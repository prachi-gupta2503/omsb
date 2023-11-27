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

import gov.omsb.tms.model.ParticipationTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ParticipationTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ParticipationTypeMasterCacheModel
	implements CacheModel<ParticipationTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParticipationTypeMasterCacheModel)) {
			return false;
		}

		ParticipationTypeMasterCacheModel participationTypeMasterCacheModel =
			(ParticipationTypeMasterCacheModel)object;

		if (participationTypeMasterId ==
				participationTypeMasterCacheModel.participationTypeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, participationTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", participationTypeMasterId=");
		sb.append(participationTypeMasterId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
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
		sb.append(", participationTypeName=");
		sb.append(participationTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ParticipationTypeMaster toEntityModel() {
		ParticipationTypeMasterImpl participationTypeMasterImpl =
			new ParticipationTypeMasterImpl();

		if (uuid == null) {
			participationTypeMasterImpl.setUuid("");
		}
		else {
			participationTypeMasterImpl.setUuid(uuid);
		}

		participationTypeMasterImpl.setParticipationTypeMasterId(
			participationTypeMasterId);
		participationTypeMasterImpl.setProgramDurationId(programDurationId);
		participationTypeMasterImpl.setGroupId(groupId);
		participationTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			participationTypeMasterImpl.setCreateDate(null);
		}
		else {
			participationTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		participationTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			participationTypeMasterImpl.setModifiedDate(null);
		}
		else {
			participationTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		participationTypeMasterImpl.setModifiedBy(modifiedBy);

		if (participationTypeName == null) {
			participationTypeMasterImpl.setParticipationTypeName("");
		}
		else {
			participationTypeMasterImpl.setParticipationTypeName(
				participationTypeName);
		}

		participationTypeMasterImpl.resetOriginalValues();

		return participationTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		participationTypeMasterId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		participationTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(participationTypeMasterId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (participationTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(participationTypeName);
		}
	}

	public String uuid;
	public long participationTypeMasterId;
	public long programDurationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String participationTypeName;

}