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
 * The table class for the &quot;trainee_rotation_ts_block_details_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRel
 * @generated
 */
public class TraineeRotationTsBlockDetailsRelTable
	extends BaseTable<TraineeRotationTsBlockDetailsRelTable> {

	public static final TraineeRotationTsBlockDetailsRelTable INSTANCE =
		new TraineeRotationTsBlockDetailsRelTable();

	public final Column<TraineeRotationTsBlockDetailsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long>
		traineeRotationTsBlockDetailsRelId = createColumn(
			"trainee_rotation_ts_block_details_rel_id", Long.class,
			Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long> traineeId =
		createColumn(
			"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long>
		blocksMetadataDetailsRelId = createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long>
		progDurationRotationTsRelId = createColumn(
			"progduration_rotation_ts_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, Long>
		traineeCohortDetailsId = createColumn(
			"trainee_cohort_details_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, String>
		rotationStatus = createColumn(
			"rotation_status", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TraineeRotationTsBlockDetailsRelTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TraineeRotationTsBlockDetailsRelTable() {
		super(
			"trainee_rotation_ts_block_details_rel",
			TraineeRotationTsBlockDetailsRelTable::new);
	}

}