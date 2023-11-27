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

import gov.omsb.tms.model.ProceduregroupProgdurationRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProceduregroupProgdurationRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProceduregroupProgdurationRelCacheModel
	implements CacheModel<ProceduregroupProgdurationRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProceduregroupProgdurationRelCacheModel)) {
			return false;
		}

		ProceduregroupProgdurationRelCacheModel
			proceduregroupProgdurationRelCacheModel =
				(ProceduregroupProgdurationRelCacheModel)object;

		if (pgPdRelId == proceduregroupProgdurationRelCacheModel.pgPdRelId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pgPdRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", pgPdRelId=");
		sb.append(pgPdRelId);
		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProceduregroupProgdurationRel toEntityModel() {
		ProceduregroupProgdurationRelImpl proceduregroupProgdurationRelImpl =
			new ProceduregroupProgdurationRelImpl();

		if (uuid == null) {
			proceduregroupProgdurationRelImpl.setUuid("");
		}
		else {
			proceduregroupProgdurationRelImpl.setUuid(uuid);
		}

		proceduregroupProgdurationRelImpl.setPgPdRelId(pgPdRelId);
		proceduregroupProgdurationRelImpl.setProcedureGroupMasterId(
			procedureGroupMasterId);
		proceduregroupProgdurationRelImpl.setProgramDurationId(
			programDurationId);
		proceduregroupProgdurationRelImpl.setGroupId(groupId);
		proceduregroupProgdurationRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			proceduregroupProgdurationRelImpl.setCreateDate(null);
		}
		else {
			proceduregroupProgdurationRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			proceduregroupProgdurationRelImpl.setModifiedDate(null);
		}
		else {
			proceduregroupProgdurationRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		proceduregroupProgdurationRelImpl.setCreatedBy(createdBy);
		proceduregroupProgdurationRelImpl.setModifiedBy(modifiedBy);

		proceduregroupProgdurationRelImpl.resetOriginalValues();

		return proceduregroupProgdurationRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		pgPdRelId = objectInput.readLong();

		procedureGroupMasterId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

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

		objectOutput.writeLong(pgPdRelId);

		objectOutput.writeLong(procedureGroupMasterId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long pgPdRelId;
	public long procedureGroupMasterId;
	public long programDurationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}