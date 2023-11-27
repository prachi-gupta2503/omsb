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

import gov.omsb.tms.model.LeaveAnnualMaxTrainee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveAnnualMaxTrainee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveAnnualMaxTraineeCacheModel
	implements CacheModel<LeaveAnnualMaxTrainee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveAnnualMaxTraineeCacheModel)) {
			return false;
		}

		LeaveAnnualMaxTraineeCacheModel leaveAnnualMaxTraineeCacheModel =
			(LeaveAnnualMaxTraineeCacheModel)object;

		if (leaveAnnualMaxTraineeId ==
				leaveAnnualMaxTraineeCacheModel.leaveAnnualMaxTraineeId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveAnnualMaxTraineeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveAnnualMaxTraineeId=");
		sb.append(leaveAnnualMaxTraineeId);
		sb.append(", leaveAnnualRuleId=");
		sb.append(leaveAnnualRuleId);
		sb.append(", trainingLevel=");
		sb.append(trainingLevel);
		sb.append(", block=");
		sb.append(block);
		sb.append(", week=");
		sb.append(week);
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
	public LeaveAnnualMaxTrainee toEntityModel() {
		LeaveAnnualMaxTraineeImpl leaveAnnualMaxTraineeImpl =
			new LeaveAnnualMaxTraineeImpl();

		if (uuid == null) {
			leaveAnnualMaxTraineeImpl.setUuid("");
		}
		else {
			leaveAnnualMaxTraineeImpl.setUuid(uuid);
		}

		leaveAnnualMaxTraineeImpl.setLeaveAnnualMaxTraineeId(
			leaveAnnualMaxTraineeId);
		leaveAnnualMaxTraineeImpl.setLeaveAnnualRuleId(leaveAnnualRuleId);

		if (trainingLevel == null) {
			leaveAnnualMaxTraineeImpl.setTrainingLevel("");
		}
		else {
			leaveAnnualMaxTraineeImpl.setTrainingLevel(trainingLevel);
		}

		leaveAnnualMaxTraineeImpl.setBlock(block);
		leaveAnnualMaxTraineeImpl.setWeek(week);
		leaveAnnualMaxTraineeImpl.setMaxTraineeApplyLeave(maxTraineeApplyLeave);
		leaveAnnualMaxTraineeImpl.setNoOfTraineeTakenLeave(
			noOfTraineeTakenLeave);
		leaveAnnualMaxTraineeImpl.setGroupId(groupId);
		leaveAnnualMaxTraineeImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveAnnualMaxTraineeImpl.setCreateDate(null);
		}
		else {
			leaveAnnualMaxTraineeImpl.setCreateDate(new Date(createDate));
		}

		leaveAnnualMaxTraineeImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveAnnualMaxTraineeImpl.setModifiedDate(null);
		}
		else {
			leaveAnnualMaxTraineeImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveAnnualMaxTraineeImpl.setModifiedBy(modifiedBy);

		leaveAnnualMaxTraineeImpl.resetOriginalValues();

		return leaveAnnualMaxTraineeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveAnnualMaxTraineeId = objectInput.readLong();

		leaveAnnualRuleId = objectInput.readLong();
		trainingLevel = objectInput.readUTF();

		block = objectInput.readInt();

		week = objectInput.readInt();

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

		objectOutput.writeLong(leaveAnnualMaxTraineeId);

		objectOutput.writeLong(leaveAnnualRuleId);

		if (trainingLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingLevel);
		}

		objectOutput.writeInt(block);

		objectOutput.writeInt(week);

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
	public long leaveAnnualMaxTraineeId;
	public long leaveAnnualRuleId;
	public String trainingLevel;
	public int block;
	public int week;
	public int maxTraineeApplyLeave;
	public int noOfTraineeTakenLeave;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}