package gov.omsb.registration.web.render;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.GenderMaster;

@Component(immediate = true, 
			property = {
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS},
			service = MVCRenderCommand.class)
public class ViewPersonalDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String civilId = ParamUtil.getString(renderRequest, "civilId");
		String passportNumber = ParamUtil.getString(renderRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(renderRequest, "dateOfBirth");
		String mobileNo =  ParamUtil.getString(renderRequest, "mobileNo");
		LOGGER.info("DOB :::::::::::::::"+dateOfBirth+" MObile no : "+mobileNo);
		long personID = ParamUtil.getLong(renderRequest, "personId");
		if(Validator.isNull(personID)) {
			try {
				personID=(Long)renderRequest.getAttribute("personId");
			} catch(Exception e) {
				LOGGER.info("unable to get the personId "+e.getMessage());;
			}
		}
		renderRequest.setAttribute("fullName", ParamUtil.getString(renderRequest, "fullName"));
		renderRequest.setAttribute("fullNameAr", ParamUtil.getString(renderRequest, "fullNameAr"));
		renderRequest.setAttribute("genderId", ParamUtil.getString(renderRequest, "genderId"));
		renderRequest.setAttribute("countryId", ParamUtil.getString(renderRequest, "countryId"));
		renderRequest.setAttribute("mobileNo", ParamUtil.getString(renderRequest, "mobileNo"));
		renderRequest.setAttribute("isPkiIdentified", ParamUtil.getString(renderRequest, "isPkiIdentified"));
		renderRequest.setAttribute("omaniCountryId", ParamUtil.getString(renderRequest, "omaniCountryId"));
		if(Validator.isNotNull(personID)) {
			Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
			if(Validator.isNotNull(person) && person.getId()>0) {
				person.setDateOfBirth(commonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
				renderRequest.setAttribute("person", person);
				
				PersonalDetailItem personalDetailsItems = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
				if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0) {
					PersonalDetail personalDetail = personalDetailsItems.getItems().get(0);
					personalDetail.setPassportExpiryDate(Validator.isNotNull(personalDetail.getPassportExpiryDate())? commonApi.convertObjectDateToNewDDMMYYYYDate(personalDetail.getPassportExpiryDate()):null);
					try {
						long professionId=commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetail.getProfession(), themeDisplay.getCompanyId()).getListTypeEntryId();
						personalDetail.setProfession(String.valueOf(professionId));
					} catch(Exception e) {
						LOGGER.error("Error while getting profession : "+e.getMessage());
					}
					renderRequest.setAttribute("personalDetails", personalDetail);

					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
						renderRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
						renderRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
					}
					
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
						renderRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
						renderRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
					}
					
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
						renderRequest.setAttribute("passportPhoto", entry.getDescription());
						renderRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
					}
				}
				
				if(person.getLrUserId() > 0) {
					try {
						User user = UserLocalServiceUtil.getUser(person.getLrUserId());
						if(Validator.isNotNull(user.getPortraitId())) {
							DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
							renderRequest.setAttribute("photo", dlFileEntry.getDescription());
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
							renderRequest.setAttribute("photoURL", DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
						} 
						renderRequest.setAttribute("lrUser", user);
						renderRequest.setAttribute("firstName", user.getFirstName());
						renderRequest.setAttribute("lastName", user.getLastName());
					} catch (PortalException e) {
						LOGGER.error("Error while getting user info, "+e.getMessage());
					}
				}else {
					if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0){
						renderRequest.setAttribute("firstName", personalDetailsItems.getItems().get(0).getGivenNameAsPassport());
						renderRequest.setAttribute("lastName", personalDetailsItems.getItems().get(0).getApplicantSurname());
					}
				}
			}
		} else if((Validator.isNotNull(civilId) || Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
			Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, passportNumber, dateOfBirth);
			LOGGER.info("newPerson.getDateOfBirth()"+newPerson.getDateOfBirth()); 
			newPerson.setDateOfBirth(Validator.isNotNull(newPerson.getDateOfBirth())?commonApi.convertObjectDateToNewDDMMYYYYDate(newPerson.getDateOfBirth()):null);
			renderRequest.setAttribute("person", newPerson);
		}
		
		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(Validator.isNotNull(countries) && countries.size()>0) {
			renderRequest.setAttribute("countries", countries);
		}
		
		List<GenderMaster> genderMasterList = registrationUtil.getGenderMasterList(themeDisplay);
		renderRequest.setAttribute("genderList", genderMasterList.stream().sorted((o1, o2)->o1.getGenderName(themeDisplay.getLocale()).
                compareTo(o2.getGenderName(themeDisplay.getLocale()))).collect(Collectors.toList()));

		List<ListTypeEntry> professionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROFESSION, themeDisplay.getCompanyId());
		renderRequest.setAttribute("professionList", professionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		List<ListTypeEntry> specialityList = registrationUtil.getPickListEntries(LRPicklistConstants.SPECIALIY, themeDisplay.getCompanyId());
		renderRequest.setAttribute("specialityList", specialityList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		List<ListTypeEntry> secondarySpeciality = registrationUtil.getPickListEntries("PL_OMSB_SUB_SPECIALITY_MASTER_ERC", themeDisplay.getCompanyId());
		renderRequest.setAttribute("secondarySpeciality", secondarySpeciality.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
//		return OmsbRegistrationWebPortletKeys.REGISTRATION_PERSONAL_DETAILS_JSP;
		return OmsbRegistrationWebPortletKeys.REGISTRATION_JSP;
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ViewPersonalDetailsMVCRenderCommand.class);
}