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

import gov.omsb.tms.model.ProcedurePgProgdurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procedure pg progduration rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProcedurePgProgdurationRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRelPersistence
 * @generated
 */
public class ProcedurePgProgdurationRelUtil {

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
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		getPersistence().clearCache(procedurePgProgdurationRel);
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
	public static Map<Serializable, ProcedurePgProgdurationRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcedurePgProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcedurePgProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcedurePgProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProcedurePgProgdurationRel update(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		return getPersistence().update(procedurePgProgdurationRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProcedurePgProgdurationRel update(
		ProcedurePgProgdurationRel procedurePgProgdurationRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			procedurePgProgdurationRel, serviceContext);
	}

	/**
	 * Returns all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByUuid_First(
			String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel[] findByUuid_PrevAndNext(
			long procedurePgPdRelId, String uuid,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_PrevAndNext(
			procedurePgPdRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procedure pg progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procedure pg progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure pg progduration rel that was removed
	 */
	public static ProcedurePgProgdurationRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel[] findByUuid_C_PrevAndNext(
			long procedurePgPdRelId, String uuid, long companyId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			procedurePgPdRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procedure pg progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel[]
			findByProgramDurationId_PrevAndNext(
				long procedurePgPdRelId, long programDurationId,
				OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			procedurePgPdRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the procedure pg progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel
		fetchByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long procedurePgPdRelId, long procedureGroupMasterId,
				OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_PrevAndNext(
			procedurePgPdRelId, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Removes all the procedure pg progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public static void removeByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		getPersistence().removeByProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getPersistence().countByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Returns all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId) {

		return getPersistence().findByProcedureMasterId(procedureMasterId);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end) {

		return getPersistence().findByProcedureMasterId(
			procedureMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findByProcedureMasterId(
			procedureMasterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findByProcedureMasterId(
		long procedureMasterId, int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProcedureMasterId(
			procedureMasterId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProcedureMasterId_First(
			long procedureMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureMasterId_First(
			procedureMasterId, orderByComparator);
	}

	/**
	 * Returns the first procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByProcedureMasterId_First(
		long procedureMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProcedureMasterId_First(
			procedureMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel findByProcedureMasterId_Last(
			long procedureMasterId,
			OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureMasterId_Last(
			procedureMasterId, orderByComparator);
	}

	/**
	 * Returns the last procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByProcedureMasterId_Last(
		long procedureMasterId,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProcedureMasterId_Last(
			procedureMasterId, orderByComparator);
	}

	/**
	 * Returns the procedure pg progduration rels before and after the current procedure pg progduration rel in the ordered set where procedureMasterId = &#63;.
	 *
	 * @param procedurePgPdRelId the primary key of the current procedure pg progduration rel
	 * @param procedureMasterId the procedure master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel[]
			findByProcedureMasterId_PrevAndNext(
				long procedurePgPdRelId, long procedureMasterId,
				OrderByComparator<ProcedurePgProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByProcedureMasterId_PrevAndNext(
			procedurePgPdRelId, procedureMasterId, orderByComparator);
	}

	/**
	 * Removes all the procedure pg progduration rels where procedureMasterId = &#63; from the database.
	 *
	 * @param procedureMasterId the procedure master ID
	 */
	public static void removeByProcedureMasterId(long procedureMasterId) {
		getPersistence().removeByProcedureMasterId(procedureMasterId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where procedureMasterId = &#63;.
	 *
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int countByProcedureMasterId(long procedureMasterId) {
		return getPersistence().countByProcedureMasterId(procedureMasterId);
	}

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);
	}

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);
	}

	/**
	 * Returns the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	public static ProcedurePgProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId, boolean useFinderCache) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId,
				useFinderCache);
	}

	/**
	 * Removes the procedure pg progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the procedure pg progduration rel that was removed
	 */
	public static ProcedurePgProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				long programDurationId, long procedureGroupMasterId,
				long procedureMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().
			removeByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);
	}

	/**
	 * Returns the number of procedure pg progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63; and procedureMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param procedureMasterId the procedure master ID
	 * @return the number of matching procedure pg progduration rels
	 */
	public static int
		countByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId) {

		return getPersistence().
			countByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);
	}

	/**
	 * Caches the procedure pg progduration rel in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 */
	public static void cacheResult(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		getPersistence().cacheResult(procedurePgProgdurationRel);
	}

	/**
	 * Caches the procedure pg progduration rels in the entity cache if it is enabled.
	 *
	 * @param procedurePgProgdurationRels the procedure pg progduration rels
	 */
	public static void cacheResult(
		List<ProcedurePgProgdurationRel> procedurePgProgdurationRels) {

		getPersistence().cacheResult(procedurePgProgdurationRels);
	}

	/**
	 * Creates a new procedure pg progduration rel with the primary key. Does not add the procedure pg progduration rel to the database.
	 *
	 * @param procedurePgPdRelId the primary key for the new procedure pg progduration rel
	 * @return the new procedure pg progduration rel
	 */
	public static ProcedurePgProgdurationRel create(long procedurePgPdRelId) {
		return getPersistence().create(procedurePgPdRelId);
	}

	/**
	 * Removes the procedure pg progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel remove(long procedurePgPdRelId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().remove(procedurePgPdRelId);
	}

	public static ProcedurePgProgdurationRel updateImpl(
		ProcedurePgProgdurationRel procedurePgProgdurationRel) {

		return getPersistence().updateImpl(procedurePgProgdurationRel);
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key or throws a <code>NoSuchProcedurePgProgdurationRelException</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel
	 * @throws NoSuchProcedurePgProgdurationRelException if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel findByPrimaryKey(
			long procedurePgPdRelId)
		throws gov.omsb.tms.exception.
			NoSuchProcedurePgProgdurationRelException {

		return getPersistence().findByPrimaryKey(procedurePgPdRelId);
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel, or <code>null</code> if a procedure pg progduration rel with the primary key could not be found
	 */
	public static ProcedurePgProgdurationRel fetchByPrimaryKey(
		long procedurePgPdRelId) {

		return getPersistence().fetchByPrimaryKey(procedurePgPdRelId);
	}

	/**
	 * Returns all the procedure pg progduration rels.
	 *
	 * @return the procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure pg progduration rels
	 */
	public static List<ProcedurePgProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProcedurePgProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procedure pg progduration rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procedure pg progduration rels.
	 *
	 * @return the number of procedure pg progduration rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcedurePgProgdurationRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProcedurePgProgdurationRelPersistence _persistence;

}