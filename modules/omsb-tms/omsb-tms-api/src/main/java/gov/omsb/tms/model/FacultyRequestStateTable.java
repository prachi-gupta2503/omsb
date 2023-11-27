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
 * The table class for the &quot;faculty_request_state&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestState
 * @generated
 */
public class FacultyRequestStateTable
	extends BaseTable<FacultyRequestStateTable> {

	public static final FacultyRequestStateTable INSTANCE =
		new FacultyRequestStateTable();

	public final Column<FacultyRequestStateTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> facultyRequestStateId =
		createColumn(
			"faculty_request_state_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FacultyRequestStateTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> createdByRoleId =
		createColumn(
			"created_by_role_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> facultyRequestId =
		createColumn(
			"faculty_request_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, Long> facultyRequestStatusId =
		createColumn(
			"faculty_request_status_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestStateTable, String> comments =
		createColumn(
			"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FacultyRequestStateTable() {
		super("faculty_request_state", FacultyRequestStateTable::new);
	}

}