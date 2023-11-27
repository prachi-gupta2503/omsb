package omsb.vehpc.equivalency.dto.web;

import java.util.List;


public class CaseRequest {
	private long id;
	private long caseNumber;
	private long caseStageID;
	private long caseStatusId;
	private long caseTypeID;
	private long cRN;
	private long message;
	private long personID;
	
	private List<CaseRequestItem> items;
	public List<CaseRequestItem> getItems() {
		return items;
	}
	public void setItems(List<CaseRequestItem> items) {
		this.items = items;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(long caseNumber) {
		this.caseNumber = caseNumber;
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
	public long getCaseTypeID() {
		return caseTypeID;
	}
	public void setCaseTypeID(long caseTypeID) {
		this.caseTypeID = caseTypeID;
	}
	public long getcRN() {
		return cRN;
	}
	public void setcRN(long cRN) {
		this.cRN = cRN;
	}
	public long getMessage() {
		return message;
	}
	public void setMessage(long message) {
		this.message = message;
	}
	public long getPersonID() {
		return personID;
	}
	public void setPersonID(long personID) {
		this.personID = personID;
	}

}
