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

package gov.omsb.tms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;procedure_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMaster
 * @generated
 */
public class ProcedureMasterTable extends BaseTable<ProcedureMasterTable> {

	public static final ProcedureMasterTable INSTANCE =
		new ProcedureMasterTable();

	public final Column<ProcedureMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Long> procedureMasterId =
		createColumn(
			"procedure_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProcedureMasterTable, Long> procedureGroupMasterId =
		createColumn(
			"procedure_group_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, String> procedureName =
		createColumn(
			"procedure_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, String> cptCode = createColumn(
		"cpt_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcedureMasterTable, Boolean> isMandatory =
		createColumn(
			"is_mandatory", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ProcedureMasterTable() {
		super("procedure_master", ProcedureMasterTable::new);
	}

}