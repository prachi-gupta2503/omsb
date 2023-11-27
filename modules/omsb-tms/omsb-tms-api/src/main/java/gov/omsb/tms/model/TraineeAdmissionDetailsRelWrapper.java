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
 * This class is a wrapper for {@link TraineeAdmissionDetailsRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRel
 * @generated
 */
public class TraineeAdmissionDetailsRelWrapper
	extends BaseModelWrapper<TraineeAdmissionDetailsRel>
	implements ModelWrapper<TraineeAdmissionDetailsRel>,
			   TraineeAdmissionDetailsRel {

	public TraineeAdmissionDetailsRelWrapper(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		super(traineeAdmissionDetailsRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"traineeAdmissionDetailsRelId", getTraineeAdmissionDetailsRelId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("traineeId", getTraineeId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("admissionYear", getAdmissionYear());
		attributes.put("omsbNumber", getOmsbNumber());
		attributes.put("traineeAddress", getTraineeAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traineeAdmissionDetailsRelId = (Long)attributes.get(
			"traineeAdmissionDetailsRelId");

		if (traineeAdmissionDetailsRelId != null) {
			setTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
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

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		String admissionYear = (String)attributes.get("admissionYear");

		if (admissionYear != null) {
			setAdmissionYear(admissionYear);
		}

		String omsbNumber = (String)attributes.get("omsbNumber");

		if (omsbNumber != null) {
			setOmsbNumber(omsbNumber);
		}

		String traineeAddress = (String)attributes.get("traineeAddress");

		if (traineeAddress != null) {
			setTraineeAddress(traineeAddress);
		}
	}

	@Override
	public TraineeAdmissionDetailsRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the admission year of this trainee admission details rel.
	 *
	 * @return the admission year of this trainee admission details rel
	 */
	@Override
	public String getAdmissionYear() {
		return model.getAdmissionYear();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this trainee admission details rel.
	 *
	 * @return the company ID of this trainee admission details rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trainee admission details rel.
	 *
	 * @return the create date of this trainee admission details rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this trainee admission details rel.
	 *
	 * @return the created by of this trainee admission details rel
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
	 * Returns the group ID of this trainee admission details rel.
	 *
	 * @return the group ID of this trainee admission details rel
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this trainee admission details rel.
	 *
	 * @return the modified by of this trainee admission details rel
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this trainee admission details rel.
	 *
	 * @return the modified date of this trainee admission details rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the omsb number of this trainee admission details rel.
	 *
	 * @return the omsb number of this trainee admission details rel
	 */
	@Override
	public String getOmsbNumber() {
		return model.getOmsbNumber();
	}

	/**
	 * Returns the primary key of this trainee admission details rel.
	 *
	 * @return the primary key of this trainee admission details rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this trainee admission details rel.
	 *
	 * @return the program duration ID of this trainee admission details rel
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the trainee address of this trainee admission details rel.
	 *
	 * @return the trainee address of this trainee admission details rel
	 */
	@Override
	public String getTraineeAddress() {
		return model.getTraineeAddress();
	}

	/**
	 * Returns the localized trainee address of this trainee admission details rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized trainee address of this trainee admission details rel
	 */
	@Override
	public String getTraineeAddress(java.util.Locale locale) {
		return model.getTraineeAddress(locale);
	}

	/**
	 * Returns the localized trainee address of this trainee admission details rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee address of this trainee admission details rel. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTraineeAddress(
		java.util.Locale locale, boolean useDefault) {

		return model.getTraineeAddress(locale, useDefault);
	}

	/**
	 * Returns the localized trainee address of this trainee admission details rel in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized trainee address of this trainee admission details rel
	 */
	@Override
	public String getTraineeAddress(String languageId) {
		return model.getTraineeAddress(languageId);
	}

	/**
	 * Returns the localized trainee address of this trainee admission details rel in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee address of this trainee admission details rel
	 */
	@Override
	public String getTraineeAddress(String languageId, boolean useDefault) {
		return model.getTraineeAddress(languageId, useDefault);
	}

	@Override
	public String getTraineeAddressCurrentLanguageId() {
		return model.getTraineeAddressCurrentLanguageId();
	}

	@Override
	public String getTraineeAddressCurrentValue() {
		return model.getTraineeAddressCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized trainee addresses of this trainee admission details rel.
	 *
	 * @return the locales and localized trainee addresses of this trainee admission details rel
	 */
	@Override
	public Map<java.util.Locale, String> getTraineeAddressMap() {
		return model.getTraineeAddressMap();
	}

	/**
	 * Returns the trainee admission details rel ID of this trainee admission details rel.
	 *
	 * @return the trainee admission details rel ID of this trainee admission details rel
	 */
	@Override
	public long getTraineeAdmissionDetailsRelId() {
		return model.getTraineeAdmissionDetailsRelId();
	}

	/**
	 * Returns the trainee ID of this trainee admission details rel.
	 *
	 * @return the trainee ID of this trainee admission details rel
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the uuid of this trainee admission details rel.
	 *
	 * @return the uuid of this trainee admission details rel
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
	 * Sets the admission year of this trainee admission details rel.
	 *
	 * @param admissionYear the admission year of this trainee admission details rel
	 */
	@Override
	public void setAdmissionYear(String admissionYear) {
		model.setAdmissionYear(admissionYear);
	}

	/**
	 * Sets the company ID of this trainee admission details rel.
	 *
	 * @param companyId the company ID of this trainee admission details rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trainee admission details rel.
	 *
	 * @param createDate the create date of this trainee admission details rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this trainee admission details rel.
	 *
	 * @param createdBy the created by of this trainee admission details rel
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this trainee admission details rel.
	 *
	 * @param groupId the group ID of this trainee admission details rel
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this trainee admission details rel.
	 *
	 * @param modifiedBy the modified by of this trainee admission details rel
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this trainee admission details rel.
	 *
	 * @param modifiedDate the modified date of this trainee admission details rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the omsb number of this trainee admission details rel.
	 *
	 * @param omsbNumber the omsb number of this trainee admission details rel
	 */
	@Override
	public void setOmsbNumber(String omsbNumber) {
		model.setOmsbNumber(omsbNumber);
	}

	/**
	 * Sets the primary key of this trainee admission details rel.
	 *
	 * @param primaryKey the primary key of this trainee admission details rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this trainee admission details rel.
	 *
	 * @param programDurationId the program duration ID of this trainee admission details rel
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the trainee address of this trainee admission details rel.
	 *
	 * @param traineeAddress the trainee address of this trainee admission details rel
	 */
	@Override
	public void setTraineeAddress(String traineeAddress) {
		model.setTraineeAddress(traineeAddress);
	}

	/**
	 * Sets the localized trainee address of this trainee admission details rel in the language.
	 *
	 * @param traineeAddress the localized trainee address of this trainee admission details rel
	 * @param locale the locale of the language
	 */
	@Override
	public void setTraineeAddress(
		String traineeAddress, java.util.Locale locale) {

		model.setTraineeAddress(traineeAddress, locale);
	}

	/**
	 * Sets the localized trainee address of this trainee admission details rel in the language, and sets the default locale.
	 *
	 * @param traineeAddress the localized trainee address of this trainee admission details rel
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeAddress(
		String traineeAddress, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTraineeAddress(traineeAddress, locale, defaultLocale);
	}

	@Override
	public void setTraineeAddressCurrentLanguageId(String languageId) {
		model.setTraineeAddressCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized trainee addresses of this trainee admission details rel from the map of locales and localized trainee addresses.
	 *
	 * @param traineeAddressMap the locales and localized trainee addresses of this trainee admission details rel
	 */
	@Override
	public void setTraineeAddressMap(
		Map<java.util.Locale, String> traineeAddressMap) {

		model.setTraineeAddressMap(traineeAddressMap);
	}

	/**
	 * Sets the localized trainee addresses of this trainee admission details rel from the map of locales and localized trainee addresses, and sets the default locale.
	 *
	 * @param traineeAddressMap the locales and localized trainee addresses of this trainee admission details rel
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTraineeAddressMap(
		Map<java.util.Locale, String> traineeAddressMap,
		java.util.Locale defaultLocale) {

		model.setTraineeAddressMap(traineeAddressMap, defaultLocale);
	}

	/**
	 * Sets the trainee admission details rel ID of this trainee admission details rel.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID of this trainee admission details rel
	 */
	@Override
	public void setTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		model.setTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
	}

	/**
	 * Sets the trainee ID of this trainee admission details rel.
	 *
	 * @param traineeId the trainee ID of this trainee admission details rel
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the uuid of this trainee admission details rel.
	 *
	 * @param uuid the uuid of this trainee admission details rel
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
	protected TraineeAdmissionDetailsRelWrapper wrap(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		return new TraineeAdmissionDetailsRelWrapper(
			traineeAdmissionDetailsRel);
	}

}