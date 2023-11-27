package gov.omsb.registration.web.resource;

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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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

/**
 * @author Mahaboob
 */


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.PERSONAL_DETAIL_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class ViewPersonalDetailMVCResourceCommand implements MVCResourceCommand {

	
	public static final Log _log=LogFactoryUtil.getLog(ViewPersonalDetailMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String civilId = ParamUtil.getString(resourceRequest, "civilId");
		String passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth");
		String mobileNo =  ParamUtil.getString(resourceRequest, "mobileNo");
		LOGGER.info("DOB :::::::::::::::"+dateOfBirth+" MObile no : "+mobileNo);
		long personID = ParamUtil.getLong(resourceRequest, "personId");
		if(Validator.isNull(personID)) {
			try {
				personID=(Long)resourceRequest.getAttribute("personId");
			} catch(Exception e) {
				LOGGER.info("unable to get the personId "+e.getMessage());;
			}
		}
		resourceRequest.setAttribute("fullName", ParamUtil.getString(resourceRequest, "fullName"));
		resourceRequest.setAttribute("fullNameAr", ParamUtil.getString(resourceRequest, "fullNameAr"));
		resourceRequest.setAttribute("genderId", ParamUtil.getString(resourceRequest, "genderId"));
		resourceRequest.setAttribute("countryId", ParamUtil.getString(resourceRequest, "countryId"));
		resourceRequest.setAttribute("mobileNo", ParamUtil.getString(resourceRequest, "mobileNo"));
		resourceRequest.setAttribute("isPkiIdentified", ParamUtil.getString(resourceRequest, "isPkiIdentified"));
		resourceRequest.setAttribute("omaniCountryId", ParamUtil.getString(resourceRequest, "omaniCountryId"));
		if(Validator.isNotNull(personID)) {
			Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
			if(Validator.isNotNull(person) && person.getId()>0) {
				person.setDateOfBirth(commonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
				resourceRequest.setAttribute("person", person);
				
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
					resourceRequest.setAttribute("personalDetails", personalDetail);

					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
						resourceRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
						resourceRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
					}
					
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
						resourceRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
						resourceRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
					}
					
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
						resourceRequest.setAttribute("passportPhoto", entry.getDescription());
						resourceRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
					}
				}
				
				if(person.getLrUserId() > 0) {
					try {
						User user = UserLocalServiceUtil.getUser(person.getLrUserId());
						if(Validator.isNotNull(user.getPortraitId())) {
							DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
							resourceRequest.setAttribute("photo", dlFileEntry.getDescription());
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
							resourceRequest.setAttribute("photoURL", DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
						} 
						resourceRequest.setAttribute("lrUser", user);
						resourceRequest.setAttribute("firstName", user.getFirstName());
						resourceRequest.setAttribute("lastName", user.getLastName());
					} catch (PortalException e) {
						LOGGER.error("Error while getting user info, "+e.getMessage());
					}
				}else {
					
					resourceRequest.setAttribute("firstName", personalDetailsItems.getItems().get(0).getGivenNameAsPassport());
					resourceRequest.setAttribute("lastName", personalDetailsItems.getItems().get(0).getApplicantSurname());
				}

				
			}
		} else if((Validator.isNotNull(civilId) || Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
			Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, passportNumber, dateOfBirth);
			LOGGER.info("newPerson.getDateOfBirth()"+newPerson.getDateOfBirth()); 
			newPerson.setDateOfBirth(Validator.isNotNull(newPerson.getDateOfBirth())?commonApi.convertObjectDateToNewDDMMYYYYDate(newPerson.getDateOfBirth()):null);
			resourceRequest.setAttribute("person", newPerson);
		}
		
		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(Validator.isNotNull(countries) && countries.size()>0) {
			resourceRequest.setAttribute("countries", countries);
		}
		
		List<GenderMaster> genderMasterList = registrationUtil.getGenderMasterList(themeDisplay);
		resourceRequest.setAttribute("genderList", genderMasterList.stream().sorted((o1, o2)->o1.getGenderName(themeDisplay.getLocale()).
                compareTo(o2.getGenderName(themeDisplay.getLocale()))).collect(Collectors.toList()));

		List<ListTypeEntry> professionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROFESSION, themeDisplay.getCompanyId());
		resourceRequest.setAttribute("professionList", professionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		List<ListTypeEntry> specialityList = registrationUtil.getPickListEntries(LRPicklistConstants.SPECIALIY, themeDisplay.getCompanyId());
		resourceRequest.setAttribute("specialityList", specialityList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		List<ListTypeEntry> secondarySpeciality = registrationUtil.getPickListEntries("PL_OMSB_SUB_SPECIALITY_MASTER_ERC", themeDisplay.getCompanyId());
		resourceRequest.setAttribute("secondarySpeciality", secondarySpeciality.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		
//		return OmsbRegistrationWebPortletKeys.REGISTRATION_PERSONAL_DETAILS_JSP;
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_PERSONAL_DETAILS_JSP);
		LOGGER.info(dispatcher);
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewPersonalDetailMVCResourceCommand.class);

}