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
 * The table class for the &quot;trainee_logged_procedure_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetails
 * @generated
 */
public class TraineeLoggedProcedureDetailsTable
	extends BaseTable<TraineeLoggedProcedureDetailsTable> {

	public static final TraineeLoggedProcedureDetailsTable INSTANCE =
		new TraineeLoggedProcedureDetailsTable();

	public final Column<TraineeLoggedProcedureDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		traineeLoggedProcedureDetailsId = createColumn(
			"trainee_logged_procedure_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> rotationId =
		createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		traineeLevelId = createColumn(
			"trainee_level_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		procedureGroupId = createColumn(
			"procedure_group_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> procedureId =
		createColumn(
			"procedure_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> genderId =
		createColumn(
			"gender_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		patientTypeId = createColumn(
			"patient_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> visitTypeId =
		createColumn(
			"visit_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String> cptCode =
		createColumn(
			"cpt_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long>
		trainingSitesId = createColumn(
			"training_sites_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> roleTypeId =
		createColumn(
			"role_type_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> facultyId =
		createColumn(
			"faculty_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Long> traineeId =
		createColumn(
			"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String> patientId =
		createColumn(
			"patient_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Date> patientDOB =
		createColumn(
			"patient_dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, Date>
		procedurePerformedDate = createColumn(
			"procedure_performed_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String>
		diagnosisDescription = createColumn(
			"diagnosis_description", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String>
		traineeComments = createColumn(
			"trainee_comments", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String>
		supervisorComments = createColumn(
			"supervisor_comments", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TraineeLoggedProcedureDetailsTable, String>
		procedureStatus = createColumn(
			"procedure_status", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private TraineeLoggedProcedureDetailsTable() {
		super(
			"trainee_logged_procedure_details",
			TraineeLoggedProcedureDetailsTable::new);
	}

}