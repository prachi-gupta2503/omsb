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

import gov.omsb.tms.model.SharedRotationRequestDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the shared rotation request details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.SharedRotationRequestDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationRequestDetailsPersistence
 * @generated
 */
public class SharedRotationRequestDetailsUtil {

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
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		getPersistence().clearCache(sharedRotationRequestDetails);
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
	public static Map<Serializable, SharedRotationRequestDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SharedRotationRequestDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SharedRotationRequestDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SharedRotationRequestDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SharedRotationRequestDetails update(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		return getPersistence().update(sharedRotationRequestDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SharedRotationRequestDetails update(
		SharedRotationRequestDetails sharedRotationRequestDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			sharedRotationRequestDetails, serviceContext);
	}

	/**
	 * Returns all the shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByUuid_First(
			String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByUuid_Last(
			String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails[] findByUuid_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			sharedRotationRequestDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation request detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the shared rotation request details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation request details that was removed
	 */
	public static SharedRotationRequestDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation request detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sharedRotationRequestDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation request detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy) {

		return getPersistence().findByRequestRaisedBy(requestRaisedBy);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end) {

		return getPersistence().findByRequestRaisedBy(
			requestRaisedBy, start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().findByRequestRaisedBy(
			requestRaisedBy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestRaisedBy(
			requestRaisedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByRequestRaisedBy_First(
			String requestRaisedBy,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByRequestRaisedBy_First(
			requestRaisedBy, orderByComparator);
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByRequestRaisedBy_First(
		String requestRaisedBy,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByRequestRaisedBy_First(
			requestRaisedBy, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails findByRequestRaisedBy_Last(
			String requestRaisedBy,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByRequestRaisedBy_Last(
			requestRaisedBy, orderByComparator);
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	public static SharedRotationRequestDetails fetchByRequestRaisedBy_Last(
		String requestRaisedBy,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().fetchByRequestRaisedBy_Last(
			requestRaisedBy, orderByComparator);
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails[]
			findByRequestRaisedBy_PrevAndNext(
				long sharedRotationRequestDetailsId, String requestRaisedBy,
				OrderByComparator<SharedRotationRequestDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByRequestRaisedBy_PrevAndNext(
			sharedRotationRequestDetailsId, requestRaisedBy, orderByComparator);
	}

	/**
	 * Removes all the shared rotation request detailses where requestRaisedBy = &#63; from the database.
	 *
	 * @param requestRaisedBy the request raised by
	 */
	public static void removeByRequestRaisedBy(String requestRaisedBy) {
		getPersistence().removeByRequestRaisedBy(requestRaisedBy);
	}

	/**
	 * Returns the number of shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the number of matching shared rotation request detailses
	 */
	public static int countByRequestRaisedBy(String requestRaisedBy) {
		return getPersistence().countByRequestRaisedBy(requestRaisedBy);
	}

	/**
	 * Caches the shared rotation request details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 */
	public static void cacheResult(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		getPersistence().cacheResult(sharedRotationRequestDetails);
	}

	/**
	 * Caches the shared rotation request detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetailses the shared rotation request detailses
	 */
	public static void cacheResult(
		List<SharedRotationRequestDetails> sharedRotationRequestDetailses) {

		getPersistence().cacheResult(sharedRotationRequestDetailses);
	}

	/**
	 * Creates a new shared rotation request details with the primary key. Does not add the shared rotation request details to the database.
	 *
	 * @param sharedRotationRequestDetailsId the primary key for the new shared rotation request details
	 * @return the new shared rotation request details
	 */
	public static SharedRotationRequestDetails create(
		long sharedRotationRequestDetailsId) {

		return getPersistence().create(sharedRotationRequestDetailsId);
	}

	/**
	 * Removes the shared rotation request details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details that was removed
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails remove(
			long sharedRotationRequestDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().remove(sharedRotationRequestDetailsId);
	}

	public static SharedRotationRequestDetails updateImpl(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		return getPersistence().updateImpl(sharedRotationRequestDetails);
	}

	/**
	 * Returns the shared rotation request details with the primary key or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails findByPrimaryKey(
			long sharedRotationRequestDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationRequestDetailsException {

		return getPersistence().findByPrimaryKey(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation request details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details, or <code>null</code> if a shared rotation request details with the primary key could not be found
	 */
	public static SharedRotationRequestDetails fetchByPrimaryKey(
		long sharedRotationRequestDetailsId) {

		return getPersistence().fetchByPrimaryKey(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns all the shared rotation request detailses.
	 *
	 * @return the shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation request detailses
	 */
	public static List<SharedRotationRequestDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the shared rotation request detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of shared rotation request detailses.
	 *
	 * @return the number of shared rotation request detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SharedRotationRequestDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SharedRotationRequestDetailsPersistence
		_persistence;

}