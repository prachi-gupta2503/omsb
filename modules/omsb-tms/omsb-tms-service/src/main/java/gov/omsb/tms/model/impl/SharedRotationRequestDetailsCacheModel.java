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

import gov.omsb.tms.model.SharedRotationRequestDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SharedRotationRequestDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SharedRotationRequestDetailsCacheModel
	implements CacheModel<SharedRotationRequestDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SharedRotationRequestDetailsCacheModel)) {
			return false;
		}

		SharedRotationRequestDetailsCacheModel
			sharedRotationRequestDetailsCacheModel =
				(SharedRotationRequestDetailsCacheModel)object;

		if (sharedRotationRequestDetailsId ==
				sharedRotationRequestDetailsCacheModel.
					sharedRotationRequestDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sharedRotationRequestDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sharedRotationRequestDetailsId=");
		sb.append(sharedRotationRequestDetailsId);
		sb.append(", programDurationId=");
		sb.append(programDurationId);
		sb.append(", rotationId=");
		sb.append(rotationId);
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
		sb.append(", noOfTraineesRequested=");
		sb.append(noOfTraineesRequested);
		sb.append(", requesterComment=");
		sb.append(requesterComment);
		sb.append(", status=");
		sb.append(status);
		sb.append(", approvedCount=");
		sb.append(approvedCount);
		sb.append(", rejectedCount=");
		sb.append(rejectedCount);
		sb.append(", requestRaisedTo=");
		sb.append(requestRaisedTo);
		sb.append(", requestRaisedBy=");
		sb.append(requestRaisedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SharedRotationRequestDetails toEntityModel() {
		SharedRotationRequestDetailsImpl sharedRotationRequestDetailsImpl =
			new SharedRotationRequestDetailsImpl();

		if (uuid == null) {
			sharedRotationRequestDetailsImpl.setUuid("");
		}
		else {
			sharedRotationRequestDetailsImpl.setUuid(uuid);
		}

		sharedRotationRequestDetailsImpl.setSharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
		sharedRotationRequestDetailsImpl.setProgramDurationId(
			programDurationId);
		sharedRotationRequestDetailsImpl.setRotationId(rotationId);
		sharedRotationRequestDetailsImpl.setGroupId(groupId);
		sharedRotationRequestDetailsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			sharedRotationRequestDetailsImpl.setCreateDate(null);
		}
		else {
			sharedRotationRequestDetailsImpl.setCreateDate(
				new Date(createDate));
		}

		sharedRotationRequestDetailsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			sharedRotationRequestDetailsImpl.setModifiedDate(null);
		}
		else {
			sharedRotationRequestDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		sharedRotationRequestDetailsImpl.setModifiedBy(modifiedBy);
		sharedRotationRequestDetailsImpl.setNoOfTraineesRequested(
			noOfTraineesRequested);

		if (requesterComment == null) {
			sharedRotationRequestDetailsImpl.setRequesterComment("");
		}
		else {
			sharedRotationRequestDetailsImpl.setRequesterComment(
				requesterComment);
		}

		if (status == null) {
			sharedRotationRequestDetailsImpl.setStatus("");
		}
		else {
			sharedRotationRequestDetailsImpl.setStatus(status);
		}

		sharedRotationRequestDetailsImpl.setApprovedCount(approvedCount);
		sharedRotationRequestDetailsImpl.setRejectedCount(rejectedCount);

		if (requestRaisedTo == null) {
			sharedRotationRequestDetailsImpl.setRequestRaisedTo("");
		}
		else {
			sharedRotationRequestDetailsImpl.setRequestRaisedTo(
				requestRaisedTo);
		}

		if (requestRaisedBy == null) {
			sharedRotationRequestDetailsImpl.setRequestRaisedBy("");
		}
		else {
			sharedRotationRequestDetailsImpl.setRequestRaisedBy(
				requestRaisedBy);
		}

		sharedRotationRequestDetailsImpl.resetOriginalValues();

		return sharedRotationRequestDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sharedRotationRequestDetailsId = objectInput.readLong();

		programDurationId = objectInput.readLong();

		rotationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		noOfTraineesRequested = objectInput.readLong();
		requesterComment = objectInput.readUTF();
		status = objectInput.readUTF();

		approvedCount = objectInput.readLong();

		rejectedCount = objectInput.readLong();
		requestRaisedTo = objectInput.readUTF();
		requestRaisedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sharedRotationRequestDetailsId);

		objectOutput.writeLong(programDurationId);

		objectOutput.writeLong(rotationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(noOfTraineesRequested);

		if (requesterComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requesterComment);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(approvedCount);

		objectOutput.writeLong(rejectedCount);

		if (requestRaisedTo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestRaisedTo);
		}

		if (requestRaisedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestRaisedBy);
		}
	}

	public String uuid;
	public long sharedRotationRequestDetailsId;
	public long programDurationId;
	public long rotationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long noOfTraineesRequested;
	public String requesterComment;
	public String status;
	public long approvedCount;
	public long rejectedCount;
	public String requestRaisedTo;
	public String requestRaisedBy;

}