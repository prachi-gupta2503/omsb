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
 * This class is a wrapper for {@link ProgramEligibilityDegreeRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramEligibilityDegreeRel
 * @generated
 */
public class ProgramEligibilityDegreeRelWrapper
	extends BaseModelWrapper<ProgramEligibilityDegreeRel>
	implements ModelWrapper<ProgramEligibilityDegreeRel>,
			   ProgramEligibilityDegreeRel {

	public ProgramEligibilityDegreeRelWrapper(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		super(programEligibilityDegreeRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("programEdId", getProgramEdId());
		attributes.put("programId", getProgramId());
		attributes.put(
			"eligibilityDegreeMasterId", getEligibilityDegreeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programEdId = (Long)attributes.get("programEdId");

		if (programEdId != null) {
			setProgramEdId(programEdId);
		}

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		Long eligibilityDegreeMasterId = (Long)attributes.get(
			"eligibilityDegreeMasterId");

		if (eligibilityDegreeMasterId != null) {
			setEligibilityDegreeMasterId(eligibilityDegreeMasterId);
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
	}

	@Override
	public ProgramEligibilityDegreeRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this program eligibility degree rel.
	 *
	 * @return the company ID of this program eligibility degree rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program eligibility degree rel.
	 *
	 * @return the create date of this program eligibility degree rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the eligibility degree master ID of this program eligibility degree rel.
	 *
	 * @return the eligibility degree master ID of this program eligibility degree rel
	 */
	@Override
	public long getEligibilityDegreeMasterId() {
		return model.getEligibilityDegreeMasterId();
	}

	/**
	 * Returns the group ID of this program eligibility degree rel.
	 *
	 * @return the group ID of this program eligibility degree rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this program eligibility degree rel.
	 *
	 * @return the modified date of this program eligibility degree rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program eligibility degree rel.
	 *
	 * @return the primary key of this program eligibility degree rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ed ID of this program eligibility degree rel.
	 *
	 * @return the program ed ID of this program eligibility degree rel
	 */
	@Override
	public long getProgramEdId() {
		return model.getProgramEdId();
	}

	/**
	 * Returns the program ID of this program eligibility degree rel.
	 *
	 * @return the program ID of this program eligibility degree rel
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the uuid of this program eligibility degree rel.
	 *
	 * @return the uuid of this program eligibility degree rel
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
	 * Sets the company ID of this program eligibility degree rel.
	 *
	 * @param companyId the company ID of this program eligibility degree rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program eligibility degree rel.
	 *
	 * @param createDate the create date of this program eligibility degree rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the eligibility degree master ID of this program eligibility degree rel.
	 *
	 * @param eligibilityDegreeMasterId the eligibility degree master ID of this program eligibility degree rel
	 */
	@Override
	public void setEligibilityDegreeMasterId(long eligibilityDegreeMasterId) {
		model.setEligibilityDegreeMasterId(eligibilityDegreeMasterId);
	}

	/**
	 * Sets the group ID of this program eligibility degree rel.
	 *
	 * @param groupId the group ID of this program eligibility degree rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this program eligibility degree rel.
	 *
	 * @param modifiedDate the modified date of this program eligibility degree rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program eligibility degree rel.
	 *
	 * @param primaryKey the primary key of this program eligibility degree rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ed ID of this program eligibility degree rel.
	 *
	 * @param programEdId the program ed ID of this program eligibility degree rel
	 */
	@Override
	public void setProgramEdId(long programEdId) {
		model.setProgramEdId(programEdId);
	}

	/**
	 * Sets the program ID of this program eligibility degree rel.
	 *
	 * @param programId the program ID of this program eligibility degree rel
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the uuid of this program eligibility degree rel.
	 *
	 * @param uuid the uuid of this program eligibility degree rel
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
	protected ProgramEligibilityDegreeRelWrapper wrap(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		return new ProgramEligibilityDegreeRelWrapper(
			programEligibilityDegreeRel);
	}

}