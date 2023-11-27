package gov.omsb.tms.ecm.web.dto;

public class DocumentInfoItem {
	private long id;
	private long caseRequestId;
	private long componentClassRefId;
	private long fileEntryID;
	private String dFFileName;
	private String documentType;
	private long personId;
	private long lRUserId;
	private String documentURL;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public long getComponentClassRefId() {
		return componentClassRefId;
	}
	public void setComponentClassRefId(long componentClassRefId) {
		this.componentClassRefId = componentClassRefId;
	}
	public long getFileEntryID() {
		return fileEntryID;
	}
	public void setFileEntryID(long fileEntryID) {
		this.fileEntryID = fileEntryID;
	}
	public String getdFFileName() {
		return dFFileName;
	}
	public void setdFFileName(String dFFileName) {
		this.dFFileName = dFFileName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getlRUserId() {
		return lRUserId;
	}
	public void setlRUserId(long lRUserId) {
		this.lRUserId = lRUserId;
	}
	public String getDocumentURL() {
		return documentURL;
	}
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	
	
}
