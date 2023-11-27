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

import gov.omsb.tms.model.LeaveProgramMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave program master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.LeaveProgramMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveProgramMasterPersistence
 * @generated
 */
public class LeaveProgramMasterUtil {

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
	public static void clearCache(LeaveProgramMaster leaveProgramMaster) {
		getPersistence().clearCache(leaveProgramMaster);
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
	public static Map<Serializable, LeaveProgramMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveProgramMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveProgramMaster update(
		LeaveProgramMaster leaveProgramMaster) {

		return getPersistence().update(leaveProgramMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveProgramMaster update(
		LeaveProgramMaster leaveProgramMaster, ServiceContext serviceContext) {

		return getPersistence().update(leaveProgramMaster, serviceContext);
	}

	/**
	 * Returns all the leave program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByUuid_First(
			String uuid,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUuid_First(
		String uuid, OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster[] findByUuid_PrevAndNext(
			long leaveProgramMasterId, String uuid,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveProgramMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave program masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave program masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave program master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave program master that was removed
	 */
	public static LeaveProgramMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave program masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave program masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster[] findByUuid_C_PrevAndNext(
			long leaveProgramMasterId, String uuid, long companyId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveProgramMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave program masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave program masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the leave program masters where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @return the matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId) {

		return getPersistence().findByProgramMasterId(programMasterId);
	}

	/**
	 * Returns a range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end) {

		return getPersistence().findByProgramMasterId(
			programMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().findByProgramMasterId(
			programMasterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public static List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramMasterId(
			programMasterId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByProgramMasterId_First(
			long programMasterId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByProgramMasterId_First(
			programMasterId, orderByComparator);
	}

	/**
	 * Returns the first leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByProgramMasterId_First(
		long programMasterId,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramMasterId_First(
			programMasterId, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByProgramMasterId_Last(
			long programMasterId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByProgramMasterId_Last(
			programMasterId, orderByComparator);
	}

	/**
	 * Returns the last leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByProgramMasterId_Last(
		long programMasterId,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().fetchByProgramMasterId_Last(
			programMasterId, orderByComparator);
	}

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster[] findByProgramMasterId_PrevAndNext(
			long leaveProgramMasterId, long programMasterId,
			OrderByComparator<LeaveProgramMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByProgramMasterId_PrevAndNext(
			leaveProgramMasterId, programMasterId, orderByComparator);
	}

	/**
	 * Removes all the leave program masters where programMasterId = &#63; from the database.
	 *
	 * @param programMasterId the program master ID
	 */
	public static void removeByProgramMasterId(long programMasterId) {
		getPersistence().removeByProgramMasterId(programMasterId);
	}

	/**
	 * Returns the number of leave program masters where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @return the number of matching leave program masters
	 */
	public static int countByProgramMasterId(long programMasterId) {
		return getPersistence().countByProgramMasterId(programMasterId);
	}

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster findByProgramMasterLeaveTypeId(
			long programMasterId, long leaveTypesId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByProgramMasterLeaveTypeId(
			programMasterId, leaveTypesId);
	}

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId) {

		return getPersistence().fetchByProgramMasterLeaveTypeId(
			programMasterId, leaveTypesId);
	}

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public static LeaveProgramMaster fetchByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId, boolean useFinderCache) {

		return getPersistence().fetchByProgramMasterLeaveTypeId(
			programMasterId, leaveTypesId, useFinderCache);
	}

	/**
	 * Removes the leave program master where programMasterId = &#63; and leaveTypesId = &#63; from the database.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the leave program master that was removed
	 */
	public static LeaveProgramMaster removeByProgramMasterLeaveTypeId(
			long programMasterId, long leaveTypesId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().removeByProgramMasterLeaveTypeId(
			programMasterId, leaveTypesId);
	}

	/**
	 * Returns the number of leave program masters where programMasterId = &#63; and leaveTypesId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the number of matching leave program masters
	 */
	public static int countByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId) {

		return getPersistence().countByProgramMasterLeaveTypeId(
			programMasterId, leaveTypesId);
	}

	/**
	 * Caches the leave program master in the entity cache if it is enabled.
	 *
	 * @param leaveProgramMaster the leave program master
	 */
	public static void cacheResult(LeaveProgramMaster leaveProgramMaster) {
		getPersistence().cacheResult(leaveProgramMaster);
	}

	/**
	 * Caches the leave program masters in the entity cache if it is enabled.
	 *
	 * @param leaveProgramMasters the leave program masters
	 */
	public static void cacheResult(
		List<LeaveProgramMaster> leaveProgramMasters) {

		getPersistence().cacheResult(leaveProgramMasters);
	}

	/**
	 * Creates a new leave program master with the primary key. Does not add the leave program master to the database.
	 *
	 * @param leaveProgramMasterId the primary key for the new leave program master
	 * @return the new leave program master
	 */
	public static LeaveProgramMaster create(long leaveProgramMasterId) {
		return getPersistence().create(leaveProgramMasterId);
	}

	/**
	 * Removes the leave program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master that was removed
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster remove(long leaveProgramMasterId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().remove(leaveProgramMasterId);
	}

	public static LeaveProgramMaster updateImpl(
		LeaveProgramMaster leaveProgramMaster) {

		return getPersistence().updateImpl(leaveProgramMaster);
	}

	/**
	 * Returns the leave program master with the primary key or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster findByPrimaryKey(long leaveProgramMasterId)
		throws gov.omsb.tms.exception.NoSuchLeaveProgramMasterException {

		return getPersistence().findByPrimaryKey(leaveProgramMasterId);
	}

	/**
	 * Returns the leave program master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master, or <code>null</code> if a leave program master with the primary key could not be found
	 */
	public static LeaveProgramMaster fetchByPrimaryKey(
		long leaveProgramMasterId) {

		return getPersistence().fetchByPrimaryKey(leaveProgramMasterId);
	}

	/**
	 * Returns all the leave program masters.
	 *
	 * @return the leave program masters
	 */
	public static List<LeaveProgramMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of leave program masters
	 */
	public static List<LeaveProgramMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave program masters
	 */
	public static List<LeaveProgramMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave program masters
	 */
	public static List<LeaveProgramMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveProgramMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave program masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave program masters.
	 *
	 * @return the number of leave program masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveProgramMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LeaveProgramMasterPersistence _persistence;

}