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

import gov.omsb.tms.model.DutyLogViolation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the duty log violation service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.DutyLogViolationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationPersistence
 * @generated
 */
public class DutyLogViolationUtil {

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
	public static void clearCache(DutyLogViolation dutyLogViolation) {
		getPersistence().clearCache(dutyLogViolation);
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
	public static Map<Serializable, DutyLogViolation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DutyLogViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DutyLogViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DutyLogViolation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DutyLogViolation update(DutyLogViolation dutyLogViolation) {
		return getPersistence().update(dutyLogViolation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DutyLogViolation update(
		DutyLogViolation dutyLogViolation, ServiceContext serviceContext) {

		return getPersistence().update(dutyLogViolation, serviceContext);
	}

	/**
	 * Returns all the duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByUuid_First(
			String uuid, OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUuid_First(
		String uuid, OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByUuid_Last(
			String uuid, OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUuid_Last(
		String uuid, OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation[] findByUuid_PrevAndNext(
			long ViolationId, String uuid,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_PrevAndNext(
			ViolationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the duty log violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty log violations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the duty log violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log violation that was removed
	 */
	public static DutyLogViolation removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty log violations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation[] findByUuid_C_PrevAndNext(
			long ViolationId, String uuid, long companyId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ViolationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the duty log violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty log violations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByTraineeId(long traineeId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByTraineeId(traineeId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeId(long traineeId) {
		return getPersistence().fetchByTraineeId(traineeId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeId(
		long traineeId, boolean useFinderCache) {

		return getPersistence().fetchByTraineeId(traineeId, useFinderCache);
	}

	/**
	 * Removes the duty log violation where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the duty log violation that was removed
	 */
	public static DutyLogViolation removeByTraineeId(long traineeId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().removeByTraineeId(traineeId);
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching duty log violations
	 */
	public static int countByTraineeId(long traineeId) {
		return getPersistence().countByTraineeId(traineeId);
	}

	/**
	 * Returns all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the matching duty log violations
	 */
	public static List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId) {

		return getPersistence().findByTraineeIdAndBlockId(traineeId, blockId);
	}

	/**
	 * Returns a range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end) {

		return getPersistence().findByTraineeIdAndBlockId(
			traineeId, blockId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().findByTraineeIdAndBlockId(
			traineeId, blockId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public static List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTraineeIdAndBlockId(
			traineeId, blockId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByTraineeIdAndBlockId_First(
			long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByTraineeIdAndBlockId_First(
			traineeId, blockId, orderByComparator);
	}

	/**
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeIdAndBlockId_First(
		long traineeId, long blockId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByTraineeIdAndBlockId_First(
			traineeId, blockId, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByTraineeIdAndBlockId_Last(
			long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByTraineeIdAndBlockId_Last(
			traineeId, blockId, orderByComparator);
	}

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeIdAndBlockId_Last(
		long traineeId, long blockId,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().fetchByTraineeIdAndBlockId_Last(
			traineeId, blockId, orderByComparator);
	}

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation[] findByTraineeIdAndBlockId_PrevAndNext(
			long ViolationId, long traineeId, long blockId,
			OrderByComparator<DutyLogViolation> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByTraineeIdAndBlockId_PrevAndNext(
			ViolationId, traineeId, blockId, orderByComparator);
	}

	/**
	 * Removes all the duty log violations where traineeId = &#63; and blockId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 */
	public static void removeByTraineeIdAndBlockId(
		long traineeId, long blockId) {

		getPersistence().removeByTraineeIdAndBlockId(traineeId, blockId);
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the number of matching duty log violations
	 */
	public static int countByTraineeIdAndBlockId(long traineeId, long blockId) {
		return getPersistence().countByTraineeIdAndBlockId(traineeId, blockId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId, long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId) {

		return getPersistence().fetchByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId);
	}

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId,
		boolean useFinderCache) {

		return getPersistence().fetchByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId, useFinderCache);
	}

	/**
	 * Removes the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	public static DutyLogViolation
			removeByTraineeAndBlockAndProgramAndDutyLogId(
				long traineeId, long blockId, long programMasterId,
				long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().removeByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId);
	}

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	public static int countByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId) {

		return getPersistence().countByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId);
	}

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation findByDutyLogId(long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByDutyLogId(dutyLogId);
	}

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByDutyLogId(long dutyLogId) {
		return getPersistence().fetchByDutyLogId(dutyLogId);
	}

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchByDutyLogId(
		long dutyLogId, boolean useFinderCache) {

		return getPersistence().fetchByDutyLogId(dutyLogId, useFinderCache);
	}

	/**
	 * Removes the duty log violation where dutyLogId = &#63; from the database.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	public static DutyLogViolation removeByDutyLogId(long dutyLogId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().removeByDutyLogId(dutyLogId);
	}

	/**
	 * Returns the number of duty log violations where dutyLogId = &#63;.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	public static int countByDutyLogId(long dutyLogId) {
		return getPersistence().countByDutyLogId(dutyLogId);
	}

	/**
	 * Caches the duty log violation in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolation the duty log violation
	 */
	public static void cacheResult(DutyLogViolation dutyLogViolation) {
		getPersistence().cacheResult(dutyLogViolation);
	}

	/**
	 * Caches the duty log violations in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolations the duty log violations
	 */
	public static void cacheResult(List<DutyLogViolation> dutyLogViolations) {
		getPersistence().cacheResult(dutyLogViolations);
	}

	/**
	 * Creates a new duty log violation with the primary key. Does not add the duty log violation to the database.
	 *
	 * @param ViolationId the primary key for the new duty log violation
	 * @return the new duty log violation
	 */
	public static DutyLogViolation create(long ViolationId) {
		return getPersistence().create(ViolationId);
	}

	/**
	 * Removes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation remove(long ViolationId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().remove(ViolationId);
	}

	public static DutyLogViolation updateImpl(
		DutyLogViolation dutyLogViolation) {

		return getPersistence().updateImpl(dutyLogViolation);
	}

	/**
	 * Returns the duty log violation with the primary key or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation findByPrimaryKey(long ViolationId)
		throws gov.omsb.tms.exception.NoSuchDutyLogViolationException {

		return getPersistence().findByPrimaryKey(ViolationId);
	}

	/**
	 * Returns the duty log violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation, or <code>null</code> if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation fetchByPrimaryKey(long ViolationId) {
		return getPersistence().fetchByPrimaryKey(ViolationId);
	}

	/**
	 * Returns all the duty log violations.
	 *
	 * @return the duty log violations
	 */
	public static List<DutyLogViolation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of duty log violations
	 */
	public static List<DutyLogViolation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty log violations
	 */
	public static List<DutyLogViolation> findAll(
		int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty log violations
	 */
	public static List<DutyLogViolation> findAll(
		int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the duty log violations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DutyLogViolationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DutyLogViolationPersistence _persistence;

}