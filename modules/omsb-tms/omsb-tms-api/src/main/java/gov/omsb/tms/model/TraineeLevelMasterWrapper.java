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
 * This class is a wrapper for {@link TraineeLevelMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMaster
 * @generated
 */
public class TraineeLevelMasterWrapper
	extends BaseModelWrapper<TraineeLevelMaster>
	implements ModelWrapper<TraineeLevelMaster>, TraineeLevelMaster {

	public TraineeLevelMasterWrapper(TraineeLevelMaster traineeLevelMaster) {
		super(traineeLevelMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("traineeLevelMasterId", getTraineeLevelMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("traineeLevelName", getTraineeLevelName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeLevelMasterId = (Long)attributes.get(
			"traineeLevelMasterId");

		if (traineeLevelMasterId != null) {
			setTraineeLevelMasterId(traineeLevelMasterId);
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

		String traineeLevelName = (String)attributes.get("traineeLevelName");

		if (traineeLevelName != null) {
			setTraineeLevelName(traineeLevelName);
		}
	}

	@Override
	public TraineeLevelMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this trainee level master.
	 *
	 * @return the company ID of this trainee level master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trainee level master.
	 *
	 * @return the create date of this trainee level master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee level master.
	 *
	 * @return the created by of this trainee level master
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
	 * Returns the group ID of this trainee level master.
	 *
	 * @return the group ID of this trainee level master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee level master.
	 *
	 * @return the modified by of this trainee level master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee level master.
	 *
	 * @return the modified date of this trainee level master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this trainee level master.
	 *
	 * @return the primary key of this trainee level master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trainee level master ID of this trainee level master.
	 *
	 * @return the trainee level master ID of this trainee level master
	 */
	@Override
	public long getTraineeLevelMasterId() {
		return model.getTraineeLevelMasterId();
	}

	/**
	 * Returns the trainee level name of this trainee level master.
	 *
	 * @return the trainee level name of this trainee level master
	 */
	@Override
	public String getTraineeLevelName() {
		return model.getTraineeLevelName();
	}

	/**
	 * Returns the localized trainee level name of this trainee level master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized trainee level name of this trainee level master
	 */
	@Override
	public String getTraineeLevelName(java.util.Locale locale) {
		return model.getTraineeLevelName(locale);
	}

	/**
	 * Returns the localized trainee level name of this trainee level master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee level name of this trainee level master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTraineeLevelName(
		java.util.Locale locale, boolean useDefault) {

		return model.getTraineeLevelName(locale, useDefault);
	}

	/**
	 * Returns the localized trainee level name of this trainee level master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized trainee level name of this trainee level master
	 */
	@Override
	public String getTraineeLevelName(String languageId) {
		return model.getTraineeLevelName(languageId);
	}

	/**
	 * Returns the localized trainee level name of this trainee level master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee level name of this trainee level master
	 */
	@Override
	public String getTraineeLevelName(String languageId, boolean useDefault) {
		return model.getTraineeLevelName(languageId, useDefault);
	}

	@Override
	public String getTraineeLevelNameCurrentLanguageId() {
		return model.getTraineeLevelNameCurrentLanguageId();
	}

	@Override
	public String getTraineeLevelNameCurrentValue() {
		return model.getTraineeLevelNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized trainee level names of this trainee level master.
	 *
	 * @return the locales and localized trainee level names of this trainee level master
	 */
	@Override
	public Map<java.util.Locale, String> getTraineeLevelNameMap() {
		return model.getTraineeLevelNameMap();
	}

	/**
	 * Returns the uuid of this trainee level master.
	 *
	 * @return the uuid of this trainee level master
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
	 * Sets the company ID of this trainee level master.
	 *
	 * @param companyId the company ID of this trainee level master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trainee level master.
	 *
	 * @param createDate the create date of this trainee level master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee level master.
	 *
	 * @param createdBy the created by of this trainee level master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this trainee level master.
	 *
	 * @param groupId the group ID of this trainee level master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee level master.
	 *
	 * @param modifiedBy the modified by of this trainee level master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee level master.
	 *
	 * @param modifiedDate the modified date of this trainee level master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this trainee level master.
	 *
	 * @param primaryKey the primary key of this trainee level master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trainee level master ID of this trainee level master.
	 *
	 * @param traineeLevelMasterId the trainee level master ID of this trainee level master
	 */
	@Override
	public void setTraineeLevelMasterId(long traineeLevelMasterId) {
		model.setTraineeLevelMasterId(traineeLevelMasterId);
	}

	/**
	 * Sets the trainee level name of this trainee level master.
	 *
	 * @param traineeLevelName the trainee level name of this trainee level master
	 */
	@Override
	public void setTraineeLevelName(String traineeLevelName) {
		model.setTraineeLevelName(traineeLevelName);
	}

	/**
	 * Sets the localized trainee level name of this trainee level master in the language.
	 *
	 * @param traineeLevelName the localized trainee level name of this trainee level master
	 * @param locale the locale of the language
	 */
	@Override
	public void setTraineeLevelName(
		String traineeLevelName, java.util.Locale locale) {

		model.setTraineeLevelName(traineeLevelName, locale);
	}

	/**
	 * Sets the localized trainee level name of this trainee level master in the language, and sets the default locale.
	 *
	 * @param traineeLevelName the localized trainee level name of this trainee level master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeLevelName(
		String traineeLevelName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTraineeLevelName(traineeLevelName, locale, defaultLocale);
	}

	@Override
	public void setTraineeLevelNameCurrentLanguageId(String languageId) {
		model.setTraineeLevelNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized trainee level names of this trainee level master from the map of locales and localized trainee level names.
	 *
	 * @param traineeLevelNameMap the locales and localized trainee level names of this trainee level master
	 */
	@Override
	public void setTraineeLevelNameMap(
		Map<java.util.Locale, String> traineeLevelNameMap) {

		model.setTraineeLevelNameMap(traineeLevelNameMap);
	}

	/**
	 * Sets the localized trainee level names of this trainee level master from the map of locales and localized trainee level names, and sets the default locale.
	 *
	 * @param traineeLevelNameMap the locales and localized trainee level names of this trainee level master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeLevelNameMap(
		Map<java.util.Locale, String> traineeLevelNameMap,
		java.util.Locale defaultLocale) {

		model.setTraineeLevelNameMap(traineeLevelNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this trainee level master.
	 *
	 * @param uuid the uuid of this trainee level master
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
	protected TraineeLevelMasterWrapper wrap(
		TraineeLevelMaster traineeLevelMaster) {

		return new TraineeLevelMasterWrapper(traineeLevelMaster);
	}

}