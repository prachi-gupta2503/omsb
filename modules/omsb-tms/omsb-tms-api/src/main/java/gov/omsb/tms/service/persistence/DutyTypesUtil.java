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

import gov.omsb.tms.model.DutyTypes;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the duty types service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.DutyTypesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypesPersistence
 * @generated
 */
public class DutyTypesUtil {

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
	public static void clearCache(DutyTypes dutyTypes) {
		getPersistence().clearCache(dutyTypes);
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
	public static Map<Serializable, DutyTypes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DutyTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DutyTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DutyTypes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DutyTypes update(DutyTypes dutyTypes) {
		return getPersistence().update(dutyTypes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DutyTypes update(
		DutyTypes dutyTypes, ServiceContext serviceContext) {

		return getPersistence().update(dutyTypes, serviceContext);
	}

	/**
	 * Returns all the duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty typeses
	 */
	public static List<DutyTypes> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByUuid_First(
			String uuid, OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUuid_First(
		String uuid, OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByUuid_Last(
			String uuid, OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUuid_Last(
		String uuid, OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public static DutyTypes[] findByUuid_PrevAndNext(
			long dutyTypeId, String uuid,
			OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_PrevAndNext(
			dutyTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the duty typeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty typeses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the duty types where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty types that was removed
	 */
	public static DutyTypes removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty typeses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty typeses
	 */
	public static List<DutyTypes> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty typeses
	 */
	public static List<DutyTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the duty typeses before and after the current duty types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyTypeId the primary key of the current duty types
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public static DutyTypes[] findByUuid_C_PrevAndNext(
			long dutyTypeId, String uuid, long companyId,
			OrderByComparator<DutyTypes> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dutyTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the duty typeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of duty typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty typeses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the duty types where dutyType = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByDutyType(String dutyType)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByDutyType(dutyType);
	}

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByDutyType(String dutyType) {
		return getPersistence().fetchByDutyType(dutyType);
	}

	/**
	 * Returns the duty types where dutyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByDutyType(
		String dutyType, boolean useFinderCache) {

		return getPersistence().fetchByDutyType(dutyType, useFinderCache);
	}

	/**
	 * Removes the duty types where dutyType = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @return the duty types that was removed
	 */
	public static DutyTypes removeByDutyType(String dutyType)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().removeByDutyType(dutyType);
	}

	/**
	 * Returns the number of duty typeses where dutyType = &#63;.
	 *
	 * @param dutyType the duty type
	 * @return the number of matching duty typeses
	 */
	public static int countByDutyType(String dutyType) {
		return getPersistence().countByDutyType(dutyType);
	}

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types
	 * @throws NoSuchDutyTypesException if a matching duty types could not be found
	 */
	public static DutyTypes findByDutyTypeAndStatus(
			String dutyType, String status)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByDutyTypeAndStatus(dutyType, status);
	}

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByDutyTypeAndStatus(
		String dutyType, String status) {

		return getPersistence().fetchByDutyTypeAndStatus(dutyType, status);
	}

	/**
	 * Returns the duty types where dutyType = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	public static DutyTypes fetchByDutyTypeAndStatus(
		String dutyType, String status, boolean useFinderCache) {

		return getPersistence().fetchByDutyTypeAndStatus(
			dutyType, status, useFinderCache);
	}

	/**
	 * Removes the duty types where dutyType = &#63; and status = &#63; from the database.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the duty types that was removed
	 */
	public static DutyTypes removeByDutyTypeAndStatus(
			String dutyType, String status)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().removeByDutyTypeAndStatus(dutyType, status);
	}

	/**
	 * Returns the number of duty typeses where dutyType = &#63; and status = &#63;.
	 *
	 * @param dutyType the duty type
	 * @param status the status
	 * @return the number of matching duty typeses
	 */
	public static int countByDutyTypeAndStatus(String dutyType, String status) {
		return getPersistence().countByDutyTypeAndStatus(dutyType, status);
	}

	/**
	 * Caches the duty types in the entity cache if it is enabled.
	 *
	 * @param dutyTypes the duty types
	 */
	public static void cacheResult(DutyTypes dutyTypes) {
		getPersistence().cacheResult(dutyTypes);
	}

	/**
	 * Caches the duty typeses in the entity cache if it is enabled.
	 *
	 * @param dutyTypeses the duty typeses
	 */
	public static void cacheResult(List<DutyTypes> dutyTypeses) {
		getPersistence().cacheResult(dutyTypeses);
	}

	/**
	 * Creates a new duty types with the primary key. Does not add the duty types to the database.
	 *
	 * @param dutyTypeId the primary key for the new duty types
	 * @return the new duty types
	 */
	public static DutyTypes create(long dutyTypeId) {
		return getPersistence().create(dutyTypeId);
	}

	/**
	 * Removes the duty types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types that was removed
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public static DutyTypes remove(long dutyTypeId)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().remove(dutyTypeId);
	}

	public static DutyTypes updateImpl(DutyTypes dutyTypes) {
		return getPersistence().updateImpl(dutyTypes);
	}

	/**
	 * Returns the duty types with the primary key or throws a <code>NoSuchDutyTypesException</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types
	 * @throws NoSuchDutyTypesException if a duty types with the primary key could not be found
	 */
	public static DutyTypes findByPrimaryKey(long dutyTypeId)
		throws gov.omsb.tms.exception.NoSuchDutyTypesException {

		return getPersistence().findByPrimaryKey(dutyTypeId);
	}

	/**
	 * Returns the duty types with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types, or <code>null</code> if a duty types with the primary key could not be found
	 */
	public static DutyTypes fetchByPrimaryKey(long dutyTypeId) {
		return getPersistence().fetchByPrimaryKey(dutyTypeId);
	}

	/**
	 * Returns all the duty typeses.
	 *
	 * @return the duty typeses
	 */
	public static List<DutyTypes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of duty typeses
	 */
	public static List<DutyTypes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty typeses
	 */
	public static List<DutyTypes> findAll(
		int start, int end, OrderByComparator<DutyTypes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty typeses
	 */
	public static List<DutyTypes> findAll(
		int start, int end, OrderByComparator<DutyTypes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the duty typeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of duty typeses.
	 *
	 * @return the number of duty typeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DutyTypesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DutyTypesPersistence _persistence;

}