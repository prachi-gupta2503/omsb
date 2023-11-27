package gov.omsb.common.dto;

import java.util.ArrayList;
import java.util.List;

public class EducationDetail {

	private Integer issuingAuthorityId;
	private String issuingAuthorityName;
	private Integer issuingAuthorityFeeAmount;
	private Object issuingAuthorityFeeCurrency;
	private Object borneBy;
	private Object feeCategory;
	private String issuingAuthorityCountry;
	private Integer issuingAuthorityCountryId;
	private String qualificationAttained;
	private String applicantsNameAsPerDocument;
	private String modeOfStudy;
	private Integer modeOfStudyId;
	private Integer durationInYears;
	private Integer durationInMonths;
	private String qualificationConferredDate;
	private String remarks;
	private String qualificationOther;
	private long equivalencyRequestId;
	private List<FileUploadDetail> fileUploadDetails = new ArrayList<>();
	private long id;
	
	private long lRUserId;
	private long personId;
	private String gpa;
    private int yearOfGraduation;
    private String dateOfGraduation;
	
	private DocumentInfo documentInfo;
	private boolean educationDetailVerified;
	private String documentUrl;
	private String educationCertificate;
	public String getQualificationOther() {
		return qualificationOther;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getEducationCertificate() {
		return educationCertificate;
	}

	public void setEducationCertificate(String educationCertificate) {
		this.educationCertificate = educationCertificate;
	}

	public void setQualificationOther(String qualificationOther) {
		this.qualificationOther = qualificationOther;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<FileUploadDetail> getFileUploadDetails() {
		return fileUploadDetails;
	}

	public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}

	public Integer getIssuingAuthorityId() {
		return issuingAuthorityId;
	}

	public void setIssuingAuthorityId(Integer issuingAuthorityId) {
		this.issuingAuthorityId = issuingAuthorityId;
	}

	public String getIssuingAuthorityName() {
		return issuingAuthorityName;
	}

	public void setIssuingAuthorityName(String issuingAuthorityName) {
		this.issuingAuthorityName = issuingAuthorityName;
	}

	public Integer getIssuingAuthorityFeeAmount() {
		return issuingAuthorityFeeAmount;
	}

	public void setIssuingAuthorityFeeAmount(Integer issuingAuthorityFeeAmount) {
		this.issuingAuthorityFeeAmount = issuingAuthorityFeeAmount;
	}

	public Object getIssuingAuthorityFeeCurrency() {
		return issuingAuthorityFeeCurrency;
	}

	public void setIssuingAuthorityFeeCurrency(Object issuingAuthorityFeeCurrency) {
		this.issuingAuthorityFeeCurrency = issuingAuthorityFeeCurrency;
	}

	public Object getBorneBy() {
		return borneBy;
	}

	public void setBorneBy(Object borneBy) {
		this.borneBy = borneBy;
	}

	public Object getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Object feeCategory) {
		this.feeCategory = feeCategory;
	}

	public String getIssuingAuthorityCountry() {
		return issuingAuthorityCountry;
	}

	public void setIssuingAuthorityCountry(String issuingAuthorityCountry) {
		this.issuingAuthorityCountry = issuingAuthorityCountry;
	}

	public Integer getIssuingAuthorityCountryId() {
		return issuingAuthorityCountryId;
	}

	public void setIssuingAuthorityCountryId(Integer issuingAuthorityCountryId) {
		this.issuingAuthorityCountryId = issuingAuthorityCountryId;
	}

	public String getQualificationAttained() {
		return qualificationAttained;
	}

	public void setQualificationAttained(String qualificationAttained) {
		this.qualificationAttained = qualificationAttained;
	}

	public String getApplicantsNameAsPerDocument() {
		return applicantsNameAsPerDocument;
	}

	public void setApplicantsNameAsPerDocument(String applicantsNameAsPerDocument) {
		this.applicantsNameAsPerDocument = applicantsNameAsPerDocument;
	}

	public String getModeOfStudy() {
		return modeOfStudy;
	}

	public void setModeOfStudy(String modeOfStudy) {
		this.modeOfStudy = modeOfStudy;
	}

	public Integer getModeOfStudyId() {
		return modeOfStudyId;
	}

	public void setModeOfStudyId(Integer modeOfStudyId) {
		this.modeOfStudyId = modeOfStudyId;
	}

	public Integer getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(Integer durationInYears) {
		this.durationInYears = durationInYears;
	}

	public Integer getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	public String getQualificationConferredDate() {
		return qualificationConferredDate;
	}

	public void setQualificationConferredDate(String qualificationConferredDate) {
		this.qualificationConferredDate = qualificationConferredDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public long getlRUserId() {
		return lRUserId;
	}

	public void setlRUserId(long lRUserId) {
		this.lRUserId = lRUserId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public DocumentInfo getDocumentInfo() {
		return documentInfo;
	}

	public void setDocumentInfo(DocumentInfo documentInfo) {
		this.documentInfo = documentInfo;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public boolean isEducationDetailVerified() {
		return educationDetailVerified;
	}

	public void setEducationDetailVerified(boolean educationDetailVerified) {
		this.educationDetailVerified = educationDetailVerified;
	}

	public String getDateOfGraduation() {
		return dateOfGraduation;
	}

	public void setDateOfGraduation(String dateOfGraduation) {
		this.dateOfGraduation = dateOfGraduation;
	}

	
}