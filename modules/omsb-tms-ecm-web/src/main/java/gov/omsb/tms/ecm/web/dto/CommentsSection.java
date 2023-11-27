package gov.omsb.tms.ecm.web.dto;

import java.util.Date;

public class CommentsSection {

	private String commenterUserName;
	private String roleName;
	private String createDate;
	private String comment;
	
	public String getCommenterUserName() {
		return commenterUserName;
	}
	public void setCommenterUserName(String commenterUserName) {
		this.commenterUserName = commenterUserName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
