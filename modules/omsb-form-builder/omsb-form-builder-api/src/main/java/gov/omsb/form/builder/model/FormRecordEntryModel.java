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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FormRecordEntry service. Represents a row in the &quot;df_form_record_entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.form.builder.model.impl.FormRecordEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntry
 * @generated
 */
@ProviderType
public interface FormRecordEntryModel
	extends BaseModel<FormRecordEntry>, ShardedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a form record entry model instance should use the {@link FormRecordEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this form record entry.
	 *
	 * @return the primary key of this form record entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this form record entry.
	 *
	 * @param primaryKey the primary key of this form record entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this form record entry.
	 *
	 * @return the uuid of this form record entry
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this form record entry.
	 *
	 * @param uuid the uuid of this form record entry
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the form record entry ID of this form record entry.
	 *
	 * @return the form record entry ID of this form record entry
	 */
	public long getFormRecordEntryId();

	/**
	 * Sets the form record entry ID of this form record entry.
	 *
	 * @param formRecordEntryId the form record entry ID of this form record entry
	 */
	public void setFormRecordEntryId(long formRecordEntryId);

	/**
	 * Returns the group ID of this form record entry.
	 *
	 * @return the group ID of this form record entry
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this form record entry.
	 *
	 * @param groupId the group ID of this form record entry
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this form record entry.
	 *
	 * @return the company ID of this form record entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this form record entry.
	 *
	 * @param companyId the company ID of this form record entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by of this form record entry.
	 *
	 * @return the created by of this form record entry
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this form record entry.
	 *
	 * @param createdBy the created by of this form record entry
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this form record entry.
	 *
	 * @return the modified by of this form record entry
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this form record entry.
	 *
	 * @param modifiedBy the modified by of this form record entry
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the created date of this form record entry.
	 *
	 * @return the created date of this form record entry
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this form record entry.
	 *
	 * @param createdDate the created date of this form record entry
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this form record entry.
	 *
	 * @return the modified date of this form record entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this form record entry.
	 *
	 * @param modifiedDate the modified date of this form record entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the form definition ID of this form record entry.
	 *
	 * @return the form definition ID of this form record entry
	 */
	public long getFormDefinitionId();

	/**
	 * Sets the form definition ID of this form record entry.
	 *
	 * @param formDefinitionId the form definition ID of this form record entry
	 */
	public void setFormDefinitionId(long formDefinitionId);

	/**
	 * Returns the record ID of this form record entry.
	 *
	 * @return the record ID of this form record entry
	 */
	public long getRecordId();

	/**
	 * Sets the record ID of this form record entry.
	 *
	 * @param recordId the record ID of this form record entry
	 */
	public void setRecordId(long recordId);

	/**
	 * Returns the df table name of this form record entry.
	 *
	 * @return the df table name of this form record entry
	 */
	@AutoEscape
	public String getDfTableName();

	/**
	 * Sets the df table name of this form record entry.
	 *
	 * @param dfTableName the df table name of this form record entry
	 */
	public void setDfTableName(String dfTableName);

	/**
	 * Returns the status of this form record entry.
	 *
	 * @return the status of this form record entry
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this form record entry.
	 *
	 * @param status the status of this form record entry
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this form record entry.
	 *
	 * @return the status by user ID of this form record entry
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this form record entry.
	 *
	 * @param statusByUserId the status by user ID of this form record entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this form record entry.
	 *
	 * @return the status by user uuid of this form record entry
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this form record entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this form record entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this form record entry.
	 *
	 * @return the status by user name of this form record entry
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this form record entry.
	 *
	 * @param statusByUserName the status by user name of this form record entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this form record entry.
	 *
	 * @return the status date of this form record entry
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this form record entry.
	 *
	 * @param statusDate the status date of this form record entry
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this form record entry is approved.
	 *
	 * @return <code>true</code> if this form record entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this form record entry is denied.
	 *
	 * @return <code>true</code> if this form record entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this form record entry is a draft.
	 *
	 * @return <code>true</code> if this form record entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this form record entry is expired.
	 *
	 * @return <code>true</code> if this form record entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this form record entry is inactive.
	 *
	 * @return <code>true</code> if this form record entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this form record entry is incomplete.
	 *
	 * @return <code>true</code> if this form record entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this form record entry is pending.
	 *
	 * @return <code>true</code> if this form record entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this form record entry is scheduled.
	 *
	 * @return <code>true</code> if this form record entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public FormRecordEntry cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}