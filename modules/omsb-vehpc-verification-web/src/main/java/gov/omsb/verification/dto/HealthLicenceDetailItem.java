package gov.omsb.verification.dto;

import java.util.List;

public class HealthLicenceDetailItem {
    private Object borneBy;
    private String id;
    private Integer caseRequestID;
    private Object feeCategory;
    
    private String licenseAttained;
    private String licenseConferredDate;
    private String licenseExpiryDate;
    
    private String licenseNumber;
    private String licenseStatus;
    private String licenseType;
    private Integer personId;
    private String professionalTitle;
    private List<DocumentDetailCertificate> items;
	public Object getBorneBy() {
		return borneBy;
	}
	public void setBorneBy(Object borneBy) {
		this.borneBy = borneBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCaseRequestID() {
		return caseRequestID;
	}
	public void setCaseRequestID(Integer caseRequestID) {
		this.caseRequestID = caseRequestID;
	}
	public Object getFeeCategory() {
		return feeCategory;
	}
	public void setFeeCategory(Object feeCategory) {
		this.feeCategory = feeCategory;
	}
	public String getLicenseAttained() {
		return licenseAttained;
	}
	public void setLicenseAttained(String licenseAttained) {
		this.licenseAttained = licenseAttained;
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
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getLicenseStatus() {
		return licenseStatus;
	}
	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	public List<DocumentDetailCertificate> getItems() {
		return items;
	}
	public void setItems(List<DocumentDetailCertificate> items) {
		this.items = items;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	
}
