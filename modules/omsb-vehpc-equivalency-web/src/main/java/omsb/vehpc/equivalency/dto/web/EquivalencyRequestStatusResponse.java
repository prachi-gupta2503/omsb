package omsb.vehpc.equivalency.dto.web;

import java.util.List;

public class EquivalencyRequestStatusResponse {
	private long id;
	private long equivalencyRequestId;
	//private EquivalencyStatus equivalencyStatusId;
	private EquivalencyStatus equivalencyStatusId;
	private String comments;
	private long commenterUserId;
	private String name;
	private String dateCreated;
	private String role;
	private String equivalencyCertificate;
	private String equivalencyLevel;
	private String equivalencyLevelReason;
	private List<DocumentInfo> documentList;

	public String getEquivalencyCertificate() {
		return equivalencyCertificate;
	}

	public void setEquivalencyCertificate(String equivalencyCertificate) {
		this.equivalencyCertificate = equivalencyCertificate;
	}

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

	public List<DocumentInfo> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<DocumentInfo> documentList) {
		this.documentList = documentList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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
	/*
	 * public long getEquivalencyStatusId() { return equivalencyStatusId; } public
	 * void setEquivalencyStatusId(long equivalencyStatusId) {
	 * this.equivalencyStatusId = equivalencyStatusId; }
	 */
	/*
	 * public EquivalencyStatus getEquivalencyStatusId() { return
	 * equivalencyStatusId; } public void setEquivalencyStatusId(EquivalencyStatus
	 * equivalencyStatusId) { this.equivalencyStatusId = equivalencyStatusId; }
	 */
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	
}
