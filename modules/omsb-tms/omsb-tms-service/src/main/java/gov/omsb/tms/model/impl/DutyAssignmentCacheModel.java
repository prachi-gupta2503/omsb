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

import gov.omsb.tms.model.DutyAssignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DutyAssignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DutyAssignmentCacheModel
	implements CacheModel<DutyAssignment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyAssignmentCacheModel)) {
			return false;
		}

		DutyAssignmentCacheModel dutyAssignmentCacheModel =
			(DutyAssignmentCacheModel)object;

		if (dutyAssignmentId == dutyAssignmentCacheModel.dutyAssignmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dutyAssignmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dutyAssignmentId=");
		sb.append(dutyAssignmentId);
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
		sb.append(", dutyTypeId=");
		sb.append(dutyTypeId);
		sb.append(", assignment=");
		sb.append(assignment);
		sb.append(", status=");
		sb.append(status);
		sb.append(", colorCode=");
		sb.append(colorCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DutyAssignment toEntityModel() {
		DutyAssignmentImpl dutyAssignmentImpl = new DutyAssignmentImpl();

		if (uuid == null) {
			dutyAssignmentImpl.setUuid("");
		}
		else {
			dutyAssignmentImpl.setUuid(uuid);
		}

		dutyAssignmentImpl.setDutyAssignmentId(dutyAssignmentId);
		dutyAssignmentImpl.setGroupId(groupId);
		dutyAssignmentImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dutyAssignmentImpl.setCreateDate(null);
		}
		else {
			dutyAssignmentImpl.setCreateDate(new Date(createDate));
		}

		dutyAssignmentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dutyAssignmentImpl.setModifiedDate(null);
		}
		else {
			dutyAssignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		dutyAssignmentImpl.setModifiedBy(modifiedBy);
		dutyAssignmentImpl.setDutyTypeId(dutyTypeId);

		if (assignment == null) {
			dutyAssignmentImpl.setAssignment("");
		}
		else {
			dutyAssignmentImpl.setAssignment(assignment);
		}

		if (status == null) {
			dutyAssignmentImpl.setStatus("");
		}
		else {
			dutyAssignmentImpl.setStatus(status);
		}

		if (colorCode == null) {
			dutyAssignmentImpl.setColorCode("");
		}
		else {
			dutyAssignmentImpl.setColorCode(colorCode);
		}

		dutyAssignmentImpl.resetOriginalValues();

		return dutyAssignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dutyAssignmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		dutyTypeId = objectInput.readLong();
		assignment = objectInput.readUTF();
		status = objectInput.readUTF();
		colorCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dutyAssignmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(dutyTypeId);

		if (assignment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(assignment);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (colorCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(colorCode);
		}
	}

	public String uuid;
	public long dutyAssignmentId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long dutyTypeId;
	public String assignment;
	public String status;
	public String colorCode;

}