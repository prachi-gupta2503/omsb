package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
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
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.GenderMaster;

/**
 * @author Mahaboob
 */


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.EDUCATION_DETAIL_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class ViewEducationDetailMVCResourceCommand implements MVCResourceCommand {

	
	public static final Log _log=LogFactoryUtil.getLog(ViewEducationDetailMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	
		_log.info("inside the ViewEducationDetailMVCResourceCommand");
//		Registration	registration	=saveData(resourceRequest, resourceResponse);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
		List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		String civilId = ParamUtil.getString(resourceRequest, "civilId");
		String passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth");
		_log.info("personId ::>>>>>>>>>>>>>>>>>>"+personId);
		_log.info("lrUserId  ::>>>>>>>>>>>>>>>>>>"+lrUserId);
//		if(Validator.isNotNull(registration.getPersonId())) {
//			personId=Long.valueOf(personId) ;
//		}
//		if(Validator.isNotNull(registration.getLrUserId())) {
//			lrUserId=registration.getLrUserId();
//		}

		if(Validator.isNotNull(personId) && personId>0) {
			try {
	        	EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByPersonId(themeDisplay,personId);
	            if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
	            	_log.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
	                List<EducationDetail>  educationalDetailItemList =educationalDetailItem.getItems();
	                for(EducationDetail detail : educationalDetailItemList) {
	                	if(Validator.isNotNull( detail.getQualificationAttained())) {
	                		try {
								detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
							} catch (Exception e) {
								_log.error("Error :::" +e.getMessage());
							}
	                	}
	                    if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
	                    	try {
								ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
										.fetchListTypeEntry(Long.parseLong(detail.getIssuingAuthorityName()));
								detail.setIssuingAuthorityName(listEntry.getName(Locale.getDefault()));
							} catch (Exception e) {
								_log.error("Error :::" +e.getMessage());
							}
	                    }
	                    if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
	                    	Country country=null;
							try {
								country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
								detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
							} catch (PortalException e) {
								_log.error("unable to get the country having id :: "+detail.getIssuingAuthorityCountryId()+ " :::: "+e.getMessage());
							}
	                    }
	                }

	                _log.info("educationalDetailItemList ::::" +educationalDetailItemList.size());
	                _log.info("educationalDetailItemList ::::" +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
	                resourceRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);
	            }
	        } catch (UnsupportedEncodingException e) {
	            _log.error(e.getMessage());
	        }		
			resourceRequest.setAttribute("personId", personId);
		}
		
		if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
			JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
			for(ListTypeEntry lt:qualificationList) {
				JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
				qualificationObject.put("key", lt.getKey());
				qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
				qualificationArray.put(qualificationObject);
			}
			resourceRequest.setAttribute("qualificationArray", qualificationArray);
		} 
		
		if(Validator.isNotNull(countries)  && countries.size()>0) {
			JSONArray countryArray=JSONFactoryUtil.createJSONArray();
				for(Country country :countries) {
					JSONObject countryObject=JSONFactoryUtil.createJSONObject();
					countryObject.put("id", country.getCountryId());
					countryObject.put("nationality", country.getName(themeDisplay.getLocale()));
					countryArray.put(countryObject);
				}
		//	}
			resourceRequest.setAttribute("countryArray", countryArray);
			resourceRequest.setAttribute("customCountries", countries);
		}
		resourceRequest.setAttribute("personId", personId);
		resourceRequest.setAttribute("lrUserId", lrUserId);
		resourceRequest.setAttribute("qualificationList", qualificationList);
		resourceRequest.setAttribute("institutionList", institutionList);
		resourceRequest.setAttribute("civilId", civilId);
		resourceRequest.setAttribute("passportNumber", passportNumber);
		resourceRequest.setAttribute("dateOfBirth", dateOfBirth);
		
		boolean isNext = ParamUtil.getBoolean(resourceRequest, "isNext");
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
		.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_EDUCATION_DETAILS_JSP);
		if(isNext) {
			dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_EDUCATION_DETAILS_JSP);  
		}

		try {
			_log.info(dispatcher);
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	private Registration saveData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		LOGGER.info("SaveRegistrationPersonalDetailsMVCActionCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Registration registration = registrationUtil.getRegistrationDTO(resourceRequest, themeDisplay);	
	//	LOGGER.info("registration :::: "+registration);
		
		if(Validator.isNull(registration.getPersonId())){
			 LOGGER.info("new Person flag if condtion :: "+registration.getDateOfBirth());
		    // registration.setDateOfBirth(ParamUtil.getString(resourceRequest, "dateOfBirth").trim());
			 Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), registration.getCivilId(), registration.getPassportNo(), ParamUtil.getString(resourceRequest, "dateOfBirth").trim());
		   LOGGER.info("new Person Id :: "+newPerson.getId());
		   registration.setPersonId(newPerson.getId());
		}
		
		if(registration.getPersonId() > 0) {
			registration=registrationUtil.saveRegistration(resourceRequest, registration);
			//actionResponse.getRenderParameters().setValue("personId", String.valueOf(registration.getPersonId()));
		}
		
		LOGGER.info("registration.getPersonId() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+registration.getPersonId() );
		
		resourceRequest.setAttribute("personId",registration.getPersonId());
		String tabValue=ParamUtil.getString(resourceRequest, "tabValue");
		LOGGER.info("tabValue :::" +tabValue);
		
		if(!Validator.isBlank(tabValue))
			SessionMessages.add(resourceRequest,"success-personal-detail");
		
		SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(resourceRequest, PortalUtil.getPortletId(resourceRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		return registration;
	}
	
	private void setPersonalData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
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
		
		LOGGER.info("personID :::::::::::::::"+personID);
		
		
		resourceRequest.setAttribute("fullName", ParamUtil.getString(resourceRequest, "fullName"));
		resourceRequest.setAttribute("fullNameAr", ParamUtil.getString(resourceRequest, "fullNameAr"));
		resourceRequest.setAttribute("genderId", ParamUtil.getString(resourceRequest, "genderId"));
		resourceRequest.setAttribute("countryId", ParamUtil.getString(resourceRequest, "countryId"));
		resourceRequest.setAttribute("mobileNo", ParamUtil.getString(resourceRequest, "mobileNo"));
		resourceRequest.setAttribute("isPkiIdentified", ParamUtil.getString(resourceRequest, "isPkiIdentified"));
		if(Validator.isNotNull(personID)) {
			Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
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
						} 
						LOGGER.info("user ::::" +user);
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
			}
		} else if((Validator.isNotNull(civilId) || Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
			Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, passportNumber, dateOfBirth);
			LOGGER.info("newPerson.getDateOfBirth()"+newPerson.getDateOfBirth()); 
			newPerson.setDateOfBirth(Validator.isNotNull(newPerson.getDateOfBirth())?commonApi.convertObjectDateToNewDDMMYYYYDate(newPerson.getDateOfBirth()):null);
			LOGGER.info("newPerson.getId() >>>>>>>>>>>>>.."+newPerson.getId());
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
		
		LOGGER.info(secondarySpeciality);
		
		LOGGER.info("End >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>...");
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewEducationDetailMVCResourceCommand.class);

}