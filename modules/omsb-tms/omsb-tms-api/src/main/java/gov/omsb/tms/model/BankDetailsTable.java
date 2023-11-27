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
 * The table class for the &quot;bank_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BankDetails
 * @generated
 */
public class BankDetailsTable extends BaseTable<BankDetailsTable> {

	public static final BankDetailsTable INSTANCE = new BankDetailsTable();

	public final Column<BankDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, Long> bankDetailsId = createColumn(
		"bank_details_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BankDetailsTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, Long> ecMemberRequestId =
		createColumn(
			"ec_member_request_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, String> bankName = createColumn(
		"bank_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, String> accountNumber = createColumn(
		"account_number", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankDetailsTable, String> bankBranch = createColumn(
		"bank_branch", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BankDetailsTable() {
		super("bank_details", BankDetailsTable::new);
	}

}