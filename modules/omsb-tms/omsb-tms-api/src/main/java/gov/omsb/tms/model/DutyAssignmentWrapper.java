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
 * This class is a wrapper for {@link DutyAssignment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignment
 * @generated
 */
public class DutyAssignmentWrapper
	extends BaseModelWrapper<DutyAssignment>
	implements DutyAssignment, ModelWrapper<DutyAssignment> {

	public DutyAssignmentWrapper(DutyAssignment dutyAssignment) {
		super(dutyAssignment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dutyAssignmentId", getDutyAssignmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("dutyTypeId", getDutyTypeId());
		attributes.put("assignment", getAssignment());
		attributes.put("status", getStatus());
		attributes.put("colorCode", getColorCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dutyAssignmentId = (Long)attributes.get("dutyAssignmentId");

		if (dutyAssignmentId != null) {
			setDutyAssignmentId(dutyAssignmentId);
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

		Long dutyTypeId = (Long)attributes.get("dutyTypeId");

		if (dutyTypeId != null) {
			setDutyTypeId(dutyTypeId);
		}

		String assignment = (String)attributes.get("assignment");

		if (assignment != null) {
			setAssignment(assignment);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String colorCode = (String)attributes.get("colorCode");

		if (colorCode != null) {
			setColorCode(colorCode);
		}
	}

	@Override
	public DutyAssignment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assignment of this duty assignment.
	 *
	 * @return the assignment of this duty assignment
	 */
	@Override
	public String getAssignment() {
		return model.getAssignment();
	}

	/**
	 * Returns the color code of this duty assignment.
	 *
	 * @return the color code of this duty assignment
	 */
	@Override
	public String getColorCode() {
		return model.getColorCode();
	}

	/**
	 * Returns the company ID of this duty assignment.
	 *
	 * @return the company ID of this duty assignment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this duty assignment.
	 *
	 * @return the create date of this duty assignment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this duty assignment.
	 *
	 * @return the created by of this duty assignment
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the duty assignment ID of this duty assignment.
	 *
	 * @return the duty assignment ID of this duty assignment
	 */
	@Override
	public long getDutyAssignmentId() {
		return model.getDutyAssignmentId();
	}

	/**
	 * Returns the duty type ID of this duty assignment.
	 *
	 * @return the duty type ID of this duty assignment
	 */
	@Override
	public long getDutyTypeId() {
		return model.getDutyTypeId();
	}

	/**
	 * Returns the group ID of this duty assignment.
	 *
	 * @return the group ID of this duty assignment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this duty assignment.
	 *
	 * @return the modified by of this duty assignment
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this duty assignment.
	 *
	 * @return the modified date of this duty assignment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this duty assignment.
	 *
	 * @return the primary key of this duty assignment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this duty assignment.
	 *
	 * @return the status of this duty assignment
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this duty assignment.
	 *
	 * @return the uuid of this duty assignment
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
	 * Sets the assignment of this duty assignment.
	 *
	 * @param assignment the assignment of this duty assignment
	 */
	@Override
	public void setAssignment(String assignment) {
		model.setAssignment(assignment);
	}

	/**
	 * Sets the color code of this duty assignment.
	 *
	 * @param colorCode the color code of this duty assignment
	 */
	@Override
	public void setColorCode(String colorCode) {
		model.setColorCode(colorCode);
	}

	/**
	 * Sets the company ID of this duty assignment.
	 *
	 * @param companyId the company ID of this duty assignment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this duty assignment.
	 *
	 * @param createDate the create date of this duty assignment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this duty assignment.
	 *
	 * @param createdBy the created by of this duty assignment
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the duty assignment ID of this duty assignment.
	 *
	 * @param dutyAssignmentId the duty assignment ID of this duty assignment
	 */
	@Override
	public void setDutyAssignmentId(long dutyAssignmentId) {
		model.setDutyAssignmentId(dutyAssignmentId);
	}

	/**
	 * Sets the duty type ID of this duty assignment.
	 *
	 * @param dutyTypeId the duty type ID of this duty assignment
	 */
	@Override
	public void setDutyTypeId(long dutyTypeId) {
		model.setDutyTypeId(dutyTypeId);
	}

	/**
	 * Sets the group ID of this duty assignment.
	 *
	 * @param groupId the group ID of this duty assignment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this duty assignment.
	 *
	 * @param modifiedBy the modified by of this duty assignment
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this duty assignment.
	 *
	 * @param modifiedDate the modified date of this duty assignment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this duty assignment.
	 *
	 * @param primaryKey the primary key of this duty assignment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this duty assignment.
	 *
	 * @param status the status of this duty assignment
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this duty assignment.
	 *
	 * @param uuid the uuid of this duty assignment
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
	protected DutyAssignmentWrapper wrap(DutyAssignment dutyAssignment) {
		return new DutyAssignmentWrapper(dutyAssignment);
	}

}