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
 * The table class for the &quot;faculty_bank_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetails
 * @generated
 */
public class FacultyBankDetailsTable
	extends BaseTable<FacultyBankDetailsTable> {

	public static final FacultyBankDetailsTable INSTANCE =
		new FacultyBankDetailsTable();

	public final Column<FacultyBankDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, Long> facultyBankDetailsId =
		createColumn(
			"faculty_bank_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FacultyBankDetailsTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, Long> facultyRequestId =
		createColumn(
			"faculty_request_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, String> bankName =
		createColumn(
			"bank_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, String> accountNo =
		createColumn(
			"account_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FacultyBankDetailsTable, String> bankBranch =
		createColumn(
			"bank_branch", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FacultyBankDetailsTable() {
		super("faculty_bank_details", FacultyBankDetailsTable::new);
	}

}