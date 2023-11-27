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

import gov.omsb.tms.model.FacultyRequestStatus;
import gov.omsb.tms.model.FacultyRequestStatusModel;

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
 * The base model implementation for the FacultyRequestStatus service. Represents a row in the &quot;faculty_request_status&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FacultyRequestStatusModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FacultyRequestStatusImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatusImpl
 * @generated
 */
@JSON(strict = true)
public class FacultyRequestStatusModelImpl
	extends BaseModelImpl<FacultyRequestStatus>
	implements FacultyRequestStatusModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a faculty request status model instance should use the <code>FacultyRequestStatus</code> interface instead.
	 */
	public static final String TABLE_NAME = "faculty_request_status";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"faculty_request_status_id", Types.BIGINT},
		{"group_id", Types.BIGINT}, {"company_id", Types.BIGINT},
		{"create_date", Types.TIMESTAMP}, {"modified_date", Types.TIMESTAMP},
		{"code", Types.VARCHAR}, {"name_en", Types.VARCHAR},
		{"name_ar", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("faculty_request_status_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("group_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("company_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("create_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modified_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("code", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name_en", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name_ar", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table faculty_request_status (uuid_ VARCHAR(75) null,faculty_request_status_id LONG not null primary key,group_id LONG,company_id LONG,create_date DATE null,modified_date DATE null,code VARCHAR(75) null,name_en VARCHAR(75) null,name_ar VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table faculty_request_status";

	public static final String ORDER_BY_JPQL =
		" ORDER BY facultyRequestStatus.facultyRequestStatusId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY faculty_request_status.faculty_request_status_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CODE_COLUMN_BITMASK = 1L;

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
	public static final long FACULTYREQUESTSTATUSID_COLUMN_BITMASK = 16L;

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

	public FacultyRequestStatusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _facultyRequestStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacultyRequestStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facultyRequestStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FacultyRequestStatus.class;
	}

	@Override
	public String getModelClassName() {
		return FacultyRequestStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FacultyRequestStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FacultyRequestStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacultyRequestStatus, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FacultyRequestStatus)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FacultyRequestStatus, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FacultyRequestStatus, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FacultyRequestStatus)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FacultyRequestStatus, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FacultyRequestStatus, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FacultyRequestStatus, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FacultyRequestStatus, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FacultyRequestStatus, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FacultyRequestStatus, Object>>();
		Map<String, BiConsumer<FacultyRequestStatus, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<FacultyRequestStatus, ?>>();

		attributeGetterFunctions.put("uuid", FacultyRequestStatus::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FacultyRequestStatus, String>)
				FacultyRequestStatus::setUuid);
		attributeGetterFunctions.put(
			"facultyRequestStatusId",
			FacultyRequestStatus::getFacultyRequestStatusId);
		attributeSetterBiConsumers.put(
			"facultyRequestStatusId",
			(BiConsumer<FacultyRequestStatus, Long>)
				FacultyRequestStatus::setFacultyRequestStatusId);
		attributeGetterFunctions.put(
			"groupId", FacultyRequestStatus::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FacultyRequestStatus, Long>)
				FacultyRequestStatus::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FacultyRequestStatus::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FacultyRequestStatus, Long>)
				FacultyRequestStatus::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", FacultyRequestStatus::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FacultyRequestStatus, Date>)
				FacultyRequestStatus::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FacultyRequestStatus::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FacultyRequestStatus, Date>)
				FacultyRequestStatus::setModifiedDate);
		attributeGetterFunctions.put("code", FacultyRequestStatus::getCode);
		attributeSetterBiConsumers.put(
			"code",
			(BiConsumer<FacultyRequestStatus, String>)
				FacultyRequestStatus::setCode);
		attributeGetterFunctions.put("nameEn", FacultyRequestStatus::getNameEn);
		attributeSetterBiConsumers.put(
			"nameEn",
			(BiConsumer<FacultyRequestStatus, String>)
				FacultyRequestStatus::setNameEn);
		attributeGetterFunctions.put("nameAr", FacultyRequestStatus::getNameAr);
		attributeSetterBiConsumers.put(
			"nameAr",
			(BiConsumer<FacultyRequestStatus, String>)
				FacultyRequestStatus::setNameAr);

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
	public long getFacultyRequestStatusId() {
		return _facultyRequestStatusId;
	}

	@Override
	public void setFacultyRequestStatusId(long facultyRequestStatusId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_facultyRequestStatusId = facultyRequestStatusId;
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
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCode() {
		return getColumnOriginalValue("code");
	}

	@JSON
	@Override
	public String getNameEn() {
		if (_nameEn == null) {
			return "";
		}
		else {
			return _nameEn;
		}
	}

	@Override
	public void setNameEn(String nameEn) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nameEn = nameEn;
	}

	@JSON
	@Override
	public String getNameAr() {
		if (_nameAr == null) {
			return "";
		}
		else {
			return _nameAr;
		}
	}

	@Override
	public void setNameAr(String nameAr) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nameAr = nameAr;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(FacultyRequestStatus.class.getName()));
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
			getCompanyId(), FacultyRequestStatus.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FacultyRequestStatus toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FacultyRequestStatus>
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
		FacultyRequestStatusImpl facultyRequestStatusImpl =
			new FacultyRequestStatusImpl();

		facultyRequestStatusImpl.setUuid(getUuid());
		facultyRequestStatusImpl.setFacultyRequestStatusId(
			getFacultyRequestStatusId());
		facultyRequestStatusImpl.setGroupId(getGroupId());
		facultyRequestStatusImpl.setCompanyId(getCompanyId());
		facultyRequestStatusImpl.setCreateDate(getCreateDate());
		facultyRequestStatusImpl.setModifiedDate(getModifiedDate());
		facultyRequestStatusImpl.setCode(getCode());
		facultyRequestStatusImpl.setNameEn(getNameEn());
		facultyRequestStatusImpl.setNameAr(getNameAr());

		facultyRequestStatusImpl.resetOriginalValues();

		return facultyRequestStatusImpl;
	}

	@Override
	public FacultyRequestStatus cloneWithOriginalValues() {
		FacultyRequestStatusImpl facultyRequestStatusImpl =
			new FacultyRequestStatusImpl();

		facultyRequestStatusImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		facultyRequestStatusImpl.setFacultyRequestStatusId(
			this.<Long>getColumnOriginalValue("faculty_request_status_id"));
		facultyRequestStatusImpl.setGroupId(
			this.<Long>getColumnOriginalValue("group_id"));
		facultyRequestStatusImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("company_id"));
		facultyRequestStatusImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("create_date"));
		facultyRequestStatusImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modified_date"));
		facultyRequestStatusImpl.setCode(
			this.<String>getColumnOriginalValue("code"));
		facultyRequestStatusImpl.setNameEn(
			this.<String>getColumnOriginalValue("name_en"));
		facultyRequestStatusImpl.setNameAr(
			this.<String>getColumnOriginalValue("name_ar"));

		return facultyRequestStatusImpl;
	}

	@Override
	public int compareTo(FacultyRequestStatus facultyRequestStatus) {
		long primaryKey = facultyRequestStatus.getPrimaryKey();

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

		if (!(object instanceof FacultyRequestStatus)) {
			return false;
		}

		FacultyRequestStatus facultyRequestStatus =
			(FacultyRequestStatus)object;

		long primaryKey = facultyRequestStatus.getPrimaryKey();

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
	public CacheModel<FacultyRequestStatus> toCacheModel() {
		FacultyRequestStatusCacheModel facultyRequestStatusCacheModel =
			new FacultyRequestStatusCacheModel();

		facultyRequestStatusCacheModel.uuid = getUuid();

		String uuid = facultyRequestStatusCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			facultyRequestStatusCacheModel.uuid = null;
		}

		facultyRequestStatusCacheModel.facultyRequestStatusId =
			getFacultyRequestStatusId();

		facultyRequestStatusCacheModel.groupId = getGroupId();

		facultyRequestStatusCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			facultyRequestStatusCacheModel.createDate = createDate.getTime();
		}
		else {
			facultyRequestStatusCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			facultyRequestStatusCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			facultyRequestStatusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		facultyRequestStatusCacheModel.code = getCode();

		String code = facultyRequestStatusCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			facultyRequestStatusCacheModel.code = null;
		}

		facultyRequestStatusCacheModel.nameEn = getNameEn();

		String nameEn = facultyRequestStatusCacheModel.nameEn;

		if ((nameEn != null) && (nameEn.length() == 0)) {
			facultyRequestStatusCacheModel.nameEn = null;
		}

		facultyRequestStatusCacheModel.nameAr = getNameAr();

		String nameAr = facultyRequestStatusCacheModel.nameAr;

		if ((nameAr != null) && (nameAr.length() == 0)) {
			facultyRequestStatusCacheModel.nameAr = null;
		}

		return facultyRequestStatusCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FacultyRequestStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FacultyRequestStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FacultyRequestStatus, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FacultyRequestStatus)this);

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

		private static final Function<InvocationHandler, FacultyRequestStatus>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					FacultyRequestStatus.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _facultyRequestStatusId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _code;
	private String _nameEn;
	private String _nameAr;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FacultyRequestStatus, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FacultyRequestStatus)this);
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
			"faculty_request_status_id", _facultyRequestStatusId);
		_columnOriginalValues.put("group_id", _groupId);
		_columnOriginalValues.put("company_id", _companyId);
		_columnOriginalValues.put("create_date", _createDate);
		_columnOriginalValues.put("modified_date", _modifiedDate);
		_columnOriginalValues.put("code", _code);
		_columnOriginalValues.put("name_en", _nameEn);
		_columnOriginalValues.put("name_ar", _nameAr);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put(
			"faculty_request_status_id", "facultyRequestStatusId");
		attributeNames.put("group_id", "groupId");
		attributeNames.put("company_id", "companyId");
		attributeNames.put("create_date", "createDate");
		attributeNames.put("modified_date", "modifiedDate");
		attributeNames.put("name_en", "nameEn");
		attributeNames.put("name_ar", "nameAr");

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

		columnBitmasks.put("faculty_request_status_id", 2L);

		columnBitmasks.put("group_id", 4L);

		columnBitmasks.put("company_id", 8L);

		columnBitmasks.put("create_date", 16L);

		columnBitmasks.put("modified_date", 32L);

		columnBitmasks.put("code", 64L);

		columnBitmasks.put("name_en", 128L);

		columnBitmasks.put("name_ar", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FacultyRequestStatus _escapedModel;

}