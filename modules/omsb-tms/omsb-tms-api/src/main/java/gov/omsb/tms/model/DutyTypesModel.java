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
 * The base model interface for the DutyTypes service. Represents a row in the &quot;duty_types_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.DutyTypesModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.DutyTypesImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypes
 * @generated
 */
@ProviderType
public interface DutyTypesModel
	extends BaseModel<DutyTypes>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a duty types model instance should use the {@link DutyTypes} interface instead.
	 */

	/**
	 * Returns the primary key of this duty types.
	 *
	 * @return the primary key of this duty types
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this duty types.
	 *
	 * @param primaryKey the primary key of this duty types
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this duty types.
	 *
	 * @return the uuid of this duty types
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this duty types.
	 *
	 * @param uuid the uuid of this duty types
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the duty type ID of this duty types.
	 *
	 * @return the duty type ID of this duty types
	 */
	public long getDutyTypeId();

	/**
	 * Sets the duty type ID of this duty types.
	 *
	 * @param dutyTypeId the duty type ID of this duty types
	 */
	public void setDutyTypeId(long dutyTypeId);

	/**
	 * Returns the group ID of this duty types.
	 *
	 * @return the group ID of this duty types
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this duty types.
	 *
	 * @param groupId the group ID of this duty types
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this duty types.
	 *
	 * @return the company ID of this duty types
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this duty types.
	 *
	 * @param companyId the company ID of this duty types
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this duty types.
	 *
	 * @return the create date of this duty types
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this duty types.
	 *
	 * @param createDate the create date of this duty types
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this duty types.
	 *
	 * @return the created by of this duty types
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this duty types.
	 *
	 * @param createdBy the created by of this duty types
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this duty types.
	 *
	 * @return the modified date of this duty types
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this duty types.
	 *
	 * @param modifiedDate the modified date of this duty types
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this duty types.
	 *
	 * @return the modified by of this duty types
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this duty types.
	 *
	 * @param modifiedBy the modified by of this duty types
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the duty type of this duty types.
	 *
	 * @return the duty type of this duty types
	 */
	@AutoEscape
	public String getDutyType();

	/**
	 * Sets the duty type of this duty types.
	 *
	 * @param dutyType the duty type of this duty types
	 */
	public void setDutyType(String dutyType);

	/**
	 * Returns the status of this duty types.
	 *
	 * @return the status of this duty types
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this duty types.
	 *
	 * @param status the status of this duty types
	 */
	public void setStatus(String status);

	@Override
	public DutyTypes cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}