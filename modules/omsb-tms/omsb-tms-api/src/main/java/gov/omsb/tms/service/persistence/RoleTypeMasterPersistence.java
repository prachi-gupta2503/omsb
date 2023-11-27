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

package gov.omsb.tms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.tms.exception.NoSuchRoleTypeMasterException;
import gov.omsb.tms.model.RoleTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMasterUtil
 * @generated
 */
@ProviderType
public interface RoleTypeMasterPersistence
	extends BasePersistence<RoleTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleTypeMasterUtil} to access the role type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the role type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where uuid = &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster[] findByUuid_PrevAndNext(
			long roleTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Removes all the role type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of role type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the role type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role type master that was removed
	 */
	public RoleTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the number of role type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster[] findByUuid_C_PrevAndNext(
			long roleTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Removes all the role type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @return the matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName);

	/**
	 * Returns a range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end);

	/**
	 * Returns an ordered range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public java.util.List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByRoleTypeNameByLike_First(
			String roleTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the first role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByRoleTypeNameByLike_First(
		String roleTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the last role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public RoleTypeMaster findByRoleTypeNameByLike_Last(
			String roleTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the last role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public RoleTypeMaster fetchByRoleTypeNameByLike_Last(
		String roleTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster[] findByRoleTypeNameByLike_PrevAndNext(
			long roleTypeMasterId, String roleTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
				orderByComparator)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Removes all the role type masters where roleTypeName LIKE &#63; from the database.
	 *
	 * @param roleTypeName the role type name
	 */
	public void removeByRoleTypeNameByLike(String roleTypeName);

	/**
	 * Returns the number of role type masters where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @return the number of matching role type masters
	 */
	public int countByRoleTypeNameByLike(String roleTypeName);

	/**
	 * Caches the role type master in the entity cache if it is enabled.
	 *
	 * @param roleTypeMaster the role type master
	 */
	public void cacheResult(RoleTypeMaster roleTypeMaster);

	/**
	 * Caches the role type masters in the entity cache if it is enabled.
	 *
	 * @param roleTypeMasters the role type masters
	 */
	public void cacheResult(java.util.List<RoleTypeMaster> roleTypeMasters);

	/**
	 * Creates a new role type master with the primary key. Does not add the role type master to the database.
	 *
	 * @param roleTypeMasterId the primary key for the new role type master
	 * @return the new role type master
	 */
	public RoleTypeMaster create(long roleTypeMasterId);

	/**
	 * Removes the role type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master that was removed
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster remove(long roleTypeMasterId)
		throws NoSuchRoleTypeMasterException;

	public RoleTypeMaster updateImpl(RoleTypeMaster roleTypeMaster);

	/**
	 * Returns the role type master with the primary key or throws a <code>NoSuchRoleTypeMasterException</code> if it could not be found.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster findByPrimaryKey(long roleTypeMasterId)
		throws NoSuchRoleTypeMasterException;

	/**
	 * Returns the role type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master, or <code>null</code> if a role type master with the primary key could not be found
	 */
	public RoleTypeMaster fetchByPrimaryKey(long roleTypeMasterId);

	/**
	 * Returns all the role type masters.
	 *
	 * @return the role type masters
	 */
	public java.util.List<RoleTypeMaster> findAll();

	/**
	 * Returns a range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of role type masters
	 */
	public java.util.List<RoleTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role type masters
	 */
	public java.util.List<RoleTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role type masters
	 */
	public java.util.List<RoleTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the role type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of role type masters.
	 *
	 * @return the number of role type masters
	 */
	public int countAll();

}