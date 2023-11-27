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

import gov.omsb.tms.model.TraineeLoggedProcedureDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraineeLoggedProcedureDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TraineeLoggedProcedureDetailsCacheModel
	implements CacheModel<TraineeLoggedProcedureDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TraineeLoggedProcedureDetailsCacheModel)) {
			return false;
		}

		TraineeLoggedProcedureDetailsCacheModel
			traineeLoggedProcedureDetailsCacheModel =
				(TraineeLoggedProcedureDetailsCacheModel)object;

		if (traineeLoggedProcedureDetailsId ==
				traineeLoggedProcedureDetailsCacheModel.
					traineeLoggedProcedureDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traineeLoggedProcedureDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traineeLoggedProcedureDetailsId=");
		sb.append(traineeLoggedProcedureDetailsId);
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
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);
		sb.append(", procedureGroupId=");
		sb.append(procedureGroupId);
		sb.append(", procedureId=");
		sb.append(procedureId);
		sb.append(", genderId=");
		sb.append(genderId);
		sb.append(", patientTypeId=");
		sb.append(patientTypeId);
		sb.append(", visitTypeId=");
		sb.append(visitTypeId);
		sb.append(", cptCode=");
		sb.append(cptCode);
		sb.append(", trainingSitesId=");
		sb.append(trainingSitesId);
		sb.append(", roleTypeId=");
		sb.append(roleTypeId);
		sb.append(", facultyId=");
		sb.append(facultyId);
		sb.append(", traineeId=");
		sb.append(traineeId);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", patientDOB=");
		sb.append(patientDOB);
		sb.append(", procedurePerformedDate=");
		sb.append(procedurePerformedDate);
		sb.append(", diagnosisDescription=");
		sb.append(diagnosisDescription);
		sb.append(", traineeComments=");
		sb.append(traineeComments);
		sb.append(", supervisorComments=");
		sb.append(supervisorComments);
		sb.append(", procedureStatus=");
		sb.append(procedureStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraineeLoggedProcedureDetails toEntityModel() {
		TraineeLoggedProcedureDetailsImpl traineeLoggedProcedureDetailsImpl =
			new TraineeLoggedProcedureDetailsImpl();

		if (uuid == null) {
			traineeLoggedProcedureDetailsImpl.setUuid("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setUuid(uuid);
		}

		traineeLoggedProcedureDetailsImpl.setTraineeLoggedProcedureDetailsId(
			traineeLoggedProcedureDetailsId);
		traineeLoggedProcedureDetailsImpl.setGroupId(groupId);
		traineeLoggedProcedureDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			traineeLoggedProcedureDetailsImpl.setCreateDate(null);
		}
		else {
			traineeLoggedProcedureDetailsImpl.setCreateDate(
				new Date(createDate));
		}

		traineeLoggedProcedureDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			traineeLoggedProcedureDetailsImpl.setModifiedDate(null);
		}
		else {
			traineeLoggedProcedureDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		traineeLoggedProcedureDetailsImpl.setModifiedBy(modifiedBy);
		traineeLoggedProcedureDetailsImpl.setProgramDurationId(
			programDurationId);
		traineeLoggedProcedureDetailsImpl.setRotationId(rotationId);
		traineeLoggedProcedureDetailsImpl.setTraineeLevelId(traineeLevelId);
		traineeLoggedProcedureDetailsImpl.setProcedureGroupId(procedureGroupId);
		traineeLoggedProcedureDetailsImpl.setProcedureId(procedureId);
		traineeLoggedProcedureDetailsImpl.setGenderId(genderId);
		traineeLoggedProcedureDetailsImpl.setPatientTypeId(patientTypeId);
		traineeLoggedProcedureDetailsImpl.setVisitTypeId(visitTypeId);

		if (cptCode == null) {
			traineeLoggedProcedureDetailsImpl.setCptCode("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setCptCode(cptCode);
		}

		traineeLoggedProcedureDetailsImpl.setTrainingSitesId(trainingSitesId);
		traineeLoggedProcedureDetailsImpl.setRoleTypeId(roleTypeId);
		traineeLoggedProcedureDetailsImpl.setFacultyId(facultyId);
		traineeLoggedProcedureDetailsImpl.setTraineeId(traineeId);

		if (patientId == null) {
			traineeLoggedProcedureDetailsImpl.setPatientId("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setPatientId(patientId);
		}

		if (patientDOB == Long.MIN_VALUE) {
			traineeLoggedProcedureDetailsImpl.setPatientDOB(null);
		}
		else {
			traineeLoggedProcedureDetailsImpl.setPatientDOB(
				new Date(patientDOB));
		}

		if (procedurePerformedDate == Long.MIN_VALUE) {
			traineeLoggedProcedureDetailsImpl.setProcedurePerformedDate(null);
		}
		else {
			traineeLoggedProcedureDetailsImpl.setProcedurePerformedDate(
				new Date(procedurePerformedDate));
		}

		if (diagnosisDescription == null) {
			traineeLoggedProcedureDetailsImpl.setDiagnosisDescription("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setDiagnosisDescription(
				diagnosisDescription);
		}

		if (traineeComments == null) {
			traineeLoggedProcedureDetailsImpl.setTraineeComments("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setTraineeComments(
				traineeComments);
		}

		if (supervisorComments == null) {
			traineeLoggedProcedureDetailsImpl.setSupervisorComments("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setSupervisorComments(
				supervisorComments);
		}

		if (procedureStatus == null) {
			traineeLoggedProcedureDetailsImpl.setProcedureStatus("");
		}
		else {
			traineeLoggedProcedureDetailsImpl.setProcedureStatus(
				procedureStatus);
		}

		traineeLoggedProcedureDetailsImpl.resetOriginalValues();

		return traineeLoggedProcedureDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traineeLoggedProcedureDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		programDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		traineeLevelId = objectInput.readLong();

		procedureGroupId = objectInput.readLong();

		procedureId = objectInput.readLong();

		genderId = objectInput.readLong();

		patientTypeId = objectInput.readLong();

		visitTypeId = objectInput.readLong();
		cptCode = objectInput.readUTF();

		trainingSitesId = objectInput.readLong();

		roleTypeId = objectInput.readLong();

		facultyId = objectInput.readLong();

		traineeId = objectInput.readLong();
		patientId = objectInput.readUTF();
		patientDOB = objectInput.readLong();
		procedurePerformedDate = objectInput.readLong();
		diagnosisDescription = objectInput.readUTF();
		traineeComments = objectInput.readUTF();
		supervisorComments = objectInput.readUTF();
		procedureStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traineeLoggedProcedureDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(traineeLevelId);

		objectOutput.writeLong(procedureGroupId);

		objectOutput.writeLong(procedureId);

		objectOutput.writeLong(genderId);

		objectOutput.writeLong(patientTypeId);

		objectOutput.writeLong(visitTypeId);

		if (cptCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cptCode);
		}

		objectOutput.writeLong(trainingSitesId);

		objectOutput.writeLong(roleTypeId);

		objectOutput.writeLong(facultyId);

		objectOutput.writeLong(traineeId);

		if (patientId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patientId);
		}

		objectOutput.writeLong(patientDOB);
		objectOutput.writeLong(procedurePerformedDate);

		if (diagnosisDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diagnosisDescription);
		}

		if (traineeComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(traineeComments);
		}

		if (supervisorComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supervisorComments);
		}

		if (procedureStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(procedureStatus);
		}
	}

	public String uuid;
	public long traineeLoggedProcedureDetailsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long programDurationId;
	public long rotationId;
	public long traineeLevelId;
	public long procedureGroupId;
	public long procedureId;
	public long genderId;
	public long patientTypeId;
	public long visitTypeId;
	public String cptCode;
	public long trainingSitesId;
	public long roleTypeId;
	public long facultyId;
	public long traineeId;
	public String patientId;
	public long patientDOB;
	public long procedurePerformedDate;
	public String diagnosisDescription;
	public String traineeComments;
	public String supervisorComments;
	public String procedureStatus;

}