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

import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRelModel;

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
 * The base model implementation for the ProgdurationTraineelevelBlocksLevelTypeRel service. Represents a row in the &quot;progduration_traineelevel_blocks_leveltype_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProgdurationTraineelevelBlocksLevelTypeRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProgdurationTraineelevelBlocksLevelTypeRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRelImpl
 * @generated
 */
@JSON(strict = true)
public class ProgdurationTraineelevelBlocksLevelTypeRelModelImpl
	extends BaseModelImpl<ProgdurationTraineelevelBlocksLevelTypeRel>
	implements ProgdurationTraineelevelBlocksLevelTypeRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a progduration traineelevel blocks level type rel model instance should use the <code>ProgdurationTraineelevelBlocksLevelTypeRel</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"progduration_traineelevel_blocks_leveltype_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"progduration_tl_blocks_lt_id", Types.BIGINT},
		{"program_duration_id", Types.BIGINT}, {"level_type_id", Types.BIGINT},
		{"trainee_level_id", Types.BIGINT}, {"group_id", Types.BIGINT},
		{"company_id", Types.BIGINT}, {"create_date", Types.TIMESTAMP},
		{"modified_date", Types.TIMESTAMP}, {"no_of_blocks", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("progduration_tl_blocks_lt_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("program_duration_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("level_type_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trainee_level_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("no_of_blocks", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table progduration_traineelevel_blocks_leveltype_rel (uuid_ VARCHAR(75) null,progduration_tl_blocks_lt_id LONG not null primary key,program_duration_id LONG,level_type_id LONG,trainee_level_id LONG,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,no_of_blocks INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table progduration_traineelevel_blocks_leveltype_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY progdurationTraineelevelBlocksLevelTypeRel.progdurationTlBlocksLtId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY progduration_traineelevel_blocks_leveltype_rel.progduration_tl_blocks_lt_id ASC";

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
	public static final long PROGRAMDURATIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAINEELEVELID_COLUMN_BITMASK = 8L;

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
	public static final long PROGDURATIONTLBLOCKSLTID_COLUMN_BITMASK = 32L;

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

	public ProgdurationTraineelevelBlocksLevelTypeRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _progdurationTlBlocksLtId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProgdurationTlBlocksLtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _progdurationTlBlocksLtId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProgdurationTraineelevelBlocksLevelTypeRel.class;
	}

	@Override
	public String getModelClassName() {
		return ProgdurationTraineelevelBlocksLevelTypeRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map
			<String,
			 Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
				attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String,
				 Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(ProgdurationTraineelevelBlocksLevelTypeRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map
			<String,
			 BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
				attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProgdurationTraineelevelBlocksLevelTypeRel)this,
					entry.getValue());
			}
		}
	}

	public Map
		<String, Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
			getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map
		<String, BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
			getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map
			<String,
			 Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
				attributeGetterFunctions =
					new LinkedHashMap
						<String,
						 Function
							 <ProgdurationTraineelevelBlocksLevelTypeRel,
							  Object>>();
		Map<String, BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer
						 <ProgdurationTraineelevelBlocksLevelTypeRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", ProgdurationTraineelevelBlocksLevelTypeRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, String>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setUuid);
		attributeGetterFunctions.put(
			"progdurationTlBlocksLtId",
			ProgdurationTraineelevelBlocksLevelTypeRel::
				getProgdurationTlBlocksLtId);
		attributeSetterBiConsumers.put(
			"progdurationTlBlocksLtId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::
					setProgdurationTlBlocksLtId);
		attributeGetterFunctions.put(
			"programDurationId",
			ProgdurationTraineelevelBlocksLevelTypeRel::getProgramDurationId);
		attributeSetterBiConsumers.put(
			"programDurationId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::
					setProgramDurationId);
		attributeGetterFunctions.put(
			"levelTypeId",
			ProgdurationTraineelevelBlocksLevelTypeRel::getLevelTypeId);
		attributeSetterBiConsumers.put(
			"levelTypeId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setLevelTypeId);
		attributeGetterFunctions.put(
			"traineeLevelId",
			ProgdurationTraineelevelBlocksLevelTypeRel::getTraineeLevelId);
		attributeSetterBiConsumers.put(
			"traineeLevelId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setTraineeLevelId);
		attributeGetterFunctions.put(
			"groupId", ProgdurationTraineelevelBlocksLevelTypeRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId",
			ProgdurationTraineelevelBlocksLevelTypeRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Long>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate",
			ProgdurationTraineelevelBlocksLevelTypeRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Date>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate",
			ProgdurationTraineelevelBlocksLevelTypeRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Date>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setModifiedDate);
		attributeGetterFunctions.put(
			"noOfBlocks",
			ProgdurationTraineelevelBlocksLevelTypeRel::getNoOfBlocks);
		attributeSetterBiConsumers.put(
			"noOfBlocks",
			(BiConsumer<ProgdurationTraineelevelBlocksLevelTypeRel, Integer>)
				ProgdurationTraineelevelBlocksLevelTypeRel::setNoOfBlocks);

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
	public long getProgdurationTlBlocksLtId() {
		return _progdurationTlBlocksLtId;
	}

	@Override
	public void setProgdurationTlBlocksLtId(long progdurationTlBlocksLtId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progdurationTlBlocksLtId = progdurationTlBlocksLtId;
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
	public long getLevelTypeId() {
		return _levelTypeId;
	}

	@Override
	public void setLevelTypeId(long levelTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_levelTypeId = levelTypeId;
	}

	@JSON
	@Override
	public long getTraineeLevelId() {
		return _traineeLevelId;
	}

	@Override
	public void setTraineeLevelId(long traineeLevelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_traineeLevelId = traineeLevelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTraineeLevelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("trainee_level_id"));
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
	public int getNoOfBlocks() {
		return _noOfBlocks;
	}

	@Override
	public void setNoOfBlocks(int noOfBlocks) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_noOfBlocks = noOfBlocks;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				ProgdurationTraineelevelBlocksLevelTypeRel.class.getName()));
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
			getCompanyId(),
			ProgdurationTraineelevelBlocksLevelTypeRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel toEscapedModel() {
		if (_escapedModel == null) {
			Function
				<InvocationHandler, ProgdurationTraineelevelBlocksLevelTypeRel>
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
		ProgdurationTraineelevelBlocksLevelTypeRelImpl
			progdurationTraineelevelBlocksLevelTypeRelImpl =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl();

		progdurationTraineelevelBlocksLevelTypeRelImpl.setUuid(getUuid());
		progdurationTraineelevelBlocksLevelTypeRelImpl.
			setProgdurationTlBlocksLtId(getProgdurationTlBlocksLtId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setProgramDurationId(
			getProgramDurationId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setLevelTypeId(
			getLevelTypeId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setTraineeLevelId(
			getTraineeLevelId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setGroupId(getGroupId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setCompanyId(
			getCompanyId());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setCreateDate(
			getCreateDate());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setModifiedDate(
			getModifiedDate());
		progdurationTraineelevelBlocksLevelTypeRelImpl.setNoOfBlocks(
			getNoOfBlocks());

		progdurationTraineelevelBlocksLevelTypeRelImpl.resetOriginalValues();

		return progdurationTraineelevelBlocksLevelTypeRelImpl;
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRel
		cloneWithOriginalValues() {

		ProgdurationTraineelevelBlocksLevelTypeRelImpl
			progdurationTraineelevelBlocksLevelTypeRelImpl =
				new ProgdurationTraineelevelBlocksLevelTypeRelImpl();

		progdurationTraineelevelBlocksLevelTypeRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.
			setProgdurationTlBlocksLtId(
				this.<Long>getColumnOriginalValue(
					"progduration_tl_blocks_lt_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setProgramDurationId(
			this.<Long>getColumnOriginalValue("program_duration_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setLevelTypeId(
			this.<Long>getColumnOriginalValue("level_type_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setTraineeLevelId(
			this.<Long>getColumnOriginalValue("trainee_level_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		progdurationTraineelevelBlocksLevelTypeRelImpl.setNoOfBlocks(
			this.<Integer>getColumnOriginalValue("no_of_blocks"));

		return progdurationTraineelevelBlocksLevelTypeRelImpl;
	}

	@Override
	public int compareTo(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		long primaryKey =
			progdurationTraineelevelBlocksLevelTypeRel.getPrimaryKey();

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

		if (!(object instanceof ProgdurationTraineelevelBlocksLevelTypeRel)) {
			return false;
		}

		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel =
				(ProgdurationTraineelevelBlocksLevelTypeRel)object;

		long primaryKey =
			progdurationTraineelevelBlocksLevelTypeRel.getPrimaryKey();

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
	public CacheModel<ProgdurationTraineelevelBlocksLevelTypeRel>
		toCacheModel() {

		ProgdurationTraineelevelBlocksLevelTypeRelCacheModel
			progdurationTraineelevelBlocksLevelTypeRelCacheModel =
				new ProgdurationTraineelevelBlocksLevelTypeRelCacheModel();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.uuid = getUuid();

		String uuid = progdurationTraineelevelBlocksLevelTypeRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			progdurationTraineelevelBlocksLevelTypeRelCacheModel.uuid = null;
		}

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.
			progdurationTlBlocksLtId = getProgdurationTlBlocksLtId();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.programDurationId =
			getProgramDurationId();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.levelTypeId =
			getLevelTypeId();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.traineeLevelId =
			getTraineeLevelId();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.groupId =
			getGroupId();

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.companyId =
			getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			progdurationTraineelevelBlocksLevelTypeRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			progdurationTraineelevelBlocksLevelTypeRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			progdurationTraineelevelBlocksLevelTypeRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			progdurationTraineelevelBlocksLevelTypeRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		progdurationTraineelevelBlocksLevelTypeRelCacheModel.noOfBlocks =
			getNoOfBlocks();

		return progdurationTraineelevelBlocksLevelTypeRelCacheModel;
	}

	@Override
	public String toString() {
		Map
			<String,
			 Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
				attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String,
				 Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProgdurationTraineelevelBlocksLevelTypeRel)this);

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
			<InvocationHandler, ProgdurationTraineelevelBlocksLevelTypeRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						ProgdurationTraineelevelBlocksLevelTypeRel.class,
						ModelWrapper.class);

	}

	private String _uuid;
	private long _progdurationTlBlocksLtId;
	private long _programDurationId;
	private long _levelTypeId;
	private long _traineeLevelId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _noOfBlocks;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProgdurationTraineelevelBlocksLevelTypeRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply(
			(ProgdurationTraineelevelBlocksLevelTypeRel)this);
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
			"progduration_tl_blocks_lt_id", _progdurationTlBlocksLtId);
		_columnOriginalValues.put("program_duration_id", _programDurationId);
		_columnOriginalValues.put("level_type_id", _levelTypeId);
		_columnOriginalValues.put("trainee_level_id", _traineeLevelId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("no_of_blocks", _noOfBlocks);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"progduration_tl_blocks_lt_id", "progdurationTlBlocksLtId");
		attributeNames.put("program_duration_id", "programDurationId");
		attributeNames.put("level_type_id", "levelTypeId");
		attributeNames.put("trainee_level_id", "traineeLevelId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("no_of_blocks", "noOfBlocks");

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

		columnBitmasks.put("progduration_tl_blocks_lt_id", 2L);

		columnBitmasks.put("program_duration_id", 4L);

		columnBitmasks.put("level_type_id", 8L);

		columnBitmasks.put("trainee_level_id", 16L);

		columnBitmasks.put("group_id", 32L);

		columnBitmasks.put("company_id", 64L);

		columnBitmasks.put("create_date", 128L);

		columnBitmasks.put("modified_date", 256L);

		columnBitmasks.put("no_of_blocks", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProgdurationTraineelevelBlocksLevelTypeRel _escapedModel;

}