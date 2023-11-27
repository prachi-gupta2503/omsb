package omsb.vehpc.equivalency.workflow.web;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskAssignee;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import gov.omsb.common.util.CustomWorkflowTaskUtil;

/**
 * 
 * @author MahaboobB
 *
 */

public class JspTransitionWorkflowHandler {
	
	public static List<String> getNextTransitionNames(ThemeDisplay themeDisplay,String className,long classPk){
		List<WorkflowLog> logs = new ArrayList<>();
		long workflowTaskId = 0;
		WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay, classPk);
		if (Validator.isNotNull(instance)) {
			 logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
		}
		if (Validator.isNotNull(logs) && !logs.isEmpty()) {
			workflowTaskId = CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs);
		}
		return CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
	}
	
	/**
	 * Equivalendcy workflow jsp handler
	 */
	public static List<String> equivalencyRequestJspTransitionHandler(ThemeDisplay themeDisplay,String className,long classPk){
		
		List<String> transitionNames = new ArrayList<String>();
		try{	
			WorkflowInstanceLink wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), className, classPk);
			if(Validator.isNotNull(wil)){
				List<Integer> logTypes_assign = new ArrayList<Integer>();	
				logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
				try {
					List<WorkflowLog> workflowLogs_assign = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(themeDisplay.getCompanyId(), wil.getWorkflowInstanceId(), logTypes_assign, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
					if(workflowLogs_assign.size() > 0){	
					    long workflowTaskId = workflowLogs_assign.get(workflowLogs_assign.size()-1).getWorkflowTaskId();
					    if(workflowLogs_assign.get(workflowLogs_assign.size()-1).getRoleId() > 0){	
							try {
								List<WorkflowTask> workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasks(themeDisplay.getCompanyId(), false, QueryUtil.ALL_POS, QueryUtil.ALL_POS, WorkflowComparatorFactoryUtil.getTaskCreateDateComparator());
								for(WorkflowTask workflowTask : workflowTasks){	
						    		if(workflowTask.getWorkflowInstanceId() == wil.getWorkflowInstanceId()){	
							    		List<WorkflowTaskAssignee> WorkflowTaskAssignees = workflowTask.getWorkflowTaskAssignees();	
							    		for(WorkflowTaskAssignee workflowTaskAssignee : WorkflowTaskAssignees){	
							    			for(long roleId : themeDisplay.getUser().getRoleIds()){	
						    	    			if(workflowTaskAssignee.getAssigneeClassName().equalsIgnoreCase(Role.class.getName())	
						    	    					&& workflowTaskAssignee.getAssigneeClassPK() == roleId){	
						    	    				transitionNames.add("assignToMe");
						    	    				break;	
						    	    			}	
							    			}	
							    		}	
							    		break;	
						    		}	
						    	}
							} catch (WorkflowException e) {
								LOGGER.error(e.getMessage());
							}	
					    		
					    } else {	
							if(themeDisplay.getUserId() == workflowLogs_assign.get(workflowLogs_assign.size()-1).getUserId()){
								try {
									transitionNames = WorkflowTaskManagerUtil.getNextTransitionNames(themeDisplay.getCompanyId(), themeDisplay.getUserId(), workflowTaskId);
								} catch (WorkflowException e) {
									LOGGER.error(e.getMessage());
								}	
							}	
					    }
					}
				} catch (WorkflowException e) {
					LOGGER.error(e.getMessage());
				}				
			}
		} catch(PortalException  e){
			LOGGER.error(e.getMessage());
		}	
		return transitionNames;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(JspTransitionWorkflowHandler.class);	
}