create table role_dashboard_config (
	configId LONG not null primary key,
	roleId LONG,
	dashboardId VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG
);