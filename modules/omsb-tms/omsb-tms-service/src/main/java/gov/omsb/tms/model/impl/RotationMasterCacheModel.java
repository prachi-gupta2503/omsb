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

import gov.omsb.tms.model.RotationMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RotationMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RotationMasterCacheModel
	implements CacheModel<RotationMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RotationMasterCacheModel)) {
			return false;
		}

		RotationMasterCacheModel rotationMasterCacheModel =
			(RotationMasterCacheModel)object;

		if (rotationMasterId == rotationMasterCacheModel.rotationMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rotationMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rotationMasterId=");
		sb.append(rotationMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", rotationCode=");
		sb.append(rotationCode);
		sb.append(", rotationShortName=");
		sb.append(rotationShortName);
		sb.append(", rotationName=");
		sb.append(rotationName);
		sb.append(", rotationStatus=");
		sb.append(rotationStatus);
		sb.append(", rotationObjectives=");
		sb.append(rotationObjectives);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RotationMaster toEntityModel() {
		RotationMasterImpl rotationMasterImpl = new RotationMasterImpl();

		if (uuid == null) {
			rotationMasterImpl.setUuid("");
		}
		else {
			rotationMasterImpl.setUuid(uuid);
		}

		rotationMasterImpl.setRotationMasterId(rotationMasterId);
		rotationMasterImpl.setGroupId(groupId);
		rotationMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			rotationMasterImpl.setCreateDate(null);
		}
		else {
			rotationMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rotationMasterImpl.setModifiedDate(null);
		}
		else {
			rotationMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (rotationCode == null) {
			rotationMasterImpl.setRotationCode("");
		}
		else {
			rotationMasterImpl.setRotationCode(rotationCode);
		}

		if (rotationShortName == null) {
			rotationMasterImpl.setRotationShortName("");
		}
		else {
			rotationMasterImpl.setRotationShortName(rotationShortName);
		}

		if (rotationName == null) {
			rotationMasterImpl.setRotationName("");
		}
		else {
			rotationMasterImpl.setRotationName(rotationName);
		}

		rotationMasterImpl.setRotationStatus(rotationStatus);

		if (rotationObjectives == null) {
			rotationMasterImpl.setRotationObjectives("");
		}
		else {
			rotationMasterImpl.setRotationObjectives(rotationObjectives);
		}

		rotationMasterImpl.resetOriginalValues();

		return rotationMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rotationMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rotationCode = objectInput.readUTF();
		rotationShortName = objectInput.readUTF();
		rotationName = objectInput.readUTF();

		rotationStatus = objectInput.readBoolean();
		rotationObjectives = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rotationMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (rotationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationCode);
		}

		if (rotationShortName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationShortName);
		}

		if (rotationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationName);
		}

		objectOutput.writeBoolean(rotationStatus);

		if (rotationObjectives == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rotationObjectives);
		}
	}

	public String uuid;
	public long rotationMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String rotationCode;
	public String rotationShortName;
	public String rotationName;
	public boolean rotationStatus;
	public String rotationObjectives;

}