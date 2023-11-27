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

import gov.omsb.tms.model.RotationTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RotationTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RotationTypeMasterCacheModel
	implements CacheModel<RotationTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RotationTypeMasterCacheModel)) {
			return false;
		}

		RotationTypeMasterCacheModel rotationTypeMasterCacheModel =
			(RotationTypeMasterCacheModel)object;

		if (rotationTypeMasterId ==
				rotationTypeMasterCacheModel.rotationTypeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rotationTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rotationTypeMasterId=");
		sb.append(rotationTypeMasterId);
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
		sb.append(", rotationTypeName=");
		sb.append(rotationTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RotationTypeMaster toEntityModel() {
		RotationTypeMasterImpl rotationTypeMasterImpl =
			new RotationTypeMasterImpl();

		if (uuid == null) {
			rotationTypeMasterImpl.setUuid("");
		}
		else {
			rotationTypeMasterImpl.setUuid(uuid);
		}

		rotationTypeMasterImpl.setRotationTypeMasterId(rotationTypeMasterId);
		rotationTypeMasterImpl.setGroupId(groupId);
		rotationTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			rotationTypeMasterImpl.setCreateDate(null);
		}
		else {
			rotationTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		rotationTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			rotationTypeMasterImpl.setModifiedDate(null);
		}
		else {
			rotationTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		rotationTypeMasterImpl.setModifiedBy(modifiedBy);

		if (rotationTypeName == null) {
			rotationTypeMasterImpl.setRotationTypeName("");
		}
		else {
			rotationTypeMasterImpl.setRotationTypeName(rotationTypeName);
		}

		rotationTypeMasterImpl.resetOriginalValues();

		return rotationTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rotationTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		rotationTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rotationTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (rotationTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationTypeName);
		}
	}

	public String uuid;
	public long rotationTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String rotationTypeName;

}