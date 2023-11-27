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

import gov.omsb.tms.model.ProgramTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramTypeMasterCacheModel
	implements CacheModel<ProgramTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramTypeMasterCacheModel)) {
			return false;
		}

		ProgramTypeMasterCacheModel programTypeMasterCacheModel =
			(ProgramTypeMasterCacheModel)object;

		if (programTypeMasterId ==
				programTypeMasterCacheModel.programTypeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programTypeMasterId=");
		sb.append(programTypeMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", programTypeName=");
		sb.append(programTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramTypeMaster toEntityModel() {
		ProgramTypeMasterImpl programTypeMasterImpl =
			new ProgramTypeMasterImpl();

		if (uuid == null) {
			programTypeMasterImpl.setUuid("");
		}
		else {
			programTypeMasterImpl.setUuid(uuid);
		}

		programTypeMasterImpl.setProgramTypeMasterId(programTypeMasterId);
		programTypeMasterImpl.setGroupId(groupId);
		programTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programTypeMasterImpl.setCreateDate(null);
		}
		else {
			programTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			programTypeMasterImpl.setModifiedDate(null);
		}
		else {
			programTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (programTypeName == null) {
			programTypeMasterImpl.setProgramTypeName("");
		}
		else {
			programTypeMasterImpl.setProgramTypeName(programTypeName);
		}

		programTypeMasterImpl.resetOriginalValues();

		return programTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		programTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (programTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programTypeName);
		}
	}

	public String uuid;
	public long programTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String programTypeName;

}