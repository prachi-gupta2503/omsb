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

import gov.omsb.tms.model.LeaveTraineeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTraineeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveTraineeMasterCacheModel
	implements CacheModel<LeaveTraineeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveTraineeMasterCacheModel)) {
			return false;
		}

		LeaveTraineeMasterCacheModel leaveTraineeMasterCacheModel =
			(LeaveTraineeMasterCacheModel)object;

		if (leaveTraineeMasterId ==
				leaveTraineeMasterCacheModel.leaveTraineeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveTraineeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveTraineeMasterId=");
		sb.append(leaveTraineeMasterId);
		sb.append(", leaveProgramMasterId=");
		sb.append(leaveProgramMasterId);
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", noOfLeaveTaken=");
		sb.append(noOfLeaveTaken);
		sb.append(", noOfLeaveRemaining=");
		sb.append(noOfLeaveRemaining);
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
	public LeaveTraineeMaster toEntityModel() {
		LeaveTraineeMasterImpl leaveTraineeMasterImpl =
			new LeaveTraineeMasterImpl();

		if (uuid == null) {
			leaveTraineeMasterImpl.setUuid("");
		}
		else {
			leaveTraineeMasterImpl.setUuid(uuid);
		}

		leaveTraineeMasterImpl.setLeaveTraineeMasterId(leaveTraineeMasterId);
		leaveTraineeMasterImpl.setLeaveProgramMasterId(leaveProgramMasterId);
		leaveTraineeMasterImpl.setTraineeId(traineeId);
		leaveTraineeMasterImpl.setNoOfLeaveTaken(noOfLeaveTaken);
		leaveTraineeMasterImpl.setNoOfLeaveRemaining(noOfLeaveRemaining);
		leaveTraineeMasterImpl.setGroupId(groupId);
		leaveTraineeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveTraineeMasterImpl.setCreateDate(null);
		}
		else {
			leaveTraineeMasterImpl.setCreateDate(new Date(createDate));
		}

		leaveTraineeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTraineeMasterImpl.setModifiedDate(null);
		}
		else {
			leaveTraineeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTraineeMasterImpl.setModifiedBy(modifiedBy);

		leaveTraineeMasterImpl.resetOriginalValues();

		return leaveTraineeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveTraineeMasterId = objectInput.readLong();

		leaveProgramMasterId = objectInput.readLong();

		traineeId = objectInput.readLong();

		noOfLeaveTaken = objectInput.readInt();

		noOfLeaveRemaining = objectInput.readInt();

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

		objectOutput.writeLong(leaveTraineeMasterId);

		objectOutput.writeLong(leaveProgramMasterId);

		objectOutput.writeLong(traineeId);

		objectOutput.writeInt(noOfLeaveTaken);

		objectOutput.writeInt(noOfLeaveRemaining);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveTraineeMasterId;
	public long leaveProgramMasterId;
	public long traineeId;
	public int noOfLeaveTaken;
	public int noOfLeaveRemaining;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}