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
 * This class is a wrapper for {@link FacultyBankDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetails
 * @generated
 */
public class FacultyBankDetailsWrapper
	extends BaseModelWrapper<FacultyBankDetails>
	implements FacultyBankDetails, ModelWrapper<FacultyBankDetails> {

	public FacultyBankDetailsWrapper(FacultyBankDetails facultyBankDetails) {
		super(facultyBankDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("facultyBankDetailsId", getFacultyBankDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("facultyRequestId", getFacultyRequestId());
		attributes.put("bankName", getBankName());
		attributes.put("accountNo", getAccountNo());
		attributes.put("bankBranch", getBankBranch());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long facultyBankDetailsId = (Long)attributes.get(
			"facultyBankDetailsId");

		if (facultyBankDetailsId != null) {
			setFacultyBankDetailsId(facultyBankDetailsId);
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

		Long facultyRequestId = (Long)attributes.get("facultyRequestId");

		if (facultyRequestId != null) {
			setFacultyRequestId(facultyRequestId);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String accountNo = (String)attributes.get("accountNo");

		if (accountNo != null) {
			setAccountNo(accountNo);
		}

		String bankBranch = (String)attributes.get("bankBranch");

		if (bankBranch != null) {
			setBankBranch(bankBranch);
		}
	}

	@Override
	public FacultyBankDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account no of this faculty bank details.
	 *
	 * @return the account no of this faculty bank details
	 */
	@Override
	public String getAccountNo() {
		return model.getAccountNo();
	}

	/**
	 * Returns the localized account no of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized account no of this faculty bank details
	 */
	@Override
	public String getAccountNo(java.util.Locale locale) {
		return model.getAccountNo(locale);
	}

	/**
	 * Returns the localized account no of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized account no of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccountNo(java.util.Locale locale, boolean useDefault) {
		return model.getAccountNo(locale, useDefault);
	}

	/**
	 * Returns the localized account no of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized account no of this faculty bank details
	 */
	@Override
	public String getAccountNo(String languageId) {
		return model.getAccountNo(languageId);
	}

	/**
	 * Returns the localized account no of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized account no of this faculty bank details
	 */
	@Override
	public String getAccountNo(String languageId, boolean useDefault) {
		return model.getAccountNo(languageId, useDefault);
	}

	@Override
	public String getAccountNoCurrentLanguageId() {
		return model.getAccountNoCurrentLanguageId();
	}

	@Override
	public String getAccountNoCurrentValue() {
		return model.getAccountNoCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized account nos of this faculty bank details.
	 *
	 * @return the locales and localized account nos of this faculty bank details
	 */
	@Override
	public Map<java.util.Locale, String> getAccountNoMap() {
		return model.getAccountNoMap();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the bank branch of this faculty bank details.
	 *
	 * @return the bank branch of this faculty bank details
	 */
	@Override
	public String getBankBranch() {
		return model.getBankBranch();
	}

	/**
	 * Returns the localized bank branch of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized bank branch of this faculty bank details
	 */
	@Override
	public String getBankBranch(java.util.Locale locale) {
		return model.getBankBranch(locale);
	}

	/**
	 * Returns the localized bank branch of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank branch of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBankBranch(java.util.Locale locale, boolean useDefault) {
		return model.getBankBranch(locale, useDefault);
	}

	/**
	 * Returns the localized bank branch of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized bank branch of this faculty bank details
	 */
	@Override
	public String getBankBranch(String languageId) {
		return model.getBankBranch(languageId);
	}

	/**
	 * Returns the localized bank branch of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank branch of this faculty bank details
	 */
	@Override
	public String getBankBranch(String languageId, boolean useDefault) {
		return model.getBankBranch(languageId, useDefault);
	}

	@Override
	public String getBankBranchCurrentLanguageId() {
		return model.getBankBranchCurrentLanguageId();
	}

	@Override
	public String getBankBranchCurrentValue() {
		return model.getBankBranchCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized bank branches of this faculty bank details.
	 *
	 * @return the locales and localized bank branches of this faculty bank details
	 */
	@Override
	public Map<java.util.Locale, String> getBankBranchMap() {
		return model.getBankBranchMap();
	}

	/**
	 * Returns the bank name of this faculty bank details.
	 *
	 * @return the bank name of this faculty bank details
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the localized bank name of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized bank name of this faculty bank details
	 */
	@Override
	public String getBankName(java.util.Locale locale) {
		return model.getBankName(locale);
	}

	/**
	 * Returns the localized bank name of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank name of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBankName(java.util.Locale locale, boolean useDefault) {
		return model.getBankName(locale, useDefault);
	}

	/**
	 * Returns the localized bank name of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized bank name of this faculty bank details
	 */
	@Override
	public String getBankName(String languageId) {
		return model.getBankName(languageId);
	}

	/**
	 * Returns the localized bank name of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank name of this faculty bank details
	 */
	@Override
	public String getBankName(String languageId, boolean useDefault) {
		return model.getBankName(languageId, useDefault);
	}

	@Override
	public String getBankNameCurrentLanguageId() {
		return model.getBankNameCurrentLanguageId();
	}

	@Override
	public String getBankNameCurrentValue() {
		return model.getBankNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized bank names of this faculty bank details.
	 *
	 * @return the locales and localized bank names of this faculty bank details
	 */
	@Override
	public Map<java.util.Locale, String> getBankNameMap() {
		return model.getBankNameMap();
	}

	/**
	 * Returns the company ID of this faculty bank details.
	 *
	 * @return the company ID of this faculty bank details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faculty bank details.
	 *
	 * @return the create date of this faculty bank details
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
	 * Returns the faculty bank details ID of this faculty bank details.
	 *
	 * @return the faculty bank details ID of this faculty bank details
	 */
	@Override
	public long getFacultyBankDetailsId() {
		return model.getFacultyBankDetailsId();
	}

	/**
	 * Returns the faculty request ID of this faculty bank details.
	 *
	 * @return the faculty request ID of this faculty bank details
	 */
	@Override
	public long getFacultyRequestId() {
		return model.getFacultyRequestId();
	}

	/**
	 * Returns the group ID of this faculty bank details.
	 *
	 * @return the group ID of this faculty bank details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faculty bank details.
	 *
	 * @return the modified date of this faculty bank details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faculty bank details.
	 *
	 * @return the primary key of this faculty bank details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this faculty bank details.
	 *
	 * @return the uuid of this faculty bank details
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
	 * Sets the account no of this faculty bank details.
	 *
	 * @param accountNo the account no of this faculty bank details
	 */
	@Override
	public void setAccountNo(String accountNo) {
		model.setAccountNo(accountNo);
	}

	/**
	 * Sets the localized account no of this faculty bank details in the language.
	 *
	 * @param accountNo the localized account no of this faculty bank details
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccountNo(String accountNo, java.util.Locale locale) {
		model.setAccountNo(accountNo, locale);
	}

	/**
	 * Sets the localized account no of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param accountNo the localized account no of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccountNo(
		String accountNo, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAccountNo(accountNo, locale, defaultLocale);
	}

	@Override
	public void setAccountNoCurrentLanguageId(String languageId) {
		model.setAccountNoCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized account nos of this faculty bank details from the map of locales and localized account nos.
	 *
	 * @param accountNoMap the locales and localized account nos of this faculty bank details
	 */
	@Override
	public void setAccountNoMap(Map<java.util.Locale, String> accountNoMap) {
		model.setAccountNoMap(accountNoMap);
	}

	/**
	 * Sets the localized account nos of this faculty bank details from the map of locales and localized account nos, and sets the default locale.
	 *
	 * @param accountNoMap the locales and localized account nos of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccountNoMap(
		Map<java.util.Locale, String> accountNoMap,
		java.util.Locale defaultLocale) {

		model.setAccountNoMap(accountNoMap, defaultLocale);
	}

	/**
	 * Sets the bank branch of this faculty bank details.
	 *
	 * @param bankBranch the bank branch of this faculty bank details
	 */
	@Override
	public void setBankBranch(String bankBranch) {
		model.setBankBranch(bankBranch);
	}

	/**
	 * Sets the localized bank branch of this faculty bank details in the language.
	 *
	 * @param bankBranch the localized bank branch of this faculty bank details
	 * @param locale the locale of the language
	 */
	@Override
	public void setBankBranch(String bankBranch, java.util.Locale locale) {
		model.setBankBranch(bankBranch, locale);
	}

	/**
	 * Sets the localized bank branch of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param bankBranch the localized bank branch of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBankBranch(
		String bankBranch, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBankBranch(bankBranch, locale, defaultLocale);
	}

	@Override
	public void setBankBranchCurrentLanguageId(String languageId) {
		model.setBankBranchCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized bank branches of this faculty bank details from the map of locales and localized bank branches.
	 *
	 * @param bankBranchMap the locales and localized bank branches of this faculty bank details
	 */
	@Override
	public void setBankBranchMap(Map<java.util.Locale, String> bankBranchMap) {
		model.setBankBranchMap(bankBranchMap);
	}

	/**
	 * Sets the localized bank branches of this faculty bank details from the map of locales and localized bank branches, and sets the default locale.
	 *
	 * @param bankBranchMap the locales and localized bank branches of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBankBranchMap(
		Map<java.util.Locale, String> bankBranchMap,
		java.util.Locale defaultLocale) {

		model.setBankBranchMap(bankBranchMap, defaultLocale);
	}

	/**
	 * Sets the bank name of this faculty bank details.
	 *
	 * @param bankName the bank name of this faculty bank details
	 */
	@Override
	public void setBankName(String bankName) {
		model.setBankName(bankName);
	}

	/**
	 * Sets the localized bank name of this faculty bank details in the language.
	 *
	 * @param bankName the localized bank name of this faculty bank details
	 * @param locale the locale of the language
	 */
	@Override
	public void setBankName(String bankName, java.util.Locale locale) {
		model.setBankName(bankName, locale);
	}

	/**
	 * Sets the localized bank name of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param bankName the localized bank name of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBankName(
		String bankName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBankName(bankName, locale, defaultLocale);
	}

	@Override
	public void setBankNameCurrentLanguageId(String languageId) {
		model.setBankNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized bank names of this faculty bank details from the map of locales and localized bank names.
	 *
	 * @param bankNameMap the locales and localized bank names of this faculty bank details
	 */
	@Override
	public void setBankNameMap(Map<java.util.Locale, String> bankNameMap) {
		model.setBankNameMap(bankNameMap);
	}

	/**
	 * Sets the localized bank names of this faculty bank details from the map of locales and localized bank names, and sets the default locale.
	 *
	 * @param bankNameMap the locales and localized bank names of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBankNameMap(
		Map<java.util.Locale, String> bankNameMap,
		java.util.Locale defaultLocale) {

		model.setBankNameMap(bankNameMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this faculty bank details.
	 *
	 * @param companyId the company ID of this faculty bank details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faculty bank details.
	 *
	 * @param createDate the create date of this faculty bank details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the faculty bank details ID of this faculty bank details.
	 *
	 * @param facultyBankDetailsId the faculty bank details ID of this faculty bank details
	 */
	@Override
	public void setFacultyBankDetailsId(long facultyBankDetailsId) {
		model.setFacultyBankDetailsId(facultyBankDetailsId);
	}

	/**
	 * Sets the faculty request ID of this faculty bank details.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty bank details
	 */
	@Override
	public void setFacultyRequestId(long facultyRequestId) {
		model.setFacultyRequestId(facultyRequestId);
	}

	/**
	 * Sets the group ID of this faculty bank details.
	 *
	 * @param groupId the group ID of this faculty bank details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faculty bank details.
	 *
	 * @param modifiedDate the modified date of this faculty bank details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faculty bank details.
	 *
	 * @param primaryKey the primary key of this faculty bank details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this faculty bank details.
	 *
	 * @param uuid the uuid of this faculty bank details
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
	protected FacultyBankDetailsWrapper wrap(
		FacultyBankDetails facultyBankDetails) {

		return new FacultyBankDetailsWrapper(facultyBankDetails);
	}

}