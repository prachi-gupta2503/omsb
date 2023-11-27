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

import gov.omsb.tms.model.RotationTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rotation type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RotationTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationTypeMasterPersistence
 * @generated
 */
public class RotationTypeMasterUtil {

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
	public static void clearCache(RotationTypeMaster rotationTypeMaster) {
		getPersistence().clearCache(rotationTypeMaster);
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
	public static Map<Serializable, RotationTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RotationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RotationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RotationTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RotationTypeMaster update(
		RotationTypeMaster rotationTypeMaster) {

		return getPersistence().update(rotationTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RotationTypeMaster update(
		RotationTypeMaster rotationTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(rotationTypeMaster, serviceContext);
	}

	/**
	 * Returns all the rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByUuid_First(
			String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByUuid_Last(
			String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster[] findByUuid_PrevAndNext(
			long rotationTypeMasterId, String uuid,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			rotationTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the rotation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the rotation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation type master that was removed
	 */
	public static RotationTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster[] findByUuid_C_PrevAndNext(
			long rotationTypeMasterId, String uuid, long companyId,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rotationTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the rotation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName) {

		return getPersistence().findByRotationTypeNameByLike(rotationTypeName);
	}

	/**
	 * Returns a range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end) {

		return getPersistence().findByRotationTypeNameByLike(
			rotationTypeName, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().findByRotationTypeNameByLike(
			rotationTypeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public static List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRotationTypeNameByLike(
			rotationTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByRotationTypeNameByLike_First(
			String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByRotationTypeNameByLike_First(
			rotationTypeName, orderByComparator);
	}

	/**
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByRotationTypeNameByLike_First(
		String rotationTypeName,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByRotationTypeNameByLike_First(
			rotationTypeName, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster findByRotationTypeNameByLike_Last(
			String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByRotationTypeNameByLike_Last(
			rotationTypeName, orderByComparator);
	}

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public static RotationTypeMaster fetchByRotationTypeNameByLike_Last(
		String rotationTypeName,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().fetchByRotationTypeNameByLike_Last(
			rotationTypeName, orderByComparator);
	}

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster[] findByRotationTypeNameByLike_PrevAndNext(
			long rotationTypeMasterId, String rotationTypeName,
			OrderByComparator<RotationTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByRotationTypeNameByLike_PrevAndNext(
			rotationTypeMasterId, rotationTypeName, orderByComparator);
	}

	/**
	 * Removes all the rotation type masters where rotationTypeName LIKE &#63; from the database.
	 *
	 * @param rotationTypeName the rotation type name
	 */
	public static void removeByRotationTypeNameByLike(String rotationTypeName) {
		getPersistence().removeByRotationTypeNameByLike(rotationTypeName);
	}

	/**
	 * Returns the number of rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the number of matching rotation type masters
	 */
	public static int countByRotationTypeNameByLike(String rotationTypeName) {
		return getPersistence().countByRotationTypeNameByLike(rotationTypeName);
	}

	/**
	 * Caches the rotation type master in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMaster the rotation type master
	 */
	public static void cacheResult(RotationTypeMaster rotationTypeMaster) {
		getPersistence().cacheResult(rotationTypeMaster);
	}

	/**
	 * Caches the rotation type masters in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMasters the rotation type masters
	 */
	public static void cacheResult(
		List<RotationTypeMaster> rotationTypeMasters) {

		getPersistence().cacheResult(rotationTypeMasters);
	}

	/**
	 * Creates a new rotation type master with the primary key. Does not add the rotation type master to the database.
	 *
	 * @param rotationTypeMasterId the primary key for the new rotation type master
	 * @return the new rotation type master
	 */
	public static RotationTypeMaster create(long rotationTypeMasterId) {
		return getPersistence().create(rotationTypeMasterId);
	}

	/**
	 * Removes the rotation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master that was removed
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster remove(long rotationTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().remove(rotationTypeMasterId);
	}

	public static RotationTypeMaster updateImpl(
		RotationTypeMaster rotationTypeMaster) {

		return getPersistence().updateImpl(rotationTypeMaster);
	}

	/**
	 * Returns the rotation type master with the primary key or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster findByPrimaryKey(long rotationTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRotationTypeMasterException {

		return getPersistence().findByPrimaryKey(rotationTypeMasterId);
	}

	/**
	 * Returns the rotation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master, or <code>null</code> if a rotation type master with the primary key could not be found
	 */
	public static RotationTypeMaster fetchByPrimaryKey(
		long rotationTypeMasterId) {

		return getPersistence().fetchByPrimaryKey(rotationTypeMasterId);
	}

	/**
	 * Returns all the rotation type masters.
	 *
	 * @return the rotation type masters
	 */
	public static List<RotationTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of rotation type masters
	 */
	public static List<RotationTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation type masters
	 */
	public static List<RotationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation type masters
	 */
	public static List<RotationTypeMaster> findAll(
		int start, int end,
		OrderByComparator<RotationTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rotation type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rotation type masters.
	 *
	 * @return the number of rotation type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RotationTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RotationTypeMasterPersistence _persistence;

}