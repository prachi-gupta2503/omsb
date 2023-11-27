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

import gov.omsb.tms.model.ProgramWorkflowDetailsRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgramWorkflowDetailsRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramWorkflowDetailsRelCacheModel
	implements CacheModel<ProgramWorkflowDetailsRel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProgramWorkflowDetailsRelCacheModel)) {
			return false;
		}

		ProgramWorkflowDetailsRelCacheModel
			programWorkflowDetailsRelCacheModel =
				(ProgramWorkflowDetailsRelCacheModel)object;

		if (programWorkflowDetailsRelId ==
				programWorkflowDetailsRelCacheModel.
					programWorkflowDetailsRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, programWorkflowDetailsRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", programWorkflowDetailsRelId=");
		sb.append(programWorkflowDetailsRelId);
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
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", workflowApprovalOrder=");
		sb.append(workflowApprovalOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgramWorkflowDetailsRel toEntityModel() {
		ProgramWorkflowDetailsRelImpl programWorkflowDetailsRelImpl =
			new ProgramWorkflowDetailsRelImpl();

		if (uuid == null) {
			programWorkflowDetailsRelImpl.setUuid("");
		}
		else {
			programWorkflowDetailsRelImpl.setUuid(uuid);
		}

		programWorkflowDetailsRelImpl.setProgramWorkflowDetailsRelId(
			programWorkflowDetailsRelId);
		programWorkflowDetailsRelImpl.setGroupId(groupId);
		programWorkflowDetailsRelImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			programWorkflowDetailsRelImpl.setCreateDate(null);
		}
		else {
			programWorkflowDetailsRelImpl.setCreateDate(new Date(createDate));
		}

		programWorkflowDetailsRelImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			programWorkflowDetailsRelImpl.setModifiedDate(null);
		}
		else {
			programWorkflowDetailsRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		programWorkflowDetailsRelImpl.setModifiedBy(modifiedBy);
		programWorkflowDetailsRelImpl.setProgramId(programId);

		if (workflowApprovalOrder == null) {
			programWorkflowDetailsRelImpl.setWorkflowApprovalOrder("");
		}
		else {
			programWorkflowDetailsRelImpl.setWorkflowApprovalOrder(
				workflowApprovalOrder);
		}

		programWorkflowDetailsRelImpl.resetOriginalValues();

		return programWorkflowDetailsRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		programWorkflowDetailsRelId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		programId = objectInput.readLong();
		workflowApprovalOrder = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(programWorkflowDetailsRelId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(programId);

		if (workflowApprovalOrder == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workflowApprovalOrder);
		}
	}

	public String uuid;
	public long programWorkflowDetailsRelId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long programId;
	public String workflowApprovalOrder;

}