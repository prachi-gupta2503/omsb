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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.superset.dashboard.model.RoleDashboardConfig;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RoleDashboardConfig. This utility wraps
 * <code>gov.omsb.superset.dashboard.service.impl.RoleDashboardConfigLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfigLocalService
 * @generated
 */
public class RoleDashboardConfigLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.superset.dashboard.service.impl.RoleDashboardConfigLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static RoleDashboardConfig addRoleDashboardConfig(
		RoleDashboardConfig roleDashboardConfig) {

		return getService().addRoleDashboardConfig(roleDashboardConfig);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role dashboard config with the primary key. Does not add the role dashboard config to the database.
	 *
	 * @param configId the primary key for the new role dashboard config
	 * @return the new role dashboard config
	 */
	public static RoleDashboardConfig createRoleDashboardConfig(long configId) {
		return getService().createRoleDashboardConfig(configId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static RoleDashboardConfig deleteRoleDashboardConfig(long configId)
		throws PortalException {

		return getService().deleteRoleDashboardConfig(configId);
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
	public static RoleDashboardConfig deleteRoleDashboardConfig(
		RoleDashboardConfig roleDashboardConfig) {

		return getService().deleteRoleDashboardConfig(roleDashboardConfig);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static RoleDashboardConfig fetchRoleDashboardConfig(long configId) {
		return getService().fetchRoleDashboardConfig(configId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role dashboard config with the primary key.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws PortalException if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig getRoleDashboardConfig(long configId)
		throws PortalException {

		return getService().getRoleDashboardConfig(configId);
	}

	public static List<RoleDashboardConfig>
		getRoleDashboardConfigByGroupIdAndCompanyId(
			long groupId, long companyId) {

		return getService().getRoleDashboardConfigByGroupIdAndCompanyId(
			groupId, companyId);
	}

	public static List<RoleDashboardConfig> getRoleDashboardConfigByRoleId(
		long roleId) {

		return getService().getRoleDashboardConfigByRoleId(roleId);
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
	public static List<RoleDashboardConfig> getRoleDashboardConfigs(
		int start, int end) {

		return getService().getRoleDashboardConfigs(start, end);
	}

	/**
	 * Returns the number of role dashboard configs.
	 *
	 * @return the number of role dashboard configs
	 */
	public static int getRoleDashboardConfigsCount() {
		return getService().getRoleDashboardConfigsCount();
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
	public static RoleDashboardConfig updateRoleDashboardConfig(
		RoleDashboardConfig roleDashboardConfig) {

		return getService().updateRoleDashboardConfig(roleDashboardConfig);
	}

	public static RoleDashboardConfigLocalService getService() {
		return _service;
	}

	private static volatile RoleDashboardConfigLocalService _service;

}