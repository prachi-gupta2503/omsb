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
 * This class is a wrapper for {@link ProgramDutyAssignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignment
 * @generated
 */
public class ProgramDutyAssignmentWrapper
	extends BaseModelWrapper<ProgramDutyAssignment>
	implements ModelWrapper<ProgramDutyAssignment>, ProgramDutyAssignment {

	public ProgramDutyAssignmentWrapper(
		ProgramDutyAssignment programDutyAssignment) {

		super(programDutyAssignment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("programDutyAssignmentId", getProgramDutyAssignmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("programId", getProgramId());
		attributes.put("dutyAssignmentId", getDutyAssignmentId());
		attributes.put("cohortId", getCohortId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programDutyAssignmentId = (Long)attributes.get(
			"programDutyAssignmentId");

		if (programDutyAssignmentId != null) {
			setProgramDutyAssignmentId(programDutyAssignmentId);
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

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		Long dutyAssignmentId = (Long)attributes.get("dutyAssignmentId");

		if (dutyAssignmentId != null) {
			setDutyAssignmentId(dutyAssignmentId);
		}

		Long cohortId = (Long)attributes.get("cohortId");

		if (cohortId != null) {
			setCohortId(cohortId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public ProgramDutyAssignment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cohort ID of this program duty assignment.
	 *
	 * @return the cohort ID of this program duty assignment
	 */
	@Override
	public long getCohortId() {
		return model.getCohortId();
	}

	/**
	 * Returns the company ID of this program duty assignment.
	 *
	 * @return the company ID of this program duty assignment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program duty assignment.
	 *
	 * @return the create date of this program duty assignment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this program duty assignment.
	 *
	 * @return the created by of this program duty assignment
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the duty assignment ID of this program duty assignment.
	 *
	 * @return the duty assignment ID of this program duty assignment
	 */
	@Override
	public long getDutyAssignmentId() {
		return model.getDutyAssignmentId();
	}

	/**
	 * Returns the group ID of this program duty assignment.
	 *
	 * @return the group ID of this program duty assignment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this program duty assignment.
	 *
	 * @return the modified by of this program duty assignment
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this program duty assignment.
	 *
	 * @return the modified date of this program duty assignment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program duty assignment.
	 *
	 * @return the primary key of this program duty assignment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duty assignment ID of this program duty assignment.
	 *
	 * @return the program duty assignment ID of this program duty assignment
	 */
	@Override
	public long getProgramDutyAssignmentId() {
		return model.getProgramDutyAssignmentId();
	}

	/**
	 * Returns the program ID of this program duty assignment.
	 *
	 * @return the program ID of this program duty assignment
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the status of this program duty assignment.
	 *
	 * @return the status of this program duty assignment
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this program duty assignment.
	 *
	 * @return the uuid of this program duty assignment
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
	 * Sets the cohort ID of this program duty assignment.
	 *
	 * @param cohortId the cohort ID of this program duty assignment
	 */
	@Override
	public void setCohortId(long cohortId) {
		model.setCohortId(cohortId);
	}

	/**
	 * Sets the company ID of this program duty assignment.
	 *
	 * @param companyId the company ID of this program duty assignment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program duty assignment.
	 *
	 * @param createDate the create date of this program duty assignment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this program duty assignment.
	 *
	 * @param createdBy the created by of this program duty assignment
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the duty assignment ID of this program duty assignment.
	 *
	 * @param dutyAssignmentId the duty assignment ID of this program duty assignment
	 */
	@Override
	public void setDutyAssignmentId(long dutyAssignmentId) {
		model.setDutyAssignmentId(dutyAssignmentId);
	}

	/**
	 * Sets the group ID of this program duty assignment.
	 *
	 * @param groupId the group ID of this program duty assignment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this program duty assignment.
	 *
	 * @param modifiedBy the modified by of this program duty assignment
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this program duty assignment.
	 *
	 * @param modifiedDate the modified date of this program duty assignment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program duty assignment.
	 *
	 * @param primaryKey the primary key of this program duty assignment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duty assignment ID of this program duty assignment.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID of this program duty assignment
	 */
	@Override
	public void setProgramDutyAssignmentId(long programDutyAssignmentId) {
		model.setProgramDutyAssignmentId(programDutyAssignmentId);
	}

	/**
	 * Sets the program ID of this program duty assignment.
	 *
	 * @param programId the program ID of this program duty assignment
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the status of this program duty assignment.
	 *
	 * @param status the status of this program duty assignment
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this program duty assignment.
	 *
	 * @param uuid the uuid of this program duty assignment
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
	protected ProgramDutyAssignmentWrapper wrap(
		ProgramDutyAssignment programDutyAssignment) {

		return new ProgramDutyAssignmentWrapper(programDutyAssignment);
	}

}