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
 * The table class for the &quot;ec_member_request&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequest
 * @generated
 */
public class EcMemberRequestTable extends BaseTable<EcMemberRequestTable> {

	public static final EcMemberRequestTable INSTANCE =
		new EcMemberRequestTable();

	public final Column<EcMemberRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> ecMemberRequestId =
		createColumn(
			"ec_member_request_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EcMemberRequestTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> programId = createColumn(
		"program_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> potentialEcMemberId =
		createColumn(
			"potential_ec_member_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> potentialEcMemberRoleId =
		createColumn(
			"potential_ec_member_role_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long>
		latestEcMemberRequestStateId = createColumn(
			"latest_ec_member_request_state_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> coveringLetterId =
		createColumn(
			"covering_letter_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> cvId = createColumn(
		"cv_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> noObjectionLetterId =
		createColumn(
			"no_objection_letter_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> passportCopyId =
		createColumn(
			"passport_copy_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> nationalIdCopyId =
		createColumn(
			"national_id_copy_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> qararRequestId =
		createColumn(
			"qarar_request_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> qararDocId = createColumn(
		"qarar_doc_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> potentialEcMemberLruserid =
		createColumn(
			"potential_ec_member_lruserid", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EcMemberRequestTable() {
		super("ec_member_request", EcMemberRequestTable::new);
	}

}