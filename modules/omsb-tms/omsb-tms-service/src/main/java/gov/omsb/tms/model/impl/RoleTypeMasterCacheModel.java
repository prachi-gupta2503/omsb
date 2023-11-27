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

package gov.omsb.tms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import gov.omsb.tms.model.RoleTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RoleTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoleTypeMasterCacheModel
	implements CacheModel<RoleTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleTypeMasterCacheModel)) {
			return false;
		}

		RoleTypeMasterCacheModel roleTypeMasterCacheModel =
			(RoleTypeMasterCacheModel)object;

		if (roleTypeMasterId == roleTypeMasterCacheModel.roleTypeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roleTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", roleTypeMasterId=");
		sb.append(roleTypeMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", roleTypeName=");
		sb.append(roleTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RoleTypeMaster toEntityModel() {
		RoleTypeMasterImpl roleTypeMasterImpl = new RoleTypeMasterImpl();

		if (uuid == null) {
			roleTypeMasterImpl.setUuid("");
		}
		else {
			roleTypeMasterImpl.setUuid(uuid);
		}

		roleTypeMasterImpl.setRoleTypeMasterId(roleTypeMasterId);
		roleTypeMasterImpl.setGroupId(groupId);
		roleTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			roleTypeMasterImpl.setCreateDate(null);
		}
		else {
			roleTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		roleTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			roleTypeMasterImpl.setModifiedDate(null);
		}
		else {
			roleTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		roleTypeMasterImpl.setModifiedBy(modifiedBy);

		if (roleTypeName == null) {
			roleTypeMasterImpl.setRoleTypeName("");
		}
		else {
			roleTypeMasterImpl.setRoleTypeName(roleTypeName);
		}

		roleTypeMasterImpl.resetOriginalValues();

		return roleTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		roleTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		roleTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(roleTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (roleTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleTypeName);
		}
	}

	public String uuid;
	public long roleTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String roleTypeName;

}