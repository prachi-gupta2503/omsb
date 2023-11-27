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
 * Provides a wrapper for {@link FormRecordEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntryLocalService
 * @generated
 */
public class FormRecordEntryLocalServiceWrapper
	implements FormRecordEntryLocalService,
			   ServiceWrapper<FormRecordEntryLocalService> {

	public FormRecordEntryLocalServiceWrapper() {
		this(null);
	}

	public FormRecordEntryLocalServiceWrapper(
		FormRecordEntryLocalService formRecordEntryLocalService) {

		_formRecordEntryLocalService = formRecordEntryLocalService;
	}

	/**
	 * Adds the form record entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormRecordEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formRecordEntry the form record entry
	 * @return the form record entry that was added
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry addFormRecordEntry(
		gov.omsb.form.builder.model.FormRecordEntry formRecordEntry) {

		return _formRecordEntryLocalService.addFormRecordEntry(formRecordEntry);
	}

	/**
	 * Creates a new form record entry with the primary key. Does not add the form record entry to the database.
	 *
	 * @param formRecordEntryId the primary key for the new form record entry
	 * @return the new form record entry
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry createFormRecordEntry(
		long formRecordEntryId) {

		return _formRecordEntryLocalService.createFormRecordEntry(
			formRecordEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the form record entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormRecordEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formRecordEntry the form record entry
	 * @return the form record entry that was removed
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry deleteFormRecordEntry(
		gov.omsb.form.builder.model.FormRecordEntry formRecordEntry) {

		return _formRecordEntryLocalService.deleteFormRecordEntry(
			formRecordEntry);
	}

	/**
	 * Deletes the form record entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormRecordEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry that was removed
	 * @throws PortalException if a form record entry with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry deleteFormRecordEntry(
			long formRecordEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.deleteFormRecordEntry(
			formRecordEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _formRecordEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _formRecordEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formRecordEntryLocalService.dynamicQuery();
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

		return _formRecordEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code>.
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

		return _formRecordEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code>.
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

		return _formRecordEntryLocalService.dynamicQuery(
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

		return _formRecordEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _formRecordEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.form.builder.model.FormRecordEntry fetchFormRecordEntry(
		long formRecordEntryId) {

		return _formRecordEntryLocalService.fetchFormRecordEntry(
			formRecordEntryId);
	}

	/**
	 * Returns the form record entry matching the UUID and group.
	 *
	 * @param uuid the form record entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry
		fetchFormRecordEntryByUuidAndGroupId(String uuid, long groupId) {

		return _formRecordEntryLocalService.
			fetchFormRecordEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.form.builder.model.FormRecordEntry
			findFormRecordEntryByFormDefinitionIdAndRecordId(
				long formDefinitionId, long recordId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return _formRecordEntryLocalService.
			findFormRecordEntryByFormDefinitionIdAndRecordId(
				formDefinitionId, recordId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formRecordEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.form.builder.model.FormRecordEntry>
		getFormDefinitionByStatus(long groupId, int status) {

		return _formRecordEntryLocalService.getFormDefinitionByStatus(
			groupId, status);
	}

	@Override
	public java.util.List<gov.omsb.form.builder.model.FormRecordEntry>
		getFormDefinitionByStatus(
			long groupId, int status, int start, int end) {

		return _formRecordEntryLocalService.getFormDefinitionByStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns a range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of form record entries
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormRecordEntry>
		getFormRecordEntries(int start, int end) {

		return _formRecordEntryLocalService.getFormRecordEntries(start, end);
	}

	/**
	 * Returns all the form record entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the form record entries
	 * @param companyId the primary key of the company
	 * @return the matching form record entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormRecordEntry>
		getFormRecordEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _formRecordEntryLocalService.
			getFormRecordEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of form record entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the form record entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching form record entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.FormRecordEntry>
		getFormRecordEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.form.builder.model.FormRecordEntry>
					orderByComparator) {

		return _formRecordEntryLocalService.
			getFormRecordEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form record entries.
	 *
	 * @return the number of form record entries
	 */
	@Override
	public int getFormRecordEntriesCount() {
		return _formRecordEntryLocalService.getFormRecordEntriesCount();
	}

	/**
	 * Returns the form record entry with the primary key.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry
	 * @throws PortalException if a form record entry with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry getFormRecordEntry(
			long formRecordEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.getFormRecordEntry(
			formRecordEntryId);
	}

	/**
	 * Returns the form record entry matching the UUID and group.
	 *
	 * @param uuid the form record entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form record entry
	 * @throws PortalException if a matching form record entry could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry
			getFormRecordEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.getFormRecordEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formRecordEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formRecordEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formRecordEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the form record entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FormRecordEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param formRecordEntry the form record entry
	 * @return the form record entry that was updated
	 */
	@Override
	public gov.omsb.form.builder.model.FormRecordEntry updateFormRecordEntry(
		gov.omsb.form.builder.model.FormRecordEntry formRecordEntry) {

		return _formRecordEntryLocalService.updateFormRecordEntry(
			formRecordEntry);
	}

	@Override
	public FormRecordEntryLocalService getWrappedService() {
		return _formRecordEntryLocalService;
	}

	@Override
	public void setWrappedService(
		FormRecordEntryLocalService formRecordEntryLocalService) {

		_formRecordEntryLocalService = formRecordEntryLocalService;
	}

	private FormRecordEntryLocalService _formRecordEntryLocalService;

}