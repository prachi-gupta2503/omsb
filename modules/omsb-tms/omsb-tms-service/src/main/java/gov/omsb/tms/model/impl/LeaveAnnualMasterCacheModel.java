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

import gov.omsb.tms.model.LeaveAnnualMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveAnnualMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveAnnualMasterCacheModel
	implements CacheModel<LeaveAnnualMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveAnnualMasterCacheModel)) {
			return false;
		}

		LeaveAnnualMasterCacheModel leaveAnnualMasterCacheModel =
			(LeaveAnnualMasterCacheModel)object;

		if (leaveAnnualMasterId ==
				leaveAnnualMasterCacheModel.leaveAnnualMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveAnnualMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveAnnualMasterId=");
		sb.append(leaveAnnualMasterId);
		sb.append(", leaveProgramMasterId=");
		sb.append(leaveProgramMasterId);
		sb.append(", leaveTypesId=");
		sb.append(leaveTypesId);
		sb.append(", trainingLevelId=");
		sb.append(trainingLevelId);
		sb.append(", blockName=");
		sb.append(blockName);
		sb.append(", maxTraineeApplyLeave=");
		sb.append(maxTraineeApplyLeave);
		sb.append(", noOfTraineeTakenLeave=");
		sb.append(noOfTraineeTakenLeave);
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
	public LeaveAnnualMaster toEntityModel() {
		LeaveAnnualMasterImpl leaveAnnualMasterImpl =
			new LeaveAnnualMasterImpl();

		if (uuid == null) {
			leaveAnnualMasterImpl.setUuid("");
		}
		else {
			leaveAnnualMasterImpl.setUuid(uuid);
		}

		leaveAnnualMasterImpl.setLeaveAnnualMasterId(leaveAnnualMasterId);
		leaveAnnualMasterImpl.setLeaveProgramMasterId(leaveProgramMasterId);
		leaveAnnualMasterImpl.setLeaveTypesId(leaveTypesId);
		leaveAnnualMasterImpl.setTrainingLevelId(trainingLevelId);

		if (blockName == null) {
			leaveAnnualMasterImpl.setBlockName("");
		}
		else {
			leaveAnnualMasterImpl.setBlockName(blockName);
		}

		leaveAnnualMasterImpl.setMaxTraineeApplyLeave(maxTraineeApplyLeave);
		leaveAnnualMasterImpl.setNoOfTraineeTakenLeave(noOfTraineeTakenLeave);
		leaveAnnualMasterImpl.setGroupId(groupId);
		leaveAnnualMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveAnnualMasterImpl.setCreateDate(null);
		}
		else {
			leaveAnnualMasterImpl.setCreateDate(new Date(createDate));
		}

		leaveAnnualMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveAnnualMasterImpl.setModifiedDate(null);
		}
		else {
			leaveAnnualMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveAnnualMasterImpl.setModifiedBy(modifiedBy);

		leaveAnnualMasterImpl.resetOriginalValues();

		return leaveAnnualMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveAnnualMasterId = objectInput.readLong();

		leaveProgramMasterId = objectInput.readLong();

		leaveTypesId = objectInput.readLong();

		trainingLevelId = objectInput.readLong();
		blockName = objectInput.readUTF();

		maxTraineeApplyLeave = objectInput.readInt();

		noOfTraineeTakenLeave = objectInput.readInt();

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

		objectOutput.writeLong(leaveAnnualMasterId);

		objectOutput.writeLong(leaveProgramMasterId);

		objectOutput.writeLong(leaveTypesId);

		objectOutput.writeLong(trainingLevelId);

		if (blockName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(blockName);
		}

		objectOutput.writeInt(maxTraineeApplyLeave);

		objectOutput.writeInt(noOfTraineeTakenLeave);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveAnnualMasterId;
	public long leaveProgramMasterId;
	public long leaveTypesId;
	public long trainingLevelId;
	public String blockName;
	public int maxTraineeApplyLeave;
	public int noOfTraineeTakenLeave;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}