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

import gov.omsb.tms.model.ProgramMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramMasterCacheModel
	implements CacheModel<ProgramMaster>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramMasterCacheModel)) {
			return false;
		}

		ProgramMasterCacheModel programMasterCacheModel =
			(ProgramMasterCacheModel)object;

		if (programMasterId == programMasterCacheModel.programMasterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programMasterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programMasterId=");
		sb.append(programMasterId);
		sb.append(", programTypeId=");
		sb.append(programTypeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", programCode=");
		sb.append(programCode);
		sb.append(", programName=");
		sb.append(programName);
		sb.append(", programDescription=");
		sb.append(programDescription);
		sb.append(", establishmentDate=");
		sb.append(establishmentDate);
		sb.append(", programVision=");
		sb.append(programVision);
		sb.append(", programMission=");
		sb.append(programMission);
		sb.append(", programStatus=");
		sb.append(programStatus);
		sb.append(", programObjectives=");
		sb.append(programObjectives);
		sb.append(", programAdmissionRequirements=");
		sb.append(programAdmissionRequirements);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramMaster toEntityModel() {
		ProgramMasterImpl programMasterImpl = new ProgramMasterImpl();

		if (uuid == null) {
			programMasterImpl.setUuid("");
		}
		else {
			programMasterImpl.setUuid(uuid);
		}

		programMasterImpl.setProgramMasterId(programMasterId);
		programMasterImpl.setProgramTypeId(programTypeId);
		programMasterImpl.setGroupId(groupId);
		programMasterImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programMasterImpl.setCreateDate(null);
		}
		else {
			programMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			programMasterImpl.setModifiedDate(null);
		}
		else {
			programMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (programCode == null) {
			programMasterImpl.setProgramCode("");
		}
		else {
			programMasterImpl.setProgramCode(programCode);
		}

		if (programName == null) {
			programMasterImpl.setProgramName("");
		}
		else {
			programMasterImpl.setProgramName(programName);
		}

		if (programDescription == null) {
			programMasterImpl.setProgramDescription("");
		}
		else {
			programMasterImpl.setProgramDescription(programDescription);
		}

		if (establishmentDate == Long.MIN_VALUE) {
			programMasterImpl.setEstablishmentDate(null);
		}
		else {
			programMasterImpl.setEstablishmentDate(new Date(establishmentDate));
		}

		if (programVision == null) {
			programMasterImpl.setProgramVision("");
		}
		else {
			programMasterImpl.setProgramVision(programVision);
		}

		if (programMission == null) {
			programMasterImpl.setProgramMission("");
		}
		else {
			programMasterImpl.setProgramMission(programMission);
		}

		programMasterImpl.setProgramStatus(programStatus);

		if (programObjectives == null) {
			programMasterImpl.setProgramObjectives("");
		}
		else {
			programMasterImpl.setProgramObjectives(programObjectives);
		}

		if (programAdmissionRequirements == null) {
			programMasterImpl.setProgramAdmissionRequirements("");
		}
		else {
			programMasterImpl.setProgramAdmissionRequirements(
				programAdmissionRequirements);
		}

		programMasterImpl.resetOriginalValues();

		return programMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programMasterId = objectInput.readLong();

		programTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		programCode = objectInput.readUTF();
		programName = objectInput.readUTF();
		programDescription = objectInput.readUTF();
		establishmentDate = objectInput.readLong();
		programVision = objectInput.readUTF();
		programMission = objectInput.readUTF();

		programStatus = objectInput.readBoolean();
		programObjectives = objectInput.readUTF();
		programAdmissionRequirements = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programMasterId);

		objectOutput.writeLong(programTypeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (programCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programCode);
		}

		if (programName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programName);
		}

		if (programDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programDescription);
		}

		objectOutput.writeLong(establishmentDate);

		if (programVision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programVision);
		}

		if (programMission == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programMission);
		}

		objectOutput.writeBoolean(programStatus);

		if (programObjectives == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programObjectives);
		}

		if (programAdmissionRequirements == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programAdmissionRequirements);
		}
	}

	public String uuid;
	public long programMasterId;
	public long programTypeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String programCode;
	public String programName;
	public String programDescription;
	public long establishmentDate;
	public String programVision;
	public String programMission;
	public boolean programStatus;
	public String programObjectives;
	public String programAdmissionRequirements;

}