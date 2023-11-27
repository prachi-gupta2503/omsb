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
 * The table class for the &quot;leave_annual_max_trainee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTrainee
 * @generated
 */
public class LeaveAnnualMaxTraineeTable
	extends BaseTable<LeaveAnnualMaxTraineeTable> {

	public static final LeaveAnnualMaxTraineeTable INSTANCE =
		new LeaveAnnualMaxTraineeTable();

	public final Column<LeaveAnnualMaxTraineeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Long>
		leaveAnnualMaxTraineeId = createColumn(
			"leave_annual_max_trainee_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveAnnualMaxTraineeTable, Long> leaveAnnualRuleId =
		createColumn(
			"leave_annual_rule_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, String> trainingLevel =
		createColumn(
			"training_level", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Integer> block =
		createColumn(
			"block", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Integer> week =
		createColumn("week", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Integer>
		maxTraineeApplyLeave = createColumn(
			"max_trainee_apply_leave", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Integer>
		noOfTraineeTakenLeave = createColumn(
			"no_of_trainee_taken_leave", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMaxTraineeTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveAnnualMaxTraineeTable() {
		super("leave_annual_max_trainee", LeaveAnnualMaxTraineeTable::new);
	}

}