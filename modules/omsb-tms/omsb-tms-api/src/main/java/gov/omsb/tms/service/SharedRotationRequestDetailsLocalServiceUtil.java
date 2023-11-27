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

import gov.omsb.tms.model.SharedRotationRequestDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SharedRotationRequestDetails. This utility wraps
 * <code>gov.omsb.tms.service.impl.SharedRotationRequestDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetailsLocalService
 * @generated
 */
public class SharedRotationRequestDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.SharedRotationRequestDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the shared rotation request details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationRequestDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 * @return the shared rotation request details that was added
	 */
	public static SharedRotationRequestDetails addSharedRotationRequestDetails(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		return getService().addSharedRotationRequestDetails(
			sharedRotationRequestDetails);
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
	 * Creates a new shared rotation request details with the primary key. Does not add the shared rotation request details to the database.
	 *
	 * @param sharedRotationRequestDetailsId the primary key for the new shared rotation request details
	 * @return the new shared rotation request details
	 */
	public static SharedRotationRequestDetails
		createSharedRotationRequestDetails(
			long sharedRotationRequestDetailsId) {

		return getService().createSharedRotationRequestDetails(
			sharedRotationRequestDetailsId);
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
	 * Deletes the shared rotation request details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationRequestDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details that was removed
	 * @throws PortalException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails
			deleteSharedRotationRequestDetails(
				long sharedRotationRequestDetailsId)
		throws PortalException {

		return getService().deleteSharedRotationRequestDetails(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Deletes the shared rotation request details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationRequestDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 * @return the shared rotation request details that was removed
	 */
	public static SharedRotationRequestDetails
		deleteSharedRotationRequestDetails(
			SharedRotationRequestDetails sharedRotationRequestDetails) {

		return getService().deleteSharedRotationRequestDetails(
			sharedRotationRequestDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationRequestDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationRequestDetailsModelImpl</code>.
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

	public static SharedRotationRequestDetails
		fetchSharedRotationRequestDetails(long sharedRotationRequestDetailsId) {

		return getService().fetchSharedRotationRequestDetails(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation request details matching the UUID and group.
	 *
	 * @param uuid the shared rotation request details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails
		fetchSharedRotationRequestDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchSharedRotationRequestDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy) {

		return getService().findByRequestRaisedBy(requestRaisedBy);
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
	 * Returns the shared rotation request details with the primary key.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws PortalException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails getSharedRotationRequestDetails(
			long sharedRotationRequestDetailsId)
		throws PortalException {

		return getService().getSharedRotationRequestDetails(
			sharedRotationRequestDetailsId);
	}

	public static List<SharedRotationRequestDetails>
		getSharedRotationRequestDetailsByApproverId(long approverId) {

		return getService().getSharedRotationRequestDetailsByApproverId(
			approverId);
	}

	/**
	 * Returns the shared rotation request details matching the UUID and group.
	 *
	 * @param uuid the shared rotation request details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation request details
	 * @throws PortalException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails
			getSharedRotationRequestDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getSharedRotationRequestDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails>
		getSharedRotationRequestDetailses(int start, int end) {

		return getService().getSharedRotationRequestDetailses(start, end);
	}

	/**
	 * Returns all the shared rotation request detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation request detailses
	 * @param companyId the primary key of the company
	 * @return the matching shared rotation request detailses, or an empty list if no matches were found
	 */
	public static List<SharedRotationRequestDetails>
		getSharedRotationRequestDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getSharedRotationRequestDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of shared rotation request detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation request detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching shared rotation request detailses, or an empty list if no matches were found
	 */
	public static List<SharedRotationRequestDetails>
		getSharedRotationRequestDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getService().getSharedRotationRequestDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of shared rotation request detailses.
	 *
	 * @return the number of shared rotation request detailses
	 */
	public static int getSharedRotationRequestDetailsesCount() {
		return getService().getSharedRotationRequestDetailsesCount();
	}

	/**
	 * Updates the shared rotation request details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationRequestDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 * @return the shared rotation request details that was updated
	 */
	public static SharedRotationRequestDetails
		updateSharedRotationRequestDetails(
			SharedRotationRequestDetails sharedRotationRequestDetails) {

		return getService().updateSharedRotationRequestDetails(
			sharedRotationRequestDetails);
	}

	public static SharedRotationRequestDetailsLocalService getService() {
		return _service;
	}

	private static volatile SharedRotationRequestDetailsLocalService _service;

}