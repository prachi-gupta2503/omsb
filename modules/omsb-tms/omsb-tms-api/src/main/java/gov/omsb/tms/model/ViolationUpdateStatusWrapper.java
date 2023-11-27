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
 * This class is a wrapper for {@link ViolationUpdateStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatus
 * @generated
 */
public class ViolationUpdateStatusWrapper
	extends BaseModelWrapper<ViolationUpdateStatus>
	implements ModelWrapper<ViolationUpdateStatus>, ViolationUpdateStatus {

	public ViolationUpdateStatusWrapper(
		ViolationUpdateStatus violationUpdateStatus) {

		super(violationUpdateStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("violationUpdateStatusId", getViolationUpdateStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put(
			"blocksMetadataDetailRelId", getBlocksMetadataDetailRelId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long violationUpdateStatusId = (Long)attributes.get(
			"violationUpdateStatusId");

		if (violationUpdateStatusId != null) {
			setViolationUpdateStatusId(violationUpdateStatusId);
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

		Long blocksMetadataDetailRelId = (Long)attributes.get(
			"blocksMetadataDetailRelId");

		if (blocksMetadataDetailRelId != null) {
			setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public ViolationUpdateStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the blocks metadata detail rel ID of this violation update status.
	 *
	 * @return the blocks metadata detail rel ID of this violation update status
	 */
	@Override
	public long getBlocksMetadataDetailRelId() {
		return model.getBlocksMetadataDetailRelId();
	}

	/**
	 * Returns the company ID of this violation update status.
	 *
	 * @return the company ID of this violation update status
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this violation update status.
	 *
	 * @return the created by of this violation update status
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this violation update status.
	 *
	 * @return the created date of this violation update status
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this violation update status.
	 *
	 * @return the group ID of this violation update status
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this violation update status.
	 *
	 * @return the modified by of this violation update status
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this violation update status.
	 *
	 * @return the modified date of this violation update status
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this violation update status.
	 *
	 * @return the primary key of this violation update status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this violation update status.
	 *
	 * @return the status of this violation update status
	 */
	@Override
	public Boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this violation update status.
	 *
	 * @return the uuid of this violation update status
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the violation update status ID of this violation update status.
	 *
	 * @return the violation update status ID of this violation update status
	 */
	@Override
	public long getViolationUpdateStatusId() {
		return model.getViolationUpdateStatusId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the blocks metadata detail rel ID of this violation update status.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID of this violation update status
	 */
	@Override
	public void setBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		model.setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	/**
	 * Sets the company ID of this violation update status.
	 *
	 * @param companyId the company ID of this violation update status
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this violation update status.
	 *
	 * @param createdBy the created by of this violation update status
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this violation update status.
	 *
	 * @param createdDate the created date of this violation update status
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this violation update status.
	 *
	 * @param groupId the group ID of this violation update status
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this violation update status.
	 *
	 * @param modifiedBy the modified by of this violation update status
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this violation update status.
	 *
	 * @param modifiedDate the modified date of this violation update status
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this violation update status.
	 *
	 * @param primaryKey the primary key of this violation update status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this violation update status.
	 *
	 * @param status the status of this violation update status
	 */
	@Override
	public void setStatus(Boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this violation update status.
	 *
	 * @param uuid the uuid of this violation update status
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the violation update status ID of this violation update status.
	 *
	 * @param violationUpdateStatusId the violation update status ID of this violation update status
	 */
	@Override
	public void setViolationUpdateStatusId(long violationUpdateStatusId) {
		model.setViolationUpdateStatusId(violationUpdateStatusId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ViolationUpdateStatusWrapper wrap(
		ViolationUpdateStatus violationUpdateStatus) {

		return new ViolationUpdateStatusWrapper(violationUpdateStatus);
	}

}