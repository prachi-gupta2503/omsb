package gov.omsb.registration.web.render;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, 
property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_DETAILS},
service = MVCRenderCommand.class)
public class ViewRegistrationDetailsMVCRenderCommand implements MVCRenderCommand {

@Override
public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	long personID = ParamUtil.getLong(renderRequest, "personId");
	if(Validator.isNotNull(personID)) {
		Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personID);
		
		LOGGER.info("Person :::" +person);
		if(Validator.isNotNull(person) && person.getId()>0) {
			person.setDateOfBirth(Validator.isNotNull(person.getDateOfBirth())?commonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()):StringPool.BLANK);
			renderRequest.setAttribute("person", person);
			
			try {
				boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
				boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
				boolean isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
				renderRequest.setAttribute("isProfileApprover", isProfileApprover);
				renderRequest.setAttribute("isRoleApprover", isRoleApprover);
				renderRequest.setAttribute("isServiceApprover", isServiceApprover);
				String requestFor = null, requestForERC = null;
				if(isProfileApprover) {
					requestFor = LRObjectURL.REG_USER_PROFILE_STATUS;
					requestForERC = LRObjectURL.USER_PROFILE_STATUS_OBJ_ERC;
				} else if(isRoleApprover){
					requestFor = LRObjectURL.REG_USER_ROLE_STATUS;
					requestForERC = LRObjectURL.USER_ROLE_STATUS_OBJ_ERC;
				} else if(isServiceApprover) {
					requestFor = LRObjectURL.REG_USER_SERVICE_STATUS;
					requestForERC = LRObjectURL.USER_SERVICE_STATUS_OBJ_ERC;
				}
				UserRegistrationStatusItems userProfileStatusItems = registrationUtil.getRegistrationWorkflowStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), requestFor, person.getLrUserId(), person.getId(), 0, UserRegistrationStatusItems.class);
				if(Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
					Registration registration = new Registration();
					registration.setWorkflowStatus(userProfileStatusItems.getItems().get(0).getUserStatus());
					registration.setWorkflowId(userProfileStatusItems.getItems().get(0).getId());
					registrationUtil.getWorkflowData(themeDisplay, registration, requestForERC);
					renderRequest.setAttribute("registration", registration);
				}
			} catch (PortalException e) {
				LOGGER.error("Error while getting workflow status :::::, "+e.getMessage());
			}
			
			try {
				User user = UserLocalServiceUtil.getUser(person.getLrUserId());
				if(Validator.isNotNull(user.getPortraitId())) {
					FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
					renderRequest.setAttribute("photo", entry.getDescription());
					renderRequest.setAttribute("photoURL", DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
				}
				renderRequest.setAttribute("user_", user);
			} catch (PortalException e) {
				LOGGER.error("Error while getting user info, "+e.getMessage());
			}
			
			//Role Service 
			if(Validator.isNotNull(person.getLrUserId()) && person.getLrUserId() > 0) {
				
				UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getLrUserId());
				if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
					List<UserMetadata>  userMetadataList1 =new ArrayList<>();	
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
											themeDisplay.getLocale().toString())      );
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
							//Get Role verfied status
							if(Validator.isNotNull(userMetadata) && userMetadata.getId()>0){
								try {
									LOGGER.info("userMetadata.getId() ::::" +userMetadata.getId());
									UserRegistrationStatusItems userRoleStatusItems = registrationUtil.getRoleStatusByUserMetadataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadata.getId());
									LOGGER.info("userRoleStatusItems ::::" +userRoleStatusItems.getItems().size());
									if (Validator.isNotNull(userRoleStatusItems)&& Validator.isNotNull(userRoleStatusItems.getItems())&& userRoleStatusItems.getItems().size() > 0) {
										UserRegistrationStatus userRegistrationStatus = userRoleStatusItems.getItems().get(0);
										LOGGER.info("userRegistrationStatus.userRegistrationStatus()e:::"+ userRegistrationStatus.getUserStatus());
										LOGGER.info("userRegistrationStatus.getComment()e:::"+ userRegistrationStatus.getComment());
										userMetadata.setRoleVerifiedStatus(Validator.isNotNull(userRegistrationStatus.getUserStatus())? userRegistrationStatus.getUserStatus():"NA");
										userMetadata.setRoleVerifiedComments(Validator.isNotNull(userRegistrationStatus.getComment())? HtmlUtil.escape(userRegistrationStatus.getComment()):"NA");
										userMetadata.setUserRoleStatusId(Validator.isNotNull(userRegistrationStatus.getId())?userRegistrationStatus.getId():0);
									}
								} catch (Exception e) {
									LOGGER.error("Exception ::"+e.getMessage());
								}
							}
							LOGGER.info("User Meta data Items :::::"+userMetadataItem.getItems());
							
							
							if (Validator.isNotNull(userMetadata) && userMetadata.getId()>0 && userMetadata.getRoleId()>0) {
								userMetadataList1.add(userMetadata);
							}
							renderRequest.setAttribute("userMetadata", userMetadata);
						}
						userMetadataItem.setItems(userMetadataList1);
						renderRequest.setAttribute("userMetadataItem", userMetadataItem);
				}
			
			}
			
			EmploymentDetailItem workDetailItems=registrationUtil.getWorkDetailsByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
			if(Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0){
				for(EmploymentDetail employmentDetail :workDetailItems.getItems()) {

					LOGGER.info("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
					ListTypeEntry listTypeEntry = null;
					long workSectorTypeID =0;
					try {
						workSectorTypeID=Long.parseLong(employmentDetail.getWorkSectorType());
					} catch (NumberFormatException e1) {
						LOGGER.error("Exception in code :::" + e1.getMessage());
					}
					try {
						listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
					} catch (PortalException e) {
						LOGGER.error("Exception in code :::" + e.getMessage());
					}


					//Get Work Sector Type
					if(Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {
						employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());
					}else {
						employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);
					}

					WorkSector workSector=null;

					//Getting Work Sector
					if(Validator.isNotNull(employmentDetail.getWorkSectorOther3())) {
						employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther3());
					}else if(Validator.isNotNull(employmentDetail.getWorkSectorId3()) && employmentDetail.getWorkSectorId3()>0) {
						try {
							workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId3());
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}
						if(Validator.isNotNull(workSector)) {
							employmentDetail.setWorkSector(workSector.getWorkSector());
						}

					}else if(Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {
						employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther2());
					}else if(Validator.isNotNull(employmentDetail.getWorkSectorId2()) && employmentDetail.getWorkSectorId2()>0) {
						try {
							workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId2());
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}
						if(Validator.isNotNull(workSector)) {
							employmentDetail.setWorkSector(workSector.getWorkSector());
						}
					}else if(Validator.isNotNull(employmentDetail.getWorkSectorOther())) {
						employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());
					}else if(Validator.isNotNull(employmentDetail.getWorkSectorId()) && employmentDetail.getWorkSectorId()>0) {
						try {
							workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId());
						} catch (Exception e) {
							LOGGER.error("Exception in code :::" + e.getMessage());
						}
						if(Validator.isNotNull(workSector)) {
							employmentDetail.setWorkSector(workSector.getWorkSector());
						}
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
			renderRequest.setAttribute("workDetailItems", workDetailItems);
			}
		}
		
		PersonalDetailItem personalDetailsItems = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
		if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0) {
			personalDetailsItems.getItems().get(0).setPassportExpiryDate(Validator.isNotNull(personalDetailsItems.getItems().get(0).getPassportExpiryDate())?commonApi.convertObjectDateToNewDDMMYYYYDate(personalDetailsItems.getItems().get(0).getPassportExpiryDate()):StringPool.BLANK);
			
		//	Country passportIssuingCountry = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), personalDetailsItems.getItems().get(0).getPassportIssuingCountryId());
			 com.liferay.portal.kernel.model.Country passportIssuingCountry=null;
				try {
					passportIssuingCountry = CountryLocalServiceUtil.getCountry(personalDetailsItems.getItems().get(0).getPassportIssuingCountryId());
					personalDetailsItems.getItems().get(0).setPassportIssuingCountryName(passportIssuingCountry.getName(themeDisplay.getLocale()));
				} catch (PortalException e1) {
					LOGGER.info("unable to get the country by country id :"+personalDetailsItems.getItems().get(0).getNationalityCountryId());
				}
			
			//Country nationalityCountry = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), personalDetailsItems.getItems().get(0).getNationalityCountryId());
		 com.liferay.portal.kernel.model.Country nationalityCountry=null;
		try {
			nationalityCountry = CountryLocalServiceUtil.getCountry(personalDetailsItems.getItems().get(0).getNationalityCountryId());
			personalDetailsItems.getItems().get(0).setNationalityCountryName(nationalityCountry.getName(themeDisplay.getLocale()));
		} catch (PortalException e1) {
			LOGGER.info("unable to get the country by country id :"+personalDetailsItems.getItems().get(0).getNationalityCountryId());
		}

			renderRequest.setAttribute("gender", registrationUtil.getGenderMaster(themeDisplay, personalDetailsItems.getItems().get(0).getGenderId()));
			
			renderRequest.setAttribute("profession", commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetailsItems.getItems().get(0).getProfession(), themeDisplay.getCompanyId()));
			ListTypeEntry listTypeEntry	=null;
			try {
				listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(Long.valueOf(personalDetailsItems.getItems().get(0).getPrimarySpeciality()));
				renderRequest.setAttribute("primarySpeciality",listTypeEntry.getName(themeDisplay.getLocale()) );
			} catch (Exception e) {
				LOGGER.error("Exception :::" +e.getMessage());
			}
			try {
				 listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(Long.valueOf(personalDetailsItems.getItems().get(0).getSecondarySpeciality()));
				renderRequest.setAttribute("secondarySpeciality",listTypeEntry.getName(themeDisplay.getLocale()) );
			} catch (Exception e) {
				LOGGER.error("Exception :::" +e.getMessage());
			}
		//	renderRequest.setAttribute("primarySpeciality", commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SPECIALIY, personalDetailsItems.getItems().get(0).getPrimarySpeciality(), themeDisplay.getCompanyId()));
			
		//	renderRequest.setAttribute("secondarySpeciality", commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SPECIALIY, personalDetailsItems.getItems().get(0).getSecondarySpeciality(), themeDisplay.getCompanyId()));

			renderRequest.setAttribute("personalDetails", personalDetailsItems.getItems().get(0));
			
			List<EducationDetail> educationDetailList =  registrationUtil.getEducationDetailList(themeDisplay, person.getId());
			if(Validator.isNotNull(educationDetailList)) {
				renderRequest.setAttribute("educationalDetailItemList", educationDetailList);
			}
			EducationDetailItem educationDetailItem=null;
			try {
				educationDetailItem = registrationUtil.fetchEducationDetailByPersonId(
						themeDisplay, person.getId());
				if (Validator.isNotNull(educationDetailItem)) {
					List<EducationDetail> educationDetails = educationDetailItem.getItems();
					if (Validator.isNotNull(educationDetails) && educationDetails.size() > 0) {
							for(EducationDetail education :educationDetails) {
									try {
										education.setQualificationAttained(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, education.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
									} catch (Exception e) {
										LOGGER.info(e.getMessage());
									}

									try {
										education.setIssuingAuthorityName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.INSTITUTION, education.getIssuingAuthorityName(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
									} catch (Exception e) {
										LOGGER.error(e.getMessage());
									}
								//	Country country = registrationUtil.getCustomCountryById(themeDisplay.getPortalURL(), education.getIssuingAuthorityCountryId());

//									if(Validator.isNotNull(country)) {
//										education.setIssuingAuthorityCountry(country.getNationality());
//									}
									 com.liferay.portal.kernel.model.Country country=null;
										try {
											country = CountryLocalServiceUtil.getCountry(education.getIssuingAuthorityCountryId());
											education.setIssuingAuthorityCountry(country.getName(themeDisplay.getLocale()));
										} catch (PortalException e1) {
											LOGGER.info("unable to get the country by country id :"+personalDetailsItems.getItems().get(0).getNationalityCountryId());
										}
							}
						renderRequest.setAttribute("educationalDetailItemList", educationDetails);
					}
				}
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
//			EmploymentDetailItem employmentDetailItem = registrationUtil.getEmploymentDetailItems(
//					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
//			if (Validator.isNotNull(employmentDetailItem)) {
//				List<EmploymentDetail> employmentDetails = employmentDetailItem.getItems();
//				if (Validator.isNotNull(employmentDetails) && employmentDetails.size() > 0) {
//					renderRequest.setAttribute("employmentDetails", employmentDetails);
//				}
//			}
		}
		renderRequest.setAttribute("personId", personID);
	}
	return OmsbRegistrationWebPortletKeys.ADMIN_VIEW_REGISTRATION_JSP;
}

@Reference(unbind = "_")
private OMSBCommonApi commonApi;

@Reference(unbind = "_")
private RegistrationUtil registrationUtil;

private static final Log LOGGER = LogFactoryUtil.getLog(ViewRegistrationDetailsMVCRenderCommand.class);
}