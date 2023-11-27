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
 * The table class for the &quot;participation_type_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMaster
 * @generated
 */
public class ParticipationTypeMasterTable
	extends BaseTable<ParticipationTypeMasterTable> {

	public static final ParticipationTypeMasterTable INSTANCE =
		new ParticipationTypeMasterTable();

	public final Column<ParticipationTypeMasterTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Long>
		participationTypeMasterId = createColumn(
			"participation_type_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ParticipationTypeMasterTable, Long> programDurationId =
		createColumn(
			"program_duration_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTypeMasterTable, String>
		participationTypeName = createColumn(
			"participation_type_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ParticipationTypeMasterTable() {
		super("participation_type_master", ParticipationTypeMasterTable::new);
	}

}