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

import gov.omsb.tms.model.CptCodeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CptCodeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CptCodeMasterCacheModel
	implements CacheModel<CptCodeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CptCodeMasterCacheModel)) {
			return false;
		}

		CptCodeMasterCacheModel cptCodeMasterCacheModel =
			(CptCodeMasterCacheModel)object;

		if (cptCodeMasterId == cptCodeMasterCacheModel.cptCodeMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cptCodeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cptCodeMasterId=");
		sb.append(cptCodeMasterId);
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
		sb.append(", cptCodeName=");
		sb.append(cptCodeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CptCodeMaster toEntityModel() {
		CptCodeMasterImpl cptCodeMasterImpl = new CptCodeMasterImpl();

		if (uuid == null) {
			cptCodeMasterImpl.setUuid("");
		}
		else {
			cptCodeMasterImpl.setUuid(uuid);
		}

		cptCodeMasterImpl.setCptCodeMasterId(cptCodeMasterId);
		cptCodeMasterImpl.setGroupId(groupId);
		cptCodeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			cptCodeMasterImpl.setCreateDate(null);
		}
		else {
			cptCodeMasterImpl.setCreateDate(new Date(createDate));
		}

		cptCodeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			cptCodeMasterImpl.setModifiedDate(null);
		}
		else {
			cptCodeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		cptCodeMasterImpl.setModifiedBy(modifiedBy);

		if (cptCodeName == null) {
			cptCodeMasterImpl.setCptCodeName("");
		}
		else {
			cptCodeMasterImpl.setCptCodeName(cptCodeName);
		}

		cptCodeMasterImpl.resetOriginalValues();

		return cptCodeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		cptCodeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		cptCodeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(cptCodeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (cptCodeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cptCodeName);
		}
	}

	public String uuid;
	public long cptCodeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String cptCodeName;

}