create index IX_C3A72AE7 on df_form_definition (formDefinitionId, formVersion[$COLUMN_LENGTH:75$]);
create index IX_CBA3515A on df_form_definition (formName[$COLUMN_LENGTH:200$]);
create index IX_9DBC20F9 on df_form_definition (groupId, status);
create index IX_B796B7AB on df_form_definition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_402F2CED on df_form_definition (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8AB88E4E on df_form_record_entry (formDefinitionId, recordId);
create index IX_81FF3728 on df_form_record_entry (groupId, status);
create index IX_5BB6675C on df_form_record_entry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB2914DE on df_form_record_entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1DD34A67 on df_range_option_master (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DCA93EA9 on df_range_option_master (uuid_[$COLUMN_LENGTH:75$], groupId);