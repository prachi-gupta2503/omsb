package gov.omsb.registration.web.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.util.RegistrationUtil;

/**
 * @author Mahaboob
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" + MVCCommands.SAVE_ADMIN_DECISION }, service = MVCActionCommand.class)
public class SaveAdminDecisionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.debug("SaveAdminDecisionMVCActionCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()) {
		
			boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
			boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
			boolean isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
	
			if(isProfileApprover || isRoleApprover || isServiceApprover) {
				try {
					
					WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), ParamUtil.getLong(actionRequest, "workflowInstanceId"));
					if (Validator.isNotNull(workflowInstance)) {
						CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, ParamUtil.getLong(actionRequest, "workflowTaskId"));
					}
					
					if (Validator.isNotNull(workflowInstance)) {
						String comments = ParamUtil.getString(actionRequest, "comments");
						String decision = ParamUtil.getString(actionRequest, "decision");
						
						LOGGER.debug("decision :::::"+decision);
						LOGGER.debug("comments :::::"+comments);
						String url=StringPool.BLANK;
						
						if(isRoleApprover) {
							url=LRObjectURL.REG_USER_ROLE_STATUS;
						}else if(isProfileApprover) {
							url=LRObjectURL.REG_USER_PROFILE_STATUS;
						}else if (isServiceApprover) {
							url=LRObjectURL.REG_USER_SERVICE_STATUS;
						}
						
						UserRegistrationStatus userRegistrationStatus = registrationUtil.getItems(themeDisplay.getPortalURL() + url + ParamUtil.getLong(actionRequest, "userRegistrationStatusId"), UserRegistrationStatus.class);
						userRegistrationStatus.setComment(comments);
						userRegistrationStatus.setUserStatus(decision);
						
						try {
							registrationUtil.updateRegistrationStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), url, userRegistrationStatus);
						} catch (Exception e) {
							LOGGER.error("Error ::"+e.getMessage());
						}
						
						try {
							CustomWorkflowTaskUtil.completeWorkflowTask(themeDisplay, workflowInstance, ParamUtil.getLong(actionRequest, "workflowTaskId"), comments, decision);
						} catch (Exception e) {
							LOGGER.error("Error ::"+e.getMessage());
						}
						if(isProfileApprover) {
							if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.APPROVED_WF_STATUS)) {
								LOGGER.debug("Send Profile Approve Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_APPROVE_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							} else if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
								LOGGER.debug("Send Profile Reject Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_PROFILE_REJECT_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							}
						} else if(isRoleApprover) {
							if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.APPROVED_WF_STATUS)) {
								addRequestedRole(themeDisplay, decision, userRegistrationStatus);
								LOGGER.debug("Send Role Approve Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_ROLE_APPROVE_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							} else if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
								LOGGER.debug("Send Role Reject Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_ROLE_REJECT_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							}
						} else if(isServiceApprover) {
							if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.APPROVED_WF_STATUS)) {
								LOGGER.debug("Send Service Approve Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_SERVICE_APPROVE_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							} else if(decision.equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
								LOGGER.debug("Send Service Reject Notification userId : "+userRegistrationStatus.getLrUserId());
								commonApi.sendLRUserNotification(themeDisplay.getScopeGroupId(), userRegistrationStatus.getLrUserId(), OmsbRegistrationWebPortletKeys.REGISTRATION_SERVICE_REJECT_USER_NOTIFICATION_TEMPLATE, OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB, Boolean.TRUE);
							}
						}
					}
				} catch (PortalException e) {
					LOGGER.error(e.getMessage());
				}
			}
		}
		//actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_DETAILS);
	}

	private void addRequestedRole(ThemeDisplay themeDisplay, String decision,
			UserRegistrationStatus userRegistrationStatus) throws PortalException {
		if(decision.equalsIgnoreCase("approve")&& Validator.isNotNull(userRegistrationStatus)) {
				long lrUserId=userRegistrationStatus.getLrUserId();
				LOGGER.debug("lrUserId ::::::::"+lrUserId);
				User regUser=UserLocalServiceUtil.getUser(lrUserId);
				UserMetatdataItems userMetaDataItems=registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), lrUserId);
				if(Validator.isNotNull(userMetaDataItems) && Validator.isNotNull(userMetaDataItems.getItems()) && userMetaDataItems.getItems().size()>0) {
					UserMetadata userMetadata=userMetaDataItems.getItems().get(0);
					
					LOGGER.debug("userMetadata :::" +userMetadata.getRoleId());
					LOGGER.debug("userMetadata :::" +userMetadata.getLrUserId());
					
					if(Validator.isNotNull(userMetadata) && userMetadata.getRoleId()>0) {
						List<Role> roleList =new ArrayList<>();
						 Role requestedRole=RoleLocalServiceUtil.getRole(userMetadata.getRoleId());
						 String departmentId=userMetadata.getDepartmentId();
						 String sectionId=userMetadata.getSectionId();
						 String functionId=userMetadata.getFunctionId();
						 LOGGER.debug("requestedRole ::::"+requestedRole.getName());
						 
						 Role toRequestedRole=null;
						 if(departmentId.equalsIgnoreCase("professionalCompetenceDepartment") && 
								  sectionId.equalsIgnoreCase("verificationEquivalencyOfHealthSection") &&
								  functionId.equalsIgnoreCase("verificationAndEquivalencyOfHealthProfessionalsCertificatesSpecialist")) {
						
							  if(requestedRole.getName().equalsIgnoreCase(RoleNameConstants.AUTHORIZED_USER_FROM_MEDICAL_INSTITUTIONS)) {
								  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EMPLOYER);
							  }else if(requestedRole.getName().equalsIgnoreCase("Staff")) {
								  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_ADMIN);
							  }else if(requestedRole.getName().equalsIgnoreCase("Committee member")) {
								  toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.VEHPC_COMMITTEE);
							  }else {
								  toRequestedRole=requestedRole;
							  }
						  }
						 
						 if((requestedRole.getName().equalsIgnoreCase("Residency Trainee")) || (requestedRole.getName().equalsIgnoreCase("Fellowship Trainee")) || (requestedRole.getName().equalsIgnoreCase("GFP Trainee"))){
							 toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.TRAINEE); 
						 }
						 if((requestedRole.getName().equalsIgnoreCase("Staff")) || departmentId.equalsIgnoreCase("examinationDepartment")){
							 toRequestedRole=RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),RoleNameConstants.EXAM_DEPARTNEMT_ADMIN);
						 }
						 LOGGER.debug("toRequestedRole :::" +toRequestedRole);
						 roleList.add(toRequestedRole);
						 LOGGER.debug("roleList ::::" +roleList);
						 
						 
						 RoleLocalServiceUtil.addUserRoles(regUser.getUserId(), roleList);
						 UserLocalServiceUtil.updateUser(regUser);
						 
						 LOGGER.debug("Requester Role : Added to user  :::::::::");
					}
				}
		}
	}

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(SaveAdminDecisionMVCActionCommand.class);
}