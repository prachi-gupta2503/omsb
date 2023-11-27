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
 * This class is a wrapper for {@link LeaveAnnualMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaster
 * @generated
 */
public class LeaveAnnualMasterWrapper
	extends BaseModelWrapper<LeaveAnnualMaster>
	implements LeaveAnnualMaster, ModelWrapper<LeaveAnnualMaster> {

	public LeaveAnnualMasterWrapper(LeaveAnnualMaster leaveAnnualMaster) {
		super(leaveAnnualMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveAnnualMasterId", getLeaveAnnualMasterId());
		attributes.put("leaveProgramMasterId", getLeaveProgramMasterId());
		attributes.put("leaveTypesId", getLeaveTypesId());
		attributes.put("trainingLevelId", getTrainingLevelId());
		attributes.put("blockName", getBlockName());
		attributes.put("maxTraineeApplyLeave", getMaxTraineeApplyLeave());
		attributes.put("noOfTraineeTakenLeave", getNoOfTraineeTakenLeave());
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

		Long leaveAnnualMasterId = (Long)attributes.get("leaveAnnualMasterId");

		if (leaveAnnualMasterId != null) {
			setLeaveAnnualMasterId(leaveAnnualMasterId);
		}

		Long leaveProgramMasterId = (Long)attributes.get(
			"leaveProgramMasterId");

		if (leaveProgramMasterId != null) {
			setLeaveProgramMasterId(leaveProgramMasterId);
		}

		Long leaveTypesId = (Long)attributes.get("leaveTypesId");

		if (leaveTypesId != null) {
			setLeaveTypesId(leaveTypesId);
		}

		Long trainingLevelId = (Long)attributes.get("trainingLevelId");

		if (trainingLevelId != null) {
			setTrainingLevelId(trainingLevelId);
		}

		String blockName = (String)attributes.get("blockName");

		if (blockName != null) {
			setBlockName(blockName);
		}

		Integer maxTraineeApplyLeave = (Integer)attributes.get(
			"maxTraineeApplyLeave");

		if (maxTraineeApplyLeave != null) {
			setMaxTraineeApplyLeave(maxTraineeApplyLeave);
		}

		Integer noOfTraineeTakenLeave = (Integer)attributes.get(
			"noOfTraineeTakenLeave");

		if (noOfTraineeTakenLeave != null) {
			setNoOfTraineeTakenLeave(noOfTraineeTakenLeave);
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
	public LeaveAnnualMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the block name of this leave annual master.
	 *
	 * @return the block name of this leave annual master
	 */
	@Override
	public String getBlockName() {
		return model.getBlockName();
	}

	/**
	 * Returns the localized block name of this leave annual master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized block name of this leave annual master
	 */
	@Override
	public String getBlockName(java.util.Locale locale) {
		return model.getBlockName(locale);
	}

	/**
	 * Returns the localized block name of this leave annual master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized block name of this leave annual master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBlockName(java.util.Locale locale, boolean useDefault) {
		return model.getBlockName(locale, useDefault);
	}

	/**
	 * Returns the localized block name of this leave annual master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized block name of this leave annual master
	 */
	@Override
	public String getBlockName(String languageId) {
		return model.getBlockName(languageId);
	}

	/**
	 * Returns the localized block name of this leave annual master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized block name of this leave annual master
	 */
	@Override
	public String getBlockName(String languageId, boolean useDefault) {
		return model.getBlockName(languageId, useDefault);
	}

	@Override
	public String getBlockNameCurrentLanguageId() {
		return model.getBlockNameCurrentLanguageId();
	}

	@Override
	public String getBlockNameCurrentValue() {
		return model.getBlockNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized block names of this leave annual master.
	 *
	 * @return the locales and localized block names of this leave annual master
	 */
	@Override
	public Map<java.util.Locale, String> getBlockNameMap() {
		return model.getBlockNameMap();
	}

	/**
	 * Returns the company ID of this leave annual master.
	 *
	 * @return the company ID of this leave annual master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave annual master.
	 *
	 * @return the create date of this leave annual master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave annual master.
	 *
	 * @return the created by of this leave annual master
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the group ID of this leave annual master.
	 *
	 * @return the group ID of this leave annual master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave annual master ID of this leave annual master.
	 *
	 * @return the leave annual master ID of this leave annual master
	 */
	@Override
	public long getLeaveAnnualMasterId() {
		return model.getLeaveAnnualMasterId();
	}

	/**
	 * Returns the leave program master ID of this leave annual master.
	 *
	 * @return the leave program master ID of this leave annual master
	 */
	@Override
	public long getLeaveProgramMasterId() {
		return model.getLeaveProgramMasterId();
	}

	/**
	 * Returns the leave types ID of this leave annual master.
	 *
	 * @return the leave types ID of this leave annual master
	 */
	@Override
	public long getLeaveTypesId() {
		return model.getLeaveTypesId();
	}

	/**
	 * Returns the max trainee apply leave of this leave annual master.
	 *
	 * @return the max trainee apply leave of this leave annual master
	 */
	@Override
	public int getMaxTraineeApplyLeave() {
		return model.getMaxTraineeApplyLeave();
	}

	/**
	 * Returns the modified by of this leave annual master.
	 *
	 * @return the modified by of this leave annual master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave annual master.
	 *
	 * @return the modified date of this leave annual master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of trainee taken leave of this leave annual master.
	 *
	 * @return the no of trainee taken leave of this leave annual master
	 */
	@Override
	public int getNoOfTraineeTakenLeave() {
		return model.getNoOfTraineeTakenLeave();
	}

	/**
	 * Returns the primary key of this leave annual master.
	 *
	 * @return the primary key of this leave annual master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the training level ID of this leave annual master.
	 *
	 * @return the training level ID of this leave annual master
	 */
	@Override
	public long getTrainingLevelId() {
		return model.getTrainingLevelId();
	}

	/**
	 * Returns the uuid of this leave annual master.
	 *
	 * @return the uuid of this leave annual master
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the block name of this leave annual master.
	 *
	 * @param blockName the block name of this leave annual master
	 */
	@Override
	public void setBlockName(String blockName) {
		model.setBlockName(blockName);
	}

	/**
	 * Sets the localized block name of this leave annual master in the language.
	 *
	 * @param blockName the localized block name of this leave annual master
	 * @param locale the locale of the language
	 */
	@Override
	public void setBlockName(String blockName, java.util.Locale locale) {
		model.setBlockName(blockName, locale);
	}

	/**
	 * Sets the localized block name of this leave annual master in the language, and sets the default locale.
	 *
	 * @param blockName the localized block name of this leave annual master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBlockName(
		String blockName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBlockName(blockName, locale, defaultLocale);
	}

	@Override
	public void setBlockNameCurrentLanguageId(String languageId) {
		model.setBlockNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized block names of this leave annual master from the map of locales and localized block names.
	 *
	 * @param blockNameMap the locales and localized block names of this leave annual master
	 */
	@Override
	public void setBlockNameMap(Map<java.util.Locale, String> blockNameMap) {
		model.setBlockNameMap(blockNameMap);
	}

	/**
	 * Sets the localized block names of this leave annual master from the map of locales and localized block names, and sets the default locale.
	 *
	 * @param blockNameMap the locales and localized block names of this leave annual master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBlockNameMap(
		Map<java.util.Locale, String> blockNameMap,
		java.util.Locale defaultLocale) {

		model.setBlockNameMap(blockNameMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this leave annual master.
	 *
	 * @param companyId the company ID of this leave annual master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave annual master.
	 *
	 * @param createDate the create date of this leave annual master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave annual master.
	 *
	 * @param createdBy the created by of this leave annual master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave annual master.
	 *
	 * @param groupId the group ID of this leave annual master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave annual master ID of this leave annual master.
	 *
	 * @param leaveAnnualMasterId the leave annual master ID of this leave annual master
	 */
	@Override
	public void setLeaveAnnualMasterId(long leaveAnnualMasterId) {
		model.setLeaveAnnualMasterId(leaveAnnualMasterId);
	}

	/**
	 * Sets the leave program master ID of this leave annual master.
	 *
	 * @param leaveProgramMasterId the leave program master ID of this leave annual master
	 */
	@Override
	public void setLeaveProgramMasterId(long leaveProgramMasterId) {
		model.setLeaveProgramMasterId(leaveProgramMasterId);
	}

	/**
	 * Sets the leave types ID of this leave annual master.
	 *
	 * @param leaveTypesId the leave types ID of this leave annual master
	 */
	@Override
	public void setLeaveTypesId(long leaveTypesId) {
		model.setLeaveTypesId(leaveTypesId);
	}

	/**
	 * Sets the max trainee apply leave of this leave annual master.
	 *
	 * @param maxTraineeApplyLeave the max trainee apply leave of this leave annual master
	 */
	@Override
	public void setMaxTraineeApplyLeave(int maxTraineeApplyLeave) {
		model.setMaxTraineeApplyLeave(maxTraineeApplyLeave);
	}

	/**
	 * Sets the modified by of this leave annual master.
	 *
	 * @param modifiedBy the modified by of this leave annual master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave annual master.
	 *
	 * @param modifiedDate the modified date of this leave annual master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of trainee taken leave of this leave annual master.
	 *
	 * @param noOfTraineeTakenLeave the no of trainee taken leave of this leave annual master
	 */
	@Override
	public void setNoOfTraineeTakenLeave(int noOfTraineeTakenLeave) {
		model.setNoOfTraineeTakenLeave(noOfTraineeTakenLeave);
	}

	/**
	 * Sets the primary key of this leave annual master.
	 *
	 * @param primaryKey the primary key of this leave annual master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the training level ID of this leave annual master.
	 *
	 * @param trainingLevelId the training level ID of this leave annual master
	 */
	@Override
	public void setTrainingLevelId(long trainingLevelId) {
		model.setTrainingLevelId(trainingLevelId);
	}

	/**
	 * Sets the uuid of this leave annual master.
	 *
	 * @param uuid the uuid of this leave annual master
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
	protected LeaveAnnualMasterWrapper wrap(
		LeaveAnnualMaster leaveAnnualMaster) {

		return new LeaveAnnualMasterWrapper(leaveAnnualMaster);
	}

}