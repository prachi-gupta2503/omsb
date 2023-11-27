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

import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationRotationTlPgProcedurePtRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelCacheModel
	implements CacheModel<ProgdurationRotationTlPgProcedurePtRel>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				ProgdurationRotationTlPgProcedurePtRelCacheModel)) {

			return false;
		}

		ProgdurationRotationTlPgProcedurePtRelCacheModel
			progdurationRotationTlPgProcedurePtRelCacheModel =
				(ProgdurationRotationTlPgProcedurePtRelCacheModel)object;

		if (progdurationRotationTlPgProcedurePtRelId ==
				progdurationRotationTlPgProcedurePtRelCacheModel.
					progdurationRotationTlPgProcedurePtRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progdurationRotationTlPgProcedurePtRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progdurationRotationTlPgProcedurePtRelId=");
		sb.append(progdurationRotationTlPgProcedurePtRelId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);
		sb.append(", procedureGroupId=");
		sb.append(procedureGroupId);
		sb.append(", procedureId=");
		sb.append(procedureId);
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
		sb.append(", minimumProcedures=");
		sb.append(minimumProcedures);
		sb.append(", traineelevelMinimumProcedures=");
		sb.append(traineelevelMinimumProcedures);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationRotationTlPgProcedurePtRel toEntityModel() {
		ProgdurationRotationTlPgProcedurePtRelImpl
			progdurationRotationTlPgProcedurePtRelImpl =
				new ProgdurationRotationTlPgProcedurePtRelImpl();

		if (uuid == null) {
			progdurationRotationTlPgProcedurePtRelImpl.setUuid("");
		}
		else {
			progdurationRotationTlPgProcedurePtRelImpl.setUuid(uuid);
		}

		progdurationRotationTlPgProcedurePtRelImpl.
			setProgdurationRotationTlPgProcedurePtRelId(
				progdurationRotationTlPgProcedurePtRelId);
		progdurationRotationTlPgProcedurePtRelImpl.setProgramDurationId(
			programDurationId);
		progdurationRotationTlPgProcedurePtRelImpl.setRotationId(rotationId);
		progdurationRotationTlPgProcedurePtRelImpl.setTraineeLevelId(
			traineeLevelId);
		progdurationRotationTlPgProcedurePtRelImpl.setProcedureGroupId(
			procedureGroupId);
		progdurationRotationTlPgProcedurePtRelImpl.setProcedureId(procedureId);
		progdurationRotationTlPgProcedurePtRelImpl.setGroupId(groupId);
		progdurationRotationTlPgProcedurePtRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationRotationTlPgProcedurePtRelImpl.setCreateDate(null);
		}
		else {
			progdurationRotationTlPgProcedurePtRelImpl.setCreateDate(
				new Date(createDate));
		}

		progdurationRotationTlPgProcedurePtRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationRotationTlPgProcedurePtRelImpl.setModifiedDate(null);
		}
		else {
			progdurationRotationTlPgProcedurePtRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationRotationTlPgProcedurePtRelImpl.setModifiedBy(modifiedBy);
		progdurationRotationTlPgProcedurePtRelImpl.setMinimumProcedures(
			minimumProcedures);
		progdurationRotationTlPgProcedurePtRelImpl.
			setTraineelevelMinimumProcedures(traineelevelMinimumProcedures);

		progdurationRotationTlPgProcedurePtRelImpl.resetOriginalValues();

		return progdurationRotationTlPgProcedurePtRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progdurationRotationTlPgProcedurePtRelId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		traineeLevelId = objectInput.readLong();

		procedureGroupId = objectInput.readLong();

		procedureId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		minimumProcedures = objectInput.readInt();

		traineelevelMinimumProcedures = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(progdurationRotationTlPgProcedurePtRelId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeLong(procedureGroupId);

		objectOutput.writeLong(procedureId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeInt(minimumProcedures);

		objectOutput.writeInt(traineelevelMinimumProcedures);
	}

	public String uuid;
	public long progdurationRotationTlPgProcedurePtRelId;
	public long programDurationId;
	public long rotationId;
	public long traineeLevelId;
	public long procedureGroupId;
	public long procedureId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public int minimumProcedures;
	public int traineelevelMinimumProcedures;

}