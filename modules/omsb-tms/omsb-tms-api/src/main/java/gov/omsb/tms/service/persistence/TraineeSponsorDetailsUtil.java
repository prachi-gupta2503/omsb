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

import gov.omsb.tms.model.TraineeSponsorDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee sponsor details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeSponsorDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetailsPersistence
 * @generated
 */
public class TraineeSponsorDetailsUtil {

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
	public static void clearCache(TraineeSponsorDetails traineeSponsorDetails) {
		getPersistence().clearCache(traineeSponsorDetails);
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
	public static Map<Serializable, TraineeSponsorDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeSponsorDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeSponsorDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeSponsorDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeSponsorDetails update(
		TraineeSponsorDetails traineeSponsorDetails) {

		return getPersistence().update(traineeSponsorDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeSponsorDetails update(
		TraineeSponsorDetails traineeSponsorDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(traineeSponsorDetails, serviceContext);
	}

	/**
	 * Returns all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails[] findByUuid_PrevAndNext(
			long traineeSponsorDetailsId, String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeSponsorDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee sponsor detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee sponsor details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee sponsor details that was removed
	 */
	public static TraineeSponsorDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails[] findByUuid_C_PrevAndNext(
			long traineeSponsorDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeSponsorDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails findBytraineeId(long traineeId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findBytraineeId(traineeId);
	}

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchBytraineeId(long traineeId) {
		return getPersistence().fetchBytraineeId(traineeId);
	}

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	public static TraineeSponsorDetails fetchBytraineeId(
		long traineeId, boolean useFinderCache) {

		return getPersistence().fetchBytraineeId(traineeId, useFinderCache);
	}

	/**
	 * Removes the trainee sponsor details where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee sponsor details that was removed
	 */
	public static TraineeSponsorDetails removeBytraineeId(long traineeId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().removeBytraineeId(traineeId);
	}

	/**
	 * Returns the number of trainee sponsor detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee sponsor detailses
	 */
	public static int countBytraineeId(long traineeId) {
		return getPersistence().countBytraineeId(traineeId);
	}

	/**
	 * Caches the trainee sponsor details in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 */
	public static void cacheResult(
		TraineeSponsorDetails traineeSponsorDetails) {

		getPersistence().cacheResult(traineeSponsorDetails);
	}

	/**
	 * Caches the trainee sponsor detailses in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetailses the trainee sponsor detailses
	 */
	public static void cacheResult(
		List<TraineeSponsorDetails> traineeSponsorDetailses) {

		getPersistence().cacheResult(traineeSponsorDetailses);
	}

	/**
	 * Creates a new trainee sponsor details with the primary key. Does not add the trainee sponsor details to the database.
	 *
	 * @param traineeSponsorDetailsId the primary key for the new trainee sponsor details
	 * @return the new trainee sponsor details
	 */
	public static TraineeSponsorDetails create(long traineeSponsorDetailsId) {
		return getPersistence().create(traineeSponsorDetailsId);
	}

	/**
	 * Removes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails remove(long traineeSponsorDetailsId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().remove(traineeSponsorDetailsId);
	}

	public static TraineeSponsorDetails updateImpl(
		TraineeSponsorDetails traineeSponsorDetails) {

		return getPersistence().updateImpl(traineeSponsorDetails);
	}

	/**
	 * Returns the trainee sponsor details with the primary key or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails findByPrimaryKey(
			long traineeSponsorDetailsId)
		throws gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException {

		return getPersistence().findByPrimaryKey(traineeSponsorDetailsId);
	}

	/**
	 * Returns the trainee sponsor details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details, or <code>null</code> if a trainee sponsor details with the primary key could not be found
	 */
	public static TraineeSponsorDetails fetchByPrimaryKey(
		long traineeSponsorDetailsId) {

		return getPersistence().fetchByPrimaryKey(traineeSponsorDetailsId);
	}

	/**
	 * Returns all the trainee sponsor detailses.
	 *
	 * @return the trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee sponsor detailses
	 */
	public static List<TraineeSponsorDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee sponsor detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee sponsor detailses.
	 *
	 * @return the number of trainee sponsor detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeSponsorDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TraineeSponsorDetailsPersistence _persistence;

}