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

import gov.omsb.tms.model.VisitTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the visit type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.VisitTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeMasterPersistence
 * @generated
 */
public class VisitTypeMasterUtil {

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
	public static void clearCache(VisitTypeMaster visitTypeMaster) {
		getPersistence().clearCache(visitTypeMaster);
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
	public static Map<Serializable, VisitTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VisitTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VisitTypeMaster update(VisitTypeMaster visitTypeMaster) {
		return getPersistence().update(visitTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VisitTypeMaster update(
		VisitTypeMaster visitTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(visitTypeMaster, serviceContext);
	}

	/**
	 * Returns all the visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByUuid_First(
			String uuid, OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster[] findByUuid_PrevAndNext(
			long visitTypeMasterId, String uuid,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			visitTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the visit type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching visit type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the visit type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the visit type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the visit type master that was removed
	 */
	public static VisitTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching visit type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster[] findByUuid_C_PrevAndNext(
			long visitTypeMasterId, String uuid, long companyId,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			visitTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the visit type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of visit type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching visit type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the matching visit type masters
	 */
	public static List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName) {

		return getPersistence().findByVisitTypeNameByLike(visitTypeName);
	}

	/**
	 * Returns a range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end) {

		return getPersistence().findByVisitTypeNameByLike(
			visitTypeName, start, end);
	}

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().findByVisitTypeNameByLike(
			visitTypeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visit type masters where visitTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param visitTypeName the visit type name
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visit type masters
	 */
	public static List<VisitTypeMaster> findByVisitTypeNameByLike(
		String visitTypeName, int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVisitTypeNameByLike(
			visitTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByVisitTypeNameByLike_First(
			String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByVisitTypeNameByLike_First(
			visitTypeName, orderByComparator);
	}

	/**
	 * Returns the first visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByVisitTypeNameByLike_First(
		String visitTypeName,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByVisitTypeNameByLike_First(
			visitTypeName, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master
	 * @throws NoSuchVisitTypeMasterException if a matching visit type master could not be found
	 */
	public static VisitTypeMaster findByVisitTypeNameByLike_Last(
			String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByVisitTypeNameByLike_Last(
			visitTypeName, orderByComparator);
	}

	/**
	 * Returns the last visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	public static VisitTypeMaster fetchByVisitTypeNameByLike_Last(
		String visitTypeName,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().fetchByVisitTypeNameByLike_Last(
			visitTypeName, orderByComparator);
	}

	/**
	 * Returns the visit type masters before and after the current visit type master in the ordered set where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeMasterId the primary key of the current visit type master
	 * @param visitTypeName the visit type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster[] findByVisitTypeNameByLike_PrevAndNext(
			long visitTypeMasterId, String visitTypeName,
			OrderByComparator<VisitTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByVisitTypeNameByLike_PrevAndNext(
			visitTypeMasterId, visitTypeName, orderByComparator);
	}

	/**
	 * Removes all the visit type masters where visitTypeName LIKE &#63; from the database.
	 *
	 * @param visitTypeName the visit type name
	 */
	public static void removeByVisitTypeNameByLike(String visitTypeName) {
		getPersistence().removeByVisitTypeNameByLike(visitTypeName);
	}

	/**
	 * Returns the number of visit type masters where visitTypeName LIKE &#63;.
	 *
	 * @param visitTypeName the visit type name
	 * @return the number of matching visit type masters
	 */
	public static int countByVisitTypeNameByLike(String visitTypeName) {
		return getPersistence().countByVisitTypeNameByLike(visitTypeName);
	}

	/**
	 * Caches the visit type master in the entity cache if it is enabled.
	 *
	 * @param visitTypeMaster the visit type master
	 */
	public static void cacheResult(VisitTypeMaster visitTypeMaster) {
		getPersistence().cacheResult(visitTypeMaster);
	}

	/**
	 * Caches the visit type masters in the entity cache if it is enabled.
	 *
	 * @param visitTypeMasters the visit type masters
	 */
	public static void cacheResult(List<VisitTypeMaster> visitTypeMasters) {
		getPersistence().cacheResult(visitTypeMasters);
	}

	/**
	 * Creates a new visit type master with the primary key. Does not add the visit type master to the database.
	 *
	 * @param visitTypeMasterId the primary key for the new visit type master
	 * @return the new visit type master
	 */
	public static VisitTypeMaster create(long visitTypeMasterId) {
		return getPersistence().create(visitTypeMasterId);
	}

	/**
	 * Removes the visit type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master that was removed
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster remove(long visitTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().remove(visitTypeMasterId);
	}

	public static VisitTypeMaster updateImpl(VisitTypeMaster visitTypeMaster) {
		return getPersistence().updateImpl(visitTypeMaster);
	}

	/**
	 * Returns the visit type master with the primary key or throws a <code>NoSuchVisitTypeMasterException</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master
	 * @throws NoSuchVisitTypeMasterException if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster findByPrimaryKey(long visitTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchVisitTypeMasterException {

		return getPersistence().findByPrimaryKey(visitTypeMasterId);
	}

	/**
	 * Returns the visit type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master, or <code>null</code> if a visit type master with the primary key could not be found
	 */
	public static VisitTypeMaster fetchByPrimaryKey(long visitTypeMasterId) {
		return getPersistence().fetchByPrimaryKey(visitTypeMasterId);
	}

	/**
	 * Returns all the visit type masters.
	 *
	 * @return the visit type masters
	 */
	public static List<VisitTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of visit type masters
	 */
	public static List<VisitTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visit type masters
	 */
	public static List<VisitTypeMaster> findAll(
		int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visit type masters
	 */
	public static List<VisitTypeMaster> findAll(
		int start, int end,
		OrderByComparator<VisitTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the visit type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of visit type masters.
	 *
	 * @return the number of visit type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VisitTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile VisitTypeMasterPersistence _persistence;

}