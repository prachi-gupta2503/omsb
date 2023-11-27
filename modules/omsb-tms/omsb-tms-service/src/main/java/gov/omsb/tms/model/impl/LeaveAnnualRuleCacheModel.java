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

import gov.omsb.tms.model.LeaveAnnualRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveAnnualRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveAnnualRuleCacheModel
	implements CacheModel<LeaveAnnualRule>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveAnnualRuleCacheModel)) {
			return false;
		}

		LeaveAnnualRuleCacheModel leaveAnnualRuleCacheModel =
			(LeaveAnnualRuleCacheModel)object;

		if (leaveAnnualRuleId == leaveAnnualRuleCacheModel.leaveAnnualRuleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveAnnualRuleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveAnnualRuleId=");
		sb.append(leaveAnnualRuleId);
		sb.append(", programMasterId=");
		sb.append(programMasterId);
		sb.append(", lastDateForSubmission=");
		sb.append(lastDateForSubmission);
		sb.append(", annualLeaveAvailableAt=");
		sb.append(annualLeaveAvailableAt);
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
	public LeaveAnnualRule toEntityModel() {
		LeaveAnnualRuleImpl leaveAnnualRuleImpl = new LeaveAnnualRuleImpl();

		if (uuid == null) {
			leaveAnnualRuleImpl.setUuid("");
		}
		else {
			leaveAnnualRuleImpl.setUuid(uuid);
		}

		leaveAnnualRuleImpl.setLeaveAnnualRuleId(leaveAnnualRuleId);
		leaveAnnualRuleImpl.setProgramMasterId(programMasterId);

		if (lastDateForSubmission == Long.MIN_VALUE) {
			leaveAnnualRuleImpl.setLastDateForSubmission(null);
		}
		else {
			leaveAnnualRuleImpl.setLastDateForSubmission(
				new Date(lastDateForSubmission));
		}

		if (annualLeaveAvailableAt == null) {
			leaveAnnualRuleImpl.setAnnualLeaveAvailableAt("");
		}
		else {
			leaveAnnualRuleImpl.setAnnualLeaveAvailableAt(
				annualLeaveAvailableAt);
		}

		leaveAnnualRuleImpl.setGroupId(groupId);
		leaveAnnualRuleImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveAnnualRuleImpl.setCreateDate(null);
		}
		else {
			leaveAnnualRuleImpl.setCreateDate(new Date(createDate));
		}

		leaveAnnualRuleImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveAnnualRuleImpl.setModifiedDate(null);
		}
		else {
			leaveAnnualRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveAnnualRuleImpl.setModifiedBy(modifiedBy);

		leaveAnnualRuleImpl.resetOriginalValues();

		return leaveAnnualRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveAnnualRuleId = objectInput.readLong();

		programMasterId = objectInput.readLong();
		lastDateForSubmission = objectInput.readLong();
		annualLeaveAvailableAt = objectInput.readUTF();

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

		objectOutput.writeLong(leaveAnnualRuleId);

		objectOutput.writeLong(programMasterId);
		objectOutput.writeLong(lastDateForSubmission);

		if (annualLeaveAvailableAt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(annualLeaveAvailableAt);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveAnnualRuleId;
	public long programMasterId;
	public long lastDateForSubmission;
	public String annualLeaveAvailableAt;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}