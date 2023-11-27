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
 * This class is a wrapper for {@link EcMemberRequestState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestState
 * @generated
 */
public class EcMemberRequestStateWrapper
	extends BaseModelWrapper<EcMemberRequestState>
	implements EcMemberRequestState, ModelWrapper<EcMemberRequestState> {

	public EcMemberRequestStateWrapper(
		EcMemberRequestState ecMemberRequestState) {

		super(ecMemberRequestState);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ecMemberRequestStateId", getEcMemberRequestStateId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdByRoleId", getCreatedByRoleId());
		attributes.put("ecMemberRequestId", getEcMemberRequestId());
		attributes.put("ecMemberRequestStatusId", getEcMemberRequestStatusId());
		attributes.put("comments", getComments());
		attributes.put("isPublic", isIsPublic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ecMemberRequestStateId = (Long)attributes.get(
			"ecMemberRequestStateId");

		if (ecMemberRequestStateId != null) {
			setEcMemberRequestStateId(ecMemberRequestStateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdByRoleId = (Long)attributes.get("createdByRoleId");

		if (createdByRoleId != null) {
			setCreatedByRoleId(createdByRoleId);
		}

		Long ecMemberRequestId = (Long)attributes.get("ecMemberRequestId");

		if (ecMemberRequestId != null) {
			setEcMemberRequestId(ecMemberRequestId);
		}

		Long ecMemberRequestStatusId = (Long)attributes.get(
			"ecMemberRequestStatusId");

		if (ecMemberRequestStatusId != null) {
			setEcMemberRequestStatusId(ecMemberRequestStatusId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}
	}

	@Override
	public EcMemberRequestState cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comments of this ec member request state.
	 *
	 * @return the comments of this ec member request state
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this ec member request state.
	 *
	 * @return the company ID of this ec member request state
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ec member request state.
	 *
	 * @return the create date of this ec member request state
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this ec member request state.
	 *
	 * @return the created by of this ec member request state
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created by role ID of this ec member request state.
	 *
	 * @return the created by role ID of this ec member request state
	 */
	@Override
	public long getCreatedByRoleId() {
		return model.getCreatedByRoleId();
	}

	/**
	 * Returns the ec member request ID of this ec member request state.
	 *
	 * @return the ec member request ID of this ec member request state
	 */
	@Override
	public long getEcMemberRequestId() {
		return model.getEcMemberRequestId();
	}

	/**
	 * Returns the ec member request state ID of this ec member request state.
	 *
	 * @return the ec member request state ID of this ec member request state
	 */
	@Override
	public long getEcMemberRequestStateId() {
		return model.getEcMemberRequestStateId();
	}

	/**
	 * Returns the ec member request status ID of this ec member request state.
	 *
	 * @return the ec member request status ID of this ec member request state
	 */
	@Override
	public long getEcMemberRequestStatusId() {
		return model.getEcMemberRequestStatusId();
	}

	/**
	 * Returns the group ID of this ec member request state.
	 *
	 * @return the group ID of this ec member request state
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is public of this ec member request state.
	 *
	 * @return the is public of this ec member request state
	 */
	@Override
	public boolean getIsPublic() {
		return model.getIsPublic();
	}

	/**
	 * Returns the modified date of this ec member request state.
	 *
	 * @return the modified date of this ec member request state
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ec member request state.
	 *
	 * @return the primary key of this ec member request state
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this ec member request state.
	 *
	 * @return the uuid of this ec member request state
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this ec member request state is is public.
	 *
	 * @return <code>true</code> if this ec member request state is is public; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsPublic() {
		return model.isIsPublic();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comments of this ec member request state.
	 *
	 * @param comments the comments of this ec member request state
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this ec member request state.
	 *
	 * @param companyId the company ID of this ec member request state
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ec member request state.
	 *
	 * @param createDate the create date of this ec member request state
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this ec member request state.
	 *
	 * @param createdBy the created by of this ec member request state
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created by role ID of this ec member request state.
	 *
	 * @param createdByRoleId the created by role ID of this ec member request state
	 */
	@Override
	public void setCreatedByRoleId(long createdByRoleId) {
		model.setCreatedByRoleId(createdByRoleId);
	}

	/**
	 * Sets the ec member request ID of this ec member request state.
	 *
	 * @param ecMemberRequestId the ec member request ID of this ec member request state
	 */
	@Override
	public void setEcMemberRequestId(long ecMemberRequestId) {
		model.setEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Sets the ec member request state ID of this ec member request state.
	 *
	 * @param ecMemberRequestStateId the ec member request state ID of this ec member request state
	 */
	@Override
	public void setEcMemberRequestStateId(long ecMemberRequestStateId) {
		model.setEcMemberRequestStateId(ecMemberRequestStateId);
	}

	/**
	 * Sets the ec member request status ID of this ec member request state.
	 *
	 * @param ecMemberRequestStatusId the ec member request status ID of this ec member request state
	 */
	@Override
	public void setEcMemberRequestStatusId(long ecMemberRequestStatusId) {
		model.setEcMemberRequestStatusId(ecMemberRequestStatusId);
	}

	/**
	 * Sets the group ID of this ec member request state.
	 *
	 * @param groupId the group ID of this ec member request state
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this ec member request state is is public.
	 *
	 * @param isPublic the is public of this ec member request state
	 */
	@Override
	public void setIsPublic(boolean isPublic) {
		model.setIsPublic(isPublic);
	}

	/**
	 * Sets the modified date of this ec member request state.
	 *
	 * @param modifiedDate the modified date of this ec member request state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ec member request state.
	 *
	 * @param primaryKey the primary key of this ec member request state
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this ec member request state.
	 *
	 * @param uuid the uuid of this ec member request state
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
	protected EcMemberRequestStateWrapper wrap(
		EcMemberRequestState ecMemberRequestState) {

		return new EcMemberRequestStateWrapper(ecMemberRequestState);
	}

}