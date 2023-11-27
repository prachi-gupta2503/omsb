package gov.omsb.exam.web.portlet.dto;

import java.util.List;

import gov.omsb.common.dto.EducationDetail;

public class Registration {

	private long id;
	private long examTypeId;
	private long programId;
	private long examDefinitionId;
	private long lrUserId;
	private long examRegistrationId;
	private int noOfAttempt;
	private boolean paymentComplete;
	private String dateOfPayment;
	private String name;
	private String telephone;
	private String mobileNumber;
	private String relationshipToApplicant;
	private String emailAddress;
	private boolean consentAuthorize;
	private boolean declaration;
	private String dateOfBirth;
	private String firstName;
	private String familyName;
	private long genderId;
	private String civilId;
	private String passportNumber;
	private String passportExpiryDate;
	private String nationality;
	private String examTypeName;
	private String programName;
	private String registrationStatus;
	private long examScheduleId;
	private String examStartDate;
	private String examEndDate;
	private String result;
	private String appeared;
	private double percentage;
	private String gender;

	private float feesPaid;

	private String issuingAuthorityName;
	private String educationCertificate;
	private String documentUrl;
	private String emEmailAddress;

	private String internshipFromDate;

	private String internshipToDate;

	private String internshipStatus;
	private String langUsedCollege;
	private boolean langUsedOther;
	private long internshipFileEntryId;
	private String internshipFileName;
	private String feeType;
	private String profileUrl;
	private String UserRegNumber;
	private long paymentReceiptFileEntryId;

	public long getPaymentReceiptFileEntryId() {
		return paymentReceiptFileEntryId;
	}

	public void setPaymentReceiptFileEntryId(long paymentReceiptFileEntryId) {
		this.paymentReceiptFileEntryId = paymentReceiptFileEntryId;
	}

	private List<RegistrationItem> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public long getExamDefinitionId() {
		return examDefinitionId;
	}

	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public int getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(int noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public boolean isPaymentComplete() {
		return paymentComplete;
	}

	public void setPaymentComplete(boolean paymentComplete) {
		this.paymentComplete = paymentComplete;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRelationshipToApplicant() {
		return relationshipToApplicant;
	}

	public void setRelationshipToApplicant(String relationshipToApplicant) {
		this.relationshipToApplicant = relationshipToApplicant;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isConsentAuthorize() {
		return consentAuthorize;
	}

	public void setConsentAuthorize(boolean consentAuthorize) {
		this.consentAuthorize = consentAuthorize;
	}

	public boolean isDeclaration() {
		return declaration;
	}

	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}

	public long getExamRegistrationId() {
		return examRegistrationId;
	}

	public void setExamRegistrationId(long examRegistrationId) {
		this.examRegistrationId = examRegistrationId;
	}

	public List<RegistrationItem> getItems() {
		return items;
	}

	public void setItems(List<RegistrationItem> items) {
		this.items = items;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public long getGenderId() {
		return genderId;
	}

	public void setGenderId(long genderId) {
		this.genderId = genderId;
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

	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getExamTypeName() {
		return examTypeName;
	}

	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public long getExamScheduleId() {
		return examScheduleId;
	}

	public void setExamScheduleId(long examScheduleId) {
		this.examScheduleId = examScheduleId;
	}

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAppeared() {
		return appeared;
	}

	public void setAppeared(String appeared) {
		this.appeared = appeared;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(float feesPaid) {
		this.feesPaid = feesPaid;
	}

	public String getIssuingAuthorityName() {
		return issuingAuthorityName;
	}

	public void setIssuingAuthorityName(String issuingAuthorityName) {
		this.issuingAuthorityName = issuingAuthorityName;
	}

	public String getEducationCertificate() {
		return educationCertificate;
	}

	public void setEducationCertificate(String educationCertificate) {
		this.educationCertificate = educationCertificate;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getEmEmailAddress() {
		return emEmailAddress;
	}

	public void setEmEmailAddress(String emEmailAddress) {
		this.emEmailAddress = emEmailAddress;
	}

	public String getInternshipFromDate() {
		return internshipFromDate;
	}

	public void setInternshipFromDate(String internshipFromDate) {
		this.internshipFromDate = internshipFromDate;
	}

	public String getInternshipToDate() {
		return internshipToDate;
	}

	public void setInternshipToDate(String internshipToDate) {
		this.internshipToDate = internshipToDate;
	}

	public String getInternshipStatus() {
		return internshipStatus;
	}

	public void setInternshipStatus(String internshipStatus) {
		this.internshipStatus = internshipStatus;
	}

	public String getLangUsedCollege() {
		return langUsedCollege;
	}

	public void setLangUsedCollege(String langUsedCollege) {
		this.langUsedCollege = langUsedCollege;
	}

	public boolean isLangUsedOther() {
		return langUsedOther;
	}

	public void setLangUsedOther(boolean langUsedOther) {
		this.langUsedOther = langUsedOther;
	}

	public long getInternshipFileEntryId() {
		return internshipFileEntryId;
	}

	public void setInternshipFileEntryId(long internshipFileEntryId) {
		this.internshipFileEntryId = internshipFileEntryId;
	}

	public String getInternshipFileName() {
		return internshipFileName;
	}

	public void setInternshipFileName(String internshipFileName) {
		this.internshipFileName = internshipFileName;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getUserRegNumber() {
		return UserRegNumber;
	}

	public void setUserRegNumber(String userRegNumber) {
		UserRegNumber = userRegNumber;
	}
	

}
