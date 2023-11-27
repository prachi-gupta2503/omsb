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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FacultyRequestState service. Represents a row in the &quot;faculty_request_state&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.FacultyRequestStateModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.FacultyRequestStateImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestState
 * @generated
 */
@ProviderType
public interface FacultyRequestStateModel
	extends BaseModel<FacultyRequestState>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty request state model instance should use the {@link FacultyRequestState} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty request state.
	 *
	 * @return the primary key of this faculty request state
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty request state.
	 *
	 * @param primaryKey the primary key of this faculty request state
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faculty request state.
	 *
	 * @return the uuid of this faculty request state
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faculty request state.
	 *
	 * @param uuid the uuid of this faculty request state
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faculty request state ID of this faculty request state.
	 *
	 * @return the faculty request state ID of this faculty request state
	 */
	public long getFacultyRequestStateId();

	/**
	 * Sets the faculty request state ID of this faculty request state.
	 *
	 * @param facultyRequestStateId the faculty request state ID of this faculty request state
	 */
	public void setFacultyRequestStateId(long facultyRequestStateId);

	/**
	 * Returns the group ID of this faculty request state.
	 *
	 * @return the group ID of this faculty request state
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this faculty request state.
	 *
	 * @param groupId the group ID of this faculty request state
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faculty request state.
	 *
	 * @return the company ID of this faculty request state
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faculty request state.
	 *
	 * @param companyId the company ID of this faculty request state
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by of this faculty request state.
	 *
	 * @return the created by of this faculty request state
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this faculty request state.
	 *
	 * @param createdBy the created by of this faculty request state
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the create date of this faculty request state.
	 *
	 * @return the create date of this faculty request state
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faculty request state.
	 *
	 * @param createDate the create date of this faculty request state
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faculty request state.
	 *
	 * @return the modified date of this faculty request state
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faculty request state.
	 *
	 * @param modifiedDate the modified date of this faculty request state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created by role ID of this faculty request state.
	 *
	 * @return the created by role ID of this faculty request state
	 */
	public long getCreatedByRoleId();

	/**
	 * Sets the created by role ID of this faculty request state.
	 *
	 * @param createdByRoleId the created by role ID of this faculty request state
	 */
	public void setCreatedByRoleId(long createdByRoleId);

	/**
	 * Returns the faculty request ID of this faculty request state.
	 *
	 * @return the faculty request ID of this faculty request state
	 */
	public long getFacultyRequestId();

	/**
	 * Sets the faculty request ID of this faculty request state.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty request state
	 */
	public void setFacultyRequestId(long facultyRequestId);

	/**
	 * Returns the faculty request status ID of this faculty request state.
	 *
	 * @return the faculty request status ID of this faculty request state
	 */
	public long getFacultyRequestStatusId();

	/**
	 * Sets the faculty request status ID of this faculty request state.
	 *
	 * @param facultyRequestStatusId the faculty request status ID of this faculty request state
	 */
	public void setFacultyRequestStatusId(long facultyRequestStatusId);

	/**
	 * Returns the comments of this faculty request state.
	 *
	 * @return the comments of this faculty request state
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this faculty request state.
	 *
	 * @param comments the comments of this faculty request state
	 */
	public void setComments(String comments);

	@Override
	public FacultyRequestState cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}