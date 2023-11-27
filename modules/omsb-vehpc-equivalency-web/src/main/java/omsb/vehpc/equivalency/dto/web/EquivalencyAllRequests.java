package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class EquivalencyAllRequests {
	private String dateOfbirth;
	private String verificationDate;
	private String employeeName;
	private String caseNumber;
	private String createdBy;
	private long equivalencyRequestId;
	private String dateCreated;
	private String statusColorClass;
	private String status;
	private String statusKey;
	private long personId;
	private List<String> transitions;
	private long appealId;
	private boolean appealValidity;

	private boolean resubmit;
	private String appealStatusColorClass;
	private String appealStatus;
	private String appealStatusKey;
	private String certificateFileUrl;

	public String getAppealStatusColorClass() {
		return appealStatusColorClass;
	}

	public void setAppealStatusColorClass(String appealStatusColorClass) {
		this.appealStatusColorClass = appealStatusColorClass;
	}

	public String getAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(String appealStatus) {
		this.appealStatus = appealStatus;
	}

	public String getAppealStatusKey() {
		return appealStatusKey;
	}

	public void setAppealStatusKey(String appealStatusKey) {
		this.appealStatusKey = appealStatusKey;
	}

	//
	public boolean isResubmit() {
		return resubmit;
	}

	public void setResubmit(boolean resubmit) {
		this.resubmit = resubmit;
	}

	public boolean isAppealValidity() {
		return appealValidity;
	}

	public void setAppealValidity(boolean appealValidity) {
		this.appealValidity = appealValidity;
	}

	public long getAppealId() {
		return appealId;
	}

	public void setAppealId(long appealId) {
		this.appealId = appealId;
	}

	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatusColorClass() {
		return statusColorClass;
	}

	public void setStatusColorClass(String statusColorClass) {
		this.statusColorClass = statusColorClass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public List<String> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<String> transitions) {
		this.transitions = transitions;
	}
	

	public String getCertificateFileUrl() {
		return certificateFileUrl;
	}

	public void setCertificateFileUrl(String certificateFileUrl) {
		this.certificateFileUrl = certificateFileUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyAllRequests [dateOfbirth=");
		builder.append(dateOfbirth);
		builder.append(", verificationDate=");
		builder.append(verificationDate);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", caseNumber=");
		builder.append(caseNumber);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", statusColorClass=");
		builder.append(statusColorClass);
		builder.append(", status=");
		builder.append(status);
		builder.append(", statusKey=");
		builder.append(statusKey);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", transitions=");
		builder.append(transitions);
		builder.append(", appealId=");
		builder.append(appealId);
		builder.append(", appealValidity=");
		builder.append(appealValidity);
		builder.append(", resubmit=");
		builder.append(resubmit);
		builder.append(", appealStatusColorClass=");
		builder.append(appealStatusColorClass);
		builder.append(", appealStatus=");
		builder.append(appealStatus);
		builder.append(", appealStatusKey=");
		builder.append(appealStatusKey);
		builder.append(", certificateFileUrl=");
		builder.append(certificateFileUrl);
		builder.append("]");
		return builder.toString();
	}

}
