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

import gov.omsb.tms.model.FacultyBankDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FacultyBankDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FacultyBankDetailsCacheModel
	implements CacheModel<FacultyBankDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FacultyBankDetailsCacheModel)) {
			return false;
		}

		FacultyBankDetailsCacheModel facultyBankDetailsCacheModel =
			(FacultyBankDetailsCacheModel)object;

		if (facultyBankDetailsId ==
				facultyBankDetailsCacheModel.facultyBankDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, facultyBankDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", facultyBankDetailsId=");
		sb.append(facultyBankDetailsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", facultyRequestId=");
		sb.append(facultyRequestId);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", accountNo=");
		sb.append(accountNo);
		sb.append(", bankBranch=");
		sb.append(bankBranch);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FacultyBankDetails toEntityModel() {
		FacultyBankDetailsImpl facultyBankDetailsImpl =
			new FacultyBankDetailsImpl();

		if (uuid == null) {
			facultyBankDetailsImpl.setUuid("");
		}
		else {
			facultyBankDetailsImpl.setUuid(uuid);
		}

		facultyBankDetailsImpl.setFacultyBankDetailsId(facultyBankDetailsId);
		facultyBankDetailsImpl.setGroupId(groupId);
		facultyBankDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			facultyBankDetailsImpl.setCreateDate(null);
		}
		else {
			facultyBankDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			facultyBankDetailsImpl.setModifiedDate(null);
		}
		else {
			facultyBankDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		facultyBankDetailsImpl.setFacultyRequestId(facultyRequestId);

		if (bankName == null) {
			facultyBankDetailsImpl.setBankName("");
		}
		else {
			facultyBankDetailsImpl.setBankName(bankName);
		}

		if (accountNo == null) {
			facultyBankDetailsImpl.setAccountNo("");
		}
		else {
			facultyBankDetailsImpl.setAccountNo(accountNo);
		}

		if (bankBranch == null) {
			facultyBankDetailsImpl.setBankBranch("");
		}
		else {
			facultyBankDetailsImpl.setBankBranch(bankBranch);
		}

		facultyBankDetailsImpl.resetOriginalValues();

		return facultyBankDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		facultyBankDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		facultyRequestId = objectInput.readLong();
		bankName = objectInput.readUTF();
		accountNo = objectInput.readUTF();
		bankBranch = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(facultyBankDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(facultyRequestId);

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (accountNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNo);
		}

		if (bankBranch == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankBranch);
		}
	}

	public String uuid;
	public long facultyBankDetailsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long facultyRequestId;
	public String bankName;
	public String accountNo;
	public String bankBranch;

}