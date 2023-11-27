package omsb.vehpc.equivalency.dto.web;

public class EquivalencyDecision {
	private long id;
	private long documentInfoId;
	private String otherEquivalency;
	private long decisionBy;
	private String comments;
	private EquivalencyLevel equivalencyLevelId;
	private long eqDecisionLevelId;
	private long equivalencyRequestId;
	private boolean isAdmin;
	private String qualification;
	private EquivalencyStatus equivalencyStatus;
	private String dateModified;

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public EquivalencyStatus getEquivalencyStatus() {
		return equivalencyStatus;
	}

	public void setEquivalencyStatus(EquivalencyStatus equivalencyStatus) {
		this.equivalencyStatus = equivalencyStatus;
	}

	public long getEqDecisionLevelId() {
		return eqDecisionLevelId;
	}

	public void setEqDecisionLevelId(long eqDecisionLevelId) {
		this.eqDecisionLevelId = eqDecisionLevelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDocumentInfoId() {
		return documentInfoId;
	}

	public void setDocumentInfoId(long documentInfoId) {
		this.documentInfoId = documentInfoId;
	}

	public String getOtherEquivalency() {
		return otherEquivalency;
	}

	public void setOtherEquivalency(String otherEquivalency) {
		this.otherEquivalency = otherEquivalency;
	}

	public long getDecisionBy() {
		return decisionBy;
	}

	public void setDecisionBy(long decisionBy) {
		this.decisionBy = decisionBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public EquivalencyLevel getEquivalencyLevelId() {
		return equivalencyLevelId;
	}

	public void setEquivalencyLevelId(EquivalencyLevel equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}

	public long getEquivalencyRequestId() {
		return equivalencyRequestId;
	}

	public void setEquivalencyRequestId(long equivalencyRequestId) {
		this.equivalencyRequestId = equivalencyRequestId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyDecision [id=");
		builder.append(id);
		builder.append(", documentInfoId=");
		builder.append(documentInfoId);
		builder.append(", otherEquivalency=");
		builder.append(otherEquivalency);
		builder.append(", decisionBy=");
		builder.append(decisionBy);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", equivalencyLevelId=");
		builder.append(equivalencyLevelId);
		builder.append(", eqDecisionLevelId=");
		builder.append(eqDecisionLevelId);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append("]");
		return builder.toString();
	}

}
