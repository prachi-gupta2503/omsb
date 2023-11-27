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

import gov.omsb.tms.model.FacultyRequestRotations;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FacultyRequestRotations. This utility wraps
 * <code>gov.omsb.tms.service.impl.FacultyRequestRotationsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsLocalService
 * @generated
 */
public class FacultyRequestRotationsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyRequestRotationsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faculty request rotations to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 * @return the faculty request rotations that was added
	 */
	public static FacultyRequestRotations addFacultyRequestRotations(
		FacultyRequestRotations facultyRequestRotations) {

		return getService().addFacultyRequestRotations(facultyRequestRotations);
	}

	public static FacultyRequestRotations addFacultyRequestRotations(
		long groupId, long userId, long facultyRequestId, long trainingSiteId,
		boolean isActive) {

		return getService().addFacultyRequestRotations(
			groupId, userId, facultyRequestId, trainingSiteId, isActive);
	}

	/**
	 * Creates a new faculty request rotations with the primary key. Does not add the faculty request rotations to the database.
	 *
	 * @param facultyRequestRotationsId the primary key for the new faculty request rotations
	 * @return the new faculty request rotations
	 */
	public static FacultyRequestRotations createFacultyRequestRotations(
		long facultyRequestRotationsId) {

		return getService().createFacultyRequestRotations(
			facultyRequestRotationsId);
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
	 * Deletes the faculty request rotations from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 * @return the faculty request rotations that was removed
	 */
	public static FacultyRequestRotations deleteFacultyRequestRotations(
		FacultyRequestRotations facultyRequestRotations) {

		return getService().deleteFacultyRequestRotations(
			facultyRequestRotations);
	}

	/**
	 * Deletes the faculty request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations that was removed
	 * @throws PortalException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations deleteFacultyRequestRotations(
			long facultyRequestRotationsId)
		throws PortalException {

		return getService().deleteFacultyRequestRotations(
			facultyRequestRotationsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestRotationsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestRotationsModelImpl</code>.
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

	public static FacultyRequestRotations fetchFacultyRequestRotations(
		long facultyRequestRotationsId) {

		return getService().fetchFacultyRequestRotations(
			facultyRequestRotationsId);
	}

	/**
	 * Returns the faculty request rotations matching the UUID and group.
	 *
	 * @param uuid the faculty request rotations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations
		fetchFacultyRequestRotationsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchFacultyRequestRotationsByUuidAndGroupId(
			uuid, groupId);
	}

	public static FacultyRequestRotations findByFacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive) {

		return getService().findByFacultyRequestIdAndIsActive(
			facultyRequestId, isActive);
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
	 * Returns the faculty request rotations with the primary key.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws PortalException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations getFacultyRequestRotations(
			long facultyRequestRotationsId)
		throws PortalException {

		return getService().getFacultyRequestRotations(
			facultyRequestRotationsId);
	}

	/**
	 * Returns the faculty request rotations matching the UUID and group.
	 *
	 * @param uuid the faculty request rotations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request rotations
	 * @throws PortalException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations
			getFacultyRequestRotationsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getFacultyRequestRotationsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of faculty request rotationses
	 */
	public static List<FacultyRequestRotations> getFacultyRequestRotationses(
		int start, int end) {

		return getService().getFacultyRequestRotationses(start, end);
	}

	/**
	 * Returns all the faculty request rotationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request rotationses
	 * @param companyId the primary key of the company
	 * @return the matching faculty request rotationses, or an empty list if no matches were found
	 */
	public static List<FacultyRequestRotations>
		getFacultyRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getFacultyRequestRotationsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of faculty request rotationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request rotationses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty request rotationses, or an empty list if no matches were found
	 */
	public static List<FacultyRequestRotations>
		getFacultyRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getService().getFacultyRequestRotationsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty request rotationses.
	 *
	 * @return the number of faculty request rotationses
	 */
	public static int getFacultyRequestRotationsesCount() {
		return getService().getFacultyRequestRotationsesCount();
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
	 * Updates the faculty request rotations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 * @return the faculty request rotations that was updated
	 */
	public static FacultyRequestRotations updateFacultyRequestRotations(
		FacultyRequestRotations facultyRequestRotations) {

		return getService().updateFacultyRequestRotations(
			facultyRequestRotations);
	}

	public static FacultyRequestRotationsLocalService getService() {
		return _service;
	}

	private static volatile FacultyRequestRotationsLocalService _service;

}