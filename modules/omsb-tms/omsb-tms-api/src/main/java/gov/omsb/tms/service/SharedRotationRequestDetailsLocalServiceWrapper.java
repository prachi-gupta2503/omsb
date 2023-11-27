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
 * Provides a wrapper for {@link SharedRotationRequestDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetailsLocalService
 * @generated
 */
public class SharedRotationRequestDetailsLocalServiceWrapper
	implements ServiceWrapper<SharedRotationRequestDetailsLocalService>,
			   SharedRotationRequestDetailsLocalService {

	public SharedRotationRequestDetailsLocalServiceWrapper() {
		this(null);
	}

	public SharedRotationRequestDetailsLocalServiceWrapper(
		SharedRotationRequestDetailsLocalService
			sharedRotationRequestDetailsLocalService) {

		_sharedRotationRequestDetailsLocalService =
			sharedRotationRequestDetailsLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		addSharedRotationRequestDetails(
			gov.omsb.tms.model.SharedRotationRequestDetails
				sharedRotationRequestDetails) {

		return _sharedRotationRequestDetailsLocalService.
			addSharedRotationRequestDetails(sharedRotationRequestDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new shared rotation request details with the primary key. Does not add the shared rotation request details to the database.
	 *
	 * @param sharedRotationRequestDetailsId the primary key for the new shared rotation request details
	 * @return the new shared rotation request details
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		createSharedRotationRequestDetails(
			long sharedRotationRequestDetailsId) {

		return _sharedRotationRequestDetailsLocalService.
			createSharedRotationRequestDetails(sharedRotationRequestDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
			deleteSharedRotationRequestDetails(
				long sharedRotationRequestDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.
			deleteSharedRotationRequestDetails(sharedRotationRequestDetailsId);
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
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		deleteSharedRotationRequestDetails(
			gov.omsb.tms.model.SharedRotationRequestDetails
				sharedRotationRequestDetails) {

		return _sharedRotationRequestDetailsLocalService.
			deleteSharedRotationRequestDetails(sharedRotationRequestDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sharedRotationRequestDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sharedRotationRequestDetailsLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sharedRotationRequestDetailsLocalService.dynamicQuery();
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

		return _sharedRotationRequestDetailsLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _sharedRotationRequestDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _sharedRotationRequestDetailsLocalService.dynamicQuery(
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

		return _sharedRotationRequestDetailsLocalService.dynamicQueryCount(
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

		return _sharedRotationRequestDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		fetchSharedRotationRequestDetails(long sharedRotationRequestDetailsId) {

		return _sharedRotationRequestDetailsLocalService.
			fetchSharedRotationRequestDetails(sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation request details matching the UUID and group.
	 *
	 * @param uuid the shared rotation request details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		fetchSharedRotationRequestDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _sharedRotationRequestDetailsLocalService.
			fetchSharedRotationRequestDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationRequestDetails>
		findByRequestRaisedBy(String requestRaisedBy) {

		return _sharedRotationRequestDetailsLocalService.findByRequestRaisedBy(
			requestRaisedBy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sharedRotationRequestDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sharedRotationRequestDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sharedRotationRequestDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sharedRotationRequestDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the shared rotation request details with the primary key.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws PortalException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
			getSharedRotationRequestDetails(long sharedRotationRequestDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetails(sharedRotationRequestDetailsId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationRequestDetails>
		getSharedRotationRequestDetailsByApproverId(long approverId) {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailsByApproverId(approverId);
	}

	/**
	 * Returns the shared rotation request details matching the UUID and group.
	 *
	 * @param uuid the shared rotation request details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation request details
	 * @throws PortalException if a matching shared rotation request details could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
			getSharedRotationRequestDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailsByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationRequestDetails>
		getSharedRotationRequestDetailses(int start, int end) {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailses(start, end);
	}

	/**
	 * Returns all the shared rotation request detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation request detailses
	 * @param companyId the primary key of the company
	 * @return the matching shared rotation request detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationRequestDetails>
		getSharedRotationRequestDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailsesByUuidAndCompanyId(
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
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationRequestDetails>
		getSharedRotationRequestDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.SharedRotationRequestDetails>
					orderByComparator) {

		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of shared rotation request detailses.
	 *
	 * @return the number of shared rotation request detailses
	 */
	@Override
	public int getSharedRotationRequestDetailsesCount() {
		return _sharedRotationRequestDetailsLocalService.
			getSharedRotationRequestDetailsesCount();
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
	@Override
	public gov.omsb.tms.model.SharedRotationRequestDetails
		updateSharedRotationRequestDetails(
			gov.omsb.tms.model.SharedRotationRequestDetails
				sharedRotationRequestDetails) {

		return _sharedRotationRequestDetailsLocalService.
			updateSharedRotationRequestDetails(sharedRotationRequestDetails);
	}

	@Override
	public SharedRotationRequestDetailsLocalService getWrappedService() {
		return _sharedRotationRequestDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		SharedRotationRequestDetailsLocalService
			sharedRotationRequestDetailsLocalService) {

		_sharedRotationRequestDetailsLocalService =
			sharedRotationRequestDetailsLocalService;
	}

	private SharedRotationRequestDetailsLocalService
		_sharedRotationRequestDetailsLocalService;

}