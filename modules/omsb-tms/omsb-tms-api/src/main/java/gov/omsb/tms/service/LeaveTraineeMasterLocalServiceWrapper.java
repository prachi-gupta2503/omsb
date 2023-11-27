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
 * Provides a wrapper for {@link LeaveTraineeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTraineeMasterLocalService
 * @generated
 */
public class LeaveTraineeMasterLocalServiceWrapper
	implements LeaveTraineeMasterLocalService,
			   ServiceWrapper<LeaveTraineeMasterLocalService> {

	public LeaveTraineeMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveTraineeMasterLocalServiceWrapper(
		LeaveTraineeMasterLocalService leaveTraineeMasterLocalService) {

		_leaveTraineeMasterLocalService = leaveTraineeMasterLocalService;
	}

	/**
	 * Adds the leave trainee master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 * @return the leave trainee master that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster addLeaveTraineeMaster(
		gov.omsb.tms.model.LeaveTraineeMaster leaveTraineeMaster) {

		return _leaveTraineeMasterLocalService.addLeaveTraineeMaster(
			leaveTraineeMaster);
	}

	/**
	 * Creates a new leave trainee master with the primary key. Does not add the leave trainee master to the database.
	 *
	 * @param leaveTraineeMasterId the primary key for the new leave trainee master
	 * @return the new leave trainee master
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster createLeaveTraineeMaster(
		long leaveTraineeMasterId) {

		return _leaveTraineeMasterLocalService.createLeaveTraineeMaster(
			leaveTraineeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave trainee master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 * @return the leave trainee master that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster deleteLeaveTraineeMaster(
		gov.omsb.tms.model.LeaveTraineeMaster leaveTraineeMaster) {

		return _leaveTraineeMasterLocalService.deleteLeaveTraineeMaster(
			leaveTraineeMaster);
	}

	/**
	 * Deletes the leave trainee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master that was removed
	 * @throws PortalException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster deleteLeaveTraineeMaster(
			long leaveTraineeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.deleteLeaveTraineeMaster(
			leaveTraineeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveTraineeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveTraineeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTraineeMasterLocalService.dynamicQuery();
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

		return _leaveTraineeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl</code>.
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

		return _leaveTraineeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl</code>.
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

		return _leaveTraineeMasterLocalService.dynamicQuery(
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

		return _leaveTraineeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveTraineeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster fetchLeaveTraineeMaster(
		long leaveTraineeMasterId) {

		return _leaveTraineeMasterLocalService.fetchLeaveTraineeMaster(
			leaveTraineeMasterId);
	}

	/**
	 * Returns the leave trainee master matching the UUID and group.
	 *
	 * @param uuid the leave trainee master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster
		fetchLeaveTraineeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _leaveTraineeMasterLocalService.
			fetchLeaveTraineeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveTraineeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveTraineeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveTraineeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave trainee master with the primary key.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master
	 * @throws PortalException if a leave trainee master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster getLeaveTraineeMaster(
			long leaveTraineeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.getLeaveTraineeMaster(
			leaveTraineeMasterId);
	}

	/**
	 * Returns the leave trainee master matching the UUID and group.
	 *
	 * @param uuid the leave trainee master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave trainee master
	 * @throws PortalException if a matching leave trainee master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster
			getLeaveTraineeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.
			getLeaveTraineeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of leave trainee masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTraineeMaster>
		getLeaveTraineeMasters(int start, int end) {

		return _leaveTraineeMasterLocalService.getLeaveTraineeMasters(
			start, end);
	}

	/**
	 * Returns all the leave trainee masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave trainee masters
	 * @param companyId the primary key of the company
	 * @return the matching leave trainee masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTraineeMaster>
		getLeaveTraineeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveTraineeMasterLocalService.
			getLeaveTraineeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave trainee masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave trainee masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave trainee masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveTraineeMaster>
		getLeaveTraineeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveTraineeMaster> orderByComparator) {

		return _leaveTraineeMasterLocalService.
			getLeaveTraineeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave trainee masters.
	 *
	 * @return the number of leave trainee masters
	 */
	@Override
	public int getLeaveTraineeMastersCount() {
		return _leaveTraineeMasterLocalService.getLeaveTraineeMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTraineeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTraineeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave trainee master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 * @return the leave trainee master that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveTraineeMaster updateLeaveTraineeMaster(
		gov.omsb.tms.model.LeaveTraineeMaster leaveTraineeMaster) {

		return _leaveTraineeMasterLocalService.updateLeaveTraineeMaster(
			leaveTraineeMaster);
	}

	@Override
	public LeaveTraineeMasterLocalService getWrappedService() {
		return _leaveTraineeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTraineeMasterLocalService leaveTraineeMasterLocalService) {

		_leaveTraineeMasterLocalService = leaveTraineeMasterLocalService;
	}

	private LeaveTraineeMasterLocalService _leaveTraineeMasterLocalService;

}