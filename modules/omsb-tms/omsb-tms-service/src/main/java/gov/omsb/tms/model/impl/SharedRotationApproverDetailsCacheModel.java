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

import gov.omsb.tms.model.SharedRotationApproverDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SharedRotationApproverDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SharedRotationApproverDetailsCacheModel
	implements CacheModel<SharedRotationApproverDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SharedRotationApproverDetailsCacheModel)) {
			return false;
		}

		SharedRotationApproverDetailsCacheModel
			sharedRotationApproverDetailsCacheModel =
				(SharedRotationApproverDetailsCacheModel)object;

		if (sharedRotationApproverDetailsId ==
				sharedRotationApproverDetailsCacheModel.
					sharedRotationApproverDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sharedRotationApproverDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sharedRotationApproverDetailsId=");
		sb.append(sharedRotationApproverDetailsId);
		sb.append(", sharedRotationRequestDetailsId=");
		sb.append(sharedRotationRequestDetailsId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", approvedTrainees=");
		sb.append(approvedTrainees);
		sb.append(", rejectedTrainees=");
		sb.append(rejectedTrainees);
		sb.append(", approversComment=");
		sb.append(approversComment);
		sb.append(", decisionMakingDate=");
		sb.append(decisionMakingDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SharedRotationApproverDetails toEntityModel() {
		SharedRotationApproverDetailsImpl sharedRotationApproverDetailsImpl =
			new SharedRotationApproverDetailsImpl();

		if (uuid == null) {
			sharedRotationApproverDetailsImpl.setUuid("");
		}
		else {
			sharedRotationApproverDetailsImpl.setUuid(uuid);
		}

		sharedRotationApproverDetailsImpl.setSharedRotationApproverDetailsId(
			sharedRotationApproverDetailsId);
		sharedRotationApproverDetailsImpl.setSharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
		sharedRotationApproverDetailsImpl.setGroupId(groupId);
		sharedRotationApproverDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			sharedRotationApproverDetailsImpl.setCreateDate(null);
		}
		else {
			sharedRotationApproverDetailsImpl.setCreateDate(
				new Date(createDate));
		}

		sharedRotationApproverDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			sharedRotationApproverDetailsImpl.setModifiedDate(null);
		}
		else {
			sharedRotationApproverDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		sharedRotationApproverDetailsImpl.setModifiedBy(modifiedBy);

		if (status == null) {
			sharedRotationApproverDetailsImpl.setStatus("");
		}
		else {
			sharedRotationApproverDetailsImpl.setStatus(status);
		}

		sharedRotationApproverDetailsImpl.setApprovedTrainees(approvedTrainees);
		sharedRotationApproverDetailsImpl.setRejectedTrainees(rejectedTrainees);

		if (approversComment == null) {
			sharedRotationApproverDetailsImpl.setApproversComment("");
		}
		else {
			sharedRotationApproverDetailsImpl.setApproversComment(
				approversComment);
		}

		if (decisionMakingDate == Long.MIN_VALUE) {
			sharedRotationApproverDetailsImpl.setDecisionMakingDate(null);
		}
		else {
			sharedRotationApproverDetailsImpl.setDecisionMakingDate(
				new Date(decisionMakingDate));
		}

		sharedRotationApproverDetailsImpl.resetOriginalValues();

		return sharedRotationApproverDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sharedRotationApproverDetailsId = objectInput.readLong();

		sharedRotationRequestDetailsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		status = objectInput.readUTF();

		approvedTrainees = objectInput.readLong();

		rejectedTrainees = objectInput.readLong();
		approversComment = objectInput.readUTF();
		decisionMakingDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sharedRotationApproverDetailsId);

		objectOutput.writeLong(sharedRotationRequestDetailsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(approvedTrainees);

		objectOutput.writeLong(rejectedTrainees);

		if (approversComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(approversComment);
		}

		objectOutput.writeLong(decisionMakingDate);
	}

	public String uuid;
	public long sharedRotationApproverDetailsId;
	public long sharedRotationRequestDetailsId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String status;
	public long approvedTrainees;
	public long rejectedTrainees;
	public String approversComment;
	public long decisionMakingDate;

}