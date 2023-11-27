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
 * The table class for the &quot;ec_member_request_status&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatus
 * @generated
 */
public class EcMemberRequestStatusTable
	extends BaseTable<EcMemberRequestStatusTable> {

	public static final EcMemberRequestStatusTable INSTANCE =
		new EcMemberRequestStatusTable();

	public final Column<EcMemberRequestStatusTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, Long>
		ecMemberRequestStatusId = createColumn(
			"ec_member_request_status_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EcMemberRequestStatusTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, String> nameEn =
		createColumn(
			"name_en", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EcMemberRequestStatusTable, String> nameAr =
		createColumn(
			"name_ar", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EcMemberRequestStatusTable() {
		super("ec_member_request_status", EcMemberRequestStatusTable::new);
	}

}