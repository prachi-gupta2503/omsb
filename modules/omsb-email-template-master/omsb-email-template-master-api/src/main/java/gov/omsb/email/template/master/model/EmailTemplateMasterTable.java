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

package gov.omsb.email.template.master.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;omsb_email_template&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateMaster
 * @generated
 */
public class EmailTemplateMasterTable
	extends BaseTable<EmailTemplateMasterTable> {

	public static final EmailTemplateMasterTable INSTANCE =
		new EmailTemplateMasterTable();

	public final Column<EmailTemplateMasterTable, Long> templateId =
		createColumn(
			"templateId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmailTemplateMasterTable, String> templateName =
		createColumn(
			"templateName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, String> templateDescription =
		createColumn(
			"templateDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, String> senderType =
		createColumn(
			"senderType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, String> senderEmailId =
		createColumn(
			"senderEmailId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, String> defaultCC =
		createColumn(
			"defaultCC", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, String> defaultBCC =
		createColumn(
			"defaultBCC", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Clob> subject = createColumn(
		"subject", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Clob> dynamicBody =
		createColumn(
			"dynamicBody", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Clob> staticBody =
		createColumn("staticBody", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Clob> signature =
		createColumn("signature", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Clob> userNotification =
		createColumn(
			"userNotification", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Boolean> isRichText =
		createColumn(
			"isRichText", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Date> createdDate =
		createColumn(
			"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTemplateMasterTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmailTemplateMasterTable() {
		super("omsb_email_template", EmailTemplateMasterTable::new);
	}

}