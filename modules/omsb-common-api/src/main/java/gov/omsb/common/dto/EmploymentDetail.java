package gov.omsb.common.dto;

import java.util.ArrayList;
import java.util.List;

public class EmploymentDetail {
	private Integer issuingAuthorityId;
	private String issuingAuthorityName;
	private Integer issuingAuthorityFeeAmount;
	private Object issuingAuthorityFeeCurrency;
	private Object borneBy;
	private Object feeCategory;
	private Object applicantPaysDirectlyToIA;
	private String issuingAuthorityCountry;
	private Integer issuingAuthorityCountryId;
	private String lastProfile;
	private String natureOfEmployment;
	private String employementPeriodFrom;
	private String employementPeriodTo;
	private String applicantsNameAsPerDocument;
	private String remarks;
	private List<FileUploadDetail> fileUploadDetails = new ArrayList<>();
	
	private long id;
	private String workSectorType;
	private long workSectorId;
	private String workSectorOther;
	private String workSectorLocation;
	private String designationId;
	private String designationOther;
	private String staffIdCard;
	private long personId;
	private String workSector;
	private String uploadFileName;
	private String documentUrl;
	private long lRUserId;
	private String primaryWorkDetail;
	
	private String workSectorTypeOther;
	
	private String workSector2;
	private long workSectorId2;
	private String workSectorOther2;
	
	private String workSector3;
	private long workSectorId3;
	private String workSectorOther3;
	
	private WorkSectorItems workSectorItems ;
	private WorkSectorItems workSubSectorItems ;
	
	private boolean employmentDetailVerified;

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

	public Object getApplicantPaysDirectlyToIA() {
		return applicantPaysDirectlyToIA;
	}

	public void setApplicantPaysDirectlyToIA(Object applicantPaysDirectlyToIA) {
		this.applicantPaysDirectlyToIA = applicantPaysDirectlyToIA;
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

	public String getLastProfile() {
		return lastProfile;
	}

	public void setLastProfile(String lastProfile) {
		this.lastProfile = lastProfile;
	}

	public String getNatureOfEmployment() {
		return natureOfEmployment;
	}

	public void setNatureOfEmployment(String natureOfEmployment) {
		this.natureOfEmployment = natureOfEmployment;
	}

	public String getEmployementPeriodFrom() {
		return employementPeriodFrom;
	}

	public void setEmployementPeriodFrom(String employementPeriodFrom) {
		this.employementPeriodFrom = employementPeriodFrom;
	}

	public String getEmployementPeriodTo() {
		return employementPeriodTo;
	}

	public void setEmployementPeriodTo(String employementPeriodTo) {
		this.employementPeriodTo = employementPeriodTo;
	}

	public String getApplicantsNameAsPerDocument() {
		return applicantsNameAsPerDocument;
	}

	public void setApplicantsNameAsPerDocument(String applicantsNameAsPerDocument) {
		this.applicantsNameAsPerDocument = applicantsNameAsPerDocument;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<FileUploadDetail> getFileUploadDetails() {
		return fileUploadDetails;
	}

	public void setFileUploadDetails(List<FileUploadDetail> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}

	public String getWorkSectorType() {
		return workSectorType;
	}

	public void setWorkSectorType(String workSectorType) {
		this.workSectorType = workSectorType;
	}

	public long getWorkSectorId() {
		return workSectorId;
	}

	public void setWorkSectorId(long workSectorId) {
		this.workSectorId = workSectorId;
	}

	public String getWorkSectorOther() {
		return workSectorOther;
	}

	public void setWorkSectorOther(String workSectorOther) {
		this.workSectorOther = workSectorOther;
	}

	public String getWorkSectorLocation() {
		return workSectorLocation;
	}

	public void setWorkSectorLocation(String workSectorLocation) {
		this.workSectorLocation = workSectorLocation;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignationOther() {
		return designationOther;
	}

	public void setDesignationOther(String designationOther) {
		this.designationOther = designationOther;
	}

	public String getStaffIdCard() {
		return staffIdCard;
	}

	public void setStaffIdCard(String staffIdCard) {
		this.staffIdCard = staffIdCard;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getWorkSector() {
		return workSector;
	}

	public void setWorkSector(String workSector) {
		this.workSector = workSector;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public long getlRUserId() {
		return lRUserId;
	}

	public void setlRUserId(long lRUserId) {
		this.lRUserId = lRUserId;
	}

	/*
	 * public boolean isPrimaryWorkDetail() { return primaryWorkDetail; }
	 * 
	 * public void setPrimaryWorkDetail(boolean primaryWorkDetail) {
	 * this.primaryWorkDetail = primaryWorkDetail; }
	 */

	public String getWorkSectorTypeOther() {
		return workSectorTypeOther;
	}

	public void setWorkSectorTypeOther(String workSectorTypeOther) {
		this.workSectorTypeOther = workSectorTypeOther;
	}

	public WorkSectorItems getWorkSectorItems() {
		return workSectorItems;
	}

	public void setWorkSectorItems(WorkSectorItems workSectorItems) {
		this.workSectorItems = workSectorItems;
	}

	public WorkSectorItems getWorkSubSectorItems() {
		return workSubSectorItems;
	}

	public void setWorkSubSectorItems(WorkSectorItems workSubSectorItems) {
		this.workSubSectorItems = workSubSectorItems;
	}

	public long getWorkSectorId2() {
		return workSectorId2;
	}

	public void setWorkSectorId2(long workSectorId2) {
		this.workSectorId2 = workSectorId2;
	}

	public String getWorkSectorOther2() {
		return workSectorOther2;
	}

	public void setWorkSectorOther2(String workSectorOther2) {
		this.workSectorOther2 = workSectorOther2;
	}

	public long getWorkSectorId3() {
		return workSectorId3;
	}

	public void setWorkSectorId3(long workSectorId3) {
		this.workSectorId3 = workSectorId3;
	}

	public String getWorkSectorOther3() {
		return workSectorOther3;
	}

	public void setWorkSectorOther3(String workSectorOther3) {
		this.workSectorOther3 = workSectorOther3;
	}

	public String getWorkSector2() {
		return workSector2;
	}

	public void setWorkSector2(String workSector2) {
		this.workSector2 = workSector2;
	}

	public String getWorkSector3() {
		return workSector3;
	}

	public void setWorkSector3(String workSector3) {
		this.workSector3 = workSector3;
	}

	public String getPrimaryWorkDetail() {
		return primaryWorkDetail;
	}

	public void setPrimaryWorkDetail(String primaryWorkDetail) {
		this.primaryWorkDetail = primaryWorkDetail;
	}

	public boolean isEmploymentDetailVerified() {
		return employmentDetailVerified;
	}

	public void setEmploymentDetailVerified(boolean employmentDetailVerified) {
		this.employmentDetailVerified = employmentDetailVerified;
	}
	
	
	
	
	
}
