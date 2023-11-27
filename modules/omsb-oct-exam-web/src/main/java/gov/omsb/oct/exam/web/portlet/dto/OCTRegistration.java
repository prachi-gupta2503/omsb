package gov.omsb.oct.exam.web.portlet.dto;

import java.util.List;

public class OCTRegistration {
	
	private long id;
	private long examTypeId;
	private long programId;
	private long oCExamDefinitionId;
	private long oCExamScheduleId;
	private long lrUserId;
	private long examRegistrationId;
	private int noOfAttempts;
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
	private String regStatus;
	private double percentage;
	private String gender;
	private String statusColor;
	private String middleName;
	private String emEmailAddress;
	private List<OCTRegistrationItem> items;
	
	private long oCExamFormNumberId;	
	
	private String userEligibility;	
	private String userRegNumber;	
	private long ocExamRegistrationId;	
	private long oCExamTitleId;	
	private String oCExamTitleName;
		
	private String issuingAuthorityName;	
	private String educationCertificate;	
	private String oCExamTitle;
	private String examDate;	
	private String examTime;	
	private String examEndTime;	
	private String venue;	
	private String locationOnGoogleMap;

	private String documentUrl;

	private String examTitle;
	private long workflowTaskId;
	private long workflowInstanceId;
	private boolean assignedToMe;
	private List<String> transitionNames;

	private float feesPaid;
	private long emergancyContanctId;
	private String internshipFromDate;
	
	private String internshipToDate;
	
	private float reschedulingFeesPercentage;
	
	private String internshipStatus;
	private String langUsedCollege;
	private boolean langUsedOther;
	private long internshipFileEntryId;
	private String internshipFileName;
	private String emobileNumber;
	private String feeType;
	private long PaymentReceiptFileEntryId;
	
	
	

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

	public long getoCExamDefinitionId() {
		return oCExamDefinitionId;
	}

	public void setoCExamDefinitionId(long oCExamDefinitionId) {
		this.oCExamDefinitionId = oCExamDefinitionId;
	}

	public long getoCExamScheduleId() {
		return oCExamScheduleId;
	}

	public void setoCExamScheduleId(long oCExamScheduleId) {
		this.oCExamScheduleId = oCExamScheduleId;
	}

	public long getLrUserId() {
		return lrUserId;
	}

	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}

	public long getExamRegistrationId() {
		return examRegistrationId;
	}

	public void setExamRegistrationId(long examRegistrationId) {
		this.examRegistrationId = examRegistrationId;
	}

	

	public int getNoOfAttempt() {
		return noOfAttempts;
	}

	public void setNoOfAttempt(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
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

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
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
	public long getoCExamFormNumberId() {
		return oCExamFormNumberId;
	}
	public void setoCExamFormNumberId(long oCExamFormNumberId) {
		this.oCExamFormNumberId = oCExamFormNumberId;
	}
	public String getUserEligibility() {
		return userEligibility;
	}
	public void setUserEligibility(String userEligibility) {
		this.userEligibility = userEligibility;
	}
	public String getUserRegNumber() {
		return userRegNumber;
	}
	public void setUserRegNumber(String userRegNumber) {
		this.userRegNumber = userRegNumber;
	}
	public long getOcExamRegistrationId() {
		return ocExamRegistrationId;
	}
	public void setOcExamRegistrationId(long ocExamRegistrationId) {
		this.ocExamRegistrationId = ocExamRegistrationId;
	}
	public long getoCExamTitleId() {
		return oCExamTitleId;
	}
	public void setoCExamTitleId(long oCExamTitleId) {
		this.oCExamTitleId = oCExamTitleId;
	}
	
	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public String getoCExamTitleName() {
		return oCExamTitleName;
	}

	public void setoCExamTitleName(String oCExamTitleName) {
		this.oCExamTitleName = oCExamTitleName;
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
	public String getoCExamTitle() {
		return oCExamTitle;
	}
	public void setoCExamTitle(String oCExamTitle) {
		this.oCExamTitle = oCExamTitle;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getExamEndTime() {
		return examEndTime;
	}
	public void setExamEndTime(String examEndTime) {
		this.examEndTime = examEndTime;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getLocationOnGoogleMap() {
		return locationOnGoogleMap;
	}
	public void setLocationOnGoogleMap(String locationOnGoogleMap) {
		this.locationOnGoogleMap = locationOnGoogleMap;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	

	public List<OCTRegistrationItem> getItems() {
		return items;
	}

	public void setItems(List<OCTRegistrationItem> items) {
		this.items = items;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
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
	
	

	public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	
	public float getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(float feesPaid) {
		this.feesPaid = feesPaid;
	}
	

	public String getEmEmailAddress() {
		return emEmailAddress;
	}

	public void setEmEmailAddress(String emEmailAddress) {
		this.emEmailAddress = emEmailAddress;
	}

	public long getEmergancyContanctId() {
		return emergancyContanctId;
	}

	public void setEmergancyContanctId(long emergancyContanctId) {
		this.emergancyContanctId = emergancyContanctId;
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

	public float getReschedulingFeesPercentage() {
		return reschedulingFeesPercentage;
	}

	public void setReschedulingFeesPercentage(float reschedulingFeesPercentage) {
		this.reschedulingFeesPercentage = reschedulingFeesPercentage;
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
	

	public String getEmobileNumber() {
		return emobileNumber;
	}

	public void setEmobileNumber(String emobileNumber) {
		this.emobileNumber = emobileNumber;
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public long getPaymentReceiptFileEntryId() {
		return PaymentReceiptFileEntryId;
	}

	public void setPaymentReceiptFileEntryId(long paymentReceiptFileEntryId) {
		PaymentReceiptFileEntryId = paymentReceiptFileEntryId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OCTRegistration [id=");
		builder.append(id);
		builder.append(", examTypeId=");
		builder.append(examTypeId);
		builder.append(", programId=");
		builder.append(programId);
		builder.append(", oCExamDefinitionId=");
		builder.append(oCExamDefinitionId);
		builder.append(", oCExamScheduleId=");
		builder.append(oCExamScheduleId);
		builder.append(", lrUserId=");
		builder.append(lrUserId);
		builder.append(", examRegistrationId=");
		builder.append(examRegistrationId);
		builder.append(", noOfAttempts=");
		builder.append(noOfAttempts);
		builder.append(", paymentComplete=");
		builder.append(paymentComplete);
		builder.append(", dateOfPayment=");
		builder.append(dateOfPayment);
		builder.append(", name=");
		builder.append(name);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", relationshipToApplicant=");
		builder.append(relationshipToApplicant);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", consentAuthorize=");
		builder.append(consentAuthorize);
		builder.append(", declaration=");
		builder.append(declaration);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", familyName=");
		builder.append(familyName);
		builder.append(", genderId=");
		builder.append(genderId);
		builder.append(", civilId=");
		builder.append(civilId);
		builder.append(", passportNumber=");
		builder.append(passportNumber);
		builder.append(", passportExpiryDate=");
		builder.append(passportExpiryDate);
		builder.append(", nationality=");
		builder.append(nationality);
		builder.append(", examTypeName=");
		builder.append(examTypeName);
		builder.append(", programName=");
		builder.append(programName);
		builder.append(", registrationStatus=");
		builder.append(registrationStatus);
		builder.append(", examScheduleId=");
		builder.append(examScheduleId);
		builder.append(", examStartDate=");
		builder.append(examStartDate);
		builder.append(", examEndDate=");
		builder.append(examEndDate);
		builder.append(", result=");
		builder.append(result);
		builder.append(", appeared=");
		builder.append(appeared);
		builder.append(", regStatus=");
		builder.append(regStatus);
		builder.append(", percentage=");
		builder.append(percentage);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", statusColor=");
		builder.append(statusColor);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", emEmailAddress=");
		builder.append(emEmailAddress);
		builder.append(", items=");
		builder.append(items);
		builder.append(", oCExamFormNumberId=");
		builder.append(oCExamFormNumberId);
		builder.append(", userEligibility=");
		builder.append(userEligibility);
		builder.append(", userRegNumber=");
		builder.append(userRegNumber);
		builder.append(", ocExamRegistrationId=");
		builder.append(ocExamRegistrationId);
		builder.append(", oCExamTitleId=");
		builder.append(oCExamTitleId);
		builder.append(", oCExamTitleName=");
		builder.append(oCExamTitleName);
		builder.append(", issuingAuthorityName=");
		builder.append(issuingAuthorityName);
		builder.append(", educationCertificate=");
		builder.append(educationCertificate);
		builder.append(", oCExamTitle=");
		builder.append(oCExamTitle);
		builder.append(", examDate=");
		builder.append(examDate);
		builder.append(", examTime=");
		builder.append(examTime);
		builder.append(", examEndTime=");
		builder.append(examEndTime);
		builder.append(", venue=");
		builder.append(venue);
		builder.append(", locationOnGoogleMap=");
		builder.append(locationOnGoogleMap);
		builder.append(", documentUrl=");
		builder.append(documentUrl);
		builder.append(", examTitle=");
		builder.append(examTitle);
		builder.append(", workflowTaskId=");
		builder.append(workflowTaskId);
		builder.append(", workflowInstanceId=");
		builder.append(workflowInstanceId);
		builder.append(", assignedToMe=");
		builder.append(assignedToMe);
		builder.append(", transitionNames=");
		builder.append(transitionNames);
		builder.append(", feesPaid=");
		builder.append(feesPaid);
		builder.append(", emergancyContanctId=");
		builder.append(emergancyContanctId);
		builder.append(", internshipFromDate=");
		builder.append(internshipFromDate);
		builder.append(", internshipToDate=");
		builder.append(internshipToDate);
		builder.append(", reschedulingFeesPercentage=");
		builder.append(reschedulingFeesPercentage);
		builder.append(", internshipStatus=");
		builder.append(internshipStatus);
		builder.append(", langUsedCollege=");
		builder.append(langUsedCollege);
		builder.append(", langUsedOther=");
		builder.append(langUsedOther);
		builder.append(", internshipFileEntryId=");
		builder.append(internshipFileEntryId);
		builder.append(", internshipFileName=");
		builder.append(internshipFileName);
		builder.append(", emobileNumber=");
		builder.append(emobileNumber);
		builder.append(", feeType=");
		builder.append(feeType);
		builder.append("]");
		return builder.toString();
	}
	
}
