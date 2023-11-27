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

import gov.omsb.tms.model.LeaveTypes;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveTypes. This utility wraps
 * <code>gov.omsb.tms.service.impl.LeaveTypesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypesLocalService
 * @generated
 */
public class LeaveTypesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.LeaveTypesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveTypes addLeaveTypes(LeaveTypes leaveTypes) {
		return getService().addLeaveTypes(leaveTypes);
	}

	/**
	 * Creates a new leave types with the primary key. Does not add the leave types to the database.
	 *
	 * @param leaveTypesId the primary key for the new leave types
	 * @return the new leave types
	 */
	public static LeaveTypes createLeaveTypes(long leaveTypesId) {
		return getService().createLeaveTypes(leaveTypesId);
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
	 * Deletes the leave types from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypes the leave types
	 * @return the leave types that was removed
	 */
	public static LeaveTypes deleteLeaveTypes(LeaveTypes leaveTypes) {
		return getService().deleteLeaveTypes(leaveTypes);
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
	public static LeaveTypes deleteLeaveTypes(long leaveTypesId)
		throws PortalException {

		return getService().deleteLeaveTypes(leaveTypesId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTypesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveTypesModelImpl</code>.
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

	public static LeaveTypes fetchLeaveTypes(long leaveTypesId) {
		return getService().fetchLeaveTypes(leaveTypesId);
	}

	/**
	 * Returns the leave types matching the UUID and group.
	 *
	 * @param uuid the leave types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchLeaveTypesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveTypesByUuidAndGroupId(uuid, groupId);
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
	 * Returns the leave types with the primary key.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types
	 * @throws PortalException if a leave types with the primary key could not be found
	 */
	public static LeaveTypes getLeaveTypes(long leaveTypesId)
		throws PortalException {

		return getService().getLeaveTypes(leaveTypesId);
	}

	/**
	 * Returns the leave types matching the UUID and group.
	 *
	 * @param uuid the leave types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave types
	 * @throws PortalException if a matching leave types could not be found
	 */
	public static LeaveTypes getLeaveTypesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveTypesByUuidAndGroupId(uuid, groupId);
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
	public static List<LeaveTypes> getLeaveTypeses(int start, int end) {
		return getService().getLeaveTypeses(start, end);
	}

	/**
	 * Returns all the leave typeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave typeses
	 * @param companyId the primary key of the company
	 * @return the matching leave typeses, or an empty list if no matches were found
	 */
	public static List<LeaveTypes> getLeaveTypesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLeaveTypesesByUuidAndCompanyId(uuid, companyId);
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
	public static List<LeaveTypes> getLeaveTypesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getService().getLeaveTypesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave typeses.
	 *
	 * @return the number of leave typeses
	 */
	public static int getLeaveTypesesCount() {
		return getService().getLeaveTypesesCount();
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
	 * Updates the leave types in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypes the leave types
	 * @return the leave types that was updated
	 */
	public static LeaveTypes updateLeaveTypes(LeaveTypes leaveTypes) {
		return getService().updateLeaveTypes(leaveTypes);
	}

	public static LeaveTypesLocalService getService() {
		return _service;
	}

	private static volatile LeaveTypesLocalService _service;

}