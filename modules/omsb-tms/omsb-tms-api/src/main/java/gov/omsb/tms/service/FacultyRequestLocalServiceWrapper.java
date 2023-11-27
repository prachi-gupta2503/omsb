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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FacultyRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestLocalService
 * @generated
 */
public class FacultyRequestLocalServiceWrapper
	implements FacultyRequestLocalService,
			   ServiceWrapper<FacultyRequestLocalService> {

	public FacultyRequestLocalServiceWrapper() {
		this(null);
	}

	public FacultyRequestLocalServiceWrapper(
		FacultyRequestLocalService facultyRequestLocalService) {

		_facultyRequestLocalService = facultyRequestLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.FacultyRequest addFacultyRequest(
		gov.omsb.tms.model.FacultyRequest facultyRequest) {

		return _facultyRequestLocalService.addFacultyRequest(facultyRequest);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest addFacultyRequest(
			long groupId, long userId, long programId, long cvId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.addFacultyRequest(
			groupId, userId, programId, cvId);
	}

	/**
	 * Creates a new faculty request with the primary key. Does not add the faculty request to the database.
	 *
	 * @param facultyRequestId the primary key for the new faculty request
	 * @return the new faculty request
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequest createFacultyRequest(
		long facultyRequestId) {

		return _facultyRequestLocalService.createFacultyRequest(
			facultyRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyRequest deleteFacultyRequest(
		gov.omsb.tms.model.FacultyRequest facultyRequest) {

		return _facultyRequestLocalService.deleteFacultyRequest(facultyRequest);
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
	@Override
	public gov.omsb.tms.model.FacultyRequest deleteFacultyRequest(
			long facultyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.deleteFacultyRequest(
			facultyRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyRequestLocalService.dynamicQuery();
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

		return _facultyRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facultyRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facultyRequestLocalService.dynamicQuery(
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

		return _facultyRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facultyRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest editFacultyRequest(
			long userId, long facultyRequestId, long potentialFacultyTypeId,
			long coveringLetterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.editFacultyRequest(
			userId, facultyRequestId, potentialFacultyTypeId, coveringLetterId);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest fetchFacultyRequest(
		long facultyRequestId) {

		return _facultyRequestLocalService.fetchFacultyRequest(
			facultyRequestId);
	}

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequest
		fetchFacultyRequestByUuidAndGroupId(String uuid, long groupId) {

		return _facultyRequestLocalService.fetchFacultyRequestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the faculty request with the primary key.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request
	 * @throws PortalException if a faculty request with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequest getFacultyRequest(
			long facultyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.getFacultyRequest(facultyRequestId);
	}

	/**
	 * Returns the faculty request matching the UUID and group.
	 *
	 * @param uuid the faculty request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request
	 * @throws PortalException if a matching faculty request could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequest getFacultyRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.getFacultyRequestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestData(String languageCode) {

		return _facultyRequestLocalService.getFacultyRequestData(languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestDataBySearch(
			long programId, long facultyTypeId, long facultyRequestStatusId,
			String languageCode) {

		return _facultyRequestLocalService.getFacultyRequestDataBySearch(
			programId, facultyTypeId, facultyRequestStatusId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequest>
		getFacultyRequestList() {

		return _facultyRequestLocalService.getFacultyRequestList();
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequest> getFacultyRequests(
		int start, int end) {

		return _facultyRequestLocalService.getFacultyRequests(start, end);
	}

	/**
	 * Returns all the faculty requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty requests
	 * @param companyId the primary key of the company
	 * @return the matching faculty requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequest>
		getFacultyRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _facultyRequestLocalService.getFacultyRequestsByUuidAndCompanyId(
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequest>
		getFacultyRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyRequest> orderByComparator) {

		return _facultyRequestLocalService.getFacultyRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty requests.
	 *
	 * @return the number of faculty requests
	 */
	@Override
	public int getFacultyRequestsCount() {
		return _facultyRequestLocalService.getFacultyRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyRequestLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getMyFacultyRequests(long potentialFacultyId, String languageCode) {

		return _facultyRequestLocalService.getMyFacultyRequests(
			potentialFacultyId, languageCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.User getPotentialFacultyUser(
		long requestId) {

		return _facultyRequestLocalService.getPotentialFacultyUser(requestId);
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
	@Override
	public gov.omsb.tms.model.FacultyRequest updateFacultyRequest(
		gov.omsb.tms.model.FacultyRequest facultyRequest) {

		return _facultyRequestLocalService.updateFacultyRequest(facultyRequest);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest updateLastestFacultyState(
		gov.omsb.tms.model.FacultyRequest facultyRequest,
		long lastestFacultyRequestStateId) {

		return _facultyRequestLocalService.updateLastestFacultyState(
			facultyRequest, lastestFacultyRequestStateId);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest updateRequest(
		gov.omsb.tms.model.FacultyRequest facultyRequest) {

		return _facultyRequestLocalService.updateRequest(facultyRequest);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequest updateStatus(
			long userId, long facultyRequestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestLocalService.updateStatus(
			userId, facultyRequestId, status, serviceContext);
	}

	@Override
	public FacultyRequestLocalService getWrappedService() {
		return _facultyRequestLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestLocalService facultyRequestLocalService) {

		_facultyRequestLocalService = facultyRequestLocalService;
	}

	private FacultyRequestLocalService _facultyRequestLocalService;

}