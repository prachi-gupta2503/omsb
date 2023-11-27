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
 * The table class for the &quot;trainee_sponsor_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetails
 * @generated
 */
public class TraineeSponsorDetailsTable
	extends BaseTable<TraineeSponsorDetailsTable> {

	public static final TraineeSponsorDetailsTable INSTANCE =
		new TraineeSponsorDetailsTable();

	public final Column<TraineeSponsorDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long>
		traineeSponsorDetailsId = createColumn(
			"trainee_sponsor_details_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TraineeSponsorDetailsTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Date> createdDate =
		createColumn(
			"created_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long> traineeId =
		createColumn(
			"trainee_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, Long> programDurationId =
		createColumn(
			"program_duration_Id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<TraineeSponsorDetailsTable, String> sponsor =
		createColumn(
			"sponsor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TraineeSponsorDetailsTable() {
		super("trainee_sponsor_details", TraineeSponsorDetailsTable::new);
	}

}