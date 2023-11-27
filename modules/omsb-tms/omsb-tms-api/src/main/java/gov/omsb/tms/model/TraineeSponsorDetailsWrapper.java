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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TraineeSponsorDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetails
 * @generated
 */
public class TraineeSponsorDetailsWrapper
	extends BaseModelWrapper<TraineeSponsorDetails>
	implements ModelWrapper<TraineeSponsorDetails>, TraineeSponsorDetails {

	public TraineeSponsorDetailsWrapper(
		TraineeSponsorDetails traineeSponsorDetails) {

		super(traineeSponsorDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("traineeSponsorDetailsId", getTraineeSponsorDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("traineeId", getTraineeId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("sponsor", getSponsor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeSponsorDetailsId = (Long)attributes.get(
			"traineeSponsorDetailsId");

		if (traineeSponsorDetailsId != null) {
			setTraineeSponsorDetailsId(traineeSponsorDetailsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
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

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		String sponsor = (String)attributes.get("sponsor");

		if (sponsor != null) {
			setSponsor(sponsor);
		}
	}

	@Override
	public TraineeSponsorDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this trainee sponsor details.
	 *
	 * @return the company ID of this trainee sponsor details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by of this trainee sponsor details.
	 *
	 * @return the created by of this trainee sponsor details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this trainee sponsor details.
	 *
	 * @return the created date of this trainee sponsor details
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the group ID of this trainee sponsor details.
	 *
	 * @return the group ID of this trainee sponsor details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee sponsor details.
	 *
	 * @return the modified by of this trainee sponsor details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee sponsor details.
	 *
	 * @return the modified date of this trainee sponsor details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this trainee sponsor details.
	 *
	 * @return the primary key of this trainee sponsor details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this trainee sponsor details.
	 *
	 * @return the program duration ID of this trainee sponsor details
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the sponsor of this trainee sponsor details.
	 *
	 * @return the sponsor of this trainee sponsor details
	 */
	@Override
	public String getSponsor() {
		return model.getSponsor();
	}

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@Override
	public String getSponsor(java.util.Locale locale) {
		return model.getSponsor(locale);
	}

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sponsor of this trainee sponsor details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSponsor(java.util.Locale locale, boolean useDefault) {
		return model.getSponsor(locale, useDefault);
	}

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@Override
	public String getSponsor(String languageId) {
		return model.getSponsor(languageId);
	}

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@Override
	public String getSponsor(String languageId, boolean useDefault) {
		return model.getSponsor(languageId, useDefault);
	}

	@Override
	public String getSponsorCurrentLanguageId() {
		return model.getSponsorCurrentLanguageId();
	}

	@Override
	public String getSponsorCurrentValue() {
		return model.getSponsorCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized sponsors of this trainee sponsor details.
	 *
	 * @return the locales and localized sponsors of this trainee sponsor details
	 */
	@Override
	public Map<java.util.Locale, String> getSponsorMap() {
		return model.getSponsorMap();
	}

	/**
	 * Returns the trainee ID of this trainee sponsor details.
	 *
	 * @return the trainee ID of this trainee sponsor details
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the trainee sponsor details ID of this trainee sponsor details.
	 *
	 * @return the trainee sponsor details ID of this trainee sponsor details
	 */
	@Override
	public long getTraineeSponsorDetailsId() {
		return model.getTraineeSponsorDetailsId();
	}

	/**
	 * Returns the uuid of this trainee sponsor details.
	 *
	 * @return the uuid of this trainee sponsor details
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
	 * Sets the company ID of this trainee sponsor details.
	 *
	 * @param companyId the company ID of this trainee sponsor details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by of this trainee sponsor details.
	 *
	 * @param createdBy the created by of this trainee sponsor details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this trainee sponsor details.
	 *
	 * @param createdDate the created date of this trainee sponsor details
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this trainee sponsor details.
	 *
	 * @param groupId the group ID of this trainee sponsor details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee sponsor details.
	 *
	 * @param modifiedBy the modified by of this trainee sponsor details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee sponsor details.
	 *
	 * @param modifiedDate the modified date of this trainee sponsor details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this trainee sponsor details.
	 *
	 * @param primaryKey the primary key of this trainee sponsor details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this trainee sponsor details.
	 *
	 * @param programDurationId the program duration ID of this trainee sponsor details
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the sponsor of this trainee sponsor details.
	 *
	 * @param sponsor the sponsor of this trainee sponsor details
	 */
	@Override
	public void setSponsor(String sponsor) {
		model.setSponsor(sponsor);
	}

	/**
	 * Sets the localized sponsor of this trainee sponsor details in the language.
	 *
	 * @param sponsor the localized sponsor of this trainee sponsor details
	 * @param locale the locale of the language
	 */
	@Override
	public void setSponsor(String sponsor, java.util.Locale locale) {
		model.setSponsor(sponsor, locale);
	}

	/**
	 * Sets the localized sponsor of this trainee sponsor details in the language, and sets the default locale.
	 *
	 * @param sponsor the localized sponsor of this trainee sponsor details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSponsor(
		String sponsor, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSponsor(sponsor, locale, defaultLocale);
	}

	@Override
	public void setSponsorCurrentLanguageId(String languageId) {
		model.setSponsorCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized sponsors of this trainee sponsor details from the map of locales and localized sponsors.
	 *
	 * @param sponsorMap the locales and localized sponsors of this trainee sponsor details
	 */
	@Override
	public void setSponsorMap(Map<java.util.Locale, String> sponsorMap) {
		model.setSponsorMap(sponsorMap);
	}

	/**
	 * Sets the localized sponsors of this trainee sponsor details from the map of locales and localized sponsors, and sets the default locale.
	 *
	 * @param sponsorMap the locales and localized sponsors of this trainee sponsor details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSponsorMap(
		Map<java.util.Locale, String> sponsorMap,
		java.util.Locale defaultLocale) {

		model.setSponsorMap(sponsorMap, defaultLocale);
	}

	/**
	 * Sets the trainee ID of this trainee sponsor details.
	 *
	 * @param traineeId the trainee ID of this trainee sponsor details
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the trainee sponsor details ID of this trainee sponsor details.
	 *
	 * @param traineeSponsorDetailsId the trainee sponsor details ID of this trainee sponsor details
	 */
	@Override
	public void setTraineeSponsorDetailsId(long traineeSponsorDetailsId) {
		model.setTraineeSponsorDetailsId(traineeSponsorDetailsId);
	}

	/**
	 * Sets the uuid of this trainee sponsor details.
	 *
	 * @param uuid the uuid of this trainee sponsor details
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
	protected TraineeSponsorDetailsWrapper wrap(
		TraineeSponsorDetails traineeSponsorDetails) {

		return new TraineeSponsorDetailsWrapper(traineeSponsorDetails);
	}

}