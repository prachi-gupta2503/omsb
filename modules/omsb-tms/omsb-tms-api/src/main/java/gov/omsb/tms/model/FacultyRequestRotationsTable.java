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
 * The table class for the &quot;faculty_request_rotations&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotations
 * @generated
 */
public class FacultyRequestRotationsTable
	extends BaseTable<FacultyRequestRotationsTable> {

	public static final FacultyRequestRotationsTable INSTANCE =
		new FacultyRequestRotationsTable();

	public final Column<FacultyRequestRotationsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long>
		facultyRequestRotationsId = createColumn(
			"faculty_request_rotations_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FacultyRequestRotationsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> facultyRequestId =
		createColumn(
			"faculty_request_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> trainingSiteId =
		createColumn(
			"training_site_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Long> rotationId =
		createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRequestRotationsTable, Boolean> isActive =
		createColumn(
			"is_active", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private FacultyRequestRotationsTable() {
		super("faculty_request_rotations", FacultyRequestRotationsTable::new);
	}

}