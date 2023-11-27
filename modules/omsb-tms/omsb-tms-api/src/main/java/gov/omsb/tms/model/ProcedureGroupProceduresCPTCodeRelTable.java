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
 * The table class for the &quot;proceduregroup_procedures_cptcode_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRel
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelTable
	extends BaseTable<ProcedureGroupProceduresCPTCodeRelTable> {

	public static final ProcedureGroupProceduresCPTCodeRelTable INSTANCE =
		new ProcedureGroupProceduresCPTCodeRelTable();

	public final Column<ProcedureGroupProceduresCPTCodeRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		pgProcedureCptCodeRelId = createColumn(
			"pg_procedures_cpt_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		createdBy = createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		procedureGroupId = createColumn(
			"procedure_group_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		procedureId = createColumn(
			"procedure_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcedureGroupProceduresCPTCodeRelTable, Long>
		cptCodeId = createColumn(
			"cpt_code_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProcedureGroupProceduresCPTCodeRelTable() {
		super(
			"proceduregroup_procedures_cptcode_rel",
			ProcedureGroupProceduresCPTCodeRelTable::new);
	}

}