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
 * The table class for the &quot;blocks_metadata_details_rel&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRel
 * @generated
 */
public class BlocksMetadataDetailsRelTable
	extends BaseTable<BlocksMetadataDetailsRelTable> {

	public static final BlocksMetadataDetailsRelTable INSTANCE =
		new BlocksMetadataDetailsRelTable();

	public final Column<BlocksMetadataDetailsRelTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Long>
		blocksMetadataDetailsRelId = createColumn(
			"blocks_metadata_details_rel_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BlocksMetadataDetailsRelTable, Long> groupId =
		createColumn("group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Long> companyId =
		createColumn(
			"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Long> createdBy =
		createColumn(
			"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Long> modifiedBy =
		createColumn(
			"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Long>
		progDurationTlBlocksLtId = createColumn(
			"progduration_tl_blocks_lt_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, String> blockNo =
		createColumn(
			"block_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Date> blockStartDate =
		createColumn(
			"block_start_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<BlocksMetadataDetailsRelTable, Date> blockEndDate =
		createColumn(
			"block_end_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private BlocksMetadataDetailsRelTable() {
		super(
			"blocks_metadata_details_rel", BlocksMetadataDetailsRelTable::new);
	}

}