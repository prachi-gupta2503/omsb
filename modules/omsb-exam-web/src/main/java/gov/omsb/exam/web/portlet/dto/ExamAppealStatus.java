package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class ExamAppealStatus {
	private long id;
	private long examAppealId;
	private String reason;
	private long lrUserId;
	private long appealStatus;
	private boolean admin;
	private String name;
	private List<ExamDocuments> examDocuments;
	
	@Override
	public String toString() {
		return "ExamAppealStatus [id=" + id + ", examAppealId=" + examAppealId + ", reason=" + reason + ", lrUserId="
				+ lrUserId + ", appealStatus=" + appealStatus + ", isAdmin=" + admin + ", name=" + name
				+ ", examDocuments=" + examDocuments + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ExamDocuments> getExamDocuments() {
		return examDocuments;
	}
	public void setExamDocuments(List<ExamDocuments> examDocuments) {
		this.examDocuments = examDocuments;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getExamAppealId() {
		return examAppealId;
	}
	public void setExamAppealId(long examAppealId) {
		this.examAppealId = examAppealId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public long getAppealStatus() {
		return appealStatus;
	}
	public void setAppealStatus(long appealStatus) {
		this.appealStatus = appealStatus;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
