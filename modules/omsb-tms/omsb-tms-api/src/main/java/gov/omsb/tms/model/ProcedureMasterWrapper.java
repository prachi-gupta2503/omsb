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
 * This class is a wrapper for {@link ProcedureMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMaster
 * @generated
 */
public class ProcedureMasterWrapper
	extends BaseModelWrapper<ProcedureMaster>
	implements ModelWrapper<ProcedureMaster>, ProcedureMaster {

	public ProcedureMasterWrapper(ProcedureMaster procedureMaster) {
		super(procedureMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("procedureMasterId", getProcedureMasterId());
		attributes.put("procedureGroupMasterId", getProcedureGroupMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("procedureName", getProcedureName());
		attributes.put("cptCode", getCptCode());
		attributes.put("isMandatory", isIsMandatory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long procedureMasterId = (Long)attributes.get("procedureMasterId");

		if (procedureMasterId != null) {
			setProcedureMasterId(procedureMasterId);
		}

		Long procedureGroupMasterId = (Long)attributes.get(
			"procedureGroupMasterId");

		if (procedureGroupMasterId != null) {
			setProcedureGroupMasterId(procedureGroupMasterId);
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

		String procedureName = (String)attributes.get("procedureName");

		if (procedureName != null) {
			setProcedureName(procedureName);
		}

		String cptCode = (String)attributes.get("cptCode");

		if (cptCode != null) {
			setCptCode(cptCode);
		}

		Boolean isMandatory = (Boolean)attributes.get("isMandatory");

		if (isMandatory != null) {
			setIsMandatory(isMandatory);
		}
	}

	@Override
	public ProcedureMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this procedure master.
	 *
	 * @return the company ID of this procedure master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cpt code of this procedure master.
	 *
	 * @return the cpt code of this procedure master
	 */
	@Override
	public String getCptCode() {
		return model.getCptCode();
	}

	/**
	 * Returns the localized cpt code of this procedure master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized cpt code of this procedure master
	 */
	@Override
	public String getCptCode(java.util.Locale locale) {
		return model.getCptCode(locale);
	}

	/**
	 * Returns the localized cpt code of this procedure master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code of this procedure master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCptCode(java.util.Locale locale, boolean useDefault) {
		return model.getCptCode(locale, useDefault);
	}

	/**
	 * Returns the localized cpt code of this procedure master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized cpt code of this procedure master
	 */
	@Override
	public String getCptCode(String languageId) {
		return model.getCptCode(languageId);
	}

	/**
	 * Returns the localized cpt code of this procedure master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code of this procedure master
	 */
	@Override
	public String getCptCode(String languageId, boolean useDefault) {
		return model.getCptCode(languageId, useDefault);
	}

	@Override
	public String getCptCodeCurrentLanguageId() {
		return model.getCptCodeCurrentLanguageId();
	}

	@Override
	public String getCptCodeCurrentValue() {
		return model.getCptCodeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized cpt codes of this procedure master.
	 *
	 * @return the locales and localized cpt codes of this procedure master
	 */
	@Override
	public Map<java.util.Locale, String> getCptCodeMap() {
		return model.getCptCodeMap();
	}

	/**
	 * Returns the create date of this procedure master.
	 *
	 * @return the create date of this procedure master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this procedure master.
	 *
	 * @return the created by of this procedure master
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
	 * Returns the group ID of this procedure master.
	 *
	 * @return the group ID of this procedure master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is mandatory of this procedure master.
	 *
	 * @return the is mandatory of this procedure master
	 */
	@Override
	public boolean getIsMandatory() {
		return model.getIsMandatory();
	}

	/**
	 * Returns the modified by of this procedure master.
	 *
	 * @return the modified by of this procedure master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this procedure master.
	 *
	 * @return the modified date of this procedure master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this procedure master.
	 *
	 * @return the primary key of this procedure master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group master ID of this procedure master.
	 *
	 * @return the procedure group master ID of this procedure master
	 */
	@Override
	public long getProcedureGroupMasterId() {
		return model.getProcedureGroupMasterId();
	}

	/**
	 * Returns the procedure master ID of this procedure master.
	 *
	 * @return the procedure master ID of this procedure master
	 */
	@Override
	public long getProcedureMasterId() {
		return model.getProcedureMasterId();
	}

	/**
	 * Returns the procedure name of this procedure master.
	 *
	 * @return the procedure name of this procedure master
	 */
	@Override
	public String getProcedureName() {
		return model.getProcedureName();
	}

	/**
	 * Returns the localized procedure name of this procedure master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized procedure name of this procedure master
	 */
	@Override
	public String getProcedureName(java.util.Locale locale) {
		return model.getProcedureName(locale);
	}

	/**
	 * Returns the localized procedure name of this procedure master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized procedure name of this procedure master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProcedureName(
		java.util.Locale locale, boolean useDefault) {

		return model.getProcedureName(locale, useDefault);
	}

	/**
	 * Returns the localized procedure name of this procedure master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized procedure name of this procedure master
	 */
	@Override
	public String getProcedureName(String languageId) {
		return model.getProcedureName(languageId);
	}

	/**
	 * Returns the localized procedure name of this procedure master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized procedure name of this procedure master
	 */
	@Override
	public String getProcedureName(String languageId, boolean useDefault) {
		return model.getProcedureName(languageId, useDefault);
	}

	@Override
	public String getProcedureNameCurrentLanguageId() {
		return model.getProcedureNameCurrentLanguageId();
	}

	@Override
	public String getProcedureNameCurrentValue() {
		return model.getProcedureNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized procedure names of this procedure master.
	 *
	 * @return the locales and localized procedure names of this procedure master
	 */
	@Override
	public Map<java.util.Locale, String> getProcedureNameMap() {
		return model.getProcedureNameMap();
	}

	/**
	 * Returns the uuid of this procedure master.
	 *
	 * @return the uuid of this procedure master
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this procedure master is is mandatory.
	 *
	 * @return <code>true</code> if this procedure master is is mandatory; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMandatory() {
		return model.isIsMandatory();
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
	 * Sets the company ID of this procedure master.
	 *
	 * @param companyId the company ID of this procedure master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cpt code of this procedure master.
	 *
	 * @param cptCode the cpt code of this procedure master
	 */
	@Override
	public void setCptCode(String cptCode) {
		model.setCptCode(cptCode);
	}

	/**
	 * Sets the localized cpt code of this procedure master in the language.
	 *
	 * @param cptCode the localized cpt code of this procedure master
	 * @param locale the locale of the language
	 */
	@Override
	public void setCptCode(String cptCode, java.util.Locale locale) {
		model.setCptCode(cptCode, locale);
	}

	/**
	 * Sets the localized cpt code of this procedure master in the language, and sets the default locale.
	 *
	 * @param cptCode the localized cpt code of this procedure master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCode(
		String cptCode, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCptCode(cptCode, locale, defaultLocale);
	}

	@Override
	public void setCptCodeCurrentLanguageId(String languageId) {
		model.setCptCodeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized cpt codes of this procedure master from the map of locales and localized cpt codes.
	 *
	 * @param cptCodeMap the locales and localized cpt codes of this procedure master
	 */
	@Override
	public void setCptCodeMap(Map<java.util.Locale, String> cptCodeMap) {
		model.setCptCodeMap(cptCodeMap);
	}

	/**
	 * Sets the localized cpt codes of this procedure master from the map of locales and localized cpt codes, and sets the default locale.
	 *
	 * @param cptCodeMap the locales and localized cpt codes of this procedure master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCodeMap(
		Map<java.util.Locale, String> cptCodeMap,
		java.util.Locale defaultLocale) {

		model.setCptCodeMap(cptCodeMap, defaultLocale);
	}

	/**
	 * Sets the create date of this procedure master.
	 *
	 * @param createDate the create date of this procedure master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this procedure master.
	 *
	 * @param createdBy the created by of this procedure master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this procedure master.
	 *
	 * @param groupId the group ID of this procedure master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this procedure master is is mandatory.
	 *
	 * @param isMandatory the is mandatory of this procedure master
	 */
	@Override
	public void setIsMandatory(boolean isMandatory) {
		model.setIsMandatory(isMandatory);
	}

	/**
	 * Sets the modified by of this procedure master.
	 *
	 * @param modifiedBy the modified by of this procedure master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this procedure master.
	 *
	 * @param modifiedDate the modified date of this procedure master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this procedure master.
	 *
	 * @param primaryKey the primary key of this procedure master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group master ID of this procedure master.
	 *
	 * @param procedureGroupMasterId the procedure group master ID of this procedure master
	 */
	@Override
	public void setProcedureGroupMasterId(long procedureGroupMasterId) {
		model.setProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Sets the procedure master ID of this procedure master.
	 *
	 * @param procedureMasterId the procedure master ID of this procedure master
	 */
	@Override
	public void setProcedureMasterId(long procedureMasterId) {
		model.setProcedureMasterId(procedureMasterId);
	}

	/**
	 * Sets the procedure name of this procedure master.
	 *
	 * @param procedureName the procedure name of this procedure master
	 */
	@Override
	public void setProcedureName(String procedureName) {
		model.setProcedureName(procedureName);
	}

	/**
	 * Sets the localized procedure name of this procedure master in the language.
	 *
	 * @param procedureName the localized procedure name of this procedure master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProcedureName(
		String procedureName, java.util.Locale locale) {

		model.setProcedureName(procedureName, locale);
	}

	/**
	 * Sets the localized procedure name of this procedure master in the language, and sets the default locale.
	 *
	 * @param procedureName the localized procedure name of this procedure master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProcedureName(
		String procedureName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProcedureName(procedureName, locale, defaultLocale);
	}

	@Override
	public void setProcedureNameCurrentLanguageId(String languageId) {
		model.setProcedureNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized procedure names of this procedure master from the map of locales and localized procedure names.
	 *
	 * @param procedureNameMap the locales and localized procedure names of this procedure master
	 */
	@Override
	public void setProcedureNameMap(
		Map<java.util.Locale, String> procedureNameMap) {

		model.setProcedureNameMap(procedureNameMap);
	}

	/**
	 * Sets the localized procedure names of this procedure master from the map of locales and localized procedure names, and sets the default locale.
	 *
	 * @param procedureNameMap the locales and localized procedure names of this procedure master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProcedureNameMap(
		Map<java.util.Locale, String> procedureNameMap,
		java.util.Locale defaultLocale) {

		model.setProcedureNameMap(procedureNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this procedure master.
	 *
	 * @param uuid the uuid of this procedure master
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
	protected ProcedureMasterWrapper wrap(ProcedureMaster procedureMaster) {
		return new ProcedureMasterWrapper(procedureMaster);
	}

}