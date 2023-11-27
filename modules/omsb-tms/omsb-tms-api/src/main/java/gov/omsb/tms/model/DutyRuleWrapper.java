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
 * This class is a wrapper for {@link DutyRule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyRule
 * @generated
 */
public class DutyRuleWrapper
	extends BaseModelWrapper<DutyRule>
	implements DutyRule, ModelWrapper<DutyRule> {

	public DutyRuleWrapper(DutyRule dutyRule) {
		super(dutyRule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dutyRuleId", getDutyRuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("rule", getRule());
		attributes.put("description", getDescription());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dutyRuleId = (Long)attributes.get("dutyRuleId");

		if (dutyRuleId != null) {
			setDutyRuleId(dutyRuleId);
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

		String rule = (String)attributes.get("rule");

		if (rule != null) {
			setRule(rule);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public DutyRule cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this duty rule.
	 *
	 * @return the company ID of this duty rule
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this duty rule.
	 *
	 * @return the create date of this duty rule
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this duty rule.
	 *
	 * @return the created by of this duty rule
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the description of this duty rule.
	 *
	 * @return the description of this duty rule
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the duty rule ID of this duty rule.
	 *
	 * @return the duty rule ID of this duty rule
	 */
	@Override
	public long getDutyRuleId() {
		return model.getDutyRuleId();
	}

	/**
	 * Returns the group ID of this duty rule.
	 *
	 * @return the group ID of this duty rule
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this duty rule.
	 *
	 * @return the modified by of this duty rule
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this duty rule.
	 *
	 * @return the modified date of this duty rule
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the parent ID of this duty rule.
	 *
	 * @return the parent ID of this duty rule
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this duty rule.
	 *
	 * @return the primary key of this duty rule
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule of this duty rule.
	 *
	 * @return the rule of this duty rule
	 */
	@Override
	public String getRule() {
		return model.getRule();
	}

	/**
	 * Returns the uuid of this duty rule.
	 *
	 * @return the uuid of this duty rule
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
	 * Sets the company ID of this duty rule.
	 *
	 * @param companyId the company ID of this duty rule
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this duty rule.
	 *
	 * @param createDate the create date of this duty rule
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this duty rule.
	 *
	 * @param createdBy the created by of this duty rule
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the description of this duty rule.
	 *
	 * @param description the description of this duty rule
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the duty rule ID of this duty rule.
	 *
	 * @param dutyRuleId the duty rule ID of this duty rule
	 */
	@Override
	public void setDutyRuleId(long dutyRuleId) {
		model.setDutyRuleId(dutyRuleId);
	}

	/**
	 * Sets the group ID of this duty rule.
	 *
	 * @param groupId the group ID of this duty rule
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this duty rule.
	 *
	 * @param modifiedBy the modified by of this duty rule
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this duty rule.
	 *
	 * @param modifiedDate the modified date of this duty rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent ID of this duty rule.
	 *
	 * @param parentId the parent ID of this duty rule
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this duty rule.
	 *
	 * @param primaryKey the primary key of this duty rule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule of this duty rule.
	 *
	 * @param rule the rule of this duty rule
	 */
	@Override
	public void setRule(String rule) {
		model.setRule(rule);
	}

	/**
	 * Sets the uuid of this duty rule.
	 *
	 * @param uuid the uuid of this duty rule
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
	protected DutyRuleWrapper wrap(DutyRule dutyRule) {
		return new DutyRuleWrapper(dutyRule);
	}

}