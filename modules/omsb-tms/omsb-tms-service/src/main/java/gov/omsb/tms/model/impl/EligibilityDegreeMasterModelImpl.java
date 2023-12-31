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

import gov.omsb.tms.model.EligibilityDegreeMaster;
import gov.omsb.tms.model.EligibilityDegreeMasterModel;

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
 * The base model implementation for the EligibilityDegreeMaster service. Represents a row in the &quot;eligibility_degree_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EligibilityDegreeMasterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EligibilityDegreeMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterImpl
 * @generated
 */
@JSON(strict = true)
public class EligibilityDegreeMasterModelImpl
	extends BaseModelImpl<EligibilityDegreeMaster>
	implements EligibilityDegreeMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a eligibility degree master model instance should use the <code>EligibilityDegreeMaster</code> interface instead.
	 */
	public static final String TABLE_NAME = "eligibility_degree_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"eligibility_degree_master_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"modified_date", Types.TIMESTAMP},
		{"created_by", Types.BIGINT}, {"modified_by", Types.BIGINT},
		{"eligibility_degree", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eligibility_degree_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("eligibility_degree", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table eligibility_degree_master (uuid_ VARCHAR(75) null,eligibility_degree_master_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG,eligibility_degree STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table eligibility_degree_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY eligibilityDegreeMaster.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY eligibility_degree_master.modified_date DESC";

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
	public static final long ELIGIBILITYDEGREE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

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

	public EligibilityDegreeMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eligibilityDegreeMasterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEligibilityDegreeMasterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eligibilityDegreeMasterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EligibilityDegreeMaster.class;
	}

	@Override
	public String getModelClassName() {
		return EligibilityDegreeMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EligibilityDegreeMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EligibilityDegreeMaster, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EligibilityDegreeMaster, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EligibilityDegreeMaster)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EligibilityDegreeMaster, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EligibilityDegreeMaster, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EligibilityDegreeMaster)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EligibilityDegreeMaster, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EligibilityDegreeMaster, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<EligibilityDegreeMaster, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<EligibilityDegreeMaster, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<EligibilityDegreeMaster, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EligibilityDegreeMaster, Object>>();
		Map<String, BiConsumer<EligibilityDegreeMaster, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<EligibilityDegreeMaster, ?>>();

		attributeGetterFunctions.put("uuid", EligibilityDegreeMaster::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<EligibilityDegreeMaster, String>)
				EligibilityDegreeMaster::setUuid);
		attributeGetterFunctions.put(
			"eligibilityDegreeMasterId",
			EligibilityDegreeMaster::getEligibilityDegreeMasterId);
		attributeSetterBiConsumers.put(
			"eligibilityDegreeMasterId",
			(BiConsumer<EligibilityDegreeMaster, Long>)
				EligibilityDegreeMaster::setEligibilityDegreeMasterId);
		attributeGetterFunctions.put(
			"groupId", EligibilityDegreeMaster::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<EligibilityDegreeMaster, Long>)
				EligibilityDegreeMaster::setGroupId);
		attributeGetterFunctions.put(
			"companyId", EligibilityDegreeMaster::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<EligibilityDegreeMaster, Long>)
				EligibilityDegreeMaster::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", EligibilityDegreeMaster::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EligibilityDegreeMaster, Date>)
				EligibilityDegreeMaster::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EligibilityDegreeMaster::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EligibilityDegreeMaster, Date>)
				EligibilityDegreeMaster::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", EligibilityDegreeMaster::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<EligibilityDegreeMaster, Long>)
				EligibilityDegreeMaster::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", EligibilityDegreeMaster::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<EligibilityDegreeMaster, Long>)
				EligibilityDegreeMaster::setModifiedBy);
		attributeGetterFunctions.put(
			"eligibilityDegree", EligibilityDegreeMaster::getEligibilityDegree);
		attributeSetterBiConsumers.put(
			"eligibilityDegree",
			(BiConsumer<EligibilityDegreeMaster, String>)
				EligibilityDegreeMaster::setEligibilityDegree);

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
	public long getEligibilityDegreeMasterId() {
		return _eligibilityDegreeMasterId;
	}

	@Override
	public void setEligibilityDegreeMasterId(long eligibilityDegreeMasterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eligibilityDegreeMasterId = eligibilityDegreeMasterId;
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
	public String getEligibilityDegree() {
		if (_eligibilityDegree == null) {
			return "";
		}
		else {
			return _eligibilityDegree;
		}
	}

	@Override
	public String getEligibilityDegree(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEligibilityDegree(languageId);
	}

	@Override
	public String getEligibilityDegree(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEligibilityDegree(languageId, useDefault);
	}

	@Override
	public String getEligibilityDegree(String languageId) {
		return LocalizationUtil.getLocalization(
			getEligibilityDegree(), languageId);
	}

	@Override
	public String getEligibilityDegree(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getEligibilityDegree(), languageId, useDefault);
	}

	@Override
	public String getEligibilityDegreeCurrentLanguageId() {
		return _eligibilityDegreeCurrentLanguageId;
	}

	@JSON
	@Override
	public String getEligibilityDegreeCurrentValue() {
		Locale locale = getLocale(_eligibilityDegreeCurrentLanguageId);

		return getEligibilityDegree(locale);
	}

	@Override
	public Map<Locale, String> getEligibilityDegreeMap() {
		return LocalizationUtil.getLocalizationMap(getEligibilityDegree());
	}

	@Override
	public void setEligibilityDegree(String eligibilityDegree) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eligibilityDegree = eligibilityDegree;
	}

	@Override
	public void setEligibilityDegree(String eligibilityDegree, Locale locale) {
		setEligibilityDegree(
			eligibilityDegree, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setEligibilityDegree(
		String eligibilityDegree, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(eligibilityDegree)) {
			setEligibilityDegree(
				LocalizationUtil.updateLocalization(
					getEligibilityDegree(), "EligibilityDegree",
					eligibilityDegree, languageId, defaultLanguageId));
		}
		else {
			setEligibilityDegree(
				LocalizationUtil.removeLocalization(
					getEligibilityDegree(), "EligibilityDegree", languageId));
		}
	}

	@Override
	public void setEligibilityDegreeCurrentLanguageId(String languageId) {
		_eligibilityDegreeCurrentLanguageId = languageId;
	}

	@Override
	public void setEligibilityDegreeMap(
		Map<Locale, String> eligibilityDegreeMap) {

		setEligibilityDegreeMap(eligibilityDegreeMap, LocaleUtil.getDefault());
	}

	@Override
	public void setEligibilityDegreeMap(
		Map<Locale, String> eligibilityDegreeMap, Locale defaultLocale) {

		if (eligibilityDegreeMap == null) {
			return;
		}

		setEligibilityDegree(
			LocalizationUtil.updateLocalization(
				eligibilityDegreeMap, getEligibilityDegree(),
				"EligibilityDegree", LocaleUtil.toLanguageId(defaultLocale)));
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEligibilityDegree() {
		return getColumnOriginalValue("eligibility_degree");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(EligibilityDegreeMaster.class.getName()));
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
			getCompanyId(), EligibilityDegreeMaster.class.getName(),
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

		Map<Locale, String> eligibilityDegreeMap = getEligibilityDegreeMap();

		for (Map.Entry<Locale, String> entry :
				eligibilityDegreeMap.entrySet()) {

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
		String xml = getEligibilityDegree();

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
			EligibilityDegreeMaster.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String eligibilityDegree = getEligibilityDegree(defaultLocale);

		if (Validator.isNull(eligibilityDegree)) {
			setEligibilityDegree(
				getEligibilityDegree(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setEligibilityDegree(
				getEligibilityDegree(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public EligibilityDegreeMaster toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EligibilityDegreeMaster>
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
		EligibilityDegreeMasterImpl eligibilityDegreeMasterImpl =
			new EligibilityDegreeMasterImpl();

		eligibilityDegreeMasterImpl.setUuid(getUuid());
		eligibilityDegreeMasterImpl.setEligibilityDegreeMasterId(
			getEligibilityDegreeMasterId());
		eligibilityDegreeMasterImpl.setGroupId(getGroupId());
		eligibilityDegreeMasterImpl.setCompanyId(getCompanyId());
		eligibilityDegreeMasterImpl.setCreateDate(getCreateDate());
		eligibilityDegreeMasterImpl.setModifiedDate(getModifiedDate());
		eligibilityDegreeMasterImpl.setCreatedBy(getCreatedBy());
		eligibilityDegreeMasterImpl.setModifiedBy(getModifiedBy());
		eligibilityDegreeMasterImpl.setEligibilityDegree(
			getEligibilityDegree());

		eligibilityDegreeMasterImpl.resetOriginalValues();

		return eligibilityDegreeMasterImpl;
	}

	@Override
	public EligibilityDegreeMaster cloneWithOriginalValues() {
		EligibilityDegreeMasterImpl eligibilityDegreeMasterImpl =
			new EligibilityDegreeMasterImpl();

		eligibilityDegreeMasterImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		eligibilityDegreeMasterImpl.setEligibilityDegreeMasterId(
			this.<Long>getColumnOriginalValue("eligibility_degree_master_id"));
		eligibilityDegreeMasterImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		eligibilityDegreeMasterImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		eligibilityDegreeMasterImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		eligibilityDegreeMasterImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		eligibilityDegreeMasterImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		eligibilityDegreeMasterImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		eligibilityDegreeMasterImpl.setEligibilityDegree(
			this.<String>getColumnOriginalValue("eligibility_degree"));

		return eligibilityDegreeMasterImpl;
	}

	@Override
	public int compareTo(EligibilityDegreeMaster eligibilityDegreeMaster) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), eligibilityDegreeMaster.getModifiedDate());

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

		if (!(object instanceof EligibilityDegreeMaster)) {
			return false;
		}

		EligibilityDegreeMaster eligibilityDegreeMaster =
			(EligibilityDegreeMaster)object;

		long primaryKey = eligibilityDegreeMaster.getPrimaryKey();

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
	public CacheModel<EligibilityDegreeMaster> toCacheModel() {
		EligibilityDegreeMasterCacheModel eligibilityDegreeMasterCacheModel =
			new EligibilityDegreeMasterCacheModel();

		eligibilityDegreeMasterCacheModel.uuid = getUuid();

		String uuid = eligibilityDegreeMasterCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			eligibilityDegreeMasterCacheModel.uuid = null;
		}

		eligibilityDegreeMasterCacheModel.eligibilityDegreeMasterId =
			getEligibilityDegreeMasterId();

		eligibilityDegreeMasterCacheModel.groupId = getGroupId();

		eligibilityDegreeMasterCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			eligibilityDegreeMasterCacheModel.createDate = createDate.getTime();
		}
		else {
			eligibilityDegreeMasterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			eligibilityDegreeMasterCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			eligibilityDegreeMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		eligibilityDegreeMasterCacheModel.createdBy = getCreatedBy();

		eligibilityDegreeMasterCacheModel.modifiedBy = getModifiedBy();

		eligibilityDegreeMasterCacheModel.eligibilityDegree =
			getEligibilityDegree();

		String eligibilityDegree =
			eligibilityDegreeMasterCacheModel.eligibilityDegree;

		if ((eligibilityDegree != null) && (eligibilityDegree.length() == 0)) {
			eligibilityDegreeMasterCacheModel.eligibilityDegree = null;
		}

		return eligibilityDegreeMasterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EligibilityDegreeMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EligibilityDegreeMaster, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EligibilityDegreeMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(EligibilityDegreeMaster)this);

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

		private static final Function
			<InvocationHandler, EligibilityDegreeMaster>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						EligibilityDegreeMaster.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _eligibilityDegreeMasterId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private String _eligibilityDegree;
	private String _eligibilityDegreeCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EligibilityDegreeMaster, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EligibilityDegreeMaster)this);
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
			"eligibility_degree_master_id", _eligibilityDegreeMasterId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("eligibility_degree", _eligibilityDegree);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"eligibility_degree_master_id", "eligibilityDegreeMasterId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("eligibility_degree", "eligibilityDegree");

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

		columnBitmasks.put("eligibility_degree_master_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("modified_date", 32L);

		columnBitmasks.put("created_by", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("eligibility_degree", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EligibilityDegreeMaster _escapedModel;

}