package omsb.vehpc.equivalency.dto.web;

public class CaseReport {
	private long id;
	private String fileName;
	private long caseRequestId;
	private long personId;
	private long fileEntryId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public long getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CaseReport [id=");
		builder.append(id);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", caseRequestId=");
		builder.append(caseRequestId);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", fileEntryId=");
		builder.append(fileEntryId);
		builder.append("]");
		return builder.toString();
	}
}
