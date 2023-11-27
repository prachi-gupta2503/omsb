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

import gov.omsb.tms.model.ProgramDurationDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramDurationDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramDurationDetailsCacheModel
	implements CacheModel<ProgramDurationDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramDurationDetailsCacheModel)) {
			return false;
		}

		ProgramDurationDetailsCacheModel programDurationDetailsCacheModel =
			(ProgramDurationDetailsCacheModel)object;

		if (progDurationId == programDurationDetailsCacheModel.progDurationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, progDurationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", progDurationId=");
		sb.append(progDurationId);
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ayApplicableForm=");
		sb.append(ayApplicableForm);
		sb.append(", noOfBlocks=");
		sb.append(noOfBlocks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramDurationDetails toEntityModel() {
		ProgramDurationDetailsImpl programDurationDetailsImpl =
			new ProgramDurationDetailsImpl();

		if (uuid == null) {
			programDurationDetailsImpl.setUuid("");
		}
		else {
			programDurationDetailsImpl.setUuid(uuid);
		}

		programDurationDetailsImpl.setProgDurationId(progDurationId);
		programDurationDetailsImpl.setProgramId(programId);
		programDurationDetailsImpl.setGroupId(groupId);
		programDurationDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programDurationDetailsImpl.setCreateDate(null);
		}
		else {
			programDurationDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			programDurationDetailsImpl.setModifiedDate(null);
		}
		else {
			programDurationDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ayApplicableForm == null) {
			programDurationDetailsImpl.setAyApplicableForm("");
		}
		else {
			programDurationDetailsImpl.setAyApplicableForm(ayApplicableForm);
		}

		programDurationDetailsImpl.setNoOfBlocks(noOfBlocks);

		programDurationDetailsImpl.resetOriginalValues();

		return programDurationDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		progDurationId = objectInput.readLong();

		programId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ayApplicableForm = objectInput.readUTF();

		noOfBlocks = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(progDurationId);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (ayApplicableForm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ayApplicableForm);
		}

		objectOutput.writeInt(noOfBlocks);
	}

	public String uuid;
	public long progDurationId;
	public long programId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String ayApplicableForm;
	public int noOfBlocks;

}