package omsb.vehpc.equivalency.dto.web;

import java.util.Date;

public class EquivalencyDtoItem {
	
	/* PersonItem variable Starts */
	private Date dateCreated;
    private Date dateModified;
    private long id;
    private String passportNumber;
    private String dateOfBirth;
    private int lrUserId;
    private String civilId;
	/* PersonItem variable Ends */    
    
    /*PersonalDetailsItems variable Starts*/
	private String givenNameAsPassport;
	private String applicantSurname;
	private boolean isVerified;
	private long mobileNumber;
	private String email;
	private long personId;
	private long caseRequestId;   
	private long countryId;
	private String countryName;
	private long nationalityCountryId;
	private String nationalityCountryName;
    
	/* PersonalDetailsItems variable Ends */
	
	
	/* caseRequest variable Starts */
    
	private String caseNumber;
	private long caseStageID;
	private long caseStatusId;
	private long caseTypeID;
	private String cRN;
	private String message;
	private long personID;
	/* caseRequest variable Starts */
	
	/* EquivalencyRequest variable starts */
	private long employerUserID;
	private long equivalencyStatusId;
	//private long personId;
	private String professionId;
	/* EquivalencyRequest variable Ends */
	
	/* Document info passing value */
	private long documentInfoId;
	private String documentType;
	private String documentUrl;
	private String documentTypeCategory;
	private String qualification;
	/* Document info passing value Ends*/
    
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public int getLrUserId() {
		return lrUserId;
	}
	public void setLrUserId(int lrUserId) {
		this.lrUserId = lrUserId;
	}
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGivenNameAsPassport() {
		return givenNameAsPassport;
	}
	public void setGivenNameAsPassport(String givenNameAsPassport) {
		this.givenNameAsPassport = givenNameAsPassport;
	}
	public String getApplicantSurname() {
		return applicantSurname;
	}
	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getCaseRequestId() {
		return caseRequestId;
	}
	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getNationalityCountryId() {
		return nationalityCountryId;
	}
	public void setNationalityCountryId(long nationalityCountryId) {
		this.nationalityCountryId = nationalityCountryId;
	}
	public String getNationalityCountryName() {
		return nationalityCountryName;
	}
	public void setNationalityCountryName(String nationalityCountryName) {
		this.nationalityCountryName = nationalityCountryName;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public long getCaseStageID() {
		return caseStageID;
	}
	public void setCaseStageID(long caseStageID) {
		this.caseStageID = caseStageID;
	}
	public long getCaseStatusId() {
		return caseStatusId;
	}
	public void setCaseStatusId(long caseStatusId) {
		this.caseStatusId = caseStatusId;
	}
	public long getCaseTypeID() {
		return caseTypeID;
	}
	public void setCaseTypeID(long caseTypeID) {
		this.caseTypeID = caseTypeID;
	}
	
	public long getPersonID() {
		return personID;
	}
	public void setPersonID(long personID) {
		this.personID = personID;
	}
	public String getcRN() {
		return cRN;
	}
	public void setcRN(String cRN) {
		this.cRN = cRN;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getEmployerUserID() {
		return employerUserID;
	}
	public void setEmployerUserID(long employerUserID) {
		this.employerUserID = employerUserID;
	}
	public long getEquivalencyStatusId() {
		return equivalencyStatusId;
	}
	public void setEquivalencyStatusId(long equivalencyStatusId) {
		this.equivalencyStatusId = equivalencyStatusId;
	}
	public String getProfessionId() {
		return professionId;
	}
	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	public String getDocumentTypeCategory() {
		return documentTypeCategory;
	}
	public void setDocumentTypeCategory(String documentTypeCategory) {
		this.documentTypeCategory = documentTypeCategory;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public long getDocumentInfoId() {
		return documentInfoId;
	}
	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}
	
	
	
}
