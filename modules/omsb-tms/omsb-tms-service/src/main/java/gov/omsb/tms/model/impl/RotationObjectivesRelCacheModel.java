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

import gov.omsb.tms.model.RotationObjectivesRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RotationObjectivesRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RotationObjectivesRelCacheModel
	implements CacheModel<RotationObjectivesRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RotationObjectivesRelCacheModel)) {
			return false;
		}

		RotationObjectivesRelCacheModel rotationObjectivesRelCacheModel =
			(RotationObjectivesRelCacheModel)object;

		if (rotationObjectivesRelId ==
				rotationObjectivesRelCacheModel.rotationObjectivesRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rotationObjectivesRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rotationObjectivesRelId=");
		sb.append(rotationObjectivesRelId);
		sb.append(", progDurationId=");
		sb.append(progDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", objectives=");
		sb.append(objectives);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RotationObjectivesRel toEntityModel() {
		RotationObjectivesRelImpl rotationObjectivesRelImpl =
			new RotationObjectivesRelImpl();

		if (uuid == null) {
			rotationObjectivesRelImpl.setUuid("");
		}
		else {
			rotationObjectivesRelImpl.setUuid(uuid);
		}

		rotationObjectivesRelImpl.setRotationObjectivesRelId(
			rotationObjectivesRelId);
		rotationObjectivesRelImpl.setProgDurationId(progDurationId);
		rotationObjectivesRelImpl.setRotationId(rotationId);
		rotationObjectivesRelImpl.setGroupId(groupId);
		rotationObjectivesRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			rotationObjectivesRelImpl.setCreateDate(null);
		}
		else {
			rotationObjectivesRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rotationObjectivesRelImpl.setModifiedDate(null);
		}
		else {
			rotationObjectivesRelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (objectives == null) {
			rotationObjectivesRelImpl.setObjectives("");
		}
		else {
			rotationObjectivesRelImpl.setObjectives(objectives);
		}

		rotationObjectivesRelImpl.resetOriginalValues();

		return rotationObjectivesRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		rotationObjectivesRelId = objectInput.readLong();

		progDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		objectives = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(rotationObjectivesRelId);

		objectOutput.writeLong(progDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (objectives == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(objectives);
		}
	}

	public String uuid;
	public long rotationObjectivesRelId;
	public long progDurationId;
	public long rotationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String objectives;

}