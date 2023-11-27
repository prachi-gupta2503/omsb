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

import gov.omsb.tms.model.ProgramProgramTypeRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramProgramTypeRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramProgramTypeRelCacheModel
	implements CacheModel<ProgramProgramTypeRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramProgramTypeRelCacheModel)) {
			return false;
		}

		ProgramProgramTypeRelCacheModel programProgramTypeRelCacheModel =
			(ProgramProgramTypeRelCacheModel)object;

		if (programPtId == programProgramTypeRelCacheModel.programPtId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programPtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programPtId=");
		sb.append(programPtId);
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", programTypeId=");
		sb.append(programTypeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramProgramTypeRel toEntityModel() {
		ProgramProgramTypeRelImpl programProgramTypeRelImpl =
			new ProgramProgramTypeRelImpl();

		if (uuid == null) {
			programProgramTypeRelImpl.setUuid("");
		}
		else {
			programProgramTypeRelImpl.setUuid(uuid);
		}

		programProgramTypeRelImpl.setProgramPtId(programPtId);
		programProgramTypeRelImpl.setProgramId(programId);
		programProgramTypeRelImpl.setProgramTypeId(programTypeId);
		programProgramTypeRelImpl.setGroupId(groupId);
		programProgramTypeRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programProgramTypeRelImpl.setCreateDate(null);
		}
		else {
			programProgramTypeRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			programProgramTypeRelImpl.setModifiedDate(null);
		}
		else {
			programProgramTypeRelImpl.setModifiedDate(new Date(modifiedDate));
		}

		programProgramTypeRelImpl.resetOriginalValues();

		return programProgramTypeRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programPtId = objectInput.readLong();

		programId = objectInput.readLong();

		programTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programPtId);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(programTypeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long programPtId;
	public long programId;
	public long programTypeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}