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

import gov.omsb.tms.model.FacultyRequestRotations;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty request rotations service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyRequestRotationsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsPersistence
 * @generated
 */
public class FacultyRequestRotationsUtil {

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
		FacultyRequestRotations facultyRequestRotations) {

		getPersistence().clearCache(facultyRequestRotations);
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
	public static Map<Serializable, FacultyRequestRotations> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyRequestRotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyRequestRotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyRequestRotations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyRequestRotations update(
		FacultyRequestRotations facultyRequestRotations) {

		return getPersistence().update(facultyRequestRotations);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyRequestRotations update(
		FacultyRequestRotations facultyRequestRotations,
		ServiceContext serviceContext) {

		return getPersistence().update(facultyRequestRotations, serviceContext);
	}

	/**
	 * Returns all the faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations[] findByUuid_PrevAndNext(
			long facultyRequestRotationsId, String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_PrevAndNext(
			facultyRequestRotationsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request rotationses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the faculty request rotations where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request rotations that was removed
	 */
	public static FacultyRequestRotations removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request rotationses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations[] findByUuid_C_PrevAndNext(
			long facultyRequestRotationsId, String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			facultyRequestRotationsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request rotationses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations findByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive);
	}

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive) {

		return getPersistence().fetchByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive);
	}

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public static FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive, boolean useFinderCache) {

		return getPersistence().fetchByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive, useFinderCache);
	}

	/**
	 * Removes the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the faculty request rotations that was removed
	 */
	public static FacultyRequestRotations removeByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().removeByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive);
	}

	/**
	 * Returns the number of faculty request rotationses where facultyRequestId = &#63; and isActive = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the number of matching faculty request rotationses
	 */
	public static int countByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive) {

		return getPersistence().countByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive);
	}

	/**
	 * Caches the faculty request rotations in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 */
	public static void cacheResult(
		FacultyRequestRotations facultyRequestRotations) {

		getPersistence().cacheResult(facultyRequestRotations);
	}

	/**
	 * Caches the faculty request rotationses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotationses the faculty request rotationses
	 */
	public static void cacheResult(
		List<FacultyRequestRotations> facultyRequestRotationses) {

		getPersistence().cacheResult(facultyRequestRotationses);
	}

	/**
	 * Creates a new faculty request rotations with the primary key. Does not add the faculty request rotations to the database.
	 *
	 * @param facultyRequestRotationsId the primary key for the new faculty request rotations
	 * @return the new faculty request rotations
	 */
	public static FacultyRequestRotations create(
		long facultyRequestRotationsId) {

		return getPersistence().create(facultyRequestRotationsId);
	}

	/**
	 * Removes the faculty request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations that was removed
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations remove(long facultyRequestRotationsId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().remove(facultyRequestRotationsId);
	}

	public static FacultyRequestRotations updateImpl(
		FacultyRequestRotations facultyRequestRotations) {

		return getPersistence().updateImpl(facultyRequestRotations);
	}

	/**
	 * Returns the faculty request rotations with the primary key or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations findByPrimaryKey(
			long facultyRequestRotationsId)
		throws gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException {

		return getPersistence().findByPrimaryKey(facultyRequestRotationsId);
	}

	/**
	 * Returns the faculty request rotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations, or <code>null</code> if a faculty request rotations with the primary key could not be found
	 */
	public static FacultyRequestRotations fetchByPrimaryKey(
		long facultyRequestRotationsId) {

		return getPersistence().fetchByPrimaryKey(facultyRequestRotationsId);
	}

	/**
	 * Returns all the faculty request rotationses.
	 *
	 * @return the faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request rotationses
	 */
	public static List<FacultyRequestRotations> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty request rotationses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty request rotationses.
	 *
	 * @return the number of faculty request rotationses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyRequestRotationsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyRequestRotationsPersistence _persistence;

}