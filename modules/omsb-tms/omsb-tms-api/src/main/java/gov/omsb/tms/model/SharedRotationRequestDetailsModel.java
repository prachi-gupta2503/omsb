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
 * The base model interface for the SharedRotationRequestDetails service. Represents a row in the &quot;shared_rotation_request_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>gov.omsb.tms.model.impl.SharedRotationRequestDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>gov.omsb.tms.model.impl.SharedRotationRequestDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetails
 * @generated
 */
@ProviderType
public interface SharedRotationRequestDetailsModel
	extends BaseModel<SharedRotationRequestDetails>, LocalizedModel,
			ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a shared rotation request details model instance should use the {@link SharedRotationRequestDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this shared rotation request details.
	 *
	 * @return the primary key of this shared rotation request details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shared rotation request details.
	 *
	 * @param primaryKey the primary key of this shared rotation request details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this shared rotation request details.
	 *
	 * @return the uuid of this shared rotation request details
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this shared rotation request details.
	 *
	 * @param uuid the uuid of this shared rotation request details
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the shared rotation request details ID of this shared rotation request details.
	 *
	 * @return the shared rotation request details ID of this shared rotation request details
	 */
	public long getSharedRotationRequestDetailsId();

	/**
	 * Sets the shared rotation request details ID of this shared rotation request details.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID of this shared rotation request details
	 */
	public void setSharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId);

	/**
	 * Returns the program duration ID of this shared rotation request details.
	 *
	 * @return the program duration ID of this shared rotation request details
	 */
	public long getProgramDurationId();

	/**
	 * Sets the program duration ID of this shared rotation request details.
	 *
	 * @param programDurationId the program duration ID of this shared rotation request details
	 */
	public void setProgramDurationId(long programDurationId);

	/**
	 * Returns the rotation ID of this shared rotation request details.
	 *
	 * @return the rotation ID of this shared rotation request details
	 */
	public long getRotationId();

	/**
	 * Sets the rotation ID of this shared rotation request details.
	 *
	 * @param rotationId the rotation ID of this shared rotation request details
	 */
	public void setRotationId(long rotationId);

	/**
	 * Returns the group ID of this shared rotation request details.
	 *
	 * @return the group ID of this shared rotation request details
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this shared rotation request details.
	 *
	 * @param groupId the group ID of this shared rotation request details
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this shared rotation request details.
	 *
	 * @return the company ID of this shared rotation request details
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this shared rotation request details.
	 *
	 * @param companyId the company ID of this shared rotation request details
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this shared rotation request details.
	 *
	 * @return the create date of this shared rotation request details
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this shared rotation request details.
	 *
	 * @param createDate the create date of this shared rotation request details
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this shared rotation request details.
	 *
	 * @return the created by of this shared rotation request details
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this shared rotation request details.
	 *
	 * @param createdBy the created by of this shared rotation request details
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this shared rotation request details.
	 *
	 * @return the modified date of this shared rotation request details
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this shared rotation request details.
	 *
	 * @param modifiedDate the modified date of this shared rotation request details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this shared rotation request details.
	 *
	 * @return the modified by of this shared rotation request details
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this shared rotation request details.
	 *
	 * @param modifiedBy the modified by of this shared rotation request details
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the no of trainees requested of this shared rotation request details.
	 *
	 * @return the no of trainees requested of this shared rotation request details
	 */
	public long getNoOfTraineesRequested();

	/**
	 * Sets the no of trainees requested of this shared rotation request details.
	 *
	 * @param noOfTraineesRequested the no of trainees requested of this shared rotation request details
	 */
	public void setNoOfTraineesRequested(long noOfTraineesRequested);

	/**
	 * Returns the requester comment of this shared rotation request details.
	 *
	 * @return the requester comment of this shared rotation request details
	 */
	public String getRequesterComment();

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@AutoEscape
	public String getRequesterComment(Locale locale);

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requester comment of this shared rotation request details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getRequesterComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@AutoEscape
	public String getRequesterComment(String languageId);

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@AutoEscape
	public String getRequesterComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getRequesterCommentCurrentLanguageId();

	@AutoEscape
	public String getRequesterCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized requester comments of this shared rotation request details.
	 *
	 * @return the locales and localized requester comments of this shared rotation request details
	 */
	public Map<Locale, String> getRequesterCommentMap();

	/**
	 * Sets the requester comment of this shared rotation request details.
	 *
	 * @param requesterComment the requester comment of this shared rotation request details
	 */
	public void setRequesterComment(String requesterComment);

	/**
	 * Sets the localized requester comment of this shared rotation request details in the language.
	 *
	 * @param requesterComment the localized requester comment of this shared rotation request details
	 * @param locale the locale of the language
	 */
	public void setRequesterComment(String requesterComment, Locale locale);

	/**
	 * Sets the localized requester comment of this shared rotation request details in the language, and sets the default locale.
	 *
	 * @param requesterComment the localized requester comment of this shared rotation request details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setRequesterComment(
		String requesterComment, Locale locale, Locale defaultLocale);

	public void setRequesterCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized requester comments of this shared rotation request details from the map of locales and localized requester comments.
	 *
	 * @param requesterCommentMap the locales and localized requester comments of this shared rotation request details
	 */
	public void setRequesterCommentMap(Map<Locale, String> requesterCommentMap);

	/**
	 * Sets the localized requester comments of this shared rotation request details from the map of locales and localized requester comments, and sets the default locale.
	 *
	 * @param requesterCommentMap the locales and localized requester comments of this shared rotation request details
	 * @param defaultLocale the default locale
	 */
	public void setRequesterCommentMap(
		Map<Locale, String> requesterCommentMap, Locale defaultLocale);

	/**
	 * Returns the status of this shared rotation request details.
	 *
	 * @return the status of this shared rotation request details
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this shared rotation request details.
	 *
	 * @param status the status of this shared rotation request details
	 */
	public void setStatus(String status);

	/**
	 * Returns the approved count of this shared rotation request details.
	 *
	 * @return the approved count of this shared rotation request details
	 */
	public long getApprovedCount();

	/**
	 * Sets the approved count of this shared rotation request details.
	 *
	 * @param approvedCount the approved count of this shared rotation request details
	 */
	public void setApprovedCount(long approvedCount);

	/**
	 * Returns the rejected count of this shared rotation request details.
	 *
	 * @return the rejected count of this shared rotation request details
	 */
	public long getRejectedCount();

	/**
	 * Sets the rejected count of this shared rotation request details.
	 *
	 * @param rejectedCount the rejected count of this shared rotation request details
	 */
	public void setRejectedCount(long rejectedCount);

	/**
	 * Returns the request raised to of this shared rotation request details.
	 *
	 * @return the request raised to of this shared rotation request details
	 */
	@AutoEscape
	public String getRequestRaisedTo();

	/**
	 * Sets the request raised to of this shared rotation request details.
	 *
	 * @param requestRaisedTo the request raised to of this shared rotation request details
	 */
	public void setRequestRaisedTo(String requestRaisedTo);

	/**
	 * Returns the request raised by of this shared rotation request details.
	 *
	 * @return the request raised by of this shared rotation request details
	 */
	@AutoEscape
	public String getRequestRaisedBy();

	/**
	 * Sets the request raised by of this shared rotation request details.
	 *
	 * @param requestRaisedBy the request raised by of this shared rotation request details
	 */
	public void setRequestRaisedBy(String requestRaisedBy);

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
	public SharedRotationRequestDetails cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}