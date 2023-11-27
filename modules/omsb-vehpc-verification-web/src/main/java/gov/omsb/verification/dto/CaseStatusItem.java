package gov.omsb.verification.dto;

public class CaseStatusItem {
	
	private long id;
	private long dFStatusID;
	
	
	
	public long getdFStatusID() {
		return dFStatusID;
	}

	public void setdFStatusID(long dFStatusID) {
		this.dFStatusID = dFStatusID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	private CaseStatusPicList caseStatus;



	public CaseStatusPicList getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(CaseStatusPicList caseStatus) {
		this.caseStatus = caseStatus;
	}

	

}
