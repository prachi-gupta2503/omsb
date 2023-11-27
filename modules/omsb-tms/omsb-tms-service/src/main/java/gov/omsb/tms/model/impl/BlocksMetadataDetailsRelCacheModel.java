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

import gov.omsb.tms.model.BlocksMetadataDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BlocksMetadataDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BlocksMetadataDetailsRelCacheModel
	implements CacheModel<BlocksMetadataDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BlocksMetadataDetailsRelCacheModel)) {
			return false;
		}

		BlocksMetadataDetailsRelCacheModel blocksMetadataDetailsRelCacheModel =
			(BlocksMetadataDetailsRelCacheModel)object;

		if (blocksMetadataDetailsRelId ==
				blocksMetadataDetailsRelCacheModel.blocksMetadataDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, blocksMetadataDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", progDurationTlBlocksLtId=");
		sb.append(progDurationTlBlocksLtId);
		sb.append(", blockNo=");
		sb.append(blockNo);
		sb.append(", blockStartDate=");
		sb.append(blockStartDate);
		sb.append(", blockEndDate=");
		sb.append(blockEndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BlocksMetadataDetailsRel toEntityModel() {
		BlocksMetadataDetailsRelImpl blocksMetadataDetailsRelImpl =
			new BlocksMetadataDetailsRelImpl();

		if (uuid == null) {
			blocksMetadataDetailsRelImpl.setUuid("");
		}
		else {
			blocksMetadataDetailsRelImpl.setUuid(uuid);
		}

		blocksMetadataDetailsRelImpl.setBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
		blocksMetadataDetailsRelImpl.setGroupId(groupId);
		blocksMetadataDetailsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			blocksMetadataDetailsRelImpl.setCreateDate(null);
		}
		else {
			blocksMetadataDetailsRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			blocksMetadataDetailsRelImpl.setModifiedDate(null);
		}
		else {
			blocksMetadataDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		blocksMetadataDetailsRelImpl.setCreatedBy(createdBy);
		blocksMetadataDetailsRelImpl.setModifiedBy(modifiedBy);
		blocksMetadataDetailsRelImpl.setProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId);

		if (blockNo == null) {
			blocksMetadataDetailsRelImpl.setBlockNo("");
		}
		else {
			blocksMetadataDetailsRelImpl.setBlockNo(blockNo);
		}

		if (blockStartDate == Long.MIN_VALUE) {
			blocksMetadataDetailsRelImpl.setBlockStartDate(null);
		}
		else {
			blocksMetadataDetailsRelImpl.setBlockStartDate(
				new Date(blockStartDate));
		}

		if (blockEndDate == Long.MIN_VALUE) {
			blocksMetadataDetailsRelImpl.setBlockEndDate(null);
		}
		else {
			blocksMetadataDetailsRelImpl.setBlockEndDate(
				new Date(blockEndDate));
		}

		blocksMetadataDetailsRelImpl.resetOriginalValues();

		return blocksMetadataDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		blocksMetadataDetailsRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		progDurationTlBlocksLtId = objectInput.readLong();
		blockNo = objectInput.readUTF();
		blockStartDate = objectInput.readLong();
		blockEndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(blocksMetadataDetailsRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(progDurationTlBlocksLtId);

		if (blockNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(blockNo);
		}

		objectOutput.writeLong(blockStartDate);
		objectOutput.writeLong(blockEndDate);
	}

	public String uuid;
	public long blocksMetadataDetailsRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public long progDurationTlBlocksLtId;
	public String blockNo;
	public long blockStartDate;
	public long blockEndDate;

}