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

import gov.omsb.tms.model.ProgdurationObjectivesRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationObjectivesRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationObjectivesRelCacheModel
	implements CacheModel<ProgdurationObjectivesRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgdurationObjectivesRelCacheModel)) {
			return false;
		}

		ProgdurationObjectivesRelCacheModel
			progdurationObjectivesRelCacheModel =
				(ProgdurationObjectivesRelCacheModel)object;

		if (PDObjectivesId ==
				progdurationObjectivesRelCacheModel.PDObjectivesId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PDObjectivesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PDObjectivesId=");
		sb.append(PDObjectivesId);
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
		sb.append(", objectives=");
		sb.append(objectives);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationObjectivesRel toEntityModel() {
		ProgdurationObjectivesRelImpl progdurationObjectivesRelImpl =
			new ProgdurationObjectivesRelImpl();

		if (uuid == null) {
			progdurationObjectivesRelImpl.setUuid("");
		}
		else {
			progdurationObjectivesRelImpl.setUuid(uuid);
		}

		progdurationObjectivesRelImpl.setPDObjectivesId(PDObjectivesId);
		progdurationObjectivesRelImpl.setGroupId(groupId);
		progdurationObjectivesRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationObjectivesRelImpl.setCreateDate(null);
		}
		else {
			progdurationObjectivesRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationObjectivesRelImpl.setModifiedDate(null);
		}
		else {
			progdurationObjectivesRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationObjectivesRelImpl.setProgDurationId(progDurationId);

		if (objectives == null) {
			progdurationObjectivesRelImpl.setObjectives("");
		}
		else {
			progdurationObjectivesRelImpl.setObjectives(objectives);
		}

		progdurationObjectivesRelImpl.resetOriginalValues();

		return progdurationObjectivesRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PDObjectivesId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		progDurationId = objectInput.readLong();
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

		objectOutput.writeLong(PDObjectivesId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(progDurationId);

		if (objectives == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(objectives);
		}
	}

	public String uuid;
	public long PDObjectivesId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long progDurationId;
	public String objectives;

}