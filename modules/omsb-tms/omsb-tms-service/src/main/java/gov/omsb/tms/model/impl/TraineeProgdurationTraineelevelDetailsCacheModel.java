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

import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeProgdurationTraineelevelDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsCacheModel
	implements CacheModel<TraineeProgdurationTraineelevelDetails>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				TraineeProgdurationTraineelevelDetailsCacheModel)) {

			return false;
		}

		TraineeProgdurationTraineelevelDetailsCacheModel
			traineeProgdurationTraineelevelDetailsCacheModel =
				(TraineeProgdurationTraineelevelDetailsCacheModel)object;

		if (traineePdTlErDetailsId ==
				traineeProgdurationTraineelevelDetailsCacheModel.
					traineePdTlErDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineePdTlErDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineePdTlErDetailsId=");
		sb.append(traineePdTlErDetailsId);
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeProgdurationTraineelevelDetails toEntityModel() {
		TraineeProgdurationTraineelevelDetailsImpl
			traineeProgdurationTraineelevelDetailsImpl =
				new TraineeProgdurationTraineelevelDetailsImpl();

		if (uuid == null) {
			traineeProgdurationTraineelevelDetailsImpl.setUuid("");
		}
		else {
			traineeProgdurationTraineelevelDetailsImpl.setUuid(uuid);
		}

		traineeProgdurationTraineelevelDetailsImpl.setTraineePdTlErDetailsId(
			traineePdTlErDetailsId);
		traineeProgdurationTraineelevelDetailsImpl.setTraineeId(traineeId);
		traineeProgdurationTraineelevelDetailsImpl.setProgramDurationId(
			programDurationId);
		traineeProgdurationTraineelevelDetailsImpl.setTraineeLevelId(
			traineeLevelId);
		traineeProgdurationTraineelevelDetailsImpl.setGroupId(groupId);
		traineeProgdurationTraineelevelDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeProgdurationTraineelevelDetailsImpl.setCreateDate(null);
		}
		else {
			traineeProgdurationTraineelevelDetailsImpl.setCreateDate(
				new Date(createDate));
		}

		traineeProgdurationTraineelevelDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			traineeProgdurationTraineelevelDetailsImpl.setModifiedDate(null);
		}
		else {
			traineeProgdurationTraineelevelDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		traineeProgdurationTraineelevelDetailsImpl.setModifiedBy(modifiedBy);

		traineeProgdurationTraineelevelDetailsImpl.resetOriginalValues();

		return traineeProgdurationTraineelevelDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineePdTlErDetailsId = objectInput.readLong();

		traineeId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		traineeLevelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineePdTlErDetailsId);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long traineePdTlErDetailsId;
	public long traineeId;
	public long programDurationId;
	public long traineeLevelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}