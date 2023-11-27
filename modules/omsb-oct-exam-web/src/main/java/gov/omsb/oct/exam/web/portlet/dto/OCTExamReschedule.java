package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamReschedule {

	private long id;
	private long examDefinationId;
	private long lrUserId;
	private String reason;
	private int rescheduleStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getExamDefinationId() {
		return examDefinationId;
	}
	public void setExamDefinationId(long examDefinationId) {
		this.examDefinationId = examDefinationId;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getRescheduleStatus() {
		return rescheduleStatus;
	}
	public void setRescheduleStatus(int rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}
	
	
}
