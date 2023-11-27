package gov.omsb.tms.ecm.web.dto;

public class PotentialMemberAffiliationDTO {
	private String program;
	private String role;
	private long programId;
	private long personId;
	private String status;
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PotentialMemberAffiliationDTO [program=" + program + ", role=" + role + ", programId=" + programId
				+ ", personId=" + personId + ", status=" + status + "]";
	}
	
	
	
	
}
