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

import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRelModel;

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
 * The base model implementation for the BlocksMetadataDetailsRel service. Represents a row in the &quot;blocks_metadata_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BlocksMetadataDetailsRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlocksMetadataDetailsRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelImpl
 * @generated
 */
@JSON(strict = true)
public class BlocksMetadataDetailsRelModelImpl
	extends BaseModelImpl<BlocksMetadataDetailsRel>
	implements BlocksMetadataDetailsRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a blocks metadata details rel model instance should use the <code>BlocksMetadataDetailsRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "blocks_metadata_details_rel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"blocks_metadata_details_rel_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"modified_date", Types.TIMESTAMP},
		{"created_by", Types.BIGINT}, {"modified_by", Types.BIGINT},
		{"progduration_tl_blocks_lt_id", Types.BIGINT},
		{"block_no", Types.VARCHAR}, {"block_start_date", Types.TIMESTAMP},
		{"block_end_date", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("blocks_metadata_details_rel_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("progduration_tl_blocks_lt_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("block_no", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("block_start_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("block_end_date", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table blocks_metadata_details_rel (uuid_ VARCHAR(75) null,blocks_metadata_details_rel_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,created_by LONG,modified_by LONG,progduration_tl_blocks_lt_id LONG,block_no VARCHAR(75) null,block_start_date DATE null,block_end_date DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table blocks_metadata_details_rel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY blocksMetadataDetailsRel.blocksMetadataDetailsRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY blocks_metadata_details_rel.blocks_metadata_details_rel_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BLOCKSTARTDATE_COLUMN_BITMASK = 1L;

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
	public static final long PROGDURATIONTLBLOCKSLTID_COLUMN_BITMASK = 8L;

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
	public static final long BLOCKSMETADATADETAILSRELID_COLUMN_BITMASK = 32L;

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

	public BlocksMetadataDetailsRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _blocksMetadataDetailsRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBlocksMetadataDetailsRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _blocksMetadataDetailsRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BlocksMetadataDetailsRel.class;
	}

	@Override
	public String getModelClassName() {
		return BlocksMetadataDetailsRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BlocksMetadataDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BlocksMetadataDetailsRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlocksMetadataDetailsRel, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BlocksMetadataDetailsRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BlocksMetadataDetailsRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BlocksMetadataDetailsRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BlocksMetadataDetailsRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BlocksMetadataDetailsRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BlocksMetadataDetailsRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<BlocksMetadataDetailsRel, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<BlocksMetadataDetailsRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<BlocksMetadataDetailsRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<BlocksMetadataDetailsRel, Object>>();
		Map<String, BiConsumer<BlocksMetadataDetailsRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<BlocksMetadataDetailsRel, ?>>();

		attributeGetterFunctions.put("uuid", BlocksMetadataDetailsRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<BlocksMetadataDetailsRel, String>)
				BlocksMetadataDetailsRel::setUuid);
		attributeGetterFunctions.put(
			"blocksMetadataDetailsRelId",
			BlocksMetadataDetailsRel::getBlocksMetadataDetailsRelId);
		attributeSetterBiConsumers.put(
			"blocksMetadataDetailsRelId",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setBlocksMetadataDetailsRelId);
		attributeGetterFunctions.put(
			"groupId", BlocksMetadataDetailsRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", BlocksMetadataDetailsRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", BlocksMetadataDetailsRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<BlocksMetadataDetailsRel, Date>)
				BlocksMetadataDetailsRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", BlocksMetadataDetailsRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<BlocksMetadataDetailsRel, Date>)
				BlocksMetadataDetailsRel::setModifiedDate);
		attributeGetterFunctions.put(
			"createdBy", BlocksMetadataDetailsRel::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", BlocksMetadataDetailsRel::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setModifiedBy);
		attributeGetterFunctions.put(
			"progDurationTlBlocksLtId",
			BlocksMetadataDetailsRel::getProgDurationTlBlocksLtId);
		attributeSetterBiConsumers.put(
			"progDurationTlBlocksLtId",
			(BiConsumer<BlocksMetadataDetailsRel, Long>)
				BlocksMetadataDetailsRel::setProgDurationTlBlocksLtId);
		attributeGetterFunctions.put(
			"blockNo", BlocksMetadataDetailsRel::getBlockNo);
		attributeSetterBiConsumers.put(
			"blockNo",
			(BiConsumer<BlocksMetadataDetailsRel, String>)
				BlocksMetadataDetailsRel::setBlockNo);
		attributeGetterFunctions.put(
			"blockStartDate", BlocksMetadataDetailsRel::getBlockStartDate);
		attributeSetterBiConsumers.put(
			"blockStartDate",
			(BiConsumer<BlocksMetadataDetailsRel, Date>)
				BlocksMetadataDetailsRel::setBlockStartDate);
		attributeGetterFunctions.put(
			"blockEndDate", BlocksMetadataDetailsRel::getBlockEndDate);
		attributeSetterBiConsumers.put(
			"blockEndDate",
			(BiConsumer<BlocksMetadataDetailsRel, Date>)
				BlocksMetadataDetailsRel::setBlockEndDate);

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
	public long getProgDurationTlBlocksLtId() {
		return _progDurationTlBlocksLtId;
	}

	@Override
	public void setProgDurationTlBlocksLtId(long progDurationTlBlocksLtId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_progDurationTlBlocksLtId = progDurationTlBlocksLtId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalProgDurationTlBlocksLtId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("progduration_tl_blocks_lt_id"));
	}

	@JSON
	@Override
	public String getBlockNo() {
		if (_blockNo == null) {
			return "";
		}
		else {
			return _blockNo;
		}
	}

	@Override
	public void setBlockNo(String blockNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockNo = blockNo;
	}

	@JSON
	@Override
	public Date getBlockStartDate() {
		return _blockStartDate;
	}

	@Override
	public void setBlockStartDate(Date blockStartDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockStartDate = blockStartDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalBlockStartDate() {
		return getColumnOriginalValue("block_start_date");
	}

	@JSON
	@Override
	public Date getBlockEndDate() {
		return _blockEndDate;
	}

	@Override
	public void setBlockEndDate(Date blockEndDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_blockEndDate = blockEndDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				BlocksMetadataDetailsRel.class.getName()));
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
			getCompanyId(), BlocksMetadataDetailsRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BlocksMetadataDetailsRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BlocksMetadataDetailsRel>
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
		BlocksMetadataDetailsRelImpl blocksMetadataDetailsRelImpl =
			new BlocksMetadataDetailsRelImpl();

		blocksMetadataDetailsRelImpl.setUuid(getUuid());
		blocksMetadataDetailsRelImpl.setBlocksMetadataDetailsRelId(
			getBlocksMetadataDetailsRelId());
		blocksMetadataDetailsRelImpl.setGroupId(getGroupId());
		blocksMetadataDetailsRelImpl.setCompanyId(getCompanyId());
		blocksMetadataDetailsRelImpl.setCreateDate(getCreateDate());
		blocksMetadataDetailsRelImpl.setModifiedDate(getModifiedDate());
		blocksMetadataDetailsRelImpl.setCreatedBy(getCreatedBy());
		blocksMetadataDetailsRelImpl.setModifiedBy(getModifiedBy());
		blocksMetadataDetailsRelImpl.setProgDurationTlBlocksLtId(
			getProgDurationTlBlocksLtId());
		blocksMetadataDetailsRelImpl.setBlockNo(getBlockNo());
		blocksMetadataDetailsRelImpl.setBlockStartDate(getBlockStartDate());
		blocksMetadataDetailsRelImpl.setBlockEndDate(getBlockEndDate());

		blocksMetadataDetailsRelImpl.resetOriginalValues();

		return blocksMetadataDetailsRelImpl;
	}

	@Override
	public BlocksMetadataDetailsRel cloneWithOriginalValues() {
		BlocksMetadataDetailsRelImpl blocksMetadataDetailsRelImpl =
			new BlocksMetadataDetailsRelImpl();

		blocksMetadataDetailsRelImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		blocksMetadataDetailsRelImpl.setBlocksMetadataDetailsRelId(
			this.<Long>getColumnOriginalValue(
				"blocks_metadata_details_rel_id"));
		blocksMetadataDetailsRelImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		blocksMetadataDetailsRelImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		blocksMetadataDetailsRelImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		blocksMetadataDetailsRelImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		blocksMetadataDetailsRelImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		blocksMetadataDetailsRelImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		blocksMetadataDetailsRelImpl.setProgDurationTlBlocksLtId(
			this.<Long>getColumnOriginalValue("progduration_tl_blocks_lt_id"));
		blocksMetadataDetailsRelImpl.setBlockNo(
			this.<String>getColumnOriginalValue("block_no"));
		blocksMetadataDetailsRelImpl.setBlockStartDate(
			this.<Date>getColumnOriginalValue("block_start_date"));
		blocksMetadataDetailsRelImpl.setBlockEndDate(
			this.<Date>getColumnOriginalValue("block_end_date"));

		return blocksMetadataDetailsRelImpl;
	}

	@Override
	public int compareTo(BlocksMetadataDetailsRel blocksMetadataDetailsRel) {
		long primaryKey = blocksMetadataDetailsRel.getPrimaryKey();

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

		if (!(object instanceof BlocksMetadataDetailsRel)) {
			return false;
		}

		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			(BlocksMetadataDetailsRel)object;

		long primaryKey = blocksMetadataDetailsRel.getPrimaryKey();

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
	public CacheModel<BlocksMetadataDetailsRel> toCacheModel() {
		BlocksMetadataDetailsRelCacheModel blocksMetadataDetailsRelCacheModel =
			new BlocksMetadataDetailsRelCacheModel();

		blocksMetadataDetailsRelCacheModel.uuid = getUuid();

		String uuid = blocksMetadataDetailsRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			blocksMetadataDetailsRelCacheModel.uuid = null;
		}

		blocksMetadataDetailsRelCacheModel.blocksMetadataDetailsRelId =
			getBlocksMetadataDetailsRelId();

		blocksMetadataDetailsRelCacheModel.groupId = getGroupId();

		blocksMetadataDetailsRelCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			blocksMetadataDetailsRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			blocksMetadataDetailsRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			blocksMetadataDetailsRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			blocksMetadataDetailsRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		blocksMetadataDetailsRelCacheModel.createdBy = getCreatedBy();

		blocksMetadataDetailsRelCacheModel.modifiedBy = getModifiedBy();

		blocksMetadataDetailsRelCacheModel.progDurationTlBlocksLtId =
			getProgDurationTlBlocksLtId();

		blocksMetadataDetailsRelCacheModel.blockNo = getBlockNo();

		String blockNo = blocksMetadataDetailsRelCacheModel.blockNo;

		if ((blockNo != null) && (blockNo.length() == 0)) {
			blocksMetadataDetailsRelCacheModel.blockNo = null;
		}

		Date blockStartDate = getBlockStartDate();

		if (blockStartDate != null) {
			blocksMetadataDetailsRelCacheModel.blockStartDate =
				blockStartDate.getTime();
		}
		else {
			blocksMetadataDetailsRelCacheModel.blockStartDate = Long.MIN_VALUE;
		}

		Date blockEndDate = getBlockEndDate();

		if (blockEndDate != null) {
			blocksMetadataDetailsRelCacheModel.blockEndDate =
				blockEndDate.getTime();
		}
		else {
			blocksMetadataDetailsRelCacheModel.blockEndDate = Long.MIN_VALUE;
		}

		return blocksMetadataDetailsRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BlocksMetadataDetailsRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BlocksMetadataDetailsRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BlocksMetadataDetailsRel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(BlocksMetadataDetailsRel)this);

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
			<InvocationHandler, BlocksMetadataDetailsRel>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						BlocksMetadataDetailsRel.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _blocksMetadataDetailsRelId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _createdBy;
	private long _modifiedBy;
	private long _progDurationTlBlocksLtId;
	private String _blockNo;
	private Date _blockStartDate;
	private Date _blockEndDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<BlocksMetadataDetailsRel, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BlocksMetadataDetailsRel)this);
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
			"blocks_metadata_details_rel_id", _blocksMetadataDetailsRelId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put(
			"progduration_tl_blocks_lt_id", _progDurationTlBlocksLtId);
		_columnOriginalValues.put("block_no", _blockNo);
		_columnOriginalValues.put("block_start_date", _blockStartDate);
		_columnOriginalValues.put("block_end_date", _blockEndDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"blocks_metadata_details_rel_id", "blocksMetadataDetailsRelId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put(
			"progduration_tl_blocks_lt_id", "progDurationTlBlocksLtId");
		attributeNames.put("block_no", "blockNo");
		attributeNames.put("block_start_date", "blockStartDate");
		attributeNames.put("block_end_date", "blockEndDate");

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

		columnBitmasks.put("blocks_metadata_details_rel_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("modified_date", 32L);

		columnBitmasks.put("created_by", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("progduration_tl_blocks_lt_id", 256L);

		columnBitmasks.put("block_no", 512L);

		columnBitmasks.put("block_start_date", 1024L);

		columnBitmasks.put("block_end_date", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BlocksMetadataDetailsRel _escapedModel;

}