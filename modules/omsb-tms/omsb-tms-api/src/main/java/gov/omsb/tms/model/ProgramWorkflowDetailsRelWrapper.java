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
 * This class is a wrapper for {@link ProgramWorkflowDetailsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRel
 * @generated
 */
public class ProgramWorkflowDetailsRelWrapper
	extends BaseModelWrapper<ProgramWorkflowDetailsRel>
	implements ModelWrapper<ProgramWorkflowDetailsRel>,
			   ProgramWorkflowDetailsRel {

	public ProgramWorkflowDetailsRelWrapper(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		super(programWorkflowDetailsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"programWorkflowDetailsRelId", getProgramWorkflowDetailsRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("programId", getProgramId());
		attributes.put("workflowApprovalOrder", getWorkflowApprovalOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programWorkflowDetailsRelId = (Long)attributes.get(
			"programWorkflowDetailsRelId");

		if (programWorkflowDetailsRelId != null) {
			setProgramWorkflowDetailsRelId(programWorkflowDetailsRelId);
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

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		String workflowApprovalOrder = (String)attributes.get(
			"workflowApprovalOrder");

		if (workflowApprovalOrder != null) {
			setWorkflowApprovalOrder(workflowApprovalOrder);
		}
	}

	@Override
	public ProgramWorkflowDetailsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this program workflow details rel.
	 *
	 * @return the company ID of this program workflow details rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program workflow details rel.
	 *
	 * @return the create date of this program workflow details rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this program workflow details rel.
	 *
	 * @return the created by of this program workflow details rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this program workflow details rel.
	 *
	 * @return the group ID of this program workflow details rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this program workflow details rel.
	 *
	 * @return the modified by of this program workflow details rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this program workflow details rel.
	 *
	 * @return the modified date of this program workflow details rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program workflow details rel.
	 *
	 * @return the primary key of this program workflow details rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ID of this program workflow details rel.
	 *
	 * @return the program ID of this program workflow details rel
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the program workflow details rel ID of this program workflow details rel.
	 *
	 * @return the program workflow details rel ID of this program workflow details rel
	 */
	@Override
	public long getProgramWorkflowDetailsRelId() {
		return model.getProgramWorkflowDetailsRelId();
	}

	/**
	 * Returns the uuid of this program workflow details rel.
	 *
	 * @return the uuid of this program workflow details rel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the workflow approval order of this program workflow details rel.
	 *
	 * @return the workflow approval order of this program workflow details rel
	 */
	@Override
	public String getWorkflowApprovalOrder() {
		return model.getWorkflowApprovalOrder();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this program workflow details rel.
	 *
	 * @param companyId the company ID of this program workflow details rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program workflow details rel.
	 *
	 * @param createDate the create date of this program workflow details rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this program workflow details rel.
	 *
	 * @param createdBy the created by of this program workflow details rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this program workflow details rel.
	 *
	 * @param groupId the group ID of this program workflow details rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this program workflow details rel.
	 *
	 * @param modifiedBy the modified by of this program workflow details rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this program workflow details rel.
	 *
	 * @param modifiedDate the modified date of this program workflow details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program workflow details rel.
	 *
	 * @param primaryKey the primary key of this program workflow details rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ID of this program workflow details rel.
	 *
	 * @param programId the program ID of this program workflow details rel
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the program workflow details rel ID of this program workflow details rel.
	 *
	 * @param programWorkflowDetailsRelId the program workflow details rel ID of this program workflow details rel
	 */
	@Override
	public void setProgramWorkflowDetailsRelId(
		long programWorkflowDetailsRelId) {

		model.setProgramWorkflowDetailsRelId(programWorkflowDetailsRelId);
	}

	/**
	 * Sets the uuid of this program workflow details rel.
	 *
	 * @param uuid the uuid of this program workflow details rel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the workflow approval order of this program workflow details rel.
	 *
	 * @param workflowApprovalOrder the workflow approval order of this program workflow details rel
	 */
	@Override
	public void setWorkflowApprovalOrder(String workflowApprovalOrder) {
		model.setWorkflowApprovalOrder(workflowApprovalOrder);
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
	protected ProgramWorkflowDetailsRelWrapper wrap(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return new ProgramWorkflowDetailsRelWrapper(programWorkflowDetailsRel);
	}

}