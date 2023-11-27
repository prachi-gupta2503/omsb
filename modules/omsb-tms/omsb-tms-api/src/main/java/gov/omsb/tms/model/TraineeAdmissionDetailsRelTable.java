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
 * The table class for the &quot;trainee_admission_details_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRel
 * @generated
 */
public class TraineeAdmissionDetailsRelTable
	extends BaseTable<TraineeAdmissionDetailsRelTable> {

	public static final TraineeAdmissionDetailsRelTable INSTANCE =
		new TraineeAdmissionDetailsRelTable();

	public final Column<TraineeAdmissionDetailsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long>
		traineeAdmissionDetailsRelId = createColumn(
			"trainee_admission_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TraineeAdmissionDetailsRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long> traineeId =
		createColumn(
			"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, String> admissionYear =
		createColumn(
			"admission_year", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, String> omsbNumber =
		createColumn(
			"omsb_number", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeAdmissionDetailsRelTable, String>
		traineeAddress = createColumn(
			"trainee_address", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private TraineeAdmissionDetailsRelTable() {
		super(
			"trainee_admission_details_rel",
			TraineeAdmissionDetailsRelTable::new);
	}

}