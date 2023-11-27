package gov.omsb.registration.web.dto;

public class UserVerification {

	private long id;
	private long personId;
	private String emailAddress;
	private String emailAddressOTP;
	
	private String mobileNumber;
	private String mobileNumberOTP;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailAddressOTP() {
		return emailAddressOTP;
	}
	public void setEmailAddressOTP(String emailAddressOTP) {
		this.emailAddressOTP = emailAddressOTP;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMobileNumberOTP() {
		return mobileNumberOTP;
	}
	public void setMobileNumberOTP(String mobileNumberOTP) {
		this.mobileNumberOTP = mobileNumberOTP;
	}
}