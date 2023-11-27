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
 * The table class for the &quot;progduration_rotation_tl_pg_procedure_pt_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRel
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelTable
	extends BaseTable<ProgdurationRotationTlPgProcedurePtRelTable> {

	public static final ProgdurationRotationTlPgProcedurePtRelTable INSTANCE =
		new ProgdurationRotationTlPgProcedurePtRelTable();

	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		progdurationRotationTlPgProcedurePtRelId = createColumn(
			"progduration_rotation_tl_pg_procedure_pt_rel_id", Long.class,
			Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		rotationId = createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		traineeLevelId = createColumn(
			"trainee_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		procedureGroupId = createColumn(
			"procedure_group_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		procedureId = createColumn(
			"procedure_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		createdBy = createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Integer>
		minimumProcedures = createColumn(
			"minimum_procedures", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTlPgProcedurePtRelTable, Integer>
		traineelevelMinimumProcedures = createColumn(
			"traineelevel_minimum_procedures", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private ProgdurationRotationTlPgProcedurePtRelTable() {
		super(
			"progduration_rotation_tl_pg_procedure_pt_rel",
			ProgdurationRotationTlPgProcedurePtRelTable::new);
	}

}