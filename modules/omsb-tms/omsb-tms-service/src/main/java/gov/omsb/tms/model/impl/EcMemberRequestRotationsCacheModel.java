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

import gov.omsb.tms.model.EcMemberRequestRotations;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EcMemberRequestRotations in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EcMemberRequestRotationsCacheModel
	implements CacheModel<EcMemberRequestRotations>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EcMemberRequestRotationsCacheModel)) {
			return false;
		}

		EcMemberRequestRotationsCacheModel ecMemberRequestRotationsCacheModel =
			(EcMemberRequestRotationsCacheModel)object;

		if (ecMemberRequestRotationsId ==
				ecMemberRequestRotationsCacheModel.ecMemberRequestRotationsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecMemberRequestRotationsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ecMemberRequestRotationsId=");
		sb.append(ecMemberRequestRotationsId);
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
		sb.append(", trainingSiteId=");
		sb.append(trainingSiteId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcMemberRequestRotations toEntityModel() {
		EcMemberRequestRotationsImpl ecMemberRequestRotationsImpl =
			new EcMemberRequestRotationsImpl();

		if (uuid == null) {
			ecMemberRequestRotationsImpl.setUuid("");
		}
		else {
			ecMemberRequestRotationsImpl.setUuid(uuid);
		}

		ecMemberRequestRotationsImpl.setEcMemberRequestRotationsId(
			ecMemberRequestRotationsId);
		ecMemberRequestRotationsImpl.setGroupId(groupId);
		ecMemberRequestRotationsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ecMemberRequestRotationsImpl.setCreateDate(null);
		}
		else {
			ecMemberRequestRotationsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ecMemberRequestRotationsImpl.setModifiedDate(null);
		}
		else {
			ecMemberRequestRotationsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		ecMemberRequestRotationsImpl.setEcMemberRequestId(ecMemberRequestId);
		ecMemberRequestRotationsImpl.setTrainingSiteId(trainingSiteId);
		ecMemberRequestRotationsImpl.setRotationId(rotationId);
		ecMemberRequestRotationsImpl.setIsActive(isActive);

		ecMemberRequestRotationsImpl.resetOriginalValues();

		return ecMemberRequestRotationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ecMemberRequestRotationsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ecMemberRequestId = objectInput.readLong();

		trainingSiteId = objectInput.readLong();

		rotationId = objectInput.readLong();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ecMemberRequestRotationsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ecMemberRequestId);

		objectOutput.writeLong(trainingSiteId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeBoolean(isActive);
	}

	public String uuid;
	public long ecMemberRequestRotationsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long ecMemberRequestId;
	public long trainingSiteId;
	public long rotationId;
	public boolean isActive;

}