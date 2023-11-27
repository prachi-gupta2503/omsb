package gov.omsb.registration.web.action;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.ROLE_SERVICE_MVCACTION},
			service = MVCActionCommand.class)
public class SaveRoleServiceMVCActionCommand implements MVCActionCommand {
	
	public static final Log _log=LogFactoryUtil.getLog(SaveRoleServiceMVCActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean associated = ParamUtil.getBoolean(actionRequest, "associated");
		boolean registringForRole = ParamUtil.getBoolean(actionRequest, "registering");
		boolean requestForService = ParamUtil.getBoolean(actionRequest, "requestForService");
		String index = ParamUtil.getString(actionRequest, "index");
		
		String roleId =	ParamUtil.getString(actionRequest, "role_"+index);
		String departmentId = ParamUtil.getString(actionRequest, "department_"+index);
		String sectionId = ParamUtil.getString(actionRequest, "section_"+index);
		String functionId = ParamUtil.getString(actionRequest, "function_"+index);
		String programtypeId = ParamUtil.getString(actionRequest, "programtype_"+index);
		long programId = ParamUtil.getLong(actionRequest, "program_"+index);
		String programPositionId = ParamUtil.getString(actionRequest, "programPosition_"+index);
		String purposeId = ParamUtil.getString(actionRequest, "purpose_"+index);
		
		String roleOther = ParamUtil.getString(actionRequest, "roleOther_"+index);
		String departmentOther = ParamUtil.getString(actionRequest, "departmentOther_"+index);
		String sectionOther = ParamUtil.getString(actionRequest, "sectionOther_"+index);
		String functionOther = ParamUtil.getString(actionRequest, "functionOther_"+index);
		//String programtypeOther = ParamUtil.getString(actionRequest, "programtypeOther_"+index);
		String programOther = ParamUtil.getString(actionRequest, "programOther_"+index);
		String programPositionOther = ParamUtil.getString(actionRequest, "programPositionOther_"+index);
		String purposeOther = ParamUtil.getString(actionRequest, "purposeOther_"+index);
		
		String commiteeId = ParamUtil.getString(actionRequest, "committe_"+index);
		String omsbServiceId = ParamUtil.getString(actionRequest, "service");
		String commiteeOther = ParamUtil.getString(actionRequest, "commiteeOther");
		String omsbServiceOther = ParamUtil.getString(actionRequest, "serviceOther");
		long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
		boolean roleVerifiedStatisId=false;
		boolean profileVerifiedStatisId=false;
		//boolean registringForRole=true;
		
		
		boolean isProfileApprover=false;
		boolean isRoleApprover=false;
		boolean isServiceApprover=false;
		try {
			 isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
		} catch (PortalException e1) {
			_log.error("Exception ::" +e1.getMessage());
		}

		try {
			 isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
		} catch (PortalException e2) {
			_log.error("Exception ::" +e2.getMessage());
		}
		
		try {
			 isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
		} catch (PortalException e1) {
			_log.error("Exception ::" +e1.getMessage());
		}
		
		boolean isAdmin = registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId()==themeDisplay.getUserId()?true :false;
		boolean isRequestedByAdmin=false;
		
		if(themeDisplay.isSignedIn() && (isAdmin || isServiceApprover ||isRoleApprover || isProfileApprover)) {
			isRequestedByAdmin=true;
		}
		
		Person person=null;
		PersonItem personItem=null;
		if (Validator.isNotNull(lrUserId) && lrUserId > 0) {
			UserMetatdataItems userMetadataItem = registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), lrUserId); // null check

			if (Validator.isNotNull(userMetadataItem.getItems()) && userMetadataItem.getItems().size() > 0) {
				UserMetadata userMetadata = userMetadataItem.getItems().get(0);				
				long userMetadataId=userMetadata.getId();
				registrationUtil.deleteUserMetaData(themeDisplay, userMetadata.getId());
				//Delete Role Status
				UserRegistrationStatusItems userRegistrationStatusItems = registrationUtil.getRoleStatusByUserMetaDataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadataId);
				
				_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().size());
				try {
					if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
						UserRegistrationStatus userRegistrationStatus=	userRegistrationStatusItems.getItems().get(0);
						if(Validator.isNotNull(userRegistrationStatus)) {
							_log.info("inside delete role statuss :::");
							registrationUtil.deleteRoleStatus(themeDisplay, userRegistrationStatus.getId());
						}
					}
				} catch (Exception e) {
					_log.error("Exception in code :::" +e.getMessage());
				}
			}
			_log.info("Deleted::::User info");
			
			try {
				 personItem=registrationUtil.fetchPersonByLrUserId(themeDisplay, lrUserId);
			} catch (UnsupportedEncodingException e) {
				_log.error(e.getMessage());
			}
			
			//Add Permission CHecker pending
			//User user=	UserLocalServiceUtil.getUser(lrUserId);
			//user.setStatus(WorkflowConstants.STATUS_APPROVED);
			//UserLocalServiceUtil.updateUser(user);
		}
		
		if(Validator.isNotNull(personItem.getItems())  && personItem.getItems().size()>0) {
			person=personItem.getItems().get(0);
		}
		
		//Changes
		UserMetadata userMetadata=null;
		if (requestForService) {
			userMetadata=registrationUtil.saveUserMetadata(themeDisplay, null, null, null, null, null, 0, null, null, null, null, roleVerifiedStatisId,
					profileVerifiedStatisId, omsbServiceId, registringForRole, associated, lrUserId,
					isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
			
			//Update User status
			/*
			 * PersonalDetailItem
			 * personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(person.getId
			 * (), themeDisplay); if(Validator.isNotNull(personDetailItem.getItems()) &&
			 * personDetailItem.getItems().size()>0) { try { PersonalDetail
			 * personalDetail=personDetailItem.getItems().get(0);
			 * personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.
			 * SERVICE_TYPE);
			 * registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(),
			 * themeDisplay.getScopeGroupId(), personalDetail); } catch (Exception e) {
			 * _log.error(e.getMessage()); } }
			 */

			//Save User Profile and Service
			//UserRegistrationStatus userRegistrationServiceStatus = new UserRegistrationStatus();
			//userRegistrationServiceStatus.setPersonId(Validator.isNotNull(person.getId())?person.getId():0);
			//userRegistrationServiceStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
			//userRegistrationServiceStatus.setUserStatus(OmsbRegistrationWebPortletKeys.APPROVED_WF_STATUS);
			//userRegistrationProfileStatus.setPersonId(Validator.isNotNull(person)?person.getId():0);
			try {
				//registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationProfileStatus);
				//registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_SERVICE_STATUS, userRegistrationServiceStatus);

			//	Role profileRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN);
			//	long[] profileRoleUserIds = UserLocalServiceUtil.getRoleUserIds(profileRole.getRoleId());
			//	for (int i=0; i<=profileRoleUserIds.length;i++) {
		//			commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), profileRoleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
			//	}
				
		//		Role serviceRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN);
			//	long[] serviceRoleUserIds = UserLocalServiceUtil.getRoleUserIds(serviceRole.getRoleId());
		//		for (int i=0; i<=serviceRoleUserIds.length;i++) {
		//			commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), serviceRoleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_SERVICE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
		//		}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
			
		} else {
			userMetadata = registrationUtil.saveUserMetadata(themeDisplay, roleId, departmentId, sectionId, commiteeId, functionId,
					programId, programPositionId, programPositionOther, purposeId, purposeOther, roleVerifiedStatisId, profileVerifiedStatisId, omsbServiceId, registringForRole,
					associated, lrUserId,isRequestedByAdmin,roleOther,departmentOther,sectionOther,functionOther,programOther,commiteeOther,omsbServiceOther);
		}
		
		/*
		 * boolean isNext = ParamUtil.getBoolean(actionRequest, "isNext"); if(isNext) {
		 */
			if (!requestForService) {
				//Update User status
				PersonalDetailItem personDetailItem=registrationUtil.fetchPersonalDetailsByPersonId(person.getId(), themeDisplay);
				if(Validator.isNotNull(personDetailItem.getItems()) && personDetailItem.getItems().size()>0) {
					try {
						PersonalDetail personalDetail=personDetailItem.getItems().get(0);
						
						if(registringForRole) {
							personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2);
							registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);	
						}else {
							personalDetail.setRegistrationStatus(OmsbRegistrationWebPortletKeys.ROLE_TYPE_1);
							registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personalDetail);
						}
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}	
			
			try {
				if(!themeDisplay.isSignedIn() && (!isProfileApprover || !isRoleApprover || !isAdmin)) {
				//Save User Profile and Role Status
					_log.info("inside if condition :");
				UserRegistrationStatus userRegistrationRoleStatus=new UserRegistrationStatus();
				userRegistrationRoleStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
				userRegistrationRoleStatus.setUserStatus(CommonConstants.PENDING);
				userRegistrationRoleStatus.setPersonId(Validator.isNotNull(person)?person.getId():0);
				userRegistrationRoleStatus.setUserMetaDataId(Validator.isNotNull(userMetadata)?userMetadata.getId():0);
				
				_log.info("userRegistrationRoleStatus .getUserMetadataId ::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+userRegistrationRoleStatus.getUserMetaDataId());
				
				UserRegistrationStatus userRegistrationProfileStatus=new UserRegistrationStatus();
				userRegistrationProfileStatus.setLrUserId(Validator.isNotNull(lrUserId)?lrUserId:0);
				userRegistrationProfileStatus.setUserStatus(CommonConstants.PENDING);
				userRegistrationProfileStatus.setPersonId(Validator.isNotNull(person)?person.getId():0);
				
				registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, userRegistrationProfileStatus);
				registrationUtil.addRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_ROLE_STATUS, userRegistrationRoleStatus);
				//}
				Role profileRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN);
				long[] profileRoleUserIds = UserLocalServiceUtil.getRoleUserIds(profileRole.getRoleId());
				for (int i=0; i<=profileRoleUserIds.length;i++) {
					commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), profileRoleUserIds[0], OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_APPROVER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
				}
				
				Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN);
				long[] roleUserIds = UserLocalServiceUtil.getRoleUserIds(role.getRoleId());
				for (int i=0; i<=roleUserIds.length;i++) {
					commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), roleUserIds[0], OmsbRegistrationWebPortletKeys.OMSB_REGISTRATION_EMAIL_NOTIFICATION, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.FALSE);
				}
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		
		// Update User status to active
		try {
			Role adminRole = null;
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long userId = registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				userId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(userId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);

			if (Validator.isNotNull(lrUserId)) {
				User regUSer = UserLocalServiceUtil.getUser(lrUserId);
				regUSer.setStatus(WorkflowConstants.STATUS_APPROVED);
				regUSer=UserLocalServiceUtil.updateUser(regUSer);
				//Add Role TO User 
				registrationUtil.addRole(themeDisplay, roleId, userId, regUSer,actionRequest);
			}
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		
			//Send email notification 
//			if(themeDisplay.isSignedIn() && isRoleApprover ) {
//				try {
//					actionResponse.sendRedirect(OmsbRegistrationWebPortletKeys.ROLE_APPROVER_PAGE_URL);
//				} catch (IOException e) {
//				_log.error("unable to redirect "+e.getMessage());
//				}
//			}
//			else if(themeDisplay.isSignedIn() &&( isProfileApprover || isRoleApprover)) {
			if(themeDisplay.isSignedIn() && ( isProfileApprover || isRoleApprover || isAdmin)) {
				try {
					String userValues=null;
					
					try {
						String email=UserLocalServiceUtil.getUser(lrUserId).getEmailAddress();
						userValues=String.valueOf(lrUserId)+":"+email;
						userValues=Base64.encode(userValues.getBytes());
						_log.info("encodedValues "+userValues);
						String url=themeDisplay.getPortalURL()+"/registration?p_p_id=gov_omsb_registration_web_OmsbRegistrationWebPortlet_INSTANCE_cyUlh6A1IzKv&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_gov_omsb_registration_web_OmsbRegistrationWebPortlet_INSTANCE_cyUlh6A1IzKv_mvcRenderCommandName=%2Fregistration%2Fview-new-password&user="+userValues;
						JournalArticle article = null;
						article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), OmsbRegistrationWebPortletKeys.REGISTRATION_USER_NEW_PASSWORD_NOTIFICATION_TEMPLATE);
						String emailTitle = StringPool.BLANK;
						String emailContent = StringPool.BLANK;
						if (Validator.isNotNull(article)) {
							String content = article.getContentByLocale("en_US");
							emailTitle = commonApi.readXMLData(content, "emailTitle");
							emailContent = commonApi.readXMLData(content, "emailContent");
							emailContent=emailContent.replace("[resetlink]", url);
						}
						_log.info("emailContent : "+emailContent);
						_log.info("emailTitle : "+emailTitle);
		
						sendEmailNotification(CommonConstants.SENDER_EMAIL, email, emailTitle, emailContent);
						//commonApi.sendEmailNotification(CommonConstants.SENDER_EMAIL, email, emailTitle, emailContent);
						_log.info("emailContent : send email notification clicked::::");
					} catch (PortalException e) {
						_log.info("unable to get the user having user id  "+lrUserId+" ::: "+e.getMessage());
					}
					if(isRoleApprover) {
						actionResponse.sendRedirect(OmsbRegistrationWebPortletKeys.ROLE_APPROVER_PAGE_URL);
					}
					else if(isProfileApprover){
					actionResponse.sendRedirect(OmsbRegistrationWebPortletKeys.PROFILE_APPROVER_PAGE_URL);
					}
					else {
						actionResponse.sendRedirect("/group/guest/dashboard");
					}
				} catch (IOException e) {
				_log.error("unable to redirect "+e.getMessage());
				}
			}
//			else if(themeDisplay.isSignedIn() && isAdmin) {
//				try {
//					actionResponse.sendRedirect("/group/guest/dashboard");
//				} catch (IOException e) {
//				_log.error("unable to redirect "+e.getMessage());
//				}
//			}
			else {
//				commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), lrUserId, "OMSB_Registration_Email_Notification", 
//						OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
//				JournalArticle article = null;
//				try {
//					article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "OMSB_Registration_Email_Notification");
//					String emailTitle = StringPool.BLANK;
//					String emailContent = StringPool.BLANK;
//					String email=StringPool.BLANK;
//					if (Validator.isNotNull(article)) {
//						String content = article.getContentByLocale("en_US");
//						emailTitle = commonApi.readXMLData(content, "emailTitle");
//						emailContent = commonApi.readXMLData(content, "emailContent");
//						 email=UserLocalServiceUtil.getUser(lrUserId).getEmailAddress();
//					}
//					_log.info("emailTitle ?? " + emailTitle);
//					_log.info("emailContent  ?? " + emailContent);
//					JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
//
//					notificationJSON.put("notificationText", emailTitle);
//					notificationJSON.put("emailTitle", emailTitle);
//					notificationJSON.put("emailContent", emailContent);
//					
//					sendEmailNotification(CommonConstants.SENDER_EMAIL, email, emailTitle, emailContent);
//					
//				} catch (PortalException e) {
//					_log.error(e.getMessage(), e);
//				}
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_THANK_YOU);
			}
		/*} else {
			actionResponse.getRenderParameters().setValue("personId", String.valueOf(person.getId()));
			actionResponse.getRenderParameters().setValue("lrUserId", String.valueOf(lrUserId));
		  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_ROLE_SERVICE);
		}*/
		SessionMessages.add(actionRequest,"success-role-service");
		return false;
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
	

	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;
	
	
	@Reference
	private UserLocalService userLocalService;
}