package gov.omsb.faculty.membership.web.dto;

public class PersonalDetailsDTO {
	private long id;
	private String email;
	private String mobile;
	private String givenNameAsPassport;
	private String civilId;
	private String passportNumber;
	private String dateOfBirth;
	private long lrUserId;
	private long personId;
	private String personName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}

	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}

	public String getCivilId() {
		return civilId;
	}

	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public String toString() {
		return "PersonalDetailsDTO [id=" + id + ", email=" + email + ", mobile=" + mobile + ", givenNameAsPassport="
				+ givenNameAsPassport + ", civilId=" + civilId + ", passportNumber=" + passportNumber + ", dateOfBirth="
				+ dateOfBirth + ", lrUserId=" + lrUserId + ", personId=" + personId + ", personName=" + personName
				+ "]";
	}

}