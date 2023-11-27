package gov.omsb.exam.web.portlet.dto;

import java.util.List;

public class ExamWithdrawalStatus {
	private long id;
	private long examWithdrawalId;
	private long lrUserId;
	private String reason;
	private String withdrawalStatus;
	private String isAdmin;
	private String name;
	private List<ExamDocuments> examDocuments;
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
	public long getExamWithdrawalId() {
		return examWithdrawalId;
	}
	public void setExamWithdrawalId(long examWithdrawalId) {
		this.examWithdrawalId = examWithdrawalId;
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
	public String getWithdrawalStatus() {
		return withdrawalStatus;
	}
	public void setWithdrawalStatus(String withdrawalStatus) {
		this.withdrawalStatus = withdrawalStatus;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
