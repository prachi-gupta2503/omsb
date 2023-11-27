package gov.omsb.tms.custom.dto;

import java.util.Date;

public class TraineeLoggedProcedureDetailsDTO {

	private long traineeLoggedProcedureDetailsId;
	private long traineeId;
	private String patientId;
	private String trainingSiteName;
	private String roleTypeName;
	private Date procedurePerformedDate;
	private String diagnosisDescription;
	private String procedureStatus;
	private String procedureName;
	private String procedureGroupName;
	private String cptCode;
	private String programName;
	
	public long getTraineeLoggedProcedureDetailsId() {
		return traineeLoggedProcedureDetailsId;
	}

	public void setTraineeLoggedProcedureDetailsId(long traineeLoggedProcedureDetailsId) {
		this.traineeLoggedProcedureDetailsId = traineeLoggedProcedureDetailsId;
	}

	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getTrainingSiteName() {
		return trainingSiteName;
	}

	public void setTrainingSiteName(String trainingSiteName) {
		this.trainingSiteName = trainingSiteName;
	}

	public String getRoleTypeName() {
		return roleTypeName;
	}

	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	public Date getProcedurePerformedDate() {
		return procedurePerformedDate;
	}

	public void setProcedurePerformedDate(Date procedurePerformedDate) {
		this.procedurePerformedDate = procedurePerformedDate;
	}

	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}

	public String getProcedureStatus() {
		return procedureStatus;
	}

	public void setProcedureStatus(String procedureStatus) {
		this.procedureStatus = procedureStatus;
	}
	
	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getProcedureGroupName() {
		return procedureGroupName;
	}

	public void setProcedureGroupName(String procedureGroupName) {
		this.procedureGroupName = procedureGroupName;
	}

	public String getCptCode() {
		return cptCode;
	}

	public void setCptCode(String cptCode) {
		this.cptCode = cptCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public String toString() {
		return "TraineeLoggedProcedureDetailsDTO [traineeLoggedProcedureDetailsId=" + traineeLoggedProcedureDetailsId
				+ ", traineeId=" + traineeId + ", patientId=" + patientId + ", trainingSiteName=" + trainingSiteName
				+ ", roleTypeName=" + roleTypeName + ", procedurePerformedDate=" + procedurePerformedDate
				+ ", diagnosisDescription=" + diagnosisDescription + ", procedureStatus=" + procedureStatus
				+ ", procedureName=" + procedureName + ", procedureGroupName=" + procedureGroupName + ", cptCode="
				+ cptCode + ", programName=" + programName + "]";
	}

}
