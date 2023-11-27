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

import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcedureGroupProceduresCPTCodeRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelCacheModel
	implements CacheModel<ProcedureGroupProceduresCPTCodeRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcedureGroupProceduresCPTCodeRelCacheModel)) {
			return false;
		}

		ProcedureGroupProceduresCPTCodeRelCacheModel
			procedureGroupProceduresCPTCodeRelCacheModel =
				(ProcedureGroupProceduresCPTCodeRelCacheModel)object;

		if (pgProcedureCptCodeRelId ==
				procedureGroupProceduresCPTCodeRelCacheModel.
					pgProcedureCptCodeRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pgProcedureCptCodeRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", pgProcedureCptCodeRelId=");
		sb.append(pgProcedureCptCodeRelId);
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
		sb.append(", procedureGroupId=");
		sb.append(procedureGroupId);
		sb.append(", procedureId=");
		sb.append(procedureId);
		sb.append(", cptCodeId=");
		sb.append(cptCodeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRel toEntityModel() {
		ProcedureGroupProceduresCPTCodeRelImpl
			procedureGroupProceduresCPTCodeRelImpl =
				new ProcedureGroupProceduresCPTCodeRelImpl();

		if (uuid == null) {
			procedureGroupProceduresCPTCodeRelImpl.setUuid("");
		}
		else {
			procedureGroupProceduresCPTCodeRelImpl.setUuid(uuid);
		}

		procedureGroupProceduresCPTCodeRelImpl.setPgProcedureCptCodeRelId(
			pgProcedureCptCodeRelId);
		procedureGroupProceduresCPTCodeRelImpl.setGroupId(groupId);
		procedureGroupProceduresCPTCodeRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			procedureGroupProceduresCPTCodeRelImpl.setCreateDate(null);
		}
		else {
			procedureGroupProceduresCPTCodeRelImpl.setCreateDate(
				new Date(createDate));
		}

		procedureGroupProceduresCPTCodeRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			procedureGroupProceduresCPTCodeRelImpl.setModifiedDate(null);
		}
		else {
			procedureGroupProceduresCPTCodeRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		procedureGroupProceduresCPTCodeRelImpl.setModifiedBy(modifiedBy);
		procedureGroupProceduresCPTCodeRelImpl.setProcedureGroupId(
			procedureGroupId);
		procedureGroupProceduresCPTCodeRelImpl.setProcedureId(procedureId);
		procedureGroupProceduresCPTCodeRelImpl.setCptCodeId(cptCodeId);

		procedureGroupProceduresCPTCodeRelImpl.resetOriginalValues();

		return procedureGroupProceduresCPTCodeRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		pgProcedureCptCodeRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		procedureGroupId = objectInput.readLong();

		procedureId = objectInput.readLong();

		cptCodeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(pgProcedureCptCodeRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(procedureGroupId);

		objectOutput.writeLong(procedureId);

		objectOutput.writeLong(cptCodeId);
	}

	public String uuid;
	public long pgProcedureCptCodeRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long procedureGroupId;
	public long procedureId;
	public long cptCodeId;

}