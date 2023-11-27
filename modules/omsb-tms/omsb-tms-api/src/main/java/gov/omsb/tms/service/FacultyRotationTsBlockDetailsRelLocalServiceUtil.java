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

import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FacultyRotationTsBlockDetailsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.FacultyRotationTsBlockDetailsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRelLocalService
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyRotationTsBlockDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faculty rotation ts block details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was added
	 */
	public static FacultyRotationTsBlockDetailsRel
		addFacultyRotationTsBlockDetailsRel(
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return getService().addFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRel);
	}

	/**
	 * Creates a new faculty rotation ts block details rel with the primary key. Does not add the faculty rotation ts block details rel to the database.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key for the new faculty rotation ts block details rel
	 * @return the new faculty rotation ts block details rel
	 */
	public static FacultyRotationTsBlockDetailsRel
		createFacultyRotationTsBlockDetailsRel(
			long facultyRotationTsBlockDetailsRelId) {

		return getService().createFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRelId);
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
	 * Deletes the faculty rotation ts block details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 */
	public static FacultyRotationTsBlockDetailsRel
		deleteFacultyRotationTsBlockDetailsRel(
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return getService().deleteFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRel);
	}

	public static void deleteFacultyRotationTsBlockDetailsRel(
		List<FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels) {

		getService().deleteFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRels);
	}

	/**
	 * Deletes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws PortalException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			deleteFacultyRotationTsBlockDetailsRel(
				long facultyRotationTsBlockDetailsRelId)
		throws PortalException {

		return getService().deleteFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRelId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
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

	public static FacultyRotationTsBlockDetailsRel
		fetchFacultyRotationTsBlockDetailsRel(
			long facultyRotationTsBlockDetailsRelId) {

		return getService().fetchFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the faculty rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
		fetchFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		return getService().
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);
	}

	public static List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId) {

		return getService().findByFacultyId(facultyId);
	}

	public static List<FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(long facultyId, String status) {

		return getService().findByFacultyIdAndStatus(facultyId, status);
	}

	public static List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return getService().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
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
	 * Returns the faculty rotation ts block details rel with the primary key.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws PortalException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			getFacultyRotationTsBlockDetailsRel(
				long facultyRotationTsBlockDetailsRelId)
		throws PortalException {

		return getService().getFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the faculty rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty rotation ts block details rel
	 * @throws PortalException if a matching faculty rotation ts block details rel could not be found
	 */
	public static FacultyRotationTsBlockDetailsRel
			getFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of faculty rotation ts block details rels
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRels(int start, int end) {

		return getService().getFacultyRotationTsBlockDetailsRels(start, end);
	}

	/**
	 * Returns all the faculty rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @return the matching faculty rotation ts block details rels, or an empty list if no matches were found
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of faculty rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty rotation ts block details rels, or an empty list if no matches were found
	 */
	public static List<FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return getService().
			getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels.
	 *
	 * @return the number of faculty rotation ts block details rels
	 */
	public static int getFacultyRotationTsBlockDetailsRelsCount() {
		return getService().getFacultyRotationTsBlockDetailsRelsCount();
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
	 * Updates the faculty rotation ts block details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was updated
	 */
	public static FacultyRotationTsBlockDetailsRel
		updateFacultyRotationTsBlockDetailsRel(
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		return getService().updateFacultyRotationTsBlockDetailsRel(
			facultyRotationTsBlockDetailsRel);
	}

	public static FacultyRotationTsBlockDetailsRelLocalService getService() {
		return _service;
	}

	private static volatile FacultyRotationTsBlockDetailsRelLocalService
		_service;

}