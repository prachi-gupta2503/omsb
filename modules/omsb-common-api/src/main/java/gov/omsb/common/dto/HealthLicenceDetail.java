package gov.omsb.common.dto;

import java.util.ArrayList;
import java.util.List;

public class HealthLicenceDetail {
	private Integer issuingAuthorityId;
    private String issuingAuthorityName;
    private String professionalTitle;
    private Integer issuingAuthorityCountryId;
    private String issuingAuthorityCountry;
    private Integer issuingAuthorityFeeAmount;
    private Object issuingAuthorityFeeCurrency;
    private Object borneBy;
    private Object feeCategory;
    private String applicantNameAsPerDocument;
	private String licenceType;
    private String registrationOrLicenceNumberOrID;
    private String licenseConferredDate;
    private String licenseExpiryDate;
    private String licenseStatus;
    private List<FileUploadDetail> fileUploadDetails = new ArrayList<>();
    private String remarks;
    private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	public Integer getIssuingAuthorityCountryId() {
		return issuingAuthorityCountryId;
	}
	public void setIssuingAuthorityCountryId(Integer issuingAuthorityCountryId) {
		this.issuingAuthorityCountryId = issuingAuthorityCountryId;
	}
	public String getIssuingAuthorityCountry() {
		return issuingAuthorityCountry;
	}
	public void setIssuingAuthorityCountry(String issuingAuthorityCountry) {
		this.issuingAuthorityCountry = issuingAuthorityCountry;
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
	public String getApplicantNameAsPerDocument() {
		return applicantNameAsPerDocument;
	}
	public void setApplicantNameAsPerDocument(String applicantNameAsPerDocument) {
		this.applicantNameAsPerDocument = applicantNameAsPerDocument;
	}
	public String getLicenceType() {
		return licenceType;
	}
	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}
	public String getRegistrationOrLicenceNumberOrID() {
		return registrationOrLicenceNumberOrID;
	}
	public void setRegistrationOrLicenceNumberOrID(String registrationOrLicenceNumberOrID) {
		this.registrationOrLicenceNumberOrID = registrationOrLicenceNumberOrID;
	}
	public String getLicenseConferredDate() {
		return licenseConferredDate;
	}
	public void setLicenseConferredDate(String licenseConferredDate) {
		this.licenseConferredDate = licenseConferredDate;
	}
	public String getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(String licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public String getLicenseStatus() {
		return licenseStatus;
	}
	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}
	public List<FileUploadDetail> getFileUploadDetails() {
		return fileUploadDetails;
	}
	public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
