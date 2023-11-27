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
 * The table class for the &quot;faculty_request&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequest
 * @generated
 */
public class FacultyRequestTable extends BaseTable<FacultyRequestTable> {

	public static final FacultyRequestTable INSTANCE =
		new FacultyRequestTable();

	public final Column<FacultyRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> facultyRequestId =
		createColumn(
			"faculty_request_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FacultyRequestTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> programId = createColumn(
		"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> potentialFacultyId =
		createColumn(
			"potential_faculty_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> potentialFacultyTypeId =
		createColumn(
			"potential_faculty_type_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long>
		lastestFacultyRequestStateId = createColumn(
			"lastest_faculty_request_state_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> coveringLetterId =
		createColumn(
			"covering_letter_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> cvId = createColumn(
		"cv_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> passportCopyId =
		createColumn(
			"passport_copy_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> notionalIdCopyId =
		createColumn(
			"notional_id_copy_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FacultyRequestTable() {
		super("faculty_request", FacultyRequestTable::new);
	}

}