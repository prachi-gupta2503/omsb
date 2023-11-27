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
 * This class is a wrapper for {@link LeaveAnnualMaxTrainee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTrainee
 * @generated
 */
public class LeaveAnnualMaxTraineeWrapper
	extends BaseModelWrapper<LeaveAnnualMaxTrainee>
	implements LeaveAnnualMaxTrainee, ModelWrapper<LeaveAnnualMaxTrainee> {

	public LeaveAnnualMaxTraineeWrapper(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		super(leaveAnnualMaxTrainee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveAnnualMaxTraineeId", getLeaveAnnualMaxTraineeId());
		attributes.put("leaveAnnualRuleId", getLeaveAnnualRuleId());
		attributes.put("trainingLevel", getTrainingLevel());
		attributes.put("block", getBlock());
		attributes.put("week", getWeek());
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

		Long leaveAnnualMaxTraineeId = (Long)attributes.get(
			"leaveAnnualMaxTraineeId");

		if (leaveAnnualMaxTraineeId != null) {
			setLeaveAnnualMaxTraineeId(leaveAnnualMaxTraineeId);
		}

		Long leaveAnnualRuleId = (Long)attributes.get("leaveAnnualRuleId");

		if (leaveAnnualRuleId != null) {
			setLeaveAnnualRuleId(leaveAnnualRuleId);
		}

		String trainingLevel = (String)attributes.get("trainingLevel");

		if (trainingLevel != null) {
			setTrainingLevel(trainingLevel);
		}

		Integer block = (Integer)attributes.get("block");

		if (block != null) {
			setBlock(block);
		}

		Integer week = (Integer)attributes.get("week");

		if (week != null) {
			setWeek(week);
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
	public LeaveAnnualMaxTrainee cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the block of this leave annual max trainee.
	 *
	 * @return the block of this leave annual max trainee
	 */
	@Override
	public int getBlock() {
		return model.getBlock();
	}

	/**
	 * Returns the company ID of this leave annual max trainee.
	 *
	 * @return the company ID of this leave annual max trainee
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave annual max trainee.
	 *
	 * @return the create date of this leave annual max trainee
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave annual max trainee.
	 *
	 * @return the created by of this leave annual max trainee
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
	 * Returns the group ID of this leave annual max trainee.
	 *
	 * @return the group ID of this leave annual max trainee
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave annual max trainee ID of this leave annual max trainee.
	 *
	 * @return the leave annual max trainee ID of this leave annual max trainee
	 */
	@Override
	public long getLeaveAnnualMaxTraineeId() {
		return model.getLeaveAnnualMaxTraineeId();
	}

	/**
	 * Returns the leave annual rule ID of this leave annual max trainee.
	 *
	 * @return the leave annual rule ID of this leave annual max trainee
	 */
	@Override
	public long getLeaveAnnualRuleId() {
		return model.getLeaveAnnualRuleId();
	}

	/**
	 * Returns the max trainee apply leave of this leave annual max trainee.
	 *
	 * @return the max trainee apply leave of this leave annual max trainee
	 */
	@Override
	public int getMaxTraineeApplyLeave() {
		return model.getMaxTraineeApplyLeave();
	}

	/**
	 * Returns the modified by of this leave annual max trainee.
	 *
	 * @return the modified by of this leave annual max trainee
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave annual max trainee.
	 *
	 * @return the modified date of this leave annual max trainee
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of trainee taken leave of this leave annual max trainee.
	 *
	 * @return the no of trainee taken leave of this leave annual max trainee
	 */
	@Override
	public int getNoOfTraineeTakenLeave() {
		return model.getNoOfTraineeTakenLeave();
	}

	/**
	 * Returns the primary key of this leave annual max trainee.
	 *
	 * @return the primary key of this leave annual max trainee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the training level of this leave annual max trainee.
	 *
	 * @return the training level of this leave annual max trainee
	 */
	@Override
	public String getTrainingLevel() {
		return model.getTrainingLevel();
	}

	/**
	 * Returns the localized training level of this leave annual max trainee in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized training level of this leave annual max trainee
	 */
	@Override
	public String getTrainingLevel(java.util.Locale locale) {
		return model.getTrainingLevel(locale);
	}

	/**
	 * Returns the localized training level of this leave annual max trainee in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training level of this leave annual max trainee. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTrainingLevel(
		java.util.Locale locale, boolean useDefault) {

		return model.getTrainingLevel(locale, useDefault);
	}

	/**
	 * Returns the localized training level of this leave annual max trainee in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized training level of this leave annual max trainee
	 */
	@Override
	public String getTrainingLevel(String languageId) {
		return model.getTrainingLevel(languageId);
	}

	/**
	 * Returns the localized training level of this leave annual max trainee in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training level of this leave annual max trainee
	 */
	@Override
	public String getTrainingLevel(String languageId, boolean useDefault) {
		return model.getTrainingLevel(languageId, useDefault);
	}

	@Override
	public String getTrainingLevelCurrentLanguageId() {
		return model.getTrainingLevelCurrentLanguageId();
	}

	@Override
	public String getTrainingLevelCurrentValue() {
		return model.getTrainingLevelCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized training levels of this leave annual max trainee.
	 *
	 * @return the locales and localized training levels of this leave annual max trainee
	 */
	@Override
	public Map<java.util.Locale, String> getTrainingLevelMap() {
		return model.getTrainingLevelMap();
	}

	/**
	 * Returns the uuid of this leave annual max trainee.
	 *
	 * @return the uuid of this leave annual max trainee
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the week of this leave annual max trainee.
	 *
	 * @return the week of this leave annual max trainee
	 */
	@Override
	public int getWeek() {
		return model.getWeek();
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
	 * Sets the block of this leave annual max trainee.
	 *
	 * @param block the block of this leave annual max trainee
	 */
	@Override
	public void setBlock(int block) {
		model.setBlock(block);
	}

	/**
	 * Sets the company ID of this leave annual max trainee.
	 *
	 * @param companyId the company ID of this leave annual max trainee
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave annual max trainee.
	 *
	 * @param createDate the create date of this leave annual max trainee
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave annual max trainee.
	 *
	 * @param createdBy the created by of this leave annual max trainee
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave annual max trainee.
	 *
	 * @param groupId the group ID of this leave annual max trainee
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave annual max trainee ID of this leave annual max trainee.
	 *
	 * @param leaveAnnualMaxTraineeId the leave annual max trainee ID of this leave annual max trainee
	 */
	@Override
	public void setLeaveAnnualMaxTraineeId(long leaveAnnualMaxTraineeId) {
		model.setLeaveAnnualMaxTraineeId(leaveAnnualMaxTraineeId);
	}

	/**
	 * Sets the leave annual rule ID of this leave annual max trainee.
	 *
	 * @param leaveAnnualRuleId the leave annual rule ID of this leave annual max trainee
	 */
	@Override
	public void setLeaveAnnualRuleId(long leaveAnnualRuleId) {
		model.setLeaveAnnualRuleId(leaveAnnualRuleId);
	}

	/**
	 * Sets the max trainee apply leave of this leave annual max trainee.
	 *
	 * @param maxTraineeApplyLeave the max trainee apply leave of this leave annual max trainee
	 */
	@Override
	public void setMaxTraineeApplyLeave(int maxTraineeApplyLeave) {
		model.setMaxTraineeApplyLeave(maxTraineeApplyLeave);
	}

	/**
	 * Sets the modified by of this leave annual max trainee.
	 *
	 * @param modifiedBy the modified by of this leave annual max trainee
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave annual max trainee.
	 *
	 * @param modifiedDate the modified date of this leave annual max trainee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of trainee taken leave of this leave annual max trainee.
	 *
	 * @param noOfTraineeTakenLeave the no of trainee taken leave of this leave annual max trainee
	 */
	@Override
	public void setNoOfTraineeTakenLeave(int noOfTraineeTakenLeave) {
		model.setNoOfTraineeTakenLeave(noOfTraineeTakenLeave);
	}

	/**
	 * Sets the primary key of this leave annual max trainee.
	 *
	 * @param primaryKey the primary key of this leave annual max trainee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the training level of this leave annual max trainee.
	 *
	 * @param trainingLevel the training level of this leave annual max trainee
	 */
	@Override
	public void setTrainingLevel(String trainingLevel) {
		model.setTrainingLevel(trainingLevel);
	}

	/**
	 * Sets the localized training level of this leave annual max trainee in the language.
	 *
	 * @param trainingLevel the localized training level of this leave annual max trainee
	 * @param locale the locale of the language
	 */
	@Override
	public void setTrainingLevel(
		String trainingLevel, java.util.Locale locale) {

		model.setTrainingLevel(trainingLevel, locale);
	}

	/**
	 * Sets the localized training level of this leave annual max trainee in the language, and sets the default locale.
	 *
	 * @param trainingLevel the localized training level of this leave annual max trainee
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingLevel(
		String trainingLevel, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTrainingLevel(trainingLevel, locale, defaultLocale);
	}

	@Override
	public void setTrainingLevelCurrentLanguageId(String languageId) {
		model.setTrainingLevelCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized training levels of this leave annual max trainee from the map of locales and localized training levels.
	 *
	 * @param trainingLevelMap the locales and localized training levels of this leave annual max trainee
	 */
	@Override
	public void setTrainingLevelMap(
		Map<java.util.Locale, String> trainingLevelMap) {

		model.setTrainingLevelMap(trainingLevelMap);
	}

	/**
	 * Sets the localized training levels of this leave annual max trainee from the map of locales and localized training levels, and sets the default locale.
	 *
	 * @param trainingLevelMap the locales and localized training levels of this leave annual max trainee
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingLevelMap(
		Map<java.util.Locale, String> trainingLevelMap,
		java.util.Locale defaultLocale) {

		model.setTrainingLevelMap(trainingLevelMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this leave annual max trainee.
	 *
	 * @param uuid the uuid of this leave annual max trainee
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the week of this leave annual max trainee.
	 *
	 * @param week the week of this leave annual max trainee
	 */
	@Override
	public void setWeek(int week) {
		model.setWeek(week);
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
	protected LeaveAnnualMaxTraineeWrapper wrap(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return new LeaveAnnualMaxTraineeWrapper(leaveAnnualMaxTrainee);
	}

}