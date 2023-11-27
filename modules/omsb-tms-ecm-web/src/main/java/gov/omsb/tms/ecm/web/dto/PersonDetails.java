package gov.omsb.tms.ecm.web.dto;

public class PersonDetails {

	private long id;
	private String email;
	private String givenNameAsPassport;
	private long personId;
	private String passportNumber;
	private String dateOfBirth;
	private String civilId;
	private long lrUserId;
	
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
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
	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}
	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
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
}
