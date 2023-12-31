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

import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationCompetenciesRequirementsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationCompetenciesRequirementsRelCacheModel
	implements CacheModel<ProgdurationCompetenciesRequirementsRel>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				ProgdurationCompetenciesRequirementsRelCacheModel)) {

			return false;
		}

		ProgdurationCompetenciesRequirementsRelCacheModel
			progdurationCompetenciesRequirementsRelCacheModel =
				(ProgdurationCompetenciesRequirementsRelCacheModel)object;

		if (progdurationCompetenciesRelId ==
				progdurationCompetenciesRequirementsRelCacheModel.
					progdurationCompetenciesRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progdurationCompetenciesRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progdurationCompetenciesRelId=");
		sb.append(progdurationCompetenciesRelId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", progDurationId=");
		sb.append(progDurationId);
		sb.append(", competenciesMasterId=");
		sb.append(competenciesMasterId);
		sb.append(", requirements=");
		sb.append(requirements);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationCompetenciesRequirementsRel toEntityModel() {
		ProgdurationCompetenciesRequirementsRelImpl
			progdurationCompetenciesRequirementsRelImpl =
				new ProgdurationCompetenciesRequirementsRelImpl();

		if (uuid == null) {
			progdurationCompetenciesRequirementsRelImpl.setUuid("");
		}
		else {
			progdurationCompetenciesRequirementsRelImpl.setUuid(uuid);
		}

		progdurationCompetenciesRequirementsRelImpl.
			setProgdurationCompetenciesRelId(progdurationCompetenciesRelId);
		progdurationCompetenciesRequirementsRelImpl.setGroupId(groupId);
		progdurationCompetenciesRequirementsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationCompetenciesRequirementsRelImpl.setCreateDate(null);
		}
		else {
			progdurationCompetenciesRequirementsRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationCompetenciesRequirementsRelImpl.setModifiedDate(null);
		}
		else {
			progdurationCompetenciesRequirementsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationCompetenciesRequirementsRelImpl.setProgDurationId(
			progDurationId);
		progdurationCompetenciesRequirementsRelImpl.setCompetenciesMasterId(
			competenciesMasterId);

		if (requirements == null) {
			progdurationCompetenciesRequirementsRelImpl.setRequirements("");
		}
		else {
			progdurationCompetenciesRequirementsRelImpl.setRequirements(
				requirements);
		}

		progdurationCompetenciesRequirementsRelImpl.resetOriginalValues();

		return progdurationCompetenciesRequirementsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progdurationCompetenciesRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		progDurationId = objectInput.readLong();

		competenciesMasterId = objectInput.readLong();
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

		objectOutput.writeLong(progdurationCompetenciesRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(progDurationId);

		objectOutput.writeLong(competenciesMasterId);

		if (requirements == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requirements);
		}
	}

	public String uuid;
	public long progdurationCompetenciesRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long progDurationId;
	public long competenciesMasterId;
	public String requirements;

}