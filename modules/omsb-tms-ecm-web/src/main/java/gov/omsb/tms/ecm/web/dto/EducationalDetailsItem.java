package gov.omsb.tms.ecm.web.dto;

public class EducationalDetailsItem {
	private long id;
    private String issuingAuthorityName;
    private long personId;
    private long issuingAuthorityCountryId;
    private String issuingAuthorityCountryName;
    private String qualificationAttained;
    private String gpa;
    private int yearOfGraduation;
    private long equivalencyRequestId;
    private String documentUrl;
    private String fileName;
    private DocumentInfoItem documentInfoItem;
  
	public String getIssuingAuthorityName() {
		return issuingAuthorityName;
	}
	public void setIssuingAuthorityName(String issuingAuthorityName) {
		this.issuingAuthorityName = issuingAuthorityName;
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
	public String getIssuingAuthorityCountryName() {
		return issuingAuthorityCountryName;
	}
	public void setIssuingAuthorityCountryName(String issuingAuthorityCountryName) {
		this.issuingAuthorityCountryName = issuingAuthorityCountryName;
	}
	public String getQualificationAttained() {
		return qualificationAttained;
	}
	public void setQualificationAttained(String qualificationAttained) {
		this.qualificationAttained = qualificationAttained;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public int getYearOfGraduation() {
		return yearOfGraduation;
	}
	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}
	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public DocumentInfoItem getDocumentInfoItem() {
		return documentInfoItem;
	}
	public void setDocumentInfoItem(DocumentInfoItem documentInfoItem) {
		this.documentInfoItem = documentInfoItem;
	}

	
	


}
