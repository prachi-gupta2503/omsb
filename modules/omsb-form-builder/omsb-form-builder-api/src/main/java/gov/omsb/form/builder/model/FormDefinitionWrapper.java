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
 * This class is a wrapper for {@link FormDefinition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinition
 * @generated
 */
public class FormDefinitionWrapper
	extends BaseModelWrapper<FormDefinition>
	implements FormDefinition, ModelWrapper<FormDefinition> {

	public FormDefinitionWrapper(FormDefinition formDefinition) {
		super(formDefinition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("formDefinitionId", getFormDefinitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formName", getFormName());
		attributes.put("formTitle", getFormTitle());
		attributes.put("formDescription", getFormDescription());
		attributes.put("formVersion", getFormVersion());
		attributes.put("formConfig", getFormConfig());
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

		Long formDefinitionId = (Long)attributes.get("formDefinitionId");

		if (formDefinitionId != null) {
			setFormDefinitionId(formDefinitionId);
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

		String formName = (String)attributes.get("formName");

		if (formName != null) {
			setFormName(formName);
		}

		String formTitle = (String)attributes.get("formTitle");

		if (formTitle != null) {
			setFormTitle(formTitle);
		}

		String formDescription = (String)attributes.get("formDescription");

		if (formDescription != null) {
			setFormDescription(formDescription);
		}

		String formVersion = (String)attributes.get("formVersion");

		if (formVersion != null) {
			setFormVersion(formVersion);
		}

		String formConfig = (String)attributes.get("formConfig");

		if (formConfig != null) {
			setFormConfig(formConfig);
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
	public FormDefinition cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this form definition.
	 *
	 * @return the company ID of this form definition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this form definition.
	 *
	 * @return the created by of this form definition
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this form definition.
	 *
	 * @return the created date of this form definition
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the form config of this form definition.
	 *
	 * @return the form config of this form definition
	 */
	@Override
	public String getFormConfig() {
		return model.getFormConfig();
	}

	/**
	 * Returns the form definition ID of this form definition.
	 *
	 * @return the form definition ID of this form definition
	 */
	@Override
	public long getFormDefinitionId() {
		return model.getFormDefinitionId();
	}

	/**
	 * Returns the form description of this form definition.
	 *
	 * @return the form description of this form definition
	 */
	@Override
	public String getFormDescription() {
		return model.getFormDescription();
	}

	/**
	 * Returns the form name of this form definition.
	 *
	 * @return the form name of this form definition
	 */
	@Override
	public String getFormName() {
		return model.getFormName();
	}

	/**
	 * Returns the form title of this form definition.
	 *
	 * @return the form title of this form definition
	 */
	@Override
	public String getFormTitle() {
		return model.getFormTitle();
	}

	/**
	 * Returns the form version of this form definition.
	 *
	 * @return the form version of this form definition
	 */
	@Override
	public String getFormVersion() {
		return model.getFormVersion();
	}

	/**
	 * Returns the group ID of this form definition.
	 *
	 * @return the group ID of this form definition
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this form definition.
	 *
	 * @return the modified by of this form definition
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this form definition.
	 *
	 * @return the modified date of this form definition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this form definition.
	 *
	 * @return the primary key of this form definition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this form definition.
	 *
	 * @return the status of this form definition
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this form definition.
	 *
	 * @return the status by user ID of this form definition
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this form definition.
	 *
	 * @return the status by user name of this form definition
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this form definition.
	 *
	 * @return the status by user uuid of this form definition
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this form definition.
	 *
	 * @return the status date of this form definition
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this form definition.
	 *
	 * @return the uuid of this form definition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this form definition is approved.
	 *
	 * @return <code>true</code> if this form definition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this form definition is denied.
	 *
	 * @return <code>true</code> if this form definition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this form definition is a draft.
	 *
	 * @return <code>true</code> if this form definition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this form definition is expired.
	 *
	 * @return <code>true</code> if this form definition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this form definition is inactive.
	 *
	 * @return <code>true</code> if this form definition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this form definition is incomplete.
	 *
	 * @return <code>true</code> if this form definition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this form definition is pending.
	 *
	 * @return <code>true</code> if this form definition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this form definition is scheduled.
	 *
	 * @return <code>true</code> if this form definition is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this form definition.
	 *
	 * @param companyId the company ID of this form definition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this form definition.
	 *
	 * @param createdBy the created by of this form definition
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this form definition.
	 *
	 * @param createdDate the created date of this form definition
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the form config of this form definition.
	 *
	 * @param formConfig the form config of this form definition
	 */
	@Override
	public void setFormConfig(String formConfig) {
		model.setFormConfig(formConfig);
	}

	/**
	 * Sets the form definition ID of this form definition.
	 *
	 * @param formDefinitionId the form definition ID of this form definition
	 */
	@Override
	public void setFormDefinitionId(long formDefinitionId) {
		model.setFormDefinitionId(formDefinitionId);
	}

	/**
	 * Sets the form description of this form definition.
	 *
	 * @param formDescription the form description of this form definition
	 */
	@Override
	public void setFormDescription(String formDescription) {
		model.setFormDescription(formDescription);
	}

	/**
	 * Sets the form name of this form definition.
	 *
	 * @param formName the form name of this form definition
	 */
	@Override
	public void setFormName(String formName) {
		model.setFormName(formName);
	}

	/**
	 * Sets the form title of this form definition.
	 *
	 * @param formTitle the form title of this form definition
	 */
	@Override
	public void setFormTitle(String formTitle) {
		model.setFormTitle(formTitle);
	}

	/**
	 * Sets the form version of this form definition.
	 *
	 * @param formVersion the form version of this form definition
	 */
	@Override
	public void setFormVersion(String formVersion) {
		model.setFormVersion(formVersion);
	}

	/**
	 * Sets the group ID of this form definition.
	 *
	 * @param groupId the group ID of this form definition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this form definition.
	 *
	 * @param modifiedBy the modified by of this form definition
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this form definition.
	 *
	 * @param modifiedDate the modified date of this form definition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this form definition.
	 *
	 * @param primaryKey the primary key of this form definition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this form definition.
	 *
	 * @param status the status of this form definition
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this form definition.
	 *
	 * @param statusByUserId the status by user ID of this form definition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this form definition.
	 *
	 * @param statusByUserName the status by user name of this form definition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this form definition.
	 *
	 * @param statusByUserUuid the status by user uuid of this form definition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this form definition.
	 *
	 * @param statusDate the status date of this form definition
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this form definition.
	 *
	 * @param uuid the uuid of this form definition
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
	protected FormDefinitionWrapper wrap(FormDefinition formDefinition) {
		return new FormDefinitionWrapper(formDefinition);
	}

}