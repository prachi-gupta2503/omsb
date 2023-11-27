package gov.omsb.vehpc.appeal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
@Component(immediate = true, service = AppealWrokflowUtil.class)
public class AppealWrokflowUtil {
	
	public WorkflowInstance getWorkflowInstace(String className, ThemeDisplay themeDisplay, long classPK) throws PortalException {
		WorkflowInstanceLink instanceLink = WorkflowInstanceLinkLocalServiceUtil.
				getWorkflowInstanceLink(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), className, classPK);
		if (Validator.isNotNull(instanceLink)) {
			return WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceLink.getWorkflowInstanceId());
		}
		return null;
	}
	
	public List<WorkflowLog> getWorkflowLogs(long companyId, WorkflowInstance instance) throws WorkflowException {
		List<Integer> assignLogTypes = new ArrayList<>();
		assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
		return WorkflowLogManagerUtil.
				getWorkflowLogsByWorkflowInstance(companyId, instance.getWorkflowInstanceId(), 
						assignLogTypes, -1, -1, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
	}
	
	public long getWorkflowTaskIdByLogs(List<WorkflowLog> wfAssignLogs) {
		return wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
	}
	
	public long getWorkflowAssigneeRoleIdByLogs(List<WorkflowLog> wfAssignLogs) {
		return wfAssignLogs.get(wfAssignLogs.size() - 1).getRoleId();
	}
	
	public boolean isWorkFlowTaskAssignedToRole(ThemeDisplay themeDisplay, long assigneeRoleId) {
		return Arrays.stream(themeDisplay.getUser().getRoleIds()).anyMatch(id -> (id == assigneeRoleId));

	}
	
	public List<String> getTransitionNames(ThemeDisplay themeDisplay, long workflowTaskId) throws WorkflowException {
		return WorkflowTaskManagerUtil.
				 getNextTransitionNames(themeDisplay.getCompanyId(), themeDisplay.getUserId(), workflowTaskId);
		
	}
	
	public boolean isTaskCompleted(long workflowTaskId) throws WorkflowException {
		return WorkflowTaskManagerUtil.fetchWorkflowTask(workflowTaskId).isCompleted();
	}
	
	public void assignWorkflowToUser(ThemeDisplay themeDisplay, WorkflowInstance instance, long workflowTaskId) throws PortalException {
		WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(), workflowTaskId,
				themeDisplay.getUserId(), "", new Date(), instance.getWorkflowContext());
	}
	
	public void completeWorkflowTask(ThemeDisplay themeDisplay, WorkflowInstance instance, long workflowTaskId, String comments, String transitionName) throws PortalException {
		WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
				workflowTaskId, transitionName, comments, instance.getWorkflowContext());
	}
	
	
	
	public void getWorkflowTask(String className, ThemeDisplay themeDisplay, String comments, PortletRequest request) {
		try {
			Role role = null;
			WorkflowInstanceLink instanceLink = WorkflowInstanceLinkLocalServiceUtil.
					getWorkflowInstanceLink(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), className, 47875);
			WorkflowInstance instance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceLink.getWorkflowInstanceId());
			
			List<Integer> assignLogTypes = new ArrayList<>();
			assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
			List<WorkflowLog> wfAssignLogs = WorkflowLogManagerUtil.
					getWorkflowLogsByWorkflowInstance(themeDisplay.getCompanyId(), instance.getWorkflowInstanceId(), 
							assignLogTypes, -1, -1, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
			for (WorkflowLog log : wfAssignLogs) {
				logger.info("log  ? " + log.getRoleId());
			}
			 long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() - 1).getWorkflowTaskId();
			 long roleId = wfAssignLogs.get(wfAssignLogs.size() - 1).getRoleId();
			 WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), wfTaskId);
			 logger.info("task assignee user Id  ? " + task.getAssigneeUserId());
			 List<String> transitionNames = WorkflowTaskManagerUtil.
					 getNextTransitionNames(themeDisplay.getCompanyId(), themeDisplay.getUserId(), task.getWorkflowTaskId());
			 try {
					role = RoleLocalServiceUtil.getRole(roleId);
					logger.info("role Name   ? " + role.getName());
				}
				catch (PortalException e) {
					logger.error(e.getMessage());
				}
			 String tName = "";
			 if (themeDisplay.getUser().getRoles().contains(role)) {
					logger.info("role Name matching and assigning to user >>>");
					 request.setAttribute("hasAssignableUsers", false);
					WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(), task.getWorkflowTaskId(),
							themeDisplay.getUserId(), "", new Date(), instance.getWorkflowContext());
			} else {
			 for (String transitionName: transitionNames) {
				 logger.info("transition Name ? " + transitionName);
				 tName = transitionName;
				 WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(), task.getWorkflowTaskId(), transitionName, comments, instance.getWorkflowContext());
			 }
			}
			 request.setAttribute("workflowTaskId", task.getWorkflowTaskId());
			 request.setAttribute("comments", comments);
			 request.setAttribute("workflowContext", instance.getWorkflowContext());
			 request.setAttribute("transitionName", tName);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		
	}
	

	
	private static final Log logger = LogFactoryUtil.getLog(AppealWrokflowUtil.class);
}
