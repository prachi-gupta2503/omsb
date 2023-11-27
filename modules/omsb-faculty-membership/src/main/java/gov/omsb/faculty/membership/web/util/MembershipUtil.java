package gov.omsb.faculty.membership.web.util;

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.faculty.membership.web.constants.FacultyMemberRoles;
import gov.omsb.faculty.membership.web.dto.ActionDetail;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetails;
import gov.omsb.faculty.membership.web.dto.WorkflowTaskDetail;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestState;
import gov.omsb.tms.model.EcMemberRequestStatus;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.model.FacultyRequestStatus;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.EcMemberRequestStateLocalServiceUtil;
import gov.omsb.tms.service.EcMemberRequestStatusLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestStateLocalServiceUtil;
import gov.omsb.tms.service.FacultyRequestStatusLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, service = MembershipUtil.class)
public class MembershipUtil {

	public FacultyRequest createNewRequest(FacultyRequest facultyRequest, User user, String viewUrl)
			throws PortalException {
		LOGGER.info("createNewRequest Start test");

		facultyRequest = FacultyRequestLocalServiceUtil.updateFacultyRequest(facultyRequest);
		ProgramMaster programMaster = programMasterLocalService.getProgramMaster(facultyRequest.getProgramId());
		String programName = programMaster.getProgramName(Locale.ENGLISH);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		LOGGER.debug("programName >" + programName);
		serviceContext.setAttribute("PROGRAM-NAME", programName);
		serviceContext.setAttribute("viewDetailsUrl", viewUrl);
		serviceContext.setAttribute("backURL", viewUrl);
		serviceContext.setAttribute("url", viewUrl);

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
		workflowContext.put("viewDetailsUrl", viewUrl);
		workflowContext.put("PROGRAM-NAME", programName);

		AssetEntryLocalServiceUtil.updateEntry(user.getUserId(), facultyRequest.getGroupId(),
				FacultyRequest.class.getName(), facultyRequest.getFacultyRequestId(),
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

		WorkflowHandlerRegistryUtil.startWorkflowInstance(facultyRequest.getCompanyId(), facultyRequest.getGroupId(),
				user.getUserId(), FacultyRequest.class.getName(), facultyRequest.getFacultyRequestId(), facultyRequest,
				serviceContext, workflowContext);

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}

		LOGGER.info("createNewRequest End");

		return facultyRequest;
	}

	public UserMetadata addUserMetaData(FacultyRequest facultyRequest) throws PortalException {
		FacultyRequest facultyRequestObj = facultyRequestLocalService
				.getFacultyRequest(facultyRequest.getFacultyRequestId());
		LOGGER.debug("facultyRequestObj => " + facultyRequestObj);
		UserMetadata userMetaData = new UserMetadata();
		userMetaData.setLrUserId(facultyRequestObj.getPotentialFacultyId());
		userMetaData.setProgramId(facultyRequestObj.getProgramId());
		userMetaData.setRoleId(facultyRequestObj.getPotentialFacultyTypeId());
		LOGGER.debug("userMetaData => " + userMetaData);
		return userMetaData;
	}

	public static Role getUserRole(long groupId, long userId) throws PortalException {
		String[] roleName = { "Potential EC Member", "Executive President", "EC Section Head", "Authorized Individual",
				"EC Section Staff", "GME Director", "VPAA", "Chairman" };
		List<Role> userRoles = UserLocalServiceUtil.getUser(userId).getRoles();
		for (int i = 0; i < roleName.length; i++) {
			for (Role role : userRoles) {
				if (role.getName().equals(roleName[i])) {
					return role;
				}
			}
		}

		return null;
	}

	public static void assignPotentialECMemberRole(FacultyRequest facultyRequest, ServiceContext serviceContext) {
		LOGGER.info("checkPotentialECMemberRoleIsAssignOrNot called");
		User user = null;
		Role role;
		try {
			LOGGER.info("CompenyId " + serviceContext.getCompanyId());
			role = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), FacultyMemberRoles.POTENTIAL_EC_MEMBER);
			user = UserLocalServiceUtil.getUser(facultyRequest.getPotentialFacultyId());
			LOGGER.info("isPotentialECMember(user.getUserId(),role.getRoleId())  :  "
					+ isPotentialECMember(user.getUserId(), role.getRoleId()));
			if (!isPotentialECMember(user.getUserId(), role.getRoleId())) {

				RoleLocalServiceUtil.addUserRole(user.getUserId(), role.getRoleId());
				UserLocalServiceUtil.updateUser(user);
				LOGGER.info("Potential EC Member Role Update Successfully");
			}
		} catch (PortalException e) {

			e.printStackTrace();
		}
	}

	public static boolean isPotentialECMember(long userId, long roleId) {
		LOGGER.info("isPotentialECMember called");
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
		for (Role userRole : userRoles) {
			if (userRole.getRoleId() == roleId) {
				LOGGER.info("Inside Role Check");
				return true;
			}

		}

		return false;

	}

	public static void assignECMemberRole(FacultyRequest facultyRequest, long companyId, long groupId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(facultyRequest.getPotentialFacultyId());
			RoleLocalServiceUtil.addUserRole(user.getUserId(), facultyRequest.getPotentialFacultyTypeId());
			UserLocalServiceUtil.updateUser(user);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		try {

			UserLocalServiceUtil.deleteRoleUser(
					RoleLocalServiceUtil.getRole(companyId, FacultyMemberRoles.POTENTIAL_EC_MEMBER).getRoleId(),
					user.getUserId());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void saveUserMetadata(UserMetadata userMetadata, long groupId) {
		LOGGER.info("into saveUserMetadata function");
		String userMetadataDetailUrl = generateScopeListURL(LRObjectURL.REG_USER_METADATA_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String userMetadataDetailMapper = CustomObjectMapperUtil.writeValueAsString(userMetadata, null);
		httpConnector.executePost(userMetadataDetailUrl, userMetadataDetailMapper, headers);
	}

	private String generateScopeListURL(String userMetadataRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + userMetadataRequestsUrl + "scopes/" + String.valueOf(siteId);
	}

	public static FacultyRequestDetails getMemberRequestDetail(HttpServletRequest httpRequest,
			ThemeDisplay themeDisplay, FacultyRequestDTO data) {

		FacultyRequestDetails memberRequestDetail = new FacultyRequestDetails(data);
		String statusCode = data.getFaultyRequestStatusCode();

		LOGGER.info("statusCode > " + statusCode);

		// workflow task
		long requestId = data.getFacultyRequestId();
		FacultyRequest facultyRequest = null;
		try {
			facultyRequest = FacultyRequestLocalServiceUtil.getFacultyRequest(requestId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean taskAssignableForUser = WorkflowUtil.isTaskAssignableForUser(themeDisplay,
				FacultyRequest.class.getName(), requestId, themeDisplay.getUserId());

		List<ActionDetail> actionList = new ArrayList<ActionDetail>();
		List<String> transitionNames = new ArrayList<String>();
		List<String> transitionLevels = new ArrayList<String>();

		if (taskAssignableForUser) {
			if ("MEMBER_DETAILS_ENTRY".equalsIgnoreCase(statusCode)) {
				if (data.getPassportCopyId() > 0 && data.getNationalIdCopyId() > 0) {
					statusCode = statusCode + ":EDIT";
				}
			}

			if ("PROGRAM".equalsIgnoreCase(statusCode)) {
				if (facultyRequest != null) {
					if (facultyRequest.getCoveringLetterId() <= 0) {
						statusCode = statusCode + ":EDIT";
					}
				}
			}
			LOGGER.debug("######## statusCode > " + statusCode);
			actionList = ActionManager.getActions(statusCode);
			long workflowTaskId = WorkflowUtil.getCurrentTaskId(themeDisplay, FacultyRequest.class.getName(), requestId,
					themeDisplay.getUserId());
			LOGGER.debug("######## workflowTaskId " + workflowTaskId);
			WorkflowInstance workflowInstance = WorkflowUtil.getWorkflowInstace(FacultyRequest.class.getName(),
					themeDisplay, requestId);
			memberRequestDetail.setWorkflowTaskId(workflowTaskId);
			memberRequestDetail.setWorkflowInstanceId(workflowInstance.getWorkflowInstanceId());

			transitionNames = WorkflowUtil.getNextTransitionNames(themeDisplay.getCompanyId(), workflowTaskId,
					themeDisplay.getUserId());

			if (transitionNames != null && transitionNames.size() > 0) {
				for (String transitionName : transitionNames) {
					transitionLevels.add(ActionManager.getTransitionLevel(transitionName, httpRequest));
				}
			}
		}

		memberRequestDetail.setActionList(actionList);
		memberRequestDetail.setTransitionNames(transitionNames);
		memberRequestDetail.setTransitionLevels(transitionLevels);

		LOGGER.debug("actionList > " + actionList);
		LOGGER.debug("transitionNames > " + transitionNames);
		LOGGER.debug("transitionLevels > " + transitionLevels);

		return memberRequestDetail;
	}

	public void submitTask(ThemeDisplay themeDisplay, long workflowInstanceId, long taskId, String transitionName,
			String comment) throws PortalException {

		WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);

		LOGGER.info("************** isCompleted >  " + task.isCompleted());

		if (task.isCompleted()) {
			return;
		}

		Map<String, Serializable> workflowContext = WorkflowInstanceManagerUtil
				.getWorkflowInstance(themeDisplay.getCompanyId(), workflowInstanceId).getWorkflowContext();

		workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(themeDisplay.getUserId()));
		workflowContext.put(WorkflowConstants.CONTEXT_TASK_COMMENTS, comment);

		if (task.getAssigneeUserId() <= 0) { // task is not assigned to user
			List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(taskId);

			if (userList.stream().anyMatch(u -> u.getUserId() == themeDisplay.getUserId())) {
				LOGGER.info(" task is not assigned to user Auto assign");
				WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						taskId, themeDisplay.getUserId(), "Auto assign", task.getDueDate(), workflowContext);
			}

			LOGGER.info(" task is assigned to user completeWorkflowTask");
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskId,
					transitionName, comment, workflowContext);
			LOGGER.info("completeWorkflowTask done");

		} else if (task.getAssigneeUserId() == themeDisplay.getUserId()) {

			LOGGER.info("task is assigned to user completeWorkflowTask");
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), taskId,
					transitionName, comment, workflowContext);
			LOGGER.info("task is not assigned to user completeWorkflowTask done");
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}

	}

	public static WorkflowTaskDetail getMemberRequestWorkflowDetail(HttpServletRequest httpRequest,
			ThemeDisplay themeDisplay, FacultyRequest facultyRequest) {
		WorkflowTaskDetail workflowTaskDetail = new WorkflowTaskDetail();
		LOGGER.info("############ getMemberRequestWorkflowDetail ###############");
		try {

			if (facultyRequest.getLastestFacultyRequestStateId() <= 0) {
				return workflowTaskDetail;
			}
			
			FacultyRequestState facultyRequestStates = FacultyRequestStateLocalServiceUtil
					.getFacultyRequestState(facultyRequest.getLastestFacultyRequestStateId());
			
			FacultyRequestStatus requestStatus = FacultyRequestStatusLocalServiceUtil
					.getFacultyRequestStatus(facultyRequestStates.getFacultyRequestStatusId());
			
			String statusCode = requestStatus.getCode();
			LOGGER.info("statusCode > " + statusCode);

			// workflow task

			long requestId = facultyRequest.getFacultyRequestId();

			workflowTaskDetail.setRequestId(requestId);

			boolean taskAssignableForUser = WorkflowUtil.isTaskAssignableForUser(themeDisplay,
					FacultyRequest.class.getName(), requestId, themeDisplay.getUserId());

			List<ActionDetail> actionList = new ArrayList<ActionDetail>();
			List<String> transitionNames = new ArrayList<String>();
			List<String> transitionLevels = new ArrayList<String>();

			if (taskAssignableForUser) {

				if ("MEMBER_DETAILS_ENTRY".equalsIgnoreCase(statusCode)) {
					if (facultyRequest.getPassportCopyId() > 0 && facultyRequest.getNotionalIdCopyId() > 0) {
						statusCode = statusCode + ":EDIT";
					}
				}

				if ("PROGRAM".equalsIgnoreCase(statusCode)) {
					if (facultyRequest.getCoveringLetterId() <= 0) {
						statusCode = statusCode + ":EDIT";
					}
				}

				actionList = ActionManager.getActions(statusCode);

				transitionNames = WorkflowUtil.getNextTransitionNames(themeDisplay, FacultyRequest.class.getName(),
						requestId, themeDisplay.getUserId());

				long workflowTaskId = WorkflowUtil.getCurrentTaskId(themeDisplay, FacultyRequest.class.getName(),
						requestId, themeDisplay.getUserId());
				WorkflowInstance workflowInstance = WorkflowUtil.getWorkflowInstace(FacultyRequest.class.getName(),
						themeDisplay, requestId);
				workflowTaskDetail.setTaskId(workflowTaskId);
				workflowTaskDetail.setWorkflowInstanceId(workflowInstance.getWorkflowInstanceId());

				if (transitionNames != null && transitionNames.size() > 0) {
					for (String transitionName : transitionNames) {
						transitionLevels.add(ActionManager.getTransitionLevel(transitionName, httpRequest));
					}
				}
			}
			LOGGER.debug("actionList > > " + actionList);
			workflowTaskDetail.setActionList(actionList);
			workflowTaskDetail.setTransitionNames(transitionNames);
			workflowTaskDetail.setTransitionLevels(transitionLevels);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return workflowTaskDetail;
	}

	

	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;

	@Reference(unbind = "-")
	private FacultyRequestLocalService facultyRequestLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;

	private static final Log LOGGER = LogFactoryUtil.getLog(MembershipUtil.class);

}
