package omsb.vehpc.equivalency.dto.web;

public class DocumentInfo {

	private long id;
	private long caseRequestId;
	private long componentId;
	private long dFDocumentId;
	private String dFFileKey;
	private String dFFileName;
	private String documentTypeId;
	private String documentTypeName;
	private long equivalencyDocTypeId;
	private long fileEntryID;
	private String fileName;
	private long personId;
	private long equivalencyRequestId;
	private String caseNumber;
	private String documentType;
	private String documentUrl;
	private String documentTypeCategory;
	private long componentClassRefId;
	private String issuingAuthorityName;
	private String evaluateDocTypeKey;
	private String docsfileurl;
	private String evaluateDocTypeName;
	private String otherDocType;
	private long equivalencyAppealId;
	private long documentInfoId;
	private String countryName;
	private String equivalencyCertificate;
	private long yearOfGraduation;
	private String suggestedEquivalencyLevel;
	private String issuingAuthorityCountryName;

	public String getDocumentTypeName() {
		return documentTypeName;
	}

	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCaseRequestId() {
		return caseRequestId;
	}

	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}

	public long getComponentId() {
		return componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public long getdFDocumentId() {
		return dFDocumentId;
	}

	public void setdFDocumentId(long dFDocumentId) {
		this.dFDocumentId = dFDocumentId;
	}

	public String getdFFileKey() {
		return dFFileKey;
	}

	public void setdFFileKey(String dFFileKey) {
		this.dFFileKey = dFFileKey;
	}

	public String getdFFileName() {
		return dFFileName;
	}

	public void setdFFileName(String dFFileName) {
		this.dFFileName = dFFileName;
	}

	public String getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(String documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public long getEquivalencyDocTypeId() {
		return equivalencyDocTypeId;
	}

	public void setEquivalencyDocTypeId(long equivalencyDocTypeId) {
		this.equivalencyDocTypeId = equivalencyDocTypeId;
	}

	public long getFileEntryID() {
		return fileEntryID;
	}

	public void setFileEntryID(long fileEntryID) {
		this.fileEntryID = fileEntryID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
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

	public long getComponentClassRefId() {
		return componentClassRefId;
	}

	public void setComponentClassRefId(long componentClassRefId) {
		this.componentClassRefId = componentClassRefId;
	}

	public String getIssuingAuthorityName() {
		return issuingAuthorityName;
	}

	public void setIssuingAuthorityName(String issuingAuthorityName) {
		this.issuingAuthorityName = issuingAuthorityName;
	}

	public String getEvaluateDocTypeKey() {
		return evaluateDocTypeKey;
	}

	public void setEvaluateDocTypeKey(String evaluateDocTypeKey) {
		this.evaluateDocTypeKey = evaluateDocTypeKey;
	}

	public String getDocsfileurl() {
		return docsfileurl;
	}

	public void setDocsfileurl(String docsfileurl) {
		this.docsfileurl = docsfileurl;
	}

	public String getEvaluateDocTypeName() {
		return evaluateDocTypeName;
	}

	public void setEvaluateDocTypeName(String evaluateDocTypeName) {
		this.evaluateDocTypeName = evaluateDocTypeName;
	}

	public String getOtherDocType() {
		return otherDocType;
	}

	public void setOtherDocType(String otherDocType) {
		this.otherDocType = otherDocType;
	}

	public long getEquivalencyAppealId() {
		return equivalencyAppealId;
	}

	public void setEquivalencyAppealId(long equivalencyAppealId) {
		this.equivalencyAppealId = equivalencyAppealId;
	}

	public long getDocumentInfoId() {
		return documentInfoId;
	}

	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}
	

	public String getEquivalencyCertificate() {
		return equivalencyCertificate;
	}

	public void setEquivalencyCertificate(String equivalencyCertificate) {
		this.equivalencyCertificate = equivalencyCertificate;
	}

	public long getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(long yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	
	public String getSuggestedEquivalencyLevel() {
		return suggestedEquivalencyLevel;
	}

	public void setSuggestedEquivalencyLevel(String suggestedEquivalencyLevel) {
		this.suggestedEquivalencyLevel = suggestedEquivalencyLevel;
	}
	
	public String getIssuingAuthorityCountryName() {
		return issuingAuthorityCountryName;
	}

	public void setIssuingAuthorityCountryName(String issuingAuthorityCountryName) {
		this.issuingAuthorityCountryName = issuingAuthorityCountryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentInfo [id=");
		builder.append(id);
		builder.append(", caseRequestId=");
		builder.append(caseRequestId);
		builder.append(", componentId=");
		builder.append(componentId);
		builder.append(", dFDocumentId=");
		builder.append(dFDocumentId);
		builder.append(", dFFileKey=");
		builder.append(dFFileKey);
		builder.append(", dFFileName=");
		builder.append(dFFileName);
		builder.append(", documentTypeId=");
		builder.append(documentTypeId);
		builder.append(", documentTypeName=");
		builder.append(documentTypeName);
		builder.append(", equivalencyDocTypeId=");
		builder.append(equivalencyDocTypeId);
		builder.append(", fileEntryID=");
		builder.append(fileEntryID);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", caseNumber=");
		builder.append(caseNumber);
		builder.append(", documentType=");
		builder.append(documentType);
		builder.append(", documentUrl=");
		builder.append(documentUrl);
		builder.append(", documentTypeCategory=");
		builder.append(documentTypeCategory);
		builder.append(", componentClassRefId=");
		builder.append(componentClassRefId);
		builder.append(", issuingAuthorityName=");
		builder.append(issuingAuthorityName);
		builder.append(", evaluateDocTypeKey=");
		builder.append(evaluateDocTypeKey);
		builder.append(", docsfileurl=");
		builder.append(docsfileurl);
		builder.append(", evaluateDocTypeName=");
		builder.append(evaluateDocTypeName);
		builder.append(", otherDocType=");
		builder.append(otherDocType);
		builder.append(", equivalencyAppealId=");
		builder.append(equivalencyAppealId);
		builder.append(", documentInfoId=");
		builder.append(documentInfoId);
		builder.append(", countryName=");
		builder.append(countryName);
		builder.append(", equivalencyCertificate=");
		builder.append(equivalencyCertificate);
		builder.append(", yearOfGraduation=");
		builder.append(yearOfGraduation);
		builder.append(", suggestedEquivalencyLevel=");
		builder.append(suggestedEquivalencyLevel);
		builder.append(", issuingAuthorityCountryName=");
		builder.append(issuingAuthorityCountryName);
		builder.append("]");
		return builder.toString();
	}

}
