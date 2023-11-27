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

import gov.omsb.tms.model.SharedRotationApproverDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the shared rotation approver details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.SharedRotationApproverDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SharedRotationApproverDetailsPersistence
 * @generated
 */
public class SharedRotationApproverDetailsUtil {

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
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		getPersistence().clearCache(sharedRotationApproverDetails);
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
	public static Map<Serializable, SharedRotationApproverDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SharedRotationApproverDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SharedRotationApproverDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SharedRotationApproverDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SharedRotationApproverDetails update(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		return getPersistence().update(sharedRotationApproverDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SharedRotationApproverDetails update(
		SharedRotationApproverDetails sharedRotationApproverDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			sharedRotationApproverDetails, serviceContext);
	}

	/**
	 * Returns all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails findByUuid_First(
			String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails findByUuid_Last(
			String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public static SharedRotationApproverDetails[] findByUuid_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			sharedRotationApproverDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation approver detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the shared rotation approver details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation approver details that was removed
	 */
	public static SharedRotationApproverDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public static SharedRotationApproverDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sharedRotationApproverDetailsId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails
			findBySharedRotationRequestDetailsId(
				long sharedRotationRequestDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails
		fetchBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId) {

		return getPersistence().fetchBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	public static SharedRotationApproverDetails
		fetchBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId, boolean useFinderCache) {

		return getPersistence().fetchBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId, useFinderCache);
	}

	/**
	 * Removes the shared rotation approver details where sharedRotationRequestDetailsId = &#63; from the database.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the shared rotation approver details that was removed
	 */
	public static SharedRotationApproverDetails
			removeBySharedRotationRequestDetailsId(
				long sharedRotationRequestDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().removeBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the number of shared rotation approver detailses where sharedRotationRequestDetailsId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the number of matching shared rotation approver detailses
	 */
	public static int countBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId) {

		return getPersistence().countBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId);
	}

	/**
	 * Caches the shared rotation approver details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 */
	public static void cacheResult(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		getPersistence().cacheResult(sharedRotationApproverDetails);
	}

	/**
	 * Caches the shared rotation approver detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetailses the shared rotation approver detailses
	 */
	public static void cacheResult(
		List<SharedRotationApproverDetails> sharedRotationApproverDetailses) {

		getPersistence().cacheResult(sharedRotationApproverDetailses);
	}

	/**
	 * Creates a new shared rotation approver details with the primary key. Does not add the shared rotation approver details to the database.
	 *
	 * @param sharedRotationApproverDetailsId the primary key for the new shared rotation approver details
	 * @return the new shared rotation approver details
	 */
	public static SharedRotationApproverDetails create(
		long sharedRotationApproverDetailsId) {

		return getPersistence().create(sharedRotationApproverDetailsId);
	}

	/**
	 * Removes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public static SharedRotationApproverDetails remove(
			long sharedRotationApproverDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().remove(sharedRotationApproverDetailsId);
	}

	public static SharedRotationApproverDetails updateImpl(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		return getPersistence().updateImpl(sharedRotationApproverDetails);
	}

	/**
	 * Returns the shared rotation approver details with the primary key or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	public static SharedRotationApproverDetails findByPrimaryKey(
			long sharedRotationApproverDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchSharedRotationApproverDetailsException {

		return getPersistence().findByPrimaryKey(
			sharedRotationApproverDetailsId);
	}

	/**
	 * Returns the shared rotation approver details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details, or <code>null</code> if a shared rotation approver details with the primary key could not be found
	 */
	public static SharedRotationApproverDetails fetchByPrimaryKey(
		long sharedRotationApproverDetailsId) {

		return getPersistence().fetchByPrimaryKey(
			sharedRotationApproverDetailsId);
	}

	/**
	 * Returns all the shared rotation approver detailses.
	 *
	 * @return the shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation approver detailses
	 */
	public static List<SharedRotationApproverDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the shared rotation approver detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of shared rotation approver detailses.
	 *
	 * @return the number of shared rotation approver detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SharedRotationApproverDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SharedRotationApproverDetailsPersistence
		_persistence;

}