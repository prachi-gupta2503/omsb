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
 * Provides a wrapper for {@link FacultyRequestStateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStateLocalService
 * @generated
 */
public class FacultyRequestStateLocalServiceWrapper
	implements FacultyRequestStateLocalService,
			   ServiceWrapper<FacultyRequestStateLocalService> {

	public FacultyRequestStateLocalServiceWrapper() {
		this(null);
	}

	public FacultyRequestStateLocalServiceWrapper(
		FacultyRequestStateLocalService facultyRequestStateLocalService) {

		_facultyRequestStateLocalService = facultyRequestStateLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.FacultyRequestState addFacultyRequestState(
		gov.omsb.tms.model.FacultyRequestState facultyRequestState) {

		return _facultyRequestStateLocalService.addFacultyRequestState(
			facultyRequestState);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestState addFacultyRequestState(
		String comment, long facultyRequestId, long facultyRequestStatusId,
		long userId, long roleId, boolean isPublic) {

		return _facultyRequestStateLocalService.addFacultyRequestState(
			comment, facultyRequestId, facultyRequestStatusId, userId, roleId,
			isPublic);
	}

	/**
	 * Creates a new faculty request state with the primary key. Does not add the faculty request state to the database.
	 *
	 * @param facultyRequestStateId the primary key for the new faculty request state
	 * @return the new faculty request state
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestState createFacultyRequestState(
		long facultyRequestStateId) {

		return _facultyRequestStateLocalService.createFacultyRequestState(
			facultyRequestStateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestState deleteFacultyRequestState(
		gov.omsb.tms.model.FacultyRequestState facultyRequestState) {

		return _facultyRequestStateLocalService.deleteFacultyRequestState(
			facultyRequestState);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestState deleteFacultyRequestState(
			long facultyRequestStateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.deleteFacultyRequestState(
			facultyRequestStateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyRequestStateLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyRequestStateLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyRequestStateLocalService.dynamicQuery();
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

		return _facultyRequestStateLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _facultyRequestStateLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _facultyRequestStateLocalService.dynamicQuery(
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

		return _facultyRequestStateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facultyRequestStateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestState fetchFacultyRequestState(
		long facultyRequestStateId) {

		return _facultyRequestStateLocalService.fetchFacultyRequestState(
			facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state matching the UUID and group.
	 *
	 * @param uuid the faculty request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestState
		fetchFacultyRequestStateByUuidAndGroupId(String uuid, long groupId) {

		return _facultyRequestStateLocalService.
			fetchFacultyRequestStateByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestState>
		findByFacultyRequestId(long facultyRequestId) {

		return _facultyRequestStateLocalService.findByFacultyRequestId(
			facultyRequestId);
	}

	@Override
	public gov.omsb.tms.model.FacultyRequestState findByRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		return _facultyRequestStateLocalService.findByRequestIdAndCreatedBy(
			facultyRequestId, createdBy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyRequestStateLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyRequestStateLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the faculty request state with the primary key.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws PortalException if a faculty request state with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestState getFacultyRequestState(
			long facultyRequestStateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.getFacultyRequestState(
			facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state matching the UUID and group.
	 *
	 * @param uuid the faculty request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty request state
	 * @throws PortalException if a matching faculty request state could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRequestState
			getFacultyRequestStateByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.
			getFacultyRequestStateByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestState>
		getFacultyRequestStates(int start, int end) {

		return _facultyRequestStateLocalService.getFacultyRequestStates(
			start, end);
	}

	/**
	 * Returns all the faculty request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty request states
	 * @param companyId the primary key of the company
	 * @return the matching faculty request states, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestState>
		getFacultyRequestStatesByUuidAndCompanyId(String uuid, long companyId) {

		return _facultyRequestStateLocalService.
			getFacultyRequestStatesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRequestState>
		getFacultyRequestStatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyRequestState> orderByComparator) {

		return _facultyRequestStateLocalService.
			getFacultyRequestStatesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty request states.
	 *
	 * @return the number of faculty request states
	 */
	@Override
	public int getFacultyRequestStatesCount() {
		return _facultyRequestStateLocalService.getFacultyRequestStatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyRequestStateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestStateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRequestStateLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.FacultyRequestState updateFacultyRequestState(
		gov.omsb.tms.model.FacultyRequestState facultyRequestState) {

		return _facultyRequestStateLocalService.updateFacultyRequestState(
			facultyRequestState);
	}

	@Override
	public FacultyRequestStateLocalService getWrappedService() {
		return _facultyRequestStateLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestStateLocalService facultyRequestStateLocalService) {

		_facultyRequestStateLocalService = facultyRequestStateLocalService;
	}

	private FacultyRequestStateLocalService _facultyRequestStateLocalService;

}