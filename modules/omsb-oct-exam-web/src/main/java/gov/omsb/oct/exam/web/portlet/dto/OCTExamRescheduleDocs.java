package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamRescheduleDocs {

	private long id;
	private long oCExamRescheduleStatusId;
	private long fileEntryId;
	private String docTitle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getoCExamRescheduleStatusId() {
		return oCExamRescheduleStatusId;
	}
	public void setoCExamRescheduleStatusId(long oCExamRescheduleStatusId) {
		this.oCExamRescheduleStatusId = oCExamRescheduleStatusId;
	}
	public long getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	
}
