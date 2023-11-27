package gov.omsb.tms.ecm.web.dto;

public class WorflowTaskRequest {
	
	private long requestId;
	private long workflowInstanceId;
	private long workflowTaskId;
	private String transitionName;
	
	public WorflowTaskRequest() {
		
	}
	public WorflowTaskRequest(long requestId, long workflowInstanceId, long workflowTaskId, String transitionName) {
		 	this.requestId=requestId;
		 	this.workflowInstanceId =workflowInstanceId;
		 	this.workflowTaskId=workflowTaskId;
		 	this.transitionName=transitionName;
	}
	
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
	public long getWorkflowTaskId() {
		return workflowTaskId;
	}
	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}
	public String getTransitionName() {
		return transitionName;
	}
	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	} 
	  

}
