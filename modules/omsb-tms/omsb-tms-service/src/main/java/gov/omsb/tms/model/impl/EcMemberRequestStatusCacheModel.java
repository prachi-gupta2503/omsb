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

import gov.omsb.tms.model.EcMemberRequestStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EcMemberRequestStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EcMemberRequestStatusCacheModel
	implements CacheModel<EcMemberRequestStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EcMemberRequestStatusCacheModel)) {
			return false;
		}

		EcMemberRequestStatusCacheModel ecMemberRequestStatusCacheModel =
			(EcMemberRequestStatusCacheModel)object;

		if (ecMemberRequestStatusId ==
				ecMemberRequestStatusCacheModel.ecMemberRequestStatusId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecMemberRequestStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ecMemberRequestStatusId=");
		sb.append(ecMemberRequestStatusId);
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
	public EcMemberRequestStatus toEntityModel() {
		EcMemberRequestStatusImpl ecMemberRequestStatusImpl =
			new EcMemberRequestStatusImpl();

		if (uuid == null) {
			ecMemberRequestStatusImpl.setUuid("");
		}
		else {
			ecMemberRequestStatusImpl.setUuid(uuid);
		}

		ecMemberRequestStatusImpl.setEcMemberRequestStatusId(
			ecMemberRequestStatusId);
		ecMemberRequestStatusImpl.setGroupId(groupId);
		ecMemberRequestStatusImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ecMemberRequestStatusImpl.setCreateDate(null);
		}
		else {
			ecMemberRequestStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ecMemberRequestStatusImpl.setModifiedDate(null);
		}
		else {
			ecMemberRequestStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			ecMemberRequestStatusImpl.setCode("");
		}
		else {
			ecMemberRequestStatusImpl.setCode(code);
		}

		if (nameEn == null) {
			ecMemberRequestStatusImpl.setNameEn("");
		}
		else {
			ecMemberRequestStatusImpl.setNameEn(nameEn);
		}

		if (nameAr == null) {
			ecMemberRequestStatusImpl.setNameAr("");
		}
		else {
			ecMemberRequestStatusImpl.setNameAr(nameAr);
		}

		ecMemberRequestStatusImpl.resetOriginalValues();

		return ecMemberRequestStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ecMemberRequestStatusId = objectInput.readLong();

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

		objectOutput.writeLong(ecMemberRequestStatusId);

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
	public long ecMemberRequestStatusId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String nameEn;
	public String nameAr;

}