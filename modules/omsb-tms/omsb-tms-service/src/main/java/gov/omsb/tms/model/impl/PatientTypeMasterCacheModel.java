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

import gov.omsb.tms.model.PatientTypeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PatientTypeMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientTypeMasterCacheModel
	implements CacheModel<PatientTypeMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientTypeMasterCacheModel)) {
			return false;
		}

		PatientTypeMasterCacheModel patientTypeMasterCacheModel =
			(PatientTypeMasterCacheModel)object;

		if (patientTypeMasterId ==
				patientTypeMasterCacheModel.patientTypeMasterId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, patientTypeMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", patientTypeMasterId=");
		sb.append(patientTypeMasterId);
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
		sb.append(", patientTypeName=");
		sb.append(patientTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PatientTypeMaster toEntityModel() {
		PatientTypeMasterImpl patientTypeMasterImpl =
			new PatientTypeMasterImpl();

		if (uuid == null) {
			patientTypeMasterImpl.setUuid("");
		}
		else {
			patientTypeMasterImpl.setUuid(uuid);
		}

		patientTypeMasterImpl.setPatientTypeMasterId(patientTypeMasterId);
		patientTypeMasterImpl.setGroupId(groupId);
		patientTypeMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			patientTypeMasterImpl.setCreateDate(null);
		}
		else {
			patientTypeMasterImpl.setCreateDate(new Date(createDate));
		}

		patientTypeMasterImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			patientTypeMasterImpl.setModifiedDate(null);
		}
		else {
			patientTypeMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		patientTypeMasterImpl.setModifiedBy(modifiedBy);

		if (patientTypeName == null) {
			patientTypeMasterImpl.setPatientTypeName("");
		}
		else {
			patientTypeMasterImpl.setPatientTypeName(patientTypeName);
		}

		patientTypeMasterImpl.resetOriginalValues();

		return patientTypeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		patientTypeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		patientTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(patientTypeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (patientTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patientTypeName);
		}
	}

	public String uuid;
	public long patientTypeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String patientTypeName;

}