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

import gov.omsb.tms.model.DutyAssignment;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DutyAssignment. This utility wraps
 * <code>gov.omsb.tms.service.impl.DutyAssignmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentLocalService
 * @generated
 */
public class DutyAssignmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyAssignmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the duty assignment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was added
	 */
	public static DutyAssignment addDutyAssignment(
		DutyAssignment dutyAssignment) {

		return getService().addDutyAssignment(dutyAssignment);
	}

	/**
	 * Creates a new duty assignment with the primary key. Does not add the duty assignment to the database.
	 *
	 * @param dutyAssignmentId the primary key for the new duty assignment
	 * @return the new duty assignment
	 */
	public static DutyAssignment createDutyAssignment(long dutyAssignmentId) {
		return getService().createDutyAssignment(dutyAssignmentId);
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
	 * Deletes the duty assignment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was removed
	 */
	public static DutyAssignment deleteDutyAssignment(
		DutyAssignment dutyAssignment) {

		return getService().deleteDutyAssignment(dutyAssignment);
	}

	/**
	 * Deletes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws PortalException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment deleteDutyAssignment(long dutyAssignmentId)
		throws PortalException {

		return getService().deleteDutyAssignment(dutyAssignmentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
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

	public static DutyAssignment fetchDutyAssignment(long dutyAssignmentId) {
		return getService().fetchDutyAssignment(dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment matching the UUID and group.
	 *
	 * @param uuid the duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchDutyAssignmentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDutyAssignmentByUuidAndGroupId(uuid, groupId);
	}

	public static String fetchDutyTypeAssignmentStatus(
		long dutyTypeId, String assignment, long dutyAssignmentId) {

		return getService().fetchDutyTypeAssignmentStatus(
			dutyTypeId, assignment, dutyAssignmentId);
	}

	public static List<DutyAssignment> findAssignmentByDutyTypeId(
		long dutyTypeId) {

		return getService().findAssignmentByDutyTypeId(dutyTypeId);
	}

	public static List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		return getService().findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment);
	}

	public static String findDutyTypeStatus(long dutyTypeId) {
		return getService().findDutyTypeStatus(dutyTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static String getAssignmentListByDutyTypeId(long dutyTypeId) {
		return getService().getAssignmentListByDutyTypeId(dutyTypeId);
	}

	/**
	 * Returns the duty assignment with the primary key.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws PortalException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment getDutyAssignment(long dutyAssignmentId)
		throws PortalException {

		return getService().getDutyAssignment(dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment matching the UUID and group.
	 *
	 * @param uuid the duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty assignment
	 * @throws PortalException if a matching duty assignment could not be found
	 */
	public static DutyAssignment getDutyAssignmentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDutyAssignmentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of duty assignments
	 */
	public static List<DutyAssignment> getDutyAssignments(int start, int end) {
		return getService().getDutyAssignments(start, end);
	}

	/**
	 * Returns all the duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty assignments
	 * @param companyId the primary key of the company
	 * @return the matching duty assignments, or an empty list if no matches were found
	 */
	public static List<DutyAssignment> getDutyAssignmentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDutyAssignmentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty assignments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty assignments, or an empty list if no matches were found
	 */
	public static List<DutyAssignment> getDutyAssignmentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getService().getDutyAssignmentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty assignments.
	 *
	 * @return the number of duty assignments
	 */
	public static int getDutyAssignmentsCount() {
		return getService().getDutyAssignmentsCount();
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
	 * Updates the duty assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was updated
	 */
	public static DutyAssignment updateDutyAssignment(
		DutyAssignment dutyAssignment) {

		return getService().updateDutyAssignment(dutyAssignment);
	}

	public static DutyAssignmentLocalService getService() {
		return _service;
	}

	private static volatile DutyAssignmentLocalService _service;

}