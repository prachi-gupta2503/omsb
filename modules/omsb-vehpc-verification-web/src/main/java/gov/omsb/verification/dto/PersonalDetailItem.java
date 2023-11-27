package gov.omsb.verification.dto;

import java.util.List;

public class PersonalDetailItem {
	private String dateCreated;
	private String dateModified;
	private String passportNumber;
	private String givenNameAsPassport;
	private String applicantSurname;
	private boolean isVerified;
	private long mobileNumber;
	private String dateOfBirth;
	private String email;
	private long personId;
	private long caseRequestId;   
	private long countryId;
	private String countryName;
	private long id;
	private long nationalityCountryId;
	private String nationalityCountryName;
	private List<DocumentDetailCertificate> items;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	
	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}
	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}
	public String getApplicantSurname() {
		return applicantSurname;
	}
	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public long getNationalityCountryId() {
		return nationalityCountryId;
	}
	public void setNationalityCountryId(long nationalityCountryId) {
		this.nationalityCountryId = nationalityCountryId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getNationalityCountryName() {
		return nationalityCountryName;
	}
	public void setNationalityCountryName(String nationalityCountryName) {
		this.nationalityCountryName = nationalityCountryName;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getCountryId() {
		return countryId;
	}
	public List<DocumentDetailCertificate> getItems() {
		return items;
	}
	public void setItems(List<DocumentDetailCertificate> items) {
		this.items = items;
	}
	
	
}
