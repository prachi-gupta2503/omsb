package gov.omsb.tms.custom.dto;

import java.util.Date;

public class ECMembershipRequestStateDTO {
	
	String comments;
	Date createDate;
	String potentialECMember;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPotentialECMember() {
		return potentialECMember;
	}
	public void setPotentialECMember(String potentialECMember) {
		this.potentialECMember = potentialECMember;
	}
	@Override
	public String toString() {
		return "ECMembershipRequestStateDTO [comments=" + comments + ", createDate=" + createDate
				+ ", potentialECMember=" + potentialECMember + "]";
	} 
	
	

}
