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
 * The table class for the &quot;rotation_objectives_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RotationObjectivesRel
 * @generated
 */
public class RotationObjectivesRelTable
	extends BaseTable<RotationObjectivesRelTable> {

	public static final RotationObjectivesRelTable INSTANCE =
		new RotationObjectivesRelTable();

	public final Column<RotationObjectivesRelTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Long>
		rotationObjectivesRelId = createColumn(
			"rotation_objectives_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RotationObjectivesRelTable, Long> progDurationId =
		createColumn(
			"prog_duration_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Long> rotationId =
		createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationObjectivesRelTable, String> objectives =
		createColumn(
			"objectives", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RotationObjectivesRelTable() {
		super("rotation_objectives_rel", RotationObjectivesRelTable::new);
	}

}