package gov.omsb.registration.web.dto;

public class ServiceVerification {

	private long id;
	private String service;
	private boolean verificationRequired;
	private long profileVerificationRoleId;
	private long serviceVerificationRoleId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public boolean isVerificationRequired() {
		return verificationRequired;
	}
	public void setVerificationRequired(boolean verificationRequired) {
		this.verificationRequired = verificationRequired;
	}
	public long getProfileVerificationRoleId() {
		return profileVerificationRoleId;
	}
	public void setProfileVerificationRoleId(long profileVerificationRoleId) {
		this.profileVerificationRoleId = profileVerificationRoleId;
	}
	public long getServiceVerificationRoleId() {
		return serviceVerificationRoleId;
	}
	public void setServiceVerificationRoleId(long serviceVerificationRoleId) {
		this.serviceVerificationRoleId = serviceVerificationRoleId;
	}
}
