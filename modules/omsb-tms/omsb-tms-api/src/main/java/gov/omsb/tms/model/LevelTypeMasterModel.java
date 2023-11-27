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
 * The base model interface for the LevelTypeMaster service. Represents a row in the &quot;level_type_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.LevelTypeMasterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMaster
 * @generated
 */
@ProviderType
public interface LevelTypeMasterModel
	extends BaseModel<LevelTypeMaster>, LocalizedModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a level type master model instance should use the {@link LevelTypeMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this level type master.
	 *
	 * @return the primary key of this level type master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this level type master.
	 *
	 * @param primaryKey the primary key of this level type master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this level type master.
	 *
	 * @return the uuid of this level type master
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this level type master.
	 *
	 * @param uuid the uuid of this level type master
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the level type master ID of this level type master.
	 *
	 * @return the level type master ID of this level type master
	 */
	public long getLevelTypeMasterId();

	/**
	 * Sets the level type master ID of this level type master.
	 *
	 * @param LevelTypeMasterId the level type master ID of this level type master
	 */
	public void setLevelTypeMasterId(long LevelTypeMasterId);

	/**
	 * Returns the group ID of this level type master.
	 *
	 * @return the group ID of this level type master
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this level type master.
	 *
	 * @param groupId the group ID of this level type master
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this level type master.
	 *
	 * @return the company ID of this level type master
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this level type master.
	 *
	 * @param companyId the company ID of this level type master
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this level type master.
	 *
	 * @return the create date of this level type master
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this level type master.
	 *
	 * @param createDate the create date of this level type master
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this level type master.
	 *
	 * @return the created by of this level type master
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this level type master.
	 *
	 * @param createdBy the created by of this level type master
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this level type master.
	 *
	 * @return the modified date of this level type master
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this level type master.
	 *
	 * @param modifiedDate the modified date of this level type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this level type master.
	 *
	 * @return the modified by of this level type master
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this level type master.
	 *
	 * @param modifiedBy the modified by of this level type master
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the level type name of this level type master.
	 *
	 * @return the level type name of this level type master
	 */
	public String getLevelTypeName();

	/**
	 * Returns the localized level type name of this level type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized level type name of this level type master
	 */
	@AutoEscape
	public String getLevelTypeName(Locale locale);

	/**
	 * Returns the localized level type name of this level type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized level type name of this level type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLevelTypeName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized level type name of this level type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized level type name of this level type master
	 */
	@AutoEscape
	public String getLevelTypeName(String languageId);

	/**
	 * Returns the localized level type name of this level type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized level type name of this level type master
	 */
	@AutoEscape
	public String getLevelTypeName(String languageId, boolean useDefault);

	@AutoEscape
	public String getLevelTypeNameCurrentLanguageId();

	@AutoEscape
	public String getLevelTypeNameCurrentValue();

	/**
	 * Returns a map of the locales and localized level type names of this level type master.
	 *
	 * @return the locales and localized level type names of this level type master
	 */
	public Map<Locale, String> getLevelTypeNameMap();

	/**
	 * Sets the level type name of this level type master.
	 *
	 * @param levelTypeName the level type name of this level type master
	 */
	public void setLevelTypeName(String levelTypeName);

	/**
	 * Sets the localized level type name of this level type master in the language.
	 *
	 * @param levelTypeName the localized level type name of this level type master
	 * @param locale the locale of the language
	 */
	public void setLevelTypeName(String levelTypeName, Locale locale);

	/**
	 * Sets the localized level type name of this level type master in the language, and sets the default locale.
	 *
	 * @param levelTypeName the localized level type name of this level type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLevelTypeName(
		String levelTypeName, Locale locale, Locale defaultLocale);

	public void setLevelTypeNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized level type names of this level type master from the map of locales and localized level type names.
	 *
	 * @param levelTypeNameMap the locales and localized level type names of this level type master
	 */
	public void setLevelTypeNameMap(Map<Locale, String> levelTypeNameMap);

	/**
	 * Sets the localized level type names of this level type master from the map of locales and localized level type names, and sets the default locale.
	 *
	 * @param levelTypeNameMap the locales and localized level type names of this level type master
	 * @param defaultLocale the default locale
	 */
	public void setLevelTypeNameMap(
		Map<Locale, String> levelTypeNameMap, Locale defaultLocale);

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
	public LevelTypeMaster cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}