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
 * This class is a wrapper for {@link FacultyRotationTsBlockDetailsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRel
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelWrapper
	extends BaseModelWrapper<FacultyRotationTsBlockDetailsRel>
	implements FacultyRotationTsBlockDetailsRel,
			   ModelWrapper<FacultyRotationTsBlockDetailsRel> {

	public FacultyRotationTsBlockDetailsRelWrapper(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		super(facultyRotationTsBlockDetailsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"facultyRotationTsBlockDetailsRelId",
			getFacultyRotationTsBlockDetailsRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("facultyId", getFacultyId());
		attributes.put(
			"blocksMetadataDetailsRelId", getBlocksMetadataDetailsRelId());
		attributes.put(
			"progDurationRotationTsRelId", getProgDurationRotationTsRelId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyRotationTsBlockDetailsRelId = (Long)attributes.get(
			"facultyRotationTsBlockDetailsRelId");

		if (facultyRotationTsBlockDetailsRelId != null) {
			setFacultyRotationTsBlockDetailsRelId(
				facultyRotationTsBlockDetailsRelId);
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

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		Long blocksMetadataDetailsRelId = (Long)attributes.get(
			"blocksMetadataDetailsRelId");

		if (blocksMetadataDetailsRelId != null) {
			setBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
		}

		Long progDurationRotationTsRelId = (Long)attributes.get(
			"progDurationRotationTsRelId");

		if (progDurationRotationTsRelId != null) {
			setProgDurationRotationTsRelId(progDurationRotationTsRelId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public FacultyRotationTsBlockDetailsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the blocks metadata details rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the blocks metadata details rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getBlocksMetadataDetailsRelId() {
		return model.getBlocksMetadataDetailsRelId();
	}

	/**
	 * Returns the company ID of this faculty rotation ts block details rel.
	 *
	 * @return the company ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty rotation ts block details rel.
	 *
	 * @return the create date of this faculty rotation ts block details rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this faculty rotation ts block details rel.
	 *
	 * @return the created by of this faculty rotation ts block details rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the faculty ID of this faculty rotation ts block details rel.
	 *
	 * @return the faculty ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getFacultyId() {
		return model.getFacultyId();
	}

	/**
	 * Returns the faculty rotation ts block details rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the faculty rotation ts block details rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getFacultyRotationTsBlockDetailsRelId() {
		return model.getFacultyRotationTsBlockDetailsRelId();
	}

	/**
	 * Returns the group ID of this faculty rotation ts block details rel.
	 *
	 * @return the group ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this faculty rotation ts block details rel.
	 *
	 * @return the modified by of this faculty rotation ts block details rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this faculty rotation ts block details rel.
	 *
	 * @return the modified date of this faculty rotation ts block details rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faculty rotation ts block details rel.
	 *
	 * @return the primary key of this faculty rotation ts block details rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog duration rotation ts rel ID of this faculty rotation ts block details rel.
	 *
	 * @return the prog duration rotation ts rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public long getProgDurationRotationTsRelId() {
		return model.getProgDurationRotationTsRelId();
	}

	/**
	 * Returns the status of this faculty rotation ts block details rel.
	 *
	 * @return the status of this faculty rotation ts block details rel
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this faculty rotation ts block details rel.
	 *
	 * @return the uuid of this faculty rotation ts block details rel
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
	 * Sets the blocks metadata details rel ID of this faculty rotation ts block details rel.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {
		model.setBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
	}

	/**
	 * Sets the company ID of this faculty rotation ts block details rel.
	 *
	 * @param companyId the company ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty rotation ts block details rel.
	 *
	 * @param createDate the create date of this faculty rotation ts block details rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this faculty rotation ts block details rel.
	 *
	 * @param createdBy the created by of this faculty rotation ts block details rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the faculty ID of this faculty rotation ts block details rel.
	 *
	 * @param facultyId the faculty ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setFacultyId(long facultyId) {
		model.setFacultyId(facultyId);
	}

	/**
	 * Sets the faculty rotation ts block details rel ID of this faculty rotation ts block details rel.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the faculty rotation ts block details rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setFacultyRotationTsBlockDetailsRelId(
		long facultyRotationTsBlockDetailsRelId) {

		model.setFacultyRotationTsBlockDetailsRelId(
			facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Sets the group ID of this faculty rotation ts block details rel.
	 *
	 * @param groupId the group ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this faculty rotation ts block details rel.
	 *
	 * @param modifiedBy the modified by of this faculty rotation ts block details rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this faculty rotation ts block details rel.
	 *
	 * @param modifiedDate the modified date of this faculty rotation ts block details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faculty rotation ts block details rel.
	 *
	 * @param primaryKey the primary key of this faculty rotation ts block details rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog duration rotation ts rel ID of this faculty rotation ts block details rel.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID of this faculty rotation ts block details rel
	 */
	@Override
	public void setProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		model.setProgDurationRotationTsRelId(progDurationRotationTsRelId);
	}

	/**
	 * Sets the status of this faculty rotation ts block details rel.
	 *
	 * @param status the status of this faculty rotation ts block details rel
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this faculty rotation ts block details rel.
	 *
	 * @param uuid the uuid of this faculty rotation ts block details rel
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
	protected FacultyRotationTsBlockDetailsRelWrapper wrap(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return new FacultyRotationTsBlockDetailsRelWrapper(
			facultyRotationTsBlockDetailsRel);
	}

}