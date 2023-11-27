package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class ExamAppeal {
	private long id;
	private long examResultId;
	private String reason;
	private long lrUserId;
	private int appealCount;
	private String traineeName;
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private List<String> transitionNames;
	private String appealStatusValue;
	private long appealStatus;
	private String result;
	private double percentage;
	private String programName;
	private String examType;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
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
	public String getAppealStatusValue() {
		return appealStatusValue;
	}
	public void setAppealStatusValue(String appealStatusValue) {
		this.appealStatusValue = appealStatusValue;
	}
	public long getAppealStatus() {
		return appealStatus;
	}
	public void setAppealStatus(long appealStatus) {
		this.appealStatus = appealStatus;
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
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getExamResultId() {
		return examResultId;
	}
	public void setExamResultId(long examResultId) {
		this.examResultId = examResultId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public int getAppealCount() {
		return appealCount;
	}
	public void setAppealCount(int appealCount) {
		this.appealCount = appealCount;
	}
	
}
