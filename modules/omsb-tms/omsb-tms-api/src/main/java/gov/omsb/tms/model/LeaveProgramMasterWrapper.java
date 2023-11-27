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
 * This class is a wrapper for {@link LeaveProgramMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveProgramMaster
 * @generated
 */
public class LeaveProgramMasterWrapper
	extends BaseModelWrapper<LeaveProgramMaster>
	implements LeaveProgramMaster, ModelWrapper<LeaveProgramMaster> {

	public LeaveProgramMasterWrapper(LeaveProgramMaster leaveProgramMaster) {
		super(leaveProgramMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveProgramMasterId", getLeaveProgramMasterId());
		attributes.put("programMasterId", getProgramMasterId());
		attributes.put("leaveTypesId", getLeaveTypesId());
		attributes.put("noOfLeaves", getNoOfLeaves());
		attributes.put("residentLevelRule", getResidentLevelRule());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long leaveProgramMasterId = (Long)attributes.get(
			"leaveProgramMasterId");

		if (leaveProgramMasterId != null) {
			setLeaveProgramMasterId(leaveProgramMasterId);
		}

		Long programMasterId = (Long)attributes.get("programMasterId");

		if (programMasterId != null) {
			setProgramMasterId(programMasterId);
		}

		Long leaveTypesId = (Long)attributes.get("leaveTypesId");

		if (leaveTypesId != null) {
			setLeaveTypesId(leaveTypesId);
		}

		Integer noOfLeaves = (Integer)attributes.get("noOfLeaves");

		if (noOfLeaves != null) {
			setNoOfLeaves(noOfLeaves);
		}

		String residentLevelRule = (String)attributes.get("residentLevelRule");

		if (residentLevelRule != null) {
			setResidentLevelRule(residentLevelRule);
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
	}

	@Override
	public LeaveProgramMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this leave program master.
	 *
	 * @return the company ID of this leave program master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave program master.
	 *
	 * @return the create date of this leave program master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave program master.
	 *
	 * @return the created by of this leave program master
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
	 * Returns the group ID of this leave program master.
	 *
	 * @return the group ID of this leave program master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave program master ID of this leave program master.
	 *
	 * @return the leave program master ID of this leave program master
	 */
	@Override
	public long getLeaveProgramMasterId() {
		return model.getLeaveProgramMasterId();
	}

	/**
	 * Returns the leave types ID of this leave program master.
	 *
	 * @return the leave types ID of this leave program master
	 */
	@Override
	public long getLeaveTypesId() {
		return model.getLeaveTypesId();
	}

	/**
	 * Returns the modified by of this leave program master.
	 *
	 * @return the modified by of this leave program master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave program master.
	 *
	 * @return the modified date of this leave program master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of leaves of this leave program master.
	 *
	 * @return the no of leaves of this leave program master
	 */
	@Override
	public int getNoOfLeaves() {
		return model.getNoOfLeaves();
	}

	/**
	 * Returns the primary key of this leave program master.
	 *
	 * @return the primary key of this leave program master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program master ID of this leave program master.
	 *
	 * @return the program master ID of this leave program master
	 */
	@Override
	public long getProgramMasterId() {
		return model.getProgramMasterId();
	}

	/**
	 * Returns the resident level rule of this leave program master.
	 *
	 * @return the resident level rule of this leave program master
	 */
	@Override
	public String getResidentLevelRule() {
		return model.getResidentLevelRule();
	}

	/**
	 * Returns the localized resident level rule of this leave program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized resident level rule of this leave program master
	 */
	@Override
	public String getResidentLevelRule(java.util.Locale locale) {
		return model.getResidentLevelRule(locale);
	}

	/**
	 * Returns the localized resident level rule of this leave program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resident level rule of this leave program master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getResidentLevelRule(
		java.util.Locale locale, boolean useDefault) {

		return model.getResidentLevelRule(locale, useDefault);
	}

	/**
	 * Returns the localized resident level rule of this leave program master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized resident level rule of this leave program master
	 */
	@Override
	public String getResidentLevelRule(String languageId) {
		return model.getResidentLevelRule(languageId);
	}

	/**
	 * Returns the localized resident level rule of this leave program master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resident level rule of this leave program master
	 */
	@Override
	public String getResidentLevelRule(String languageId, boolean useDefault) {
		return model.getResidentLevelRule(languageId, useDefault);
	}

	@Override
	public String getResidentLevelRuleCurrentLanguageId() {
		return model.getResidentLevelRuleCurrentLanguageId();
	}

	@Override
	public String getResidentLevelRuleCurrentValue() {
		return model.getResidentLevelRuleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized resident level rules of this leave program master.
	 *
	 * @return the locales and localized resident level rules of this leave program master
	 */
	@Override
	public Map<java.util.Locale, String> getResidentLevelRuleMap() {
		return model.getResidentLevelRuleMap();
	}

	/**
	 * Returns the uuid of this leave program master.
	 *
	 * @return the uuid of this leave program master
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
	 * Sets the company ID of this leave program master.
	 *
	 * @param companyId the company ID of this leave program master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave program master.
	 *
	 * @param createDate the create date of this leave program master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave program master.
	 *
	 * @param createdBy the created by of this leave program master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave program master.
	 *
	 * @param groupId the group ID of this leave program master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave program master ID of this leave program master.
	 *
	 * @param leaveProgramMasterId the leave program master ID of this leave program master
	 */
	@Override
	public void setLeaveProgramMasterId(long leaveProgramMasterId) {
		model.setLeaveProgramMasterId(leaveProgramMasterId);
	}

	/**
	 * Sets the leave types ID of this leave program master.
	 *
	 * @param leaveTypesId the leave types ID of this leave program master
	 */
	@Override
	public void setLeaveTypesId(long leaveTypesId) {
		model.setLeaveTypesId(leaveTypesId);
	}

	/**
	 * Sets the modified by of this leave program master.
	 *
	 * @param modifiedBy the modified by of this leave program master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave program master.
	 *
	 * @param modifiedDate the modified date of this leave program master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of leaves of this leave program master.
	 *
	 * @param noOfLeaves the no of leaves of this leave program master
	 */
	@Override
	public void setNoOfLeaves(int noOfLeaves) {
		model.setNoOfLeaves(noOfLeaves);
	}

	/**
	 * Sets the primary key of this leave program master.
	 *
	 * @param primaryKey the primary key of this leave program master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program master ID of this leave program master.
	 *
	 * @param programMasterId the program master ID of this leave program master
	 */
	@Override
	public void setProgramMasterId(long programMasterId) {
		model.setProgramMasterId(programMasterId);
	}

	/**
	 * Sets the resident level rule of this leave program master.
	 *
	 * @param residentLevelRule the resident level rule of this leave program master
	 */
	@Override
	public void setResidentLevelRule(String residentLevelRule) {
		model.setResidentLevelRule(residentLevelRule);
	}

	/**
	 * Sets the localized resident level rule of this leave program master in the language.
	 *
	 * @param residentLevelRule the localized resident level rule of this leave program master
	 * @param locale the locale of the language
	 */
	@Override
	public void setResidentLevelRule(
		String residentLevelRule, java.util.Locale locale) {

		model.setResidentLevelRule(residentLevelRule, locale);
	}

	/**
	 * Sets the localized resident level rule of this leave program master in the language, and sets the default locale.
	 *
	 * @param residentLevelRule the localized resident level rule of this leave program master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResidentLevelRule(
		String residentLevelRule, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setResidentLevelRule(residentLevelRule, locale, defaultLocale);
	}

	@Override
	public void setResidentLevelRuleCurrentLanguageId(String languageId) {
		model.setResidentLevelRuleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized resident level rules of this leave program master from the map of locales and localized resident level rules.
	 *
	 * @param residentLevelRuleMap the locales and localized resident level rules of this leave program master
	 */
	@Override
	public void setResidentLevelRuleMap(
		Map<java.util.Locale, String> residentLevelRuleMap) {

		model.setResidentLevelRuleMap(residentLevelRuleMap);
	}

	/**
	 * Sets the localized resident level rules of this leave program master from the map of locales and localized resident level rules, and sets the default locale.
	 *
	 * @param residentLevelRuleMap the locales and localized resident level rules of this leave program master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResidentLevelRuleMap(
		Map<java.util.Locale, String> residentLevelRuleMap,
		java.util.Locale defaultLocale) {

		model.setResidentLevelRuleMap(residentLevelRuleMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this leave program master.
	 *
	 * @param uuid the uuid of this leave program master
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
	protected LeaveProgramMasterWrapper wrap(
		LeaveProgramMaster leaveProgramMaster) {

		return new LeaveProgramMasterWrapper(leaveProgramMaster);
	}

}