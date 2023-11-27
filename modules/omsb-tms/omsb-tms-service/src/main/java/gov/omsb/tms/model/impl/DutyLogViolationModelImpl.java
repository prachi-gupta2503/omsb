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

import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.model.DutyLogViolationModel;

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
 * The base model implementation for the DutyLogViolation service. Represents a row in the &quot;duty_log_violation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DutyLogViolationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DutyLogViolationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationImpl
 * @generated
 */
@JSON(strict = true)
public class DutyLogViolationModelImpl
	extends BaseModelImpl<DutyLogViolation> implements DutyLogViolationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a duty log violation model instance should use the <code>DutyLogViolation</code> interface instead.
	 */
	public static final String TABLE_NAME = "duty_log_violation";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"violation_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"created_by", Types.BIGINT},
		{"modified_date", Types.TIMESTAMP}, {"modified_by", Types.BIGINT},
		{"trainee_id", Types.BIGINT}, {"program_master_id", Types.BIGINT},
		{"residency_level", Types.BIGINT}, {"rotation_id", Types.BIGINT},
		{"training_site_id", Types.BIGINT}, {"block_id", Types.BIGINT},
		{"block_week_id", Types.BIGINT}, {"program_duty_rule_id", Types.BIGINT},
		{"acgme_80_hours_rule", Types.INTEGER},
		{"acgme_call_rule_option1", Types.INTEGER},
		{"acgme_call_rule_option2", Types.INTEGER},
		{"acgme_Short_Break_Rule", Types.INTEGER},
		{"acgme_24_hours_rule", Types.INTEGER},
		{"acgme_day_off_rule", Types.INTEGER}, {"duty_log_id", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("violation_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trainee_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("program_master_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("residency_level", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rotation_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("training_site_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("block_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("block_week_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("program_duty_rule_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("acgme_80_hours_rule", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("acgme_call_rule_option1", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("acgme_call_rule_option2", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("acgme_Short_Break_Rule", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("acgme_24_hours_rule", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("acgme_day_off_rule", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("duty_log_id", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table duty_log_violation (uuid_ VARCHAR(75) null,violation_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,created_by LONG,modified_date DATE null,modified_by LONG,trainee_id LONG,program_master_id LONG,residency_level LONG,rotation_id LONG,training_site_id LONG,block_id LONG,block_week_id LONG,program_duty_rule_id LONG,acgme_80_hours_rule INTEGER,acgme_call_rule_option1 INTEGER,acgme_call_rule_option2 INTEGER,acgme_Short_Break_Rule INTEGER,acgme_24_hours_rule INTEGER,acgme_day_off_rule INTEGER,duty_log_id LONG)";

	public static final String TABLE_SQL_DROP = "drop table duty_log_violation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dutyLogViolation.ViolationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY duty_log_violation.violation_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BLOCKID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DUTYLOGID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROGRAMMASTERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAINEEID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VIOLATIONID_COLUMN_BITMASK = 128L;

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

	public DutyLogViolationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ViolationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setViolationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ViolationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DutyLogViolation.class;
	}

	@Override
	public String getModelClassName() {
		return DutyLogViolation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DutyLogViolation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DutyLogViolation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DutyLogViolation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DutyLogViolation)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DutyLogViolation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DutyLogViolation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DutyLogViolation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DutyLogViolation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DutyLogViolation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DutyLogViolation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DutyLogViolation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DutyLogViolation, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DutyLogViolation, Object>>();
		Map<String, BiConsumer<DutyLogViolation, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DutyLogViolation, ?>>();

		attributeGetterFunctions.put("uuid", DutyLogViolation::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DutyLogViolation, String>)DutyLogViolation::setUuid);
		attributeGetterFunctions.put(
			"ViolationId", DutyLogViolation::getViolationId);
		attributeSetterBiConsumers.put(
			"ViolationId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setViolationId);
		attributeGetterFunctions.put("groupId", DutyLogViolation::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DutyLogViolation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", DutyLogViolation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DutyLogViolation, Date>)
				DutyLogViolation::setCreateDate);
		attributeGetterFunctions.put(
			"createdBy", DutyLogViolation::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate", DutyLogViolation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DutyLogViolation, Date>)
				DutyLogViolation::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", DutyLogViolation::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setModifiedBy);
		attributeGetterFunctions.put(
			"traineeId", DutyLogViolation::getTraineeId);
		attributeSetterBiConsumers.put(
			"traineeId",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setTraineeId);
		attributeGetterFunctions.put(
			"programMasterId", DutyLogViolation::getProgramMasterId);
		attributeSetterBiConsumers.put(
			"programMasterId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setProgramMasterId);
		attributeGetterFunctions.put(
			"residencyLevel", DutyLogViolation::getResidencyLevel);
		attributeSetterBiConsumers.put(
			"residencyLevel",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setResidencyLevel);
		attributeGetterFunctions.put(
			"rotationId", DutyLogViolation::getRotationId);
		attributeSetterBiConsumers.put(
			"rotationId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setRotationId);
		attributeGetterFunctions.put(
			"trainingSiteId", DutyLogViolation::getTrainingSiteId);
		attributeSetterBiConsumers.put(
			"trainingSiteId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setTrainingSiteId);
		attributeGetterFunctions.put("blockId", DutyLogViolation::getBlockId);
		attributeSetterBiConsumers.put(
			"blockId",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setBlockId);
		attributeGetterFunctions.put(
			"blockWeekId", DutyLogViolation::getBlockWeekId);
		attributeSetterBiConsumers.put(
			"blockWeekId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setBlockWeekId);
		attributeGetterFunctions.put(
			"programDutyRuleId", DutyLogViolation::getProgramDutyRuleId);
		attributeSetterBiConsumers.put(
			"programDutyRuleId",
			(BiConsumer<DutyLogViolation, Long>)
				DutyLogViolation::setProgramDutyRuleId);
		attributeGetterFunctions.put(
			"acgme80HoursRule", DutyLogViolation::getAcgme80HoursRule);
		attributeSetterBiConsumers.put(
			"acgme80HoursRule",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgme80HoursRule);
		attributeGetterFunctions.put(
			"acgmeCallRuleOption1", DutyLogViolation::getAcgmeCallRuleOption1);
		attributeSetterBiConsumers.put(
			"acgmeCallRuleOption1",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgmeCallRuleOption1);
		attributeGetterFunctions.put(
			"acgmeCallRuleOption2", DutyLogViolation::getAcgmeCallRuleOption2);
		attributeSetterBiConsumers.put(
			"acgmeCallRuleOption2",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgmeCallRuleOption2);
		attributeGetterFunctions.put(
			"acgmeShortBreakRule", DutyLogViolation::getAcgmeShortBreakRule);
		attributeSetterBiConsumers.put(
			"acgmeShortBreakRule",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgmeShortBreakRule);
		attributeGetterFunctions.put(
			"acgme24HoursRule", DutyLogViolation::getAcgme24HoursRule);
		attributeSetterBiConsumers.put(
			"acgme24HoursRule",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgme24HoursRule);
		attributeGetterFunctions.put(
			"acgmeDayOffRule", DutyLogViolation::getAcgmeDayOffRule);
		attributeSetterBiConsumers.put(
			"acgmeDayOffRule",
			(BiConsumer<DutyLogViolation, Integer>)
				DutyLogViolation::setAcgmeDayOffRule);
		attributeGetterFunctions.put(
			"dutyLogId", DutyLogViolation::getDutyLogId);
		attributeSetterBiConsumers.put(
			"dutyLogId",
			(BiConsumer<DutyLogViolation, Long>)DutyLogViolation::setDutyLogId);

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
	public long getViolationId() {
		return _ViolationId;
	}

	@Override
	public void setViolationId(long ViolationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ViolationId = ViolationId;
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
	public long getTraineeId() {
		return _traineeId;
	}

	@Override
	public void setTraineeId(long traineeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_traineeId = traineeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTraineeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("trainee_id"));
	}

	@JSON
	@Override
	public long getProgramMasterId() {
		return _programMasterId;
	}

	@Override
	public void setProgramMasterId(long programMasterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_programMasterId = programMasterId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProgramMasterId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("program_master_id"));
	}

	@JSON
	@Override
	public long getResidencyLevel() {
		return _residencyLevel;
	}

	@Override
	public void setResidencyLevel(long residencyLevel) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_residencyLevel = residencyLevel;
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

	@JSON
	@Override
	public long getTrainingSiteId() {
		return _trainingSiteId;
	}

	@Override
	public void setTrainingSiteId(long trainingSiteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_trainingSiteId = trainingSiteId;
	}

	@JSON
	@Override
	public long getBlockId() {
		return _blockId;
	}

	@Override
	public void setBlockId(long blockId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockId = blockId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalBlockId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("block_id"));
	}

	@JSON
	@Override
	public long getBlockWeekId() {
		return _blockWeekId;
	}

	@Override
	public void setBlockWeekId(long blockWeekId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockWeekId = blockWeekId;
	}

	@JSON
	@Override
	public long getProgramDutyRuleId() {
		return _programDutyRuleId;
	}

	@Override
	public void setProgramDutyRuleId(long programDutyRuleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_programDutyRuleId = programDutyRuleId;
	}

	@JSON
	@Override
	public int getAcgme80HoursRule() {
		return _acgme80HoursRule;
	}

	@Override
	public void setAcgme80HoursRule(int acgme80HoursRule) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgme80HoursRule = acgme80HoursRule;
	}

	@JSON
	@Override
	public int getAcgmeCallRuleOption1() {
		return _acgmeCallRuleOption1;
	}

	@Override
	public void setAcgmeCallRuleOption1(int acgmeCallRuleOption1) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgmeCallRuleOption1 = acgmeCallRuleOption1;
	}

	@JSON
	@Override
	public int getAcgmeCallRuleOption2() {
		return _acgmeCallRuleOption2;
	}

	@Override
	public void setAcgmeCallRuleOption2(int acgmeCallRuleOption2) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgmeCallRuleOption2 = acgmeCallRuleOption2;
	}

	@JSON
	@Override
	public int getAcgmeShortBreakRule() {
		return _acgmeShortBreakRule;
	}

	@Override
	public void setAcgmeShortBreakRule(int acgmeShortBreakRule) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgmeShortBreakRule = acgmeShortBreakRule;
	}

	@JSON
	@Override
	public int getAcgme24HoursRule() {
		return _acgme24HoursRule;
	}

	@Override
	public void setAcgme24HoursRule(int acgme24HoursRule) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgme24HoursRule = acgme24HoursRule;
	}

	@JSON
	@Override
	public int getAcgmeDayOffRule() {
		return _acgmeDayOffRule;
	}

	@Override
	public void setAcgmeDayOffRule(int acgmeDayOffRule) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_acgmeDayOffRule = acgmeDayOffRule;
	}

	@JSON
	@Override
	public long getDutyLogId() {
		return _dutyLogId;
	}

	@Override
	public void setDutyLogId(long dutyLogId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dutyLogId = dutyLogId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDutyLogId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("duty_log_id"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DutyLogViolation.class.getName()));
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
			getCompanyId(), DutyLogViolation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DutyLogViolation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DutyLogViolation>
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
		DutyLogViolationImpl dutyLogViolationImpl = new DutyLogViolationImpl();

		dutyLogViolationImpl.setUuid(getUuid());
		dutyLogViolationImpl.setViolationId(getViolationId());
		dutyLogViolationImpl.setGroupId(getGroupId());
		dutyLogViolationImpl.setCompanyId(getCompanyId());
		dutyLogViolationImpl.setCreateDate(getCreateDate());
		dutyLogViolationImpl.setCreatedBy(getCreatedBy());
		dutyLogViolationImpl.setModifiedDate(getModifiedDate());
		dutyLogViolationImpl.setModifiedBy(getModifiedBy());
		dutyLogViolationImpl.setTraineeId(getTraineeId());
		dutyLogViolationImpl.setProgramMasterId(getProgramMasterId());
		dutyLogViolationImpl.setResidencyLevel(getResidencyLevel());
		dutyLogViolationImpl.setRotationId(getRotationId());
		dutyLogViolationImpl.setTrainingSiteId(getTrainingSiteId());
		dutyLogViolationImpl.setBlockId(getBlockId());
		dutyLogViolationImpl.setBlockWeekId(getBlockWeekId());
		dutyLogViolationImpl.setProgramDutyRuleId(getProgramDutyRuleId());
		dutyLogViolationImpl.setAcgme80HoursRule(getAcgme80HoursRule());
		dutyLogViolationImpl.setAcgmeCallRuleOption1(getAcgmeCallRuleOption1());
		dutyLogViolationImpl.setAcgmeCallRuleOption2(getAcgmeCallRuleOption2());
		dutyLogViolationImpl.setAcgmeShortBreakRule(getAcgmeShortBreakRule());
		dutyLogViolationImpl.setAcgme24HoursRule(getAcgme24HoursRule());
		dutyLogViolationImpl.setAcgmeDayOffRule(getAcgmeDayOffRule());
		dutyLogViolationImpl.setDutyLogId(getDutyLogId());

		dutyLogViolationImpl.resetOriginalValues();

		return dutyLogViolationImpl;
	}

	@Override
	public DutyLogViolation cloneWithOriginalValues() {
		DutyLogViolationImpl dutyLogViolationImpl = new DutyLogViolationImpl();

		dutyLogViolationImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		dutyLogViolationImpl.setViolationId(
			this.<Long>getColumnOriginalValue("violation_id"));
		dutyLogViolationImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		dutyLogViolationImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		dutyLogViolationImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		dutyLogViolationImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		dutyLogViolationImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		dutyLogViolationImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		dutyLogViolationImpl.setTraineeId(
			this.<Long>getColumnOriginalValue("trainee_id"));
		dutyLogViolationImpl.setProgramMasterId(
			this.<Long>getColumnOriginalValue("program_master_id"));
		dutyLogViolationImpl.setResidencyLevel(
			this.<Long>getColumnOriginalValue("residency_level"));
		dutyLogViolationImpl.setRotationId(
			this.<Long>getColumnOriginalValue("rotation_id"));
		dutyLogViolationImpl.setTrainingSiteId(
			this.<Long>getColumnOriginalValue("training_site_id"));
		dutyLogViolationImpl.setBlockId(
			this.<Long>getColumnOriginalValue("block_id"));
		dutyLogViolationImpl.setBlockWeekId(
			this.<Long>getColumnOriginalValue("block_week_id"));
		dutyLogViolationImpl.setProgramDutyRuleId(
			this.<Long>getColumnOriginalValue("program_duty_rule_id"));
		dutyLogViolationImpl.setAcgme80HoursRule(
			this.<Integer>getColumnOriginalValue("acgme_80_hours_rule"));
		dutyLogViolationImpl.setAcgmeCallRuleOption1(
			this.<Integer>getColumnOriginalValue("acgme_call_rule_option1"));
		dutyLogViolationImpl.setAcgmeCallRuleOption2(
			this.<Integer>getColumnOriginalValue("acgme_call_rule_option2"));
		dutyLogViolationImpl.setAcgmeShortBreakRule(
			this.<Integer>getColumnOriginalValue("acgme_Short_Break_Rule"));
		dutyLogViolationImpl.setAcgme24HoursRule(
			this.<Integer>getColumnOriginalValue("acgme_24_hours_rule"));
		dutyLogViolationImpl.setAcgmeDayOffRule(
			this.<Integer>getColumnOriginalValue("acgme_day_off_rule"));
		dutyLogViolationImpl.setDutyLogId(
			this.<Long>getColumnOriginalValue("duty_log_id"));

		return dutyLogViolationImpl;
	}

	@Override
	public int compareTo(DutyLogViolation dutyLogViolation) {
		long primaryKey = dutyLogViolation.getPrimaryKey();

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

		if (!(object instanceof DutyLogViolation)) {
			return false;
		}

		DutyLogViolation dutyLogViolation = (DutyLogViolation)object;

		long primaryKey = dutyLogViolation.getPrimaryKey();

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
	public CacheModel<DutyLogViolation> toCacheModel() {
		DutyLogViolationCacheModel dutyLogViolationCacheModel =
			new DutyLogViolationCacheModel();

		dutyLogViolationCacheModel.uuid = getUuid();

		String uuid = dutyLogViolationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dutyLogViolationCacheModel.uuid = null;
		}

		dutyLogViolationCacheModel.ViolationId = getViolationId();

		dutyLogViolationCacheModel.groupId = getGroupId();

		dutyLogViolationCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dutyLogViolationCacheModel.createDate = createDate.getTime();
		}
		else {
			dutyLogViolationCacheModel.createDate = Long.MIN_VALUE;
		}

		dutyLogViolationCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dutyLogViolationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dutyLogViolationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dutyLogViolationCacheModel.modifiedBy = getModifiedBy();

		dutyLogViolationCacheModel.traineeId = getTraineeId();

		dutyLogViolationCacheModel.programMasterId = getProgramMasterId();

		dutyLogViolationCacheModel.residencyLevel = getResidencyLevel();

		dutyLogViolationCacheModel.rotationId = getRotationId();

		dutyLogViolationCacheModel.trainingSiteId = getTrainingSiteId();

		dutyLogViolationCacheModel.blockId = getBlockId();

		dutyLogViolationCacheModel.blockWeekId = getBlockWeekId();

		dutyLogViolationCacheModel.programDutyRuleId = getProgramDutyRuleId();

		dutyLogViolationCacheModel.acgme80HoursRule = getAcgme80HoursRule();

		dutyLogViolationCacheModel.acgmeCallRuleOption1 =
			getAcgmeCallRuleOption1();

		dutyLogViolationCacheModel.acgmeCallRuleOption2 =
			getAcgmeCallRuleOption2();

		dutyLogViolationCacheModel.acgmeShortBreakRule =
			getAcgmeShortBreakRule();

		dutyLogViolationCacheModel.acgme24HoursRule = getAcgme24HoursRule();

		dutyLogViolationCacheModel.acgmeDayOffRule = getAcgmeDayOffRule();

		dutyLogViolationCacheModel.dutyLogId = getDutyLogId();

		return dutyLogViolationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DutyLogViolation, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DutyLogViolation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DutyLogViolation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DutyLogViolation)this);

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

		private static final Function<InvocationHandler, DutyLogViolation>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DutyLogViolation.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _ViolationId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _traineeId;
	private long _programMasterId;
	private long _residencyLevel;
	private long _rotationId;
	private long _trainingSiteId;
	private long _blockId;
	private long _blockWeekId;
	private long _programDutyRuleId;
	private int _acgme80HoursRule;
	private int _acgmeCallRuleOption1;
	private int _acgmeCallRuleOption2;
	private int _acgmeShortBreakRule;
	private int _acgme24HoursRule;
	private int _acgmeDayOffRule;
	private long _dutyLogId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DutyLogViolation, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DutyLogViolation)this);
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
		_columnOriginalValues.put("violation_id", _ViolationId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("trainee_id", _traineeId);
		_columnOriginalValues.put("program_master_id", _programMasterId);
		_columnOriginalValues.put("residency_level", _residencyLevel);
		_columnOriginalValues.put("rotation_id", _rotationId);
		_columnOriginalValues.put("training_site_id", _trainingSiteId);
		_columnOriginalValues.put("block_id", _blockId);
		_columnOriginalValues.put("block_week_id", _blockWeekId);
		_columnOriginalValues.put("program_duty_rule_id", _programDutyRuleId);
		_columnOriginalValues.put("acgme_80_hours_rule", _acgme80HoursRule);
		_columnOriginalValues.put(
			"acgme_call_rule_option1", _acgmeCallRuleOption1);
		_columnOriginalValues.put(
			"acgme_call_rule_option2", _acgmeCallRuleOption2);
		_columnOriginalValues.put(
			"acgme_Short_Break_Rule", _acgmeShortBreakRule);
		_columnOriginalValues.put("acgme_24_hours_rule", _acgme24HoursRule);
		_columnOriginalValues.put("acgme_day_off_rule", _acgmeDayOffRule);
		_columnOriginalValues.put("duty_log_id", _dutyLogId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("violation_id", "ViolationId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("trainee_id", "traineeId");
		attributeNames.put("program_master_id", "programMasterId");
		attributeNames.put("residency_level", "residencyLevel");
		attributeNames.put("rotation_id", "rotationId");
		attributeNames.put("training_site_id", "trainingSiteId");
		attributeNames.put("block_id", "blockId");
		attributeNames.put("block_week_id", "blockWeekId");
		attributeNames.put("program_duty_rule_id", "programDutyRuleId");
		attributeNames.put("acgme_80_hours_rule", "acgme80HoursRule");
		attributeNames.put("acgme_call_rule_option1", "acgmeCallRuleOption1");
		attributeNames.put("acgme_call_rule_option2", "acgmeCallRuleOption2");
		attributeNames.put("acgme_Short_Break_Rule", "acgmeShortBreakRule");
		attributeNames.put("acgme_24_hours_rule", "acgme24HoursRule");
		attributeNames.put("acgme_day_off_rule", "acgmeDayOffRule");
		attributeNames.put("duty_log_id", "dutyLogId");

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

		columnBitmasks.put("violation_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("created_by", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("trainee_id", 256L);

		columnBitmasks.put("program_master_id", 512L);

		columnBitmasks.put("residency_level", 1024L);

		columnBitmasks.put("rotation_id", 2048L);

		columnBitmasks.put("training_site_id", 4096L);

		columnBitmasks.put("block_id", 8192L);

		columnBitmasks.put("block_week_id", 16384L);

		columnBitmasks.put("program_duty_rule_id", 32768L);

		columnBitmasks.put("acgme_80_hours_rule", 65536L);

		columnBitmasks.put("acgme_call_rule_option1", 131072L);

		columnBitmasks.put("acgme_call_rule_option2", 262144L);

		columnBitmasks.put("acgme_Short_Break_Rule", 524288L);

		columnBitmasks.put("acgme_24_hours_rule", 1048576L);

		columnBitmasks.put("acgme_day_off_rule", 2097152L);

		columnBitmasks.put("duty_log_id", 4194304L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DutyLogViolation _escapedModel;

}