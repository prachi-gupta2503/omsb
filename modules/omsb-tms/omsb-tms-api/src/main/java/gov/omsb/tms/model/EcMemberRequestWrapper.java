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
 * This class is a wrapper for {@link EcMemberRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequest
 * @generated
 */
public class EcMemberRequestWrapper
	extends BaseModelWrapper<EcMemberRequest>
	implements EcMemberRequest, ModelWrapper<EcMemberRequest> {

	public EcMemberRequestWrapper(EcMemberRequest ecMemberRequest) {
		super(ecMemberRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ecMemberRequestId", getEcMemberRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("programId", getProgramId());
		attributes.put("potentialEcMemberId", getPotentialEcMemberId());
		attributes.put("potentialEcMemberRoleId", getPotentialEcMemberRoleId());
		attributes.put(
			"latestEcMemberRequestStateId", getLatestEcMemberRequestStateId());
		attributes.put("coveringLetterId", getCoveringLetterId());
		attributes.put("cvId", getCvId());
		attributes.put("noObjectionLetterId", getNoObjectionLetterId());
		attributes.put("passportCopyId", getPassportCopyId());
		attributes.put("nationalIdCopyId", getNationalIdCopyId());
		attributes.put("qararRequestId", getQararRequestId());
		attributes.put("qararDocId", getQararDocId());
		attributes.put("comments", getComments());
		attributes.put(
			"potentialEcMemberLruserid", getPotentialEcMemberLruserid());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ecMemberRequestId = (Long)attributes.get("ecMemberRequestId");

		if (ecMemberRequestId != null) {
			setEcMemberRequestId(ecMemberRequestId);
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

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
		}

		Long potentialEcMemberId = (Long)attributes.get("potentialEcMemberId");

		if (potentialEcMemberId != null) {
			setPotentialEcMemberId(potentialEcMemberId);
		}

		Long potentialEcMemberRoleId = (Long)attributes.get(
			"potentialEcMemberRoleId");

		if (potentialEcMemberRoleId != null) {
			setPotentialEcMemberRoleId(potentialEcMemberRoleId);
		}

		Long latestEcMemberRequestStateId = (Long)attributes.get(
			"latestEcMemberRequestStateId");

		if (latestEcMemberRequestStateId != null) {
			setLatestEcMemberRequestStateId(latestEcMemberRequestStateId);
		}

		Long coveringLetterId = (Long)attributes.get("coveringLetterId");

		if (coveringLetterId != null) {
			setCoveringLetterId(coveringLetterId);
		}

		Long cvId = (Long)attributes.get("cvId");

		if (cvId != null) {
			setCvId(cvId);
		}

		Long noObjectionLetterId = (Long)attributes.get("noObjectionLetterId");

		if (noObjectionLetterId != null) {
			setNoObjectionLetterId(noObjectionLetterId);
		}

		Long passportCopyId = (Long)attributes.get("passportCopyId");

		if (passportCopyId != null) {
			setPassportCopyId(passportCopyId);
		}

		Long nationalIdCopyId = (Long)attributes.get("nationalIdCopyId");

		if (nationalIdCopyId != null) {
			setNationalIdCopyId(nationalIdCopyId);
		}

		Long qararRequestId = (Long)attributes.get("qararRequestId");

		if (qararRequestId != null) {
			setQararRequestId(qararRequestId);
		}

		Long qararDocId = (Long)attributes.get("qararDocId");

		if (qararDocId != null) {
			setQararDocId(qararDocId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Long potentialEcMemberLruserid = (Long)attributes.get(
			"potentialEcMemberLruserid");

		if (potentialEcMemberLruserid != null) {
			setPotentialEcMemberLruserid(potentialEcMemberLruserid);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public EcMemberRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the comments of this ec member request.
	 *
	 * @return the comments of this ec member request
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the localized comments of this ec member request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comments of this ec member request
	 */
	@Override
	public String getComments(java.util.Locale locale) {
		return model.getComments(locale);
	}

	/**
	 * Returns the localized comments of this ec member request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this ec member request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getComments(java.util.Locale locale, boolean useDefault) {
		return model.getComments(locale, useDefault);
	}

	/**
	 * Returns the localized comments of this ec member request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comments of this ec member request
	 */
	@Override
	public String getComments(String languageId) {
		return model.getComments(languageId);
	}

	/**
	 * Returns the localized comments of this ec member request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this ec member request
	 */
	@Override
	public String getComments(String languageId, boolean useDefault) {
		return model.getComments(languageId, useDefault);
	}

	@Override
	public String getCommentsCurrentLanguageId() {
		return model.getCommentsCurrentLanguageId();
	}

	@Override
	public String getCommentsCurrentValue() {
		return model.getCommentsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized commentses of this ec member request.
	 *
	 * @return the locales and localized commentses of this ec member request
	 */
	@Override
	public Map<java.util.Locale, String> getCommentsMap() {
		return model.getCommentsMap();
	}

	/**
	 * Returns the company ID of this ec member request.
	 *
	 * @return the company ID of this ec member request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the covering letter ID of this ec member request.
	 *
	 * @return the covering letter ID of this ec member request
	 */
	@Override
	public long getCoveringLetterId() {
		return model.getCoveringLetterId();
	}

	/**
	 * Returns the create date of this ec member request.
	 *
	 * @return the create date of this ec member request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the cv ID of this ec member request.
	 *
	 * @return the cv ID of this ec member request
	 */
	@Override
	public long getCvId() {
		return model.getCvId();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the ec member request ID of this ec member request.
	 *
	 * @return the ec member request ID of this ec member request
	 */
	@Override
	public long getEcMemberRequestId() {
		return model.getEcMemberRequestId();
	}

	/**
	 * Returns the group ID of this ec member request.
	 *
	 * @return the group ID of this ec member request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latest ec member request state ID of this ec member request.
	 *
	 * @return the latest ec member request state ID of this ec member request
	 */
	@Override
	public long getLatestEcMemberRequestStateId() {
		return model.getLatestEcMemberRequestStateId();
	}

	/**
	 * Returns the modified date of this ec member request.
	 *
	 * @return the modified date of this ec member request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID copy ID of this ec member request.
	 *
	 * @return the national ID copy ID of this ec member request
	 */
	@Override
	public long getNationalIdCopyId() {
		return model.getNationalIdCopyId();
	}

	/**
	 * Returns the no objection letter ID of this ec member request.
	 *
	 * @return the no objection letter ID of this ec member request
	 */
	@Override
	public long getNoObjectionLetterId() {
		return model.getNoObjectionLetterId();
	}

	/**
	 * Returns the passport copy ID of this ec member request.
	 *
	 * @return the passport copy ID of this ec member request
	 */
	@Override
	public long getPassportCopyId() {
		return model.getPassportCopyId();
	}

	/**
	 * Returns the potential ec member ID of this ec member request.
	 *
	 * @return the potential ec member ID of this ec member request
	 */
	@Override
	public long getPotentialEcMemberId() {
		return model.getPotentialEcMemberId();
	}

	/**
	 * Returns the potential ec member lruserid of this ec member request.
	 *
	 * @return the potential ec member lruserid of this ec member request
	 */
	@Override
	public long getPotentialEcMemberLruserid() {
		return model.getPotentialEcMemberLruserid();
	}

	/**
	 * Returns the potential ec member role ID of this ec member request.
	 *
	 * @return the potential ec member role ID of this ec member request
	 */
	@Override
	public long getPotentialEcMemberRoleId() {
		return model.getPotentialEcMemberRoleId();
	}

	/**
	 * Returns the primary key of this ec member request.
	 *
	 * @return the primary key of this ec member request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ID of this ec member request.
	 *
	 * @return the program ID of this ec member request
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the qarar doc ID of this ec member request.
	 *
	 * @return the qarar doc ID of this ec member request
	 */
	@Override
	public long getQararDocId() {
		return model.getQararDocId();
	}

	/**
	 * Returns the qarar request ID of this ec member request.
	 *
	 * @return the qarar request ID of this ec member request
	 */
	@Override
	public long getQararRequestId() {
		return model.getQararRequestId();
	}

	/**
	 * Returns the status of this ec member request.
	 *
	 * @return the status of this ec member request
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this ec member request.
	 *
	 * @return the status by user ID of this ec member request
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this ec member request.
	 *
	 * @return the status by user name of this ec member request
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this ec member request.
	 *
	 * @return the status by user uuid of this ec member request
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this ec member request.
	 *
	 * @return the status date of this ec member request
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this ec member request.
	 *
	 * @return the user ID of this ec member request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ec member request.
	 *
	 * @return the user name of this ec member request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ec member request.
	 *
	 * @return the user uuid of this ec member request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ec member request.
	 *
	 * @return the uuid of this ec member request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this ec member request is approved.
	 *
	 * @return <code>true</code> if this ec member request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this ec member request is denied.
	 *
	 * @return <code>true</code> if this ec member request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this ec member request is a draft.
	 *
	 * @return <code>true</code> if this ec member request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this ec member request is expired.
	 *
	 * @return <code>true</code> if this ec member request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this ec member request is inactive.
	 *
	 * @return <code>true</code> if this ec member request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this ec member request is incomplete.
	 *
	 * @return <code>true</code> if this ec member request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this ec member request is pending.
	 *
	 * @return <code>true</code> if this ec member request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this ec member request is scheduled.
	 *
	 * @return <code>true</code> if this ec member request is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
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
	 * Sets the comments of this ec member request.
	 *
	 * @param comments the comments of this ec member request
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the localized comments of this ec member request in the language.
	 *
	 * @param comments the localized comments of this ec member request
	 * @param locale the locale of the language
	 */
	@Override
	public void setComments(String comments, java.util.Locale locale) {
		model.setComments(comments, locale);
	}

	/**
	 * Sets the localized comments of this ec member request in the language, and sets the default locale.
	 *
	 * @param comments the localized comments of this ec member request
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setComments(
		String comments, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setComments(comments, locale, defaultLocale);
	}

	@Override
	public void setCommentsCurrentLanguageId(String languageId) {
		model.setCommentsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized commentses of this ec member request from the map of locales and localized commentses.
	 *
	 * @param commentsMap the locales and localized commentses of this ec member request
	 */
	@Override
	public void setCommentsMap(Map<java.util.Locale, String> commentsMap) {
		model.setCommentsMap(commentsMap);
	}

	/**
	 * Sets the localized commentses of this ec member request from the map of locales and localized commentses, and sets the default locale.
	 *
	 * @param commentsMap the locales and localized commentses of this ec member request
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommentsMap(
		Map<java.util.Locale, String> commentsMap,
		java.util.Locale defaultLocale) {

		model.setCommentsMap(commentsMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this ec member request.
	 *
	 * @param companyId the company ID of this ec member request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the covering letter ID of this ec member request.
	 *
	 * @param coveringLetterId the covering letter ID of this ec member request
	 */
	@Override
	public void setCoveringLetterId(long coveringLetterId) {
		model.setCoveringLetterId(coveringLetterId);
	}

	/**
	 * Sets the create date of this ec member request.
	 *
	 * @param createDate the create date of this ec member request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the cv ID of this ec member request.
	 *
	 * @param cvId the cv ID of this ec member request
	 */
	@Override
	public void setCvId(long cvId) {
		model.setCvId(cvId);
	}

	/**
	 * Sets the ec member request ID of this ec member request.
	 *
	 * @param ecMemberRequestId the ec member request ID of this ec member request
	 */
	@Override
	public void setEcMemberRequestId(long ecMemberRequestId) {
		model.setEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Sets the group ID of this ec member request.
	 *
	 * @param groupId the group ID of this ec member request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the latest ec member request state ID of this ec member request.
	 *
	 * @param latestEcMemberRequestStateId the latest ec member request state ID of this ec member request
	 */
	@Override
	public void setLatestEcMemberRequestStateId(
		long latestEcMemberRequestStateId) {

		model.setLatestEcMemberRequestStateId(latestEcMemberRequestStateId);
	}

	/**
	 * Sets the modified date of this ec member request.
	 *
	 * @param modifiedDate the modified date of this ec member request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID copy ID of this ec member request.
	 *
	 * @param nationalIdCopyId the national ID copy ID of this ec member request
	 */
	@Override
	public void setNationalIdCopyId(long nationalIdCopyId) {
		model.setNationalIdCopyId(nationalIdCopyId);
	}

	/**
	 * Sets the no objection letter ID of this ec member request.
	 *
	 * @param noObjectionLetterId the no objection letter ID of this ec member request
	 */
	@Override
	public void setNoObjectionLetterId(long noObjectionLetterId) {
		model.setNoObjectionLetterId(noObjectionLetterId);
	}

	/**
	 * Sets the passport copy ID of this ec member request.
	 *
	 * @param passportCopyId the passport copy ID of this ec member request
	 */
	@Override
	public void setPassportCopyId(long passportCopyId) {
		model.setPassportCopyId(passportCopyId);
	}

	/**
	 * Sets the potential ec member ID of this ec member request.
	 *
	 * @param potentialEcMemberId the potential ec member ID of this ec member request
	 */
	@Override
	public void setPotentialEcMemberId(long potentialEcMemberId) {
		model.setPotentialEcMemberId(potentialEcMemberId);
	}

	/**
	 * Sets the potential ec member lruserid of this ec member request.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid of this ec member request
	 */
	@Override
	public void setPotentialEcMemberLruserid(long potentialEcMemberLruserid) {
		model.setPotentialEcMemberLruserid(potentialEcMemberLruserid);
	}

	/**
	 * Sets the potential ec member role ID of this ec member request.
	 *
	 * @param potentialEcMemberRoleId the potential ec member role ID of this ec member request
	 */
	@Override
	public void setPotentialEcMemberRoleId(long potentialEcMemberRoleId) {
		model.setPotentialEcMemberRoleId(potentialEcMemberRoleId);
	}

	/**
	 * Sets the primary key of this ec member request.
	 *
	 * @param primaryKey the primary key of this ec member request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ID of this ec member request.
	 *
	 * @param programId the program ID of this ec member request
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the qarar doc ID of this ec member request.
	 *
	 * @param qararDocId the qarar doc ID of this ec member request
	 */
	@Override
	public void setQararDocId(long qararDocId) {
		model.setQararDocId(qararDocId);
	}

	/**
	 * Sets the qarar request ID of this ec member request.
	 *
	 * @param qararRequestId the qarar request ID of this ec member request
	 */
	@Override
	public void setQararRequestId(long qararRequestId) {
		model.setQararRequestId(qararRequestId);
	}

	/**
	 * Sets the status of this ec member request.
	 *
	 * @param status the status of this ec member request
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this ec member request.
	 *
	 * @param statusByUserId the status by user ID of this ec member request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this ec member request.
	 *
	 * @param statusByUserName the status by user name of this ec member request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this ec member request.
	 *
	 * @param statusByUserUuid the status by user uuid of this ec member request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this ec member request.
	 *
	 * @param statusDate the status date of this ec member request
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this ec member request.
	 *
	 * @param userId the user ID of this ec member request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ec member request.
	 *
	 * @param userName the user name of this ec member request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ec member request.
	 *
	 * @param userUuid the user uuid of this ec member request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ec member request.
	 *
	 * @param uuid the uuid of this ec member request
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
	protected EcMemberRequestWrapper wrap(EcMemberRequest ecMemberRequest) {
		return new EcMemberRequestWrapper(ecMemberRequest);
	}

}