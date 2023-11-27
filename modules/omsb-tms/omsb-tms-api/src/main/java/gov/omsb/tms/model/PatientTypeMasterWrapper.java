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
 * This class is a wrapper for {@link PatientTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeMaster
 * @generated
 */
public class PatientTypeMasterWrapper
	extends BaseModelWrapper<PatientTypeMaster>
	implements ModelWrapper<PatientTypeMaster>, PatientTypeMaster {

	public PatientTypeMasterWrapper(PatientTypeMaster patientTypeMaster) {
		super(patientTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("patientTypeMasterId", getPatientTypeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("patientTypeName", getPatientTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long patientTypeMasterId = (Long)attributes.get("patientTypeMasterId");

		if (patientTypeMasterId != null) {
			setPatientTypeMasterId(patientTypeMasterId);
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

		String patientTypeName = (String)attributes.get("patientTypeName");

		if (patientTypeName != null) {
			setPatientTypeName(patientTypeName);
		}
	}

	@Override
	public PatientTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this patient type master.
	 *
	 * @return the company ID of this patient type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this patient type master.
	 *
	 * @return the create date of this patient type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this patient type master.
	 *
	 * @return the created by of this patient type master
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
	 * Returns the group ID of this patient type master.
	 *
	 * @return the group ID of this patient type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this patient type master.
	 *
	 * @return the modified by of this patient type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this patient type master.
	 *
	 * @return the modified date of this patient type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient type master ID of this patient type master.
	 *
	 * @return the patient type master ID of this patient type master
	 */
	@Override
	public long getPatientTypeMasterId() {
		return model.getPatientTypeMasterId();
	}

	/**
	 * Returns the patient type name of this patient type master.
	 *
	 * @return the patient type name of this patient type master
	 */
	@Override
	public String getPatientTypeName() {
		return model.getPatientTypeName();
	}

	/**
	 * Returns the localized patient type name of this patient type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized patient type name of this patient type master
	 */
	@Override
	public String getPatientTypeName(java.util.Locale locale) {
		return model.getPatientTypeName(locale);
	}

	/**
	 * Returns the localized patient type name of this patient type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized patient type name of this patient type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPatientTypeName(
		java.util.Locale locale, boolean useDefault) {

		return model.getPatientTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized patient type name of this patient type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized patient type name of this patient type master
	 */
	@Override
	public String getPatientTypeName(String languageId) {
		return model.getPatientTypeName(languageId);
	}

	/**
	 * Returns the localized patient type name of this patient type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized patient type name of this patient type master
	 */
	@Override
	public String getPatientTypeName(String languageId, boolean useDefault) {
		return model.getPatientTypeName(languageId, useDefault);
	}

	@Override
	public String getPatientTypeNameCurrentLanguageId() {
		return model.getPatientTypeNameCurrentLanguageId();
	}

	@Override
	public String getPatientTypeNameCurrentValue() {
		return model.getPatientTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized patient type names of this patient type master.
	 *
	 * @return the locales and localized patient type names of this patient type master
	 */
	@Override
	public Map<java.util.Locale, String> getPatientTypeNameMap() {
		return model.getPatientTypeNameMap();
	}

	/**
	 * Returns the primary key of this patient type master.
	 *
	 * @return the primary key of this patient type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this patient type master.
	 *
	 * @return the uuid of this patient type master
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
	 * Sets the company ID of this patient type master.
	 *
	 * @param companyId the company ID of this patient type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this patient type master.
	 *
	 * @param createDate the create date of this patient type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this patient type master.
	 *
	 * @param createdBy the created by of this patient type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this patient type master.
	 *
	 * @param groupId the group ID of this patient type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this patient type master.
	 *
	 * @param modifiedBy the modified by of this patient type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this patient type master.
	 *
	 * @param modifiedDate the modified date of this patient type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient type master ID of this patient type master.
	 *
	 * @param patientTypeMasterId the patient type master ID of this patient type master
	 */
	@Override
	public void setPatientTypeMasterId(long patientTypeMasterId) {
		model.setPatientTypeMasterId(patientTypeMasterId);
	}

	/**
	 * Sets the patient type name of this patient type master.
	 *
	 * @param patientTypeName the patient type name of this patient type master
	 */
	@Override
	public void setPatientTypeName(String patientTypeName) {
		model.setPatientTypeName(patientTypeName);
	}

	/**
	 * Sets the localized patient type name of this patient type master in the language.
	 *
	 * @param patientTypeName the localized patient type name of this patient type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setPatientTypeName(
		String patientTypeName, java.util.Locale locale) {

		model.setPatientTypeName(patientTypeName, locale);
	}

	/**
	 * Sets the localized patient type name of this patient type master in the language, and sets the default locale.
	 *
	 * @param patientTypeName the localized patient type name of this patient type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPatientTypeName(
		String patientTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPatientTypeName(patientTypeName, locale, defaultLocale);
	}

	@Override
	public void setPatientTypeNameCurrentLanguageId(String languageId) {
		model.setPatientTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized patient type names of this patient type master from the map of locales and localized patient type names.
	 *
	 * @param patientTypeNameMap the locales and localized patient type names of this patient type master
	 */
	@Override
	public void setPatientTypeNameMap(
		Map<java.util.Locale, String> patientTypeNameMap) {

		model.setPatientTypeNameMap(patientTypeNameMap);
	}

	/**
	 * Sets the localized patient type names of this patient type master from the map of locales and localized patient type names, and sets the default locale.
	 *
	 * @param patientTypeNameMap the locales and localized patient type names of this patient type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPatientTypeNameMap(
		Map<java.util.Locale, String> patientTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setPatientTypeNameMap(patientTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this patient type master.
	 *
	 * @param primaryKey the primary key of this patient type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this patient type master.
	 *
	 * @param uuid the uuid of this patient type master
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
	protected PatientTypeMasterWrapper wrap(
		PatientTypeMaster patientTypeMaster) {

		return new PatientTypeMasterWrapper(patientTypeMaster);
	}

}