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
 * The table class for the &quot;duty_log&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLog
 * @generated
 */
public class DutyLogTable extends BaseTable<DutyLogTable> {

	public static final DutyLogTable INSTANCE = new DutyLogTable();

	public final Column<DutyLogTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> dutyLogId = createColumn(
		"duty_log_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DutyLogTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> traineeId = createColumn(
		"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> programDutyAssignmentId =
		createColumn(
			"program_duty_assignment_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> blocksMetadataDetailRelId =
		createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Long> residencyLevelId = createColumn(
		"residency_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Boolean> multiDays = createColumn(
		"multi_days", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Date> startDate = createColumn(
		"start_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyLogTable, Date> endDate = createColumn(
		"end_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DutyLogTable() {
		super("duty_log", DutyLogTable::new);
	}

}