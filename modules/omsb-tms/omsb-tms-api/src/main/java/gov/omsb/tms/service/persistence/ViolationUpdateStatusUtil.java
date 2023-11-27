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

import gov.omsb.tms.model.ViolationUpdateStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the violation update status service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ViolationUpdateStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatusPersistence
 * @generated
 */
public class ViolationUpdateStatusUtil {

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
	public static void clearCache(ViolationUpdateStatus violationUpdateStatus) {
		getPersistence().clearCache(violationUpdateStatus);
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
	public static Map<Serializable, ViolationUpdateStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ViolationUpdateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ViolationUpdateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ViolationUpdateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ViolationUpdateStatus update(
		ViolationUpdateStatus violationUpdateStatus) {

		return getPersistence().update(violationUpdateStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ViolationUpdateStatus update(
		ViolationUpdateStatus violationUpdateStatus,
		ServiceContext serviceContext) {

		return getPersistence().update(violationUpdateStatus, serviceContext);
	}

	/**
	 * Returns all the violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByUuid_First(
			String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByUuid_Last(
			String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus[] findByUuid_PrevAndNext(
			long violationUpdateStatusId, String uuid,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			violationUpdateStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the violation update statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching violation update statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the violation update status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the violation update status that was removed
	 */
	public static ViolationUpdateStatus removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching violation update statuses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	public static List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus[] findByUuid_C_PrevAndNext(
			long violationUpdateStatusId, String uuid, long companyId,
			OrderByComparator<ViolationUpdateStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByUuid_C_PrevAndNext(
			violationUpdateStatusId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the violation update statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching violation update statuses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getPersistence().fetchByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public static ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, boolean useFinderCache) {

		return getPersistence().fetchByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, useFinderCache);
	}

	/**
	 * Removes the violation update status where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the violation update status that was removed
	 */
	public static ViolationUpdateStatus removeByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().removeByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns the number of violation update statuses where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching violation update statuses
	 */
	public static int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getPersistence().countByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Caches the violation update status in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatus the violation update status
	 */
	public static void cacheResult(
		ViolationUpdateStatus violationUpdateStatus) {

		getPersistence().cacheResult(violationUpdateStatus);
	}

	/**
	 * Caches the violation update statuses in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatuses the violation update statuses
	 */
	public static void cacheResult(
		List<ViolationUpdateStatus> violationUpdateStatuses) {

		getPersistence().cacheResult(violationUpdateStatuses);
	}

	/**
	 * Creates a new violation update status with the primary key. Does not add the violation update status to the database.
	 *
	 * @param violationUpdateStatusId the primary key for the new violation update status
	 * @return the new violation update status
	 */
	public static ViolationUpdateStatus create(long violationUpdateStatusId) {
		return getPersistence().create(violationUpdateStatusId);
	}

	/**
	 * Removes the violation update status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status that was removed
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus remove(long violationUpdateStatusId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().remove(violationUpdateStatusId);
	}

	public static ViolationUpdateStatus updateImpl(
		ViolationUpdateStatus violationUpdateStatus) {

		return getPersistence().updateImpl(violationUpdateStatus);
	}

	/**
	 * Returns the violation update status with the primary key or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus findByPrimaryKey(
			long violationUpdateStatusId)
		throws gov.omsb.tms.exception.NoSuchViolationUpdateStatusException {

		return getPersistence().findByPrimaryKey(violationUpdateStatusId);
	}

	/**
	 * Returns the violation update status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status, or <code>null</code> if a violation update status with the primary key could not be found
	 */
	public static ViolationUpdateStatus fetchByPrimaryKey(
		long violationUpdateStatusId) {

		return getPersistence().fetchByPrimaryKey(violationUpdateStatusId);
	}

	/**
	 * Returns all the violation update statuses.
	 *
	 * @return the violation update statuses
	 */
	public static List<ViolationUpdateStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of violation update statuses
	 */
	public static List<ViolationUpdateStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of violation update statuses
	 */
	public static List<ViolationUpdateStatus> findAll(
		int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of violation update statuses
	 */
	public static List<ViolationUpdateStatus> findAll(
		int start, int end,
		OrderByComparator<ViolationUpdateStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the violation update statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of violation update statuses.
	 *
	 * @return the number of violation update statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ViolationUpdateStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ViolationUpdateStatusPersistence _persistence;

}