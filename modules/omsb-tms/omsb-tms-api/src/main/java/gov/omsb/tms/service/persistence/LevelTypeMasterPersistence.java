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

import gov.omsb.tms.exception.NoSuchLevelTypeMasterException;
import gov.omsb.tms.model.LevelTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the level type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMasterUtil
 * @generated
 */
@ProviderType
public interface LevelTypeMasterPersistence
	extends BasePersistence<LevelTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LevelTypeMasterUtil} to access the level type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where uuid = &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster[] findByUuid_PrevAndNext(
			long LevelTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Removes all the level type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching level type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the level type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the level type master that was removed
	 */
	public LevelTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the number of level type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching level type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster[] findByUuid_C_PrevAndNext(
			long LevelTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Removes all the level type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching level type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName);

	/**
	 * Returns a range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end);

	/**
	 * Returns an ordered range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param levelTypeName the level type name
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching level type masters
	 */
	public java.util.List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByLevelTypeNameByLike_First(
			String levelTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByLevelTypeNameByLike_First(
		String levelTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public LevelTypeMaster findByLevelTypeNameByLike_Last(
			String levelTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public LevelTypeMaster fetchByLevelTypeNameByLike_Last(
		String levelTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster[] findByLevelTypeNameByLike_PrevAndNext(
			long LevelTypeMasterId, String levelTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
				orderByComparator)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Removes all the level type masters where levelTypeName LIKE &#63; from the database.
	 *
	 * @param levelTypeName the level type name
	 */
	public void removeByLevelTypeNameByLike(String levelTypeName);

	/**
	 * Returns the number of level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the number of matching level type masters
	 */
	public int countByLevelTypeNameByLike(String levelTypeName);

	/**
	 * Caches the level type master in the entity cache if it is enabled.
	 *
	 * @param levelTypeMaster the level type master
	 */
	public void cacheResult(LevelTypeMaster levelTypeMaster);

	/**
	 * Caches the level type masters in the entity cache if it is enabled.
	 *
	 * @param levelTypeMasters the level type masters
	 */
	public void cacheResult(java.util.List<LevelTypeMaster> levelTypeMasters);

	/**
	 * Creates a new level type master with the primary key. Does not add the level type master to the database.
	 *
	 * @param LevelTypeMasterId the primary key for the new level type master
	 * @return the new level type master
	 */
	public LevelTypeMaster create(long LevelTypeMasterId);

	/**
	 * Removes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster remove(long LevelTypeMasterId)
		throws NoSuchLevelTypeMasterException;

	public LevelTypeMaster updateImpl(LevelTypeMaster levelTypeMaster);

	/**
	 * Returns the level type master with the primary key or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster findByPrimaryKey(long LevelTypeMasterId)
		throws NoSuchLevelTypeMasterException;

	/**
	 * Returns the level type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master, or <code>null</code> if a level type master with the primary key could not be found
	 */
	public LevelTypeMaster fetchByPrimaryKey(long LevelTypeMasterId);

	/**
	 * Returns all the level type masters.
	 *
	 * @return the level type masters
	 */
	public java.util.List<LevelTypeMaster> findAll();

	/**
	 * Returns a range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @return the range of level type masters
	 */
	public java.util.List<LevelTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of level type masters
	 */
	public java.util.List<LevelTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the level type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level type masters
	 * @param end the upper bound of the range of level type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of level type masters
	 */
	public java.util.List<LevelTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the level type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of level type masters.
	 *
	 * @return the number of level type masters
	 */
	public int countAll();

}