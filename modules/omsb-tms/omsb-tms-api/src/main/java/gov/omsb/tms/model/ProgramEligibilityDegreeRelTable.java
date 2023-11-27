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
 * The table class for the &quot;program_eligibility_degree_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramEligibilityDegreeRel
 * @generated
 */
public class ProgramEligibilityDegreeRelTable
	extends BaseTable<ProgramEligibilityDegreeRelTable> {

	public static final ProgramEligibilityDegreeRelTable INSTANCE =
		new ProgramEligibilityDegreeRelTable();

	public final Column<ProgramEligibilityDegreeRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Long> programEdId =
		createColumn(
			"program_ed_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProgramEligibilityDegreeRelTable, Long> programId =
		createColumn(
			"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Long>
		eligibilityDegreeMasterId = createColumn(
			"eligibility_degree_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProgramEligibilityDegreeRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProgramEligibilityDegreeRelTable() {
		super(
			"program_eligibility_degree_rel",
			ProgramEligibilityDegreeRelTable::new);
	}

}