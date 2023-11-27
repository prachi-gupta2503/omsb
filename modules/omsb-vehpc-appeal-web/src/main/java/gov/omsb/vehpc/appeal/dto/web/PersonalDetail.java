package gov.omsb.vehpc.appeal.dto.web;

import java.util.ArrayList;
import java.util.List;

import gov.omsb.common.dto.FileUploadDetail;

public class PersonalDetail {
		private String givenNameAsPassport;
	    private String applicantSurname;
	    private String dateOfBirth;
	    private String passportNumber;
	    private String personalMail;
	    private Integer countryId;
	    private Integer countryCodeIsd;
	    private String mobileNumber;
	    private String passportIssuingCountryId;
	    private String passportIssuingCountryName;
	    private String nationality;
	    private Integer nationalityCntyId;
	    private long id;
	    private String personId;
	    
		public long getId() {
			return id;
		}
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
		}
		public void setId(long id) {
			this.id = id;
		}
	    private List<FileUploadDetail> fileUploadDetails = new ArrayList<>();
	    
		
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
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getPassportNumber() {
			return passportNumber;
		}
		public void setPassportNumber(String passportNumber) {
			this.passportNumber = passportNumber;
		}
		public String getPersonalMail() {
			return personalMail;
		}
		public void setPersonalMail(String personalMail) {
			this.personalMail = personalMail;
		}
		public Integer getCountryId() {
			return countryId;
		}
		public void setCountryId(Integer countryId) {
			this.countryId = countryId;
		}
		public Integer getCountryCodeIsd() {
			return countryCodeIsd;
		}
		public void setCountryCodeIsd(Integer countryCodeIsd) {
			this.countryCodeIsd = countryCodeIsd;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getPassportIssuingCountryId() {
			return passportIssuingCountryId;
		}
		public void setPassportIssuingCountryId(String passportIssuingCountryId) {
			this.passportIssuingCountryId = passportIssuingCountryId;
		}
		public String getPassportIssuingCountryName() {
			return passportIssuingCountryName;
		}
		public void setPassportIssuingCountryName(String passportIssuingCountryName) {
			this.passportIssuingCountryName = passportIssuingCountryName;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Integer getNationalityCntyId() {
			return nationalityCntyId;
		}
		public void setNationalityCntyId(Integer nationalityCntyId) {
			this.nationalityCntyId = nationalityCntyId;
		}
		public List<FileUploadDetail> getFileUploadDetails() {
			return fileUploadDetails;
		}
		public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
			this.fileUploadDetails = fileUploadDetails;
		}
	}
