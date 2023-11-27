package omsb.vehpc.equivalency.dto.web;

import java.util.Date;

public class EquivalencyRequestStatus {
	private long id;
	private long equivalencyRequestId;
	private EquivalencyStatus equivalencyStatusId;
	private String comments;
	private long commenterUserId;
	private String dateCreated;
	private String equivalencyLevel;
	private String equivalencyLevelReason;
	private String dateModified;
	
	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getEquivalencyCertificate() {
		return equivalencyCertificate;
	}

	public void setEquivalencyCertificate(String equivalencyCertificate) {
		this.equivalencyCertificate = equivalencyCertificate;
	}

	private String equivalencyCertificate;

	public String getEquivalencyLevel() {
		return equivalencyLevel;
	}

	public void setEquivalencyLevel(String equivalencyLevel) {
		this.equivalencyLevel = equivalencyLevel;
	}

	public String getEquivalencyLevelReason() {
		return equivalencyLevelReason;
	}

	public void setEquivalencyLevelReason(String equivalencyLevelReason) {
		this.equivalencyLevelReason = equivalencyLevelReason;
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

	public EquivalencyStatus getEquivalencyStatusId() {
		return equivalencyStatusId;
	}

	public void setEquivalencyStatusId(EquivalencyStatus equivalencyStatusId) {
		this.equivalencyStatusId = equivalencyStatusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getCommenterUserId() {
		return commenterUserId;
	}

	public void setCommenterUserId(long commenterUserId) {
		this.commenterUserId = commenterUserId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyRequestStatus [id=");
		builder.append(id);
		builder.append(", equivalencyRequestId=");
		builder.append(equivalencyRequestId);
		builder.append(", equivalencyStatusId=");
		builder.append(equivalencyStatusId);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", commenterUserId=");
		builder.append(commenterUserId);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", equivalencyLevel=");
		builder.append(equivalencyLevel);
		builder.append(", equivalencyLevelReason=");
		builder.append(equivalencyLevelReason);
		builder.append(", dateModified=");
		builder.append(dateModified);
		builder.append(", equivalencyCertificate=");
		builder.append(equivalencyCertificate);
		builder.append("]");
		return builder.toString();
	}

}
