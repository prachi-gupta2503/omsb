package gov.omsb.tms.custom.dto;

import java.util.Date;

public class ProgramDTO {

	private long programMasterId;
	private long programTypeMasterId;
	private long eligibilityDegreeMasterId;
	private String programName;
	private String programCode;
	private String programType;
	private String eligibilityDegree;
	private String programObjectives;
	private String programAdmissionRequirements;
	private String programDescription;
	private String programVision;
	private String programMission;
	private Boolean programStatus;
	private Date establishmentDate;

	public ProgramDTO() {
		super();
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getEligibilityDegree() {
		return eligibilityDegree;
	}

	public void setEligibilityDegree(String eligibilityDegree) {
		this.eligibilityDegree = eligibilityDegree;
	}

	public String getProgramObjectives() {
		return programObjectives;
	}

	public void setProgramObjectives(String programObjectives) {
		this.programObjectives = programObjectives;
	}

	public String getProgramAdmissionRequirements() {
		return programAdmissionRequirements;
	}

	public void setProgramAdmissionRequirements(String programAdmissionRequirements) {
		this.programAdmissionRequirements = programAdmissionRequirements;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public String getProgramVision() {
		return programVision;
	}

	public void setProgramVision(String programVision) {
		this.programVision = programVision;
	}

	public String getProgramMission() {
		return programMission;
	}

	public void setProgramMission(String programMission) {
		this.programMission = programMission;
	}

	public long getProgramMasterId() {
		return programMasterId;
	}

	public void setProgramMasterId(long programMasterId) {
		this.programMasterId = programMasterId;
	}

	public long getProgramTypeMasterId() {
		return programTypeMasterId;
	}

	public void setProgramTypeMasterId(long programTypeMasterId) {
		this.programTypeMasterId = programTypeMasterId;
	}

	public long getEligibilityDegreeMasterId() {
		return eligibilityDegreeMasterId;
	}

	public void setEligibilityDegreeMasterId(long eligibilityDegreeMasterId) {
		this.eligibilityDegreeMasterId = eligibilityDegreeMasterId;
	}

	public Boolean getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(Boolean programStatus) {
		this.programStatus = programStatus;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	@Override
	public String toString() {
		return "ProgramDTO [programMasterId=" + programMasterId + ", programTypeMasterId=" + programTypeMasterId
				+ ", eligibilityDegreeMasterId=" + eligibilityDegreeMasterId + ", programName=" + programName
				+ ", programCode=" + programCode + ", programType=" + programType + ", eligibilityDegree="
				+ eligibilityDegree + ", programObjectives=" + programObjectives + ", programAdmissionRequirements="
				+ programAdmissionRequirements + ", programDescription=" + programDescription + ", programVision="
				+ programVision + ", programMission=" + programMission + ", programStatus=" + programStatus
				+ ", establishmentDate=" + establishmentDate + "]";
	}
	
}