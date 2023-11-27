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
 * Provides a wrapper for {@link LeaveMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMasterLocalService
 * @generated
 */
public class LeaveMasterLocalServiceWrapper
	implements LeaveMasterLocalService,
			   ServiceWrapper<LeaveMasterLocalService> {

	public LeaveMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveMasterLocalServiceWrapper(
		LeaveMasterLocalService leaveMasterLocalService) {

		_leaveMasterLocalService = leaveMasterLocalService;
	}

	/**
	 * Adds the leave master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMaster the leave master
	 * @return the leave master that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster addLeaveMaster(
		gov.omsb.tms.model.LeaveMaster leaveMaster) {

		return _leaveMasterLocalService.addLeaveMaster(leaveMaster);
	}

	@Override
	public gov.omsb.tms.model.LeaveMaster addLeaveMaster(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long traineeId, java.util.Date dateOfApplication, long leaveTypeId,
		java.util.Date fromDate, java.util.Date toDate, int numberOfDays,
		String contactName, String contactEmail, String contactNumber,
		long programId) {

		return _leaveMasterLocalService.addLeaveMaster(
			serviceContext, traineeId, dateOfApplication, leaveTypeId, fromDate,
			toDate, numberOfDays, contactName, contactEmail, contactNumber,
			programId);
	}

	/**
	 * Creates a new leave master with the primary key. Does not add the leave master to the database.
	 *
	 * @param leaveMasterId the primary key for the new leave master
	 * @return the new leave master
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster createLeaveMaster(
		long leaveMasterId) {

		return _leaveMasterLocalService.createLeaveMaster(leaveMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMaster the leave master
	 * @return the leave master that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster deleteLeaveMaster(
		gov.omsb.tms.model.LeaveMaster leaveMaster) {

		return _leaveMasterLocalService.deleteLeaveMaster(leaveMaster);
	}

	/**
	 * Deletes the leave master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master that was removed
	 * @throws PortalException if a leave master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster deleteLeaveMaster(long leaveMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.deleteLeaveMaster(leaveMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveMasterLocalService.dynamicQuery();
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

		return _leaveMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveMasterModelImpl</code>.
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

		return _leaveMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveMasterModelImpl</code>.
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

		return _leaveMasterLocalService.dynamicQuery(
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

		return _leaveMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveMaster fetchLeaveMaster(long leaveMasterId) {
		return _leaveMasterLocalService.fetchLeaveMaster(leaveMasterId);
	}

	/**
	 * Returns the leave master matching the UUID and group.
	 *
	 * @param uuid the leave master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster fetchLeaveMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return _leaveMasterLocalService.fetchLeaveMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster>
		findLeaveDetailsByTraineeId(long traineeId) {

		return _leaveMasterLocalService.findLeaveDetailsByTraineeId(traineeId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster>
		findLeaveDetailsByTraineeIds(
			java.util.List<Long> traineeIds, java.util.Date startDate,
			java.util.Date endDate) {

		return _leaveMasterLocalService.findLeaveDetailsByTraineeIds(
			traineeIds, startDate, endDate);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster>
		findLeaveDetailsByTraineeIdsWithStatus(
			java.util.List<Long> traineeIds, java.util.Date startDate,
			java.util.Date endDate, int status) {

		return _leaveMasterLocalService.findLeaveDetailsByTraineeIdsWithStatus(
			traineeIds, startDate, endDate, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave master with the primary key.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master
	 * @throws PortalException if a leave master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster getLeaveMaster(long leaveMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.getLeaveMaster(leaveMasterId);
	}

	/**
	 * Returns the leave master matching the UUID and group.
	 *
	 * @param uuid the leave master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave master
	 * @throws PortalException if a matching leave master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster getLeaveMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.getLeaveMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of leave masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster> getLeaveMasters(
		int start, int end) {

		return _leaveMasterLocalService.getLeaveMasters(start, end);
	}

	/**
	 * Returns all the leave masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave masters
	 * @param companyId the primary key of the company
	 * @return the matching leave masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster>
		getLeaveMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveMasterLocalService.getLeaveMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of leave masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveMaster>
		getLeaveMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveMaster> orderByComparator) {

		return _leaveMasterLocalService.getLeaveMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave masters.
	 *
	 * @return the number of leave masters
	 */
	@Override
	public int getLeaveMastersCount() {
		return _leaveMasterLocalService.getLeaveMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMaster the leave master
	 * @return the leave master that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveMaster updateLeaveMaster(
		gov.omsb.tms.model.LeaveMaster leaveMaster) {

		return _leaveMasterLocalService.updateLeaveMaster(leaveMaster);
	}

	@Override
	public gov.omsb.tms.model.LeaveMaster updateStatus(
		long userId, long leaveMasterId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _leaveMasterLocalService.updateStatus(
			userId, leaveMasterId, status, serviceContext);
	}

	@Override
	public LeaveMasterLocalService getWrappedService() {
		return _leaveMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveMasterLocalService leaveMasterLocalService) {

		_leaveMasterLocalService = leaveMasterLocalService;
	}

	private LeaveMasterLocalService _leaveMasterLocalService;

}