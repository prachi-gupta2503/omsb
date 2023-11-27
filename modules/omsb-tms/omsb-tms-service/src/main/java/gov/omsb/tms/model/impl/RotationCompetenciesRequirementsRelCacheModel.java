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

import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RotationCompetenciesRequirementsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RotationCompetenciesRequirementsRelCacheModel
	implements CacheModel<RotationCompetenciesRequirementsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				RotationCompetenciesRequirementsRelCacheModel)) {

			return false;
		}

		RotationCompetenciesRequirementsRelCacheModel
			rotationCompetenciesRequirementsRelCacheModel =
				(RotationCompetenciesRequirementsRelCacheModel)object;

		if (rotationCompetenciesRelId ==
				rotationCompetenciesRequirementsRelCacheModel.
					rotationCompetenciesRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rotationCompetenciesRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rotationCompetenciesRelId=");
		sb.append(rotationCompetenciesRelId);
		sb.append(", progDurationId=");
		sb.append(progDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", competenciesMasterId=");
		sb.append(competenciesMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", requirements=");
		sb.append(requirements);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RotationCompetenciesRequirementsRel toEntityModel() {
		RotationCompetenciesRequirementsRelImpl
			rotationCompetenciesRequirementsRelImpl =
				new RotationCompetenciesRequirementsRelImpl();

		if (uuid == null) {
			rotationCompetenciesRequirementsRelImpl.setUuid("");
		}
		else {
			rotationCompetenciesRequirementsRelImpl.setUuid(uuid);
		}

		rotationCompetenciesRequirementsRelImpl.setRotationCompetenciesRelId(
			rotationCompetenciesRelId);
		rotationCompetenciesRequirementsRelImpl.setProgDurationId(
			progDurationId);
		rotationCompetenciesRequirementsRelImpl.setRotationId(rotationId);
		rotationCompetenciesRequirementsRelImpl.setCompetenciesMasterId(
			competenciesMasterId);
		rotationCompetenciesRequirementsRelImpl.setGroupId(groupId);
		rotationCompetenciesRequirementsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			rotationCompetenciesRequirementsRelImpl.setCreateDate(null);
		}
		else {
			rotationCompetenciesRequirementsRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rotationCompetenciesRequirementsRelImpl.setModifiedDate(null);
		}
		else {
			rotationCompetenciesRequirementsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (requirements == null) {
			rotationCompetenciesRequirementsRelImpl.setRequirements("");
		}
		else {
			rotationCompetenciesRequirementsRelImpl.setRequirements(
				requirements);
		}

		rotationCompetenciesRequirementsRelImpl.resetOriginalValues();

		return rotationCompetenciesRequirementsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rotationCompetenciesRelId = objectInput.readLong();

		progDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		competenciesMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		requirements = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rotationCompetenciesRelId);

		objectOutput.writeLong(progDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(competenciesMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (requirements == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requirements);
		}
	}

	public String uuid;
	public long rotationCompetenciesRelId;
	public long progDurationId;
	public long rotationId;
	public long competenciesMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String requirements;

}