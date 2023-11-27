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
 * This class is a wrapper for {@link FacultyRequestState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestState
 * @generated
 */
public class FacultyRequestStateWrapper
	extends BaseModelWrapper<FacultyRequestState>
	implements FacultyRequestState, ModelWrapper<FacultyRequestState> {

	public FacultyRequestStateWrapper(FacultyRequestState facultyRequestState) {
		super(facultyRequestState);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("facultyRequestStateId", getFacultyRequestStateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdByRoleId", getCreatedByRoleId());
		attributes.put("facultyRequestId", getFacultyRequestId());
		attributes.put("facultyRequestStatusId", getFacultyRequestStatusId());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyRequestStateId = (Long)attributes.get(
			"facultyRequestStateId");

		if (facultyRequestStateId != null) {
			setFacultyRequestStateId(facultyRequestStateId);
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

		Long createdByRoleId = (Long)attributes.get("createdByRoleId");

		if (createdByRoleId != null) {
			setCreatedByRoleId(createdByRoleId);
		}

		Long facultyRequestId = (Long)attributes.get("facultyRequestId");

		if (facultyRequestId != null) {
			setFacultyRequestId(facultyRequestId);
		}

		Long facultyRequestStatusId = (Long)attributes.get(
			"facultyRequestStatusId");

		if (facultyRequestStatusId != null) {
			setFacultyRequestStatusId(facultyRequestStatusId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public FacultyRequestState cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comments of this faculty request state.
	 *
	 * @return the comments of this faculty request state
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this faculty request state.
	 *
	 * @return the company ID of this faculty request state
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty request state.
	 *
	 * @return the create date of this faculty request state
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this faculty request state.
	 *
	 * @return the created by of this faculty request state
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created by role ID of this faculty request state.
	 *
	 * @return the created by role ID of this faculty request state
	 */
	@Override
	public long getCreatedByRoleId() {
		return model.getCreatedByRoleId();
	}

	/**
	 * Returns the faculty request ID of this faculty request state.
	 *
	 * @return the faculty request ID of this faculty request state
	 */
	@Override
	public long getFacultyRequestId() {
		return model.getFacultyRequestId();
	}

	/**
	 * Returns the faculty request state ID of this faculty request state.
	 *
	 * @return the faculty request state ID of this faculty request state
	 */
	@Override
	public long getFacultyRequestStateId() {
		return model.getFacultyRequestStateId();
	}

	/**
	 * Returns the faculty request status ID of this faculty request state.
	 *
	 * @return the faculty request status ID of this faculty request state
	 */
	@Override
	public long getFacultyRequestStatusId() {
		return model.getFacultyRequestStatusId();
	}

	/**
	 * Returns the group ID of this faculty request state.
	 *
	 * @return the group ID of this faculty request state
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faculty request state.
	 *
	 * @return the modified date of this faculty request state
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faculty request state.
	 *
	 * @return the primary key of this faculty request state
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this faculty request state.
	 *
	 * @return the uuid of this faculty request state
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
	 * Sets the comments of this faculty request state.
	 *
	 * @param comments the comments of this faculty request state
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this faculty request state.
	 *
	 * @param companyId the company ID of this faculty request state
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty request state.
	 *
	 * @param createDate the create date of this faculty request state
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this faculty request state.
	 *
	 * @param createdBy the created by of this faculty request state
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created by role ID of this faculty request state.
	 *
	 * @param createdByRoleId the created by role ID of this faculty request state
	 */
	@Override
	public void setCreatedByRoleId(long createdByRoleId) {
		model.setCreatedByRoleId(createdByRoleId);
	}

	/**
	 * Sets the faculty request ID of this faculty request state.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty request state
	 */
	@Override
	public void setFacultyRequestId(long facultyRequestId) {
		model.setFacultyRequestId(facultyRequestId);
	}

	/**
	 * Sets the faculty request state ID of this faculty request state.
	 *
	 * @param facultyRequestStateId the faculty request state ID of this faculty request state
	 */
	@Override
	public void setFacultyRequestStateId(long facultyRequestStateId) {
		model.setFacultyRequestStateId(facultyRequestStateId);
	}

	/**
	 * Sets the faculty request status ID of this faculty request state.
	 *
	 * @param facultyRequestStatusId the faculty request status ID of this faculty request state
	 */
	@Override
	public void setFacultyRequestStatusId(long facultyRequestStatusId) {
		model.setFacultyRequestStatusId(facultyRequestStatusId);
	}

	/**
	 * Sets the group ID of this faculty request state.
	 *
	 * @param groupId the group ID of this faculty request state
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faculty request state.
	 *
	 * @param modifiedDate the modified date of this faculty request state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faculty request state.
	 *
	 * @param primaryKey the primary key of this faculty request state
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this faculty request state.
	 *
	 * @param uuid the uuid of this faculty request state
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
	protected FacultyRequestStateWrapper wrap(
		FacultyRequestState facultyRequestState) {

		return new FacultyRequestStateWrapper(facultyRequestState);
	}

}