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

import gov.omsb.tms.model.FacultyRequestState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyRequestState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyRequestStateCacheModel
	implements CacheModel<FacultyRequestState>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyRequestStateCacheModel)) {
			return false;
		}

		FacultyRequestStateCacheModel facultyRequestStateCacheModel =
			(FacultyRequestStateCacheModel)object;

		if (facultyRequestStateId ==
				facultyRequestStateCacheModel.facultyRequestStateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyRequestStateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyRequestStateId=");
		sb.append(facultyRequestStateId);
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
		sb.append(", createdByRoleId=");
		sb.append(createdByRoleId);
		sb.append(", facultyRequestId=");
		sb.append(facultyRequestId);
		sb.append(", facultyRequestStatusId=");
		sb.append(facultyRequestStatusId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyRequestState toEntityModel() {
		FacultyRequestStateImpl facultyRequestStateImpl =
			new FacultyRequestStateImpl();

		if (uuid == null) {
			facultyRequestStateImpl.setUuid("");
		}
		else {
			facultyRequestStateImpl.setUuid(uuid);
		}

		facultyRequestStateImpl.setFacultyRequestStateId(facultyRequestStateId);
		facultyRequestStateImpl.setGroupId(groupId);
		facultyRequestStateImpl.setCompanyId(companyId);
		facultyRequestStateImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			facultyRequestStateImpl.setCreateDate(null);
		}
		else {
			facultyRequestStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyRequestStateImpl.setModifiedDate(null);
		}
		else {
			facultyRequestStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		facultyRequestStateImpl.setCreatedByRoleId(createdByRoleId);
		facultyRequestStateImpl.setFacultyRequestId(facultyRequestId);
		facultyRequestStateImpl.setFacultyRequestStatusId(
			facultyRequestStatusId);

		if (comments == null) {
			facultyRequestStateImpl.setComments("");
		}
		else {
			facultyRequestStateImpl.setComments(comments);
		}

		facultyRequestStateImpl.resetOriginalValues();

		return facultyRequestStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyRequestStateId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByRoleId = objectInput.readLong();

		facultyRequestId = objectInput.readLong();

		facultyRequestStatusId = objectInput.readLong();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyRequestStateId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByRoleId);

		objectOutput.writeLong(facultyRequestId);

		objectOutput.writeLong(facultyRequestStatusId);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public String uuid;
	public long facultyRequestStateId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long createDate;
	public long modifiedDate;
	public long createdByRoleId;
	public long facultyRequestId;
	public long facultyRequestStatusId;
	public String comments;

}