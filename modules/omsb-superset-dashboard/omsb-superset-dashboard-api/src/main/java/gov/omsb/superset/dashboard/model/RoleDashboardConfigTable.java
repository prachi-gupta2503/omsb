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

package gov.omsb.superset.dashboard.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;role_dashboard_config&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfig
 * @generated
 */
public class RoleDashboardConfigTable
	extends BaseTable<RoleDashboardConfigTable> {

	public static final RoleDashboardConfigTable INSTANCE =
		new RoleDashboardConfigTable();

	public final Column<RoleDashboardConfigTable, Long> configId = createColumn(
		"configId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RoleDashboardConfigTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, String> dashboardId =
		createColumn(
			"dashboardId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Date> createdDate =
		createColumn(
			"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RoleDashboardConfigTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RoleDashboardConfigTable() {
		super("role_dashboard_config", RoleDashboardConfigTable::new);
	}

}