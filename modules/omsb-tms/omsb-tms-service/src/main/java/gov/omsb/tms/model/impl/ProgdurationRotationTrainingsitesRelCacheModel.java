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

import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgdurationRotationTrainingsitesRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelCacheModel
	implements CacheModel<ProgdurationRotationTrainingsitesRel>,
			   Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof
				ProgdurationRotationTrainingsitesRelCacheModel)) {

			return false;
		}

		ProgdurationRotationTrainingsitesRelCacheModel
			progdurationRotationTrainingsitesRelCacheModel =
				(ProgdurationRotationTrainingsitesRelCacheModel)object;

		if (progdurationRotationTsRelId ==
				progdurationRotationTrainingsitesRelCacheModel.
					progdurationRotationTsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progdurationRotationTsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progdurationRotationTsRelId=");
		sb.append(progdurationRotationTsRelId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
		sb.append(", trainingSitesId=");
		sb.append(trainingSitesId);
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
		sb.append(", isSharedRotation=");
		sb.append(isSharedRotation);
		sb.append(", rotationOwningProgramId=");
		sb.append(rotationOwningProgramId);
		sb.append(", progCodeRsnSiteCode=");
		sb.append(progCodeRsnSiteCode);
		sb.append(", owningProgramDurationId=");
		sb.append(owningProgramDurationId);
		sb.append(", noOfSlots=");
		sb.append(noOfSlots);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgdurationRotationTrainingsitesRel toEntityModel() {
		ProgdurationRotationTrainingsitesRelImpl
			progdurationRotationTrainingsitesRelImpl =
				new ProgdurationRotationTrainingsitesRelImpl();

		if (uuid == null) {
			progdurationRotationTrainingsitesRelImpl.setUuid("");
		}
		else {
			progdurationRotationTrainingsitesRelImpl.setUuid(uuid);
		}

		progdurationRotationTrainingsitesRelImpl.setProgdurationRotationTsRelId(
			progdurationRotationTsRelId);
		progdurationRotationTrainingsitesRelImpl.setProgramDurationId(
			programDurationId);
		progdurationRotationTrainingsitesRelImpl.setRotationId(rotationId);
		progdurationRotationTrainingsitesRelImpl.setTrainingSitesId(
			trainingSitesId);
		progdurationRotationTrainingsitesRelImpl.setGroupId(groupId);
		progdurationRotationTrainingsitesRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			progdurationRotationTrainingsitesRelImpl.setCreateDate(null);
		}
		else {
			progdurationRotationTrainingsitesRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progdurationRotationTrainingsitesRelImpl.setModifiedDate(null);
		}
		else {
			progdurationRotationTrainingsitesRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		progdurationRotationTrainingsitesRelImpl.setCreatedBy(createdBy);
		progdurationRotationTrainingsitesRelImpl.setModifiedBy(modifiedBy);
		progdurationRotationTrainingsitesRelImpl.setIsSharedRotation(
			isSharedRotation);
		progdurationRotationTrainingsitesRelImpl.setRotationOwningProgramId(
			rotationOwningProgramId);

		if (progCodeRsnSiteCode == null) {
			progdurationRotationTrainingsitesRelImpl.setProgCodeRsnSiteCode("");
		}
		else {
			progdurationRotationTrainingsitesRelImpl.setProgCodeRsnSiteCode(
				progCodeRsnSiteCode);
		}

		progdurationRotationTrainingsitesRelImpl.setOwningProgramDurationId(
			owningProgramDurationId);
		progdurationRotationTrainingsitesRelImpl.setNoOfSlots(noOfSlots);

		progdurationRotationTrainingsitesRelImpl.resetOriginalValues();

		return progdurationRotationTrainingsitesRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progdurationRotationTsRelId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		trainingSitesId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		isSharedRotation = objectInput.readBoolean();

		rotationOwningProgramId = objectInput.readLong();
		progCodeRsnSiteCode = objectInput.readUTF();

		owningProgramDurationId = objectInput.readLong();

		noOfSlots = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(progdurationRotationTsRelId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(trainingSitesId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeBoolean(isSharedRotation);

		objectOutput.writeLong(rotationOwningProgramId);

		if (progCodeRsnSiteCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(progCodeRsnSiteCode);
		}

		objectOutput.writeLong(owningProgramDurationId);

		objectOutput.writeInt(noOfSlots);
	}

	public String uuid;
	public long progdurationRotationTsRelId;
	public long programDurationId;
	public long rotationId;
	public long trainingSitesId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdBy;
	public long modifiedBy;
	public boolean isSharedRotation;
	public long rotationOwningProgramId;
	public String progCodeRsnSiteCode;
	public long owningProgramDurationId;
	public int noOfSlots;

}