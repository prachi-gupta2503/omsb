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
 * The table class for the &quot;program_duty_assignment&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignment
 * @generated
 */
public class ProgramDutyAssignmentTable
	extends BaseTable<ProgramDutyAssignmentTable> {

	public static final ProgramDutyAssignmentTable INSTANCE =
		new ProgramDutyAssignmentTable();

	public final Column<ProgramDutyAssignmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long>
		programDutyAssignmentId = createColumn(
			"program_duty_assignment_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProgramDutyAssignmentTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> programId =
		createColumn(
			"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> dutyAssignmentId =
		createColumn(
			"duty_assignment_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, Long> cohortId =
		createColumn(
			"cohort_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDutyAssignmentTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProgramDutyAssignmentTable() {
		super("program_duty_assignment", ProgramDutyAssignmentTable::new);
	}

}