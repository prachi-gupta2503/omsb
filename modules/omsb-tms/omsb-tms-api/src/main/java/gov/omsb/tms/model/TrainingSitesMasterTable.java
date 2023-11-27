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
 * The table class for the &quot;training_sites_master&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMaster
 * @generated
 */
public class TrainingSitesMasterTable
	extends BaseTable<TrainingSitesMasterTable> {

	public static final TrainingSitesMasterTable INSTANCE =
		new TrainingSitesMasterTable();

	public final Column<TrainingSitesMasterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, Long> trainingSiteMasterId =
		createColumn(
			"training_site_master_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<TrainingSitesMasterTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, String> trainingSiteName =
		createColumn(
			"training_site_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, String> trainingSiteCode =
		createColumn(
			"training_site_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, Boolean> trainingSiteStatus =
		createColumn(
			"training_site_status", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, String> trainingSiteAddress =
		createColumn(
			"training_site_address", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TrainingSitesMasterTable, String>
		trainingSiteDescription = createColumn(
			"training_site_description", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private TrainingSitesMasterTable() {
		super("training_sites_master", TrainingSitesMasterTable::new);
	}

}