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

import gov.omsb.tms.model.TraineeSponsorDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeSponsorDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeSponsorDetailsCacheModel
	implements CacheModel<TraineeSponsorDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeSponsorDetailsCacheModel)) {
			return false;
		}

		TraineeSponsorDetailsCacheModel traineeSponsorDetailsCacheModel =
			(TraineeSponsorDetailsCacheModel)object;

		if (traineeSponsorDetailsId ==
				traineeSponsorDetailsCacheModel.traineeSponsorDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeSponsorDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeSponsorDetailsId=");
		sb.append(traineeSponsorDetailsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", sponsor=");
		sb.append(sponsor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeSponsorDetails toEntityModel() {
		TraineeSponsorDetailsImpl traineeSponsorDetailsImpl =
			new TraineeSponsorDetailsImpl();

		if (uuid == null) {
			traineeSponsorDetailsImpl.setUuid("");
		}
		else {
			traineeSponsorDetailsImpl.setUuid(uuid);
		}

		traineeSponsorDetailsImpl.setTraineeSponsorDetailsId(
			traineeSponsorDetailsId);
		traineeSponsorDetailsImpl.setGroupId(groupId);
		traineeSponsorDetailsImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			traineeSponsorDetailsImpl.setCreatedDate(null);
		}
		else {
			traineeSponsorDetailsImpl.setCreatedDate(new Date(createdDate));
		}

		traineeSponsorDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			traineeSponsorDetailsImpl.setModifiedDate(null);
		}
		else {
			traineeSponsorDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		traineeSponsorDetailsImpl.setModifiedBy(modifiedBy);
		traineeSponsorDetailsImpl.setTraineeId(traineeId);
		traineeSponsorDetailsImpl.setProgramDurationId(programDurationId);

		if (sponsor == null) {
			traineeSponsorDetailsImpl.setSponsor("");
		}
		else {
			traineeSponsorDetailsImpl.setSponsor(sponsor);
		}

		traineeSponsorDetailsImpl.resetOriginalValues();

		return traineeSponsorDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeSponsorDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeId = objectInput.readLong();

		programDurationId = objectInput.readLong();
		sponsor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeSponsorDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(programDurationId);

		if (sponsor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sponsor);
		}
	}

	public String uuid;
	public long traineeSponsorDetailsId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long traineeId;
	public long programDurationId;
	public String sponsor;

}