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

import gov.omsb.tms.model.FacultyRequestStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyRequestStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyRequestStatusCacheModel
	implements CacheModel<FacultyRequestStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyRequestStatusCacheModel)) {
			return false;
		}

		FacultyRequestStatusCacheModel facultyRequestStatusCacheModel =
			(FacultyRequestStatusCacheModel)object;

		if (facultyRequestStatusId ==
				facultyRequestStatusCacheModel.facultyRequestStatusId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyRequestStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyRequestStatusId=");
		sb.append(facultyRequestStatusId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", code=");
		sb.append(code);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", nameAr=");
		sb.append(nameAr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyRequestStatus toEntityModel() {
		FacultyRequestStatusImpl facultyRequestStatusImpl =
			new FacultyRequestStatusImpl();

		if (uuid == null) {
			facultyRequestStatusImpl.setUuid("");
		}
		else {
			facultyRequestStatusImpl.setUuid(uuid);
		}

		facultyRequestStatusImpl.setFacultyRequestStatusId(
			facultyRequestStatusId);
		facultyRequestStatusImpl.setGroupId(groupId);
		facultyRequestStatusImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyRequestStatusImpl.setCreateDate(null);
		}
		else {
			facultyRequestStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyRequestStatusImpl.setModifiedDate(null);
		}
		else {
			facultyRequestStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			facultyRequestStatusImpl.setCode("");
		}
		else {
			facultyRequestStatusImpl.setCode(code);
		}

		if (nameEn == null) {
			facultyRequestStatusImpl.setNameEn("");
		}
		else {
			facultyRequestStatusImpl.setNameEn(nameEn);
		}

		if (nameAr == null) {
			facultyRequestStatusImpl.setNameAr("");
		}
		else {
			facultyRequestStatusImpl.setNameAr(nameAr);
		}

		facultyRequestStatusImpl.resetOriginalValues();

		return facultyRequestStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyRequestStatusId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		nameEn = objectInput.readUTF();
		nameAr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyRequestStatusId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (nameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameEn);
		}

		if (nameAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameAr);
		}
	}

	public String uuid;
	public long facultyRequestStatusId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String nameEn;
	public String nameAr;

}