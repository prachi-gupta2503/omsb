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

package gov.omsb.superset.dashboard.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.superset.dashboard.model.RoleDashboardConfig;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the role dashboard config service. This utility wraps <code>gov.omsb.superset.dashboard.service.persistence.impl.RoleDashboardConfigPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfigPersistence
 * @generated
 */
public class RoleDashboardConfigUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RoleDashboardConfig roleDashboardConfig) {
		getPersistence().clearCache(roleDashboardConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, RoleDashboardConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RoleDashboardConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoleDashboardConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoleDashboardConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RoleDashboardConfig update(
		RoleDashboardConfig roleDashboardConfig) {

		return getPersistence().update(roleDashboardConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RoleDashboardConfig update(
		RoleDashboardConfig roleDashboardConfig,
		ServiceContext serviceContext) {

		return getPersistence().update(roleDashboardConfig, serviceContext);
	}

	/**
	 * Returns all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId) {

		return getPersistence().findByGroupIdAndCompanyId(groupId, companyId);
	}

	/**
	 * Returns a range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByGroupIdAndCompanyId(
			groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().findByGroupIdAndCompanyId(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndCompanyId(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig findByGroupIdAndCompanyId_First(
			long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByGroupIdAndCompanyId_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig fetchByGroupIdAndCompanyId_First(
		long groupId, long companyId,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().fetchByGroupIdAndCompanyId_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig findByGroupIdAndCompanyId_Last(
			long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByGroupIdAndCompanyId_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig fetchByGroupIdAndCompanyId_Last(
		long groupId, long companyId,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().fetchByGroupIdAndCompanyId_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the role dashboard configs before and after the current role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param configId the primary key of the current role dashboard config
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig[] findByGroupIdAndCompanyId_PrevAndNext(
			long configId, long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByGroupIdAndCompanyId_PrevAndNext(
			configId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the role dashboard configs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByGroupIdAndCompanyId(
		long groupId, long companyId) {

		getPersistence().removeByGroupIdAndCompanyId(groupId, companyId);
	}

	/**
	 * Returns the number of role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching role dashboard configs
	 */
	public static int countByGroupIdAndCompanyId(long groupId, long companyId) {
		return getPersistence().countByGroupIdAndCompanyId(groupId, companyId);
	}

	/**
	 * Returns all the role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByRoleId(long roleId) {
		return getPersistence().findByRoleId(roleId);
	}

	/**
	 * Returns a range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end) {

		return getPersistence().findByRoleId(roleId, start, end);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role dashboard configs
	 */
	public static List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRoleId(
			roleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig findByRoleId_First(
			long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig fetchByRoleId_First(
		long roleId, OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().fetchByRoleId_First(roleId, orderByComparator);
	}

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig findByRoleId_Last(
			long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public static RoleDashboardConfig fetchByRoleId_Last(
		long roleId, OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().fetchByRoleId_Last(roleId, orderByComparator);
	}

	/**
	 * Returns the role dashboard configs before and after the current role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param configId the primary key of the current role dashboard config
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig[] findByRoleId_PrevAndNext(
			long configId, long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByRoleId_PrevAndNext(
			configId, roleId, orderByComparator);
	}

	/**
	 * Removes all the role dashboard configs where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	public static void removeByRoleId(long roleId) {
		getPersistence().removeByRoleId(roleId);
	}

	/**
	 * Returns the number of role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching role dashboard configs
	 */
	public static int countByRoleId(long roleId) {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	 * Caches the role dashboard config in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfig the role dashboard config
	 */
	public static void cacheResult(RoleDashboardConfig roleDashboardConfig) {
		getPersistence().cacheResult(roleDashboardConfig);
	}

	/**
	 * Caches the role dashboard configs in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfigs the role dashboard configs
	 */
	public static void cacheResult(
		List<RoleDashboardConfig> roleDashboardConfigs) {

		getPersistence().cacheResult(roleDashboardConfigs);
	}

	/**
	 * Creates a new role dashboard config with the primary key. Does not add the role dashboard config to the database.
	 *
	 * @param configId the primary key for the new role dashboard config
	 * @return the new role dashboard config
	 */
	public static RoleDashboardConfig create(long configId) {
		return getPersistence().create(configId);
	}

	/**
	 * Removes the role dashboard config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config that was removed
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig remove(long configId)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().remove(configId);
	}

	public static RoleDashboardConfig updateImpl(
		RoleDashboardConfig roleDashboardConfig) {

		return getPersistence().updateImpl(roleDashboardConfig);
	}

	/**
	 * Returns the role dashboard config with the primary key or throws a <code>NoSuchRoleDashboardConfigException</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig findByPrimaryKey(long configId)
		throws gov.omsb.superset.dashboard.exception.
			NoSuchRoleDashboardConfigException {

		return getPersistence().findByPrimaryKey(configId);
	}

	/**
	 * Returns the role dashboard config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config, or <code>null</code> if a role dashboard config with the primary key could not be found
	 */
	public static RoleDashboardConfig fetchByPrimaryKey(long configId) {
		return getPersistence().fetchByPrimaryKey(configId);
	}

	/**
	 * Returns all the role dashboard configs.
	 *
	 * @return the role dashboard configs
	 */
	public static List<RoleDashboardConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of role dashboard configs
	 */
	public static List<RoleDashboardConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role dashboard configs
	 */
	public static List<RoleDashboardConfig> findAll(
		int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role dashboard configs
	 */
	public static List<RoleDashboardConfig> findAll(
		int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the role dashboard configs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of role dashboard configs.
	 *
	 * @return the number of role dashboard configs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoleDashboardConfigPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoleDashboardConfigPersistence _persistence;

}