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
 * The table class for the &quot;visit_type_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeMaster
 * @generated
 */
public class VisitTypeMasterTable extends BaseTable<VisitTypeMasterTable> {

	public static final VisitTypeMasterTable INSTANCE =
		new VisitTypeMasterTable();

	public final Column<VisitTypeMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Long> visitTypeMasterId =
		createColumn(
			"visit_type_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<VisitTypeMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeMasterTable, String> visitTypeName =
		createColumn(
			"visit_type_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private VisitTypeMasterTable() {
		super("visit_type_master", VisitTypeMasterTable::new);
	}

}