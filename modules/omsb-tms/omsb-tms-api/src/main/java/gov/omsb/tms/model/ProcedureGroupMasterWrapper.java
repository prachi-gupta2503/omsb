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
 * This class is a wrapper for {@link ProcedureGroupMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMaster
 * @generated
 */
public class ProcedureGroupMasterWrapper
	extends BaseModelWrapper<ProcedureGroupMaster>
	implements ModelWrapper<ProcedureGroupMaster>, ProcedureGroupMaster {

	public ProcedureGroupMasterWrapper(
		ProcedureGroupMaster procedureGroupMaster) {

		super(procedureGroupMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("procedureGroupMasterId", getProcedureGroupMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("procedureGroupName", getProcedureGroupName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
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

		String procedureGroupName = (String)attributes.get(
			"procedureGroupName");

		if (procedureGroupName != null) {
			setProcedureGroupName(procedureGroupName);
		}
	}

	@Override
	public ProcedureGroupMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this procedure group master.
	 *
	 * @return the company ID of this procedure group master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this procedure group master.
	 *
	 * @return the create date of this procedure group master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this procedure group master.
	 *
	 * @return the created by of this procedure group master
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
	 * Returns the group ID of this procedure group master.
	 *
	 * @return the group ID of this procedure group master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this procedure group master.
	 *
	 * @return the modified by of this procedure group master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this procedure group master.
	 *
	 * @return the modified date of this procedure group master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this procedure group master.
	 *
	 * @return the primary key of this procedure group master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procedure group master ID of this procedure group master.
	 *
	 * @return the procedure group master ID of this procedure group master
	 */
	@Override
	public long getProcedureGroupMasterId() {
		return model.getProcedureGroupMasterId();
	}

	/**
	 * Returns the procedure group name of this procedure group master.
	 *
	 * @return the procedure group name of this procedure group master
	 */
	@Override
	public String getProcedureGroupName() {
		return model.getProcedureGroupName();
	}

	/**
	 * Returns the localized procedure group name of this procedure group master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized procedure group name of this procedure group master
	 */
	@Override
	public String getProcedureGroupName(java.util.Locale locale) {
		return model.getProcedureGroupName(locale);
	}

	/**
	 * Returns the localized procedure group name of this procedure group master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized procedure group name of this procedure group master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProcedureGroupName(
		java.util.Locale locale, boolean useDefault) {

		return model.getProcedureGroupName(locale, useDefault);
	}

	/**
	 * Returns the localized procedure group name of this procedure group master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized procedure group name of this procedure group master
	 */
	@Override
	public String getProcedureGroupName(String languageId) {
		return model.getProcedureGroupName(languageId);
	}

	/**
	 * Returns the localized procedure group name of this procedure group master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized procedure group name of this procedure group master
	 */
	@Override
	public String getProcedureGroupName(String languageId, boolean useDefault) {
		return model.getProcedureGroupName(languageId, useDefault);
	}

	@Override
	public String getProcedureGroupNameCurrentLanguageId() {
		return model.getProcedureGroupNameCurrentLanguageId();
	}

	@Override
	public String getProcedureGroupNameCurrentValue() {
		return model.getProcedureGroupNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized procedure group names of this procedure group master.
	 *
	 * @return the locales and localized procedure group names of this procedure group master
	 */
	@Override
	public Map<java.util.Locale, String> getProcedureGroupNameMap() {
		return model.getProcedureGroupNameMap();
	}

	/**
	 * Returns the uuid of this procedure group master.
	 *
	 * @return the uuid of this procedure group master
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
	 * Sets the company ID of this procedure group master.
	 *
	 * @param companyId the company ID of this procedure group master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this procedure group master.
	 *
	 * @param createDate the create date of this procedure group master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this procedure group master.
	 *
	 * @param createdBy the created by of this procedure group master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this procedure group master.
	 *
	 * @param groupId the group ID of this procedure group master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this procedure group master.
	 *
	 * @param modifiedBy the modified by of this procedure group master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this procedure group master.
	 *
	 * @param modifiedDate the modified date of this procedure group master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this procedure group master.
	 *
	 * @param primaryKey the primary key of this procedure group master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procedure group master ID of this procedure group master.
	 *
	 * @param procedureGroupMasterId the procedure group master ID of this procedure group master
	 */
	@Override
	public void setProcedureGroupMasterId(long procedureGroupMasterId) {
		model.setProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Sets the procedure group name of this procedure group master.
	 *
	 * @param procedureGroupName the procedure group name of this procedure group master
	 */
	@Override
	public void setProcedureGroupName(String procedureGroupName) {
		model.setProcedureGroupName(procedureGroupName);
	}

	/**
	 * Sets the localized procedure group name of this procedure group master in the language.
	 *
	 * @param procedureGroupName the localized procedure group name of this procedure group master
	 * @param locale the locale of the language
	 */
	@Override
	public void setProcedureGroupName(
		String procedureGroupName, java.util.Locale locale) {

		model.setProcedureGroupName(procedureGroupName, locale);
	}

	/**
	 * Sets the localized procedure group name of this procedure group master in the language, and sets the default locale.
	 *
	 * @param procedureGroupName the localized procedure group name of this procedure group master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProcedureGroupName(
		String procedureGroupName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProcedureGroupName(procedureGroupName, locale, defaultLocale);
	}

	@Override
	public void setProcedureGroupNameCurrentLanguageId(String languageId) {
		model.setProcedureGroupNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized procedure group names of this procedure group master from the map of locales and localized procedure group names.
	 *
	 * @param procedureGroupNameMap the locales and localized procedure group names of this procedure group master
	 */
	@Override
	public void setProcedureGroupNameMap(
		Map<java.util.Locale, String> procedureGroupNameMap) {

		model.setProcedureGroupNameMap(procedureGroupNameMap);
	}

	/**
	 * Sets the localized procedure group names of this procedure group master from the map of locales and localized procedure group names, and sets the default locale.
	 *
	 * @param procedureGroupNameMap the locales and localized procedure group names of this procedure group master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProcedureGroupNameMap(
		Map<java.util.Locale, String> procedureGroupNameMap,
		java.util.Locale defaultLocale) {

		model.setProcedureGroupNameMap(procedureGroupNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this procedure group master.
	 *
	 * @param uuid the uuid of this procedure group master
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
	protected ProcedureGroupMasterWrapper wrap(
		ProcedureGroupMaster procedureGroupMaster) {

		return new ProcedureGroupMasterWrapper(procedureGroupMaster);
	}

}