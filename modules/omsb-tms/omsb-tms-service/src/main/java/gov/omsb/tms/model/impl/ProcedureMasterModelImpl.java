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

package gov.omsb.tms.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProcedureMasterModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProcedureMaster service. Represents a row in the &quot;procedure_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProcedureMasterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcedureMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMasterImpl
 * @generated
 */
@JSON(strict = true)
public class ProcedureMasterModelImpl
	extends BaseModelImpl<ProcedureMaster> implements ProcedureMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a procedure master model instance should use the <code>ProcedureMaster</code> interface instead.
	 */
	public static final String TABLE_NAME = "procedure_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"procedure_master_id", Types.BIGINT},
		{"procedure_group_master_id", Types.BIGINT}, {"group_id", Types.BIGINT},
		{"company_id", Types.BIGINT}, {"create_date", Types.TIMESTAMP},
		{"modified_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_by", Types.BIGINT}, {"procedure_name", Types.VARCHAR},
		{"cpt_code", Types.VARCHAR}, {"is_mandatory", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("procedure_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_group_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cpt_code", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("is_mandatory", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table procedure_master (uuid_ VARCHAR(75) null,procedure_master_id LONG not null primary key,procedure_group_master_id LONG,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG,procedure_name STRING null,cpt_code STRING null,is_mandatory BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table procedure_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY procedureMaster.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY procedure_master.modified_date DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROCEDUREGROUPMASTERID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROCEDURENAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ProcedureMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _procedureMasterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcedureMasterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _procedureMasterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcedureMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ProcedureMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProcedureMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProcedureMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureMaster, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProcedureMaster)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProcedureMaster, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProcedureMaster, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProcedureMaster)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProcedureMaster, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProcedureMaster, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ProcedureMaster, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProcedureMaster, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProcedureMaster, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ProcedureMaster, Object>>();
		Map<String, BiConsumer<ProcedureMaster, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProcedureMaster, ?>>();

		attributeGetterFunctions.put("uuid", ProcedureMaster::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProcedureMaster, String>)ProcedureMaster::setUuid);
		attributeGetterFunctions.put(
			"procedureMasterId", ProcedureMaster::getProcedureMasterId);
		attributeSetterBiConsumers.put(
			"procedureMasterId",
			(BiConsumer<ProcedureMaster, Long>)
				ProcedureMaster::setProcedureMasterId);
		attributeGetterFunctions.put(
			"procedureGroupMasterId",
			ProcedureMaster::getProcedureGroupMasterId);
		attributeSetterBiConsumers.put(
			"procedureGroupMasterId",
			(BiConsumer<ProcedureMaster, Long>)
				ProcedureMaster::setProcedureGroupMasterId);
		attributeGetterFunctions.put("groupId", ProcedureMaster::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProcedureMaster, Long>)ProcedureMaster::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProcedureMaster::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProcedureMaster, Long>)ProcedureMaster::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ProcedureMaster::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProcedureMaster, Date>)ProcedureMaster::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProcedureMaster::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProcedureMaster, Date>)
				ProcedureMaster::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", ProcedureMaster::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProcedureMaster, Long>)ProcedureMaster::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", ProcedureMaster::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProcedureMaster, Long>)ProcedureMaster::setModifiedBy);
		attributeGetterFunctions.put(
			"procedureName", ProcedureMaster::getProcedureName);
		attributeSetterBiConsumers.put(
			"procedureName",
			(BiConsumer<ProcedureMaster, String>)
				ProcedureMaster::setProcedureName);
		attributeGetterFunctions.put("cptCode", ProcedureMaster::getCptCode);
		attributeSetterBiConsumers.put(
			"cptCode",
			(BiConsumer<ProcedureMaster, String>)ProcedureMaster::setCptCode);
		attributeGetterFunctions.put(
			"isMandatory", ProcedureMaster::getIsMandatory);
		attributeSetterBiConsumers.put(
			"isMandatory",
			(BiConsumer<ProcedureMaster, Boolean>)
				ProcedureMaster::setIsMandatory);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getProcedureMasterId() {
		return _procedureMasterId;
	}

	@Override
	public void setProcedureMasterId(long procedureMasterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureMasterId = procedureMasterId;
	}

	@JSON
	@Override
	public long getProcedureGroupMasterId() {
		return _procedureGroupMasterId;
	}

	@Override
	public void setProcedureGroupMasterId(long procedureGroupMasterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureGroupMasterId = procedureGroupMasterId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProcedureGroupMasterId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("procedure_group_master_id"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("group_id"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("company_id"));
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdBy = createdBy;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public String getProcedureName() {
		if (_procedureName == null) {
			return "";
		}
		else {
			return _procedureName;
		}
	}

	@Override
	public String getProcedureName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcedureName(languageId);
	}

	@Override
	public String getProcedureName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcedureName(languageId, useDefault);
	}

	@Override
	public String getProcedureName(String languageId) {
		return LocalizationUtil.getLocalization(getProcedureName(), languageId);
	}

	@Override
	public String getProcedureName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getProcedureName(), languageId, useDefault);
	}

	@Override
	public String getProcedureNameCurrentLanguageId() {
		return _procedureNameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getProcedureNameCurrentValue() {
		Locale locale = getLocale(_procedureNameCurrentLanguageId);

		return getProcedureName(locale);
	}

	@Override
	public Map<Locale, String> getProcedureNameMap() {
		return LocalizationUtil.getLocalizationMap(getProcedureName());
	}

	@Override
	public void setProcedureName(String procedureName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureName = procedureName;
	}

	@Override
	public void setProcedureName(String procedureName, Locale locale) {
		setProcedureName(procedureName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setProcedureName(
		String procedureName, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(procedureName)) {
			setProcedureName(
				LocalizationUtil.updateLocalization(
					getProcedureName(), "ProcedureName", procedureName,
					languageId, defaultLanguageId));
		}
		else {
			setProcedureName(
				LocalizationUtil.removeLocalization(
					getProcedureName(), "ProcedureName", languageId));
		}
	}

	@Override
	public void setProcedureNameCurrentLanguageId(String languageId) {
		_procedureNameCurrentLanguageId = languageId;
	}

	@Override
	public void setProcedureNameMap(Map<Locale, String> procedureNameMap) {
		setProcedureNameMap(procedureNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setProcedureNameMap(
		Map<Locale, String> procedureNameMap, Locale defaultLocale) {

		if (procedureNameMap == null) {
			return;
		}

		setProcedureName(
			LocalizationUtil.updateLocalization(
				procedureNameMap, getProcedureName(), "ProcedureName",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalProcedureName() {
		return getColumnOriginalValue("procedure_name");
	}

	@JSON
	@Override
	public String getCptCode() {
		if (_cptCode == null) {
			return "";
		}
		else {
			return _cptCode;
		}
	}

	@Override
	public String getCptCode(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCptCode(languageId);
	}

	@Override
	public String getCptCode(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCptCode(languageId, useDefault);
	}

	@Override
	public String getCptCode(String languageId) {
		return LocalizationUtil.getLocalization(getCptCode(), languageId);
	}

	@Override
	public String getCptCode(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getCptCode(), languageId, useDefault);
	}

	@Override
	public String getCptCodeCurrentLanguageId() {
		return _cptCodeCurrentLanguageId;
	}

	@JSON
	@Override
	public String getCptCodeCurrentValue() {
		Locale locale = getLocale(_cptCodeCurrentLanguageId);

		return getCptCode(locale);
	}

	@Override
	public Map<Locale, String> getCptCodeMap() {
		return LocalizationUtil.getLocalizationMap(getCptCode());
	}

	@Override
	public void setCptCode(String cptCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cptCode = cptCode;
	}

	@Override
	public void setCptCode(String cptCode, Locale locale) {
		setCptCode(cptCode, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setCptCode(
		String cptCode, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(cptCode)) {
			setCptCode(
				LocalizationUtil.updateLocalization(
					getCptCode(), "CptCode", cptCode, languageId,
					defaultLanguageId));
		}
		else {
			setCptCode(
				LocalizationUtil.removeLocalization(
					getCptCode(), "CptCode", languageId));
		}
	}

	@Override
	public void setCptCodeCurrentLanguageId(String languageId) {
		_cptCodeCurrentLanguageId = languageId;
	}

	@Override
	public void setCptCodeMap(Map<Locale, String> cptCodeMap) {
		setCptCodeMap(cptCodeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setCptCodeMap(
		Map<Locale, String> cptCodeMap, Locale defaultLocale) {

		if (cptCodeMap == null) {
			return;
		}

		setCptCode(
			LocalizationUtil.updateLocalization(
				cptCodeMap, getCptCode(), "CptCode",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public boolean getIsMandatory() {
		return _isMandatory;
	}

	@JSON
	@Override
	public boolean isIsMandatory() {
		return _isMandatory;
	}

	@Override
	public void setIsMandatory(boolean isMandatory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isMandatory = isMandatory;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProcedureMaster.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProcedureMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> procedureNameMap = getProcedureNameMap();

		for (Map.Entry<Locale, String> entry : procedureNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> cptCodeMap = getCptCodeMap();

		for (Map.Entry<Locale, String> entry : cptCodeMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getProcedureName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			ProcedureMaster.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String procedureName = getProcedureName(defaultLocale);

		if (Validator.isNull(procedureName)) {
			setProcedureName(
				getProcedureName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setProcedureName(
				getProcedureName(defaultLocale), defaultLocale, defaultLocale);
		}

		String cptCode = getCptCode(defaultLocale);

		if (Validator.isNull(cptCode)) {
			setCptCode(getCptCode(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setCptCode(getCptCode(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public ProcedureMaster toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProcedureMaster>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProcedureMasterImpl procedureMasterImpl = new ProcedureMasterImpl();

		procedureMasterImpl.setUuid(getUuid());
		procedureMasterImpl.setProcedureMasterId(getProcedureMasterId());
		procedureMasterImpl.setProcedureGroupMasterId(
			getProcedureGroupMasterId());
		procedureMasterImpl.setGroupId(getGroupId());
		procedureMasterImpl.setCompanyId(getCompanyId());
		procedureMasterImpl.setCreateDate(getCreateDate());
		procedureMasterImpl.setModifiedDate(getModifiedDate());
		procedureMasterImpl.setCreatedBy(getCreatedBy());
		procedureMasterImpl.setModifiedBy(getModifiedBy());
		procedureMasterImpl.setProcedureName(getProcedureName());
		procedureMasterImpl.setCptCode(getCptCode());
		procedureMasterImpl.setIsMandatory(isIsMandatory());

		procedureMasterImpl.resetOriginalValues();

		return procedureMasterImpl;
	}

	@Override
	public ProcedureMaster cloneWithOriginalValues() {
		ProcedureMasterImpl procedureMasterImpl = new ProcedureMasterImpl();

		procedureMasterImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		procedureMasterImpl.setProcedureMasterId(
			this.<Long>getColumnOriginalValue("procedure_master_id"));
		procedureMasterImpl.setProcedureGroupMasterId(
			this.<Long>getColumnOriginalValue("procedure_group_master_id"));
		procedureMasterImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		procedureMasterImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		procedureMasterImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		procedureMasterImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		procedureMasterImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		procedureMasterImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		procedureMasterImpl.setProcedureName(
			this.<String>getColumnOriginalValue("procedure_name"));
		procedureMasterImpl.setCptCode(
			this.<String>getColumnOriginalValue("cpt_code"));
		procedureMasterImpl.setIsMandatory(
			this.<Boolean>getColumnOriginalValue("is_mandatory"));

		return procedureMasterImpl;
	}

	@Override
	public int compareTo(ProcedureMaster procedureMaster) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), procedureMaster.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcedureMaster)) {
			return false;
		}

		ProcedureMaster procedureMaster = (ProcedureMaster)object;

		long primaryKey = procedureMaster.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ProcedureMaster> toCacheModel() {
		ProcedureMasterCacheModel procedureMasterCacheModel =
			new ProcedureMasterCacheModel();

		procedureMasterCacheModel.uuid = getUuid();

		String uuid = procedureMasterCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			procedureMasterCacheModel.uuid = null;
		}

		procedureMasterCacheModel.procedureMasterId = getProcedureMasterId();

		procedureMasterCacheModel.procedureGroupMasterId =
			getProcedureGroupMasterId();

		procedureMasterCacheModel.groupId = getGroupId();

		procedureMasterCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			procedureMasterCacheModel.createDate = createDate.getTime();
		}
		else {
			procedureMasterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			procedureMasterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			procedureMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		procedureMasterCacheModel.createdBy = getCreatedBy();

		procedureMasterCacheModel.modifiedBy = getModifiedBy();

		procedureMasterCacheModel.procedureName = getProcedureName();

		String procedureName = procedureMasterCacheModel.procedureName;

		if ((procedureName != null) && (procedureName.length() == 0)) {
			procedureMasterCacheModel.procedureName = null;
		}

		procedureMasterCacheModel.cptCode = getCptCode();

		String cptCode = procedureMasterCacheModel.cptCode;

		if ((cptCode != null) && (cptCode.length() == 0)) {
			procedureMasterCacheModel.cptCode = null;
		}

		procedureMasterCacheModel.isMandatory = isIsMandatory();

		return procedureMasterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProcedureMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProcedureMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ProcedureMaster)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProcedureMaster>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ProcedureMaster.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _procedureMasterId;
	private long _procedureGroupMasterId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private String _procedureName;
	private String _procedureNameCurrentLanguageId;
	private String _cptCode;
	private String _cptCodeCurrentLanguageId;
	private boolean _isMandatory;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProcedureMaster, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProcedureMaster)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("procedure_master_id", _procedureMasterId);
		_columnOriginalValues.put(
			"procedure_group_master_id", _procedureGroupMasterId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("procedure_name", _procedureName);
		_columnOriginalValues.put("cpt_code", _cptCode);
		_columnOriginalValues.put("is_mandatory", _isMandatory);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("procedure_master_id", "procedureMasterId");
		attributeNames.put(
			"procedure_group_master_id", "procedureGroupMasterId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("procedure_name", "procedureName");
		attributeNames.put("cpt_code", "cptCode");
		attributeNames.put("is_mandatory", "isMandatory");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("procedure_master_id", 2L);

		columnBitmasks.put("procedure_group_master_id", 4L);

		columnBitmasks.put("group_id", 8L);

		columnBitmasks.put("company_id", 16L);

		columnBitmasks.put("create_date", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("created_by", 128L);

		columnBitmasks.put("modified_by", 256L);

		columnBitmasks.put("procedure_name", 512L);

		columnBitmasks.put("cpt_code", 1024L);

		columnBitmasks.put("is_mandatory", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProcedureMaster _escapedModel;

}