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
 * The base model interface for the TraineeLevelMaster service. Represents a row in the &quot;trainee_level_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.TraineeLevelMasterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMaster
 * @generated
 */
@ProviderType
public interface TraineeLevelMasterModel
	extends BaseModel<TraineeLevelMaster>, LocalizedModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a trainee level master model instance should use the {@link TraineeLevelMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this trainee level master.
	 *
	 * @return the primary key of this trainee level master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this trainee level master.
	 *
	 * @param primaryKey the primary key of this trainee level master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this trainee level master.
	 *
	 * @return the uuid of this trainee level master
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this trainee level master.
	 *
	 * @param uuid the uuid of this trainee level master
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the trainee level master ID of this trainee level master.
	 *
	 * @return the trainee level master ID of this trainee level master
	 */
	public long getTraineeLevelMasterId();

	/**
	 * Sets the trainee level master ID of this trainee level master.
	 *
	 * @param traineeLevelMasterId the trainee level master ID of this trainee level master
	 */
	public void setTraineeLevelMasterId(long traineeLevelMasterId);

	/**
	 * Returns the group ID of this trainee level master.
	 *
	 * @return the group ID of this trainee level master
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this trainee level master.
	 *
	 * @param groupId the group ID of this trainee level master
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this trainee level master.
	 *
	 * @return the company ID of this trainee level master
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this trainee level master.
	 *
	 * @param companyId the company ID of this trainee level master
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this trainee level master.
	 *
	 * @return the create date of this trainee level master
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this trainee level master.
	 *
	 * @param createDate the create date of this trainee level master
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this trainee level master.
	 *
	 * @return the modified date of this trainee level master
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this trainee level master.
	 *
	 * @param modifiedDate the modified date of this trainee level master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the created by of this trainee level master.
	 *
	 * @return the created by of this trainee level master
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this trainee level master.
	 *
	 * @param createdBy the created by of this trainee level master
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this trainee level master.
	 *
	 * @return the modified by of this trainee level master
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this trainee level master.
	 *
	 * @param modifiedBy the modified by of this trainee level master
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the trainee level name of this trainee level master.
	 *
	 * @return the trainee level name of this trainee level master
	 */
	public String getTraineeLevelName();

	/**
	 * Returns the localized trainee level name of this trainee level master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized trainee level name of this trainee level master
	 */
	@AutoEscape
	public String getTraineeLevelName(Locale locale);

	/**
	 * Returns the localized trainee level name of this trainee level master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee level name of this trainee level master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTraineeLevelName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized trainee level name of this trainee level master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized trainee level name of this trainee level master
	 */
	@AutoEscape
	public String getTraineeLevelName(String languageId);

	/**
	 * Returns the localized trainee level name of this trainee level master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized trainee level name of this trainee level master
	 */
	@AutoEscape
	public String getTraineeLevelName(String languageId, boolean useDefault);

	@AutoEscape
	public String getTraineeLevelNameCurrentLanguageId();

	@AutoEscape
	public String getTraineeLevelNameCurrentValue();

	/**
	 * Returns a map of the locales and localized trainee level names of this trainee level master.
	 *
	 * @return the locales and localized trainee level names of this trainee level master
	 */
	public Map<Locale, String> getTraineeLevelNameMap();

	/**
	 * Sets the trainee level name of this trainee level master.
	 *
	 * @param traineeLevelName the trainee level name of this trainee level master
	 */
	public void setTraineeLevelName(String traineeLevelName);

	/**
	 * Sets the localized trainee level name of this trainee level master in the language.
	 *
	 * @param traineeLevelName the localized trainee level name of this trainee level master
	 * @param locale the locale of the language
	 */
	public void setTraineeLevelName(String traineeLevelName, Locale locale);

	/**
	 * Sets the localized trainee level name of this trainee level master in the language, and sets the default locale.
	 *
	 * @param traineeLevelName the localized trainee level name of this trainee level master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTraineeLevelName(
		String traineeLevelName, Locale locale, Locale defaultLocale);

	public void setTraineeLevelNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized trainee level names of this trainee level master from the map of locales and localized trainee level names.
	 *
	 * @param traineeLevelNameMap the locales and localized trainee level names of this trainee level master
	 */
	public void setTraineeLevelNameMap(Map<Locale, String> traineeLevelNameMap);

	/**
	 * Sets the localized trainee level names of this trainee level master from the map of locales and localized trainee level names, and sets the default locale.
	 *
	 * @param traineeLevelNameMap the locales and localized trainee level names of this trainee level master
	 * @param defaultLocale the default locale
	 */
	public void setTraineeLevelNameMap(
		Map<Locale, String> traineeLevelNameMap, Locale defaultLocale);

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
	public TraineeLevelMaster cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}