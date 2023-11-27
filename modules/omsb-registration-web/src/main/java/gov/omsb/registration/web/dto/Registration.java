package gov.omsb.registration.web.dto;

import java.util.List;

import gov.omsb.common.dto.EducationDetail;

public class Registration {
	
	private long personId;
	private String personName;
	private String civilId;
	private String dateOfBirth;
	private String passportNo;
	private long countryIdOfIssue;
	private String passportExpiryDate;
	private String firstName;
	private String lastName;
	private String fullName;
	private String fullNameAr;
	private String emailAddress;
	private String mobileNumber;
	private long genderId;
	private long nationalityId;
	private long photoId;
	private String profession;
	private String primarySpeciality;
	private String secondarySpeciality;
	private String userName;
	private String password;
	private String reTypePassword;
	private long lrUserId;
	
	private boolean emailAddressVerified;
	private boolean mobileNumberVerified;

	private String registrationStatus;
	private String registrationStatusColor;
	private String dateCreated;
	
	private EducationDetail educationalDetail;
	
	private String workflowStatus;
	private long workflowId;
	
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private List<String> transitionNames;
	private String givenNameAsPassport;
	
	private String secondarySpecialityOther;
	private String primarySpecialityOther;
	private String professionOther;
	
	private String countryCode;
	private String countryIsoCode;
	
	private String registrationSource;
	
	private String omsbAssociated;
	
	private long civilCardFrontPhotoId;
	private long civilCardBackPhotoId;
	private long passportPhotoId;
	private long cvDocumentId;

	private String lastVerified;
	private String lastVerifiedStatusColor;
	private String dateModified;

	public String getSecondarySpecialityOther() {
		return secondarySpecialityOther;
	}
	public void setSecondarySpecialityOther(String secondarySpecialityOther) {
		this.secondarySpecialityOther = secondarySpecialityOther;
	}
	public String getPrimarySpecialityOther() {
		return primarySpecialityOther;
	}
	public void setPrimarySpecialityOther(String primarySpecialityOther) {
		this.primarySpecialityOther = primarySpecialityOther;
	}
	public String getProfessionOther() {
		return professionOther;
	}
	public void setProfessionOther(String professionOther) {
		this.professionOther = professionOther;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public long getCountryIdOfIssue() {
		return countryIdOfIssue;
	}
	public void setCountryIdOfIssue(long countryIdOfIssue) {
		this.countryIdOfIssue = countryIdOfIssue;
	}
	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}
	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getGenderId() {
		return genderId;
	}
	public void setGenderId(long genderId) {
		this.genderId = genderId;
	}
	public long getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(long nationalityId) {
		this.nationalityId = nationalityId;
	}
	public long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPrimarySpeciality() {
		return primarySpeciality;
	}
	public void setPrimarySpeciality(String primarySpeciality) {
		this.primarySpeciality = primarySpeciality;
	}
	public String getSecondarySpeciality() {
		return secondarySpeciality;
	}
	public void setSecondarySpeciality(String secondarySpeciality) {
		this.secondarySpeciality = secondarySpeciality;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReTypePassword() {
		return reTypePassword;
	}
	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public boolean isEmailAddressVerified() {
		return emailAddressVerified;
	}
	public void setEmailAddressVerified(boolean emailAddressVerified) {
		this.emailAddressVerified = emailAddressVerified;
	}
	public boolean isMobileNumberVerified() {
		return mobileNumberVerified;
	}
	public void setMobileNumberVerified(boolean mobileNumberVerified) {
		this.mobileNumberVerified = mobileNumberVerified;
	}
	public EducationDetail getEducationalDetail() {
		return educationalDetail;
	}
	public void setEducationalDetail(EducationDetail educationalDetail) {
		this.educationalDetail = educationalDetail;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public String getRegistrationStatusColor() {
		return registrationStatusColor;
	}
	public void setRegistrationStatusColor(String registrationStatusColor) {
		this.registrationStatusColor = registrationStatusColor;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getWorkflowStatus() {
		return workflowStatus;
	}
	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}
	public long getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}
	public long getWorkflowTaskId() {
		return workflowTaskId;
	}
	public void setWorkflowTaskId(long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}
	public long getWorkflowInstanceId() {
		return workflowInstanceId;
	}
	public void setWorkflowInstanceId(long workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}
	public boolean isAssignedToMe() {
		return assignedToMe;
	}
	public void setAssignedToMe(boolean assignedToMe) {
		this.assignedToMe = assignedToMe;
	}
	public List<String> getTransitionNames() {
		return transitionNames;
	}
	public void setTransitionNames(List<String> transitionNames) {
		this.transitionNames = transitionNames;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullNameAr() {
		return fullNameAr;
	}
	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
	}
	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}
	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryIsoCode() {
		return countryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}
	public String getRegistrationSource() {
		return registrationSource;
	}
	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}
	public String getOmsbAssociated() {
		return omsbAssociated;
	}
	public void setOmsbAssociated(String omsbAssociated) {
		this.omsbAssociated = omsbAssociated;
	}
	public long getCivilCardFrontPhotoId() {
		return civilCardFrontPhotoId;
	}
	public void setCivilCardFrontPhotoId(long civilCardFrontPhotoId) {
		this.civilCardFrontPhotoId = civilCardFrontPhotoId;
	}
	public long getCivilCardBackPhotoId() {
		return civilCardBackPhotoId;
	}
	public void setCivilCardBackPhotoId(long civilCardBackPhotoId) {
		this.civilCardBackPhotoId = civilCardBackPhotoId;
	}
	public long getPassportPhotoId() {
		return passportPhotoId;
	}
	public void setPassportPhotoId(long passportPhotoId) {
		this.passportPhotoId = passportPhotoId;
	}
	public long getCvDocumentId() {
		return cvDocumentId;
	}
	public void setCvDocumentId(long cvDocumentId) {
		this.cvDocumentId = cvDocumentId;
	}
	public String getLastVerified() {
		return lastVerified;
	}
	public void setLastVerified(String lastVerified) {
		this.lastVerified = lastVerified;
	}
	public String getLastVerifiedStatusColor() {
		return lastVerifiedStatusColor;
	}
	public void setLastVerifiedStatusColor(String lastVerifiedStatusColor) {
		this.lastVerifiedStatusColor = lastVerifiedStatusColor;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
}
