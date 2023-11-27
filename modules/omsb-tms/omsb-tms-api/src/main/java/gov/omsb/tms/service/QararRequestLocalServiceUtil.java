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

import gov.omsb.tms.model.QararRequest;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for QararRequest. This utility wraps
 * <code>gov.omsb.tms.service.impl.QararRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QararRequestLocalService
 * @generated
 */
public class QararRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.QararRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the qarar request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QararRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qararRequest the qarar request
	 * @return the qarar request that was added
	 */
	public static QararRequest addQararRequest(QararRequest qararRequest) {
		return getService().addQararRequest(qararRequest);
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
	 * Creates a new qarar request with the primary key. Does not add the qarar request to the database.
	 *
	 * @param qararRequestId the primary key for the new qarar request
	 * @return the new qarar request
	 */
	public static QararRequest createQararRequest(long qararRequestId) {
		return getService().createQararRequest(qararRequestId);
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
	 * Deletes the qarar request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QararRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request that was removed
	 * @throws PortalException if a qarar request with the primary key could not be found
	 */
	public static QararRequest deleteQararRequest(long qararRequestId)
		throws PortalException {

		return getService().deleteQararRequest(qararRequestId);
	}

	/**
	 * Deletes the qarar request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QararRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qararRequest the qarar request
	 * @return the qarar request that was removed
	 */
	public static QararRequest deleteQararRequest(QararRequest qararRequest) {
		return getService().deleteQararRequest(qararRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.QararRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.QararRequestModelImpl</code>.
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

	public static QararRequest fetchQararRequest(long qararRequestId) {
		return getService().fetchQararRequest(qararRequestId);
	}

	/**
	 * Returns the qarar request matching the UUID and group.
	 *
	 * @param uuid the qarar request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	public static QararRequest fetchQararRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchQararRequestByUuidAndGroupId(uuid, groupId);
	}

	public static QararRequest findByDocTreeId(long docTreeId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return getService().findByDocTreeId(docTreeId);
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
	 * Returns the qarar request with the primary key.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request
	 * @throws PortalException if a qarar request with the primary key could not be found
	 */
	public static QararRequest getQararRequest(long qararRequestId)
		throws PortalException {

		return getService().getQararRequest(qararRequestId);
	}

	/**
	 * Returns the qarar request matching the UUID and group.
	 *
	 * @param uuid the qarar request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching qarar request
	 * @throws PortalException if a matching qarar request could not be found
	 */
	public static QararRequest getQararRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getQararRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the qarar requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.QararRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @return the range of qarar requests
	 */
	public static List<QararRequest> getQararRequests(int start, int end) {
		return getService().getQararRequests(start, end);
	}

	/**
	 * Returns all the qarar requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the qarar requests
	 * @param companyId the primary key of the company
	 * @return the matching qarar requests, or an empty list if no matches were found
	 */
	public static List<QararRequest> getQararRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getQararRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of qarar requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the qarar requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of qarar requests
	 * @param end the upper bound of the range of qarar requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching qarar requests, or an empty list if no matches were found
	 */
	public static List<QararRequest> getQararRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<QararRequest> orderByComparator) {

		return getService().getQararRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of qarar requests.
	 *
	 * @return the number of qarar requests
	 */
	public static int getQararRequestsCount() {
		return getService().getQararRequestsCount();
	}

	/**
	 * Updates the qarar request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QararRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param qararRequest the qarar request
	 * @return the qarar request that was updated
	 */
	public static QararRequest updateQararRequest(QararRequest qararRequest) {
		return getService().updateQararRequest(qararRequest);
	}

	public static QararRequestLocalService getService() {
		return _service;
	}

	private static volatile QararRequestLocalService _service;

}