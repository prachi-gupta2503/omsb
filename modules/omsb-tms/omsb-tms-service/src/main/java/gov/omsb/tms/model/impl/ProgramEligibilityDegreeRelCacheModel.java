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

import gov.omsb.tms.model.ProgramEligibilityDegreeRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramEligibilityDegreeRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramEligibilityDegreeRelCacheModel
	implements CacheModel<ProgramEligibilityDegreeRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramEligibilityDegreeRelCacheModel)) {
			return false;
		}

		ProgramEligibilityDegreeRelCacheModel
			programEligibilityDegreeRelCacheModel =
				(ProgramEligibilityDegreeRelCacheModel)object;

		if (programEdId == programEligibilityDegreeRelCacheModel.programEdId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programEdId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programEdId=");
		sb.append(programEdId);
		sb.append(", programId=");
		sb.append(programId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramEligibilityDegreeRel toEntityModel() {
		ProgramEligibilityDegreeRelImpl programEligibilityDegreeRelImpl =
			new ProgramEligibilityDegreeRelImpl();

		if (uuid == null) {
			programEligibilityDegreeRelImpl.setUuid("");
		}
		else {
			programEligibilityDegreeRelImpl.setUuid(uuid);
		}

		programEligibilityDegreeRelImpl.setProgramEdId(programEdId);
		programEligibilityDegreeRelImpl.setProgramId(programId);
		programEligibilityDegreeRelImpl.setEligibilityDegreeMasterId(
			eligibilityDegreeMasterId);
		programEligibilityDegreeRelImpl.setGroupId(groupId);
		programEligibilityDegreeRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programEligibilityDegreeRelImpl.setCreateDate(null);
		}
		else {
			programEligibilityDegreeRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			programEligibilityDegreeRelImpl.setModifiedDate(null);
		}
		else {
			programEligibilityDegreeRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		programEligibilityDegreeRelImpl.resetOriginalValues();

		return programEligibilityDegreeRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programEdId = objectInput.readLong();

		programId = objectInput.readLong();

		eligibilityDegreeMasterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programEdId);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(eligibilityDegreeMasterId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long programEdId;
	public long programId;
	public long eligibilityDegreeMasterId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}