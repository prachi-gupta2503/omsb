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
 * The table class for the &quot;df_form_definition&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinition
 * @generated
 */
public class FormDefinitionTable extends BaseTable<FormDefinitionTable> {

	public static final FormDefinitionTable INSTANCE =
		new FormDefinitionTable();

	public final Column<FormDefinitionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Long> formDefinitionId =
		createColumn(
			"formDefinitionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FormDefinitionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> formName = createColumn(
		"formName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> formTitle = createColumn(
		"formTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> formDescription =
		createColumn(
			"formDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> formVersion = createColumn(
		"formVersion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> formConfig = createColumn(
		"formConfig", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FormDefinitionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FormDefinitionTable() {
		super("df_form_definition", FormDefinitionTable::new);
	}

}