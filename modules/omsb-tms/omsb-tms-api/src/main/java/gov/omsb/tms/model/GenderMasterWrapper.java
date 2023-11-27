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
 * This class is a wrapper for {@link GenderMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderMaster
 * @generated
 */
public class GenderMasterWrapper
	extends BaseModelWrapper<GenderMaster>
	implements GenderMaster, ModelWrapper<GenderMaster> {

	public GenderMasterWrapper(GenderMaster genderMaster) {
		super(genderMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("genderMasterId", getGenderMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("genderName", getGenderName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long genderMasterId = (Long)attributes.get("genderMasterId");

		if (genderMasterId != null) {
			setGenderMasterId(genderMasterId);
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

		String genderName = (String)attributes.get("genderName");

		if (genderName != null) {
			setGenderName(genderName);
		}
	}

	@Override
	public GenderMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this gender master.
	 *
	 * @return the company ID of this gender master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this gender master.
	 *
	 * @return the create date of this gender master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this gender master.
	 *
	 * @return the created by of this gender master
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
	 * Returns the gender master ID of this gender master.
	 *
	 * @return the gender master ID of this gender master
	 */
	@Override
	public long getGenderMasterId() {
		return model.getGenderMasterId();
	}

	/**
	 * Returns the gender name of this gender master.
	 *
	 * @return the gender name of this gender master
	 */
	@Override
	public String getGenderName() {
		return model.getGenderName();
	}

	/**
	 * Returns the localized gender name of this gender master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized gender name of this gender master
	 */
	@Override
	public String getGenderName(java.util.Locale locale) {
		return model.getGenderName(locale);
	}

	/**
	 * Returns the localized gender name of this gender master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized gender name of this gender master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getGenderName(java.util.Locale locale, boolean useDefault) {
		return model.getGenderName(locale, useDefault);
	}

	/**
	 * Returns the localized gender name of this gender master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized gender name of this gender master
	 */
	@Override
	public String getGenderName(String languageId) {
		return model.getGenderName(languageId);
	}

	/**
	 * Returns the localized gender name of this gender master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized gender name of this gender master
	 */
	@Override
	public String getGenderName(String languageId, boolean useDefault) {
		return model.getGenderName(languageId, useDefault);
	}

	@Override
	public String getGenderNameCurrentLanguageId() {
		return model.getGenderNameCurrentLanguageId();
	}

	@Override
	public String getGenderNameCurrentValue() {
		return model.getGenderNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized gender names of this gender master.
	 *
	 * @return the locales and localized gender names of this gender master
	 */
	@Override
	public Map<java.util.Locale, String> getGenderNameMap() {
		return model.getGenderNameMap();
	}

	/**
	 * Returns the group ID of this gender master.
	 *
	 * @return the group ID of this gender master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this gender master.
	 *
	 * @return the modified by of this gender master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this gender master.
	 *
	 * @return the modified date of this gender master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this gender master.
	 *
	 * @return the primary key of this gender master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this gender master.
	 *
	 * @return the uuid of this gender master
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
	 * Sets the company ID of this gender master.
	 *
	 * @param companyId the company ID of this gender master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this gender master.
	 *
	 * @param createDate the create date of this gender master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this gender master.
	 *
	 * @param createdBy the created by of this gender master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the gender master ID of this gender master.
	 *
	 * @param genderMasterId the gender master ID of this gender master
	 */
	@Override
	public void setGenderMasterId(long genderMasterId) {
		model.setGenderMasterId(genderMasterId);
	}

	/**
	 * Sets the gender name of this gender master.
	 *
	 * @param genderName the gender name of this gender master
	 */
	@Override
	public void setGenderName(String genderName) {
		model.setGenderName(genderName);
	}

	/**
	 * Sets the localized gender name of this gender master in the language.
	 *
	 * @param genderName the localized gender name of this gender master
	 * @param locale the locale of the language
	 */
	@Override
	public void setGenderName(String genderName, java.util.Locale locale) {
		model.setGenderName(genderName, locale);
	}

	/**
	 * Sets the localized gender name of this gender master in the language, and sets the default locale.
	 *
	 * @param genderName the localized gender name of this gender master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setGenderName(
		String genderName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setGenderName(genderName, locale, defaultLocale);
	}

	@Override
	public void setGenderNameCurrentLanguageId(String languageId) {
		model.setGenderNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized gender names of this gender master from the map of locales and localized gender names.
	 *
	 * @param genderNameMap the locales and localized gender names of this gender master
	 */
	@Override
	public void setGenderNameMap(Map<java.util.Locale, String> genderNameMap) {
		model.setGenderNameMap(genderNameMap);
	}

	/**
	 * Sets the localized gender names of this gender master from the map of locales and localized gender names, and sets the default locale.
	 *
	 * @param genderNameMap the locales and localized gender names of this gender master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setGenderNameMap(
		Map<java.util.Locale, String> genderNameMap,
		java.util.Locale defaultLocale) {

		model.setGenderNameMap(genderNameMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this gender master.
	 *
	 * @param groupId the group ID of this gender master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this gender master.
	 *
	 * @param modifiedBy the modified by of this gender master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this gender master.
	 *
	 * @param modifiedDate the modified date of this gender master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this gender master.
	 *
	 * @param primaryKey the primary key of this gender master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this gender master.
	 *
	 * @param uuid the uuid of this gender master
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
	protected GenderMasterWrapper wrap(GenderMaster genderMaster) {
		return new GenderMasterWrapper(genderMaster);
	}

}