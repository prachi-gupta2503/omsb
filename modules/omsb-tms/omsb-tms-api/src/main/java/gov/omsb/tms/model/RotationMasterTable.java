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
 * The table class for the &quot;rotation_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RotationMaster
 * @generated
 */
public class RotationMasterTable extends BaseTable<RotationMasterTable> {

	public static final RotationMasterTable INSTANCE =
		new RotationMasterTable();

	public final Column<RotationMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, Long> rotationMasterId =
		createColumn(
			"rotation_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RotationMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, String> rotationCode =
		createColumn(
			"rotation_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, String> rotationShortName =
		createColumn(
			"rotation_short_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, String> rotationName =
		createColumn(
			"rotation_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, Boolean> rotationStatus =
		createColumn(
			"rotation_status", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<RotationMasterTable, String> rotationObjectives =
		createColumn(
			"rotation_objecctives", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private RotationMasterTable() {
		super("rotation_master", RotationMasterTable::new);
	}

}