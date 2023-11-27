package gov.omsb.email.template.master.common.dto;

import java.util.Date;

public class EmailTemplateMasterDTO {
	
	private long templateId;
	private String templateName;
	private String templateDescription;
	private String senderType;
	private String senderEmailId;
	private String defaultCC;
	private String defaultBCC;
	private String subjectEnUS;
	private String subjectArSA;
	private String dynamicBodyEnUS;
	private String dynamicBodyArSA;
	private String staticBodyEnUS;
	private String staticBodyArSA;
	private String signatureEnUS;
	private String signatureArSA;
	private String userNotificationEnUS;
	private String userNotificationArSA;
	private boolean isRichText;
	private long createdBy;
	private Date createdDate;
	private long modifiedBy;
	private Date modifiedDate;
	private long groupId;
	private long companyId;
	
	public EmailTemplateMasterDTO() {
		super();
	}
	
	public EmailTemplateMasterDTO(long templateId, String templateName, String templateDescription, String senderType,
			String senderEmailId, String defaultCC, String defaultBCC, String subjectEnUS, String subjectArSA,
			String dynamicBodyEnUS, String dynamicBodyArSA, String staticBodyEnUS, String staticBodyArSA,
			String signatureEnUS, String signatureArSA, String userNotificationEnUS, String userNotificationArSA,
			boolean isRichText, long createdBy, Date createdDate, long modifiedBy, Date modifiedDate, long groupId,
			long companyId) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.templateDescription = templateDescription;
		this.senderType = senderType;
		this.senderEmailId = senderEmailId;
		this.defaultCC = defaultCC;
		this.defaultBCC = defaultBCC;
		this.subjectEnUS = subjectEnUS;
		this.subjectArSA = subjectArSA;
		this.dynamicBodyEnUS = dynamicBodyEnUS;
		this.dynamicBodyArSA = dynamicBodyArSA;
		this.staticBodyEnUS = staticBodyEnUS;
		this.staticBodyArSA = staticBodyArSA;
		this.signatureEnUS = signatureEnUS;
		this.signatureArSA = signatureArSA;
		this.userNotificationEnUS = userNotificationEnUS;
		this.userNotificationArSA = userNotificationArSA;
		this.isRichText = isRichText;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.groupId = groupId;
		this.companyId = companyId;
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplateDescription() {
		return templateDescription;
	}
	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}
	public String getSenderType() {
		return senderType;
	}
	public void setSenderType(String senderType) {
		this.senderType = senderType;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getDefaultCC() {
		return defaultCC;
	}
	public void setDefaultCC(String defaultCC) {
		this.defaultCC = defaultCC;
	}
	public String getDefaultBCC() {
		return defaultBCC;
	}
	public void setDefaultBCC(String defaultBCC) {
		this.defaultBCC = defaultBCC;
	}
	public String getSubjectEnUS() {
		return subjectEnUS;
	}
	public void setSubjectEnUS(String subjectEnUS) {
		this.subjectEnUS = subjectEnUS;
	}
	public String getSubjectArSA() {
		return subjectArSA;
	}
	public void setSubjectArSA(String subjectArSA) {
		this.subjectArSA = subjectArSA;
	}
	public String getDynamicBodyEnUS() {
		return dynamicBodyEnUS;
	}
	public void setDynamicBodyEnUS(String dynamicBodyEnUS) {
		this.dynamicBodyEnUS = dynamicBodyEnUS;
	}
	public String getDynamicBodyArSA() {
		return dynamicBodyArSA;
	}
	public void setDynamicBodyArSA(String dynamicBodyArSA) {
		this.dynamicBodyArSA = dynamicBodyArSA;
	}
	public String getStaticBodyEnUS() {
		return staticBodyEnUS;
	}
	public void setStaticBodyEnUS(String staticBodyEnUS) {
		this.staticBodyEnUS = staticBodyEnUS;
	}
	public String getStaticBodyArSA() {
		return staticBodyArSA;
	}
	public void setStaticBodyArSA(String staticBodyArSA) {
		this.staticBodyArSA = staticBodyArSA;
	}
	public String getSignatureEnUS() {
		return signatureEnUS;
	}
	public void setSignatureEnUS(String signatureEnUS) {
		this.signatureEnUS = signatureEnUS;
	}
	public String getSignatureArSA() {
		return signatureArSA;
	}
	public void setSignatureArSA(String signatureArSA) {
		this.signatureArSA = signatureArSA;
	}
	public String getUserNotificationEnUS() {
		return userNotificationEnUS;
	}
	public void setUserNotificationEnUS(String userNotificationEnUS) {
		this.userNotificationEnUS = userNotificationEnUS;
	}
	public String getUserNotificationArSA() {
		return userNotificationArSA;
	}
	public void setUserNotificationArSA(String userNotificationArSA) {
		this.userNotificationArSA = userNotificationArSA;
	}
	public boolean isRichText() {
		return isRichText;
	}
	public void setRichText(boolean isRichText) {
		this.isRichText = isRichText;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
}
