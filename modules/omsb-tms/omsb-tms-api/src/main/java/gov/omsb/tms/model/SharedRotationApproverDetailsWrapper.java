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
 * This class is a wrapper for {@link SharedRotationApproverDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetails
 * @generated
 */
public class SharedRotationApproverDetailsWrapper
	extends BaseModelWrapper<SharedRotationApproverDetails>
	implements ModelWrapper<SharedRotationApproverDetails>,
			   SharedRotationApproverDetails {

	public SharedRotationApproverDetailsWrapper(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		super(sharedRotationApproverDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"sharedRotationApproverDetailsId",
			getSharedRotationApproverDetailsId());
		attributes.put(
			"sharedRotationRequestDetailsId",
			getSharedRotationRequestDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("status", getStatus());
		attributes.put("approvedTrainees", getApprovedTrainees());
		attributes.put("rejectedTrainees", getRejectedTrainees());
		attributes.put("approversComment", getApproversComment());
		attributes.put("decisionMakingDate", getDecisionMakingDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sharedRotationApproverDetailsId = (Long)attributes.get(
			"sharedRotationApproverDetailsId");

		if (sharedRotationApproverDetailsId != null) {
			setSharedRotationApproverDetailsId(sharedRotationApproverDetailsId);
		}

		Long sharedRotationRequestDetailsId = (Long)attributes.get(
			"sharedRotationRequestDetailsId");

		if (sharedRotationRequestDetailsId != null) {
			setSharedRotationRequestDetailsId(sharedRotationRequestDetailsId);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long approvedTrainees = (Long)attributes.get("approvedTrainees");

		if (approvedTrainees != null) {
			setApprovedTrainees(approvedTrainees);
		}

		Long rejectedTrainees = (Long)attributes.get("rejectedTrainees");

		if (rejectedTrainees != null) {
			setRejectedTrainees(rejectedTrainees);
		}

		String approversComment = (String)attributes.get("approversComment");

		if (approversComment != null) {
			setApproversComment(approversComment);
		}

		Date decisionMakingDate = (Date)attributes.get("decisionMakingDate");

		if (decisionMakingDate != null) {
			setDecisionMakingDate(decisionMakingDate);
		}
	}

	@Override
	public SharedRotationApproverDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the approved trainees of this shared rotation approver details.
	 *
	 * @return the approved trainees of this shared rotation approver details
	 */
	@Override
	public long getApprovedTrainees() {
		return model.getApprovedTrainees();
	}

	/**
	 * Returns the approvers comment of this shared rotation approver details.
	 *
	 * @return the approvers comment of this shared rotation approver details
	 */
	@Override
	public String getApproversComment() {
		return model.getApproversComment();
	}

	/**
	 * Returns the localized approvers comment of this shared rotation approver details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized approvers comment of this shared rotation approver details
	 */
	@Override
	public String getApproversComment(java.util.Locale locale) {
		return model.getApproversComment(locale);
	}

	/**
	 * Returns the localized approvers comment of this shared rotation approver details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized approvers comment of this shared rotation approver details. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getApproversComment(
		java.util.Locale locale, boolean useDefault) {

		return model.getApproversComment(locale, useDefault);
	}

	/**
	 * Returns the localized approvers comment of this shared rotation approver details in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized approvers comment of this shared rotation approver details
	 */
	@Override
	public String getApproversComment(String languageId) {
		return model.getApproversComment(languageId);
	}

	/**
	 * Returns the localized approvers comment of this shared rotation approver details in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized approvers comment of this shared rotation approver details
	 */
	@Override
	public String getApproversComment(String languageId, boolean useDefault) {
		return model.getApproversComment(languageId, useDefault);
	}

	@Override
	public String getApproversCommentCurrentLanguageId() {
		return model.getApproversCommentCurrentLanguageId();
	}

	@Override
	public String getApproversCommentCurrentValue() {
		return model.getApproversCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized approvers comments of this shared rotation approver details.
	 *
	 * @return the locales and localized approvers comments of this shared rotation approver details
	 */
	@Override
	public Map<java.util.Locale, String> getApproversCommentMap() {
		return model.getApproversCommentMap();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this shared rotation approver details.
	 *
	 * @return the company ID of this shared rotation approver details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this shared rotation approver details.
	 *
	 * @return the create date of this shared rotation approver details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this shared rotation approver details.
	 *
	 * @return the created by of this shared rotation approver details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the decision making date of this shared rotation approver details.
	 *
	 * @return the decision making date of this shared rotation approver details
	 */
	@Override
	public Date getDecisionMakingDate() {
		return model.getDecisionMakingDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the group ID of this shared rotation approver details.
	 *
	 * @return the group ID of this shared rotation approver details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this shared rotation approver details.
	 *
	 * @return the modified by of this shared rotation approver details
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this shared rotation approver details.
	 *
	 * @return the modified date of this shared rotation approver details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this shared rotation approver details.
	 *
	 * @return the primary key of this shared rotation approver details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rejected trainees of this shared rotation approver details.
	 *
	 * @return the rejected trainees of this shared rotation approver details
	 */
	@Override
	public long getRejectedTrainees() {
		return model.getRejectedTrainees();
	}

	/**
	 * Returns the shared rotation approver details ID of this shared rotation approver details.
	 *
	 * @return the shared rotation approver details ID of this shared rotation approver details
	 */
	@Override
	public long getSharedRotationApproverDetailsId() {
		return model.getSharedRotationApproverDetailsId();
	}

	/**
	 * Returns the shared rotation request details ID of this shared rotation approver details.
	 *
	 * @return the shared rotation request details ID of this shared rotation approver details
	 */
	@Override
	public long getSharedRotationRequestDetailsId() {
		return model.getSharedRotationRequestDetailsId();
	}

	/**
	 * Returns the status of this shared rotation approver details.
	 *
	 * @return the status of this shared rotation approver details
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this shared rotation approver details.
	 *
	 * @return the uuid of this shared rotation approver details
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
	 * Sets the approved trainees of this shared rotation approver details.
	 *
	 * @param approvedTrainees the approved trainees of this shared rotation approver details
	 */
	@Override
	public void setApprovedTrainees(long approvedTrainees) {
		model.setApprovedTrainees(approvedTrainees);
	}

	/**
	 * Sets the approvers comment of this shared rotation approver details.
	 *
	 * @param approversComment the approvers comment of this shared rotation approver details
	 */
	@Override
	public void setApproversComment(String approversComment) {
		model.setApproversComment(approversComment);
	}

	/**
	 * Sets the localized approvers comment of this shared rotation approver details in the language.
	 *
	 * @param approversComment the localized approvers comment of this shared rotation approver details
	 * @param locale the locale of the language
	 */
	@Override
	public void setApproversComment(
		String approversComment, java.util.Locale locale) {

		model.setApproversComment(approversComment, locale);
	}

	/**
	 * Sets the localized approvers comment of this shared rotation approver details in the language, and sets the default locale.
	 *
	 * @param approversComment the localized approvers comment of this shared rotation approver details
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setApproversComment(
		String approversComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setApproversComment(approversComment, locale, defaultLocale);
	}

	@Override
	public void setApproversCommentCurrentLanguageId(String languageId) {
		model.setApproversCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized approvers comments of this shared rotation approver details from the map of locales and localized approvers comments.
	 *
	 * @param approversCommentMap the locales and localized approvers comments of this shared rotation approver details
	 */
	@Override
	public void setApproversCommentMap(
		Map<java.util.Locale, String> approversCommentMap) {

		model.setApproversCommentMap(approversCommentMap);
	}

	/**
	 * Sets the localized approvers comments of this shared rotation approver details from the map of locales and localized approvers comments, and sets the default locale.
	 *
	 * @param approversCommentMap the locales and localized approvers comments of this shared rotation approver details
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setApproversCommentMap(
		Map<java.util.Locale, String> approversCommentMap,
		java.util.Locale defaultLocale) {

		model.setApproversCommentMap(approversCommentMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this shared rotation approver details.
	 *
	 * @param companyId the company ID of this shared rotation approver details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this shared rotation approver details.
	 *
	 * @param createDate the create date of this shared rotation approver details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this shared rotation approver details.
	 *
	 * @param createdBy the created by of this shared rotation approver details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the decision making date of this shared rotation approver details.
	 *
	 * @param decisionMakingDate the decision making date of this shared rotation approver details
	 */
	@Override
	public void setDecisionMakingDate(Date decisionMakingDate) {
		model.setDecisionMakingDate(decisionMakingDate);
	}

	/**
	 * Sets the group ID of this shared rotation approver details.
	 *
	 * @param groupId the group ID of this shared rotation approver details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this shared rotation approver details.
	 *
	 * @param modifiedBy the modified by of this shared rotation approver details
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this shared rotation approver details.
	 *
	 * @param modifiedDate the modified date of this shared rotation approver details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this shared rotation approver details.
	 *
	 * @param primaryKey the primary key of this shared rotation approver details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rejected trainees of this shared rotation approver details.
	 *
	 * @param rejectedTrainees the rejected trainees of this shared rotation approver details
	 */
	@Override
	public void setRejectedTrainees(long rejectedTrainees) {
		model.setRejectedTrainees(rejectedTrainees);
	}

	/**
	 * Sets the shared rotation approver details ID of this shared rotation approver details.
	 *
	 * @param sharedRotationApproverDetailsId the shared rotation approver details ID of this shared rotation approver details
	 */
	@Override
	public void setSharedRotationApproverDetailsId(
		long sharedRotationApproverDetailsId) {

		model.setSharedRotationApproverDetailsId(
			sharedRotationApproverDetailsId);
	}

	/**
	 * Sets the shared rotation request details ID of this shared rotation approver details.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID of this shared rotation approver details
	 */
	@Override
	public void setSharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId) {

		model.setSharedRotationRequestDetailsId(sharedRotationRequestDetailsId);
	}

	/**
	 * Sets the status of this shared rotation approver details.
	 *
	 * @param status the status of this shared rotation approver details
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this shared rotation approver details.
	 *
	 * @param uuid the uuid of this shared rotation approver details
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
	protected SharedRotationApproverDetailsWrapper wrap(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		return new SharedRotationApproverDetailsWrapper(
			sharedRotationApproverDetails);
	}

}