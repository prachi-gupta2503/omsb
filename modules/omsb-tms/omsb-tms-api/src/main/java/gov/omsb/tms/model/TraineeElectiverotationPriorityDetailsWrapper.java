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
 * This class is a wrapper for {@link TraineeElectiverotationPriorityDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetails
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsWrapper
	extends BaseModelWrapper<TraineeElectiverotationPriorityDetails>
	implements ModelWrapper<TraineeElectiverotationPriorityDetails>,
			   TraineeElectiverotationPriorityDetails {

	public TraineeElectiverotationPriorityDetailsWrapper(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		super(traineeElectiverotationPriorityDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"traineeElectiverotationPriorityDetailsId",
			getTraineeElectiverotationPriorityDetailsId());
		attributes.put("traineePdTlErDetailsId", getTraineePdTlErDetailsId());
		attributes.put("rotationId", getRotationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("sequence", getSequence());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeElectiverotationPriorityDetailsId = (Long)attributes.get(
			"traineeElectiverotationPriorityDetailsId");

		if (traineeElectiverotationPriorityDetailsId != null) {
			setTraineeElectiverotationPriorityDetailsId(
				traineeElectiverotationPriorityDetailsId);
		}

		Long traineePdTlErDetailsId = (Long)attributes.get(
			"traineePdTlErDetailsId");

		if (traineePdTlErDetailsId != null) {
			setTraineePdTlErDetailsId(traineePdTlErDetailsId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
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

		Integer sequence = (Integer)attributes.get("sequence");

		if (sequence != null) {
			setSequence(sequence);
		}
	}

	@Override
	public TraineeElectiverotationPriorityDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this trainee electiverotation priority details.
	 *
	 * @return the company ID of this trainee electiverotation priority details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trainee electiverotation priority details.
	 *
	 * @return the create date of this trainee electiverotation priority details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee electiverotation priority details.
	 *
	 * @return the created by of this trainee electiverotation priority details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this trainee electiverotation priority details.
	 *
	 * @return the group ID of this trainee electiverotation priority details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee electiverotation priority details.
	 *
	 * @return the modified by of this trainee electiverotation priority details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee electiverotation priority details.
	 *
	 * @return the modified date of this trainee electiverotation priority details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this trainee electiverotation priority details.
	 *
	 * @return the primary key of this trainee electiverotation priority details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rotation ID of this trainee electiverotation priority details.
	 *
	 * @return the rotation ID of this trainee electiverotation priority details
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the sequence of this trainee electiverotation priority details.
	 *
	 * @return the sequence of this trainee electiverotation priority details
	 */
	@Override
	public int getSequence() {
		return model.getSequence();
	}

	/**
	 * Returns the trainee electiverotation priority details ID of this trainee electiverotation priority details.
	 *
	 * @return the trainee electiverotation priority details ID of this trainee electiverotation priority details
	 */
	@Override
	public long getTraineeElectiverotationPriorityDetailsId() {
		return model.getTraineeElectiverotationPriorityDetailsId();
	}

	/**
	 * Returns the trainee pd tl er details ID of this trainee electiverotation priority details.
	 *
	 * @return the trainee pd tl er details ID of this trainee electiverotation priority details
	 */
	@Override
	public long getTraineePdTlErDetailsId() {
		return model.getTraineePdTlErDetailsId();
	}

	/**
	 * Returns the uuid of this trainee electiverotation priority details.
	 *
	 * @return the uuid of this trainee electiverotation priority details
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
	 * Sets the company ID of this trainee electiverotation priority details.
	 *
	 * @param companyId the company ID of this trainee electiverotation priority details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trainee electiverotation priority details.
	 *
	 * @param createDate the create date of this trainee electiverotation priority details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee electiverotation priority details.
	 *
	 * @param createdBy the created by of this trainee electiverotation priority details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this trainee electiverotation priority details.
	 *
	 * @param groupId the group ID of this trainee electiverotation priority details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee electiverotation priority details.
	 *
	 * @param modifiedBy the modified by of this trainee electiverotation priority details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee electiverotation priority details.
	 *
	 * @param modifiedDate the modified date of this trainee electiverotation priority details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this trainee electiverotation priority details.
	 *
	 * @param primaryKey the primary key of this trainee electiverotation priority details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rotation ID of this trainee electiverotation priority details.
	 *
	 * @param rotationId the rotation ID of this trainee electiverotation priority details
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the sequence of this trainee electiverotation priority details.
	 *
	 * @param sequence the sequence of this trainee electiverotation priority details
	 */
	@Override
	public void setSequence(int sequence) {
		model.setSequence(sequence);
	}

	/**
	 * Sets the trainee electiverotation priority details ID of this trainee electiverotation priority details.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the trainee electiverotation priority details ID of this trainee electiverotation priority details
	 */
	@Override
	public void setTraineeElectiverotationPriorityDetailsId(
		long traineeElectiverotationPriorityDetailsId) {

		model.setTraineeElectiverotationPriorityDetailsId(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Sets the trainee pd tl er details ID of this trainee electiverotation priority details.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID of this trainee electiverotation priority details
	 */
	@Override
	public void setTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		model.setTraineePdTlErDetailsId(traineePdTlErDetailsId);
	}

	/**
	 * Sets the uuid of this trainee electiverotation priority details.
	 *
	 * @param uuid the uuid of this trainee electiverotation priority details
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
	protected TraineeElectiverotationPriorityDetailsWrapper wrap(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		return new TraineeElectiverotationPriorityDetailsWrapper(
			traineeElectiverotationPriorityDetails);
	}

}