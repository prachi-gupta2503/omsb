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
 * The table class for the &quot;duty_log_violation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolation
 * @generated
 */
public class DutyLogViolationTable extends BaseTable<DutyLogViolationTable> {

	public static final DutyLogViolationTable INSTANCE =
		new DutyLogViolationTable();

	public final Column<DutyLogViolationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> ViolationId = createColumn(
		"violation_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DutyLogViolationTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> traineeId = createColumn(
		"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> programMasterId =
		createColumn(
			"program_master_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> residencyLevel =
		createColumn(
			"residency_level", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> rotationId = createColumn(
		"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> trainingSiteId =
		createColumn(
			"training_site_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> blockId = createColumn(
		"block_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> blockWeekId = createColumn(
		"block_week_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> programDutyRuleId =
		createColumn(
			"program_duty_rule_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgme80HoursRule =
		createColumn(
			"acgme_80_hours_rule", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgmeCallRuleOption1 =
		createColumn(
			"acgme_call_rule_option1", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgmeCallRuleOption2 =
		createColumn(
			"acgme_call_rule_option2", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgmeShortBreakRule =
		createColumn(
			"acgme_Short_Break_Rule", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgme24HoursRule =
		createColumn(
			"acgme_24_hours_rule", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Integer> acgmeDayOffRule =
		createColumn(
			"acgme_day_off_rule", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DutyLogViolationTable, Long> dutyLogId = createColumn(
		"duty_log_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DutyLogViolationTable() {
		super("duty_log_violation", DutyLogViolationTable::new);
	}

}