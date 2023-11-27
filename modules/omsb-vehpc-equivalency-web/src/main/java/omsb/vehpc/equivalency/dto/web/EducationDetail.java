package omsb.vehpc.equivalency.dto.web;

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
	private long durationInYears;
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
	
	private DocumentInfo documentInfo;
	private boolean educationDetailVerified;
	private long institution;
	private String suggestedEquivalencyLevel;
	
	public String getQualificationOther() {
		return qualificationOther;
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

	public long getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(long durationInYears) {
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

	public String getSuggestedEquivalencyLevel() {
		return suggestedEquivalencyLevel;
	}

	public void setSuggestedEquivalencyLevel(String suggestedEquivalencyLevel) {
		this.suggestedEquivalencyLevel = suggestedEquivalencyLevel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EducationDetail [issuingAuthorityId=");
		builder.append(issuingAuthorityId);
		builder.append(", issuingAuthorityName=");
		builder.append(issuingAuthorityName);
		builder.append(", issuingAuthorityFeeAmount=");
		builder.append(issuingAuthorityFeeAmount);
		builder.append(", issuingAuthorityFeeCurrency=");
		builder.append(issuingAuthorityFeeCurrency);
		builder.append(", borneBy=");
		builder.append(borneBy);
		builder.append(", feeCategory=");
		builder.append(feeCategory);
		builder.append(", issuingAuthorityCountry=");
		builder.append(issuingAuthorityCountry);
		builder.append(", issuingAuthorityCountryId=");
		builder.append(issuingAuthorityCountryId);
		builder.append(", qualificationAttained=");
		builder.append(qualificationAttained);
		builder.append(", applicantsNameAsPerDocument=");
		builder.append(applicantsNameAsPerDocument);
		builder.append(", modeOfStudy=");
		builder.append(modeOfStudy);
		builder.append(", modeOfStudyId=");
		builder.append(modeOfStudyId);
		builder.append(", durationInYears=");
		builder.append(durationInYears);
		builder.append(", durationInMonths=");
		builder.append(durationInMonths);
		builder.append(", qualificationConferredDate=");
		builder.append(qualificationConferredDate);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", qualificationOther=");
		builder.append(qualificationOther);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", fileUploadDetails=");
		builder.append(fileUploadDetails);
		builder.append(", id=");
		builder.append(id);
		builder.append(", lRUserId=");
		builder.append(lRUserId);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", gpa=");
		builder.append(gpa);
		builder.append(", yearOfGraduation=");
		builder.append(yearOfGraduation);
		builder.append(", documentInfo=");
		builder.append(documentInfo);
		builder.append(", educationDetailVerified=");
		builder.append(educationDetailVerified);
		builder.append(", institution=");
		builder.append(institution);
		builder.append(", suggestedEquivalencyLevel=");
		builder.append(suggestedEquivalencyLevel);
		builder.append("]");
		return builder.toString();
	}
	
}