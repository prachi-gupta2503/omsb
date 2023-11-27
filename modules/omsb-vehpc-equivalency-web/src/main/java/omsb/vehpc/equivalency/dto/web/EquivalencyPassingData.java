package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class EquivalencyPassingData {
	/* new-equivalency variable Starts */
	private String personName;
	private String caseNumber;
	private String dob;
	private String email;
	private long caseRequestId;
	private long personId;
	/* new-equivalency variable Ends */

	/* Equivalency home search variable Starts */
	private String employer;
	private String employee;
	private String statusColorClass;
	private String status;
	private String createdOn;
	private long equivalencyRequestId;

	private List<String> transitions;

	/* Equivalency home search variable Ends */

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCaseRequestId() {
		return caseRequestId;
	}

	public void setCaseRequestId(long caseRequestId) {
		this.caseRequestId = caseRequestId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public List<String> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<String> transitions) {
		this.transitions = transitions;
	}

	public String getStatusColorClass() {
		return statusColorClass;
	}

	public void setStatusColorClass(String statusColorClass) {
		this.statusColorClass = statusColorClass;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyPassingData [personName=");
		builder.append(personName);
		builder.append(", caseNumber=");
		builder.append(caseNumber);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", email=");
		builder.append(email);
		builder.append(", caseRequestId=");
		builder.append(caseRequestId);
		builder.append(", personId=");
		builder.append(personId);
		builder.append(", employer=");
		builder.append(employer);
		builder.append(", employee=");
		builder.append(employee);
		builder.append(", statusColorClass=");
		builder.append(statusColorClass);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", transitions=");
		builder.append(transitions);
		builder.append("]");
		return builder.toString();
	}

}