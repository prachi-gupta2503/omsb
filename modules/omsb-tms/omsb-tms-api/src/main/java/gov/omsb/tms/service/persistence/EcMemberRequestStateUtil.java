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

import gov.omsb.tms.model.EcMemberRequestState;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ec member request state service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.EcMemberRequestStatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestStatePersistence
 * @generated
 */
public class EcMemberRequestStateUtil {

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
	public static void clearCache(EcMemberRequestState ecMemberRequestState) {
		getPersistence().clearCache(ecMemberRequestState);
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
	public static Map<Serializable, EcMemberRequestState> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EcMemberRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EcMemberRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EcMemberRequestState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EcMemberRequestState update(
		EcMemberRequestState ecMemberRequestState) {

		return getPersistence().update(ecMemberRequestState);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EcMemberRequestState update(
		EcMemberRequestState ecMemberRequestState,
		ServiceContext serviceContext) {

		return getPersistence().update(ecMemberRequestState, serviceContext);
	}

	/**
	 * Returns all the ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByUuid_First(
			String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUuid_First(
		String uuid,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByUuid_Last(
			String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUuid_Last(
		String uuid,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState[] findByUuid_PrevAndNext(
			long ecMemberRequestStateId, String uuid,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_PrevAndNext(
			ecMemberRequestStateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ec member request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ec member request states
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ec member request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ec member request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ec member request state that was removed
	 */
	public static EcMemberRequestState removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ec member request states
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState[] findByUuid_C_PrevAndNext(
			long ecMemberRequestStateId, String uuid, long companyId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ecMemberRequestStateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ec member request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ec member request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ec member request states
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the matching ec member request states
	 */
	public static List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId) {

		return getPersistence().findByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end) {

		return getPersistence().findByEcMemberRequestId(
			ecMemberRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findByEcMemberRequestId(
			ecMemberRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByEcMemberRequestId(
		long ecMemberRequestId, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEcMemberRequestId(
			ecMemberRequestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByEcMemberRequestId_First(
			long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByEcMemberRequestId_First(
			ecMemberRequestId, orderByComparator);
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByEcMemberRequestId_First(
		long ecMemberRequestId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByEcMemberRequestId_First(
			ecMemberRequestId, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByEcMemberRequestId_Last(
			long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByEcMemberRequestId_Last(
			ecMemberRequestId, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByEcMemberRequestId_Last(
		long ecMemberRequestId,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByEcMemberRequestId_Last(
			ecMemberRequestId, orderByComparator);
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState[] findByEcMemberRequestId_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByEcMemberRequestId_PrevAndNext(
			ecMemberRequestStateId, ecMemberRequestId, orderByComparator);
	}

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 */
	public static void removeByEcMemberRequestId(long ecMemberRequestId) {
		getPersistence().removeByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @return the number of matching ec member request states
	 */
	public static int countByEcMemberRequestId(long ecMemberRequestId) {
		return getPersistence().countByEcMemberRequestId(ecMemberRequestId);
	}

	/**
	 * Returns all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the matching ec member request states
	 */
	public static List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic) {

		return getPersistence().findByVisibility(ecMemberRequestId, isPublic);
	}

	/**
	 * Returns a range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end) {

		return getPersistence().findByVisibility(
			ecMemberRequestId, isPublic, start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findByVisibility(
			ecMemberRequestId, isPublic, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ec member request states
	 */
	public static List<EcMemberRequestState> findByVisibility(
		long ecMemberRequestId, boolean isPublic, int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVisibility(
			ecMemberRequestId, isPublic, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByVisibility_First(
			long ecMemberRequestId, boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByVisibility_First(
			ecMemberRequestId, isPublic, orderByComparator);
	}

	/**
	 * Returns the first ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByVisibility_First(
		long ecMemberRequestId, boolean isPublic,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByVisibility_First(
			ecMemberRequestId, isPublic, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState findByVisibility_Last(
			long ecMemberRequestId, boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByVisibility_Last(
			ecMemberRequestId, isPublic, orderByComparator);
	}

	/**
	 * Returns the last ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ec member request state, or <code>null</code> if a matching ec member request state could not be found
	 */
	public static EcMemberRequestState fetchByVisibility_Last(
		long ecMemberRequestId, boolean isPublic,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().fetchByVisibility_Last(
			ecMemberRequestId, isPublic, orderByComparator);
	}

	/**
	 * Returns the ec member request states before and after the current ec member request state in the ordered set where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestStateId the primary key of the current ec member request state
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState[] findByVisibility_PrevAndNext(
			long ecMemberRequestStateId, long ecMemberRequestId,
			boolean isPublic,
			OrderByComparator<EcMemberRequestState> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByVisibility_PrevAndNext(
			ecMemberRequestStateId, ecMemberRequestId, isPublic,
			orderByComparator);
	}

	/**
	 * Removes all the ec member request states where ecMemberRequestId = &#63; and isPublic = &#63; from the database.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 */
	public static void removeByVisibility(
		long ecMemberRequestId, boolean isPublic) {

		getPersistence().removeByVisibility(ecMemberRequestId, isPublic);
	}

	/**
	 * Returns the number of ec member request states where ecMemberRequestId = &#63; and isPublic = &#63;.
	 *
	 * @param ecMemberRequestId the ec member request ID
	 * @param isPublic the is public
	 * @return the number of matching ec member request states
	 */
	public static int countByVisibility(
		long ecMemberRequestId, boolean isPublic) {

		return getPersistence().countByVisibility(ecMemberRequestId, isPublic);
	}

	/**
	 * Caches the ec member request state in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestState the ec member request state
	 */
	public static void cacheResult(EcMemberRequestState ecMemberRequestState) {
		getPersistence().cacheResult(ecMemberRequestState);
	}

	/**
	 * Caches the ec member request states in the entity cache if it is enabled.
	 *
	 * @param ecMemberRequestStates the ec member request states
	 */
	public static void cacheResult(
		List<EcMemberRequestState> ecMemberRequestStates) {

		getPersistence().cacheResult(ecMemberRequestStates);
	}

	/**
	 * Creates a new ec member request state with the primary key. Does not add the ec member request state to the database.
	 *
	 * @param ecMemberRequestStateId the primary key for the new ec member request state
	 * @return the new ec member request state
	 */
	public static EcMemberRequestState create(long ecMemberRequestStateId) {
		return getPersistence().create(ecMemberRequestStateId);
	}

	/**
	 * Removes the ec member request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state that was removed
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState remove(long ecMemberRequestStateId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().remove(ecMemberRequestStateId);
	}

	public static EcMemberRequestState updateImpl(
		EcMemberRequestState ecMemberRequestState) {

		return getPersistence().updateImpl(ecMemberRequestState);
	}

	/**
	 * Returns the ec member request state with the primary key or throws a <code>NoSuchEcMemberRequestStateException</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state
	 * @throws NoSuchEcMemberRequestStateException if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState findByPrimaryKey(
			long ecMemberRequestStateId)
		throws gov.omsb.tms.exception.NoSuchEcMemberRequestStateException {

		return getPersistence().findByPrimaryKey(ecMemberRequestStateId);
	}

	/**
	 * Returns the ec member request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecMemberRequestStateId the primary key of the ec member request state
	 * @return the ec member request state, or <code>null</code> if a ec member request state with the primary key could not be found
	 */
	public static EcMemberRequestState fetchByPrimaryKey(
		long ecMemberRequestStateId) {

		return getPersistence().fetchByPrimaryKey(ecMemberRequestStateId);
	}

	/**
	 * Returns all the ec member request states.
	 *
	 * @return the ec member request states
	 */
	public static List<EcMemberRequestState> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @return the range of ec member request states
	 */
	public static List<EcMemberRequestState> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ec member request states
	 */
	public static List<EcMemberRequestState> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ec member request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcMemberRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ec member request states
	 * @param end the upper bound of the range of ec member request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ec member request states
	 */
	public static List<EcMemberRequestState> findAll(
		int start, int end,
		OrderByComparator<EcMemberRequestState> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ec member request states from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ec member request states.
	 *
	 * @return the number of ec member request states
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EcMemberRequestStatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EcMemberRequestStatePersistence _persistence;

}