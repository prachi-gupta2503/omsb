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
 * The table class for the &quot;duty_assignment_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignment
 * @generated
 */
public class DutyAssignmentTable extends BaseTable<DutyAssignmentTable> {

	public static final DutyAssignmentTable INSTANCE =
		new DutyAssignmentTable();

	public final Column<DutyAssignmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Long> dutyAssignmentId =
		createColumn(
			"duty_assignment_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DutyAssignmentTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, Long> dutyTypeId = createColumn(
		"duty_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, String> assignment = createColumn(
		"assignment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DutyAssignmentTable, String> colorCode = createColumn(
		"color_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DutyAssignmentTable() {
		super("duty_assignment_master", DutyAssignmentTable::new);
	}

}