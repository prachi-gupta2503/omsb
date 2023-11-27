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
 * Provides a wrapper for {@link LeaveTypesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypesLocalService
 * @generated
 */
public class LeaveTypesLocalServiceWrapper
	implements LeaveTypesLocalService, ServiceWrapper<LeaveTypesLocalService> {

	public LeaveTypesLocalServiceWrapper() {
		this(null);
	}

	public LeaveTypesLocalServiceWrapper(
		LeaveTypesLocalService leaveTypesLocalService) {

		_leaveTypesLocalService = leaveTypesLocalService;
	}

	/**
	 * Adds the leave types to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypes the leave types
	 * @return the leave types that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes addLeaveTypes(
		gov.omsb.tms.model.LeaveTypes leaveTypes) {

		return _leaveTypesLocalService.addLeaveTypes(leaveTypes);
	}

	/**
	 * Creates a new leave types with the primary key. Does not add the leave types to the database.
	 *
	 * @param leaveTypesId the primary key for the new leave types
	 * @return the new leave types
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes createLeaveTypes(long leaveTypesId) {
		return _leaveTypesLocalService.createLeaveTypes(leaveTypesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave types from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypes the leave types
	 * @return the leave types that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes deleteLeaveTypes(
		gov.omsb.tms.model.LeaveTypes leaveTypes) {

		return _leaveTypesLocalService.deleteLeaveTypes(leaveTypes);
	}

	/**
	 * Deletes the leave types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types that was removed
	 * @throws PortalException if a leave types with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes deleteLeaveTypes(long leaveTypesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.deleteLeaveTypes(leaveTypesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveTypesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveTypesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTypesLocalService.dynamicQuery();
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

		return _leaveTypesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTypesModelImpl</code>.
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

		return _leaveTypesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTypesModelImpl</code>.
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

		return _leaveTypesLocalService.dynamicQuery(
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

		return _leaveTypesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveTypesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveTypes fetchLeaveTypes(long leaveTypesId) {
		return _leaveTypesLocalService.fetchLeaveTypes(leaveTypesId);
	}

	/**
	 * Returns the leave types matching the UUID and group.
	 *
	 * @param uuid the leave types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes fetchLeaveTypesByUuidAndGroupId(
		String uuid, long groupId) {

		return _leaveTypesLocalService.fetchLeaveTypesByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveTypesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveTypesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveTypesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave types with the primary key.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types
	 * @throws PortalException if a leave types with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes getLeaveTypes(long leaveTypesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.getLeaveTypes(leaveTypesId);
	}

	/**
	 * Returns the leave types matching the UUID and group.
	 *
	 * @param uuid the leave types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave types
	 * @throws PortalException if a matching leave types could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes getLeaveTypesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.getLeaveTypesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of leave typeses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTypes> getLeaveTypeses(
		int start, int end) {

		return _leaveTypesLocalService.getLeaveTypeses(start, end);
	}

	/**
	 * Returns all the leave typeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave typeses
	 * @param companyId the primary key of the company
	 * @return the matching leave typeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTypes>
		getLeaveTypesesByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveTypesLocalService.getLeaveTypesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of leave typeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave typeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave typeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTypes>
		getLeaveTypesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveTypes> orderByComparator) {

		return _leaveTypesLocalService.getLeaveTypesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave typeses.
	 *
	 * @return the number of leave typeses
	 */
	@Override
	public int getLeaveTypesesCount() {
		return _leaveTypesLocalService.getLeaveTypesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTypesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave types in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypes the leave types
	 * @return the leave types that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveTypes updateLeaveTypes(
		gov.omsb.tms.model.LeaveTypes leaveTypes) {

		return _leaveTypesLocalService.updateLeaveTypes(leaveTypes);
	}

	@Override
	public LeaveTypesLocalService getWrappedService() {
		return _leaveTypesLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTypesLocalService leaveTypesLocalService) {

		_leaveTypesLocalService = leaveTypesLocalService;
	}

	private LeaveTypesLocalService _leaveTypesLocalService;

}