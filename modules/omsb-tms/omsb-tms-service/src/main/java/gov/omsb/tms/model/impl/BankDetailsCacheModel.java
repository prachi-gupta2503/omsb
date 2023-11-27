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

import gov.omsb.tms.model.BankDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BankDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BankDetailsCacheModel
	implements CacheModel<BankDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BankDetailsCacheModel)) {
			return false;
		}

		BankDetailsCacheModel bankDetailsCacheModel =
			(BankDetailsCacheModel)object;

		if (bankDetailsId == bankDetailsCacheModel.bankDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bankDetailsId=");
		sb.append(bankDetailsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ecMemberRequestId=");
		sb.append(ecMemberRequestId);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", accountNumber=");
		sb.append(accountNumber);
		sb.append(", bankBranch=");
		sb.append(bankBranch);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BankDetails toEntityModel() {
		BankDetailsImpl bankDetailsImpl = new BankDetailsImpl();

		if (uuid == null) {
			bankDetailsImpl.setUuid("");
		}
		else {
			bankDetailsImpl.setUuid(uuid);
		}

		bankDetailsImpl.setBankDetailsId(bankDetailsId);
		bankDetailsImpl.setGroupId(groupId);
		bankDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			bankDetailsImpl.setCreateDate(null);
		}
		else {
			bankDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bankDetailsImpl.setModifiedDate(null);
		}
		else {
			bankDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		bankDetailsImpl.setEcMemberRequestId(ecMemberRequestId);

		if (bankName == null) {
			bankDetailsImpl.setBankName("");
		}
		else {
			bankDetailsImpl.setBankName(bankName);
		}

		if (accountNumber == null) {
			bankDetailsImpl.setAccountNumber("");
		}
		else {
			bankDetailsImpl.setAccountNumber(accountNumber);
		}

		if (bankBranch == null) {
			bankDetailsImpl.setBankBranch("");
		}
		else {
			bankDetailsImpl.setBankBranch(bankBranch);
		}

		bankDetailsImpl.resetOriginalValues();

		return bankDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bankDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ecMemberRequestId = objectInput.readLong();
		bankName = objectInput.readUTF();
		accountNumber = objectInput.readUTF();
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

		objectOutput.writeLong(bankDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ecMemberRequestId);

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (accountNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNumber);
		}

		if (bankBranch == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankBranch);
		}
	}

	public String uuid;
	public long bankDetailsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long ecMemberRequestId;
	public String bankName;
	public String accountNumber;
	public String bankBranch;

}