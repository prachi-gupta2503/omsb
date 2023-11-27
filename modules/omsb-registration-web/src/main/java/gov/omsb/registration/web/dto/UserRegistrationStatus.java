package gov.omsb.registration.web.dto;

public class UserRegistrationStatus {
	
	private long id;
	private long lrUserId;
	private long personId;
	private String userStatus;
	private String comment;
	private long userMetaDataId;
	private String dateModified;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getUserMetaDataId() {
		return userMetaDataId;
	}
	public void setUserMetaDataId(long userMetaDataId) {
		this.userMetaDataId = userMetaDataId;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
}
