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
 * The table class for the &quot;role_type_prog_duration_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRel
 * @generated
 */
public class RoleTypeProgDurationRelTable
	extends BaseTable<RoleTypeProgDurationRelTable> {

	public static final RoleTypeProgDurationRelTable INSTANCE =
		new RoleTypeProgDurationRelTable();

	public final Column<RoleTypeProgDurationRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long>
		RoleTypeProgDurationRelId = createColumn(
			"role_type_prog_duration_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<RoleTypeProgDurationRelTable, Long> roleTypeMasterId =
		createColumn(
			"role_type_master_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long> programDurationId =
		createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoleTypeProgDurationRelTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RoleTypeProgDurationRelTable() {
		super("role_type_prog_duration_rel", RoleTypeProgDurationRelTable::new);
	}

}