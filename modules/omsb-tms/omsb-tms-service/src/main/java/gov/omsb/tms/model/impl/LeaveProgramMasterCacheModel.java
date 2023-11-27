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

import gov.omsb.tms.model.LeaveProgramMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveProgramMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveProgramMasterCacheModel
	implements CacheModel<LeaveProgramMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveProgramMasterCacheModel)) {
			return false;
		}

		LeaveProgramMasterCacheModel leaveProgramMasterCacheModel =
			(LeaveProgramMasterCacheModel)object;

		if (leaveProgramMasterId ==
				leaveProgramMasterCacheModel.leaveProgramMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveProgramMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveProgramMasterId=");
		sb.append(leaveProgramMasterId);
		sb.append(", programMasterId=");
		sb.append(programMasterId);
		sb.append(", leaveTypesId=");
		sb.append(leaveTypesId);
		sb.append(", noOfLeaves=");
		sb.append(noOfLeaves);
		sb.append(", residentLevelRule=");
		sb.append(residentLevelRule);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveProgramMaster toEntityModel() {
		LeaveProgramMasterImpl leaveProgramMasterImpl =
			new LeaveProgramMasterImpl();

		if (uuid == null) {
			leaveProgramMasterImpl.setUuid("");
		}
		else {
			leaveProgramMasterImpl.setUuid(uuid);
		}

		leaveProgramMasterImpl.setLeaveProgramMasterId(leaveProgramMasterId);
		leaveProgramMasterImpl.setProgramMasterId(programMasterId);
		leaveProgramMasterImpl.setLeaveTypesId(leaveTypesId);
		leaveProgramMasterImpl.setNoOfLeaves(noOfLeaves);

		if (residentLevelRule == null) {
			leaveProgramMasterImpl.setResidentLevelRule("");
		}
		else {
			leaveProgramMasterImpl.setResidentLevelRule(residentLevelRule);
		}

		leaveProgramMasterImpl.setGroupId(groupId);
		leaveProgramMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveProgramMasterImpl.setCreateDate(null);
		}
		else {
			leaveProgramMasterImpl.setCreateDate(new Date(createDate));
		}

		leaveProgramMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveProgramMasterImpl.setModifiedDate(null);
		}
		else {
			leaveProgramMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveProgramMasterImpl.setModifiedBy(modifiedBy);

		leaveProgramMasterImpl.resetOriginalValues();

		return leaveProgramMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveProgramMasterId = objectInput.readLong();

		programMasterId = objectInput.readLong();

		leaveTypesId = objectInput.readLong();

		noOfLeaves = objectInput.readInt();
		residentLevelRule = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

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

		objectOutput.writeLong(leaveProgramMasterId);

		objectOutput.writeLong(programMasterId);

		objectOutput.writeLong(leaveTypesId);

		objectOutput.writeInt(noOfLeaves);

		if (residentLevelRule == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(residentLevelRule);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveProgramMasterId;
	public long programMasterId;
	public long leaveTypesId;
	public int noOfLeaves;
	public String residentLevelRule;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}