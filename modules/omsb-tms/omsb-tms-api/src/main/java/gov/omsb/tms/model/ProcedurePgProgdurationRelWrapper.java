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
 * This class is a wrapper for {@link ProcedurePgProgdurationRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRel
 * @generated
 */
public class ProcedurePgProgdurationRelWrapper
	extends BaseModelWrapper<ProcedurePgProgdurationRel>
	implements ModelWrapper<ProcedurePgProgdurationRel>,
			   ProcedurePgProgdurationRel {

	public ProcedurePgProgdurationRelWrapper(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		super(procedurePgProgdurationRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("procedurePgPdRelId", getProcedurePgPdRelId());
		attributes.put("procedureGroupMasterId", getProcedureGroupMasterId());
		attributes.put("procedureMasterId", getProcedureMasterId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long procedurePgPdRelId = (Long)attributes.get("procedurePgPdRelId");

		if (procedurePgPdRelId != null) {
			setProcedurePgPdRelId(procedurePgPdRelId);
		}

		Long procedureGroupMasterId = (Long)attributes.get(
			"procedureGroupMasterId");

		if (procedureGroupMasterId != null) {
			setProcedureGroupMasterId(procedureGroupMasterId);
		}

		Long procedureMasterId = (Long)attributes.get("procedureMasterId");

		if (procedureMasterId != null) {
			setProcedureMasterId(procedureMasterId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
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
	}

	@Override
	public ProcedurePgProgdurationRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this procedure pg progduration rel.
	 *
	 * @return the company ID of this procedure pg progduration rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this procedure pg progduration rel.
	 *
	 * @return the create date of this procedure pg progduration rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this procedure pg progduration rel.
	 *
	 * @return the created by of this procedure pg progduration rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this procedure pg progduration rel.
	 *
	 * @return the group ID of this procedure pg progduration rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this procedure pg progduration rel.
	 *
	 * @return the modified by of this procedure pg progduration rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this procedure pg progduration rel.
	 *
	 * @return the modified date of this procedure pg progduration rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this procedure pg progduration rel.
	 *
	 * @return the primary key of this procedure pg progduration rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group master ID of this procedure pg progduration rel.
	 *
	 * @return the procedure group master ID of this procedure pg progduration rel
	 */
	@Override
	public long getProcedureGroupMasterId() {
		return model.getProcedureGroupMasterId();
	}

	/**
	 * Returns the procedure master ID of this procedure pg progduration rel.
	 *
	 * @return the procedure master ID of this procedure pg progduration rel
	 */
	@Override
	public long getProcedureMasterId() {
		return model.getProcedureMasterId();
	}

	/**
	 * Returns the procedure pg pd rel ID of this procedure pg progduration rel.
	 *
	 * @return the procedure pg pd rel ID of this procedure pg progduration rel
	 */
	@Override
	public long getProcedurePgPdRelId() {
		return model.getProcedurePgPdRelId();
	}

	/**
	 * Returns the program duration ID of this procedure pg progduration rel.
	 *
	 * @return the program duration ID of this procedure pg progduration rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the uuid of this procedure pg progduration rel.
	 *
	 * @return the uuid of this procedure pg progduration rel
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
	 * Sets the company ID of this procedure pg progduration rel.
	 *
	 * @param companyId the company ID of this procedure pg progduration rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this procedure pg progduration rel.
	 *
	 * @param createDate the create date of this procedure pg progduration rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this procedure pg progduration rel.
	 *
	 * @param createdBy the created by of this procedure pg progduration rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this procedure pg progduration rel.
	 *
	 * @param groupId the group ID of this procedure pg progduration rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this procedure pg progduration rel.
	 *
	 * @param modifiedBy the modified by of this procedure pg progduration rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this procedure pg progduration rel.
	 *
	 * @param modifiedDate the modified date of this procedure pg progduration rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this procedure pg progduration rel.
	 *
	 * @param primaryKey the primary key of this procedure pg progduration rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group master ID of this procedure pg progduration rel.
	 *
	 * @param procedureGroupMasterId the procedure group master ID of this procedure pg progduration rel
	 */
	@Override
	public void setProcedureGroupMasterId(long procedureGroupMasterId) {
		model.setProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Sets the procedure master ID of this procedure pg progduration rel.
	 *
	 * @param procedureMasterId the procedure master ID of this procedure pg progduration rel
	 */
	@Override
	public void setProcedureMasterId(long procedureMasterId) {
		model.setProcedureMasterId(procedureMasterId);
	}

	/**
	 * Sets the procedure pg pd rel ID of this procedure pg progduration rel.
	 *
	 * @param procedurePgPdRelId the procedure pg pd rel ID of this procedure pg progduration rel
	 */
	@Override
	public void setProcedurePgPdRelId(long procedurePgPdRelId) {
		model.setProcedurePgPdRelId(procedurePgPdRelId);
	}

	/**
	 * Sets the program duration ID of this procedure pg progduration rel.
	 *
	 * @param programDurationId the program duration ID of this procedure pg progduration rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the uuid of this procedure pg progduration rel.
	 *
	 * @param uuid the uuid of this procedure pg progduration rel
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
	protected ProcedurePgProgdurationRelWrapper wrap(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		return new ProcedurePgProgdurationRelWrapper(
			procedurePgProgdurationRel);
	}

}