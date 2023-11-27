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

import gov.omsb.tms.model.LeaveMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.LeaveMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMasterLocalService
 * @generated
 */
public class LeaveMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.LeaveMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveMaster addLeaveMaster(LeaveMaster leaveMaster) {
		return getService().addLeaveMaster(leaveMaster);
	}

	public static LeaveMaster addLeaveMaster(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long traineeId, java.util.Date dateOfApplication, long leaveTypeId,
		java.util.Date fromDate, java.util.Date toDate, int numberOfDays,
		String contactName, String contactEmail, String contactNumber,
		long programId) {

		return getService().addLeaveMaster(
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
	public static LeaveMaster createLeaveMaster(long leaveMasterId) {
		return getService().createLeaveMaster(leaveMasterId);
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
	 * Deletes the leave master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMaster the leave master
	 * @return the leave master that was removed
	 */
	public static LeaveMaster deleteLeaveMaster(LeaveMaster leaveMaster) {
		return getService().deleteLeaveMaster(leaveMaster);
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
	public static LeaveMaster deleteLeaveMaster(long leaveMasterId)
		throws PortalException {

		return getService().deleteLeaveMaster(leaveMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveMasterModelImpl</code>.
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

	public static LeaveMaster fetchLeaveMaster(long leaveMasterId) {
		return getService().fetchLeaveMaster(leaveMasterId);
	}

	/**
	 * Returns the leave master matching the UUID and group.
	 *
	 * @param uuid the leave master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public static LeaveMaster fetchLeaveMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveMasterByUuidAndGroupId(uuid, groupId);
	}

	public static List<LeaveMaster> findLeaveDetailsByTraineeId(
		long traineeId) {

		return getService().findLeaveDetailsByTraineeId(traineeId);
	}

	public static List<LeaveMaster> findLeaveDetailsByTraineeIds(
		List<Long> traineeIds, java.util.Date startDate,
		java.util.Date endDate) {

		return getService().findLeaveDetailsByTraineeIds(
			traineeIds, startDate, endDate);
	}

	public static List<LeaveMaster> findLeaveDetailsByTraineeIdsWithStatus(
		List<Long> traineeIds, java.util.Date startDate, java.util.Date endDate,
		int status) {

		return getService().findLeaveDetailsByTraineeIdsWithStatus(
			traineeIds, startDate, endDate, status);
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

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave master with the primary key.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master
	 * @throws PortalException if a leave master with the primary key could not be found
	 */
	public static LeaveMaster getLeaveMaster(long leaveMasterId)
		throws PortalException {

		return getService().getLeaveMaster(leaveMasterId);
	}

	/**
	 * Returns the leave master matching the UUID and group.
	 *
	 * @param uuid the leave master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave master
	 * @throws PortalException if a matching leave master could not be found
	 */
	public static LeaveMaster getLeaveMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveMasterByUuidAndGroupId(uuid, groupId);
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
	public static List<LeaveMaster> getLeaveMasters(int start, int end) {
		return getService().getLeaveMasters(start, end);
	}

	/**
	 * Returns all the leave masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave masters
	 * @param companyId the primary key of the company
	 * @return the matching leave masters, or an empty list if no matches were found
	 */
	public static List<LeaveMaster> getLeaveMastersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLeaveMastersByUuidAndCompanyId(uuid, companyId);
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
	public static List<LeaveMaster> getLeaveMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveMaster> orderByComparator) {

		return getService().getLeaveMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave masters.
	 *
	 * @return the number of leave masters
	 */
	public static int getLeaveMastersCount() {
		return getService().getLeaveMastersCount();
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
	 * Updates the leave master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveMaster the leave master
	 * @return the leave master that was updated
	 */
	public static LeaveMaster updateLeaveMaster(LeaveMaster leaveMaster) {
		return getService().updateLeaveMaster(leaveMaster);
	}

	public static LeaveMaster updateStatus(
		long userId, long leaveMasterId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateStatus(
			userId, leaveMasterId, status, serviceContext);
	}

	public static LeaveMasterLocalService getService() {
		return _service;
	}

	private static volatile LeaveMasterLocalService _service;

}