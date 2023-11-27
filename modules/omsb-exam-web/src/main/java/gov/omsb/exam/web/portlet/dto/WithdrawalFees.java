package gov.omsb.exam.web.portlet.dto;

public class WithdrawalFees {
	private long id;
	private long examDefinitionId;
	private String noOfDays;
	private String noOfDaysText;
	private float withdrawalFeesPercentage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getExamDefinitionId() {
		return examDefinitionId;
	}
	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	public float getWithdrawalFeesPercentage() {
		return withdrawalFeesPercentage;
	}
	public void setWithdrawalFeesPercentage(float withdrawalFeesPercentage) {
		this.withdrawalFeesPercentage = withdrawalFeesPercentage;
	}
	public String getNoOfDaysText() {
		return noOfDaysText;
	}
	public void setNoOfDaysText(String noOfDaysText) {
		this.noOfDaysText = noOfDaysText;
	}
}
