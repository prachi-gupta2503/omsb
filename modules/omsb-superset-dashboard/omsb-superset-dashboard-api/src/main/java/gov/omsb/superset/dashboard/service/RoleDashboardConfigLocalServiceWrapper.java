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

package gov.omsb.superset.dashboard.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoleDashboardConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfigLocalService
 * @generated
 */
public class RoleDashboardConfigLocalServiceWrapper
	implements RoleDashboardConfigLocalService,
			   ServiceWrapper<RoleDashboardConfigLocalService> {

	public RoleDashboardConfigLocalServiceWrapper() {
		this(null);
	}

	public RoleDashboardConfigLocalServiceWrapper(
		RoleDashboardConfigLocalService roleDashboardConfigLocalService) {

		_roleDashboardConfigLocalService = roleDashboardConfigLocalService;
	}

	/**
	 * Adds the role dashboard config to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleDashboardConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleDashboardConfig the role dashboard config
	 * @return the role dashboard config that was added
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
		addRoleDashboardConfig(
			gov.omsb.superset.dashboard.model.RoleDashboardConfig
				roleDashboardConfig) {

		return _roleDashboardConfigLocalService.addRoleDashboardConfig(
			roleDashboardConfig);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleDashboardConfigLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new role dashboard config with the primary key. Does not add the role dashboard config to the database.
	 *
	 * @param configId the primary key for the new role dashboard config
	 * @return the new role dashboard config
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
		createRoleDashboardConfig(long configId) {

		return _roleDashboardConfigLocalService.createRoleDashboardConfig(
			configId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleDashboardConfigLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the role dashboard config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleDashboardConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config that was removed
	 * @throws PortalException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
			deleteRoleDashboardConfig(long configId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleDashboardConfigLocalService.deleteRoleDashboardConfig(
			configId);
	}

	/**
	 * Deletes the role dashboard config from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleDashboardConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleDashboardConfig the role dashboard config
	 * @return the role dashboard config that was removed
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
		deleteRoleDashboardConfig(
			gov.omsb.superset.dashboard.model.RoleDashboardConfig
				roleDashboardConfig) {

		return _roleDashboardConfigLocalService.deleteRoleDashboardConfig(
			roleDashboardConfig);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _roleDashboardConfigLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _roleDashboardConfigLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roleDashboardConfigLocalService.dynamicQuery();
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

		return _roleDashboardConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.superset.dashboard.model.impl.RoleDashboardConfigModelImpl</code>.
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

		return _roleDashboardConfigLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.superset.dashboard.model.impl.RoleDashboardConfigModelImpl</code>.
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

		return _roleDashboardConfigLocalService.dynamicQuery(
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

		return _roleDashboardConfigLocalService.dynamicQueryCount(dynamicQuery);
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

		return _roleDashboardConfigLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
		fetchRoleDashboardConfig(long configId) {

		return _roleDashboardConfigLocalService.fetchRoleDashboardConfig(
			configId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roleDashboardConfigLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roleDashboardConfigLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleDashboardConfigLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleDashboardConfigLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the role dashboard config with the primary key.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws PortalException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
			getRoleDashboardConfig(long configId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleDashboardConfigLocalService.getRoleDashboardConfig(
			configId);
	}

	@Override
	public java.util.List<gov.omsb.superset.dashboard.model.RoleDashboardConfig>
		getRoleDashboardConfigByGroupIdAndCompanyId(
			long groupId, long companyId) {

		return _roleDashboardConfigLocalService.
			getRoleDashboardConfigByGroupIdAndCompanyId(groupId, companyId);
	}

	@Override
	public java.util.List<gov.omsb.superset.dashboard.model.RoleDashboardConfig>
		getRoleDashboardConfigByRoleId(long roleId) {

		return _roleDashboardConfigLocalService.getRoleDashboardConfigByRoleId(
			roleId);
	}

	/**
	 * Returns a range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.superset.dashboard.model.impl.RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of role dashboard configs
	 */
	@Override
	public java.util.List<gov.omsb.superset.dashboard.model.RoleDashboardConfig>
		getRoleDashboardConfigs(int start, int end) {

		return _roleDashboardConfigLocalService.getRoleDashboardConfigs(
			start, end);
	}

	/**
	 * Returns the number of role dashboard configs.
	 *
	 * @return the number of role dashboard configs
	 */
	@Override
	public int getRoleDashboardConfigsCount() {
		return _roleDashboardConfigLocalService.getRoleDashboardConfigsCount();
	}

	/**
	 * Updates the role dashboard config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleDashboardConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleDashboardConfig the role dashboard config
	 * @return the role dashboard config that was updated
	 */
	@Override
	public gov.omsb.superset.dashboard.model.RoleDashboardConfig
		updateRoleDashboardConfig(
			gov.omsb.superset.dashboard.model.RoleDashboardConfig
				roleDashboardConfig) {

		return _roleDashboardConfigLocalService.updateRoleDashboardConfig(
			roleDashboardConfig);
	}

	@Override
	public RoleDashboardConfigLocalService getWrappedService() {
		return _roleDashboardConfigLocalService;
	}

	@Override
	public void setWrappedService(
		RoleDashboardConfigLocalService roleDashboardConfigLocalService) {

		_roleDashboardConfigLocalService = roleDashboardConfigLocalService;
	}

	private RoleDashboardConfigLocalService _roleDashboardConfigLocalService;

}