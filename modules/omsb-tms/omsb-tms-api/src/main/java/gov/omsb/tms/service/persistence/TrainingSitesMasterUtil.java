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

import gov.omsb.tms.model.TrainingSitesMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the training sites master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TrainingSitesMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMasterPersistence
 * @generated
 */
public class TrainingSitesMasterUtil {

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
	public static void clearCache(TrainingSitesMaster trainingSitesMaster) {
		getPersistence().clearCache(trainingSitesMaster);
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
	public static Map<Serializable, TrainingSitesMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrainingSitesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrainingSitesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrainingSitesMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrainingSitesMaster update(
		TrainingSitesMaster trainingSitesMaster) {

		return getPersistence().update(trainingSitesMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrainingSitesMaster update(
		TrainingSitesMaster trainingSitesMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(trainingSitesMaster, serviceContext);
	}

	/**
	 * Returns all the training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByUuid_First(
			String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUuid_First(
		String uuid, OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByUuid_Last(
			String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUuid_Last(
		String uuid, OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster[] findByUuid_PrevAndNext(
			long trainingSiteMasterId, String uuid,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			trainingSiteMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the training sites masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching training sites masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the training sites master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the training sites master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the training sites master that was removed
	 */
	public static TrainingSitesMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching training sites masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster[] findByUuid_C_PrevAndNext(
			long trainingSiteMasterId, String uuid, long companyId,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			trainingSiteMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the training sites masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of training sites masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching training sites masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus) {

		return getPersistence().findByTrainingSiteStatus(trainingSiteStatus);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end) {

		return getPersistence().findByTrainingSiteStatus(
			trainingSiteStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findByTrainingSiteStatus(
			trainingSiteStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteStatus the training site status
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteStatus(
		Boolean trainingSiteStatus, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTrainingSiteStatus(
			trainingSiteStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteStatus_First(
			Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteStatus_First(
			trainingSiteStatus, orderByComparator);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteStatus_First(
		Boolean trainingSiteStatus,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteStatus_First(
			trainingSiteStatus, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteStatus_Last(
			Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteStatus_Last(
			trainingSiteStatus, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteStatus_Last(
		Boolean trainingSiteStatus,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteStatus_Last(
			trainingSiteStatus, orderByComparator);
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteStatus the training site status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster[] findByTrainingSiteStatus_PrevAndNext(
			long trainingSiteMasterId, Boolean trainingSiteStatus,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteStatus_PrevAndNext(
			trainingSiteMasterId, trainingSiteStatus, orderByComparator);
	}

	/**
	 * Removes all the training sites masters where trainingSiteStatus = &#63; from the database.
	 *
	 * @param trainingSiteStatus the training site status
	 */
	public static void removeByTrainingSiteStatus(Boolean trainingSiteStatus) {
		getPersistence().removeByTrainingSiteStatus(trainingSiteStatus);
	}

	/**
	 * Returns the number of training sites masters where trainingSiteStatus = &#63;.
	 *
	 * @param trainingSiteStatus the training site status
	 * @return the number of matching training sites masters
	 */
	public static int countByTrainingSiteStatus(Boolean trainingSiteStatus) {
		return getPersistence().countByTrainingSiteStatus(trainingSiteStatus);
	}

	/**
	 * Returns all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName) {

		return getPersistence().findByTrainingSiteNameByLike(trainingSiteName);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end) {

		return getPersistence().findByTrainingSiteNameByLike(
			trainingSiteName, start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findByTrainingSiteNameByLike(
			trainingSiteName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteName the training site name
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTrainingSiteNameByLike(
			trainingSiteName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteNameByLike_First(
			String trainingSiteName,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteNameByLike_First(
			trainingSiteName, orderByComparator);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteNameByLike_First(
		String trainingSiteName,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteNameByLike_First(
			trainingSiteName, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteNameByLike_Last(
			String trainingSiteName,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteNameByLike_Last(
			trainingSiteName, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteNameByLike_Last(
		String trainingSiteName,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteNameByLike_Last(
			trainingSiteName, orderByComparator);
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteName the training site name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster[]
			findByTrainingSiteNameByLike_PrevAndNext(
				long trainingSiteMasterId, String trainingSiteName,
				OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteNameByLike_PrevAndNext(
			trainingSiteMasterId, trainingSiteName, orderByComparator);
	}

	/**
	 * Removes all the training sites masters where trainingSiteName LIKE &#63; from the database.
	 *
	 * @param trainingSiteName the training site name
	 */
	public static void removeByTrainingSiteNameByLike(String trainingSiteName) {
		getPersistence().removeByTrainingSiteNameByLike(trainingSiteName);
	}

	/**
	 * Returns the number of training sites masters where trainingSiteName LIKE &#63;.
	 *
	 * @param trainingSiteName the training site name
	 * @return the number of matching training sites masters
	 */
	public static int countByTrainingSiteNameByLike(String trainingSiteName) {
		return getPersistence().countByTrainingSiteNameByLike(trainingSiteName);
	}

	/**
	 * Returns all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode) {

		return getPersistence().findByTrainingSiteCodeByLike(trainingSiteCode);
	}

	/**
	 * Returns a range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end) {

		return getPersistence().findByTrainingSiteCodeByLike(
			trainingSiteCode, start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findByTrainingSiteCodeByLike(
			trainingSiteCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param trainingSiteCode the training site code
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training sites masters
	 */
	public static List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTrainingSiteCodeByLike(
			trainingSiteCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteCodeByLike_First(
			String trainingSiteCode,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteCodeByLike_First(
			trainingSiteCode, orderByComparator);
	}

	/**
	 * Returns the first training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteCodeByLike_First(
		String trainingSiteCode,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteCodeByLike_First(
			trainingSiteCode, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master
	 * @throws NoSuchTrainingSitesMasterException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster findByTrainingSiteCodeByLike_Last(
			String trainingSiteCode,
			OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteCodeByLike_Last(
			trainingSiteCode, orderByComparator);
	}

	/**
	 * Returns the last training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchByTrainingSiteCodeByLike_Last(
		String trainingSiteCode,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().fetchByTrainingSiteCodeByLike_Last(
			trainingSiteCode, orderByComparator);
	}

	/**
	 * Returns the training sites masters before and after the current training sites master in the ordered set where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteMasterId the primary key of the current training sites master
	 * @param trainingSiteCode the training site code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster[]
			findByTrainingSiteCodeByLike_PrevAndNext(
				long trainingSiteMasterId, String trainingSiteCode,
				OrderByComparator<TrainingSitesMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByTrainingSiteCodeByLike_PrevAndNext(
			trainingSiteMasterId, trainingSiteCode, orderByComparator);
	}

	/**
	 * Removes all the training sites masters where trainingSiteCode LIKE &#63; from the database.
	 *
	 * @param trainingSiteCode the training site code
	 */
	public static void removeByTrainingSiteCodeByLike(String trainingSiteCode) {
		getPersistence().removeByTrainingSiteCodeByLike(trainingSiteCode);
	}

	/**
	 * Returns the number of training sites masters where trainingSiteCode LIKE &#63;.
	 *
	 * @param trainingSiteCode the training site code
	 * @return the number of matching training sites masters
	 */
	public static int countByTrainingSiteCodeByLike(String trainingSiteCode) {
		return getPersistence().countByTrainingSiteCodeByLike(trainingSiteCode);
	}

	/**
	 * Caches the training sites master in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMaster the training sites master
	 */
	public static void cacheResult(TrainingSitesMaster trainingSitesMaster) {
		getPersistence().cacheResult(trainingSitesMaster);
	}

	/**
	 * Caches the training sites masters in the entity cache if it is enabled.
	 *
	 * @param trainingSitesMasters the training sites masters
	 */
	public static void cacheResult(
		List<TrainingSitesMaster> trainingSitesMasters) {

		getPersistence().cacheResult(trainingSitesMasters);
	}

	/**
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	public static TrainingSitesMaster create(long trainingSiteMasterId) {
		return getPersistence().create(trainingSiteMasterId);
	}

	/**
	 * Removes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster remove(long trainingSiteMasterId)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().remove(trainingSiteMasterId);
	}

	public static TrainingSitesMaster updateImpl(
		TrainingSitesMaster trainingSitesMaster) {

		return getPersistence().updateImpl(trainingSitesMaster);
	}

	/**
	 * Returns the training sites master with the primary key or throws a <code>NoSuchTrainingSitesMasterException</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws NoSuchTrainingSitesMasterException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster findByPrimaryKey(
			long trainingSiteMasterId)
		throws gov.omsb.tms.exception.NoSuchTrainingSitesMasterException {

		return getPersistence().findByPrimaryKey(trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master, or <code>null</code> if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster fetchByPrimaryKey(
		long trainingSiteMasterId) {

		return getPersistence().fetchByPrimaryKey(trainingSiteMasterId);
	}

	/**
	 * Returns all the training sites masters.
	 *
	 * @return the training sites masters
	 */
	public static List<TrainingSitesMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of training sites masters
	 */
	public static List<TrainingSitesMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training sites masters
	 */
	public static List<TrainingSitesMaster> findAll(
		int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training sites masters
	 */
	public static List<TrainingSitesMaster> findAll(
		int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the training sites masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TrainingSitesMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TrainingSitesMasterPersistence _persistence;

}