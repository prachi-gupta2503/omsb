package gov.omsb.faculty.membership.web.dto;

public class DocumentInfoDTO {

	private long id;
	private long fileEntryID;
	private String dFFileName;
	private String documentType;
	private long personId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "DocumentInfoDTO [id=" + id + ", fileEntryID=" + fileEntryID + ", dFFileName=" + dFFileName
				+ ", documentType=" + documentType + ", personId=" + personId + "]";
	}
}