package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.GenderMaster;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.SAVE_REGISTRATION_PERSONAL_DETAIL
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SavePersonalDetailsMVCResourceCommand implements MVCResourceCommand{

	
	public static final Log LOGGER=LogFactoryUtil.getLog(SavePersonalDetailsMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		
		LOGGER.info("SaveRegistrationPersonalDetailsMVCActionCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Registration registration = registrationUtil.getRegistrationDTO(resourceRequest, themeDisplay);	
		boolean isButtonNext = ParamUtil.getBoolean(resourceRequest,"isButtonNext");
		String isButtonNext1 = ParamUtil.getString(resourceRequest,"isButtonNext");
		String buttonNext = ParamUtil.getString(resourceRequest,"buttonNext");
		String dummyValue = ParamUtil.getString(resourceRequest,"dummyValue");
		LOGGER.info("isButtonNext :::: "+isButtonNext);
		LOGGER.info("isButtonNext1 :::: "+isButtonNext1);
		LOGGER.info("dummyValue :::: "+dummyValue);
		
		try {
			if(Validator.isNull(registration.getPersonId())){
				LOGGER.info("new Person flag if condtion :: "+registration.getDateOfBirth());
			    Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getCivilId(), registration.getPassportNo(), ParamUtil.getString(resourceRequest, "dateOfBirth").trim());
			    LOGGER.info("new Person Id :: "+newPerson.getId());
			    registration.setPersonId(newPerson.getId());
			}
		} catch (Exception e1) {
			LOGGER.error("Error::" +e1.getMessage());
		}
		
		if(registration.getPersonId() > 0) {
			registration=registrationUtil.saveRegistration(resourceRequest, registration);
			//actionResponse.getRenderParameters().setValue("personId", String.valueOf(registration.getPersonId()));
		}
		
		LOGGER.info("registration.getLrUserId() ::::::::::::>>>>>>>>"+registration.getLrUserId());
		
		String tabValue=ParamUtil.getString(resourceRequest, "tabValue");
		if(!Validator.isBlank(tabValue))
			SessionMessages.add(resourceRequest,"success-personal-detail");
		
		SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		resourceRequest.setAttribute("isSaveOnThisStage","true");
		
		if(isButtonNext){
			resourceRequest.setAttribute("personId", registration.getPersonId());
			resourceRequest.setAttribute("lrUserId", registration.getLrUserId());
            JSONObject jsonData = JSONFactoryUtil.createJSONObject();
            try {
                jsonData.put("personId", resourceRequest.getAttribute("personId"));
                jsonData.put("lrUserId", resourceRequest.getAttribute("lrUserId"));
                PrintWriter writer = null;
                writer = resourceResponse.getWriter();
                writer.println(jsonData.toJSONString());
            } catch (IOException e) {
            	LOGGER.error("Error in code :::::"+e.getMessage());
            }
        }else{
        	setPersonalData(resourceRequest, resourceResponse);
        	PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
                    .getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_PERSONAL_DETAILS_JSP);
            try {
                LOGGER.info(dispatcher);
                dispatcher.include(resourceRequest, resourceResponse);
            } catch (PortletException | IOException e) {
            	LOGGER.error("Error in code :::::"+e.getMessage());
            }
        }
		return false;
	}


	private void setPersonalData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long personID = ParamUtil.getLong(resourceRequest, "personId");
		if(Validator.isNull(personID)) {
			try {
				personID=(Long)resourceRequest.getAttribute("personId");
			} catch(Exception e) {
				LOGGER.info("unable to get the personId "+e.getMessage());
			}
		}
		if(Validator.isNotNull(personID)) {
			Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
			LOGGER.info("person ::::>>>>>>>>" +person.getPassportNumber());
				
			if(Validator.isNotNull(person) && person.getId()>0) {
				person.setDateOfBirth(commonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
				resourceRequest.setAttribute("person", person);
				if(person.getLrUserId() > 0) {
					try {
						User user = UserLocalServiceUtil.getUser(person.getLrUserId());
						if(Validator.isNotNull(user.getPortraitId())) {
							DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
							resourceRequest.setAttribute("photo", dlFileEntry.getDescription());
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
							resourceRequest.setAttribute("photoURL", DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
							
							resourceRequest.setAttribute("firstName", user.getFirstName());
							resourceRequest.setAttribute("lastName", user.getLastName());
						} 
						
						LOGGER.info("user ::::>>>>>>>>>>>>>>>>" +user);
						resourceRequest.setAttribute("lrUser", user);
					} catch (PortalException e) {
						LOGGER.error("Error while getting user info, "+e.getMessage());
					}
				}
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
						if(personalDetail.getCivilCardFrontPhotoId()!=0) {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
							resourceRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
							resourceRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
						}
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
					}

					try {
						if(personalDetail.getCivilCardBackPhotoId()!=0) {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
							resourceRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
							resourceRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
						}
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
					}

					try {
						if(personalDetail.getPassportPhotoId()!=0) {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
							resourceRequest.setAttribute("passportPhoto", entry.getDescription());
							resourceRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
						}
					}catch(PortalException e) {
						LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
					}
				}
			}
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
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
}
