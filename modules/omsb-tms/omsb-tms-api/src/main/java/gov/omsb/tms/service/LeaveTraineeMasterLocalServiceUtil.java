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

import gov.omsb.tms.model.LeaveTraineeMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveTraineeMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.LeaveTraineeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTraineeMasterLocalService
 * @generated
 */
public class LeaveTraineeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.LeaveTraineeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveTraineeMaster addLeaveTraineeMaster(
		LeaveTraineeMaster leaveTraineeMaster) {

		return getService().addLeaveTraineeMaster(leaveTraineeMaster);
	}

	/**
	 * Creates a new leave trainee master with the primary key. Does not add the leave trainee master to the database.
	 *
	 * @param leaveTraineeMasterId the primary key for the new leave trainee master
	 * @return the new leave trainee master
	 */
	public static LeaveTraineeMaster createLeaveTraineeMaster(
		long leaveTraineeMasterId) {

		return getService().createLeaveTraineeMaster(leaveTraineeMasterId);
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
	 * Deletes the leave trainee master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 * @return the leave trainee master that was removed
	 */
	public static LeaveTraineeMaster deleteLeaveTraineeMaster(
		LeaveTraineeMaster leaveTraineeMaster) {

		return getService().deleteLeaveTraineeMaster(leaveTraineeMaster);
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
	public static LeaveTraineeMaster deleteLeaveTraineeMaster(
			long leaveTraineeMasterId)
		throws PortalException {

		return getService().deleteLeaveTraineeMaster(leaveTraineeMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTraineeMasterModelImpl</code>.
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

	public static LeaveTraineeMaster fetchLeaveTraineeMaster(
		long leaveTraineeMasterId) {

		return getService().fetchLeaveTraineeMaster(leaveTraineeMasterId);
	}

	/**
	 * Returns the leave trainee master matching the UUID and group.
	 *
	 * @param uuid the leave trainee master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public static LeaveTraineeMaster fetchLeaveTraineeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveTraineeMasterByUuidAndGroupId(
			uuid, groupId);
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
	 * Returns the leave trainee master with the primary key.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master
	 * @throws PortalException if a leave trainee master with the primary key could not be found
	 */
	public static LeaveTraineeMaster getLeaveTraineeMaster(
			long leaveTraineeMasterId)
		throws PortalException {

		return getService().getLeaveTraineeMaster(leaveTraineeMasterId);
	}

	/**
	 * Returns the leave trainee master matching the UUID and group.
	 *
	 * @param uuid the leave trainee master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave trainee master
	 * @throws PortalException if a matching leave trainee master could not be found
	 */
	public static LeaveTraineeMaster getLeaveTraineeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveTraineeMasterByUuidAndGroupId(
			uuid, groupId);
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
	public static List<LeaveTraineeMaster> getLeaveTraineeMasters(
		int start, int end) {

		return getService().getLeaveTraineeMasters(start, end);
	}

	/**
	 * Returns all the leave trainee masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave trainee masters
	 * @param companyId the primary key of the company
	 * @return the matching leave trainee masters, or an empty list if no matches were found
	 */
	public static List<LeaveTraineeMaster>
		getLeaveTraineeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getLeaveTraineeMastersByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<LeaveTraineeMaster>
		getLeaveTraineeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<LeaveTraineeMaster> orderByComparator) {

		return getService().getLeaveTraineeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave trainee masters.
	 *
	 * @return the number of leave trainee masters
	 */
	public static int getLeaveTraineeMastersCount() {
		return getService().getLeaveTraineeMastersCount();
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
	 * Updates the leave trainee master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTraineeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 * @return the leave trainee master that was updated
	 */
	public static LeaveTraineeMaster updateLeaveTraineeMaster(
		LeaveTraineeMaster leaveTraineeMaster) {

		return getService().updateLeaveTraineeMaster(leaveTraineeMaster);
	}

	public static LeaveTraineeMasterLocalService getService() {
		return _service;
	}

	private static volatile LeaveTraineeMasterLocalService _service;

}