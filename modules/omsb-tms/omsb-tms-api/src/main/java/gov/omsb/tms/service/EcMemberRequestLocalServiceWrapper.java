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
 * Provides a wrapper for {@link EcMemberRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestLocalService
 * @generated
 */
public class EcMemberRequestLocalServiceWrapper
	implements EcMemberRequestLocalService,
			   ServiceWrapper<EcMemberRequestLocalService> {

	public EcMemberRequestLocalServiceWrapper() {
		this(null);
	}

	public EcMemberRequestLocalServiceWrapper(
		EcMemberRequestLocalService ecMemberRequestLocalService) {

		_ecMemberRequestLocalService = ecMemberRequestLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.EcMemberRequest addEcMemberRequest(
		gov.omsb.tms.model.EcMemberRequest ecMemberRequest) {

		return _ecMemberRequestLocalService.addEcMemberRequest(ecMemberRequest);
	}

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequest createEcMemberRequest(
		long ecMemberRequestId) {

		return _ecMemberRequestLocalService.createEcMemberRequest(
			ecMemberRequestId);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest createNewRequest(
			gov.omsb.tms.model.EcMemberRequest ecMemberRequest,
			com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.createNewRequest(
			ecMemberRequest, user);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAllRequests()
		throws com.liferay.portal.kernel.exception.PortalException {

		_ecMemberRequestLocalService.deleteAllRequests();
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
	@Override
	public gov.omsb.tms.model.EcMemberRequest deleteEcMemberRequest(
		gov.omsb.tms.model.EcMemberRequest ecMemberRequest) {

		return _ecMemberRequestLocalService.deleteEcMemberRequest(
			ecMemberRequest);
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
	@Override
	public gov.omsb.tms.model.EcMemberRequest deleteEcMemberRequest(
			long ecMemberRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.deleteEcMemberRequest(
			ecMemberRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ecMemberRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ecMemberRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ecMemberRequestLocalService.dynamicQuery();
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

		return _ecMemberRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ecMemberRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ecMemberRequestLocalService.dynamicQuery(
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

		return _ecMemberRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ecMemberRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest fetchEcMemberRequest(
		long ecMemberRequestId) {

		return _ecMemberRequestLocalService.fetchEcMemberRequest(
			ecMemberRequestId);
	}

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequest
		fetchEcMemberRequestByUuidAndGroupId(String uuid, long groupId) {

		return _ecMemberRequestLocalService.
			fetchEcMemberRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest findByPotentialEcMemberId(
		long potentialEcMemberId) {

		return _ecMemberRequestLocalService.findByPotentialEcMemberId(
			potentialEcMemberId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequest>
		findByPotentialEcMemberLruserid(long potentialEcMemberLruserid) {

		return _ecMemberRequestLocalService.findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ecMemberRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request with the primary key.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws PortalException if a ec member request with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequest getEcMemberRequest(
			long ecMemberRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.getEcMemberRequest(
			ecMemberRequestId);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest getEcMemberRequestById(
			long ecMemberRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.getEcMemberRequestById(
			ecMemberRequestId);
	}

	/**
	 * Returns the ec member request matching the UUID and group.
	 *
	 * @param uuid the ec member request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request
	 * @throws PortalException if a matching ec member request could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequest
			getEcMemberRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.getEcMemberRequestByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequest>
		getEcMemberRequests(int start, int end) {

		return _ecMemberRequestLocalService.getEcMemberRequests(start, end);
	}

	/**
	 * Returns all the ec member requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member requests
	 * @param companyId the primary key of the company
	 * @return the matching ec member requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequest>
		getEcMemberRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _ecMemberRequestLocalService.
			getEcMemberRequestsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequest>
		getEcMemberRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.EcMemberRequest> orderByComparator) {

		return _ecMemberRequestLocalService.
			getEcMemberRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	@Override
	public int getEcMemberRequestsCount() {
		return _ecMemberRequestLocalService.getEcMemberRequestsCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ECMembershipRequestListDTO>
		getECMembershipRequestData(
			long programId, long roleId, long statusId,
			long potentialEcMemberLrUserid, String languageCode) {

		return _ecMemberRequestLocalService.getECMembershipRequestData(
			programId, roleId, statusId, potentialEcMemberLrUserid,
			languageCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ecMemberRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.FacultySiteCompensationDTO>
		getFacultySiteCompensationReportDetailsOfEcMember(
			String languageCode, long programId) {

		return _ecMemberRequestLocalService.
			getFacultySiteCompensationReportDetailsOfEcMember(
				languageCode, programId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ecMemberRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecMemberRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.User getPotentialMemberUser(
		long requestId) {

		return _ecMemberRequestLocalService.getPotentialMemberUser(requestId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ResidentReportDTO>
		getResidentsInEachSitePerBlock(
			long programId, String annualYear, String languageCode) {

		return _ecMemberRequestLocalService.getResidentsInEachSitePerBlock(
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
	@Override
	public gov.omsb.tms.model.EcMemberRequest updateEcMemberRequest(
		gov.omsb.tms.model.EcMemberRequest ecMemberRequest) {

		return _ecMemberRequestLocalService.updateEcMemberRequest(
			ecMemberRequest);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest updateRequest(
		gov.omsb.tms.model.EcMemberRequest ecMemberRequest) {

		return _ecMemberRequestLocalService.updateRequest(ecMemberRequest);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest updateStatus(
			long userId, long ecMemberRequestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.updateStatus(
			userId, ecMemberRequestId, status, serviceContext);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequest updateStatus(
			long userId, long roleId, long ecMemberRequestId, int status,
			String ecRequestStateCode, String comments,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestLocalService.updateStatus(
			userId, roleId, ecMemberRequestId, status, ecRequestStateCode,
			comments, serviceContext);
	}

	@Override
	public EcMemberRequestLocalService getWrappedService() {
		return _ecMemberRequestLocalService;
	}

	@Override
	public void setWrappedService(
		EcMemberRequestLocalService ecMemberRequestLocalService) {

		_ecMemberRequestLocalService = ecMemberRequestLocalService;
	}

	private EcMemberRequestLocalService _ecMemberRequestLocalService;

}