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
 * This class is a wrapper for {@link RoleTypeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMaster
 * @generated
 */
public class RoleTypeMasterWrapper
	extends BaseModelWrapper<RoleTypeMaster>
	implements ModelWrapper<RoleTypeMaster>, RoleTypeMaster {

	public RoleTypeMasterWrapper(RoleTypeMaster roleTypeMaster) {
		super(roleTypeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("roleTypeMasterId", getRoleTypeMasterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("roleTypeName", getRoleTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long roleTypeMasterId = (Long)attributes.get("roleTypeMasterId");

		if (roleTypeMasterId != null) {
			setRoleTypeMasterId(roleTypeMasterId);
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

		String roleTypeName = (String)attributes.get("roleTypeName");

		if (roleTypeName != null) {
			setRoleTypeName(roleTypeName);
		}
	}

	@Override
	public RoleTypeMaster cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this role type master.
	 *
	 * @return the company ID of this role type master
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this role type master.
	 *
	 * @return the create date of this role type master
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this role type master.
	 *
	 * @return the created by of this role type master
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
	 * Returns the group ID of this role type master.
	 *
	 * @return the group ID of this role type master
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this role type master.
	 *
	 * @return the modified by of this role type master
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this role type master.
	 *
	 * @return the modified date of this role type master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this role type master.
	 *
	 * @return the primary key of this role type master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role type master ID of this role type master.
	 *
	 * @return the role type master ID of this role type master
	 */
	@Override
	public long getRoleTypeMasterId() {
		return model.getRoleTypeMasterId();
	}

	/**
	 * Returns the role type name of this role type master.
	 *
	 * @return the role type name of this role type master
	 */
	@Override
	public String getRoleTypeName() {
		return model.getRoleTypeName();
	}

	/**
	 * Returns the localized role type name of this role type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized role type name of this role type master
	 */
	@Override
	public String getRoleTypeName(java.util.Locale locale) {
		return model.getRoleTypeName(locale);
	}

	/**
	 * Returns the localized role type name of this role type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized role type name of this role type master. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getRoleTypeName(java.util.Locale locale, boolean useDefault) {
		return model.getRoleTypeName(locale, useDefault);
	}

	/**
	 * Returns the localized role type name of this role type master in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized role type name of this role type master
	 */
	@Override
	public String getRoleTypeName(String languageId) {
		return model.getRoleTypeName(languageId);
	}

	/**
	 * Returns the localized role type name of this role type master in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized role type name of this role type master
	 */
	@Override
	public String getRoleTypeName(String languageId, boolean useDefault) {
		return model.getRoleTypeName(languageId, useDefault);
	}

	@Override
	public String getRoleTypeNameCurrentLanguageId() {
		return model.getRoleTypeNameCurrentLanguageId();
	}

	@Override
	public String getRoleTypeNameCurrentValue() {
		return model.getRoleTypeNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized role type names of this role type master.
	 *
	 * @return the locales and localized role type names of this role type master
	 */
	@Override
	public Map<java.util.Locale, String> getRoleTypeNameMap() {
		return model.getRoleTypeNameMap();
	}

	/**
	 * Returns the uuid of this role type master.
	 *
	 * @return the uuid of this role type master
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
	 * Sets the company ID of this role type master.
	 *
	 * @param companyId the company ID of this role type master
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this role type master.
	 *
	 * @param createDate the create date of this role type master
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this role type master.
	 *
	 * @param createdBy the created by of this role type master
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this role type master.
	 *
	 * @param groupId the group ID of this role type master
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this role type master.
	 *
	 * @param modifiedBy the modified by of this role type master
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this role type master.
	 *
	 * @param modifiedDate the modified date of this role type master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this role type master.
	 *
	 * @param primaryKey the primary key of this role type master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role type master ID of this role type master.
	 *
	 * @param roleTypeMasterId the role type master ID of this role type master
	 */
	@Override
	public void setRoleTypeMasterId(long roleTypeMasterId) {
		model.setRoleTypeMasterId(roleTypeMasterId);
	}

	/**
	 * Sets the role type name of this role type master.
	 *
	 * @param roleTypeName the role type name of this role type master
	 */
	@Override
	public void setRoleTypeName(String roleTypeName) {
		model.setRoleTypeName(roleTypeName);
	}

	/**
	 * Sets the localized role type name of this role type master in the language.
	 *
	 * @param roleTypeName the localized role type name of this role type master
	 * @param locale the locale of the language
	 */
	@Override
	public void setRoleTypeName(String roleTypeName, java.util.Locale locale) {
		model.setRoleTypeName(roleTypeName, locale);
	}

	/**
	 * Sets the localized role type name of this role type master in the language, and sets the default locale.
	 *
	 * @param roleTypeName the localized role type name of this role type master
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRoleTypeName(
		String roleTypeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setRoleTypeName(roleTypeName, locale, defaultLocale);
	}

	@Override
	public void setRoleTypeNameCurrentLanguageId(String languageId) {
		model.setRoleTypeNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized role type names of this role type master from the map of locales and localized role type names.
	 *
	 * @param roleTypeNameMap the locales and localized role type names of this role type master
	 */
	@Override
	public void setRoleTypeNameMap(
		Map<java.util.Locale, String> roleTypeNameMap) {

		model.setRoleTypeNameMap(roleTypeNameMap);
	}

	/**
	 * Sets the localized role type names of this role type master from the map of locales and localized role type names, and sets the default locale.
	 *
	 * @param roleTypeNameMap the locales and localized role type names of this role type master
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setRoleTypeNameMap(
		Map<java.util.Locale, String> roleTypeNameMap,
		java.util.Locale defaultLocale) {

		model.setRoleTypeNameMap(roleTypeNameMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this role type master.
	 *
	 * @param uuid the uuid of this role type master
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
	protected RoleTypeMasterWrapper wrap(RoleTypeMaster roleTypeMaster) {
		return new RoleTypeMasterWrapper(roleTypeMaster);
	}

}