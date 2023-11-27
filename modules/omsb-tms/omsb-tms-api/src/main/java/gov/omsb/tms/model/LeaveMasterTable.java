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
 * The table class for the &quot;leave_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMaster
 * @generated
 */
public class LeaveMasterTable extends BaseTable<LeaveMasterTable> {

	public static final LeaveMasterTable INSTANCE = new LeaveMasterTable();

	public final Column<LeaveMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> leaveMasterId = createColumn(
		"leave_master_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveMasterTable, Long> traineeId = createColumn(
		"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> leaveTypeId = createColumn(
		"leave_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> leaveTraineeId = createColumn(
		"leave_trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> blockName = createColumn(
		"block_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> leaveFrom = createColumn(
		"leave_from", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> leaveTo = createColumn(
		"leave_to", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Integer> noOfDays = createColumn(
		"no_of_days", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> contactName = createColumn(
		"contact_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> contactEmail = createColumn(
		"contact_email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> contactNo = createColumn(
		"contact_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> reasonForLeave = createColumn(
		"reason_for_leave", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> applicationDate = createColumn(
		"application_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> returnFromLeave = createColumn(
		"return_from_leave", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> reasonForDelay = createColumn(
		"reason_for_delay", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> programId = createColumn(
		"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveMasterTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveMasterTable() {
		super("leave_master", LeaveMasterTable::new);
	}

}