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
 * This class is a wrapper for {@link FacultyRequestRotations}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotations
 * @generated
 */
public class FacultyRequestRotationsWrapper
	extends BaseModelWrapper<FacultyRequestRotations>
	implements FacultyRequestRotations, ModelWrapper<FacultyRequestRotations> {

	public FacultyRequestRotationsWrapper(
		FacultyRequestRotations facultyRequestRotations) {

		super(facultyRequestRotations);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"facultyRequestRotationsId", getFacultyRequestRotationsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("facultyRequestId", getFacultyRequestId());
		attributes.put("trainingSiteId", getTrainingSiteId());
		attributes.put("rotationId", getRotationId());
		attributes.put("isActive", isIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyRequestRotationsId = (Long)attributes.get(
			"facultyRequestRotationsId");

		if (facultyRequestRotationsId != null) {
			setFacultyRequestRotationsId(facultyRequestRotationsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long facultyRequestId = (Long)attributes.get("facultyRequestId");

		if (facultyRequestId != null) {
			setFacultyRequestId(facultyRequestId);
		}

		Long trainingSiteId = (Long)attributes.get("trainingSiteId");

		if (trainingSiteId != null) {
			setTrainingSiteId(trainingSiteId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public FacultyRequestRotations cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this faculty request rotations.
	 *
	 * @return the company ID of this faculty request rotations
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty request rotations.
	 *
	 * @return the create date of this faculty request rotations
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this faculty request rotations.
	 *
	 * @return the created by of this faculty request rotations
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the faculty request ID of this faculty request rotations.
	 *
	 * @return the faculty request ID of this faculty request rotations
	 */
	@Override
	public long getFacultyRequestId() {
		return model.getFacultyRequestId();
	}

	/**
	 * Returns the faculty request rotations ID of this faculty request rotations.
	 *
	 * @return the faculty request rotations ID of this faculty request rotations
	 */
	@Override
	public long getFacultyRequestRotationsId() {
		return model.getFacultyRequestRotationsId();
	}

	/**
	 * Returns the group ID of this faculty request rotations.
	 *
	 * @return the group ID of this faculty request rotations
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this faculty request rotations.
	 *
	 * @return the is active of this faculty request rotations
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the modified by of this faculty request rotations.
	 *
	 * @return the modified by of this faculty request rotations
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this faculty request rotations.
	 *
	 * @return the modified date of this faculty request rotations
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faculty request rotations.
	 *
	 * @return the primary key of this faculty request rotations
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rotation ID of this faculty request rotations.
	 *
	 * @return the rotation ID of this faculty request rotations
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the training site ID of this faculty request rotations.
	 *
	 * @return the training site ID of this faculty request rotations
	 */
	@Override
	public long getTrainingSiteId() {
		return model.getTrainingSiteId();
	}

	/**
	 * Returns the uuid of this faculty request rotations.
	 *
	 * @return the uuid of this faculty request rotations
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this faculty request rotations is is active.
	 *
	 * @return <code>true</code> if this faculty request rotations is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this faculty request rotations.
	 *
	 * @param companyId the company ID of this faculty request rotations
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty request rotations.
	 *
	 * @param createDate the create date of this faculty request rotations
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this faculty request rotations.
	 *
	 * @param createdBy the created by of this faculty request rotations
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the faculty request ID of this faculty request rotations.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty request rotations
	 */
	@Override
	public void setFacultyRequestId(long facultyRequestId) {
		model.setFacultyRequestId(facultyRequestId);
	}

	/**
	 * Sets the faculty request rotations ID of this faculty request rotations.
	 *
	 * @param facultyRequestRotationsId the faculty request rotations ID of this faculty request rotations
	 */
	@Override
	public void setFacultyRequestRotationsId(long facultyRequestRotationsId) {
		model.setFacultyRequestRotationsId(facultyRequestRotationsId);
	}

	/**
	 * Sets the group ID of this faculty request rotations.
	 *
	 * @param groupId the group ID of this faculty request rotations
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this faculty request rotations is is active.
	 *
	 * @param isActive the is active of this faculty request rotations
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the modified by of this faculty request rotations.
	 *
	 * @param modifiedBy the modified by of this faculty request rotations
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this faculty request rotations.
	 *
	 * @param modifiedDate the modified date of this faculty request rotations
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faculty request rotations.
	 *
	 * @param primaryKey the primary key of this faculty request rotations
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rotation ID of this faculty request rotations.
	 *
	 * @param rotationId the rotation ID of this faculty request rotations
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the training site ID of this faculty request rotations.
	 *
	 * @param trainingSiteId the training site ID of this faculty request rotations
	 */
	@Override
	public void setTrainingSiteId(long trainingSiteId) {
		model.setTrainingSiteId(trainingSiteId);
	}

	/**
	 * Sets the uuid of this faculty request rotations.
	 *
	 * @param uuid the uuid of this faculty request rotations
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
	protected FacultyRequestRotationsWrapper wrap(
		FacultyRequestRotations facultyRequestRotations) {

		return new FacultyRequestRotationsWrapper(facultyRequestRotations);
	}

}