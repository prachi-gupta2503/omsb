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
 * This class is a wrapper for {@link ProgdurationRotationTlPgProcedurePtRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRel
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelWrapper
	extends BaseModelWrapper<ProgdurationRotationTlPgProcedurePtRel>
	implements ModelWrapper<ProgdurationRotationTlPgProcedurePtRel>,
			   ProgdurationRotationTlPgProcedurePtRel {

	public ProgdurationRotationTlPgProcedurePtRelWrapper(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		super(progdurationRotationTlPgProcedurePtRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"progdurationRotationTlPgProcedurePtRelId",
			getProgdurationRotationTlPgProcedurePtRelId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("traineeLevelId", getTraineeLevelId());
		attributes.put("procedureGroupId", getProcedureGroupId());
		attributes.put("procedureId", getProcedureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("minimumProcedures", getMinimumProcedures());
		attributes.put(
			"traineelevelMinimumProcedures",
			getTraineelevelMinimumProcedures());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long progdurationRotationTlPgProcedurePtRelId = (Long)attributes.get(
			"progdurationRotationTlPgProcedurePtRelId");

		if (progdurationRotationTlPgProcedurePtRelId != null) {
			setProgdurationRotationTlPgProcedurePtRelId(
				progdurationRotationTlPgProcedurePtRelId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Long traineeLevelId = (Long)attributes.get("traineeLevelId");

		if (traineeLevelId != null) {
			setTraineeLevelId(traineeLevelId);
		}

		Long procedureGroupId = (Long)attributes.get("procedureGroupId");

		if (procedureGroupId != null) {
			setProcedureGroupId(procedureGroupId);
		}

		Long procedureId = (Long)attributes.get("procedureId");

		if (procedureId != null) {
			setProcedureId(procedureId);
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

		Integer minimumProcedures = (Integer)attributes.get(
			"minimumProcedures");

		if (minimumProcedures != null) {
			setMinimumProcedures(minimumProcedures);
		}

		Integer traineelevelMinimumProcedures = (Integer)attributes.get(
			"traineelevelMinimumProcedures");

		if (traineelevelMinimumProcedures != null) {
			setTraineelevelMinimumProcedures(traineelevelMinimumProcedures);
		}
	}

	@Override
	public ProgdurationRotationTlPgProcedurePtRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the company ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the create date of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the created by of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the group ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the minimum procedures of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the minimum procedures of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public int getMinimumProcedures() {
		return model.getMinimumProcedures();
	}

	/**
	 * Returns the modified by of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the modified by of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the modified date of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the primary key of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the procedure group ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getProcedureGroupId() {
		return model.getProcedureGroupId();
	}

	/**
	 * Returns the procedure ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the procedure ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getProcedureId() {
		return model.getProcedureId();
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the progduration rotation tl pg procedure pt rel ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getProgdurationRotationTlPgProcedurePtRelId() {
		return model.getProgdurationRotationTlPgProcedurePtRelId();
	}

	/**
	 * Returns the program duration ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the program duration ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the rotation ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the rotation ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the trainee level ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the trainee level ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the traineelevel minimum procedures of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the traineelevel minimum procedures of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public int getTraineelevelMinimumProcedures() {
		return model.getTraineelevelMinimumProcedures();
	}

	/**
	 * Returns the uuid of this progduration rotation tl pg procedure pt rel.
	 *
	 * @return the uuid of this progduration rotation tl pg procedure pt rel
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
	 * Sets the company ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param companyId the company ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param createDate the create date of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param createdBy the created by of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param groupId the group ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the minimum procedures of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param minimumProcedures the minimum procedures of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setMinimumProcedures(int minimumProcedures) {
		model.setMinimumProcedures(minimumProcedures);
	}

	/**
	 * Sets the modified by of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param modifiedBy the modified by of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param modifiedDate the modified date of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param primaryKey the primary key of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param procedureGroupId the procedure group ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setProcedureGroupId(long procedureGroupId) {
		model.setProcedureGroupId(procedureGroupId);
	}

	/**
	 * Sets the procedure ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param procedureId the procedure ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setProcedureId(long procedureId) {
		model.setProcedureId(procedureId);
	}

	/**
	 * Sets the progduration rotation tl pg procedure pt rel ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the progduration rotation tl pg procedure pt rel ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setProgdurationRotationTlPgProcedurePtRelId(
		long progdurationRotationTlPgProcedurePtRelId) {

		model.setProgdurationRotationTlPgProcedurePtRelId(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Sets the program duration ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param programDurationId the program duration ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the rotation ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param rotationId the rotation ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the trainee level ID of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param traineeLevelId the trainee level ID of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the traineelevel minimum procedures of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param traineelevelMinimumProcedures the traineelevel minimum procedures of this progduration rotation tl pg procedure pt rel
	 */
	@Override
	public void setTraineelevelMinimumProcedures(
		int traineelevelMinimumProcedures) {

		model.setTraineelevelMinimumProcedures(traineelevelMinimumProcedures);
	}

	/**
	 * Sets the uuid of this progduration rotation tl pg procedure pt rel.
	 *
	 * @param uuid the uuid of this progduration rotation tl pg procedure pt rel
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
	protected ProgdurationRotationTlPgProcedurePtRelWrapper wrap(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		return new ProgdurationRotationTlPgProcedurePtRelWrapper(
			progdurationRotationTlPgProcedurePtRel);
	}

}