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
 * The table class for the &quot;trainee_progduration_traineelevel_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetails
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsTable
	extends BaseTable<TraineeProgdurationTraineelevelDetailsTable> {

	public static final TraineeProgdurationTraineelevelDetailsTable INSTANCE =
		new TraineeProgdurationTraineelevelDetailsTable();

	public final Column<TraineeProgdurationTraineelevelDetailsTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		traineePdTlErDetailsId = createColumn(
			"trainee_pd_tl_er_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		traineeId = createColumn(
			"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		traineeLevelId = createColumn(
			"trainee_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		createdBy = createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeProgdurationTraineelevelDetailsTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TraineeProgdurationTraineelevelDetailsTable() {
		super(
			"trainee_progduration_traineelevel_details",
			TraineeProgdurationTraineelevelDetailsTable::new);
	}

}