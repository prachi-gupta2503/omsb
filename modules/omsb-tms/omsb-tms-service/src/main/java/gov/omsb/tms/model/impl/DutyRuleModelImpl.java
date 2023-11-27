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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.DutyRuleModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DutyRule service. Represents a row in the &quot;duty_rule_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DutyRuleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DutyRuleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyRuleImpl
 * @generated
 */
@JSON(strict = true)
public class DutyRuleModelImpl
	extends BaseModelImpl<DutyRule> implements DutyRuleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a duty rule model instance should use the <code>DutyRule</code> interface instead.
	 */
	public static final String TABLE_NAME = "duty_rule_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"duty_rule_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_date", Types.TIMESTAMP}, {"modified_by", Types.BIGINT},
		{"rule", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"parent_id", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("duty_rule_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rule", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("parent_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table duty_rule_master (uuid_ VARCHAR(75) null,duty_rule_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,created_by LONG,modified_date DATE null,modified_by LONG,rule VARCHAR(75) null,description VARCHAR(75) null,parent_id LONG)";

	public static final String TABLE_SQL_DROP = "drop table duty_rule_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dutyRule.dutyRuleId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY duty_rule_master.duty_rule_id ASC";

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
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DUTYRULEID_COLUMN_BITMASK = 8L;

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

	public DutyRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dutyRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDutyRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dutyRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DutyRule.class;
	}

	@Override
	public String getModelClassName() {
		return DutyRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DutyRule, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DutyRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DutyRule, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DutyRule)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DutyRule, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DutyRule, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DutyRule)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DutyRule, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DutyRule, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DutyRule, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DutyRule, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DutyRule, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DutyRule, Object>>();
		Map<String, BiConsumer<DutyRule, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DutyRule, ?>>();

		attributeGetterFunctions.put("uuid", DutyRule::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DutyRule, String>)DutyRule::setUuid);
		attributeGetterFunctions.put("dutyRuleId", DutyRule::getDutyRuleId);
		attributeSetterBiConsumers.put(
			"dutyRuleId", (BiConsumer<DutyRule, Long>)DutyRule::setDutyRuleId);
		attributeGetterFunctions.put("groupId", DutyRule::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<DutyRule, Long>)DutyRule::setGroupId);
		attributeGetterFunctions.put("companyId", DutyRule::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<DutyRule, Long>)DutyRule::setCompanyId);
		attributeGetterFunctions.put("createDate", DutyRule::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<DutyRule, Date>)DutyRule::setCreateDate);
		attributeGetterFunctions.put("createdBy", DutyRule::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy", (BiConsumer<DutyRule, Long>)DutyRule::setCreatedBy);
		attributeGetterFunctions.put("modifiedDate", DutyRule::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DutyRule, Date>)DutyRule::setModifiedDate);
		attributeGetterFunctions.put("modifiedBy", DutyRule::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy", (BiConsumer<DutyRule, Long>)DutyRule::setModifiedBy);
		attributeGetterFunctions.put("rule", DutyRule::getRule);
		attributeSetterBiConsumers.put(
			"rule", (BiConsumer<DutyRule, String>)DutyRule::setRule);
		attributeGetterFunctions.put("description", DutyRule::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<DutyRule, String>)DutyRule::setDescription);
		attributeGetterFunctions.put("parentId", DutyRule::getParentId);
		attributeSetterBiConsumers.put(
			"parentId", (BiConsumer<DutyRule, Long>)DutyRule::setParentId);

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
	public long getDutyRuleId() {
		return _dutyRuleId;
	}

	@Override
	public void setDutyRuleId(long dutyRuleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dutyRuleId = dutyRuleId;
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
	public String getRule() {
		if (_rule == null) {
			return "";
		}
		else {
			return _rule;
		}
	}

	@Override
	public void setRule(String rule) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rule = rule;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentId = parentId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DutyRule.class.getName()));
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
			getCompanyId(), DutyRule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DutyRule toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DutyRule>
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
		DutyRuleImpl dutyRuleImpl = new DutyRuleImpl();

		dutyRuleImpl.setUuid(getUuid());
		dutyRuleImpl.setDutyRuleId(getDutyRuleId());
		dutyRuleImpl.setGroupId(getGroupId());
		dutyRuleImpl.setCompanyId(getCompanyId());
		dutyRuleImpl.setCreateDate(getCreateDate());
		dutyRuleImpl.setCreatedBy(getCreatedBy());
		dutyRuleImpl.setModifiedDate(getModifiedDate());
		dutyRuleImpl.setModifiedBy(getModifiedBy());
		dutyRuleImpl.setRule(getRule());
		dutyRuleImpl.setDescription(getDescription());
		dutyRuleImpl.setParentId(getParentId());

		dutyRuleImpl.resetOriginalValues();

		return dutyRuleImpl;
	}

	@Override
	public DutyRule cloneWithOriginalValues() {
		DutyRuleImpl dutyRuleImpl = new DutyRuleImpl();

		dutyRuleImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		dutyRuleImpl.setDutyRuleId(
			this.<Long>getColumnOriginalValue("duty_rule_id"));
		dutyRuleImpl.setGroupId(this.<Long>getColumnOriginalValue("group_id"));
		dutyRuleImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		dutyRuleImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		dutyRuleImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		dutyRuleImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		dutyRuleImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		dutyRuleImpl.setRule(this.<String>getColumnOriginalValue("rule"));
		dutyRuleImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		dutyRuleImpl.setParentId(
			this.<Long>getColumnOriginalValue("parent_id"));

		return dutyRuleImpl;
	}

	@Override
	public int compareTo(DutyRule dutyRule) {
		long primaryKey = dutyRule.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DutyRule)) {
			return false;
		}

		DutyRule dutyRule = (DutyRule)object;

		long primaryKey = dutyRule.getPrimaryKey();

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
	public CacheModel<DutyRule> toCacheModel() {
		DutyRuleCacheModel dutyRuleCacheModel = new DutyRuleCacheModel();

		dutyRuleCacheModel.uuid = getUuid();

		String uuid = dutyRuleCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dutyRuleCacheModel.uuid = null;
		}

		dutyRuleCacheModel.dutyRuleId = getDutyRuleId();

		dutyRuleCacheModel.groupId = getGroupId();

		dutyRuleCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dutyRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			dutyRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		dutyRuleCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dutyRuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dutyRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dutyRuleCacheModel.modifiedBy = getModifiedBy();

		dutyRuleCacheModel.rule = getRule();

		String rule = dutyRuleCacheModel.rule;

		if ((rule != null) && (rule.length() == 0)) {
			dutyRuleCacheModel.rule = null;
		}

		dutyRuleCacheModel.description = getDescription();

		String description = dutyRuleCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dutyRuleCacheModel.description = null;
		}

		dutyRuleCacheModel.parentId = getParentId();

		return dutyRuleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DutyRule, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DutyRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DutyRule, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DutyRule)this);

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

		private static final Function<InvocationHandler, DutyRule>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DutyRule.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _dutyRuleId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private String _rule;
	private String _description;
	private long _parentId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DutyRule, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DutyRule)this);
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
		_columnOriginalValues.put("duty_rule_id", _dutyRuleId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("rule", _rule);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("parent_id", _parentId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("duty_rule_id", "dutyRuleId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("parent_id", "parentId");

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

		columnBitmasks.put("duty_rule_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("created_by", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("rule", 256L);

		columnBitmasks.put("description", 512L);

		columnBitmasks.put("parent_id", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DutyRule _escapedModel;

}