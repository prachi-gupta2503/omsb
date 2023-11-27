package gov.omsb.exam.web.portlet.dto;

public class TraineeItem {
	private long lrUserId;
	private long programId;
	private String roleId;
	private String functionId;
	private String sectionId;
	private boolean profileVerifiedStatusId;
	private boolean roleVerifiedStatusId;
	private String departmentId;
	private String committeeId;
	private String name;
	private String registrationStatus;
	private long examDefinitionId;
	private long examTypeId;
	private String examTypeName;
	private String programName;
	private ExamSchedule examSchedule;
	private String dateOfBirth;
	private String passportNumber;
	private String nationality;
	private String gender;
	private String emailAddress;
	private String mobileNumber;
	private String paymentReceiptUrl;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(long lrUserId) {
		this.lrUserId = lrUserId;
	}
	public long getProgramId() {
		return programId;
	}
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public void setCommitteeId(String committeeId) {
		this.committeeId = committeeId;
	}
	public boolean getProfileVerifiedStatusId() {
		return profileVerifiedStatusId;
	}
	public void setProfileVerifiedStatusId(boolean profileVerifiedStatusId) {
		this.profileVerifiedStatusId = profileVerifiedStatusId;
	}
	public boolean getRoleVerifiedStatusId() {
		return roleVerifiedStatusId;
	}
	public void setRoleVerifiedStatusId(boolean roleVerifiedStatusId) {
		this.roleVerifiedStatusId = roleVerifiedStatusId;
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	public String getCommitteeId() {
		return committeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public long getExamDefinitionId() {
		return examDefinitionId;
	}
	public void setExamDefinitionId(long examDefinitionId) {
		this.examDefinitionId = examDefinitionId;
	}
	public long getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(long examTypeId) {
		this.examTypeId = examTypeId;
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
	public ExamSchedule getExamSchedule() {
		return examSchedule;
	}
	public void setExamSchedule(ExamSchedule examSchedule) {
		this.examSchedule = examSchedule;
	}
	public String getPaymentReceiptUrl() {
		return paymentReceiptUrl;
	}
	public void setPaymentReceiptUrl(String paymentReceiptUrl) {
		this.paymentReceiptUrl = paymentReceiptUrl;
	}
	
	
}
