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
 * The table class for the &quot;shared_rotation_request_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetails
 * @generated
 */
public class SharedRotationRequestDetailsTable
	extends BaseTable<SharedRotationRequestDetailsTable> {

	public static final SharedRotationRequestDetailsTable INSTANCE =
		new SharedRotationRequestDetailsTable();

	public final Column<SharedRotationRequestDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long>
		sharedRotationRequestDetailsId = createColumn(
			"shared_rotation_request_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SharedRotationRequestDetailsTable, Long>
		programDurationId = createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> rotationId =
		createColumn(
			"rotation_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long>
		noOfTraineesRequested = createColumn(
			"no_of_trainees_requested", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, String>
		requesterComment = createColumn(
			"requester_comment", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> approvedCount =
		createColumn(
			"approved_count", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, Long> rejectedCount =
		createColumn(
			"rejected_count", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, String>
		requestRaisedTo = createColumn(
			"request_raised_to", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationRequestDetailsTable, String>
		requestRaisedBy = createColumn(
			"request_raised_by", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private SharedRotationRequestDetailsTable() {
		super(
			"shared_rotation_request_details",
			SharedRotationRequestDetailsTable::new);
	}

}