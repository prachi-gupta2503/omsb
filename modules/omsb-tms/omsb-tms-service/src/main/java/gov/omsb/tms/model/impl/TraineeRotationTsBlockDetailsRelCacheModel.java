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

import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeRotationTsBlockDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeRotationTsBlockDetailsRelCacheModel
	implements CacheModel<TraineeRotationTsBlockDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeRotationTsBlockDetailsRelCacheModel)) {
			return false;
		}

		TraineeRotationTsBlockDetailsRelCacheModel
			traineeRotationTsBlockDetailsRelCacheModel =
				(TraineeRotationTsBlockDetailsRelCacheModel)object;

		if (traineeRotationTsBlockDetailsRelId ==
				traineeRotationTsBlockDetailsRelCacheModel.
					traineeRotationTsBlockDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeRotationTsBlockDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeRotationTsBlockDetailsRelId=");
		sb.append(traineeRotationTsBlockDetailsRelId);
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
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);
		sb.append(", progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);
		sb.append(", traineeCohortDetailsId=");
		sb.append(traineeCohortDetailsId);
		sb.append(", rotationStatus=");
		sb.append(rotationStatus);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeRotationTsBlockDetailsRel toEntityModel() {
		TraineeRotationTsBlockDetailsRelImpl
			traineeRotationTsBlockDetailsRelImpl =
				new TraineeRotationTsBlockDetailsRelImpl();

		if (uuid == null) {
			traineeRotationTsBlockDetailsRelImpl.setUuid("");
		}
		else {
			traineeRotationTsBlockDetailsRelImpl.setUuid(uuid);
		}

		traineeRotationTsBlockDetailsRelImpl.
			setTraineeRotationTsBlockDetailsRelId(
				traineeRotationTsBlockDetailsRelId);
		traineeRotationTsBlockDetailsRelImpl.setGroupId(groupId);
		traineeRotationTsBlockDetailsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeRotationTsBlockDetailsRelImpl.setCreateDate(null);
		}
		else {
			traineeRotationTsBlockDetailsRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			traineeRotationTsBlockDetailsRelImpl.setModifiedDate(null);
		}
		else {
			traineeRotationTsBlockDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		traineeRotationTsBlockDetailsRelImpl.setCreatedBy(createdBy);
		traineeRotationTsBlockDetailsRelImpl.setModifiedBy(modifiedBy);
		traineeRotationTsBlockDetailsRelImpl.setTraineeId(traineeId);
		traineeRotationTsBlockDetailsRelImpl.setBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
		traineeRotationTsBlockDetailsRelImpl.setProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
		traineeRotationTsBlockDetailsRelImpl.setTraineeCohortDetailsId(
			traineeCohortDetailsId);

		if (rotationStatus == null) {
			traineeRotationTsBlockDetailsRelImpl.setRotationStatus("");
		}
		else {
			traineeRotationTsBlockDetailsRelImpl.setRotationStatus(
				rotationStatus);
		}

		if (status == null) {
			traineeRotationTsBlockDetailsRelImpl.setStatus("");
		}
		else {
			traineeRotationTsBlockDetailsRelImpl.setStatus(status);
		}

		traineeRotationTsBlockDetailsRelImpl.resetOriginalValues();

		return traineeRotationTsBlockDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeRotationTsBlockDetailsRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeId = objectInput.readLong();

		blocksMetadataDetailsRelId = objectInput.readLong();

		progDurationRotationTsRelId = objectInput.readLong();

		traineeCohortDetailsId = objectInput.readLong();
		rotationStatus = objectInput.readUTF();
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

		objectOutput.writeLong(traineeRotationTsBlockDetailsRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(blocksMetadataDetailsRelId);

		objectOutput.writeLong(progDurationRotationTsRelId);

		objectOutput.writeLong(traineeCohortDetailsId);

		if (rotationStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationStatus);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long traineeRotationTsBlockDetailsRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public long traineeId;
	public long blocksMetadataDetailsRelId;
	public long progDurationRotationTsRelId;
	public long traineeCohortDetailsId;
	public String rotationStatus;
	public String status;

}