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
 * Provides a wrapper for {@link FacultyIncentiveLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyIncentiveLocalService
 * @generated
 */
public class FacultyIncentiveLocalServiceWrapper
	implements FacultyIncentiveLocalService,
			   ServiceWrapper<FacultyIncentiveLocalService> {

	public FacultyIncentiveLocalServiceWrapper() {
		this(null);
	}

	public FacultyIncentiveLocalServiceWrapper(
		FacultyIncentiveLocalService facultyIncentiveLocalService) {

		_facultyIncentiveLocalService = facultyIncentiveLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.FacultyIncentive addFacultyIncentive(
		gov.omsb.tms.model.FacultyIncentive facultyIncentive) {

		return _facultyIncentiveLocalService.addFacultyIncentive(
			facultyIncentive);
	}

	/**
	 * Creates a new faculty incentive with the primary key. Does not add the faculty incentive to the database.
	 *
	 * @param FacultyIncentiveId the primary key for the new faculty incentive
	 * @return the new faculty incentive
	 */
	@Override
	public gov.omsb.tms.model.FacultyIncentive createFacultyIncentive(
		long FacultyIncentiveId) {

		return _facultyIncentiveLocalService.createFacultyIncentive(
			FacultyIncentiveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyIncentive deleteFacultyIncentive(
		gov.omsb.tms.model.FacultyIncentive facultyIncentive) {

		return _facultyIncentiveLocalService.deleteFacultyIncentive(
			facultyIncentive);
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
	@Override
	public gov.omsb.tms.model.FacultyIncentive deleteFacultyIncentive(
			long FacultyIncentiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.deleteFacultyIncentive(
			FacultyIncentiveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyIncentiveLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyIncentiveLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyIncentiveLocalService.dynamicQuery();
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

		return _facultyIncentiveLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facultyIncentiveLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facultyIncentiveLocalService.dynamicQuery(
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

		return _facultyIncentiveLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facultyIncentiveLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyIncentive fetchFacultyIncentive(
		long FacultyIncentiveId) {

		return _facultyIncentiveLocalService.fetchFacultyIncentive(
			FacultyIncentiveId);
	}

	/**
	 * Returns the faculty incentive matching the UUID and group.
	 *
	 * @param uuid the faculty incentive's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyIncentive
		fetchFacultyIncentiveByUuidAndGroupId(String uuid, long groupId) {

		return _facultyIncentiveLocalService.
			fetchFacultyIncentiveByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyIncentiveLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyIncentiveLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the faculty incentive with the primary key.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive
	 * @throws PortalException if a faculty incentive with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyIncentive getFacultyIncentive(
			long FacultyIncentiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.getFacultyIncentive(
			FacultyIncentiveId);
	}

	/**
	 * Returns the faculty incentive matching the UUID and group.
	 *
	 * @param uuid the faculty incentive's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty incentive
	 * @throws PortalException if a matching faculty incentive could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyIncentive
			getFacultyIncentiveByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.
			getFacultyIncentiveByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyIncentive>
		getFacultyIncentives(int start, int end) {

		return _facultyIncentiveLocalService.getFacultyIncentives(start, end);
	}

	/**
	 * Returns all the faculty incentives matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty incentives
	 * @param companyId the primary key of the company
	 * @return the matching faculty incentives, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyIncentive>
		getFacultyIncentivesByUuidAndCompanyId(String uuid, long companyId) {

		return _facultyIncentiveLocalService.
			getFacultyIncentivesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyIncentive>
		getFacultyIncentivesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyIncentive> orderByComparator) {

		return _facultyIncentiveLocalService.
			getFacultyIncentivesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty incentives.
	 *
	 * @return the number of faculty incentives
	 */
	@Override
	public int getFacultyIncentivesCount() {
		return _facultyIncentiveLocalService.getFacultyIncentivesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyIncentiveLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyIncentiveLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyIncentiveLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyIncentive updateFacultyIncentive(
		gov.omsb.tms.model.FacultyIncentive facultyIncentive) {

		return _facultyIncentiveLocalService.updateFacultyIncentive(
			facultyIncentive);
	}

	@Override
	public FacultyIncentiveLocalService getWrappedService() {
		return _facultyIncentiveLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyIncentiveLocalService facultyIncentiveLocalService) {

		_facultyIncentiveLocalService = facultyIncentiveLocalService;
	}

	private FacultyIncentiveLocalService _facultyIncentiveLocalService;

}