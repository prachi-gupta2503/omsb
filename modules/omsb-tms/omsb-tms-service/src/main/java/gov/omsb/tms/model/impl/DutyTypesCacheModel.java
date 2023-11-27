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

package gov.omsb.tms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import gov.omsb.tms.model.DutyTypes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DutyTypes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DutyTypesCacheModel
	implements CacheModel<DutyTypes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyTypesCacheModel)) {
			return false;
		}

		DutyTypesCacheModel dutyTypesCacheModel = (DutyTypesCacheModel)object;

		if (dutyTypeId == dutyTypesCacheModel.dutyTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dutyTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dutyTypeId=");
		sb.append(dutyTypeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", dutyType=");
		sb.append(dutyType);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DutyTypes toEntityModel() {
		DutyTypesImpl dutyTypesImpl = new DutyTypesImpl();

		if (uuid == null) {
			dutyTypesImpl.setUuid("");
		}
		else {
			dutyTypesImpl.setUuid(uuid);
		}

		dutyTypesImpl.setDutyTypeId(dutyTypeId);
		dutyTypesImpl.setGroupId(groupId);
		dutyTypesImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dutyTypesImpl.setCreateDate(null);
		}
		else {
			dutyTypesImpl.setCreateDate(new Date(createDate));
		}

		dutyTypesImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dutyTypesImpl.setModifiedDate(null);
		}
		else {
			dutyTypesImpl.setModifiedDate(new Date(modifiedDate));
		}

		dutyTypesImpl.setModifiedBy(modifiedBy);

		if (dutyType == null) {
			dutyTypesImpl.setDutyType("");
		}
		else {
			dutyTypesImpl.setDutyType(dutyType);
		}

		if (status == null) {
			dutyTypesImpl.setStatus("");
		}
		else {
			dutyTypesImpl.setStatus(status);
		}

		dutyTypesImpl.resetOriginalValues();

		return dutyTypesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dutyTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		dutyType = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dutyTypeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (dutyType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dutyType);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long dutyTypeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String dutyType;
	public String status;

}