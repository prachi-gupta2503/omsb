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
 * The table class for the &quot;leave_annual_rule&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualRule
 * @generated
 */
public class LeaveAnnualRuleTable extends BaseTable<LeaveAnnualRuleTable> {

	public static final LeaveAnnualRuleTable INSTANCE =
		new LeaveAnnualRuleTable();

	public final Column<LeaveAnnualRuleTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Long> leaveAnnualRuleId =
		createColumn(
			"leave_annual_rule_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveAnnualRuleTable, Long> programMasterId =
		createColumn(
			"program_master_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Date> lastDateForSubmission =
		createColumn(
			"last_date_for_submission", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, String> annualLeaveAvailableAt =
		createColumn(
			"annual_leave_available_at", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualRuleTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveAnnualRuleTable() {
		super("leave_annual_rule", LeaveAnnualRuleTable::new);
	}

}