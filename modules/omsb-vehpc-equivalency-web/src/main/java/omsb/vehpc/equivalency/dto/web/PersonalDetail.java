package omsb.vehpc.equivalency.dto.web;

public class PersonalDetail {
	private String givenNameAsPassport;
	private String applicantSurname;
	private String email;
	private long countryId;
	private String mobileNumber;
	private long nationalityCountryId;
	private long id;
	private long personId;
	private String profession;
	private String professionKey;
	private String dateCreated;
	private String dateModified;
	private String passportNumber;
	private boolean isVerified;
	private String dateOfBirth;
	private long caseRequestId;
	private String countryName;
	private String nationalityCountryName;
	private long primarySpeciality;
	private String professionOther;
	
	public String getProfessionOther() {
		return professionOther;
	}
	
	public void setProfessionOther(String professionOther) {
		this.professionOther = professionOther;
	}
	public long getPrimarySpeciality() {
		return primarySpeciality;
	}

	public void setPrimarySpeciality(long primarySpeciality) {
		this.primarySpeciality = primarySpeciality;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getNationalityCountryId() {
		return nationalityCountryId;
	}

	public void setNationalityCountryId(long nationalityCountryId) {
		this.nationalityCountryId = nationalityCountryId;
	}

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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionKey() {
		return professionKey;
	}

	public void setProfessionKey(String professionKey) {
		this.professionKey = professionKey;
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

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getCaseRequestId() {
		return caseRequestId;
	}

	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonDetail [givenNameAsPassport=");
		builder.append(givenNameAsPassport);
		builder.append(", applicantSurname=");
		builder.append(applicantSurname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", nationalityCountryId=");
		builder.append(nationalityCountryId);
		builder.append(", id=");
		builder.append(id);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", profession=");
		builder.append(profession);
		builder.append(", professionKey=");
		builder.append(professionKey);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", dateModified=");
		builder.append(dateModified);
		builder.append(", passportNumber=");
		builder.append(passportNumber);
		builder.append(", isVerified=");
		builder.append(isVerified);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", caseRequestId=");
		builder.append(caseRequestId);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", nationalityCountryName=");
		builder.append(nationalityCountryName);
		builder.append(", primarySpeciality=");
		builder.append(primarySpeciality);
		
		builder.append("]");
		return builder.toString();
	}

}
