package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamRescheduleStatus {

	private long id;
	private long oCExamRescheduleId;
	private long lrUserId;
	private String reason;
	private String rescheduleStatus;
	private boolean admin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getoCExamRescheduleId() {
		return oCExamRescheduleId;
	}
	public void setoCExamRescheduleId(long oCExamRescheduleId) {
		this.oCExamRescheduleId = oCExamRescheduleId;
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
	public String getRescheduleStatus() {
		return rescheduleStatus;
	}
	public void setRescheduleStatus(String rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
