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
 * Provides a wrapper for {@link QararRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QararRequestLocalService
 * @generated
 */
public class QararRequestLocalServiceWrapper
	implements QararRequestLocalService,
			   ServiceWrapper<QararRequestLocalService> {

	public QararRequestLocalServiceWrapper() {
		this(null);
	}

	public QararRequestLocalServiceWrapper(
		QararRequestLocalService qararRequestLocalService) {

		_qararRequestLocalService = qararRequestLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.QararRequest addQararRequest(
		gov.omsb.tms.model.QararRequest qararRequest) {

		return _qararRequestLocalService.addQararRequest(qararRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new qarar request with the primary key. Does not add the qarar request to the database.
	 *
	 * @param qararRequestId the primary key for the new qarar request
	 * @return the new qarar request
	 */
	@Override
	public gov.omsb.tms.model.QararRequest createQararRequest(
		long qararRequestId) {

		return _qararRequestLocalService.createQararRequest(qararRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public gov.omsb.tms.model.QararRequest deleteQararRequest(
			long qararRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.deleteQararRequest(qararRequestId);
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
	@Override
	public gov.omsb.tms.model.QararRequest deleteQararRequest(
		gov.omsb.tms.model.QararRequest qararRequest) {

		return _qararRequestLocalService.deleteQararRequest(qararRequest);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _qararRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _qararRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _qararRequestLocalService.dynamicQuery();
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

		return _qararRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _qararRequestLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _qararRequestLocalService.dynamicQuery(
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

		return _qararRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _qararRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.QararRequest fetchQararRequest(
		long qararRequestId) {

		return _qararRequestLocalService.fetchQararRequest(qararRequestId);
	}

	/**
	 * Returns the qarar request matching the UUID and group.
	 *
	 * @param uuid the qarar request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching qarar request, or <code>null</code> if a matching qarar request could not be found
	 */
	@Override
	public gov.omsb.tms.model.QararRequest fetchQararRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return _qararRequestLocalService.fetchQararRequestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.QararRequest findByDocTreeId(long docTreeId)
		throws gov.omsb.tms.exception.NoSuchQararRequestException {

		return _qararRequestLocalService.findByDocTreeId(docTreeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _qararRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _qararRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _qararRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qararRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the qarar request with the primary key.
	 *
	 * @param qararRequestId the primary key of the qarar request
	 * @return the qarar request
	 * @throws PortalException if a qarar request with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.QararRequest getQararRequest(long qararRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.getQararRequest(qararRequestId);
	}

	/**
	 * Returns the qarar request matching the UUID and group.
	 *
	 * @param uuid the qarar request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching qarar request
	 * @throws PortalException if a matching qarar request could not be found
	 */
	@Override
	public gov.omsb.tms.model.QararRequest getQararRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _qararRequestLocalService.getQararRequestByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.QararRequest> getQararRequests(
		int start, int end) {

		return _qararRequestLocalService.getQararRequests(start, end);
	}

	/**
	 * Returns all the qarar requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the qarar requests
	 * @param companyId the primary key of the company
	 * @return the matching qarar requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.QararRequest>
		getQararRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _qararRequestLocalService.getQararRequestsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.QararRequest>
		getQararRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.QararRequest> orderByComparator) {

		return _qararRequestLocalService.getQararRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of qarar requests.
	 *
	 * @return the number of qarar requests
	 */
	@Override
	public int getQararRequestsCount() {
		return _qararRequestLocalService.getQararRequestsCount();
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
	@Override
	public gov.omsb.tms.model.QararRequest updateQararRequest(
		gov.omsb.tms.model.QararRequest qararRequest) {

		return _qararRequestLocalService.updateQararRequest(qararRequest);
	}

	@Override
	public QararRequestLocalService getWrappedService() {
		return _qararRequestLocalService;
	}

	@Override
	public void setWrappedService(
		QararRequestLocalService qararRequestLocalService) {

		_qararRequestLocalService = qararRequestLocalService;
	}

	private QararRequestLocalService _qararRequestLocalService;

}