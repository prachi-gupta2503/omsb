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
 * This class is a wrapper for {@link TrainingSitesMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMaster
 * @generated
 */
public class TrainingSitesMasterWrapper
	extends BaseModelWrapper<TrainingSitesMaster>
	implements ModelWrapper<TrainingSitesMaster>, TrainingSitesMaster {

	public TrainingSitesMasterWrapper(TrainingSitesMaster trainingSitesMaster) {
		super(trainingSitesMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trainingSiteMasterId", getTrainingSiteMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("trainingSiteName", getTrainingSiteName());
		attributes.put("trainingSiteCode", getTrainingSiteCode());
		attributes.put("trainingSiteStatus", getTrainingSiteStatus());
		attributes.put("trainingSiteAddress", getTrainingSiteAddress());
		attributes.put("trainingSiteDescription", getTrainingSiteDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trainingSiteMasterId = (Long)attributes.get(
			"trainingSiteMasterId");

		if (trainingSiteMasterId != null) {
			setTrainingSiteMasterId(trainingSiteMasterId);
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

		String trainingSiteName = (String)attributes.get("trainingSiteName");

		if (trainingSiteName != null) {
			setTrainingSiteName(trainingSiteName);
		}

		String trainingSiteCode = (String)attributes.get("trainingSiteCode");

		if (trainingSiteCode != null) {
			setTrainingSiteCode(trainingSiteCode);
		}

		Boolean trainingSiteStatus = (Boolean)attributes.get(
			"trainingSiteStatus");

		if (trainingSiteStatus != null) {
			setTrainingSiteStatus(trainingSiteStatus);
		}

		String trainingSiteAddress = (String)attributes.get(
			"trainingSiteAddress");

		if (trainingSiteAddress != null) {
			setTrainingSiteAddress(trainingSiteAddress);
		}

		String trainingSiteDescription = (String)attributes.get(
			"trainingSiteDescription");

		if (trainingSiteDescription != null) {
			setTrainingSiteDescription(trainingSiteDescription);
		}
	}

	@Override
	public TrainingSitesMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this training sites master.
	 *
	 * @return the company ID of this training sites master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this training sites master.
	 *
	 * @return the create date of this training sites master
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
	 * Returns the group ID of this training sites master.
	 *
	 * @return the group ID of this training sites master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this training sites master.
	 *
	 * @return the modified date of this training sites master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this training sites master.
	 *
	 * @return the primary key of this training sites master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the training site address of this training sites master.
	 *
	 * @return the training site address of this training sites master
	 */
	@Override
	public String getTrainingSiteAddress() {
		return model.getTrainingSiteAddress();
	}

	/**
	 * Returns the localized training site address of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized training site address of this training sites master
	 */
	@Override
	public String getTrainingSiteAddress(java.util.Locale locale) {
		return model.getTrainingSiteAddress(locale);
	}

	/**
	 * Returns the localized training site address of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site address of this training sites master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTrainingSiteAddress(
		java.util.Locale locale, boolean useDefault) {

		return model.getTrainingSiteAddress(locale, useDefault);
	}

	/**
	 * Returns the localized training site address of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized training site address of this training sites master
	 */
	@Override
	public String getTrainingSiteAddress(String languageId) {
		return model.getTrainingSiteAddress(languageId);
	}

	/**
	 * Returns the localized training site address of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site address of this training sites master
	 */
	@Override
	public String getTrainingSiteAddress(
		String languageId, boolean useDefault) {

		return model.getTrainingSiteAddress(languageId, useDefault);
	}

	@Override
	public String getTrainingSiteAddressCurrentLanguageId() {
		return model.getTrainingSiteAddressCurrentLanguageId();
	}

	@Override
	public String getTrainingSiteAddressCurrentValue() {
		return model.getTrainingSiteAddressCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized training site addresses of this training sites master.
	 *
	 * @return the locales and localized training site addresses of this training sites master
	 */
	@Override
	public Map<java.util.Locale, String> getTrainingSiteAddressMap() {
		return model.getTrainingSiteAddressMap();
	}

	/**
	 * Returns the training site code of this training sites master.
	 *
	 * @return the training site code of this training sites master
	 */
	@Override
	public String getTrainingSiteCode() {
		return model.getTrainingSiteCode();
	}

	/**
	 * Returns the localized training site code of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized training site code of this training sites master
	 */
	@Override
	public String getTrainingSiteCode(java.util.Locale locale) {
		return model.getTrainingSiteCode(locale);
	}

	/**
	 * Returns the localized training site code of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site code of this training sites master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTrainingSiteCode(
		java.util.Locale locale, boolean useDefault) {

		return model.getTrainingSiteCode(locale, useDefault);
	}

	/**
	 * Returns the localized training site code of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized training site code of this training sites master
	 */
	@Override
	public String getTrainingSiteCode(String languageId) {
		return model.getTrainingSiteCode(languageId);
	}

	/**
	 * Returns the localized training site code of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site code of this training sites master
	 */
	@Override
	public String getTrainingSiteCode(String languageId, boolean useDefault) {
		return model.getTrainingSiteCode(languageId, useDefault);
	}

	@Override
	public String getTrainingSiteCodeCurrentLanguageId() {
		return model.getTrainingSiteCodeCurrentLanguageId();
	}

	@Override
	public String getTrainingSiteCodeCurrentValue() {
		return model.getTrainingSiteCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized training site codes of this training sites master.
	 *
	 * @return the locales and localized training site codes of this training sites master
	 */
	@Override
	public Map<java.util.Locale, String> getTrainingSiteCodeMap() {
		return model.getTrainingSiteCodeMap();
	}

	/**
	 * Returns the training site description of this training sites master.
	 *
	 * @return the training site description of this training sites master
	 */
	@Override
	public String getTrainingSiteDescription() {
		return model.getTrainingSiteDescription();
	}

	/**
	 * Returns the localized training site description of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized training site description of this training sites master
	 */
	@Override
	public String getTrainingSiteDescription(java.util.Locale locale) {
		return model.getTrainingSiteDescription(locale);
	}

	/**
	 * Returns the localized training site description of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site description of this training sites master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTrainingSiteDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getTrainingSiteDescription(locale, useDefault);
	}

	/**
	 * Returns the localized training site description of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized training site description of this training sites master
	 */
	@Override
	public String getTrainingSiteDescription(String languageId) {
		return model.getTrainingSiteDescription(languageId);
	}

	/**
	 * Returns the localized training site description of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site description of this training sites master
	 */
	@Override
	public String getTrainingSiteDescription(
		String languageId, boolean useDefault) {

		return model.getTrainingSiteDescription(languageId, useDefault);
	}

	@Override
	public String getTrainingSiteDescriptionCurrentLanguageId() {
		return model.getTrainingSiteDescriptionCurrentLanguageId();
	}

	@Override
	public String getTrainingSiteDescriptionCurrentValue() {
		return model.getTrainingSiteDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized training site descriptions of this training sites master.
	 *
	 * @return the locales and localized training site descriptions of this training sites master
	 */
	@Override
	public Map<java.util.Locale, String> getTrainingSiteDescriptionMap() {
		return model.getTrainingSiteDescriptionMap();
	}

	/**
	 * Returns the training site master ID of this training sites master.
	 *
	 * @return the training site master ID of this training sites master
	 */
	@Override
	public long getTrainingSiteMasterId() {
		return model.getTrainingSiteMasterId();
	}

	/**
	 * Returns the training site name of this training sites master.
	 *
	 * @return the training site name of this training sites master
	 */
	@Override
	public String getTrainingSiteName() {
		return model.getTrainingSiteName();
	}

	/**
	 * Returns the localized training site name of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized training site name of this training sites master
	 */
	@Override
	public String getTrainingSiteName(java.util.Locale locale) {
		return model.getTrainingSiteName(locale);
	}

	/**
	 * Returns the localized training site name of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site name of this training sites master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTrainingSiteName(
		java.util.Locale locale, boolean useDefault) {

		return model.getTrainingSiteName(locale, useDefault);
	}

	/**
	 * Returns the localized training site name of this training sites master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized training site name of this training sites master
	 */
	@Override
	public String getTrainingSiteName(String languageId) {
		return model.getTrainingSiteName(languageId);
	}

	/**
	 * Returns the localized training site name of this training sites master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized training site name of this training sites master
	 */
	@Override
	public String getTrainingSiteName(String languageId, boolean useDefault) {
		return model.getTrainingSiteName(languageId, useDefault);
	}

	@Override
	public String getTrainingSiteNameCurrentLanguageId() {
		return model.getTrainingSiteNameCurrentLanguageId();
	}

	@Override
	public String getTrainingSiteNameCurrentValue() {
		return model.getTrainingSiteNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized training site names of this training sites master.
	 *
	 * @return the locales and localized training site names of this training sites master
	 */
	@Override
	public Map<java.util.Locale, String> getTrainingSiteNameMap() {
		return model.getTrainingSiteNameMap();
	}

	/**
	 * Returns the training site status of this training sites master.
	 *
	 * @return the training site status of this training sites master
	 */
	@Override
	public Boolean getTrainingSiteStatus() {
		return model.getTrainingSiteStatus();
	}

	/**
	 * Returns the uuid of this training sites master.
	 *
	 * @return the uuid of this training sites master
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
	 * Sets the company ID of this training sites master.
	 *
	 * @param companyId the company ID of this training sites master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this training sites master.
	 *
	 * @param createDate the create date of this training sites master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this training sites master.
	 *
	 * @param groupId the group ID of this training sites master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this training sites master.
	 *
	 * @param modifiedDate the modified date of this training sites master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this training sites master.
	 *
	 * @param primaryKey the primary key of this training sites master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the training site address of this training sites master.
	 *
	 * @param trainingSiteAddress the training site address of this training sites master
	 */
	@Override
	public void setTrainingSiteAddress(String trainingSiteAddress) {
		model.setTrainingSiteAddress(trainingSiteAddress);
	}

	/**
	 * Sets the localized training site address of this training sites master in the language.
	 *
	 * @param trainingSiteAddress the localized training site address of this training sites master
	 * @param locale the locale of the language
	 */
	@Override
	public void setTrainingSiteAddress(
		String trainingSiteAddress, java.util.Locale locale) {

		model.setTrainingSiteAddress(trainingSiteAddress, locale);
	}

	/**
	 * Sets the localized training site address of this training sites master in the language, and sets the default locale.
	 *
	 * @param trainingSiteAddress the localized training site address of this training sites master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteAddress(
		String trainingSiteAddress, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteAddress(
			trainingSiteAddress, locale, defaultLocale);
	}

	@Override
	public void setTrainingSiteAddressCurrentLanguageId(String languageId) {
		model.setTrainingSiteAddressCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized training site addresses of this training sites master from the map of locales and localized training site addresses.
	 *
	 * @param trainingSiteAddressMap the locales and localized training site addresses of this training sites master
	 */
	@Override
	public void setTrainingSiteAddressMap(
		Map<java.util.Locale, String> trainingSiteAddressMap) {

		model.setTrainingSiteAddressMap(trainingSiteAddressMap);
	}

	/**
	 * Sets the localized training site addresses of this training sites master from the map of locales and localized training site addresses, and sets the default locale.
	 *
	 * @param trainingSiteAddressMap the locales and localized training site addresses of this training sites master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteAddressMap(
		Map<java.util.Locale, String> trainingSiteAddressMap,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteAddressMap(trainingSiteAddressMap, defaultLocale);
	}

	/**
	 * Sets the training site code of this training sites master.
	 *
	 * @param trainingSiteCode the training site code of this training sites master
	 */
	@Override
	public void setTrainingSiteCode(String trainingSiteCode) {
		model.setTrainingSiteCode(trainingSiteCode);
	}

	/**
	 * Sets the localized training site code of this training sites master in the language.
	 *
	 * @param trainingSiteCode the localized training site code of this training sites master
	 * @param locale the locale of the language
	 */
	@Override
	public void setTrainingSiteCode(
		String trainingSiteCode, java.util.Locale locale) {

		model.setTrainingSiteCode(trainingSiteCode, locale);
	}

	/**
	 * Sets the localized training site code of this training sites master in the language, and sets the default locale.
	 *
	 * @param trainingSiteCode the localized training site code of this training sites master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteCode(
		String trainingSiteCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteCode(trainingSiteCode, locale, defaultLocale);
	}

	@Override
	public void setTrainingSiteCodeCurrentLanguageId(String languageId) {
		model.setTrainingSiteCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized training site codes of this training sites master from the map of locales and localized training site codes.
	 *
	 * @param trainingSiteCodeMap the locales and localized training site codes of this training sites master
	 */
	@Override
	public void setTrainingSiteCodeMap(
		Map<java.util.Locale, String> trainingSiteCodeMap) {

		model.setTrainingSiteCodeMap(trainingSiteCodeMap);
	}

	/**
	 * Sets the localized training site codes of this training sites master from the map of locales and localized training site codes, and sets the default locale.
	 *
	 * @param trainingSiteCodeMap the locales and localized training site codes of this training sites master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteCodeMap(
		Map<java.util.Locale, String> trainingSiteCodeMap,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteCodeMap(trainingSiteCodeMap, defaultLocale);
	}

	/**
	 * Sets the training site description of this training sites master.
	 *
	 * @param trainingSiteDescription the training site description of this training sites master
	 */
	@Override
	public void setTrainingSiteDescription(String trainingSiteDescription) {
		model.setTrainingSiteDescription(trainingSiteDescription);
	}

	/**
	 * Sets the localized training site description of this training sites master in the language.
	 *
	 * @param trainingSiteDescription the localized training site description of this training sites master
	 * @param locale the locale of the language
	 */
	@Override
	public void setTrainingSiteDescription(
		String trainingSiteDescription, java.util.Locale locale) {

		model.setTrainingSiteDescription(trainingSiteDescription, locale);
	}

	/**
	 * Sets the localized training site description of this training sites master in the language, and sets the default locale.
	 *
	 * @param trainingSiteDescription the localized training site description of this training sites master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteDescription(
		String trainingSiteDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteDescription(
			trainingSiteDescription, locale, defaultLocale);
	}

	@Override
	public void setTrainingSiteDescriptionCurrentLanguageId(String languageId) {
		model.setTrainingSiteDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized training site descriptions of this training sites master from the map of locales and localized training site descriptions.
	 *
	 * @param trainingSiteDescriptionMap the locales and localized training site descriptions of this training sites master
	 */
	@Override
	public void setTrainingSiteDescriptionMap(
		Map<java.util.Locale, String> trainingSiteDescriptionMap) {

		model.setTrainingSiteDescriptionMap(trainingSiteDescriptionMap);
	}

	/**
	 * Sets the localized training site descriptions of this training sites master from the map of locales and localized training site descriptions, and sets the default locale.
	 *
	 * @param trainingSiteDescriptionMap the locales and localized training site descriptions of this training sites master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteDescriptionMap(
		Map<java.util.Locale, String> trainingSiteDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteDescriptionMap(
			trainingSiteDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the training site master ID of this training sites master.
	 *
	 * @param trainingSiteMasterId the training site master ID of this training sites master
	 */
	@Override
	public void setTrainingSiteMasterId(long trainingSiteMasterId) {
		model.setTrainingSiteMasterId(trainingSiteMasterId);
	}

	/**
	 * Sets the training site name of this training sites master.
	 *
	 * @param trainingSiteName the training site name of this training sites master
	 */
	@Override
	public void setTrainingSiteName(String trainingSiteName) {
		model.setTrainingSiteName(trainingSiteName);
	}

	/**
	 * Sets the localized training site name of this training sites master in the language.
	 *
	 * @param trainingSiteName the localized training site name of this training sites master
	 * @param locale the locale of the language
	 */
	@Override
	public void setTrainingSiteName(
		String trainingSiteName, java.util.Locale locale) {

		model.setTrainingSiteName(trainingSiteName, locale);
	}

	/**
	 * Sets the localized training site name of this training sites master in the language, and sets the default locale.
	 *
	 * @param trainingSiteName the localized training site name of this training sites master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteName(
		String trainingSiteName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteName(trainingSiteName, locale, defaultLocale);
	}

	@Override
	public void setTrainingSiteNameCurrentLanguageId(String languageId) {
		model.setTrainingSiteNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized training site names of this training sites master from the map of locales and localized training site names.
	 *
	 * @param trainingSiteNameMap the locales and localized training site names of this training sites master
	 */
	@Override
	public void setTrainingSiteNameMap(
		Map<java.util.Locale, String> trainingSiteNameMap) {

		model.setTrainingSiteNameMap(trainingSiteNameMap);
	}

	/**
	 * Sets the localized training site names of this training sites master from the map of locales and localized training site names, and sets the default locale.
	 *
	 * @param trainingSiteNameMap the locales and localized training site names of this training sites master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTrainingSiteNameMap(
		Map<java.util.Locale, String> trainingSiteNameMap,
		java.util.Locale defaultLocale) {

		model.setTrainingSiteNameMap(trainingSiteNameMap, defaultLocale);
	}

	/**
	 * Sets the training site status of this training sites master.
	 *
	 * @param trainingSiteStatus the training site status of this training sites master
	 */
	@Override
	public void setTrainingSiteStatus(Boolean trainingSiteStatus) {
		model.setTrainingSiteStatus(trainingSiteStatus);
	}

	/**
	 * Sets the uuid of this training sites master.
	 *
	 * @param uuid the uuid of this training sites master
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
	protected TrainingSitesMasterWrapper wrap(
		TrainingSitesMaster trainingSitesMaster) {

		return new TrainingSitesMasterWrapper(trainingSitesMaster);
	}

}