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
 * This class is a wrapper for {@link LeaveAnnualRule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualRule
 * @generated
 */
public class LeaveAnnualRuleWrapper
	extends BaseModelWrapper<LeaveAnnualRule>
	implements LeaveAnnualRule, ModelWrapper<LeaveAnnualRule> {

	public LeaveAnnualRuleWrapper(LeaveAnnualRule leaveAnnualRule) {
		super(leaveAnnualRule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveAnnualRuleId", getLeaveAnnualRuleId());
		attributes.put("programMasterId", getProgramMasterId());
		attributes.put("lastDateForSubmission", getLastDateForSubmission());
		attributes.put("annualLeaveAvailableAt", getAnnualLeaveAvailableAt());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long leaveAnnualRuleId = (Long)attributes.get("leaveAnnualRuleId");

		if (leaveAnnualRuleId != null) {
			setLeaveAnnualRuleId(leaveAnnualRuleId);
		}

		Long programMasterId = (Long)attributes.get("programMasterId");

		if (programMasterId != null) {
			setProgramMasterId(programMasterId);
		}

		Date lastDateForSubmission = (Date)attributes.get(
			"lastDateForSubmission");

		if (lastDateForSubmission != null) {
			setLastDateForSubmission(lastDateForSubmission);
		}

		String annualLeaveAvailableAt = (String)attributes.get(
			"annualLeaveAvailableAt");

		if (annualLeaveAvailableAt != null) {
			setAnnualLeaveAvailableAt(annualLeaveAvailableAt);
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
	}

	@Override
	public LeaveAnnualRule cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the annual leave available at of this leave annual rule.
	 *
	 * @return the annual leave available at of this leave annual rule
	 */
	@Override
	public String getAnnualLeaveAvailableAt() {
		return model.getAnnualLeaveAvailableAt();
	}

	/**
	 * Returns the company ID of this leave annual rule.
	 *
	 * @return the company ID of this leave annual rule
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave annual rule.
	 *
	 * @return the create date of this leave annual rule
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave annual rule.
	 *
	 * @return the created by of this leave annual rule
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this leave annual rule.
	 *
	 * @return the group ID of this leave annual rule
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last date for submission of this leave annual rule.
	 *
	 * @return the last date for submission of this leave annual rule
	 */
	@Override
	public Date getLastDateForSubmission() {
		return model.getLastDateForSubmission();
	}

	/**
	 * Returns the leave annual rule ID of this leave annual rule.
	 *
	 * @return the leave annual rule ID of this leave annual rule
	 */
	@Override
	public long getLeaveAnnualRuleId() {
		return model.getLeaveAnnualRuleId();
	}

	/**
	 * Returns the modified by of this leave annual rule.
	 *
	 * @return the modified by of this leave annual rule
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave annual rule.
	 *
	 * @return the modified date of this leave annual rule
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave annual rule.
	 *
	 * @return the primary key of this leave annual rule
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program master ID of this leave annual rule.
	 *
	 * @return the program master ID of this leave annual rule
	 */
	@Override
	public long getProgramMasterId() {
		return model.getProgramMasterId();
	}

	/**
	 * Returns the uuid of this leave annual rule.
	 *
	 * @return the uuid of this leave annual rule
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
	 * Sets the annual leave available at of this leave annual rule.
	 *
	 * @param annualLeaveAvailableAt the annual leave available at of this leave annual rule
	 */
	@Override
	public void setAnnualLeaveAvailableAt(String annualLeaveAvailableAt) {
		model.setAnnualLeaveAvailableAt(annualLeaveAvailableAt);
	}

	/**
	 * Sets the company ID of this leave annual rule.
	 *
	 * @param companyId the company ID of this leave annual rule
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave annual rule.
	 *
	 * @param createDate the create date of this leave annual rule
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave annual rule.
	 *
	 * @param createdBy the created by of this leave annual rule
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave annual rule.
	 *
	 * @param groupId the group ID of this leave annual rule
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last date for submission of this leave annual rule.
	 *
	 * @param lastDateForSubmission the last date for submission of this leave annual rule
	 */
	@Override
	public void setLastDateForSubmission(Date lastDateForSubmission) {
		model.setLastDateForSubmission(lastDateForSubmission);
	}

	/**
	 * Sets the leave annual rule ID of this leave annual rule.
	 *
	 * @param leaveAnnualRuleId the leave annual rule ID of this leave annual rule
	 */
	@Override
	public void setLeaveAnnualRuleId(long leaveAnnualRuleId) {
		model.setLeaveAnnualRuleId(leaveAnnualRuleId);
	}

	/**
	 * Sets the modified by of this leave annual rule.
	 *
	 * @param modifiedBy the modified by of this leave annual rule
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave annual rule.
	 *
	 * @param modifiedDate the modified date of this leave annual rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave annual rule.
	 *
	 * @param primaryKey the primary key of this leave annual rule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program master ID of this leave annual rule.
	 *
	 * @param programMasterId the program master ID of this leave annual rule
	 */
	@Override
	public void setProgramMasterId(long programMasterId) {
		model.setProgramMasterId(programMasterId);
	}

	/**
	 * Sets the uuid of this leave annual rule.
	 *
	 * @param uuid the uuid of this leave annual rule
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
	protected LeaveAnnualRuleWrapper wrap(LeaveAnnualRule leaveAnnualRule) {
		return new LeaveAnnualRuleWrapper(leaveAnnualRule);
	}

}