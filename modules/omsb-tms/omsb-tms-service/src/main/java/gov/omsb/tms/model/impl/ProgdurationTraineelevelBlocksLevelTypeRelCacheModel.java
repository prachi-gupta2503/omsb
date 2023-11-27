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

import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationTraineelevelBlocksLevelTypeRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelCacheModel
	implements CacheModel<ProgdurationTraineelevelBlocksLevelTypeRel>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				ProgdurationTraineelevelBlocksLevelTypeRelCacheModel)) {

			return false;
		}

		ProgdurationTraineelevelBlocksLevelTypeRelCacheModel
			progdurationTraineelevelBlocksLevelTypeRelCacheModel =
				(ProgdurationTraineelevelBlocksLevelTypeRelCacheModel)object;

		if (progdurationTlBlocksLtId ==
				progdurationTraineelevelBlocksLevelTypeRelCacheModel.
					progdurationTlBlocksLtId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progdurationTlBlocksLtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progdurationTlBlocksLtId=");
		sb.append(progdurationTlBlocksLtId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", levelTypeId=");
		sb.append(levelTypeId);
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
		sb.append(", noOfBlocks=");
		sb.append(noOfBlocks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel toEntityModel() {
		ProgdurationTraineelevelBlocksLevelTypeRelImpl
			progdurationTraineelevelBlocksLevelTypeRelImpl =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl();

		if (uuid == null) {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setUuid("");
		}
		else {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setUuid(uuid);
		}

		progdurationTraineelevelBlocksLevelTypeRelImpl.
			setProgdurationTlBlocksLtId(progdurationTlBlocksLtId);
		progdurationTraineelevelBlocksLevelTypeRelImpl.setProgramDurationId(
			programDurationId);
		progdurationTraineelevelBlocksLevelTypeRelImpl.setLevelTypeId(
			levelTypeId);
		progdurationTraineelevelBlocksLevelTypeRelImpl.setTraineeLevelId(
			traineeLevelId);
		progdurationTraineelevelBlocksLevelTypeRelImpl.setGroupId(groupId);
		progdurationTraineelevelBlocksLevelTypeRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setCreateDate(null);
		}
		else {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setModifiedDate(
				null);
		}
		else {
			progdurationTraineelevelBlocksLevelTypeRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationTraineelevelBlocksLevelTypeRelImpl.setNoOfBlocks(
			noOfBlocks);

		progdurationTraineelevelBlocksLevelTypeRelImpl.resetOriginalValues();

		return progdurationTraineelevelBlocksLevelTypeRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progdurationTlBlocksLtId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		levelTypeId = objectInput.readLong();

		traineeLevelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

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

		objectOutput.writeLong(progdurationTlBlocksLtId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(levelTypeId);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(noOfBlocks);
	}

	public String uuid;
	public long progdurationTlBlocksLtId;
	public long programDurationId;
	public long levelTypeId;
	public long traineeLevelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public int noOfBlocks;

}