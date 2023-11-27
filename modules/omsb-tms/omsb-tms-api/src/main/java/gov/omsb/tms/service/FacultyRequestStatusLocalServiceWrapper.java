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
 * Provides a wrapper for {@link FacultyRequestStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatusLocalService
 * @generated
 */
public class FacultyRequestStatusLocalServiceWrapper
	implements FacultyRequestStatusLocalService,
			   ServiceWrapper<FacultyRequestStatusLocalService> {

	public FacultyRequestStatusLocalServiceWrapper() {
		this(null);
	}

	public FacultyRequestStatusLocalServiceWrapper(
		FacultyRequestStatusLocalService facultyRequestStatusLocalService) {

		_facultyRequestStatusLocalService = facultyRequestStatusLocalService;
	}

	/**
	 * Adds the faculty request status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestStatus the faculty request status
	 * @return the faculty request status that was added
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus addFacultyRequestStatus(
		gov.omsb.tms.model.FacultyRequestStatus facultyRequestStatus) {

		return _facultyRequestStatusLocalService.addFacultyRequestStatus(
			facultyRequestStatus);
	}

	/**
	 * Creates a new faculty request status with the primary key. Does not add the faculty request status to the database.
	 *
	 * @param facultyRequestStatusId the primary key for the new faculty request status
	 * @return the new faculty request status
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus createFacultyRequestStatus(
		long facultyRequestStatusId) {

		return _facultyRequestStatusLocalService.createFacultyRequestStatus(
			facultyRequestStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the faculty request status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestStatus the faculty request status
	 * @return the faculty request status that was removed
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus deleteFacultyRequestStatus(
		gov.omsb.tms.model.FacultyRequestStatus facultyRequestStatus) {

		return _facultyRequestStatusLocalService.deleteFacultyRequestStatus(
			facultyRequestStatus);
	}

	/**
	 * Deletes the faculty request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status that was removed
	 * @throws PortalException if a faculty request status with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus deleteFacultyRequestStatus(
			long facultyRequestStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.deleteFacultyRequestStatus(
			facultyRequestStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyRequestStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyRequestStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyRequestStatusLocalService.dynamicQuery();
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

		return _facultyRequestStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStatusModelImpl</code>.
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

		return _facultyRequestStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStatusModelImpl</code>.
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

		return _facultyRequestStatusLocalService.dynamicQuery(
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

		return _facultyRequestStatusLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _facultyRequestStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestStatus fetchFacultyRequestStatus(
		long facultyRequestStatusId) {

		return _facultyRequestStatusLocalService.fetchFacultyRequestStatus(
			facultyRequestStatusId);
	}

	/**
	 * Returns the faculty request status matching the UUID and group.
	 *
	 * @param uuid the faculty request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus
		fetchFacultyRequestStatusByUuidAndGroupId(String uuid, long groupId) {

		return _facultyRequestStatusLocalService.
			fetchFacultyRequestStatusByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestStatus findByCode(String code) {
		return _facultyRequestStatusLocalService.findByCode(code);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyRequestStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyRequestStatusLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the faculty request status with the primary key.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status
	 * @throws PortalException if a faculty request status with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus getFacultyRequestStatus(
			long facultyRequestStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.getFacultyRequestStatus(
			facultyRequestStatusId);
	}

	/**
	 * Returns the faculty request status matching the UUID and group.
	 *
	 * @param uuid the faculty request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request status
	 * @throws PortalException if a matching faculty request status could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus
			getFacultyRequestStatusByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.
			getFacultyRequestStatusByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of faculty request statuses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestStatus>
		getFacultyRequestStatuses(int start, int end) {

		return _facultyRequestStatusLocalService.getFacultyRequestStatuses(
			start, end);
	}

	/**
	 * Returns all the faculty request statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request statuses
	 * @param companyId the primary key of the company
	 * @return the matching faculty request statuses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestStatus>
		getFacultyRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _facultyRequestStatusLocalService.
			getFacultyRequestStatusesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of faculty request statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request statuses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty request statuses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestStatus>
		getFacultyRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyRequestStatus> orderByComparator) {

		return _facultyRequestStatusLocalService.
			getFacultyRequestStatusesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty request statuses.
	 *
	 * @return the number of faculty request statuses
	 */
	@Override
	public int getFacultyRequestStatusesCount() {
		return _facultyRequestStatusLocalService.
			getFacultyRequestStatusesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyRequestStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStatusLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the faculty request status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRequestStatus the faculty request status
	 * @return the faculty request status that was updated
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestStatus updateFacultyRequestStatus(
		gov.omsb.tms.model.FacultyRequestStatus facultyRequestStatus) {

		return _facultyRequestStatusLocalService.updateFacultyRequestStatus(
			facultyRequestStatus);
	}

	@Override
	public FacultyRequestStatusLocalService getWrappedService() {
		return _facultyRequestStatusLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestStatusLocalService facultyRequestStatusLocalService) {

		_facultyRequestStatusLocalService = facultyRequestStatusLocalService;
	}

	private FacultyRequestStatusLocalService _facultyRequestStatusLocalService;

}