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

import gov.omsb.form.builder.model.FormRecordEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FormRecordEntry. This utility wraps
 * <code>gov.omsb.form.builder.service.impl.FormRecordEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FormRecordEntryLocalService
 * @generated
 */
public class FormRecordEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.form.builder.service.impl.FormRecordEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static FormRecordEntry addFormRecordEntry(
		FormRecordEntry formRecordEntry) {

		return getService().addFormRecordEntry(formRecordEntry);
	}

	/**
	 * Creates a new form record entry with the primary key. Does not add the form record entry to the database.
	 *
	 * @param formRecordEntryId the primary key for the new form record entry
	 * @return the new form record entry
	 */
	public static FormRecordEntry createFormRecordEntry(
		long formRecordEntryId) {

		return getService().createFormRecordEntry(formRecordEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static FormRecordEntry deleteFormRecordEntry(
		FormRecordEntry formRecordEntry) {

		return getService().deleteFormRecordEntry(formRecordEntry);
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
	public static FormRecordEntry deleteFormRecordEntry(long formRecordEntryId)
		throws PortalException {

		return getService().deleteFormRecordEntry(formRecordEntryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl</code>.
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

	public static FormRecordEntry fetchFormRecordEntry(long formRecordEntryId) {
		return getService().fetchFormRecordEntry(formRecordEntryId);
	}

	/**
	 * Returns the form record entry matching the UUID and group.
	 *
	 * @param uuid the form record entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	public static FormRecordEntry fetchFormRecordEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFormRecordEntryByUuidAndGroupId(uuid, groupId);
	}

	public static FormRecordEntry
			findFormRecordEntryByFormDefinitionIdAndRecordId(
				long formDefinitionId, long recordId)
		throws gov.omsb.form.builder.exception.NoSuchFormRecordEntryException {

		return getService().findFormRecordEntryByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<FormRecordEntry> getFormDefinitionByStatus(
		long groupId, int status) {

		return getService().getFormDefinitionByStatus(groupId, status);
	}

	public static List<FormRecordEntry> getFormDefinitionByStatus(
		long groupId, int status, int start, int end) {

		return getService().getFormDefinitionByStatus(
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
	public static List<FormRecordEntry> getFormRecordEntries(
		int start, int end) {

		return getService().getFormRecordEntries(start, end);
	}

	/**
	 * Returns all the form record entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the form record entries
	 * @param companyId the primary key of the company
	 * @return the matching form record entries, or an empty list if no matches were found
	 */
	public static List<FormRecordEntry> getFormRecordEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFormRecordEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<FormRecordEntry> getFormRecordEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return getService().getFormRecordEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of form record entries.
	 *
	 * @return the number of form record entries
	 */
	public static int getFormRecordEntriesCount() {
		return getService().getFormRecordEntriesCount();
	}

	/**
	 * Returns the form record entry with the primary key.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry
	 * @throws PortalException if a form record entry with the primary key could not be found
	 */
	public static FormRecordEntry getFormRecordEntry(long formRecordEntryId)
		throws PortalException {

		return getService().getFormRecordEntry(formRecordEntryId);
	}

	/**
	 * Returns the form record entry matching the UUID and group.
	 *
	 * @param uuid the form record entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching form record entry
	 * @throws PortalException if a matching form record entry could not be found
	 */
	public static FormRecordEntry getFormRecordEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFormRecordEntryByUuidAndGroupId(uuid, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	public static FormRecordEntry updateFormRecordEntry(
		FormRecordEntry formRecordEntry) {

		return getService().updateFormRecordEntry(formRecordEntry);
	}

	public static FormRecordEntryLocalService getService() {
		return _service;
	}

	private static volatile FormRecordEntryLocalService _service;

}