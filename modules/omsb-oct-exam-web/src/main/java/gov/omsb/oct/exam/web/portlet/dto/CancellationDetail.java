package gov.omsb.oct.exam.web.portlet.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CancellationDetail {
    private long id;
    private String examTitle;
    private String examDate;
    private String registrationStartDate;
    private String registrationEndDate;
    private Map<String, Serializable> values;

    private long workflowTaskId;
    private long workflowInstanceId;
    private boolean assignedToMe;
    private List<String> transitionNames;
    private String statusColor;
    public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	private long cancellationStatus;

    private String cancellationStatusValue;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getCancellationStatus() {
        return cancellationStatus;
    }

    public String getCancellationStatusValue() {
        return cancellationStatusValue;
    }

    public void setCancellationStatusValue(String cancellationStatusValue) {
        this.cancellationStatusValue = cancellationStatusValue;
    }

    public void setCancellationStatus(long cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
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

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getRegistrationStartDate() {
        return registrationStartDate;
    }

    public void setRegistrationStartDate(String registrationStartDate) {
        this.registrationStartDate = registrationStartDate;
    }

    public String getRegistrationEndDate() {
        return registrationEndDate;
    }


    public void setRegistrationEndDate(String registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }
    public Map<String, Serializable> getValues() {
        return values;
    }

    public void setValues(Map<String, Serializable> values) {
        this.values = values;
    }
}
