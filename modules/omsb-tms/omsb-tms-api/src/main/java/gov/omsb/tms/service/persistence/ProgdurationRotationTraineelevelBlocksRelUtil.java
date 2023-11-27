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

import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration rotation traineelevel blocks rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationRotationTraineelevelBlocksRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRelPersistence
 * @generated
 */
public class ProgdurationRotationTraineelevelBlocksRelUtil {

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
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		getPersistence().clearCache(progdurationRotationTraineelevelBlocksRel);
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
	public static Map<Serializable, ProgdurationRotationTraineelevelBlocksRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationRotationTraineelevelBlocksRel update(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		return getPersistence().update(
			progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationRotationTraineelevelBlocksRel update(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationRotationTraineelevelBlocksRel, serviceContext);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByUuid_PrevAndNext(
				long progdurationRotationTlBlocksRelId, String uuid,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_PrevAndNext(
			progdurationRotationTlBlocksRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	public static ProgdurationRotationTraineelevelBlocksRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByUuid_C_PrevAndNext(
				long progdurationRotationTlBlocksRelId, String uuid,
				long companyId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progdurationRotationTlBlocksRelId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(long traineeLevelId) {

		return getPersistence().findByTraineeLevelId(traineeLevelId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(long traineeLevelId, int start, int end) {

		return getPersistence().findByTraineeLevelId(
			traineeLevelId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(
			long traineeLevelId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findByTraineeLevelId(
			traineeLevelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelId(
			long traineeLevelId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTraineeLevelId(
			traineeLevelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelId_First(
				long traineeLevelId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelId_First(
			traineeLevelId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelId_First(
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeLevelId_First(
			traineeLevelId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelId_Last(
				long traineeLevelId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelId_Last(
			traineeLevelId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelId_Last(
			long traineeLevelId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeLevelId_Last(
			traineeLevelId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelId_PrevAndNext(
			progdurationRotationTlBlocksRelId, traineeLevelId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 */
	public static void removeByTraineeLevelId(long traineeLevelId) {
		getPersistence().removeByTraineeLevelId(traineeLevelId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByTraineeLevelId(long traineeLevelId) {
		return getPersistence().countByTraineeLevelId(traineeLevelId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			progdurationRotationTlBlocksRelId, programDurationId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId) {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long traineeLevelId, long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_First(
				long traineeLevelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId_First(
			traineeLevelId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_First(
			long traineeLevelId, long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationIdAndTraineeLevelId_First(
			traineeLevelId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelId_Last(
				long traineeLevelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationIdAndTraineeLevelId_Last(
			traineeLevelId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelId_Last(
			long traineeLevelId, long programDurationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationIdAndTraineeLevelId_Last(
			traineeLevelId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long programDurationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().
			findByProgramDurationIdAndTraineeLevelId_PrevAndNext(
				progdurationRotationTlBlocksRelId, traineeLevelId,
				programDurationId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId) {

		getPersistence().removeByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByProgramDurationIdAndTraineeLevelId(
		long traineeLevelId, long programDurationId) {

		return getPersistence().countByProgramDurationIdAndTraineeLevelId(
			traineeLevelId, programDurationId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId) {

		return getPersistence().
			fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
			long traineeLevelId, long programDurationId, long rotationId,
			boolean useFinderCache) {

		return getPersistence().
			fetchByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			removeByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().
			removeByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByProgramDurationIdAndTraineeLevelIdAndRotationId(
		long traineeLevelId, long programDurationId, long rotationId) {

		return getPersistence().
			countByProgramDurationIdAndTraineeLevelIdAndRotationId(
				traineeLevelId, programDurationId, rotationId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId) {

		return getPersistence().findByProgramDurationIdAndRotationId(
			programDurationId, rotationId);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end) {

		return getPersistence().findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationIdAndRotationId(
			programDurationId, rotationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_First(
				long programDurationId, long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationIdAndRotationId_First(
			programDurationId, rotationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_First(
			long programDurationId, long rotationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationIdAndRotationId_First(
			programDurationId, rotationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndRotationId_Last(
				long programDurationId, long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByProgramDurationIdAndRotationId_Last(
			programDurationId, rotationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByProgramDurationIdAndRotationId_Last(
			long programDurationId, long rotationId,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationIdAndRotationId_Last(
			programDurationId, rotationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByProgramDurationIdAndRotationId_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long programDurationId,
				long rotationId,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().
			findByProgramDurationIdAndRotationId_PrevAndNext(
				progdurationRotationTlBlocksRelId, programDurationId,
				rotationId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 */
	public static void removeByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId) {

		getPersistence().removeByProgramDurationIdAndRotationId(
			programDurationId, rotationId);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where programDurationId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByProgramDurationIdAndRotationId(
		long programDurationId, long rotationId) {

		return getPersistence().countByProgramDurationIdAndRotationId(
			programDurationId, rotationId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType) {

		return getPersistence().findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType);
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end) {

		return getPersistence().findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_First(
				long traineeLevelId, long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelIdAndRotationType_First(
			traineeLevelId, rotationType, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_First(
			long traineeLevelId, long rotationType,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeLevelIdAndRotationType_First(
			traineeLevelId, rotationType, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
			findByTraineeLevelIdAndRotationType_Last(
				long traineeLevelId, long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelIdAndRotationType_Last(
			traineeLevelId, rotationType, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel
		fetchByTraineeLevelIdAndRotationType_Last(
			long traineeLevelId, long rotationType,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeLevelIdAndRotationType_Last(
			traineeLevelId, rotationType, orderByComparator);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rels before and after the current progduration rotation traineelevel blocks rel in the ordered set where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the current progduration rotation traineelevel blocks rel
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel[]
			findByTraineeLevelIdAndRotationType_PrevAndNext(
				long progdurationRotationTlBlocksRelId, long traineeLevelId,
				long rotationType,
				OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByTraineeLevelIdAndRotationType_PrevAndNext(
			progdurationRotationTlBlocksRelId, traineeLevelId, rotationType,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63; from the database.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 */
	public static void removeByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType) {

		getPersistence().removeByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType);
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels where traineeLevelId = &#63; and rotationType = &#63;.
	 *
	 * @param traineeLevelId the trainee level ID
	 * @param rotationType the rotation type
	 * @return the number of matching progduration rotation traineelevel blocks rels
	 */
	public static int countByTraineeLevelIdAndRotationType(
		long traineeLevelId, long rotationType) {

		return getPersistence().countByTraineeLevelIdAndRotationType(
			traineeLevelId, rotationType);
	}

	/**
	 * Caches the progduration rotation traineelevel blocks rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 */
	public static void cacheResult(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		getPersistence().cacheResult(progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * Caches the progduration rotation traineelevel blocks rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTraineelevelBlocksRels the progduration rotation traineelevel blocks rels
	 */
	public static void cacheResult(
		List<ProgdurationRotationTraineelevelBlocksRel>
			progdurationRotationTraineelevelBlocksRels) {

		getPersistence().cacheResult(
			progdurationRotationTraineelevelBlocksRels);
	}

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	public static ProgdurationRotationTraineelevelBlocksRel create(
		long progdurationRotationTlBlocksRelId) {

		return getPersistence().create(progdurationRotationTlBlocksRelId);
	}

	/**
	 * Removes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel remove(
			long progdurationRotationTlBlocksRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().remove(progdurationRotationTlBlocksRelId);
	}

	public static ProgdurationRotationTraineelevelBlocksRel updateImpl(
		ProgdurationRotationTraineelevelBlocksRel
			progdurationRotationTraineelevelBlocksRel) {

		return getPersistence().updateImpl(
			progdurationRotationTraineelevelBlocksRel);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or throws a <code>NoSuchProgdurationRotationTraineelevelBlocksRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws NoSuchProgdurationRotationTraineelevelBlocksRelException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel findByPrimaryKey(
			long progdurationRotationTlBlocksRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTraineelevelBlocksRelException {

		return getPersistence().findByPrimaryKey(
			progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns the progduration rotation traineelevel blocks rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel, or <code>null</code> if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	public static ProgdurationRotationTraineelevelBlocksRel fetchByPrimaryKey(
		long progdurationRotationTlBlocksRelId) {

		return getPersistence().fetchByPrimaryKey(
			progdurationRotationTlBlocksRelId);
	}

	/**
	 * Returns all the progduration rotation traineelevel blocks rels.
	 *
	 * @return the progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation traineelevel blocks rels
	 */
	public static List<ProgdurationRotationTraineelevelBlocksRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration rotation traineelevel blocks rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationRotationTraineelevelBlocksRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile ProgdurationRotationTraineelevelBlocksRelPersistence
		_persistence;

}