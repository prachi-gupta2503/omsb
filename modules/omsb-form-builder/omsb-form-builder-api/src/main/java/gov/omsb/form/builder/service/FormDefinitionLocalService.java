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
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.form.builder.exception.NoSuchFormDefinitionException;
import gov.omsb.form.builder.model.FormDefinition;

import java.io.File;
import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for FormDefinition. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FormDefinitionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.form.builder.service.impl.FormDefinitionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the form definition local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FormDefinitionLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public FormDefinition addFormDefinition(FormDefinition formDefinition);

	public boolean alterFormTable(
		String formName, String columnName, String dataType);

	/**
	 * Creates a new form definition with the primary key. Does not add the form definition to the database.
	 *
	 * @param formDefinitionId the primary key for the new form definition
	 * @return the new form definition
	 */
	@Transactional(enabled = false)
	public FormDefinition createFormDefinition(long formDefinitionId);

	public boolean createFormTable(String formName);

	public boolean createMasterTable(String tableName, String columnName);

	public boolean createMasterTableMapping(
		String tableName, String columnName);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public String creatorEmailAddress(String recordId, long formRecordEntryId);

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
	@Indexable(type = IndexableType.DELETE)
	public FormDefinition deleteFormDefinition(FormDefinition formDefinition);

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
	@Indexable(type = IndexableType.DELETE)
	public FormDefinition deleteFormDefinition(long formDefinitionId)
		throws PortalException;

	public boolean deleteFormRecords(String tableName, String recordIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<File> fetchAttachments(
		long emailTemplateMasterId, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FormDefinition fetchFormDefinition(long formDefinitionId);

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition, or <code>null</code> if a matching form definition could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FormDefinition fetchFormDefinitionByUuidAndGroupId(
		String uuid, long groupId);

	public FormDefinition findFormDefinitionByFormDefinitionIdAndFormVersion(
			long formDefinitionId, String formVersion)
		throws NoSuchFormDefinitionException;

	/**
	 * Finder tag for UserId
	 *
	 * @throws NoSuchFormDefinitionException
	 */
	public List<FormDefinition> findFormDefinitionByFormName(String formName)
		throws NoSuchFormDefinitionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getColumnNames(String tableName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getColumnNamesWithDatatype(String tableName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getDataSelectQuery(
		String tableName, String columnNames, String whereCondition);

	/**
	 * Returns the form definition with the primary key.
	 *
	 * @param formDefinitionId the primary key of the form definition
	 * @return the form definition
	 * @throws PortalException if a form definition with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FormDefinition getFormDefinition(long formDefinitionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getFormDefinitionByStatus(
		long groupId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getFormDefinitionByStatus(
		long groupId, int status, int start, int end);

	/**
	 * Returns the form definition matching the UUID and group.
	 *
	 * @param uuid the form definition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form definition
	 * @throws PortalException if a matching form definition could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FormDefinition getFormDefinitionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getFormDefinitions(int start, int end);

	/**
	 * Returns all the form definitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the form definitions
	 * @param companyId the primary key of the company
	 * @return the matching form definitions, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getFormDefinitionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormDefinition> orderByComparator);

	/**
	 * Returns the number of form definitions.
	 *
	 * @return the number of form definitions
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getFormDefinitionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FormDefinition getInstance();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Long getLastestMasterTableId(String tableName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<FormDefinition> getLatestFormDefinition(
		long groupId, long companyId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Long getSelectLatestMasterRecord(String tableName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Long getSelectLatestRecord(String tableName);

	public boolean insertIntoTable(
		String tableName, String columnNames, String columnValues);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isColumnNameExists(String formName, String key);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isTableExists(String tableName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isTableNameExists(String tableName);

	public boolean modifyTableName(String oldTableName, String newTableName);

	public void sendEmail(
		String fromAddress, String toAddress, String subject, String body,
		String[] ccAddress, String[] bccAddress);

	public void sendEmailWithAttachment(
		String fromAddress, String toAddress, String subject, String body,
		List<File> attachments, String[] ccAddress, String[] bccAddress);

	public String updatedEmailTemplateBody(
		String emailBody, String formDefinitionId, String recordId,
		long groupId);

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
	@Indexable(type = IndexableType.REINDEX)
	public FormDefinition updateFormDefinition(FormDefinition formDefinition);

	public boolean updateMasterRecord(
		String tableName, String columnName, String columnValue,
		String latestRecord);

	public boolean updateMasterTableRecord(
		String tableName, String columnValues, String latestRecordCondition);

	public boolean updateTableRecord(
		String tableName, String columnValues, String latestRecordCondition);

}