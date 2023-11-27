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

import gov.omsb.tms.model.EcMemberRequestState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EcMemberRequestState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EcMemberRequestStateCacheModel
	implements CacheModel<EcMemberRequestState>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EcMemberRequestStateCacheModel)) {
			return false;
		}

		EcMemberRequestStateCacheModel ecMemberRequestStateCacheModel =
			(EcMemberRequestStateCacheModel)object;

		if (ecMemberRequestStateId ==
				ecMemberRequestStateCacheModel.ecMemberRequestStateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecMemberRequestStateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ecMemberRequestStateId=");
		sb.append(ecMemberRequestStateId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdByRoleId=");
		sb.append(createdByRoleId);
		sb.append(", ecMemberRequestId=");
		sb.append(ecMemberRequestId);
		sb.append(", ecMemberRequestStatusId=");
		sb.append(ecMemberRequestStatusId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", isPublic=");
		sb.append(isPublic);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcMemberRequestState toEntityModel() {
		EcMemberRequestStateImpl ecMemberRequestStateImpl =
			new EcMemberRequestStateImpl();

		if (uuid == null) {
			ecMemberRequestStateImpl.setUuid("");
		}
		else {
			ecMemberRequestStateImpl.setUuid(uuid);
		}

		ecMemberRequestStateImpl.setEcMemberRequestStateId(
			ecMemberRequestStateId);
		ecMemberRequestStateImpl.setGroupId(groupId);
		ecMemberRequestStateImpl.setCreatedBy(createdBy);
		ecMemberRequestStateImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ecMemberRequestStateImpl.setCreateDate(null);
		}
		else {
			ecMemberRequestStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ecMemberRequestStateImpl.setModifiedDate(null);
		}
		else {
			ecMemberRequestStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		ecMemberRequestStateImpl.setCreatedByRoleId(createdByRoleId);
		ecMemberRequestStateImpl.setEcMemberRequestId(ecMemberRequestId);
		ecMemberRequestStateImpl.setEcMemberRequestStatusId(
			ecMemberRequestStatusId);

		if (comments == null) {
			ecMemberRequestStateImpl.setComments("");
		}
		else {
			ecMemberRequestStateImpl.setComments(comments);
		}

		ecMemberRequestStateImpl.setIsPublic(isPublic);

		ecMemberRequestStateImpl.resetOriginalValues();

		return ecMemberRequestStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ecMemberRequestStateId = objectInput.readLong();

		groupId = objectInput.readLong();

		createdBy = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByRoleId = objectInput.readLong();

		ecMemberRequestId = objectInput.readLong();

		ecMemberRequestStatusId = objectInput.readLong();
		comments = objectInput.readUTF();

		isPublic = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ecMemberRequestStateId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByRoleId);

		objectOutput.writeLong(ecMemberRequestId);

		objectOutput.writeLong(ecMemberRequestStatusId);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeBoolean(isPublic);
	}

	public String uuid;
	public long ecMemberRequestStateId;
	public long groupId;
	public long createdBy;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long createdByRoleId;
	public long ecMemberRequestId;
	public long ecMemberRequestStatusId;
	public String comments;
	public boolean isPublic;

}