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

import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRelModel;

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
 * The base model implementation for the TraineeRotationTsBlockDetailsRel service. Represents a row in the &quot;trainee_rotation_ts_block_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TraineeRotationTsBlockDetailsRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TraineeRotationTsBlockDetailsRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRelImpl
 * @generated
 */
@JSON(strict = true)
public class TraineeRotationTsBlockDetailsRelModelImpl
	extends BaseModelImpl<TraineeRotationTsBlockDetailsRel>
	implements TraineeRotationTsBlockDetailsRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a trainee rotation ts block details rel model instance should use the <code>TraineeRotationTsBlockDetailsRel</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"trainee_rotation_ts_block_details_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"trainee_rotation_ts_block_details_rel_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"modified_date", Types.TIMESTAMP},
		{"created_by", Types.BIGINT}, {"modified_by", Types.BIGINT},
		{"trainee_id", Types.BIGINT},
		{"blocks_metadata_details_rel_id", Types.BIGINT},
		{"progduration_rotation_ts_rel_id", Types.BIGINT},
		{"trainee_cohort_details_id", Types.BIGINT},
		{"rotation_status", Types.VARCHAR}, {"status", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put(
			"trainee_rotation_ts_block_details_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trainee_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("blocks_metadata_details_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("progduration_rotation_ts_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trainee_cohort_details_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rotation_status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table trainee_rotation_ts_block_details_rel (uuid_ VARCHAR(75) null,trainee_rotation_ts_block_details_rel_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG,trainee_id LONG,blocks_metadata_details_rel_id LONG,progduration_rotation_ts_rel_id LONG,trainee_cohort_details_id LONG,rotation_status VARCHAR(75) null,status VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table trainee_rotation_ts_block_details_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY traineeRotationTsBlockDetailsRel.traineeRotationTsBlockDetailsRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY trainee_rotation_ts_block_details_rel.trainee_rotation_ts_block_details_rel_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BLOCKSMETADATADETAILSRELID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROGDURATIONROTATIONTSRELID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 16L;

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
	public static final long TRAINEEROTATIONTSBLOCKDETAILSRELID_COLUMN_BITMASK =
		128L;

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

	public TraineeRotationTsBlockDetailsRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _traineeRotationTsBlockDetailsRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTraineeRotationTsBlockDetailsRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _traineeRotationTsBlockDetailsRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TraineeRotationTsBlockDetailsRel.class;
	}

	@Override
	public String getModelClassName() {
		return TraineeRotationTsBlockDetailsRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TraineeRotationTsBlockDetailsRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(TraineeRotationTsBlockDetailsRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TraineeRotationTsBlockDetailsRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TraineeRotationTsBlockDetailsRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TraineeRotationTsBlockDetailsRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TraineeRotationTsBlockDetailsRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<TraineeRotationTsBlockDetailsRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<TraineeRotationTsBlockDetailsRel, Object>>();
		Map<String, BiConsumer<TraineeRotationTsBlockDetailsRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<TraineeRotationTsBlockDetailsRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", TraineeRotationTsBlockDetailsRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, String>)
				TraineeRotationTsBlockDetailsRel::setUuid);
		attributeGetterFunctions.put(
			"traineeRotationTsBlockDetailsRelId",
			TraineeRotationTsBlockDetailsRel::
				getTraineeRotationTsBlockDetailsRelId);
		attributeSetterBiConsumers.put(
			"traineeRotationTsBlockDetailsRelId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::
					setTraineeRotationTsBlockDetailsRelId);
		attributeGetterFunctions.put(
			"groupId", TraineeRotationTsBlockDetailsRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", TraineeRotationTsBlockDetailsRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", TraineeRotationTsBlockDetailsRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Date>)
				TraineeRotationTsBlockDetailsRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TraineeRotationTsBlockDetailsRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Date>)
				TraineeRotationTsBlockDetailsRel::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", TraineeRotationTsBlockDetailsRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", TraineeRotationTsBlockDetailsRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setModifiedBy);
		attributeGetterFunctions.put(
			"traineeId", TraineeRotationTsBlockDetailsRel::getTraineeId);
		attributeSetterBiConsumers.put(
			"traineeId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setTraineeId);
		attributeGetterFunctions.put(
			"blocksMetadataDetailsRelId",
			TraineeRotationTsBlockDetailsRel::getBlocksMetadataDetailsRelId);
		attributeSetterBiConsumers.put(
			"blocksMetadataDetailsRelId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::
					setBlocksMetadataDetailsRelId);
		attributeGetterFunctions.put(
			"progDurationRotationTsRelId",
			TraineeRotationTsBlockDetailsRel::getProgDurationRotationTsRelId);
		attributeSetterBiConsumers.put(
			"progDurationRotationTsRelId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::
					setProgDurationRotationTsRelId);
		attributeGetterFunctions.put(
			"traineeCohortDetailsId",
			TraineeRotationTsBlockDetailsRel::getTraineeCohortDetailsId);
		attributeSetterBiConsumers.put(
			"traineeCohortDetailsId",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, Long>)
				TraineeRotationTsBlockDetailsRel::setTraineeCohortDetailsId);
		attributeGetterFunctions.put(
			"rotationStatus",
			TraineeRotationTsBlockDetailsRel::getRotationStatus);
		attributeSetterBiConsumers.put(
			"rotationStatus",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, String>)
				TraineeRotationTsBlockDetailsRel::setRotationStatus);
		attributeGetterFunctions.put(
			"status", TraineeRotationTsBlockDetailsRel::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<TraineeRotationTsBlockDetailsRel, String>)
				TraineeRotationTsBlockDetailsRel::setStatus);

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
	public long getTraineeRotationTsBlockDetailsRelId() {
		return _traineeRotationTsBlockDetailsRelId;
	}

	@Override
	public void setTraineeRotationTsBlockDetailsRelId(
		long traineeRotationTsBlockDetailsRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_traineeRotationTsBlockDetailsRelId =
			traineeRotationTsBlockDetailsRelId;
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
	public long getBlocksMetadataDetailsRelId() {
		return _blocksMetadataDetailsRelId;
	}

	@Override
	public void setBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blocksMetadataDetailsRelId = blocksMetadataDetailsRelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalBlocksMetadataDetailsRelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue(
				"blocks_metadata_details_rel_id"));
	}

	@JSON
	@Override
	public long getProgDurationRotationTsRelId() {
		return _progDurationRotationTsRelId;
	}

	@Override
	public void setProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progDurationRotationTsRelId = progDurationRotationTsRelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProgDurationRotationTsRelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue(
				"progduration_rotation_ts_rel_id"));
	}

	@JSON
	@Override
	public long getTraineeCohortDetailsId() {
		return _traineeCohortDetailsId;
	}

	@Override
	public void setTraineeCohortDetailsId(long traineeCohortDetailsId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_traineeCohortDetailsId = traineeCohortDetailsId;
	}

	@JSON
	@Override
	public String getRotationStatus() {
		if (_rotationStatus == null) {
			return "";
		}
		else {
			return _rotationStatus;
		}
	}

	@Override
	public void setRotationStatus(String rotationStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rotationStatus = rotationStatus;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStatus() {
		return getColumnOriginalValue("status");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				TraineeRotationTsBlockDetailsRel.class.getName()));
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
			getCompanyId(), TraineeRotationTsBlockDetailsRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TraineeRotationTsBlockDetailsRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TraineeRotationTsBlockDetailsRel>
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
		TraineeRotationTsBlockDetailsRelImpl
			traineeRotationTsBlockDetailsRelImpl =
				new TraineeRotationTsBlockDetailsRelImpl();

		traineeRotationTsBlockDetailsRelImpl.setUuid(getUuid());
		traineeRotationTsBlockDetailsRelImpl.
			setTraineeRotationTsBlockDetailsRelId(
				getTraineeRotationTsBlockDetailsRelId());
		traineeRotationTsBlockDetailsRelImpl.setGroupId(getGroupId());
		traineeRotationTsBlockDetailsRelImpl.setCompanyId(getCompanyId());
		traineeRotationTsBlockDetailsRelImpl.setCreateDate(getCreateDate());
		traineeRotationTsBlockDetailsRelImpl.setModifiedDate(getModifiedDate());
		traineeRotationTsBlockDetailsRelImpl.setCreatedBy(getCreatedBy());
		traineeRotationTsBlockDetailsRelImpl.setModifiedBy(getModifiedBy());
		traineeRotationTsBlockDetailsRelImpl.setTraineeId(getTraineeId());
		traineeRotationTsBlockDetailsRelImpl.setBlocksMetadataDetailsRelId(
			getBlocksMetadataDetailsRelId());
		traineeRotationTsBlockDetailsRelImpl.setProgDurationRotationTsRelId(
			getProgDurationRotationTsRelId());
		traineeRotationTsBlockDetailsRelImpl.setTraineeCohortDetailsId(
			getTraineeCohortDetailsId());
		traineeRotationTsBlockDetailsRelImpl.setRotationStatus(
			getRotationStatus());
		traineeRotationTsBlockDetailsRelImpl.setStatus(getStatus());

		traineeRotationTsBlockDetailsRelImpl.resetOriginalValues();

		return traineeRotationTsBlockDetailsRelImpl;
	}

	@Override
	public TraineeRotationTsBlockDetailsRel cloneWithOriginalValues() {
		TraineeRotationTsBlockDetailsRelImpl
			traineeRotationTsBlockDetailsRelImpl =
				new TraineeRotationTsBlockDetailsRelImpl();

		traineeRotationTsBlockDetailsRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		traineeRotationTsBlockDetailsRelImpl.
			setTraineeRotationTsBlockDetailsRelId(
				this.<Long>getColumnOriginalValue(
					"trainee_rotation_ts_block_details_rel_id"));
		traineeRotationTsBlockDetailsRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		traineeRotationTsBlockDetailsRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		traineeRotationTsBlockDetailsRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		traineeRotationTsBlockDetailsRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		traineeRotationTsBlockDetailsRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		traineeRotationTsBlockDetailsRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		traineeRotationTsBlockDetailsRelImpl.setTraineeId(
			this.<Long>getColumnOriginalValue("trainee_id"));
		traineeRotationTsBlockDetailsRelImpl.setBlocksMetadataDetailsRelId(
			this.<Long>getColumnOriginalValue(
				"blocks_metadata_details_rel_id"));
		traineeRotationTsBlockDetailsRelImpl.setProgDurationRotationTsRelId(
			this.<Long>getColumnOriginalValue(
				"progduration_rotation_ts_rel_id"));
		traineeRotationTsBlockDetailsRelImpl.setTraineeCohortDetailsId(
			this.<Long>getColumnOriginalValue("trainee_cohort_details_id"));
		traineeRotationTsBlockDetailsRelImpl.setRotationStatus(
			this.<String>getColumnOriginalValue("rotation_status"));
		traineeRotationTsBlockDetailsRelImpl.setStatus(
			this.<String>getColumnOriginalValue("status"));

		return traineeRotationTsBlockDetailsRelImpl;
	}

	@Override
	public int compareTo(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		long primaryKey = traineeRotationTsBlockDetailsRel.getPrimaryKey();

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

		if (!(object instanceof TraineeRotationTsBlockDetailsRel)) {
			return false;
		}

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			(TraineeRotationTsBlockDetailsRel)object;

		long primaryKey = traineeRotationTsBlockDetailsRel.getPrimaryKey();

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
	public CacheModel<TraineeRotationTsBlockDetailsRel> toCacheModel() {
		TraineeRotationTsBlockDetailsRelCacheModel
			traineeRotationTsBlockDetailsRelCacheModel =
				new TraineeRotationTsBlockDetailsRelCacheModel();

		traineeRotationTsBlockDetailsRelCacheModel.uuid = getUuid();

		String uuid = traineeRotationTsBlockDetailsRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			traineeRotationTsBlockDetailsRelCacheModel.uuid = null;
		}

		traineeRotationTsBlockDetailsRelCacheModel.
			traineeRotationTsBlockDetailsRelId =
				getTraineeRotationTsBlockDetailsRelId();

		traineeRotationTsBlockDetailsRelCacheModel.groupId = getGroupId();

		traineeRotationTsBlockDetailsRelCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			traineeRotationTsBlockDetailsRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			traineeRotationTsBlockDetailsRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			traineeRotationTsBlockDetailsRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			traineeRotationTsBlockDetailsRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		traineeRotationTsBlockDetailsRelCacheModel.createdBy = getCreatedBy();

		traineeRotationTsBlockDetailsRelCacheModel.modifiedBy = getModifiedBy();

		traineeRotationTsBlockDetailsRelCacheModel.traineeId = getTraineeId();

		traineeRotationTsBlockDetailsRelCacheModel.blocksMetadataDetailsRelId =
			getBlocksMetadataDetailsRelId();

		traineeRotationTsBlockDetailsRelCacheModel.progDurationRotationTsRelId =
			getProgDurationRotationTsRelId();

		traineeRotationTsBlockDetailsRelCacheModel.traineeCohortDetailsId =
			getTraineeCohortDetailsId();

		traineeRotationTsBlockDetailsRelCacheModel.rotationStatus =
			getRotationStatus();

		String rotationStatus =
			traineeRotationTsBlockDetailsRelCacheModel.rotationStatus;

		if ((rotationStatus != null) && (rotationStatus.length() == 0)) {
			traineeRotationTsBlockDetailsRelCacheModel.rotationStatus = null;
		}

		traineeRotationTsBlockDetailsRelCacheModel.status = getStatus();

		String status = traineeRotationTsBlockDetailsRelCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			traineeRotationTsBlockDetailsRelCacheModel.status = null;
		}

		return traineeRotationTsBlockDetailsRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry
				<String, Function<TraineeRotationTsBlockDetailsRel, Object>>
					entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TraineeRotationTsBlockDetailsRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(TraineeRotationTsBlockDetailsRel)this);

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
			<InvocationHandler, TraineeRotationTsBlockDetailsRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						TraineeRotationTsBlockDetailsRel.class,
						ModelWrapper.class);

	}

	private String _uuid;
	private long _traineeRotationTsBlockDetailsRelId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private long _traineeId;
	private long _blocksMetadataDetailsRelId;
	private long _progDurationRotationTsRelId;
	private long _traineeCohortDetailsId;
	private String _rotationStatus;
	private String _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TraineeRotationTsBlockDetailsRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TraineeRotationTsBlockDetailsRel)this);
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
			"trainee_rotation_ts_block_details_rel_id",
			_traineeRotationTsBlockDetailsRelId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("trainee_id", _traineeId);
		_columnOriginalValues.put(
			"blocks_metadata_details_rel_id", _blocksMetadataDetailsRelId);
		_columnOriginalValues.put(
			"progduration_rotation_ts_rel_id", _progDurationRotationTsRelId);
		_columnOriginalValues.put(
			"trainee_cohort_details_id", _traineeCohortDetailsId);
		_columnOriginalValues.put("rotation_status", _rotationStatus);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"trainee_rotation_ts_block_details_rel_id",
			"traineeRotationTsBlockDetailsRelId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("trainee_id", "traineeId");
		attributeNames.put(
			"blocks_metadata_details_rel_id", "blocksMetadataDetailsRelId");
		attributeNames.put(
			"progduration_rotation_ts_rel_id", "progDurationRotationTsRelId");
		attributeNames.put(
			"trainee_cohort_details_id", "traineeCohortDetailsId");
		attributeNames.put("rotation_status", "rotationStatus");

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

		columnBitmasks.put("trainee_rotation_ts_block_details_rel_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("modified_date", 32L);

		columnBitmasks.put("created_by", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("trainee_id", 256L);

		columnBitmasks.put("blocks_metadata_details_rel_id", 512L);

		columnBitmasks.put("progduration_rotation_ts_rel_id", 1024L);

		columnBitmasks.put("trainee_cohort_details_id", 2048L);

		columnBitmasks.put("rotation_status", 4096L);

		columnBitmasks.put("status", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TraineeRotationTsBlockDetailsRel _escapedModel;

}