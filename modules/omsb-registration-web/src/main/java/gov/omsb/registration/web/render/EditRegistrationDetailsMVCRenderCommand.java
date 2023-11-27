package gov.omsb.registration.web.render;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.CountryItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, 
			property = {
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					//"mvc.command.name=/", 
					"mvc.command.name="+ MVCCommands.EDIT_REGISTRATION_DETAILS},
			service = MVCRenderCommand.class)
public class EditRegistrationDetailsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String civilId = ParamUtil.getString(renderRequest, "civilId");
		String passportNumber = ParamUtil.getString(renderRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(renderRequest, "dateOfBirth");
		long personID = ParamUtil.getLong(renderRequest, "personId");
		//List<String> roleNames = themeDisplay.getUser().getRoles().stream().map(Role::getName).collect(Collectors.toList());
		
		if(Validator.isNotNull(personID)) {
			Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
			if(Validator.isNotNull(person) && person.getId()>0) {
				
				LOGGER.info("person.getDateOfBirth() :::" +person.getDateOfBirth());
				
				person.setDateOfBirth(Validator.isNotNull(person.getDateOfBirth())?commonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()):StringPool.BLANK);
				renderRequest.setAttribute("person", person);
				
				try {
					User user = UserLocalServiceUtil.getUser(person.getLrUserId());
					if(Validator.isNotNull(user.getPortraitId())) {
						//DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
						
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
						
						renderRequest.setAttribute("photo", entry.getDescription());
					//	LOGGER.info(themeDisplay.getPortalURL() + "/c/document_library/get_file?uuid=" + dlFileEntry.getUuid() + "&groupId=" + dlFileEntry.getGroupId());
						//String documentViewURL = themeDisplay.getURLPortal() + "/documents/" + dlFileEntry.getRepositoryId() + "/" +dlFileEntry.getFolderId() + "/" + dlFileEntry.getDescription() + "/" + dlFileEntry.getUuid() + "?version=" + dlFileEntry.getVersion();
						String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
						
						
						
						//	LOGGER.info("document view url ::: "+documentViewURL);
						renderRequest.setAttribute("photoURL",documentViewURL );
						//renderRequest.setAttribute("photoURL", themeDisplay.getPortalURL() + "/c/document_library/get_file?uuid=" + dlFileEntry.getUuid() + "&groupId=" + dlFileEntry.getGroupId());
					} 
					renderRequest.setAttribute("user_", user);
				} catch (PortalException e) {
					LOGGER.error("Error while getting user info, "+e.getMessage());
				}

				PersonalDetailItem personalDetailsItems = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
				if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0) {
					personalDetailsItems.getItems().get(0).setPassportExpiryDate(Validator.isNotNull(personalDetailsItems.getItems().get(0).getPassportExpiryDate())?commonApi.convertObjectDateToNewDDMMYYYYDate(personalDetailsItems.getItems().get(0).getPassportExpiryDate()):StringPool.BLANK);
					PersonalDetail personalDetail=	personalDetailsItems.getItems().get(0);
					LOGGER.info("personalDetail:::"+personalDetailsItems.getItems().size());
					
					
					//Role Service Starts
					if(Validator.isNotNull(personalDetail.getLrUserId()) && personalDetail.getLrUserId() > 0) {
						UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getLrUserId());
						if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
							for(UserMetadata userMetadata : userMetadataItem.getItems()) {
								//UserMetadata userMetadata=userMetadataItem.getItems().get(0);
								try {
									userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
								} catch (PortalException e) {
									LOGGER.error(e.getMessage());
								}
							
								long programTypeId=0;	
								LOGGER.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
								if(Validator.isNotNull(userMetadata.getProgramId())) {
								try {
									 ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
									 programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
									 userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
												themeDisplay.getLocale().toString()));
								} catch (Exception e) {
									LOGGER.error(e.getMessage());
								}
								userMetadata.setProgramTypeId(programTypeId);
								if(programTypeId>0) {
									try {
										LOGGER.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
										userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
												themeDisplay.getLocale().toString()));
									} catch (PortalException e) {
										LOGGER.error(e.getMessage());
									}
								}
								}
								if(Validator.isNotNull(userMetadata.getDepartmentId())){
									userMetadata.setDepartmentId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT, userMetadata.getDepartmentId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
									}
								if(Validator.isNotNull(userMetadata.getSectionId())){
									userMetadata.setSectionId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION, userMetadata.getSectionId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
								}
								LOGGER.info("User Meta data Items :::::"+userMetadataItem.getItems());
								renderRequest.setAttribute("userMetadata", userMetadata);
							}
							renderRequest.setAttribute("userMetadataItem", userMetadataItem);
						}
						 renderRequest.setAttribute("lrUserId", personalDetail.getLrUserId());
					}
				}
				try {
					long professionId=commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetailsItems.getItems().get(0).getProfession(), themeDisplay.getCompanyId()).getListTypeEntryId();
					personalDetailsItems.getItems().get(0).setProfession(String.valueOf(professionId));
					}
					catch(Exception e) {
						e.getMessage();
					}
					renderRequest.setAttribute("personalDetails", personalDetailsItems.getItems().get(0));
				}
				
				//Educational Details starts
				try {
					EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByPersonId(themeDisplay, personID);
					if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
						LOGGER.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
		                List<EducationDetail>  educationalDetailItemList =educationalDetailItem.getItems();
		                for(EducationDetail detail : educationalDetailItemList) {
		                	if(Validator.isNotNull( detail.getQualificationAttained())) {
		                		try {
									detail.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
								} catch (Exception e) {
									LOGGER.error(e.getMessage());
								}
		                	}
		                    if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
		                    	try {
									detail.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION, detail.getIssuingAuthorityName(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
								} catch (Exception e) {
									LOGGER.error(e.getMessage());
								}
		                    }
		                    if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
			                    //	Country country = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), detail.getIssuingAuthorityCountryId());
		                    	   com.liferay.portal.kernel.model.Country country=null;
									try {
										country = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
										detail.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
									} catch (PortalException e) {
										LOGGER.error("unable to get the country having id :: "+detail.getIssuingAuthorityCountryId()+ " :::: "+e.getMessage());
									}
			                    }
		                }

		                LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.size());
		                LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
		               
		                renderRequest.setAttribute("educationalDetailItemList", educationalDetailItemList);
		            }
				} catch (UnsupportedEncodingException e) {
					LOGGER.error(e.getMessage());
				}
				
			RoleMappingItems roleMappingItems=registrationUtil.fetchRoleMapping(themeDisplay, RoleNameConstants.ROLE_TYPE_REGISTRATION);
			List<ListTypeEntry> departmentList = registrationUtil.getPickListEntries(LRPicklistConstants.DEPARTMENT, themeDisplay.getCompanyId());
			List<ListTypeEntry> sectionList = registrationUtil.getPickListEntries(LRPicklistConstants.SECTION, themeDisplay.getCompanyId());
			List<ListTypeEntry> functionList = registrationUtil.getPickListEntries(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId());
			List<ListTypeEntry> committeList = registrationUtil.getPickListEntries(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId());
			List<ListTypeEntry> serviceList = registrationUtil.getPickListEntries(LRPicklistConstants.SERVICE, themeDisplay.getCompanyId());
			//List<ListTypeEntry> programList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM, themeDisplay.getCompanyId());
			List<ListTypeEntry> programPositionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM_POSITION, themeDisplay.getCompanyId());
			List<ListTypeEntry> purposeList = registrationUtil.getPickListEntries(LRPicklistConstants.PURPOSE, themeDisplay.getCompanyId());
			
			List<ProgramTypeMaster> programTypeMasterList=registrationUtil.getProgramType(themeDisplay);
			
			LOGGER.info("programTypeMasterList :::::"+programTypeMasterList);
			List<ProgramMaster> programList=registrationUtil.getProgram(themeDisplay);
			LOGGER.info("programList :::::"+programList);
			
			if(Validator.isNotNull(roleMappingItems)) {
				renderRequest.setAttribute("omsbRoleList", registrationUtil.getOMSBRoles(roleMappingItems));
			}
			
			renderRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
	                compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
	                compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			renderRequest.setAttribute("serviceList", serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			//Role Service Ends
			
		} else if((Validator.isNotNull(civilId) || Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
			Person newPerson = registrationUtil.setPersonData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, passportNumber, dateOfBirth);
			newPerson.setDateOfBirth(commonApi.convertObjectDateToNewDDMMYYYYDate(newPerson.getDateOfBirth()));
			renderRequest.setAttribute("person", newPerson);
		}
		
		CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
			renderRequest.setAttribute("customCountries", customCountryItems.getItems().stream().sorted((o1, o2)->o1.getNationality().
					compareTo(o2.getNationality())).collect(Collectors.toList()));
		}
		List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(Validator.isNotNull(countries) && !countries.isEmpty()) {
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
		
		//Educational Details Related values  starts 
		List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
		renderRequest.setAttribute("qualificationList", qualificationList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
		renderRequest.setAttribute("institutionList", institutionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				
		if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
			JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
			for(ListTypeEntry lt:qualificationList) {
				JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
				qualificationObject.put("key", lt.getKey());
				qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
				qualificationArray.put(qualificationObject);
			}
			renderRequest.setAttribute("qualificationArray", qualificationArray);
		}
			
//		if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
//			List<Country> countryList=customCountryItems.getItems();
//			JSONArray countryArray=JSONFactoryUtil.createJSONArray();
//			if(Validator.isNotNull(countryList) && countryList.size()>0) {
//				for(Country country :countryList) {
//					JSONObject countryObject=JSONFactoryUtil.createJSONObject();
//					countryObject.put("id", country.getId());
//					countryObject.put("nationality", country.getNationality());
//					countryArray.put(countryObject);
//				}
//			}
//			renderRequest.setAttribute("countryArray", countryArray);
//		}
		if(Validator.isNotNull(countries) &&  !countries.isEmpty()) {
		//	List<Country> countryList=customCountryItems.getItems();
			JSONArray countryArray=JSONFactoryUtil.createJSONArray();
				for(com.liferay.portal.kernel.model.Country country :countries) {
					JSONObject countryObject=JSONFactoryUtil.createJSONObject();
					countryObject.put("id", country.getCountryId());
					countryObject.put("nationality", country.getName(themeDisplay.getLocale()));
					countryArray.put(countryObject);
			}
			renderRequest.setAttribute("countryArray", countryArray);
		}
		//long personID = 55325;
		List<ListTypeEntry> workSectorTypes = registrationUtil.getPickListEntries(LRPicklistConstants.WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
	//	List<ListTypeEntry> wilayats = registrationUtil.getPickListEntries(LRPicklistConstants.WILAYAT, themeDisplay.getCompanyId());
		List<ListTypeEntry> governorate=registrationUtil.getPickListEntries(LRPicklistConstants.GOVERNORATE, themeDisplay.getCompanyId());
		List<ListTypeEntry> designations = registrationUtil.getPickListEntries(LRPicklistConstants.DESIGNATION, themeDisplay.getCompanyId());
		//JSONArray workSectorJsonArray=JSONFactoryUtil.createJSONArray();
		//JSONArray workSectorJsonArray = registrationUtil.getJsonArray(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),0);
		JSONArray workSectorJsonArray = registrationUtil.getJsonArrayTest(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		LOGGER.info("workSector Json Array :"+workSectorJsonArray);
		
		
		if(Validator.isNotNull(personID)) {
		/*	EmploymentDetailItem workDetailItems=registrationUtil.getWorkDetailsByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
			if(Validator.isNotNull(workDetailItems.getItems())) {
			for(EmploymentDetail workDetail : workDetailItems.getItems()) { 
				if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
					LOGGER.info("inside if");
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
						String documentURL =DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK);
						workDetail.setDocumentUrl(documentURL);
					} catch (PortalException e) {
						LOGGER.error("Error in  code :::" + e.getMessage());
					}
					try {
		                workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
						LOGGER.info("workDetail :: "+workDetail);
				  }
				  catch(Exception e) {
				}
			}
				}
			renderRequest.setAttribute("workDetailItems", workDetailItems);
			}
			
			*/
			
			//Changes
			
			//Get Primary Work Detail 
			EmploymentDetailItem workDetailItems = null;
			
			try {
				workDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(),personID,"1");
			} catch (Exception e) {
				LOGGER.error("workDetailItems exception:" + e.getMessage());
			}
			
			EmploymentDetailItem secondaryWorkDetailItems = null;
			
			try {
				secondaryWorkDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), personID,"2");
			} catch (Exception e) {
				LOGGER.error("secondaryWorkDetailItems exception:" + e.getMessage());
			}
			
			if(Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {
				EmploymentDetail workDetail=workDetailItems.getItems().get(0);
				FileEntry entry=null;
					try {
						LOGGER.info("workDetail getWorkSectorType:::"+workDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry =null;
						
						//Get Work sector Type 
						if(Validator.isNotNull(workDetail.getWorkSectorType())) {
							long workSectorTypeID=Long.parseLong(workDetail.getWorkSectorType());
							listTypeEntry	 =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
							LOGGER.info("listTypeEntry ::: " +listTypeEntry);
							LOGGER.info("listTypeEntry key ::: " +listTypeEntry.getKey());
							LOGGER.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
						}
						
						//Get Work sector  
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
								
								WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorType());
								LOGGER.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
								workDetail.setWorkSectorItems(workSectorItems);
								LOGGER.info("Worke sector items ::::"+workDetail.getWorkSectorItems().getItems().get(0).getWorkSector());
							}
						
						
						//Get Work Sub Sector 
						if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
							WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
							workDetail.setWorkSubSectorItems(workSectorItems);
						}
						
						
						//Get work second sub sectors 
						if(Validator.isNotNull(workDetail.getWorkSectorId3()) && workDetail.getWorkSectorId3()>0) {
							WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId2());
							workDetail.setWorkSecondSubSectorItems(workSectorItems);
						}
						
							
						if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
							workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
							try {
								 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
								workDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
							} catch (PortalException e) {
								LOGGER.error("Error in  code :::" + e.getMessage());
							}
						}
						if(Validator.isNotNull( workDetail.getWorkSector())) {
							WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, workDetail.getWorkSector());
							if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
								workDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
	                    }
						LOGGER.debug("workDetail :: " + workDetail);
				} catch (Exception e) {
					LOGGER.error("Error :::::"+e.getMessage());
				}
					LOGGER.info("workDetailItems Size :::::"+ workDetailItems.getItems().size());
				renderRequest.setAttribute("primaryworkDetail", workDetail);
			}
			
			//Secondary
			if(Validator.isNotNull(secondaryWorkDetailItems.getItems()) && secondaryWorkDetailItems.getItems().size()>0) {
				EmploymentDetail secondaryWorkDetail=secondaryWorkDetailItems.getItems().get(0);
				FileEntry entry=null;
					try {
				//		LOGGER.info("workDetail getWorkSectorType:::"+secondaryWorkDetail.getWorkSectorType());
				//		LOGGER.info("secondaryWorkDetail getStaffIdCard:::"+secondaryWorkDetail.getStaffIdCard());
						ListTypeEntry listTypeEntry =null;
						
						//Get Work sector Type 
						if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorType())) {
							long workSectorTypeID = Long.parseLong(secondaryWorkDetail.getWorkSectorType());
							listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					//		LOGGER.info("listTypeEntry ::: " +listTypeEntry);
							LOGGER.info("listTypeEntry key ::: " +listTypeEntry.getKey());
							LOGGER.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
						}
						//Get Work sector  
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
								WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorType());	
								secondaryWorkDetail.setWorkSectorItems(workSectorItems);
						}
						
						//Get Work Sub Sector 
						if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
							WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
							
							//LOGGER.info("workSectorItems ::::"+workSectorItems);
							secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
						}
							
						//Get work second sub sectors 
						if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId3()) && secondaryWorkDetail.getWorkSectorId3()>0) {
							WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
							secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
						}
						
						LOGGER.info("secondaryWorkDetail.getStaffIdCard() ::::" +secondaryWorkDetail.getStaffIdCard());
						
						
						if(Validator.isNotNull(secondaryWorkDetail.getStaffIdCard()) && Long.valueOf(secondaryWorkDetail.getStaffIdCard()) > 0) {
							secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getFileName());
							try {
								 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(secondaryWorkDetail.getStaffIdCard()));
								 
								 LOGGER.info("entry :::::"+entry);
								 
								 
								 secondaryWorkDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
							} catch (PortalException e) {
								LOGGER.error("Error in  code :::" + e.getMessage());
							}
						}
						if(Validator.isNotNull( secondaryWorkDetail.getWorkSector())) {
							WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, secondaryWorkDetail.getWorkSector());
							if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
								secondaryWorkDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
	                    }
						LOGGER.debug("workDetail :: " + secondaryWorkDetail);
				} catch (Exception e) {
					LOGGER.error("Error :::::"+e.getMessage());
				}
					LOGGER.info("secondaryWorkDetailItems Size :::::"+ secondaryWorkDetailItems.getItems().size());
				renderRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
			}
			
			
			//Getting past work details
			LOGGER.info("inside view get work details ");
			EmploymentDetailItem employmentDetailItem=null;
			
			try {
				employmentDetailItem=registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(),personID,"0");
			} catch (Exception e) {
				LOGGER.error("Exception in code :::"+e.getMessage());
			}
		if(Validator.isNotNull(employmentDetailItem) && Validator.isNotNull(employmentDetailItem.getItems()) && employmentDetailItem.getItems().size()>0) {
			
			List<EmploymentDetail> 	employmentDetailList=employmentDetailItem.getItems();	
			
			
			if(Validator.isNotNull(employmentDetailList) && employmentDetailList.size()>0) {
				
				for(EmploymentDetail employmentDetail :employmentDetailList) {
					
					LOGGER.info("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
					ListTypeEntry listTypeEntry = null;
					long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());
					try {
						listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					} catch (PortalException e) {
						LOGGER.error("Exception in code :::" + e.getMessage());
					}
					
					if(Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {
						employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());
					}else {
						employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);
					}
					
					LOGGER.info("employmentDetail getWorkSectorId::: " + employmentDetail.getWorkSectorId());
						
					WorkSector workSector=null;
					try {
						workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId());
					} catch (Exception e) {
						LOGGER.error("Exception in code :::" + e.getMessage());
					}
					
					if(Validator.isNotNull(employmentDetail.getWorkSectorOther())) {
						employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());
					}else {
						employmentDetail.setWorkSector(Validator.isNotNull(workSector)?workSector.getWorkSector():StringPool.BLANK );
					}
					WorkSector workSector2=null;
					if(Validator.isNotNull(employmentDetail.getWorkSectorId2())) {
						
						try {
							workSector2=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId2());
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}
						
						
					}
					
					if(Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {
						employmentDetail.setWorkSector2(employmentDetail.getWorkSectorOther2());
					}else {
						employmentDetail.setWorkSector2(Validator.isNotNull(workSector2)?workSector2.getWorkSector():StringPool.BLANK );
					}
					if(Validator.isNotNull(employmentDetail.getDesignationOther())) {
						employmentDetail.setDesignationId(employmentDetail.getDesignationOther());
					}else {
							try {
								employmentDetail.setDesignationId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
							} catch (Exception e) {
							LOGGER.error("Exception ::"+e.getMessage());
							}
					}
					try {
						employmentDetail.setWorkSectorLocation(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.GOVERNORATE, employmentDetail.getWorkSectorLocation(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					} catch (Exception e) {
						LOGGER.error("Exception ::"+e.getMessage());
					}
					
					//employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
					
				}
				
			}
			renderRequest.setAttribute("pastWorkDetails", employmentDetailList);
		}
		}
		renderRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		renderRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		
		renderRequest.setAttribute("personId", personID);
		renderRequest.setAttribute("workSectors", workSectorJsonArray);
		LOGGER.info(" workSectorTypes :: "+workSectorTypes);
		
		try {
			boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
			boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
			boolean isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
			
			if(isProfileApprover) {
				return OmsbRegistrationWebPortletKeys.EDIT_REGISTRATION_PROFILE_DETAILS_JSP;
			}else if(isRoleApprover || isServiceApprover) {
				renderRequest.setAttribute("isRoleApprover", isRoleApprover);
				renderRequest.setAttribute("isServiceApprover", isServiceApprover);
				return OmsbRegistrationWebPortletKeys.EDIT_REGISTRATION_ROLE_DETAILS_JSP;
				
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return OmsbRegistrationWebPortletKeys.EDIT_REGISTRATION_DETAILS_JSP;
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EditRegistrationDetailsMVCRenderCommand.class);
}