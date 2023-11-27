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

import gov.omsb.tms.model.ProcedureGroupMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcedureGroupMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcedureGroupMasterCacheModel
	implements CacheModel<ProcedureGroupMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcedureGroupMasterCacheModel)) {
			return false;
		}

		ProcedureGroupMasterCacheModel procedureGroupMasterCacheModel =
			(ProcedureGroupMasterCacheModel)object;

		if (procedureGroupMasterId ==
				procedureGroupMasterCacheModel.procedureGroupMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, procedureGroupMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", procedureGroupMasterId=");
		sb.append(procedureGroupMasterId);
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
		sb.append(", procedureGroupName=");
		sb.append(procedureGroupName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcedureGroupMaster toEntityModel() {
		ProcedureGroupMasterImpl procedureGroupMasterImpl =
			new ProcedureGroupMasterImpl();

		if (uuid == null) {
			procedureGroupMasterImpl.setUuid("");
		}
		else {
			procedureGroupMasterImpl.setUuid(uuid);
		}

		procedureGroupMasterImpl.setProcedureGroupMasterId(
			procedureGroupMasterId);
		procedureGroupMasterImpl.setGroupId(groupId);
		procedureGroupMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			procedureGroupMasterImpl.setCreateDate(null);
		}
		else {
			procedureGroupMasterImpl.setCreateDate(new Date(createDate));
		}

		procedureGroupMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			procedureGroupMasterImpl.setModifiedDate(null);
		}
		else {
			procedureGroupMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		procedureGroupMasterImpl.setModifiedBy(modifiedBy);

		if (procedureGroupName == null) {
			procedureGroupMasterImpl.setProcedureGroupName("");
		}
		else {
			procedureGroupMasterImpl.setProcedureGroupName(procedureGroupName);
		}

		procedureGroupMasterImpl.resetOriginalValues();

		return procedureGroupMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		procedureGroupMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		procedureGroupName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(procedureGroupMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (procedureGroupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureGroupName);
		}
	}

	public String uuid;
	public long procedureGroupMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String procedureGroupName;

}