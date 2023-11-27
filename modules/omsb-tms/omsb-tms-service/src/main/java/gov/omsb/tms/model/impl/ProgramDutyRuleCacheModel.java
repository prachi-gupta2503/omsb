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

import gov.omsb.tms.model.ProgramDutyRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramDutyRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramDutyRuleCacheModel
	implements CacheModel<ProgramDutyRule>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramDutyRuleCacheModel)) {
			return false;
		}

		ProgramDutyRuleCacheModel programDutyRuleCacheModel =
			(ProgramDutyRuleCacheModel)object;

		if (programDutyRuleId == programDutyRuleCacheModel.programDutyRuleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programDutyRuleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programDutyRuleId=");
		sb.append(programDutyRuleId);
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
		sb.append(", dutyRuleId=");
		sb.append(dutyRuleId);
		sb.append(", cohortId=");
		sb.append(cohortId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramDutyRule toEntityModel() {
		ProgramDutyRuleImpl programDutyRuleImpl = new ProgramDutyRuleImpl();

		if (uuid == null) {
			programDutyRuleImpl.setUuid("");
		}
		else {
			programDutyRuleImpl.setUuid(uuid);
		}

		programDutyRuleImpl.setProgramDutyRuleId(programDutyRuleId);
		programDutyRuleImpl.setGroupId(groupId);
		programDutyRuleImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programDutyRuleImpl.setCreateDate(null);
		}
		else {
			programDutyRuleImpl.setCreateDate(new Date(createDate));
		}

		programDutyRuleImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			programDutyRuleImpl.setModifiedDate(null);
		}
		else {
			programDutyRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		programDutyRuleImpl.setModifiedBy(modifiedBy);
		programDutyRuleImpl.setProgramId(programId);
		programDutyRuleImpl.setDutyRuleId(dutyRuleId);
		programDutyRuleImpl.setCohortId(cohortId);

		if (status == null) {
			programDutyRuleImpl.setStatus("");
		}
		else {
			programDutyRuleImpl.setStatus(status);
		}

		programDutyRuleImpl.resetOriginalValues();

		return programDutyRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programDutyRuleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		programId = objectInput.readLong();

		dutyRuleId = objectInput.readLong();

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

		objectOutput.writeLong(programDutyRuleId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(dutyRuleId);

		objectOutput.writeLong(cohortId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long programDutyRuleId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long programId;
	public long dutyRuleId;
	public long cohortId;
	public String status;

}