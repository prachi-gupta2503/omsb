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

import gov.omsb.tms.model.ProgdurationObjectivesRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration objectives rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationObjectivesRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationObjectivesRelPersistence
 * @generated
 */
public class ProgdurationObjectivesRelUtil {

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
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		getPersistence().clearCache(progdurationObjectivesRel);
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
	public static Map<Serializable, ProgdurationObjectivesRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationObjectivesRel update(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		return getPersistence().update(progdurationObjectivesRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationObjectivesRel update(
		ProgdurationObjectivesRel progdurationObjectivesRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationObjectivesRel, serviceContext);
	}

	/**
	 * Returns all the progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public static ProgdurationObjectivesRel[] findByUuid_PrevAndNext(
			long PDObjectivesId, String uuid,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_PrevAndNext(
			PDObjectivesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration objectives rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration objectives rel that was removed
	 */
	public static ProgdurationObjectivesRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration objectives rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	public static ProgdurationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration objectives rels before and after the current progduration objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param PDObjectivesId the primary key of the current progduration objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public static ProgdurationObjectivesRel[] findByUuid_C_PrevAndNext(
			long PDObjectivesId, String uuid, long companyId,
			OrderByComparator<ProgdurationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			PDObjectivesId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the progduration objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration objectives rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the progduration objectives rel in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 */
	public static void cacheResult(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		getPersistence().cacheResult(progdurationObjectivesRel);
	}

	/**
	 * Caches the progduration objectives rels in the entity cache if it is enabled.
	 *
	 * @param progdurationObjectivesRels the progduration objectives rels
	 */
	public static void cacheResult(
		List<ProgdurationObjectivesRel> progdurationObjectivesRels) {

		getPersistence().cacheResult(progdurationObjectivesRels);
	}

	/**
	 * Creates a new progduration objectives rel with the primary key. Does not add the progduration objectives rel to the database.
	 *
	 * @param PDObjectivesId the primary key for the new progduration objectives rel
	 * @return the new progduration objectives rel
	 */
	public static ProgdurationObjectivesRel create(long PDObjectivesId) {
		return getPersistence().create(PDObjectivesId);
	}

	/**
	 * Removes the progduration objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public static ProgdurationObjectivesRel remove(long PDObjectivesId)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().remove(PDObjectivesId);
	}

	public static ProgdurationObjectivesRel updateImpl(
		ProgdurationObjectivesRel progdurationObjectivesRel) {

		return getPersistence().updateImpl(progdurationObjectivesRel);
	}

	/**
	 * Returns the progduration objectives rel with the primary key or throws a <code>NoSuchProgdurationObjectivesRelException</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel
	 * @throws NoSuchProgdurationObjectivesRelException if a progduration objectives rel with the primary key could not be found
	 */
	public static ProgdurationObjectivesRel findByPrimaryKey(
			long PDObjectivesId)
		throws gov.omsb.tms.exception.NoSuchProgdurationObjectivesRelException {

		return getPersistence().findByPrimaryKey(PDObjectivesId);
	}

	/**
	 * Returns the progduration objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel, or <code>null</code> if a progduration objectives rel with the primary key could not be found
	 */
	public static ProgdurationObjectivesRel fetchByPrimaryKey(
		long PDObjectivesId) {

		return getPersistence().fetchByPrimaryKey(PDObjectivesId);
	}

	/**
	 * Returns all the progduration objectives rels.
	 *
	 * @return the progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration objectives rels
	 */
	public static List<ProgdurationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration objectives rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration objectives rels.
	 *
	 * @return the number of progduration objectives rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationObjectivesRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgdurationObjectivesRelPersistence _persistence;

}