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

import gov.omsb.tms.model.ProcedureMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedure master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProcedureMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMasterPersistence
 * @generated
 */
public class ProcedureMasterUtil {

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
	public static void clearCache(ProcedureMaster procedureMaster) {
		getPersistence().clearCache(procedureMaster);
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
	public static Map<Serializable, ProcedureMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcedureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcedureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcedureMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProcedureMaster update(ProcedureMaster procedureMaster) {
		return getPersistence().update(procedureMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProcedureMaster update(
		ProcedureMaster procedureMaster, ServiceContext serviceContext) {

		return getPersistence().update(procedureMaster, serviceContext);
	}

	/**
	 * Returns all the procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByUuid_First(
			String uuid, OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByUuid_Last(
			String uuid, OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster[] findByUuid_PrevAndNext(
			long procedureMasterId, String uuid,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			procedureMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the procedure masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procedure master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure master that was removed
	 */
	public static ProcedureMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster[] findByUuid_C_PrevAndNext(
			long procedureMasterId, String uuid, long companyId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			procedureMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procedure masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName) {

		return getPersistence().findByProcedureNameByLike(procedureName);
	}

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end) {

		return getPersistence().findByProcedureNameByLike(
			procedureName, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findByProcedureNameByLike(
			procedureName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProcedureNameByLike(
			procedureName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByProcedureNameByLike_First(
			String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureNameByLike_First(
			procedureName, orderByComparator);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByProcedureNameByLike_First(
		String procedureName,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByProcedureNameByLike_First(
			procedureName, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByProcedureNameByLike_Last(
			String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureNameByLike_Last(
			procedureName, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByProcedureNameByLike_Last(
		String procedureName,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByProcedureNameByLike_Last(
			procedureName, orderByComparator);
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster[] findByProcedureNameByLike_PrevAndNext(
			long procedureMasterId, String procedureName,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureNameByLike_PrevAndNext(
			procedureMasterId, procedureName, orderByComparator);
	}

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 */
	public static void removeByProcedureNameByLike(String procedureName) {
		getPersistence().removeByProcedureNameByLike(procedureName);
	}

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the number of matching procedure masters
	 */
	public static int countByProcedureNameByLike(String procedureName) {
		return getPersistence().countByProcedureNameByLike(procedureName);
	}

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	public static List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId) {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId);
	}

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public static List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end) {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end, OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId, start, end,
				orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end, OrderByComparator<ProcedureMaster> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId, start, end,
				orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_First(
				String procedureName, long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId_First(
				procedureName, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_First(
			String procedureName, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().
			fetchByProcedureNameByLikeAndProcedureGroupMasterId_First(
				procedureName, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				String procedureName, long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				procedureName, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_Last(
			String procedureName, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().
			fetchByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				procedureName, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster[]
			findByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
				long procedureMasterId, String procedureName,
				long procedureGroupMasterId,
				OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().
			findByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
				procedureMasterId, procedureName, procedureGroupMasterId,
				orderByComparator);
	}

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public static void removeByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId) {

		getPersistence().removeByProcedureNameByLikeAndProcedureGroupMasterId(
			procedureName, procedureGroupMasterId);
	}

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	public static int countByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId) {

		return getPersistence().
			countByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId);
	}

	/**
	 * Returns all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Returns a range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public static List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public static ProcedureMaster findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public static ProcedureMaster fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster[] findByProcedureGroupMasterId_PrevAndNext(
			long procedureMasterId, long procedureGroupMasterId,
			OrderByComparator<ProcedureMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByProcedureGroupMasterId_PrevAndNext(
			procedureMasterId, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Removes all the procedure masters where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public static void removeByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		getPersistence().removeByProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Returns the number of procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	public static int countByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getPersistence().countByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Caches the procedure master in the entity cache if it is enabled.
	 *
	 * @param procedureMaster the procedure master
	 */
	public static void cacheResult(ProcedureMaster procedureMaster) {
		getPersistence().cacheResult(procedureMaster);
	}

	/**
	 * Caches the procedure masters in the entity cache if it is enabled.
	 *
	 * @param procedureMasters the procedure masters
	 */
	public static void cacheResult(List<ProcedureMaster> procedureMasters) {
		getPersistence().cacheResult(procedureMasters);
	}

	/**
	 * Creates a new procedure master with the primary key. Does not add the procedure master to the database.
	 *
	 * @param procedureMasterId the primary key for the new procedure master
	 * @return the new procedure master
	 */
	public static ProcedureMaster create(long procedureMasterId) {
		return getPersistence().create(procedureMasterId);
	}

	/**
	 * Removes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster remove(long procedureMasterId)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().remove(procedureMasterId);
	}

	public static ProcedureMaster updateImpl(ProcedureMaster procedureMaster) {
		return getPersistence().updateImpl(procedureMaster);
	}

	/**
	 * Returns the procedure master with the primary key or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster findByPrimaryKey(long procedureMasterId)
		throws gov.omsb.tms.exception.NoSuchProcedureMasterException {

		return getPersistence().findByPrimaryKey(procedureMasterId);
	}

	/**
	 * Returns the procedure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master, or <code>null</code> if a procedure master with the primary key could not be found
	 */
	public static ProcedureMaster fetchByPrimaryKey(long procedureMasterId) {
		return getPersistence().fetchByPrimaryKey(procedureMasterId);
	}

	/**
	 * Returns all the procedure masters.
	 *
	 * @return the procedure masters
	 */
	public static List<ProcedureMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of procedure masters
	 */
	public static List<ProcedureMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure masters
	 */
	public static List<ProcedureMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure masters
	 */
	public static List<ProcedureMaster> findAll(
		int start, int end,
		OrderByComparator<ProcedureMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procedure masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procedure masters.
	 *
	 * @return the number of procedure masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcedureMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProcedureMasterPersistence _persistence;

}