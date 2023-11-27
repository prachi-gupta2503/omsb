package gov.omsb.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Component(immediate = true, service = CustomWorkflowTaskUtil.class)
public class CustomWorkflowTaskUtil {
	
	private CustomWorkflowTaskUtil() {}
	
	public static  WorkflowInstance getWorkflowInstace(String className, ThemeDisplay themeDisplay, long classPK){
		try {
			WorkflowInstanceLink instanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), className, classPK);
			if (Validator.isNotNull(instanceLink)) {
				return WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(),
						instanceLink.getWorkflowInstanceId());
			}
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static  List<WorkflowLog> getWorkflowLogs(long companyId, WorkflowInstance instance) {
		List<Integer> assignLogTypes = new ArrayList<>();
		assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
		try {
			return WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId, instance.getWorkflowInstanceId(),
					assignLogTypes, -1, -1, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
		} catch (WorkflowException e) {
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public static  long getWorkflowTaskIdByLogs(List<WorkflowLog> wfAssignLogs) {
		return wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
	}

	public static  long getWorkflowAssigneeRoleIdByLogs(List<WorkflowLog> wfAssignLogs) {
		return wfAssignLogs.get(wfAssignLogs.size() - 1).getRoleId();
	}

	public static  boolean isWorkFlowTaskAssignedToRole(ThemeDisplay themeDisplay, long assigneeRoleId) {
		return Arrays.stream(themeDisplay.getUser().getRoleIds()).anyMatch(id -> (id == assigneeRoleId));

	}

	public static  List<String> getTransitionNames(ThemeDisplay themeDisplay, long workflowTaskId) {
		try {
			return WorkflowTaskManagerUtil.getNextTransitionNames(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					workflowTaskId);
		} catch (WorkflowException e) {
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public static  boolean isTaskCompleted(long workflowTaskId) {
		try {
			return WorkflowTaskManagerUtil.fetchWorkflowTask(workflowTaskId).isCompleted();
		} catch (WorkflowException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public static void assignWorkflowToUser(ThemeDisplay themeDisplay, WorkflowInstance instance, long workflowTaskId) {
		try {
			WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					workflowTaskId, themeDisplay.getUserId(), "", new Date(), instance.getWorkflowContext());
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static  void completeWorkflowTask(ThemeDisplay themeDisplay, WorkflowInstance instance, long workflowTaskId,
			String comments, String transitionName) {
		try {
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					workflowTaskId, transitionName, comments, instance.getWorkflowContext());
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private static final Log logger = LogFactoryUtil.getLog(CustomWorkflowTaskUtil.class);
}
