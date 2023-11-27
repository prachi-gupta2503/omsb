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

import gov.omsb.tms.model.LeaveTypes;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave types service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.LeaveTypesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypesPersistence
 * @generated
 */
public class LeaveTypesUtil {

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
	public static void clearCache(LeaveTypes leaveTypes) {
		getPersistence().clearCache(leaveTypes);
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
	public static Map<Serializable, LeaveTypes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveTypes update(LeaveTypes leaveTypes) {
		return getPersistence().update(leaveTypes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveTypes update(
		LeaveTypes leaveTypes, ServiceContext serviceContext) {

		return getPersistence().update(leaveTypes, serviceContext);
	}

	/**
	 * Returns all the leave typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public static LeaveTypes findByUuid_First(
			String uuid, OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUuid_First(
		String uuid, OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public static LeaveTypes findByUuid_Last(
			String uuid, OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave typeses before and after the current leave types in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTypesId the primary key of the current leave types
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public static LeaveTypes[] findByUuid_PrevAndNext(
			long leaveTypesId, String uuid,
			OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveTypesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave typeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave typeses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTypesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public static LeaveTypes findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave types where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave types that was removed
	 */
	public static LeaveTypes removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave typeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave typeses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave typeses
	 */
	public static List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public static LeaveTypes findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public static LeaveTypes findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public static LeaveTypes fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave typeses before and after the current leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTypesId the primary key of the current leave types
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public static LeaveTypes[] findByUuid_C_PrevAndNext(
			long leaveTypesId, String uuid, long companyId,
			OrderByComparator<LeaveTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveTypesId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave typeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave typeses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the leave types in the entity cache if it is enabled.
	 *
	 * @param leaveTypes the leave types
	 */
	public static void cacheResult(LeaveTypes leaveTypes) {
		getPersistence().cacheResult(leaveTypes);
	}

	/**
	 * Caches the leave typeses in the entity cache if it is enabled.
	 *
	 * @param leaveTypeses the leave typeses
	 */
	public static void cacheResult(List<LeaveTypes> leaveTypeses) {
		getPersistence().cacheResult(leaveTypeses);
	}

	/**
	 * Creates a new leave types with the primary key. Does not add the leave types to the database.
	 *
	 * @param leaveTypesId the primary key for the new leave types
	 * @return the new leave types
	 */
	public static LeaveTypes create(long leaveTypesId) {
		return getPersistence().create(leaveTypesId);
	}

	/**
	 * Removes the leave types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types that was removed
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public static LeaveTypes remove(long leaveTypesId)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().remove(leaveTypesId);
	}

	public static LeaveTypes updateImpl(LeaveTypes leaveTypes) {
		return getPersistence().updateImpl(leaveTypes);
	}

	/**
	 * Returns the leave types with the primary key or throws a <code>NoSuchLeaveTypesException</code> if it could not be found.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public static LeaveTypes findByPrimaryKey(long leaveTypesId)
		throws gov.omsb.tms.exception.NoSuchLeaveTypesException {

		return getPersistence().findByPrimaryKey(leaveTypesId);
	}

	/**
	 * Returns the leave types with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types, or <code>null</code> if a leave types with the primary key could not be found
	 */
	public static LeaveTypes fetchByPrimaryKey(long leaveTypesId) {
		return getPersistence().fetchByPrimaryKey(leaveTypesId);
	}

	/**
	 * Returns all the leave typeses.
	 *
	 * @return the leave typeses
	 */
	public static List<LeaveTypes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of leave typeses
	 */
	public static List<LeaveTypes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave typeses
	 */
	public static List<LeaveTypes> findAll(
		int start, int end, OrderByComparator<LeaveTypes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave typeses
	 */
	public static List<LeaveTypes> findAll(
		int start, int end, OrderByComparator<LeaveTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave typeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave typeses.
	 *
	 * @return the number of leave typeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveTypesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LeaveTypesPersistence _persistence;

}