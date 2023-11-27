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
 * The table class for the &quot;progduration_rotation_trainingsites_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRel
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelTable
	extends BaseTable<ProgdurationRotationTrainingsitesRelTable> {

	public static final ProgdurationRotationTrainingsitesRelTable INSTANCE =
		new ProgdurationRotationTrainingsitesRelTable();

	public final Column<ProgdurationRotationTrainingsitesRelTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		progdurationRotationTsRelId = createColumn(
			"progduration_rotation_ts_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		rotationId = createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		trainingSitesId = createColumn(
			"training_sites_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		createdBy = createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Boolean>
		isSharedRotation = createColumn(
			"is_shared_rotation", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		rotationOwningProgramId = createColumn(
			"rotation_owning_program_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, String>
		progCodeRsnSiteCode = createColumn(
			"progcode_rsn_sitecode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Long>
		owningProgramDurationId = createColumn(
			"owning_program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationRotationTrainingsitesRelTable, Integer>
		noOfSlots = createColumn(
			"no_of_slots", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ProgdurationRotationTrainingsitesRelTable() {
		super(
			"progduration_rotation_trainingsites_rel",
			ProgdurationRotationTrainingsitesRelTable::new);
	}

}