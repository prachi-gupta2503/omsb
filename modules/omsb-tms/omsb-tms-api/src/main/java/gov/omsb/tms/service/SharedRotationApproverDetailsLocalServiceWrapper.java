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
 * Provides a wrapper for {@link SharedRotationApproverDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetailsLocalService
 * @generated
 */
public class SharedRotationApproverDetailsLocalServiceWrapper
	implements ServiceWrapper<SharedRotationApproverDetailsLocalService>,
			   SharedRotationApproverDetailsLocalService {

	public SharedRotationApproverDetailsLocalServiceWrapper() {
		this(null);
	}

	public SharedRotationApproverDetailsLocalServiceWrapper(
		SharedRotationApproverDetailsLocalService
			sharedRotationApproverDetailsLocalService) {

		_sharedRotationApproverDetailsLocalService =
			sharedRotationApproverDetailsLocalService;
	}

	/**
	 * Adds the shared rotation approver details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was added
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		addSharedRotationApproverDetails(
			gov.omsb.tms.model.SharedRotationApproverDetails
				sharedRotationApproverDetails) {

		return _sharedRotationApproverDetailsLocalService.
			addSharedRotationApproverDetails(sharedRotationApproverDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new shared rotation approver details with the primary key. Does not add the shared rotation approver details to the database.
	 *
	 * @param sharedRotationApproverDetailsId the primary key for the new shared rotation approver details
	 * @return the new shared rotation approver details
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		createSharedRotationApproverDetails(
			long sharedRotationApproverDetailsId) {

		return _sharedRotationApproverDetailsLocalService.
			createSharedRotationApproverDetails(
				sharedRotationApproverDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws PortalException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
			deleteSharedRotationApproverDetails(
				long sharedRotationApproverDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.
			deleteSharedRotationApproverDetails(
				sharedRotationApproverDetailsId);
	}

	/**
	 * Deletes the shared rotation approver details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		deleteSharedRotationApproverDetails(
			gov.omsb.tms.model.SharedRotationApproverDetails
				sharedRotationApproverDetails) {

		return _sharedRotationApproverDetailsLocalService.
			deleteSharedRotationApproverDetails(sharedRotationApproverDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sharedRotationApproverDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sharedRotationApproverDetailsLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sharedRotationApproverDetailsLocalService.dynamicQuery();
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

		return _sharedRotationApproverDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
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

		return _sharedRotationApproverDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
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

		return _sharedRotationApproverDetailsLocalService.dynamicQuery(
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

		return _sharedRotationApproverDetailsLocalService.dynamicQueryCount(
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

		return _sharedRotationApproverDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		fetchSharedRotationApproverDetails(
			long sharedRotationApproverDetailsId) {

		return _sharedRotationApproverDetailsLocalService.
			fetchSharedRotationApproverDetails(sharedRotationApproverDetailsId);
	}

	/**
	 * Returns the shared rotation approver details matching the UUID and group.
	 *
	 * @param uuid the shared rotation approver details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		fetchSharedRotationApproverDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _sharedRotationApproverDetailsLocalService.
			fetchSharedRotationApproverDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		findBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId) {

		return _sharedRotationApproverDetailsLocalService.
			findBySharedRotationRequestDetailsId(
				sharedRotationRequestDetailsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sharedRotationApproverDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sharedRotationApproverDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sharedRotationApproverDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sharedRotationApproverDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the shared rotation approver details with the primary key.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws PortalException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
			getSharedRotationApproverDetails(
				long sharedRotationApproverDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetails(sharedRotationApproverDetailsId);
	}

	/**
	 * Returns the shared rotation approver details matching the UUID and group.
	 *
	 * @param uuid the shared rotation approver details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching shared rotation approver details
	 * @throws PortalException if a matching shared rotation approver details could not be found
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
			getSharedRotationApproverDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of shared rotation approver detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationApproverDetails>
		getSharedRotationApproverDetailses(int start, int end) {

		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetailses(start, end);
	}

	/**
	 * Returns all the shared rotation approver detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation approver detailses
	 * @param companyId the primary key of the company
	 * @return the matching shared rotation approver detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationApproverDetails>
		getSharedRotationApproverDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of shared rotation approver detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the shared rotation approver detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching shared rotation approver detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.SharedRotationApproverDetails>
		getSharedRotationApproverDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.SharedRotationApproverDetails>
					orderByComparator) {

		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of shared rotation approver detailses.
	 *
	 * @return the number of shared rotation approver detailses
	 */
	@Override
	public int getSharedRotationApproverDetailsesCount() {
		return _sharedRotationApproverDetailsLocalService.
			getSharedRotationApproverDetailsesCount();
	}

	/**
	 * Updates the shared rotation approver details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SharedRotationApproverDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 * @return the shared rotation approver details that was updated
	 */
	@Override
	public gov.omsb.tms.model.SharedRotationApproverDetails
		updateSharedRotationApproverDetails(
			gov.omsb.tms.model.SharedRotationApproverDetails
				sharedRotationApproverDetails) {

		return _sharedRotationApproverDetailsLocalService.
			updateSharedRotationApproverDetails(sharedRotationApproverDetails);
	}

	@Override
	public SharedRotationApproverDetailsLocalService getWrappedService() {
		return _sharedRotationApproverDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		SharedRotationApproverDetailsLocalService
			sharedRotationApproverDetailsLocalService) {

		_sharedRotationApproverDetailsLocalService =
			sharedRotationApproverDetailsLocalService;
	}

	private SharedRotationApproverDetailsLocalService
		_sharedRotationApproverDetailsLocalService;

}