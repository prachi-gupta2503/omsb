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

import gov.omsb.tms.model.ProgramDutyAssignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramDutyAssignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramDutyAssignmentCacheModel
	implements CacheModel<ProgramDutyAssignment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramDutyAssignmentCacheModel)) {
			return false;
		}

		ProgramDutyAssignmentCacheModel programDutyAssignmentCacheModel =
			(ProgramDutyAssignmentCacheModel)object;

		if (programDutyAssignmentId ==
				programDutyAssignmentCacheModel.programDutyAssignmentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programDutyAssignmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programDutyAssignmentId=");
		sb.append(programDutyAssignmentId);
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
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", dutyAssignmentId=");
		sb.append(dutyAssignmentId);
		sb.append(", cohortId=");
		sb.append(cohortId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramDutyAssignment toEntityModel() {
		ProgramDutyAssignmentImpl programDutyAssignmentImpl =
			new ProgramDutyAssignmentImpl();

		if (uuid == null) {
			programDutyAssignmentImpl.setUuid("");
		}
		else {
			programDutyAssignmentImpl.setUuid(uuid);
		}

		programDutyAssignmentImpl.setProgramDutyAssignmentId(
			programDutyAssignmentId);
		programDutyAssignmentImpl.setGroupId(groupId);
		programDutyAssignmentImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programDutyAssignmentImpl.setCreateDate(null);
		}
		else {
			programDutyAssignmentImpl.setCreateDate(new Date(createDate));
		}

		programDutyAssignmentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			programDutyAssignmentImpl.setModifiedDate(null);
		}
		else {
			programDutyAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		programDutyAssignmentImpl.setModifiedBy(modifiedBy);
		programDutyAssignmentImpl.setProgramId(programId);
		programDutyAssignmentImpl.setDutyAssignmentId(dutyAssignmentId);
		programDutyAssignmentImpl.setCohortId(cohortId);

		if (status == null) {
			programDutyAssignmentImpl.setStatus("");
		}
		else {
			programDutyAssignmentImpl.setStatus(status);
		}

		programDutyAssignmentImpl.resetOriginalValues();

		return programDutyAssignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programDutyAssignmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		programId = objectInput.readLong();

		dutyAssignmentId = objectInput.readLong();

		cohortId = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programDutyAssignmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(dutyAssignmentId);

		objectOutput.writeLong(cohortId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long programDutyAssignmentId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long programId;
	public long dutyAssignmentId;
	public long cohortId;
	public String status;

}