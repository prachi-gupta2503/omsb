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

import gov.omsb.tms.model.FacultyIncentive;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FacultyIncentive. This utility wraps
 * <code>gov.omsb.tms.service.impl.FacultyIncentiveLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyIncentiveLocalService
 * @generated
 */
public class FacultyIncentiveLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyIncentiveLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faculty incentive to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyIncentiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyIncentive the faculty incentive
	 * @return the faculty incentive that was added
	 */
	public static FacultyIncentive addFacultyIncentive(
		FacultyIncentive facultyIncentive) {

		return getService().addFacultyIncentive(facultyIncentive);
	}

	/**
	 * Creates a new faculty incentive with the primary key. Does not add the faculty incentive to the database.
	 *
	 * @param FacultyIncentiveId the primary key for the new faculty incentive
	 * @return the new faculty incentive
	 */
	public static FacultyIncentive createFacultyIncentive(
		long FacultyIncentiveId) {

		return getService().createFacultyIncentive(FacultyIncentiveId);
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
	 * Deletes the faculty incentive from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyIncentiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyIncentive the faculty incentive
	 * @return the faculty incentive that was removed
	 */
	public static FacultyIncentive deleteFacultyIncentive(
		FacultyIncentive facultyIncentive) {

		return getService().deleteFacultyIncentive(facultyIncentive);
	}

	/**
	 * Deletes the faculty incentive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyIncentiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive that was removed
	 * @throws PortalException if a faculty incentive with the primary key could not be found
	 */
	public static FacultyIncentive deleteFacultyIncentive(
			long FacultyIncentiveId)
		throws PortalException {

		return getService().deleteFacultyIncentive(FacultyIncentiveId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyIncentiveModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyIncentiveModelImpl</code>.
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

	public static FacultyIncentive fetchFacultyIncentive(
		long FacultyIncentiveId) {

		return getService().fetchFacultyIncentive(FacultyIncentiveId);
	}

	/**
	 * Returns the faculty incentive matching the UUID and group.
	 *
	 * @param uuid the faculty incentive's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public static FacultyIncentive fetchFacultyIncentiveByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFacultyIncentiveByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the faculty incentive with the primary key.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive
	 * @throws PortalException if a faculty incentive with the primary key could not be found
	 */
	public static FacultyIncentive getFacultyIncentive(long FacultyIncentiveId)
		throws PortalException {

		return getService().getFacultyIncentive(FacultyIncentiveId);
	}

	/**
	 * Returns the faculty incentive matching the UUID and group.
	 *
	 * @param uuid the faculty incentive's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty incentive
	 * @throws PortalException if a matching faculty incentive could not be found
	 */
	public static FacultyIncentive getFacultyIncentiveByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFacultyIncentiveByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of faculty incentives
	 */
	public static List<FacultyIncentive> getFacultyIncentives(
		int start, int end) {

		return getService().getFacultyIncentives(start, end);
	}

	/**
	 * Returns all the faculty incentives matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty incentives
	 * @param companyId the primary key of the company
	 * @return the matching faculty incentives, or an empty list if no matches were found
	 */
	public static List<FacultyIncentive> getFacultyIncentivesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFacultyIncentivesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of faculty incentives matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty incentives
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty incentives, or an empty list if no matches were found
	 */
	public static List<FacultyIncentive> getFacultyIncentivesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyIncentive> orderByComparator) {

		return getService().getFacultyIncentivesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty incentives.
	 *
	 * @return the number of faculty incentives
	 */
	public static int getFacultyIncentivesCount() {
		return getService().getFacultyIncentivesCount();
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
	 * Updates the faculty incentive in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyIncentiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyIncentive the faculty incentive
	 * @return the faculty incentive that was updated
	 */
	public static FacultyIncentive updateFacultyIncentive(
		FacultyIncentive facultyIncentive) {

		return getService().updateFacultyIncentive(facultyIncentive);
	}

	public static FacultyIncentiveLocalService getService() {
		return _service;
	}

	private static volatile FacultyIncentiveLocalService _service;

}