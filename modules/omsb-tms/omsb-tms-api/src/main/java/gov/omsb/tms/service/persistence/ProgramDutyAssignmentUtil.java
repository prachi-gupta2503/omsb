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

import gov.omsb.tms.model.ProgramDutyAssignment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program duty assignment service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramDutyAssignmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignmentPersistence
 * @generated
 */
public class ProgramDutyAssignmentUtil {

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
	public static void clearCache(ProgramDutyAssignment programDutyAssignment) {
		getPersistence().clearCache(programDutyAssignment);
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
	public static Map<Serializable, ProgramDutyAssignment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramDutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramDutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramDutyAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramDutyAssignment update(
		ProgramDutyAssignment programDutyAssignment) {

		return getPersistence().update(programDutyAssignment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramDutyAssignment update(
		ProgramDutyAssignment programDutyAssignment,
		ServiceContext serviceContext) {

		return getPersistence().update(programDutyAssignment, serviceContext);
	}

	/**
	 * Returns all the program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByUuid_First(
			String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[] findByUuid_PrevAndNext(
			long programDutyAssignmentId, String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_PrevAndNext(
			programDutyAssignmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty assignments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty assignment that was removed
	 */
	public static ProgramDutyAssignment removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[] findByUuid_C_PrevAndNext(
			long programDutyAssignmentId, String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programDutyAssignmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId) {

		return getPersistence().findByDutyAssignmentId(dutyAssignmentId);
	}

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end) {

		return getPersistence().findByDutyAssignmentId(
			dutyAssignmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByDutyAssignmentId(
			dutyAssignmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDutyAssignmentId(
			dutyAssignmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByDutyAssignmentId_First(
			long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentId_First(
			dutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByDutyAssignmentId_First(
		long dutyAssignmentId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyAssignmentId_First(
			dutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByDutyAssignmentId_Last(
			long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentId_Last(
			dutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByDutyAssignmentId_Last(
		long dutyAssignmentId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyAssignmentId_Last(
			dutyAssignmentId, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[] findByDutyAssignmentId_PrevAndNext(
			long programDutyAssignmentId, long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentId_PrevAndNext(
			programDutyAssignmentId, dutyAssignmentId, orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 */
	public static void removeByDutyAssignmentId(long dutyAssignmentId) {
		getPersistence().removeByDutyAssignmentId(dutyAssignmentId);
	}

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByDutyAssignmentId(long dutyAssignmentId) {
		return getPersistence().countByDutyAssignmentId(dutyAssignmentId);
	}

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		return getPersistence().findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status);
	}

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end) {

		return getPersistence().findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByDutyAssignmentIdAndStatus_First(
			long dutyAssignmentId, String status,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentIdAndStatus_First(
			dutyAssignmentId, status, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_First(
		long dutyAssignmentId, String status,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyAssignmentIdAndStatus_First(
			dutyAssignmentId, status, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByDutyAssignmentIdAndStatus_Last(
			long dutyAssignmentId, String status,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentIdAndStatus_Last(
			dutyAssignmentId, status, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_Last(
		long dutyAssignmentId, String status,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByDutyAssignmentIdAndStatus_Last(
			dutyAssignmentId, status, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[]
			findByDutyAssignmentIdAndStatus_PrevAndNext(
				long programDutyAssignmentId, long dutyAssignmentId,
				String status,
				OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByDutyAssignmentIdAndStatus_PrevAndNext(
			programDutyAssignmentId, dutyAssignmentId, status,
			orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 */
	public static void removeByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		getPersistence().removeByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status);
	}

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the number of matching program duty assignments
	 */
	public static int countByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		return getPersistence().countByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status);
	}

	/**
	 * Returns all the program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramId(long programId) {
		return getPersistence().findByProgramId(programId);
	}

	/**
	 * Returns a range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end) {

		return getPersistence().findByProgramId(programId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByProgramId(
			programId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramId(
			programId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByProgramId_First(
			long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramId_First(
			programId, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByProgramId_First(
		long programId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByProgramId_First(
			programId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByProgramId_Last(
			long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramId_Last(
			programId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByProgramId_Last(
		long programId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByProgramId_Last(
			programId, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[] findByProgramId_PrevAndNext(
			long programDutyAssignmentId, long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramId_PrevAndNext(
			programDutyAssignmentId, programId, orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	public static void removeByProgramId(long programId) {
		getPersistence().removeByProgramId(programId);
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByProgramId(long programId) {
		return getPersistence().countByProgramId(programId);
	}

	/**
	 * Returns all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId) {

		return getPersistence().findByProgramIdAndCohortId(programId, cohortId);
	}

	/**
	 * Returns a range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public static List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramIdAndCohortId_First(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByProgramIdAndCohortId_First(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramIdAndCohortId_Last(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().fetchByProgramIdAndCohortId_Last(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment[]
			findByProgramIdAndCohortId_PrevAndNext(
				long programDutyAssignmentId, long programId, long cohortId,
				OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramIdAndCohortId_PrevAndNext(
			programDutyAssignmentId, programId, cohortId, orderByComparator);
	}

	/**
	 * Removes all the program duty assignments where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	public static void removeByProgramIdAndCohortId(
		long programId, long cohortId) {

		getPersistence().removeByProgramIdAndCohortId(programId, cohortId);
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByProgramIdAndCohortId(
		long programId, long cohortId) {

		return getPersistence().countByProgramIdAndCohortId(
			programId, cohortId);
	}

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment findByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId);
	}

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment
		fetchByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId) {

		return getPersistence().fetchByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId);
	}

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public static ProgramDutyAssignment
		fetchByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId, useFinderCache);
	}

	/**
	 * Removes the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the program duty assignment that was removed
	 */
	public static ProgramDutyAssignment
			removeByProgramIdDutyAssignmentIdCohortId(
				long programId, long dutyAssignmentId, long cohortId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().removeByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId);
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	public static int countByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId) {

		return getPersistence().countByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId);
	}

	/**
	 * Caches the program duty assignment in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignment the program duty assignment
	 */
	public static void cacheResult(
		ProgramDutyAssignment programDutyAssignment) {

		getPersistence().cacheResult(programDutyAssignment);
	}

	/**
	 * Caches the program duty assignments in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignments the program duty assignments
	 */
	public static void cacheResult(
		List<ProgramDutyAssignment> programDutyAssignments) {

		getPersistence().cacheResult(programDutyAssignments);
	}

	/**
	 * Creates a new program duty assignment with the primary key. Does not add the program duty assignment to the database.
	 *
	 * @param programDutyAssignmentId the primary key for the new program duty assignment
	 * @return the new program duty assignment
	 */
	public static ProgramDutyAssignment create(long programDutyAssignmentId) {
		return getPersistence().create(programDutyAssignmentId);
	}

	/**
	 * Removes the program duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment that was removed
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment remove(long programDutyAssignmentId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().remove(programDutyAssignmentId);
	}

	public static ProgramDutyAssignment updateImpl(
		ProgramDutyAssignment programDutyAssignment) {

		return getPersistence().updateImpl(programDutyAssignment);
	}

	/**
	 * Returns the program duty assignment with the primary key or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment findByPrimaryKey(
			long programDutyAssignmentId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException {

		return getPersistence().findByPrimaryKey(programDutyAssignmentId);
	}

	/**
	 * Returns the program duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment, or <code>null</code> if a program duty assignment with the primary key could not be found
	 */
	public static ProgramDutyAssignment fetchByPrimaryKey(
		long programDutyAssignmentId) {

		return getPersistence().fetchByPrimaryKey(programDutyAssignmentId);
	}

	/**
	 * Returns all the program duty assignments.
	 *
	 * @return the program duty assignments
	 */
	public static List<ProgramDutyAssignment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of program duty assignments
	 */
	public static List<ProgramDutyAssignment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duty assignments
	 */
	public static List<ProgramDutyAssignment> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duty assignments
	 */
	public static List<ProgramDutyAssignment> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program duty assignments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program duty assignments.
	 *
	 * @return the number of program duty assignments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramDutyAssignmentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramDutyAssignmentPersistence _persistence;

}