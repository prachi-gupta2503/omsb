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

import gov.omsb.tms.model.GenderMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the gender master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.GenderMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderMasterPersistence
 * @generated
 */
public class GenderMasterUtil {

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
	public static void clearCache(GenderMaster genderMaster) {
		getPersistence().clearCache(genderMaster);
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
	public static Map<Serializable, GenderMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GenderMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GenderMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GenderMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GenderMaster update(GenderMaster genderMaster) {
		return getPersistence().update(genderMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GenderMaster update(
		GenderMaster genderMaster, ServiceContext serviceContext) {

		return getPersistence().update(genderMaster, serviceContext);
	}

	/**
	 * Returns all the gender masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching gender masters
	 */
	public static List<GenderMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<GenderMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public static GenderMaster findByUuid_First(
			String uuid, OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUuid_First(
		String uuid, OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public static GenderMaster findByUuid_Last(
			String uuid, OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUuid_Last(
		String uuid, OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the gender masters before and after the current gender master in the ordered set where uuid = &#63;.
	 *
	 * @param genderMasterId the primary key of the current gender master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public static GenderMaster[] findByUuid_PrevAndNext(
			long genderMasterId, String uuid,
			OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			genderMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the gender masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of gender masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching gender masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGenderMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public static GenderMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the gender master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the gender master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the gender master that was removed
	 */
	public static GenderMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of gender masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching gender masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching gender masters
	 */
	public static List<GenderMaster> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gender masters
	 */
	public static List<GenderMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<GenderMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public static GenderMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master
	 * @throws NoSuchGenderMasterException if a matching gender master could not be found
	 */
	public static GenderMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	public static GenderMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the gender masters before and after the current gender master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param genderMasterId the primary key of the current gender master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public static GenderMaster[] findByUuid_C_PrevAndNext(
			long genderMasterId, String uuid, long companyId,
			OrderByComparator<GenderMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			genderMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the gender masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of gender masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching gender masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the gender master in the entity cache if it is enabled.
	 *
	 * @param genderMaster the gender master
	 */
	public static void cacheResult(GenderMaster genderMaster) {
		getPersistence().cacheResult(genderMaster);
	}

	/**
	 * Caches the gender masters in the entity cache if it is enabled.
	 *
	 * @param genderMasters the gender masters
	 */
	public static void cacheResult(List<GenderMaster> genderMasters) {
		getPersistence().cacheResult(genderMasters);
	}

	/**
	 * Creates a new gender master with the primary key. Does not add the gender master to the database.
	 *
	 * @param genderMasterId the primary key for the new gender master
	 * @return the new gender master
	 */
	public static GenderMaster create(long genderMasterId) {
		return getPersistence().create(genderMasterId);
	}

	/**
	 * Removes the gender master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master that was removed
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public static GenderMaster remove(long genderMasterId)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().remove(genderMasterId);
	}

	public static GenderMaster updateImpl(GenderMaster genderMaster) {
		return getPersistence().updateImpl(genderMaster);
	}

	/**
	 * Returns the gender master with the primary key or throws a <code>NoSuchGenderMasterException</code> if it could not be found.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master
	 * @throws NoSuchGenderMasterException if a gender master with the primary key could not be found
	 */
	public static GenderMaster findByPrimaryKey(long genderMasterId)
		throws gov.omsb.tms.exception.NoSuchGenderMasterException {

		return getPersistence().findByPrimaryKey(genderMasterId);
	}

	/**
	 * Returns the gender master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master, or <code>null</code> if a gender master with the primary key could not be found
	 */
	public static GenderMaster fetchByPrimaryKey(long genderMasterId) {
		return getPersistence().fetchByPrimaryKey(genderMasterId);
	}

	/**
	 * Returns all the gender masters.
	 *
	 * @return the gender masters
	 */
	public static List<GenderMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of gender masters
	 */
	public static List<GenderMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gender masters
	 */
	public static List<GenderMaster> findAll(
		int start, int end, OrderByComparator<GenderMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gender masters
	 */
	public static List<GenderMaster> findAll(
		int start, int end, OrderByComparator<GenderMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gender masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gender masters.
	 *
	 * @return the number of gender masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GenderMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GenderMasterPersistence _persistence;

}