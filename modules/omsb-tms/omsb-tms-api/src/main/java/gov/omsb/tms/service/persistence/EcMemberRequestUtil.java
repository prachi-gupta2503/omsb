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

import gov.omsb.tms.model.EcMemberRequest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ec member request service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.EcMemberRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestPersistence
 * @generated
 */
public class EcMemberRequestUtil {

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
	public static void clearCache(EcMemberRequest ecMemberRequest) {
		getPersistence().clearCache(ecMemberRequest);
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
	public static Map<Serializable, EcMemberRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EcMemberRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EcMemberRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EcMemberRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EcMemberRequest update(EcMemberRequest ecMemberRequest) {
		return getPersistence().update(ecMemberRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EcMemberRequest update(
		EcMemberRequest ecMemberRequest, ServiceContext serviceContext) {

		return getPersistence().update(ecMemberRequest, serviceContext);
	}

	/**
	 * Returns all the ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByUuid_First(
			String uuid, OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUuid_First(
		String uuid, OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByUuid_Last(
			String uuid, OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUuid_Last(
		String uuid, OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest[] findByUuid_PrevAndNext(
			long ecMemberRequestId, String uuid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			ecMemberRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ec member requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ec member request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request that was removed
	 */
	public static EcMemberRequest removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest[] findByUuid_C_PrevAndNext(
			long ecMemberRequestId, String uuid, long companyId,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ecMemberRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ec member requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ec member requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByPotentialEcMemberId(
			long potentialEcMemberId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByPotentialEcMemberId(potentialEcMemberId);
	}

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByPotentialEcMemberId(
		long potentialEcMemberId) {

		return getPersistence().fetchByPotentialEcMemberId(potentialEcMemberId);
	}

	/**
	 * Returns the ec member request where potentialEcMemberId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByPotentialEcMemberId(
		long potentialEcMemberId, boolean useFinderCache) {

		return getPersistence().fetchByPotentialEcMemberId(
			potentialEcMemberId, useFinderCache);
	}

	/**
	 * Removes the ec member request where potentialEcMemberId = &#63; from the database.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the ec member request that was removed
	 */
	public static EcMemberRequest removeByPotentialEcMemberId(
			long potentialEcMemberId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().removeByPotentialEcMemberId(
			potentialEcMemberId);
	}

	/**
	 * Returns the number of ec member requests where potentialEcMemberId = &#63;.
	 *
	 * @param potentialEcMemberId the potential ec member ID
	 * @return the number of matching ec member requests
	 */
	public static int countByPotentialEcMemberId(long potentialEcMemberId) {
		return getPersistence().countByPotentialEcMemberId(potentialEcMemberId);
	}

	/**
	 * Returns all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the matching ec member requests
	 */
	public static List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		return getPersistence().findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
	}

	/**
	 * Returns a range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end) {

		return getPersistence().findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member requests
	 */
	public static List<EcMemberRequest> findByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid, int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPotentialEcMemberLruserid(
			potentialEcMemberLruserid, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByPotentialEcMemberLruserid_First(
			long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByPotentialEcMemberLruserid_First(
			potentialEcMemberLruserid, orderByComparator);
	}

	/**
	 * Returns the first ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByPotentialEcMemberLruserid_First(
		long potentialEcMemberLruserid,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByPotentialEcMemberLruserid_First(
			potentialEcMemberLruserid, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request
	 * @throws NoSuchEcMemberRequestException if a matching ec member request could not be found
	 */
	public static EcMemberRequest findByPotentialEcMemberLruserid_Last(
			long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByPotentialEcMemberLruserid_Last(
			potentialEcMemberLruserid, orderByComparator);
	}

	/**
	 * Returns the last ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request, or <code>null</code> if a matching ec member request could not be found
	 */
	public static EcMemberRequest fetchByPotentialEcMemberLruserid_Last(
		long potentialEcMemberLruserid,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().fetchByPotentialEcMemberLruserid_Last(
			potentialEcMemberLruserid, orderByComparator);
	}

	/**
	 * Returns the ec member requests before and after the current ec member request in the ordered set where potentialEcMemberLruserid = &#63;.
	 *
	 * @param ecMemberRequestId the primary key of the current ec member request
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest[] findByPotentialEcMemberLruserid_PrevAndNext(
			long ecMemberRequestId, long potentialEcMemberLruserid,
			OrderByComparator<EcMemberRequest> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByPotentialEcMemberLruserid_PrevAndNext(
			ecMemberRequestId, potentialEcMemberLruserid, orderByComparator);
	}

	/**
	 * Removes all the ec member requests where potentialEcMemberLruserid = &#63; from the database.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 */
	public static void removeByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		getPersistence().removeByPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
	}

	/**
	 * Returns the number of ec member requests where potentialEcMemberLruserid = &#63;.
	 *
	 * @param potentialEcMemberLruserid the potential ec member lruserid
	 * @return the number of matching ec member requests
	 */
	public static int countByPotentialEcMemberLruserid(
		long potentialEcMemberLruserid) {

		return getPersistence().countByPotentialEcMemberLruserid(
			potentialEcMemberLruserid);
	}

	/**
	 * Caches the ec member request in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequest the ec member request
	 */
	public static void cacheResult(EcMemberRequest ecMemberRequest) {
		getPersistence().cacheResult(ecMemberRequest);
	}

	/**
	 * Caches the ec member requests in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequests the ec member requests
	 */
	public static void cacheResult(List<EcMemberRequest> ecMemberRequests) {
		getPersistence().cacheResult(ecMemberRequests);
	}

	/**
	 * Creates a new ec member request with the primary key. Does not add the ec member request to the database.
	 *
	 * @param ecMemberRequestId the primary key for the new ec member request
	 * @return the new ec member request
	 */
	public static EcMemberRequest create(long ecMemberRequestId) {
		return getPersistence().create(ecMemberRequestId);
	}

	/**
	 * Removes the ec member request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request that was removed
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest remove(long ecMemberRequestId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().remove(ecMemberRequestId);
	}

	public static EcMemberRequest updateImpl(EcMemberRequest ecMemberRequest) {
		return getPersistence().updateImpl(ecMemberRequest);
	}

	/**
	 * Returns the ec member request with the primary key or throws a <code>NoSuchEcMemberRequestException</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request
	 * @throws NoSuchEcMemberRequestException if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest findByPrimaryKey(long ecMemberRequestId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestException {

		return getPersistence().findByPrimaryKey(ecMemberRequestId);
	}

	/**
	 * Returns the ec member request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestId the primary key of the ec member request
	 * @return the ec member request, or <code>null</code> if a ec member request with the primary key could not be found
	 */
	public static EcMemberRequest fetchByPrimaryKey(long ecMemberRequestId) {
		return getPersistence().fetchByPrimaryKey(ecMemberRequestId);
	}

	/**
	 * Returns all the ec member requests.
	 *
	 * @return the ec member requests
	 */
	public static List<EcMemberRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @return the range of ec member requests
	 */
	public static List<EcMemberRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member requests
	 */
	public static List<EcMemberRequest> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member requests
	 * @param end the upper bound of the range of ec member requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member requests
	 */
	public static List<EcMemberRequest> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ec member requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ec member requests.
	 *
	 * @return the number of ec member requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EcMemberRequestPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EcMemberRequestPersistence _persistence;

}