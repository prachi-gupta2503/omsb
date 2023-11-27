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
 * This class is a wrapper for {@link FacultyIncentive}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyIncentive
 * @generated
 */
public class FacultyIncentiveWrapper
	extends BaseModelWrapper<FacultyIncentive>
	implements FacultyIncentive, ModelWrapper<FacultyIncentive> {

	public FacultyIncentiveWrapper(FacultyIncentive facultyIncentive) {
		super(facultyIncentive);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("FacultyIncentiveId", getFacultyIncentiveId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("roleId", getRoleId());
		attributes.put("amountInOMR", getAmountInOMR());
		attributes.put("applicableForm", getApplicableForm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long FacultyIncentiveId = (Long)attributes.get("FacultyIncentiveId");

		if (FacultyIncentiveId != null) {
			setFacultyIncentiveId(FacultyIncentiveId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long amountInOMR = (Long)attributes.get("amountInOMR");

		if (amountInOMR != null) {
			setAmountInOMR(amountInOMR);
		}

		Date applicableForm = (Date)attributes.get("applicableForm");

		if (applicableForm != null) {
			setApplicableForm(applicableForm);
		}
	}

	@Override
	public FacultyIncentive cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the amount in omr of this faculty incentive.
	 *
	 * @return the amount in omr of this faculty incentive
	 */
	@Override
	public long getAmountInOMR() {
		return model.getAmountInOMR();
	}

	/**
	 * Returns the applicable form of this faculty incentive.
	 *
	 * @return the applicable form of this faculty incentive
	 */
	@Override
	public Date getApplicableForm() {
		return model.getApplicableForm();
	}

	/**
	 * Returns the company ID of this faculty incentive.
	 *
	 * @return the company ID of this faculty incentive
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty incentive.
	 *
	 * @return the create date of this faculty incentive
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the faculty incentive ID of this faculty incentive.
	 *
	 * @return the faculty incentive ID of this faculty incentive
	 */
	@Override
	public long getFacultyIncentiveId() {
		return model.getFacultyIncentiveId();
	}

	/**
	 * Returns the group ID of this faculty incentive.
	 *
	 * @return the group ID of this faculty incentive
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faculty incentive.
	 *
	 * @return the modified date of this faculty incentive
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faculty incentive.
	 *
	 * @return the primary key of this faculty incentive
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this faculty incentive.
	 *
	 * @return the role ID of this faculty incentive
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the uuid of this faculty incentive.
	 *
	 * @return the uuid of this faculty incentive
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
	 * Sets the amount in omr of this faculty incentive.
	 *
	 * @param amountInOMR the amount in omr of this faculty incentive
	 */
	@Override
	public void setAmountInOMR(long amountInOMR) {
		model.setAmountInOMR(amountInOMR);
	}

	/**
	 * Sets the applicable form of this faculty incentive.
	 *
	 * @param applicableForm the applicable form of this faculty incentive
	 */
	@Override
	public void setApplicableForm(Date applicableForm) {
		model.setApplicableForm(applicableForm);
	}

	/**
	 * Sets the company ID of this faculty incentive.
	 *
	 * @param companyId the company ID of this faculty incentive
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty incentive.
	 *
	 * @param createDate the create date of this faculty incentive
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the faculty incentive ID of this faculty incentive.
	 *
	 * @param FacultyIncentiveId the faculty incentive ID of this faculty incentive
	 */
	@Override
	public void setFacultyIncentiveId(long FacultyIncentiveId) {
		model.setFacultyIncentiveId(FacultyIncentiveId);
	}

	/**
	 * Sets the group ID of this faculty incentive.
	 *
	 * @param groupId the group ID of this faculty incentive
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faculty incentive.
	 *
	 * @param modifiedDate the modified date of this faculty incentive
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faculty incentive.
	 *
	 * @param primaryKey the primary key of this faculty incentive
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this faculty incentive.
	 *
	 * @param roleId the role ID of this faculty incentive
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the uuid of this faculty incentive.
	 *
	 * @param uuid the uuid of this faculty incentive
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
	protected FacultyIncentiveWrapper wrap(FacultyIncentive facultyIncentive) {
		return new FacultyIncentiveWrapper(facultyIncentive);
	}

}