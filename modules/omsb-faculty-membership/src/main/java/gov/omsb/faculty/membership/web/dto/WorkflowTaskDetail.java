package gov.omsb.faculty.membership.web.dto;

import java.util.List;

public class WorkflowTaskDetail {
	
	private long requestId;
	
	private long workflowInstanceId;
	
	private long taskId;
	
	private boolean taskAssignable;
	
	private List<ActionDetail> actionList;

	private List<String> transitionNames;
	
	private List<String> transitionLevels;

	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public boolean isTaskAssignable() {
		return taskAssignable;
	}

	public void setTaskAssignable(boolean taskAssignable) {
		this.taskAssignable = taskAssignable;
	}

	public List<String> getTransitionNames() {
		return transitionNames;
	}

	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}
	
	public List<ActionDetail> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionDetail> actionList) {
		this.actionList = actionList;
	}

	public List<String> getTransitionLevels() {
		return transitionLevels;
	}

	public void setTransitionLevels(List<String> transitionLevels) {
		this.transitionLevels = transitionLevels;
	}


	public String getTransitionList() {
		if(transitionNames != null && transitionNames.size()>0) {
			return String.join(",", transitionNames); 
		}
		return "";
	}
	
	public String getTransitionLevelsList() {
		if(transitionLevels != null && transitionLevels.size()>0) {
			return String.join(",", transitionLevels); 
		}
		return "";
	}
	
	public String getFirstTransitionName() {
		try {
			return transitionNames.get(0);
		}catch(Exception ex) {}
		
		return  "";
	}
	
	public String getFirstTransitionLevel() {
		try {
			return transitionLevels.get(0);
		}catch(Exception ex) {}
		
		return null;
	}
	
}
