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
 * Provides a wrapper for {@link EcMemberRequestStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatusLocalService
 * @generated
 */
public class EcMemberRequestStatusLocalServiceWrapper
	implements EcMemberRequestStatusLocalService,
			   ServiceWrapper<EcMemberRequestStatusLocalService> {

	public EcMemberRequestStatusLocalServiceWrapper() {
		this(null);
	}

	public EcMemberRequestStatusLocalServiceWrapper(
		EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService) {

		_ecMemberRequestStatusLocalService = ecMemberRequestStatusLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus addEcMemberRequestStatus(
		gov.omsb.tms.model.EcMemberRequestStatus ecMemberRequestStatus) {

		return _ecMemberRequestStatusLocalService.addEcMemberRequestStatus(
			ecMemberRequestStatus);
	}

	/**
	 * Creates a new ec member request status with the primary key. Does not add the ec member request status to the database.
	 *
	 * @param ecMemberRequestStatusId the primary key for the new ec member request status
	 * @return the new ec member request status
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus createEcMemberRequestStatus(
		long ecMemberRequestStatusId) {

		return _ecMemberRequestStatusLocalService.createEcMemberRequestStatus(
			ecMemberRequestStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus deleteEcMemberRequestStatus(
		gov.omsb.tms.model.EcMemberRequestStatus ecMemberRequestStatus) {

		return _ecMemberRequestStatusLocalService.deleteEcMemberRequestStatus(
			ecMemberRequestStatus);
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
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus deleteEcMemberRequestStatus(
			long ecMemberRequestStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.deleteEcMemberRequestStatus(
			ecMemberRequestStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ecMemberRequestStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ecMemberRequestStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ecMemberRequestStatusLocalService.dynamicQuery();
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

		return _ecMemberRequestStatusLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ecMemberRequestStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ecMemberRequestStatusLocalService.dynamicQuery(
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

		return _ecMemberRequestStatusLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _ecMemberRequestStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus fetchEcMemberRequestStatus(
		long ecMemberRequestStatusId) {

		return _ecMemberRequestStatusLocalService.fetchEcMemberRequestStatus(
			ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status matching the UUID and group.
	 *
	 * @param uuid the ec member request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus
		fetchEcMemberRequestStatusByUuidAndGroupId(String uuid, long groupId) {

		return _ecMemberRequestStatusLocalService.
			fetchEcMemberRequestStatusByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus findByCode(String code) {
		return _ecMemberRequestStatusLocalService.findByCode(code);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus findByName(String name) {
		return _ecMemberRequestStatusLocalService.findByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ecMemberRequestStatusLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request status with the primary key.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws PortalException if a ec member request status with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus getEcMemberRequestStatus(
			long ecMemberRequestStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.getEcMemberRequestStatus(
			ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status matching the UUID and group.
	 *
	 * @param uuid the ec member request status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request status
	 * @throws PortalException if a matching ec member request status could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus
			getEcMemberRequestStatusByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.
			getEcMemberRequestStatusByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestStatus>
		getEcMemberRequestStatuses(int start, int end) {

		return _ecMemberRequestStatusLocalService.getEcMemberRequestStatuses(
			start, end);
	}

	/**
	 * Returns all the ec member request statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request statuses
	 * @param companyId the primary key of the company
	 * @return the matching ec member request statuses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestStatus>
		getEcMemberRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _ecMemberRequestStatusLocalService.
			getEcMemberRequestStatusesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestStatus>
		getEcMemberRequestStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.EcMemberRequestStatus> orderByComparator) {

		return _ecMemberRequestStatusLocalService.
			getEcMemberRequestStatusesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member request statuses.
	 *
	 * @return the number of ec member request statuses
	 */
	@Override
	public int getEcMemberRequestStatusesCount() {
		return _ecMemberRequestStatusLocalService.
			getEcMemberRequestStatusesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ecMemberRequestStatusLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ecMemberRequestStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecMemberRequestStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStatusLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.EcMemberRequestStatus updateEcMemberRequestStatus(
		gov.omsb.tms.model.EcMemberRequestStatus ecMemberRequestStatus) {

		return _ecMemberRequestStatusLocalService.updateEcMemberRequestStatus(
			ecMemberRequestStatus);
	}

	@Override
	public EcMemberRequestStatusLocalService getWrappedService() {
		return _ecMemberRequestStatusLocalService;
	}

	@Override
	public void setWrappedService(
		EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService) {

		_ecMemberRequestStatusLocalService = ecMemberRequestStatusLocalService;
	}

	private EcMemberRequestStatusLocalService
		_ecMemberRequestStatusLocalService;

}