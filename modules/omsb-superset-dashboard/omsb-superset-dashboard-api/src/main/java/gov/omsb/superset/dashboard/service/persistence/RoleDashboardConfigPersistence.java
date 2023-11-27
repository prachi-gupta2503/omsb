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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.superset.dashboard.exception.NoSuchRoleDashboardConfigException;
import gov.omsb.superset.dashboard.model.RoleDashboardConfig;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role dashboard config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleDashboardConfigUtil
 * @generated
 */
@ProviderType
public interface RoleDashboardConfigPersistence
	extends BasePersistence<RoleDashboardConfig> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleDashboardConfigUtil} to access the role dashboard config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching role dashboard configs
	 */
	public java.util.List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId);

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
	public java.util.List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

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
	public java.util.List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig findByGroupIdAndCompanyId_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig fetchByGroupIdAndCompanyId_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig findByGroupIdAndCompanyId_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig fetchByGroupIdAndCompanyId_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

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
	public RoleDashboardConfig[] findByGroupIdAndCompanyId_PrevAndNext(
			long configId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Removes all the role dashboard configs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupIdAndCompanyId(long groupId, long companyId);

	/**
	 * Returns the number of role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching role dashboard configs
	 */
	public int countByGroupIdAndCompanyId(long groupId, long companyId);

	/**
	 * Returns all the role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching role dashboard configs
	 */
	public java.util.List<RoleDashboardConfig> findByRoleId(long roleId);

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
	public java.util.List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end);

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
	public java.util.List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

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
	public java.util.List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig findByRoleId_First(
			long roleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig fetchByRoleId_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig findByRoleId_Last(
			long roleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	public RoleDashboardConfig fetchByRoleId_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

	/**
	 * Returns the role dashboard configs before and after the current role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param configId the primary key of the current role dashboard config
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public RoleDashboardConfig[] findByRoleId_PrevAndNext(
			long configId, long roleId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Removes all the role dashboard configs where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	public void removeByRoleId(long roleId);

	/**
	 * Returns the number of role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching role dashboard configs
	 */
	public int countByRoleId(long roleId);

	/**
	 * Caches the role dashboard config in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfig the role dashboard config
	 */
	public void cacheResult(RoleDashboardConfig roleDashboardConfig);

	/**
	 * Caches the role dashboard configs in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfigs the role dashboard configs
	 */
	public void cacheResult(
		java.util.List<RoleDashboardConfig> roleDashboardConfigs);

	/**
	 * Creates a new role dashboard config with the primary key. Does not add the role dashboard config to the database.
	 *
	 * @param configId the primary key for the new role dashboard config
	 * @return the new role dashboard config
	 */
	public RoleDashboardConfig create(long configId);

	/**
	 * Removes the role dashboard config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config that was removed
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public RoleDashboardConfig remove(long configId)
		throws NoSuchRoleDashboardConfigException;

	public RoleDashboardConfig updateImpl(
		RoleDashboardConfig roleDashboardConfig);

	/**
	 * Returns the role dashboard config with the primary key or throws a <code>NoSuchRoleDashboardConfigException</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	public RoleDashboardConfig findByPrimaryKey(long configId)
		throws NoSuchRoleDashboardConfigException;

	/**
	 * Returns the role dashboard config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config, or <code>null</code> if a role dashboard config with the primary key could not be found
	 */
	public RoleDashboardConfig fetchByPrimaryKey(long configId);

	/**
	 * Returns all the role dashboard configs.
	 *
	 * @return the role dashboard configs
	 */
	public java.util.List<RoleDashboardConfig> findAll();

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
	public java.util.List<RoleDashboardConfig> findAll(int start, int end);

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
	public java.util.List<RoleDashboardConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator);

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
	public java.util.List<RoleDashboardConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleDashboardConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the role dashboard configs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of role dashboard configs.
	 *
	 * @return the number of role dashboard configs
	 */
	public int countAll();

}