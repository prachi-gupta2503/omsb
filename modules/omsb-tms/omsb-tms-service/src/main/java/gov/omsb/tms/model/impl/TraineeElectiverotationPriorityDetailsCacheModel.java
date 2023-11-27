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

import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeElectiverotationPriorityDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsCacheModel
	implements CacheModel<TraineeElectiverotationPriorityDetails>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				TraineeElectiverotationPriorityDetailsCacheModel)) {

			return false;
		}

		TraineeElectiverotationPriorityDetailsCacheModel
			traineeElectiverotationPriorityDetailsCacheModel =
				(TraineeElectiverotationPriorityDetailsCacheModel)object;

		if (traineeElectiverotationPriorityDetailsId ==
				traineeElectiverotationPriorityDetailsCacheModel.
					traineeElectiverotationPriorityDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeElectiverotationPriorityDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeElectiverotationPriorityDetailsId=");
		sb.append(traineeElectiverotationPriorityDetailsId);
		sb.append(", traineePdTlErDetailsId=");
		sb.append(traineePdTlErDetailsId);
		sb.append(", rotationId=");
		sb.append(rotationId);
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
		sb.append(", sequence=");
		sb.append(sequence);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeElectiverotationPriorityDetails toEntityModel() {
		TraineeElectiverotationPriorityDetailsImpl
			traineeElectiverotationPriorityDetailsImpl =
				new TraineeElectiverotationPriorityDetailsImpl();

		if (uuid == null) {
			traineeElectiverotationPriorityDetailsImpl.setUuid("");
		}
		else {
			traineeElectiverotationPriorityDetailsImpl.setUuid(uuid);
		}

		traineeElectiverotationPriorityDetailsImpl.
			setTraineeElectiverotationPriorityDetailsId(
				traineeElectiverotationPriorityDetailsId);
		traineeElectiverotationPriorityDetailsImpl.setTraineePdTlErDetailsId(
			traineePdTlErDetailsId);
		traineeElectiverotationPriorityDetailsImpl.setRotationId(rotationId);
		traineeElectiverotationPriorityDetailsImpl.setGroupId(groupId);
		traineeElectiverotationPriorityDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeElectiverotationPriorityDetailsImpl.setCreateDate(null);
		}
		else {
			traineeElectiverotationPriorityDetailsImpl.setCreateDate(
				new Date(createDate));
		}

		traineeElectiverotationPriorityDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			traineeElectiverotationPriorityDetailsImpl.setModifiedDate(null);
		}
		else {
			traineeElectiverotationPriorityDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		traineeElectiverotationPriorityDetailsImpl.setModifiedBy(modifiedBy);
		traineeElectiverotationPriorityDetailsImpl.setSequence(sequence);

		traineeElectiverotationPriorityDetailsImpl.resetOriginalValues();

		return traineeElectiverotationPriorityDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeElectiverotationPriorityDetailsId = objectInput.readLong();

		traineePdTlErDetailsId = objectInput.readLong();

		rotationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		sequence = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeElectiverotationPriorityDetailsId);

		objectOutput.writeLong(traineePdTlErDetailsId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeInt(sequence);
	}

	public String uuid;
	public long traineeElectiverotationPriorityDetailsId;
	public long traineePdTlErDetailsId;
	public long rotationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public int sequence;

}