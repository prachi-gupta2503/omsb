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
 * Provides a wrapper for {@link FacultyRequestRotationsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsLocalService
 * @generated
 */
public class FacultyRequestRotationsLocalServiceWrapper
	implements FacultyRequestRotationsLocalService,
			   ServiceWrapper<FacultyRequestRotationsLocalService> {

	public FacultyRequestRotationsLocalServiceWrapper() {
		this(null);
	}

	public FacultyRequestRotationsLocalServiceWrapper(
		FacultyRequestRotationsLocalService
			facultyRequestRotationsLocalService) {

		_facultyRequestRotationsLocalService =
			facultyRequestRotationsLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		addFacultyRequestRotations(
			gov.omsb.tms.model.FacultyRequestRotations
				facultyRequestRotations) {

		return _facultyRequestRotationsLocalService.addFacultyRequestRotations(
			facultyRequestRotations);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		addFacultyRequestRotations(
			long groupId, long userId, long facultyRequestId,
			long trainingSiteId, boolean isActive) {

		return _facultyRequestRotationsLocalService.addFacultyRequestRotations(
			groupId, userId, facultyRequestId, trainingSiteId, isActive);
	}

	/**
	 * Creates a new faculty request rotations with the primary key. Does not add the faculty request rotations to the database.
	 *
	 * @param facultyRequestRotationsId the primary key for the new faculty request rotations
	 * @return the new faculty request rotations
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		createFacultyRequestRotations(long facultyRequestRotationsId) {

		return _facultyRequestRotationsLocalService.
			createFacultyRequestRotations(facultyRequestRotationsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		deleteFacultyRequestRotations(
			gov.omsb.tms.model.FacultyRequestRotations
				facultyRequestRotations) {

		return _facultyRequestRotationsLocalService.
			deleteFacultyRequestRotations(facultyRequestRotations);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
			deleteFacultyRequestRotations(long facultyRequestRotationsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.
			deleteFacultyRequestRotations(facultyRequestRotationsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyRequestRotationsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyRequestRotationsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyRequestRotationsLocalService.dynamicQuery();
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

		return _facultyRequestRotationsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facultyRequestRotationsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facultyRequestRotationsLocalService.dynamicQuery(
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

		return _facultyRequestRotationsLocalService.dynamicQueryCount(
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

		return _facultyRequestRotationsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		fetchFacultyRequestRotations(long facultyRequestRotationsId) {

		return _facultyRequestRotationsLocalService.
			fetchFacultyRequestRotations(facultyRequestRotationsId);
	}

	/**
	 * Returns the faculty request rotations matching the UUID and group.
	 *
	 * @param uuid the faculty request rotations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		fetchFacultyRequestRotationsByUuidAndGroupId(
			String uuid, long groupId) {

		return _facultyRequestRotationsLocalService.
			fetchFacultyRequestRotationsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		findByFacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive) {

		return _facultyRequestRotationsLocalService.
			findByFacultyRequestIdAndIsActive(facultyRequestId, isActive);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyRequestRotationsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyRequestRotationsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the faculty request rotations with the primary key.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws PortalException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
			getFacultyRequestRotations(long facultyRequestRotationsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.getFacultyRequestRotations(
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
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
			getFacultyRequestRotationsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.
			getFacultyRequestRotationsByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestRotations>
		getFacultyRequestRotationses(int start, int end) {

		return _facultyRequestRotationsLocalService.
			getFacultyRequestRotationses(start, end);
	}

	/**
	 * Returns all the faculty request rotationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request rotationses
	 * @param companyId the primary key of the company
	 * @return the matching faculty request rotationses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestRotations>
		getFacultyRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _facultyRequestRotationsLocalService.
			getFacultyRequestRotationsesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestRotations>
		getFacultyRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyRequestRotations>
					orderByComparator) {

		return _facultyRequestRotationsLocalService.
			getFacultyRequestRotationsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty request rotationses.
	 *
	 * @return the number of faculty request rotationses
	 */
	@Override
	public int getFacultyRequestRotationsesCount() {
		return _facultyRequestRotationsLocalService.
			getFacultyRequestRotationsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyRequestRotationsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestRotationsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestRotationsLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestRotations
		updateFacultyRequestRotations(
			gov.omsb.tms.model.FacultyRequestRotations
				facultyRequestRotations) {

		return _facultyRequestRotationsLocalService.
			updateFacultyRequestRotations(facultyRequestRotations);
	}

	@Override
	public FacultyRequestRotationsLocalService getWrappedService() {
		return _facultyRequestRotationsLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestRotationsLocalService
			facultyRequestRotationsLocalService) {

		_facultyRequestRotationsLocalService =
			facultyRequestRotationsLocalService;
	}

	private FacultyRequestRotationsLocalService
		_facultyRequestRotationsLocalService;

}