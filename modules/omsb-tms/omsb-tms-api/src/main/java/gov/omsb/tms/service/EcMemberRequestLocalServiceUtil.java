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

import gov.omsb.tms.model.EcMemberRequest;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EcMemberRequest. This utility wraps
 * <code>gov.omsb.tms.service.impl.EcMemberRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestLocalService
 * @generated
 */
public class EcMemberRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.EcMemberRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ec member request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was added
	 */
	public static EcMemberRequest addEcMemberRequest(
		EcMemberRequest ecMemberRequest) {

		return getService().addEcMemberRequest(ecMemberRequest);
	}

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	public static EcMemberRequest createEcMemberRequest(
		long ecMemberRequestId) {

		return getService().createEcMemberRequest(ecMemberRequestId);
	}

	public static EcMemberRequest createNewRequest(
			EcMemberRequest ecMemberRequest,
			com.liferay.portal.kernel.model.User user)
		throws PortalException {

		return getService().createNewRequest(ecMemberRequest, user);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAllRequests() throws PortalException {
		getService().deleteAllRequests();
	}

	/**
	 * Deletes the ec member request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was removed
	 */
	public static EcMemberRequest deleteEcMemberRequest(
		EcMemberRequest ecMemberRequest) {

		return getService().deleteEcMemberRequest(ecMemberRequest);
	}

	/**
	 * Deletes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws PortalException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest deleteEcMemberRequest(long ecMemberRequestId)
		throws PortalException {

		return getService().deleteEcMemberRequest(ecMemberRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
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

	public static EcMemberRequest fetchEcMemberRequest(long ecMemberRequestId) {
		return getService().fetchEcMemberRequest(ecMemberRequestId);
	}

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchEcMemberRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEcMemberRequestByUuidAndGroupId(uuid, groupId);
	}

	public static EcMemberRequest findByPotentialEcMemberId(
		long potentialEcMemberId) {

		return getService().findByPotentialEcMemberId(potentialEcMemberId);
	}

	public static List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		return getService().findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request with the primary key.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws PortalException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest getEcMemberRequest(long ecMemberRequestId)
		throws PortalException {

		return getService().getEcMemberRequest(ecMemberRequestId);
	}

	public static EcMemberRequest getEcMemberRequestById(long ecMemberRequestId)
		throws PortalException {

		return getService().getEcMemberRequestById(ecMemberRequestId);
	}

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request
	 * @throws PortalException if a matching ec member request could not be found
	 */
	public static EcMemberRequest getEcMemberRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEcMemberRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of ec member requests
	 */
	public static List<EcMemberRequest> getEcMemberRequests(
		int start, int end) {

		return getService().getEcMemberRequests(start, end);
	}

	/**
	 * Returns all the ec member requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member requests
	 * @param companyId the primary key of the company
	 * @return the matching ec member requests, or an empty list if no matches were found
	 */
	public static List<EcMemberRequest> getEcMemberRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEcMemberRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ec member requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member requests, or an empty list if no matches were found
	 */
	public static List<EcMemberRequest> getEcMemberRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getService().getEcMemberRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	public static int getEcMemberRequestsCount() {
		return getService().getEcMemberRequestsCount();
	}

	public static List<gov.omsb.tms.custom.dto.ECMembershipRequestListDTO>
		getECMembershipRequestData(
			long programId, long roleId, long statusId,
			long potentialEcMemberLrUserid, String languageCode) {

		return getService().getECMembershipRequestData(
			programId, roleId, statusId, potentialEcMemberLrUserid,
			languageCode);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static List<gov.omsb.tms.custom.dto.FacultySiteCompensationDTO>
		getFacultySiteCompensationReportDetailsOfEcMember(
			String languageCode, long programId) {

		return getService().getFacultySiteCompensationReportDetailsOfEcMember(
			languageCode, programId);
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

	public static com.liferay.portal.kernel.model.User getPotentialMemberUser(
		long requestId) {

		return getService().getPotentialMemberUser(requestId);
	}

	public static List<gov.omsb.tms.custom.dto.ResidentReportDTO>
		getResidentsInEachSitePerBlock(
			long programId, String annualYear, String languageCode) {

		return getService().getResidentsInEachSitePerBlock(
			programId, annualYear, languageCode);
	}

	/**
	 * Updates the ec member request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequest the ec member request
	 * @return the ec member request that was updated
	 */
	public static EcMemberRequest updateEcMemberRequest(
		EcMemberRequest ecMemberRequest) {

		return getService().updateEcMemberRequest(ecMemberRequest);
	}

	public static EcMemberRequest updateRequest(
		EcMemberRequest ecMemberRequest) {

		return getService().updateRequest(ecMemberRequest);
	}

	public static EcMemberRequest updateStatus(
			long userId, long ecMemberRequestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, ecMemberRequestId, status, serviceContext);
	}

	public static EcMemberRequest updateStatus(
			long userId, long roleId, long ecMemberRequestId, int status,
			String ecRequestStateCode, String comments,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, roleId, ecMemberRequestId, status, ecRequestStateCode,
			comments, serviceContext);
	}

	public static EcMemberRequestLocalService getService() {
		return _service;
	}

	private static volatile EcMemberRequestLocalService _service;

}