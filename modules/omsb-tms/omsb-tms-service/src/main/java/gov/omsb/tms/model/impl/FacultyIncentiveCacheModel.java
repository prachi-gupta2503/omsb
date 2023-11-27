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

import gov.omsb.tms.model.FacultyIncentive;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyIncentive in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyIncentiveCacheModel
	implements CacheModel<FacultyIncentive>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyIncentiveCacheModel)) {
			return false;
		}

		FacultyIncentiveCacheModel facultyIncentiveCacheModel =
			(FacultyIncentiveCacheModel)object;

		if (FacultyIncentiveId ==
				facultyIncentiveCacheModel.FacultyIncentiveId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, FacultyIncentiveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", FacultyIncentiveId=");
		sb.append(FacultyIncentiveId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", amountInOMR=");
		sb.append(amountInOMR);
		sb.append(", applicableForm=");
		sb.append(applicableForm);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyIncentive toEntityModel() {
		FacultyIncentiveImpl facultyIncentiveImpl = new FacultyIncentiveImpl();

		if (uuid == null) {
			facultyIncentiveImpl.setUuid("");
		}
		else {
			facultyIncentiveImpl.setUuid(uuid);
		}

		facultyIncentiveImpl.setFacultyIncentiveId(FacultyIncentiveId);
		facultyIncentiveImpl.setGroupId(groupId);
		facultyIncentiveImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyIncentiveImpl.setCreateDate(null);
		}
		else {
			facultyIncentiveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyIncentiveImpl.setModifiedDate(null);
		}
		else {
			facultyIncentiveImpl.setModifiedDate(new Date(modifiedDate));
		}

		facultyIncentiveImpl.setRoleId(roleId);
		facultyIncentiveImpl.setAmountInOMR(amountInOMR);

		if (applicableForm == Long.MIN_VALUE) {
			facultyIncentiveImpl.setApplicableForm(null);
		}
		else {
			facultyIncentiveImpl.setApplicableForm(new Date(applicableForm));
		}

		facultyIncentiveImpl.resetOriginalValues();

		return facultyIncentiveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		FacultyIncentiveId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		roleId = objectInput.readLong();

		amountInOMR = objectInput.readLong();
		applicableForm = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(FacultyIncentiveId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(roleId);

		objectOutput.writeLong(amountInOMR);
		objectOutput.writeLong(applicableForm);
	}

	public String uuid;
	public long FacultyIncentiveId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long roleId;
	public long amountInOMR;
	public long applicableForm;

}