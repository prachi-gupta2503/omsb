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

import gov.omsb.tms.model.LeaveTypes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTypes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveTypesCacheModel
	implements CacheModel<LeaveTypes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveTypesCacheModel)) {
			return false;
		}

		LeaveTypesCacheModel leaveTypesCacheModel =
			(LeaveTypesCacheModel)object;

		if (leaveTypesId == leaveTypesCacheModel.leaveTypesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveTypesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveTypesId=");
		sb.append(leaveTypesId);
		sb.append(", leaveTypes=");
		sb.append(leaveTypes);
		sb.append(", leaveCode=");
		sb.append(leaveCode);
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
	public LeaveTypes toEntityModel() {
		LeaveTypesImpl leaveTypesImpl = new LeaveTypesImpl();

		if (uuid == null) {
			leaveTypesImpl.setUuid("");
		}
		else {
			leaveTypesImpl.setUuid(uuid);
		}

		leaveTypesImpl.setLeaveTypesId(leaveTypesId);

		if (leaveTypes == null) {
			leaveTypesImpl.setLeaveTypes("");
		}
		else {
			leaveTypesImpl.setLeaveTypes(leaveTypes);
		}

		if (leaveCode == null) {
			leaveTypesImpl.setLeaveCode("");
		}
		else {
			leaveTypesImpl.setLeaveCode(leaveCode);
		}

		leaveTypesImpl.setGroupId(groupId);
		leaveTypesImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			leaveTypesImpl.setCreateDate(null);
		}
		else {
			leaveTypesImpl.setCreateDate(new Date(createDate));
		}

		leaveTypesImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTypesImpl.setModifiedDate(null);
		}
		else {
			leaveTypesImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTypesImpl.setModifiedBy(modifiedBy);

		leaveTypesImpl.resetOriginalValues();

		return leaveTypesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveTypesId = objectInput.readLong();
		leaveTypes = objectInput.readUTF();
		leaveCode = objectInput.readUTF();

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

		objectOutput.writeLong(leaveTypesId);

		if (leaveTypes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveTypes);
		}

		if (leaveCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveCode);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long leaveTypesId;
	public String leaveTypes;
	public String leaveCode;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}