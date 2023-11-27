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
 * This class is a wrapper for {@link RotationMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationMaster
 * @generated
 */
public class RotationMasterWrapper
	extends BaseModelWrapper<RotationMaster>
	implements ModelWrapper<RotationMaster>, RotationMaster {

	public RotationMasterWrapper(RotationMaster rotationMaster) {
		super(rotationMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rotationMasterId", getRotationMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rotationCode", getRotationCode());
		attributes.put("rotationShortName", getRotationShortName());
		attributes.put("rotationName", getRotationName());
		attributes.put("rotationStatus", getRotationStatus());
		attributes.put("rotationObjectives", getRotationObjectives());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rotationMasterId = (Long)attributes.get("rotationMasterId");

		if (rotationMasterId != null) {
			setRotationMasterId(rotationMasterId);
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

		String rotationCode = (String)attributes.get("rotationCode");

		if (rotationCode != null) {
			setRotationCode(rotationCode);
		}

		String rotationShortName = (String)attributes.get("rotationShortName");

		if (rotationShortName != null) {
			setRotationShortName(rotationShortName);
		}

		String rotationName = (String)attributes.get("rotationName");

		if (rotationName != null) {
			setRotationName(rotationName);
		}

		Boolean rotationStatus = (Boolean)attributes.get("rotationStatus");

		if (rotationStatus != null) {
			setRotationStatus(rotationStatus);
		}

		String rotationObjectives = (String)attributes.get(
			"rotationObjectives");

		if (rotationObjectives != null) {
			setRotationObjectives(rotationObjectives);
		}
	}

	@Override
	public RotationMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this rotation master.
	 *
	 * @return the company ID of this rotation master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this rotation master.
	 *
	 * @return the create date of this rotation master
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
	 * Returns the group ID of this rotation master.
	 *
	 * @return the group ID of this rotation master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this rotation master.
	 *
	 * @return the modified date of this rotation master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this rotation master.
	 *
	 * @return the primary key of this rotation master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rotation code of this rotation master.
	 *
	 * @return the rotation code of this rotation master
	 */
	@Override
	public String getRotationCode() {
		return model.getRotationCode();
	}

	/**
	 * Returns the localized rotation code of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation code of this rotation master
	 */
	@Override
	public String getRotationCode(java.util.Locale locale) {
		return model.getRotationCode(locale);
	}

	/**
	 * Returns the localized rotation code of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation code of this rotation master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRotationCode(java.util.Locale locale, boolean useDefault) {
		return model.getRotationCode(locale, useDefault);
	}

	/**
	 * Returns the localized rotation code of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation code of this rotation master
	 */
	@Override
	public String getRotationCode(String languageId) {
		return model.getRotationCode(languageId);
	}

	/**
	 * Returns the localized rotation code of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation code of this rotation master
	 */
	@Override
	public String getRotationCode(String languageId, boolean useDefault) {
		return model.getRotationCode(languageId, useDefault);
	}

	@Override
	public String getRotationCodeCurrentLanguageId() {
		return model.getRotationCodeCurrentLanguageId();
	}

	@Override
	public String getRotationCodeCurrentValue() {
		return model.getRotationCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized rotation codes of this rotation master.
	 *
	 * @return the locales and localized rotation codes of this rotation master
	 */
	@Override
	public Map<java.util.Locale, String> getRotationCodeMap() {
		return model.getRotationCodeMap();
	}

	/**
	 * Returns the rotation master ID of this rotation master.
	 *
	 * @return the rotation master ID of this rotation master
	 */
	@Override
	public long getRotationMasterId() {
		return model.getRotationMasterId();
	}

	/**
	 * Returns the rotation name of this rotation master.
	 *
	 * @return the rotation name of this rotation master
	 */
	@Override
	public String getRotationName() {
		return model.getRotationName();
	}

	/**
	 * Returns the localized rotation name of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation name of this rotation master
	 */
	@Override
	public String getRotationName(java.util.Locale locale) {
		return model.getRotationName(locale);
	}

	/**
	 * Returns the localized rotation name of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation name of this rotation master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRotationName(java.util.Locale locale, boolean useDefault) {
		return model.getRotationName(locale, useDefault);
	}

	/**
	 * Returns the localized rotation name of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation name of this rotation master
	 */
	@Override
	public String getRotationName(String languageId) {
		return model.getRotationName(languageId);
	}

	/**
	 * Returns the localized rotation name of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation name of this rotation master
	 */
	@Override
	public String getRotationName(String languageId, boolean useDefault) {
		return model.getRotationName(languageId, useDefault);
	}

	@Override
	public String getRotationNameCurrentLanguageId() {
		return model.getRotationNameCurrentLanguageId();
	}

	@Override
	public String getRotationNameCurrentValue() {
		return model.getRotationNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized rotation names of this rotation master.
	 *
	 * @return the locales and localized rotation names of this rotation master
	 */
	@Override
	public Map<java.util.Locale, String> getRotationNameMap() {
		return model.getRotationNameMap();
	}

	/**
	 * Returns the rotation objectives of this rotation master.
	 *
	 * @return the rotation objectives of this rotation master
	 */
	@Override
	public String getRotationObjectives() {
		return model.getRotationObjectives();
	}

	/**
	 * Returns the localized rotation objectives of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation objectives of this rotation master
	 */
	@Override
	public String getRotationObjectives(java.util.Locale locale) {
		return model.getRotationObjectives(locale);
	}

	/**
	 * Returns the localized rotation objectives of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation objectives of this rotation master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRotationObjectives(
		java.util.Locale locale, boolean useDefault) {

		return model.getRotationObjectives(locale, useDefault);
	}

	/**
	 * Returns the localized rotation objectives of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation objectives of this rotation master
	 */
	@Override
	public String getRotationObjectives(String languageId) {
		return model.getRotationObjectives(languageId);
	}

	/**
	 * Returns the localized rotation objectives of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation objectives of this rotation master
	 */
	@Override
	public String getRotationObjectives(String languageId, boolean useDefault) {
		return model.getRotationObjectives(languageId, useDefault);
	}

	@Override
	public String getRotationObjectivesCurrentLanguageId() {
		return model.getRotationObjectivesCurrentLanguageId();
	}

	@Override
	public String getRotationObjectivesCurrentValue() {
		return model.getRotationObjectivesCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized rotation objectiveses of this rotation master.
	 *
	 * @return the locales and localized rotation objectiveses of this rotation master
	 */
	@Override
	public Map<java.util.Locale, String> getRotationObjectivesMap() {
		return model.getRotationObjectivesMap();
	}

	/**
	 * Returns the rotation short name of this rotation master.
	 *
	 * @return the rotation short name of this rotation master
	 */
	@Override
	public String getRotationShortName() {
		return model.getRotationShortName();
	}

	/**
	 * Returns the localized rotation short name of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation short name of this rotation master
	 */
	@Override
	public String getRotationShortName(java.util.Locale locale) {
		return model.getRotationShortName(locale);
	}

	/**
	 * Returns the localized rotation short name of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation short name of this rotation master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRotationShortName(
		java.util.Locale locale, boolean useDefault) {

		return model.getRotationShortName(locale, useDefault);
	}

	/**
	 * Returns the localized rotation short name of this rotation master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation short name of this rotation master
	 */
	@Override
	public String getRotationShortName(String languageId) {
		return model.getRotationShortName(languageId);
	}

	/**
	 * Returns the localized rotation short name of this rotation master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation short name of this rotation master
	 */
	@Override
	public String getRotationShortName(String languageId, boolean useDefault) {
		return model.getRotationShortName(languageId, useDefault);
	}

	@Override
	public String getRotationShortNameCurrentLanguageId() {
		return model.getRotationShortNameCurrentLanguageId();
	}

	@Override
	public String getRotationShortNameCurrentValue() {
		return model.getRotationShortNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized rotation short names of this rotation master.
	 *
	 * @return the locales and localized rotation short names of this rotation master
	 */
	@Override
	public Map<java.util.Locale, String> getRotationShortNameMap() {
		return model.getRotationShortNameMap();
	}

	/**
	 * Returns the rotation status of this rotation master.
	 *
	 * @return the rotation status of this rotation master
	 */
	@Override
	public Boolean getRotationStatus() {
		return model.getRotationStatus();
	}

	/**
	 * Returns the uuid of this rotation master.
	 *
	 * @return the uuid of this rotation master
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
	 * Sets the company ID of this rotation master.
	 *
	 * @param companyId the company ID of this rotation master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this rotation master.
	 *
	 * @param createDate the create date of this rotation master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this rotation master.
	 *
	 * @param groupId the group ID of this rotation master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this rotation master.
	 *
	 * @param modifiedDate the modified date of this rotation master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this rotation master.
	 *
	 * @param primaryKey the primary key of this rotation master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rotation code of this rotation master.
	 *
	 * @param rotationCode the rotation code of this rotation master
	 */
	@Override
	public void setRotationCode(String rotationCode) {
		model.setRotationCode(rotationCode);
	}

	/**
	 * Sets the localized rotation code of this rotation master in the language.
	 *
	 * @param rotationCode the localized rotation code of this rotation master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRotationCode(String rotationCode, java.util.Locale locale) {
		model.setRotationCode(rotationCode, locale);
	}

	/**
	 * Sets the localized rotation code of this rotation master in the language, and sets the default locale.
	 *
	 * @param rotationCode the localized rotation code of this rotation master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationCode(
		String rotationCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRotationCode(rotationCode, locale, defaultLocale);
	}

	@Override
	public void setRotationCodeCurrentLanguageId(String languageId) {
		model.setRotationCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized rotation codes of this rotation master from the map of locales and localized rotation codes.
	 *
	 * @param rotationCodeMap the locales and localized rotation codes of this rotation master
	 */
	@Override
	public void setRotationCodeMap(
		Map<java.util.Locale, String> rotationCodeMap) {

		model.setRotationCodeMap(rotationCodeMap);
	}

	/**
	 * Sets the localized rotation codes of this rotation master from the map of locales and localized rotation codes, and sets the default locale.
	 *
	 * @param rotationCodeMap the locales and localized rotation codes of this rotation master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationCodeMap(
		Map<java.util.Locale, String> rotationCodeMap,
		java.util.Locale defaultLocale) {

		model.setRotationCodeMap(rotationCodeMap, defaultLocale);
	}

	/**
	 * Sets the rotation master ID of this rotation master.
	 *
	 * @param rotationMasterId the rotation master ID of this rotation master
	 */
	@Override
	public void setRotationMasterId(long rotationMasterId) {
		model.setRotationMasterId(rotationMasterId);
	}

	/**
	 * Sets the rotation name of this rotation master.
	 *
	 * @param rotationName the rotation name of this rotation master
	 */
	@Override
	public void setRotationName(String rotationName) {
		model.setRotationName(rotationName);
	}

	/**
	 * Sets the localized rotation name of this rotation master in the language.
	 *
	 * @param rotationName the localized rotation name of this rotation master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRotationName(String rotationName, java.util.Locale locale) {
		model.setRotationName(rotationName, locale);
	}

	/**
	 * Sets the localized rotation name of this rotation master in the language, and sets the default locale.
	 *
	 * @param rotationName the localized rotation name of this rotation master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationName(
		String rotationName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRotationName(rotationName, locale, defaultLocale);
	}

	@Override
	public void setRotationNameCurrentLanguageId(String languageId) {
		model.setRotationNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized rotation names of this rotation master from the map of locales and localized rotation names.
	 *
	 * @param rotationNameMap the locales and localized rotation names of this rotation master
	 */
	@Override
	public void setRotationNameMap(
		Map<java.util.Locale, String> rotationNameMap) {

		model.setRotationNameMap(rotationNameMap);
	}

	/**
	 * Sets the localized rotation names of this rotation master from the map of locales and localized rotation names, and sets the default locale.
	 *
	 * @param rotationNameMap the locales and localized rotation names of this rotation master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationNameMap(
		Map<java.util.Locale, String> rotationNameMap,
		java.util.Locale defaultLocale) {

		model.setRotationNameMap(rotationNameMap, defaultLocale);
	}

	/**
	 * Sets the rotation objectives of this rotation master.
	 *
	 * @param rotationObjectives the rotation objectives of this rotation master
	 */
	@Override
	public void setRotationObjectives(String rotationObjectives) {
		model.setRotationObjectives(rotationObjectives);
	}

	/**
	 * Sets the localized rotation objectives of this rotation master in the language.
	 *
	 * @param rotationObjectives the localized rotation objectives of this rotation master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRotationObjectives(
		String rotationObjectives, java.util.Locale locale) {

		model.setRotationObjectives(rotationObjectives, locale);
	}

	/**
	 * Sets the localized rotation objectives of this rotation master in the language, and sets the default locale.
	 *
	 * @param rotationObjectives the localized rotation objectives of this rotation master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationObjectives(
		String rotationObjectives, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRotationObjectives(rotationObjectives, locale, defaultLocale);
	}

	@Override
	public void setRotationObjectivesCurrentLanguageId(String languageId) {
		model.setRotationObjectivesCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized rotation objectiveses of this rotation master from the map of locales and localized rotation objectiveses.
	 *
	 * @param rotationObjectivesMap the locales and localized rotation objectiveses of this rotation master
	 */
	@Override
	public void setRotationObjectivesMap(
		Map<java.util.Locale, String> rotationObjectivesMap) {

		model.setRotationObjectivesMap(rotationObjectivesMap);
	}

	/**
	 * Sets the localized rotation objectiveses of this rotation master from the map of locales and localized rotation objectiveses, and sets the default locale.
	 *
	 * @param rotationObjectivesMap the locales and localized rotation objectiveses of this rotation master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationObjectivesMap(
		Map<java.util.Locale, String> rotationObjectivesMap,
		java.util.Locale defaultLocale) {

		model.setRotationObjectivesMap(rotationObjectivesMap, defaultLocale);
	}

	/**
	 * Sets the rotation short name of this rotation master.
	 *
	 * @param rotationShortName the rotation short name of this rotation master
	 */
	@Override
	public void setRotationShortName(String rotationShortName) {
		model.setRotationShortName(rotationShortName);
	}

	/**
	 * Sets the localized rotation short name of this rotation master in the language.
	 *
	 * @param rotationShortName the localized rotation short name of this rotation master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRotationShortName(
		String rotationShortName, java.util.Locale locale) {

		model.setRotationShortName(rotationShortName, locale);
	}

	/**
	 * Sets the localized rotation short name of this rotation master in the language, and sets the default locale.
	 *
	 * @param rotationShortName the localized rotation short name of this rotation master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationShortName(
		String rotationShortName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRotationShortName(rotationShortName, locale, defaultLocale);
	}

	@Override
	public void setRotationShortNameCurrentLanguageId(String languageId) {
		model.setRotationShortNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized rotation short names of this rotation master from the map of locales and localized rotation short names.
	 *
	 * @param rotationShortNameMap the locales and localized rotation short names of this rotation master
	 */
	@Override
	public void setRotationShortNameMap(
		Map<java.util.Locale, String> rotationShortNameMap) {

		model.setRotationShortNameMap(rotationShortNameMap);
	}

	/**
	 * Sets the localized rotation short names of this rotation master from the map of locales and localized rotation short names, and sets the default locale.
	 *
	 * @param rotationShortNameMap the locales and localized rotation short names of this rotation master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationShortNameMap(
		Map<java.util.Locale, String> rotationShortNameMap,
		java.util.Locale defaultLocale) {

		model.setRotationShortNameMap(rotationShortNameMap, defaultLocale);
	}

	/**
	 * Sets the rotation status of this rotation master.
	 *
	 * @param rotationStatus the rotation status of this rotation master
	 */
	@Override
	public void setRotationStatus(Boolean rotationStatus) {
		model.setRotationStatus(rotationStatus);
	}

	/**
	 * Sets the uuid of this rotation master.
	 *
	 * @param uuid the uuid of this rotation master
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
	protected RotationMasterWrapper wrap(RotationMaster rotationMaster) {
		return new RotationMasterWrapper(rotationMaster);
	}

}