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

import gov.omsb.tms.model.ViolationUpdateStatus;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ViolationUpdateStatus. This utility wraps
 * <code>gov.omsb.tms.service.impl.ViolationUpdateStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatusLocalService
 * @generated
 */
public class ViolationUpdateStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ViolationUpdateStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the violation update status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViolationUpdateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param violationUpdateStatus the violation update status
	 * @return the violation update status that was added
	 */
	public static ViolationUpdateStatus addViolationUpdateStatus(
		ViolationUpdateStatus violationUpdateStatus) {

		return getService().addViolationUpdateStatus(violationUpdateStatus);
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
	 * Creates a new violation update status with the primary key. Does not add the violation update status to the database.
	 *
	 * @param violationUpdateStatusId the primary key for the new violation update status
	 * @return the new violation update status
	 */
	public static ViolationUpdateStatus createViolationUpdateStatus(
		long violationUpdateStatusId) {

		return getService().createViolationUpdateStatus(
			violationUpdateStatusId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the violation update status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViolationUpdateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status that was removed
	 * @throws PortalException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus deleteViolationUpdateStatus(
			long violationUpdateStatusId)
		throws PortalException {

		return getService().deleteViolationUpdateStatus(
			violationUpdateStatusId);
	}

	/**
	 * Deletes the violation update status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViolationUpdateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param violationUpdateStatus the violation update status
	 * @return the violation update status that was removed
	 */
	public static ViolationUpdateStatus deleteViolationUpdateStatus(
		ViolationUpdateStatus violationUpdateStatus) {

		return getService().deleteViolationUpdateStatus(violationUpdateStatus);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ViolationUpdateStatusModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ViolationUpdateStatusModelImpl</code>.
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

	public static ViolationUpdateStatus fetchViolationUpdateStatus(
		long violationUpdateStatusId) {

		return getService().fetchViolationUpdateStatus(violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status matching the UUID and group.
	 *
	 * @param uuid the violation update status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus
		fetchViolationUpdateStatusByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchViolationUpdateStatusByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ViolationUpdateStatus getByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getService().getByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
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
	 * Returns the violation update status with the primary key.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status
	 * @throws PortalException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus getViolationUpdateStatus(
			long violationUpdateStatusId)
		throws PortalException {

		return getService().getViolationUpdateStatus(violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status matching the UUID and group.
	 *
	 * @param uuid the violation update status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching violation update status
	 * @throws PortalException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus
			getViolationUpdateStatusByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getViolationUpdateStatusByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of violation update statuses
	 */
	public static List<ViolationUpdateStatus> getViolationUpdateStatuses(
		int start, int end) {

		return getService().getViolationUpdateStatuses(start, end);
	}

	/**
	 * Returns all the violation update statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the violation update statuses
	 * @param companyId the primary key of the company
	 * @return the matching violation update statuses, or an empty list if no matches were found
	 */
	public static List<ViolationUpdateStatus>
		getViolationUpdateStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getViolationUpdateStatusesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of violation update statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the violation update statuses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching violation update statuses, or an empty list if no matches were found
	 */
	public static List<ViolationUpdateStatus>
		getViolationUpdateStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getService().getViolationUpdateStatusesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of violation update statuses.
	 *
	 * @return the number of violation update statuses
	 */
	public static int getViolationUpdateStatusesCount() {
		return getService().getViolationUpdateStatusesCount();
	}

	/**
	 * Updates the violation update status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViolationUpdateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param violationUpdateStatus the violation update status
	 * @return the violation update status that was updated
	 */
	public static ViolationUpdateStatus updateViolationUpdateStatus(
		ViolationUpdateStatus violationUpdateStatus) {

		return getService().updateViolationUpdateStatus(violationUpdateStatus);
	}

	public static ViolationUpdateStatusLocalService getService() {
		return _service;
	}

	private static volatile ViolationUpdateStatusLocalService _service;

}