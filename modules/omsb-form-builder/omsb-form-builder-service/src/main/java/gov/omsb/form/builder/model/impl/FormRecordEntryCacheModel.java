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

import gov.omsb.form.builder.model.FormRecordEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FormRecordEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormRecordEntryCacheModel
	implements CacheModel<FormRecordEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormRecordEntryCacheModel)) {
			return false;
		}

		FormRecordEntryCacheModel formRecordEntryCacheModel =
			(FormRecordEntryCacheModel)object;

		if (formRecordEntryId == formRecordEntryCacheModel.formRecordEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formRecordEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", formRecordEntryId=");
		sb.append(formRecordEntryId);
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
		sb.append(", formDefinitionId=");
		sb.append(formDefinitionId);
		sb.append(", recordId=");
		sb.append(recordId);
		sb.append(", dfTableName=");
		sb.append(dfTableName);
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
	public FormRecordEntry toEntityModel() {
		FormRecordEntryImpl formRecordEntryImpl = new FormRecordEntryImpl();

		if (uuid == null) {
			formRecordEntryImpl.setUuid("");
		}
		else {
			formRecordEntryImpl.setUuid(uuid);
		}

		formRecordEntryImpl.setFormRecordEntryId(formRecordEntryId);
		formRecordEntryImpl.setGroupId(groupId);
		formRecordEntryImpl.setCompanyId(companyId);
		formRecordEntryImpl.setCreatedBy(createdBy);
		formRecordEntryImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			formRecordEntryImpl.setCreatedDate(null);
		}
		else {
			formRecordEntryImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			formRecordEntryImpl.setModifiedDate(null);
		}
		else {
			formRecordEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		formRecordEntryImpl.setFormDefinitionId(formDefinitionId);
		formRecordEntryImpl.setRecordId(recordId);

		if (dfTableName == null) {
			formRecordEntryImpl.setDfTableName("");
		}
		else {
			formRecordEntryImpl.setDfTableName(dfTableName);
		}

		formRecordEntryImpl.setStatus(status);
		formRecordEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			formRecordEntryImpl.setStatusByUserName("");
		}
		else {
			formRecordEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			formRecordEntryImpl.setStatusDate(null);
		}
		else {
			formRecordEntryImpl.setStatusDate(new Date(statusDate));
		}

		formRecordEntryImpl.resetOriginalValues();

		return formRecordEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		formRecordEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		formDefinitionId = objectInput.readLong();

		recordId = objectInput.readLong();
		dfTableName = objectInput.readUTF();

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

		objectOutput.writeLong(formRecordEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(formDefinitionId);

		objectOutput.writeLong(recordId);

		if (dfTableName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dfTableName);
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
	public long formRecordEntryId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
	public long formDefinitionId;
	public long recordId;
	public String dfTableName;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}