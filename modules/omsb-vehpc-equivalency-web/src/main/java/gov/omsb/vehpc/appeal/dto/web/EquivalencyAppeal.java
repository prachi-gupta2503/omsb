package gov.omsb.vehpc.appeal.dto.web;

import java.util.List;

public class EquivalencyAppeal {
	
	private String id;
	private String comments;
	private long statusID;
	private long appellantUserId;
	private String eqLevelId;
	private String dateCreated;
	
	private String documentInfoId;
	private String dFFileName;
	private EquivalencyLevel equivalencyLevelId;
	private String appellantName;
	private String employerName;
	private String employeeName;
	private long eQDecisionId;
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private long employeePersonId;
	private long eQRequestedId;
	
	//
	private long eqDecisionLevelId;
	private String eqLevel;
	private String documentType;
	private long equivalencyDocTypeId;
	//
	
	public long getEqDecisionLevelId() {
		return eqDecisionLevelId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public long getEquivalencyDocTypeId() {
		return equivalencyDocTypeId;
	}

	public void setEquivalencyDocTypeId(long equivalencyDocTypeId) {
		this.equivalencyDocTypeId = equivalencyDocTypeId;
	}

	public void setEqDecisionLevelId(long eqDecisionLevelId) {
		this.eqDecisionLevelId = eqDecisionLevelId;
	}

	public String getEqLevel() {
		return eqLevel;
	}

	public void setEqLevel(String eqLevel) {
		this.eqLevel = eqLevel;
	}

	private List<String> transitionNames;
	
	
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

	public long geteQDecisionId() {
		return eQDecisionId;
	}

	public void seteQDecisionId(long eQDecisionId) {
		this.eQDecisionId = eQDecisionId;
	}

	public String getAppellantName() {
		return appellantName;
	}

	public void setAppellantName(String appellantName) {
		this.appellantName = appellantName;
	}

	public EquivalencyLevel getEquivalencyLevelId() {
		return equivalencyLevelId;
	}

	public void setEquivalencyLevelId(EquivalencyLevel equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}

	

	public String getDocumentInfoId() {
		return documentInfoId;
	}

	public void setDocumentInfoId(String documentInfoId) {
		this.documentInfoId = documentInfoId;
	}




	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getStatusID() {
		return statusID;
	}

	public void setStatusID(long statusID) {
		this.statusID = statusID;
	}

	public long getAppellantUserId() {
		return appellantUserId;
	}

	public void setAppellantUserId(long appellantUserId) {
		this.appellantUserId = appellantUserId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getdFFileName() {
		return dFFileName;
	}

	public void setdFFileName(String dFFileName) {
		this.dFFileName = dFFileName;
	}
	public String getEqLevelId() {
		return eqLevelId;
	}

	public void setEqLevelId(String eqLevelId) {
		this.eqLevelId = eqLevelId;
	}

	public long getEmployeePersonId() {
		return employeePersonId;
	}

	public void setEmployeePersonId(long employeePersonId) {
		this.employeePersonId = employeePersonId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public long geteQRequestedId() {
		return eQRequestedId;
	}

	public void seteQRequestedId(long eQRequestedId) {
		this.eQRequestedId = eQRequestedId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyAppeal [id=");
		builder.append(id);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", statusID=");
		builder.append(statusID);
		builder.append(", appellantUserId=");
		builder.append(appellantUserId);
		builder.append(", eqLevelId=");
		builder.append(eqLevelId);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", documentInfoId=");
		builder.append(documentInfoId);
		builder.append(", dFFileName=");
		builder.append(dFFileName);
		builder.append(", equivalencyLevelId=");
		builder.append(equivalencyLevelId);
		builder.append(", appellantName=");
		builder.append(appellantName);
		builder.append(", employerName=");
		builder.append(employerName);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", eQDecisionId=");
		builder.append(eQDecisionId);
		builder.append(", workflowTaskId=");
		builder.append(workflowTaskId);
		builder.append(", workflowInstanceId=");
		builder.append(workflowInstanceId);
		builder.append(", assignedToMe=");
		builder.append(assignedToMe);
		builder.append(", employeePersonId=");
		builder.append(employeePersonId);
		builder.append(", eQRequestedId=");
		builder.append(eQRequestedId);
		builder.append(", eqDecisionLevelId=");
		builder.append(eqDecisionLevelId);
		builder.append(", eqLevel=");
		builder.append(eqLevel);
		builder.append(", documentType=");
		builder.append(documentType);
		builder.append(", equivalencyDocTypeId=");
		builder.append(equivalencyDocTypeId);
		builder.append(", transitionNames=");
		builder.append(transitionNames);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
