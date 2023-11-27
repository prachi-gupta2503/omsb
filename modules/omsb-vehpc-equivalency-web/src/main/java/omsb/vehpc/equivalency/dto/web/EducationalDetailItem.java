package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class EducationalDetailItem {
	
	private String dateCreated;
    private String dateModified;
    private String issuingAuthorityName;
    private int durationInMonths;
    private long durationInYears;
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
    private String suggestedEquivalencyLevel;
    private List<DocumentDetailCertificate> items;
 
	
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
	public List<DocumentDetailCertificate> getItems() {
		return items;
	}
	public void setItems(List<DocumentDetailCertificate> items) {
		this.items = items;
	}
	public String getSuggestedEquivalencyLevel() {
		return suggestedEquivalencyLevel;
	}
	public void setSuggestedEquivalencyLevel(String suggestedEquivalencyLevel) {
		this.suggestedEquivalencyLevel = suggestedEquivalencyLevel;
	}
	public long getDurationInYears() {
		return durationInYears;
	}
	public void setDurationInYears(long durationInYears) {
		this.durationInYears = durationInYears;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EducationalDetailItem [dateCreated=");
		builder.append(dateCreated);
		builder.append(", dateModified=");
		builder.append(dateModified);
		builder.append(", issuingAuthorityName=");
		builder.append(issuingAuthorityName);
		builder.append(", durationInMonths=");
		builder.append(durationInMonths);
		builder.append(", durationInYears=");
		builder.append(durationInYears);
		builder.append(", caseRequestId=");
		builder.append(caseRequestId);
		builder.append(", issuingAuthorityState=");
		builder.append(issuingAuthorityState);
		builder.append(", qualificationConferredDate=");
		builder.append(qualificationConferredDate);
		builder.append(", mosId=");
		builder.append(mosId);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", issuingAuthorityCountryId=");
		builder.append(issuingAuthorityCountryId);
		builder.append(", issuingAuthorityCountryName=");
		builder.append(issuingAuthorityCountryName);
		builder.append(", qualificationAttained=");
		builder.append(qualificationAttained);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", id=");
		builder.append(id);
		builder.append(", suggestedEquivalencyLevel=");
		builder.append(suggestedEquivalencyLevel);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
}
