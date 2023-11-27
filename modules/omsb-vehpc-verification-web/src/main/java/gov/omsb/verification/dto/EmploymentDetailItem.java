package gov.omsb.verification.dto;

import java.util.List;

public class EmploymentDetailItem {
	
		private String feeCategory;
	    private String issuingAuthorityName;
	    private String borneBy;
	    private long caseRequestID;
	    private String natureOfEmployment;
	    private String employmentPeriodFrom;
	    private String employmentPeriodTo;
	    private long personId;
	    private long issuingAuthorityCountryId;
	    private String issuingAuthorityCountryName;
	    private String lastProfile;
	    private long id;
	    private List<DocumentDetailCertificate> items;
		public String getFeeCategory() {
			return feeCategory;
		}
		public void setFeeCategory(String feeCategory) {
			this.feeCategory = feeCategory;
		}
		public String getIssuingAuthorityName() {
			return issuingAuthorityName;
		}
		public void setIssuingAuthorityName(String issuingAuthorityName) {
			this.issuingAuthorityName = issuingAuthorityName;
		}
		public String getBorneBy() {
			return borneBy;
		}
		public void setBorneBy(String borneBy) {
			this.borneBy = borneBy;
		}
		public long getCaseRequestID() {
			return caseRequestID;
		}
		public void setCaseRequestID(long caseRequestID) {
			this.caseRequestID = caseRequestID;
		}
		public String getNatureOfEmployment() {
			return natureOfEmployment;
		}
		public void setNatureOfEmployment(String natureOfEmployment) {
			this.natureOfEmployment = natureOfEmployment;
		}
		public String getEmploymentPeriodFrom() {
			return employmentPeriodFrom;
		}
		public void setEmploymentPeriodFrom(String employmentPeriodFrom) {
			this.employmentPeriodFrom = employmentPeriodFrom;
		}
		public String getEmploymentPeriodTo() {
			return employmentPeriodTo;
		}
		public void setEmploymentPeriodTo(String employmentPeriodTo) {
			this.employmentPeriodTo = employmentPeriodTo;
		}
		public long getPersonId() {
			return personId;
		}
		public void setPersonId(long personId) {
			this.personId = personId;
		}
		public long getIssuingAuthorityCountryId() {
			return issuingAuthorityCountryId;
		}
		public void setIssuingAuthorityCountryId(long issuingAuthorityCountryId) {
			this.issuingAuthorityCountryId = issuingAuthorityCountryId;
		}
		public String getLastProfile() {
			return lastProfile;
		}
		public void setLastProfile(String lastProfile) {
			this.lastProfile = lastProfile;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public List<DocumentDetailCertificate> getItems() {
			return items;
		}
		public void setItems(List<DocumentDetailCertificate> items) {
			this.items = items;
		}
		public String getIssuingAuthorityCountryName() {
			return issuingAuthorityCountryName;
		}
		public void setIssuingAuthorityCountryName(String issuingAuthorityCountryName) {
			this.issuingAuthorityCountryName = issuingAuthorityCountryName;
		}
	
	
		
		
}
