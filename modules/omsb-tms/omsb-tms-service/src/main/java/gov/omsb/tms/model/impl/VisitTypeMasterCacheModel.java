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

import gov.omsb.tms.model.VisitTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VisitTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VisitTypeMasterCacheModel
	implements CacheModel<VisitTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisitTypeMasterCacheModel)) {
			return false;
		}

		VisitTypeMasterCacheModel visitTypeMasterCacheModel =
			(VisitTypeMasterCacheModel)object;

		if (visitTypeMasterId == visitTypeMasterCacheModel.visitTypeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, visitTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", visitTypeMasterId=");
		sb.append(visitTypeMasterId);
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
		sb.append(", visitTypeName=");
		sb.append(visitTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VisitTypeMaster toEntityModel() {
		VisitTypeMasterImpl visitTypeMasterImpl = new VisitTypeMasterImpl();

		if (uuid == null) {
			visitTypeMasterImpl.setUuid("");
		}
		else {
			visitTypeMasterImpl.setUuid(uuid);
		}

		visitTypeMasterImpl.setVisitTypeMasterId(visitTypeMasterId);
		visitTypeMasterImpl.setGroupId(groupId);
		visitTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			visitTypeMasterImpl.setCreateDate(null);
		}
		else {
			visitTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		visitTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			visitTypeMasterImpl.setModifiedDate(null);
		}
		else {
			visitTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		visitTypeMasterImpl.setModifiedBy(modifiedBy);

		if (visitTypeName == null) {
			visitTypeMasterImpl.setVisitTypeName("");
		}
		else {
			visitTypeMasterImpl.setVisitTypeName(visitTypeName);
		}

		visitTypeMasterImpl.resetOriginalValues();

		return visitTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		visitTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		visitTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(visitTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (visitTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visitTypeName);
		}
	}

	public String uuid;
	public long visitTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String visitTypeName;

}