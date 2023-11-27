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

package gov.omsb.form.builder.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import gov.omsb.form.builder.model.FormDefinition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormDefinition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormDefinitionCacheModel
	implements CacheModel<FormDefinition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormDefinitionCacheModel)) {
			return false;
		}

		FormDefinitionCacheModel formDefinitionCacheModel =
			(FormDefinitionCacheModel)object;

		if (formDefinitionId == formDefinitionCacheModel.formDefinitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formDefinitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", formDefinitionId=");
		sb.append(formDefinitionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", formName=");
		sb.append(formName);
		sb.append(", formTitle=");
		sb.append(formTitle);
		sb.append(", formDescription=");
		sb.append(formDescription);
		sb.append(", formVersion=");
		sb.append(formVersion);
		sb.append(", formConfig=");
		sb.append(formConfig);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormDefinition toEntityModel() {
		FormDefinitionImpl formDefinitionImpl = new FormDefinitionImpl();

		if (uuid == null) {
			formDefinitionImpl.setUuid("");
		}
		else {
			formDefinitionImpl.setUuid(uuid);
		}

		formDefinitionImpl.setFormDefinitionId(formDefinitionId);
		formDefinitionImpl.setGroupId(groupId);
		formDefinitionImpl.setCompanyId(companyId);
		formDefinitionImpl.setCreatedBy(createdBy);
		formDefinitionImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			formDefinitionImpl.setCreatedDate(null);
		}
		else {
			formDefinitionImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formDefinitionImpl.setModifiedDate(null);
		}
		else {
			formDefinitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (formName == null) {
			formDefinitionImpl.setFormName("");
		}
		else {
			formDefinitionImpl.setFormName(formName);
		}

		if (formTitle == null) {
			formDefinitionImpl.setFormTitle("");
		}
		else {
			formDefinitionImpl.setFormTitle(formTitle);
		}

		if (formDescription == null) {
			formDefinitionImpl.setFormDescription("");
		}
		else {
			formDefinitionImpl.setFormDescription(formDescription);
		}

		if (formVersion == null) {
			formDefinitionImpl.setFormVersion("");
		}
		else {
			formDefinitionImpl.setFormVersion(formVersion);
		}

		if (formConfig == null) {
			formDefinitionImpl.setFormConfig("");
		}
		else {
			formDefinitionImpl.setFormConfig(formConfig);
		}

		formDefinitionImpl.setStatus(status);
		formDefinitionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			formDefinitionImpl.setStatusByUserName("");
		}
		else {
			formDefinitionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			formDefinitionImpl.setStatusDate(null);
		}
		else {
			formDefinitionImpl.setStatusDate(new Date(statusDate));
		}

		formDefinitionImpl.resetOriginalValues();

		return formDefinitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		formDefinitionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		formName = objectInput.readUTF();
		formTitle = objectInput.readUTF();
		formDescription = objectInput.readUTF();
		formVersion = objectInput.readUTF();
		formConfig = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(formDefinitionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (formName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formName);
		}

		if (formTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formTitle);
		}

		if (formDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formDescription);
		}

		if (formVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formVersion);
		}

		if (formConfig == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formConfig);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long formDefinitionId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
	public String formName;
	public String formTitle;
	public String formDescription;
	public String formVersion;
	public String formConfig;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}