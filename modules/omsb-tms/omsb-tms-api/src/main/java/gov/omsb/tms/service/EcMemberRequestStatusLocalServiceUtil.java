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

import gov.omsb.tms.model.EcMemberRequestStatus;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EcMemberRequestStatus. This utility wraps
 * <code>gov.omsb.tms.service.impl.EcMemberRequestStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatusLocalService
 * @generated
 */
public class EcMemberRequestStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.EcMemberRequestStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ec member request status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 * @return the ec member request status that was added
	 */
	public static EcMemberRequestStatus addEcMemberRequestStatus(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return getService().addEcMemberRequestStatus(ecMemberRequestStatus);
	}

	/**
	 * Creates a new ec member request status with the primary key. Does not add the ec member request status to the database.
	 *
	 * @param ecMemberRequestStatusId the primary key for the new ec member request status
	 * @return the new ec member request status
	 */
	public static EcMemberRequestStatus createEcMemberRequestStatus(
		long ecMemberRequestStatusId) {

		return getService().createEcMemberRequestStatus(
			ecMemberRequestStatusId);
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
	 * Deletes the ec member request status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 * @return the ec member request status that was removed
	 */
	public static EcMemberRequestStatus deleteEcMemberRequestStatus(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return getService().deleteEcMemberRequestStatus(ecMemberRequestStatus);
	}

	/**
	 * Deletes the ec member request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status that was removed
	 * @throws PortalException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus deleteEcMemberRequestStatus(
			long ecMemberRequestStatusId)
		throws PortalException {

		return getService().deleteEcMemberRequestStatus(
			ecMemberRequestStatusId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStatusModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStatusModelImpl</code>.
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

	public static EcMemberRequestStatus fetchEcMemberRequestStatus(
		long ecMemberRequestStatusId) {

		return getService().fetchEcMemberRequestStatus(ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status matching the UUID and group.
	 *
	 * @param uuid the ec member request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus
		fetchEcMemberRequestStatusByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEcMemberRequestStatusByUuidAndGroupId(
			uuid, groupId);
	}

	public static EcMemberRequestStatus findByCode(String code) {
		return getService().findByCode(code);
	}

	public static EcMemberRequestStatus findByName(String name) {
		return getService().findByName(name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request status with the primary key.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws PortalException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus getEcMemberRequestStatus(
			long ecMemberRequestStatusId)
		throws PortalException {

		return getService().getEcMemberRequestStatus(ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status matching the UUID and group.
	 *
	 * @param uuid the ec member request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request status
	 * @throws PortalException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus
			getEcMemberRequestStatusByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getEcMemberRequestStatusByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of ec member request statuses
	 */
	public static List<EcMemberRequestStatus> getEcMemberRequestStatuses(
		int start, int end) {

		return getService().getEcMemberRequestStatuses(start, end);
	}

	/**
	 * Returns all the ec member request statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request statuses
	 * @param companyId the primary key of the company
	 * @return the matching ec member request statuses, or an empty list if no matches were found
	 */
	public static List<EcMemberRequestStatus>
		getEcMemberRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getEcMemberRequestStatusesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ec member request statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request statuses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member request statuses, or an empty list if no matches were found
	 */
	public static List<EcMemberRequestStatus>
		getEcMemberRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getService().getEcMemberRequestStatusesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member request statuses.
	 *
	 * @return the number of ec member request statuses
	 */
	public static int getEcMemberRequestStatusesCount() {
		return getService().getEcMemberRequestStatusesCount();
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
	 * Updates the ec member request status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 * @return the ec member request status that was updated
	 */
	public static EcMemberRequestStatus updateEcMemberRequestStatus(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return getService().updateEcMemberRequestStatus(ecMemberRequestStatus);
	}

	public static EcMemberRequestStatusLocalService getService() {
		return _service;
	}

	private static volatile EcMemberRequestStatusLocalService _service;

}