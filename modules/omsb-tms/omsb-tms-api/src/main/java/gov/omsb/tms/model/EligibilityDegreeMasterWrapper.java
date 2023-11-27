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
 * This class is a wrapper for {@link EligibilityDegreeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMaster
 * @generated
 */
public class EligibilityDegreeMasterWrapper
	extends BaseModelWrapper<EligibilityDegreeMaster>
	implements EligibilityDegreeMaster, ModelWrapper<EligibilityDegreeMaster> {

	public EligibilityDegreeMasterWrapper(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		super(eligibilityDegreeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"eligibilityDegreeMasterId", getEligibilityDegreeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("eligibilityDegree", getEligibilityDegree());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eligibilityDegreeMasterId = (Long)attributes.get(
			"eligibilityDegreeMasterId");

		if (eligibilityDegreeMasterId != null) {
			setEligibilityDegreeMasterId(eligibilityDegreeMasterId);
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

		String eligibilityDegree = (String)attributes.get("eligibilityDegree");

		if (eligibilityDegree != null) {
			setEligibilityDegree(eligibilityDegree);
		}
	}

	@Override
	public EligibilityDegreeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this eligibility degree master.
	 *
	 * @return the company ID of this eligibility degree master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this eligibility degree master.
	 *
	 * @return the create date of this eligibility degree master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this eligibility degree master.
	 *
	 * @return the created by of this eligibility degree master
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
	 * Returns the eligibility degree of this eligibility degree master.
	 *
	 * @return the eligibility degree of this eligibility degree master
	 */
	@Override
	public String getEligibilityDegree() {
		return model.getEligibilityDegree();
	}

	/**
	 * Returns the localized eligibility degree of this eligibility degree master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized eligibility degree of this eligibility degree master
	 */
	@Override
	public String getEligibilityDegree(java.util.Locale locale) {
		return model.getEligibilityDegree(locale);
	}

	/**
	 * Returns the localized eligibility degree of this eligibility degree master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized eligibility degree of this eligibility degree master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getEligibilityDegree(
		java.util.Locale locale, boolean useDefault) {

		return model.getEligibilityDegree(locale, useDefault);
	}

	/**
	 * Returns the localized eligibility degree of this eligibility degree master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized eligibility degree of this eligibility degree master
	 */
	@Override
	public String getEligibilityDegree(String languageId) {
		return model.getEligibilityDegree(languageId);
	}

	/**
	 * Returns the localized eligibility degree of this eligibility degree master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized eligibility degree of this eligibility degree master
	 */
	@Override
	public String getEligibilityDegree(String languageId, boolean useDefault) {
		return model.getEligibilityDegree(languageId, useDefault);
	}

	@Override
	public String getEligibilityDegreeCurrentLanguageId() {
		return model.getEligibilityDegreeCurrentLanguageId();
	}

	@Override
	public String getEligibilityDegreeCurrentValue() {
		return model.getEligibilityDegreeCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized eligibility degrees of this eligibility degree master.
	 *
	 * @return the locales and localized eligibility degrees of this eligibility degree master
	 */
	@Override
	public Map<java.util.Locale, String> getEligibilityDegreeMap() {
		return model.getEligibilityDegreeMap();
	}

	/**
	 * Returns the eligibility degree master ID of this eligibility degree master.
	 *
	 * @return the eligibility degree master ID of this eligibility degree master
	 */
	@Override
	public long getEligibilityDegreeMasterId() {
		return model.getEligibilityDegreeMasterId();
	}

	/**
	 * Returns the group ID of this eligibility degree master.
	 *
	 * @return the group ID of this eligibility degree master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this eligibility degree master.
	 *
	 * @return the modified by of this eligibility degree master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this eligibility degree master.
	 *
	 * @return the modified date of this eligibility degree master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this eligibility degree master.
	 *
	 * @return the primary key of this eligibility degree master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this eligibility degree master.
	 *
	 * @return the uuid of this eligibility degree master
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
	 * Sets the company ID of this eligibility degree master.
	 *
	 * @param companyId the company ID of this eligibility degree master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this eligibility degree master.
	 *
	 * @param createDate the create date of this eligibility degree master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this eligibility degree master.
	 *
	 * @param createdBy the created by of this eligibility degree master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the eligibility degree of this eligibility degree master.
	 *
	 * @param eligibilityDegree the eligibility degree of this eligibility degree master
	 */
	@Override
	public void setEligibilityDegree(String eligibilityDegree) {
		model.setEligibilityDegree(eligibilityDegree);
	}

	/**
	 * Sets the localized eligibility degree of this eligibility degree master in the language.
	 *
	 * @param eligibilityDegree the localized eligibility degree of this eligibility degree master
	 * @param locale the locale of the language
	 */
	@Override
	public void setEligibilityDegree(
		String eligibilityDegree, java.util.Locale locale) {

		model.setEligibilityDegree(eligibilityDegree, locale);
	}

	/**
	 * Sets the localized eligibility degree of this eligibility degree master in the language, and sets the default locale.
	 *
	 * @param eligibilityDegree the localized eligibility degree of this eligibility degree master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setEligibilityDegree(
		String eligibilityDegree, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setEligibilityDegree(eligibilityDegree, locale, defaultLocale);
	}

	@Override
	public void setEligibilityDegreeCurrentLanguageId(String languageId) {
		model.setEligibilityDegreeCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized eligibility degrees of this eligibility degree master from the map of locales and localized eligibility degrees.
	 *
	 * @param eligibilityDegreeMap the locales and localized eligibility degrees of this eligibility degree master
	 */
	@Override
	public void setEligibilityDegreeMap(
		Map<java.util.Locale, String> eligibilityDegreeMap) {

		model.setEligibilityDegreeMap(eligibilityDegreeMap);
	}

	/**
	 * Sets the localized eligibility degrees of this eligibility degree master from the map of locales and localized eligibility degrees, and sets the default locale.
	 *
	 * @param eligibilityDegreeMap the locales and localized eligibility degrees of this eligibility degree master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setEligibilityDegreeMap(
		Map<java.util.Locale, String> eligibilityDegreeMap,
		java.util.Locale defaultLocale) {

		model.setEligibilityDegreeMap(eligibilityDegreeMap, defaultLocale);
	}

	/**
	 * Sets the eligibility degree master ID of this eligibility degree master.
	 *
	 * @param eligibilityDegreeMasterId the eligibility degree master ID of this eligibility degree master
	 */
	@Override
	public void setEligibilityDegreeMasterId(long eligibilityDegreeMasterId) {
		model.setEligibilityDegreeMasterId(eligibilityDegreeMasterId);
	}

	/**
	 * Sets the group ID of this eligibility degree master.
	 *
	 * @param groupId the group ID of this eligibility degree master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this eligibility degree master.
	 *
	 * @param modifiedBy the modified by of this eligibility degree master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this eligibility degree master.
	 *
	 * @param modifiedDate the modified date of this eligibility degree master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this eligibility degree master.
	 *
	 * @param primaryKey the primary key of this eligibility degree master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this eligibility degree master.
	 *
	 * @param uuid the uuid of this eligibility degree master
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
	protected EligibilityDegreeMasterWrapper wrap(
		EligibilityDegreeMaster eligibilityDegreeMaster) {

		return new EligibilityDegreeMasterWrapper(eligibilityDegreeMaster);
	}

}