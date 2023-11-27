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
 * This class is a wrapper for {@link ProgdurationTraineelevelBlocksLevelTypeRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRel
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelWrapper
	extends BaseModelWrapper<ProgdurationTraineelevelBlocksLevelTypeRel>
	implements ModelWrapper<ProgdurationTraineelevelBlocksLevelTypeRel>,
			   ProgdurationTraineelevelBlocksLevelTypeRel {

	public ProgdurationTraineelevelBlocksLevelTypeRelWrapper(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		super(progdurationTraineelevelBlocksLevelTypeRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"progdurationTlBlocksLtId", getProgdurationTlBlocksLtId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("levelTypeId", getLevelTypeId());
		attributes.put("traineeLevelId", getTraineeLevelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("noOfBlocks", getNoOfBlocks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long progdurationTlBlocksLtId = (Long)attributes.get(
			"progdurationTlBlocksLtId");

		if (progdurationTlBlocksLtId != null) {
			setProgdurationTlBlocksLtId(progdurationTlBlocksLtId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long levelTypeId = (Long)attributes.get("levelTypeId");

		if (levelTypeId != null) {
			setLevelTypeId(levelTypeId);
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

		Integer noOfBlocks = (Integer)attributes.get("noOfBlocks");

		if (noOfBlocks != null) {
			setNoOfBlocks(noOfBlocks);
		}
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		cloneWithOriginalValues() {

		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the company ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this progduration traineelevel blocks level type rel.
	 *
	 * @return the create date of this progduration traineelevel blocks level type rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the group ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level type ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the level type ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getLevelTypeId() {
		return model.getLevelTypeId();
	}

	/**
	 * Returns the modified date of this progduration traineelevel blocks level type rel.
	 *
	 * @return the modified date of this progduration traineelevel blocks level type rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of blocks of this progduration traineelevel blocks level type rel.
	 *
	 * @return the no of blocks of this progduration traineelevel blocks level type rel
	 */
	@Override
	public int getNoOfBlocks() {
		return model.getNoOfBlocks();
	}

	/**
	 * Returns the primary key of this progduration traineelevel blocks level type rel.
	 *
	 * @return the primary key of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progduration tl blocks lt ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the progduration tl blocks lt ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getProgdurationTlBlocksLtId() {
		return model.getProgdurationTlBlocksLtId();
	}

	/**
	 * Returns the program duration ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the program duration ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the trainee level ID of this progduration traineelevel blocks level type rel.
	 *
	 * @return the trainee level ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the uuid of this progduration traineelevel blocks level type rel.
	 *
	 * @return the uuid of this progduration traineelevel blocks level type rel
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
	 * Sets the company ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param companyId the company ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this progduration traineelevel blocks level type rel.
	 *
	 * @param createDate the create date of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param groupId the group ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level type ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param levelTypeId the level type ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setLevelTypeId(long levelTypeId) {
		model.setLevelTypeId(levelTypeId);
	}

	/**
	 * Sets the modified date of this progduration traineelevel blocks level type rel.
	 *
	 * @param modifiedDate the modified date of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of blocks of this progduration traineelevel blocks level type rel.
	 *
	 * @param noOfBlocks the no of blocks of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setNoOfBlocks(int noOfBlocks) {
		model.setNoOfBlocks(noOfBlocks);
	}

	/**
	 * Sets the primary key of this progduration traineelevel blocks level type rel.
	 *
	 * @param primaryKey the primary key of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progduration tl blocks lt ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param progdurationTlBlocksLtId the progduration tl blocks lt ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setProgdurationTlBlocksLtId(long progdurationTlBlocksLtId) {
		model.setProgdurationTlBlocksLtId(progdurationTlBlocksLtId);
	}

	/**
	 * Sets the program duration ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param programDurationId the program duration ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the trainee level ID of this progduration traineelevel blocks level type rel.
	 *
	 * @param traineeLevelId the trainee level ID of this progduration traineelevel blocks level type rel
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the uuid of this progduration traineelevel blocks level type rel.
	 *
	 * @param uuid the uuid of this progduration traineelevel blocks level type rel
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
	protected ProgdurationTraineelevelBlocksLevelTypeRelWrapper wrap(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		return new ProgdurationTraineelevelBlocksLevelTypeRelWrapper(
			progdurationTraineelevelBlocksLevelTypeRel);
	}

}