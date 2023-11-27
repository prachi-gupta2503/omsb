create index IX_CBA3515A on df_form_definition (formName[$COLUMN_LENGTH:200$]);
create index IX_B796B7AB on df_form_definition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_402F2CED on df_form_definition (uuid_[$COLUMN_LENGTH:75$], groupId);