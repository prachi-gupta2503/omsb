package gov.omsb.oct.exam.web.portlet.dto;

public class OCTExamRegistrationTemp {
	
	private long id;
	private long examRegistrationId;
	private String regStatus;
	private String comments;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getExamRegistrationId() {
		return examRegistrationId;
	}
	public void setExamRegistrationId(long examRegistrationId) {
		this.examRegistrationId = examRegistrationId;
	}
	public String getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "OCTExamRegistrationTemp [id=" + id + ", examRegistrationId=" + examRegistrationId + ", regStatus="
				+ regStatus + ", comments=" + comments + "]";
	}




}
