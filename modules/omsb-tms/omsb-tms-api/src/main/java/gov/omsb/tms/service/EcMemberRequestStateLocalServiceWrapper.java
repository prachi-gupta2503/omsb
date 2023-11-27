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
 * Provides a wrapper for {@link EcMemberRequestStateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStateLocalService
 * @generated
 */
public class EcMemberRequestStateLocalServiceWrapper
	implements EcMemberRequestStateLocalService,
			   ServiceWrapper<EcMemberRequestStateLocalService> {

	public EcMemberRequestStateLocalServiceWrapper() {
		this(null);
	}

	public EcMemberRequestStateLocalServiceWrapper(
		EcMemberRequestStateLocalService ecMemberRequestStateLocalService) {

		_ecMemberRequestStateLocalService = ecMemberRequestStateLocalService;
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestState addComments(
		String comment, long ecMemberRequestId) {

		return _ecMemberRequestStateLocalService.addComments(
			comment, ecMemberRequestId);
	}

	/**
	 * Adds the ec member request state to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was added
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState addEcMemberRequestState(
		gov.omsb.tms.model.EcMemberRequestState ecMemberRequestState) {

		return _ecMemberRequestStateLocalService.addEcMemberRequestState(
			ecMemberRequestState);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestState addRequestState(
		String comment, long ecMemberRequestId, long statusId, long userId,
		long roleId, boolean isPublic) {

		return _ecMemberRequestStateLocalService.addRequestState(
			comment, ecMemberRequestId, statusId, userId, roleId, isPublic);
	}

	/**
	 * Creates a new ec member request state with the primary key. Does not add the ec member request state to the database.
	 *
	 * @param ecMemberRequestStateId the primary key for the new ec member request state
	 * @return the new ec member request state
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState createEcMemberRequestState(
		long ecMemberRequestStateId) {

		return _ecMemberRequestStateLocalService.createEcMemberRequestState(
			ecMemberRequestStateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the ec member request state from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was removed
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState deleteEcMemberRequestState(
		gov.omsb.tms.model.EcMemberRequestState ecMemberRequestState) {

		return _ecMemberRequestStateLocalService.deleteEcMemberRequestState(
			ecMemberRequestState);
	}

	/**
	 * Deletes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws PortalException if a ec member request state with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState deleteEcMemberRequestState(
			long ecMemberRequestStateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.deleteEcMemberRequestState(
			ecMemberRequestStateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ecMemberRequestStateLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ecMemberRequestStateLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ecMemberRequestStateLocalService.dynamicQuery();
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

		return _ecMemberRequestStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
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

		return _ecMemberRequestStateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
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

		return _ecMemberRequestStateLocalService.dynamicQuery(
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

		return _ecMemberRequestStateLocalService.dynamicQueryCount(
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

		return _ecMemberRequestStateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ECMembershipRequestStateDTO>
		eCMembershipRequestStateList(long emMemberRequestId) {

		return _ecMemberRequestStateLocalService.eCMembershipRequestStateList(
			emMemberRequestId);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestState fetchEcMemberRequestState(
		long ecMemberRequestStateId) {

		return _ecMemberRequestStateLocalService.fetchEcMemberRequestState(
			ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state matching the UUID and group.
	 *
	 * @param uuid the ec member request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState
		fetchEcMemberRequestStateByUuidAndGroupId(String uuid, long groupId) {

		return _ecMemberRequestStateLocalService.
			fetchEcMemberRequestStateByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestState>
		findByEcMemberRequestId(long ecMemberRequestId) {

		return _ecMemberRequestStateLocalService.findByEcMemberRequestId(
			ecMemberRequestId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestState>
		findByVisibility(long ecMemberRequestId, boolean isPublic) {

		return _ecMemberRequestStateLocalService.findByVisibility(
			ecMemberRequestId, isPublic);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ecMemberRequestStateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request state with the primary key.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws PortalException if a ec member request state with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState getEcMemberRequestState(
			long ecMemberRequestStateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.getEcMemberRequestState(
			ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state matching the UUID and group.
	 *
	 * @param uuid the ec member request state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request state
	 * @throws PortalException if a matching ec member request state could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState
			getEcMemberRequestStateByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.
			getEcMemberRequestStateByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of ec member request states
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestState>
		getEcMemberRequestStates(int start, int end) {

		return _ecMemberRequestStateLocalService.getEcMemberRequestStates(
			start, end);
	}

	/**
	 * Returns all the ec member request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request states
	 * @param companyId the primary key of the company
	 * @return the matching ec member request states, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestState>
		getEcMemberRequestStatesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _ecMemberRequestStateLocalService.
			getEcMemberRequestStatesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of ec member request states matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request states
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member request states, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestState>
		getEcMemberRequestStatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.EcMemberRequestState> orderByComparator) {

		return _ecMemberRequestStateLocalService.
			getEcMemberRequestStatesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member request states.
	 *
	 * @return the number of ec member request states
	 */
	@Override
	public int getEcMemberRequestStatesCount() {
		return _ecMemberRequestStateLocalService.
			getEcMemberRequestStatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ecMemberRequestStateLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ecMemberRequestStateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecMemberRequestStateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestStateLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the ec member request state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestStateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestState the ec member request state
	 * @return the ec member request state that was updated
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestState updateEcMemberRequestState(
		gov.omsb.tms.model.EcMemberRequestState ecMemberRequestState) {

		return _ecMemberRequestStateLocalService.updateEcMemberRequestState(
			ecMemberRequestState);
	}

	@Override
	public EcMemberRequestStateLocalService getWrappedService() {
		return _ecMemberRequestStateLocalService;
	}

	@Override
	public void setWrappedService(
		EcMemberRequestStateLocalService ecMemberRequestStateLocalService) {

		_ecMemberRequestStateLocalService = ecMemberRequestStateLocalService;
	}

	private EcMemberRequestStateLocalService _ecMemberRequestStateLocalService;

}