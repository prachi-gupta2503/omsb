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
	formDescription TEXT null,
	formVersion VARCHAR(75) null,
	formConfig STRING null
);