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

import gov.omsb.tms.model.TraineeAdmissionDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeAdmissionDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeAdmissionDetailsRelCacheModel
	implements CacheModel<TraineeAdmissionDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeAdmissionDetailsRelCacheModel)) {
			return false;
		}

		TraineeAdmissionDetailsRelCacheModel
			traineeAdmissionDetailsRelCacheModel =
				(TraineeAdmissionDetailsRelCacheModel)object;

		if (traineeAdmissionDetailsRelId ==
				traineeAdmissionDetailsRelCacheModel.
					traineeAdmissionDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeAdmissionDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);
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
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", admissionYear=");
		sb.append(admissionYear);
		sb.append(", omsbNumber=");
		sb.append(omsbNumber);
		sb.append(", traineeAddress=");
		sb.append(traineeAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeAdmissionDetailsRel toEntityModel() {
		TraineeAdmissionDetailsRelImpl traineeAdmissionDetailsRelImpl =
			new TraineeAdmissionDetailsRelImpl();

		if (uuid == null) {
			traineeAdmissionDetailsRelImpl.setUuid("");
		}
		else {
			traineeAdmissionDetailsRelImpl.setUuid(uuid);
		}

		traineeAdmissionDetailsRelImpl.setTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);
		traineeAdmissionDetailsRelImpl.setGroupId(groupId);
		traineeAdmissionDetailsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeAdmissionDetailsRelImpl.setCreateDate(null);
		}
		else {
			traineeAdmissionDetailsRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			traineeAdmissionDetailsRelImpl.setModifiedDate(null);
		}
		else {
			traineeAdmissionDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		traineeAdmissionDetailsRelImpl.setCreatedBy(createdBy);
		traineeAdmissionDetailsRelImpl.setModifiedBy(modifiedBy);
		traineeAdmissionDetailsRelImpl.setTraineeId(traineeId);
		traineeAdmissionDetailsRelImpl.setProgramDurationId(programDurationId);

		if (admissionYear == null) {
			traineeAdmissionDetailsRelImpl.setAdmissionYear("");
		}
		else {
			traineeAdmissionDetailsRelImpl.setAdmissionYear(admissionYear);
		}

		if (omsbNumber == null) {
			traineeAdmissionDetailsRelImpl.setOmsbNumber("");
		}
		else {
			traineeAdmissionDetailsRelImpl.setOmsbNumber(omsbNumber);
		}

		if (traineeAddress == null) {
			traineeAdmissionDetailsRelImpl.setTraineeAddress("");
		}
		else {
			traineeAdmissionDetailsRelImpl.setTraineeAddress(traineeAddress);
		}

		traineeAdmissionDetailsRelImpl.resetOriginalValues();

		return traineeAdmissionDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeAdmissionDetailsRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeId = objectInput.readLong();

		programDurationId = objectInput.readLong();
		admissionYear = objectInput.readUTF();
		omsbNumber = objectInput.readUTF();
		traineeAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeAdmissionDetailsRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(programDurationId);

		if (admissionYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(admissionYear);
		}

		if (omsbNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(omsbNumber);
		}

		if (traineeAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(traineeAddress);
		}
	}

	public String uuid;
	public long traineeAdmissionDetailsRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public long traineeId;
	public long programDurationId;
	public String admissionYear;
	public String omsbNumber;
	public String traineeAddress;

}