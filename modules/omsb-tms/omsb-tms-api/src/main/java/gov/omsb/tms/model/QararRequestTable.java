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
 * The table class for the &quot;qarar_request_info&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see QararRequest
 * @generated
 */
public class QararRequestTable extends BaseTable<QararRequestTable> {

	public static final QararRequestTable INSTANCE = new QararRequestTable();

	public final Column<QararRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> qararRequestId = createColumn(
		"qarar_request_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<QararRequestTable, Long> referenceId = createColumn(
		"reference_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, String> referenceClass =
		createColumn(
			"reference_class", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, String> qararType = createColumn(
		"qarar_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> docTreeId = createColumn(
		"doc_tree_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, String> docURL = createColumn(
		"doc_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> createdBy = createColumn(
		"created_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Date> modifiedDate = createColumn(
		"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<QararRequestTable, Long> qararDocId = createColumn(
		"qarar_doc_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private QararRequestTable() {
		super("qarar_request_info", QararRequestTable::new);
	}

}