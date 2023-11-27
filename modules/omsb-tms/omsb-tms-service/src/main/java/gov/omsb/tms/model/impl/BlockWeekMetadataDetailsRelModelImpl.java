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
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRelModel;

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
 * The base model implementation for the BlockWeekMetadataDetailsRel service. Represents a row in the &quot;block_week_metadata_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BlockWeekMetadataDetailsRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlockWeekMetadataDetailsRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRelImpl
 * @generated
 */
@JSON(strict = true)
public class BlockWeekMetadataDetailsRelModelImpl
	extends BaseModelImpl<BlockWeekMetadataDetailsRel>
	implements BlockWeekMetadataDetailsRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a block week metadata details rel model instance should use the <code>BlockWeekMetadataDetailsRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "block_week_metadata_details_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"block_week_metadata_details_rel_id", Types.BIGINT},
		{"blocks_metadata_details_rel_id", Types.BIGINT},
		{"week_no", Types.VARCHAR}, {"week_start_date", Types.TIMESTAMP},
		{"week_end_date", Types.TIMESTAMP}, {"group_id", Types.BIGINT},
		{"company_id", Types.BIGINT}, {"created_date", Types.TIMESTAMP},
		{"created_by", Types.BIGINT}, {"modified_date", Types.TIMESTAMP},
		{"modified_by", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put(
			"block_week_metadata_details_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("blocks_metadata_details_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("week_no", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("week_start_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("week_end_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("created_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table block_week_metadata_details_rel (uuid_ VARCHAR(75) null,block_week_metadata_details_rel_id LONG not null primary key,blocks_metadata_details_rel_id LONG,week_no VARCHAR(75) null,week_start_date DATE null,week_end_date DATE null,group_id LONG,company_id LONG,created_date DATE null,created_by LONG,modified_date DATE null,modified_by LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table block_week_metadata_details_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY blockWeekMetadataDetailsRel.blockWeekMetadataDetailsRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY block_week_metadata_details_rel.block_week_metadata_details_rel_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BLOCKSMETADATADETAILRELID_COLUMN_BITMASK = 1L;

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
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BLOCKWEEKMETADATADETAILSRELID_COLUMN_BITMASK = 16L;

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

	public BlockWeekMetadataDetailsRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _blockWeekMetadataDetailsRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBlockWeekMetadataDetailsRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _blockWeekMetadataDetailsRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BlockWeekMetadataDetailsRel.class;
	}

	@Override
	public String getModelClassName() {
		return BlockWeekMetadataDetailsRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BlockWeekMetadataDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BlockWeekMetadataDetailsRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlockWeekMetadataDetailsRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(BlockWeekMetadataDetailsRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BlockWeekMetadataDetailsRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BlockWeekMetadataDetailsRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BlockWeekMetadataDetailsRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BlockWeekMetadataDetailsRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BlockWeekMetadataDetailsRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<BlockWeekMetadataDetailsRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<BlockWeekMetadataDetailsRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<BlockWeekMetadataDetailsRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<BlockWeekMetadataDetailsRel, Object>>();
		Map<String, BiConsumer<BlockWeekMetadataDetailsRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<BlockWeekMetadataDetailsRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", BlockWeekMetadataDetailsRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<BlockWeekMetadataDetailsRel, String>)
				BlockWeekMetadataDetailsRel::setUuid);
		attributeGetterFunctions.put(
			"blockWeekMetadataDetailsRelId",
			BlockWeekMetadataDetailsRel::getBlockWeekMetadataDetailsRelId);
		attributeSetterBiConsumers.put(
			"blockWeekMetadataDetailsRelId",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setBlockWeekMetadataDetailsRelId);
		attributeGetterFunctions.put(
			"blocksMetadataDetailRelId",
			BlockWeekMetadataDetailsRel::getBlocksMetadataDetailRelId);
		attributeSetterBiConsumers.put(
			"blocksMetadataDetailRelId",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setBlocksMetadataDetailRelId);
		attributeGetterFunctions.put(
			"weekNo", BlockWeekMetadataDetailsRel::getWeekNo);
		attributeSetterBiConsumers.put(
			"weekNo",
			(BiConsumer<BlockWeekMetadataDetailsRel, String>)
				BlockWeekMetadataDetailsRel::setWeekNo);
		attributeGetterFunctions.put(
			"weekStartDate", BlockWeekMetadataDetailsRel::getWeekStartDate);
		attributeSetterBiConsumers.put(
			"weekStartDate",
			(BiConsumer<BlockWeekMetadataDetailsRel, Date>)
				BlockWeekMetadataDetailsRel::setWeekStartDate);
		attributeGetterFunctions.put(
			"weekEndDate", BlockWeekMetadataDetailsRel::getWeekEndDate);
		attributeSetterBiConsumers.put(
			"weekEndDate",
			(BiConsumer<BlockWeekMetadataDetailsRel, Date>)
				BlockWeekMetadataDetailsRel::setWeekEndDate);
		attributeGetterFunctions.put(
			"groupId", BlockWeekMetadataDetailsRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", BlockWeekMetadataDetailsRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setCompanyId);
		attributeGetterFunctions.put(
			"createdDate", BlockWeekMetadataDetailsRel::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<BlockWeekMetadataDetailsRel, Date>)
				BlockWeekMetadataDetailsRel::setCreatedDate);
		attributeGetterFunctions.put(
			"createdBy", BlockWeekMetadataDetailsRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedDate", BlockWeekMetadataDetailsRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<BlockWeekMetadataDetailsRel, Date>)
				BlockWeekMetadataDetailsRel::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", BlockWeekMetadataDetailsRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<BlockWeekMetadataDetailsRel, Long>)
				BlockWeekMetadataDetailsRel::setModifiedBy);

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
	public long getBlockWeekMetadataDetailsRelId() {
		return _blockWeekMetadataDetailsRelId;
	}

	@Override
	public void setBlockWeekMetadataDetailsRelId(
		long blockWeekMetadataDetailsRelId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockWeekMetadataDetailsRelId = blockWeekMetadataDetailsRelId;
	}

	@JSON
	@Override
	public long getBlocksMetadataDetailRelId() {
		return _blocksMetadataDetailRelId;
	}

	@Override
	public void setBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blocksMetadataDetailRelId = blocksMetadataDetailRelId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalBlocksMetadataDetailRelId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue(
				"blocks_metadata_details_rel_id"));
	}

	@JSON
	@Override
	public String getWeekNo() {
		if (_weekNo == null) {
			return "";
		}
		else {
			return _weekNo;
		}
	}

	@Override
	public void setWeekNo(String weekNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_weekNo = weekNo;
	}

	@JSON
	@Override
	public Date getWeekStartDate() {
		return _weekStartDate;
	}

	@Override
	public void setWeekStartDate(Date weekStartDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_weekStartDate = weekStartDate;
	}

	@JSON
	@Override
	public Date getWeekEndDate() {
		return _weekEndDate;
	}

	@Override
	public void setWeekEndDate(Date weekEndDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_weekEndDate = weekEndDate;
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdDate = createdDate;
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
			getCompanyId(), BlockWeekMetadataDetailsRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BlockWeekMetadataDetailsRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BlockWeekMetadataDetailsRel>
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
		BlockWeekMetadataDetailsRelImpl blockWeekMetadataDetailsRelImpl =
			new BlockWeekMetadataDetailsRelImpl();

		blockWeekMetadataDetailsRelImpl.setUuid(getUuid());
		blockWeekMetadataDetailsRelImpl.setBlockWeekMetadataDetailsRelId(
			getBlockWeekMetadataDetailsRelId());
		blockWeekMetadataDetailsRelImpl.setBlocksMetadataDetailRelId(
			getBlocksMetadataDetailRelId());
		blockWeekMetadataDetailsRelImpl.setWeekNo(getWeekNo());
		blockWeekMetadataDetailsRelImpl.setWeekStartDate(getWeekStartDate());
		blockWeekMetadataDetailsRelImpl.setWeekEndDate(getWeekEndDate());
		blockWeekMetadataDetailsRelImpl.setGroupId(getGroupId());
		blockWeekMetadataDetailsRelImpl.setCompanyId(getCompanyId());
		blockWeekMetadataDetailsRelImpl.setCreatedDate(getCreatedDate());
		blockWeekMetadataDetailsRelImpl.setCreatedBy(getCreatedBy());
		blockWeekMetadataDetailsRelImpl.setModifiedDate(getModifiedDate());
		blockWeekMetadataDetailsRelImpl.setModifiedBy(getModifiedBy());

		blockWeekMetadataDetailsRelImpl.resetOriginalValues();

		return blockWeekMetadataDetailsRelImpl;
	}

	@Override
	public BlockWeekMetadataDetailsRel cloneWithOriginalValues() {
		BlockWeekMetadataDetailsRelImpl blockWeekMetadataDetailsRelImpl =
			new BlockWeekMetadataDetailsRelImpl();

		blockWeekMetadataDetailsRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		blockWeekMetadataDetailsRelImpl.setBlockWeekMetadataDetailsRelId(
			this.<Long>getColumnOriginalValue(
				"block_week_metadata_details_rel_id"));
		blockWeekMetadataDetailsRelImpl.setBlocksMetadataDetailRelId(
			this.<Long>getColumnOriginalValue(
				"blocks_metadata_details_rel_id"));
		blockWeekMetadataDetailsRelImpl.setWeekNo(
			this.<String>getColumnOriginalValue("week_no"));
		blockWeekMetadataDetailsRelImpl.setWeekStartDate(
			this.<Date>getColumnOriginalValue("week_start_date"));
		blockWeekMetadataDetailsRelImpl.setWeekEndDate(
			this.<Date>getColumnOriginalValue("week_end_date"));
		blockWeekMetadataDetailsRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		blockWeekMetadataDetailsRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		blockWeekMetadataDetailsRelImpl.setCreatedDate(
			this.<Date>getColumnOriginalValue("created_date"));
		blockWeekMetadataDetailsRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		blockWeekMetadataDetailsRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		blockWeekMetadataDetailsRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));

		return blockWeekMetadataDetailsRelImpl;
	}

	@Override
	public int compareTo(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		long primaryKey = blockWeekMetadataDetailsRel.getPrimaryKey();

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

		if (!(object instanceof BlockWeekMetadataDetailsRel)) {
			return false;
		}

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			(BlockWeekMetadataDetailsRel)object;

		long primaryKey = blockWeekMetadataDetailsRel.getPrimaryKey();

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
	public CacheModel<BlockWeekMetadataDetailsRel> toCacheModel() {
		BlockWeekMetadataDetailsRelCacheModel
			blockWeekMetadataDetailsRelCacheModel =
				new BlockWeekMetadataDetailsRelCacheModel();

		blockWeekMetadataDetailsRelCacheModel.uuid = getUuid();

		String uuid = blockWeekMetadataDetailsRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			blockWeekMetadataDetailsRelCacheModel.uuid = null;
		}

		blockWeekMetadataDetailsRelCacheModel.blockWeekMetadataDetailsRelId =
			getBlockWeekMetadataDetailsRelId();

		blockWeekMetadataDetailsRelCacheModel.blocksMetadataDetailRelId =
			getBlocksMetadataDetailRelId();

		blockWeekMetadataDetailsRelCacheModel.weekNo = getWeekNo();

		String weekNo = blockWeekMetadataDetailsRelCacheModel.weekNo;

		if ((weekNo != null) && (weekNo.length() == 0)) {
			blockWeekMetadataDetailsRelCacheModel.weekNo = null;
		}

		Date weekStartDate = getWeekStartDate();

		if (weekStartDate != null) {
			blockWeekMetadataDetailsRelCacheModel.weekStartDate =
				weekStartDate.getTime();
		}
		else {
			blockWeekMetadataDetailsRelCacheModel.weekStartDate =
				Long.MIN_VALUE;
		}

		Date weekEndDate = getWeekEndDate();

		if (weekEndDate != null) {
			blockWeekMetadataDetailsRelCacheModel.weekEndDate =
				weekEndDate.getTime();
		}
		else {
			blockWeekMetadataDetailsRelCacheModel.weekEndDate = Long.MIN_VALUE;
		}

		blockWeekMetadataDetailsRelCacheModel.groupId = getGroupId();

		blockWeekMetadataDetailsRelCacheModel.companyId = getCompanyId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			blockWeekMetadataDetailsRelCacheModel.createdDate =
				createdDate.getTime();
		}
		else {
			blockWeekMetadataDetailsRelCacheModel.createdDate = Long.MIN_VALUE;
		}

		blockWeekMetadataDetailsRelCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			blockWeekMetadataDetailsRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			blockWeekMetadataDetailsRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		blockWeekMetadataDetailsRelCacheModel.modifiedBy = getModifiedBy();

		return blockWeekMetadataDetailsRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BlockWeekMetadataDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BlockWeekMetadataDetailsRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlockWeekMetadataDetailsRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(BlockWeekMetadataDetailsRel)this);

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
			<InvocationHandler, BlockWeekMetadataDetailsRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						BlockWeekMetadataDetailsRel.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _blockWeekMetadataDetailsRelId;
	private long _blocksMetadataDetailRelId;
	private String _weekNo;
	private Date _weekStartDate;
	private Date _weekEndDate;
	private long _groupId;
	private long _companyId;
	private Date _createdDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<BlockWeekMetadataDetailsRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BlockWeekMetadataDetailsRel)this);
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
			"block_week_metadata_details_rel_id",
			_blockWeekMetadataDetailsRelId);
		_columnOriginalValues.put(
			"blocks_metadata_details_rel_id", _blocksMetadataDetailRelId);
		_columnOriginalValues.put("week_no", _weekNo);
		_columnOriginalValues.put("week_start_date", _weekStartDate);
		_columnOriginalValues.put("week_end_date", _weekEndDate);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("created_date", _createdDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"block_week_metadata_details_rel_id",
			"blockWeekMetadataDetailsRelId");
		attributeNames.put(
			"blocks_metadata_details_rel_id", "blocksMetadataDetailRelId");
		attributeNames.put("week_no", "weekNo");
		attributeNames.put("week_start_date", "weekStartDate");
		attributeNames.put("week_end_date", "weekEndDate");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("created_date", "createdDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_date", "modifiedDate");
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

		columnBitmasks.put("block_week_metadata_details_rel_id", 2L);

		columnBitmasks.put("blocks_metadata_details_rel_id", 4L);

		columnBitmasks.put("week_no", 8L);

		columnBitmasks.put("week_start_date", 16L);

		columnBitmasks.put("week_end_date", 32L);

		columnBitmasks.put("group_id", 64L);

		columnBitmasks.put("company_id", 128L);

		columnBitmasks.put("created_date", 256L);

		columnBitmasks.put("created_by", 512L);

		columnBitmasks.put("modified_date", 1024L);

		columnBitmasks.put("modified_by", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BlockWeekMetadataDetailsRel _escapedModel;

}