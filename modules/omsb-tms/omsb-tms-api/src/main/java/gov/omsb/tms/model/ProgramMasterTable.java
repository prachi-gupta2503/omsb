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
 * The table class for the &quot;program_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMaster
 * @generated
 */
public class ProgramMasterTable extends BaseTable<ProgramMasterTable> {

	public static final ProgramMasterTable INSTANCE = new ProgramMasterTable();

	public final Column<ProgramMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Long> programMasterId =
		createColumn(
			"program_master_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProgramMasterTable, Long> programTypeId = createColumn(
		"program_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programCode = createColumn(
		"program_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programName = createColumn(
		"program_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programDescription =
		createColumn(
			"program_description", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Date> establishmentDate =
		createColumn(
			"establishment_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programVision =
		createColumn(
			"program_vision", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programMission =
		createColumn(
			"program_mission", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, Boolean> programStatus =
		createColumn(
			"program_status", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String> programObjectives =
		createColumn(
			"program_objectives", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProgramMasterTable, String>
		programAdmissionRequirements = createColumn(
			"program_admission_requirements", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ProgramMasterTable() {
		super("program_master", ProgramMasterTable::new);
	}

}