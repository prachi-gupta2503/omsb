package gov.omsb.duty.logging.web.dto;

public class ProgramDutyAssignmentDTO {
	
	private long programDutyAssignmentId;
	private String dutyType;
	private String dutyAssignment;
	private String program;
	private String cohort;
	private String status;
	
	public ProgramDutyAssignmentDTO() {
		super();
	}
	public ProgramDutyAssignmentDTO(long programDutyAssignmentId, String dutyType, String dutyAssignment,
			String program, String cohort, String status) {
		super();
		this.programDutyAssignmentId = programDutyAssignmentId;
		this.dutyType = dutyType;
		this.dutyAssignment = dutyAssignment;
		this.program = program;
		this.cohort = cohort;
		this.status = status;
	}
	public long getProgramDutyAssignmentId() {
		return programDutyAssignmentId;
	}
	public void setProgramDutyAssignmentId(long programDutyAssignmentId) {
		this.programDutyAssignmentId = programDutyAssignmentId;
	}
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	public String getDutyAssignment() {
		return dutyAssignment;
	}
	public void setDutyAssignment(String dutyAssignment) {
		this.dutyAssignment = dutyAssignment;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getCohort() {
		return cohort;
	}
	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getJson() {
		  return "{ 'programDutyAssignmentId':'" + programDutyAssignmentId +
		  "', 'dutyType':'" + dutyType + "', 'dutyAssignment':'" + dutyAssignment +
		  "', 'program':'" + program + "', 'cohort':'" + cohort + "', 'status':'" +
		  status + "'}";
	}
	
	@Override
	public String toString() {
		return "ProgramDutyAssignmentDTO [programDutyAssignmentId=" + programDutyAssignmentId + ", dutyType=" + dutyType
				+ ", dutyAssignment=" + dutyAssignment + ", program=" + program + ", cohort=" + cohort + ", status="
				+ status + "]";
	}
		
	
}
