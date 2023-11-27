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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BlockWeekMetadataDetailsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRel
 * @generated
 */
public class BlockWeekMetadataDetailsRelWrapper
	extends BaseModelWrapper<BlockWeekMetadataDetailsRel>
	implements BlockWeekMetadataDetailsRel,
			   ModelWrapper<BlockWeekMetadataDetailsRel> {

	public BlockWeekMetadataDetailsRelWrapper(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		super(blockWeekMetadataDetailsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"blockWeekMetadataDetailsRelId",
			getBlockWeekMetadataDetailsRelId());
		attributes.put(
			"blocksMetadataDetailRelId", getBlocksMetadataDetailRelId());
		attributes.put("weekNo", getWeekNo());
		attributes.put("weekStartDate", getWeekStartDate());
		attributes.put("weekEndDate", getWeekEndDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long blockWeekMetadataDetailsRelId = (Long)attributes.get(
			"blockWeekMetadataDetailsRelId");

		if (blockWeekMetadataDetailsRelId != null) {
			setBlockWeekMetadataDetailsRelId(blockWeekMetadataDetailsRelId);
		}

		Long blocksMetadataDetailRelId = (Long)attributes.get(
			"blocksMetadataDetailRelId");

		if (blocksMetadataDetailRelId != null) {
			setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		}

		String weekNo = (String)attributes.get("weekNo");

		if (weekNo != null) {
			setWeekNo(weekNo);
		}

		Date weekStartDate = (Date)attributes.get("weekStartDate");

		if (weekStartDate != null) {
			setWeekStartDate(weekStartDate);
		}

		Date weekEndDate = (Date)attributes.get("weekEndDate");

		if (weekEndDate != null) {
			setWeekEndDate(weekEndDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public BlockWeekMetadataDetailsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the blocks metadata detail rel ID of this block week metadata details rel.
	 *
	 * @return the blocks metadata detail rel ID of this block week metadata details rel
	 */
	@Override
	public long getBlocksMetadataDetailRelId() {
		return model.getBlocksMetadataDetailRelId();
	}

	/**
	 * Returns the block week metadata details rel ID of this block week metadata details rel.
	 *
	 * @return the block week metadata details rel ID of this block week metadata details rel
	 */
	@Override
	public long getBlockWeekMetadataDetailsRelId() {
		return model.getBlockWeekMetadataDetailsRelId();
	}

	/**
	 * Returns the company ID of this block week metadata details rel.
	 *
	 * @return the company ID of this block week metadata details rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this block week metadata details rel.
	 *
	 * @return the created by of this block week metadata details rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this block week metadata details rel.
	 *
	 * @return the created date of this block week metadata details rel
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this block week metadata details rel.
	 *
	 * @return the group ID of this block week metadata details rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this block week metadata details rel.
	 *
	 * @return the modified by of this block week metadata details rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this block week metadata details rel.
	 *
	 * @return the modified date of this block week metadata details rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this block week metadata details rel.
	 *
	 * @return the primary key of this block week metadata details rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this block week metadata details rel.
	 *
	 * @return the uuid of this block week metadata details rel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the week end date of this block week metadata details rel.
	 *
	 * @return the week end date of this block week metadata details rel
	 */
	@Override
	public Date getWeekEndDate() {
		return model.getWeekEndDate();
	}

	/**
	 * Returns the week no of this block week metadata details rel.
	 *
	 * @return the week no of this block week metadata details rel
	 */
	@Override
	public String getWeekNo() {
		return model.getWeekNo();
	}

	/**
	 * Returns the week start date of this block week metadata details rel.
	 *
	 * @return the week start date of this block week metadata details rel
	 */
	@Override
	public Date getWeekStartDate() {
		return model.getWeekStartDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the blocks metadata detail rel ID of this block week metadata details rel.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID of this block week metadata details rel
	 */
	@Override
	public void setBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		model.setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	/**
	 * Sets the block week metadata details rel ID of this block week metadata details rel.
	 *
	 * @param blockWeekMetadataDetailsRelId the block week metadata details rel ID of this block week metadata details rel
	 */
	@Override
	public void setBlockWeekMetadataDetailsRelId(
		long blockWeekMetadataDetailsRelId) {

		model.setBlockWeekMetadataDetailsRelId(blockWeekMetadataDetailsRelId);
	}

	/**
	 * Sets the company ID of this block week metadata details rel.
	 *
	 * @param companyId the company ID of this block week metadata details rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this block week metadata details rel.
	 *
	 * @param createdBy the created by of this block week metadata details rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this block week metadata details rel.
	 *
	 * @param createdDate the created date of this block week metadata details rel
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this block week metadata details rel.
	 *
	 * @param groupId the group ID of this block week metadata details rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this block week metadata details rel.
	 *
	 * @param modifiedBy the modified by of this block week metadata details rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this block week metadata details rel.
	 *
	 * @param modifiedDate the modified date of this block week metadata details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this block week metadata details rel.
	 *
	 * @param primaryKey the primary key of this block week metadata details rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this block week metadata details rel.
	 *
	 * @param uuid the uuid of this block week metadata details rel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the week end date of this block week metadata details rel.
	 *
	 * @param weekEndDate the week end date of this block week metadata details rel
	 */
	@Override
	public void setWeekEndDate(Date weekEndDate) {
		model.setWeekEndDate(weekEndDate);
	}

	/**
	 * Sets the week no of this block week metadata details rel.
	 *
	 * @param weekNo the week no of this block week metadata details rel
	 */
	@Override
	public void setWeekNo(String weekNo) {
		model.setWeekNo(weekNo);
	}

	/**
	 * Sets the week start date of this block week metadata details rel.
	 *
	 * @param weekStartDate the week start date of this block week metadata details rel
	 */
	@Override
	public void setWeekStartDate(Date weekStartDate) {
		model.setWeekStartDate(weekStartDate);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BlockWeekMetadataDetailsRelWrapper wrap(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return new BlockWeekMetadataDetailsRelWrapper(
			blockWeekMetadataDetailsRel);
	}

}