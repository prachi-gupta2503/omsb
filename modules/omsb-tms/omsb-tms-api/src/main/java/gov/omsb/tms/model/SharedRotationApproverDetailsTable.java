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
 * The table class for the &quot;shared_rotation_approver_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetails
 * @generated
 */
public class SharedRotationApproverDetailsTable
	extends BaseTable<SharedRotationApproverDetailsTable> {

	public static final SharedRotationApproverDetailsTable INSTANCE =
		new SharedRotationApproverDetailsTable();

	public final Column<SharedRotationApproverDetailsTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long>
		sharedRotationApproverDetailsId = createColumn(
			"shared_rotation_approver_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SharedRotationApproverDetailsTable, Long>
		sharedRotationRequestDetailsId = createColumn(
			"shared_rotation_request_details_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, String> status =
		createColumn(
			"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long>
		approvedTrainees = createColumn(
			"approved_trainees", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Long>
		rejectedTrainees = createColumn(
			"rejected_trainees", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, String>
		approversComment = createColumn(
			"approvers_comment", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SharedRotationApproverDetailsTable, Date>
		decisionMakingDate = createColumn(
			"decision_making_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	private SharedRotationApproverDetailsTable() {
		super(
			"shared_rotation_approver_details",
			SharedRotationApproverDetailsTable::new);
	}

}