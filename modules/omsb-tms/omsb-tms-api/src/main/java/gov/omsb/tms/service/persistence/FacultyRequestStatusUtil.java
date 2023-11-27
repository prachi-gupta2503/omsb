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

import gov.omsb.tms.model.FacultyRequestStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty request status service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyRequestStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatusPersistence
 * @generated
 */
public class FacultyRequestStatusUtil {

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
	public static void clearCache(FacultyRequestStatus facultyRequestStatus) {
		getPersistence().clearCache(facultyRequestStatus);
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
	public static Map<Serializable, FacultyRequestStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyRequestStatus update(
		FacultyRequestStatus facultyRequestStatus) {

		return getPersistence().update(facultyRequestStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyRequestStatus update(
		FacultyRequestStatus facultyRequestStatus,
		ServiceContext serviceContext) {

		return getPersistence().update(facultyRequestStatus, serviceContext);
	}

	/**
	 * Returns all the faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public static FacultyRequestStatus[] findByUuid_PrevAndNext(
			long facultyRequestStatusId, String uuid,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			facultyRequestStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the faculty request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the faculty request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request status that was removed
	 */
	public static FacultyRequestStatus removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request statuses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	public static List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public static FacultyRequestStatus[] findByUuid_C_PrevAndNext(
			long facultyRequestStatusId, String uuid, long companyId,
			OrderByComparator<FacultyRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByUuid_C_PrevAndNext(
			facultyRequestStatusId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the faculty request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request statuses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the faculty request status where code = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus findByCode(String code)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public static FacultyRequestStatus fetchByCode(
		String code, boolean useFinderCache) {

		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the faculty request status where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty request status that was removed
	 */
	public static FacultyRequestStatus removeByCode(String code)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of faculty request statuses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty request statuses
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the faculty request status in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatus the faculty request status
	 */
	public static void cacheResult(FacultyRequestStatus facultyRequestStatus) {
		getPersistence().cacheResult(facultyRequestStatus);
	}

	/**
	 * Caches the faculty request statuses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatuses the faculty request statuses
	 */
	public static void cacheResult(
		List<FacultyRequestStatus> facultyRequestStatuses) {

		getPersistence().cacheResult(facultyRequestStatuses);
	}

	/**
	 * Creates a new faculty request status with the primary key. Does not add the faculty request status to the database.
	 *
	 * @param facultyRequestStatusId the primary key for the new faculty request status
	 * @return the new faculty request status
	 */
	public static FacultyRequestStatus create(long facultyRequestStatusId) {
		return getPersistence().create(facultyRequestStatusId);
	}

	/**
	 * Removes the faculty request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status that was removed
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public static FacultyRequestStatus remove(long facultyRequestStatusId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().remove(facultyRequestStatusId);
	}

	public static FacultyRequestStatus updateImpl(
		FacultyRequestStatus facultyRequestStatus) {

		return getPersistence().updateImpl(facultyRequestStatus);
	}

	/**
	 * Returns the faculty request status with the primary key or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public static FacultyRequestStatus findByPrimaryKey(
			long facultyRequestStatusId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStatusException {

		return getPersistence().findByPrimaryKey(facultyRequestStatusId);
	}

	/**
	 * Returns the faculty request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status, or <code>null</code> if a faculty request status with the primary key could not be found
	 */
	public static FacultyRequestStatus fetchByPrimaryKey(
		long facultyRequestStatusId) {

		return getPersistence().fetchByPrimaryKey(facultyRequestStatusId);
	}

	/**
	 * Returns all the faculty request statuses.
	 *
	 * @return the faculty request statuses
	 */
	public static List<FacultyRequestStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of faculty request statuses
	 */
	public static List<FacultyRequestStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request statuses
	 */
	public static List<FacultyRequestStatus> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request statuses
	 */
	public static List<FacultyRequestStatus> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty request statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty request statuses.
	 *
	 * @return the number of faculty request statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyRequestStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyRequestStatusPersistence _persistence;

}