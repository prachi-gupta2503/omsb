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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.form.builder.model.FormDefinition;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FormDefinition. This utility wraps
 * <code>gov.omsb.form.builder.service.impl.FormDefinitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionLocalService
 * @generated
 */
public class FormDefinitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.form.builder.service.impl.FormDefinitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FormDefinition addFormDefinition(
		FormDefinition formDefinition) {

		return getService().addFormDefinition(formDefinition);
	}

	public static boolean alterFormTable(
		String formName, String columnName, String dataType) {

		return getService().alterFormTable(formName, columnName, dataType);
	}

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	public static FormDefinition createFormDefinition(long formDefinitionId) {
		return getService().createFormDefinition(formDefinitionId);
	}

	public static boolean createFormTable(String formName) {
		return getService().createFormTable(formName);
	}

	public static boolean createMasterTable(
		String tableName, String columnName) {

		return getService().createMasterTable(tableName, columnName);
	}

	public static boolean createMasterTableMapping(
		String tableName, String columnName) {

		return getService().createMasterTableMapping(tableName, columnName);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static String creatorEmailAddress(
		String recordId, long formRecordEntryId) {

		return getService().creatorEmailAddress(recordId, formRecordEntryId);
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
	public static FormDefinition deleteFormDefinition(
		FormDefinition formDefinition) {

		return getService().deleteFormDefinition(formDefinition);
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
	public static FormDefinition deleteFormDefinition(long formDefinitionId)
		throws PortalException {

		return getService().deleteFormDefinition(formDefinitionId);
	}

	public static boolean deleteFormRecords(
		String tableName, String recordIds) {

		return getService().deleteFormRecords(tableName, recordIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static List<java.io.File> fetchAttachments(
		long emailTemplateMasterId, long groupId) {

		return getService().fetchAttachments(emailTemplateMasterId, groupId);
	}

	public static FormDefinition fetchFormDefinition(long formDefinitionId) {
		return getService().fetchFormDefinition(formDefinitionId);
	}

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	public static FormDefinition fetchFormDefinitionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFormDefinitionByUuidAndGroupId(uuid, groupId);
	}

	public static FormDefinition
			findFormDefinitionByFormDefinitionIdAndFormVersion(
				long formDefinitionId, String formVersion)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getService().findFormDefinitionByFormDefinitionIdAndFormVersion(
			formDefinitionId, formVersion);
	}

	/**
	 * Finder tag for UserId
	 *
	 * @throws NoSuchFormDefinitionException
	 */
	public static List<FormDefinition> findFormDefinitionByFormName(
			String formName)
		throws gov.omsb.form.builder.exception.NoSuchFormDefinitionException {

		return getService().findFormDefinitionByFormName(formName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<String> getColumnNames(String tableName) {
		return getService().getColumnNames(tableName);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getColumnNamesWithDatatype(String tableName) {

		return getService().getColumnNamesWithDatatype(tableName);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDataSelectQuery(
		String tableName, String columnNames, String whereCondition) {

		return getService().getDataSelectQuery(
			tableName, columnNames, whereCondition);
	}

	/**
	 * Returns the form definition with the primary key.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	public static FormDefinition getFormDefinition(long formDefinitionId)
		throws PortalException {

		return getService().getFormDefinition(formDefinitionId);
	}

	public static List<FormDefinition> getFormDefinitionByStatus(
		long groupId, int status) {

		return getService().getFormDefinitionByStatus(groupId, status);
	}

	public static List<FormDefinition> getFormDefinitionByStatus(
		long groupId, int status, int start, int end) {

		return getService().getFormDefinitionByStatus(
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
	public static FormDefinition getFormDefinitionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFormDefinitionByUuidAndGroupId(uuid, groupId);
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
	public static List<FormDefinition> getFormDefinitions(int start, int end) {
		return getService().getFormDefinitions(start, end);
	}

	/**
	 * Returns all the form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @return the matching form definitions, or an empty list if no matches were found
	 */
	public static List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFormDefinitionsByUuidAndCompanyId(
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
	public static List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator) {

		return getService().getFormDefinitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	public static int getFormDefinitionsCount() {
		return getService().getFormDefinitionsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static FormDefinition getInstance() {
		return getService().getInstance();
	}

	public static Long getLastestMasterTableId(String tableName) {
		return getService().getLastestMasterTableId(tableName);
	}

	public static List<FormDefinition> getLatestFormDefinition(
		long groupId, long companyId) {

		return getService().getLatestFormDefinition(groupId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static Long getSelectLatestMasterRecord(String tableName) {
		return getService().getSelectLatestMasterRecord(tableName);
	}

	public static Long getSelectLatestRecord(String tableName) {
		return getService().getSelectLatestRecord(tableName);
	}

	public static boolean insertIntoTable(
		String tableName, String columnNames, String columnValues) {

		return getService().insertIntoTable(
			tableName, columnNames, columnValues);
	}

	public static boolean isColumnNameExists(String formName, String key) {
		return getService().isColumnNameExists(formName, key);
	}

	public static boolean isTableExists(String tableName) {
		return getService().isTableExists(tableName);
	}

	public static boolean isTableNameExists(String tableName) {
		return getService().isTableNameExists(tableName);
	}

	public static boolean modifyTableName(
		String oldTableName, String newTableName) {

		return getService().modifyTableName(oldTableName, newTableName);
	}

	public static void sendEmail(
		String fromAddress, String toAddress, String subject, String body,
		String[] ccAddress, String[] bccAddress) {

		getService().sendEmail(
			fromAddress, toAddress, subject, body, ccAddress, bccAddress);
	}

	public static void sendEmailWithAttachment(
		String fromAddress, String toAddress, String subject, String body,
		List<java.io.File> attachments, String[] ccAddress,
		String[] bccAddress) {

		getService().sendEmailWithAttachment(
			fromAddress, toAddress, subject, body, attachments, ccAddress,
			bccAddress);
	}

	public static String updatedEmailTemplateBody(
		String emailBody, String formDefinitionId, String recordId,
		long groupId) {

		return getService().updatedEmailTemplateBody(
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
	public static FormDefinition updateFormDefinition(
		FormDefinition formDefinition) {

		return getService().updateFormDefinition(formDefinition);
	}

	public static boolean updateMasterRecord(
		String tableName, String columnName, String columnValue,
		String latestRecord) {

		return getService().updateMasterRecord(
			tableName, columnName, columnValue, latestRecord);
	}

	public static boolean updateMasterTableRecord(
		String tableName, String columnValues, String latestRecordCondition) {

		return getService().updateMasterTableRecord(
			tableName, columnValues, latestRecordCondition);
	}

	public static boolean updateTableRecord(
		String tableName, String columnValues, String latestRecordCondition) {

		return getService().updateTableRecord(
			tableName, columnValues, latestRecordCondition);
	}

	public static FormDefinitionLocalService getService() {
		return _service;
	}

	private static volatile FormDefinitionLocalService _service;

}