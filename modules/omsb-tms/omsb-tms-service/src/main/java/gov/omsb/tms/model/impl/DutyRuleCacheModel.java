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

import gov.omsb.tms.model.DutyRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DutyRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DutyRuleCacheModel
	implements CacheModel<DutyRule>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyRuleCacheModel)) {
			return false;
		}

		DutyRuleCacheModel dutyRuleCacheModel = (DutyRuleCacheModel)object;

		if (dutyRuleId == dutyRuleCacheModel.dutyRuleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dutyRuleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dutyRuleId=");
		sb.append(dutyRuleId);
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
		sb.append(", rule=");
		sb.append(rule);
		sb.append(", description=");
		sb.append(description);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DutyRule toEntityModel() {
		DutyRuleImpl dutyRuleImpl = new DutyRuleImpl();

		if (uuid == null) {
			dutyRuleImpl.setUuid("");
		}
		else {
			dutyRuleImpl.setUuid(uuid);
		}

		dutyRuleImpl.setDutyRuleId(dutyRuleId);
		dutyRuleImpl.setGroupId(groupId);
		dutyRuleImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dutyRuleImpl.setCreateDate(null);
		}
		else {
			dutyRuleImpl.setCreateDate(new Date(createDate));
		}

		dutyRuleImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dutyRuleImpl.setModifiedDate(null);
		}
		else {
			dutyRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		dutyRuleImpl.setModifiedBy(modifiedBy);

		if (rule == null) {
			dutyRuleImpl.setRule("");
		}
		else {
			dutyRuleImpl.setRule(rule);
		}

		if (description == null) {
			dutyRuleImpl.setDescription("");
		}
		else {
			dutyRuleImpl.setDescription(description);
		}

		dutyRuleImpl.setParentId(parentId);

		dutyRuleImpl.resetOriginalValues();

		return dutyRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dutyRuleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		rule = objectInput.readUTF();
		description = objectInput.readUTF();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dutyRuleId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (rule == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rule);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public long dutyRuleId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public String rule;
	public String description;
	public long parentId;

}