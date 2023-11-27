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
 * Provides a wrapper for {@link EcMemberRequestRotationsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestRotationsLocalService
 * @generated
 */
public class EcMemberRequestRotationsLocalServiceWrapper
	implements EcMemberRequestRotationsLocalService,
			   ServiceWrapper<EcMemberRequestRotationsLocalService> {

	public EcMemberRequestRotationsLocalServiceWrapper() {
		this(null);
	}

	public EcMemberRequestRotationsLocalServiceWrapper(
		EcMemberRequestRotationsLocalService
			ecMemberRequestRotationsLocalService) {

		_ecMemberRequestRotationsLocalService =
			ecMemberRequestRotationsLocalService;
	}

	/**
	 * Adds the ec member request rotations to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestRotations the ec member request rotations
	 * @return the ec member request rotations that was added
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		addEcMemberRequestRotations(
			gov.omsb.tms.model.EcMemberRequestRotations
				ecMemberRequestRotations) {

		return _ecMemberRequestRotationsLocalService.
			addEcMemberRequestRotations(ecMemberRequestRotations);
	}

	/**
	 * Creates a new ec member request rotations with the primary key. Does not add the ec member request rotations to the database.
	 *
	 * @param ecMemberRequestRotationsId the primary key for the new ec member request rotations
	 * @return the new ec member request rotations
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		createEcMemberRequestRotations(long ecMemberRequestRotationsId) {

		return _ecMemberRequestRotationsLocalService.
			createEcMemberRequestRotations(ecMemberRequestRotationsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the ec member request rotations from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestRotations the ec member request rotations
	 * @return the ec member request rotations that was removed
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		deleteEcMemberRequestRotations(
			gov.omsb.tms.model.EcMemberRequestRotations
				ecMemberRequestRotations) {

		return _ecMemberRequestRotationsLocalService.
			deleteEcMemberRequestRotations(ecMemberRequestRotations);
	}

	/**
	 * Deletes the ec member request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestRotationsId the primary key of the ec member request rotations
	 * @return the ec member request rotations that was removed
	 * @throws PortalException if a ec member request rotations with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
			deleteEcMemberRequestRotations(long ecMemberRequestRotationsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.
			deleteEcMemberRequestRotations(ecMemberRequestRotationsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ecMemberRequestRotationsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ecMemberRequestRotationsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ecMemberRequestRotationsLocalService.dynamicQuery();
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

		return _ecMemberRequestRotationsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestRotationsModelImpl</code>.
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

		return _ecMemberRequestRotationsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestRotationsModelImpl</code>.
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

		return _ecMemberRequestRotationsLocalService.dynamicQuery(
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

		return _ecMemberRequestRotationsLocalService.dynamicQueryCount(
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

		return _ecMemberRequestRotationsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		fetchEcMemberRequestRotations(long ecMemberRequestRotationsId) {

		return _ecMemberRequestRotationsLocalService.
			fetchEcMemberRequestRotations(ecMemberRequestRotationsId);
	}

	/**
	 * Returns the ec member request rotations matching the UUID and group.
	 *
	 * @param uuid the ec member request rotations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request rotations, or <code>null</code> if a matching ec member request rotations could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		fetchEcMemberRequestRotationsByUuidAndGroupId(
			String uuid, long groupId) {

		return _ecMemberRequestRotationsLocalService.
			fetchEcMemberRequestRotationsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestRotations>
		findByEcMemberRequestId(long ecMemberRequestId) {

		return _ecMemberRequestRotationsLocalService.findByEcMemberRequestId(
			ecMemberRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ecMemberRequestRotationsLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the ec member request rotations with the primary key.
	 *
	 * @param ecMemberRequestRotationsId the primary key of the ec member request rotations
	 * @return the ec member request rotations
	 * @throws PortalException if a ec member request rotations with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
			getEcMemberRequestRotations(long ecMemberRequestRotationsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotations(ecMemberRequestRotationsId);
	}

	/**
	 * Returns the ec member request rotations matching the UUID and group.
	 *
	 * @param uuid the ec member request rotations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ec member request rotations
	 * @throws PortalException if a matching ec member request rotations could not be found
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
			getEcMemberRequestRotationsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotationsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ec member request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EcMemberRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @return the range of ec member request rotationses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestRotations>
		getEcMemberRequestRotationses(int start, int end) {

		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotationses(start, end);
	}

	/**
	 * Returns all the ec member request rotationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request rotationses
	 * @param companyId the primary key of the company
	 * @return the matching ec member request rotationses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestRotations>
		getEcMemberRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotationsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of ec member request rotationses matching the UUID and company.
	 *
	 * @param uuid the UUID of the ec member request rotationses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ec member request rotationses
	 * @param end the upper bound of the range of ec member request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ec member request rotationses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EcMemberRequestRotations>
		getEcMemberRequestRotationsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.EcMemberRequestRotations>
					orderByComparator) {

		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotationsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ec member request rotationses.
	 *
	 * @return the number of ec member request rotationses
	 */
	@Override
	public int getEcMemberRequestRotationsesCount() {
		return _ecMemberRequestRotationsLocalService.
			getEcMemberRequestRotationsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ecMemberRequestRotationsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ecMemberRequestRotationsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecMemberRequestRotationsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecMemberRequestRotationsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the ec member request rotations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EcMemberRequestRotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ecMemberRequestRotations the ec member request rotations
	 * @return the ec member request rotations that was updated
	 */
	@Override
	public gov.omsb.tms.model.EcMemberRequestRotations
		updateEcMemberRequestRotations(
			gov.omsb.tms.model.EcMemberRequestRotations
				ecMemberRequestRotations) {

		return _ecMemberRequestRotationsLocalService.
			updateEcMemberRequestRotations(ecMemberRequestRotations);
	}

	@Override
	public EcMemberRequestRotationsLocalService getWrappedService() {
		return _ecMemberRequestRotationsLocalService;
	}

	@Override
	public void setWrappedService(
		EcMemberRequestRotationsLocalService
			ecMemberRequestRotationsLocalService) {

		_ecMemberRequestRotationsLocalService =
			ecMemberRequestRotationsLocalService;
	}

	private EcMemberRequestRotationsLocalService
		_ecMemberRequestRotationsLocalService;

}