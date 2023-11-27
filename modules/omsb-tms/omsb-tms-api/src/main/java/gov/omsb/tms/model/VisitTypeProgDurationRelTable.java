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
 * The table class for the &quot;visit_type_prog_duration_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeProgDurationRel
 * @generated
 */
public class VisitTypeProgDurationRelTable
	extends BaseTable<VisitTypeProgDurationRelTable> {

	public static final VisitTypeProgDurationRelTable INSTANCE =
		new VisitTypeProgDurationRelTable();

	public final Column<VisitTypeProgDurationRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long>
		VisitTypeProgDurationRelId = createColumn(
			"visit_type_prog_duration_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<VisitTypeProgDurationRelTable, Long> visitTypeMasterId =
		createColumn(
			"visit_type_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long> programDurationId =
		createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisitTypeProgDurationRelTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private VisitTypeProgDurationRelTable() {
		super(
			"visit_type_prog_duration_rel", VisitTypeProgDurationRelTable::new);
	}

}