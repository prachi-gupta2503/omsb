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

package gov.omsb.form.builder.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.form.builder.model.RangeOptionMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the range option master service. This utility wraps <code>gov.omsb.form.builder.service.persistence.impl.RangeOptionMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RangeOptionMasterPersistence
 * @generated
 */
public class RangeOptionMasterUtil {

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
	public static void clearCache(RangeOptionMaster rangeOptionMaster) {
		getPersistence().clearCache(rangeOptionMaster);
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
	public static Map<Serializable, RangeOptionMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RangeOptionMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RangeOptionMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RangeOptionMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RangeOptionMaster update(
		RangeOptionMaster rangeOptionMaster) {

		return getPersistence().update(rangeOptionMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RangeOptionMaster update(
		RangeOptionMaster rangeOptionMaster, ServiceContext serviceContext) {

		return getPersistence().update(rangeOptionMaster, serviceContext);
	}

	/**
	 * Returns all the range option masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public static RangeOptionMaster findByUuid_First(
			String uuid, OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUuid_First(
		String uuid, OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public static RangeOptionMaster findByUuid_Last(
			String uuid, OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the range option masters before and after the current range option master in the ordered set where uuid = &#63;.
	 *
	 * @param rangeOptionId the primary key of the current range option master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public static RangeOptionMaster[] findByUuid_PrevAndNext(
			long rangeOptionId, String uuid,
			OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			rangeOptionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the range option masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of range option masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching range option masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRangeOptionMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public static RangeOptionMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the range option master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the range option master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the range option master that was removed
	 */
	public static RangeOptionMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of range option masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching range option masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching range option masters
	 */
	public static List<RangeOptionMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public static RangeOptionMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master
	 * @throws NoSuchRangeOptionMasterException if a matching range option master could not be found
	 */
	public static RangeOptionMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	public static RangeOptionMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the range option masters before and after the current range option master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rangeOptionId the primary key of the current range option master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public static RangeOptionMaster[] findByUuid_C_PrevAndNext(
			long rangeOptionId, String uuid, long companyId,
			OrderByComparator<RangeOptionMaster> orderByComparator)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rangeOptionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the range option masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of range option masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching range option masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the range option master in the entity cache if it is enabled.
	 *
	 * @param rangeOptionMaster the range option master
	 */
	public static void cacheResult(RangeOptionMaster rangeOptionMaster) {
		getPersistence().cacheResult(rangeOptionMaster);
	}

	/**
	 * Caches the range option masters in the entity cache if it is enabled.
	 *
	 * @param rangeOptionMasters the range option masters
	 */
	public static void cacheResult(List<RangeOptionMaster> rangeOptionMasters) {
		getPersistence().cacheResult(rangeOptionMasters);
	}

	/**
	 * Creates a new range option master with the primary key. Does not add the range option master to the database.
	 *
	 * @param rangeOptionId the primary key for the new range option master
	 * @return the new range option master
	 */
	public static RangeOptionMaster create(long rangeOptionId) {
		return getPersistence().create(rangeOptionId);
	}

	/**
	 * Removes the range option master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master that was removed
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public static RangeOptionMaster remove(long rangeOptionId)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().remove(rangeOptionId);
	}

	public static RangeOptionMaster updateImpl(
		RangeOptionMaster rangeOptionMaster) {

		return getPersistence().updateImpl(rangeOptionMaster);
	}

	/**
	 * Returns the range option master with the primary key or throws a <code>NoSuchRangeOptionMasterException</code> if it could not be found.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master
	 * @throws NoSuchRangeOptionMasterException if a range option master with the primary key could not be found
	 */
	public static RangeOptionMaster findByPrimaryKey(long rangeOptionId)
		throws gov.omsb.form.builder.exception.
			NoSuchRangeOptionMasterException {

		return getPersistence().findByPrimaryKey(rangeOptionId);
	}

	/**
	 * Returns the range option master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master, or <code>null</code> if a range option master with the primary key could not be found
	 */
	public static RangeOptionMaster fetchByPrimaryKey(long rangeOptionId) {
		return getPersistence().fetchByPrimaryKey(rangeOptionId);
	}

	/**
	 * Returns all the range option masters.
	 *
	 * @return the range option masters
	 */
	public static List<RangeOptionMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of range option masters
	 */
	public static List<RangeOptionMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of range option masters
	 */
	public static List<RangeOptionMaster> findAll(
		int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of range option masters
	 */
	public static List<RangeOptionMaster> findAll(
		int start, int end,
		OrderByComparator<RangeOptionMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the range option masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of range option masters.
	 *
	 * @return the number of range option masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RangeOptionMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RangeOptionMasterPersistence _persistence;

}