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

package gov.omsb.form.builder.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;df_form_record_entry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntry
 * @generated
 */
public class FormRecordEntryTable extends BaseTable<FormRecordEntryTable> {

	public static final FormRecordEntryTable INSTANCE =
		new FormRecordEntryTable();

	public final Column<FormRecordEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> formRecordEntryId =
		createColumn(
			"formRecordEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FormRecordEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> formDefinitionId =
		createColumn(
			"formDefinitionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> recordId = createColumn(
		"recordId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, String> dfTableName =
		createColumn(
			"dfTableName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FormRecordEntryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FormRecordEntryTable() {
		super("df_form_record_entry", FormRecordEntryTable::new);
	}

}