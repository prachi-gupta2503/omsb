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

import gov.omsb.tms.model.FacultyRequest;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FacultyRequest. This utility wraps
 * <code>gov.omsb.tms.service.impl.FacultyRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestLocalService
 * @generated
 */
public class FacultyRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.FacultyRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faculty request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was added
	 */
	public static FacultyRequest addFacultyRequest(
		FacultyRequest facultyRequest) {

		return getService().addFacultyRequest(facultyRequest);
	}

	public static FacultyRequest addFacultyRequest(
			long groupId, long userId, long programId, long cvId)
		throws PortalException {

		return getService().addFacultyRequest(groupId, userId, programId, cvId);
	}

	/**
	 * Creates a new faculty request with the primary key. Does not add the faculty request to the database.
	 *
	 * @param facultyRequestId the primary key for the new faculty request
	 * @return the new faculty request
	 */
	public static FacultyRequest createFacultyRequest(long facultyRequestId) {
		return getService().createFacultyRequest(facultyRequestId);
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
	 * Deletes the faculty request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was removed
	 */
	public static FacultyRequest deleteFacultyRequest(
		FacultyRequest facultyRequest) {

		return getService().deleteFacultyRequest(facultyRequest);
	}

	/**
	 * Deletes the faculty request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request that was removed
	 * @throws PortalException if a faculty request with the primary key could not be found
	 */
	public static FacultyRequest deleteFacultyRequest(long facultyRequestId)
		throws PortalException {

		return getService().deleteFacultyRequest(facultyRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
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

	public static FacultyRequest editFacultyRequest(
			long userId, long facultyRequestId, long potentialFacultyTypeId,
			long coveringLetterId)
		throws PortalException {

		return getService().editFacultyRequest(
			userId, facultyRequestId, potentialFacultyTypeId, coveringLetterId);
	}

	public static FacultyRequest fetchFacultyRequest(long facultyRequestId) {
		return getService().fetchFacultyRequest(facultyRequestId);
	}

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public static FacultyRequest fetchFacultyRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFacultyRequestByUuidAndGroupId(uuid, groupId);
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
	 * Returns the faculty request with the primary key.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request
	 * @throws PortalException if a faculty request with the primary key could not be found
	 */
	public static FacultyRequest getFacultyRequest(long facultyRequestId)
		throws PortalException {

		return getService().getFacultyRequest(facultyRequestId);
	}

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request
	 * @throws PortalException if a matching faculty request could not be found
	 */
	public static FacultyRequest getFacultyRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getFacultyRequestByUuidAndGroupId(uuid, groupId);
	}

	public static List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestData(String languageCode) {

		return getService().getFacultyRequestData(languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestDataBySearch(
			long programId, long facultyTypeId, long facultyRequestStatusId,
			String languageCode) {

		return getService().getFacultyRequestDataBySearch(
			programId, facultyTypeId, facultyRequestStatusId, languageCode);
	}

	public static List<FacultyRequest> getFacultyRequestList() {
		return getService().getFacultyRequestList();
	}

	/**
	 * Returns a range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of faculty requests
	 */
	public static List<FacultyRequest> getFacultyRequests(int start, int end) {
		return getService().getFacultyRequests(start, end);
	}

	/**
	 * Returns all the faculty requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty requests
	 * @param companyId the primary key of the company
	 * @return the matching faculty requests, or an empty list if no matches were found
	 */
	public static List<FacultyRequest> getFacultyRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getFacultyRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of faculty requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty requests, or an empty list if no matches were found
	 */
	public static List<FacultyRequest> getFacultyRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequest> orderByComparator) {

		return getService().getFacultyRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty requests.
	 *
	 * @return the number of faculty requests
	 */
	public static int getFacultyRequestsCount() {
		return getService().getFacultyRequestsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getMyFacultyRequests(long potentialFacultyId, String languageCode) {

		return getService().getMyFacultyRequests(
			potentialFacultyId, languageCode);
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

	public static com.liferay.portal.kernel.model.User getPotentialFacultyUser(
		long requestId) {

		return getService().getPotentialFacultyUser(requestId);
	}

	/**
	 * Updates the faculty request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequest the faculty request
	 * @return the faculty request that was updated
	 */
	public static FacultyRequest updateFacultyRequest(
		FacultyRequest facultyRequest) {

		return getService().updateFacultyRequest(facultyRequest);
	}

	public static FacultyRequest updateLastestFacultyState(
		FacultyRequest facultyRequest, long lastestFacultyRequestStateId) {

		return getService().updateLastestFacultyState(
			facultyRequest, lastestFacultyRequestStateId);
	}

	public static FacultyRequest updateRequest(FacultyRequest facultyRequest) {
		return getService().updateRequest(facultyRequest);
	}

	public static FacultyRequest updateStatus(
			long userId, long facultyRequestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, facultyRequestId, status, serviceContext);
	}

	public static FacultyRequestLocalService getService() {
		return _service;
	}

	private static volatile FacultyRequestLocalService _service;

}