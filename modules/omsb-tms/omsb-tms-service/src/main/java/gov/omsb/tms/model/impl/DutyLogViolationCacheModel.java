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

import gov.omsb.tms.model.DutyLogViolation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DutyLogViolation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DutyLogViolationCacheModel
	implements CacheModel<DutyLogViolation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyLogViolationCacheModel)) {
			return false;
		}

		DutyLogViolationCacheModel dutyLogViolationCacheModel =
			(DutyLogViolationCacheModel)object;

		if (ViolationId == dutyLogViolationCacheModel.ViolationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ViolationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ViolationId=");
		sb.append(ViolationId);
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
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", programMasterId=");
		sb.append(programMasterId);
		sb.append(", residencyLevel=");
		sb.append(residencyLevel);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", trainingSiteId=");
		sb.append(trainingSiteId);
		sb.append(", blockId=");
		sb.append(blockId);
		sb.append(", blockWeekId=");
		sb.append(blockWeekId);
		sb.append(", programDutyRuleId=");
		sb.append(programDutyRuleId);
		sb.append(", acgme80HoursRule=");
		sb.append(acgme80HoursRule);
		sb.append(", acgmeCallRuleOption1=");
		sb.append(acgmeCallRuleOption1);
		sb.append(", acgmeCallRuleOption2=");
		sb.append(acgmeCallRuleOption2);
		sb.append(", acgmeShortBreakRule=");
		sb.append(acgmeShortBreakRule);
		sb.append(", acgme24HoursRule=");
		sb.append(acgme24HoursRule);
		sb.append(", acgmeDayOffRule=");
		sb.append(acgmeDayOffRule);
		sb.append(", dutyLogId=");
		sb.append(dutyLogId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DutyLogViolation toEntityModel() {
		DutyLogViolationImpl dutyLogViolationImpl = new DutyLogViolationImpl();

		if (uuid == null) {
			dutyLogViolationImpl.setUuid("");
		}
		else {
			dutyLogViolationImpl.setUuid(uuid);
		}

		dutyLogViolationImpl.setViolationId(ViolationId);
		dutyLogViolationImpl.setGroupId(groupId);
		dutyLogViolationImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dutyLogViolationImpl.setCreateDate(null);
		}
		else {
			dutyLogViolationImpl.setCreateDate(new Date(createDate));
		}

		dutyLogViolationImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dutyLogViolationImpl.setModifiedDate(null);
		}
		else {
			dutyLogViolationImpl.setModifiedDate(new Date(modifiedDate));
		}

		dutyLogViolationImpl.setModifiedBy(modifiedBy);
		dutyLogViolationImpl.setTraineeId(traineeId);
		dutyLogViolationImpl.setProgramMasterId(programMasterId);
		dutyLogViolationImpl.setResidencyLevel(residencyLevel);
		dutyLogViolationImpl.setRotationId(rotationId);
		dutyLogViolationImpl.setTrainingSiteId(trainingSiteId);
		dutyLogViolationImpl.setBlockId(blockId);
		dutyLogViolationImpl.setBlockWeekId(blockWeekId);
		dutyLogViolationImpl.setProgramDutyRuleId(programDutyRuleId);
		dutyLogViolationImpl.setAcgme80HoursRule(acgme80HoursRule);
		dutyLogViolationImpl.setAcgmeCallRuleOption1(acgmeCallRuleOption1);
		dutyLogViolationImpl.setAcgmeCallRuleOption2(acgmeCallRuleOption2);
		dutyLogViolationImpl.setAcgmeShortBreakRule(acgmeShortBreakRule);
		dutyLogViolationImpl.setAcgme24HoursRule(acgme24HoursRule);
		dutyLogViolationImpl.setAcgmeDayOffRule(acgmeDayOffRule);
		dutyLogViolationImpl.setDutyLogId(dutyLogId);

		dutyLogViolationImpl.resetOriginalValues();

		return dutyLogViolationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ViolationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		traineeId = objectInput.readLong();

		programMasterId = objectInput.readLong();

		residencyLevel = objectInput.readLong();

		rotationId = objectInput.readLong();

		trainingSiteId = objectInput.readLong();

		blockId = objectInput.readLong();

		blockWeekId = objectInput.readLong();

		programDutyRuleId = objectInput.readLong();

		acgme80HoursRule = objectInput.readInt();

		acgmeCallRuleOption1 = objectInput.readInt();

		acgmeCallRuleOption2 = objectInput.readInt();

		acgmeShortBreakRule = objectInput.readInt();

		acgme24HoursRule = objectInput.readInt();

		acgmeDayOffRule = objectInput.readInt();

		dutyLogId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ViolationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(traineeId);

		objectOutput.writeLong(programMasterId);

		objectOutput.writeLong(residencyLevel);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(trainingSiteId);

		objectOutput.writeLong(blockId);

		objectOutput.writeLong(blockWeekId);

		objectOutput.writeLong(programDutyRuleId);

		objectOutput.writeInt(acgme80HoursRule);

		objectOutput.writeInt(acgmeCallRuleOption1);

		objectOutput.writeInt(acgmeCallRuleOption2);

		objectOutput.writeInt(acgmeShortBreakRule);

		objectOutput.writeInt(acgme24HoursRule);

		objectOutput.writeInt(acgmeDayOffRule);

		objectOutput.writeLong(dutyLogId);
	}

	public String uuid;
	public long ViolationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long traineeId;
	public long programMasterId;
	public long residencyLevel;
	public long rotationId;
	public long trainingSiteId;
	public long blockId;
	public long blockWeekId;
	public long programDutyRuleId;
	public int acgme80HoursRule;
	public int acgmeCallRuleOption1;
	public int acgmeCallRuleOption2;
	public int acgmeShortBreakRule;
	public int acgme24HoursRule;
	public int acgmeDayOffRule;
	public long dutyLogId;

}