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

import gov.omsb.tms.model.FacultyRequestRotations;
import gov.omsb.tms.model.FacultyRequestRotationsModel;

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
 * The base model implementation for the FacultyRequestRotations service. Represents a row in the &quot;faculty_request_rotations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FacultyRequestRotationsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FacultyRequestRotationsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsImpl
 * @generated
 */
@JSON(strict = true)
public class FacultyRequestRotationsModelImpl
	extends BaseModelImpl<FacultyRequestRotations>
	implements FacultyRequestRotationsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a faculty request rotations model instance should use the <code>FacultyRequestRotations</code> interface instead.
	 */
	public static final String TABLE_NAME = "faculty_request_rotations";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"faculty_request_rotations_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"created_by", Types.BIGINT}, {"create_date", Types.TIMESTAMP},
		{"modified_date", Types.TIMESTAMP}, {"modified_by", Types.BIGINT},
		{"faculty_request_id", Types.BIGINT},
		{"training_site_id", Types.BIGINT}, {"rotation_id", Types.BIGINT},
		{"is_active", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("faculty_request_rotations_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("created_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_by", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("faculty_request_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("training_site_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rotation_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("is_active", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table faculty_request_rotations (uuid_ VARCHAR(75) null,faculty_request_rotations_id LONG not null primary key,group_id LONG,company_id LONG,created_by LONG,create_date DATE null,modified_date DATE null,modified_by LONG,faculty_request_id LONG,training_site_id LONG,rotation_id LONG,is_active BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table faculty_request_rotations";

	public static final String ORDER_BY_JPQL =
		" ORDER BY facultyRequestRotations.facultyRequestRotationsId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY faculty_request_rotations.faculty_request_rotations_id ASC";

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
	public static final long FACULTYREQUESTID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISACTIVE_COLUMN_BITMASK = 8L;

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
	public static final long FACULTYREQUESTROTATIONSID_COLUMN_BITMASK = 32L;

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

	public FacultyRequestRotationsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _facultyRequestRotationsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacultyRequestRotationsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facultyRequestRotationsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FacultyRequestRotations.class;
	}

	@Override
	public String getModelClassName() {
		return FacultyRequestRotations.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FacultyRequestRotations, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FacultyRequestRotations, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacultyRequestRotations, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FacultyRequestRotations)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FacultyRequestRotations, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FacultyRequestRotations, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FacultyRequestRotations)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FacultyRequestRotations, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FacultyRequestRotations, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FacultyRequestRotations, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<FacultyRequestRotations, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<FacultyRequestRotations, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FacultyRequestRotations, Object>>();
		Map<String, BiConsumer<FacultyRequestRotations, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<FacultyRequestRotations, ?>>();

		attributeGetterFunctions.put("uuid", FacultyRequestRotations::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FacultyRequestRotations, String>)
				FacultyRequestRotations::setUuid);
		attributeGetterFunctions.put(
			"facultyRequestRotationsId",
			FacultyRequestRotations::getFacultyRequestRotationsId);
		attributeSetterBiConsumers.put(
			"facultyRequestRotationsId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setFacultyRequestRotationsId);
		attributeGetterFunctions.put(
			"groupId", FacultyRequestRotations::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FacultyRequestRotations::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setCompanyId);
		attributeGetterFunctions.put(
			"createdBy", FacultyRequestRotations::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setCreatedBy);
		attributeGetterFunctions.put(
			"createDate", FacultyRequestRotations::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FacultyRequestRotations, Date>)
				FacultyRequestRotations::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FacultyRequestRotations::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FacultyRequestRotations, Date>)
				FacultyRequestRotations::setModifiedDate);
		attributeGetterFunctions.put(
			"modifiedBy", FacultyRequestRotations::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setModifiedBy);
		attributeGetterFunctions.put(
			"facultyRequestId", FacultyRequestRotations::getFacultyRequestId);
		attributeSetterBiConsumers.put(
			"facultyRequestId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setFacultyRequestId);
		attributeGetterFunctions.put(
			"trainingSiteId", FacultyRequestRotations::getTrainingSiteId);
		attributeSetterBiConsumers.put(
			"trainingSiteId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setTrainingSiteId);
		attributeGetterFunctions.put(
			"rotationId", FacultyRequestRotations::getRotationId);
		attributeSetterBiConsumers.put(
			"rotationId",
			(BiConsumer<FacultyRequestRotations, Long>)
				FacultyRequestRotations::setRotationId);
		attributeGetterFunctions.put(
			"isActive", FacultyRequestRotations::getIsActive);
		attributeSetterBiConsumers.put(
			"isActive",
			(BiConsumer<FacultyRequestRotations, Boolean>)
				FacultyRequestRotations::setIsActive);

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
	public long getFacultyRequestRotationsId() {
		return _facultyRequestRotationsId;
	}

	@Override
	public void setFacultyRequestRotationsId(long facultyRequestRotationsId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_facultyRequestRotationsId = facultyRequestRotationsId;
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
	public long getFacultyRequestId() {
		return _facultyRequestId;
	}

	@Override
	public void setFacultyRequestId(long facultyRequestId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_facultyRequestId = facultyRequestId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFacultyRequestId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("faculty_request_id"));
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
	public boolean getIsActive() {
		return _isActive;
	}

	@JSON
	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isActive = isActive;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("is_active"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(FacultyRequestRotations.class.getName()));
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
			getCompanyId(), FacultyRequestRotations.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FacultyRequestRotations toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FacultyRequestRotations>
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
		FacultyRequestRotationsImpl facultyRequestRotationsImpl =
			new FacultyRequestRotationsImpl();

		facultyRequestRotationsImpl.setUuid(getUuid());
		facultyRequestRotationsImpl.setFacultyRequestRotationsId(
			getFacultyRequestRotationsId());
		facultyRequestRotationsImpl.setGroupId(getGroupId());
		facultyRequestRotationsImpl.setCompanyId(getCompanyId());
		facultyRequestRotationsImpl.setCreatedBy(getCreatedBy());
		facultyRequestRotationsImpl.setCreateDate(getCreateDate());
		facultyRequestRotationsImpl.setModifiedDate(getModifiedDate());
		facultyRequestRotationsImpl.setModifiedBy(getModifiedBy());
		facultyRequestRotationsImpl.setFacultyRequestId(getFacultyRequestId());
		facultyRequestRotationsImpl.setTrainingSiteId(getTrainingSiteId());
		facultyRequestRotationsImpl.setRotationId(getRotationId());
		facultyRequestRotationsImpl.setIsActive(isIsActive());

		facultyRequestRotationsImpl.resetOriginalValues();

		return facultyRequestRotationsImpl;
	}

	@Override
	public FacultyRequestRotations cloneWithOriginalValues() {
		FacultyRequestRotationsImpl facultyRequestRotationsImpl =
			new FacultyRequestRotationsImpl();

		facultyRequestRotationsImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		facultyRequestRotationsImpl.setFacultyRequestRotationsId(
			this.<Long>getColumnOriginalValue("faculty_request_rotations_id"));
		facultyRequestRotationsImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		facultyRequestRotationsImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		facultyRequestRotationsImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("created_by"));
		facultyRequestRotationsImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		facultyRequestRotationsImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		facultyRequestRotationsImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modified_by"));
		facultyRequestRotationsImpl.setFacultyRequestId(
			this.<Long>getColumnOriginalValue("faculty_request_id"));
		facultyRequestRotationsImpl.setTrainingSiteId(
			this.<Long>getColumnOriginalValue("training_site_id"));
		facultyRequestRotationsImpl.setRotationId(
			this.<Long>getColumnOriginalValue("rotation_id"));
		facultyRequestRotationsImpl.setIsActive(
			this.<Boolean>getColumnOriginalValue("is_active"));

		return facultyRequestRotationsImpl;
	}

	@Override
	public int compareTo(FacultyRequestRotations facultyRequestRotations) {
		long primaryKey = facultyRequestRotations.getPrimaryKey();

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

		if (!(object instanceof FacultyRequestRotations)) {
			return false;
		}

		FacultyRequestRotations facultyRequestRotations =
			(FacultyRequestRotations)object;

		long primaryKey = facultyRequestRotations.getPrimaryKey();

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
	public CacheModel<FacultyRequestRotations> toCacheModel() {
		FacultyRequestRotationsCacheModel facultyRequestRotationsCacheModel =
			new FacultyRequestRotationsCacheModel();

		facultyRequestRotationsCacheModel.uuid = getUuid();

		String uuid = facultyRequestRotationsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			facultyRequestRotationsCacheModel.uuid = null;
		}

		facultyRequestRotationsCacheModel.facultyRequestRotationsId =
			getFacultyRequestRotationsId();

		facultyRequestRotationsCacheModel.groupId = getGroupId();

		facultyRequestRotationsCacheModel.companyId = getCompanyId();

		facultyRequestRotationsCacheModel.createdBy = getCreatedBy();

		Date createDate = getCreateDate();

		if (createDate != null) {
			facultyRequestRotationsCacheModel.createDate = createDate.getTime();
		}
		else {
			facultyRequestRotationsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			facultyRequestRotationsCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			facultyRequestRotationsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		facultyRequestRotationsCacheModel.modifiedBy = getModifiedBy();

		facultyRequestRotationsCacheModel.facultyRequestId =
			getFacultyRequestId();

		facultyRequestRotationsCacheModel.trainingSiteId = getTrainingSiteId();

		facultyRequestRotationsCacheModel.rotationId = getRotationId();

		facultyRequestRotationsCacheModel.isActive = isIsActive();

		return facultyRequestRotationsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FacultyRequestRotations, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FacultyRequestRotations, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacultyRequestRotations, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FacultyRequestRotations)this);

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
			<InvocationHandler, FacultyRequestRotations>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						FacultyRequestRotations.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _facultyRequestRotationsId;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _facultyRequestId;
	private long _trainingSiteId;
	private long _rotationId;
	private boolean _isActive;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FacultyRequestRotations, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FacultyRequestRotations)this);
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
			"faculty_request_rotations_id", _facultyRequestRotationsId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("created_by", _createdBy);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("modified_by", _modifiedBy);
		_columnOriginalValues.put("faculty_request_id", _facultyRequestId);
		_columnOriginalValues.put("training_site_id", _trainingSiteId);
		_columnOriginalValues.put("rotation_id", _rotationId);
		_columnOriginalValues.put("is_active", _isActive);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"faculty_request_rotations_id", "facultyRequestRotationsId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("created_by", "createdBy");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("modified_by", "modifiedBy");
		attributeNames.put("faculty_request_id", "facultyRequestId");
		attributeNames.put("training_site_id", "trainingSiteId");
		attributeNames.put("rotation_id", "rotationId");
		attributeNames.put("is_active", "isActive");

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

		columnBitmasks.put("faculty_request_rotations_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("created_by", 16L);

		columnBitmasks.put("create_date", 32L);

		columnBitmasks.put("modified_date", 64L);

		columnBitmasks.put("modified_by", 128L);

		columnBitmasks.put("faculty_request_id", 256L);

		columnBitmasks.put("training_site_id", 512L);

		columnBitmasks.put("rotation_id", 1024L);

		columnBitmasks.put("is_active", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FacultyRequestRotations _escapedModel;

}