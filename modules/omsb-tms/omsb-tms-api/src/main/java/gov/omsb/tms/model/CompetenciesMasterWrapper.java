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
 * This class is a wrapper for {@link CompetenciesMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMaster
 * @generated
 */
public class CompetenciesMasterWrapper
	extends BaseModelWrapper<CompetenciesMaster>
	implements CompetenciesMaster, ModelWrapper<CompetenciesMaster> {

	public CompetenciesMasterWrapper(CompetenciesMaster competenciesMaster) {
		super(competenciesMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("competenciesMasterId", getCompetenciesMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("competencyName", getCompetencyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long competenciesMasterId = (Long)attributes.get(
			"competenciesMasterId");

		if (competenciesMasterId != null) {
			setCompetenciesMasterId(competenciesMasterId);
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

		String competencyName = (String)attributes.get("competencyName");

		if (competencyName != null) {
			setCompetencyName(competencyName);
		}
	}

	@Override
	public CompetenciesMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this competencies master.
	 *
	 * @return the company ID of this competencies master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the competencies master ID of this competencies master.
	 *
	 * @return the competencies master ID of this competencies master
	 */
	@Override
	public long getCompetenciesMasterId() {
		return model.getCompetenciesMasterId();
	}

	/**
	 * Returns the competency name of this competencies master.
	 *
	 * @return the competency name of this competencies master
	 */
	@Override
	public String getCompetencyName() {
		return model.getCompetencyName();
	}

	/**
	 * Returns the localized competency name of this competencies master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized competency name of this competencies master
	 */
	@Override
	public String getCompetencyName(java.util.Locale locale) {
		return model.getCompetencyName(locale);
	}

	/**
	 * Returns the localized competency name of this competencies master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized competency name of this competencies master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCompetencyName(
		java.util.Locale locale, boolean useDefault) {

		return model.getCompetencyName(locale, useDefault);
	}

	/**
	 * Returns the localized competency name of this competencies master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized competency name of this competencies master
	 */
	@Override
	public String getCompetencyName(String languageId) {
		return model.getCompetencyName(languageId);
	}

	/**
	 * Returns the localized competency name of this competencies master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized competency name of this competencies master
	 */
	@Override
	public String getCompetencyName(String languageId, boolean useDefault) {
		return model.getCompetencyName(languageId, useDefault);
	}

	@Override
	public String getCompetencyNameCurrentLanguageId() {
		return model.getCompetencyNameCurrentLanguageId();
	}

	@Override
	public String getCompetencyNameCurrentValue() {
		return model.getCompetencyNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized competency names of this competencies master.
	 *
	 * @return the locales and localized competency names of this competencies master
	 */
	@Override
	public Map<java.util.Locale, String> getCompetencyNameMap() {
		return model.getCompetencyNameMap();
	}

	/**
	 * Returns the create date of this competencies master.
	 *
	 * @return the create date of this competencies master
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
	 * Returns the group ID of this competencies master.
	 *
	 * @return the group ID of this competencies master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this competencies master.
	 *
	 * @return the modified date of this competencies master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this competencies master.
	 *
	 * @return the primary key of this competencies master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this competencies master.
	 *
	 * @return the uuid of this competencies master
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
	 * Sets the company ID of this competencies master.
	 *
	 * @param companyId the company ID of this competencies master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the competencies master ID of this competencies master.
	 *
	 * @param competenciesMasterId the competencies master ID of this competencies master
	 */
	@Override
	public void setCompetenciesMasterId(long competenciesMasterId) {
		model.setCompetenciesMasterId(competenciesMasterId);
	}

	/**
	 * Sets the competency name of this competencies master.
	 *
	 * @param competencyName the competency name of this competencies master
	 */
	@Override
	public void setCompetencyName(String competencyName) {
		model.setCompetencyName(competencyName);
	}

	/**
	 * Sets the localized competency name of this competencies master in the language.
	 *
	 * @param competencyName the localized competency name of this competencies master
	 * @param locale the locale of the language
	 */
	@Override
	public void setCompetencyName(
		String competencyName, java.util.Locale locale) {

		model.setCompetencyName(competencyName, locale);
	}

	/**
	 * Sets the localized competency name of this competencies master in the language, and sets the default locale.
	 *
	 * @param competencyName the localized competency name of this competencies master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCompetencyName(
		String competencyName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCompetencyName(competencyName, locale, defaultLocale);
	}

	@Override
	public void setCompetencyNameCurrentLanguageId(String languageId) {
		model.setCompetencyNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized competency names of this competencies master from the map of locales and localized competency names.
	 *
	 * @param competencyNameMap the locales and localized competency names of this competencies master
	 */
	@Override
	public void setCompetencyNameMap(
		Map<java.util.Locale, String> competencyNameMap) {

		model.setCompetencyNameMap(competencyNameMap);
	}

	/**
	 * Sets the localized competency names of this competencies master from the map of locales and localized competency names, and sets the default locale.
	 *
	 * @param competencyNameMap the locales and localized competency names of this competencies master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCompetencyNameMap(
		Map<java.util.Locale, String> competencyNameMap,
		java.util.Locale defaultLocale) {

		model.setCompetencyNameMap(competencyNameMap, defaultLocale);
	}

	/**
	 * Sets the create date of this competencies master.
	 *
	 * @param createDate the create date of this competencies master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this competencies master.
	 *
	 * @param groupId the group ID of this competencies master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this competencies master.
	 *
	 * @param modifiedDate the modified date of this competencies master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this competencies master.
	 *
	 * @param primaryKey the primary key of this competencies master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this competencies master.
	 *
	 * @param uuid the uuid of this competencies master
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
	protected CompetenciesMasterWrapper wrap(
		CompetenciesMaster competenciesMaster) {

		return new CompetenciesMasterWrapper(competenciesMaster);
	}

}