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
 * This class is a wrapper for {@link ProgdurationRotationTraineelevelBlocksRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRel
 * @generated
 */
public class ProgdurationRotationTraineelevelBlocksRelWrapper
	extends BaseModelWrapper<ProgdurationRotationTraineelevelBlocksRel>
	implements ModelWrapper<ProgdurationRotationTraineelevelBlocksRel>,
			   ProgdurationRotationTraineelevelBlocksRel {

	public ProgdurationRotationTraineelevelBlocksRelWrapper(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		super(progdurationRotationTraineelevelBlocksRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"progdurationRotationTlBlocksRelId",
			getProgdurationRotationTlBlocksRelId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("rotationType", getRotationType());
		attributes.put("traineeLevelId", getTraineeLevelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("noOfBlocks", getNoOfBlocks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long progdurationRotationTlBlocksRelId = (Long)attributes.get(
			"progdurationRotationTlBlocksRelId");

		if (progdurationRotationTlBlocksRelId != null) {
			setProgdurationRotationTlBlocksRelId(
				progdurationRotationTlBlocksRelId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Long rotationType = (Long)attributes.get("rotationType");

		if (rotationType != null) {
			setRotationType(rotationType);
		}

		Long traineeLevelId = (Long)attributes.get("traineeLevelId");

		if (traineeLevelId != null) {
			setTraineeLevelId(traineeLevelId);
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

		Integer noOfBlocks = (Integer)attributes.get("noOfBlocks");

		if (noOfBlocks != null) {
			setNoOfBlocks(noOfBlocks);
		}
	}

	@Override
	public ProgdurationRotationTraineelevelBlocksRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the company ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the create date of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the created by of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the group ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the modified by of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the modified date of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of blocks of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the no of blocks of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public int getNoOfBlocks() {
		return model.getNoOfBlocks();
	}

	/**
	 * Returns the primary key of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the primary key of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progduration rotation tl blocks rel ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the progduration rotation tl blocks rel ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getProgdurationRotationTlBlocksRelId() {
		return model.getProgdurationRotationTlBlocksRelId();
	}

	/**
	 * Returns the program duration ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the program duration ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the rotation ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the rotation ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the rotation type of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the rotation type of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getRotationType() {
		return model.getRotationType();
	}

	/**
	 * Returns the trainee level ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the trainee level ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the uuid of this progduration rotation traineelevel blocks rel.
	 *
	 * @return the uuid of this progduration rotation traineelevel blocks rel
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
	 * Sets the company ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param companyId the company ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this progduration rotation traineelevel blocks rel.
	 *
	 * @param createDate the create date of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this progduration rotation traineelevel blocks rel.
	 *
	 * @param createdBy the created by of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param groupId the group ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this progduration rotation traineelevel blocks rel.
	 *
	 * @param modifiedBy the modified by of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this progduration rotation traineelevel blocks rel.
	 *
	 * @param modifiedDate the modified date of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of blocks of this progduration rotation traineelevel blocks rel.
	 *
	 * @param noOfBlocks the no of blocks of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setNoOfBlocks(int noOfBlocks) {
		model.setNoOfBlocks(noOfBlocks);
	}

	/**
	 * Sets the primary key of this progduration rotation traineelevel blocks rel.
	 *
	 * @param primaryKey the primary key of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progduration rotation tl blocks rel ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param progdurationRotationTlBlocksRelId the progduration rotation tl blocks rel ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setProgdurationRotationTlBlocksRelId(
		long progdurationRotationTlBlocksRelId) {

		model.setProgdurationRotationTlBlocksRelId(
			progdurationRotationTlBlocksRelId);
	}

	/**
	 * Sets the program duration ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param programDurationId the program duration ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the rotation ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param rotationId the rotation ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the rotation type of this progduration rotation traineelevel blocks rel.
	 *
	 * @param rotationType the rotation type of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setRotationType(long rotationType) {
		model.setRotationType(rotationType);
	}

	/**
	 * Sets the trainee level ID of this progduration rotation traineelevel blocks rel.
	 *
	 * @param traineeLevelId the trainee level ID of this progduration rotation traineelevel blocks rel
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the uuid of this progduration rotation traineelevel blocks rel.
	 *
	 * @param uuid the uuid of this progduration rotation traineelevel blocks rel
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
	protected ProgdurationRotationTraineelevelBlocksRelWrapper wrap(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		return new ProgdurationRotationTraineelevelBlocksRelWrapper(
			progdurationRotationTraineelevelBlocksRel);
	}

}