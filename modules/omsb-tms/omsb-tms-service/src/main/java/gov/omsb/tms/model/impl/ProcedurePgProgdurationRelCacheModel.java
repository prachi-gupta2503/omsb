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

import gov.omsb.tms.model.ProcedurePgProgdurationRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcedurePgProgdurationRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcedurePgProgdurationRelCacheModel
	implements CacheModel<ProcedurePgProgdurationRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcedurePgProgdurationRelCacheModel)) {
			return false;
		}

		ProcedurePgProgdurationRelCacheModel
			procedurePgProgdurationRelCacheModel =
				(ProcedurePgProgdurationRelCacheModel)object;

		if (procedurePgPdRelId ==
				procedurePgProgdurationRelCacheModel.procedurePgPdRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, procedurePgPdRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", procedurePgPdRelId=");
		sb.append(procedurePgPdRelId);
		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);
		sb.append(", procedureMasterId=");
		sb.append(procedureMasterId);
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
	public ProcedurePgProgdurationRel toEntityModel() {
		ProcedurePgProgdurationRelImpl procedurePgProgdurationRelImpl =
			new ProcedurePgProgdurationRelImpl();

		if (uuid == null) {
			procedurePgProgdurationRelImpl.setUuid("");
		}
		else {
			procedurePgProgdurationRelImpl.setUuid(uuid);
		}

		procedurePgProgdurationRelImpl.setProcedurePgPdRelId(
			procedurePgPdRelId);
		procedurePgProgdurationRelImpl.setProcedureGroupMasterId(
			procedureGroupMasterId);
		procedurePgProgdurationRelImpl.setProcedureMasterId(procedureMasterId);
		procedurePgProgdurationRelImpl.setProgramDurationId(programDurationId);
		procedurePgProgdurationRelImpl.setGroupId(groupId);
		procedurePgProgdurationRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			procedurePgProgdurationRelImpl.setCreateDate(null);
		}
		else {
			procedurePgProgdurationRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			procedurePgProgdurationRelImpl.setModifiedDate(null);
		}
		else {
			procedurePgProgdurationRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		procedurePgProgdurationRelImpl.setCreatedBy(createdBy);
		procedurePgProgdurationRelImpl.setModifiedBy(modifiedBy);

		procedurePgProgdurationRelImpl.resetOriginalValues();

		return procedurePgProgdurationRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		procedurePgPdRelId = objectInput.readLong();

		procedureGroupMasterId = objectInput.readLong();

		procedureMasterId = objectInput.readLong();

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

		objectOutput.writeLong(procedurePgPdRelId);

		objectOutput.writeLong(procedureGroupMasterId);

		objectOutput.writeLong(procedureMasterId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long procedurePgPdRelId;
	public long procedureGroupMasterId;
	public long procedureMasterId;
	public long programDurationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}