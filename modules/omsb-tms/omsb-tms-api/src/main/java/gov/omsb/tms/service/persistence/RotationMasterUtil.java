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

import gov.omsb.tms.model.RotationMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rotation master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RotationMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationMasterPersistence
 * @generated
 */
public class RotationMasterUtil {

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
	public static void clearCache(RotationMaster rotationMaster) {
		getPersistence().clearCache(rotationMaster);
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
	public static Map<Serializable, RotationMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RotationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RotationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RotationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RotationMaster update(RotationMaster rotationMaster) {
		return getPersistence().update(rotationMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RotationMaster update(
		RotationMaster rotationMaster, ServiceContext serviceContext) {

		return getPersistence().update(rotationMaster, serviceContext);
	}

	/**
	 * Returns all the rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation masters
	 */
	public static List<RotationMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByUuid_First(
			String uuid, OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUuid_First(
		String uuid, OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByUuid_Last(
			String uuid, OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster[] findByUuid_PrevAndNext(
			long rotationMasterId, String uuid,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			rotationMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the rotation masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the rotation master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation master that was removed
	 */
	public static RotationMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation masters
	 */
	public static List<RotationMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster[] findByUuid_C_PrevAndNext(
			long rotationMasterId, String uuid, long companyId,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rotationMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the rotation masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the matching rotation masters
	 */
	public static List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus) {

		return getPersistence().findByRotationStatus(rotationStatus);
	}

	/**
	 * Returns a range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end) {

		return getPersistence().findByRotationStatus(
			rotationStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findByRotationStatus(
			rotationStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRotationStatus(
			rotationStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationStatus_First(
			Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationStatus_First(
			rotationStatus, orderByComparator);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationStatus_First(
		Boolean rotationStatus,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationStatus_First(
			rotationStatus, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationStatus_Last(
			Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationStatus_Last(
			rotationStatus, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationStatus_Last(
		Boolean rotationStatus,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationStatus_Last(
			rotationStatus, orderByComparator);
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster[] findByRotationStatus_PrevAndNext(
			long rotationMasterId, Boolean rotationStatus,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationStatus_PrevAndNext(
			rotationMasterId, rotationStatus, orderByComparator);
	}

	/**
	 * Removes all the rotation masters where rotationStatus = &#63; from the database.
	 *
	 * @param rotationStatus the rotation status
	 */
	public static void removeByRotationStatus(Boolean rotationStatus) {
		getPersistence().removeByRotationStatus(rotationStatus);
	}

	/**
	 * Returns the number of rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the number of matching rotation masters
	 */
	public static int countByRotationStatus(Boolean rotationStatus) {
		return getPersistence().countByRotationStatus(rotationStatus);
	}

	/**
	 * Returns all the rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the matching rotation masters
	 */
	public static List<RotationMaster> findByRotationNameByLike(
		String rotationName) {

		return getPersistence().findByRotationNameByLike(rotationName);
	}

	/**
	 * Returns a range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end) {

		return getPersistence().findByRotationNameByLike(
			rotationName, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findByRotationNameByLike(
			rotationName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRotationNameByLike(
			rotationName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationNameByLike_First(
			String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationNameByLike_First(
			rotationName, orderByComparator);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationNameByLike_First(
		String rotationName,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationNameByLike_First(
			rotationName, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationNameByLike_Last(
			String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationNameByLike_Last(
			rotationName, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationNameByLike_Last(
		String rotationName,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationNameByLike_Last(
			rotationName, orderByComparator);
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster[] findByRotationNameByLike_PrevAndNext(
			long rotationMasterId, String rotationName,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationNameByLike_PrevAndNext(
			rotationMasterId, rotationName, orderByComparator);
	}

	/**
	 * Removes all the rotation masters where rotationName LIKE &#63; from the database.
	 *
	 * @param rotationName the rotation name
	 */
	public static void removeByRotationNameByLike(String rotationName) {
		getPersistence().removeByRotationNameByLike(rotationName);
	}

	/**
	 * Returns the number of rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the number of matching rotation masters
	 */
	public static int countByRotationNameByLike(String rotationName) {
		return getPersistence().countByRotationNameByLike(rotationName);
	}

	/**
	 * Returns all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the matching rotation masters
	 */
	public static List<RotationMaster> findByRotationCodeByLike(
		String rotationCode) {

		return getPersistence().findByRotationCodeByLike(rotationCode);
	}

	/**
	 * Returns a range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end) {

		return getPersistence().findByRotationCodeByLike(
			rotationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findByRotationCodeByLike(
			rotationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public static List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRotationCodeByLike(
			rotationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationCodeByLike_First(
			String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationCodeByLike_First(
			rotationCode, orderByComparator);
	}

	/**
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationCodeByLike_First(
		String rotationCode,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationCodeByLike_First(
			rotationCode, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public static RotationMaster findByRotationCodeByLike_Last(
			String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationCodeByLike_Last(
			rotationCode, orderByComparator);
	}

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public static RotationMaster fetchByRotationCodeByLike_Last(
		String rotationCode,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().fetchByRotationCodeByLike_Last(
			rotationCode, orderByComparator);
	}

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster[] findByRotationCodeByLike_PrevAndNext(
			long rotationMasterId, String rotationCode,
			OrderByComparator<RotationMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByRotationCodeByLike_PrevAndNext(
			rotationMasterId, rotationCode, orderByComparator);
	}

	/**
	 * Removes all the rotation masters where rotationCode LIKE &#63; from the database.
	 *
	 * @param rotationCode the rotation code
	 */
	public static void removeByRotationCodeByLike(String rotationCode) {
		getPersistence().removeByRotationCodeByLike(rotationCode);
	}

	/**
	 * Returns the number of rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the number of matching rotation masters
	 */
	public static int countByRotationCodeByLike(String rotationCode) {
		return getPersistence().countByRotationCodeByLike(rotationCode);
	}

	/**
	 * Caches the rotation master in the entity cache if it is enabled.
	 *
	 * @param rotationMaster the rotation master
	 */
	public static void cacheResult(RotationMaster rotationMaster) {
		getPersistence().cacheResult(rotationMaster);
	}

	/**
	 * Caches the rotation masters in the entity cache if it is enabled.
	 *
	 * @param rotationMasters the rotation masters
	 */
	public static void cacheResult(List<RotationMaster> rotationMasters) {
		getPersistence().cacheResult(rotationMasters);
	}

	/**
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	public static RotationMaster create(long rotationMasterId) {
		return getPersistence().create(rotationMasterId);
	}

	/**
	 * Removes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster remove(long rotationMasterId)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().remove(rotationMasterId);
	}

	public static RotationMaster updateImpl(RotationMaster rotationMaster) {
		return getPersistence().updateImpl(rotationMaster);
	}

	/**
	 * Returns the rotation master with the primary key or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public static RotationMaster findByPrimaryKey(long rotationMasterId)
		throws gov.omsb.tms.exception.NoSuchRotationMasterException {

		return getPersistence().findByPrimaryKey(rotationMasterId);
	}

	/**
	 * Returns the rotation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master, or <code>null</code> if a rotation master with the primary key could not be found
	 */
	public static RotationMaster fetchByPrimaryKey(long rotationMasterId) {
		return getPersistence().fetchByPrimaryKey(rotationMasterId);
	}

	/**
	 * Returns all the rotation masters.
	 *
	 * @return the rotation masters
	 */
	public static List<RotationMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	public static List<RotationMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation masters
	 */
	public static List<RotationMaster> findAll(
		int start, int end,
		OrderByComparator<RotationMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation masters
	 */
	public static List<RotationMaster> findAll(
		int start, int end, OrderByComparator<RotationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rotation masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RotationMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RotationMasterPersistence _persistence;

}