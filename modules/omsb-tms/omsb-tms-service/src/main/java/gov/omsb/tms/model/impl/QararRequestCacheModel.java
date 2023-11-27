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

import gov.omsb.tms.model.QararRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QararRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QararRequestCacheModel
	implements CacheModel<QararRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QararRequestCacheModel)) {
			return false;
		}

		QararRequestCacheModel qararRequestCacheModel =
			(QararRequestCacheModel)object;

		if (qararRequestId == qararRequestCacheModel.qararRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, qararRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", qararRequestId=");
		sb.append(qararRequestId);
		sb.append(", referenceId=");
		sb.append(referenceId);
		sb.append(", referenceClass=");
		sb.append(referenceClass);
		sb.append(", qararType=");
		sb.append(qararType);
		sb.append(", docTreeId=");
		sb.append(docTreeId);
		sb.append(", docURL=");
		sb.append(docURL);
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
		sb.append(", qararDocId=");
		sb.append(qararDocId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QararRequest toEntityModel() {
		QararRequestImpl qararRequestImpl = new QararRequestImpl();

		if (uuid == null) {
			qararRequestImpl.setUuid("");
		}
		else {
			qararRequestImpl.setUuid(uuid);
		}

		qararRequestImpl.setQararRequestId(qararRequestId);
		qararRequestImpl.setReferenceId(referenceId);

		if (referenceClass == null) {
			qararRequestImpl.setReferenceClass("");
		}
		else {
			qararRequestImpl.setReferenceClass(referenceClass);
		}

		if (qararType == null) {
			qararRequestImpl.setQararType("");
		}
		else {
			qararRequestImpl.setQararType(qararType);
		}

		qararRequestImpl.setDocTreeId(docTreeId);

		if (docURL == null) {
			qararRequestImpl.setDocURL("");
		}
		else {
			qararRequestImpl.setDocURL(docURL);
		}

		qararRequestImpl.setGroupId(groupId);
		qararRequestImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			qararRequestImpl.setCreateDate(null);
		}
		else {
			qararRequestImpl.setCreateDate(new Date(createDate));
		}

		qararRequestImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			qararRequestImpl.setModifiedDate(null);
		}
		else {
			qararRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		qararRequestImpl.setModifiedBy(modifiedBy);
		qararRequestImpl.setQararDocId(qararDocId);

		qararRequestImpl.resetOriginalValues();

		return qararRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		qararRequestId = objectInput.readLong();

		referenceId = objectInput.readLong();
		referenceClass = objectInput.readUTF();
		qararType = objectInput.readUTF();

		docTreeId = objectInput.readLong();
		docURL = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		qararDocId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(qararRequestId);

		objectOutput.writeLong(referenceId);

		if (referenceClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceClass);
		}

		if (qararType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qararType);
		}

		objectOutput.writeLong(docTreeId);

		if (docURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docURL);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(qararDocId);
	}

	public String uuid;
	public long qararRequestId;
	public long referenceId;
	public String referenceClass;
	public String qararType;
	public long docTreeId;
	public String docURL;
	public long groupId;
	public long companyId;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long qararDocId;

}