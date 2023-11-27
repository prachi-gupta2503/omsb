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

import gov.omsb.tms.model.FacultyRequestRotations;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyRequestRotations in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyRequestRotationsCacheModel
	implements CacheModel<FacultyRequestRotations>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyRequestRotationsCacheModel)) {
			return false;
		}

		FacultyRequestRotationsCacheModel facultyRequestRotationsCacheModel =
			(FacultyRequestRotationsCacheModel)object;

		if (facultyRequestRotationsId ==
				facultyRequestRotationsCacheModel.facultyRequestRotationsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyRequestRotationsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyRequestRotationsId=");
		sb.append(facultyRequestRotationsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", facultyRequestId=");
		sb.append(facultyRequestId);
		sb.append(", trainingSiteId=");
		sb.append(trainingSiteId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyRequestRotations toEntityModel() {
		FacultyRequestRotationsImpl facultyRequestRotationsImpl =
			new FacultyRequestRotationsImpl();

		if (uuid == null) {
			facultyRequestRotationsImpl.setUuid("");
		}
		else {
			facultyRequestRotationsImpl.setUuid(uuid);
		}

		facultyRequestRotationsImpl.setFacultyRequestRotationsId(
			facultyRequestRotationsId);
		facultyRequestRotationsImpl.setGroupId(groupId);
		facultyRequestRotationsImpl.setCompanyId(companyId);
		facultyRequestRotationsImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			facultyRequestRotationsImpl.setCreateDate(null);
		}
		else {
			facultyRequestRotationsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyRequestRotationsImpl.setModifiedDate(null);
		}
		else {
			facultyRequestRotationsImpl.setModifiedDate(new Date(modifiedDate));
		}

		facultyRequestRotationsImpl.setModifiedBy(modifiedBy);
		facultyRequestRotationsImpl.setFacultyRequestId(facultyRequestId);
		facultyRequestRotationsImpl.setTrainingSiteId(trainingSiteId);
		facultyRequestRotationsImpl.setRotationId(rotationId);
		facultyRequestRotationsImpl.setIsActive(isActive);

		facultyRequestRotationsImpl.resetOriginalValues();

		return facultyRequestRotationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyRequestRotationsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		facultyRequestId = objectInput.readLong();

		trainingSiteId = objectInput.readLong();

		rotationId = objectInput.readLong();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyRequestRotationsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(facultyRequestId);

		objectOutput.writeLong(trainingSiteId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeBoolean(isActive);
	}

	public String uuid;
	public long facultyRequestRotationsId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long createDate;
	public long modifiedDate;
	public long modifiedBy;
	public long facultyRequestId;
	public long trainingSiteId;
	public long rotationId;
	public boolean isActive;

}