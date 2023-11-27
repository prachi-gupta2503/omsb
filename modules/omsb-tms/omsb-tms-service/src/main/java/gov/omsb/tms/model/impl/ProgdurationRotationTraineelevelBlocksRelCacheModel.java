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

import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationRotationTraineelevelBlocksRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationRotationTraineelevelBlocksRelCacheModel
	implements CacheModel<ProgdurationRotationTraineelevelBlocksRel>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				ProgdurationRotationTraineelevelBlocksRelCacheModel)) {

			return false;
		}

		ProgdurationRotationTraineelevelBlocksRelCacheModel
			progdurationRotationTraineelevelBlocksRelCacheModel =
				(ProgdurationRotationTraineelevelBlocksRelCacheModel)object;

		if (progdurationRotationTlBlocksRelId ==
				progdurationRotationTraineelevelBlocksRelCacheModel.
					progdurationRotationTlBlocksRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progdurationRotationTlBlocksRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progdurationRotationTlBlocksRelId=");
		sb.append(progdurationRotationTlBlocksRelId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", rotationType=");
		sb.append(rotationType);
		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);
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
		sb.append(", noOfBlocks=");
		sb.append(noOfBlocks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationRotationTraineelevelBlocksRel toEntityModel() {
		ProgdurationRotationTraineelevelBlocksRelImpl
			progdurationRotationTraineelevelBlocksRelImpl =
				new ProgdurationRotationTraineelevelBlocksRelImpl();

		if (uuid == null) {
			progdurationRotationTraineelevelBlocksRelImpl.setUuid("");
		}
		else {
			progdurationRotationTraineelevelBlocksRelImpl.setUuid(uuid);
		}

		progdurationRotationTraineelevelBlocksRelImpl.
			setProgdurationRotationTlBlocksRelId(
				progdurationRotationTlBlocksRelId);
		progdurationRotationTraineelevelBlocksRelImpl.setProgramDurationId(
			programDurationId);
		progdurationRotationTraineelevelBlocksRelImpl.setRotationId(rotationId);
		progdurationRotationTraineelevelBlocksRelImpl.setRotationType(
			rotationType);
		progdurationRotationTraineelevelBlocksRelImpl.setTraineeLevelId(
			traineeLevelId);
		progdurationRotationTraineelevelBlocksRelImpl.setGroupId(groupId);
		progdurationRotationTraineelevelBlocksRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationRotationTraineelevelBlocksRelImpl.setCreateDate(null);
		}
		else {
			progdurationRotationTraineelevelBlocksRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationRotationTraineelevelBlocksRelImpl.setModifiedDate(null);
		}
		else {
			progdurationRotationTraineelevelBlocksRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationRotationTraineelevelBlocksRelImpl.setCreatedBy(createdBy);
		progdurationRotationTraineelevelBlocksRelImpl.setModifiedBy(modifiedBy);
		progdurationRotationTraineelevelBlocksRelImpl.setNoOfBlocks(noOfBlocks);

		progdurationRotationTraineelevelBlocksRelImpl.resetOriginalValues();

		return progdurationRotationTraineelevelBlocksRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progdurationRotationTlBlocksRelId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		rotationType = objectInput.readLong();

		traineeLevelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		noOfBlocks = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(progdurationRotationTlBlocksRelId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(rotationType);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeInt(noOfBlocks);
	}

	public String uuid;
	public long progdurationRotationTlBlocksRelId;
	public long programDurationId;
	public long rotationId;
	public long rotationType;
	public long traineeLevelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public int noOfBlocks;

}