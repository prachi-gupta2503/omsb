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
 * Provides a wrapper for {@link ViolationUpdateStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatusLocalService
 * @generated
 */
public class ViolationUpdateStatusLocalServiceWrapper
	implements ServiceWrapper<ViolationUpdateStatusLocalService>,
			   ViolationUpdateStatusLocalService {

	public ViolationUpdateStatusLocalServiceWrapper() {
		this(null);
	}

	public ViolationUpdateStatusLocalServiceWrapper(
		ViolationUpdateStatusLocalService violationUpdateStatusLocalService) {

		_violationUpdateStatusLocalService = violationUpdateStatusLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus addViolationUpdateStatus(
		gov.omsb.tms.model.ViolationUpdateStatus violationUpdateStatus) {

		return _violationUpdateStatusLocalService.addViolationUpdateStatus(
			violationUpdateStatus);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new violation update status with the primary key. Does not add the violation update status to the database.
	 *
	 * @param violationUpdateStatusId the primary key for the new violation update status
	 * @return the new violation update status
	 */
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus createViolationUpdateStatus(
		long violationUpdateStatusId) {

		return _violationUpdateStatusLocalService.createViolationUpdateStatus(
			violationUpdateStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus deleteViolationUpdateStatus(
			long violationUpdateStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.deleteViolationUpdateStatus(
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
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus deleteViolationUpdateStatus(
		gov.omsb.tms.model.ViolationUpdateStatus violationUpdateStatus) {

		return _violationUpdateStatusLocalService.deleteViolationUpdateStatus(
			violationUpdateStatus);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _violationUpdateStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _violationUpdateStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _violationUpdateStatusLocalService.dynamicQuery();
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

		return _violationUpdateStatusLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _violationUpdateStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _violationUpdateStatusLocalService.dynamicQuery(
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

		return _violationUpdateStatusLocalService.dynamicQueryCount(
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

		return _violationUpdateStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus fetchViolationUpdateStatus(
		long violationUpdateStatusId) {

		return _violationUpdateStatusLocalService.fetchViolationUpdateStatus(
			violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status matching the UUID and group.
	 *
	 * @param uuid the violation update status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus
		fetchViolationUpdateStatusByUuidAndGroupId(String uuid, long groupId) {

		return _violationUpdateStatusLocalService.
			fetchViolationUpdateStatusByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _violationUpdateStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus
		getByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {

		return _violationUpdateStatusLocalService.
			getByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _violationUpdateStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _violationUpdateStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the violation update status with the primary key.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status
	 * @throws PortalException if a violation update status with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus getViolationUpdateStatus(
			long violationUpdateStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.getViolationUpdateStatus(
			violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status matching the UUID and group.
	 *
	 * @param uuid the violation update status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching violation update status
	 * @throws PortalException if a matching violation update status could not be found
	 */
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus
			getViolationUpdateStatusByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _violationUpdateStatusLocalService.
			getViolationUpdateStatusByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.ViolationUpdateStatus>
		getViolationUpdateStatuses(int start, int end) {

		return _violationUpdateStatusLocalService.getViolationUpdateStatuses(
			start, end);
	}

	/**
	 * Returns all the violation update statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the violation update statuses
	 * @param companyId the primary key of the company
	 * @return the matching violation update statuses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ViolationUpdateStatus>
		getViolationUpdateStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _violationUpdateStatusLocalService.
			getViolationUpdateStatusesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.ViolationUpdateStatus>
		getViolationUpdateStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ViolationUpdateStatus> orderByComparator) {

		return _violationUpdateStatusLocalService.
			getViolationUpdateStatusesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of violation update statuses.
	 *
	 * @return the number of violation update statuses
	 */
	@Override
	public int getViolationUpdateStatusesCount() {
		return _violationUpdateStatusLocalService.
			getViolationUpdateStatusesCount();
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
	@Override
	public gov.omsb.tms.model.ViolationUpdateStatus updateViolationUpdateStatus(
		gov.omsb.tms.model.ViolationUpdateStatus violationUpdateStatus) {

		return _violationUpdateStatusLocalService.updateViolationUpdateStatus(
			violationUpdateStatus);
	}

	@Override
	public ViolationUpdateStatusLocalService getWrappedService() {
		return _violationUpdateStatusLocalService;
	}

	@Override
	public void setWrappedService(
		ViolationUpdateStatusLocalService violationUpdateStatusLocalService) {

		_violationUpdateStatusLocalService = violationUpdateStatusLocalService;
	}

	private ViolationUpdateStatusLocalService
		_violationUpdateStatusLocalService;

}