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
 * The table class for the &quot;progduration_traineelevel_blocks_leveltype_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRel
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelTable
	extends BaseTable<ProgdurationTraineelevelBlocksLevelTypeRelTable> {

	public static final ProgdurationTraineelevelBlocksLevelTypeRelTable
		INSTANCE = new ProgdurationTraineelevelBlocksLevelTypeRelTable();

	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		progdurationTlBlocksLtId = createColumn(
			"progduration_tl_blocks_lt_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		levelTypeId = createColumn(
			"level_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		traineeLevelId = createColumn(
			"trainee_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationTraineelevelBlocksLevelTypeRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column
		<ProgdurationTraineelevelBlocksLevelTypeRelTable, Integer> noOfBlocks =
			createColumn(
				"no_of_blocks", Integer.class, Types.INTEGER,
				Column.FLAG_DEFAULT);

	private ProgdurationTraineelevelBlocksLevelTypeRelTable() {
		super(
			"progduration_traineelevel_blocks_leveltype_rel",
			ProgdurationTraineelevelBlocksLevelTypeRelTable::new);
	}

}