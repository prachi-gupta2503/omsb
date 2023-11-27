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

import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureGroupMasterModel;

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
 * The base model implementation for the ProcedureGroupMaster service. Represents a row in the &quot;procedure_group_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProcedureGroupMasterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcedureGroupMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMasterImpl
 * @generated
 */
@JSON(strict = true)
public class ProcedureGroupMasterModelImpl
	extends BaseModelImpl<ProcedureGroupMaster>
	implements ProcedureGroupMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a procedure group master model instance should use the <code>ProcedureGroupMaster</code> interface instead.
	 */
	public static final String TABLE_NAME = "procedure_group_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"procedure_group_master_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_date", Types.TIMESTAMP}, {"modified_by", Types.BIGINT},
		{"procedure_group_name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("procedure_group_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_group_name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table procedure_group_master (uuid_ VARCHAR(75) null,procedure_group_master_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,created_by LONG,modified_date DATE null,modified_by LONG,procedure_group_name STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table procedure_group_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY procedureGroupMaster.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY procedure_group_master.modified_date DESC";

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
	public static final long PROCEDUREGROUPNAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 16L;

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

	public ProcedureGroupMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _procedureGroupMasterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcedureGroupMasterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _procedureGroupMasterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcedureGroupMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ProcedureGroupMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProcedureGroupMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProcedureGroupMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureGroupMaster, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProcedureGroupMaster)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProcedureGroupMaster, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProcedureGroupMaster, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProcedureGroupMaster)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProcedureGroupMaster, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProcedureGroupMaster, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ProcedureGroupMaster, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProcedureGroupMaster, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProcedureGroupMaster, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProcedureGroupMaster, Object>>();
		Map<String, BiConsumer<ProcedureGroupMaster, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ProcedureGroupMaster, ?>>();

		attributeGetterFunctions.put("uuid", ProcedureGroupMaster::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProcedureGroupMaster, String>)
				ProcedureGroupMaster::setUuid);
		attributeGetterFunctions.put(
			"procedureGroupMasterId",
			ProcedureGroupMaster::getProcedureGroupMasterId);
		attributeSetterBiConsumers.put(
			"procedureGroupMasterId",
			(BiConsumer<ProcedureGroupMaster, Long>)
				ProcedureGroupMaster::setProcedureGroupMasterId);
		attributeGetterFunctions.put(
			"groupId", ProcedureGroupMaster::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProcedureGroupMaster, Long>)
				ProcedureGroupMaster::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProcedureGroupMaster::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProcedureGroupMaster, Long>)
				ProcedureGroupMaster::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ProcedureGroupMaster::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProcedureGroupMaster, Date>)
				ProcedureGroupMaster::setCreateDate);
		attributeGetterFunctions.put(
			"createdBy", ProcedureGroupMaster::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProcedureGroupMaster, Long>)
				ProcedureGroupMaster::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate", ProcedureGroupMaster::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProcedureGroupMaster, Date>)
				ProcedureGroupMaster::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", ProcedureGroupMaster::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProcedureGroupMaster, Long>)
				ProcedureGroupMaster::setModifiedBy);
		attributeGetterFunctions.put(
			"procedureGroupName", ProcedureGroupMaster::getProcedureGroupName);
		attributeSetterBiConsumers.put(
			"procedureGroupName",
			(BiConsumer<ProcedureGroupMaster, String>)
				ProcedureGroupMaster::setProcedureGroupName);

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
	public String getProcedureGroupName() {
		if (_procedureGroupName == null) {
			return "";
		}
		else {
			return _procedureGroupName;
		}
	}

	@Override
	public String getProcedureGroupName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcedureGroupName(languageId);
	}

	@Override
	public String getProcedureGroupName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcedureGroupName(languageId, useDefault);
	}

	@Override
	public String getProcedureGroupName(String languageId) {
		return LocalizationUtil.getLocalization(
			getProcedureGroupName(), languageId);
	}

	@Override
	public String getProcedureGroupName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getProcedureGroupName(), languageId, useDefault);
	}

	@Override
	public String getProcedureGroupNameCurrentLanguageId() {
		return _procedureGroupNameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getProcedureGroupNameCurrentValue() {
		Locale locale = getLocale(_procedureGroupNameCurrentLanguageId);

		return getProcedureGroupName(locale);
	}

	@Override
	public Map<Locale, String> getProcedureGroupNameMap() {
		return LocalizationUtil.getLocalizationMap(getProcedureGroupName());
	}

	@Override
	public void setProcedureGroupName(String procedureGroupName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureGroupName = procedureGroupName;
	}

	@Override
	public void setProcedureGroupName(
		String procedureGroupName, Locale locale) {

		setProcedureGroupName(
			procedureGroupName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setProcedureGroupName(
		String procedureGroupName, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(procedureGroupName)) {
			setProcedureGroupName(
				LocalizationUtil.updateLocalization(
					getProcedureGroupName(), "ProcedureGroupName",
					procedureGroupName, languageId, defaultLanguageId));
		}
		else {
			setProcedureGroupName(
				LocalizationUtil.removeLocalization(
					getProcedureGroupName(), "ProcedureGroupName", languageId));
		}
	}

	@Override
	public void setProcedureGroupNameCurrentLanguageId(String languageId) {
		_procedureGroupNameCurrentLanguageId = languageId;
	}

	@Override
	public void setProcedureGroupNameMap(
		Map<Locale, String> procedureGroupNameMap) {

		setProcedureGroupNameMap(
			procedureGroupNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setProcedureGroupNameMap(
		Map<Locale, String> procedureGroupNameMap, Locale defaultLocale) {

		if (procedureGroupNameMap == null) {
			return;
		}

		setProcedureGroupName(
			LocalizationUtil.updateLocalization(
				procedureGroupNameMap, getProcedureGroupName(),
				"ProcedureGroupName", LocaleUtil.toLanguageId(defaultLocale)));
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalProcedureGroupName() {
		return getColumnOriginalValue("procedure_group_name");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProcedureGroupMaster.class.getName()));
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
			getCompanyId(), ProcedureGroupMaster.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> procedureGroupNameMap = getProcedureGroupNameMap();

		for (Map.Entry<Locale, String> entry :
				procedureGroupNameMap.entrySet()) {

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
		String xml = getProcedureGroupName();

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
			ProcedureGroupMaster.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String procedureGroupName = getProcedureGroupName(defaultLocale);

		if (Validator.isNull(procedureGroupName)) {
			setProcedureGroupName(
				getProcedureGroupName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setProcedureGroupName(
				getProcedureGroupName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public ProcedureGroupMaster toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProcedureGroupMaster>
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
		ProcedureGroupMasterImpl procedureGroupMasterImpl =
			new ProcedureGroupMasterImpl();

		procedureGroupMasterImpl.setUuid(getUuid());
		procedureGroupMasterImpl.setProcedureGroupMasterId(
			getProcedureGroupMasterId());
		procedureGroupMasterImpl.setGroupId(getGroupId());
		procedureGroupMasterImpl.setCompanyId(getCompanyId());
		procedureGroupMasterImpl.setCreateDate(getCreateDate());
		procedureGroupMasterImpl.setCreatedBy(getCreatedBy());
		procedureGroupMasterImpl.setModifiedDate(getModifiedDate());
		procedureGroupMasterImpl.setModifiedBy(getModifiedBy());
		procedureGroupMasterImpl.setProcedureGroupName(getProcedureGroupName());

		procedureGroupMasterImpl.resetOriginalValues();

		return procedureGroupMasterImpl;
	}

	@Override
	public ProcedureGroupMaster cloneWithOriginalValues() {
		ProcedureGroupMasterImpl procedureGroupMasterImpl =
			new ProcedureGroupMasterImpl();

		procedureGroupMasterImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		procedureGroupMasterImpl.setProcedureGroupMasterId(
			this.<Long>getColumnOriginalValue("procedure_group_master_id"));
		procedureGroupMasterImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		procedureGroupMasterImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		procedureGroupMasterImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		procedureGroupMasterImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		procedureGroupMasterImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		procedureGroupMasterImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		procedureGroupMasterImpl.setProcedureGroupName(
			this.<String>getColumnOriginalValue("procedure_group_name"));

		return procedureGroupMasterImpl;
	}

	@Override
	public int compareTo(ProcedureGroupMaster procedureGroupMaster) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), procedureGroupMaster.getModifiedDate());

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

		if (!(object instanceof ProcedureGroupMaster)) {
			return false;
		}

		ProcedureGroupMaster procedureGroupMaster =
			(ProcedureGroupMaster)object;

		long primaryKey = procedureGroupMaster.getPrimaryKey();

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
	public CacheModel<ProcedureGroupMaster> toCacheModel() {
		ProcedureGroupMasterCacheModel procedureGroupMasterCacheModel =
			new ProcedureGroupMasterCacheModel();

		procedureGroupMasterCacheModel.uuid = getUuid();

		String uuid = procedureGroupMasterCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			procedureGroupMasterCacheModel.uuid = null;
		}

		procedureGroupMasterCacheModel.procedureGroupMasterId =
			getProcedureGroupMasterId();

		procedureGroupMasterCacheModel.groupId = getGroupId();

		procedureGroupMasterCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			procedureGroupMasterCacheModel.createDate = createDate.getTime();
		}
		else {
			procedureGroupMasterCacheModel.createDate = Long.MIN_VALUE;
		}

		procedureGroupMasterCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			procedureGroupMasterCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			procedureGroupMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		procedureGroupMasterCacheModel.modifiedBy = getModifiedBy();

		procedureGroupMasterCacheModel.procedureGroupName =
			getProcedureGroupName();

		String procedureGroupName =
			procedureGroupMasterCacheModel.procedureGroupName;

		if ((procedureGroupName != null) &&
			(procedureGroupName.length() == 0)) {

			procedureGroupMasterCacheModel.procedureGroupName = null;
		}

		return procedureGroupMasterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProcedureGroupMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProcedureGroupMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureGroupMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProcedureGroupMaster)this);

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

		private static final Function<InvocationHandler, ProcedureGroupMaster>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ProcedureGroupMaster.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _procedureGroupMasterId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private String _procedureGroupName;
	private String _procedureGroupNameCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProcedureGroupMaster, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProcedureGroupMaster)this);
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
		_columnOriginalValues.put(
			"procedure_group_master_id", _procedureGroupMasterId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("procedure_group_name", _procedureGroupName);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"procedure_group_master_id", "procedureGroupMasterId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("procedure_group_name", "procedureGroupName");

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

		columnBitmasks.put("procedure_group_master_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("created_by", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("procedure_group_name", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProcedureGroupMaster _escapedModel;

}