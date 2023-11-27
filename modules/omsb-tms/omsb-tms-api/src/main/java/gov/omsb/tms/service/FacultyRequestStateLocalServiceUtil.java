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

package gov.omsb.tms.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.FacultyRequestState;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FacultyRequestState. This utility wraps
 * <code>gov.omsb.tms.service.impl.FacultyRequestStateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStateLocalService
 * @generated
 */
public class FacultyRequestStateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyRequestStateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faculty request state to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestState the faculty request state
	 * @return the faculty request state that was added
	 */
	public static FacultyRequestState addFacultyRequestState(
		FacultyRequestState facultyRequestState) {

		return getService().addFacultyRequestState(facultyRequestState);
	}

	public static FacultyRequestState addFacultyRequestState(
		String comment, long facultyRequestId, long facultyRequestStatusId,
		long userId, long roleId, boolean isPublic) {

		return getService().addFacultyRequestState(
			comment, facultyRequestId, facultyRequestStatusId, userId, roleId,
			isPublic);
	}

	/**
	 * Creates a new faculty request state with the primary key. Does not add the faculty request state to the database.
	 *
	 * @param facultyRequestStateId the primary key for the new faculty request state
	 * @return the new faculty request state
	 */
	public static FacultyRequestState createFacultyRequestState(
		long facultyRequestStateId) {

		return getService().createFacultyRequestState(facultyRequestStateId);
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
	 * Deletes the faculty request state from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestState the faculty request state
	 * @return the faculty request state that was removed
	 */
	public static FacultyRequestState deleteFacultyRequestState(
		FacultyRequestState facultyRequestState) {

		return getService().deleteFacultyRequestState(facultyRequestState);
	}

	/**
	 * Deletes the faculty request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state that was removed
	 * @throws PortalException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState deleteFacultyRequestState(
			long facultyRequestStateId)
		throws PortalException {

		return getService().deleteFacultyRequestState(facultyRequestStateId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStateModelImpl</code>.
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

	public static FacultyRequestState fetchFacultyRequestState(
		long facultyRequestStateId) {

		return getService().fetchFacultyRequestState(facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state matching the UUID and group.
	 *
	 * @param uuid the faculty request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchFacultyRequestStateByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFacultyRequestStateByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<FacultyRequestState> findByFacultyRequestId(
		long facultyRequestId) {

		return getService().findByFacultyRequestId(facultyRequestId);
	}

	public static FacultyRequestState findByRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		return getService().findByRequestIdAndCreatedBy(
			facultyRequestId, createdBy);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the faculty request state with the primary key.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws PortalException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState getFacultyRequestState(
			long facultyRequestStateId)
		throws PortalException {

		return getService().getFacultyRequestState(facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state matching the UUID and group.
	 *
	 * @param uuid the faculty request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request state
	 * @throws PortalException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState getFacultyRequestStateByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFacultyRequestStateByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of faculty request states
	 */
	public static List<FacultyRequestState> getFacultyRequestStates(
		int start, int end) {

		return getService().getFacultyRequestStates(start, end);
	}

	/**
	 * Returns all the faculty request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request states
	 * @param companyId the primary key of the company
	 * @return the matching faculty request states, or an empty list if no matches were found
	 */
	public static List<FacultyRequestState>
		getFacultyRequestStatesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFacultyRequestStatesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of faculty request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request states
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty request states, or an empty list if no matches were found
	 */
	public static List<FacultyRequestState>
		getFacultyRequestStatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FacultyRequestState> orderByComparator) {

		return getService().getFacultyRequestStatesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty request states.
	 *
	 * @return the number of faculty request states
	 */
	public static int getFacultyRequestStatesCount() {
		return getService().getFacultyRequestStatesCount();
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
	 * Updates the faculty request state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestState the faculty request state
	 * @return the faculty request state that was updated
	 */
	public static FacultyRequestState updateFacultyRequestState(
		FacultyRequestState facultyRequestState) {

		return getService().updateFacultyRequestState(facultyRequestState);
	}

	public static FacultyRequestStateLocalService getService() {
		return _service;
	}

	private static volatile FacultyRequestStateLocalService _service;

}