package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class ExamWithdrawal {

	private long id;
	private long examDefinitionId;
	private long lrUserId;
	private String reason;
	private long withdrawalStatus;
	private String traineeName;
	private String programName;
	private String examType;
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private List<String> transitionNames;
	private String withdrawalStatusValue;
	private long examScheduleId;
	
	public String getWithdrawalStatusValue() {
		return withdrawalStatusValue;
	}

	public void setWithdrawalStatusValue(String withdrawalStatusValue) {
		this.withdrawalStatusValue = withdrawalStatusValue;
	}

	public long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public boolean isAssignedToMe() {
		return assignedToMe;
	}

	public void setAssignedToMe(boolean assignedToMe) {
		this.assignedToMe = assignedToMe;
	}

	public List<String> getTransitionNames() {
		return transitionNames;
	}

	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getWithdrawalStatus() {
		return withdrawalStatus;
	}

	public void setWithdrawalStatus(long withdrawalStatus) {
		this.withdrawalStatus = withdrawalStatus;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public long getExamScheduleId() {
		return examScheduleId;
	}

	public void setExamScheduleId(long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}

}
