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

import gov.omsb.tms.model.EcMemberRequestStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ec member request status service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.EcMemberRequestStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatusPersistence
 * @generated
 */
public class EcMemberRequestStatusUtil {

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
	public static void clearCache(EcMemberRequestStatus ecMemberRequestStatus) {
		getPersistence().clearCache(ecMemberRequestStatus);
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
	public static Map<Serializable, EcMemberRequestStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EcMemberRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EcMemberRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EcMemberRequestStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EcMemberRequestStatus update(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return getPersistence().update(ecMemberRequestStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EcMemberRequestStatus update(
		EcMemberRequestStatus ecMemberRequestStatus,
		ServiceContext serviceContext) {

		return getPersistence().update(ecMemberRequestStatus, serviceContext);
	}

	/**
	 * Returns all the ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByUuid_First(
			String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByUuid_Last(
			String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus[] findByUuid_PrevAndNext(
			long ecMemberRequestStatusId, String uuid,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			ecMemberRequestStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ec member request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ec member request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request status that was removed
	 */
	public static EcMemberRequestStatus removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request statuses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStatusId, String uuid, long companyId,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ecMemberRequestStatusId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ec member request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ec member request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request statuses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses where code LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findByCode(
		String code, int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByCode_First(
			String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByCode_First(
		String code,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByCode_Last(
			String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByCode_Last(
		String code,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the ec member request statuses before and after the current ec member request status in the ordered set where code LIKE &#63;.
	 *
	 * @param ecMemberRequestStatusId the primary key of the current ec member request status
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus[] findByCode_PrevAndNext(
			long ecMemberRequestStatusId, String code,
			OrderByComparator<EcMemberRequestStatus> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByCode_PrevAndNext(
			ecMemberRequestStatusId, code, orderByComparator);
	}

	/**
	 * Removes all the ec member request statuses where code LIKE &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of ec member request statuses where code LIKE &#63;.
	 *
	 * @param code the code
	 * @return the number of matching ec member request statuses
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns the ec member request status where nameEn = &#63; or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus findByNameEn(String nameEn)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByNameEn(nameEn);
	}

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nameEn the name en
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByNameEn(String nameEn) {
		return getPersistence().fetchByNameEn(nameEn);
	}

	/**
	 * Returns the ec member request status where nameEn = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nameEn the name en
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request status, or <code>null</code> if a matching ec member request status could not be found
	 */
	public static EcMemberRequestStatus fetchByNameEn(
		String nameEn, boolean useFinderCache) {

		return getPersistence().fetchByNameEn(nameEn, useFinderCache);
	}

	/**
	 * Removes the ec member request status where nameEn = &#63; from the database.
	 *
	 * @param nameEn the name en
	 * @return the ec member request status that was removed
	 */
	public static EcMemberRequestStatus removeByNameEn(String nameEn)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().removeByNameEn(nameEn);
	}

	/**
	 * Returns the number of ec member request statuses where nameEn = &#63;.
	 *
	 * @param nameEn the name en
	 * @return the number of matching ec member request statuses
	 */
	public static int countByNameEn(String nameEn) {
		return getPersistence().countByNameEn(nameEn);
	}

	/**
	 * Caches the ec member request status in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatus the ec member request status
	 */
	public static void cacheResult(
		EcMemberRequestStatus ecMemberRequestStatus) {

		getPersistence().cacheResult(ecMemberRequestStatus);
	}

	/**
	 * Caches the ec member request statuses in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStatuses the ec member request statuses
	 */
	public static void cacheResult(
		List<EcMemberRequestStatus> ecMemberRequestStatuses) {

		getPersistence().cacheResult(ecMemberRequestStatuses);
	}

	/**
	 * Creates a new ec member request status with the primary key. Does not add the ec member request status to the database.
	 *
	 * @param ecMemberRequestStatusId the primary key for the new ec member request status
	 * @return the new ec member request status
	 */
	public static EcMemberRequestStatus create(long ecMemberRequestStatusId) {
		return getPersistence().create(ecMemberRequestStatusId);
	}

	/**
	 * Removes the ec member request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status that was removed
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus remove(long ecMemberRequestStatusId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().remove(ecMemberRequestStatusId);
	}

	public static EcMemberRequestStatus updateImpl(
		EcMemberRequestStatus ecMemberRequestStatus) {

		return getPersistence().updateImpl(ecMemberRequestStatus);
	}

	/**
	 * Returns the ec member request status with the primary key or throws a <code>NoSuchEcMemberRequestStatusException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status
	 * @throws NoSuchEcMemberRequestStatusException if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus findByPrimaryKey(
			long ecMemberRequestStatusId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStatusException {

		return getPersistence().findByPrimaryKey(ecMemberRequestStatusId);
	}

	/**
	 * Returns the ec member request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStatusId the primary key of the ec member request status
	 * @return the ec member request status, or <code>null</code> if a ec member request status with the primary key could not be found
	 */
	public static EcMemberRequestStatus fetchByPrimaryKey(
		long ecMemberRequestStatusId) {

		return getPersistence().fetchByPrimaryKey(ecMemberRequestStatusId);
	}

	/**
	 * Returns all the ec member request statuses.
	 *
	 * @return the ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @return the range of ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request statuses
	 * @param end the upper bound of the range of ec member request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request statuses
	 */
	public static List<EcMemberRequestStatus> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ec member request statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ec member request statuses.
	 *
	 * @return the number of ec member request statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EcMemberRequestStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EcMemberRequestStatusPersistence _persistence;

}