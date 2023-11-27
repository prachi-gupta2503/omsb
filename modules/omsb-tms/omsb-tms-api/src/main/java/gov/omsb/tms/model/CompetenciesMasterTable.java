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
 * The table class for the &quot;competencies_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMaster
 * @generated
 */
public class CompetenciesMasterTable
	extends BaseTable<CompetenciesMasterTable> {

	public static final CompetenciesMasterTable INSTANCE =
		new CompetenciesMasterTable();

	public final Column<CompetenciesMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompetenciesMasterTable, Long> competenciesMasterId =
		createColumn(
			"competencies_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CompetenciesMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompetenciesMasterTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompetenciesMasterTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompetenciesMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompetenciesMasterTable, String> competencyName =
		createColumn(
			"competency_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private CompetenciesMasterTable() {
		super("competencies_master", CompetenciesMasterTable::new);
	}

}