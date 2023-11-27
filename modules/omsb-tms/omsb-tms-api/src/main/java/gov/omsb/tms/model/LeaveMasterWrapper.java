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
 * This class is a wrapper for {@link LeaveMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMaster
 * @generated
 */
public class LeaveMasterWrapper
	extends BaseModelWrapper<LeaveMaster>
	implements LeaveMaster, ModelWrapper<LeaveMaster> {

	public LeaveMasterWrapper(LeaveMaster leaveMaster) {
		super(leaveMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveMasterId", getLeaveMasterId());
		attributes.put("traineeId", getTraineeId());
		attributes.put("leaveTypeId", getLeaveTypeId());
		attributes.put("leaveTraineeId", getLeaveTraineeId());
		attributes.put("blockName", getBlockName());
		attributes.put("leaveFrom", getLeaveFrom());
		attributes.put("leaveTo", getLeaveTo());
		attributes.put("noOfDays", getNoOfDays());
		attributes.put("contactName", getContactName());
		attributes.put("contactEmail", getContactEmail());
		attributes.put("contactNo", getContactNo());
		attributes.put("reasonForLeave", getReasonForLeave());
		attributes.put("applicationDate", getApplicationDate());
		attributes.put("returnFromLeave", getReturnFromLeave());
		attributes.put("reasonForDelay", getReasonForDelay());
		attributes.put("programId", getProgramId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long leaveMasterId = (Long)attributes.get("leaveMasterId");

		if (leaveMasterId != null) {
			setLeaveMasterId(leaveMasterId);
		}

		Long traineeId = (Long)attributes.get("traineeId");

		if (traineeId != null) {
			setTraineeId(traineeId);
		}

		Long leaveTypeId = (Long)attributes.get("leaveTypeId");

		if (leaveTypeId != null) {
			setLeaveTypeId(leaveTypeId);
		}

		Long leaveTraineeId = (Long)attributes.get("leaveTraineeId");

		if (leaveTraineeId != null) {
			setLeaveTraineeId(leaveTraineeId);
		}

		String blockName = (String)attributes.get("blockName");

		if (blockName != null) {
			setBlockName(blockName);
		}

		Date leaveFrom = (Date)attributes.get("leaveFrom");

		if (leaveFrom != null) {
			setLeaveFrom(leaveFrom);
		}

		Date leaveTo = (Date)attributes.get("leaveTo");

		if (leaveTo != null) {
			setLeaveTo(leaveTo);
		}

		Integer noOfDays = (Integer)attributes.get("noOfDays");

		if (noOfDays != null) {
			setNoOfDays(noOfDays);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String contactEmail = (String)attributes.get("contactEmail");

		if (contactEmail != null) {
			setContactEmail(contactEmail);
		}

		String contactNo = (String)attributes.get("contactNo");

		if (contactNo != null) {
			setContactNo(contactNo);
		}

		String reasonForLeave = (String)attributes.get("reasonForLeave");

		if (reasonForLeave != null) {
			setReasonForLeave(reasonForLeave);
		}

		Date applicationDate = (Date)attributes.get("applicationDate");

		if (applicationDate != null) {
			setApplicationDate(applicationDate);
		}

		Date returnFromLeave = (Date)attributes.get("returnFromLeave");

		if (returnFromLeave != null) {
			setReturnFromLeave(returnFromLeave);
		}

		String reasonForDelay = (String)attributes.get("reasonForDelay");

		if (reasonForDelay != null) {
			setReasonForDelay(reasonForDelay);
		}

		Long programId = (Long)attributes.get("programId");

		if (programId != null) {
			setProgramId(programId);
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
	}

	@Override
	public LeaveMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application date of this leave master.
	 *
	 * @return the application date of this leave master
	 */
	@Override
	public Date getApplicationDate() {
		return model.getApplicationDate();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the block name of this leave master.
	 *
	 * @return the block name of this leave master
	 */
	@Override
	public String getBlockName() {
		return model.getBlockName();
	}

	/**
	 * Returns the localized block name of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized block name of this leave master
	 */
	@Override
	public String getBlockName(java.util.Locale locale) {
		return model.getBlockName(locale);
	}

	/**
	 * Returns the localized block name of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized block name of this leave master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBlockName(java.util.Locale locale, boolean useDefault) {
		return model.getBlockName(locale, useDefault);
	}

	/**
	 * Returns the localized block name of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized block name of this leave master
	 */
	@Override
	public String getBlockName(String languageId) {
		return model.getBlockName(languageId);
	}

	/**
	 * Returns the localized block name of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized block name of this leave master
	 */
	@Override
	public String getBlockName(String languageId, boolean useDefault) {
		return model.getBlockName(languageId, useDefault);
	}

	@Override
	public String getBlockNameCurrentLanguageId() {
		return model.getBlockNameCurrentLanguageId();
	}

	@Override
	public String getBlockNameCurrentValue() {
		return model.getBlockNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized block names of this leave master.
	 *
	 * @return the locales and localized block names of this leave master
	 */
	@Override
	public Map<java.util.Locale, String> getBlockNameMap() {
		return model.getBlockNameMap();
	}

	/**
	 * Returns the company ID of this leave master.
	 *
	 * @return the company ID of this leave master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact email of this leave master.
	 *
	 * @return the contact email of this leave master
	 */
	@Override
	public String getContactEmail() {
		return model.getContactEmail();
	}

	/**
	 * Returns the contact name of this leave master.
	 *
	 * @return the contact name of this leave master
	 */
	@Override
	public String getContactName() {
		return model.getContactName();
	}

	/**
	 * Returns the localized contact name of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized contact name of this leave master
	 */
	@Override
	public String getContactName(java.util.Locale locale) {
		return model.getContactName(locale);
	}

	/**
	 * Returns the localized contact name of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact name of this leave master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContactName(java.util.Locale locale, boolean useDefault) {
		return model.getContactName(locale, useDefault);
	}

	/**
	 * Returns the localized contact name of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized contact name of this leave master
	 */
	@Override
	public String getContactName(String languageId) {
		return model.getContactName(languageId);
	}

	/**
	 * Returns the localized contact name of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact name of this leave master
	 */
	@Override
	public String getContactName(String languageId, boolean useDefault) {
		return model.getContactName(languageId, useDefault);
	}

	@Override
	public String getContactNameCurrentLanguageId() {
		return model.getContactNameCurrentLanguageId();
	}

	@Override
	public String getContactNameCurrentValue() {
		return model.getContactNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contact names of this leave master.
	 *
	 * @return the locales and localized contact names of this leave master
	 */
	@Override
	public Map<java.util.Locale, String> getContactNameMap() {
		return model.getContactNameMap();
	}

	/**
	 * Returns the contact no of this leave master.
	 *
	 * @return the contact no of this leave master
	 */
	@Override
	public String getContactNo() {
		return model.getContactNo();
	}

	/**
	 * Returns the create date of this leave master.
	 *
	 * @return the create date of this leave master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave master.
	 *
	 * @return the created by of this leave master
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
	 * Returns the group ID of this leave master.
	 *
	 * @return the group ID of this leave master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave from of this leave master.
	 *
	 * @return the leave from of this leave master
	 */
	@Override
	public Date getLeaveFrom() {
		return model.getLeaveFrom();
	}

	/**
	 * Returns the leave master ID of this leave master.
	 *
	 * @return the leave master ID of this leave master
	 */
	@Override
	public long getLeaveMasterId() {
		return model.getLeaveMasterId();
	}

	/**
	 * Returns the leave to of this leave master.
	 *
	 * @return the leave to of this leave master
	 */
	@Override
	public Date getLeaveTo() {
		return model.getLeaveTo();
	}

	/**
	 * Returns the leave trainee ID of this leave master.
	 *
	 * @return the leave trainee ID of this leave master
	 */
	@Override
	public long getLeaveTraineeId() {
		return model.getLeaveTraineeId();
	}

	/**
	 * Returns the leave type ID of this leave master.
	 *
	 * @return the leave type ID of this leave master
	 */
	@Override
	public long getLeaveTypeId() {
		return model.getLeaveTypeId();
	}

	/**
	 * Returns the modified by of this leave master.
	 *
	 * @return the modified by of this leave master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave master.
	 *
	 * @return the modified date of this leave master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no of days of this leave master.
	 *
	 * @return the no of days of this leave master
	 */
	@Override
	public int getNoOfDays() {
		return model.getNoOfDays();
	}

	/**
	 * Returns the primary key of this leave master.
	 *
	 * @return the primary key of this leave master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program ID of this leave master.
	 *
	 * @return the program ID of this leave master
	 */
	@Override
	public long getProgramId() {
		return model.getProgramId();
	}

	/**
	 * Returns the reason for delay of this leave master.
	 *
	 * @return the reason for delay of this leave master
	 */
	@Override
	public String getReasonForDelay() {
		return model.getReasonForDelay();
	}

	/**
	 * Returns the localized reason for delay of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized reason for delay of this leave master
	 */
	@Override
	public String getReasonForDelay(java.util.Locale locale) {
		return model.getReasonForDelay(locale);
	}

	/**
	 * Returns the localized reason for delay of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized reason for delay of this leave master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getReasonForDelay(
		java.util.Locale locale, boolean useDefault) {

		return model.getReasonForDelay(locale, useDefault);
	}

	/**
	 * Returns the localized reason for delay of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized reason for delay of this leave master
	 */
	@Override
	public String getReasonForDelay(String languageId) {
		return model.getReasonForDelay(languageId);
	}

	/**
	 * Returns the localized reason for delay of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized reason for delay of this leave master
	 */
	@Override
	public String getReasonForDelay(String languageId, boolean useDefault) {
		return model.getReasonForDelay(languageId, useDefault);
	}

	@Override
	public String getReasonForDelayCurrentLanguageId() {
		return model.getReasonForDelayCurrentLanguageId();
	}

	@Override
	public String getReasonForDelayCurrentValue() {
		return model.getReasonForDelayCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized reason for delays of this leave master.
	 *
	 * @return the locales and localized reason for delays of this leave master
	 */
	@Override
	public Map<java.util.Locale, String> getReasonForDelayMap() {
		return model.getReasonForDelayMap();
	}

	/**
	 * Returns the reason for leave of this leave master.
	 *
	 * @return the reason for leave of this leave master
	 */
	@Override
	public String getReasonForLeave() {
		return model.getReasonForLeave();
	}

	/**
	 * Returns the localized reason for leave of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized reason for leave of this leave master
	 */
	@Override
	public String getReasonForLeave(java.util.Locale locale) {
		return model.getReasonForLeave(locale);
	}

	/**
	 * Returns the localized reason for leave of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized reason for leave of this leave master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getReasonForLeave(
		java.util.Locale locale, boolean useDefault) {

		return model.getReasonForLeave(locale, useDefault);
	}

	/**
	 * Returns the localized reason for leave of this leave master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized reason for leave of this leave master
	 */
	@Override
	public String getReasonForLeave(String languageId) {
		return model.getReasonForLeave(languageId);
	}

	/**
	 * Returns the localized reason for leave of this leave master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized reason for leave of this leave master
	 */
	@Override
	public String getReasonForLeave(String languageId, boolean useDefault) {
		return model.getReasonForLeave(languageId, useDefault);
	}

	@Override
	public String getReasonForLeaveCurrentLanguageId() {
		return model.getReasonForLeaveCurrentLanguageId();
	}

	@Override
	public String getReasonForLeaveCurrentValue() {
		return model.getReasonForLeaveCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized reason for leaves of this leave master.
	 *
	 * @return the locales and localized reason for leaves of this leave master
	 */
	@Override
	public Map<java.util.Locale, String> getReasonForLeaveMap() {
		return model.getReasonForLeaveMap();
	}

	/**
	 * Returns the return from leave of this leave master.
	 *
	 * @return the return from leave of this leave master
	 */
	@Override
	public Date getReturnFromLeave() {
		return model.getReturnFromLeave();
	}

	/**
	 * Returns the status of this leave master.
	 *
	 * @return the status of this leave master
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this leave master.
	 *
	 * @return the status by user ID of this leave master
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this leave master.
	 *
	 * @return the status by user name of this leave master
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this leave master.
	 *
	 * @return the status by user uuid of this leave master
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this leave master.
	 *
	 * @return the status date of this leave master
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trainee ID of this leave master.
	 *
	 * @return the trainee ID of this leave master
	 */
	@Override
	public long getTraineeId() {
		return model.getTraineeId();
	}

	/**
	 * Returns the uuid of this leave master.
	 *
	 * @return the uuid of this leave master
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this leave master is approved.
	 *
	 * @return <code>true</code> if this leave master is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this leave master is denied.
	 *
	 * @return <code>true</code> if this leave master is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this leave master is a draft.
	 *
	 * @return <code>true</code> if this leave master is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this leave master is expired.
	 *
	 * @return <code>true</code> if this leave master is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this leave master is inactive.
	 *
	 * @return <code>true</code> if this leave master is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this leave master is incomplete.
	 *
	 * @return <code>true</code> if this leave master is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this leave master is pending.
	 *
	 * @return <code>true</code> if this leave master is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this leave master is scheduled.
	 *
	 * @return <code>true</code> if this leave master is scheduled; <code>false</code> otherwise
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
	 * Sets the application date of this leave master.
	 *
	 * @param applicationDate the application date of this leave master
	 */
	@Override
	public void setApplicationDate(Date applicationDate) {
		model.setApplicationDate(applicationDate);
	}

	/**
	 * Sets the block name of this leave master.
	 *
	 * @param blockName the block name of this leave master
	 */
	@Override
	public void setBlockName(String blockName) {
		model.setBlockName(blockName);
	}

	/**
	 * Sets the localized block name of this leave master in the language.
	 *
	 * @param blockName the localized block name of this leave master
	 * @param locale the locale of the language
	 */
	@Override
	public void setBlockName(String blockName, java.util.Locale locale) {
		model.setBlockName(blockName, locale);
	}

	/**
	 * Sets the localized block name of this leave master in the language, and sets the default locale.
	 *
	 * @param blockName the localized block name of this leave master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBlockName(
		String blockName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBlockName(blockName, locale, defaultLocale);
	}

	@Override
	public void setBlockNameCurrentLanguageId(String languageId) {
		model.setBlockNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized block names of this leave master from the map of locales and localized block names.
	 *
	 * @param blockNameMap the locales and localized block names of this leave master
	 */
	@Override
	public void setBlockNameMap(Map<java.util.Locale, String> blockNameMap) {
		model.setBlockNameMap(blockNameMap);
	}

	/**
	 * Sets the localized block names of this leave master from the map of locales and localized block names, and sets the default locale.
	 *
	 * @param blockNameMap the locales and localized block names of this leave master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBlockNameMap(
		Map<java.util.Locale, String> blockNameMap,
		java.util.Locale defaultLocale) {

		model.setBlockNameMap(blockNameMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this leave master.
	 *
	 * @param companyId the company ID of this leave master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact email of this leave master.
	 *
	 * @param contactEmail the contact email of this leave master
	 */
	@Override
	public void setContactEmail(String contactEmail) {
		model.setContactEmail(contactEmail);
	}

	/**
	 * Sets the contact name of this leave master.
	 *
	 * @param contactName the contact name of this leave master
	 */
	@Override
	public void setContactName(String contactName) {
		model.setContactName(contactName);
	}

	/**
	 * Sets the localized contact name of this leave master in the language.
	 *
	 * @param contactName the localized contact name of this leave master
	 * @param locale the locale of the language
	 */
	@Override
	public void setContactName(String contactName, java.util.Locale locale) {
		model.setContactName(contactName, locale);
	}

	/**
	 * Sets the localized contact name of this leave master in the language, and sets the default locale.
	 *
	 * @param contactName the localized contact name of this leave master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContactName(
		String contactName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContactName(contactName, locale, defaultLocale);
	}

	@Override
	public void setContactNameCurrentLanguageId(String languageId) {
		model.setContactNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contact names of this leave master from the map of locales and localized contact names.
	 *
	 * @param contactNameMap the locales and localized contact names of this leave master
	 */
	@Override
	public void setContactNameMap(
		Map<java.util.Locale, String> contactNameMap) {

		model.setContactNameMap(contactNameMap);
	}

	/**
	 * Sets the localized contact names of this leave master from the map of locales and localized contact names, and sets the default locale.
	 *
	 * @param contactNameMap the locales and localized contact names of this leave master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContactNameMap(
		Map<java.util.Locale, String> contactNameMap,
		java.util.Locale defaultLocale) {

		model.setContactNameMap(contactNameMap, defaultLocale);
	}

	/**
	 * Sets the contact no of this leave master.
	 *
	 * @param contactNo the contact no of this leave master
	 */
	@Override
	public void setContactNo(String contactNo) {
		model.setContactNo(contactNo);
	}

	/**
	 * Sets the create date of this leave master.
	 *
	 * @param createDate the create date of this leave master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave master.
	 *
	 * @param createdBy the created by of this leave master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave master.
	 *
	 * @param groupId the group ID of this leave master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave from of this leave master.
	 *
	 * @param leaveFrom the leave from of this leave master
	 */
	@Override
	public void setLeaveFrom(Date leaveFrom) {
		model.setLeaveFrom(leaveFrom);
	}

	/**
	 * Sets the leave master ID of this leave master.
	 *
	 * @param leaveMasterId the leave master ID of this leave master
	 */
	@Override
	public void setLeaveMasterId(long leaveMasterId) {
		model.setLeaveMasterId(leaveMasterId);
	}

	/**
	 * Sets the leave to of this leave master.
	 *
	 * @param leaveTo the leave to of this leave master
	 */
	@Override
	public void setLeaveTo(Date leaveTo) {
		model.setLeaveTo(leaveTo);
	}

	/**
	 * Sets the leave trainee ID of this leave master.
	 *
	 * @param leaveTraineeId the leave trainee ID of this leave master
	 */
	@Override
	public void setLeaveTraineeId(long leaveTraineeId) {
		model.setLeaveTraineeId(leaveTraineeId);
	}

	/**
	 * Sets the leave type ID of this leave master.
	 *
	 * @param leaveTypeId the leave type ID of this leave master
	 */
	@Override
	public void setLeaveTypeId(long leaveTypeId) {
		model.setLeaveTypeId(leaveTypeId);
	}

	/**
	 * Sets the modified by of this leave master.
	 *
	 * @param modifiedBy the modified by of this leave master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave master.
	 *
	 * @param modifiedDate the modified date of this leave master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no of days of this leave master.
	 *
	 * @param noOfDays the no of days of this leave master
	 */
	@Override
	public void setNoOfDays(int noOfDays) {
		model.setNoOfDays(noOfDays);
	}

	/**
	 * Sets the primary key of this leave master.
	 *
	 * @param primaryKey the primary key of this leave master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program ID of this leave master.
	 *
	 * @param programId the program ID of this leave master
	 */
	@Override
	public void setProgramId(long programId) {
		model.setProgramId(programId);
	}

	/**
	 * Sets the reason for delay of this leave master.
	 *
	 * @param reasonForDelay the reason for delay of this leave master
	 */
	@Override
	public void setReasonForDelay(String reasonForDelay) {
		model.setReasonForDelay(reasonForDelay);
	}

	/**
	 * Sets the localized reason for delay of this leave master in the language.
	 *
	 * @param reasonForDelay the localized reason for delay of this leave master
	 * @param locale the locale of the language
	 */
	@Override
	public void setReasonForDelay(
		String reasonForDelay, java.util.Locale locale) {

		model.setReasonForDelay(reasonForDelay, locale);
	}

	/**
	 * Sets the localized reason for delay of this leave master in the language, and sets the default locale.
	 *
	 * @param reasonForDelay the localized reason for delay of this leave master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setReasonForDelay(
		String reasonForDelay, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setReasonForDelay(reasonForDelay, locale, defaultLocale);
	}

	@Override
	public void setReasonForDelayCurrentLanguageId(String languageId) {
		model.setReasonForDelayCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized reason for delays of this leave master from the map of locales and localized reason for delays.
	 *
	 * @param reasonForDelayMap the locales and localized reason for delays of this leave master
	 */
	@Override
	public void setReasonForDelayMap(
		Map<java.util.Locale, String> reasonForDelayMap) {

		model.setReasonForDelayMap(reasonForDelayMap);
	}

	/**
	 * Sets the localized reason for delays of this leave master from the map of locales and localized reason for delays, and sets the default locale.
	 *
	 * @param reasonForDelayMap the locales and localized reason for delays of this leave master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setReasonForDelayMap(
		Map<java.util.Locale, String> reasonForDelayMap,
		java.util.Locale defaultLocale) {

		model.setReasonForDelayMap(reasonForDelayMap, defaultLocale);
	}

	/**
	 * Sets the reason for leave of this leave master.
	 *
	 * @param reasonForLeave the reason for leave of this leave master
	 */
	@Override
	public void setReasonForLeave(String reasonForLeave) {
		model.setReasonForLeave(reasonForLeave);
	}

	/**
	 * Sets the localized reason for leave of this leave master in the language.
	 *
	 * @param reasonForLeave the localized reason for leave of this leave master
	 * @param locale the locale of the language
	 */
	@Override
	public void setReasonForLeave(
		String reasonForLeave, java.util.Locale locale) {

		model.setReasonForLeave(reasonForLeave, locale);
	}

	/**
	 * Sets the localized reason for leave of this leave master in the language, and sets the default locale.
	 *
	 * @param reasonForLeave the localized reason for leave of this leave master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setReasonForLeave(
		String reasonForLeave, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setReasonForLeave(reasonForLeave, locale, defaultLocale);
	}

	@Override
	public void setReasonForLeaveCurrentLanguageId(String languageId) {
		model.setReasonForLeaveCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized reason for leaves of this leave master from the map of locales and localized reason for leaves.
	 *
	 * @param reasonForLeaveMap the locales and localized reason for leaves of this leave master
	 */
	@Override
	public void setReasonForLeaveMap(
		Map<java.util.Locale, String> reasonForLeaveMap) {

		model.setReasonForLeaveMap(reasonForLeaveMap);
	}

	/**
	 * Sets the localized reason for leaves of this leave master from the map of locales and localized reason for leaves, and sets the default locale.
	 *
	 * @param reasonForLeaveMap the locales and localized reason for leaves of this leave master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setReasonForLeaveMap(
		Map<java.util.Locale, String> reasonForLeaveMap,
		java.util.Locale defaultLocale) {

		model.setReasonForLeaveMap(reasonForLeaveMap, defaultLocale);
	}

	/**
	 * Sets the return from leave of this leave master.
	 *
	 * @param returnFromLeave the return from leave of this leave master
	 */
	@Override
	public void setReturnFromLeave(Date returnFromLeave) {
		model.setReturnFromLeave(returnFromLeave);
	}

	/**
	 * Sets the status of this leave master.
	 *
	 * @param status the status of this leave master
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this leave master.
	 *
	 * @param statusByUserId the status by user ID of this leave master
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this leave master.
	 *
	 * @param statusByUserName the status by user name of this leave master
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this leave master.
	 *
	 * @param statusByUserUuid the status by user uuid of this leave master
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this leave master.
	 *
	 * @param statusDate the status date of this leave master
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trainee ID of this leave master.
	 *
	 * @param traineeId the trainee ID of this leave master
	 */
	@Override
	public void setTraineeId(long traineeId) {
		model.setTraineeId(traineeId);
	}

	/**
	 * Sets the uuid of this leave master.
	 *
	 * @param uuid the uuid of this leave master
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
	protected LeaveMasterWrapper wrap(LeaveMaster leaveMaster) {
		return new LeaveMasterWrapper(leaveMaster);
	}

}