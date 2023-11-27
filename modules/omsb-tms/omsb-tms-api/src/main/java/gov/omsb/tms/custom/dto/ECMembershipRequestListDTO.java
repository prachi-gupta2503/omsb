package gov.omsb.tms.custom.dto;

public class ECMembershipRequestListDTO {

	private String program;
	private String potentialECMember;
	private String role;
	private String status;
	private long ecMemberRequestId;
	private long bankDetailsId;
	private long passportCopyId;
	private long nationalIdCopyId;
	private String statusCode;
	private long stateId;

	public ECMembershipRequestListDTO() {
		super();
	}
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getPotentialECMember() {
		return potentialECMember;
	}
	public void setPotentialECMember(String potentialECMember) {
		this.potentialECMember = potentialECMember;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getEcMemberRequestId() {
		return ecMemberRequestId;
	}
	public void setEcMemberRequestId(long ecMemberRequestId) {
		this.ecMemberRequestId = ecMemberRequestId;
	}
	
	public long getBankDetailsId() {
		return bankDetailsId;
	}

	public void setBankDetailsId(long bankDetailsId) {
		this.bankDetailsId = bankDetailsId;
	}

	public long getPassportCopyId() {
		return passportCopyId;
	}

	public void setPassportCopyId(long passportCopyId) {
		this.passportCopyId = passportCopyId;
	}

	public long getNationalIdCopyId() {
		return nationalIdCopyId;
	}

	public void setNationalIdCopyId(long nationalIdCopyId) {
		this.nationalIdCopyId = nationalIdCopyId;
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "ECMembershipRequestListDTO [program=" + program + ", potentialECMember=" + potentialECMember + ", role="
				+ role + ", status=" + status + ", ecMemberRequestId=" + ecMemberRequestId + ", bankDetailsId="
				+ bankDetailsId + ", passportCopyId=" + passportCopyId + ", nationalIdCopyId=" + nationalIdCopyId
				+ ", statusCode=" + statusCode + ", stateId=" + stateId + "]";
	}

	
}
