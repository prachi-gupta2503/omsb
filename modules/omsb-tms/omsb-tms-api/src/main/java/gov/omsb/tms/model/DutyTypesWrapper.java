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
 * This class is a wrapper for {@link DutyTypes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypes
 * @generated
 */
public class DutyTypesWrapper
	extends BaseModelWrapper<DutyTypes>
	implements DutyTypes, ModelWrapper<DutyTypes> {

	public DutyTypesWrapper(DutyTypes dutyTypes) {
		super(dutyTypes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dutyTypeId", getDutyTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("dutyType", getDutyType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dutyTypeId = (Long)attributes.get("dutyTypeId");

		if (dutyTypeId != null) {
			setDutyTypeId(dutyTypeId);
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

		String dutyType = (String)attributes.get("dutyType");

		if (dutyType != null) {
			setDutyType(dutyType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public DutyTypes cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this duty types.
	 *
	 * @return the company ID of this duty types
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this duty types.
	 *
	 * @return the create date of this duty types
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this duty types.
	 *
	 * @return the created by of this duty types
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the duty type of this duty types.
	 *
	 * @return the duty type of this duty types
	 */
	@Override
	public String getDutyType() {
		return model.getDutyType();
	}

	/**
	 * Returns the duty type ID of this duty types.
	 *
	 * @return the duty type ID of this duty types
	 */
	@Override
	public long getDutyTypeId() {
		return model.getDutyTypeId();
	}

	/**
	 * Returns the group ID of this duty types.
	 *
	 * @return the group ID of this duty types
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this duty types.
	 *
	 * @return the modified by of this duty types
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this duty types.
	 *
	 * @return the modified date of this duty types
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this duty types.
	 *
	 * @return the primary key of this duty types
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this duty types.
	 *
	 * @return the status of this duty types
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this duty types.
	 *
	 * @return the uuid of this duty types
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
	 * Sets the company ID of this duty types.
	 *
	 * @param companyId the company ID of this duty types
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this duty types.
	 *
	 * @param createDate the create date of this duty types
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this duty types.
	 *
	 * @param createdBy the created by of this duty types
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the duty type of this duty types.
	 *
	 * @param dutyType the duty type of this duty types
	 */
	@Override
	public void setDutyType(String dutyType) {
		model.setDutyType(dutyType);
	}

	/**
	 * Sets the duty type ID of this duty types.
	 *
	 * @param dutyTypeId the duty type ID of this duty types
	 */
	@Override
	public void setDutyTypeId(long dutyTypeId) {
		model.setDutyTypeId(dutyTypeId);
	}

	/**
	 * Sets the group ID of this duty types.
	 *
	 * @param groupId the group ID of this duty types
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this duty types.
	 *
	 * @param modifiedBy the modified by of this duty types
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this duty types.
	 *
	 * @param modifiedDate the modified date of this duty types
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this duty types.
	 *
	 * @param primaryKey the primary key of this duty types
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this duty types.
	 *
	 * @param status the status of this duty types
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this duty types.
	 *
	 * @param uuid the uuid of this duty types
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
	protected DutyTypesWrapper wrap(DutyTypes dutyTypes) {
		return new DutyTypesWrapper(dutyTypes);
	}

}