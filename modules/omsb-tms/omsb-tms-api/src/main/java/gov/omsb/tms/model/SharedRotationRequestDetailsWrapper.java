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
 * This class is a wrapper for {@link SharedRotationRequestDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetails
 * @generated
 */
public class SharedRotationRequestDetailsWrapper
	extends BaseModelWrapper<SharedRotationRequestDetails>
	implements ModelWrapper<SharedRotationRequestDetails>,
			   SharedRotationRequestDetails {

	public SharedRotationRequestDetailsWrapper(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		super(sharedRotationRequestDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"sharedRotationRequestDetailsId",
			getSharedRotationRequestDetailsId());
		attributes.put("programDurationId", getProgramDurationId());
		attributes.put("rotationId", getRotationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("noOfTraineesRequested", getNoOfTraineesRequested());
		attributes.put("requesterComment", getRequesterComment());
		attributes.put("status", getStatus());
		attributes.put("approvedCount", getApprovedCount());
		attributes.put("rejectedCount", getRejectedCount());
		attributes.put("requestRaisedTo", getRequestRaisedTo());
		attributes.put("requestRaisedBy", getRequestRaisedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sharedRotationRequestDetailsId = (Long)attributes.get(
			"sharedRotationRequestDetailsId");

		if (sharedRotationRequestDetailsId != null) {
			setSharedRotationRequestDetailsId(sharedRotationRequestDetailsId);
		}

		Long programDurationId = (Long)attributes.get("programDurationId");

		if (programDurationId != null) {
			setProgramDurationId(programDurationId);
		}

		Long rotationId = (Long)attributes.get("rotationId");

		if (rotationId != null) {
			setRotationId(rotationId);
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

		Long noOfTraineesRequested = (Long)attributes.get(
			"noOfTraineesRequested");

		if (noOfTraineesRequested != null) {
			setNoOfTraineesRequested(noOfTraineesRequested);
		}

		String requesterComment = (String)attributes.get("requesterComment");

		if (requesterComment != null) {
			setRequesterComment(requesterComment);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long approvedCount = (Long)attributes.get("approvedCount");

		if (approvedCount != null) {
			setApprovedCount(approvedCount);
		}

		Long rejectedCount = (Long)attributes.get("rejectedCount");

		if (rejectedCount != null) {
			setRejectedCount(rejectedCount);
		}

		String requestRaisedTo = (String)attributes.get("requestRaisedTo");

		if (requestRaisedTo != null) {
			setRequestRaisedTo(requestRaisedTo);
		}

		String requestRaisedBy = (String)attributes.get("requestRaisedBy");

		if (requestRaisedBy != null) {
			setRequestRaisedBy(requestRaisedBy);
		}
	}

	@Override
	public SharedRotationRequestDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the approved count of this shared rotation request details.
	 *
	 * @return the approved count of this shared rotation request details
	 */
	@Override
	public long getApprovedCount() {
		return model.getApprovedCount();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this shared rotation request details.
	 *
	 * @return the company ID of this shared rotation request details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this shared rotation request details.
	 *
	 * @return the create date of this shared rotation request details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this shared rotation request details.
	 *
	 * @return the created by of this shared rotation request details
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
	 * Returns the group ID of this shared rotation request details.
	 *
	 * @return the group ID of this shared rotation request details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this shared rotation request details.
	 *
	 * @return the modified by of this shared rotation request details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this shared rotation request details.
	 *
	 * @return the modified date of this shared rotation request details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of trainees requested of this shared rotation request details.
	 *
	 * @return the no of trainees requested of this shared rotation request details
	 */
	@Override
	public long getNoOfTraineesRequested() {
		return model.getNoOfTraineesRequested();
	}

	/**
	 * Returns the primary key of this shared rotation request details.
	 *
	 * @return the primary key of this shared rotation request details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program duration ID of this shared rotation request details.
	 *
	 * @return the program duration ID of this shared rotation request details
	 */
	@Override
	public long getProgramDurationId() {
		return model.getProgramDurationId();
	}

	/**
	 * Returns the rejected count of this shared rotation request details.
	 *
	 * @return the rejected count of this shared rotation request details
	 */
	@Override
	public long getRejectedCount() {
		return model.getRejectedCount();
	}

	/**
	 * Returns the requester comment of this shared rotation request details.
	 *
	 * @return the requester comment of this shared rotation request details
	 */
	@Override
	public String getRequesterComment() {
		return model.getRequesterComment();
	}

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@Override
	public String getRequesterComment(java.util.Locale locale) {
		return model.getRequesterComment(locale);
	}

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requester comment of this shared rotation request details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRequesterComment(
		java.util.Locale locale, boolean useDefault) {

		return model.getRequesterComment(locale, useDefault);
	}

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@Override
	public String getRequesterComment(String languageId) {
		return model.getRequesterComment(languageId);
	}

	/**
	 * Returns the localized requester comment of this shared rotation request details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized requester comment of this shared rotation request details
	 */
	@Override
	public String getRequesterComment(String languageId, boolean useDefault) {
		return model.getRequesterComment(languageId, useDefault);
	}

	@Override
	public String getRequesterCommentCurrentLanguageId() {
		return model.getRequesterCommentCurrentLanguageId();
	}

	@Override
	public String getRequesterCommentCurrentValue() {
		return model.getRequesterCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized requester comments of this shared rotation request details.
	 *
	 * @return the locales and localized requester comments of this shared rotation request details
	 */
	@Override
	public Map<java.util.Locale, String> getRequesterCommentMap() {
		return model.getRequesterCommentMap();
	}

	/**
	 * Returns the request raised by of this shared rotation request details.
	 *
	 * @return the request raised by of this shared rotation request details
	 */
	@Override
	public String getRequestRaisedBy() {
		return model.getRequestRaisedBy();
	}

	/**
	 * Returns the request raised to of this shared rotation request details.
	 *
	 * @return the request raised to of this shared rotation request details
	 */
	@Override
	public String getRequestRaisedTo() {
		return model.getRequestRaisedTo();
	}

	/**
	 * Returns the rotation ID of this shared rotation request details.
	 *
	 * @return the rotation ID of this shared rotation request details
	 */
	@Override
	public long getRotationId() {
		return model.getRotationId();
	}

	/**
	 * Returns the shared rotation request details ID of this shared rotation request details.
	 *
	 * @return the shared rotation request details ID of this shared rotation request details
	 */
	@Override
	public long getSharedRotationRequestDetailsId() {
		return model.getSharedRotationRequestDetailsId();
	}

	/**
	 * Returns the status of this shared rotation request details.
	 *
	 * @return the status of this shared rotation request details
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this shared rotation request details.
	 *
	 * @return the uuid of this shared rotation request details
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
	 * Sets the approved count of this shared rotation request details.
	 *
	 * @param approvedCount the approved count of this shared rotation request details
	 */
	@Override
	public void setApprovedCount(long approvedCount) {
		model.setApprovedCount(approvedCount);
	}

	/**
	 * Sets the company ID of this shared rotation request details.
	 *
	 * @param companyId the company ID of this shared rotation request details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this shared rotation request details.
	 *
	 * @param createDate the create date of this shared rotation request details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this shared rotation request details.
	 *
	 * @param createdBy the created by of this shared rotation request details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this shared rotation request details.
	 *
	 * @param groupId the group ID of this shared rotation request details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this shared rotation request details.
	 *
	 * @param modifiedBy the modified by of this shared rotation request details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this shared rotation request details.
	 *
	 * @param modifiedDate the modified date of this shared rotation request details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of trainees requested of this shared rotation request details.
	 *
	 * @param noOfTraineesRequested the no of trainees requested of this shared rotation request details
	 */
	@Override
	public void setNoOfTraineesRequested(long noOfTraineesRequested) {
		model.setNoOfTraineesRequested(noOfTraineesRequested);
	}

	/**
	 * Sets the primary key of this shared rotation request details.
	 *
	 * @param primaryKey the primary key of this shared rotation request details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program duration ID of this shared rotation request details.
	 *
	 * @param programDurationId the program duration ID of this shared rotation request details
	 */
	@Override
	public void setProgramDurationId(long programDurationId) {
		model.setProgramDurationId(programDurationId);
	}

	/**
	 * Sets the rejected count of this shared rotation request details.
	 *
	 * @param rejectedCount the rejected count of this shared rotation request details
	 */
	@Override
	public void setRejectedCount(long rejectedCount) {
		model.setRejectedCount(rejectedCount);
	}

	/**
	 * Sets the requester comment of this shared rotation request details.
	 *
	 * @param requesterComment the requester comment of this shared rotation request details
	 */
	@Override
	public void setRequesterComment(String requesterComment) {
		model.setRequesterComment(requesterComment);
	}

	/**
	 * Sets the localized requester comment of this shared rotation request details in the language.
	 *
	 * @param requesterComment the localized requester comment of this shared rotation request details
	 * @param locale the locale of the language
	 */
	@Override
	public void setRequesterComment(
		String requesterComment, java.util.Locale locale) {

		model.setRequesterComment(requesterComment, locale);
	}

	/**
	 * Sets the localized requester comment of this shared rotation request details in the language, and sets the default locale.
	 *
	 * @param requesterComment the localized requester comment of this shared rotation request details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRequesterComment(
		String requesterComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRequesterComment(requesterComment, locale, defaultLocale);
	}

	@Override
	public void setRequesterCommentCurrentLanguageId(String languageId) {
		model.setRequesterCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized requester comments of this shared rotation request details from the map of locales and localized requester comments.
	 *
	 * @param requesterCommentMap the locales and localized requester comments of this shared rotation request details
	 */
	@Override
	public void setRequesterCommentMap(
		Map<java.util.Locale, String> requesterCommentMap) {

		model.setRequesterCommentMap(requesterCommentMap);
	}

	/**
	 * Sets the localized requester comments of this shared rotation request details from the map of locales and localized requester comments, and sets the default locale.
	 *
	 * @param requesterCommentMap the locales and localized requester comments of this shared rotation request details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRequesterCommentMap(
		Map<java.util.Locale, String> requesterCommentMap,
		java.util.Locale defaultLocale) {

		model.setRequesterCommentMap(requesterCommentMap, defaultLocale);
	}

	/**
	 * Sets the request raised by of this shared rotation request details.
	 *
	 * @param requestRaisedBy the request raised by of this shared rotation request details
	 */
	@Override
	public void setRequestRaisedBy(String requestRaisedBy) {
		model.setRequestRaisedBy(requestRaisedBy);
	}

	/**
	 * Sets the request raised to of this shared rotation request details.
	 *
	 * @param requestRaisedTo the request raised to of this shared rotation request details
	 */
	@Override
	public void setRequestRaisedTo(String requestRaisedTo) {
		model.setRequestRaisedTo(requestRaisedTo);
	}

	/**
	 * Sets the rotation ID of this shared rotation request details.
	 *
	 * @param rotationId the rotation ID of this shared rotation request details
	 */
	@Override
	public void setRotationId(long rotationId) {
		model.setRotationId(rotationId);
	}

	/**
	 * Sets the shared rotation request details ID of this shared rotation request details.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID of this shared rotation request details
	 */
	@Override
	public void setSharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId) {

		model.setSharedRotationRequestDetailsId(sharedRotationRequestDetailsId);
	}

	/**
	 * Sets the status of this shared rotation request details.
	 *
	 * @param status the status of this shared rotation request details
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this shared rotation request details.
	 *
	 * @param uuid the uuid of this shared rotation request details
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
	protected SharedRotationRequestDetailsWrapper wrap(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		return new SharedRotationRequestDetailsWrapper(
			sharedRotationRequestDetails);
	}

}