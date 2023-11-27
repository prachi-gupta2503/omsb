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
 * This class is a wrapper for {@link ParticipationTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMaster
 * @generated
 */
public class ParticipationTypeMasterWrapper
	extends BaseModelWrapper<ParticipationTypeMaster>
	implements ModelWrapper<ParticipationTypeMaster>, ParticipationTypeMaster {

	public ParticipationTypeMasterWrapper(
		ParticipationTypeMaster participationTypeMaster) {

		super(participationTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"participationTypeMasterId", getParticipationTypeMasterId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("participationTypeName", getParticipationTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long participationTypeMasterId = (Long)attributes.get(
			"participationTypeMasterId");

		if (participationTypeMasterId != null) {
			setParticipationTypeMasterId(participationTypeMasterId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
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

		String participationTypeName = (String)attributes.get(
			"participationTypeName");

		if (participationTypeName != null) {
			setParticipationTypeName(participationTypeName);
		}
	}

	@Override
	public ParticipationTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this participation type master.
	 *
	 * @return the company ID of this participation type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this participation type master.
	 *
	 * @return the create date of this participation type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this participation type master.
	 *
	 * @return the created by of this participation type master
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
	 * Returns the group ID of this participation type master.
	 *
	 * @return the group ID of this participation type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this participation type master.
	 *
	 * @return the modified by of this participation type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this participation type master.
	 *
	 * @return the modified date of this participation type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the participation type master ID of this participation type master.
	 *
	 * @return the participation type master ID of this participation type master
	 */
	@Override
	public long getParticipationTypeMasterId() {
		return model.getParticipationTypeMasterId();
	}

	/**
	 * Returns the participation type name of this participation type master.
	 *
	 * @return the participation type name of this participation type master
	 */
	@Override
	public String getParticipationTypeName() {
		return model.getParticipationTypeName();
	}

	/**
	 * Returns the localized participation type name of this participation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized participation type name of this participation type master
	 */
	@Override
	public String getParticipationTypeName(java.util.Locale locale) {
		return model.getParticipationTypeName(locale);
	}

	/**
	 * Returns the localized participation type name of this participation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized participation type name of this participation type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getParticipationTypeName(
		java.util.Locale locale, boolean useDefault) {

		return model.getParticipationTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized participation type name of this participation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized participation type name of this participation type master
	 */
	@Override
	public String getParticipationTypeName(String languageId) {
		return model.getParticipationTypeName(languageId);
	}

	/**
	 * Returns the localized participation type name of this participation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized participation type name of this participation type master
	 */
	@Override
	public String getParticipationTypeName(
		String languageId, boolean useDefault) {

		return model.getParticipationTypeName(languageId, useDefault);
	}

	@Override
	public String getParticipationTypeNameCurrentLanguageId() {
		return model.getParticipationTypeNameCurrentLanguageId();
	}

	@Override
	public String getParticipationTypeNameCurrentValue() {
		return model.getParticipationTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized participation type names of this participation type master.
	 *
	 * @return the locales and localized participation type names of this participation type master
	 */
	@Override
	public Map<java.util.Locale, String> getParticipationTypeNameMap() {
		return model.getParticipationTypeNameMap();
	}

	/**
	 * Returns the primary key of this participation type master.
	 *
	 * @return the primary key of this participation type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this participation type master.
	 *
	 * @return the program duration ID of this participation type master
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the uuid of this participation type master.
	 *
	 * @return the uuid of this participation type master
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
	 * Sets the company ID of this participation type master.
	 *
	 * @param companyId the company ID of this participation type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this participation type master.
	 *
	 * @param createDate the create date of this participation type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this participation type master.
	 *
	 * @param createdBy the created by of this participation type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this participation type master.
	 *
	 * @param groupId the group ID of this participation type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this participation type master.
	 *
	 * @param modifiedBy the modified by of this participation type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this participation type master.
	 *
	 * @param modifiedDate the modified date of this participation type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the participation type master ID of this participation type master.
	 *
	 * @param participationTypeMasterId the participation type master ID of this participation type master
	 */
	@Override
	public void setParticipationTypeMasterId(long participationTypeMasterId) {
		model.setParticipationTypeMasterId(participationTypeMasterId);
	}

	/**
	 * Sets the participation type name of this participation type master.
	 *
	 * @param participationTypeName the participation type name of this participation type master
	 */
	@Override
	public void setParticipationTypeName(String participationTypeName) {
		model.setParticipationTypeName(participationTypeName);
	}

	/**
	 * Sets the localized participation type name of this participation type master in the language.
	 *
	 * @param participationTypeName the localized participation type name of this participation type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setParticipationTypeName(
		String participationTypeName, java.util.Locale locale) {

		model.setParticipationTypeName(participationTypeName, locale);
	}

	/**
	 * Sets the localized participation type name of this participation type master in the language, and sets the default locale.
	 *
	 * @param participationTypeName the localized participation type name of this participation type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setParticipationTypeName(
		String participationTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setParticipationTypeName(
			participationTypeName, locale, defaultLocale);
	}

	@Override
	public void setParticipationTypeNameCurrentLanguageId(String languageId) {
		model.setParticipationTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized participation type names of this participation type master from the map of locales and localized participation type names.
	 *
	 * @param participationTypeNameMap the locales and localized participation type names of this participation type master
	 */
	@Override
	public void setParticipationTypeNameMap(
		Map<java.util.Locale, String> participationTypeNameMap) {

		model.setParticipationTypeNameMap(participationTypeNameMap);
	}

	/**
	 * Sets the localized participation type names of this participation type master from the map of locales and localized participation type names, and sets the default locale.
	 *
	 * @param participationTypeNameMap the locales and localized participation type names of this participation type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setParticipationTypeNameMap(
		Map<java.util.Locale, String> participationTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setParticipationTypeNameMap(
			participationTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this participation type master.
	 *
	 * @param primaryKey the primary key of this participation type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this participation type master.
	 *
	 * @param programDurationId the program duration ID of this participation type master
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the uuid of this participation type master.
	 *
	 * @param uuid the uuid of this participation type master
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
	protected ParticipationTypeMasterWrapper wrap(
		ParticipationTypeMaster participationTypeMaster) {

		return new ParticipationTypeMasterWrapper(participationTypeMaster);
	}

}