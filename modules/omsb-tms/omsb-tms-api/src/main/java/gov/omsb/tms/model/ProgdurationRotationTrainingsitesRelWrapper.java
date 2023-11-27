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
 * This class is a wrapper for {@link ProgdurationRotationTrainingsitesRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRel
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelWrapper
	extends BaseModelWrapper<ProgdurationRotationTrainingsitesRel>
	implements ModelWrapper<ProgdurationRotationTrainingsitesRel>,
			   ProgdurationRotationTrainingsitesRel {

	public ProgdurationRotationTrainingsitesRelWrapper(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		super(progdurationRotationTrainingsitesRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"progdurationRotationTsRelId", getProgdurationRotationTsRelId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("trainingSitesId", getTrainingSitesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("isSharedRotation", isIsSharedRotation());
		attributes.put("rotationOwningProgramId", getRotationOwningProgramId());
		attributes.put("progCodeRsnSiteCode", getProgCodeRsnSiteCode());
		attributes.put("owningProgramDurationId", getOwningProgramDurationId());
		attributes.put("noOfSlots", getNoOfSlots());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long progdurationRotationTsRelId = (Long)attributes.get(
			"progdurationRotationTsRelId");

		if (progdurationRotationTsRelId != null) {
			setProgdurationRotationTsRelId(progdurationRotationTsRelId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Long trainingSitesId = (Long)attributes.get("trainingSitesId");

		if (trainingSitesId != null) {
			setTrainingSitesId(trainingSitesId);
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

		Boolean isSharedRotation = (Boolean)attributes.get("isSharedRotation");

		if (isSharedRotation != null) {
			setIsSharedRotation(isSharedRotation);
		}

		Long rotationOwningProgramId = (Long)attributes.get(
			"rotationOwningProgramId");

		if (rotationOwningProgramId != null) {
			setRotationOwningProgramId(rotationOwningProgramId);
		}

		String progCodeRsnSiteCode = (String)attributes.get(
			"progCodeRsnSiteCode");

		if (progCodeRsnSiteCode != null) {
			setProgCodeRsnSiteCode(progCodeRsnSiteCode);
		}

		Long owningProgramDurationId = (Long)attributes.get(
			"owningProgramDurationId");

		if (owningProgramDurationId != null) {
			setOwningProgramDurationId(owningProgramDurationId);
		}

		Integer noOfSlots = (Integer)attributes.get("noOfSlots");

		if (noOfSlots != null) {
			setNoOfSlots(noOfSlots);
		}
	}

	@Override
	public ProgdurationRotationTrainingsitesRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this progduration rotation trainingsites rel.
	 *
	 * @return the company ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this progduration rotation trainingsites rel.
	 *
	 * @return the create date of this progduration rotation trainingsites rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this progduration rotation trainingsites rel.
	 *
	 * @return the created by of this progduration rotation trainingsites rel
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this progduration rotation trainingsites rel.
	 *
	 * @return the group ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is shared rotation of this progduration rotation trainingsites rel.
	 *
	 * @return the is shared rotation of this progduration rotation trainingsites rel
	 */
	@Override
	public boolean getIsSharedRotation() {
		return model.getIsSharedRotation();
	}

	/**
	 * Returns the modified by of this progduration rotation trainingsites rel.
	 *
	 * @return the modified by of this progduration rotation trainingsites rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this progduration rotation trainingsites rel.
	 *
	 * @return the modified date of this progduration rotation trainingsites rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of slots of this progduration rotation trainingsites rel.
	 *
	 * @return the no of slots of this progduration rotation trainingsites rel
	 */
	@Override
	public int getNoOfSlots() {
		return model.getNoOfSlots();
	}

	/**
	 * Returns the owning program duration ID of this progduration rotation trainingsites rel.
	 *
	 * @return the owning program duration ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getOwningProgramDurationId() {
		return model.getOwningProgramDurationId();
	}

	/**
	 * Returns the primary key of this progduration rotation trainingsites rel.
	 *
	 * @return the primary key of this progduration rotation trainingsites rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog code rsn site code of this progduration rotation trainingsites rel.
	 *
	 * @return the prog code rsn site code of this progduration rotation trainingsites rel
	 */
	@Override
	public String getProgCodeRsnSiteCode() {
		return model.getProgCodeRsnSiteCode();
	}

	/**
	 * Returns the progduration rotation ts rel ID of this progduration rotation trainingsites rel.
	 *
	 * @return the progduration rotation ts rel ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getProgdurationRotationTsRelId() {
		return model.getProgdurationRotationTsRelId();
	}

	/**
	 * Returns the program duration ID of this progduration rotation trainingsites rel.
	 *
	 * @return the program duration ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the rotation ID of this progduration rotation trainingsites rel.
	 *
	 * @return the rotation ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the rotation owning program ID of this progduration rotation trainingsites rel.
	 *
	 * @return the rotation owning program ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getRotationOwningProgramId() {
		return model.getRotationOwningProgramId();
	}

	/**
	 * Returns the training sites ID of this progduration rotation trainingsites rel.
	 *
	 * @return the training sites ID of this progduration rotation trainingsites rel
	 */
	@Override
	public long getTrainingSitesId() {
		return model.getTrainingSitesId();
	}

	/**
	 * Returns the uuid of this progduration rotation trainingsites rel.
	 *
	 * @return the uuid of this progduration rotation trainingsites rel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this progduration rotation trainingsites rel is is shared rotation.
	 *
	 * @return <code>true</code> if this progduration rotation trainingsites rel is is shared rotation; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSharedRotation() {
		return model.isIsSharedRotation();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this progduration rotation trainingsites rel.
	 *
	 * @param companyId the company ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this progduration rotation trainingsites rel.
	 *
	 * @param createDate the create date of this progduration rotation trainingsites rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this progduration rotation trainingsites rel.
	 *
	 * @param createdBy the created by of this progduration rotation trainingsites rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this progduration rotation trainingsites rel.
	 *
	 * @param groupId the group ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this progduration rotation trainingsites rel is is shared rotation.
	 *
	 * @param isSharedRotation the is shared rotation of this progduration rotation trainingsites rel
	 */
	@Override
	public void setIsSharedRotation(boolean isSharedRotation) {
		model.setIsSharedRotation(isSharedRotation);
	}

	/**
	 * Sets the modified by of this progduration rotation trainingsites rel.
	 *
	 * @param modifiedBy the modified by of this progduration rotation trainingsites rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this progduration rotation trainingsites rel.
	 *
	 * @param modifiedDate the modified date of this progduration rotation trainingsites rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of slots of this progduration rotation trainingsites rel.
	 *
	 * @param noOfSlots the no of slots of this progduration rotation trainingsites rel
	 */
	@Override
	public void setNoOfSlots(int noOfSlots) {
		model.setNoOfSlots(noOfSlots);
	}

	/**
	 * Sets the owning program duration ID of this progduration rotation trainingsites rel.
	 *
	 * @param owningProgramDurationId the owning program duration ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setOwningProgramDurationId(long owningProgramDurationId) {
		model.setOwningProgramDurationId(owningProgramDurationId);
	}

	/**
	 * Sets the primary key of this progduration rotation trainingsites rel.
	 *
	 * @param primaryKey the primary key of this progduration rotation trainingsites rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog code rsn site code of this progduration rotation trainingsites rel.
	 *
	 * @param progCodeRsnSiteCode the prog code rsn site code of this progduration rotation trainingsites rel
	 */
	@Override
	public void setProgCodeRsnSiteCode(String progCodeRsnSiteCode) {
		model.setProgCodeRsnSiteCode(progCodeRsnSiteCode);
	}

	/**
	 * Sets the progduration rotation ts rel ID of this progduration rotation trainingsites rel.
	 *
	 * @param progdurationRotationTsRelId the progduration rotation ts rel ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setProgdurationRotationTsRelId(
		long progdurationRotationTsRelId) {

		model.setProgdurationRotationTsRelId(progdurationRotationTsRelId);
	}

	/**
	 * Sets the program duration ID of this progduration rotation trainingsites rel.
	 *
	 * @param programDurationId the program duration ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the rotation ID of this progduration rotation trainingsites rel.
	 *
	 * @param rotationId the rotation ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the rotation owning program ID of this progduration rotation trainingsites rel.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setRotationOwningProgramId(long rotationOwningProgramId) {
		model.setRotationOwningProgramId(rotationOwningProgramId);
	}

	/**
	 * Sets the training sites ID of this progduration rotation trainingsites rel.
	 *
	 * @param trainingSitesId the training sites ID of this progduration rotation trainingsites rel
	 */
	@Override
	public void setTrainingSitesId(long trainingSitesId) {
		model.setTrainingSitesId(trainingSitesId);
	}

	/**
	 * Sets the uuid of this progduration rotation trainingsites rel.
	 *
	 * @param uuid the uuid of this progduration rotation trainingsites rel
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
	protected ProgdurationRotationTrainingsitesRelWrapper wrap(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		return new ProgdurationRotationTrainingsitesRelWrapper(
			progdurationRotationTrainingsitesRel);
	}

}