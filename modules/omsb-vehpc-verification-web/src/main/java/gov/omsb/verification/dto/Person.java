package gov.omsb.verification.dto;

import java.util.List;

public class Person {
	private List<PersonItem> items;
	
	/* search-data variable Starts*/
	private String personName;
	private String caseNumber;
	private String verificationDate;
	private String caseStatus;
	private long caseRequestId;
	private long personId;
	private boolean isRedirect;
	/* search-data variable Starts*/
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getVerificationDate() {
		return verificationDate;
	}
	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public List<PersonItem> getItems() {
		return items;
	}
	public void setItems(List<PersonItem> items) {
		this.items = items;
	}
	public long getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}