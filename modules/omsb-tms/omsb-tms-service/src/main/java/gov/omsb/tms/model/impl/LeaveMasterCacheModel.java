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

import gov.omsb.tms.model.LeaveMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveMasterCacheModel
	implements CacheModel<LeaveMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveMasterCacheModel)) {
			return false;
		}

		LeaveMasterCacheModel leaveMasterCacheModel =
			(LeaveMasterCacheModel)object;

		if (leaveMasterId == leaveMasterCacheModel.leaveMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveMasterId=");
		sb.append(leaveMasterId);
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", leaveTypeId=");
		sb.append(leaveTypeId);
		sb.append(", leaveTraineeId=");
		sb.append(leaveTraineeId);
		sb.append(", blockName=");
		sb.append(blockName);
		sb.append(", leaveFrom=");
		sb.append(leaveFrom);
		sb.append(", leaveTo=");
		sb.append(leaveTo);
		sb.append(", noOfDays=");
		sb.append(noOfDays);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", contactEmail=");
		sb.append(contactEmail);
		sb.append(", contactNo=");
		sb.append(contactNo);
		sb.append(", reasonForLeave=");
		sb.append(reasonForLeave);
		sb.append(", applicationDate=");
		sb.append(applicationDate);
		sb.append(", returnFromLeave=");
		sb.append(returnFromLeave);
		sb.append(", reasonForDelay=");
		sb.append(reasonForDelay);
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
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
	public LeaveMaster toEntityModel() {
		LeaveMasterImpl leaveMasterImpl = new LeaveMasterImpl();

		if (uuid == null) {
			leaveMasterImpl.setUuid("");
		}
		else {
			leaveMasterImpl.setUuid(uuid);
		}

		leaveMasterImpl.setLeaveMasterId(leaveMasterId);
		leaveMasterImpl.setTraineeId(traineeId);
		leaveMasterImpl.setLeaveTypeId(leaveTypeId);
		leaveMasterImpl.setLeaveTraineeId(leaveTraineeId);

		if (blockName == null) {
			leaveMasterImpl.setBlockName("");
		}
		else {
			leaveMasterImpl.setBlockName(blockName);
		}

		if (leaveFrom == Long.MIN_VALUE) {
			leaveMasterImpl.setLeaveFrom(null);
		}
		else {
			leaveMasterImpl.setLeaveFrom(new Date(leaveFrom));
		}

		if (leaveTo == Long.MIN_VALUE) {
			leaveMasterImpl.setLeaveTo(null);
		}
		else {
			leaveMasterImpl.setLeaveTo(new Date(leaveTo));
		}

		leaveMasterImpl.setNoOfDays(noOfDays);

		if (contactName == null) {
			leaveMasterImpl.setContactName("");
		}
		else {
			leaveMasterImpl.setContactName(contactName);
		}

		if (contactEmail == null) {
			leaveMasterImpl.setContactEmail("");
		}
		else {
			leaveMasterImpl.setContactEmail(contactEmail);
		}

		if (contactNo == null) {
			leaveMasterImpl.setContactNo("");
		}
		else {
			leaveMasterImpl.setContactNo(contactNo);
		}

		if (reasonForLeave == null) {
			leaveMasterImpl.setReasonForLeave("");
		}
		else {
			leaveMasterImpl.setReasonForLeave(reasonForLeave);
		}

		if (applicationDate == Long.MIN_VALUE) {
			leaveMasterImpl.setApplicationDate(null);
		}
		else {
			leaveMasterImpl.setApplicationDate(new Date(applicationDate));
		}

		if (returnFromLeave == Long.MIN_VALUE) {
			leaveMasterImpl.setReturnFromLeave(null);
		}
		else {
			leaveMasterImpl.setReturnFromLeave(new Date(returnFromLeave));
		}

		if (reasonForDelay == null) {
			leaveMasterImpl.setReasonForDelay("");
		}
		else {
			leaveMasterImpl.setReasonForDelay(reasonForDelay);
		}

		leaveMasterImpl.setProgramId(programId);
		leaveMasterImpl.setStatus(status);
		leaveMasterImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			leaveMasterImpl.setStatusByUserName("");
		}
		else {
			leaveMasterImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			leaveMasterImpl.setStatusDate(null);
		}
		else {
			leaveMasterImpl.setStatusDate(new Date(statusDate));
		}

		leaveMasterImpl.setGroupId(groupId);
		leaveMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveMasterImpl.setCreateDate(null);
		}
		else {
			leaveMasterImpl.setCreateDate(new Date(createDate));
		}

		leaveMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveMasterImpl.setModifiedDate(null);
		}
		else {
			leaveMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveMasterImpl.setModifiedBy(modifiedBy);

		leaveMasterImpl.resetOriginalValues();

		return leaveMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveMasterId = objectInput.readLong();

		traineeId = objectInput.readLong();

		leaveTypeId = objectInput.readLong();

		leaveTraineeId = objectInput.readLong();
		blockName = objectInput.readUTF();
		leaveFrom = objectInput.readLong();
		leaveTo = objectInput.readLong();

		noOfDays = objectInput.readInt();
		contactName = objectInput.readUTF();
		contactEmail = objectInput.readUTF();
		contactNo = objectInput.readUTF();
		reasonForLeave = objectInput.readUTF();
		applicationDate = objectInput.readLong();
		returnFromLeave = objectInput.readLong();
		reasonForDelay = objectInput.readUTF();

		programId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

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

		objectOutput.writeLong(leaveMasterId);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(leaveTypeId);

		objectOutput.writeLong(leaveTraineeId);

		if (blockName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(blockName);
		}

		objectOutput.writeLong(leaveFrom);
		objectOutput.writeLong(leaveTo);

		objectOutput.writeInt(noOfDays);

		if (contactName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		if (contactEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactEmail);
		}

		if (contactNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNo);
		}

		if (reasonForLeave == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reasonForLeave);
		}

		objectOutput.writeLong(applicationDate);
		objectOutput.writeLong(returnFromLeave);

		if (reasonForDelay == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reasonForDelay);
		}

		objectOutput.writeLong(programId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveMasterId;
	public long traineeId;
	public long leaveTypeId;
	public long leaveTraineeId;
	public String blockName;
	public long leaveFrom;
	public long leaveTo;
	public int noOfDays;
	public String contactName;
	public String contactEmail;
	public String contactNo;
	public String reasonForLeave;
	public long applicationDate;
	public long returnFromLeave;
	public String reasonForDelay;
	public long programId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}