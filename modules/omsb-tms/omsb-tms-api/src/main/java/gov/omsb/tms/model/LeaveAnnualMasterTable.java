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
 * The table class for the &quot;leave_annual_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaster
 * @generated
 */
public class LeaveAnnualMasterTable extends BaseTable<LeaveAnnualMasterTable> {

	public static final LeaveAnnualMasterTable INSTANCE =
		new LeaveAnnualMasterTable();

	public final Column<LeaveAnnualMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> leaveAnnualMasterId =
		createColumn(
			"leave_annual_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveAnnualMasterTable, Long> leaveProgramMasterId =
		createColumn(
			"leave_program_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> leaveTypesId =
		createColumn(
			"leave_types_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> trainingLevelId =
		createColumn(
			"training_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, String> blockName =
		createColumn(
			"block_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Integer> maxTraineeApplyLeave =
		createColumn(
			"max_trainee_apply_leave", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Integer> noOfTraineeTakenLeave =
		createColumn(
			"no_of_trainee_taken_leave", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveAnnualMasterTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveAnnualMasterTable() {
		super("leave_annual_master", LeaveAnnualMasterTable::new);
	}

}