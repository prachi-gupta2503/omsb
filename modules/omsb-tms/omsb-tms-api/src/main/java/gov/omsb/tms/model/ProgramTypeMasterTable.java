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
 * The table class for the &quot;program_type_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMaster
 * @generated
 */
public class ProgramTypeMasterTable extends BaseTable<ProgramTypeMasterTable> {

	public static final ProgramTypeMasterTable INSTANCE =
		new ProgramTypeMasterTable();

	public final Column<ProgramTypeMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramTypeMasterTable, Long> programTypeMasterId =
		createColumn(
			"program_type_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProgramTypeMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramTypeMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramTypeMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramTypeMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramTypeMasterTable, String> programTypeName =
		createColumn(
			"program_type_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ProgramTypeMasterTable() {
		super("program_type_master", ProgramTypeMasterTable::new);
	}

}