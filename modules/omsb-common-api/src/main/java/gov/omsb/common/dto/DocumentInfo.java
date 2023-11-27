package gov.omsb.common.dto;

public class DocumentInfo {
	
	private long caseRequestId;
	private long componentClassRefId;
	private long fileEntryID;
	private String dFFileName;
	private String documentType;
	private long id;
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
	public String getDocumentURL() {
		return documentURL;
	}
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	
	
	
}
