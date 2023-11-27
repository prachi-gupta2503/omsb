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
 * The table class for the &quot;program_programtype_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRel
 * @generated
 */
public class ProgramProgramTypeRelTable
	extends BaseTable<ProgramProgramTypeRelTable> {

	public static final ProgramProgramTypeRelTable INSTANCE =
		new ProgramProgramTypeRelTable();

	public final Column<ProgramProgramTypeRelTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Long> programPtId =
		createColumn(
			"program_pt_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProgramProgramTypeRelTable, Long> programId =
		createColumn(
			"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Long> programTypeId =
		createColumn(
			"program_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramProgramTypeRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProgramProgramTypeRelTable() {
		super("program_programtype_rel", ProgramProgramTypeRelTable::new);
	}

}