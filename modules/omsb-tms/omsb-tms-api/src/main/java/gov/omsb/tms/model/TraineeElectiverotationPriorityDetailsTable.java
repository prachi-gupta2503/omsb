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
 * The table class for the &quot;trainee_electiverotation_priority_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetails
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsTable
	extends BaseTable<TraineeElectiverotationPriorityDetailsTable> {

	public static final TraineeElectiverotationPriorityDetailsTable INSTANCE =
		new TraineeElectiverotationPriorityDetailsTable();

	public final Column<TraineeElectiverotationPriorityDetailsTable, String>
		uuid = createColumn(
			"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		traineeElectiverotationPriorityDetailsId = createColumn(
			"trainee_electiverotation_priority_details_id", Long.class,
			Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		traineePdTlErDetailsId = createColumn(
			"trainee_pd_tl_er_details_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		rotationId = createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		groupId = createColumn(
			"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		companyId = createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Date>
		createDate = createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		createdBy = createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Date>
		modifiedDate = createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Long>
		modifiedBy = createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeElectiverotationPriorityDetailsTable, Integer>
		sequence = createColumn(
			"sequence", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private TraineeElectiverotationPriorityDetailsTable() {
		super(
			"trainee_electiverotation_priority_details",
			TraineeElectiverotationPriorityDetailsTable::new);
	}

}