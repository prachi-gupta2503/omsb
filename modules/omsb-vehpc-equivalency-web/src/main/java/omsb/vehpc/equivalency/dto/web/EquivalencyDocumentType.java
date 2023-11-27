package omsb.vehpc.equivalency.dto.web;

public class EquivalencyDocumentType {
	private long id;
	private String equivalencyDocType;
	private long equivalencyRequestId;
	
	private String qualification;
	private String caseRequestNumber;
	private long countryId;
	
	
	
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCaseRequestNumber() {
		return caseRequestNumber;
	}
	public void setCaseRequestNumber(String caseRequestNumber) {
		this.caseRequestNumber = caseRequestNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEquivalencyDocType() {
		return equivalencyDocType;
	}
	public void setEquivalencyDocType(String equivalencyDocType) {
		this.equivalencyDocType = equivalencyDocType;
	}
	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}
	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyDocumentType [id=");
		builder.append(id);
		builder.append(", equivalencyDocType=");
		builder.append(equivalencyDocType);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append(", caseRequestNumber=");
		builder.append(caseRequestNumber);
		builder.append(", countryId=");
		builder.append(countryId);
		builder.append("]");
		return builder.toString();
	}	
	
	
}
