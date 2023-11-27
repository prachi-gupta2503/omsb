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

import gov.omsb.tms.model.ProcedureMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcedureMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcedureMasterCacheModel
	implements CacheModel<ProcedureMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcedureMasterCacheModel)) {
			return false;
		}

		ProcedureMasterCacheModel procedureMasterCacheModel =
			(ProcedureMasterCacheModel)object;

		if (procedureMasterId == procedureMasterCacheModel.procedureMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, procedureMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", procedureMasterId=");
		sb.append(procedureMasterId);
		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);
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
		sb.append(", procedureName=");
		sb.append(procedureName);
		sb.append(", cptCode=");
		sb.append(cptCode);
		sb.append(", isMandatory=");
		sb.append(isMandatory);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcedureMaster toEntityModel() {
		ProcedureMasterImpl procedureMasterImpl = new ProcedureMasterImpl();

		if (uuid == null) {
			procedureMasterImpl.setUuid("");
		}
		else {
			procedureMasterImpl.setUuid(uuid);
		}

		procedureMasterImpl.setProcedureMasterId(procedureMasterId);
		procedureMasterImpl.setProcedureGroupMasterId(procedureGroupMasterId);
		procedureMasterImpl.setGroupId(groupId);
		procedureMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			procedureMasterImpl.setCreateDate(null);
		}
		else {
			procedureMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			procedureMasterImpl.setModifiedDate(null);
		}
		else {
			procedureMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		procedureMasterImpl.setCreatedBy(createdBy);
		procedureMasterImpl.setModifiedBy(modifiedBy);

		if (procedureName == null) {
			procedureMasterImpl.setProcedureName("");
		}
		else {
			procedureMasterImpl.setProcedureName(procedureName);
		}

		if (cptCode == null) {
			procedureMasterImpl.setCptCode("");
		}
		else {
			procedureMasterImpl.setCptCode(cptCode);
		}

		procedureMasterImpl.setIsMandatory(isMandatory);

		procedureMasterImpl.resetOriginalValues();

		return procedureMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		procedureMasterId = objectInput.readLong();

		procedureGroupMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		procedureName = objectInput.readUTF();
		cptCode = objectInput.readUTF();

		isMandatory = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(procedureMasterId);

		objectOutput.writeLong(procedureGroupMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		if (procedureName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureName);
		}

		if (cptCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cptCode);
		}

		objectOutput.writeBoolean(isMandatory);
	}

	public String uuid;
	public long procedureMasterId;
	public long procedureGroupMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public String procedureName;
	public String cptCode;
	public boolean isMandatory;

}