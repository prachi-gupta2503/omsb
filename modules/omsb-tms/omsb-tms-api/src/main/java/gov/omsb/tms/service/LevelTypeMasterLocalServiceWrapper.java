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
 * Provides a wrapper for {@link LevelTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMasterLocalService
 * @generated
 */
public class LevelTypeMasterLocalServiceWrapper
	implements LevelTypeMasterLocalService,
			   ServiceWrapper<LevelTypeMasterLocalService> {

	public LevelTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public LevelTypeMasterLocalServiceWrapper(
		LevelTypeMasterLocalService levelTypeMasterLocalService) {

		_levelTypeMasterLocalService = levelTypeMasterLocalService;
	}

	/**
	 * Adds the level type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was added
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster addLevelTypeMaster(
		gov.omsb.tms.model.LevelTypeMaster levelTypeMaster) {

		return _levelTypeMasterLocalService.addLevelTypeMaster(levelTypeMaster);
	}

	/**
	 * Creates a new level type master with the primary key. Does not add the level type master to the database.
	 *
	 * @param LevelTypeMasterId the primary key for the new level type master
	 * @return the new level type master
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster createLevelTypeMaster(
		long LevelTypeMasterId) {

		return _levelTypeMasterLocalService.createLevelTypeMaster(
			LevelTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the level type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster deleteLevelTypeMaster(
		gov.omsb.tms.model.LevelTypeMaster levelTypeMaster) {

		return _levelTypeMasterLocalService.deleteLevelTypeMaster(
			levelTypeMaster);
	}

	/**
	 * Deletes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws PortalException if a level type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster deleteLevelTypeMaster(
			long LevelTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.deleteLevelTypeMaster(
			LevelTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _levelTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _levelTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _levelTypeMasterLocalService.dynamicQuery();
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

		return _levelTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
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

		return _levelTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
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

		return _levelTypeMasterLocalService.dynamicQuery(
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

		return _levelTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _levelTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LevelTypeMaster fetchLevelTypeMaster(
		long LevelTypeMasterId) {

		return _levelTypeMasterLocalService.fetchLevelTypeMaster(
			LevelTypeMasterId);
	}

	/**
	 * Returns the level type master matching the UUID and group.
	 *
	 * @param uuid the level type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster
		fetchLevelTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _levelTypeMasterLocalService.
			fetchLevelTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.LevelTypeMaster>
		findByLevelTypeNameByLike(String levelTypeName) {

		return _levelTypeMasterLocalService.findByLevelTypeNameByLike(
			levelTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _levelTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _levelTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _levelTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the level type master with the primary key.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master
	 * @throws PortalException if a level type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster getLevelTypeMaster(
			long LevelTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.getLevelTypeMaster(
			LevelTypeMasterId);
	}

	/**
	 * Returns the level type master matching the UUID and group.
	 *
	 * @param uuid the level type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching level type master
	 * @throws PortalException if a matching level type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster
			getLevelTypeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.getLevelTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of level type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LevelTypeMaster>
		getLevelTypeMasters(int start, int end) {

		return _levelTypeMasterLocalService.getLevelTypeMasters(start, end);
	}

	/**
	 * Returns all the level type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the level type masters
	 * @param companyId the primary key of the company
	 * @return the matching level type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LevelTypeMaster>
		getLevelTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _levelTypeMasterLocalService.
			getLevelTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of level type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the level type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching level type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LevelTypeMaster>
		getLevelTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LevelTypeMaster> orderByComparator) {

		return _levelTypeMasterLocalService.
			getLevelTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of level type masters.
	 *
	 * @return the number of level type masters
	 */
	@Override
	public int getLevelTypeMastersCount() {
		return _levelTypeMasterLocalService.getLevelTypeMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _levelTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _levelTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the level type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LevelTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param levelTypeMaster the level type master
	 * @return the level type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.LevelTypeMaster updateLevelTypeMaster(
		gov.omsb.tms.model.LevelTypeMaster levelTypeMaster) {

		return _levelTypeMasterLocalService.updateLevelTypeMaster(
			levelTypeMaster);
	}

	@Override
	public LevelTypeMasterLocalService getWrappedService() {
		return _levelTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LevelTypeMasterLocalService levelTypeMasterLocalService) {

		_levelTypeMasterLocalService = levelTypeMasterLocalService;
	}

	private LevelTypeMasterLocalService _levelTypeMasterLocalService;

}