package gov.omsb.verification.dto;


public class LoggedUserDetails {
	private String name;
	private String dfrn;
	private String verificationDate;
	private String caseRequestId;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDfrn() {
		return dfrn;
	}
	public void setDfrn(String dfrn) {
		this.dfrn = dfrn;
	}
	public String getVerificationDate() {
		return verificationDate;
	}
	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}
	public String getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(String caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
