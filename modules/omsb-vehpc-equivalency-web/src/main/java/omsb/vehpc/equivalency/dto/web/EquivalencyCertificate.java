package omsb.vehpc.equivalency.dto.web;

public class EquivalencyCertificate {
	private long id;
	private String fileName;
	private String fileEntryId;
	private long equivalencyRequestId;
	private long equivalencyAppealId;

	public long getEquivalencyAppealId() {
		return equivalencyAppealId;
	}

	public void setEquivalencyAppealId(long equivalencyAppealId) {
		this.equivalencyAppealId = equivalencyAppealId;
	}

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

	public String getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

}
