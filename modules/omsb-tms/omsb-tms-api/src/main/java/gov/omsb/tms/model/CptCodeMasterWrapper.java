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
 * This class is a wrapper for {@link CptCodeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMaster
 * @generated
 */
public class CptCodeMasterWrapper
	extends BaseModelWrapper<CptCodeMaster>
	implements CptCodeMaster, ModelWrapper<CptCodeMaster> {

	public CptCodeMasterWrapper(CptCodeMaster cptCodeMaster) {
		super(cptCodeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cptCodeMasterId", getCptCodeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("cptCodeName", getCptCodeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cptCodeMasterId = (Long)attributes.get("cptCodeMasterId");

		if (cptCodeMasterId != null) {
			setCptCodeMasterId(cptCodeMasterId);
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

		String cptCodeName = (String)attributes.get("cptCodeName");

		if (cptCodeName != null) {
			setCptCodeName(cptCodeName);
		}
	}

	@Override
	public CptCodeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this cpt code master.
	 *
	 * @return the company ID of this cpt code master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cpt code master ID of this cpt code master.
	 *
	 * @return the cpt code master ID of this cpt code master
	 */
	@Override
	public long getCptCodeMasterId() {
		return model.getCptCodeMasterId();
	}

	/**
	 * Returns the cpt code name of this cpt code master.
	 *
	 * @return the cpt code name of this cpt code master
	 */
	@Override
	public String getCptCodeName() {
		return model.getCptCodeName();
	}

	/**
	 * Returns the localized cpt code name of this cpt code master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized cpt code name of this cpt code master
	 */
	@Override
	public String getCptCodeName(java.util.Locale locale) {
		return model.getCptCodeName(locale);
	}

	/**
	 * Returns the localized cpt code name of this cpt code master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code name of this cpt code master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCptCodeName(java.util.Locale locale, boolean useDefault) {
		return model.getCptCodeName(locale, useDefault);
	}

	/**
	 * Returns the localized cpt code name of this cpt code master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized cpt code name of this cpt code master
	 */
	@Override
	public String getCptCodeName(String languageId) {
		return model.getCptCodeName(languageId);
	}

	/**
	 * Returns the localized cpt code name of this cpt code master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized cpt code name of this cpt code master
	 */
	@Override
	public String getCptCodeName(String languageId, boolean useDefault) {
		return model.getCptCodeName(languageId, useDefault);
	}

	@Override
	public String getCptCodeNameCurrentLanguageId() {
		return model.getCptCodeNameCurrentLanguageId();
	}

	@Override
	public String getCptCodeNameCurrentValue() {
		return model.getCptCodeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized cpt code names of this cpt code master.
	 *
	 * @return the locales and localized cpt code names of this cpt code master
	 */
	@Override
	public Map<java.util.Locale, String> getCptCodeNameMap() {
		return model.getCptCodeNameMap();
	}

	/**
	 * Returns the create date of this cpt code master.
	 *
	 * @return the create date of this cpt code master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this cpt code master.
	 *
	 * @return the created by of this cpt code master
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
	 * Returns the group ID of this cpt code master.
	 *
	 * @return the group ID of this cpt code master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this cpt code master.
	 *
	 * @return the modified by of this cpt code master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this cpt code master.
	 *
	 * @return the modified date of this cpt code master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cpt code master.
	 *
	 * @return the primary key of this cpt code master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this cpt code master.
	 *
	 * @return the uuid of this cpt code master
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
	 * Sets the company ID of this cpt code master.
	 *
	 * @param companyId the company ID of this cpt code master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cpt code master ID of this cpt code master.
	 *
	 * @param cptCodeMasterId the cpt code master ID of this cpt code master
	 */
	@Override
	public void setCptCodeMasterId(long cptCodeMasterId) {
		model.setCptCodeMasterId(cptCodeMasterId);
	}

	/**
	 * Sets the cpt code name of this cpt code master.
	 *
	 * @param cptCodeName the cpt code name of this cpt code master
	 */
	@Override
	public void setCptCodeName(String cptCodeName) {
		model.setCptCodeName(cptCodeName);
	}

	/**
	 * Sets the localized cpt code name of this cpt code master in the language.
	 *
	 * @param cptCodeName the localized cpt code name of this cpt code master
	 * @param locale the locale of the language
	 */
	@Override
	public void setCptCodeName(String cptCodeName, java.util.Locale locale) {
		model.setCptCodeName(cptCodeName, locale);
	}

	/**
	 * Sets the localized cpt code name of this cpt code master in the language, and sets the default locale.
	 *
	 * @param cptCodeName the localized cpt code name of this cpt code master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCodeName(
		String cptCodeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCptCodeName(cptCodeName, locale, defaultLocale);
	}

	@Override
	public void setCptCodeNameCurrentLanguageId(String languageId) {
		model.setCptCodeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized cpt code names of this cpt code master from the map of locales and localized cpt code names.
	 *
	 * @param cptCodeNameMap the locales and localized cpt code names of this cpt code master
	 */
	@Override
	public void setCptCodeNameMap(
		Map<java.util.Locale, String> cptCodeNameMap) {

		model.setCptCodeNameMap(cptCodeNameMap);
	}

	/**
	 * Sets the localized cpt code names of this cpt code master from the map of locales and localized cpt code names, and sets the default locale.
	 *
	 * @param cptCodeNameMap the locales and localized cpt code names of this cpt code master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCptCodeNameMap(
		Map<java.util.Locale, String> cptCodeNameMap,
		java.util.Locale defaultLocale) {

		model.setCptCodeNameMap(cptCodeNameMap, defaultLocale);
	}

	/**
	 * Sets the create date of this cpt code master.
	 *
	 * @param createDate the create date of this cpt code master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this cpt code master.
	 *
	 * @param createdBy the created by of this cpt code master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this cpt code master.
	 *
	 * @param groupId the group ID of this cpt code master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this cpt code master.
	 *
	 * @param modifiedBy the modified by of this cpt code master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this cpt code master.
	 *
	 * @param modifiedDate the modified date of this cpt code master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cpt code master.
	 *
	 * @param primaryKey the primary key of this cpt code master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this cpt code master.
	 *
	 * @param uuid the uuid of this cpt code master
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
	protected CptCodeMasterWrapper wrap(CptCodeMaster cptCodeMaster) {
		return new CptCodeMasterWrapper(cptCodeMaster);
	}

}