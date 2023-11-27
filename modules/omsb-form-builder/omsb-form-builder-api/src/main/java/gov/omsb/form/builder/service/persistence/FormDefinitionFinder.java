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

package gov.omsb.form.builder.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface FormDefinitionFinder {

	public boolean createMasterTable(String tableName, String columnName);

	public boolean createMasterTableMapping(
		String tableName, String columnName);

	public boolean createFormTable(String formName);

	public boolean alterFormTable(
		String formName, String columnName, String dataType);

	public boolean isTableExists(String tableName);

	public java.util.List<String> getColumnNames(String tableName);

	public com.liferay.portal.kernel.json.JSONObject getColumnNamesWithDatatype(
		String tableName);

	public boolean modifyTableName(String oldTableName, String newTableName);

	public boolean insertIntoTable(
		String tableName, String columnNames, String columnValues);

	public boolean updateTableRecord(
		String tableName, String columnValues, String latestRecordCondition);

	public boolean updateMasterTableRecord(
		String tableName, String columnValues, String latestRecordCondition);

	public boolean updateMasterRecord(
		String tableName, String columnName, String columnValue,
		String latestRecord);

	public Long getSelectLatestRecord(String tableName);

	public Long getSelectLatestMasterRecord(String tableName);

	public Long getLastestMasterTableId(String tableName);

	public com.liferay.portal.kernel.json.JSONArray getDataSelectQuery(
		String tableName, String columnNames, String whereCondition);

	public boolean deleteFormRecords(String tableName, String recordIds);

	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getLatestFormDefinition(long groupId, long companyId);

}