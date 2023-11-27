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
 * This class is a wrapper for {@link LevelTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMaster
 * @generated
 */
public class LevelTypeMasterWrapper
	extends BaseModelWrapper<LevelTypeMaster>
	implements LevelTypeMaster, ModelWrapper<LevelTypeMaster> {

	public LevelTypeMasterWrapper(LevelTypeMaster levelTypeMaster) {
		super(levelTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("LevelTypeMasterId", getLevelTypeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("levelTypeName", getLevelTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long LevelTypeMasterId = (Long)attributes.get("LevelTypeMasterId");

		if (LevelTypeMasterId != null) {
			setLevelTypeMasterId(LevelTypeMasterId);
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

		String levelTypeName = (String)attributes.get("levelTypeName");

		if (levelTypeName != null) {
			setLevelTypeName(levelTypeName);
		}
	}

	@Override
	public LevelTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this level type master.
	 *
	 * @return the company ID of this level type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this level type master.
	 *
	 * @return the create date of this level type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this level type master.
	 *
	 * @return the created by of this level type master
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
	 * Returns the group ID of this level type master.
	 *
	 * @return the group ID of this level type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level type master ID of this level type master.
	 *
	 * @return the level type master ID of this level type master
	 */
	@Override
	public long getLevelTypeMasterId() {
		return model.getLevelTypeMasterId();
	}

	/**
	 * Returns the level type name of this level type master.
	 *
	 * @return the level type name of this level type master
	 */
	@Override
	public String getLevelTypeName() {
		return model.getLevelTypeName();
	}

	/**
	 * Returns the localized level type name of this level type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized level type name of this level type master
	 */
	@Override
	public String getLevelTypeName(java.util.Locale locale) {
		return model.getLevelTypeName(locale);
	}

	/**
	 * Returns the localized level type name of this level type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized level type name of this level type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLevelTypeName(
		java.util.Locale locale, boolean useDefault) {

		return model.getLevelTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized level type name of this level type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized level type name of this level type master
	 */
	@Override
	public String getLevelTypeName(String languageId) {
		return model.getLevelTypeName(languageId);
	}

	/**
	 * Returns the localized level type name of this level type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized level type name of this level type master
	 */
	@Override
	public String getLevelTypeName(String languageId, boolean useDefault) {
		return model.getLevelTypeName(languageId, useDefault);
	}

	@Override
	public String getLevelTypeNameCurrentLanguageId() {
		return model.getLevelTypeNameCurrentLanguageId();
	}

	@Override
	public String getLevelTypeNameCurrentValue() {
		return model.getLevelTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized level type names of this level type master.
	 *
	 * @return the locales and localized level type names of this level type master
	 */
	@Override
	public Map<java.util.Locale, String> getLevelTypeNameMap() {
		return model.getLevelTypeNameMap();
	}

	/**
	 * Returns the modified by of this level type master.
	 *
	 * @return the modified by of this level type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this level type master.
	 *
	 * @return the modified date of this level type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this level type master.
	 *
	 * @return the primary key of this level type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this level type master.
	 *
	 * @return the uuid of this level type master
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
	 * Sets the company ID of this level type master.
	 *
	 * @param companyId the company ID of this level type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this level type master.
	 *
	 * @param createDate the create date of this level type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this level type master.
	 *
	 * @param createdBy the created by of this level type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this level type master.
	 *
	 * @param groupId the group ID of this level type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level type master ID of this level type master.
	 *
	 * @param LevelTypeMasterId the level type master ID of this level type master
	 */
	@Override
	public void setLevelTypeMasterId(long LevelTypeMasterId) {
		model.setLevelTypeMasterId(LevelTypeMasterId);
	}

	/**
	 * Sets the level type name of this level type master.
	 *
	 * @param levelTypeName the level type name of this level type master
	 */
	@Override
	public void setLevelTypeName(String levelTypeName) {
		model.setLevelTypeName(levelTypeName);
	}

	/**
	 * Sets the localized level type name of this level type master in the language.
	 *
	 * @param levelTypeName the localized level type name of this level type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setLevelTypeName(
		String levelTypeName, java.util.Locale locale) {

		model.setLevelTypeName(levelTypeName, locale);
	}

	/**
	 * Sets the localized level type name of this level type master in the language, and sets the default locale.
	 *
	 * @param levelTypeName the localized level type name of this level type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLevelTypeName(
		String levelTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLevelTypeName(levelTypeName, locale, defaultLocale);
	}

	@Override
	public void setLevelTypeNameCurrentLanguageId(String languageId) {
		model.setLevelTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized level type names of this level type master from the map of locales and localized level type names.
	 *
	 * @param levelTypeNameMap the locales and localized level type names of this level type master
	 */
	@Override
	public void setLevelTypeNameMap(
		Map<java.util.Locale, String> levelTypeNameMap) {

		model.setLevelTypeNameMap(levelTypeNameMap);
	}

	/**
	 * Sets the localized level type names of this level type master from the map of locales and localized level type names, and sets the default locale.
	 *
	 * @param levelTypeNameMap the locales and localized level type names of this level type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLevelTypeNameMap(
		Map<java.util.Locale, String> levelTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setLevelTypeNameMap(levelTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the modified by of this level type master.
	 *
	 * @param modifiedBy the modified by of this level type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this level type master.
	 *
	 * @param modifiedDate the modified date of this level type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this level type master.
	 *
	 * @param primaryKey the primary key of this level type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this level type master.
	 *
	 * @param uuid the uuid of this level type master
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
	protected LevelTypeMasterWrapper wrap(LevelTypeMaster levelTypeMaster) {
		return new LevelTypeMasterWrapper(levelTypeMaster);
	}

}