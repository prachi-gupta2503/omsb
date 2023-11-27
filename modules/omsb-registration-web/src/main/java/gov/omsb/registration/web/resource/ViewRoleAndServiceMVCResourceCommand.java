package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.Services;
import gov.omsb.registration.web.dto.ServicesItem;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

/**
 * @author Mahaboob
 */


@Component(
		immediate=true,
		property = { 
				"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
				"mvc.command.name="+MVCCommands.ROLE_SERVICE_RESOURCE
		}, 
		service = MVCResourceCommand.class
		)
public class ViewRoleAndServiceMVCResourceCommand implements MVCResourceCommand {


	public static final Log _log=LogFactoryUtil.getLog(ViewRoleAndServiceMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long lrUserId=ParamUtil.getLong(resourceRequest, "lrUserId");
		long personId=ParamUtil.getLong(resourceRequest, "personId");
		
		//Save Work Detail
		saveData( resourceRequest,  resourceResponse);

		boolean isNext = ParamUtil.getBoolean(resourceRequest, "isNext");
		_log.info("isNext::: " + isNext);
		if(isNext) {
			if(Validator.isNotNull(lrUserId) && lrUserId > 0) {
				UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), lrUserId);
				if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
					UserMetadata userMetadata=userMetadataItem.getItems().get(0);
					try {
						userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
					} catch (PortalException e) {
						_log.error(e.getMessage());
					}
	
					_log.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
					if(Validator.isNotNull(userMetadata.getProgramId())) {
						try {
							ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
							userMetadata.setProgramTypeId(ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId());
							userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
									themeDisplay.getLocale().toString())      );
						} catch (Exception e) {
							_log.error(e.getMessage());
						}
						if(userMetadata.getProgramTypeId()>0) {
							try {
								_log.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(userMetadata.getProgramTypeId()).getProgramTypeName());
								userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(userMetadata.getProgramTypeId()).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
										themeDisplay.getLocale().toString()));
							} catch (PortalException e) {
								_log.error(e.getMessage());
							}
						}
					}
					resourceRequest.setAttribute("userMetadata", userMetadata);
				}
			}
			RoleMappingItems roleMappingItems=registrationUtil.fetchRoleMapping(themeDisplay, RoleNameConstants.ROLE_TYPE_REGISTRATION);
			List<ListTypeEntry> departmentList = registrationUtil.getPickListEntries(LRPicklistConstants.DEPARTMENT, themeDisplay.getCompanyId());
			List<ListTypeEntry> sectionList = registrationUtil.getPickListEntries(LRPicklistConstants.SECTION, themeDisplay.getCompanyId());
			List<ListTypeEntry> functionList = registrationUtil.getPickListEntries(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId());
			List<ListTypeEntry> committeList = registrationUtil.getPickListEntries(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId());
			//	List<ListTypeEntry> serviceList = registrationUtil.getPickListEntries(LRPicklistConstants.SERVICE, themeDisplay.getCompanyId());
			ServicesItem services = registrationUtil.getServices(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());
			_log.info("services size :"+services.getItems().size());
			if(Validator.isNotNull(services) && Validator.isNotNull(services.getItems())) {
				List<Services> serviceList=new ArrayList<Services>();
				for(Services service:services.getItems()) {
					_log.debug("Service ID :"+service.getServiceId());
					try {						
						service.setServiceId(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SERVICE, service.getServiceId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale())); 
					} catch(NullPointerException e) {
						_log.error("Error while getting serviceID "+ service.getServiceId()+">>"+e.getMessage());
						_log.debug(e);
					}
					serviceList.add(service);
				}
				_log.info("serviceList size :"+serviceList.size());
				resourceRequest.setAttribute("serviceList",serviceList);
			}
			List<ListTypeEntry> programPositionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM_POSITION, themeDisplay.getCompanyId());
			List<ListTypeEntry> purposeList = registrationUtil.getPickListEntries(LRPicklistConstants.PURPOSE, themeDisplay.getCompanyId());
	
			_log.info("functionList size:"+functionList.size());
			List<ProgramTypeMaster> programTypeMasterList=registrationUtil.getProgramType(themeDisplay);
	
			_log.info("programTypeMasterList size:::::"+programTypeMasterList.size());
			List<ProgramMaster> programList=registrationUtil.getProgram(themeDisplay);
	
			_log.info("programList size:::::"+programList.size());
			_log.info("roleMappingItems size:::::"+roleMappingItems.getItems().size());
			if(Validator.isNotNull(roleMappingItems)) {
				List<Role> omsbRoleList= registrationUtil.getOMSBRoles(roleMappingItems);
				resourceRequest.setAttribute("omsbRoleList", omsbRoleList);
			}
			_log.info("Role Mapping size :::" +roleMappingItems.getItems().size());
			_log.info("Role Mapping  :::" +roleMappingItems.getItems().get(0).getRoleType());
			resourceRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
					compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
					compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
					compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			//resourceRequest.setAttribute("serviceList", serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			resourceRequest.setAttribute("lrUserId", lrUserId);
			resourceRequest.setAttribute("personId", personId);
		
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_ROLE_SERVICE_JSP);
			try {
				dispatcher.include(resourceRequest, resourceResponse);
			} catch (PortletException | IOException e) {
				_log.error(e.getMessage());
			}
		} else {
			setWorkDetail(resourceRequest, resourceResponse);
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().
					getRequestDispatcher(OmsbRegistrationWebPortletKeys.REGISTRATION_WORK_DETAILS_JSP);
			try {
				dispatcher.include(resourceRequest, resourceResponse);
			} catch (PortletException | IOException e) {
				_log.error(e.getMessage());
			}
		}
		return true;
	}
	
	private void setWorkDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		
		List<ListTypeEntry> workSectorTypes = registrationUtil.getPickListEntries(LRPicklistConstants.WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
	//	List<ListTypeEntry> wilayats = registrationUtil.getPickListEntries(LRPicklistConstants.WILAYAT, themeDisplay.getCompanyId());
		List<ListTypeEntry> governorate=registrationUtil.getPickListEntries(LRPicklistConstants.GOVERNORATE, themeDisplay.getCompanyId());
		List<ListTypeEntry> designations = registrationUtil.getPickListEntries(LRPicklistConstants.DESIGNATION, themeDisplay.getCompanyId());
		
		if (Validator.isNotNull(personId)) {
			//Get Primary Work Detail 
			EmploymentDetailItem workDetailItems = null;
			try {
				workDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), personId,"1");
			} catch (Exception e) {
				_log.error("workDetailItems exception:" + e.getMessage());
			}
			EmploymentDetailItem secondaryWorkDetailItems = null;
			try {
				secondaryWorkDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), personId,"2");
			} catch (Exception e) {
				_log.error("secondaryWorkDetailItems exception:" + e.getMessage());
			}
			_log.info("workDetailItems ::::" +workDetailItems);
			if(Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {
				EmploymentDetail workDetail=workDetailItems.getItems().get(0);
				try {
					//Get Work sector Type 
					if(Validator.isNotNull(workDetail.getWorkSectorType())) {
						long workSectorTypeID=Long.parseLong(workDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
							WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorType());
							_log.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
							workDetail.setWorkSectorItems(workSectorItems);
						}
					}
						
					//Get Work sector  
					if(Validator.isNotNull(workDetail.getWorkSectorId()) && workDetail.getWorkSectorId()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
						workDetail.setWorkSubSectorItems(workSectorItems);
					}

					//Get Work Sub Sector 
					if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
						workDetail.setWorkSubSectorItems(workSectorItems);
					}

					//Get work second sub sectors 
					if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId2());
						workDetail.setWorkSecondSubSectorItems(workSectorItems);
					}

					if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
						workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getDescription());
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
							workDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
						} catch (PortalException e) {
							_log.error("Error in  code :::" + e.getMessage());
						}
					}

					if(Validator.isNotNull( workDetail.getWorkSector())) {
						WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, workDetail.getWorkSector());
						if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
							workDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
                    }
					_log.debug("workDetail :: " + workDetail);
				} catch (Exception e) {
					_log.error("Error :::::"+e.getMessage());
				}
				_log.info("workDetailItems Size :::::"+ workDetailItems.getItems().size());
				resourceRequest.setAttribute("primaryworkDetail", workDetail);
			}
			
			//Get secondary work detail
			if(Validator.isNotNull(secondaryWorkDetailItems.getItems()) && secondaryWorkDetailItems.getItems().size()>0) {
				EmploymentDetail secondaryWorkDetail=secondaryWorkDetailItems.getItems().get(0);
				try {
					//Get Work sector Type 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorType())) {
						long workSectorTypeID=Long.parseLong(secondaryWorkDetail.getWorkSectorType());
						ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
						//Get Work sector  
						if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
							WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorType());
							_log.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
							secondaryWorkDetail.setWorkSectorItems(workSectorItems);
						}
					}
					
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId()) && secondaryWorkDetail.getWorkSectorId()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
						secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
					}
										
					//Get Work Sub Sector 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
						secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
					}
					
					
					//Get work second sub sectors 
					/*if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId3()) && secondaryWorkDetail.getWorkSectorId3()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
						secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
					}*/
					
					//Get work second sub sectors 
					if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
						WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
						secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
					}
					
					if(Validator.isNotNull(secondaryWorkDetail.getStaffIdCard()) && Long.valueOf(secondaryWorkDetail.getStaffIdCard()) > 0) {
						secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getDescription());
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(secondaryWorkDetail.getStaffIdCard()));
							secondaryWorkDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
						} catch (PortalException e) {
							_log.error("Error in  code :::" + e.getMessage());
						}
					}
					
					if(Validator.isNotNull( secondaryWorkDetail.getWorkSector())) {
						WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, secondaryWorkDetail.getWorkSector());
						if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
							secondaryWorkDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
                    }
			} catch (Exception e) {
				_log.error("Error :::::"+e.getMessage());
			}
			_log.info("secondaryWorkDetailItems Size :::::"+ secondaryWorkDetailItems.getItems().size());
			resourceRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
		}
			
			//Getting Secondary work detail logic here 
			PersonalDetailItem personalDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
			if(Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size()>0) {
				_log.info("agreed : "+personalDetailItem.getItems().get(0).isAgreed());
				_log.info("declared : "+personalDetailItem.getItems().get(0).isDeclaration());
				resourceRequest.setAttribute("isAgreed", personalDetailItem.getItems().get(0).isAgreed());
				resourceRequest.setAttribute("isDeclared", personalDetailItem.getItems().get(0).isDeclaration());
				
				long cvDocumentId = personalDetailItem.getItems().get(0).getCvDocumentId();
				resourceRequest.setAttribute("cvDocumentId", cvDocumentId);
				if(cvDocumentId>0) {
					try {
						FileEntry entry = DLAppLocalServiceUtil.getFileEntry(cvDocumentId);
						resourceRequest.setAttribute("cvDocument", entry.getDescription());
						String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
						_log.info("documentViewURL :::::"+documentViewURL);
						resourceRequest.setAttribute("cvDocumentURL",documentViewURL);
					}catch(PortalException e) {
						_log.error("unable to get the file entry having id "+cvDocumentId);
					}
				}
				resourceRequest.setAttribute("cvDocumentId", cvDocumentId);				
			}
			_log.info(" workSectorTypes :: " + workSectorTypes + "workDetailItems " + workDetailItems);
		}
		
		resourceRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
		resourceRequest.setAttribute("personId", personId);
		resourceRequest.setAttribute("lrUserId", lrUserId);
		
	}

	private void saveData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		_log.info("Inside Save the work details");
		EmploymentDetail employmentDetail = null;
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			Group group = groupLocalService.fetchGroup(PortalUtil.getDefaultCompanyId(),
					CommonConstants.GUEST_GROUP_KEY);
			long groupId = group.getGroupId();
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId = ParamUtil.getLong(resourceRequest, "personId");
			long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
			long employed = ParamUtil.getLong(resourceRequest, "employed");
			String firstDeclareValue = ParamUtil.getString(resourceRequest, "declare1");
			String secondDeclareValue = ParamUtil.getString(resourceRequest, "declare2");
			_log.info("firstDeclareValue : " + firstDeclareValue + " second " + secondDeclareValue + " employed : "+ employed);
			
			
			boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
			boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
			
			
			
			if(isProfileApprover || isRoleApprover) {
				firstDeclareValue="on";
			}
			
			
			
			if(firstDeclareValue.equalsIgnoreCase("on")) {
				employmentDetail = registrationUtil.saveEmploymentDetail(resourceRequest, employmentDetail, uploadPortletRequest, groupId,themeDisplay, personId, lrUserId, employed);

				List<Role> roleList =new ArrayList<>();
				Role healthCareProf = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.HEALTH_CARE_PROFESSIONAL);
				roleList.add(healthCareProf);
				_log.debug(healthCareProf);
				if (Validator.isNotNull(lrUserId)) {
					User regUSer = UserLocalServiceUtil.getUser(lrUserId);
					regUSer.setStatus(WorkflowConstants.STATUS_APPROVED);
					regUSer=UserLocalServiceUtil.updateUser(regUSer);
					//Add Role TO User 
				}
				
				JournalArticle article = null;
				try {
					article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "OMSB_Registration_Email_Notification");
					String emailTitle = StringPool.BLANK;
					String emailContent = StringPool.BLANK;
					String email=StringPool.BLANK;
					if (Validator.isNotNull(article)) {
						String content = article.getContentByLocale("en_US");
						emailTitle = commonApi.readXMLData(content, "emailTitle");
						emailContent = commonApi.readXMLData(content, "emailContent");
						 email=UserLocalServiceUtil.getUser(lrUserId).getEmailAddress();
					}
					_log.debug("emailTitle ?? " + emailTitle);
					_log.debug("emailContent  ?? " + emailContent);
					JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

					notificationJSON.put("notificationText", emailTitle);
					notificationJSON.put("emailTitle", emailTitle);
					notificationJSON.put("emailContent", emailContent);
					
					sendEmailNotification(CommonConstants.SENDER_EMAIL, email, emailTitle, emailContent);
				
				}catch(Exception e) {
					_log.error(e);
				}
				if(Validator.isNull(healthCareProf)) {
					_log.debug("Going to add role and roleId is -->>" +healthCareProf.getRoleId());
					RoleLocalServiceUtil.addUserRoles(lrUserId, roleList);
					long[] roleUserIds = UserLocalServiceUtil.getRoleUserIds(healthCareProf.getRoleId());
					for (int i=0; i<=roleUserIds.length;i++) {
						commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), roleUserIds[0], OmsbRegistrationWebPortletKeys.OMSB_REGISTRATION_EMAIL_NOTIFICATION, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
					}
				}
				//Update Regis
				//Update User status
				if(Validator.isNotNull(personId) && personId>0) {
					try {
						PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
						if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
							try {
								PersonalDetail personalDetail=personDetailItem.getItems().get(0);
								personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.WORK_DETAILS);

								FileEntry cvDocumentFileEntry = registrationUtil.fileUpload(resourceRequest, themeDisplay, OmsbRegistrationWebPortletKeys.CV_DOCUMENT_FOLDERNAME, "cvDocument");
								if (Validator.isNotNull(cvDocumentFileEntry)) {
									personalDetail.setCvDocumentId(cvDocumentFileEntry.getFileEntryId());
								}

								registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
							} catch (Exception e) {
								_log.error(e.getMessage());
							}
						}
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}


				PersonalDetailItem personDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId,themeDisplay);
				_log.info(personDetailItem);
				if (Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size() > 0) {
					try {
						PersonalDetail personalDetail = personDetailItem.getItems().get(0);
						if (firstDeclareValue.equalsIgnoreCase("on")) {
							personalDetail.setDeclaration(true);
						}
						else {
							personalDetail.setDeclaration(false);
						}
						if (secondDeclareValue.equalsIgnoreCase("on")) {
							personalDetail.setAgreed(true);
						}
						else {
							personalDetail.setAgreed(false);
						}

						registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
								personalDetail);
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			_log.info("unable to save the work detail ");
		}

		//		if (Validator.isNotNull(employmentDetail)) {
//		resourceResponse.getRenderParameters().setValue("lrUserId", ParamUtil.getString(resourceRequest, "lrUserId"));
//		resourceResponse.getRenderParameters().setValue("personId", ParamUtil.getString(resourceRequest, "personId"));
		boolean isNext = ParamUtil.getBoolean(resourceRequest, "isNext");
		_log.info("isNext::: " + isNext);
	}
	
	
	public void sendEmailNotification(String senderEmail, String recieverEmail, String subject, String body) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(senderEmail));
			mailMessage.setTo(new InternetAddress(recieverEmail));
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	@Reference(unbind = "-")
	private GroupLocalService groupLocalService;

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;


}