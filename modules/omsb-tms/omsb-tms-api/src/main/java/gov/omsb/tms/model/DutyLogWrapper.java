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
 * This class is a wrapper for {@link DutyLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLog
 * @generated
 */
public class DutyLogWrapper
	extends BaseModelWrapper<DutyLog>
	implements DutyLog, ModelWrapper<DutyLog> {

	public DutyLogWrapper(DutyLog dutyLog) {
		super(dutyLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dutyLogId", getDutyLogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("traineeId", getTraineeId());
		attributes.put("programDutyAssignmentId", getProgramDutyAssignmentId());
		attributes.put(
			"blocksMetadataDetailRelId", getBlocksMetadataDetailRelId());
		attributes.put("residencyLevelId", getResidencyLevelId());
		attributes.put("multiDays", getMultiDays());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dutyLogId = (Long)attributes.get("dutyLogId");

		if (dutyLogId != null) {
			setDutyLogId(dutyLogId);
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

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		Long programDutyAssignmentId = (Long)attributes.get(
			"programDutyAssignmentId");

		if (programDutyAssignmentId != null) {
			setProgramDutyAssignmentId(programDutyAssignmentId);
		}

		Long blocksMetadataDetailRelId = (Long)attributes.get(
			"blocksMetadataDetailRelId");

		if (blocksMetadataDetailRelId != null) {
			setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		}

		Long residencyLevelId = (Long)attributes.get("residencyLevelId");

		if (residencyLevelId != null) {
			setResidencyLevelId(residencyLevelId);
		}

		Boolean multiDays = (Boolean)attributes.get("multiDays");

		if (multiDays != null) {
			setMultiDays(multiDays);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public DutyLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the blocks metadata detail rel ID of this duty log.
	 *
	 * @return the blocks metadata detail rel ID of this duty log
	 */
	@Override
	public long getBlocksMetadataDetailRelId() {
		return model.getBlocksMetadataDetailRelId();
	}

	/**
	 * Returns the company ID of this duty log.
	 *
	 * @return the company ID of this duty log
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this duty log.
	 *
	 * @return the create date of this duty log
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this duty log.
	 *
	 * @return the created by of this duty log
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the duty log ID of this duty log.
	 *
	 * @return the duty log ID of this duty log
	 */
	@Override
	public long getDutyLogId() {
		return model.getDutyLogId();
	}

	/**
	 * Returns the end date of this duty log.
	 *
	 * @return the end date of this duty log
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this duty log.
	 *
	 * @return the group ID of this duty log
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this duty log.
	 *
	 * @return the modified by of this duty log
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this duty log.
	 *
	 * @return the modified date of this duty log
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the multi days of this duty log.
	 *
	 * @return the multi days of this duty log
	 */
	@Override
	public Boolean getMultiDays() {
		return model.getMultiDays();
	}

	/**
	 * Returns the primary key of this duty log.
	 *
	 * @return the primary key of this duty log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duty assignment ID of this duty log.
	 *
	 * @return the program duty assignment ID of this duty log
	 */
	@Override
	public long getProgramDutyAssignmentId() {
		return model.getProgramDutyAssignmentId();
	}

	/**
	 * Returns the residency level ID of this duty log.
	 *
	 * @return the residency level ID of this duty log
	 */
	@Override
	public long getResidencyLevelId() {
		return model.getResidencyLevelId();
	}

	/**
	 * Returns the start date of this duty log.
	 *
	 * @return the start date of this duty log
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the trainee ID of this duty log.
	 *
	 * @return the trainee ID of this duty log
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the uuid of this duty log.
	 *
	 * @return the uuid of this duty log
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
	 * Sets the blocks metadata detail rel ID of this duty log.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID of this duty log
	 */
	@Override
	public void setBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		model.setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	/**
	 * Sets the company ID of this duty log.
	 *
	 * @param companyId the company ID of this duty log
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this duty log.
	 *
	 * @param createDate the create date of this duty log
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this duty log.
	 *
	 * @param createdBy the created by of this duty log
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the duty log ID of this duty log.
	 *
	 * @param dutyLogId the duty log ID of this duty log
	 */
	@Override
	public void setDutyLogId(long dutyLogId) {
		model.setDutyLogId(dutyLogId);
	}

	/**
	 * Sets the end date of this duty log.
	 *
	 * @param endDate the end date of this duty log
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this duty log.
	 *
	 * @param groupId the group ID of this duty log
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this duty log.
	 *
	 * @param modifiedBy the modified by of this duty log
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this duty log.
	 *
	 * @param modifiedDate the modified date of this duty log
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the multi days of this duty log.
	 *
	 * @param multiDays the multi days of this duty log
	 */
	@Override
	public void setMultiDays(Boolean multiDays) {
		model.setMultiDays(multiDays);
	}

	/**
	 * Sets the primary key of this duty log.
	 *
	 * @param primaryKey the primary key of this duty log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duty assignment ID of this duty log.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID of this duty log
	 */
	@Override
	public void setProgramDutyAssignmentId(long programDutyAssignmentId) {
		model.setProgramDutyAssignmentId(programDutyAssignmentId);
	}

	/**
	 * Sets the residency level ID of this duty log.
	 *
	 * @param residencyLevelId the residency level ID of this duty log
	 */
	@Override
	public void setResidencyLevelId(long residencyLevelId) {
		model.setResidencyLevelId(residencyLevelId);
	}

	/**
	 * Sets the start date of this duty log.
	 *
	 * @param startDate the start date of this duty log
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the trainee ID of this duty log.
	 *
	 * @param traineeId the trainee ID of this duty log
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the uuid of this duty log.
	 *
	 * @param uuid the uuid of this duty log
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
	protected DutyLogWrapper wrap(DutyLog dutyLog) {
		return new DutyLogWrapper(dutyLog);
	}

}