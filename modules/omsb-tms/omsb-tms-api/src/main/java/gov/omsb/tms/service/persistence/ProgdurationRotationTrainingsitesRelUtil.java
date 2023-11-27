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

import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration rotation trainingsites rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationRotationTrainingsitesRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelPersistence
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelUtil {

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
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		getPersistence().clearCache(progdurationRotationTrainingsitesRel);
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
	public static Map<Serializable, ProgdurationRotationTrainingsitesRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationRotationTrainingsitesRel update(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		return getPersistence().update(progdurationRotationTrainingsitesRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationRotationTrainingsitesRel update(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationRotationTrainingsitesRel, serviceContext);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[] findByUuid_PrevAndNext(
			long progdurationRotationTsRelId, String uuid,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_PrevAndNext(
			progdurationRotationTsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation trainingsites rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[]
			findByUuid_C_PrevAndNext(
				long progdurationRotationTsRelId, String uuid, long companyId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progdurationRotationTsRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTsRelId, long programDurationId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			progdurationRotationTsRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId) {

		return getPersistence().findByRotationId(rotationId);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end) {

		return getPersistence().findByRotationId(rotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().findByRotationId(
			rotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRotationId(
			rotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByRotationId_First(
			long rotationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationId_First(
			rotationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByRotationId_First(
		long rotationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByRotationId_First(
			rotationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByRotationId_Last(
			long rotationId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationId_Last(
			rotationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByRotationId_Last(
		long rotationId,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().fetchByRotationId_Last(
			rotationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[]
			findByRotationId_PrevAndNext(
				long progdurationRotationTsRelId, long rotationId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationId_PrevAndNext(
			progdurationRotationTsRelId, rotationId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 */
	public static void removeByRotationId(long rotationId) {
		getPersistence().removeByRotationId(rotationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByRotationId(long rotationId) {
		return getPersistence().countByRotationId(rotationId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(long trainingSitesId) {

		return getPersistence().findByTrainingSitesId(trainingSitesId);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(long trainingSitesId, int start, int end) {

		return getPersistence().findByTrainingSitesId(
			trainingSitesId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(
			long trainingSitesId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().findByTrainingSitesId(
			trainingSitesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSitesId the training sites ID
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(
			long trainingSitesId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTrainingSitesId(
			trainingSitesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByTrainingSitesId_First(
				long trainingSitesId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByTrainingSitesId_First(
			trainingSitesId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByTrainingSitesId_First(
			long trainingSitesId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByTrainingSitesId_First(
			trainingSitesId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByTrainingSitesId_Last(
				long trainingSitesId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByTrainingSitesId_Last(
			trainingSitesId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByTrainingSitesId_Last(
			long trainingSitesId,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByTrainingSitesId_Last(
			trainingSitesId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where trainingSitesId = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param trainingSitesId the training sites ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[]
			findByTrainingSitesId_PrevAndNext(
				long progdurationRotationTsRelId, long trainingSitesId,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByTrainingSitesId_PrevAndNext(
			progdurationRotationTsRelId, trainingSitesId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where trainingSitesId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 */
	public static void removeByTrainingSitesId(long trainingSitesId) {
		getPersistence().removeByTrainingSitesId(trainingSitesId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByTrainingSitesId(long trainingSitesId) {
		return getPersistence().countByTrainingSitesId(trainingSitesId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByTrainingSiteAndRotationId(
			trainingSitesId, rotationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId) {

		return getPersistence().fetchByTrainingSiteAndRotationId(
			trainingSitesId, rotationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, boolean useFinderCache) {

		return getPersistence().fetchByTrainingSiteAndRotationId(
			trainingSitesId, rotationId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel
			removeByTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().removeByTrainingSiteAndRotationId(
			trainingSitesId, rotationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId) {

		return getPersistence().countByTrainingSiteAndRotationId(
			trainingSitesId, rotationId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation) {

		return getPersistence().findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end) {

		return getPersistence().findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		findByRotationIdAndIsSharedRotation(
			long rotationId, boolean isSharedRotation, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_First(
				long rotationId, boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationIdAndIsSharedRotation_First(
			rotationId, isSharedRotation, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_First(
			long rotationId, boolean isSharedRotation,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByRotationIdAndIsSharedRotation_First(
			rotationId, isSharedRotation, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByRotationIdAndIsSharedRotation_Last(
				long rotationId, boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationIdAndIsSharedRotation_Last(
			rotationId, isSharedRotation, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByRotationIdAndIsSharedRotation_Last(
			long rotationId, boolean isSharedRotation,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getPersistence().fetchByRotationIdAndIsSharedRotation_Last(
			rotationId, isSharedRotation, orderByComparator);
	}

	/**
	 * Returns the progduration rotation trainingsites rels before and after the current progduration rotation trainingsites rel in the ordered set where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param progdurationRotationTsRelId the primary key of the current progduration rotation trainingsites rel
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel[]
			findByRotationIdAndIsSharedRotation_PrevAndNext(
				long progdurationRotationTsRelId, long rotationId,
				boolean isSharedRotation,
				OrderByComparator<ProgdurationRotationTrainingsitesRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByRotationIdAndIsSharedRotation_PrevAndNext(
			progdurationRotationTsRelId, rotationId, isSharedRotation,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 */
	public static void removeByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation) {

		getPersistence().removeByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationId = &#63; and isSharedRotation = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param isSharedRotation the is shared rotation
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByRotationIdAndIsSharedRotation(
		long rotationId, boolean isSharedRotation) {

		return getPersistence().countByRotationIdAndIsSharedRotation(
			rotationId, isSharedRotation);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId) {

		return getPersistence().fetchByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationTrainingSiteAndRotationId(
			long trainingSitesId, long rotationId, long programDurationId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel
			removeByProgDurationTrainingSiteAndRotationId(
				long trainingSitesId, long rotationId, long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().removeByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByProgDurationTrainingSiteAndRotationId(
		long trainingSitesId, long rotationId, long programDurationId) {

		return getPersistence().countByProgDurationTrainingSiteAndRotationId(
			trainingSitesId, rotationId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId) {

		return getPersistence().fetchByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationAndTrainingSite(
			long trainingSitesId, long programDurationId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation trainingsites rel where trainingSitesId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel
			removeByProgDurationAndTrainingSite(
				long trainingSitesId, long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().removeByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where trainingSitesId = &#63; and programDurationId = &#63;.
	 *
	 * @param trainingSitesId the training sites ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByProgDurationAndTrainingSite(
		long trainingSitesId, long programDurationId) {

		return getPersistence().countByProgDurationAndTrainingSite(
			trainingSitesId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			findByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().
			findByProgDurationRotationOwningProgramAndRotationId(
				rotationOwningProgramId, rotationId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId) {

		return getPersistence().
			fetchByProgDurationRotationOwningProgramAndRotationId(
				rotationOwningProgramId, rotationId, programDurationId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchByProgDurationRotationOwningProgramAndRotationId(
			long rotationOwningProgramId, long rotationId,
			long programDurationId, boolean useFinderCache) {

		return getPersistence().
			fetchByProgDurationRotationOwningProgramAndRotationId(
				rotationOwningProgramId, rotationId, programDurationId,
				useFinderCache);
	}

	/**
	 * Removes the progduration rotation trainingsites rel where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel
			removeByProgDurationRotationOwningProgramAndRotationId(
				long rotationOwningProgramId, long rotationId,
				long programDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().
			removeByProgDurationRotationOwningProgramAndRotationId(
				rotationOwningProgramId, rotationId, programDurationId);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels where rotationOwningProgramId = &#63; and rotationId = &#63; and programDurationId = &#63;.
	 *
	 * @param rotationOwningProgramId the rotation owning program ID
	 * @param rotationId the rotation ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation trainingsites rels
	 */
	public static int countByProgDurationRotationOwningProgramAndRotationId(
		long rotationOwningProgramId, long rotationId, long programDurationId) {

		return getPersistence().
			countByProgDurationRotationOwningProgramAndRotationId(
				rotationOwningProgramId, rotationId, programDurationId);
	}

	/**
	 * Caches the progduration rotation trainingsites rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 */
	public static void cacheResult(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		getPersistence().cacheResult(progdurationRotationTrainingsitesRel);
	}

	/**
	 * Caches the progduration rotation trainingsites rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTrainingsitesRels the progduration rotation trainingsites rels
	 */
	public static void cacheResult(
		List<ProgdurationRotationTrainingsitesRel>
			progdurationRotationTrainingsitesRels) {

		getPersistence().cacheResult(progdurationRotationTrainingsitesRels);
	}

	/**
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	public static ProgdurationRotationTrainingsitesRel create(
		long progdurationRotationTsRelId) {

		return getPersistence().create(progdurationRotationTsRelId);
	}

	/**
	 * Removes the progduration rotation trainingsites rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel remove(
			long progdurationRotationTsRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().remove(progdurationRotationTsRelId);
	}

	public static ProgdurationRotationTrainingsitesRel updateImpl(
		ProgdurationRotationTrainingsitesRel
			progdurationRotationTrainingsitesRel) {

		return getPersistence().updateImpl(
			progdurationRotationTrainingsitesRel);
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or throws a <code>NoSuchProgdurationRotationTrainingsitesRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws NoSuchProgdurationRotationTrainingsitesRelException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel findByPrimaryKey(
			long progdurationRotationTsRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getPersistence().findByPrimaryKey(progdurationRotationTsRelId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel, or <code>null</code> if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel fetchByPrimaryKey(
		long progdurationRotationTsRelId) {

		return getPersistence().fetchByPrimaryKey(progdurationRotationTsRelId);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels.
	 *
	 * @return the progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTrainingsitesRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration rotation trainingsites rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationRotationTrainingsitesRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile ProgdurationRotationTrainingsitesRelPersistence
		_persistence;

}