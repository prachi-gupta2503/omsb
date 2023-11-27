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

import gov.omsb.tms.model.DutyAssignment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the duty assignment service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.DutyAssignmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentPersistence
 * @generated
 */
public class DutyAssignmentUtil {

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
	public static void clearCache(DutyAssignment dutyAssignment) {
		getPersistence().clearCache(dutyAssignment);
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
	public static Map<Serializable, DutyAssignment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DutyAssignment update(DutyAssignment dutyAssignment) {
		return getPersistence().update(dutyAssignment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DutyAssignment update(
		DutyAssignment dutyAssignment, ServiceContext serviceContext) {

		return getPersistence().update(dutyAssignment, serviceContext);
	}

	/**
	 * Returns all the duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByUuid_First(
			String uuid, OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUuid_First(
		String uuid, OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByUuid_Last(
			String uuid, OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUuid_Last(
		String uuid, OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment[] findByUuid_PrevAndNext(
			long dutyAssignmentId, String uuid,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_PrevAndNext(
			dutyAssignmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty assignments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty assignment that was removed
	 */
	public static DutyAssignment removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty assignments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment[] findByUuid_C_PrevAndNext(
			long dutyAssignmentId, String uuid, long companyId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dutyAssignmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty assignments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeId(long dutyTypeId) {
		return getPersistence().findByDutyTypeId(dutyTypeId);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end) {

		return getPersistence().findByDutyTypeId(dutyTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findByDutyTypeId(
			dutyTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDutyTypeId(
			dutyTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeId_First(
			long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeId_First(
			dutyTypeId, orderByComparator);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeId_First(
		long dutyTypeId, OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeId_First(
			dutyTypeId, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeId_Last(
			long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeId_Last(
			dutyTypeId, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeId_Last(
		long dutyTypeId, OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeId_Last(
			dutyTypeId, orderByComparator);
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment[] findByDutyTypeId_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeId_PrevAndNext(
			dutyAssignmentId, dutyTypeId, orderByComparator);
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 */
	public static void removeByDutyTypeId(long dutyTypeId) {
		getPersistence().removeByDutyTypeId(dutyTypeId);
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the number of matching duty assignments
	 */
	public static int countByDutyTypeId(long dutyTypeId) {
		return getPersistence().countByDutyTypeId(dutyTypeId);
	}

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status) {

		return getPersistence().findByDutyTypeIdAndStatus(dutyTypeId, status);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end) {

		return getPersistence().findByDutyTypeIdAndStatus(
			dutyTypeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findByDutyTypeIdAndStatus(
			dutyTypeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDutyTypeIdAndStatus(
			dutyTypeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeIdAndStatus_First(
			long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndStatus_First(
			dutyTypeId, status, orderByComparator);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeIdAndStatus_First(
		long dutyTypeId, String status,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeIdAndStatus_First(
			dutyTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeIdAndStatus_Last(
			long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndStatus_Last(
			dutyTypeId, status, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeIdAndStatus_Last(
		long dutyTypeId, String status,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeIdAndStatus_Last(
			dutyTypeId, status, orderByComparator);
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment[] findByDutyTypeIdAndStatus_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String status,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndStatus_PrevAndNext(
			dutyAssignmentId, dutyTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 */
	public static void removeByDutyTypeIdAndStatus(
		long dutyTypeId, String status) {

		getPersistence().removeByDutyTypeIdAndStatus(dutyTypeId, status);
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the number of matching duty assignments
	 */
	public static int countByDutyTypeIdAndStatus(
		long dutyTypeId, String status) {

		return getPersistence().countByDutyTypeIdAndStatus(dutyTypeId, status);
	}

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		return getPersistence().findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment);
	}

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end) {

		return getPersistence().findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public static List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeIdAndAssignment_First(
			long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndAssignment_First(
			dutyTypeId, assignment, orderByComparator);
	}

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeIdAndAssignment_First(
		long dutyTypeId, String assignment,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeIdAndAssignment_First(
			dutyTypeId, assignment, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public static DutyAssignment findByDutyTypeIdAndAssignment_Last(
			long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndAssignment_Last(
			dutyTypeId, assignment, orderByComparator);
	}

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public static DutyAssignment fetchByDutyTypeIdAndAssignment_Last(
		long dutyTypeId, String assignment,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyTypeIdAndAssignment_Last(
			dutyTypeId, assignment, orderByComparator);
	}

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment[] findByDutyTypeIdAndAssignment_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String assignment,
			OrderByComparator<DutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByDutyTypeIdAndAssignment_PrevAndNext(
			dutyAssignmentId, dutyTypeId, assignment, orderByComparator);
	}

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and assignment = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 */
	public static void removeByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		getPersistence().removeByDutyTypeIdAndAssignment(
			dutyTypeId, assignment);
	}

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the number of matching duty assignments
	 */
	public static int countByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment) {

		return getPersistence().countByDutyTypeIdAndAssignment(
			dutyTypeId, assignment);
	}

	/**
	 * Caches the duty assignment in the entity cache if it is enabled.
	 *
	 * @param dutyAssignment the duty assignment
	 */
	public static void cacheResult(DutyAssignment dutyAssignment) {
		getPersistence().cacheResult(dutyAssignment);
	}

	/**
	 * Caches the duty assignments in the entity cache if it is enabled.
	 *
	 * @param dutyAssignments the duty assignments
	 */
	public static void cacheResult(List<DutyAssignment> dutyAssignments) {
		getPersistence().cacheResult(dutyAssignments);
	}

	/**
	 * Creates a new duty assignment with the primary key. Does not add the duty assignment to the database.
	 *
	 * @param dutyAssignmentId the primary key for the new duty assignment
	 * @return the new duty assignment
	 */
	public static DutyAssignment create(long dutyAssignmentId) {
		return getPersistence().create(dutyAssignmentId);
	}

	/**
	 * Removes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment remove(long dutyAssignmentId)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().remove(dutyAssignmentId);
	}

	public static DutyAssignment updateImpl(DutyAssignment dutyAssignment) {
		return getPersistence().updateImpl(dutyAssignment);
	}

	/**
	 * Returns the duty assignment with the primary key or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment findByPrimaryKey(long dutyAssignmentId)
		throws gov.omsb.tms.exception.NoSuchDutyAssignmentException {

		return getPersistence().findByPrimaryKey(dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment, or <code>null</code> if a duty assignment with the primary key could not be found
	 */
	public static DutyAssignment fetchByPrimaryKey(long dutyAssignmentId) {
		return getPersistence().fetchByPrimaryKey(dutyAssignmentId);
	}

	/**
	 * Returns all the duty assignments.
	 *
	 * @return the duty assignments
	 */
	public static List<DutyAssignment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of duty assignments
	 */
	public static List<DutyAssignment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty assignments
	 */
	public static List<DutyAssignment> findAll(
		int start, int end,
		OrderByComparator<DutyAssignment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty assignments
	 */
	public static List<DutyAssignment> findAll(
		int start, int end, OrderByComparator<DutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the duty assignments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of duty assignments.
	 *
	 * @return the number of duty assignments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DutyAssignmentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DutyAssignmentPersistence _persistence;

}