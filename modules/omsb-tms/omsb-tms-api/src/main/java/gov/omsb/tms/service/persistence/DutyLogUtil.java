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

import gov.omsb.tms.model.DutyLog;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the duty log service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.DutyLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogPersistence
 * @generated
 */
public class DutyLogUtil {

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
	public static void clearCache(DutyLog dutyLog) {
		getPersistence().clearCache(dutyLog);
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
	public static Map<Serializable, DutyLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DutyLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DutyLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DutyLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DutyLog update(DutyLog dutyLog) {
		return getPersistence().update(dutyLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DutyLog update(
		DutyLog dutyLog, ServiceContext serviceContext) {

		return getPersistence().update(dutyLog, serviceContext);
	}

	/**
	 * Returns all the duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByUuid_First(
			String uuid, OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUuid_First(
		String uuid, OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByUuid_Last(
			String uuid, OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUuid_Last(
		String uuid, OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[] findByUuid_PrevAndNext(
			long dutyLogId, String uuid,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_PrevAndNext(
			dutyLogId, uuid, orderByComparator);
	}

	/**
	 * Removes all the duty logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty logs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the duty log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log that was removed
	 */
	public static DutyLog removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of duty logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty logs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[] findByUuid_C_PrevAndNext(
			long dutyLogId, String uuid, long companyId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dutyLogId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the duty logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty logs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByTraineeIdAndStartDate(
			long traineeId, Date startDate)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByTraineeIdAndStartDate(
			traineeId, startDate);
	}

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTraineeIdAndStartDate(
		long traineeId, Date startDate) {

		return getPersistence().fetchByTraineeIdAndStartDate(
			traineeId, startDate);
	}

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTraineeIdAndStartDate(
		long traineeId, Date startDate, boolean useFinderCache) {

		return getPersistence().fetchByTraineeIdAndStartDate(
			traineeId, startDate, useFinderCache);
	}

	/**
	 * Removes the duty log where traineeId = &#63; and startDate = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the duty log that was removed
	 */
	public static DutyLog removeByTraineeIdAndStartDate(
			long traineeId, Date startDate)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().removeByTraineeIdAndStartDate(
			traineeId, startDate);
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and startDate = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the number of matching duty logs
	 */
	public static int countByTraineeIdAndStartDate(
		long traineeId, Date startDate) {

		return getPersistence().countByTraineeIdAndStartDate(
			traineeId, startDate);
	}

	/**
	 * Returns all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		return getPersistence().findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId);
	}

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end) {

		return getPersistence().findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_First(
			long traineeId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().
			findByTranieeIdAndBlocksMetadataDetailRelId_First(
				traineeId, blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_First(
		long traineeId, long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().
			fetchByTranieeIdAndBlocksMetadataDetailRelId_First(
				traineeId, blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_Last(
			long traineeId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().
			findByTranieeIdAndBlocksMetadataDetailRelId_Last(
				traineeId, blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_Last(
		long traineeId, long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().
			fetchByTranieeIdAndBlocksMetadataDetailRelId_Last(
				traineeId, blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[]
			findByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
				long dutyLogId, long traineeId, long blocksMetadataDetailRelId,
				OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().
			findByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
				dutyLogId, traineeId, blocksMetadataDetailRelId,
				orderByComparator);
	}

	/**
	 * Removes all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public static void removeByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		getPersistence().removeByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId);
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	public static int countByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId) {

		return getPersistence().countByTranieeIdAndBlocksMetadataDetailRelId(
			traineeId, blocksMetadataDetailRelId);
	}

	/**
	 * Returns all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId);
	}

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end) {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByTranieeIdAndProgramDutyAssignmentId_First(
			long traineeId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId_First(
			traineeId, programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_First(
		long traineeId, long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().
			fetchByTranieeIdAndProgramDutyAssignmentId_First(
				traineeId, programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByTranieeIdAndProgramDutyAssignmentId_Last(
			long traineeId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByTranieeIdAndProgramDutyAssignmentId_Last(
			traineeId, programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_Last(
		long traineeId, long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByTranieeIdAndProgramDutyAssignmentId_Last(
			traineeId, programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[]
			findByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
				long dutyLogId, long traineeId, long programDutyAssignmentId,
				OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().
			findByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
				dutyLogId, traineeId, programDutyAssignmentId,
				orderByComparator);
	}

	/**
	 * Removes all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	public static void removeByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		getPersistence().removeByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId);
	}

	/**
	 * Returns the number of duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	public static int countByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId) {

		return getPersistence().countByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programDutyAssignmentId);
	}

	/**
	 * Returns all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns a range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByBlocksMetadataDetailRelId_First(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByBlocksMetadataDetailRelId_First(
		long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailRelId_First(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByBlocksMetadataDetailRelId_Last(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByBlocksMetadataDetailRelId_Last(
		long blocksMetadataDetailRelId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailRelId_Last(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[] findByBlocksMetadataDetailRelId_PrevAndNext(
			long dutyLogId, long blocksMetadataDetailRelId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByBlocksMetadataDetailRelId_PrevAndNext(
			dutyLogId, blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Removes all the duty logs where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public static void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		getPersistence().removeByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns the number of duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	public static int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getPersistence().countByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	public static List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId) {

		return getPersistence().findByProgramDutyAssignmentId(
			programDutyAssignmentId);
	}

	/**
	 * Returns a range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public static List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end) {

		return getPersistence().findByProgramDutyAssignmentId(
			programDutyAssignmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findByProgramDutyAssignmentId(
			programDutyAssignmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public static List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProgramDutyAssignmentId(
			programDutyAssignmentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByProgramDutyAssignmentId_First(
			long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByProgramDutyAssignmentId_First(
			programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByProgramDutyAssignmentId_First(
		long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByProgramDutyAssignmentId_First(
			programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public static DutyLog findByProgramDutyAssignmentId_Last(
			long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByProgramDutyAssignmentId_Last(
			programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchByProgramDutyAssignmentId_Last(
		long programDutyAssignmentId,
		OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().fetchByProgramDutyAssignmentId_Last(
			programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog[] findByProgramDutyAssignmentId_PrevAndNext(
			long dutyLogId, long programDutyAssignmentId,
			OrderByComparator<DutyLog> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByProgramDutyAssignmentId_PrevAndNext(
			dutyLogId, programDutyAssignmentId, orderByComparator);
	}

	/**
	 * Removes all the duty logs where programDutyAssignmentId = &#63; from the database.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	public static void removeByProgramDutyAssignmentId(
		long programDutyAssignmentId) {

		getPersistence().removeByProgramDutyAssignmentId(
			programDutyAssignmentId);
	}

	/**
	 * Returns the number of duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	public static int countByProgramDutyAssignmentId(
		long programDutyAssignmentId) {

		return getPersistence().countByProgramDutyAssignmentId(
			programDutyAssignmentId);
	}

	/**
	 * Caches the duty log in the entity cache if it is enabled.
	 *
	 * @param dutyLog the duty log
	 */
	public static void cacheResult(DutyLog dutyLog) {
		getPersistence().cacheResult(dutyLog);
	}

	/**
	 * Caches the duty logs in the entity cache if it is enabled.
	 *
	 * @param dutyLogs the duty logs
	 */
	public static void cacheResult(List<DutyLog> dutyLogs) {
		getPersistence().cacheResult(dutyLogs);
	}

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	public static DutyLog create(long dutyLogId) {
		return getPersistence().create(dutyLogId);
	}

	/**
	 * Removes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog remove(long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().remove(dutyLogId);
	}

	public static DutyLog updateImpl(DutyLog dutyLog) {
		return getPersistence().updateImpl(dutyLog);
	}

	/**
	 * Returns the duty log with the primary key or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public static DutyLog findByPrimaryKey(long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogException {

		return getPersistence().findByPrimaryKey(dutyLogId);
	}

	/**
	 * Returns the duty log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log, or <code>null</code> if a duty log with the primary key could not be found
	 */
	public static DutyLog fetchByPrimaryKey(long dutyLogId) {
		return getPersistence().fetchByPrimaryKey(dutyLogId);
	}

	/**
	 * Returns all the duty logs.
	 *
	 * @return the duty logs
	 */
	public static List<DutyLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of duty logs
	 */
	public static List<DutyLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty logs
	 */
	public static List<DutyLog> findAll(
		int start, int end, OrderByComparator<DutyLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty logs
	 */
	public static List<DutyLog> findAll(
		int start, int end, OrderByComparator<DutyLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the duty logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DutyLogPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DutyLogPersistence _persistence;

}