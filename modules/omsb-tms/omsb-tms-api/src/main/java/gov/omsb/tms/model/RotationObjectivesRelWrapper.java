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
 * This class is a wrapper for {@link RotationObjectivesRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationObjectivesRel
 * @generated
 */
public class RotationObjectivesRelWrapper
	extends BaseModelWrapper<RotationObjectivesRel>
	implements ModelWrapper<RotationObjectivesRel>, RotationObjectivesRel {

	public RotationObjectivesRelWrapper(
		RotationObjectivesRel rotationObjectivesRel) {

		super(rotationObjectivesRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rotationObjectivesRelId", getRotationObjectivesRelId());
		attributes.put("progDurationId", getProgDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("objectives", getObjectives());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rotationObjectivesRelId = (Long)attributes.get(
			"rotationObjectivesRelId");

		if (rotationObjectivesRelId != null) {
			setRotationObjectivesRelId(rotationObjectivesRelId);
		}

		Long progDurationId = (Long)attributes.get("progDurationId");

		if (progDurationId != null) {
			setProgDurationId(progDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
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

		String objectives = (String)attributes.get("objectives");

		if (objectives != null) {
			setObjectives(objectives);
		}
	}

	@Override
	public RotationObjectivesRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this rotation objectives rel.
	 *
	 * @return the company ID of this rotation objectives rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this rotation objectives rel.
	 *
	 * @return the create date of this rotation objectives rel
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
	 * Returns the group ID of this rotation objectives rel.
	 *
	 * @return the group ID of this rotation objectives rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this rotation objectives rel.
	 *
	 * @return the modified date of this rotation objectives rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the objectives of this rotation objectives rel.
	 *
	 * @return the objectives of this rotation objectives rel
	 */
	@Override
	public String getObjectives() {
		return model.getObjectives();
	}

	/**
	 * Returns the localized objectives of this rotation objectives rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized objectives of this rotation objectives rel
	 */
	@Override
	public String getObjectives(java.util.Locale locale) {
		return model.getObjectives(locale);
	}

	/**
	 * Returns the localized objectives of this rotation objectives rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized objectives of this rotation objectives rel. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getObjectives(java.util.Locale locale, boolean useDefault) {
		return model.getObjectives(locale, useDefault);
	}

	/**
	 * Returns the localized objectives of this rotation objectives rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized objectives of this rotation objectives rel
	 */
	@Override
	public String getObjectives(String languageId) {
		return model.getObjectives(languageId);
	}

	/**
	 * Returns the localized objectives of this rotation objectives rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized objectives of this rotation objectives rel
	 */
	@Override
	public String getObjectives(String languageId, boolean useDefault) {
		return model.getObjectives(languageId, useDefault);
	}

	@Override
	public String getObjectivesCurrentLanguageId() {
		return model.getObjectivesCurrentLanguageId();
	}

	@Override
	public String getObjectivesCurrentValue() {
		return model.getObjectivesCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized objectiveses of this rotation objectives rel.
	 *
	 * @return the locales and localized objectiveses of this rotation objectives rel
	 */
	@Override
	public Map<java.util.Locale, String> getObjectivesMap() {
		return model.getObjectivesMap();
	}

	/**
	 * Returns the primary key of this rotation objectives rel.
	 *
	 * @return the primary key of this rotation objectives rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prog duration ID of this rotation objectives rel.
	 *
	 * @return the prog duration ID of this rotation objectives rel
	 */
	@Override
	public long getProgDurationId() {
		return model.getProgDurationId();
	}

	/**
	 * Returns the rotation ID of this rotation objectives rel.
	 *
	 * @return the rotation ID of this rotation objectives rel
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the rotation objectives rel ID of this rotation objectives rel.
	 *
	 * @return the rotation objectives rel ID of this rotation objectives rel
	 */
	@Override
	public long getRotationObjectivesRelId() {
		return model.getRotationObjectivesRelId();
	}

	/**
	 * Returns the uuid of this rotation objectives rel.
	 *
	 * @return the uuid of this rotation objectives rel
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
	 * Sets the company ID of this rotation objectives rel.
	 *
	 * @param companyId the company ID of this rotation objectives rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this rotation objectives rel.
	 *
	 * @param createDate the create date of this rotation objectives rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this rotation objectives rel.
	 *
	 * @param groupId the group ID of this rotation objectives rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this rotation objectives rel.
	 *
	 * @param modifiedDate the modified date of this rotation objectives rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the objectives of this rotation objectives rel.
	 *
	 * @param objectives the objectives of this rotation objectives rel
	 */
	@Override
	public void setObjectives(String objectives) {
		model.setObjectives(objectives);
	}

	/**
	 * Sets the localized objectives of this rotation objectives rel in the language.
	 *
	 * @param objectives the localized objectives of this rotation objectives rel
	 * @param locale the locale of the language
	 */
	@Override
	public void setObjectives(String objectives, java.util.Locale locale) {
		model.setObjectives(objectives, locale);
	}

	/**
	 * Sets the localized objectives of this rotation objectives rel in the language, and sets the default locale.
	 *
	 * @param objectives the localized objectives of this rotation objectives rel
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setObjectives(
		String objectives, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setObjectives(objectives, locale, defaultLocale);
	}

	@Override
	public void setObjectivesCurrentLanguageId(String languageId) {
		model.setObjectivesCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized objectiveses of this rotation objectives rel from the map of locales and localized objectiveses.
	 *
	 * @param objectivesMap the locales and localized objectiveses of this rotation objectives rel
	 */
	@Override
	public void setObjectivesMap(Map<java.util.Locale, String> objectivesMap) {
		model.setObjectivesMap(objectivesMap);
	}

	/**
	 * Sets the localized objectiveses of this rotation objectives rel from the map of locales and localized objectiveses, and sets the default locale.
	 *
	 * @param objectivesMap the locales and localized objectiveses of this rotation objectives rel
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setObjectivesMap(
		Map<java.util.Locale, String> objectivesMap,
		java.util.Locale defaultLocale) {

		model.setObjectivesMap(objectivesMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this rotation objectives rel.
	 *
	 * @param primaryKey the primary key of this rotation objectives rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prog duration ID of this rotation objectives rel.
	 *
	 * @param progDurationId the prog duration ID of this rotation objectives rel
	 */
	@Override
	public void setProgDurationId(long progDurationId) {
		model.setProgDurationId(progDurationId);
	}

	/**
	 * Sets the rotation ID of this rotation objectives rel.
	 *
	 * @param rotationId the rotation ID of this rotation objectives rel
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the rotation objectives rel ID of this rotation objectives rel.
	 *
	 * @param rotationObjectivesRelId the rotation objectives rel ID of this rotation objectives rel
	 */
	@Override
	public void setRotationObjectivesRelId(long rotationObjectivesRelId) {
		model.setRotationObjectivesRelId(rotationObjectivesRelId);
	}

	/**
	 * Sets the uuid of this rotation objectives rel.
	 *
	 * @param uuid the uuid of this rotation objectives rel
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
	protected RotationObjectivesRelWrapper wrap(
		RotationObjectivesRel rotationObjectivesRel) {

		return new RotationObjectivesRelWrapper(rotationObjectivesRel);
	}

}