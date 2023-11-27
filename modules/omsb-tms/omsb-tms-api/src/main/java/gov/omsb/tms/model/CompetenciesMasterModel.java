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
 * The base model interface for the CompetenciesMaster service. Represents a row in the &quot;competencies_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.CompetenciesMasterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.CompetenciesMasterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMaster
 * @generated
 */
@ProviderType
public interface CompetenciesMasterModel
	extends BaseModel<CompetenciesMaster>, LocalizedModel, ShardedModel,
			StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a competencies master model instance should use the {@link CompetenciesMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this competencies master.
	 *
	 * @return the primary key of this competencies master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this competencies master.
	 *
	 * @param primaryKey the primary key of this competencies master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this competencies master.
	 *
	 * @return the uuid of this competencies master
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this competencies master.
	 *
	 * @param uuid the uuid of this competencies master
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the competencies master ID of this competencies master.
	 *
	 * @return the competencies master ID of this competencies master
	 */
	public long getCompetenciesMasterId();

	/**
	 * Sets the competencies master ID of this competencies master.
	 *
	 * @param competenciesMasterId the competencies master ID of this competencies master
	 */
	public void setCompetenciesMasterId(long competenciesMasterId);

	/**
	 * Returns the group ID of this competencies master.
	 *
	 * @return the group ID of this competencies master
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this competencies master.
	 *
	 * @param groupId the group ID of this competencies master
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this competencies master.
	 *
	 * @return the company ID of this competencies master
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this competencies master.
	 *
	 * @param companyId the company ID of this competencies master
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this competencies master.
	 *
	 * @return the create date of this competencies master
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this competencies master.
	 *
	 * @param createDate the create date of this competencies master
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this competencies master.
	 *
	 * @return the modified date of this competencies master
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this competencies master.
	 *
	 * @param modifiedDate the modified date of this competencies master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the competency name of this competencies master.
	 *
	 * @return the competency name of this competencies master
	 */
	public String getCompetencyName();

	/**
	 * Returns the localized competency name of this competencies master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized competency name of this competencies master
	 */
	@AutoEscape
	public String getCompetencyName(Locale locale);

	/**
	 * Returns the localized competency name of this competencies master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized competency name of this competencies master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getCompetencyName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized competency name of this competencies master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized competency name of this competencies master
	 */
	@AutoEscape
	public String getCompetencyName(String languageId);

	/**
	 * Returns the localized competency name of this competencies master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized competency name of this competencies master
	 */
	@AutoEscape
	public String getCompetencyName(String languageId, boolean useDefault);

	@AutoEscape
	public String getCompetencyNameCurrentLanguageId();

	@AutoEscape
	public String getCompetencyNameCurrentValue();

	/**
	 * Returns a map of the locales and localized competency names of this competencies master.
	 *
	 * @return the locales and localized competency names of this competencies master
	 */
	public Map<Locale, String> getCompetencyNameMap();

	/**
	 * Sets the competency name of this competencies master.
	 *
	 * @param competencyName the competency name of this competencies master
	 */
	public void setCompetencyName(String competencyName);

	/**
	 * Sets the localized competency name of this competencies master in the language.
	 *
	 * @param competencyName the localized competency name of this competencies master
	 * @param locale the locale of the language
	 */
	public void setCompetencyName(String competencyName, Locale locale);

	/**
	 * Sets the localized competency name of this competencies master in the language, and sets the default locale.
	 *
	 * @param competencyName the localized competency name of this competencies master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setCompetencyName(
		String competencyName, Locale locale, Locale defaultLocale);

	public void setCompetencyNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized competency names of this competencies master from the map of locales and localized competency names.
	 *
	 * @param competencyNameMap the locales and localized competency names of this competencies master
	 */
	public void setCompetencyNameMap(Map<Locale, String> competencyNameMap);

	/**
	 * Sets the localized competency names of this competencies master from the map of locales and localized competency names, and sets the default locale.
	 *
	 * @param competencyNameMap the locales and localized competency names of this competencies master
	 * @param defaultLocale the default locale
	 */
	public void setCompetencyNameMap(
		Map<Locale, String> competencyNameMap, Locale defaultLocale);

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
	public CompetenciesMaster cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}