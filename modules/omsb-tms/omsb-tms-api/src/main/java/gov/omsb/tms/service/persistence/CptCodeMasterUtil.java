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

import gov.omsb.tms.model.CptCodeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cpt code master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.CptCodeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMasterPersistence
 * @generated
 */
public class CptCodeMasterUtil {

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
	public static void clearCache(CptCodeMaster cptCodeMaster) {
		getPersistence().clearCache(cptCodeMaster);
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
	public static Map<Serializable, CptCodeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CptCodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CptCodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CptCodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CptCodeMaster update(CptCodeMaster cptCodeMaster) {
		return getPersistence().update(cptCodeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CptCodeMaster update(
		CptCodeMaster cptCodeMaster, ServiceContext serviceContext) {

		return getPersistence().update(cptCodeMaster, serviceContext);
	}

	/**
	 * Returns all the cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByUuid_First(
			String uuid, OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUuid_First(
		String uuid, OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByUuid_Last(
			String uuid, OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster[] findByUuid_PrevAndNext(
			long cptCodeMasterId, String uuid,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			cptCodeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cpt code masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cpt code masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cpt code master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cpt code master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cpt code master that was removed
	 */
	public static CptCodeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cpt code masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster[] findByUuid_C_PrevAndNext(
			long cptCodeMasterId, String uuid, long companyId,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cptCodeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cpt code masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cpt code masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cpt code masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the matching cpt code masters
	 */
	public static List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName) {

		return getPersistence().findByCptCodeNameByLike(cptCodeName);
	}

	/**
	 * Returns a range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end) {

		return getPersistence().findByCptCodeNameByLike(
			cptCodeName, start, end);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().findByCptCodeNameByLike(
			cptCodeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param cptCodeName the cpt code name
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cpt code masters
	 */
	public static List<CptCodeMaster> findByCptCodeNameByLike(
		String cptCodeName, int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCptCodeNameByLike(
			cptCodeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByCptCodeNameByLike_First(
			String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByCptCodeNameByLike_First(
			cptCodeName, orderByComparator);
	}

	/**
	 * Returns the first cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByCptCodeNameByLike_First(
		String cptCodeName,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByCptCodeNameByLike_First(
			cptCodeName, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master
	 * @throws NoSuchCptCodeMasterException if a matching cpt code master could not be found
	 */
	public static CptCodeMaster findByCptCodeNameByLike_Last(
			String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByCptCodeNameByLike_Last(
			cptCodeName, orderByComparator);
	}

	/**
	 * Returns the last cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	public static CptCodeMaster fetchByCptCodeNameByLike_Last(
		String cptCodeName,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().fetchByCptCodeNameByLike_Last(
			cptCodeName, orderByComparator);
	}

	/**
	 * Returns the cpt code masters before and after the current cpt code master in the ordered set where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeMasterId the primary key of the current cpt code master
	 * @param cptCodeName the cpt code name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster[] findByCptCodeNameByLike_PrevAndNext(
			long cptCodeMasterId, String cptCodeName,
			OrderByComparator<CptCodeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByCptCodeNameByLike_PrevAndNext(
			cptCodeMasterId, cptCodeName, orderByComparator);
	}

	/**
	 * Removes all the cpt code masters where cptCodeName LIKE &#63; from the database.
	 *
	 * @param cptCodeName the cpt code name
	 */
	public static void removeByCptCodeNameByLike(String cptCodeName) {
		getPersistence().removeByCptCodeNameByLike(cptCodeName);
	}

	/**
	 * Returns the number of cpt code masters where cptCodeName LIKE &#63;.
	 *
	 * @param cptCodeName the cpt code name
	 * @return the number of matching cpt code masters
	 */
	public static int countByCptCodeNameByLike(String cptCodeName) {
		return getPersistence().countByCptCodeNameByLike(cptCodeName);
	}

	/**
	 * Caches the cpt code master in the entity cache if it is enabled.
	 *
	 * @param cptCodeMaster the cpt code master
	 */
	public static void cacheResult(CptCodeMaster cptCodeMaster) {
		getPersistence().cacheResult(cptCodeMaster);
	}

	/**
	 * Caches the cpt code masters in the entity cache if it is enabled.
	 *
	 * @param cptCodeMasters the cpt code masters
	 */
	public static void cacheResult(List<CptCodeMaster> cptCodeMasters) {
		getPersistence().cacheResult(cptCodeMasters);
	}

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	public static CptCodeMaster create(long cptCodeMasterId) {
		return getPersistence().create(cptCodeMasterId);
	}

	/**
	 * Removes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster remove(long cptCodeMasterId)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().remove(cptCodeMasterId);
	}

	public static CptCodeMaster updateImpl(CptCodeMaster cptCodeMaster) {
		return getPersistence().updateImpl(cptCodeMaster);
	}

	/**
	 * Returns the cpt code master with the primary key or throws a <code>NoSuchCptCodeMasterException</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws NoSuchCptCodeMasterException if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster findByPrimaryKey(long cptCodeMasterId)
		throws gov.omsb.tms.exception.NoSuchCptCodeMasterException {

		return getPersistence().findByPrimaryKey(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master, or <code>null</code> if a cpt code master with the primary key could not be found
	 */
	public static CptCodeMaster fetchByPrimaryKey(long cptCodeMasterId) {
		return getPersistence().fetchByPrimaryKey(cptCodeMasterId);
	}

	/**
	 * Returns all the cpt code masters.
	 *
	 * @return the cpt code masters
	 */
	public static List<CptCodeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	public static List<CptCodeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cpt code masters
	 */
	public static List<CptCodeMaster> findAll(
		int start, int end,
		OrderByComparator<CptCodeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cpt code masters
	 */
	public static List<CptCodeMaster> findAll(
		int start, int end, OrderByComparator<CptCodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cpt code masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CptCodeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CptCodeMasterPersistence _persistence;

}