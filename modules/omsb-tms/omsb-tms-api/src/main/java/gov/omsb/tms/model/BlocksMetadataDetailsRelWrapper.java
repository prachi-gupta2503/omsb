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

package gov.omsb.tms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BlocksMetadataDetailsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRel
 * @generated
 */
public class BlocksMetadataDetailsRelWrapper
	extends BaseModelWrapper<BlocksMetadataDetailsRel>
	implements BlocksMetadataDetailsRel,
			   ModelWrapper<BlocksMetadataDetailsRel> {

	public BlocksMetadataDetailsRelWrapper(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		super(blocksMetadataDetailsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"blocksMetadataDetailsRelId", getBlocksMetadataDetailsRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put(
			"progDurationTlBlocksLtId", getProgDurationTlBlocksLtId());
		attributes.put("blockNo", getBlockNo());
		attributes.put("blockStartDate", getBlockStartDate());
		attributes.put("blockEndDate", getBlockEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long blocksMetadataDetailsRelId = (Long)attributes.get(
			"blocksMetadataDetailsRelId");

		if (blocksMetadataDetailsRelId != null) {
			setBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long progDurationTlBlocksLtId = (Long)attributes.get(
			"progDurationTlBlocksLtId");

		if (progDurationTlBlocksLtId != null) {
			setProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
		}

		String blockNo = (String)attributes.get("blockNo");

		if (blockNo != null) {
			setBlockNo(blockNo);
		}

		Date blockStartDate = (Date)attributes.get("blockStartDate");

		if (blockStartDate != null) {
			setBlockStartDate(blockStartDate);
		}

		Date blockEndDate = (Date)attributes.get("blockEndDate");

		if (blockEndDate != null) {
			setBlockEndDate(blockEndDate);
		}
	}

	@Override
	public BlocksMetadataDetailsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the block end date of this blocks metadata details rel.
	 *
	 * @return the block end date of this blocks metadata details rel
	 */
	@Override
	public Date getBlockEndDate() {
		return model.getBlockEndDate();
	}

	/**
	 * Returns the block no of this blocks metadata details rel.
	 *
	 * @return the block no of this blocks metadata details rel
	 */
	@Override
	public String getBlockNo() {
		return model.getBlockNo();
	}

	/**
	 * Returns the blocks metadata details rel ID of this blocks metadata details rel.
	 *
	 * @return the blocks metadata details rel ID of this blocks metadata details rel
	 */
	@Override
	public long getBlocksMetadataDetailsRelId() {
		return model.getBlocksMetadataDetailsRelId();
	}

	/**
	 * Returns the block start date of this blocks metadata details rel.
	 *
	 * @return the block start date of this blocks metadata details rel
	 */
	@Override
	public Date getBlockStartDate() {
		return model.getBlockStartDate();
	}

	/**
	 * Returns the company ID of this blocks metadata details rel.
	 *
	 * @return the company ID of this blocks metadata details rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this blocks metadata details rel.
	 *
	 * @return the create date of this blocks metadata details rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this blocks metadata details rel.
	 *
	 * @return the created by of this blocks metadata details rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this blocks metadata details rel.
	 *
	 * @return the group ID of this blocks metadata details rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this blocks metadata details rel.
	 *
	 * @return the modified by of this blocks metadata details rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this blocks metadata details rel.
	 *
	 * @return the modified date of this blocks metadata details rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this blocks metadata details rel.
	 *
	 * @return the primary key of this blocks metadata details rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog duration tl blocks lt ID of this blocks metadata details rel.
	 *
	 * @return the prog duration tl blocks lt ID of this blocks metadata details rel
	 */
	@Override
	public long getProgDurationTlBlocksLtId() {
		return model.getProgDurationTlBlocksLtId();
	}

	/**
	 * Returns the uuid of this blocks metadata details rel.
	 *
	 * @return the uuid of this blocks metadata details rel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the block end date of this blocks metadata details rel.
	 *
	 * @param blockEndDate the block end date of this blocks metadata details rel
	 */
	@Override
	public void setBlockEndDate(Date blockEndDate) {
		model.setBlockEndDate(blockEndDate);
	}

	/**
	 * Sets the block no of this blocks metadata details rel.
	 *
	 * @param blockNo the block no of this blocks metadata details rel
	 */
	@Override
	public void setBlockNo(String blockNo) {
		model.setBlockNo(blockNo);
	}

	/**
	 * Sets the blocks metadata details rel ID of this blocks metadata details rel.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID of this blocks metadata details rel
	 */
	@Override
	public void setBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {
		model.setBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
	}

	/**
	 * Sets the block start date of this blocks metadata details rel.
	 *
	 * @param blockStartDate the block start date of this blocks metadata details rel
	 */
	@Override
	public void setBlockStartDate(Date blockStartDate) {
		model.setBlockStartDate(blockStartDate);
	}

	/**
	 * Sets the company ID of this blocks metadata details rel.
	 *
	 * @param companyId the company ID of this blocks metadata details rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this blocks metadata details rel.
	 *
	 * @param createDate the create date of this blocks metadata details rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this blocks metadata details rel.
	 *
	 * @param createdBy the created by of this blocks metadata details rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this blocks metadata details rel.
	 *
	 * @param groupId the group ID of this blocks metadata details rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this blocks metadata details rel.
	 *
	 * @param modifiedBy the modified by of this blocks metadata details rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this blocks metadata details rel.
	 *
	 * @param modifiedDate the modified date of this blocks metadata details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this blocks metadata details rel.
	 *
	 * @param primaryKey the primary key of this blocks metadata details rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog duration tl blocks lt ID of this blocks metadata details rel.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID of this blocks metadata details rel
	 */
	@Override
	public void setProgDurationTlBlocksLtId(long progDurationTlBlocksLtId) {
		model.setProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
	}

	/**
	 * Sets the uuid of this blocks metadata details rel.
	 *
	 * @param uuid the uuid of this blocks metadata details rel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BlocksMetadataDetailsRelWrapper wrap(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return new BlocksMetadataDetailsRelWrapper(blocksMetadataDetailsRel);
	}

}