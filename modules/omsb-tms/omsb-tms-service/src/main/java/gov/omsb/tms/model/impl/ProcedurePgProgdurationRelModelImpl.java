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

import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProcedurePgProgdurationRelModel;

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
 * The base model implementation for the ProcedurePgProgdurationRel service. Represents a row in the &quot;procedure_pg_progduration_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProcedurePgProgdurationRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcedurePgProgdurationRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRelImpl
 * @generated
 */
@JSON(strict = true)
public class ProcedurePgProgdurationRelModelImpl
	extends BaseModelImpl<ProcedurePgProgdurationRel>
	implements ProcedurePgProgdurationRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a procedure pg progduration rel model instance should use the <code>ProcedurePgProgdurationRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "procedure_pg_progduration_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"procedure_pg_pd_rel_id", Types.BIGINT},
		{"procedure_group_master_id", Types.BIGINT},
		{"procedure_master_id", Types.BIGINT},
		{"program_duration_id", Types.BIGINT}, {"group_id", Types.BIGINT},
		{"company_id", Types.BIGINT}, {"create_date", Types.TIMESTAMP},
		{"modified_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_by", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("procedure_pg_pd_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_group_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("procedure_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("program_duration_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table procedure_pg_progduration_rel (uuid_ VARCHAR(75) null,procedure_pg_pd_rel_id LONG not null primary key,procedure_group_master_id LONG,procedure_master_id LONG,program_duration_id LONG,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table procedure_pg_progduration_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY procedurePgProgdurationRel.procedurePgPdRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY procedure_pg_progduration_rel.procedure_pg_pd_rel_id ASC";

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
	public static final long PROCEDUREMASTERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROGRAMDURATIONID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROCEDUREPGPDRELID_COLUMN_BITMASK = 64L;

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

	public ProcedurePgProgdurationRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _procedurePgPdRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcedurePgPdRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _procedurePgPdRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcedurePgProgdurationRel.class;
	}

	@Override
	public String getModelClassName() {
		return ProcedurePgProgdurationRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProcedurePgProgdurationRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProcedurePgProgdurationRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedurePgProgdurationRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(ProcedurePgProgdurationRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProcedurePgProgdurationRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProcedurePgProgdurationRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProcedurePgProgdurationRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProcedurePgProgdurationRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProcedurePgProgdurationRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<ProcedurePgProgdurationRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProcedurePgProgdurationRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProcedurePgProgdurationRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProcedurePgProgdurationRel, Object>>();
		Map<String, BiConsumer<ProcedurePgProgdurationRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ProcedurePgProgdurationRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", ProcedurePgProgdurationRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProcedurePgProgdurationRel, String>)
				ProcedurePgProgdurationRel::setUuid);
		attributeGetterFunctions.put(
			"procedurePgPdRelId",
			ProcedurePgProgdurationRel::getProcedurePgPdRelId);
		attributeSetterBiConsumers.put(
			"procedurePgPdRelId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setProcedurePgPdRelId);
		attributeGetterFunctions.put(
			"procedureGroupMasterId",
			ProcedurePgProgdurationRel::getProcedureGroupMasterId);
		attributeSetterBiConsumers.put(
			"procedureGroupMasterId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setProcedureGroupMasterId);
		attributeGetterFunctions.put(
			"procedureMasterId",
			ProcedurePgProgdurationRel::getProcedureMasterId);
		attributeSetterBiConsumers.put(
			"procedureMasterId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setProcedureMasterId);
		attributeGetterFunctions.put(
			"programDurationId",
			ProcedurePgProgdurationRel::getProgramDurationId);
		attributeSetterBiConsumers.put(
			"programDurationId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setProgramDurationId);
		attributeGetterFunctions.put(
			"groupId", ProcedurePgProgdurationRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProcedurePgProgdurationRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ProcedurePgProgdurationRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProcedurePgProgdurationRel, Date>)
				ProcedurePgProgdurationRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProcedurePgProgdurationRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProcedurePgProgdurationRel, Date>)
				ProcedurePgProgdurationRel::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", ProcedurePgProgdurationRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", ProcedurePgProgdurationRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProcedurePgProgdurationRel, Long>)
				ProcedurePgProgdurationRel::setModifiedBy);

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
	public long getProcedurePgPdRelId() {
		return _procedurePgPdRelId;
	}

	@Override
	public void setProcedurePgPdRelId(long procedurePgPdRelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_procedurePgPdRelId = procedurePgPdRelId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProcedureMasterId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("procedure_master_id"));
	}

	@JSON
	@Override
	public long getProgramDurationId() {
		return _programDurationId;
	}

	@Override
	public void setProgramDurationId(long programDurationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_programDurationId = programDurationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProgramDurationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("program_duration_id"));
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

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				ProcedurePgProgdurationRel.class.getName()));
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
			getCompanyId(), ProcedurePgProgdurationRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProcedurePgProgdurationRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProcedurePgProgdurationRel>
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
		ProcedurePgProgdurationRelImpl procedurePgProgdurationRelImpl =
			new ProcedurePgProgdurationRelImpl();

		procedurePgProgdurationRelImpl.setUuid(getUuid());
		procedurePgProgdurationRelImpl.setProcedurePgPdRelId(
			getProcedurePgPdRelId());
		procedurePgProgdurationRelImpl.setProcedureGroupMasterId(
			getProcedureGroupMasterId());
		procedurePgProgdurationRelImpl.setProcedureMasterId(
			getProcedureMasterId());
		procedurePgProgdurationRelImpl.setProgramDurationId(
			getProgramDurationId());
		procedurePgProgdurationRelImpl.setGroupId(getGroupId());
		procedurePgProgdurationRelImpl.setCompanyId(getCompanyId());
		procedurePgProgdurationRelImpl.setCreateDate(getCreateDate());
		procedurePgProgdurationRelImpl.setModifiedDate(getModifiedDate());
		procedurePgProgdurationRelImpl.setCreatedBy(getCreatedBy());
		procedurePgProgdurationRelImpl.setModifiedBy(getModifiedBy());

		procedurePgProgdurationRelImpl.resetOriginalValues();

		return procedurePgProgdurationRelImpl;
	}

	@Override
	public ProcedurePgProgdurationRel cloneWithOriginalValues() {
		ProcedurePgProgdurationRelImpl procedurePgProgdurationRelImpl =
			new ProcedurePgProgdurationRelImpl();

		procedurePgProgdurationRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		procedurePgProgdurationRelImpl.setProcedurePgPdRelId(
			this.<Long>getColumnOriginalValue("procedure_pg_pd_rel_id"));
		procedurePgProgdurationRelImpl.setProcedureGroupMasterId(
			this.<Long>getColumnOriginalValue("procedure_group_master_id"));
		procedurePgProgdurationRelImpl.setProcedureMasterId(
			this.<Long>getColumnOriginalValue("procedure_master_id"));
		procedurePgProgdurationRelImpl.setProgramDurationId(
			this.<Long>getColumnOriginalValue("program_duration_id"));
		procedurePgProgdurationRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		procedurePgProgdurationRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		procedurePgProgdurationRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		procedurePgProgdurationRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		procedurePgProgdurationRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		procedurePgProgdurationRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));

		return procedurePgProgdurationRelImpl;
	}

	@Override
	public int compareTo(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		long primaryKey = procedurePgProgdurationRel.getPrimaryKey();

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

		if (!(object instanceof ProcedurePgProgdurationRel)) {
			return false;
		}

		ProcedurePgProgdurationRel procedurePgProgdurationRel =
			(ProcedurePgProgdurationRel)object;

		long primaryKey = procedurePgProgdurationRel.getPrimaryKey();

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
	public CacheModel<ProcedurePgProgdurationRel> toCacheModel() {
		ProcedurePgProgdurationRelCacheModel
			procedurePgProgdurationRelCacheModel =
				new ProcedurePgProgdurationRelCacheModel();

		procedurePgProgdurationRelCacheModel.uuid = getUuid();

		String uuid = procedurePgProgdurationRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			procedurePgProgdurationRelCacheModel.uuid = null;
		}

		procedurePgProgdurationRelCacheModel.procedurePgPdRelId =
			getProcedurePgPdRelId();

		procedurePgProgdurationRelCacheModel.procedureGroupMasterId =
			getProcedureGroupMasterId();

		procedurePgProgdurationRelCacheModel.procedureMasterId =
			getProcedureMasterId();

		procedurePgProgdurationRelCacheModel.programDurationId =
			getProgramDurationId();

		procedurePgProgdurationRelCacheModel.groupId = getGroupId();

		procedurePgProgdurationRelCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			procedurePgProgdurationRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			procedurePgProgdurationRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			procedurePgProgdurationRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			procedurePgProgdurationRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		procedurePgProgdurationRelCacheModel.createdBy = getCreatedBy();

		procedurePgProgdurationRelCacheModel.modifiedBy = getModifiedBy();

		return procedurePgProgdurationRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProcedurePgProgdurationRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProcedurePgProgdurationRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProcedurePgProgdurationRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProcedurePgProgdurationRel)this);

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
			<InvocationHandler, ProcedurePgProgdurationRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						ProcedurePgProgdurationRel.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _procedurePgPdRelId;
	private long _procedureGroupMasterId;
	private long _procedureMasterId;
	private long _programDurationId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProcedurePgProgdurationRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProcedurePgProgdurationRel)this);
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
			"procedure_pg_pd_rel_id", _procedurePgPdRelId);
		_columnOriginalValues.put(
			"procedure_group_master_id", _procedureGroupMasterId);
		_columnOriginalValues.put("procedure_master_id", _procedureMasterId);
		_columnOriginalValues.put("program_duration_id", _programDurationId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("procedure_pg_pd_rel_id", "procedurePgPdRelId");
		attributeNames.put(
			"procedure_group_master_id", "procedureGroupMasterId");
		attributeNames.put("procedure_master_id", "procedureMasterId");
		attributeNames.put("program_duration_id", "programDurationId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");

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

		columnBitmasks.put("procedure_pg_pd_rel_id", 2L);

		columnBitmasks.put("procedure_group_master_id", 4L);

		columnBitmasks.put("procedure_master_id", 8L);

		columnBitmasks.put("program_duration_id", 16L);

		columnBitmasks.put("group_id", 32L);

		columnBitmasks.put("company_id", 64L);

		columnBitmasks.put("create_date", 128L);

		columnBitmasks.put("modified_date", 256L);

		columnBitmasks.put("created_by", 512L);

		columnBitmasks.put("modified_by", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProcedurePgProgdurationRel _escapedModel;

}