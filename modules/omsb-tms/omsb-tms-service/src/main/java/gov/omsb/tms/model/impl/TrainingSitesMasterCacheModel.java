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

import gov.omsb.tms.model.TrainingSitesMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TrainingSitesMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingSitesMasterCacheModel
	implements CacheModel<TrainingSitesMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingSitesMasterCacheModel)) {
			return false;
		}

		TrainingSitesMasterCacheModel trainingSitesMasterCacheModel =
			(TrainingSitesMasterCacheModel)object;

		if (trainingSiteMasterId ==
				trainingSitesMasterCacheModel.trainingSiteMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingSiteMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trainingSiteMasterId=");
		sb.append(trainingSiteMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", trainingSiteName=");
		sb.append(trainingSiteName);
		sb.append(", trainingSiteCode=");
		sb.append(trainingSiteCode);
		sb.append(", trainingSiteStatus=");
		sb.append(trainingSiteStatus);
		sb.append(", trainingSiteAddress=");
		sb.append(trainingSiteAddress);
		sb.append(", trainingSiteDescription=");
		sb.append(trainingSiteDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrainingSitesMaster toEntityModel() {
		TrainingSitesMasterImpl trainingSitesMasterImpl =
			new TrainingSitesMasterImpl();

		if (uuid == null) {
			trainingSitesMasterImpl.setUuid("");
		}
		else {
			trainingSitesMasterImpl.setUuid(uuid);
		}

		trainingSitesMasterImpl.setTrainingSiteMasterId(trainingSiteMasterId);
		trainingSitesMasterImpl.setGroupId(groupId);
		trainingSitesMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			trainingSitesMasterImpl.setCreateDate(null);
		}
		else {
			trainingSitesMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trainingSitesMasterImpl.setModifiedDate(null);
		}
		else {
			trainingSitesMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (trainingSiteName == null) {
			trainingSitesMasterImpl.setTrainingSiteName("");
		}
		else {
			trainingSitesMasterImpl.setTrainingSiteName(trainingSiteName);
		}

		if (trainingSiteCode == null) {
			trainingSitesMasterImpl.setTrainingSiteCode("");
		}
		else {
			trainingSitesMasterImpl.setTrainingSiteCode(trainingSiteCode);
		}

		trainingSitesMasterImpl.setTrainingSiteStatus(trainingSiteStatus);

		if (trainingSiteAddress == null) {
			trainingSitesMasterImpl.setTrainingSiteAddress("");
		}
		else {
			trainingSitesMasterImpl.setTrainingSiteAddress(trainingSiteAddress);
		}

		if (trainingSiteDescription == null) {
			trainingSitesMasterImpl.setTrainingSiteDescription("");
		}
		else {
			trainingSitesMasterImpl.setTrainingSiteDescription(
				trainingSiteDescription);
		}

		trainingSitesMasterImpl.resetOriginalValues();

		return trainingSitesMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trainingSiteMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		trainingSiteName = objectInput.readUTF();
		trainingSiteCode = objectInput.readUTF();

		trainingSiteStatus = objectInput.readBoolean();
		trainingSiteAddress = objectInput.readUTF();
		trainingSiteDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(trainingSiteMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (trainingSiteName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingSiteName);
		}

		if (trainingSiteCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingSiteCode);
		}

		objectOutput.writeBoolean(trainingSiteStatus);

		if (trainingSiteAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingSiteAddress);
		}

		if (trainingSiteDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingSiteDescription);
		}
	}

	public String uuid;
	public long trainingSiteMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String trainingSiteName;
	public String trainingSiteCode;
	public boolean trainingSiteStatus;
	public String trainingSiteAddress;
	public String trainingSiteDescription;

}