package gov.omsb.exam.web.portlet.dto;

public class RegularFees {
	private long id;
	private long examDefinitionId;
	private int noOfAttempts;
	private float regularFee;
	
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
	public int getNoOfAttempts() {
		return noOfAttempts;
	}
	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	public float getRegularFee() {
		return regularFee;
	}
	public void setRegularFee(float regularFee) {
		this.regularFee = regularFee;
	}
	@Override
	public String toString() {
		return "RegularFees [id=" + id + ", examDefinitionId=" + examDefinitionId + ", noOfAttempts=" + noOfAttempts
				+ ", regularFee=" + regularFee + "]";
	}
	
	
	
}
