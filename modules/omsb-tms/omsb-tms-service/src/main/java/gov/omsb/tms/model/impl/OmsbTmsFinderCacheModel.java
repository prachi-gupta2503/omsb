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

import gov.omsb.tms.model.OmsbTmsFinder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OmsbTmsFinder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OmsbTmsFinderCacheModel
	implements CacheModel<OmsbTmsFinder>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OmsbTmsFinderCacheModel)) {
			return false;
		}

		OmsbTmsFinderCacheModel omsbTmsFinderCacheModel =
			(OmsbTmsFinderCacheModel)object;

		if (omsbTmsFinderId == omsbTmsFinderCacheModel.omsbTmsFinderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, omsbTmsFinderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", omsbTmsFinderId=");
		sb.append(omsbTmsFinderId);
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
	public OmsbTmsFinder toEntityModel() {
		OmsbTmsFinderImpl omsbTmsFinderImpl = new OmsbTmsFinderImpl();

		if (uuid == null) {
			omsbTmsFinderImpl.setUuid("");
		}
		else {
			omsbTmsFinderImpl.setUuid(uuid);
		}

		omsbTmsFinderImpl.setOmsbTmsFinderId(omsbTmsFinderId);
		omsbTmsFinderImpl.setGroupId(groupId);
		omsbTmsFinderImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			omsbTmsFinderImpl.setCreateDate(null);
		}
		else {
			omsbTmsFinderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			omsbTmsFinderImpl.setModifiedDate(null);
		}
		else {
			omsbTmsFinderImpl.setModifiedDate(new Date(modifiedDate));
		}

		omsbTmsFinderImpl.resetOriginalValues();

		return omsbTmsFinderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		omsbTmsFinderId = objectInput.readLong();

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

		objectOutput.writeLong(omsbTmsFinderId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long omsbTmsFinderId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}