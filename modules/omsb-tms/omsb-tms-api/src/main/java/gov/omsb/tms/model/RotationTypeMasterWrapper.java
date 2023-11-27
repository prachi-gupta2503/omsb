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
 * This class is a wrapper for {@link RotationTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationTypeMaster
 * @generated
 */
public class RotationTypeMasterWrapper
	extends BaseModelWrapper<RotationTypeMaster>
	implements ModelWrapper<RotationTypeMaster>, RotationTypeMaster {

	public RotationTypeMasterWrapper(RotationTypeMaster rotationTypeMaster) {
		super(rotationTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rotationTypeMasterId", getRotationTypeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("rotationTypeName", getRotationTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rotationTypeMasterId = (Long)attributes.get(
			"rotationTypeMasterId");

		if (rotationTypeMasterId != null) {
			setRotationTypeMasterId(rotationTypeMasterId);
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

		String rotationTypeName = (String)attributes.get("rotationTypeName");

		if (rotationTypeName != null) {
			setRotationTypeName(rotationTypeName);
		}
	}

	@Override
	public RotationTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this rotation type master.
	 *
	 * @return the company ID of this rotation type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this rotation type master.
	 *
	 * @return the create date of this rotation type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this rotation type master.
	 *
	 * @return the created by of this rotation type master
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
	 * Returns the group ID of this rotation type master.
	 *
	 * @return the group ID of this rotation type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this rotation type master.
	 *
	 * @return the modified by of this rotation type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this rotation type master.
	 *
	 * @return the modified date of this rotation type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this rotation type master.
	 *
	 * @return the primary key of this rotation type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rotation type master ID of this rotation type master.
	 *
	 * @return the rotation type master ID of this rotation type master
	 */
	@Override
	public long getRotationTypeMasterId() {
		return model.getRotationTypeMasterId();
	}

	/**
	 * Returns the rotation type name of this rotation type master.
	 *
	 * @return the rotation type name of this rotation type master
	 */
	@Override
	public String getRotationTypeName() {
		return model.getRotationTypeName();
	}

	/**
	 * Returns the localized rotation type name of this rotation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation type name of this rotation type master
	 */
	@Override
	public String getRotationTypeName(java.util.Locale locale) {
		return model.getRotationTypeName(locale);
	}

	/**
	 * Returns the localized rotation type name of this rotation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation type name of this rotation type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRotationTypeName(
		java.util.Locale locale, boolean useDefault) {

		return model.getRotationTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized rotation type name of this rotation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation type name of this rotation type master
	 */
	@Override
	public String getRotationTypeName(String languageId) {
		return model.getRotationTypeName(languageId);
	}

	/**
	 * Returns the localized rotation type name of this rotation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation type name of this rotation type master
	 */
	@Override
	public String getRotationTypeName(String languageId, boolean useDefault) {
		return model.getRotationTypeName(languageId, useDefault);
	}

	@Override
	public String getRotationTypeNameCurrentLanguageId() {
		return model.getRotationTypeNameCurrentLanguageId();
	}

	@Override
	public String getRotationTypeNameCurrentValue() {
		return model.getRotationTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized rotation type names of this rotation type master.
	 *
	 * @return the locales and localized rotation type names of this rotation type master
	 */
	@Override
	public Map<java.util.Locale, String> getRotationTypeNameMap() {
		return model.getRotationTypeNameMap();
	}

	/**
	 * Returns the uuid of this rotation type master.
	 *
	 * @return the uuid of this rotation type master
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
	 * Sets the company ID of this rotation type master.
	 *
	 * @param companyId the company ID of this rotation type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this rotation type master.
	 *
	 * @param createDate the create date of this rotation type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this rotation type master.
	 *
	 * @param createdBy the created by of this rotation type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this rotation type master.
	 *
	 * @param groupId the group ID of this rotation type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this rotation type master.
	 *
	 * @param modifiedBy the modified by of this rotation type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this rotation type master.
	 *
	 * @param modifiedDate the modified date of this rotation type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this rotation type master.
	 *
	 * @param primaryKey the primary key of this rotation type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rotation type master ID of this rotation type master.
	 *
	 * @param rotationTypeMasterId the rotation type master ID of this rotation type master
	 */
	@Override
	public void setRotationTypeMasterId(long rotationTypeMasterId) {
		model.setRotationTypeMasterId(rotationTypeMasterId);
	}

	/**
	 * Sets the rotation type name of this rotation type master.
	 *
	 * @param rotationTypeName the rotation type name of this rotation type master
	 */
	@Override
	public void setRotationTypeName(String rotationTypeName) {
		model.setRotationTypeName(rotationTypeName);
	}

	/**
	 * Sets the localized rotation type name of this rotation type master in the language.
	 *
	 * @param rotationTypeName the localized rotation type name of this rotation type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRotationTypeName(
		String rotationTypeName, java.util.Locale locale) {

		model.setRotationTypeName(rotationTypeName, locale);
	}

	/**
	 * Sets the localized rotation type name of this rotation type master in the language, and sets the default locale.
	 *
	 * @param rotationTypeName the localized rotation type name of this rotation type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationTypeName(
		String rotationTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRotationTypeName(rotationTypeName, locale, defaultLocale);
	}

	@Override
	public void setRotationTypeNameCurrentLanguageId(String languageId) {
		model.setRotationTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized rotation type names of this rotation type master from the map of locales and localized rotation type names.
	 *
	 * @param rotationTypeNameMap the locales and localized rotation type names of this rotation type master
	 */
	@Override
	public void setRotationTypeNameMap(
		Map<java.util.Locale, String> rotationTypeNameMap) {

		model.setRotationTypeNameMap(rotationTypeNameMap);
	}

	/**
	 * Sets the localized rotation type names of this rotation type master from the map of locales and localized rotation type names, and sets the default locale.
	 *
	 * @param rotationTypeNameMap the locales and localized rotation type names of this rotation type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRotationTypeNameMap(
		Map<java.util.Locale, String> rotationTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setRotationTypeNameMap(rotationTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this rotation type master.
	 *
	 * @param uuid the uuid of this rotation type master
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
	protected RotationTypeMasterWrapper wrap(
		RotationTypeMaster rotationTypeMaster) {

		return new RotationTypeMasterWrapper(rotationTypeMaster);
	}

}