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

import gov.omsb.tms.model.TraineeCohortDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeCohortDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeCohortDetailsCacheModel
	implements CacheModel<TraineeCohortDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeCohortDetailsCacheModel)) {
			return false;
		}

		TraineeCohortDetailsCacheModel traineeCohortDetailsCacheModel =
			(TraineeCohortDetailsCacheModel)object;

		if (traineeCohortDetailsId ==
				traineeCohortDetailsCacheModel.traineeCohortDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeCohortDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeCohortDetailsId=");
		sb.append(traineeCohortDetailsId);
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
		sb.append(", traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);
		sb.append(", cohortYear=");
		sb.append(cohortYear);
		sb.append(", isCurrentCohort=");
		sb.append(isCurrentCohort);
		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);
		sb.append(", isCurrentTraineeLevel=");
		sb.append(isCurrentTraineeLevel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeCohortDetails toEntityModel() {
		TraineeCohortDetailsImpl traineeCohortDetailsImpl =
			new TraineeCohortDetailsImpl();

		if (uuid == null) {
			traineeCohortDetailsImpl.setUuid("");
		}
		else {
			traineeCohortDetailsImpl.setUuid(uuid);
		}

		traineeCohortDetailsImpl.setTraineeCohortDetailsId(
			traineeCohortDetailsId);
		traineeCohortDetailsImpl.setGroupId(groupId);
		traineeCohortDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeCohortDetailsImpl.setCreateDate(null);
		}
		else {
			traineeCohortDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			traineeCohortDetailsImpl.setModifiedDate(null);
		}
		else {
			traineeCohortDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		traineeCohortDetailsImpl.setCreatedBy(createdBy);
		traineeCohortDetailsImpl.setModifiedBy(modifiedBy);
		traineeCohortDetailsImpl.setTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);

		if (cohortYear == null) {
			traineeCohortDetailsImpl.setCohortYear("");
		}
		else {
			traineeCohortDetailsImpl.setCohortYear(cohortYear);
		}

		traineeCohortDetailsImpl.setIsCurrentCohort(isCurrentCohort);
		traineeCohortDetailsImpl.setTraineeLevelId(traineeLevelId);
		traineeCohortDetailsImpl.setIsCurrentTraineeLevel(
			isCurrentTraineeLevel);

		traineeCohortDetailsImpl.resetOriginalValues();

		return traineeCohortDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeCohortDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeAdmissionDetailsRelId = objectInput.readLong();
		cohortYear = objectInput.readUTF();

		isCurrentCohort = objectInput.readBoolean();

		traineeLevelId = objectInput.readLong();

		isCurrentTraineeLevel = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeCohortDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeAdmissionDetailsRelId);

		if (cohortYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cohortYear);
		}

		objectOutput.writeBoolean(isCurrentCohort);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeBoolean(isCurrentTraineeLevel);
	}

	public String uuid;
	public long traineeCohortDetailsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public long traineeAdmissionDetailsRelId;
	public String cohortYear;
	public boolean isCurrentCohort;
	public long traineeLevelId;
	public boolean isCurrentTraineeLevel;

}