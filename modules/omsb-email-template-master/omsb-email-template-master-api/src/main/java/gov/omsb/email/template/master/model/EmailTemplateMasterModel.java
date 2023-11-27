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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EmailTemplateMaster service. Represents a row in the &quot;omsb_email_template&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.email.template.master.model.impl.EmailTemplateMasterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.email.template.master.model.impl.EmailTemplateMasterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMaster
 * @generated
 */
@ProviderType
public interface EmailTemplateMasterModel
	extends BaseModel<EmailTemplateMaster>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a email template master model instance should use the {@link EmailTemplateMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this email template master.
	 *
	 * @return the primary key of this email template master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this email template master.
	 *
	 * @param primaryKey the primary key of this email template master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the template ID of this email template master.
	 *
	 * @return the template ID of this email template master
	 */
	public long getTemplateId();

	/**
	 * Sets the template ID of this email template master.
	 *
	 * @param templateId the template ID of this email template master
	 */
	public void setTemplateId(long templateId);

	/**
	 * Returns the template name of this email template master.
	 *
	 * @return the template name of this email template master
	 */
	@AutoEscape
	public String getTemplateName();

	/**
	 * Sets the template name of this email template master.
	 *
	 * @param templateName the template name of this email template master
	 */
	public void setTemplateName(String templateName);

	/**
	 * Returns the template description of this email template master.
	 *
	 * @return the template description of this email template master
	 */
	@AutoEscape
	public String getTemplateDescription();

	/**
	 * Sets the template description of this email template master.
	 *
	 * @param templateDescription the template description of this email template master
	 */
	public void setTemplateDescription(String templateDescription);

	/**
	 * Returns the sender type of this email template master.
	 *
	 * @return the sender type of this email template master
	 */
	@AutoEscape
	public String getSenderType();

	/**
	 * Sets the sender type of this email template master.
	 *
	 * @param senderType the sender type of this email template master
	 */
	public void setSenderType(String senderType);

	/**
	 * Returns the sender email ID of this email template master.
	 *
	 * @return the sender email ID of this email template master
	 */
	@AutoEscape
	public String getSenderEmailId();

	/**
	 * Sets the sender email ID of this email template master.
	 *
	 * @param senderEmailId the sender email ID of this email template master
	 */
	public void setSenderEmailId(String senderEmailId);

	/**
	 * Returns the default cc of this email template master.
	 *
	 * @return the default cc of this email template master
	 */
	@AutoEscape
	public String getDefaultCC();

	/**
	 * Sets the default cc of this email template master.
	 *
	 * @param defaultCC the default cc of this email template master
	 */
	public void setDefaultCC(String defaultCC);

	/**
	 * Returns the default bcc of this email template master.
	 *
	 * @return the default bcc of this email template master
	 */
	@AutoEscape
	public String getDefaultBCC();

	/**
	 * Sets the default bcc of this email template master.
	 *
	 * @param defaultBCC the default bcc of this email template master
	 */
	public void setDefaultBCC(String defaultBCC);

	/**
	 * Returns the subject of this email template master.
	 *
	 * @return the subject of this email template master
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this email template master.
	 *
	 * @param subject the subject of this email template master
	 */
	public void setSubject(String subject);

	/**
	 * Returns the dynamic body of this email template master.
	 *
	 * @return the dynamic body of this email template master
	 */
	@AutoEscape
	public String getDynamicBody();

	/**
	 * Sets the dynamic body of this email template master.
	 *
	 * @param dynamicBody the dynamic body of this email template master
	 */
	public void setDynamicBody(String dynamicBody);

	/**
	 * Returns the static body of this email template master.
	 *
	 * @return the static body of this email template master
	 */
	@AutoEscape
	public String getStaticBody();

	/**
	 * Sets the static body of this email template master.
	 *
	 * @param staticBody the static body of this email template master
	 */
	public void setStaticBody(String staticBody);

	/**
	 * Returns the signature of this email template master.
	 *
	 * @return the signature of this email template master
	 */
	@AutoEscape
	public String getSignature();

	/**
	 * Sets the signature of this email template master.
	 *
	 * @param signature the signature of this email template master
	 */
	public void setSignature(String signature);

	/**
	 * Returns the user notification of this email template master.
	 *
	 * @return the user notification of this email template master
	 */
	@AutoEscape
	public String getUserNotification();

	/**
	 * Sets the user notification of this email template master.
	 *
	 * @param userNotification the user notification of this email template master
	 */
	public void setUserNotification(String userNotification);

	/**
	 * Returns the is rich text of this email template master.
	 *
	 * @return the is rich text of this email template master
	 */
	public boolean getIsRichText();

	/**
	 * Returns <code>true</code> if this email template master is is rich text.
	 *
	 * @return <code>true</code> if this email template master is is rich text; <code>false</code> otherwise
	 */
	public boolean isIsRichText();

	/**
	 * Sets whether this email template master is is rich text.
	 *
	 * @param isRichText the is rich text of this email template master
	 */
	public void setIsRichText(boolean isRichText);

	/**
	 * Returns the created by of this email template master.
	 *
	 * @return the created by of this email template master
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this email template master.
	 *
	 * @param createdBy the created by of this email template master
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created date of this email template master.
	 *
	 * @return the created date of this email template master
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this email template master.
	 *
	 * @param createdDate the created date of this email template master
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this email template master.
	 *
	 * @return the modified by of this email template master
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this email template master.
	 *
	 * @param modifiedBy the modified by of this email template master
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this email template master.
	 *
	 * @return the modified date of this email template master
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this email template master.
	 *
	 * @param modifiedDate the modified date of this email template master
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the group ID of this email template master.
	 *
	 * @return the group ID of this email template master
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this email template master.
	 *
	 * @param groupId the group ID of this email template master
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this email template master.
	 *
	 * @return the company ID of this email template master
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this email template master.
	 *
	 * @param companyId the company ID of this email template master
	 */
	@Override
	public void setCompanyId(long companyId);

	@Override
	public EmailTemplateMaster cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}