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

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TraineeSponsorDetails service. Represents a row in the &quot;trainee_sponsor_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetails
 * @generated
 */
@ProviderType
public interface TraineeSponsorDetailsModel
	extends BaseModel<TraineeSponsorDetails>, LocalizedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a trainee sponsor details model instance should use the {@link TraineeSponsorDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this trainee sponsor details.
	 *
	 * @return the primary key of this trainee sponsor details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this trainee sponsor details.
	 *
	 * @param primaryKey the primary key of this trainee sponsor details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this trainee sponsor details.
	 *
	 * @return the uuid of this trainee sponsor details
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this trainee sponsor details.
	 *
	 * @param uuid the uuid of this trainee sponsor details
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the trainee sponsor details ID of this trainee sponsor details.
	 *
	 * @return the trainee sponsor details ID of this trainee sponsor details
	 */
	public long getTraineeSponsorDetailsId();

	/**
	 * Sets the trainee sponsor details ID of this trainee sponsor details.
	 *
	 * @param traineeSponsorDetailsId the trainee sponsor details ID of this trainee sponsor details
	 */
	public void setTraineeSponsorDetailsId(long traineeSponsorDetailsId);

	/**
	 * Returns the group ID of this trainee sponsor details.
	 *
	 * @return the group ID of this trainee sponsor details
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this trainee sponsor details.
	 *
	 * @param groupId the group ID of this trainee sponsor details
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this trainee sponsor details.
	 *
	 * @return the company ID of this trainee sponsor details
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this trainee sponsor details.
	 *
	 * @param companyId the company ID of this trainee sponsor details
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created date of this trainee sponsor details.
	 *
	 * @return the created date of this trainee sponsor details
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this trainee sponsor details.
	 *
	 * @param createdDate the created date of this trainee sponsor details
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this trainee sponsor details.
	 *
	 * @return the created by of this trainee sponsor details
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this trainee sponsor details.
	 *
	 * @param createdBy the created by of this trainee sponsor details
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this trainee sponsor details.
	 *
	 * @return the modified date of this trainee sponsor details
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this trainee sponsor details.
	 *
	 * @param modifiedDate the modified date of this trainee sponsor details
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this trainee sponsor details.
	 *
	 * @return the modified by of this trainee sponsor details
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this trainee sponsor details.
	 *
	 * @param modifiedBy the modified by of this trainee sponsor details
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the trainee ID of this trainee sponsor details.
	 *
	 * @return the trainee ID of this trainee sponsor details
	 */
	public long getTraineeId();

	/**
	 * Sets the trainee ID of this trainee sponsor details.
	 *
	 * @param traineeId the trainee ID of this trainee sponsor details
	 */
	public void setTraineeId(long traineeId);

	/**
	 * Returns the program duration ID of this trainee sponsor details.
	 *
	 * @return the program duration ID of this trainee sponsor details
	 */
	public long getProgramDurationId();

	/**
	 * Sets the program duration ID of this trainee sponsor details.
	 *
	 * @param programDurationId the program duration ID of this trainee sponsor details
	 */
	public void setProgramDurationId(long programDurationId);

	/**
	 * Returns the sponsor of this trainee sponsor details.
	 *
	 * @return the sponsor of this trainee sponsor details
	 */
	public String getSponsor();

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@AutoEscape
	public String getSponsor(Locale locale);

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sponsor of this trainee sponsor details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSponsor(Locale locale, boolean useDefault);

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@AutoEscape
	public String getSponsor(String languageId);

	/**
	 * Returns the localized sponsor of this trainee sponsor details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized sponsor of this trainee sponsor details
	 */
	@AutoEscape
	public String getSponsor(String languageId, boolean useDefault);

	@AutoEscape
	public String getSponsorCurrentLanguageId();

	@AutoEscape
	public String getSponsorCurrentValue();

	/**
	 * Returns a map of the locales and localized sponsors of this trainee sponsor details.
	 *
	 * @return the locales and localized sponsors of this trainee sponsor details
	 */
	public Map<Locale, String> getSponsorMap();

	/**
	 * Sets the sponsor of this trainee sponsor details.
	 *
	 * @param sponsor the sponsor of this trainee sponsor details
	 */
	public void setSponsor(String sponsor);

	/**
	 * Sets the localized sponsor of this trainee sponsor details in the language.
	 *
	 * @param sponsor the localized sponsor of this trainee sponsor details
	 * @param locale the locale of the language
	 */
	public void setSponsor(String sponsor, Locale locale);

	/**
	 * Sets the localized sponsor of this trainee sponsor details in the language, and sets the default locale.
	 *
	 * @param sponsor the localized sponsor of this trainee sponsor details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSponsor(String sponsor, Locale locale, Locale defaultLocale);

	public void setSponsorCurrentLanguageId(String languageId);

	/**
	 * Sets the localized sponsors of this trainee sponsor details from the map of locales and localized sponsors.
	 *
	 * @param sponsorMap the locales and localized sponsors of this trainee sponsor details
	 */
	public void setSponsorMap(Map<Locale, String> sponsorMap);

	/**
	 * Sets the localized sponsors of this trainee sponsor details from the map of locales and localized sponsors, and sets the default locale.
	 *
	 * @param sponsorMap the locales and localized sponsors of this trainee sponsor details
	 * @param defaultLocale the default locale
	 */
	public void setSponsorMap(
		Map<Locale, String> sponsorMap, Locale defaultLocale);

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
	public TraineeSponsorDetails cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}