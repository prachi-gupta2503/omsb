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

import gov.omsb.tms.model.FacultyType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyTypeCacheModel
	implements CacheModel<FacultyType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyTypeCacheModel)) {
			return false;
		}

		FacultyTypeCacheModel facultyTypeCacheModel =
			(FacultyTypeCacheModel)object;

		if (facultyTypeId == facultyTypeCacheModel.facultyTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{facultyTypeId=");
		sb.append(facultyTypeId);
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
	public FacultyType toEntityModel() {
		FacultyTypeImpl facultyTypeImpl = new FacultyTypeImpl();

		facultyTypeImpl.setFacultyTypeId(facultyTypeId);
		facultyTypeImpl.setGroupId(groupId);
		facultyTypeImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyTypeImpl.setCreateDate(null);
		}
		else {
			facultyTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyTypeImpl.setModifiedDate(null);
		}
		else {
			facultyTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			facultyTypeImpl.setCode("");
		}
		else {
			facultyTypeImpl.setCode(code);
		}

		if (nameEn == null) {
			facultyTypeImpl.setNameEn("");
		}
		else {
			facultyTypeImpl.setNameEn(nameEn);
		}

		if (nameAr == null) {
			facultyTypeImpl.setNameAr("");
		}
		else {
			facultyTypeImpl.setNameAr(nameAr);
		}

		facultyTypeImpl.resetOriginalValues();

		return facultyTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		facultyTypeId = objectInput.readLong();

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
		objectOutput.writeLong(facultyTypeId);

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

	public long facultyTypeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String nameEn;
	public String nameAr;

}