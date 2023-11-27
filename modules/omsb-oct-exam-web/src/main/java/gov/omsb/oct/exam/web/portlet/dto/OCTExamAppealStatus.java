package gov.omsb.oct.exam.web.portlet.dto;

import java.util.List;


public class OCTExamAppealStatus {
	
	private long id;
	private long oCExamAppealId;
	private String reason;
	private long lrUserId;
	private long appealStatus;
	private boolean admin;
	private String name;
	private long ocExamCancellationId;
	private String cancellationStatusId;
	private long oCExamRescheduleId;
	private String rescheduleStatus;
	
	public long getoCExamRescheduleId() {
		return oCExamRescheduleId;
	}
	public void setoCExamRescheduleId(long oCExamRescheduleId) {
		this.oCExamRescheduleId = oCExamRescheduleId;
	}
	public String getRescheduleStatus() {
		return rescheduleStatus;
	}
	public void setRescheduleStatus(String rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}
	public long getOcExamCancellationId() {
		return ocExamCancellationId;
	}
	public void setOcExamCancellationId(long ocExamCancellationId) {
		this.ocExamCancellationId = ocExamCancellationId;
	}
	public String getCancellationStatusId() {
		return cancellationStatusId;
	}
	public void setCancellationStatusId(String cancellationStatusId) {
		this.cancellationStatusId = cancellationStatusId;
	}
	private List<OCTExamDocuments> examDocuments;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getoCExamAppealId() {
		return oCExamAppealId;
	}
	public void setoCExamAppealId(long oCExamAppealId) {
		this.oCExamAppealId = oCExamAppealId;
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
	public List<OCTExamDocuments> getExamDocuments() {
		return examDocuments;
	}
	public void setExamDocuments(List<OCTExamDocuments> examDocuments) {
		this.examDocuments = examDocuments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
