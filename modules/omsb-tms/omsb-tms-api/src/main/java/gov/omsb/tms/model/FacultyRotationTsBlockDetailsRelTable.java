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
 * The table class for the &quot;faculty_rotation_ts_block_details_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRel
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelTable
	extends BaseTable<FacultyRotationTsBlockDetailsRelTable> {

	public static final FacultyRotationTsBlockDetailsRelTable INSTANCE =
		new FacultyRotationTsBlockDetailsRelTable();

	public final Column<FacultyRotationTsBlockDetailsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long>
		facultyRotationTsBlockDetailsRelId = createColumn(
			"faculty_rotation_ts_block_details_rel_id", Long.class,
			Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long> facultyId =
		createColumn(
			"faculty_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long>
		blocksMetadataDetailsRelId = createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, Long>
		progDurationRotationTsRelId = createColumn(
			"progduration_rotation_ts_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyRotationTsBlockDetailsRelTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FacultyRotationTsBlockDetailsRelTable() {
		super(
			"faculty_rotation_ts_block_details_rel",
			FacultyRotationTsBlockDetailsRelTable::new);
	}

}