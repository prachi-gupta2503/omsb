package gov.omsb.vehpc.appeal.dto.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import omsb.vehpc.equivalency.dto.web.DocumentInfo;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquivalencyAppealStatus {

	private long eQAppealId;

	private long statusId;

	private long eqLevelId;

	private boolean iscommitte;

	private boolean isAdmin;

	private boolean isPresident;

	private long lruserId;

	private String message;

	private String dateCreated;

	private String fullName;
	
	private String eqLevel;

	private String roleType;

	private List<DocumentInfo> documentList;
	
	@JsonProperty("equivalencyLevel")
	private String equivalencyLevelKey;
	
	private String equivalencyLevelName;
	
	@JsonProperty("equivalencyLevelReason")
	private String equivalencyLevelReasonKey;
	
	private String equivalencyLevelReasonName;
	
	private String equivalencyCertificate;

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEquivalencyCertificate() {
		return equivalencyCertificate;
	}

	public void setEquivalencyCertificate(String equivalencyCertificate) {
		this.equivalencyCertificate = equivalencyCertificate;
	}

	public List<DocumentInfo> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<DocumentInfo> documentList) {
		this.documentList = documentList;
	}

	public String getEqLevel() {
		return eqLevel;
	}

	public void setEqLevel(String eqLevel) {
		this.eqLevel = eqLevel;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long geteQAppealId() {
		return eQAppealId;
	}

	public void seteQAppealId(long eQAppealId) {
		this.eQAppealId = eQAppealId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getEqLevelId() {
		return eqLevelId;
	}

	public void setEqLevelId(long eqLevelId) {
		this.eqLevelId = eqLevelId;
	}

	public boolean isIscommitte() {
		return iscommitte;
	}

	public void setIscommitte(boolean iscommitte) {
		this.iscommitte = iscommitte;
	}

	public boolean isIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isIsAdmin) {
		this.isAdmin = isIsAdmin;
	}

	public boolean isIsPresident() {
		return isPresident;
	}

	public void setIsPresident(boolean isIsPresident) {
		this.isPresident = isIsPresident;
	}

	public long getLruserId() {
		return lruserId;
	}

	public void setLruserId(long lruserId) {
		this.lruserId = lruserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isPresident() {
		return isPresident;
	}

	public void setPresident(boolean isPresident) {
		this.isPresident = isPresident;
	}

	public String getEquivalencyLevelKey() {
		return equivalencyLevelKey;
	}

	public void setEquivalencyLevelKey(String equivalencyLevelKey) {
		this.equivalencyLevelKey = equivalencyLevelKey;
	}

	public String getEquivalencyLevelName() {
		return equivalencyLevelName;
	}

	public void setEquivalencyLevelName(String equivalencyLevelName) {
		this.equivalencyLevelName = equivalencyLevelName;
	}

	public String getEquivalencyLevelReasonKey() {
		return equivalencyLevelReasonKey;
	}

	public void setEquivalencyLevelReasonKey(String equivalencyLevelReasonKey) {
		this.equivalencyLevelReasonKey = equivalencyLevelReasonKey;
	}
	
	public String getEquivalencyLevelReasonName() {
		return equivalencyLevelReasonName;
	}

	public void setEquivalencyLevelReasonName(String equivalencyLevelReasonName) {
		this.equivalencyLevelReasonName = equivalencyLevelReasonName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EquivalencyAppealStatus [eQAppealId=");
		builder.append(eQAppealId);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append(", eqLevelId=");
		builder.append(eqLevelId);
		builder.append(", iscommitte=");
		builder.append(iscommitte);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append(", isPresident=");
		builder.append(isPresident);
		builder.append(", lruserId=");
		builder.append(lruserId);
		builder.append(", message=");
		builder.append(message);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", eqLevel=");
		builder.append(eqLevel);
		builder.append(", roleType=");
		builder.append(roleType);
		builder.append(", documentList=");
		builder.append(documentList);
		builder.append(", equivalencyLevelKey=");
		builder.append(equivalencyLevelKey);
		builder.append(", equivalencyLevelName=");
		builder.append(equivalencyLevelName);
		builder.append(", equivalencyLevelReasonKey=");
		builder.append(equivalencyLevelReasonKey);
		builder.append(", equivalencyLevelReasonName=");
		builder.append(equivalencyLevelReasonName);
		builder.append(", id=");
		builder.append(id);
		builder.append(", equivalencyCertificate=");
		builder.append(equivalencyCertificate);
		builder.append("]");
		return builder.toString();
	}

	
	
		
}
