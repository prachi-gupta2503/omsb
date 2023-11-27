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

import gov.omsb.tms.model.CompetenciesMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the competencies master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.CompetenciesMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMasterPersistence
 * @generated
 */
public class CompetenciesMasterUtil {

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
	public static void clearCache(CompetenciesMaster competenciesMaster) {
		getPersistence().clearCache(competenciesMaster);
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
	public static Map<Serializable, CompetenciesMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompetenciesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompetenciesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompetenciesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompetenciesMaster update(
		CompetenciesMaster competenciesMaster) {

		return getPersistence().update(competenciesMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompetenciesMaster update(
		CompetenciesMaster competenciesMaster, ServiceContext serviceContext) {

		return getPersistence().update(competenciesMaster, serviceContext);
	}

	/**
	 * Returns all the competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public static CompetenciesMaster findByUuid_First(
			String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUuid_First(
		String uuid, OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public static CompetenciesMaster findByUuid_Last(
			String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUuid_Last(
		String uuid, OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public static CompetenciesMaster[] findByUuid_PrevAndNext(
			long competenciesMasterId, String uuid,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			competenciesMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the competencies masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching competencies masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public static CompetenciesMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the competencies master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the competencies master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the competencies master that was removed
	 */
	public static CompetenciesMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching competencies masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching competencies masters
	 */
	public static List<CompetenciesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public static CompetenciesMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master
	 * @throws NoSuchCompetenciesMasterException if a matching competencies master could not be found
	 */
	public static CompetenciesMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	public static CompetenciesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the competencies masters before and after the current competencies master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param competenciesMasterId the primary key of the current competencies master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public static CompetenciesMaster[] findByUuid_C_PrevAndNext(
			long competenciesMasterId, String uuid, long companyId,
			OrderByComparator<CompetenciesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			competenciesMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the competencies masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of competencies masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching competencies masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the competencies master in the entity cache if it is enabled.
	 *
	 * @param competenciesMaster the competencies master
	 */
	public static void cacheResult(CompetenciesMaster competenciesMaster) {
		getPersistence().cacheResult(competenciesMaster);
	}

	/**
	 * Caches the competencies masters in the entity cache if it is enabled.
	 *
	 * @param competenciesMasters the competencies masters
	 */
	public static void cacheResult(
		List<CompetenciesMaster> competenciesMasters) {

		getPersistence().cacheResult(competenciesMasters);
	}

	/**
	 * Creates a new competencies master with the primary key. Does not add the competencies master to the database.
	 *
	 * @param competenciesMasterId the primary key for the new competencies master
	 * @return the new competencies master
	 */
	public static CompetenciesMaster create(long competenciesMasterId) {
		return getPersistence().create(competenciesMasterId);
	}

	/**
	 * Removes the competencies master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master that was removed
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public static CompetenciesMaster remove(long competenciesMasterId)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().remove(competenciesMasterId);
	}

	public static CompetenciesMaster updateImpl(
		CompetenciesMaster competenciesMaster) {

		return getPersistence().updateImpl(competenciesMaster);
	}

	/**
	 * Returns the competencies master with the primary key or throws a <code>NoSuchCompetenciesMasterException</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master
	 * @throws NoSuchCompetenciesMasterException if a competencies master with the primary key could not be found
	 */
	public static CompetenciesMaster findByPrimaryKey(long competenciesMasterId)
		throws gov.omsb.tms.exception.NoSuchCompetenciesMasterException {

		return getPersistence().findByPrimaryKey(competenciesMasterId);
	}

	/**
	 * Returns the competencies master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master, or <code>null</code> if a competencies master with the primary key could not be found
	 */
	public static CompetenciesMaster fetchByPrimaryKey(
		long competenciesMasterId) {

		return getPersistence().fetchByPrimaryKey(competenciesMasterId);
	}

	/**
	 * Returns all the competencies masters.
	 *
	 * @return the competencies masters
	 */
	public static List<CompetenciesMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of competencies masters
	 */
	public static List<CompetenciesMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of competencies masters
	 */
	public static List<CompetenciesMaster> findAll(
		int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of competencies masters
	 */
	public static List<CompetenciesMaster> findAll(
		int start, int end,
		OrderByComparator<CompetenciesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the competencies masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of competencies masters.
	 *
	 * @return the number of competencies masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompetenciesMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CompetenciesMasterPersistence _persistence;

}