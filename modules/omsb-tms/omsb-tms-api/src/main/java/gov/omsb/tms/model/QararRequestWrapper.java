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

package gov.omsb.tms.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QararRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QararRequest
 * @generated
 */
public class QararRequestWrapper
	extends BaseModelWrapper<QararRequest>
	implements ModelWrapper<QararRequest>, QararRequest {

	public QararRequestWrapper(QararRequest qararRequest) {
		super(qararRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("qararRequestId", getQararRequestId());
		attributes.put("referenceId", getReferenceId());
		attributes.put("referenceClass", getReferenceClass());
		attributes.put("qararType", getQararType());
		attributes.put("docTreeId", getDocTreeId());
		attributes.put("docURL", getDocURL());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("qararDocId", getQararDocId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long qararRequestId = (Long)attributes.get("qararRequestId");

		if (qararRequestId != null) {
			setQararRequestId(qararRequestId);
		}

		Long referenceId = (Long)attributes.get("referenceId");

		if (referenceId != null) {
			setReferenceId(referenceId);
		}

		String referenceClass = (String)attributes.get("referenceClass");

		if (referenceClass != null) {
			setReferenceClass(referenceClass);
		}

		String qararType = (String)attributes.get("qararType");

		if (qararType != null) {
			setQararType(qararType);
		}

		Long docTreeId = (Long)attributes.get("docTreeId");

		if (docTreeId != null) {
			setDocTreeId(docTreeId);
		}

		String docURL = (String)attributes.get("docURL");

		if (docURL != null) {
			setDocURL(docURL);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long qararDocId = (Long)attributes.get("qararDocId");

		if (qararDocId != null) {
			setQararDocId(qararDocId);
		}
	}

	@Override
	public QararRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this qarar request.
	 *
	 * @return the company ID of this qarar request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this qarar request.
	 *
	 * @return the create date of this qarar request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this qarar request.
	 *
	 * @return the created by of this qarar request
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the doc tree ID of this qarar request.
	 *
	 * @return the doc tree ID of this qarar request
	 */
	@Override
	public long getDocTreeId() {
		return model.getDocTreeId();
	}

	/**
	 * Returns the doc url of this qarar request.
	 *
	 * @return the doc url of this qarar request
	 */
	@Override
	public String getDocURL() {
		return model.getDocURL();
	}

	/**
	 * Returns the group ID of this qarar request.
	 *
	 * @return the group ID of this qarar request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this qarar request.
	 *
	 * @return the modified by of this qarar request
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this qarar request.
	 *
	 * @return the modified date of this qarar request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this qarar request.
	 *
	 * @return the primary key of this qarar request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qarar doc ID of this qarar request.
	 *
	 * @return the qarar doc ID of this qarar request
	 */
	@Override
	public long getQararDocId() {
		return model.getQararDocId();
	}

	/**
	 * Returns the qarar request ID of this qarar request.
	 *
	 * @return the qarar request ID of this qarar request
	 */
	@Override
	public long getQararRequestId() {
		return model.getQararRequestId();
	}

	/**
	 * Returns the qarar type of this qarar request.
	 *
	 * @return the qarar type of this qarar request
	 */
	@Override
	public String getQararType() {
		return model.getQararType();
	}

	/**
	 * Returns the reference class of this qarar request.
	 *
	 * @return the reference class of this qarar request
	 */
	@Override
	public String getReferenceClass() {
		return model.getReferenceClass();
	}

	/**
	 * Returns the reference ID of this qarar request.
	 *
	 * @return the reference ID of this qarar request
	 */
	@Override
	public long getReferenceId() {
		return model.getReferenceId();
	}

	/**
	 * Returns the uuid of this qarar request.
	 *
	 * @return the uuid of this qarar request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this qarar request.
	 *
	 * @param companyId the company ID of this qarar request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this qarar request.
	 *
	 * @param createDate the create date of this qarar request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this qarar request.
	 *
	 * @param createdBy the created by of this qarar request
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the doc tree ID of this qarar request.
	 *
	 * @param docTreeId the doc tree ID of this qarar request
	 */
	@Override
	public void setDocTreeId(long docTreeId) {
		model.setDocTreeId(docTreeId);
	}

	/**
	 * Sets the doc url of this qarar request.
	 *
	 * @param docURL the doc url of this qarar request
	 */
	@Override
	public void setDocURL(String docURL) {
		model.setDocURL(docURL);
	}

	/**
	 * Sets the group ID of this qarar request.
	 *
	 * @param groupId the group ID of this qarar request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this qarar request.
	 *
	 * @param modifiedBy the modified by of this qarar request
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this qarar request.
	 *
	 * @param modifiedDate the modified date of this qarar request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this qarar request.
	 *
	 * @param primaryKey the primary key of this qarar request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qarar doc ID of this qarar request.
	 *
	 * @param qararDocId the qarar doc ID of this qarar request
	 */
	@Override
	public void setQararDocId(long qararDocId) {
		model.setQararDocId(qararDocId);
	}

	/**
	 * Sets the qarar request ID of this qarar request.
	 *
	 * @param qararRequestId the qarar request ID of this qarar request
	 */
	@Override
	public void setQararRequestId(long qararRequestId) {
		model.setQararRequestId(qararRequestId);
	}

	/**
	 * Sets the qarar type of this qarar request.
	 *
	 * @param qararType the qarar type of this qarar request
	 */
	@Override
	public void setQararType(String qararType) {
		model.setQararType(qararType);
	}

	/**
	 * Sets the reference class of this qarar request.
	 *
	 * @param referenceClass the reference class of this qarar request
	 */
	@Override
	public void setReferenceClass(String referenceClass) {
		model.setReferenceClass(referenceClass);
	}

	/**
	 * Sets the reference ID of this qarar request.
	 *
	 * @param referenceId the reference ID of this qarar request
	 */
	@Override
	public void setReferenceId(long referenceId) {
		model.setReferenceId(referenceId);
	}

	/**
	 * Sets the uuid of this qarar request.
	 *
	 * @param uuid the uuid of this qarar request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected QararRequestWrapper wrap(QararRequest qararRequest) {
		return new QararRequestWrapper(qararRequest);
	}

}