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
 * The table class for the &quot;leave_program_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveProgramMaster
 * @generated
 */
public class LeaveProgramMasterTable
	extends BaseTable<LeaveProgramMasterTable> {

	public static final LeaveProgramMasterTable INSTANCE =
		new LeaveProgramMasterTable();

	public final Column<LeaveProgramMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> leaveProgramMasterId =
		createColumn(
			"leave_program_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<LeaveProgramMasterTable, Long> programMasterId =
		createColumn(
			"program_master_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> leaveTypesId =
		createColumn(
			"leave_types_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Integer> noOfLeaves =
		createColumn(
			"no_of_leaves", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, String> residentLevelRule =
		createColumn(
			"resident_level_rule", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveProgramMasterTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveProgramMasterTable() {
		super("leave_program_master", LeaveProgramMasterTable::new);
	}

}