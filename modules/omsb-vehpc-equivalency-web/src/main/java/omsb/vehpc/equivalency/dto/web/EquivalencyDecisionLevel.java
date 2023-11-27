package omsb.vehpc.equivalency.dto.web;

public class EquivalencyDecisionLevel {
	private long documentInfoId;
	private long eqRequestId;
	private String comments;
	private EquivalencyLevel equivalencyLevelId;
	private long id;
	private long fileEntryId;
	private String fileName;
	private String fileUrl;
	private String equivalencyLevelReason;
	private String equivalencyLevelOtherReason;
	private boolean isEquatedDoc;

	public String getEquivalencyLevelOtherReason() {
		return equivalencyLevelOtherReason;
	}

	public void setEquivalencyLevelOtherReason(String equivalencyLevelOtherReason) {
		this.equivalencyLevelOtherReason = equivalencyLevelOtherReason;
	}

	public boolean isEquatedDoc() {
		return isEquatedDoc;
	}

	public void setEquatedDoc(boolean isEquatedDoc) {
		this.isEquatedDoc = isEquatedDoc;
	}

	public String getEquivalencyLevelReason() {
		return equivalencyLevelReason;
	}

	public void setEquivalencyLevelReason(String equivalencyLevelReason) {
		this.equivalencyLevelReason = equivalencyLevelReason;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDocumentInfoId() {
		return documentInfoId;
	}

	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}

	public long getEqRequestId() {
		return eqRequestId;
	}

	public void setEqRequestId(long eqRequestId) {
		this.eqRequestId = eqRequestId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public EquivalencyLevel getEquivalencyLevelId() {
		return equivalencyLevelId;
	}

	public void setEquivalencyLevelId(EquivalencyLevel equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyDecisionLevel [documentInfoId=");
		builder.append(documentInfoId);
		builder.append(", eqRequestId=");
		builder.append(eqRequestId);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", equivalencyLevelId=");
		builder.append(equivalencyLevelId);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fileEntryId=");
		builder.append(fileEntryId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", equivalencyLevelReason=");
		builder.append(equivalencyLevelReason);
		builder.append("]");
		return builder.toString();
	}

}
