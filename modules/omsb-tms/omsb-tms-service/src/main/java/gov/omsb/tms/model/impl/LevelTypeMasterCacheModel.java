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

import gov.omsb.tms.model.LevelTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LevelTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LevelTypeMasterCacheModel
	implements CacheModel<LevelTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LevelTypeMasterCacheModel)) {
			return false;
		}

		LevelTypeMasterCacheModel levelTypeMasterCacheModel =
			(LevelTypeMasterCacheModel)object;

		if (LevelTypeMasterId == levelTypeMasterCacheModel.LevelTypeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, LevelTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", LevelTypeMasterId=");
		sb.append(LevelTypeMasterId);
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
		sb.append(", levelTypeName=");
		sb.append(levelTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LevelTypeMaster toEntityModel() {
		LevelTypeMasterImpl levelTypeMasterImpl = new LevelTypeMasterImpl();

		if (uuid == null) {
			levelTypeMasterImpl.setUuid("");
		}
		else {
			levelTypeMasterImpl.setUuid(uuid);
		}

		levelTypeMasterImpl.setLevelTypeMasterId(LevelTypeMasterId);
		levelTypeMasterImpl.setGroupId(groupId);
		levelTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			levelTypeMasterImpl.setCreateDate(null);
		}
		else {
			levelTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		levelTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			levelTypeMasterImpl.setModifiedDate(null);
		}
		else {
			levelTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		levelTypeMasterImpl.setModifiedBy(modifiedBy);

		if (levelTypeName == null) {
			levelTypeMasterImpl.setLevelTypeName("");
		}
		else {
			levelTypeMasterImpl.setLevelTypeName(levelTypeName);
		}

		levelTypeMasterImpl.resetOriginalValues();

		return levelTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		LevelTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		levelTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(LevelTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (levelTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(levelTypeName);
		}
	}

	public String uuid;
	public long LevelTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String levelTypeName;

}