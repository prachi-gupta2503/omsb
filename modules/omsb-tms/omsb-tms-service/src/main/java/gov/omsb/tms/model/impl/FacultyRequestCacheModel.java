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

import gov.omsb.tms.model.FacultyRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyRequestCacheModel
	implements CacheModel<FacultyRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyRequestCacheModel)) {
			return false;
		}

		FacultyRequestCacheModel facultyRequestCacheModel =
			(FacultyRequestCacheModel)object;

		if (facultyRequestId == facultyRequestCacheModel.facultyRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyRequestId=");
		sb.append(facultyRequestId);
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
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", potentialFacultyId=");
		sb.append(potentialFacultyId);
		sb.append(", potentialFacultyTypeId=");
		sb.append(potentialFacultyTypeId);
		sb.append(", lastestFacultyRequestStateId=");
		sb.append(lastestFacultyRequestStateId);
		sb.append(", coveringLetterId=");
		sb.append(coveringLetterId);
		sb.append(", cvId=");
		sb.append(cvId);
		sb.append(", passportCopyId=");
		sb.append(passportCopyId);
		sb.append(", notionalIdCopyId=");
		sb.append(notionalIdCopyId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyRequest toEntityModel() {
		FacultyRequestImpl facultyRequestImpl = new FacultyRequestImpl();

		if (uuid == null) {
			facultyRequestImpl.setUuid("");
		}
		else {
			facultyRequestImpl.setUuid(uuid);
		}

		facultyRequestImpl.setFacultyRequestId(facultyRequestId);
		facultyRequestImpl.setGroupId(groupId);
		facultyRequestImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyRequestImpl.setCreateDate(null);
		}
		else {
			facultyRequestImpl.setCreateDate(new Date(createDate));
		}

		facultyRequestImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			facultyRequestImpl.setModifiedDate(null);
		}
		else {
			facultyRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		facultyRequestImpl.setModifiedBy(modifiedBy);
		facultyRequestImpl.setProgramId(programId);
		facultyRequestImpl.setPotentialFacultyId(potentialFacultyId);
		facultyRequestImpl.setPotentialFacultyTypeId(potentialFacultyTypeId);
		facultyRequestImpl.setLastestFacultyRequestStateId(
			lastestFacultyRequestStateId);
		facultyRequestImpl.setCoveringLetterId(coveringLetterId);
		facultyRequestImpl.setCvId(cvId);
		facultyRequestImpl.setPassportCopyId(passportCopyId);
		facultyRequestImpl.setNotionalIdCopyId(notionalIdCopyId);
		facultyRequestImpl.setStatus(status);
		facultyRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			facultyRequestImpl.setStatusByUserName("");
		}
		else {
			facultyRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			facultyRequestImpl.setStatusDate(null);
		}
		else {
			facultyRequestImpl.setStatusDate(new Date(statusDate));
		}

		facultyRequestImpl.resetOriginalValues();

		return facultyRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		programId = objectInput.readLong();

		potentialFacultyId = objectInput.readLong();

		potentialFacultyTypeId = objectInput.readLong();

		lastestFacultyRequestStateId = objectInput.readLong();

		coveringLetterId = objectInput.readLong();

		cvId = objectInput.readLong();

		passportCopyId = objectInput.readLong();

		notionalIdCopyId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyRequestId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(potentialFacultyId);

		objectOutput.writeLong(potentialFacultyTypeId);

		objectOutput.writeLong(lastestFacultyRequestStateId);

		objectOutput.writeLong(coveringLetterId);

		objectOutput.writeLong(cvId);

		objectOutput.writeLong(passportCopyId);

		objectOutput.writeLong(notionalIdCopyId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long facultyRequestId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long programId;
	public long potentialFacultyId;
	public long potentialFacultyTypeId;
	public long lastestFacultyRequestStateId;
	public long coveringLetterId;
	public long cvId;
	public long passportCopyId;
	public long notionalIdCopyId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}