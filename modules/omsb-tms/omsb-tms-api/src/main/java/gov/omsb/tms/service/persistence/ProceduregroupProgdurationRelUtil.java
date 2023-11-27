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

import gov.omsb.tms.model.ProceduregroupProgdurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the proceduregroup progduration rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProceduregroupProgdurationRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProceduregroupProgdurationRelPersistence
 * @generated
 */
public class ProceduregroupProgdurationRelUtil {

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
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		getPersistence().clearCache(proceduregroupProgdurationRel);
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
	public static Map<Serializable, ProceduregroupProgdurationRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProceduregroupProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProceduregroupProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProceduregroupProgdurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProceduregroupProgdurationRel update(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		return getPersistence().update(proceduregroupProgdurationRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProceduregroupProgdurationRel update(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			proceduregroupProgdurationRel, serviceContext);
	}

	/**
	 * Returns all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByUuid_First(
			String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel[] findByUuid_PrevAndNext(
			long pgPdRelId, String uuid,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_PrevAndNext(
			pgPdRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the proceduregroup progduration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	public static ProceduregroupProgdurationRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel[] findByUuid_C_PrevAndNext(
			long pgPdRelId, String uuid, long companyId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			pgPdRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the proceduregroup progduration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel[]
			findByProgramDurationId_PrevAndNext(
				long pgPdRelId, long programDurationId,
				OrderByComparator<ProceduregroupProgdurationRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			pgPdRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the proceduregroup progduration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(long procedureGroupMasterId) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			OrderByComparator<ProceduregroupProgdurationRel>
				orderByComparator) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(
			long procedureGroupMasterId, int start, int end,
			OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProcedureGroupMasterId(
			procedureGroupMasterId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
			findByProcedureGroupMasterId_First(
				long procedureGroupMasterId,
				OrderByComparator<ProceduregroupProgdurationRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the first proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
		fetchByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			OrderByComparator<ProceduregroupProgdurationRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_First(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
			findByProcedureGroupMasterId_Last(
				long procedureGroupMasterId,
				OrderByComparator<ProceduregroupProgdurationRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the last proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
		fetchByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			OrderByComparator<ProceduregroupProgdurationRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupMasterId_Last(
			procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Returns the proceduregroup progduration rels before and after the current proceduregroup progduration rel in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param pgPdRelId the primary key of the current proceduregroup progduration rel
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel[]
			findByProcedureGroupMasterId_PrevAndNext(
				long pgPdRelId, long procedureGroupMasterId,
				OrderByComparator<ProceduregroupProgdurationRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByProcedureGroupMasterId_PrevAndNext(
			pgPdRelId, procedureGroupMasterId, orderByComparator);
	}

	/**
	 * Removes all the proceduregroup progduration rels where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public static void removeByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		getPersistence().removeByProcedureGroupMasterId(procedureGroupMasterId);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByProcedureGroupMasterId(
		long procedureGroupMasterId) {

		return getPersistence().countByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
			findByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);
	}

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);
	}

	/**
	 * Returns the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	public static ProceduregroupProgdurationRel
		fetchByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId,
			boolean useFinderCache) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId, useFinderCache);
	}

	/**
	 * Removes the proceduregroup progduration rel where programDurationId = &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the proceduregroup progduration rel that was removed
	 */
	public static ProceduregroupProgdurationRel
			removeByProgramDurationIdAndProcedureGroupMasterId(
				long programDurationId, long procedureGroupMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().
			removeByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);
	}

	/**
	 * Returns the number of proceduregroup progduration rels where programDurationId = &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching proceduregroup progduration rels
	 */
	public static int countByProgramDurationIdAndProcedureGroupMasterId(
		long programDurationId, long procedureGroupMasterId) {

		return getPersistence().
			countByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);
	}

	/**
	 * Caches the proceduregroup progduration rel in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 */
	public static void cacheResult(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		getPersistence().cacheResult(proceduregroupProgdurationRel);
	}

	/**
	 * Caches the proceduregroup progduration rels in the entity cache if it is enabled.
	 *
	 * @param proceduregroupProgdurationRels the proceduregroup progduration rels
	 */
	public static void cacheResult(
		List<ProceduregroupProgdurationRel> proceduregroupProgdurationRels) {

		getPersistence().cacheResult(proceduregroupProgdurationRels);
	}

	/**
	 * Creates a new proceduregroup progduration rel with the primary key. Does not add the proceduregroup progduration rel to the database.
	 *
	 * @param pgPdRelId the primary key for the new proceduregroup progduration rel
	 * @return the new proceduregroup progduration rel
	 */
	public static ProceduregroupProgdurationRel create(long pgPdRelId) {
		return getPersistence().create(pgPdRelId);
	}

	/**
	 * Removes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel remove(long pgPdRelId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().remove(pgPdRelId);
	}

	public static ProceduregroupProgdurationRel updateImpl(
		ProceduregroupProgdurationRel proceduregroupProgdurationRel) {

		return getPersistence().updateImpl(proceduregroupProgdurationRel);
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key or throws a <code>NoSuchProceduregroupProgdurationRelException</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws NoSuchProceduregroupProgdurationRelException if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel findByPrimaryKey(long pgPdRelId)
		throws gov.omsb.tms.exception.
			NoSuchProceduregroupProgdurationRelException {

		return getPersistence().findByPrimaryKey(pgPdRelId);
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel, or <code>null</code> if a proceduregroup progduration rel with the primary key could not be found
	 */
	public static ProceduregroupProgdurationRel fetchByPrimaryKey(
		long pgPdRelId) {

		return getPersistence().fetchByPrimaryKey(pgPdRelId);
	}

	/**
	 * Returns all the proceduregroup progduration rels.
	 *
	 * @return the proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of proceduregroup progduration rels
	 */
	public static List<ProceduregroupProgdurationRel> findAll(
		int start, int end,
		OrderByComparator<ProceduregroupProgdurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the proceduregroup progduration rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of proceduregroup progduration rels.
	 *
	 * @return the number of proceduregroup progduration rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProceduregroupProgdurationRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProceduregroupProgdurationRelPersistence
		_persistence;

}