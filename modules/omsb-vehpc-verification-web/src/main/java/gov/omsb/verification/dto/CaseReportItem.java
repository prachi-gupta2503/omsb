package gov.omsb.verification.dto;

public class CaseReportItem {
	
	private long caseRequestId;
    private long fileEntryId;
    private String fileName;
    private long personId;
	public long getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
    	
	
}
