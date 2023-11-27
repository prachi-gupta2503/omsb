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

package gov.omsb.form.builder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormDefinitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionLocalService
 * @generated
 */
public class FormDefinitionLocalServiceWrapper
	implements FormDefinitionLocalService,
			   ServiceWrapper<FormDefinitionLocalService> {

	public FormDefinitionLocalServiceWrapper() {
		this(null);
	}

	public FormDefinitionLocalServiceWrapper(
		FormDefinitionLocalService formDefinitionLocalService) {

		_formDefinitionLocalService = formDefinitionLocalService;
	}

	/**
	 * Adds the form definition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was added
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition addFormDefinition(
		gov.omsb.form.builder.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.addFormDefinition(formDefinition);
	}

	@Override
	public boolean alterFormTable(
		String formName, String columnName, String dataType) {

		return _formDefinitionLocalService.alterFormTable(
			formName, columnName, dataType);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition createFormDefinition(
		long formDefinitionId) {

		return _formDefinitionLocalService.createFormDefinition(
			formDefinitionId);
	}

	@Override
	public boolean createFormTable(String formName) {
		return _formDefinitionLocalService.createFormTable(formName);
	}

	@Override
	public boolean createMasterTable(String tableName, String columnName) {
		return _formDefinitionLocalService.createMasterTable(
			tableName, columnName);
	}

	@Override
	public boolean createMasterTableMapping(
		String tableName, String columnName) {

		return _formDefinitionLocalService.createMasterTableMapping(
			tableName, columnName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public String creatorEmailAddress(String recordId, long formRecordEntryId) {
		return _formDefinitionLocalService.creatorEmailAddress(
			recordId, formRecordEntryId);
	}

	/**
	 * Deletes the form definition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was removed
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition deleteFormDefinition(
		gov.omsb.form.builder.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.deleteFormDefinition(formDefinition);
	}

	/**
	 * Deletes the form definition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition that was removed
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition deleteFormDefinition(
			long formDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.deleteFormDefinition(
			formDefinitionId);
	}

	@Override
	public boolean deleteFormRecords(String tableName, String recordIds) {
		return _formDefinitionLocalService.deleteFormRecords(
			tableName, recordIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _formDefinitionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _formDefinitionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formDefinitionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _formDefinitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _formDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _formDefinitionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _formDefinitionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _formDefinitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public java.util.List<java.io.File> fetchAttachments(
		long emailTemplateMasterId, long groupId) {

		return _formDefinitionLocalService.fetchAttachments(
			emailTemplateMasterId, groupId);
	}

	@Override
	public gov.omsb.form.builder.model.FormDefinition fetchFormDefinition(
		long formDefinitionId) {

		return _formDefinitionLocalService.fetchFormDefinition(
			formDefinitionId);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition
		fetchFormDefinitionByUuidAndGroupId(String uuid, long groupId) {

		return _formDefinitionLocalService.fetchFormDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public gov.omsb.form.builder.model.FormDefinition
			findFormDefinitionByFormDefinitionIdAndFormVersion(
				long formDefinitionId, String formVersion)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return _formDefinitionLocalService.
			findFormDefinitionByFormDefinitionIdAndFormVersion(
				formDefinitionId, formVersion);
	}

	/**
	 * Finder tag for UserId
	 *
	 * @throws NoSuchFormDefinitionException
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
			findFormDefinitionByFormName(String formName)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return _formDefinitionLocalService.findFormDefinitionByFormName(
			formName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formDefinitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<String> getColumnNames(String tableName) {
		return _formDefinitionLocalService.getColumnNames(tableName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getColumnNamesWithDatatype(
		String tableName) {

		return _formDefinitionLocalService.getColumnNamesWithDatatype(
			tableName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDataSelectQuery(
		String tableName, String columnNames, String whereCondition) {

		return _formDefinitionLocalService.getDataSelectQuery(
			tableName, columnNames, whereCondition);
	}

	/**
	 * Returns the form definition with the primary key.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition getFormDefinition(
			long formDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getFormDefinition(formDefinitionId);
	}

	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getFormDefinitionByStatus(long groupId, int status) {

		return _formDefinitionLocalService.getFormDefinitionByStatus(
			groupId, status);
	}

	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getFormDefinitionByStatus(
			long groupId, int status, int start, int end) {

		return _formDefinitionLocalService.getFormDefinitionByStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition
	 * @throws PortalException if a matching form definition could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition
			getFormDefinitionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getFormDefinitionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the form definitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormDefinitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @return the range of form definitions
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getFormDefinitions(int start, int end) {

		return _formDefinitionLocalService.getFormDefinitions(start, end);
	}

	/**
	 * Returns all the form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @return the matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getFormDefinitionsByUuidAndCompanyId(String uuid, long companyId) {

		return _formDefinitionLocalService.getFormDefinitionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form definitions
	 * @param end the upper bound of the range of form definitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form definitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getFormDefinitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.form.builder.model.FormDefinition>
					orderByComparator) {

		return _formDefinitionLocalService.getFormDefinitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	@Override
	public int getFormDefinitionsCount() {
		return _formDefinitionLocalService.getFormDefinitionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formDefinitionLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public gov.omsb.form.builder.model.FormDefinition getInstance() {
		return _formDefinitionLocalService.getInstance();
	}

	@Override
	public Long getLastestMasterTableId(String tableName) {
		return _formDefinitionLocalService.getLastestMasterTableId(tableName);
	}

	@Override
	public java.util.List<gov.omsb.form.builder.model.FormDefinition>
		getLatestFormDefinition(long groupId, long companyId) {

		return _formDefinitionLocalService.getLatestFormDefinition(
			groupId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formDefinitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formDefinitionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public Long getSelectLatestMasterRecord(String tableName) {
		return _formDefinitionLocalService.getSelectLatestMasterRecord(
			tableName);
	}

	@Override
	public Long getSelectLatestRecord(String tableName) {
		return _formDefinitionLocalService.getSelectLatestRecord(tableName);
	}

	@Override
	public boolean insertIntoTable(
		String tableName, String columnNames, String columnValues) {

		return _formDefinitionLocalService.insertIntoTable(
			tableName, columnNames, columnValues);
	}

	@Override
	public boolean isColumnNameExists(String formName, String key) {
		return _formDefinitionLocalService.isColumnNameExists(formName, key);
	}

	@Override
	public boolean isTableExists(String tableName) {
		return _formDefinitionLocalService.isTableExists(tableName);
	}

	@Override
	public boolean isTableNameExists(String tableName) {
		return _formDefinitionLocalService.isTableNameExists(tableName);
	}

	@Override
	public boolean modifyTableName(String oldTableName, String newTableName) {
		return _formDefinitionLocalService.modifyTableName(
			oldTableName, newTableName);
	}

	@Override
	public void sendEmail(
		String fromAddress, String toAddress, String subject, String body,
		String[] ccAddress, String[] bccAddress) {

		_formDefinitionLocalService.sendEmail(
			fromAddress, toAddress, subject, body, ccAddress, bccAddress);
	}

	@Override
	public void sendEmailWithAttachment(
		String fromAddress, String toAddress, String subject, String body,
		java.util.List<java.io.File> attachments, String[] ccAddress,
		String[] bccAddress) {

		_formDefinitionLocalService.sendEmailWithAttachment(
			fromAddress, toAddress, subject, body, attachments, ccAddress,
			bccAddress);
	}

	@Override
	public String updatedEmailTemplateBody(
		String emailBody, String formDefinitionId, String recordId,
		long groupId) {

		return _formDefinitionLocalService.updatedEmailTemplateBody(
			emailBody, formDefinitionId, recordId, groupId);
	}

	/**
	 * Updates the form definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormDefinitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formDefinition the form definition
	 * @return the form definition that was updated
	 */
	@Override
	public gov.omsb.form.builder.model.FormDefinition updateFormDefinition(
		gov.omsb.form.builder.model.FormDefinition formDefinition) {

		return _formDefinitionLocalService.updateFormDefinition(formDefinition);
	}

	@Override
	public boolean updateMasterRecord(
		String tableName, String columnName, String columnValue,
		String latestRecord) {

		return _formDefinitionLocalService.updateMasterRecord(
			tableName, columnName, columnValue, latestRecord);
	}

	@Override
	public boolean updateMasterTableRecord(
		String tableName, String columnValues, String latestRecordCondition) {

		return _formDefinitionLocalService.updateMasterTableRecord(
			tableName, columnValues, latestRecordCondition);
	}

	@Override
	public boolean updateTableRecord(
		String tableName, String columnValues, String latestRecordCondition) {

		return _formDefinitionLocalService.updateTableRecord(
			tableName, columnValues, latestRecordCondition);
	}

	@Override
	public FormDefinitionLocalService getWrappedService() {
		return _formDefinitionLocalService;
	}

	@Override
	public void setWrappedService(
		FormDefinitionLocalService formDefinitionLocalService) {

		_formDefinitionLocalService = formDefinitionLocalService;
	}

	private FormDefinitionLocalService _formDefinitionLocalService;

}