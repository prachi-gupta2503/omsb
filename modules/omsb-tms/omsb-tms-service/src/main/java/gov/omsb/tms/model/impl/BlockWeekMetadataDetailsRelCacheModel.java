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

import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BlockWeekMetadataDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BlockWeekMetadataDetailsRelCacheModel
	implements CacheModel<BlockWeekMetadataDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BlockWeekMetadataDetailsRelCacheModel)) {
			return false;
		}

		BlockWeekMetadataDetailsRelCacheModel
			blockWeekMetadataDetailsRelCacheModel =
				(BlockWeekMetadataDetailsRelCacheModel)object;

		if (blockWeekMetadataDetailsRelId ==
				blockWeekMetadataDetailsRelCacheModel.
					blockWeekMetadataDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, blockWeekMetadataDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", blockWeekMetadataDetailsRelId=");
		sb.append(blockWeekMetadataDetailsRelId);
		sb.append(", blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);
		sb.append(", weekNo=");
		sb.append(weekNo);
		sb.append(", weekStartDate=");
		sb.append(weekStartDate);
		sb.append(", weekEndDate=");
		sb.append(weekEndDate);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BlockWeekMetadataDetailsRel toEntityModel() {
		BlockWeekMetadataDetailsRelImpl blockWeekMetadataDetailsRelImpl =
			new BlockWeekMetadataDetailsRelImpl();

		if (uuid == null) {
			blockWeekMetadataDetailsRelImpl.setUuid("");
		}
		else {
			blockWeekMetadataDetailsRelImpl.setUuid(uuid);
		}

		blockWeekMetadataDetailsRelImpl.setBlockWeekMetadataDetailsRelId(
			blockWeekMetadataDetailsRelId);
		blockWeekMetadataDetailsRelImpl.setBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);

		if (weekNo == null) {
			blockWeekMetadataDetailsRelImpl.setWeekNo("");
		}
		else {
			blockWeekMetadataDetailsRelImpl.setWeekNo(weekNo);
		}

		if (weekStartDate == Long.MIN_VALUE) {
			blockWeekMetadataDetailsRelImpl.setWeekStartDate(null);
		}
		else {
			blockWeekMetadataDetailsRelImpl.setWeekStartDate(
				new Date(weekStartDate));
		}

		if (weekEndDate == Long.MIN_VALUE) {
			blockWeekMetadataDetailsRelImpl.setWeekEndDate(null);
		}
		else {
			blockWeekMetadataDetailsRelImpl.setWeekEndDate(
				new Date(weekEndDate));
		}

		blockWeekMetadataDetailsRelImpl.setGroupId(groupId);
		blockWeekMetadataDetailsRelImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			blockWeekMetadataDetailsRelImpl.setCreatedDate(null);
		}
		else {
			blockWeekMetadataDetailsRelImpl.setCreatedDate(
				new Date(createdDate));
		}

		blockWeekMetadataDetailsRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			blockWeekMetadataDetailsRelImpl.setModifiedDate(null);
		}
		else {
			blockWeekMetadataDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		blockWeekMetadataDetailsRelImpl.setModifiedBy(modifiedBy);

		blockWeekMetadataDetailsRelImpl.resetOriginalValues();

		return blockWeekMetadataDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		blockWeekMetadataDetailsRelId = objectInput.readLong();

		blocksMetadataDetailRelId = objectInput.readLong();
		weekNo = objectInput.readUTF();
		weekStartDate = objectInput.readLong();
		weekEndDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(blockWeekMetadataDetailsRelId);

		objectOutput.writeLong(blocksMetadataDetailRelId);

		if (weekNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(weekNo);
		}

		objectOutput.writeLong(weekStartDate);
		objectOutput.writeLong(weekEndDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long blockWeekMetadataDetailsRelId;
	public long blocksMetadataDetailRelId;
	public String weekNo;
	public long weekStartDate;
	public long weekEndDate;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}