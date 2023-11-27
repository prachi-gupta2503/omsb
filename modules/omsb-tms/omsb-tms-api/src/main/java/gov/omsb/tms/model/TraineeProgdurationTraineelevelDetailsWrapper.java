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
 * This class is a wrapper for {@link TraineeProgdurationTraineelevelDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetails
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsWrapper
	extends BaseModelWrapper<TraineeProgdurationTraineelevelDetails>
	implements ModelWrapper<TraineeProgdurationTraineelevelDetails>,
			   TraineeProgdurationTraineelevelDetails {

	public TraineeProgdurationTraineelevelDetailsWrapper(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		super(traineeProgdurationTraineelevelDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("traineePdTlErDetailsId", getTraineePdTlErDetailsId());
		attributes.put("traineeId", getTraineeId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("traineeLevelId", getTraineeLevelId());
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

		Long traineePdTlErDetailsId = (Long)attributes.get(
			"traineePdTlErDetailsId");

		if (traineePdTlErDetailsId != null) {
			setTraineePdTlErDetailsId(traineePdTlErDetailsId);
		}

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long traineeLevelId = (Long)attributes.get("traineeLevelId");

		if (traineeLevelId != null) {
			setTraineeLevelId(traineeLevelId);
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
	public TraineeProgdurationTraineelevelDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this trainee progduration traineelevel details.
	 *
	 * @return the company ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trainee progduration traineelevel details.
	 *
	 * @return the create date of this trainee progduration traineelevel details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee progduration traineelevel details.
	 *
	 * @return the created by of this trainee progduration traineelevel details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this trainee progduration traineelevel details.
	 *
	 * @return the group ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee progduration traineelevel details.
	 *
	 * @return the modified by of this trainee progduration traineelevel details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee progduration traineelevel details.
	 *
	 * @return the modified date of this trainee progduration traineelevel details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this trainee progduration traineelevel details.
	 *
	 * @return the primary key of this trainee progduration traineelevel details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this trainee progduration traineelevel details.
	 *
	 * @return the program duration ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the trainee ID of this trainee progduration traineelevel details.
	 *
	 * @return the trainee ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the trainee level ID of this trainee progduration traineelevel details.
	 *
	 * @return the trainee level ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getTraineeLevelId() {
		return model.getTraineeLevelId();
	}

	/**
	 * Returns the trainee pd tl er details ID of this trainee progduration traineelevel details.
	 *
	 * @return the trainee pd tl er details ID of this trainee progduration traineelevel details
	 */
	@Override
	public long getTraineePdTlErDetailsId() {
		return model.getTraineePdTlErDetailsId();
	}

	/**
	 * Returns the uuid of this trainee progduration traineelevel details.
	 *
	 * @return the uuid of this trainee progduration traineelevel details
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
	 * Sets the company ID of this trainee progduration traineelevel details.
	 *
	 * @param companyId the company ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trainee progduration traineelevel details.
	 *
	 * @param createDate the create date of this trainee progduration traineelevel details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee progduration traineelevel details.
	 *
	 * @param createdBy the created by of this trainee progduration traineelevel details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this trainee progduration traineelevel details.
	 *
	 * @param groupId the group ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee progduration traineelevel details.
	 *
	 * @param modifiedBy the modified by of this trainee progduration traineelevel details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee progduration traineelevel details.
	 *
	 * @param modifiedDate the modified date of this trainee progduration traineelevel details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this trainee progduration traineelevel details.
	 *
	 * @param primaryKey the primary key of this trainee progduration traineelevel details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this trainee progduration traineelevel details.
	 *
	 * @param programDurationId the program duration ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the trainee ID of this trainee progduration traineelevel details.
	 *
	 * @param traineeId the trainee ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the trainee level ID of this trainee progduration traineelevel details.
	 *
	 * @param traineeLevelId the trainee level ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		model.setTraineeLevelId(traineeLevelId);
	}

	/**
	 * Sets the trainee pd tl er details ID of this trainee progduration traineelevel details.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID of this trainee progduration traineelevel details
	 */
	@Override
	public void setTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		model.setTraineePdTlErDetailsId(traineePdTlErDetailsId);
	}

	/**
	 * Sets the uuid of this trainee progduration traineelevel details.
	 *
	 * @param uuid the uuid of this trainee progduration traineelevel details
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
	protected TraineeProgdurationTraineelevelDetailsWrapper wrap(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		return new TraineeProgdurationTraineelevelDetailsWrapper(
			traineeProgdurationTraineelevelDetails);
	}

}