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

package gov.omsb.form.builder.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;df_range_option_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RangeOptionMaster
 * @generated
 */
public class RangeOptionMasterTable extends BaseTable<RangeOptionMasterTable> {

	public static final RangeOptionMasterTable INSTANCE =
		new RangeOptionMasterTable();

	public final Column<RangeOptionMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Long> rangeOptionId =
		createColumn(
			"rangeOptionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RangeOptionMasterTable, String> rangeOptionName =
		createColumn(
			"rangeOptionName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, String> rangeOptions =
		createColumn(
			"rangeOptions", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Date> createdDate =
		createColumn(
			"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RangeOptionMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private RangeOptionMasterTable() {
		super("df_range_option_master", RangeOptionMasterTable::new);
	}

}