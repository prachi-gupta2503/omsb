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

import gov.omsb.tms.model.CompetenciesMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompetenciesMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CompetenciesMasterCacheModel
	implements CacheModel<CompetenciesMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CompetenciesMasterCacheModel)) {
			return false;
		}

		CompetenciesMasterCacheModel competenciesMasterCacheModel =
			(CompetenciesMasterCacheModel)object;

		if (competenciesMasterId ==
				competenciesMasterCacheModel.competenciesMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, competenciesMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", competencyName=");
		sb.append(competencyName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompetenciesMaster toEntityModel() {
		CompetenciesMasterImpl competenciesMasterImpl =
			new CompetenciesMasterImpl();

		if (uuid == null) {
			competenciesMasterImpl.setUuid("");
		}
		else {
			competenciesMasterImpl.setUuid(uuid);
		}

		competenciesMasterImpl.setCompetenciesMasterId(competenciesMasterId);
		competenciesMasterImpl.setGroupId(groupId);
		competenciesMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			competenciesMasterImpl.setCreateDate(null);
		}
		else {
			competenciesMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			competenciesMasterImpl.setModifiedDate(null);
		}
		else {
			competenciesMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (competencyName == null) {
			competenciesMasterImpl.setCompetencyName("");
		}
		else {
			competenciesMasterImpl.setCompetencyName(competencyName);
		}

		competenciesMasterImpl.resetOriginalValues();

		return competenciesMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		competenciesMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		competencyName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(competenciesMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (competencyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(competencyName);
		}
	}

	public String uuid;
	public long competenciesMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String competencyName;

}