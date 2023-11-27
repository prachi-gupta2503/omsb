package gov.omsb.vehpc.appeal.dto.web;

public class EquivalencyCertificate {
	private long id;
	private String fileName;
	private long fileEntryId;
	private long equivalencyRequestId;
	private long equivalencyAppealId;
	private String equivalencyFileUrl;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public long getEquivalencyAppealId() {
		return equivalencyAppealId;
	}

	public void setEquivalencyAppealId(long equivalencyAppealId) {
		this.equivalencyAppealId = equivalencyAppealId;
	}

	public String getEquivalencyFileUrl() {
		return equivalencyFileUrl;
	}

	public void setEquivalencyFileUrl(String equivalencyFileUrl) {
		this.equivalencyFileUrl = equivalencyFileUrl;
	}
	
	

}
