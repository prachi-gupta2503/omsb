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

import gov.omsb.tms.model.DutyLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DutyLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DutyLogCacheModel implements CacheModel<DutyLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyLogCacheModel)) {
			return false;
		}

		DutyLogCacheModel dutyLogCacheModel = (DutyLogCacheModel)object;

		if (dutyLogId == dutyLogCacheModel.dutyLogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dutyLogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dutyLogId=");
		sb.append(dutyLogId);
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
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);
		sb.append(", blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);
		sb.append(", residencyLevelId=");
		sb.append(residencyLevelId);
		sb.append(", multiDays=");
		sb.append(multiDays);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DutyLog toEntityModel() {
		DutyLogImpl dutyLogImpl = new DutyLogImpl();

		if (uuid == null) {
			dutyLogImpl.setUuid("");
		}
		else {
			dutyLogImpl.setUuid(uuid);
		}

		dutyLogImpl.setDutyLogId(dutyLogId);
		dutyLogImpl.setGroupId(groupId);
		dutyLogImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dutyLogImpl.setCreateDate(null);
		}
		else {
			dutyLogImpl.setCreateDate(new Date(createDate));
		}

		dutyLogImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dutyLogImpl.setModifiedDate(null);
		}
		else {
			dutyLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		dutyLogImpl.setModifiedBy(modifiedBy);
		dutyLogImpl.setTraineeId(traineeId);
		dutyLogImpl.setProgramDutyAssignmentId(programDutyAssignmentId);
		dutyLogImpl.setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		dutyLogImpl.setResidencyLevelId(residencyLevelId);
		dutyLogImpl.setMultiDays(multiDays);

		if (startDate == Long.MIN_VALUE) {
			dutyLogImpl.setStartDate(null);
		}
		else {
			dutyLogImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dutyLogImpl.setEndDate(null);
		}
		else {
			dutyLogImpl.setEndDate(new Date(endDate));
		}

		dutyLogImpl.resetOriginalValues();

		return dutyLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dutyLogId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeId = objectInput.readLong();

		programDutyAssignmentId = objectInput.readLong();

		blocksMetadataDetailRelId = objectInput.readLong();

		residencyLevelId = objectInput.readLong();

		multiDays = objectInput.readBoolean();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dutyLogId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(programDutyAssignmentId);

		objectOutput.writeLong(blocksMetadataDetailRelId);

		objectOutput.writeLong(residencyLevelId);

		objectOutput.writeBoolean(multiDays);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public String uuid;
	public long dutyLogId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long traineeId;
	public long programDutyAssignmentId;
	public long blocksMetadataDetailRelId;
	public long residencyLevelId;
	public boolean multiDays;
	public long startDate;
	public long endDate;

}