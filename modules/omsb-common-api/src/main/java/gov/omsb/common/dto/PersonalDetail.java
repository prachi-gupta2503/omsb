package gov.omsb.common.dto;

import java.util.List;

/**
 * @author SMohammed
 *
 */
public class PersonalDetail {
	private long id;
	private String applicantSurname;
	private String fullNameAr;
	private long caseRequestId;
	private String componentId;
	private long countryId;
	private String email;
	private String givenNameAsPassport;
	private String mobileNumber;
	private boolean mobileNumberVerified;
	private long nationalityCountryId;
	private long passportIssuingCountryId;
	private long personId;
	private String profession;
	private String primarySpeciality;
	private String secondarySpeciality;
	private String passportNumber;
	private String dateOfBirth;
	private String passportExpiryDate;
	private long genderId;
	private long lrUserId;

	private String registrationSource;
	private String registrationStatus;

	private boolean pkiVerified;
	private boolean omsbAssociated;

	private long omsbRole;
	private String omsbService;

	private boolean declaration;
	private boolean agreed;

	private List<FileUploadDetail> fileUploadDetails;
	
	private String givenNameAsPerPassport;
	private String personalMail;
	private long nationalityCntyId;
	
	private String countryCode;
	private String countryIsoCode;
	
	//Transient Variables
	private String passportIssuingCountryName;
	private String gender;
	private String nationalityCountryName;
	
	private String secondarySpecialityOther;
	private String primarySpecialityOther;
	private String professionOther;
	
	private boolean personalDetailVerified;
	
	private long civilCardFrontPhotoId;
	private long civilCardBackPhotoId;
	private long passportPhotoId;
	private long cvDocumentId;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplicantSurname() {
		return applicantSurname;
	}

	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}

	public long getCaseRequestId() {
		return caseRequestId;
	}

	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isMobileNumberVerified() {
		return mobileNumberVerified;
	}

	public void setMobileNumberVerified(boolean mobileNumberVerified) {
		this.mobileNumberVerified = mobileNumberVerified;
	}

	public long getNationalityCountryId() {
		return nationalityCountryId;
	}

	public void setNationalityCountryId(long nationalityCountryId) {
		this.nationalityCountryId = nationalityCountryId;
	}

	public long getPassportIssuingCountryId() {
		return passportIssuingCountryId;
	}

	public void setPassportIssuingCountryId(long passportIssuingCountryId) {
		this.passportIssuingCountryId = passportIssuingCountryId;
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

	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public long getGenderId() {
		return genderId;
	}

	public void setGenderId(long genderId) {
		this.genderId = genderId;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public boolean isPkiVerified() {
		return pkiVerified;
	}

	public void setPkiVerified(boolean pkiVerified) {
		this.pkiVerified = pkiVerified;
	}

	public boolean isOmsbAssociated() {
		return omsbAssociated;
	}

	public void setOmsbAssociated(boolean omsbAssociated) {
		this.omsbAssociated = omsbAssociated;
	}

	public long getOmsbRole() {
		return omsbRole;
	}

	public void setOmsbRole(long omsbRole) {
		this.omsbRole = omsbRole;
	}

	public String getOmsbService() {
		return omsbService;
	}

	public void setOmsbService(String omsbService) {
		this.omsbService = omsbService;
	}

	public boolean isDeclaration() {
		return declaration;
	}

	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public List<FileUploadDetail> getFileUploadDetails() {
		return fileUploadDetails;
	}

	public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}

	public String getPassportIssuingCountryName() {
		return passportIssuingCountryName;
	}

	public void setPassportIssuingCountryName(String passportIssuingCountryName) {
		this.passportIssuingCountryName = passportIssuingCountryName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationalityCountryName() {
		return nationalityCountryName;
	}

	public void setNationalityCountryName(String nationalityCountryName) {
		this.nationalityCountryName = nationalityCountryName;
	}

	public String getGivenNameAsPerPassport() {
		return givenNameAsPerPassport;
	}

	public void setGivenNameAsPerPassport(String givenNameAsPerPassport) {
		this.givenNameAsPerPassport = givenNameAsPerPassport;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public long getNationalityCntyId() {
		return nationalityCntyId;
	}

	public void setNationalityCntyId(long nationalityCntyId) {
		this.nationalityCntyId = nationalityCntyId;
	}

	public String getFullNameAr() {
		return fullNameAr;
	}

	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
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

	public boolean isPersonalDetailVerified() {
		return personalDetailVerified;
	}

	public void setPersonalDetailVerified(boolean personalDetailVerified) {
		this.personalDetailVerified = personalDetailVerified;
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
}