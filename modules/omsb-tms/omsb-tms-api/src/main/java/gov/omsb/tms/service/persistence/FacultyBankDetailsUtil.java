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

import gov.omsb.tms.model.FacultyBankDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the faculty bank details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.FacultyBankDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetailsPersistence
 * @generated
 */
public class FacultyBankDetailsUtil {

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
	public static void clearCache(FacultyBankDetails facultyBankDetails) {
		getPersistence().clearCache(facultyBankDetails);
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
	public static Map<Serializable, FacultyBankDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FacultyBankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FacultyBankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FacultyBankDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FacultyBankDetails update(
		FacultyBankDetails facultyBankDetails) {

		return getPersistence().update(facultyBankDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FacultyBankDetails update(
		FacultyBankDetails facultyBankDetails, ServiceContext serviceContext) {

		return getPersistence().update(facultyBankDetails, serviceContext);
	}

	/**
	 * Returns all the faculty bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByUuid_First(
			String uuid,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUuid_First(
		String uuid, OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUuid_Last(
		String uuid, OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the faculty bank detailses before and after the current faculty bank details in the ordered set where uuid = &#63;.
	 *
	 * @param facultyBankDetailsId the primary key of the current faculty bank details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public static FacultyBankDetails[] findByUuid_PrevAndNext(
			long facultyBankDetailsId, String uuid,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			facultyBankDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the faculty bank detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty bank detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the faculty bank details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the faculty bank details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty bank details that was removed
	 */
	public static FacultyBankDetails removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty bank detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty bank detailses
	 */
	public static List<FacultyBankDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the faculty bank detailses before and after the current faculty bank details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyBankDetailsId the primary key of the current faculty bank details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public static FacultyBankDetails[] findByUuid_C_PrevAndNext(
			long facultyBankDetailsId, String uuid, long companyId,
			OrderByComparator<FacultyBankDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			facultyBankDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the faculty bank detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of faculty bank detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty bank detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails findByfacultyRequestId(
			long facultyRequestId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByfacultyRequestId(
		long facultyRequestId) {

		return getPersistence().fetchByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns the faculty bank details where facultyRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	public static FacultyBankDetails fetchByfacultyRequestId(
		long facultyRequestId, boolean useFinderCache) {

		return getPersistence().fetchByfacultyRequestId(
			facultyRequestId, useFinderCache);
	}

	/**
	 * Removes the faculty bank details where facultyRequestId = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the faculty bank details that was removed
	 */
	public static FacultyBankDetails removeByfacultyRequestId(
			long facultyRequestId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().removeByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Returns the number of faculty bank detailses where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the number of matching faculty bank detailses
	 */
	public static int countByfacultyRequestId(long facultyRequestId) {
		return getPersistence().countByfacultyRequestId(facultyRequestId);
	}

	/**
	 * Caches the faculty bank details in the entity cache if it is enabled.
	 *
	 * @param facultyBankDetails the faculty bank details
	 */
	public static void cacheResult(FacultyBankDetails facultyBankDetails) {
		getPersistence().cacheResult(facultyBankDetails);
	}

	/**
	 * Caches the faculty bank detailses in the entity cache if it is enabled.
	 *
	 * @param facultyBankDetailses the faculty bank detailses
	 */
	public static void cacheResult(
		List<FacultyBankDetails> facultyBankDetailses) {

		getPersistence().cacheResult(facultyBankDetailses);
	}

	/**
	 * Creates a new faculty bank details with the primary key. Does not add the faculty bank details to the database.
	 *
	 * @param facultyBankDetailsId the primary key for the new faculty bank details
	 * @return the new faculty bank details
	 */
	public static FacultyBankDetails create(long facultyBankDetailsId) {
		return getPersistence().create(facultyBankDetailsId);
	}

	/**
	 * Removes the faculty bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details that was removed
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public static FacultyBankDetails remove(long facultyBankDetailsId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().remove(facultyBankDetailsId);
	}

	public static FacultyBankDetails updateImpl(
		FacultyBankDetails facultyBankDetails) {

		return getPersistence().updateImpl(facultyBankDetails);
	}

	/**
	 * Returns the faculty bank details with the primary key or throws a <code>NoSuchFacultyBankDetailsException</code> if it could not be found.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details
	 * @throws NoSuchFacultyBankDetailsException if a faculty bank details with the primary key could not be found
	 */
	public static FacultyBankDetails findByPrimaryKey(long facultyBankDetailsId)
		throws gov.omsb.tms.exception.NoSuchFacultyBankDetailsException {

		return getPersistence().findByPrimaryKey(facultyBankDetailsId);
	}

	/**
	 * Returns the faculty bank details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details, or <code>null</code> if a faculty bank details with the primary key could not be found
	 */
	public static FacultyBankDetails fetchByPrimaryKey(
		long facultyBankDetailsId) {

		return getPersistence().fetchByPrimaryKey(facultyBankDetailsId);
	}

	/**
	 * Returns all the faculty bank detailses.
	 *
	 * @return the faculty bank detailses
	 */
	public static List<FacultyBankDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of faculty bank detailses
	 */
	public static List<FacultyBankDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty bank detailses
	 */
	public static List<FacultyBankDetails> findAll(
		int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty bank detailses
	 */
	public static List<FacultyBankDetails> findAll(
		int start, int end,
		OrderByComparator<FacultyBankDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the faculty bank detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of faculty bank detailses.
	 *
	 * @return the number of faculty bank detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FacultyBankDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FacultyBankDetailsPersistence _persistence;

}