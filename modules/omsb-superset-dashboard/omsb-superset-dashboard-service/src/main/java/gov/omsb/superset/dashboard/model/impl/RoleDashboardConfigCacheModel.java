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

package gov.omsb.superset.dashboard.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import gov.omsb.superset.dashboard.model.RoleDashboardConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RoleDashboardConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoleDashboardConfigCacheModel
	implements CacheModel<RoleDashboardConfig>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleDashboardConfigCacheModel)) {
			return false;
		}

		RoleDashboardConfigCacheModel roleDashboardConfigCacheModel =
			(RoleDashboardConfigCacheModel)object;

		if (configId == roleDashboardConfigCacheModel.configId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, configId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{configId=");
		sb.append(configId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", dashboardId=");
		sb.append(dashboardId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RoleDashboardConfig toEntityModel() {
		RoleDashboardConfigImpl roleDashboardConfigImpl =
			new RoleDashboardConfigImpl();

		roleDashboardConfigImpl.setConfigId(configId);
		roleDashboardConfigImpl.setRoleId(roleId);

		if (dashboardId == null) {
			roleDashboardConfigImpl.setDashboardId("");
		}
		else {
			roleDashboardConfigImpl.setDashboardId(dashboardId);
		}

		roleDashboardConfigImpl.setCompanyId(companyId);
		roleDashboardConfigImpl.setGroupId(groupId);
		roleDashboardConfigImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			roleDashboardConfigImpl.setCreatedDate(null);
		}
		else {
			roleDashboardConfigImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			roleDashboardConfigImpl.setModifiedDate(null);
		}
		else {
			roleDashboardConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		roleDashboardConfigImpl.setCreatedBy(createdBy);
		roleDashboardConfigImpl.setModifiedBy(modifiedBy);

		roleDashboardConfigImpl.resetOriginalValues();

		return roleDashboardConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configId = objectInput.readLong();

		roleId = objectInput.readLong();
		dashboardId = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(configId);

		objectOutput.writeLong(roleId);

		if (dashboardId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dashboardId);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);
	}

	public long configId;
	public long roleId;
	public String dashboardId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;

}