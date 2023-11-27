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
 * This class is a wrapper for {@link LeaveTypes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypes
 * @generated
 */
public class LeaveTypesWrapper
	extends BaseModelWrapper<LeaveTypes>
	implements LeaveTypes, ModelWrapper<LeaveTypes> {

	public LeaveTypesWrapper(LeaveTypes leaveTypes) {
		super(leaveTypes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveTypesId", getLeaveTypesId());
		attributes.put("leaveTypes", getLeaveTypes());
		attributes.put("leaveCode", getLeaveCode());
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

		Long leaveTypesId = (Long)attributes.get("leaveTypesId");

		if (leaveTypesId != null) {
			setLeaveTypesId(leaveTypesId);
		}

		String leaveTypes = (String)attributes.get("leaveTypes");

		if (leaveTypes != null) {
			setLeaveTypes(leaveTypes);
		}

		String leaveCode = (String)attributes.get("leaveCode");

		if (leaveCode != null) {
			setLeaveCode(leaveCode);
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
	public LeaveTypes cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this leave types.
	 *
	 * @return the company ID of this leave types
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave types.
	 *
	 * @return the create date of this leave types
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave types.
	 *
	 * @return the created by of this leave types
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
	 * Returns the group ID of this leave types.
	 *
	 * @return the group ID of this leave types
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave code of this leave types.
	 *
	 * @return the leave code of this leave types
	 */
	@Override
	public String getLeaveCode() {
		return model.getLeaveCode();
	}

	/**
	 * Returns the localized leave code of this leave types in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized leave code of this leave types
	 */
	@Override
	public String getLeaveCode(java.util.Locale locale) {
		return model.getLeaveCode(locale);
	}

	/**
	 * Returns the localized leave code of this leave types in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized leave code of this leave types. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLeaveCode(java.util.Locale locale, boolean useDefault) {
		return model.getLeaveCode(locale, useDefault);
	}

	/**
	 * Returns the localized leave code of this leave types in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized leave code of this leave types
	 */
	@Override
	public String getLeaveCode(String languageId) {
		return model.getLeaveCode(languageId);
	}

	/**
	 * Returns the localized leave code of this leave types in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized leave code of this leave types
	 */
	@Override
	public String getLeaveCode(String languageId, boolean useDefault) {
		return model.getLeaveCode(languageId, useDefault);
	}

	@Override
	public String getLeaveCodeCurrentLanguageId() {
		return model.getLeaveCodeCurrentLanguageId();
	}

	@Override
	public String getLeaveCodeCurrentValue() {
		return model.getLeaveCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized leave codes of this leave types.
	 *
	 * @return the locales and localized leave codes of this leave types
	 */
	@Override
	public Map<java.util.Locale, String> getLeaveCodeMap() {
		return model.getLeaveCodeMap();
	}

	/**
	 * Returns the leave types of this leave types.
	 *
	 * @return the leave types of this leave types
	 */
	@Override
	public String getLeaveTypes() {
		return model.getLeaveTypes();
	}

	/**
	 * Returns the localized leave types of this leave types in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized leave types of this leave types
	 */
	@Override
	public String getLeaveTypes(java.util.Locale locale) {
		return model.getLeaveTypes(locale);
	}

	/**
	 * Returns the localized leave types of this leave types in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized leave types of this leave types. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLeaveTypes(java.util.Locale locale, boolean useDefault) {
		return model.getLeaveTypes(locale, useDefault);
	}

	/**
	 * Returns the localized leave types of this leave types in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized leave types of this leave types
	 */
	@Override
	public String getLeaveTypes(String languageId) {
		return model.getLeaveTypes(languageId);
	}

	/**
	 * Returns the localized leave types of this leave types in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized leave types of this leave types
	 */
	@Override
	public String getLeaveTypes(String languageId, boolean useDefault) {
		return model.getLeaveTypes(languageId, useDefault);
	}

	@Override
	public String getLeaveTypesCurrentLanguageId() {
		return model.getLeaveTypesCurrentLanguageId();
	}

	@Override
	public String getLeaveTypesCurrentValue() {
		return model.getLeaveTypesCurrentValue();
	}

	/**
	 * Returns the leave types ID of this leave types.
	 *
	 * @return the leave types ID of this leave types
	 */
	@Override
	public long getLeaveTypesId() {
		return model.getLeaveTypesId();
	}

	/**
	 * Returns a map of the locales and localized leave typeses of this leave types.
	 *
	 * @return the locales and localized leave typeses of this leave types
	 */
	@Override
	public Map<java.util.Locale, String> getLeaveTypesMap() {
		return model.getLeaveTypesMap();
	}

	/**
	 * Returns the modified by of this leave types.
	 *
	 * @return the modified by of this leave types
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave types.
	 *
	 * @return the modified date of this leave types
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave types.
	 *
	 * @return the primary key of this leave types
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this leave types.
	 *
	 * @return the uuid of this leave types
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
	 * Sets the company ID of this leave types.
	 *
	 * @param companyId the company ID of this leave types
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave types.
	 *
	 * @param createDate the create date of this leave types
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave types.
	 *
	 * @param createdBy the created by of this leave types
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave types.
	 *
	 * @param groupId the group ID of this leave types
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave code of this leave types.
	 *
	 * @param leaveCode the leave code of this leave types
	 */
	@Override
	public void setLeaveCode(String leaveCode) {
		model.setLeaveCode(leaveCode);
	}

	/**
	 * Sets the localized leave code of this leave types in the language.
	 *
	 * @param leaveCode the localized leave code of this leave types
	 * @param locale the locale of the language
	 */
	@Override
	public void setLeaveCode(String leaveCode, java.util.Locale locale) {
		model.setLeaveCode(leaveCode, locale);
	}

	/**
	 * Sets the localized leave code of this leave types in the language, and sets the default locale.
	 *
	 * @param leaveCode the localized leave code of this leave types
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLeaveCode(
		String leaveCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLeaveCode(leaveCode, locale, defaultLocale);
	}

	@Override
	public void setLeaveCodeCurrentLanguageId(String languageId) {
		model.setLeaveCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized leave codes of this leave types from the map of locales and localized leave codes.
	 *
	 * @param leaveCodeMap the locales and localized leave codes of this leave types
	 */
	@Override
	public void setLeaveCodeMap(Map<java.util.Locale, String> leaveCodeMap) {
		model.setLeaveCodeMap(leaveCodeMap);
	}

	/**
	 * Sets the localized leave codes of this leave types from the map of locales and localized leave codes, and sets the default locale.
	 *
	 * @param leaveCodeMap the locales and localized leave codes of this leave types
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLeaveCodeMap(
		Map<java.util.Locale, String> leaveCodeMap,
		java.util.Locale defaultLocale) {

		model.setLeaveCodeMap(leaveCodeMap, defaultLocale);
	}

	/**
	 * Sets the leave types of this leave types.
	 *
	 * @param leaveTypes the leave types of this leave types
	 */
	@Override
	public void setLeaveTypes(String leaveTypes) {
		model.setLeaveTypes(leaveTypes);
	}

	/**
	 * Sets the localized leave types of this leave types in the language.
	 *
	 * @param leaveTypes the localized leave types of this leave types
	 * @param locale the locale of the language
	 */
	@Override
	public void setLeaveTypes(String leaveTypes, java.util.Locale locale) {
		model.setLeaveTypes(leaveTypes, locale);
	}

	/**
	 * Sets the localized leave types of this leave types in the language, and sets the default locale.
	 *
	 * @param leaveTypes the localized leave types of this leave types
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLeaveTypes(
		String leaveTypes, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLeaveTypes(leaveTypes, locale, defaultLocale);
	}

	@Override
	public void setLeaveTypesCurrentLanguageId(String languageId) {
		model.setLeaveTypesCurrentLanguageId(languageId);
	}

	/**
	 * Sets the leave types ID of this leave types.
	 *
	 * @param leaveTypesId the leave types ID of this leave types
	 */
	@Override
	public void setLeaveTypesId(long leaveTypesId) {
		model.setLeaveTypesId(leaveTypesId);
	}

	/**
	 * Sets the localized leave typeses of this leave types from the map of locales and localized leave typeses.
	 *
	 * @param leaveTypesMap the locales and localized leave typeses of this leave types
	 */
	@Override
	public void setLeaveTypesMap(Map<java.util.Locale, String> leaveTypesMap) {
		model.setLeaveTypesMap(leaveTypesMap);
	}

	/**
	 * Sets the localized leave typeses of this leave types from the map of locales and localized leave typeses, and sets the default locale.
	 *
	 * @param leaveTypesMap the locales and localized leave typeses of this leave types
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLeaveTypesMap(
		Map<java.util.Locale, String> leaveTypesMap,
		java.util.Locale defaultLocale) {

		model.setLeaveTypesMap(leaveTypesMap, defaultLocale);
	}

	/**
	 * Sets the modified by of this leave types.
	 *
	 * @param modifiedBy the modified by of this leave types
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave types.
	 *
	 * @param modifiedDate the modified date of this leave types
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave types.
	 *
	 * @param primaryKey the primary key of this leave types
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this leave types.
	 *
	 * @param uuid the uuid of this leave types
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
	protected LeaveTypesWrapper wrap(LeaveTypes leaveTypes) {
		return new LeaveTypesWrapper(leaveTypes);
	}

}