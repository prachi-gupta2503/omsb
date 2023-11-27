package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamDocuments {
	private long id;
	private long oCExamAppealStatusId;
	private String docTitle;
	private long fileEntryId;
	private String fileName;
	private String fileURL;
	private long oCExamCancellationStatusId;
	private long oCExamRescheduleStatusId;
	
	
	public long getoCExamRescheduleStatusId() {
		return oCExamRescheduleStatusId;
	}
	public void setoCExamRescheduleStatusId(long oCExamRescheduleStatusId) {
		this.oCExamRescheduleStatusId = oCExamRescheduleStatusId;
	}
	public long getoCExamCancellationStatusId() {
		return oCExamCancellationStatusId;
	}
	public void setoCExamCancellationStatusId(long oCExamCancellationStatusId) {
		this.oCExamCancellationStatusId = oCExamCancellationStatusId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getoCExamAppealStatusId() {
		return oCExamAppealStatusId;
	}
	public void setoCExamAppealStatusId(long oCExamAppealStatusId) {
		this.oCExamAppealStatusId = oCExamAppealStatusId;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
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
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
	
	

}
