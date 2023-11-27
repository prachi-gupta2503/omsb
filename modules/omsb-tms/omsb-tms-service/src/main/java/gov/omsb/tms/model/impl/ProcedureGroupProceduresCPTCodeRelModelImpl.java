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

import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;
import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRelModel;

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
 * The base model implementation for the ProcedureGroupProceduresCPTCodeRel service. Represents a row in the &quot;proceduregroup_procedures_cptcode_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProcedureGroupProceduresCPTCodeRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcedureGroupProceduresCPTCodeRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelImpl
 * @generated
 */
@JSON(strict = true)
public class ProcedureGroupProceduresCPTCodeRelModelImpl
	extends BaseModelImpl<ProcedureGroupProceduresCPTCodeRel>
	implements ProcedureGroupProceduresCPTCodeRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a procedure group procedures cpt code rel model instance should use the <code>ProcedureGroupProceduresCPTCodeRel</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"proceduregroup_procedures_cptcode_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"pg_procedures_cpt_rel_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_date", Types.TIMESTAMP}, {"modified_by", Types.BIGINT},
		{"procedure_group_id", Types.BIGINT}, {"procedure_id", Types.BIGINT},
		{"cpt_code_id", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pg_procedures_cpt_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cpt_code_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table proceduregroup_procedures_cptcode_rel (uuid_ VARCHAR(75) null,pg_procedures_cpt_rel_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,created_by LONG,modified_date DATE null,modified_by LONG,procedure_group_id LONG,procedure_id LONG,cpt_code_id LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table proceduregroup_procedures_cptcode_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY procedureGroupProceduresCPTCodeRel.pgProcedureCptCodeRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY proceduregroup_procedures_cptcode_rel.pg_procedures_cpt_rel_id ASC";

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
	public static final long PROCEDUREGROUPID_COLUMN_BITMASK = 4L;

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
	public static final long PGPROCEDURECPTCODERELID_COLUMN_BITMASK = 16L;

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

	public ProcedureGroupProceduresCPTCodeRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _pgProcedureCptCodeRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPgProcedureCptCodeRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pgProcedureCptCodeRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcedureGroupProceduresCPTCodeRel.class;
	}

	@Override
	public String getModelClassName() {
		return ProcedureGroupProceduresCPTCodeRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureGroupProceduresCPTCodeRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(ProcedureGroupProceduresCPTCodeRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProcedureGroupProceduresCPTCodeRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProcedureGroupProceduresCPTCodeRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProcedureGroupProceduresCPTCodeRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProcedureGroupProceduresCPTCodeRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProcedureGroupProceduresCPTCodeRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<ProcedureGroupProceduresCPTCodeRel, Object>>();
		Map<String, BiConsumer<ProcedureGroupProceduresCPTCodeRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer<ProcedureGroupProceduresCPTCodeRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", ProcedureGroupProceduresCPTCodeRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, String>)
				ProcedureGroupProceduresCPTCodeRel::setUuid);
		attributeGetterFunctions.put(
			"pgProcedureCptCodeRelId",
			ProcedureGroupProceduresCPTCodeRel::getPgProcedureCptCodeRelId);
		attributeSetterBiConsumers.put(
			"pgProcedureCptCodeRelId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setPgProcedureCptCodeRelId);
		attributeGetterFunctions.put(
			"groupId", ProcedureGroupProceduresCPTCodeRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProcedureGroupProceduresCPTCodeRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ProcedureGroupProceduresCPTCodeRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Date>)
				ProcedureGroupProceduresCPTCodeRel::setCreateDate);
		attributeGetterFunctions.put(
			"createdBy", ProcedureGroupProceduresCPTCodeRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate",
			ProcedureGroupProceduresCPTCodeRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Date>)
				ProcedureGroupProceduresCPTCodeRel::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", ProcedureGroupProceduresCPTCodeRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setModifiedBy);
		attributeGetterFunctions.put(
			"procedureGroupId",
			ProcedureGroupProceduresCPTCodeRel::getProcedureGroupId);
		attributeSetterBiConsumers.put(
			"procedureGroupId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setProcedureGroupId);
		attributeGetterFunctions.put(
			"procedureId", ProcedureGroupProceduresCPTCodeRel::getProcedureId);
		attributeSetterBiConsumers.put(
			"procedureId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setProcedureId);
		attributeGetterFunctions.put(
			"cptCodeId", ProcedureGroupProceduresCPTCodeRel::getCptCodeId);
		attributeSetterBiConsumers.put(
			"cptCodeId",
			(BiConsumer<ProcedureGroupProceduresCPTCodeRel, Long>)
				ProcedureGroupProceduresCPTCodeRel::setCptCodeId);

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
	public long getPgProcedureCptCodeRelId() {
		return _pgProcedureCptCodeRelId;
	}

	@Override
	public void setPgProcedureCptCodeRelId(long pgProcedureCptCodeRelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_pgProcedureCptCodeRelId = pgProcedureCptCodeRelId;
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
	public long getProcedureGroupId() {
		return _procedureGroupId;
	}

	@Override
	public void setProcedureGroupId(long procedureGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureGroupId = procedureGroupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProcedureGroupId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("procedure_group_id"));
	}

	@JSON
	@Override
	public long getProcedureId() {
		return _procedureId;
	}

	@Override
	public void setProcedureId(long procedureId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedureId = procedureId;
	}

	@JSON
	@Override
	public long getCptCodeId() {
		return _cptCodeId;
	}

	@Override
	public void setCptCodeId(long cptCodeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cptCodeId = cptCodeId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				ProcedureGroupProceduresCPTCodeRel.class.getName()));
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
			getCompanyId(), ProcedureGroupProceduresCPTCodeRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProcedureGroupProceduresCPTCodeRel>
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
		ProcedureGroupProceduresCPTCodeRelImpl
			procedureGroupProceduresCPTCodeRelImpl =
				new ProcedureGroupProceduresCPTCodeRelImpl();

		procedureGroupProceduresCPTCodeRelImpl.setUuid(getUuid());
		procedureGroupProceduresCPTCodeRelImpl.setPgProcedureCptCodeRelId(
			getPgProcedureCptCodeRelId());
		procedureGroupProceduresCPTCodeRelImpl.setGroupId(getGroupId());
		procedureGroupProceduresCPTCodeRelImpl.setCompanyId(getCompanyId());
		procedureGroupProceduresCPTCodeRelImpl.setCreateDate(getCreateDate());
		procedureGroupProceduresCPTCodeRelImpl.setCreatedBy(getCreatedBy());
		procedureGroupProceduresCPTCodeRelImpl.setModifiedDate(
			getModifiedDate());
		procedureGroupProceduresCPTCodeRelImpl.setModifiedBy(getModifiedBy());
		procedureGroupProceduresCPTCodeRelImpl.setProcedureGroupId(
			getProcedureGroupId());
		procedureGroupProceduresCPTCodeRelImpl.setProcedureId(getProcedureId());
		procedureGroupProceduresCPTCodeRelImpl.setCptCodeId(getCptCodeId());

		procedureGroupProceduresCPTCodeRelImpl.resetOriginalValues();

		return procedureGroupProceduresCPTCodeRelImpl;
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRel cloneWithOriginalValues() {
		ProcedureGroupProceduresCPTCodeRelImpl
			procedureGroupProceduresCPTCodeRelImpl =
				new ProcedureGroupProceduresCPTCodeRelImpl();

		procedureGroupProceduresCPTCodeRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		procedureGroupProceduresCPTCodeRelImpl.setPgProcedureCptCodeRelId(
			this.<Long>getColumnOriginalValue("pg_procedures_cpt_rel_id"));
		procedureGroupProceduresCPTCodeRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		procedureGroupProceduresCPTCodeRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		procedureGroupProceduresCPTCodeRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		procedureGroupProceduresCPTCodeRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		procedureGroupProceduresCPTCodeRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		procedureGroupProceduresCPTCodeRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		procedureGroupProceduresCPTCodeRelImpl.setProcedureGroupId(
			this.<Long>getColumnOriginalValue("procedure_group_id"));
		procedureGroupProceduresCPTCodeRelImpl.setProcedureId(
			this.<Long>getColumnOriginalValue("procedure_id"));
		procedureGroupProceduresCPTCodeRelImpl.setCptCodeId(
			this.<Long>getColumnOriginalValue("cpt_code_id"));

		return procedureGroupProceduresCPTCodeRelImpl;
	}

	@Override
	public int compareTo(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		long primaryKey = procedureGroupProceduresCPTCodeRel.getPrimaryKey();

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

		if (!(object instanceof ProcedureGroupProceduresCPTCodeRel)) {
			return false;
		}

		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel =
			(ProcedureGroupProceduresCPTCodeRel)object;

		long primaryKey = procedureGroupProceduresCPTCodeRel.getPrimaryKey();

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
	public CacheModel<ProcedureGroupProceduresCPTCodeRel> toCacheModel() {
		ProcedureGroupProceduresCPTCodeRelCacheModel
			procedureGroupProceduresCPTCodeRelCacheModel =
				new ProcedureGroupProceduresCPTCodeRelCacheModel();

		procedureGroupProceduresCPTCodeRelCacheModel.uuid = getUuid();

		String uuid = procedureGroupProceduresCPTCodeRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			procedureGroupProceduresCPTCodeRelCacheModel.uuid = null;
		}

		procedureGroupProceduresCPTCodeRelCacheModel.pgProcedureCptCodeRelId =
			getPgProcedureCptCodeRelId();

		procedureGroupProceduresCPTCodeRelCacheModel.groupId = getGroupId();

		procedureGroupProceduresCPTCodeRelCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			procedureGroupProceduresCPTCodeRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			procedureGroupProceduresCPTCodeRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		procedureGroupProceduresCPTCodeRelCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			procedureGroupProceduresCPTCodeRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			procedureGroupProceduresCPTCodeRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		procedureGroupProceduresCPTCodeRelCacheModel.modifiedBy =
			getModifiedBy();

		procedureGroupProceduresCPTCodeRelCacheModel.procedureGroupId =
			getProcedureGroupId();

		procedureGroupProceduresCPTCodeRelCacheModel.procedureId =
			getProcedureId();

		procedureGroupProceduresCPTCodeRelCacheModel.cptCodeId = getCptCodeId();

		return procedureGroupProceduresCPTCodeRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<ProcedureGroupProceduresCPTCodeRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedureGroupProceduresCPTCodeRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProcedureGroupProceduresCPTCodeRel)this);

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
			<InvocationHandler, ProcedureGroupProceduresCPTCodeRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						ProcedureGroupProceduresCPTCodeRel.class,
						ModelWrapper.class);

	}

	private String _uuid;
	private long _pgProcedureCptCodeRelId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _procedureGroupId;
	private long _procedureId;
	private long _cptCodeId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProcedureGroupProceduresCPTCodeRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProcedureGroupProceduresCPTCodeRel)this);
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
			"pg_procedures_cpt_rel_id", _pgProcedureCptCodeRelId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("procedure_group_id", _procedureGroupId);
		_columnOriginalValues.put("procedure_id", _procedureId);
		_columnOriginalValues.put("cpt_code_id", _cptCodeId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"pg_procedures_cpt_rel_id", "pgProcedureCptCodeRelId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("procedure_group_id", "procedureGroupId");
		attributeNames.put("procedure_id", "procedureId");
		attributeNames.put("cpt_code_id", "cptCodeId");

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

		columnBitmasks.put("pg_procedures_cpt_rel_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("created_by", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("procedure_group_id", 256L);

		columnBitmasks.put("procedure_id", 512L);

		columnBitmasks.put("cpt_code_id", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProcedureGroupProceduresCPTCodeRel _escapedModel;

}