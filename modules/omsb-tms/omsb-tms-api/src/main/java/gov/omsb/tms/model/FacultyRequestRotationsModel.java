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
 * The base model interface for the FacultyRequestRotations service. Represents a row in the &quot;faculty_request_rotations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.FacultyRequestRotationsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.FacultyRequestRotationsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotations
 * @generated
 */
@ProviderType
public interface FacultyRequestRotationsModel
	extends BaseModel<FacultyRequestRotations>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty request rotations model instance should use the {@link FacultyRequestRotations} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty request rotations.
	 *
	 * @return the primary key of this faculty request rotations
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty request rotations.
	 *
	 * @param primaryKey the primary key of this faculty request rotations
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faculty request rotations.
	 *
	 * @return the uuid of this faculty request rotations
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faculty request rotations.
	 *
	 * @param uuid the uuid of this faculty request rotations
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faculty request rotations ID of this faculty request rotations.
	 *
	 * @return the faculty request rotations ID of this faculty request rotations
	 */
	public long getFacultyRequestRotationsId();

	/**
	 * Sets the faculty request rotations ID of this faculty request rotations.
	 *
	 * @param facultyRequestRotationsId the faculty request rotations ID of this faculty request rotations
	 */
	public void setFacultyRequestRotationsId(long facultyRequestRotationsId);

	/**
	 * Returns the group ID of this faculty request rotations.
	 *
	 * @return the group ID of this faculty request rotations
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this faculty request rotations.
	 *
	 * @param groupId the group ID of this faculty request rotations
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faculty request rotations.
	 *
	 * @return the company ID of this faculty request rotations
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faculty request rotations.
	 *
	 * @param companyId the company ID of this faculty request rotations
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by of this faculty request rotations.
	 *
	 * @return the created by of this faculty request rotations
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this faculty request rotations.
	 *
	 * @param createdBy the created by of this faculty request rotations
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the create date of this faculty request rotations.
	 *
	 * @return the create date of this faculty request rotations
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faculty request rotations.
	 *
	 * @param createDate the create date of this faculty request rotations
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faculty request rotations.
	 *
	 * @return the modified date of this faculty request rotations
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faculty request rotations.
	 *
	 * @param modifiedDate the modified date of this faculty request rotations
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this faculty request rotations.
	 *
	 * @return the modified by of this faculty request rotations
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this faculty request rotations.
	 *
	 * @param modifiedBy the modified by of this faculty request rotations
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the faculty request ID of this faculty request rotations.
	 *
	 * @return the faculty request ID of this faculty request rotations
	 */
	public long getFacultyRequestId();

	/**
	 * Sets the faculty request ID of this faculty request rotations.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty request rotations
	 */
	public void setFacultyRequestId(long facultyRequestId);

	/**
	 * Returns the training site ID of this faculty request rotations.
	 *
	 * @return the training site ID of this faculty request rotations
	 */
	public long getTrainingSiteId();

	/**
	 * Sets the training site ID of this faculty request rotations.
	 *
	 * @param trainingSiteId the training site ID of this faculty request rotations
	 */
	public void setTrainingSiteId(long trainingSiteId);

	/**
	 * Returns the rotation ID of this faculty request rotations.
	 *
	 * @return the rotation ID of this faculty request rotations
	 */
	public long getRotationId();

	/**
	 * Sets the rotation ID of this faculty request rotations.
	 *
	 * @param rotationId the rotation ID of this faculty request rotations
	 */
	public void setRotationId(long rotationId);

	/**
	 * Returns the is active of this faculty request rotations.
	 *
	 * @return the is active of this faculty request rotations
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this faculty request rotations is is active.
	 *
	 * @return <code>true</code> if this faculty request rotations is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this faculty request rotations is is active.
	 *
	 * @param isActive the is active of this faculty request rotations
	 */
	public void setIsActive(boolean isActive);

	@Override
	public FacultyRequestRotations cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}