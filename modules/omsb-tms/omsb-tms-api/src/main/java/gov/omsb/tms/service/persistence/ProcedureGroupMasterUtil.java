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

import gov.omsb.tms.model.ProcedureGroupMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedure group master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProcedureGroupMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMasterPersistence
 * @generated
 */
public class ProcedureGroupMasterUtil {

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
	public static void clearCache(ProcedureGroupMaster procedureGroupMaster) {
		getPersistence().clearCache(procedureGroupMaster);
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
	public static Map<Serializable, ProcedureGroupMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcedureGroupMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcedureGroupMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcedureGroupMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProcedureGroupMaster update(
		ProcedureGroupMaster procedureGroupMaster) {

		return getPersistence().update(procedureGroupMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProcedureGroupMaster update(
		ProcedureGroupMaster procedureGroupMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(procedureGroupMaster, serviceContext);
	}

	/**
	 * Returns all the procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByUuid_First(
			String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster[] findByUuid_PrevAndNext(
			long procedureGroupMasterId, String uuid,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			procedureGroupMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the procedure group masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure group masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procedure group master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure group master that was removed
	 */
	public static ProcedureGroupMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure group masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster[] findByUuid_C_PrevAndNext(
			long procedureGroupMasterId, String uuid, long companyId,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			procedureGroupMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procedure group masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure group masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName) {

		return getPersistence().findByprocedureGroupNameByLike(
			procedureGroupName);
	}

	/**
	 * Returns a range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end) {

		return getPersistence().findByprocedureGroupNameByLike(
			procedureGroupName, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().findByprocedureGroupNameByLike(
			procedureGroupName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public static List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByprocedureGroupNameByLike(
			procedureGroupName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByprocedureGroupNameByLike_First(
			String procedureGroupName,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByprocedureGroupNameByLike_First(
			procedureGroupName, orderByComparator);
	}

	/**
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByprocedureGroupNameByLike_First(
		String procedureGroupName,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByprocedureGroupNameByLike_First(
			procedureGroupName, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster findByprocedureGroupNameByLike_Last(
			String procedureGroupName,
			OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByprocedureGroupNameByLike_Last(
			procedureGroupName, orderByComparator);
	}

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public static ProcedureGroupMaster fetchByprocedureGroupNameByLike_Last(
		String procedureGroupName,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().fetchByprocedureGroupNameByLike_Last(
			procedureGroupName, orderByComparator);
	}

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster[]
			findByprocedureGroupNameByLike_PrevAndNext(
				long procedureGroupMasterId, String procedureGroupName,
				OrderByComparator<ProcedureGroupMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByprocedureGroupNameByLike_PrevAndNext(
			procedureGroupMasterId, procedureGroupName, orderByComparator);
	}

	/**
	 * Removes all the procedure group masters where procedureGroupName LIKE &#63; from the database.
	 *
	 * @param procedureGroupName the procedure group name
	 */
	public static void removeByprocedureGroupNameByLike(
		String procedureGroupName) {

		getPersistence().removeByprocedureGroupNameByLike(procedureGroupName);
	}

	/**
	 * Returns the number of procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the number of matching procedure group masters
	 */
	public static int countByprocedureGroupNameByLike(
		String procedureGroupName) {

		return getPersistence().countByprocedureGroupNameByLike(
			procedureGroupName);
	}

	/**
	 * Caches the procedure group master in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMaster the procedure group master
	 */
	public static void cacheResult(ProcedureGroupMaster procedureGroupMaster) {
		getPersistence().cacheResult(procedureGroupMaster);
	}

	/**
	 * Caches the procedure group masters in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMasters the procedure group masters
	 */
	public static void cacheResult(
		List<ProcedureGroupMaster> procedureGroupMasters) {

		getPersistence().cacheResult(procedureGroupMasters);
	}

	/**
	 * Creates a new procedure group master with the primary key. Does not add the procedure group master to the database.
	 *
	 * @param procedureGroupMasterId the primary key for the new procedure group master
	 * @return the new procedure group master
	 */
	public static ProcedureGroupMaster create(long procedureGroupMasterId) {
		return getPersistence().create(procedureGroupMasterId);
	}

	/**
	 * Removes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster remove(long procedureGroupMasterId)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().remove(procedureGroupMasterId);
	}

	public static ProcedureGroupMaster updateImpl(
		ProcedureGroupMaster procedureGroupMaster) {

		return getPersistence().updateImpl(procedureGroupMaster);
	}

	/**
	 * Returns the procedure group master with the primary key or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster findByPrimaryKey(
			long procedureGroupMasterId)
		throws gov.omsb.tms.exception.NoSuchProcedureGroupMasterException {

		return getPersistence().findByPrimaryKey(procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master, or <code>null</code> if a procedure group master with the primary key could not be found
	 */
	public static ProcedureGroupMaster fetchByPrimaryKey(
		long procedureGroupMasterId) {

		return getPersistence().fetchByPrimaryKey(procedureGroupMasterId);
	}

	/**
	 * Returns all the procedure group masters.
	 *
	 * @return the procedure group masters
	 */
	public static List<ProcedureGroupMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of procedure group masters
	 */
	public static List<ProcedureGroupMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure group masters
	 */
	public static List<ProcedureGroupMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure group masters
	 */
	public static List<ProcedureGroupMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procedure group masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procedure group masters.
	 *
	 * @return the number of procedure group masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcedureGroupMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProcedureGroupMasterPersistence _persistence;

}