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

package gov.omsb.form.builder.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormRecordEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntry
 * @generated
 */
public class FormRecordEntryWrapper
	extends BaseModelWrapper<FormRecordEntry>
	implements FormRecordEntry, ModelWrapper<FormRecordEntry> {

	public FormRecordEntryWrapper(FormRecordEntry formRecordEntry) {
		super(formRecordEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("formRecordEntryId", getFormRecordEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formDefinitionId", getFormDefinitionId());
		attributes.put("recordId", getRecordId());
		attributes.put("dfTableName", getDfTableName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long formRecordEntryId = (Long)attributes.get("formRecordEntryId");

		if (formRecordEntryId != null) {
			setFormRecordEntryId(formRecordEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long formDefinitionId = (Long)attributes.get("formDefinitionId");

		if (formDefinitionId != null) {
			setFormDefinitionId(formDefinitionId);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		String dfTableName = (String)attributes.get("dfTableName");

		if (dfTableName != null) {
			setDfTableName(dfTableName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public FormRecordEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this form record entry.
	 *
	 * @return the company ID of this form record entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this form record entry.
	 *
	 * @return the created by of this form record entry
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this form record entry.
	 *
	 * @return the created date of this form record entry
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the df table name of this form record entry.
	 *
	 * @return the df table name of this form record entry
	 */
	@Override
	public String getDfTableName() {
		return model.getDfTableName();
	}

	/**
	 * Returns the form definition ID of this form record entry.
	 *
	 * @return the form definition ID of this form record entry
	 */
	@Override
	public long getFormDefinitionId() {
		return model.getFormDefinitionId();
	}

	/**
	 * Returns the form record entry ID of this form record entry.
	 *
	 * @return the form record entry ID of this form record entry
	 */
	@Override
	public long getFormRecordEntryId() {
		return model.getFormRecordEntryId();
	}

	/**
	 * Returns the group ID of this form record entry.
	 *
	 * @return the group ID of this form record entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this form record entry.
	 *
	 * @return the modified by of this form record entry
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this form record entry.
	 *
	 * @return the modified date of this form record entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this form record entry.
	 *
	 * @return the primary key of this form record entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the record ID of this form record entry.
	 *
	 * @return the record ID of this form record entry
	 */
	@Override
	public long getRecordId() {
		return model.getRecordId();
	}

	/**
	 * Returns the status of this form record entry.
	 *
	 * @return the status of this form record entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this form record entry.
	 *
	 * @return the status by user ID of this form record entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this form record entry.
	 *
	 * @return the status by user name of this form record entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this form record entry.
	 *
	 * @return the status by user uuid of this form record entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this form record entry.
	 *
	 * @return the status date of this form record entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this form record entry.
	 *
	 * @return the uuid of this form record entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this form record entry is approved.
	 *
	 * @return <code>true</code> if this form record entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this form record entry is denied.
	 *
	 * @return <code>true</code> if this form record entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this form record entry is a draft.
	 *
	 * @return <code>true</code> if this form record entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this form record entry is expired.
	 *
	 * @return <code>true</code> if this form record entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this form record entry is inactive.
	 *
	 * @return <code>true</code> if this form record entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this form record entry is incomplete.
	 *
	 * @return <code>true</code> if this form record entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this form record entry is pending.
	 *
	 * @return <code>true</code> if this form record entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this form record entry is scheduled.
	 *
	 * @return <code>true</code> if this form record entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this form record entry.
	 *
	 * @param companyId the company ID of this form record entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this form record entry.
	 *
	 * @param createdBy the created by of this form record entry
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this form record entry.
	 *
	 * @param createdDate the created date of this form record entry
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the df table name of this form record entry.
	 *
	 * @param dfTableName the df table name of this form record entry
	 */
	@Override
	public void setDfTableName(String dfTableName) {
		model.setDfTableName(dfTableName);
	}

	/**
	 * Sets the form definition ID of this form record entry.
	 *
	 * @param formDefinitionId the form definition ID of this form record entry
	 */
	@Override
	public void setFormDefinitionId(long formDefinitionId) {
		model.setFormDefinitionId(formDefinitionId);
	}

	/**
	 * Sets the form record entry ID of this form record entry.
	 *
	 * @param formRecordEntryId the form record entry ID of this form record entry
	 */
	@Override
	public void setFormRecordEntryId(long formRecordEntryId) {
		model.setFormRecordEntryId(formRecordEntryId);
	}

	/**
	 * Sets the group ID of this form record entry.
	 *
	 * @param groupId the group ID of this form record entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this form record entry.
	 *
	 * @param modifiedBy the modified by of this form record entry
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this form record entry.
	 *
	 * @param modifiedDate the modified date of this form record entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this form record entry.
	 *
	 * @param primaryKey the primary key of this form record entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record ID of this form record entry.
	 *
	 * @param recordId the record ID of this form record entry
	 */
	@Override
	public void setRecordId(long recordId) {
		model.setRecordId(recordId);
	}

	/**
	 * Sets the status of this form record entry.
	 *
	 * @param status the status of this form record entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this form record entry.
	 *
	 * @param statusByUserId the status by user ID of this form record entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this form record entry.
	 *
	 * @param statusByUserName the status by user name of this form record entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this form record entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this form record entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this form record entry.
	 *
	 * @param statusDate the status date of this form record entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this form record entry.
	 *
	 * @param uuid the uuid of this form record entry
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
	protected FormRecordEntryWrapper wrap(FormRecordEntry formRecordEntry) {
		return new FormRecordEntryWrapper(formRecordEntry);
	}

}