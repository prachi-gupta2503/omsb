/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.email.template.master.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmailTemplateMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMaster
 * @generated
 */
public class EmailTemplateMasterWrapper
	extends BaseModelWrapper<EmailTemplateMaster>
	implements EmailTemplateMaster, ModelWrapper<EmailTemplateMaster> {

	public EmailTemplateMasterWrapper(EmailTemplateMaster emailTemplateMaster) {
		super(emailTemplateMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateName", getTemplateName());
		attributes.put("templateDescription", getTemplateDescription());
		attributes.put("senderType", getSenderType());
		attributes.put("senderEmailId", getSenderEmailId());
		attributes.put("defaultCC", getDefaultCC());
		attributes.put("defaultBCC", getDefaultBCC());
		attributes.put("subject", getSubject());
		attributes.put("dynamicBody", getDynamicBody());
		attributes.put("staticBody", getStaticBody());
		attributes.put("signature", getSignature());
		attributes.put("userNotification", getUserNotification());
		attributes.put("isRichText", isIsRichText());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		String templateDescription = (String)attributes.get(
			"templateDescription");

		if (templateDescription != null) {
			setTemplateDescription(templateDescription);
		}

		String senderType = (String)attributes.get("senderType");

		if (senderType != null) {
			setSenderType(senderType);
		}

		String senderEmailId = (String)attributes.get("senderEmailId");

		if (senderEmailId != null) {
			setSenderEmailId(senderEmailId);
		}

		String defaultCC = (String)attributes.get("defaultCC");

		if (defaultCC != null) {
			setDefaultCC(defaultCC);
		}

		String defaultBCC = (String)attributes.get("defaultBCC");

		if (defaultBCC != null) {
			setDefaultBCC(defaultBCC);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String dynamicBody = (String)attributes.get("dynamicBody");

		if (dynamicBody != null) {
			setDynamicBody(dynamicBody);
		}

		String staticBody = (String)attributes.get("staticBody");

		if (staticBody != null) {
			setStaticBody(staticBody);
		}

		String signature = (String)attributes.get("signature");

		if (signature != null) {
			setSignature(signature);
		}

		String userNotification = (String)attributes.get("userNotification");

		if (userNotification != null) {
			setUserNotification(userNotification);
		}

		Boolean isRichText = (Boolean)attributes.get("isRichText");

		if (isRichText != null) {
			setIsRichText(isRichText);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public EmailTemplateMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this email template master.
	 *
	 * @return the company ID of this email template master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this email template master.
	 *
	 * @return the created by of this email template master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this email template master.
	 *
	 * @return the created date of this email template master
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the default bcc of this email template master.
	 *
	 * @return the default bcc of this email template master
	 */
	@Override
	public String getDefaultBCC() {
		return model.getDefaultBCC();
	}

	/**
	 * Returns the default cc of this email template master.
	 *
	 * @return the default cc of this email template master
	 */
	@Override
	public String getDefaultCC() {
		return model.getDefaultCC();
	}

	/**
	 * Returns the dynamic body of this email template master.
	 *
	 * @return the dynamic body of this email template master
	 */
	@Override
	public String getDynamicBody() {
		return model.getDynamicBody();
	}

	/**
	 * Returns the group ID of this email template master.
	 *
	 * @return the group ID of this email template master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is rich text of this email template master.
	 *
	 * @return the is rich text of this email template master
	 */
	@Override
	public boolean getIsRichText() {
		return model.getIsRichText();
	}

	/**
	 * Returns the modified by of this email template master.
	 *
	 * @return the modified by of this email template master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this email template master.
	 *
	 * @return the modified date of this email template master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this email template master.
	 *
	 * @return the primary key of this email template master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sender email ID of this email template master.
	 *
	 * @return the sender email ID of this email template master
	 */
	@Override
	public String getSenderEmailId() {
		return model.getSenderEmailId();
	}

	/**
	 * Returns the sender type of this email template master.
	 *
	 * @return the sender type of this email template master
	 */
	@Override
	public String getSenderType() {
		return model.getSenderType();
	}

	/**
	 * Returns the signature of this email template master.
	 *
	 * @return the signature of this email template master
	 */
	@Override
	public String getSignature() {
		return model.getSignature();
	}

	/**
	 * Returns the static body of this email template master.
	 *
	 * @return the static body of this email template master
	 */
	@Override
	public String getStaticBody() {
		return model.getStaticBody();
	}

	/**
	 * Returns the subject of this email template master.
	 *
	 * @return the subject of this email template master
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the template description of this email template master.
	 *
	 * @return the template description of this email template master
	 */
	@Override
	public String getTemplateDescription() {
		return model.getTemplateDescription();
	}

	/**
	 * Returns the template ID of this email template master.
	 *
	 * @return the template ID of this email template master
	 */
	@Override
	public long getTemplateId() {
		return model.getTemplateId();
	}

	/**
	 * Returns the template name of this email template master.
	 *
	 * @return the template name of this email template master
	 */
	@Override
	public String getTemplateName() {
		return model.getTemplateName();
	}

	/**
	 * Returns the user notification of this email template master.
	 *
	 * @return the user notification of this email template master
	 */
	@Override
	public String getUserNotification() {
		return model.getUserNotification();
	}

	/**
	 * Returns <code>true</code> if this email template master is is rich text.
	 *
	 * @return <code>true</code> if this email template master is is rich text; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRichText() {
		return model.isIsRichText();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this email template master.
	 *
	 * @param companyId the company ID of this email template master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this email template master.
	 *
	 * @param createdBy the created by of this email template master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this email template master.
	 *
	 * @param createdDate the created date of this email template master
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the default bcc of this email template master.
	 *
	 * @param defaultBCC the default bcc of this email template master
	 */
	@Override
	public void setDefaultBCC(String defaultBCC) {
		model.setDefaultBCC(defaultBCC);
	}

	/**
	 * Sets the default cc of this email template master.
	 *
	 * @param defaultCC the default cc of this email template master
	 */
	@Override
	public void setDefaultCC(String defaultCC) {
		model.setDefaultCC(defaultCC);
	}

	/**
	 * Sets the dynamic body of this email template master.
	 *
	 * @param dynamicBody the dynamic body of this email template master
	 */
	@Override
	public void setDynamicBody(String dynamicBody) {
		model.setDynamicBody(dynamicBody);
	}

	/**
	 * Sets the group ID of this email template master.
	 *
	 * @param groupId the group ID of this email template master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this email template master is is rich text.
	 *
	 * @param isRichText the is rich text of this email template master
	 */
	@Override
	public void setIsRichText(boolean isRichText) {
		model.setIsRichText(isRichText);
	}

	/**
	 * Sets the modified by of this email template master.
	 *
	 * @param modifiedBy the modified by of this email template master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this email template master.
	 *
	 * @param modifiedDate the modified date of this email template master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this email template master.
	 *
	 * @param primaryKey the primary key of this email template master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sender email ID of this email template master.
	 *
	 * @param senderEmailId the sender email ID of this email template master
	 */
	@Override
	public void setSenderEmailId(String senderEmailId) {
		model.setSenderEmailId(senderEmailId);
	}

	/**
	 * Sets the sender type of this email template master.
	 *
	 * @param senderType the sender type of this email template master
	 */
	@Override
	public void setSenderType(String senderType) {
		model.setSenderType(senderType);
	}

	/**
	 * Sets the signature of this email template master.
	 *
	 * @param signature the signature of this email template master
	 */
	@Override
	public void setSignature(String signature) {
		model.setSignature(signature);
	}

	/**
	 * Sets the static body of this email template master.
	 *
	 * @param staticBody the static body of this email template master
	 */
	@Override
	public void setStaticBody(String staticBody) {
		model.setStaticBody(staticBody);
	}

	/**
	 * Sets the subject of this email template master.
	 *
	 * @param subject the subject of this email template master
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the template description of this email template master.
	 *
	 * @param templateDescription the template description of this email template master
	 */
	@Override
	public void setTemplateDescription(String templateDescription) {
		model.setTemplateDescription(templateDescription);
	}

	/**
	 * Sets the template ID of this email template master.
	 *
	 * @param templateId the template ID of this email template master
	 */
	@Override
	public void setTemplateId(long templateId) {
		model.setTemplateId(templateId);
	}

	/**
	 * Sets the template name of this email template master.
	 *
	 * @param templateName the template name of this email template master
	 */
	@Override
	public void setTemplateName(String templateName) {
		model.setTemplateName(templateName);
	}

	/**
	 * Sets the user notification of this email template master.
	 *
	 * @param userNotification the user notification of this email template master
	 */
	@Override
	public void setUserNotification(String userNotification) {
		model.setUserNotification(userNotification);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EmailTemplateMasterWrapper wrap(
		EmailTemplateMaster emailTemplateMaster) {

		return new EmailTemplateMasterWrapper(emailTemplateMaster);
	}

}