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
 * The table class for the &quot;program_duration_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetails
 * @generated
 */
public class ProgramDurationDetailsTable
	extends BaseTable<ProgramDurationDetailsTable> {

	public static final ProgramDurationDetailsTable INSTANCE =
		new ProgramDurationDetailsTable();

	public final Column<ProgramDurationDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Long> progDurationId =
		createColumn(
			"prog_duration_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProgramDurationDetailsTable, Long> programId =
		createColumn(
			"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, String> ayApplicableForm =
		createColumn(
			"ay_applicable_form", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProgramDurationDetailsTable, Integer> noOfBlocks =
		createColumn(
			"no_of_blocks", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ProgramDurationDetailsTable() {
		super("program_duration_details", ProgramDurationDetailsTable::new);
	}

}