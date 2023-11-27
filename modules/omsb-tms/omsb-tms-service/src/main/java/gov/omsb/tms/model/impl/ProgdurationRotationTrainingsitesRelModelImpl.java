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

import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRelModel;

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
 * The base model implementation for the ProgdurationRotationTrainingsitesRel service. Represents a row in the &quot;progduration_rotation_trainingsites_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProgdurationRotationTrainingsitesRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProgdurationRotationTrainingsitesRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelImpl
 * @generated
 */
@JSON(strict = true)
public class ProgdurationRotationTrainingsitesRelModelImpl
	extends BaseModelImpl<ProgdurationRotationTrainingsitesRel>
	implements ProgdurationRotationTrainingsitesRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a progduration rotation trainingsites rel model instance should use the <code>ProgdurationRotationTrainingsitesRel</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"progduration_rotation_trainingsites_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"progduration_rotation_ts_rel_id", Types.BIGINT},
		{"program_duration_id", Types.BIGINT}, {"rotation_id", Types.BIGINT},
		{"training_sites_id", Types.BIGINT}, {"group_id", Types.BIGINT},
		{"company_id", Types.BIGINT}, {"create_date", Types.TIMESTAMP},
		{"modified_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_by", Types.BIGINT}, {"is_shared_rotation", Types.BOOLEAN},
		{"rotation_owning_program_id", Types.BIGINT},
		{"progcode_rsn_sitecode", Types.VARCHAR},
		{"owning_program_duration_id", Types.BIGINT},
		{"no_of_slots", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("progduration_rotation_ts_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("program_duration_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rotation_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("training_sites_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("is_shared_rotation", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("rotation_owning_program_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("progcode_rsn_sitecode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("owning_program_duration_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("no_of_slots", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table progduration_rotation_trainingsites_rel (uuid_ VARCHAR(75) null,progduration_rotation_ts_rel_id LONG not null primary key,program_duration_id LONG,rotation_id LONG,training_sites_id LONG,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG,is_shared_rotation BOOLEAN,rotation_owning_program_id LONG,progcode_rsn_sitecode VARCHAR(75) null,owning_program_duration_id LONG,no_of_slots INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table progduration_rotation_trainingsites_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY progdurationRotationTrainingsitesRel.progdurationRotationTsRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY progduration_rotation_trainingsites_rel.progduration_rotation_ts_rel_id ASC";

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
	public static final long ISSHAREDROTATION_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROGRAMDURATIONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROTATIONID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROTATIONOWNINGPROGRAMID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAININGSITESID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROGDURATIONROTATIONTSRELID_COLUMN_BITMASK = 256L;

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

	public ProgdurationRotationTrainingsitesRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _progdurationRotationTsRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProgdurationRotationTsRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _progdurationRotationTsRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProgdurationRotationTrainingsitesRel.class;
	}

	@Override
	public String getModelClassName() {
		return ProgdurationRotationTrainingsitesRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProgdurationRotationTrainingsitesRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(ProgdurationRotationTrainingsitesRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProgdurationRotationTrainingsitesRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProgdurationRotationTrainingsitesRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProgdurationRotationTrainingsitesRel)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProgdurationRotationTrainingsitesRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProgdurationRotationTrainingsitesRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<ProgdurationRotationTrainingsitesRel, Object>>();
		Map<String, BiConsumer<ProgdurationRotationTrainingsitesRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String,
					 BiConsumer<ProgdurationRotationTrainingsitesRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", ProgdurationRotationTrainingsitesRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, String>)
				ProgdurationRotationTrainingsitesRel::setUuid);
		attributeGetterFunctions.put(
			"progdurationRotationTsRelId",
			ProgdurationRotationTrainingsitesRel::
				getProgdurationRotationTsRelId);
		attributeSetterBiConsumers.put(
			"progdurationRotationTsRelId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::
					setProgdurationRotationTsRelId);
		attributeGetterFunctions.put(
			"programDurationId",
			ProgdurationRotationTrainingsitesRel::getProgramDurationId);
		attributeSetterBiConsumers.put(
			"programDurationId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setProgramDurationId);
		attributeGetterFunctions.put(
			"rotationId", ProgdurationRotationTrainingsitesRel::getRotationId);
		attributeSetterBiConsumers.put(
			"rotationId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setRotationId);
		attributeGetterFunctions.put(
			"trainingSitesId",
			ProgdurationRotationTrainingsitesRel::getTrainingSitesId);
		attributeSetterBiConsumers.put(
			"trainingSitesId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setTrainingSitesId);
		attributeGetterFunctions.put(
			"groupId", ProgdurationRotationTrainingsitesRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProgdurationRotationTrainingsitesRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ProgdurationRotationTrainingsitesRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Date>)
				ProgdurationRotationTrainingsitesRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate",
			ProgdurationRotationTrainingsitesRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Date>)
				ProgdurationRotationTrainingsitesRel::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", ProgdurationRotationTrainingsitesRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", ProgdurationRotationTrainingsitesRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::setModifiedBy);
		attributeGetterFunctions.put(
			"isSharedRotation",
			ProgdurationRotationTrainingsitesRel::getIsSharedRotation);
		attributeSetterBiConsumers.put(
			"isSharedRotation",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Boolean>)
				ProgdurationRotationTrainingsitesRel::setIsSharedRotation);
		attributeGetterFunctions.put(
			"rotationOwningProgramId",
			ProgdurationRotationTrainingsitesRel::getRotationOwningProgramId);
		attributeSetterBiConsumers.put(
			"rotationOwningProgramId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::
					setRotationOwningProgramId);
		attributeGetterFunctions.put(
			"progCodeRsnSiteCode",
			ProgdurationRotationTrainingsitesRel::getProgCodeRsnSiteCode);
		attributeSetterBiConsumers.put(
			"progCodeRsnSiteCode",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, String>)
				ProgdurationRotationTrainingsitesRel::setProgCodeRsnSiteCode);
		attributeGetterFunctions.put(
			"owningProgramDurationId",
			ProgdurationRotationTrainingsitesRel::getOwningProgramDurationId);
		attributeSetterBiConsumers.put(
			"owningProgramDurationId",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Long>)
				ProgdurationRotationTrainingsitesRel::
					setOwningProgramDurationId);
		attributeGetterFunctions.put(
			"noOfSlots", ProgdurationRotationTrainingsitesRel::getNoOfSlots);
		attributeSetterBiConsumers.put(
			"noOfSlots",
			(BiConsumer<ProgdurationRotationTrainingsitesRel, Integer>)
				ProgdurationRotationTrainingsitesRel::setNoOfSlots);

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
	public long getProgdurationRotationTsRelId() {
		return _progdurationRotationTsRelId;
	}

	@Override
	public void setProgdurationRotationTsRelId(
		long progdurationRotationTsRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progdurationRotationTsRelId = progdurationRotationTsRelId;
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
	public long getRotationId() {
		return _rotationId;
	}

	@Override
	public void setRotationId(long rotationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rotationId = rotationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRotationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("rotation_id"));
	}

	@JSON
	@Override
	public long getTrainingSitesId() {
		return _trainingSitesId;
	}

	@Override
	public void setTrainingSitesId(long trainingSitesId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trainingSitesId = trainingSitesId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTrainingSitesId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("training_sites_id"));
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
	public boolean getIsSharedRotation() {
		return _isSharedRotation;
	}

	@JSON
	@Override
	public boolean isIsSharedRotation() {
		return _isSharedRotation;
	}

	@Override
	public void setIsSharedRotation(boolean isSharedRotation) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isSharedRotation = isSharedRotation;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsSharedRotation() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("is_shared_rotation"));
	}

	@JSON
	@Override
	public long getRotationOwningProgramId() {
		return _rotationOwningProgramId;
	}

	@Override
	public void setRotationOwningProgramId(long rotationOwningProgramId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rotationOwningProgramId = rotationOwningProgramId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRotationOwningProgramId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("rotation_owning_program_id"));
	}

	@JSON
	@Override
	public String getProgCodeRsnSiteCode() {
		if (_progCodeRsnSiteCode == null) {
			return "";
		}
		else {
			return _progCodeRsnSiteCode;
		}
	}

	@Override
	public void setProgCodeRsnSiteCode(String progCodeRsnSiteCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progCodeRsnSiteCode = progCodeRsnSiteCode;
	}

	@JSON
	@Override
	public long getOwningProgramDurationId() {
		return _owningProgramDurationId;
	}

	@Override
	public void setOwningProgramDurationId(long owningProgramDurationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_owningProgramDurationId = owningProgramDurationId;
	}

	@JSON
	@Override
	public int getNoOfSlots() {
		return _noOfSlots;
	}

	@Override
	public void setNoOfSlots(int noOfSlots) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_noOfSlots = noOfSlots;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				ProgdurationRotationTrainingsitesRel.class.getName()));
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
			ProgdurationRotationTrainingsitesRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProgdurationRotationTrainingsitesRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProgdurationRotationTrainingsitesRel>
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
		ProgdurationRotationTrainingsitesRelImpl
			progdurationRotationTrainingsitesRelImpl =
				new ProgdurationRotationTrainingsitesRelImpl();

		progdurationRotationTrainingsitesRelImpl.setUuid(getUuid());
		progdurationRotationTrainingsitesRelImpl.setProgdurationRotationTsRelId(
			getProgdurationRotationTsRelId());
		progdurationRotationTrainingsitesRelImpl.setProgramDurationId(
			getProgramDurationId());
		progdurationRotationTrainingsitesRelImpl.setRotationId(getRotationId());
		progdurationRotationTrainingsitesRelImpl.setTrainingSitesId(
			getTrainingSitesId());
		progdurationRotationTrainingsitesRelImpl.setGroupId(getGroupId());
		progdurationRotationTrainingsitesRelImpl.setCompanyId(getCompanyId());
		progdurationRotationTrainingsitesRelImpl.setCreateDate(getCreateDate());
		progdurationRotationTrainingsitesRelImpl.setModifiedDate(
			getModifiedDate());
		progdurationRotationTrainingsitesRelImpl.setCreatedBy(getCreatedBy());
		progdurationRotationTrainingsitesRelImpl.setModifiedBy(getModifiedBy());
		progdurationRotationTrainingsitesRelImpl.setIsSharedRotation(
			isIsSharedRotation());
		progdurationRotationTrainingsitesRelImpl.setRotationOwningProgramId(
			getRotationOwningProgramId());
		progdurationRotationTrainingsitesRelImpl.setProgCodeRsnSiteCode(
			getProgCodeRsnSiteCode());
		progdurationRotationTrainingsitesRelImpl.setOwningProgramDurationId(
			getOwningProgramDurationId());
		progdurationRotationTrainingsitesRelImpl.setNoOfSlots(getNoOfSlots());

		progdurationRotationTrainingsitesRelImpl.resetOriginalValues();

		return progdurationRotationTrainingsitesRelImpl;
	}

	@Override
	public ProgdurationRotationTrainingsitesRel cloneWithOriginalValues() {
		ProgdurationRotationTrainingsitesRelImpl
			progdurationRotationTrainingsitesRelImpl =
				new ProgdurationRotationTrainingsitesRelImpl();

		progdurationRotationTrainingsitesRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		progdurationRotationTrainingsitesRelImpl.setProgdurationRotationTsRelId(
			this.<Long>getColumnOriginalValue(
				"progduration_rotation_ts_rel_id"));
		progdurationRotationTrainingsitesRelImpl.setProgramDurationId(
			this.<Long>getColumnOriginalValue("program_duration_id"));
		progdurationRotationTrainingsitesRelImpl.setRotationId(
			this.<Long>getColumnOriginalValue("rotation_id"));
		progdurationRotationTrainingsitesRelImpl.setTrainingSitesId(
			this.<Long>getColumnOriginalValue("training_sites_id"));
		progdurationRotationTrainingsitesRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		progdurationRotationTrainingsitesRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		progdurationRotationTrainingsitesRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		progdurationRotationTrainingsitesRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		progdurationRotationTrainingsitesRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		progdurationRotationTrainingsitesRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		progdurationRotationTrainingsitesRelImpl.setIsSharedRotation(
			this.<Boolean>getColumnOriginalValue("is_shared_rotation"));
		progdurationRotationTrainingsitesRelImpl.setRotationOwningProgramId(
			this.<Long>getColumnOriginalValue("rotation_owning_program_id"));
		progdurationRotationTrainingsitesRelImpl.setProgCodeRsnSiteCode(
			this.<String>getColumnOriginalValue("progcode_rsn_sitecode"));
		progdurationRotationTrainingsitesRelImpl.setOwningProgramDurationId(
			this.<Long>getColumnOriginalValue("owning_program_duration_id"));
		progdurationRotationTrainingsitesRelImpl.setNoOfSlots(
			this.<Integer>getColumnOriginalValue("no_of_slots"));

		return progdurationRotationTrainingsitesRelImpl;
	}

	@Override
	public int compareTo(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		long primaryKey = progdurationRotationTrainingsitesRel.getPrimaryKey();

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

		if (!(object instanceof ProgdurationRotationTrainingsitesRel)) {
			return false;
		}

		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel =
				(ProgdurationRotationTrainingsitesRel)object;

		long primaryKey = progdurationRotationTrainingsitesRel.getPrimaryKey();

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
	public CacheModel<ProgdurationRotationTrainingsitesRel> toCacheModel() {
		ProgdurationRotationTrainingsitesRelCacheModel
			progdurationRotationTrainingsitesRelCacheModel =
				new ProgdurationRotationTrainingsitesRelCacheModel();

		progdurationRotationTrainingsitesRelCacheModel.uuid = getUuid();

		String uuid = progdurationRotationTrainingsitesRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			progdurationRotationTrainingsitesRelCacheModel.uuid = null;
		}

		progdurationRotationTrainingsitesRelCacheModel.
			progdurationRotationTsRelId = getProgdurationRotationTsRelId();

		progdurationRotationTrainingsitesRelCacheModel.programDurationId =
			getProgramDurationId();

		progdurationRotationTrainingsitesRelCacheModel.rotationId =
			getRotationId();

		progdurationRotationTrainingsitesRelCacheModel.trainingSitesId =
			getTrainingSitesId();

		progdurationRotationTrainingsitesRelCacheModel.groupId = getGroupId();

		progdurationRotationTrainingsitesRelCacheModel.companyId =
			getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			progdurationRotationTrainingsitesRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			progdurationRotationTrainingsitesRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			progdurationRotationTrainingsitesRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			progdurationRotationTrainingsitesRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		progdurationRotationTrainingsitesRelCacheModel.createdBy =
			getCreatedBy();

		progdurationRotationTrainingsitesRelCacheModel.modifiedBy =
			getModifiedBy();

		progdurationRotationTrainingsitesRelCacheModel.isSharedRotation =
			isIsSharedRotation();

		progdurationRotationTrainingsitesRelCacheModel.rotationOwningProgramId =
			getRotationOwningProgramId();

		progdurationRotationTrainingsitesRelCacheModel.progCodeRsnSiteCode =
			getProgCodeRsnSiteCode();

		String progCodeRsnSiteCode =
			progdurationRotationTrainingsitesRelCacheModel.progCodeRsnSiteCode;

		if ((progCodeRsnSiteCode != null) &&
			(progCodeRsnSiteCode.length() == 0)) {

			progdurationRotationTrainingsitesRelCacheModel.progCodeRsnSiteCode =
				null;
		}

		progdurationRotationTrainingsitesRelCacheModel.owningProgramDurationId =
			getOwningProgramDurationId();

		progdurationRotationTrainingsitesRelCacheModel.noOfSlots =
			getNoOfSlots();

		return progdurationRotationTrainingsitesRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<ProgdurationRotationTrainingsitesRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProgdurationRotationTrainingsitesRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProgdurationRotationTrainingsitesRel)this);

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
			<InvocationHandler, ProgdurationRotationTrainingsitesRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						ProgdurationRotationTrainingsitesRel.class,
						ModelWrapper.class);

	}

	private String _uuid;
	private long _progdurationRotationTsRelId;
	private long _programDurationId;
	private long _rotationId;
	private long _trainingSitesId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private boolean _isSharedRotation;
	private long _rotationOwningProgramId;
	private String _progCodeRsnSiteCode;
	private long _owningProgramDurationId;
	private int _noOfSlots;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProgdurationRotationTrainingsitesRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProgdurationRotationTrainingsitesRel)this);
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
			"progduration_rotation_ts_rel_id", _progdurationRotationTsRelId);
		_columnOriginalValues.put("program_duration_id", _programDurationId);
		_columnOriginalValues.put("rotation_id", _rotationId);
		_columnOriginalValues.put("training_sites_id", _trainingSitesId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("is_shared_rotation", _isSharedRotation);
		_columnOriginalValues.put(
			"rotation_owning_program_id", _rotationOwningProgramId);
		_columnOriginalValues.put(
			"progcode_rsn_sitecode", _progCodeRsnSiteCode);
		_columnOriginalValues.put(
			"owning_program_duration_id", _owningProgramDurationId);
		_columnOriginalValues.put("no_of_slots", _noOfSlots);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"progduration_rotation_ts_rel_id", "progdurationRotationTsRelId");
		attributeNames.put("program_duration_id", "programDurationId");
		attributeNames.put("rotation_id", "rotationId");
		attributeNames.put("training_sites_id", "trainingSitesId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("is_shared_rotation", "isSharedRotation");
		attributeNames.put(
			"rotation_owning_program_id", "rotationOwningProgramId");
		attributeNames.put("progcode_rsn_sitecode", "progCodeRsnSiteCode");
		attributeNames.put(
			"owning_program_duration_id", "owningProgramDurationId");
		attributeNames.put("no_of_slots", "noOfSlots");

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

		columnBitmasks.put("progduration_rotation_ts_rel_id", 2L);

		columnBitmasks.put("program_duration_id", 4L);

		columnBitmasks.put("rotation_id", 8L);

		columnBitmasks.put("training_sites_id", 16L);

		columnBitmasks.put("group_id", 32L);

		columnBitmasks.put("company_id", 64L);

		columnBitmasks.put("create_date", 128L);

		columnBitmasks.put("modified_date", 256L);

		columnBitmasks.put("created_by", 512L);

		columnBitmasks.put("modified_by", 1024L);

		columnBitmasks.put("is_shared_rotation", 2048L);

		columnBitmasks.put("rotation_owning_program_id", 4096L);

		columnBitmasks.put("progcode_rsn_sitecode", 8192L);

		columnBitmasks.put("owning_program_duration_id", 16384L);

		columnBitmasks.put("no_of_slots", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProgdurationRotationTrainingsitesRel _escapedModel;

}