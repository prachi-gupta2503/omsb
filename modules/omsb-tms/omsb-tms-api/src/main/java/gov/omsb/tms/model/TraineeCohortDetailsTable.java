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
 * The table class for the &quot;trainee_cohort_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetails
 * @generated
 */
public class TraineeCohortDetailsTable
	extends BaseTable<TraineeCohortDetailsTable> {

	public static final TraineeCohortDetailsTable INSTANCE =
		new TraineeCohortDetailsTable();

	public final Column<TraineeCohortDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long>
		traineeCohortDetailsId = createColumn(
			"trainee_cohort_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TraineeCohortDetailsTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long>
		traineeAdmissionDetailsRelId = createColumn(
			"trainee_admission_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, String> cohortYear =
		createColumn(
			"cohort_year", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Boolean> isCurrentCohort =
		createColumn(
			"is_current_cohort", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Long> traineeLevelId =
		createColumn(
			"trainee_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeCohortDetailsTable, Boolean>
		isCurrentTraineeLevel = createColumn(
			"is_current_trainee_level", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private TraineeCohortDetailsTable() {
		super("trainee_cohort_details", TraineeCohortDetailsTable::new);
	}

}