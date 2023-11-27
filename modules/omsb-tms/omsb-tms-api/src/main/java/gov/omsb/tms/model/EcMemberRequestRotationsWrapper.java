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
 * This class is a wrapper for {@link EcMemberRequestRotations}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestRotations
 * @generated
 */
public class EcMemberRequestRotationsWrapper
	extends BaseModelWrapper<EcMemberRequestRotations>
	implements EcMemberRequestRotations,
			   ModelWrapper<EcMemberRequestRotations> {

	public EcMemberRequestRotationsWrapper(
		EcMemberRequestRotations ecMemberRequestRotations) {

		super(ecMemberRequestRotations);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"ecMemberRequestRotationsId", getEcMemberRequestRotationsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ecMemberRequestId", getEcMemberRequestId());
		attributes.put("trainingSiteId", getTrainingSiteId());
		attributes.put("rotationId", getRotationId());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ecMemberRequestRotationsId = (Long)attributes.get(
			"ecMemberRequestRotationsId");

		if (ecMemberRequestRotationsId != null) {
			setEcMemberRequestRotationsId(ecMemberRequestRotationsId);
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

		Long ecMemberRequestId = (Long)attributes.get("ecMemberRequestId");

		if (ecMemberRequestId != null) {
			setEcMemberRequestId(ecMemberRequestId);
		}

		Long trainingSiteId = (Long)attributes.get("trainingSiteId");

		if (trainingSiteId != null) {
			setTrainingSiteId(trainingSiteId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public EcMemberRequestRotations cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this ec member request rotations.
	 *
	 * @return the company ID of this ec member request rotations
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ec member request rotations.
	 *
	 * @return the create date of this ec member request rotations
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the ec member request ID of this ec member request rotations.
	 *
	 * @return the ec member request ID of this ec member request rotations
	 */
	@Override
	public long getEcMemberRequestId() {
		return model.getEcMemberRequestId();
	}

	/**
	 * Returns the ec member request rotations ID of this ec member request rotations.
	 *
	 * @return the ec member request rotations ID of this ec member request rotations
	 */
	@Override
	public long getEcMemberRequestRotationsId() {
		return model.getEcMemberRequestRotationsId();
	}

	/**
	 * Returns the group ID of this ec member request rotations.
	 *
	 * @return the group ID of this ec member request rotations
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this ec member request rotations.
	 *
	 * @return the is active of this ec member request rotations
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the modified date of this ec member request rotations.
	 *
	 * @return the modified date of this ec member request rotations
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ec member request rotations.
	 *
	 * @return the primary key of this ec member request rotations
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rotation ID of this ec member request rotations.
	 *
	 * @return the rotation ID of this ec member request rotations
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the training site ID of this ec member request rotations.
	 *
	 * @return the training site ID of this ec member request rotations
	 */
	@Override
	public long getTrainingSiteId() {
		return model.getTrainingSiteId();
	}

	/**
	 * Returns the uuid of this ec member request rotations.
	 *
	 * @return the uuid of this ec member request rotations
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
	 * Sets the company ID of this ec member request rotations.
	 *
	 * @param companyId the company ID of this ec member request rotations
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ec member request rotations.
	 *
	 * @param createDate the create date of this ec member request rotations
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the ec member request ID of this ec member request rotations.
	 *
	 * @param ecMemberRequestId the ec member request ID of this ec member request rotations
	 */
	@Override
	public void setEcMemberRequestId(long ecMemberRequestId) {
		model.setEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Sets the ec member request rotations ID of this ec member request rotations.
	 *
	 * @param ecMemberRequestRotationsId the ec member request rotations ID of this ec member request rotations
	 */
	@Override
	public void setEcMemberRequestRotationsId(long ecMemberRequestRotationsId) {
		model.setEcMemberRequestRotationsId(ecMemberRequestRotationsId);
	}

	/**
	 * Sets the group ID of this ec member request rotations.
	 *
	 * @param groupId the group ID of this ec member request rotations
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is active of this ec member request rotations.
	 *
	 * @param isActive the is active of this ec member request rotations
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the modified date of this ec member request rotations.
	 *
	 * @param modifiedDate the modified date of this ec member request rotations
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ec member request rotations.
	 *
	 * @param primaryKey the primary key of this ec member request rotations
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rotation ID of this ec member request rotations.
	 *
	 * @param rotationId the rotation ID of this ec member request rotations
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the training site ID of this ec member request rotations.
	 *
	 * @param trainingSiteId the training site ID of this ec member request rotations
	 */
	@Override
	public void setTrainingSiteId(long trainingSiteId) {
		model.setTrainingSiteId(trainingSiteId);
	}

	/**
	 * Sets the uuid of this ec member request rotations.
	 *
	 * @param uuid the uuid of this ec member request rotations
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
	protected EcMemberRequestRotationsWrapper wrap(
		EcMemberRequestRotations ecMemberRequestRotations) {

		return new EcMemberRequestRotationsWrapper(ecMemberRequestRotations);
	}

}