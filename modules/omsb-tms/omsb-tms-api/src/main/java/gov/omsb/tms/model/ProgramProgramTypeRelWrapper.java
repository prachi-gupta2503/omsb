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
 * This class is a wrapper for {@link ProgramProgramTypeRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRel
 * @generated
 */
public class ProgramProgramTypeRelWrapper
	extends BaseModelWrapper<ProgramProgramTypeRel>
	implements ModelWrapper<ProgramProgramTypeRel>, ProgramProgramTypeRel {

	public ProgramProgramTypeRelWrapper(
		ProgramProgramTypeRel programProgramTypeRel) {

		super(programProgramTypeRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("programPtId", getProgramPtId());
		attributes.put("programId", getProgramId());
		attributes.put("programTypeId", getProgramTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programPtId = (Long)attributes.get("programPtId");

		if (programPtId != null) {
			setProgramPtId(programPtId);
		}

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		Long programTypeId = (Long)attributes.get("programTypeId");

		if (programTypeId != null) {
			setProgramTypeId(programTypeId);
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
	}

	@Override
	public ProgramProgramTypeRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this program program type rel.
	 *
	 * @return the company ID of this program program type rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program program type rel.
	 *
	 * @return the create date of this program program type rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this program program type rel.
	 *
	 * @return the group ID of this program program type rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this program program type rel.
	 *
	 * @return the modified date of this program program type rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program program type rel.
	 *
	 * @return the primary key of this program program type rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ID of this program program type rel.
	 *
	 * @return the program ID of this program program type rel
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the program pt ID of this program program type rel.
	 *
	 * @return the program pt ID of this program program type rel
	 */
	@Override
	public long getProgramPtId() {
		return model.getProgramPtId();
	}

	/**
	 * Returns the program type ID of this program program type rel.
	 *
	 * @return the program type ID of this program program type rel
	 */
	@Override
	public long getProgramTypeId() {
		return model.getProgramTypeId();
	}

	/**
	 * Returns the uuid of this program program type rel.
	 *
	 * @return the uuid of this program program type rel
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
	 * Sets the company ID of this program program type rel.
	 *
	 * @param companyId the company ID of this program program type rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program program type rel.
	 *
	 * @param createDate the create date of this program program type rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this program program type rel.
	 *
	 * @param groupId the group ID of this program program type rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this program program type rel.
	 *
	 * @param modifiedDate the modified date of this program program type rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program program type rel.
	 *
	 * @param primaryKey the primary key of this program program type rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ID of this program program type rel.
	 *
	 * @param programId the program ID of this program program type rel
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the program pt ID of this program program type rel.
	 *
	 * @param programPtId the program pt ID of this program program type rel
	 */
	@Override
	public void setProgramPtId(long programPtId) {
		model.setProgramPtId(programPtId);
	}

	/**
	 * Sets the program type ID of this program program type rel.
	 *
	 * @param programTypeId the program type ID of this program program type rel
	 */
	@Override
	public void setProgramTypeId(long programTypeId) {
		model.setProgramTypeId(programTypeId);
	}

	/**
	 * Sets the uuid of this program program type rel.
	 *
	 * @param uuid the uuid of this program program type rel
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
	protected ProgramProgramTypeRelWrapper wrap(
		ProgramProgramTypeRel programProgramTypeRel) {

		return new ProgramProgramTypeRelWrapper(programProgramTypeRel);
	}

}