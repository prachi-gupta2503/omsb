package gov.omsb.faculty.membership.web.dto;

import java.util.List;

import gov.omsb.tms.custom.dto.FacultyRequestDTO;

public class FacultyRequestDetails {

	private String programName;
	private String trainingSiteName;
	private String rotationName;
	private String potentialFacultyName;
	private String facultyTypeEn;
	private String facultyTypeAr;
	private String faultyRequestStatusEn;
	private String faultyRequestStatusAr;
	private long facultyRequestId;
   private String faultyRequestStatusCode;
	
	

	private List<ActionDetail> actionList;
	private long workflowTaskId;
	private List<String> transitionNames;
	private List<String> transitionLevels;
	private long workflowInstanceId;

	public FacultyRequestDetails(FacultyRequestDTO data) {
		super();
		this.programName = data.getProgramName();
		this.trainingSiteName = data.getTrainingSiteName();
		this.rotationName = data.getRotationName();
		this.potentialFacultyName = data.getPotentialFacultyName();
		this.facultyTypeEn = data.getFacultyTypeEn();
		this.facultyTypeAr = data.getFacultyTypeAr();
		this.faultyRequestStatusEn = data.getFaultyRequestStatusEn();
		this.faultyRequestStatusAr = data.getFaultyRequestStatusAr();
		this.facultyRequestId = data.getFacultyRequestId();
		this.faultyRequestStatusCode=data.getFaultyRequestStatusCode();
	}
	
	

	public FacultyRequestDetails() {
		super();
	}



	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getRotationName() {
		return rotationName;
	}

	public void setRotationName(String rotationName) {
		this.rotationName = rotationName;
	}

	public String getPotentialFacultyName() {
		return potentialFacultyName;
	}

	public void setPotentialFacultyName(String potentialFacultyName) {
		this.potentialFacultyName = potentialFacultyName;
	}

	public String getFacultyTypeEn() {
		return facultyTypeEn;
	}

	public void setFacultyTypeEn(String facultyTypeEn) {
		this.facultyTypeEn = facultyTypeEn;
	}

	public String getFacultyTypeAr() {
		return facultyTypeAr;
	}

	public void setFacultyTypeAr(String facultyTypeAr) {
		this.facultyTypeAr = facultyTypeAr;
	}

	public String getFaultyRequestStatusEn() {
		return faultyRequestStatusEn;
	}

	public void setFaultyRequestStatusEn(String faultyRequestStatusEn) {
		this.faultyRequestStatusEn = faultyRequestStatusEn;
	}

	public String getFaultyRequestStatusAr() {
		return faultyRequestStatusAr;
	}

	public void setFaultyRequestStatusAr(String faultyRequestStatusAr) {
		this.faultyRequestStatusAr = faultyRequestStatusAr;
	}

	public long getFacultyRequestId() {
		return facultyRequestId;
	}

	public void setFacultyRequestId(long facultyRequestId) {
		this.facultyRequestId = facultyRequestId;
	}

	public List<ActionDetail> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionDetail> actionList) {
		this.actionList = actionList;
	}

	public long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	public List<String> getTransitionNames() {
		return transitionNames;
	}

	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}

	public List<String> getTransitionLevels() {
		return transitionLevels;
	}

	public void setTransitionLevels(List<String> transitionLevels) {
		this.transitionLevels = transitionLevels;
	}

	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public String getFaultyRequestStatusCode() {
		return faultyRequestStatusCode;
	}

	public void setFaultyRequestStatusCode(String faultyRequestStatusCode) {
		this.faultyRequestStatusCode = faultyRequestStatusCode;
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

	@Override
	public String toString() {
		return "FacultyRequestDetails [programName=" + programName + ", trainingSiteName=" + trainingSiteName
				+ ", rotationName=" + rotationName + ", potentialFacultyName=" + potentialFacultyName
				+ ", facultyTypeEn=" + facultyTypeEn + ", facultyTypeAr=" + facultyTypeAr + ", faultyRequestStatusEn="
				+ faultyRequestStatusEn + ", faultyRequestStatusAr=" + faultyRequestStatusAr + ", facultyRequestId="
				+ facultyRequestId + ", faultyRequestStatusCode=" + faultyRequestStatusCode + ", actionList="
				+ actionList + ", workflowTaskId=" + workflowTaskId + ", transitionNames=" + transitionNames
				+ ", transitionLevels=" + transitionLevels + ", workflowInstanceId=" + workflowInstanceId + "]";
	}
	
	

	
	
}
