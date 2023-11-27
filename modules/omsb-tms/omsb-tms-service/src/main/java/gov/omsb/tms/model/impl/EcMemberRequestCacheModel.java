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

import gov.omsb.tms.model.EcMemberRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EcMemberRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EcMemberRequestCacheModel
	implements CacheModel<EcMemberRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EcMemberRequestCacheModel)) {
			return false;
		}

		EcMemberRequestCacheModel ecMemberRequestCacheModel =
			(EcMemberRequestCacheModel)object;

		if (ecMemberRequestId == ecMemberRequestCacheModel.ecMemberRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecMemberRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ecMemberRequestId=");
		sb.append(ecMemberRequestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", programId=");
		sb.append(programId);
		sb.append(", potentialEcMemberId=");
		sb.append(potentialEcMemberId);
		sb.append(", potentialEcMemberRoleId=");
		sb.append(potentialEcMemberRoleId);
		sb.append(", latestEcMemberRequestStateId=");
		sb.append(latestEcMemberRequestStateId);
		sb.append(", coveringLetterId=");
		sb.append(coveringLetterId);
		sb.append(", cvId=");
		sb.append(cvId);
		sb.append(", noObjectionLetterId=");
		sb.append(noObjectionLetterId);
		sb.append(", passportCopyId=");
		sb.append(passportCopyId);
		sb.append(", nationalIdCopyId=");
		sb.append(nationalIdCopyId);
		sb.append(", qararRequestId=");
		sb.append(qararRequestId);
		sb.append(", qararDocId=");
		sb.append(qararDocId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", potentialEcMemberLruserid=");
		sb.append(potentialEcMemberLruserid);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcMemberRequest toEntityModel() {
		EcMemberRequestImpl ecMemberRequestImpl = new EcMemberRequestImpl();

		if (uuid == null) {
			ecMemberRequestImpl.setUuid("");
		}
		else {
			ecMemberRequestImpl.setUuid(uuid);
		}

		ecMemberRequestImpl.setEcMemberRequestId(ecMemberRequestId);
		ecMemberRequestImpl.setGroupId(groupId);
		ecMemberRequestImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ecMemberRequestImpl.setCreateDate(null);
		}
		else {
			ecMemberRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ecMemberRequestImpl.setModifiedDate(null);
		}
		else {
			ecMemberRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		ecMemberRequestImpl.setProgramId(programId);
		ecMemberRequestImpl.setPotentialEcMemberId(potentialEcMemberId);
		ecMemberRequestImpl.setPotentialEcMemberRoleId(potentialEcMemberRoleId);
		ecMemberRequestImpl.setLatestEcMemberRequestStateId(
			latestEcMemberRequestStateId);
		ecMemberRequestImpl.setCoveringLetterId(coveringLetterId);
		ecMemberRequestImpl.setCvId(cvId);
		ecMemberRequestImpl.setNoObjectionLetterId(noObjectionLetterId);
		ecMemberRequestImpl.setPassportCopyId(passportCopyId);
		ecMemberRequestImpl.setNationalIdCopyId(nationalIdCopyId);
		ecMemberRequestImpl.setQararRequestId(qararRequestId);
		ecMemberRequestImpl.setQararDocId(qararDocId);

		if (comments == null) {
			ecMemberRequestImpl.setComments("");
		}
		else {
			ecMemberRequestImpl.setComments(comments);
		}

		ecMemberRequestImpl.setPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
		ecMemberRequestImpl.setStatus(status);
		ecMemberRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ecMemberRequestImpl.setStatusByUserName("");
		}
		else {
			ecMemberRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ecMemberRequestImpl.setStatusDate(null);
		}
		else {
			ecMemberRequestImpl.setStatusDate(new Date(statusDate));
		}

		if (userName == null) {
			ecMemberRequestImpl.setUserName("");
		}
		else {
			ecMemberRequestImpl.setUserName(userName);
		}

		ecMemberRequestImpl.setUserId(userId);

		ecMemberRequestImpl.resetOriginalValues();

		return ecMemberRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ecMemberRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		programId = objectInput.readLong();

		potentialEcMemberId = objectInput.readLong();

		potentialEcMemberRoleId = objectInput.readLong();

		latestEcMemberRequestStateId = objectInput.readLong();

		coveringLetterId = objectInput.readLong();

		cvId = objectInput.readLong();

		noObjectionLetterId = objectInput.readLong();

		passportCopyId = objectInput.readLong();

		nationalIdCopyId = objectInput.readLong();

		qararRequestId = objectInput.readLong();

		qararDocId = objectInput.readLong();
		comments = objectInput.readUTF();

		potentialEcMemberLruserid = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		userName = objectInput.readUTF();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ecMemberRequestId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(programId);

		objectOutput.writeLong(potentialEcMemberId);

		objectOutput.writeLong(potentialEcMemberRoleId);

		objectOutput.writeLong(latestEcMemberRequestStateId);

		objectOutput.writeLong(coveringLetterId);

		objectOutput.writeLong(cvId);

		objectOutput.writeLong(noObjectionLetterId);

		objectOutput.writeLong(passportCopyId);

		objectOutput.writeLong(nationalIdCopyId);

		objectOutput.writeLong(qararRequestId);

		objectOutput.writeLong(qararDocId);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(potentialEcMemberLruserid);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long ecMemberRequestId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long programId;
	public long potentialEcMemberId;
	public long potentialEcMemberRoleId;
	public long latestEcMemberRequestStateId;
	public long coveringLetterId;
	public long cvId;
	public long noObjectionLetterId;
	public long passportCopyId;
	public long nationalIdCopyId;
	public long qararRequestId;
	public long qararDocId;
	public String comments;
	public long potentialEcMemberLruserid;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String userName;
	public long userId;

}