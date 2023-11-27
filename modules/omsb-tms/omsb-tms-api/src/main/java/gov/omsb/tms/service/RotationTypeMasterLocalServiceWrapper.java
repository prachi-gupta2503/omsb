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
 * Provides a wrapper for {@link RotationTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RotationTypeMasterLocalService
 * @generated
 */
public class RotationTypeMasterLocalServiceWrapper
	implements RotationTypeMasterLocalService,
			   ServiceWrapper<RotationTypeMasterLocalService> {

	public RotationTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public RotationTypeMasterLocalServiceWrapper(
		RotationTypeMasterLocalService rotationTypeMasterLocalService) {

		_rotationTypeMasterLocalService = rotationTypeMasterLocalService;
	}

	/**
	 * Adds the rotation type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationTypeMaster the rotation type master
	 * @return the rotation type master that was added
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster addRotationTypeMaster(
		gov.omsb.tms.model.RotationTypeMaster rotationTypeMaster) {

		return _rotationTypeMasterLocalService.addRotationTypeMaster(
			rotationTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rotation type master with the primary key. Does not add the rotation type master to the database.
	 *
	 * @param rotationTypeMasterId the primary key for the new rotation type master
	 * @return the new rotation type master
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster createRotationTypeMaster(
		long rotationTypeMasterId) {

		return _rotationTypeMasterLocalService.createRotationTypeMaster(
			rotationTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rotation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master that was removed
	 * @throws PortalException if a rotation type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster deleteRotationTypeMaster(
			long rotationTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.deleteRotationTypeMaster(
			rotationTypeMasterId);
	}

	/**
	 * Deletes the rotation type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationTypeMaster the rotation type master
	 * @return the rotation type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster deleteRotationTypeMaster(
		gov.omsb.tms.model.RotationTypeMaster rotationTypeMaster) {

		return _rotationTypeMasterLocalService.deleteRotationTypeMaster(
			rotationTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rotationTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rotationTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rotationTypeMasterLocalService.dynamicQuery();
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

		return _rotationTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationTypeMasterModelImpl</code>.
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

		return _rotationTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationTypeMasterModelImpl</code>.
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

		return _rotationTypeMasterLocalService.dynamicQuery(
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

		return _rotationTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rotationTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RotationTypeMaster fetchRotationTypeMaster(
		long rotationTypeMasterId) {

		return _rotationTypeMasterLocalService.fetchRotationTypeMaster(
			rotationTypeMasterId);
	}

	/**
	 * Returns the rotation type master matching the UUID and group.
	 *
	 * @param uuid the rotation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster
		fetchRotationTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _rotationTypeMasterLocalService.
			fetchRotationTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RotationTypeMaster>
		findByRotationNameByLike(String rotationTypeName) {

		return _rotationTypeMasterLocalService.findByRotationNameByLike(
			rotationTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rotationTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _rotationTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rotationTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rotationTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rotation type master with the primary key.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master
	 * @throws PortalException if a rotation type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster getRotationTypeMaster(
			long rotationTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.getRotationTypeMaster(
			rotationTypeMasterId);
	}

	/**
	 * Returns the rotation type master matching the UUID and group.
	 *
	 * @param uuid the rotation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation type master
	 * @throws PortalException if a matching rotation type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster
			getRotationTypeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationTypeMasterLocalService.
			getRotationTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of rotation type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationTypeMaster>
		getRotationTypeMasters(int start, int end) {

		return _rotationTypeMasterLocalService.getRotationTypeMasters(
			start, end);
	}

	/**
	 * Returns all the rotation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation type masters
	 * @param companyId the primary key of the company
	 * @return the matching rotation type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationTypeMaster>
		getRotationTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _rotationTypeMasterLocalService.
			getRotationTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of rotation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationTypeMaster>
		getRotationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.RotationTypeMaster> orderByComparator) {

		return _rotationTypeMasterLocalService.
			getRotationTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rotation type masters.
	 *
	 * @return the number of rotation type masters
	 */
	@Override
	public int getRotationTypeMastersCount() {
		return _rotationTypeMasterLocalService.getRotationTypeMastersCount();
	}

	/**
	 * Updates the rotation type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationTypeMaster the rotation type master
	 * @return the rotation type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.RotationTypeMaster updateRotationTypeMaster(
		gov.omsb.tms.model.RotationTypeMaster rotationTypeMaster) {

		return _rotationTypeMasterLocalService.updateRotationTypeMaster(
			rotationTypeMaster);
	}

	@Override
	public RotationTypeMasterLocalService getWrappedService() {
		return _rotationTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		RotationTypeMasterLocalService rotationTypeMasterLocalService) {

		_rotationTypeMasterLocalService = rotationTypeMasterLocalService;
	}

	private RotationTypeMasterLocalService _rotationTypeMasterLocalService;

}