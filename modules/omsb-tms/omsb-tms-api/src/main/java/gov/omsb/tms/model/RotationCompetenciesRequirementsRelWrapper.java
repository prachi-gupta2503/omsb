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
 * This class is a wrapper for {@link RotationCompetenciesRequirementsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationCompetenciesRequirementsRel
 * @generated
 */
public class RotationCompetenciesRequirementsRelWrapper
	extends BaseModelWrapper<RotationCompetenciesRequirementsRel>
	implements ModelWrapper<RotationCompetenciesRequirementsRel>,
			   RotationCompetenciesRequirementsRel {

	public RotationCompetenciesRequirementsRelWrapper(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		super(rotationCompetenciesRequirementsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"rotationCompetenciesRelId", getRotationCompetenciesRelId());
		attributes.put("progDurationId", getProgDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("competenciesMasterId", getCompetenciesMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("requirements", getRequirements());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rotationCompetenciesRelId = (Long)attributes.get(
			"rotationCompetenciesRelId");

		if (rotationCompetenciesRelId != null) {
			setRotationCompetenciesRelId(rotationCompetenciesRelId);
		}

		Long progDurationId = (Long)attributes.get("progDurationId");

		if (progDurationId != null) {
			setProgDurationId(progDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
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

		String requirements = (String)attributes.get("requirements");

		if (requirements != null) {
			setRequirements(requirements);
		}
	}

	@Override
	public RotationCompetenciesRequirementsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this rotation competencies requirements rel.
	 *
	 * @return the company ID of this rotation competencies requirements rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the competencies master ID of this rotation competencies requirements rel.
	 *
	 * @return the competencies master ID of this rotation competencies requirements rel
	 */
	@Override
	public long getCompetenciesMasterId() {
		return model.getCompetenciesMasterId();
	}

	/**
	 * Returns the create date of this rotation competencies requirements rel.
	 *
	 * @return the create date of this rotation competencies requirements rel
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
	 * Returns the group ID of this rotation competencies requirements rel.
	 *
	 * @return the group ID of this rotation competencies requirements rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this rotation competencies requirements rel.
	 *
	 * @return the modified date of this rotation competencies requirements rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this rotation competencies requirements rel.
	 *
	 * @return the primary key of this rotation competencies requirements rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog duration ID of this rotation competencies requirements rel.
	 *
	 * @return the prog duration ID of this rotation competencies requirements rel
	 */
	@Override
	public long getProgDurationId() {
		return model.getProgDurationId();
	}

	/**
	 * Returns the requirements of this rotation competencies requirements rel.
	 *
	 * @return the requirements of this rotation competencies requirements rel
	 */
	@Override
	public String getRequirements() {
		return model.getRequirements();
	}

	/**
	 * Returns the localized requirements of this rotation competencies requirements rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized requirements of this rotation competencies requirements rel
	 */
	@Override
	public String getRequirements(java.util.Locale locale) {
		return model.getRequirements(locale);
	}

	/**
	 * Returns the localized requirements of this rotation competencies requirements rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requirements of this rotation competencies requirements rel. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRequirements(java.util.Locale locale, boolean useDefault) {
		return model.getRequirements(locale, useDefault);
	}

	/**
	 * Returns the localized requirements of this rotation competencies requirements rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized requirements of this rotation competencies requirements rel
	 */
	@Override
	public String getRequirements(String languageId) {
		return model.getRequirements(languageId);
	}

	/**
	 * Returns the localized requirements of this rotation competencies requirements rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requirements of this rotation competencies requirements rel
	 */
	@Override
	public String getRequirements(String languageId, boolean useDefault) {
		return model.getRequirements(languageId, useDefault);
	}

	@Override
	public String getRequirementsCurrentLanguageId() {
		return model.getRequirementsCurrentLanguageId();
	}

	@Override
	public String getRequirementsCurrentValue() {
		return model.getRequirementsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized requirementses of this rotation competencies requirements rel.
	 *
	 * @return the locales and localized requirementses of this rotation competencies requirements rel
	 */
	@Override
	public Map<java.util.Locale, String> getRequirementsMap() {
		return model.getRequirementsMap();
	}

	/**
	 * Returns the rotation competencies rel ID of this rotation competencies requirements rel.
	 *
	 * @return the rotation competencies rel ID of this rotation competencies requirements rel
	 */
	@Override
	public long getRotationCompetenciesRelId() {
		return model.getRotationCompetenciesRelId();
	}

	/**
	 * Returns the rotation ID of this rotation competencies requirements rel.
	 *
	 * @return the rotation ID of this rotation competencies requirements rel
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the uuid of this rotation competencies requirements rel.
	 *
	 * @return the uuid of this rotation competencies requirements rel
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
	 * Sets the company ID of this rotation competencies requirements rel.
	 *
	 * @param companyId the company ID of this rotation competencies requirements rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the competencies master ID of this rotation competencies requirements rel.
	 *
	 * @param competenciesMasterId the competencies master ID of this rotation competencies requirements rel
	 */
	@Override
	public void setCompetenciesMasterId(long competenciesMasterId) {
		model.setCompetenciesMasterId(competenciesMasterId);
	}

	/**
	 * Sets the create date of this rotation competencies requirements rel.
	 *
	 * @param createDate the create date of this rotation competencies requirements rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this rotation competencies requirements rel.
	 *
	 * @param groupId the group ID of this rotation competencies requirements rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this rotation competencies requirements rel.
	 *
	 * @param modifiedDate the modified date of this rotation competencies requirements rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this rotation competencies requirements rel.
	 *
	 * @param primaryKey the primary key of this rotation competencies requirements rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog duration ID of this rotation competencies requirements rel.
	 *
	 * @param progDurationId the prog duration ID of this rotation competencies requirements rel
	 */
	@Override
	public void setProgDurationId(long progDurationId) {
		model.setProgDurationId(progDurationId);
	}

	/**
	 * Sets the requirements of this rotation competencies requirements rel.
	 *
	 * @param requirements the requirements of this rotation competencies requirements rel
	 */
	@Override
	public void setRequirements(String requirements) {
		model.setRequirements(requirements);
	}

	/**
	 * Sets the localized requirements of this rotation competencies requirements rel in the language.
	 *
	 * @param requirements the localized requirements of this rotation competencies requirements rel
	 * @param locale the locale of the language
	 */
	@Override
	public void setRequirements(String requirements, java.util.Locale locale) {
		model.setRequirements(requirements, locale);
	}

	/**
	 * Sets the localized requirements of this rotation competencies requirements rel in the language, and sets the default locale.
	 *
	 * @param requirements the localized requirements of this rotation competencies requirements rel
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRequirements(
		String requirements, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRequirements(requirements, locale, defaultLocale);
	}

	@Override
	public void setRequirementsCurrentLanguageId(String languageId) {
		model.setRequirementsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized requirementses of this rotation competencies requirements rel from the map of locales and localized requirementses.
	 *
	 * @param requirementsMap the locales and localized requirementses of this rotation competencies requirements rel
	 */
	@Override
	public void setRequirementsMap(
		Map<java.util.Locale, String> requirementsMap) {

		model.setRequirementsMap(requirementsMap);
	}

	/**
	 * Sets the localized requirementses of this rotation competencies requirements rel from the map of locales and localized requirementses, and sets the default locale.
	 *
	 * @param requirementsMap the locales and localized requirementses of this rotation competencies requirements rel
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRequirementsMap(
		Map<java.util.Locale, String> requirementsMap,
		java.util.Locale defaultLocale) {

		model.setRequirementsMap(requirementsMap, defaultLocale);
	}

	/**
	 * Sets the rotation competencies rel ID of this rotation competencies requirements rel.
	 *
	 * @param rotationCompetenciesRelId the rotation competencies rel ID of this rotation competencies requirements rel
	 */
	@Override
	public void setRotationCompetenciesRelId(long rotationCompetenciesRelId) {
		model.setRotationCompetenciesRelId(rotationCompetenciesRelId);
	}

	/**
	 * Sets the rotation ID of this rotation competencies requirements rel.
	 *
	 * @param rotationId the rotation ID of this rotation competencies requirements rel
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the uuid of this rotation competencies requirements rel.
	 *
	 * @param uuid the uuid of this rotation competencies requirements rel
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
	protected RotationCompetenciesRequirementsRelWrapper wrap(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		return new RotationCompetenciesRequirementsRelWrapper(
			rotationCompetenciesRequirementsRel);
	}

}