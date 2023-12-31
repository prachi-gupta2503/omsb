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
 * The base model interface for the RotationTypeMaster service. Represents a row in the &quot;rotation_type_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.RotationTypeMasterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.RotationTypeMasterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationTypeMaster
 * @generated
 */
@ProviderType
public interface RotationTypeMasterModel
	extends BaseModel<RotationTypeMaster>, LocalizedModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rotation type master model instance should use the {@link RotationTypeMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this rotation type master.
	 *
	 * @return the primary key of this rotation type master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rotation type master.
	 *
	 * @param primaryKey the primary key of this rotation type master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this rotation type master.
	 *
	 * @return the uuid of this rotation type master
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this rotation type master.
	 *
	 * @param uuid the uuid of this rotation type master
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the rotation type master ID of this rotation type master.
	 *
	 * @return the rotation type master ID of this rotation type master
	 */
	public long getRotationTypeMasterId();

	/**
	 * Sets the rotation type master ID of this rotation type master.
	 *
	 * @param rotationTypeMasterId the rotation type master ID of this rotation type master
	 */
	public void setRotationTypeMasterId(long rotationTypeMasterId);

	/**
	 * Returns the group ID of this rotation type master.
	 *
	 * @return the group ID of this rotation type master
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this rotation type master.
	 *
	 * @param groupId the group ID of this rotation type master
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this rotation type master.
	 *
	 * @return the company ID of this rotation type master
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this rotation type master.
	 *
	 * @param companyId the company ID of this rotation type master
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this rotation type master.
	 *
	 * @return the create date of this rotation type master
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this rotation type master.
	 *
	 * @param createDate the create date of this rotation type master
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this rotation type master.
	 *
	 * @return the created by of this rotation type master
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this rotation type master.
	 *
	 * @param createdBy the created by of this rotation type master
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this rotation type master.
	 *
	 * @return the modified date of this rotation type master
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this rotation type master.
	 *
	 * @param modifiedDate the modified date of this rotation type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this rotation type master.
	 *
	 * @return the modified by of this rotation type master
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this rotation type master.
	 *
	 * @param modifiedBy the modified by of this rotation type master
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the rotation type name of this rotation type master.
	 *
	 * @return the rotation type name of this rotation type master
	 */
	public String getRotationTypeName();

	/**
	 * Returns the localized rotation type name of this rotation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized rotation type name of this rotation type master
	 */
	@AutoEscape
	public String getRotationTypeName(Locale locale);

	/**
	 * Returns the localized rotation type name of this rotation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation type name of this rotation type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getRotationTypeName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized rotation type name of this rotation type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized rotation type name of this rotation type master
	 */
	@AutoEscape
	public String getRotationTypeName(String languageId);

	/**
	 * Returns the localized rotation type name of this rotation type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized rotation type name of this rotation type master
	 */
	@AutoEscape
	public String getRotationTypeName(String languageId, boolean useDefault);

	@AutoEscape
	public String getRotationTypeNameCurrentLanguageId();

	@AutoEscape
	public String getRotationTypeNameCurrentValue();

	/**
	 * Returns a map of the locales and localized rotation type names of this rotation type master.
	 *
	 * @return the locales and localized rotation type names of this rotation type master
	 */
	public Map<Locale, String> getRotationTypeNameMap();

	/**
	 * Sets the rotation type name of this rotation type master.
	 *
	 * @param rotationTypeName the rotation type name of this rotation type master
	 */
	public void setRotationTypeName(String rotationTypeName);

	/**
	 * Sets the localized rotation type name of this rotation type master in the language.
	 *
	 * @param rotationTypeName the localized rotation type name of this rotation type master
	 * @param locale the locale of the language
	 */
	public void setRotationTypeName(String rotationTypeName, Locale locale);

	/**
	 * Sets the localized rotation type name of this rotation type master in the language, and sets the default locale.
	 *
	 * @param rotationTypeName the localized rotation type name of this rotation type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setRotationTypeName(
		String rotationTypeName, Locale locale, Locale defaultLocale);

	public void setRotationTypeNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized rotation type names of this rotation type master from the map of locales and localized rotation type names.
	 *
	 * @param rotationTypeNameMap the locales and localized rotation type names of this rotation type master
	 */
	public void setRotationTypeNameMap(Map<Locale, String> rotationTypeNameMap);

	/**
	 * Sets the localized rotation type names of this rotation type master from the map of locales and localized rotation type names, and sets the default locale.
	 *
	 * @param rotationTypeNameMap the locales and localized rotation type names of this rotation type master
	 * @param defaultLocale the default locale
	 */
	public void setRotationTypeNameMap(
		Map<Locale, String> rotationTypeNameMap, Locale defaultLocale);

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
	public RotationTypeMaster cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}