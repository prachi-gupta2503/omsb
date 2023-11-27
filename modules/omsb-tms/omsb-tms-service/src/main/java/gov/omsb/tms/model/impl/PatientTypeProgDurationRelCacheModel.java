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

import gov.omsb.tms.model.PatientTypeProgDurationRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PatientTypeProgDurationRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientTypeProgDurationRelCacheModel
	implements CacheModel<PatientTypeProgDurationRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientTypeProgDurationRelCacheModel)) {
			return false;
		}

		PatientTypeProgDurationRelCacheModel
			patientTypeProgDurationRelCacheModel =
				(PatientTypeProgDurationRelCacheModel)object;

		if (PatientTypeProgDurationRelId ==
				patientTypeProgDurationRelCacheModel.
					PatientTypeProgDurationRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PatientTypeProgDurationRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PatientTypeProgDurationRelId=");
		sb.append(PatientTypeProgDurationRelId);
		sb.append(", patientTypeMasterId=");
		sb.append(patientTypeMasterId);
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
	public PatientTypeProgDurationRel toEntityModel() {
		PatientTypeProgDurationRelImpl patientTypeProgDurationRelImpl =
			new PatientTypeProgDurationRelImpl();

		if (uuid == null) {
			patientTypeProgDurationRelImpl.setUuid("");
		}
		else {
			patientTypeProgDurationRelImpl.setUuid(uuid);
		}

		patientTypeProgDurationRelImpl.setPatientTypeProgDurationRelId(
			PatientTypeProgDurationRelId);
		patientTypeProgDurationRelImpl.setPatientTypeMasterId(
			patientTypeMasterId);
		patientTypeProgDurationRelImpl.setProgramDurationId(programDurationId);
		patientTypeProgDurationRelImpl.setGroupId(groupId);
		patientTypeProgDurationRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			patientTypeProgDurationRelImpl.setCreateDate(null);
		}
		else {
			patientTypeProgDurationRelImpl.setCreateDate(new Date(createDate));
		}

		patientTypeProgDurationRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			patientTypeProgDurationRelImpl.setModifiedDate(null);
		}
		else {
			patientTypeProgDurationRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		patientTypeProgDurationRelImpl.setModifiedBy(modifiedBy);

		patientTypeProgDurationRelImpl.resetOriginalValues();

		return patientTypeProgDurationRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PatientTypeProgDurationRelId = objectInput.readLong();

		patientTypeMasterId = objectInput.readLong();

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

		objectOutput.writeLong(PatientTypeProgDurationRelId);

		objectOutput.writeLong(patientTypeMasterId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long PatientTypeProgDurationRelId;
	public long patientTypeMasterId;
	public long programDurationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}