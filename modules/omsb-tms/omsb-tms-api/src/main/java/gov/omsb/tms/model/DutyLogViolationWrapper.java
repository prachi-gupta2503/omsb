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
 * This class is a wrapper for {@link DutyLogViolation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolation
 * @generated
 */
public class DutyLogViolationWrapper
	extends BaseModelWrapper<DutyLogViolation>
	implements DutyLogViolation, ModelWrapper<DutyLogViolation> {

	public DutyLogViolationWrapper(DutyLogViolation dutyLogViolation) {
		super(dutyLogViolation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ViolationId", getViolationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("traineeId", getTraineeId());
		attributes.put("programMasterId", getProgramMasterId());
		attributes.put("residencyLevel", getResidencyLevel());
		attributes.put("rotationId", getRotationId());
		attributes.put("trainingSiteId", getTrainingSiteId());
		attributes.put("blockId", getBlockId());
		attributes.put("blockWeekId", getBlockWeekId());
		attributes.put("programDutyRuleId", getProgramDutyRuleId());
		attributes.put("acgme80HoursRule", getAcgme80HoursRule());
		attributes.put("acgmeCallRuleOption1", getAcgmeCallRuleOption1());
		attributes.put("acgmeCallRuleOption2", getAcgmeCallRuleOption2());
		attributes.put("acgmeShortBreakRule", getAcgmeShortBreakRule());
		attributes.put("acgme24HoursRule", getAcgme24HoursRule());
		attributes.put("acgmeDayOffRule", getAcgmeDayOffRule());
		attributes.put("dutyLogId", getDutyLogId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ViolationId = (Long)attributes.get("ViolationId");

		if (ViolationId != null) {
			setViolationId(ViolationId);
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

		Long programMasterId = (Long)attributes.get("programMasterId");

		if (programMasterId != null) {
			setProgramMasterId(programMasterId);
		}

		Long residencyLevel = (Long)attributes.get("residencyLevel");

		if (residencyLevel != null) {
			setResidencyLevel(residencyLevel);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
		}

		Long trainingSiteId = (Long)attributes.get("trainingSiteId");

		if (trainingSiteId != null) {
			setTrainingSiteId(trainingSiteId);
		}

		Long blockId = (Long)attributes.get("blockId");

		if (blockId != null) {
			setBlockId(blockId);
		}

		Long blockWeekId = (Long)attributes.get("blockWeekId");

		if (blockWeekId != null) {
			setBlockWeekId(blockWeekId);
		}

		Long programDutyRuleId = (Long)attributes.get("programDutyRuleId");

		if (programDutyRuleId != null) {
			setProgramDutyRuleId(programDutyRuleId);
		}

		Integer acgme80HoursRule = (Integer)attributes.get("acgme80HoursRule");

		if (acgme80HoursRule != null) {
			setAcgme80HoursRule(acgme80HoursRule);
		}

		Integer acgmeCallRuleOption1 = (Integer)attributes.get(
			"acgmeCallRuleOption1");

		if (acgmeCallRuleOption1 != null) {
			setAcgmeCallRuleOption1(acgmeCallRuleOption1);
		}

		Integer acgmeCallRuleOption2 = (Integer)attributes.get(
			"acgmeCallRuleOption2");

		if (acgmeCallRuleOption2 != null) {
			setAcgmeCallRuleOption2(acgmeCallRuleOption2);
		}

		Integer acgmeShortBreakRule = (Integer)attributes.get(
			"acgmeShortBreakRule");

		if (acgmeShortBreakRule != null) {
			setAcgmeShortBreakRule(acgmeShortBreakRule);
		}

		Integer acgme24HoursRule = (Integer)attributes.get("acgme24HoursRule");

		if (acgme24HoursRule != null) {
			setAcgme24HoursRule(acgme24HoursRule);
		}

		Integer acgmeDayOffRule = (Integer)attributes.get("acgmeDayOffRule");

		if (acgmeDayOffRule != null) {
			setAcgmeDayOffRule(acgmeDayOffRule);
		}

		Long dutyLogId = (Long)attributes.get("dutyLogId");

		if (dutyLogId != null) {
			setDutyLogId(dutyLogId);
		}
	}

	@Override
	public DutyLogViolation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the acgme24 hours rule of this duty log violation.
	 *
	 * @return the acgme24 hours rule of this duty log violation
	 */
	@Override
	public int getAcgme24HoursRule() {
		return model.getAcgme24HoursRule();
	}

	/**
	 * Returns the acgme80 hours rule of this duty log violation.
	 *
	 * @return the acgme80 hours rule of this duty log violation
	 */
	@Override
	public int getAcgme80HoursRule() {
		return model.getAcgme80HoursRule();
	}

	/**
	 * Returns the acgme call rule option1 of this duty log violation.
	 *
	 * @return the acgme call rule option1 of this duty log violation
	 */
	@Override
	public int getAcgmeCallRuleOption1() {
		return model.getAcgmeCallRuleOption1();
	}

	/**
	 * Returns the acgme call rule option2 of this duty log violation.
	 *
	 * @return the acgme call rule option2 of this duty log violation
	 */
	@Override
	public int getAcgmeCallRuleOption2() {
		return model.getAcgmeCallRuleOption2();
	}

	/**
	 * Returns the acgme day off rule of this duty log violation.
	 *
	 * @return the acgme day off rule of this duty log violation
	 */
	@Override
	public int getAcgmeDayOffRule() {
		return model.getAcgmeDayOffRule();
	}

	/**
	 * Returns the acgme short break rule of this duty log violation.
	 *
	 * @return the acgme short break rule of this duty log violation
	 */
	@Override
	public int getAcgmeShortBreakRule() {
		return model.getAcgmeShortBreakRule();
	}

	/**
	 * Returns the block ID of this duty log violation.
	 *
	 * @return the block ID of this duty log violation
	 */
	@Override
	public long getBlockId() {
		return model.getBlockId();
	}

	/**
	 * Returns the block week ID of this duty log violation.
	 *
	 * @return the block week ID of this duty log violation
	 */
	@Override
	public long getBlockWeekId() {
		return model.getBlockWeekId();
	}

	/**
	 * Returns the company ID of this duty log violation.
	 *
	 * @return the company ID of this duty log violation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this duty log violation.
	 *
	 * @return the create date of this duty log violation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this duty log violation.
	 *
	 * @return the created by of this duty log violation
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the duty log ID of this duty log violation.
	 *
	 * @return the duty log ID of this duty log violation
	 */
	@Override
	public long getDutyLogId() {
		return model.getDutyLogId();
	}

	/**
	 * Returns the group ID of this duty log violation.
	 *
	 * @return the group ID of this duty log violation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this duty log violation.
	 *
	 * @return the modified by of this duty log violation
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this duty log violation.
	 *
	 * @return the modified date of this duty log violation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this duty log violation.
	 *
	 * @return the primary key of this duty log violation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duty rule ID of this duty log violation.
	 *
	 * @return the program duty rule ID of this duty log violation
	 */
	@Override
	public long getProgramDutyRuleId() {
		return model.getProgramDutyRuleId();
	}

	/**
	 * Returns the program master ID of this duty log violation.
	 *
	 * @return the program master ID of this duty log violation
	 */
	@Override
	public long getProgramMasterId() {
		return model.getProgramMasterId();
	}

	/**
	 * Returns the residency level of this duty log violation.
	 *
	 * @return the residency level of this duty log violation
	 */
	@Override
	public long getResidencyLevel() {
		return model.getResidencyLevel();
	}

	/**
	 * Returns the rotation ID of this duty log violation.
	 *
	 * @return the rotation ID of this duty log violation
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the trainee ID of this duty log violation.
	 *
	 * @return the trainee ID of this duty log violation
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the training site ID of this duty log violation.
	 *
	 * @return the training site ID of this duty log violation
	 */
	@Override
	public long getTrainingSiteId() {
		return model.getTrainingSiteId();
	}

	/**
	 * Returns the uuid of this duty log violation.
	 *
	 * @return the uuid of this duty log violation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the violation ID of this duty log violation.
	 *
	 * @return the violation ID of this duty log violation
	 */
	@Override
	public long getViolationId() {
		return model.getViolationId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the acgme24 hours rule of this duty log violation.
	 *
	 * @param acgme24HoursRule the acgme24 hours rule of this duty log violation
	 */
	@Override
	public void setAcgme24HoursRule(int acgme24HoursRule) {
		model.setAcgme24HoursRule(acgme24HoursRule);
	}

	/**
	 * Sets the acgme80 hours rule of this duty log violation.
	 *
	 * @param acgme80HoursRule the acgme80 hours rule of this duty log violation
	 */
	@Override
	public void setAcgme80HoursRule(int acgme80HoursRule) {
		model.setAcgme80HoursRule(acgme80HoursRule);
	}

	/**
	 * Sets the acgme call rule option1 of this duty log violation.
	 *
	 * @param acgmeCallRuleOption1 the acgme call rule option1 of this duty log violation
	 */
	@Override
	public void setAcgmeCallRuleOption1(int acgmeCallRuleOption1) {
		model.setAcgmeCallRuleOption1(acgmeCallRuleOption1);
	}

	/**
	 * Sets the acgme call rule option2 of this duty log violation.
	 *
	 * @param acgmeCallRuleOption2 the acgme call rule option2 of this duty log violation
	 */
	@Override
	public void setAcgmeCallRuleOption2(int acgmeCallRuleOption2) {
		model.setAcgmeCallRuleOption2(acgmeCallRuleOption2);
	}

	/**
	 * Sets the acgme day off rule of this duty log violation.
	 *
	 * @param acgmeDayOffRule the acgme day off rule of this duty log violation
	 */
	@Override
	public void setAcgmeDayOffRule(int acgmeDayOffRule) {
		model.setAcgmeDayOffRule(acgmeDayOffRule);
	}

	/**
	 * Sets the acgme short break rule of this duty log violation.
	 *
	 * @param acgmeShortBreakRule the acgme short break rule of this duty log violation
	 */
	@Override
	public void setAcgmeShortBreakRule(int acgmeShortBreakRule) {
		model.setAcgmeShortBreakRule(acgmeShortBreakRule);
	}

	/**
	 * Sets the block ID of this duty log violation.
	 *
	 * @param blockId the block ID of this duty log violation
	 */
	@Override
	public void setBlockId(long blockId) {
		model.setBlockId(blockId);
	}

	/**
	 * Sets the block week ID of this duty log violation.
	 *
	 * @param blockWeekId the block week ID of this duty log violation
	 */
	@Override
	public void setBlockWeekId(long blockWeekId) {
		model.setBlockWeekId(blockWeekId);
	}

	/**
	 * Sets the company ID of this duty log violation.
	 *
	 * @param companyId the company ID of this duty log violation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this duty log violation.
	 *
	 * @param createDate the create date of this duty log violation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this duty log violation.
	 *
	 * @param createdBy the created by of this duty log violation
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the duty log ID of this duty log violation.
	 *
	 * @param dutyLogId the duty log ID of this duty log violation
	 */
	@Override
	public void setDutyLogId(long dutyLogId) {
		model.setDutyLogId(dutyLogId);
	}

	/**
	 * Sets the group ID of this duty log violation.
	 *
	 * @param groupId the group ID of this duty log violation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this duty log violation.
	 *
	 * @param modifiedBy the modified by of this duty log violation
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this duty log violation.
	 *
	 * @param modifiedDate the modified date of this duty log violation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this duty log violation.
	 *
	 * @param primaryKey the primary key of this duty log violation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duty rule ID of this duty log violation.
	 *
	 * @param programDutyRuleId the program duty rule ID of this duty log violation
	 */
	@Override
	public void setProgramDutyRuleId(long programDutyRuleId) {
		model.setProgramDutyRuleId(programDutyRuleId);
	}

	/**
	 * Sets the program master ID of this duty log violation.
	 *
	 * @param programMasterId the program master ID of this duty log violation
	 */
	@Override
	public void setProgramMasterId(long programMasterId) {
		model.setProgramMasterId(programMasterId);
	}

	/**
	 * Sets the residency level of this duty log violation.
	 *
	 * @param residencyLevel the residency level of this duty log violation
	 */
	@Override
	public void setResidencyLevel(long residencyLevel) {
		model.setResidencyLevel(residencyLevel);
	}

	/**
	 * Sets the rotation ID of this duty log violation.
	 *
	 * @param rotationId the rotation ID of this duty log violation
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the trainee ID of this duty log violation.
	 *
	 * @param traineeId the trainee ID of this duty log violation
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the training site ID of this duty log violation.
	 *
	 * @param trainingSiteId the training site ID of this duty log violation
	 */
	@Override
	public void setTrainingSiteId(long trainingSiteId) {
		model.setTrainingSiteId(trainingSiteId);
	}

	/**
	 * Sets the uuid of this duty log violation.
	 *
	 * @param uuid the uuid of this duty log violation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the violation ID of this duty log violation.
	 *
	 * @param ViolationId the violation ID of this duty log violation
	 */
	@Override
	public void setViolationId(long ViolationId) {
		model.setViolationId(ViolationId);
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
	protected DutyLogViolationWrapper wrap(DutyLogViolation dutyLogViolation) {
		return new DutyLogViolationWrapper(dutyLogViolation);
	}

}