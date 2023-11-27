package gov.omsb.tms.ecm.web.dto;

public class EducationalDetailItem {
	
	private String dateCreated;
    private String dateModified;
    private String issuingAuthorityName;
    private int durationInMonths;
    private int caseRequestId;
    private String issuingAuthorityState;
    private String qualificationConferredDate;
    private int mosId;
    private int personId;
    private int issuingAuthorityCountryId;
    private String issuingAuthorityCountryName;
    private String qualificationAttained;
    private int equivalencyRequestId;
    private int id;
    private String gpa;
    private int yearOfGraduation;
    private String documentUrl;
	
	public String getIssuingAuthorityCountryName() {
		return issuingAuthorityCountryName;
	}
	public void setIssuingAuthorityCountryName(String issuingAuthorityCountryName) {
		this.issuingAuthorityCountryName = issuingAuthorityCountryName;
	}
	public String getIssuingAuthorityName() {
		return issuingAuthorityName;
	}
	public void setIssuingAuthorityName(String issuingAuthorityName) {
		this.issuingAuthorityName = issuingAuthorityName;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	public int getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(int caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public String getIssuingAuthorityState() {
		return issuingAuthorityState;
	}
	public void setIssuingAuthorityState(String issuingAuthorityState) {
		this.issuingAuthorityState = issuingAuthorityState;
	}
	public int getMosId() {
		return mosId;
	}
	public void setMosId(int mosId) {
		this.mosId = mosId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getIssuingAuthorityCountryId() {
		return issuingAuthorityCountryId;
	}
	public void setIssuingAuthorityCountryId(int issuingAuthorityCountryId) {
		this.issuingAuthorityCountryId = issuingAuthorityCountryId;
	}
	public String getQualificationAttained() {
		return qualificationAttained;
	}
	public void setQualificationAttained(String qualificationAttained) {
		this.qualificationAttained = qualificationAttained;
	}
	public int getEquivalencyRequestId() {
		return equivalencyRequestId;
	}
	public void setEquivalencyRequestId(int equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getQualificationConferredDate() {
		return qualificationConferredDate;
	}
	public void setQualificationConferredDate(String qualificationConferredDate) {
		this.qualificationConferredDate = qualificationConferredDate;
	}
	public String getGpa() {
		return gpa;
	}
	public int getYearOfGraduation() {
		return yearOfGraduation;
	}
	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	
}
