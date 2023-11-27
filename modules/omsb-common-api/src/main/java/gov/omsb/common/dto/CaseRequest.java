package gov.omsb.common.dto;

public class CaseRequest {
	private String caseNumber;
	private long caseTypeId;
	private long caseStageID;
	private long caseStatusId;
	private long personId;
	private String crn;
	private String message;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public long getCaseTypeId() {
		return caseTypeId;
	}
	public void setCaseTypeId(long caseTypeId) {
		this.caseTypeId = caseTypeId;
	}
	public long getCaseStageID() {
		return caseStageID;
	}
	public void setCaseStageID(long caseStageID) {
		this.caseStageID = caseStageID;
	}
	public long getCaseStatusId() {
		return caseStatusId;
	}
	public void setCaseStatusId(long caseStatusId) {
		this.caseStatusId = caseStatusId;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
