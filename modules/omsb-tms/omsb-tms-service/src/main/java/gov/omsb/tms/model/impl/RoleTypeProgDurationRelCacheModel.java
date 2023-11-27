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

import gov.omsb.tms.model.RoleTypeProgDurationRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RoleTypeProgDurationRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoleTypeProgDurationRelCacheModel
	implements CacheModel<RoleTypeProgDurationRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleTypeProgDurationRelCacheModel)) {
			return false;
		}

		RoleTypeProgDurationRelCacheModel roleTypeProgDurationRelCacheModel =
			(RoleTypeProgDurationRelCacheModel)object;

		if (RoleTypeProgDurationRelId ==
				roleTypeProgDurationRelCacheModel.RoleTypeProgDurationRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, RoleTypeProgDurationRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", RoleTypeProgDurationRelId=");
		sb.append(RoleTypeProgDurationRelId);
		sb.append(", roleTypeMasterId=");
		sb.append(roleTypeMasterId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RoleTypeProgDurationRel toEntityModel() {
		RoleTypeProgDurationRelImpl roleTypeProgDurationRelImpl =
			new RoleTypeProgDurationRelImpl();

		if (uuid == null) {
			roleTypeProgDurationRelImpl.setUuid("");
		}
		else {
			roleTypeProgDurationRelImpl.setUuid(uuid);
		}

		roleTypeProgDurationRelImpl.setRoleTypeProgDurationRelId(
			RoleTypeProgDurationRelId);
		roleTypeProgDurationRelImpl.setRoleTypeMasterId(roleTypeMasterId);
		roleTypeProgDurationRelImpl.setProgramDurationId(programDurationId);
		roleTypeProgDurationRelImpl.setGroupId(groupId);
		roleTypeProgDurationRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			roleTypeProgDurationRelImpl.setCreateDate(null);
		}
		else {
			roleTypeProgDurationRelImpl.setCreateDate(new Date(createDate));
		}

		roleTypeProgDurationRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			roleTypeProgDurationRelImpl.setModifiedDate(null);
		}
		else {
			roleTypeProgDurationRelImpl.setModifiedDate(new Date(modifiedDate));
		}

		roleTypeProgDurationRelImpl.setModifiedBy(modifiedBy);

		roleTypeProgDurationRelImpl.resetOriginalValues();

		return roleTypeProgDurationRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		RoleTypeProgDurationRelId = objectInput.readLong();

		roleTypeMasterId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(RoleTypeProgDurationRelId);

		objectOutput.writeLong(roleTypeMasterId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long RoleTypeProgDurationRelId;
	public long roleTypeMasterId;
	public long programDurationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}