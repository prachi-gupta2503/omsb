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
 * The table class for the &quot;progduration_competencies_requirements_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRel
 * @generated
 */
public class ProgdurationCompetenciesRequirementsRelTable
	extends BaseTable<ProgdurationCompetenciesRequirementsRelTable> {

	public static final ProgdurationCompetenciesRequirementsRelTable INSTANCE =
		new ProgdurationCompetenciesRequirementsRelTable();

	public final Column<ProgdurationCompetenciesRequirementsRelTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Long>
		progdurationCompetenciesRelId = createColumn(
			"progduration_competencies_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Long>
		progDurationId = createColumn(
			"prog_duration_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, Long>
		competenciesMasterId = createColumn(
			"competencies_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgdurationCompetenciesRequirementsRelTable, String>
		requirements = createColumn(
			"requirements", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProgdurationCompetenciesRequirementsRelTable() {
		super(
			"progduration_competencies_requirements_rel",
			ProgdurationCompetenciesRequirementsRelTable::new);
	}

}