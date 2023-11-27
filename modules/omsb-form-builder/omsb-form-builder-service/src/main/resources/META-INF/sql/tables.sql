create table df_form_definition (
	uuid_ VARCHAR(75) null,
	formDefinitionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	formName VARCHAR(200) null,
	formTitle VARCHAR(200) null,
	formDescription STRING null,
	formVersion VARCHAR(75) null,
	formConfig STRING null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table df_form_record_entry (
	uuid_ VARCHAR(75) null,
	formRecordEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createdBy LONG,
	modifiedBy LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	formDefinitionId LONG,
	recordId LONG,
	dfTableName VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table df_range_option_master (
	uuid_ VARCHAR(75) null,
	rangeOptionId LONG not null primary key,
	rangeOptionName VARCHAR(200) null,
	rangeOptions STRING null,
	companyId LONG,
	groupId LONG,
	createdBy LONG,
	modifiedBy LONG,
	createdDate DATE null,
	modifiedDate DATE null
);