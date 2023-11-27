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
 * The table class for the &quot;block_week_metadata_details_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRel
 * @generated
 */
public class BlockWeekMetadataDetailsRelTable
	extends BaseTable<BlockWeekMetadataDetailsRelTable> {

	public static final BlockWeekMetadataDetailsRelTable INSTANCE =
		new BlockWeekMetadataDetailsRelTable();

	public final Column<BlockWeekMetadataDetailsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Long>
		blockWeekMetadataDetailsRelId = createColumn(
			"block_week_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BlockWeekMetadataDetailsRelTable, Long>
		blocksMetadataDetailRelId = createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, String> weekNo =
		createColumn(
			"week_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Date> weekStartDate =
		createColumn(
			"week_start_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Date> weekEndDate =
		createColumn(
			"week_end_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Date> createdDate =
		createColumn(
			"created_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlockWeekMetadataDetailsRelTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BlockWeekMetadataDetailsRelTable() {
		super(
			"block_week_metadata_details_rel",
			BlockWeekMetadataDetailsRelTable::new);
	}

}