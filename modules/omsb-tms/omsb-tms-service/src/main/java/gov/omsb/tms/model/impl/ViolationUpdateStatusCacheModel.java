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

import gov.omsb.tms.model.ViolationUpdateStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ViolationUpdateStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ViolationUpdateStatusCacheModel
	implements CacheModel<ViolationUpdateStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ViolationUpdateStatusCacheModel)) {
			return false;
		}

		ViolationUpdateStatusCacheModel violationUpdateStatusCacheModel =
			(ViolationUpdateStatusCacheModel)object;

		if (violationUpdateStatusId ==
				violationUpdateStatusCacheModel.violationUpdateStatusId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, violationUpdateStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", violationUpdateStatusId=");
		sb.append(violationUpdateStatusId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ViolationUpdateStatus toEntityModel() {
		ViolationUpdateStatusImpl violationUpdateStatusImpl =
			new ViolationUpdateStatusImpl();

		if (uuid == null) {
			violationUpdateStatusImpl.setUuid("");
		}
		else {
			violationUpdateStatusImpl.setUuid(uuid);
		}

		violationUpdateStatusImpl.setViolationUpdateStatusId(
			violationUpdateStatusId);
		violationUpdateStatusImpl.setGroupId(groupId);
		violationUpdateStatusImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			violationUpdateStatusImpl.setCreatedDate(null);
		}
		else {
			violationUpdateStatusImpl.setCreatedDate(new Date(createdDate));
		}

		violationUpdateStatusImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			violationUpdateStatusImpl.setModifiedDate(null);
		}
		else {
			violationUpdateStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		violationUpdateStatusImpl.setModifiedBy(modifiedBy);
		violationUpdateStatusImpl.setBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
		violationUpdateStatusImpl.setStatus(status);

		violationUpdateStatusImpl.resetOriginalValues();

		return violationUpdateStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		violationUpdateStatusId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		blocksMetadataDetailRelId = objectInput.readLong();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(violationUpdateStatusId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(blocksMetadataDetailRelId);

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long violationUpdateStatusId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long blocksMetadataDetailRelId;
	public boolean status;

}