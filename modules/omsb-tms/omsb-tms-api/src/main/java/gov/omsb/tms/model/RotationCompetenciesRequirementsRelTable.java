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
 * The table class for the &quot;rotation_competencies_requirements_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RotationCompetenciesRequirementsRel
 * @generated
 */
public class RotationCompetenciesRequirementsRelTable
	extends BaseTable<RotationCompetenciesRequirementsRelTable> {

	public static final RotationCompetenciesRequirementsRelTable INSTANCE =
		new RotationCompetenciesRequirementsRelTable();

	public final Column<RotationCompetenciesRequirementsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		rotationCompetenciesRelId = createColumn(
			"rotation_competencies_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		progDurationId = createColumn(
			"prog_duration_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		rotationId = createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		competenciesMasterId = createColumn(
			"competencies_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RotationCompetenciesRequirementsRelTable, String>
		requirements = createColumn(
			"requirements", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RotationCompetenciesRequirementsRelTable() {
		super(
			"rotation_competencies_requirements_rel",
			RotationCompetenciesRequirementsRelTable::new);
	}

}