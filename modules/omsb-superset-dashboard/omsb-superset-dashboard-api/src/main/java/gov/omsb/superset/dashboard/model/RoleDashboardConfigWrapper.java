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

package gov.omsb.superset.dashboard.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RoleDashboardConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfig
 * @generated
 */
public class RoleDashboardConfigWrapper
	extends BaseModelWrapper<RoleDashboardConfig>
	implements ModelWrapper<RoleDashboardConfig>, RoleDashboardConfig {

	public RoleDashboardConfigWrapper(RoleDashboardConfig roleDashboardConfig) {
		super(roleDashboardConfig);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configId", getConfigId());
		attributes.put("roleId", getRoleId());
		attributes.put("dashboardId", getDashboardId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configId = (Long)attributes.get("configId");

		if (configId != null) {
			setConfigId(configId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String dashboardId = (String)attributes.get("dashboardId");

		if (dashboardId != null) {
			setDashboardId(dashboardId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public RoleDashboardConfig cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this role dashboard config.
	 *
	 * @return the company ID of this role dashboard config
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the config ID of this role dashboard config.
	 *
	 * @return the config ID of this role dashboard config
	 */
	@Override
	public long getConfigId() {
		return model.getConfigId();
	}

	/**
	 * Returns the created by of this role dashboard config.
	 *
	 * @return the created by of this role dashboard config
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this role dashboard config.
	 *
	 * @return the created date of this role dashboard config
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the dashboard ID of this role dashboard config.
	 *
	 * @return the dashboard ID of this role dashboard config
	 */
	@Override
	public String getDashboardId() {
		return model.getDashboardId();
	}

	/**
	 * Returns the group ID of this role dashboard config.
	 *
	 * @return the group ID of this role dashboard config
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this role dashboard config.
	 *
	 * @return the modified by of this role dashboard config
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this role dashboard config.
	 *
	 * @return the modified date of this role dashboard config
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this role dashboard config.
	 *
	 * @return the primary key of this role dashboard config
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this role dashboard config.
	 *
	 * @return the role ID of this role dashboard config
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the user ID of this role dashboard config.
	 *
	 * @return the user ID of this role dashboard config
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this role dashboard config.
	 *
	 * @return the user uuid of this role dashboard config
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this role dashboard config.
	 *
	 * @param companyId the company ID of this role dashboard config
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the config ID of this role dashboard config.
	 *
	 * @param configId the config ID of this role dashboard config
	 */
	@Override
	public void setConfigId(long configId) {
		model.setConfigId(configId);
	}

	/**
	 * Sets the created by of this role dashboard config.
	 *
	 * @param createdBy the created by of this role dashboard config
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this role dashboard config.
	 *
	 * @param createdDate the created date of this role dashboard config
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the dashboard ID of this role dashboard config.
	 *
	 * @param dashboardId the dashboard ID of this role dashboard config
	 */
	@Override
	public void setDashboardId(String dashboardId) {
		model.setDashboardId(dashboardId);
	}

	/**
	 * Sets the group ID of this role dashboard config.
	 *
	 * @param groupId the group ID of this role dashboard config
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this role dashboard config.
	 *
	 * @param modifiedBy the modified by of this role dashboard config
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this role dashboard config.
	 *
	 * @param modifiedDate the modified date of this role dashboard config
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this role dashboard config.
	 *
	 * @param primaryKey the primary key of this role dashboard config
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this role dashboard config.
	 *
	 * @param roleId the role ID of this role dashboard config
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the user ID of this role dashboard config.
	 *
	 * @param userId the user ID of this role dashboard config
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this role dashboard config.
	 *
	 * @param userUuid the user uuid of this role dashboard config
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RoleDashboardConfigWrapper wrap(
		RoleDashboardConfig roleDashboardConfig) {

		return new RoleDashboardConfigWrapper(roleDashboardConfig);
	}

}