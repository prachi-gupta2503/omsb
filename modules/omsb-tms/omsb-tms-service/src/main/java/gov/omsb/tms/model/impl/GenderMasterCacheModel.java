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

import gov.omsb.tms.model.GenderMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GenderMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GenderMasterCacheModel
	implements CacheModel<GenderMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GenderMasterCacheModel)) {
			return false;
		}

		GenderMasterCacheModel genderMasterCacheModel =
			(GenderMasterCacheModel)object;

		if (genderMasterId == genderMasterCacheModel.genderMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, genderMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", genderMasterId=");
		sb.append(genderMasterId);
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
		sb.append(", genderName=");
		sb.append(genderName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GenderMaster toEntityModel() {
		GenderMasterImpl genderMasterImpl = new GenderMasterImpl();

		if (uuid == null) {
			genderMasterImpl.setUuid("");
		}
		else {
			genderMasterImpl.setUuid(uuid);
		}

		genderMasterImpl.setGenderMasterId(genderMasterId);
		genderMasterImpl.setGroupId(groupId);
		genderMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			genderMasterImpl.setCreateDate(null);
		}
		else {
			genderMasterImpl.setCreateDate(new Date(createDate));
		}

		genderMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			genderMasterImpl.setModifiedDate(null);
		}
		else {
			genderMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		genderMasterImpl.setModifiedBy(modifiedBy);

		if (genderName == null) {
			genderMasterImpl.setGenderName("");
		}
		else {
			genderMasterImpl.setGenderName(genderName);
		}

		genderMasterImpl.resetOriginalValues();

		return genderMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		genderMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		genderName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(genderMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (genderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(genderName);
		}
	}

	public String uuid;
	public long genderMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String genderName;

}