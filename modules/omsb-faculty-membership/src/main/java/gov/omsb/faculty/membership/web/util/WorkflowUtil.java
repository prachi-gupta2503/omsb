package gov.omsb.faculty.membership.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class WorkflowUtil {

	private static final Log LOGGER = LogFactoryUtil.getLog(WorkflowUtil.class);

	public static boolean isTaskAssignableForUser(ThemeDisplay themeDisplay, String className, long entityId,
			long userId) {
		LOGGER.info("##### isTaskAssignableForUser Called  #####");

		boolean isTaskAssignable = false;
		try {
			WorkflowInstance workflowInstance = getWorkflowInstace(className, themeDisplay, entityId);
			List<WorkflowLog> workflowLogs = getWorkflowLogs(themeDisplay.getCompanyId(), workflowInstance);
			isTaskAssignable = isTaskAssignable(workflowLogs, themeDisplay, userId);

		} catch (Exception ex) {
			// no need to do anything
		}
		return isTaskAssignable;
	}

	public static WorkflowInstance getWorkflowInstace(String className, ThemeDisplay themeDisplay, long classPK) {
		WorkflowInstance WorkflowInstance = null;
		WorkflowInstanceLink instanceLink;
		try {
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), className, classPK);
			if (Validator.isNotNull(instanceLink)) {
				WorkflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(),
						instanceLink.getWorkflowInstanceId());
			}
		} catch (PortalException e) {
			// e.printStackTrace();
		}

		return WorkflowInstance;
	}

	public static WorkflowInstance getWorkflowInstace(String className, long classPK, long companyId, long groupId) {
		WorkflowInstance WorkflowInstance = null;
		WorkflowInstanceLink instanceLink;
		try {
			instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, groupId, className,
					classPK);
			if (Validator.isNotNull(instanceLink)) {
				WorkflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
						instanceLink.getWorkflowInstanceId());
			}
		} catch (PortalException e) {
			// e.printStackTrace();
		}

		return WorkflowInstance;
	}

	public static List<WorkflowLog> getWorkflowLogs(long companyId, WorkflowInstance instance) {
		List<WorkflowLog> workflowLogs = null;
		List<Integer> assignLogTypes = new ArrayList<>();
		assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
		try {
			workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId,
					instance.getWorkflowInstanceId(), assignLogTypes, -1, -1,
					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
		} catch (WorkflowException e) {
			// e.printStackTrace();
		}

		return workflowLogs;
	}

	public static boolean isTaskAssignable(List<WorkflowLog> workflowLogs, ThemeDisplay themeDisplay, long userId) {

		if (workflowLogs.size() > 0) {
			try {
				long taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
				LOGGER.info("taskId::" + taskId);
				WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
				LOGGER.info("task::" + task);
				List<User> userList = WorkflowTaskManagerUtil.getAssignableUsers(taskId);
				if (task.isCompleted()) {
					return false;
				}
				LOGGER.info("userId::" + userId);
				if ((task.getAssigneeUserId() == userId)
						|| (userList.stream().anyMatch(u -> u.getUserId() == userId))) {
					return true;

				}
			} catch (WorkflowException e) {
				// e.printStackTrace();
			}
		}

		return false;
	}

	public static long getCurrentTaskId(ThemeDisplay themeDisplay, String className, long leaveId, long userId) {
		WorkflowInstance workflowInstance = getWorkflowInstace(className, themeDisplay, leaveId);
		List<WorkflowLog> workflowLogs = getWorkflowLogs(themeDisplay.getCompanyId(), workflowInstance);
		long taskId = 0;
		if (workflowLogs.size() > 0) {
			taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
		}
		return taskId;
	}

	public static List<String> getNextTransitionNames(ThemeDisplay themeDisplay, String className, long requestId,
			long userId) {
		List<String> transitionNames = null;
		try {
			WorkflowInstance workflowInstance = getWorkflowInstace(className, themeDisplay, requestId);
			List<WorkflowLog> workflowLogs = getWorkflowLogs(themeDisplay.getCompanyId(), workflowInstance);
			long taskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
			transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(themeDisplay.getCompanyId(), userId,
					taskId);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transitionNames;

	}

	public static List<String> getNextTransitionNames(long companyId, long taskId, long userId) {
		List<String> transitionNames = null;
		try {
			transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, taskId);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transitionNames;

	}
}
