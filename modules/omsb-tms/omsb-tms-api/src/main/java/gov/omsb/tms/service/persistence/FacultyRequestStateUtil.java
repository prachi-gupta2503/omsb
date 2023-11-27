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

import gov.omsb.tms.model.FacultyRequestState;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty request state service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyRequestStatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatePersistence
 * @generated
 */
public class FacultyRequestStateUtil {

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
	public static void clearCache(FacultyRequestState facultyRequestState) {
		getPersistence().clearCache(facultyRequestState);
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
	public static Map<Serializable, FacultyRequestState> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyRequestState update(
		FacultyRequestState facultyRequestState) {

		return getPersistence().update(facultyRequestState);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyRequestState update(
		FacultyRequestState facultyRequestState,
		ServiceContext serviceContext) {

		return getPersistence().update(facultyRequestState, serviceContext);
	}

	/**
	 * Returns all the faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUuid_First(
		String uuid, OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUuid_Last(
		String uuid, OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState[] findByUuid_PrevAndNext(
			long facultyRequestStateId, String uuid,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_PrevAndNext(
			facultyRequestStateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the faculty request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request states
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the faculty request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request state that was removed
	 */
	public static FacultyRequestState removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request states
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState[] findByUuid_C_PrevAndNext(
			long facultyRequestStateId, String uuid, long companyId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByUuid_C_PrevAndNext(
			facultyRequestStateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the faculty request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request states
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId) {

		return getPersistence().findByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end) {

		return getPersistence().findByfacultyRequestId(
			facultyRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findByfacultyRequestId(
			facultyRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfacultyRequestId(
			facultyRequestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByfacultyRequestId_First(
			long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestId_First(
			facultyRequestId, orderByComparator);
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByfacultyRequestId_First(
		long facultyRequestId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByfacultyRequestId_First(
			facultyRequestId, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByfacultyRequestId_Last(
			long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestId_Last(
			facultyRequestId, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByfacultyRequestId_Last(
		long facultyRequestId,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByfacultyRequestId_Last(
			facultyRequestId, orderByComparator);
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState[] findByfacultyRequestId_PrevAndNext(
			long facultyRequestStateId, long facultyRequestId,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestId_PrevAndNext(
			facultyRequestStateId, facultyRequestId, orderByComparator);
	}

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 */
	public static void removeByfacultyRequestId(long facultyRequestId) {
		getPersistence().removeByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the number of matching faculty request states
	 */
	public static int countByfacultyRequestId(long facultyRequestId) {
		return getPersistence().countByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		return getPersistence().findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy);
	}

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end) {

		return getPersistence().findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public static List<FacultyRequestState> findByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy, int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByfacultyRequestIdAndCreatedBy_First(
			long facultyRequestId, long createdBy,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestIdAndCreatedBy_First(
			facultyRequestId, createdBy, orderByComparator);
	}

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_First(
		long facultyRequestId, long createdBy,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByfacultyRequestIdAndCreatedBy_First(
			facultyRequestId, createdBy, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public static FacultyRequestState findByfacultyRequestIdAndCreatedBy_Last(
			long facultyRequestId, long createdBy,
			OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestIdAndCreatedBy_Last(
			facultyRequestId, createdBy, orderByComparator);
	}

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public static FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_Last(
		long facultyRequestId, long createdBy,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().fetchByfacultyRequestIdAndCreatedBy_Last(
			facultyRequestId, createdBy, orderByComparator);
	}

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState[]
			findByfacultyRequestIdAndCreatedBy_PrevAndNext(
				long facultyRequestStateId, long facultyRequestId,
				long createdBy,
				OrderByComparator<FacultyRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByfacultyRequestIdAndCreatedBy_PrevAndNext(
			facultyRequestStateId, facultyRequestId, createdBy,
			orderByComparator);
	}

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; and createdBy = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 */
	public static void removeByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		getPersistence().removeByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy);
	}

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the number of matching faculty request states
	 */
	public static int countByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy) {

		return getPersistence().countByfacultyRequestIdAndCreatedBy(
			facultyRequestId, createdBy);
	}

	/**
	 * Caches the faculty request state in the entity cache if it is enabled.
	 *
	 * @param facultyRequestState the faculty request state
	 */
	public static void cacheResult(FacultyRequestState facultyRequestState) {
		getPersistence().cacheResult(facultyRequestState);
	}

	/**
	 * Caches the faculty request states in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStates the faculty request states
	 */
	public static void cacheResult(
		List<FacultyRequestState> facultyRequestStates) {

		getPersistence().cacheResult(facultyRequestStates);
	}

	/**
	 * Creates a new faculty request state with the primary key. Does not add the faculty request state to the database.
	 *
	 * @param facultyRequestStateId the primary key for the new faculty request state
	 * @return the new faculty request state
	 */
	public static FacultyRequestState create(long facultyRequestStateId) {
		return getPersistence().create(facultyRequestStateId);
	}

	/**
	 * Removes the faculty request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state that was removed
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState remove(long facultyRequestStateId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().remove(facultyRequestStateId);
	}

	public static FacultyRequestState updateImpl(
		FacultyRequestState facultyRequestState) {

		return getPersistence().updateImpl(facultyRequestState);
	}

	/**
	 * Returns the faculty request state with the primary key or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState findByPrimaryKey(
			long facultyRequestStateId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestStateException {

		return getPersistence().findByPrimaryKey(facultyRequestStateId);
	}

	/**
	 * Returns the faculty request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state, or <code>null</code> if a faculty request state with the primary key could not be found
	 */
	public static FacultyRequestState fetchByPrimaryKey(
		long facultyRequestStateId) {

		return getPersistence().fetchByPrimaryKey(facultyRequestStateId);
	}

	/**
	 * Returns all the faculty request states.
	 *
	 * @return the faculty request states
	 */
	public static List<FacultyRequestState> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of faculty request states
	 */
	public static List<FacultyRequestState> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request states
	 */
	public static List<FacultyRequestState> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request states
	 */
	public static List<FacultyRequestState> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty request states from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty request states.
	 *
	 * @return the number of faculty request states
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyRequestStatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyRequestStatePersistence _persistence;

}