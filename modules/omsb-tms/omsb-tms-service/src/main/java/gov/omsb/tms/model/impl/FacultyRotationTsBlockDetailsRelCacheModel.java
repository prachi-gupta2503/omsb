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

import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyRotationTsBlockDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelCacheModel
	implements CacheModel<FacultyRotationTsBlockDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyRotationTsBlockDetailsRelCacheModel)) {
			return false;
		}

		FacultyRotationTsBlockDetailsRelCacheModel
			facultyRotationTsBlockDetailsRelCacheModel =
				(FacultyRotationTsBlockDetailsRelCacheModel)object;

		if (facultyRotationTsBlockDetailsRelId ==
				facultyRotationTsBlockDetailsRelCacheModel.
					facultyRotationTsBlockDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyRotationTsBlockDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyRotationTsBlockDetailsRelId=");
		sb.append(facultyRotationTsBlockDetailsRelId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", facultyId=");
		sb.append(facultyId);
		sb.append(", blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);
		sb.append(", progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyRotationTsBlockDetailsRel toEntityModel() {
		FacultyRotationTsBlockDetailsRelImpl
			facultyRotationTsBlockDetailsRelImpl =
				new FacultyRotationTsBlockDetailsRelImpl();

		if (uuid == null) {
			facultyRotationTsBlockDetailsRelImpl.setUuid("");
		}
		else {
			facultyRotationTsBlockDetailsRelImpl.setUuid(uuid);
		}

		facultyRotationTsBlockDetailsRelImpl.
			setFacultyRotationTsBlockDetailsRelId(
				facultyRotationTsBlockDetailsRelId);
		facultyRotationTsBlockDetailsRelImpl.setGroupId(groupId);
		facultyRotationTsBlockDetailsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyRotationTsBlockDetailsRelImpl.setCreateDate(null);
		}
		else {
			facultyRotationTsBlockDetailsRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyRotationTsBlockDetailsRelImpl.setModifiedDate(null);
		}
		else {
			facultyRotationTsBlockDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		facultyRotationTsBlockDetailsRelImpl.setCreatedBy(createdBy);
		facultyRotationTsBlockDetailsRelImpl.setModifiedBy(modifiedBy);
		facultyRotationTsBlockDetailsRelImpl.setFacultyId(facultyId);
		facultyRotationTsBlockDetailsRelImpl.setBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
		facultyRotationTsBlockDetailsRelImpl.setProgDurationRotationTsRelId(
			progDurationRotationTsRelId);

		if (status == null) {
			facultyRotationTsBlockDetailsRelImpl.setStatus("");
		}
		else {
			facultyRotationTsBlockDetailsRelImpl.setStatus(status);
		}

		facultyRotationTsBlockDetailsRelImpl.resetOriginalValues();

		return facultyRotationTsBlockDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyRotationTsBlockDetailsRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		facultyId = objectInput.readLong();

		blocksMetadataDetailsRelId = objectInput.readLong();

		progDurationRotationTsRelId = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyRotationTsBlockDetailsRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(facultyId);

		objectOutput.writeLong(blocksMetadataDetailsRelId);

		objectOutput.writeLong(progDurationRotationTsRelId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long facultyRotationTsBlockDetailsRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public long facultyId;
	public long blocksMetadataDetailsRelId;
	public long progDurationRotationTsRelId;
	public String status;

}