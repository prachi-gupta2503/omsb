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
 * This class is a wrapper for {@link TraineeCohortDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetails
 * @generated
 */
public class TraineeCohortDetailsWrapper
	extends BaseModelWrapper<TraineeCohortDetails>
	implements ModelWrapper<TraineeCohortDetails>, TraineeCohortDetails {

	public TraineeCohortDetailsWrapper(
		TraineeCohortDetails traineeCohortDetails) {

		super(traineeCohortDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("traineeCohortDetailsId", getTraineeCohortDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put(
			"traineeAdmissionDetailsRelId", getTraineeAdmissionDetailsRelId());
		attributes.put("cohortYear", getCohortYear());
		attributes.put("isCurrentCohort", getIsCurrentCohort());
		attributes.put("traineeLevelId", getTraineeLevelId());
		attributes.put("isCurrentTraineeLevel", getIsCurrentTraineeLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeCohortDetailsId = (Long)attributes.get(
			"traineeCohortDetailsId");

		if (traineeCohortDetailsId != null) {
			setTraineeCohortDetailsId(traineeCohortDetailsId);
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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long traineeAdmissionDetailsRelId = (Long)attributes.get(
			"traineeAdmissionDetailsRelId");

		if (traineeAdmissionDetailsRelId != null) {
			setTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
		}

		String cohortYear = (String)attributes.get("cohortYear");

		if (cohortYear != null) {
			setCohortYear(cohortYear);
		}

		Boolean isCurrentCohort = (Boolean)attributes.get("isCurrentCohort");

		if (isCurrentCohort != null) {
			setIsCurrentCohort(isCurrentCohort);
		}

		Long traineeLevelId = (Long)attributes.get("traineeLevelId");

		if (traineeLevelId != null) {
			setTraineeLevelId(traineeLevelId);
		}

		Boolean isCurrentTraineeLevel = (Boolean)attributes.get(
			"isCurrentTraineeLevel");

		if (isCurrentTraineeLevel != null) {
			setIsCurrentTraineeLevel(isCurrentTraineeLevel);
		}
	}

	@Override
	public TraineeCohortDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cohort year of this trainee cohort details.
	 *
	 * @return the cohort year of this trainee cohort details
	 */
	@Override
	public String getCohortYear() {
		return model.getCohortYear();
	}

	/**
	 * Returns the company ID of this trainee cohort details.
	 *
	 * @return the company ID of this trainee cohort details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trainee cohort details.
	 *
	 * @return the create date of this trainee cohort details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee cohort details.
	 *
	 * @return the created by of this trainee cohort details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this trainee cohort details.
	 *
	 * @return the group ID of this trainee cohort details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is current cohort of this trainee cohort details.
	 *
	 * @return the is current cohort of this trainee cohort details
	 */
	@Override
	public Boolean getIsCurrentCohort() {
		return model.getIsCurrentCohort();
	}

	/**
	 * Returns the is current trainee level of this trainee cohort details.
	 *
	 * @return the is current trainee level of this trainee cohort details
	 */
	@Override
	public Boolean getIsCurrentTraineeLevel() {
		return model.getIsCurrentTraineeLevel();
	}

	/**
	 * Returns the modified by of this trainee cohort details.
	 *
	 * @return the modified by of this trainee cohort details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee cohort details.
	 *
	 * @return the modified date of this trainee cohort details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this trainee cohort details.
	 *
	 * @return the primary key of this trainee cohort details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trainee admission details rel ID of this trainee cohort details.
	 *
	 * @return the trainee admission details rel ID of this trainee cohort details
	 */
	@Override
	public long getTraineeAdmissionDetailsRelId() {
		return model.getTraineeAdmissionDetailsRelId();
	}

	/**
	 * Returns the trainee cohort details ID of this trainee cohort details.
	 *
	 * @return the trainee cohort details ID of this trainee cohort details
	 */
	@Override
	public long getTraineeCohortDetailsId() {
		return model.getTraineeCohortDetailsId();
	}

	/**
	 * Returns the trainee level ID of this trainee cohort details.
	 *
	 * @return the trainee level ID of this trainee cohort details
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the uuid of this trainee cohort details.
	 *
	 * @return the uuid of this trainee cohort details
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
	 * Sets the cohort year of this trainee cohort details.
	 *
	 * @param cohortYear the cohort year of this trainee cohort details
	 */
	@Override
	public void setCohortYear(String cohortYear) {
		model.setCohortYear(cohortYear);
	}

	/**
	 * Sets the company ID of this trainee cohort details.
	 *
	 * @param companyId the company ID of this trainee cohort details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trainee cohort details.
	 *
	 * @param createDate the create date of this trainee cohort details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee cohort details.
	 *
	 * @param createdBy the created by of this trainee cohort details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this trainee cohort details.
	 *
	 * @param groupId the group ID of this trainee cohort details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is current cohort of this trainee cohort details.
	 *
	 * @param isCurrentCohort the is current cohort of this trainee cohort details
	 */
	@Override
	public void setIsCurrentCohort(Boolean isCurrentCohort) {
		model.setIsCurrentCohort(isCurrentCohort);
	}

	/**
	 * Sets the is current trainee level of this trainee cohort details.
	 *
	 * @param isCurrentTraineeLevel the is current trainee level of this trainee cohort details
	 */
	@Override
	public void setIsCurrentTraineeLevel(Boolean isCurrentTraineeLevel) {
		model.setIsCurrentTraineeLevel(isCurrentTraineeLevel);
	}

	/**
	 * Sets the modified by of this trainee cohort details.
	 *
	 * @param modifiedBy the modified by of this trainee cohort details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee cohort details.
	 *
	 * @param modifiedDate the modified date of this trainee cohort details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this trainee cohort details.
	 *
	 * @param primaryKey the primary key of this trainee cohort details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trainee admission details rel ID of this trainee cohort details.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID of this trainee cohort details
	 */
	@Override
	public void setTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		model.setTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
	}

	/**
	 * Sets the trainee cohort details ID of this trainee cohort details.
	 *
	 * @param traineeCohortDetailsId the trainee cohort details ID of this trainee cohort details
	 */
	@Override
	public void setTraineeCohortDetailsId(long traineeCohortDetailsId) {
		model.setTraineeCohortDetailsId(traineeCohortDetailsId);
	}

	/**
	 * Sets the trainee level ID of this trainee cohort details.
	 *
	 * @param traineeLevelId the trainee level ID of this trainee cohort details
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the uuid of this trainee cohort details.
	 *
	 * @param uuid the uuid of this trainee cohort details
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
	protected TraineeCohortDetailsWrapper wrap(
		TraineeCohortDetails traineeCohortDetails) {

		return new TraineeCohortDetailsWrapper(traineeCohortDetails);
	}

}