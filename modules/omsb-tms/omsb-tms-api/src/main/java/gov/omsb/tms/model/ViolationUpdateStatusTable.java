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
 * The table class for the &quot;violation_update_status&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatus
 * @generated
 */
public class ViolationUpdateStatusTable
	extends BaseTable<ViolationUpdateStatusTable> {

	public static final ViolationUpdateStatusTable INSTANCE =
		new ViolationUpdateStatusTable();

	public final Column<ViolationUpdateStatusTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Long>
		violationUpdateStatusId = createColumn(
			"violation_update_status_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ViolationUpdateStatusTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Date> createdDate =
		createColumn(
			"created_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Long>
		blocksMetadataDetailRelId = createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ViolationUpdateStatusTable, Boolean> status =
		createColumn(
			"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private ViolationUpdateStatusTable() {
		super("violation_update_status", ViolationUpdateStatusTable::new);
	}

}