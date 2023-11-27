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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.LevelTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the level type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.LevelTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LevelTypeMasterPersistence
 * @generated
 */
public class LevelTypeMasterUtil {

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
	public static void clearCache(LevelTypeMaster levelTypeMaster) {
		getPersistence().clearCache(levelTypeMaster);
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
	public static Map<Serializable, LevelTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LevelTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LevelTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LevelTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LevelTypeMaster update(LevelTypeMaster levelTypeMaster) {
		return getPersistence().update(levelTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LevelTypeMaster update(
		LevelTypeMaster levelTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(levelTypeMaster, serviceContext);
	}

	/**
	 * Returns all the level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching level type masters
	 */
	public static List<LevelTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<LevelTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByUuid_First(
			String uuid, OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where uuid = &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster[] findByUuid_PrevAndNext(
			long LevelTypeMasterId, String uuid,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			LevelTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the level type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of level type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching level type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the level type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the level type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the level type master that was removed
	 */
	public static LevelTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of level type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching level type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching level type masters
	 */
	public static List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<LevelTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static LevelTypeMaster[] findByUuid_C_PrevAndNext(
			long LevelTypeMasterId, String uuid, long companyId,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			LevelTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the level type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of level type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching level type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the matching level type masters
	 */
	public static List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName) {

		return getPersistence().findByLevelTypeNameByLike(levelTypeName);
	}

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
	public static List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end) {

		return getPersistence().findByLevelTypeNameByLike(
			levelTypeName, start, end);
	}

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
	public static List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().findByLevelTypeNameByLike(
			levelTypeName, start, end, orderByComparator);
	}

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
	public static List<LevelTypeMaster> findByLevelTypeNameByLike(
		String levelTypeName, int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLevelTypeNameByLike(
			levelTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByLevelTypeNameByLike_First(
			String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByLevelTypeNameByLike_First(
			levelTypeName, orderByComparator);
	}

	/**
	 * Returns the first level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByLevelTypeNameByLike_First(
		String levelTypeName,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByLevelTypeNameByLike_First(
			levelTypeName, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master
	 * @throws NoSuchLevelTypeMasterException if a matching level type master could not be found
	 */
	public static LevelTypeMaster findByLevelTypeNameByLike_Last(
			String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByLevelTypeNameByLike_Last(
			levelTypeName, orderByComparator);
	}

	/**
	 * Returns the last level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching level type master, or <code>null</code> if a matching level type master could not be found
	 */
	public static LevelTypeMaster fetchByLevelTypeNameByLike_Last(
		String levelTypeName,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().fetchByLevelTypeNameByLike_Last(
			levelTypeName, orderByComparator);
	}

	/**
	 * Returns the level type masters before and after the current level type master in the ordered set where levelTypeName LIKE &#63;.
	 *
	 * @param LevelTypeMasterId the primary key of the current level type master
	 * @param levelTypeName the level type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster[] findByLevelTypeNameByLike_PrevAndNext(
			long LevelTypeMasterId, String levelTypeName,
			OrderByComparator<LevelTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByLevelTypeNameByLike_PrevAndNext(
			LevelTypeMasterId, levelTypeName, orderByComparator);
	}

	/**
	 * Removes all the level type masters where levelTypeName LIKE &#63; from the database.
	 *
	 * @param levelTypeName the level type name
	 */
	public static void removeByLevelTypeNameByLike(String levelTypeName) {
		getPersistence().removeByLevelTypeNameByLike(levelTypeName);
	}

	/**
	 * Returns the number of level type masters where levelTypeName LIKE &#63;.
	 *
	 * @param levelTypeName the level type name
	 * @return the number of matching level type masters
	 */
	public static int countByLevelTypeNameByLike(String levelTypeName) {
		return getPersistence().countByLevelTypeNameByLike(levelTypeName);
	}

	/**
	 * Caches the level type master in the entity cache if it is enabled.
	 *
	 * @param levelTypeMaster the level type master
	 */
	public static void cacheResult(LevelTypeMaster levelTypeMaster) {
		getPersistence().cacheResult(levelTypeMaster);
	}

	/**
	 * Caches the level type masters in the entity cache if it is enabled.
	 *
	 * @param levelTypeMasters the level type masters
	 */
	public static void cacheResult(List<LevelTypeMaster> levelTypeMasters) {
		getPersistence().cacheResult(levelTypeMasters);
	}

	/**
	 * Creates a new level type master with the primary key. Does not add the level type master to the database.
	 *
	 * @param LevelTypeMasterId the primary key for the new level type master
	 * @return the new level type master
	 */
	public static LevelTypeMaster create(long LevelTypeMasterId) {
		return getPersistence().create(LevelTypeMasterId);
	}

	/**
	 * Removes the level type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master that was removed
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster remove(long LevelTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().remove(LevelTypeMasterId);
	}

	public static LevelTypeMaster updateImpl(LevelTypeMaster levelTypeMaster) {
		return getPersistence().updateImpl(levelTypeMaster);
	}

	/**
	 * Returns the level type master with the primary key or throws a <code>NoSuchLevelTypeMasterException</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master
	 * @throws NoSuchLevelTypeMasterException if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster findByPrimaryKey(long LevelTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchLevelTypeMasterException {

		return getPersistence().findByPrimaryKey(LevelTypeMasterId);
	}

	/**
	 * Returns the level type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LevelTypeMasterId the primary key of the level type master
	 * @return the level type master, or <code>null</code> if a level type master with the primary key could not be found
	 */
	public static LevelTypeMaster fetchByPrimaryKey(long LevelTypeMasterId) {
		return getPersistence().fetchByPrimaryKey(LevelTypeMasterId);
	}

	/**
	 * Returns all the level type masters.
	 *
	 * @return the level type masters
	 */
	public static List<LevelTypeMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LevelTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LevelTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LevelTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LevelTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the level type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of level type masters.
	 *
	 * @return the number of level type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LevelTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LevelTypeMasterPersistence _persistence;

}