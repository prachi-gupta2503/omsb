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

import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration traineelevel blocks level type rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationTraineelevelBlocksLevelTypeRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRelPersistence
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelUtil {

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
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		getPersistence().clearCache(progdurationTraineelevelBlocksLevelTypeRel);
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
	public static Map<Serializable, ProgdurationTraineelevelBlocksLevelTypeRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel update(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		return getPersistence().update(
			progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel update(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationTraineelevelBlocksLevelTypeRel, serviceContext);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByUuid_PrevAndNext(
				long progdurationTlBlocksLtId, String uuid,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_PrevAndNext(
			progdurationTlBlocksLtId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByUuid_C_PrevAndNext(
				long progdurationTlBlocksLtId, String uuid, long companyId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progdurationTlBlocksLtId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rels before and after the current progduration traineelevel blocks level type rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the current progduration traineelevel blocks level type rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationTlBlocksLtId, long programDurationId,
				OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			progdurationTlBlocksLtId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
			findByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId) {

		return getPersistence().fetchByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration traineelevel blocks level type rel, or <code>null</code> if a matching progduration traineelevel blocks level type rel could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
		fetchByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId, useFinderCache);
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel where programDurationId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the progduration traineelevel blocks level type rel that was removed
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel
			removeByProgramDurationIdAndTraineeLevelId(
				long programDurationId, long traineeLevelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().removeByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId);
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels where programDurationId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration traineelevel blocks level type rels
	 */
	public static int countByProgramDurationIdAndTraineeLevelId(
		long programDurationId, long traineeLevelId) {

		return getPersistence().countByProgramDurationIdAndTraineeLevelId(
			programDurationId, traineeLevelId);
	}

	/**
	 * Caches the progduration traineelevel blocks level type rel in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRel the progduration traineelevel blocks level type rel
	 */
	public static void cacheResult(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		getPersistence().cacheResult(
			progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * Caches the progduration traineelevel blocks level type rels in the entity cache if it is enabled.
	 *
	 * @param progdurationTraineelevelBlocksLevelTypeRels the progduration traineelevel blocks level type rels
	 */
	public static void cacheResult(
		List<ProgdurationTraineelevelBlocksLevelTypeRel>
			progdurationTraineelevelBlocksLevelTypeRels) {

		getPersistence().cacheResult(
			progdurationTraineelevelBlocksLevelTypeRels);
	}

	/**
	 * Creates a new progduration traineelevel blocks level type rel with the primary key. Does not add the progduration traineelevel blocks level type rel to the database.
	 *
	 * @param progdurationTlBlocksLtId the primary key for the new progduration traineelevel blocks level type rel
	 * @return the new progduration traineelevel blocks level type rel
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel create(
		long progdurationTlBlocksLtId) {

		return getPersistence().create(progdurationTlBlocksLtId);
	}

	/**
	 * Removes the progduration traineelevel blocks level type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel that was removed
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel remove(
			long progdurationTlBlocksLtId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().remove(progdurationTlBlocksLtId);
	}

	public static ProgdurationTraineelevelBlocksLevelTypeRel updateImpl(
		ProgdurationTraineelevelBlocksLevelTypeRel
			progdurationTraineelevelBlocksLevelTypeRel) {

		return getPersistence().updateImpl(
			progdurationTraineelevelBlocksLevelTypeRel);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or throws a <code>NoSuchProgdurationTraineelevelBlocksLevelTypeRelException</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel
	 * @throws NoSuchProgdurationTraineelevelBlocksLevelTypeRelException if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel findByPrimaryKey(
			long progdurationTlBlocksLtId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationTraineelevelBlocksLevelTypeRelException {

		return getPersistence().findByPrimaryKey(progdurationTlBlocksLtId);
	}

	/**
	 * Returns the progduration traineelevel blocks level type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationTlBlocksLtId the primary key of the progduration traineelevel blocks level type rel
	 * @return the progduration traineelevel blocks level type rel, or <code>null</code> if a progduration traineelevel blocks level type rel with the primary key could not be found
	 */
	public static ProgdurationTraineelevelBlocksLevelTypeRel fetchByPrimaryKey(
		long progdurationTlBlocksLtId) {

		return getPersistence().fetchByPrimaryKey(progdurationTlBlocksLtId);
	}

	/**
	 * Returns all the progduration traineelevel blocks level type rels.
	 *
	 * @return the progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @return the range of progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration traineelevel blocks level type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationTraineelevelBlocksLevelTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration traineelevel blocks level type rels
	 * @param end the upper bound of the range of progduration traineelevel blocks level type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration traineelevel blocks level type rels
	 */
	public static List<ProgdurationTraineelevelBlocksLevelTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationTraineelevelBlocksLevelTypeRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration traineelevel blocks level type rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration traineelevel blocks level type rels.
	 *
	 * @return the number of progduration traineelevel blocks level type rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationTraineelevelBlocksLevelTypeRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile
		ProgdurationTraineelevelBlocksLevelTypeRelPersistence _persistence;

}