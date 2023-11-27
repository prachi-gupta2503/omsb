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
 * This class is a wrapper for {@link ProceduregroupProgdurationRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduregroupProgdurationRel
 * @generated
 */
public class ProceduregroupProgdurationRelWrapper
	extends BaseModelWrapper<ProceduregroupProgdurationRel>
	implements ModelWrapper<ProceduregroupProgdurationRel>,
			   ProceduregroupProgdurationRel {

	public ProceduregroupProgdurationRelWrapper(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		super(proceduregroupProgdurationRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("pgPdRelId", getPgPdRelId());
		attributes.put("procedureGroupMasterId", getProcedureGroupMasterId());
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

		Long pgPdRelId = (Long)attributes.get("pgPdRelId");

		if (pgPdRelId != null) {
			setPgPdRelId(pgPdRelId);
		}

		Long procedureGroupMasterId = (Long)attributes.get(
			"procedureGroupMasterId");

		if (procedureGroupMasterId != null) {
			setProcedureGroupMasterId(procedureGroupMasterId);
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
	public ProceduregroupProgdurationRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this proceduregroup progduration rel.
	 *
	 * @return the company ID of this proceduregroup progduration rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this proceduregroup progduration rel.
	 *
	 * @return the create date of this proceduregroup progduration rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this proceduregroup progduration rel.
	 *
	 * @return the created by of this proceduregroup progduration rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this proceduregroup progduration rel.
	 *
	 * @return the group ID of this proceduregroup progduration rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this proceduregroup progduration rel.
	 *
	 * @return the modified by of this proceduregroup progduration rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this proceduregroup progduration rel.
	 *
	 * @return the modified date of this proceduregroup progduration rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pg pd rel ID of this proceduregroup progduration rel.
	 *
	 * @return the pg pd rel ID of this proceduregroup progduration rel
	 */
	@Override
	public long getPgPdRelId() {
		return model.getPgPdRelId();
	}

	/**
	 * Returns the primary key of this proceduregroup progduration rel.
	 *
	 * @return the primary key of this proceduregroup progduration rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group master ID of this proceduregroup progduration rel.
	 *
	 * @return the procedure group master ID of this proceduregroup progduration rel
	 */
	@Override
	public long getProcedureGroupMasterId() {
		return model.getProcedureGroupMasterId();
	}

	/**
	 * Returns the program duration ID of this proceduregroup progduration rel.
	 *
	 * @return the program duration ID of this proceduregroup progduration rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the uuid of this proceduregroup progduration rel.
	 *
	 * @return the uuid of this proceduregroup progduration rel
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
	 * Sets the company ID of this proceduregroup progduration rel.
	 *
	 * @param companyId the company ID of this proceduregroup progduration rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this proceduregroup progduration rel.
	 *
	 * @param createDate the create date of this proceduregroup progduration rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this proceduregroup progduration rel.
	 *
	 * @param createdBy the created by of this proceduregroup progduration rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this proceduregroup progduration rel.
	 *
	 * @param groupId the group ID of this proceduregroup progduration rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this proceduregroup progduration rel.
	 *
	 * @param modifiedBy the modified by of this proceduregroup progduration rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this proceduregroup progduration rel.
	 *
	 * @param modifiedDate the modified date of this proceduregroup progduration rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pg pd rel ID of this proceduregroup progduration rel.
	 *
	 * @param pgPdRelId the pg pd rel ID of this proceduregroup progduration rel
	 */
	@Override
	public void setPgPdRelId(long pgPdRelId) {
		model.setPgPdRelId(pgPdRelId);
	}

	/**
	 * Sets the primary key of this proceduregroup progduration rel.
	 *
	 * @param primaryKey the primary key of this proceduregroup progduration rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group master ID of this proceduregroup progduration rel.
	 *
	 * @param procedureGroupMasterId the procedure group master ID of this proceduregroup progduration rel
	 */
	@Override
	public void setProcedureGroupMasterId(long procedureGroupMasterId) {
		model.setProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Sets the program duration ID of this proceduregroup progduration rel.
	 *
	 * @param programDurationId the program duration ID of this proceduregroup progduration rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the uuid of this proceduregroup progduration rel.
	 *
	 * @param uuid the uuid of this proceduregroup progduration rel
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
	protected ProceduregroupProgdurationRelWrapper wrap(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		return new ProceduregroupProgdurationRelWrapper(
			proceduregroupProgdurationRel);
	}

}