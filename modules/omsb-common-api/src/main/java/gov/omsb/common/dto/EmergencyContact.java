package gov.omsb.common.dto;

public class EmergencyContact {
	
	private long id;
	private String name;
	private String telephone;
	private String mobileNumber;
	private String relationshipToApplicant;
	private String emailAddress;
	private long examRegistrationId;
	private long lrUserID;
	
	private boolean consentAuthorize;
	private boolean declaration;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRelationshipToApplicant() {
		return relationshipToApplicant;
	}
	public void setRelationshipToApplicant(String relationshipToApplicant) {
		this.relationshipToApplicant = relationshipToApplicant;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getExamRegistrationId() {
		return examRegistrationId;
	}
	public void setExamRegistrationId(long examRegistrationId) {
		this.examRegistrationId = examRegistrationId;
	}
	public long getLrUserID() {
		return lrUserID;
	}
	public void setLrUserID(long lrUserID) {
		this.lrUserID = lrUserID;
	}
	
	public boolean isConsentAuthorize() {
		return consentAuthorize;
	}
	public void setConsentAuthorize(boolean consentAuthorize) {
		this.consentAuthorize = consentAuthorize;
	}
	public boolean isDeclaration() {
		return declaration;
	}
	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}
	@Override
	public String toString() {
		return "EmergencyContact [id=" + id + ", name=" + name + ", telephone=" + telephone + ", mobileNumber="
				+ mobileNumber + ", relationshipToApplicant=" + relationshipToApplicant + ", emailAddress="
				+ emailAddress + ", examRegistrationId=" + examRegistrationId + ", lrUserID=" + lrUserID
				+ ", consentAuthorize=" + consentAuthorize + ", declaration=" + declaration + "]";
	}
	
	
	

}
