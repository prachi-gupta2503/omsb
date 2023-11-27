package gov.omsb.exam.web.portlet.dto;

public class ExamDocuments {
	private long id;
	private long examAppealId;
	private String documentTitle;
	private long fileEntryId;
	private String fileName;
	private String fileURL;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public long getExamAppealId() {
		return examAppealId;
	}
	public void setExamAppealId(long examAppealId) {
		this.examAppealId = examAppealId;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
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
}
