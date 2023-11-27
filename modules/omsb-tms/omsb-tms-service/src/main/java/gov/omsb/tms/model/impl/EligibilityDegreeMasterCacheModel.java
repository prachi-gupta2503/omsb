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

import gov.omsb.tms.model.EligibilityDegreeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EligibilityDegreeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EligibilityDegreeMasterCacheModel
	implements CacheModel<EligibilityDegreeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EligibilityDegreeMasterCacheModel)) {
			return false;
		}

		EligibilityDegreeMasterCacheModel eligibilityDegreeMasterCacheModel =
			(EligibilityDegreeMasterCacheModel)object;

		if (eligibilityDegreeMasterId ==
				eligibilityDegreeMasterCacheModel.eligibilityDegreeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eligibilityDegreeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eligibilityDegreeMasterId=");
		sb.append(eligibilityDegreeMasterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", eligibilityDegree=");
		sb.append(eligibilityDegree);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EligibilityDegreeMaster toEntityModel() {
		EligibilityDegreeMasterImpl eligibilityDegreeMasterImpl =
			new EligibilityDegreeMasterImpl();

		if (uuid == null) {
			eligibilityDegreeMasterImpl.setUuid("");
		}
		else {
			eligibilityDegreeMasterImpl.setUuid(uuid);
		}

		eligibilityDegreeMasterImpl.setEligibilityDegreeMasterId(
			eligibilityDegreeMasterId);
		eligibilityDegreeMasterImpl.setGroupId(groupId);
		eligibilityDegreeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			eligibilityDegreeMasterImpl.setCreateDate(null);
		}
		else {
			eligibilityDegreeMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eligibilityDegreeMasterImpl.setModifiedDate(null);
		}
		else {
			eligibilityDegreeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		eligibilityDegreeMasterImpl.setCreatedBy(createdBy);
		eligibilityDegreeMasterImpl.setModifiedBy(modifiedBy);

		if (eligibilityDegree == null) {
			eligibilityDegreeMasterImpl.setEligibilityDegree("");
		}
		else {
			eligibilityDegreeMasterImpl.setEligibilityDegree(eligibilityDegree);
		}

		eligibilityDegreeMasterImpl.resetOriginalValues();

		return eligibilityDegreeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eligibilityDegreeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		eligibilityDegree = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eligibilityDegreeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		if (eligibilityDegree == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eligibilityDegree);
		}
	}

	public String uuid;
	public long eligibilityDegreeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public String eligibilityDegree;

}