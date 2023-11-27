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

import gov.omsb.form.builder.model.RangeOptionMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RangeOptionMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RangeOptionMasterCacheModel
	implements CacheModel<RangeOptionMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RangeOptionMasterCacheModel)) {
			return false;
		}

		RangeOptionMasterCacheModel rangeOptionMasterCacheModel =
			(RangeOptionMasterCacheModel)object;

		if (rangeOptionId == rangeOptionMasterCacheModel.rangeOptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rangeOptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rangeOptionId=");
		sb.append(rangeOptionId);
		sb.append(", rangeOptionName=");
		sb.append(rangeOptionName);
		sb.append(", rangeOptions=");
		sb.append(rangeOptions);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RangeOptionMaster toEntityModel() {
		RangeOptionMasterImpl rangeOptionMasterImpl =
			new RangeOptionMasterImpl();

		if (uuid == null) {
			rangeOptionMasterImpl.setUuid("");
		}
		else {
			rangeOptionMasterImpl.setUuid(uuid);
		}

		rangeOptionMasterImpl.setRangeOptionId(rangeOptionId);

		if (rangeOptionName == null) {
			rangeOptionMasterImpl.setRangeOptionName("");
		}
		else {
			rangeOptionMasterImpl.setRangeOptionName(rangeOptionName);
		}

		if (rangeOptions == null) {
			rangeOptionMasterImpl.setRangeOptions("");
		}
		else {
			rangeOptionMasterImpl.setRangeOptions(rangeOptions);
		}

		rangeOptionMasterImpl.setCompanyId(companyId);
		rangeOptionMasterImpl.setGroupId(groupId);
		rangeOptionMasterImpl.setCreatedBy(createdBy);
		rangeOptionMasterImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			rangeOptionMasterImpl.setCreatedDate(null);
		}
		else {
			rangeOptionMasterImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rangeOptionMasterImpl.setModifiedDate(null);
		}
		else {
			rangeOptionMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		rangeOptionMasterImpl.resetOriginalValues();

		return rangeOptionMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rangeOptionId = objectInput.readLong();
		rangeOptionName = objectInput.readUTF();
		rangeOptions = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rangeOptionId);

		if (rangeOptionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rangeOptionName);
		}

		if (rangeOptions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rangeOptions);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long rangeOptionId;
	public String rangeOptionName;
	public String rangeOptions;
	public long companyId;
	public long groupId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;

}