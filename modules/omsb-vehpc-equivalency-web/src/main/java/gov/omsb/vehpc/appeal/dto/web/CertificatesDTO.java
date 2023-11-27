package gov.omsb.vehpc.appeal.dto.web;

import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;

public class CertificatesDTO {

	private String equivalencylevelkey;
	private String certificatefileurl;
	private String comments;
	private String appealComments;
	private String certificateName;
	private long equivalencyLevelId;
	private EquivalencyLevel equivalencyLevel;
	private EquivalencyLevel equivalencyLevelReason;
	private EquivalencyLevel appealLevel;
	private EquivalencyLevel appealLevelReason;
	private long decisionLevelId;

	
	public EquivalencyLevel getEquivalencyLevelReason() {
		return equivalencyLevelReason;
	}

	public void setEquivalencyLevelReason(EquivalencyLevel equivalencyLevelReason) {
		this.equivalencyLevelReason = equivalencyLevelReason;
	}

	public EquivalencyLevel getAppealLevelReason() {
		return appealLevelReason;
	}

	public void setAppealLevelReason(EquivalencyLevel appealLevelReason) {
		this.appealLevelReason = appealLevelReason;
	}

	public String getAppealComments() {
		return appealComments;
	}

	public void setAppealComments(String appealComments) {
		this.appealComments = appealComments;
	}

	public EquivalencyLevel getAppealLevel() {
		return appealLevel;
	}

	public void setAppealLevel(EquivalencyLevel appealLevel) {
		this.appealLevel = appealLevel;
	}

	public long getDecisionLevelId() {
		return decisionLevelId;
	}

	public void setDecisionLevelId(long decisionLevelId) {
		this.decisionLevelId = decisionLevelId;
	}

	public EquivalencyLevel getEquivalencyLevel() {
		return equivalencyLevel;
	}

	public void setEquivalencyLevel(EquivalencyLevel equivalencyLevel) {
		this.equivalencyLevel = equivalencyLevel;
	}

	public long getEquivalencyLevelId() {
		return equivalencyLevelId;
	}

	public void setEquivalencyLevelId(long equivalencyLevelId) {
		this.equivalencyLevelId = equivalencyLevelId;
	}

	public String getEquivalencylevelkey() {
		return equivalencylevelkey;
	}

	public void setEquivalencylevelkey(String equivalencylevelkey) {
		this.equivalencylevelkey = equivalencylevelkey;
	}

	public String getCertificatefileurl() {
		return certificatefileurl;
	}

	public void setCertificatefileurl(String certificatefileurl) {
		this.certificatefileurl = certificatefileurl;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CertificatesDTO [equivalencylevelkey=");
		builder.append(equivalencylevelkey);
		builder.append(", certificatefileurl=");
		builder.append(certificatefileurl);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", appealComments=");
		builder.append(appealComments);
		builder.append(", certificateName=");
		builder.append(certificateName);
		builder.append(", equivalencyLevelId=");
		builder.append(equivalencyLevelId);
		builder.append(", equivalencyLevel=");
		builder.append(equivalencyLevel);
		builder.append(", equivalencyLevelReason=");
		builder.append(equivalencyLevelReason);
		builder.append(", appealLevel=");
		builder.append(appealLevel);
		builder.append(", appealLevelReason=");
		builder.append(appealLevelReason);
		builder.append(", decisionLevelId=");
		builder.append(decisionLevelId);
		builder.append("]");
		return builder.toString();
	}

}
