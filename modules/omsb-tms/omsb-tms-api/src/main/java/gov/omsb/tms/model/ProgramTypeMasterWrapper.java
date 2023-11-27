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
 * This class is a wrapper for {@link ProgramTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMaster
 * @generated
 */
public class ProgramTypeMasterWrapper
	extends BaseModelWrapper<ProgramTypeMaster>
	implements ModelWrapper<ProgramTypeMaster>, ProgramTypeMaster {

	public ProgramTypeMasterWrapper(ProgramTypeMaster programTypeMaster) {
		super(programTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("programTypeMasterId", getProgramTypeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("programTypeName", getProgramTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long programTypeMasterId = (Long)attributes.get("programTypeMasterId");

		if (programTypeMasterId != null) {
			setProgramTypeMasterId(programTypeMasterId);
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

		String programTypeName = (String)attributes.get("programTypeName");

		if (programTypeName != null) {
			setProgramTypeName(programTypeName);
		}
	}

	@Override
	public ProgramTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this program type master.
	 *
	 * @return the company ID of this program type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this program type master.
	 *
	 * @return the create date of this program type master
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
	 * Returns the group ID of this program type master.
	 *
	 * @return the group ID of this program type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this program type master.
	 *
	 * @return the modified date of this program type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this program type master.
	 *
	 * @return the primary key of this program type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program type master ID of this program type master.
	 *
	 * @return the program type master ID of this program type master
	 */
	@Override
	public long getProgramTypeMasterId() {
		return model.getProgramTypeMasterId();
	}

	/**
	 * Returns the program type name of this program type master.
	 *
	 * @return the program type name of this program type master
	 */
	@Override
	public String getProgramTypeName() {
		return model.getProgramTypeName();
	}

	/**
	 * Returns the localized program type name of this program type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program type name of this program type master
	 */
	@Override
	public String getProgramTypeName(java.util.Locale locale) {
		return model.getProgramTypeName(locale);
	}

	/**
	 * Returns the localized program type name of this program type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program type name of this program type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgramTypeName(
		java.util.Locale locale, boolean useDefault) {

		return model.getProgramTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized program type name of this program type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program type name of this program type master
	 */
	@Override
	public String getProgramTypeName(String languageId) {
		return model.getProgramTypeName(languageId);
	}

	/**
	 * Returns the localized program type name of this program type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program type name of this program type master
	 */
	@Override
	public String getProgramTypeName(String languageId, boolean useDefault) {
		return model.getProgramTypeName(languageId, useDefault);
	}

	@Override
	public String getProgramTypeNameCurrentLanguageId() {
		return model.getProgramTypeNameCurrentLanguageId();
	}

	@Override
	public String getProgramTypeNameCurrentValue() {
		return model.getProgramTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized program type names of this program type master.
	 *
	 * @return the locales and localized program type names of this program type master
	 */
	@Override
	public Map<java.util.Locale, String> getProgramTypeNameMap() {
		return model.getProgramTypeNameMap();
	}

	/**
	 * Returns the uuid of this program type master.
	 *
	 * @return the uuid of this program type master
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
	 * Sets the company ID of this program type master.
	 *
	 * @param companyId the company ID of this program type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this program type master.
	 *
	 * @param createDate the create date of this program type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this program type master.
	 *
	 * @param groupId the group ID of this program type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this program type master.
	 *
	 * @param modifiedDate the modified date of this program type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this program type master.
	 *
	 * @param primaryKey the primary key of this program type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program type master ID of this program type master.
	 *
	 * @param programTypeMasterId the program type master ID of this program type master
	 */
	@Override
	public void setProgramTypeMasterId(long programTypeMasterId) {
		model.setProgramTypeMasterId(programTypeMasterId);
	}

	/**
	 * Sets the program type name of this program type master.
	 *
	 * @param programTypeName the program type name of this program type master
	 */
	@Override
	public void setProgramTypeName(String programTypeName) {
		model.setProgramTypeName(programTypeName);
	}

	/**
	 * Sets the localized program type name of this program type master in the language.
	 *
	 * @param programTypeName the localized program type name of this program type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgramTypeName(
		String programTypeName, java.util.Locale locale) {

		model.setProgramTypeName(programTypeName, locale);
	}

	/**
	 * Sets the localized program type name of this program type master in the language, and sets the default locale.
	 *
	 * @param programTypeName the localized program type name of this program type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramTypeName(
		String programTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProgramTypeName(programTypeName, locale, defaultLocale);
	}

	@Override
	public void setProgramTypeNameCurrentLanguageId(String languageId) {
		model.setProgramTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized program type names of this program type master from the map of locales and localized program type names.
	 *
	 * @param programTypeNameMap the locales and localized program type names of this program type master
	 */
	@Override
	public void setProgramTypeNameMap(
		Map<java.util.Locale, String> programTypeNameMap) {

		model.setProgramTypeNameMap(programTypeNameMap);
	}

	/**
	 * Sets the localized program type names of this program type master from the map of locales and localized program type names, and sets the default locale.
	 *
	 * @param programTypeNameMap the locales and localized program type names of this program type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramTypeNameMap(
		Map<java.util.Locale, String> programTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setProgramTypeNameMap(programTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this program type master.
	 *
	 * @param uuid the uuid of this program type master
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
	protected ProgramTypeMasterWrapper wrap(
		ProgramTypeMaster programTypeMaster) {

		return new ProgramTypeMasterWrapper(programTypeMaster);
	}

}