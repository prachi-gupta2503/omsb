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
 * This class is a wrapper for {@link ProgramMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMaster
 * @generated
 */
public class ProgramMasterWrapper
	extends BaseModelWrapper<ProgramMaster>
	implements ModelWrapper<ProgramMaster>, ProgramMaster {

	public ProgramMasterWrapper(ProgramMaster programMaster) {
		super(programMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("programMasterId", getProgramMasterId());
		attributes.put("programTypeId", getProgramTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("programCode", getProgramCode());
		attributes.put("programName", getProgramName());
		attributes.put("programDescription", getProgramDescription());
		attributes.put("establishmentDate", getEstablishmentDate());
		attributes.put("programVision", getProgramVision());
		attributes.put("programMission", getProgramMission());
		attributes.put("programStatus", getProgramStatus());
		attributes.put("programObjectives", getProgramObjectives());
		attributes.put(
			"programAdmissionRequirements", getProgramAdmissionRequirements());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programMasterId = (Long)attributes.get("programMasterId");

		if (programMasterId != null) {
			setProgramMasterId(programMasterId);
		}

		Long programTypeId = (Long)attributes.get("programTypeId");

		if (programTypeId != null) {
			setProgramTypeId(programTypeId);
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

		String programCode = (String)attributes.get("programCode");

		if (programCode != null) {
			setProgramCode(programCode);
		}

		String programName = (String)attributes.get("programName");

		if (programName != null) {
			setProgramName(programName);
		}

		String programDescription = (String)attributes.get(
			"programDescription");

		if (programDescription != null) {
			setProgramDescription(programDescription);
		}

		Date establishmentDate = (Date)attributes.get("establishmentDate");

		if (establishmentDate != null) {
			setEstablishmentDate(establishmentDate);
		}

		String programVision = (String)attributes.get("programVision");

		if (programVision != null) {
			setProgramVision(programVision);
		}

		String programMission = (String)attributes.get("programMission");

		if (programMission != null) {
			setProgramMission(programMission);
		}

		Boolean programStatus = (Boolean)attributes.get("programStatus");

		if (programStatus != null) {
			setProgramStatus(programStatus);
		}

		String programObjectives = (String)attributes.get("programObjectives");

		if (programObjectives != null) {
			setProgramObjectives(programObjectives);
		}

		String programAdmissionRequirements = (String)attributes.get(
			"programAdmissionRequirements");

		if (programAdmissionRequirements != null) {
			setProgramAdmissionRequirements(programAdmissionRequirements);
		}
	}

	@Override
	public ProgramMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this program master.
	 *
	 * @return the company ID of this program master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program master.
	 *
	 * @return the create date of this program master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the establishment date of this program master.
	 *
	 * @return the establishment date of this program master
	 */
	@Override
	public Date getEstablishmentDate() {
		return model.getEstablishmentDate();
	}

	/**
	 * Returns the group ID of this program master.
	 *
	 * @return the group ID of this program master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this program master.
	 *
	 * @return the modified date of this program master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program master.
	 *
	 * @return the primary key of this program master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program admission requirements of this program master.
	 *
	 * @return the program admission requirements of this program master
	 */
	@Override
	public String getProgramAdmissionRequirements() {
		return model.getProgramAdmissionRequirements();
	}

	/**
	 * Returns the localized program admission requirements of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program admission requirements of this program master
	 */
	@Override
	public String getProgramAdmissionRequirements(java.util.Locale locale) {
		return model.getProgramAdmissionRequirements(locale);
	}

	/**
	 * Returns the localized program admission requirements of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program admission requirements of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramAdmissionRequirements(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramAdmissionRequirements(locale, useDefault);
	}

	/**
	 * Returns the localized program admission requirements of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program admission requirements of this program master
	 */
	@Override
	public String getProgramAdmissionRequirements(String languageId) {
		return model.getProgramAdmissionRequirements(languageId);
	}

	/**
	 * Returns the localized program admission requirements of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program admission requirements of this program master
	 */
	@Override
	public String getProgramAdmissionRequirements(
		String languageId, boolean useDefault) {

		return model.getProgramAdmissionRequirements(languageId, useDefault);
	}

	@Override
	public String getProgramAdmissionRequirementsCurrentLanguageId() {
		return model.getProgramAdmissionRequirementsCurrentLanguageId();
	}

	@Override
	public String getProgramAdmissionRequirementsCurrentValue() {
		return model.getProgramAdmissionRequirementsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program admission requirementses of this program master.
	 *
	 * @return the locales and localized program admission requirementses of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramAdmissionRequirementsMap() {
		return model.getProgramAdmissionRequirementsMap();
	}

	/**
	 * Returns the program code of this program master.
	 *
	 * @return the program code of this program master
	 */
	@Override
	public String getProgramCode() {
		return model.getProgramCode();
	}

	/**
	 * Returns the localized program code of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program code of this program master
	 */
	@Override
	public String getProgramCode(java.util.Locale locale) {
		return model.getProgramCode(locale);
	}

	/**
	 * Returns the localized program code of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program code of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramCode(java.util.Locale locale, boolean useDefault) {
		return model.getProgramCode(locale, useDefault);
	}

	/**
	 * Returns the localized program code of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program code of this program master
	 */
	@Override
	public String getProgramCode(String languageId) {
		return model.getProgramCode(languageId);
	}

	/**
	 * Returns the localized program code of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program code of this program master
	 */
	@Override
	public String getProgramCode(String languageId, boolean useDefault) {
		return model.getProgramCode(languageId, useDefault);
	}

	@Override
	public String getProgramCodeCurrentLanguageId() {
		return model.getProgramCodeCurrentLanguageId();
	}

	@Override
	public String getProgramCodeCurrentValue() {
		return model.getProgramCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program codes of this program master.
	 *
	 * @return the locales and localized program codes of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramCodeMap() {
		return model.getProgramCodeMap();
	}

	/**
	 * Returns the program description of this program master.
	 *
	 * @return the program description of this program master
	 */
	@Override
	public String getProgramDescription() {
		return model.getProgramDescription();
	}

	/**
	 * Returns the localized program description of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program description of this program master
	 */
	@Override
	public String getProgramDescription(java.util.Locale locale) {
		return model.getProgramDescription(locale);
	}

	/**
	 * Returns the localized program description of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program description of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramDescription(locale, useDefault);
	}

	/**
	 * Returns the localized program description of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program description of this program master
	 */
	@Override
	public String getProgramDescription(String languageId) {
		return model.getProgramDescription(languageId);
	}

	/**
	 * Returns the localized program description of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program description of this program master
	 */
	@Override
	public String getProgramDescription(String languageId, boolean useDefault) {
		return model.getProgramDescription(languageId, useDefault);
	}

	@Override
	public String getProgramDescriptionCurrentLanguageId() {
		return model.getProgramDescriptionCurrentLanguageId();
	}

	@Override
	public String getProgramDescriptionCurrentValue() {
		return model.getProgramDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program descriptions of this program master.
	 *
	 * @return the locales and localized program descriptions of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramDescriptionMap() {
		return model.getProgramDescriptionMap();
	}

	/**
	 * Returns the program master ID of this program master.
	 *
	 * @return the program master ID of this program master
	 */
	@Override
	public long getProgramMasterId() {
		return model.getProgramMasterId();
	}

	/**
	 * Returns the program mission of this program master.
	 *
	 * @return the program mission of this program master
	 */
	@Override
	public String getProgramMission() {
		return model.getProgramMission();
	}

	/**
	 * Returns the localized program mission of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program mission of this program master
	 */
	@Override
	public String getProgramMission(java.util.Locale locale) {
		return model.getProgramMission(locale);
	}

	/**
	 * Returns the localized program mission of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program mission of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramMission(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramMission(locale, useDefault);
	}

	/**
	 * Returns the localized program mission of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program mission of this program master
	 */
	@Override
	public String getProgramMission(String languageId) {
		return model.getProgramMission(languageId);
	}

	/**
	 * Returns the localized program mission of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program mission of this program master
	 */
	@Override
	public String getProgramMission(String languageId, boolean useDefault) {
		return model.getProgramMission(languageId, useDefault);
	}

	@Override
	public String getProgramMissionCurrentLanguageId() {
		return model.getProgramMissionCurrentLanguageId();
	}

	@Override
	public String getProgramMissionCurrentValue() {
		return model.getProgramMissionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program missions of this program master.
	 *
	 * @return the locales and localized program missions of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramMissionMap() {
		return model.getProgramMissionMap();
	}

	/**
	 * Returns the program name of this program master.
	 *
	 * @return the program name of this program master
	 */
	@Override
	public String getProgramName() {
		return model.getProgramName();
	}

	/**
	 * Returns the localized program name of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program name of this program master
	 */
	@Override
	public String getProgramName(java.util.Locale locale) {
		return model.getProgramName(locale);
	}

	/**
	 * Returns the localized program name of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program name of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramName(java.util.Locale locale, boolean useDefault) {
		return model.getProgramName(locale, useDefault);
	}

	/**
	 * Returns the localized program name of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program name of this program master
	 */
	@Override
	public String getProgramName(String languageId) {
		return model.getProgramName(languageId);
	}

	/**
	 * Returns the localized program name of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program name of this program master
	 */
	@Override
	public String getProgramName(String languageId, boolean useDefault) {
		return model.getProgramName(languageId, useDefault);
	}

	@Override
	public String getProgramNameCurrentLanguageId() {
		return model.getProgramNameCurrentLanguageId();
	}

	@Override
	public String getProgramNameCurrentValue() {
		return model.getProgramNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program names of this program master.
	 *
	 * @return the locales and localized program names of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramNameMap() {
		return model.getProgramNameMap();
	}

	/**
	 * Returns the program objectives of this program master.
	 *
	 * @return the program objectives of this program master
	 */
	@Override
	public String getProgramObjectives() {
		return model.getProgramObjectives();
	}

	/**
	 * Returns the localized program objectives of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program objectives of this program master
	 */
	@Override
	public String getProgramObjectives(java.util.Locale locale) {
		return model.getProgramObjectives(locale);
	}

	/**
	 * Returns the localized program objectives of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program objectives of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramObjectives(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramObjectives(locale, useDefault);
	}

	/**
	 * Returns the localized program objectives of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program objectives of this program master
	 */
	@Override
	public String getProgramObjectives(String languageId) {
		return model.getProgramObjectives(languageId);
	}

	/**
	 * Returns the localized program objectives of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program objectives of this program master
	 */
	@Override
	public String getProgramObjectives(String languageId, boolean useDefault) {
		return model.getProgramObjectives(languageId, useDefault);
	}

	@Override
	public String getProgramObjectivesCurrentLanguageId() {
		return model.getProgramObjectivesCurrentLanguageId();
	}

	@Override
	public String getProgramObjectivesCurrentValue() {
		return model.getProgramObjectivesCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program objectiveses of this program master.
	 *
	 * @return the locales and localized program objectiveses of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramObjectivesMap() {
		return model.getProgramObjectivesMap();
	}

	/**
	 * Returns the program status of this program master.
	 *
	 * @return the program status of this program master
	 */
	@Override
	public Boolean getProgramStatus() {
		return model.getProgramStatus();
	}

	/**
	 * Returns the program type ID of this program master.
	 *
	 * @return the program type ID of this program master
	 */
	@Override
	public long getProgramTypeId() {
		return model.getProgramTypeId();
	}

	/**
	 * Returns the program vision of this program master.
	 *
	 * @return the program vision of this program master
	 */
	@Override
	public String getProgramVision() {
		return model.getProgramVision();
	}

	/**
	 * Returns the localized program vision of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program vision of this program master
	 */
	@Override
	public String getProgramVision(java.util.Locale locale) {
		return model.getProgramVision(locale);
	}

	/**
	 * Returns the localized program vision of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program vision of this program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramVision(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramVision(locale, useDefault);
	}

	/**
	 * Returns the localized program vision of this program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program vision of this program master
	 */
	@Override
	public String getProgramVision(String languageId) {
		return model.getProgramVision(languageId);
	}

	/**
	 * Returns the localized program vision of this program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program vision of this program master
	 */
	@Override
	public String getProgramVision(String languageId, boolean useDefault) {
		return model.getProgramVision(languageId, useDefault);
	}

	@Override
	public String getProgramVisionCurrentLanguageId() {
		return model.getProgramVisionCurrentLanguageId();
	}

	@Override
	public String getProgramVisionCurrentValue() {
		return model.getProgramVisionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program visions of this program master.
	 *
	 * @return the locales and localized program visions of this program master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramVisionMap() {
		return model.getProgramVisionMap();
	}

	/**
	 * Returns the uuid of this program master.
	 *
	 * @return the uuid of this program master
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
	 * Sets the company ID of this program master.
	 *
	 * @param companyId the company ID of this program master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program master.
	 *
	 * @param createDate the create date of this program master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the establishment date of this program master.
	 *
	 * @param establishmentDate the establishment date of this program master
	 */
	@Override
	public void setEstablishmentDate(Date establishmentDate) {
		model.setEstablishmentDate(establishmentDate);
	}

	/**
	 * Sets the group ID of this program master.
	 *
	 * @param groupId the group ID of this program master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this program master.
	 *
	 * @param modifiedDate the modified date of this program master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program master.
	 *
	 * @param primaryKey the primary key of this program master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program admission requirements of this program master.
	 *
	 * @param programAdmissionRequirements the program admission requirements of this program master
	 */
	@Override
	public void setProgramAdmissionRequirements(
		String programAdmissionRequirements) {

		model.setProgramAdmissionRequirements(programAdmissionRequirements);
	}

	/**
	 * Sets the localized program admission requirements of this program master in the language.
	 *
	 * @param programAdmissionRequirements the localized program admission requirements of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramAdmissionRequirements(
		String programAdmissionRequirements, java.util.Locale locale) {

		model.setProgramAdmissionRequirements(
			programAdmissionRequirements, locale);
	}

	/**
	 * Sets the localized program admission requirements of this program master in the language, and sets the default locale.
	 *
	 * @param programAdmissionRequirements the localized program admission requirements of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramAdmissionRequirements(
		String programAdmissionRequirements, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramAdmissionRequirements(
			programAdmissionRequirements, locale, defaultLocale);
	}

	@Override
	public void setProgramAdmissionRequirementsCurrentLanguageId(
		String languageId) {

		model.setProgramAdmissionRequirementsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program admission requirementses of this program master from the map of locales and localized program admission requirementses.
	 *
	 * @param programAdmissionRequirementsMap the locales and localized program admission requirementses of this program master
	 */
	@Override
	public void setProgramAdmissionRequirementsMap(
		Map<java.util.Locale, String> programAdmissionRequirementsMap) {

		model.setProgramAdmissionRequirementsMap(
			programAdmissionRequirementsMap);
	}

	/**
	 * Sets the localized program admission requirementses of this program master from the map of locales and localized program admission requirementses, and sets the default locale.
	 *
	 * @param programAdmissionRequirementsMap the locales and localized program admission requirementses of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramAdmissionRequirementsMap(
		Map<java.util.Locale, String> programAdmissionRequirementsMap,
		java.util.Locale defaultLocale) {

		model.setProgramAdmissionRequirementsMap(
			programAdmissionRequirementsMap, defaultLocale);
	}

	/**
	 * Sets the program code of this program master.
	 *
	 * @param programCode the program code of this program master
	 */
	@Override
	public void setProgramCode(String programCode) {
		model.setProgramCode(programCode);
	}

	/**
	 * Sets the localized program code of this program master in the language.
	 *
	 * @param programCode the localized program code of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramCode(String programCode, java.util.Locale locale) {
		model.setProgramCode(programCode, locale);
	}

	/**
	 * Sets the localized program code of this program master in the language, and sets the default locale.
	 *
	 * @param programCode the localized program code of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramCode(
		String programCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramCode(programCode, locale, defaultLocale);
	}

	@Override
	public void setProgramCodeCurrentLanguageId(String languageId) {
		model.setProgramCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program codes of this program master from the map of locales and localized program codes.
	 *
	 * @param programCodeMap the locales and localized program codes of this program master
	 */
	@Override
	public void setProgramCodeMap(
		Map<java.util.Locale, String> programCodeMap) {

		model.setProgramCodeMap(programCodeMap);
	}

	/**
	 * Sets the localized program codes of this program master from the map of locales and localized program codes, and sets the default locale.
	 *
	 * @param programCodeMap the locales and localized program codes of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramCodeMap(
		Map<java.util.Locale, String> programCodeMap,
		java.util.Locale defaultLocale) {

		model.setProgramCodeMap(programCodeMap, defaultLocale);
	}

	/**
	 * Sets the program description of this program master.
	 *
	 * @param programDescription the program description of this program master
	 */
	@Override
	public void setProgramDescription(String programDescription) {
		model.setProgramDescription(programDescription);
	}

	/**
	 * Sets the localized program description of this program master in the language.
	 *
	 * @param programDescription the localized program description of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramDescription(
		String programDescription, java.util.Locale locale) {

		model.setProgramDescription(programDescription, locale);
	}

	/**
	 * Sets the localized program description of this program master in the language, and sets the default locale.
	 *
	 * @param programDescription the localized program description of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramDescription(
		String programDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramDescription(programDescription, locale, defaultLocale);
	}

	@Override
	public void setProgramDescriptionCurrentLanguageId(String languageId) {
		model.setProgramDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program descriptions of this program master from the map of locales and localized program descriptions.
	 *
	 * @param programDescriptionMap the locales and localized program descriptions of this program master
	 */
	@Override
	public void setProgramDescriptionMap(
		Map<java.util.Locale, String> programDescriptionMap) {

		model.setProgramDescriptionMap(programDescriptionMap);
	}

	/**
	 * Sets the localized program descriptions of this program master from the map of locales and localized program descriptions, and sets the default locale.
	 *
	 * @param programDescriptionMap the locales and localized program descriptions of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramDescriptionMap(
		Map<java.util.Locale, String> programDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setProgramDescriptionMap(programDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the program master ID of this program master.
	 *
	 * @param programMasterId the program master ID of this program master
	 */
	@Override
	public void setProgramMasterId(long programMasterId) {
		model.setProgramMasterId(programMasterId);
	}

	/**
	 * Sets the program mission of this program master.
	 *
	 * @param programMission the program mission of this program master
	 */
	@Override
	public void setProgramMission(String programMission) {
		model.setProgramMission(programMission);
	}

	/**
	 * Sets the localized program mission of this program master in the language.
	 *
	 * @param programMission the localized program mission of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramMission(
		String programMission, java.util.Locale locale) {

		model.setProgramMission(programMission, locale);
	}

	/**
	 * Sets the localized program mission of this program master in the language, and sets the default locale.
	 *
	 * @param programMission the localized program mission of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramMission(
		String programMission, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramMission(programMission, locale, defaultLocale);
	}

	@Override
	public void setProgramMissionCurrentLanguageId(String languageId) {
		model.setProgramMissionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program missions of this program master from the map of locales and localized program missions.
	 *
	 * @param programMissionMap the locales and localized program missions of this program master
	 */
	@Override
	public void setProgramMissionMap(
		Map<java.util.Locale, String> programMissionMap) {

		model.setProgramMissionMap(programMissionMap);
	}

	/**
	 * Sets the localized program missions of this program master from the map of locales and localized program missions, and sets the default locale.
	 *
	 * @param programMissionMap the locales and localized program missions of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramMissionMap(
		Map<java.util.Locale, String> programMissionMap,
		java.util.Locale defaultLocale) {

		model.setProgramMissionMap(programMissionMap, defaultLocale);
	}

	/**
	 * Sets the program name of this program master.
	 *
	 * @param programName the program name of this program master
	 */
	@Override
	public void setProgramName(String programName) {
		model.setProgramName(programName);
	}

	/**
	 * Sets the localized program name of this program master in the language.
	 *
	 * @param programName the localized program name of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramName(String programName, java.util.Locale locale) {
		model.setProgramName(programName, locale);
	}

	/**
	 * Sets the localized program name of this program master in the language, and sets the default locale.
	 *
	 * @param programName the localized program name of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramName(
		String programName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramName(programName, locale, defaultLocale);
	}

	@Override
	public void setProgramNameCurrentLanguageId(String languageId) {
		model.setProgramNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program names of this program master from the map of locales and localized program names.
	 *
	 * @param programNameMap the locales and localized program names of this program master
	 */
	@Override
	public void setProgramNameMap(
		Map<java.util.Locale, String> programNameMap) {

		model.setProgramNameMap(programNameMap);
	}

	/**
	 * Sets the localized program names of this program master from the map of locales and localized program names, and sets the default locale.
	 *
	 * @param programNameMap the locales and localized program names of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramNameMap(
		Map<java.util.Locale, String> programNameMap,
		java.util.Locale defaultLocale) {

		model.setProgramNameMap(programNameMap, defaultLocale);
	}

	/**
	 * Sets the program objectives of this program master.
	 *
	 * @param programObjectives the program objectives of this program master
	 */
	@Override
	public void setProgramObjectives(String programObjectives) {
		model.setProgramObjectives(programObjectives);
	}

	/**
	 * Sets the localized program objectives of this program master in the language.
	 *
	 * @param programObjectives the localized program objectives of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramObjectives(
		String programObjectives, java.util.Locale locale) {

		model.setProgramObjectives(programObjectives, locale);
	}

	/**
	 * Sets the localized program objectives of this program master in the language, and sets the default locale.
	 *
	 * @param programObjectives the localized program objectives of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramObjectives(
		String programObjectives, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramObjectives(programObjectives, locale, defaultLocale);
	}

	@Override
	public void setProgramObjectivesCurrentLanguageId(String languageId) {
		model.setProgramObjectivesCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program objectiveses of this program master from the map of locales and localized program objectiveses.
	 *
	 * @param programObjectivesMap the locales and localized program objectiveses of this program master
	 */
	@Override
	public void setProgramObjectivesMap(
		Map<java.util.Locale, String> programObjectivesMap) {

		model.setProgramObjectivesMap(programObjectivesMap);
	}

	/**
	 * Sets the localized program objectiveses of this program master from the map of locales and localized program objectiveses, and sets the default locale.
	 *
	 * @param programObjectivesMap the locales and localized program objectiveses of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramObjectivesMap(
		Map<java.util.Locale, String> programObjectivesMap,
		java.util.Locale defaultLocale) {

		model.setProgramObjectivesMap(programObjectivesMap, defaultLocale);
	}

	/**
	 * Sets the program status of this program master.
	 *
	 * @param programStatus the program status of this program master
	 */
	@Override
	public void setProgramStatus(Boolean programStatus) {
		model.setProgramStatus(programStatus);
	}

	/**
	 * Sets the program type ID of this program master.
	 *
	 * @param programTypeId the program type ID of this program master
	 */
	@Override
	public void setProgramTypeId(long programTypeId) {
		model.setProgramTypeId(programTypeId);
	}

	/**
	 * Sets the program vision of this program master.
	 *
	 * @param programVision the program vision of this program master
	 */
	@Override
	public void setProgramVision(String programVision) {
		model.setProgramVision(programVision);
	}

	/**
	 * Sets the localized program vision of this program master in the language.
	 *
	 * @param programVision the localized program vision of this program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramVision(
		String programVision, java.util.Locale locale) {

		model.setProgramVision(programVision, locale);
	}

	/**
	 * Sets the localized program vision of this program master in the language, and sets the default locale.
	 *
	 * @param programVision the localized program vision of this program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramVision(
		String programVision, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramVision(programVision, locale, defaultLocale);
	}

	@Override
	public void setProgramVisionCurrentLanguageId(String languageId) {
		model.setProgramVisionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program visions of this program master from the map of locales and localized program visions.
	 *
	 * @param programVisionMap the locales and localized program visions of this program master
	 */
	@Override
	public void setProgramVisionMap(
		Map<java.util.Locale, String> programVisionMap) {

		model.setProgramVisionMap(programVisionMap);
	}

	/**
	 * Sets the localized program visions of this program master from the map of locales and localized program visions, and sets the default locale.
	 *
	 * @param programVisionMap the locales and localized program visions of this program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramVisionMap(
		Map<java.util.Locale, String> programVisionMap,
		java.util.Locale defaultLocale) {

		model.setProgramVisionMap(programVisionMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this program master.
	 *
	 * @param uuid the uuid of this program master
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
	protected ProgramMasterWrapper wrap(ProgramMaster programMaster) {
		return new ProgramMasterWrapper(programMaster);
	}

}