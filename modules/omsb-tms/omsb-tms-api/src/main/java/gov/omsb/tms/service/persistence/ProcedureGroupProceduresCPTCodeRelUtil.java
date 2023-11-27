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

import gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedure group procedures cpt code rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProcedureGroupProceduresCPTCodeRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelPersistence
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelUtil {

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
	public static void clearCache(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		getPersistence().clearCache(procedureGroupProceduresCPTCodeRel);
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
	public static Map<Serializable, ProcedureGroupProceduresCPTCodeRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProcedureGroupProceduresCPTCodeRel update(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		return getPersistence().update(procedureGroupProceduresCPTCodeRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProcedureGroupProceduresCPTCodeRel update(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			procedureGroupProceduresCPTCodeRel, serviceContext);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where uuid = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel[] findByUuid_PrevAndNext(
			long pgProcedureCptCodeRelId, String uuid,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_PrevAndNext(
			pgProcedureCptCodeRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureGroupProceduresCPTCodeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procedure group procedures cpt code rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure group procedures cpt code rel that was removed
	 */
	public static ProcedureGroupProceduresCPTCodeRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel[] findByUuid_C_PrevAndNext(
			long pgProcedureCptCodeRelId, String uuid, long companyId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			pgProcedureCptCodeRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(long procedureGroupId) {

		return getPersistence().findByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(long procedureGroupId, int start, int end) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
			findByProcedureGroupId_First(
				long procedureGroupId,
				OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByProcedureGroupId_First(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the first procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		fetchByProcedureGroupId_First(
			long procedureGroupId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupId_First(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
			findByProcedureGroupId_Last(
				long procedureGroupId,
				OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByProcedureGroupId_Last(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the last procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel
		fetchByProcedureGroupId_Last(
			long procedureGroupId,
			OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupId_Last(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the procedure group procedures cpt code rels before and after the current procedure group procedures cpt code rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the current procedure group procedures cpt code rel
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel[]
			findByProcedureGroupId_PrevAndNext(
				long pgProcedureCptCodeRelId, long procedureGroupId,
				OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByProcedureGroupId_PrevAndNext(
			pgProcedureCptCodeRelId, procedureGroupId, orderByComparator);
	}

	/**
	 * Removes all the procedure group procedures cpt code rels where procedureGroupId = &#63; from the database.
	 *
	 * @param procedureGroupId the procedure group ID
	 */
	public static void removeByProcedureGroupId(long procedureGroupId) {
		getPersistence().removeByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the number of matching procedure group procedures cpt code rels
	 */
	public static int countByProcedureGroupId(long procedureGroupId) {
		return getPersistence().countByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Caches the procedure group procedures cpt code rel in the entity cache if it is enabled.
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 */
	public static void cacheResult(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		getPersistence().cacheResult(procedureGroupProceduresCPTCodeRel);
	}

	/**
	 * Caches the procedure group procedures cpt code rels in the entity cache if it is enabled.
	 *
	 * @param procedureGroupProceduresCPTCodeRels the procedure group procedures cpt code rels
	 */
	public static void cacheResult(
		List<ProcedureGroupProceduresCPTCodeRel>
			procedureGroupProceduresCPTCodeRels) {

		getPersistence().cacheResult(procedureGroupProceduresCPTCodeRels);
	}

	/**
	 * Creates a new procedure group procedures cpt code rel with the primary key. Does not add the procedure group procedures cpt code rel to the database.
	 *
	 * @param pgProcedureCptCodeRelId the primary key for the new procedure group procedures cpt code rel
	 * @return the new procedure group procedures cpt code rel
	 */
	public static ProcedureGroupProceduresCPTCodeRel create(
		long pgProcedureCptCodeRelId) {

		return getPersistence().create(pgProcedureCptCodeRelId);
	}

	/**
	 * Removes the procedure group procedures cpt code rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel remove(
			long pgProcedureCptCodeRelId)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().remove(pgProcedureCptCodeRelId);
	}

	public static ProcedureGroupProceduresCPTCodeRel updateImpl(
		ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel) {

		return getPersistence().updateImpl(procedureGroupProceduresCPTCodeRel);
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key or throws a <code>NoSuchProcedureGroupProceduresCPTCodeRelException</code> if it could not be found.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel
	 * @throws NoSuchProcedureGroupProceduresCPTCodeRelException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel findByPrimaryKey(
			long pgProcedureCptCodeRelId)
		throws gov.omsb.tms.exception.
			NoSuchProcedureGroupProceduresCPTCodeRelException {

		return getPersistence().findByPrimaryKey(pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel, or <code>null</code> if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	public static ProcedureGroupProceduresCPTCodeRel fetchByPrimaryKey(
		long pgProcedureCptCodeRelId) {

		return getPersistence().fetchByPrimaryKey(pgProcedureCptCodeRelId);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels.
	 *
	 * @return the procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure group procedures cpt code rels
	 */
	public static List<ProcedureGroupProceduresCPTCodeRel> findAll(
		int start, int end,
		OrderByComparator<ProcedureGroupProceduresCPTCodeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procedure group procedures cpt code rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels.
	 *
	 * @return the number of procedure group procedures cpt code rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcedureGroupProceduresCPTCodeRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile ProcedureGroupProceduresCPTCodeRelPersistence
		_persistence;

}