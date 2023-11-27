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
 * This class is a wrapper for {@link ProcedureGroupProceduresCPTCodeRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRel
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelWrapper
	extends BaseModelWrapper<ProcedureGroupProceduresCPTCodeRel>
	implements ModelWrapper<ProcedureGroupProceduresCPTCodeRel>,
			   ProcedureGroupProceduresCPTCodeRel {

	public ProcedureGroupProceduresCPTCodeRelWrapper(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		super(procedureGroupProceduresCPTCodeRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("pgProcedureCptCodeRelId", getPgProcedureCptCodeRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("procedureGroupId", getProcedureGroupId());
		attributes.put("procedureId", getProcedureId());
		attributes.put("cptCodeId", getCptCodeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long pgProcedureCptCodeRelId = (Long)attributes.get(
			"pgProcedureCptCodeRelId");

		if (pgProcedureCptCodeRelId != null) {
			setPgProcedureCptCodeRelId(pgProcedureCptCodeRelId);
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

		Long procedureGroupId = (Long)attributes.get("procedureGroupId");

		if (procedureGroupId != null) {
			setProcedureGroupId(procedureGroupId);
		}

		Long procedureId = (Long)attributes.get("procedureId");

		if (procedureId != null) {
			setProcedureId(procedureId);
		}

		Long cptCodeId = (Long)attributes.get("cptCodeId");

		if (cptCodeId != null) {
			setCptCodeId(cptCodeId);
		}
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this procedure group procedures cpt code rel.
	 *
	 * @return the company ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cpt code ID of this procedure group procedures cpt code rel.
	 *
	 * @return the cpt code ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getCptCodeId() {
		return model.getCptCodeId();
	}

	/**
	 * Returns the create date of this procedure group procedures cpt code rel.
	 *
	 * @return the create date of this procedure group procedures cpt code rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this procedure group procedures cpt code rel.
	 *
	 * @return the created by of this procedure group procedures cpt code rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this procedure group procedures cpt code rel.
	 *
	 * @return the group ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this procedure group procedures cpt code rel.
	 *
	 * @return the modified by of this procedure group procedures cpt code rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this procedure group procedures cpt code rel.
	 *
	 * @return the modified date of this procedure group procedures cpt code rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pg procedure cpt code rel ID of this procedure group procedures cpt code rel.
	 *
	 * @return the pg procedure cpt code rel ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getPgProcedureCptCodeRelId() {
		return model.getPgProcedureCptCodeRelId();
	}

	/**
	 * Returns the primary key of this procedure group procedures cpt code rel.
	 *
	 * @return the primary key of this procedure group procedures cpt code rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group ID of this procedure group procedures cpt code rel.
	 *
	 * @return the procedure group ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getProcedureGroupId() {
		return model.getProcedureGroupId();
	}

	/**
	 * Returns the procedure ID of this procedure group procedures cpt code rel.
	 *
	 * @return the procedure ID of this procedure group procedures cpt code rel
	 */
	@Override
	public long getProcedureId() {
		return model.getProcedureId();
	}

	/**
	 * Returns the uuid of this procedure group procedures cpt code rel.
	 *
	 * @return the uuid of this procedure group procedures cpt code rel
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
	 * Sets the company ID of this procedure group procedures cpt code rel.
	 *
	 * @param companyId the company ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cpt code ID of this procedure group procedures cpt code rel.
	 *
	 * @param cptCodeId the cpt code ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setCptCodeId(long cptCodeId) {
		model.setCptCodeId(cptCodeId);
	}

	/**
	 * Sets the create date of this procedure group procedures cpt code rel.
	 *
	 * @param createDate the create date of this procedure group procedures cpt code rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this procedure group procedures cpt code rel.
	 *
	 * @param createdBy the created by of this procedure group procedures cpt code rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this procedure group procedures cpt code rel.
	 *
	 * @param groupId the group ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this procedure group procedures cpt code rel.
	 *
	 * @param modifiedBy the modified by of this procedure group procedures cpt code rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this procedure group procedures cpt code rel.
	 *
	 * @param modifiedDate the modified date of this procedure group procedures cpt code rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pg procedure cpt code rel ID of this procedure group procedures cpt code rel.
	 *
	 * @param pgProcedureCptCodeRelId the pg procedure cpt code rel ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setPgProcedureCptCodeRelId(long pgProcedureCptCodeRelId) {
		model.setPgProcedureCptCodeRelId(pgProcedureCptCodeRelId);
	}

	/**
	 * Sets the primary key of this procedure group procedures cpt code rel.
	 *
	 * @param primaryKey the primary key of this procedure group procedures cpt code rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group ID of this procedure group procedures cpt code rel.
	 *
	 * @param procedureGroupId the procedure group ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setProcedureGroupId(long procedureGroupId) {
		model.setProcedureGroupId(procedureGroupId);
	}

	/**
	 * Sets the procedure ID of this procedure group procedures cpt code rel.
	 *
	 * @param procedureId the procedure ID of this procedure group procedures cpt code rel
	 */
	@Override
	public void setProcedureId(long procedureId) {
		model.setProcedureId(procedureId);
	}

	/**
	 * Sets the uuid of this procedure group procedures cpt code rel.
	 *
	 * @param uuid the uuid of this procedure group procedures cpt code rel
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
	protected ProcedureGroupProceduresCPTCodeRelWrapper wrap(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		return new ProcedureGroupProceduresCPTCodeRelWrapper(
			procedureGroupProceduresCPTCodeRel);
	}

}