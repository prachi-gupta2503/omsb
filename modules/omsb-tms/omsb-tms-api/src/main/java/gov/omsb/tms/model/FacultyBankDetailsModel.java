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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FacultyBankDetails service. Represents a row in the &quot;faculty_bank_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.FacultyBankDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.FacultyBankDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetails
 * @generated
 */
@ProviderType
public interface FacultyBankDetailsModel
	extends BaseModel<FacultyBankDetails>, LocalizedModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty bank details model instance should use the {@link FacultyBankDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty bank details.
	 *
	 * @return the primary key of this faculty bank details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty bank details.
	 *
	 * @param primaryKey the primary key of this faculty bank details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faculty bank details.
	 *
	 * @return the uuid of this faculty bank details
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faculty bank details.
	 *
	 * @param uuid the uuid of this faculty bank details
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faculty bank details ID of this faculty bank details.
	 *
	 * @return the faculty bank details ID of this faculty bank details
	 */
	public long getFacultyBankDetailsId();

	/**
	 * Sets the faculty bank details ID of this faculty bank details.
	 *
	 * @param facultyBankDetailsId the faculty bank details ID of this faculty bank details
	 */
	public void setFacultyBankDetailsId(long facultyBankDetailsId);

	/**
	 * Returns the group ID of this faculty bank details.
	 *
	 * @return the group ID of this faculty bank details
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this faculty bank details.
	 *
	 * @param groupId the group ID of this faculty bank details
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faculty bank details.
	 *
	 * @return the company ID of this faculty bank details
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faculty bank details.
	 *
	 * @param companyId the company ID of this faculty bank details
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this faculty bank details.
	 *
	 * @return the create date of this faculty bank details
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faculty bank details.
	 *
	 * @param createDate the create date of this faculty bank details
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faculty bank details.
	 *
	 * @return the modified date of this faculty bank details
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faculty bank details.
	 *
	 * @param modifiedDate the modified date of this faculty bank details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the faculty request ID of this faculty bank details.
	 *
	 * @return the faculty request ID of this faculty bank details
	 */
	public long getFacultyRequestId();

	/**
	 * Sets the faculty request ID of this faculty bank details.
	 *
	 * @param facultyRequestId the faculty request ID of this faculty bank details
	 */
	public void setFacultyRequestId(long facultyRequestId);

	/**
	 * Returns the bank name of this faculty bank details.
	 *
	 * @return the bank name of this faculty bank details
	 */
	public String getBankName();

	/**
	 * Returns the localized bank name of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized bank name of this faculty bank details
	 */
	@AutoEscape
	public String getBankName(Locale locale);

	/**
	 * Returns the localized bank name of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank name of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getBankName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized bank name of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized bank name of this faculty bank details
	 */
	@AutoEscape
	public String getBankName(String languageId);

	/**
	 * Returns the localized bank name of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank name of this faculty bank details
	 */
	@AutoEscape
	public String getBankName(String languageId, boolean useDefault);

	@AutoEscape
	public String getBankNameCurrentLanguageId();

	@AutoEscape
	public String getBankNameCurrentValue();

	/**
	 * Returns a map of the locales and localized bank names of this faculty bank details.
	 *
	 * @return the locales and localized bank names of this faculty bank details
	 */
	public Map<Locale, String> getBankNameMap();

	/**
	 * Sets the bank name of this faculty bank details.
	 *
	 * @param bankName the bank name of this faculty bank details
	 */
	public void setBankName(String bankName);

	/**
	 * Sets the localized bank name of this faculty bank details in the language.
	 *
	 * @param bankName the localized bank name of this faculty bank details
	 * @param locale the locale of the language
	 */
	public void setBankName(String bankName, Locale locale);

	/**
	 * Sets the localized bank name of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param bankName the localized bank name of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setBankName(
		String bankName, Locale locale, Locale defaultLocale);

	public void setBankNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized bank names of this faculty bank details from the map of locales and localized bank names.
	 *
	 * @param bankNameMap the locales and localized bank names of this faculty bank details
	 */
	public void setBankNameMap(Map<Locale, String> bankNameMap);

	/**
	 * Sets the localized bank names of this faculty bank details from the map of locales and localized bank names, and sets the default locale.
	 *
	 * @param bankNameMap the locales and localized bank names of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	public void setBankNameMap(
		Map<Locale, String> bankNameMap, Locale defaultLocale);

	/**
	 * Returns the account no of this faculty bank details.
	 *
	 * @return the account no of this faculty bank details
	 */
	public String getAccountNo();

	/**
	 * Returns the localized account no of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized account no of this faculty bank details
	 */
	@AutoEscape
	public String getAccountNo(Locale locale);

	/**
	 * Returns the localized account no of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized account no of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getAccountNo(Locale locale, boolean useDefault);

	/**
	 * Returns the localized account no of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized account no of this faculty bank details
	 */
	@AutoEscape
	public String getAccountNo(String languageId);

	/**
	 * Returns the localized account no of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized account no of this faculty bank details
	 */
	@AutoEscape
	public String getAccountNo(String languageId, boolean useDefault);

	@AutoEscape
	public String getAccountNoCurrentLanguageId();

	@AutoEscape
	public String getAccountNoCurrentValue();

	/**
	 * Returns a map of the locales and localized account nos of this faculty bank details.
	 *
	 * @return the locales and localized account nos of this faculty bank details
	 */
	public Map<Locale, String> getAccountNoMap();

	/**
	 * Sets the account no of this faculty bank details.
	 *
	 * @param accountNo the account no of this faculty bank details
	 */
	public void setAccountNo(String accountNo);

	/**
	 * Sets the localized account no of this faculty bank details in the language.
	 *
	 * @param accountNo the localized account no of this faculty bank details
	 * @param locale the locale of the language
	 */
	public void setAccountNo(String accountNo, Locale locale);

	/**
	 * Sets the localized account no of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param accountNo the localized account no of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setAccountNo(
		String accountNo, Locale locale, Locale defaultLocale);

	public void setAccountNoCurrentLanguageId(String languageId);

	/**
	 * Sets the localized account nos of this faculty bank details from the map of locales and localized account nos.
	 *
	 * @param accountNoMap the locales and localized account nos of this faculty bank details
	 */
	public void setAccountNoMap(Map<Locale, String> accountNoMap);

	/**
	 * Sets the localized account nos of this faculty bank details from the map of locales and localized account nos, and sets the default locale.
	 *
	 * @param accountNoMap the locales and localized account nos of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	public void setAccountNoMap(
		Map<Locale, String> accountNoMap, Locale defaultLocale);

	/**
	 * Returns the bank branch of this faculty bank details.
	 *
	 * @return the bank branch of this faculty bank details
	 */
	public String getBankBranch();

	/**
	 * Returns the localized bank branch of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized bank branch of this faculty bank details
	 */
	@AutoEscape
	public String getBankBranch(Locale locale);

	/**
	 * Returns the localized bank branch of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank branch of this faculty bank details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getBankBranch(Locale locale, boolean useDefault);

	/**
	 * Returns the localized bank branch of this faculty bank details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized bank branch of this faculty bank details
	 */
	@AutoEscape
	public String getBankBranch(String languageId);

	/**
	 * Returns the localized bank branch of this faculty bank details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized bank branch of this faculty bank details
	 */
	@AutoEscape
	public String getBankBranch(String languageId, boolean useDefault);

	@AutoEscape
	public String getBankBranchCurrentLanguageId();

	@AutoEscape
	public String getBankBranchCurrentValue();

	/**
	 * Returns a map of the locales and localized bank branches of this faculty bank details.
	 *
	 * @return the locales and localized bank branches of this faculty bank details
	 */
	public Map<Locale, String> getBankBranchMap();

	/**
	 * Sets the bank branch of this faculty bank details.
	 *
	 * @param bankBranch the bank branch of this faculty bank details
	 */
	public void setBankBranch(String bankBranch);

	/**
	 * Sets the localized bank branch of this faculty bank details in the language.
	 *
	 * @param bankBranch the localized bank branch of this faculty bank details
	 * @param locale the locale of the language
	 */
	public void setBankBranch(String bankBranch, Locale locale);

	/**
	 * Sets the localized bank branch of this faculty bank details in the language, and sets the default locale.
	 *
	 * @param bankBranch the localized bank branch of this faculty bank details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setBankBranch(
		String bankBranch, Locale locale, Locale defaultLocale);

	public void setBankBranchCurrentLanguageId(String languageId);

	/**
	 * Sets the localized bank branches of this faculty bank details from the map of locales and localized bank branches.
	 *
	 * @param bankBranchMap the locales and localized bank branches of this faculty bank details
	 */
	public void setBankBranchMap(Map<Locale, String> bankBranchMap);

	/**
	 * Sets the localized bank branches of this faculty bank details from the map of locales and localized bank branches, and sets the default locale.
	 *
	 * @param bankBranchMap the locales and localized bank branches of this faculty bank details
	 * @param defaultLocale the default locale
	 */
	public void setBankBranchMap(
		Map<Locale, String> bankBranchMap, Locale defaultLocale);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public FacultyBankDetails cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}