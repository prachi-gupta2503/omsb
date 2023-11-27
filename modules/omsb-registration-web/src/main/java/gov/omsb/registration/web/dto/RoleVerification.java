package gov.omsb.registration.web.dto;

public class RoleVerification {

	private long id;
	private long roleId;
	private long profileVerificationRoleId;
	private long roleVerificationUserId;
	private boolean verificationRequired;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getProfileVerificationRoleId() {
		return profileVerificationRoleId;
	}
	public void setProfileVerificationRoleId(long profileVerificationRoleId) {
		this.profileVerificationRoleId = profileVerificationRoleId;
	}
	public long getRoleVerificationUserId() {
		return roleVerificationUserId;
	}
	public void setRoleVerificationUserId(long roleVerificationUserId) {
		this.roleVerificationUserId = roleVerificationUserId;
	}
	public boolean isVerificationRequired() {
		return verificationRequired;
	}
	public void setVerificationRequired(boolean verificationRequired) {
		this.verificationRequired = verificationRequired;
	}
}