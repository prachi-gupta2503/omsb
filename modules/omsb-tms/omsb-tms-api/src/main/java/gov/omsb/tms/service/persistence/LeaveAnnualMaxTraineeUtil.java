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

import gov.omsb.tms.model.LeaveAnnualMaxTrainee;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave annual max trainee service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.LeaveAnnualMaxTraineePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTraineePersistence
 * @generated
 */
public class LeaveAnnualMaxTraineeUtil {

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
	public static void clearCache(LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {
		getPersistence().clearCache(leaveAnnualMaxTrainee);
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
	public static Map<Serializable, LeaveAnnualMaxTrainee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveAnnualMaxTrainee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveAnnualMaxTrainee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveAnnualMaxTrainee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveAnnualMaxTrainee update(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return getPersistence().update(leaveAnnualMaxTrainee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveAnnualMaxTrainee update(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee,
		ServiceContext serviceContext) {

		return getPersistence().update(leaveAnnualMaxTrainee, serviceContext);
	}

	/**
	 * Returns all the leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee findByUuid_First(
			String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUuid_First(
		String uuid,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUuid_Last(
		String uuid,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public static LeaveAnnualMaxTrainee[] findByUuid_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveAnnualMaxTraineeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual max trainees
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave annual max trainee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual max trainee that was removed
	 */
	public static LeaveAnnualMaxTrainee removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual max trainees
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public static LeaveAnnualMaxTrainee[] findByUuid_C_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid, long companyId,
			OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveAnnualMaxTraineeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual max trainees
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the leave annual max trainee in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 */
	public static void cacheResult(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		getPersistence().cacheResult(leaveAnnualMaxTrainee);
	}

	/**
	 * Caches the leave annual max trainees in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainees the leave annual max trainees
	 */
	public static void cacheResult(
		List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees) {

		getPersistence().cacheResult(leaveAnnualMaxTrainees);
	}

	/**
	 * Creates a new leave annual max trainee with the primary key. Does not add the leave annual max trainee to the database.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key for the new leave annual max trainee
	 * @return the new leave annual max trainee
	 */
	public static LeaveAnnualMaxTrainee create(long leaveAnnualMaxTraineeId) {
		return getPersistence().create(leaveAnnualMaxTraineeId);
	}

	/**
	 * Removes the leave annual max trainee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public static LeaveAnnualMaxTrainee remove(long leaveAnnualMaxTraineeId)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().remove(leaveAnnualMaxTraineeId);
	}

	public static LeaveAnnualMaxTrainee updateImpl(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return getPersistence().updateImpl(leaveAnnualMaxTrainee);
	}

	/**
	 * Returns the leave annual max trainee with the primary key or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public static LeaveAnnualMaxTrainee findByPrimaryKey(
			long leaveAnnualMaxTraineeId)
		throws gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException {

		return getPersistence().findByPrimaryKey(leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns the leave annual max trainee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee, or <code>null</code> if a leave annual max trainee with the primary key could not be found
	 */
	public static LeaveAnnualMaxTrainee fetchByPrimaryKey(
		long leaveAnnualMaxTraineeId) {

		return getPersistence().fetchByPrimaryKey(leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns all the leave annual max trainees.
	 *
	 * @return the leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual max trainees
	 */
	public static List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		OrderByComparator<LeaveAnnualMaxTrainee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave annual max trainees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave annual max trainees.
	 *
	 * @return the number of leave annual max trainees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveAnnualMaxTraineePersistence getPersistence() {
		return _persistence;
	}

	private static volatile LeaveAnnualMaxTraineePersistence _persistence;

}