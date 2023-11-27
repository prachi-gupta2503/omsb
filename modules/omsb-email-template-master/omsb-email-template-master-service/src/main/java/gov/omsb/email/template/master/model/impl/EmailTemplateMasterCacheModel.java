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

package gov.omsb.email.template.master.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import gov.omsb.email.template.master.model.EmailTemplateMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmailTemplateMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmailTemplateMasterCacheModel
	implements CacheModel<EmailTemplateMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmailTemplateMasterCacheModel)) {
			return false;
		}

		EmailTemplateMasterCacheModel emailTemplateMasterCacheModel =
			(EmailTemplateMasterCacheModel)object;

		if (templateId == emailTemplateMasterCacheModel.templateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, templateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{templateId=");
		sb.append(templateId);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", templateDescription=");
		sb.append(templateDescription);
		sb.append(", senderType=");
		sb.append(senderType);
		sb.append(", senderEmailId=");
		sb.append(senderEmailId);
		sb.append(", defaultCC=");
		sb.append(defaultCC);
		sb.append(", defaultBCC=");
		sb.append(defaultBCC);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", dynamicBody=");
		sb.append(dynamicBody);
		sb.append(", staticBody=");
		sb.append(staticBody);
		sb.append(", signature=");
		sb.append(signature);
		sb.append(", userNotification=");
		sb.append(userNotification);
		sb.append(", isRichText=");
		sb.append(isRichText);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmailTemplateMaster toEntityModel() {
		EmailTemplateMasterImpl emailTemplateMasterImpl =
			new EmailTemplateMasterImpl();

		emailTemplateMasterImpl.setTemplateId(templateId);

		if (templateName == null) {
			emailTemplateMasterImpl.setTemplateName("");
		}
		else {
			emailTemplateMasterImpl.setTemplateName(templateName);
		}

		if (templateDescription == null) {
			emailTemplateMasterImpl.setTemplateDescription("");
		}
		else {
			emailTemplateMasterImpl.setTemplateDescription(templateDescription);
		}

		if (senderType == null) {
			emailTemplateMasterImpl.setSenderType("");
		}
		else {
			emailTemplateMasterImpl.setSenderType(senderType);
		}

		if (senderEmailId == null) {
			emailTemplateMasterImpl.setSenderEmailId("");
		}
		else {
			emailTemplateMasterImpl.setSenderEmailId(senderEmailId);
		}

		if (defaultCC == null) {
			emailTemplateMasterImpl.setDefaultCC("");
		}
		else {
			emailTemplateMasterImpl.setDefaultCC(defaultCC);
		}

		if (defaultBCC == null) {
			emailTemplateMasterImpl.setDefaultBCC("");
		}
		else {
			emailTemplateMasterImpl.setDefaultBCC(defaultBCC);
		}

		if (subject == null) {
			emailTemplateMasterImpl.setSubject("");
		}
		else {
			emailTemplateMasterImpl.setSubject(subject);
		}

		if (dynamicBody == null) {
			emailTemplateMasterImpl.setDynamicBody("");
		}
		else {
			emailTemplateMasterImpl.setDynamicBody(dynamicBody);
		}

		if (staticBody == null) {
			emailTemplateMasterImpl.setStaticBody("");
		}
		else {
			emailTemplateMasterImpl.setStaticBody(staticBody);
		}

		if (signature == null) {
			emailTemplateMasterImpl.setSignature("");
		}
		else {
			emailTemplateMasterImpl.setSignature(signature);
		}

		if (userNotification == null) {
			emailTemplateMasterImpl.setUserNotification("");
		}
		else {
			emailTemplateMasterImpl.setUserNotification(userNotification);
		}

		emailTemplateMasterImpl.setIsRichText(isRichText);
		emailTemplateMasterImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			emailTemplateMasterImpl.setCreatedDate(null);
		}
		else {
			emailTemplateMasterImpl.setCreatedDate(new Date(createdDate));
		}

		emailTemplateMasterImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			emailTemplateMasterImpl.setModifiedDate(null);
		}
		else {
			emailTemplateMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		emailTemplateMasterImpl.setGroupId(groupId);
		emailTemplateMasterImpl.setCompanyId(companyId);

		emailTemplateMasterImpl.resetOriginalValues();

		return emailTemplateMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		templateId = objectInput.readLong();
		templateName = objectInput.readUTF();
		templateDescription = objectInput.readUTF();
		senderType = objectInput.readUTF();
		senderEmailId = objectInput.readUTF();
		defaultCC = objectInput.readUTF();
		defaultBCC = objectInput.readUTF();
		subject = (String)objectInput.readObject();
		dynamicBody = (String)objectInput.readObject();
		staticBody = (String)objectInput.readObject();
		signature = (String)objectInput.readObject();
		userNotification = (String)objectInput.readObject();

		isRichText = objectInput.readBoolean();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(templateId);

		if (templateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		if (templateDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateDescription);
		}

		if (senderType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(senderType);
		}

		if (senderEmailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(senderEmailId);
		}

		if (defaultCC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultCC);
		}

		if (defaultBCC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultBCC);
		}

		if (subject == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(subject);
		}

		if (dynamicBody == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(dynamicBody);
		}

		if (staticBody == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(staticBody);
		}

		if (signature == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(signature);
		}

		if (userNotification == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(userNotification);
		}

		objectOutput.writeBoolean(isRichText);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
	}

	public long templateId;
	public String templateName;
	public String templateDescription;
	public String senderType;
	public String senderEmailId;
	public String defaultCC;
	public String defaultBCC;
	public String subject;
	public String dynamicBody;
	public String staticBody;
	public String signature;
	public String userNotification;
	public boolean isRichText;
	public long createdBy;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long groupId;
	public long companyId;

}