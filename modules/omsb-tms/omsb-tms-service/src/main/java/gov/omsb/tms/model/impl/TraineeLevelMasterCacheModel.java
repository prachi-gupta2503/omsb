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

import gov.omsb.tms.model.TraineeLevelMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeLevelMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeLevelMasterCacheModel
	implements CacheModel<TraineeLevelMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeLevelMasterCacheModel)) {
			return false;
		}

		TraineeLevelMasterCacheModel traineeLevelMasterCacheModel =
			(TraineeLevelMasterCacheModel)object;

		if (traineeLevelMasterId ==
				traineeLevelMasterCacheModel.traineeLevelMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeLevelMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeLevelMasterId=");
		sb.append(traineeLevelMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", traineeLevelName=");
		sb.append(traineeLevelName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeLevelMaster toEntityModel() {
		TraineeLevelMasterImpl traineeLevelMasterImpl =
			new TraineeLevelMasterImpl();

		if (uuid == null) {
			traineeLevelMasterImpl.setUuid("");
		}
		else {
			traineeLevelMasterImpl.setUuid(uuid);
		}

		traineeLevelMasterImpl.setTraineeLevelMasterId(traineeLevelMasterId);
		traineeLevelMasterImpl.setGroupId(groupId);
		traineeLevelMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeLevelMasterImpl.setCreateDate(null);
		}
		else {
			traineeLevelMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			traineeLevelMasterImpl.setModifiedDate(null);
		}
		else {
			traineeLevelMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		traineeLevelMasterImpl.setCreatedBy(createdBy);
		traineeLevelMasterImpl.setModifiedBy(modifiedBy);

		if (traineeLevelName == null) {
			traineeLevelMasterImpl.setTraineeLevelName("");
		}
		else {
			traineeLevelMasterImpl.setTraineeLevelName(traineeLevelName);
		}

		traineeLevelMasterImpl.resetOriginalValues();

		return traineeLevelMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeLevelMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		traineeLevelName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeLevelMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		if (traineeLevelName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(traineeLevelName);
		}
	}

	public String uuid;
	public long traineeLevelMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public String traineeLevelName;

}