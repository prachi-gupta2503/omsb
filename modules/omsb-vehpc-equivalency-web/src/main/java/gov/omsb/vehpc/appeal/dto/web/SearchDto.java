package gov.omsb.vehpc.appeal.dto.web;

import java.util.Date;
import java.util.List;

public class SearchDto {
	private long id;
	private long equivalencyDecisionId;
	private String fileName;
	private String equivalencyLevel;
	private String employer;
	private String dob;
	private String employee;
	private long decisionLevelId;
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private long eQRequestedId;
	private List<String> transitionNames;
	private String createdDate;
	private boolean appealExist;
	private String status;
	private String certificateName;
	private String certificateURL;
	private String statusColour;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateURL() {
		return certificateURL;
	}

	public void setCertificateURL(String certificateURL) {
		this.certificateURL = certificateURL;
	}

	public boolean isAppealExist() {
		return appealExist;
	}

	public void setAppealExist(boolean appealExist) {
		this.appealExist = appealExist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDecisionLevelId() {
		return decisionLevelId;
	}

	public void setDecisionLevelId(long decisionLevelId) {
		this.decisionLevelId = decisionLevelId;
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

	public long geteQRequestedId() {
		return eQRequestedId;
	}

	public void seteQRequestedId(long eQRequestedId) {
		this.eQRequestedId = eQRequestedId;
	}

	public List<String> getTransitionNames() {
		return transitionNames;
	}

	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public long getEquivalencyDecisionId() {
		return equivalencyDecisionId;
	}

	public void setEquivalencyDecisionId(long equivalencyDecisionId) {
		this.equivalencyDecisionId = equivalencyDecisionId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEquivalencyLevel() {
		return equivalencyLevel;
	}

	public void setEquivalencyLevel(String equivalencyLevel) {
		this.equivalencyLevel = equivalencyLevel;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getStatusColour() {
		return statusColour;
	}

	public void setStatusColour(String statusColour) {
		this.statusColour = statusColour;
	}

	

}
