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

import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee progduration traineelevel details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeProgdurationTraineelevelDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetailsPersistence
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsUtil {

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
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		getPersistence().clearCache(traineeProgdurationTraineelevelDetails);
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
	public static Map<Serializable, TraineeProgdurationTraineelevelDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeProgdurationTraineelevelDetails update(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		return getPersistence().update(traineeProgdurationTraineelevelDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeProgdurationTraineelevelDetails update(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			traineeProgdurationTraineelevelDetails, serviceContext);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails[]
			findByUuid_PrevAndNext(
				long traineePdTlErDetailsId, String uuid,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			traineePdTlErDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	public static TraineeProgdurationTraineelevelDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails[]
			findByUuid_C_PrevAndNext(
				long traineePdTlErDetailsId, String uuid, long companyId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineePdTlErDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId) {

		return getPersistence().findByTraineeId(traineeId);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end) {

		return getPersistence().findByTraineeId(traineeId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().fetchByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails[]
			findByTraineeId_PrevAndNext(
				long traineePdTlErDetailsId, long traineeId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeId_PrevAndNext(
			traineePdTlErDetailsId, traineeId, orderByComparator);
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public static void removeByTraineeId(long traineeId) {
		getPersistence().removeByTraineeId(traineeId);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByTraineeId(long traineeId) {
		return getPersistence().countByTraineeId(traineeId);
	}

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId);
	}

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId) {

		return getPersistence().fetchByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId);
	}

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(
			long traineeId, long traineeLevelId, boolean useFinderCache) {

		return getPersistence().fetchByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId, useFinderCache);
	}

	/**
	 * Removes the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	public static TraineeProgdurationTraineelevelDetails
			removeByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().removeByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByTraineeIdAndTraineeLevelId(
		long traineeId, long traineeLevelId) {

		return getPersistence().countByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId) {

		return getPersistence().findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end) {

		return getPersistence().findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return getPersistence().findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_First(
				long traineeId, long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeIdAndProgramDurationId_First(
			traineeId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_First(
			long traineeId, long programDurationId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return getPersistence().fetchByTraineeIdAndProgramDurationId_First(
			traineeId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_Last(
				long traineeId, long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeIdAndProgramDurationId_Last(
			traineeId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_Last(
			long traineeId, long programDurationId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return getPersistence().fetchByTraineeIdAndProgramDurationId_Last(
			traineeId, programDurationId, orderByComparator);
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails[]
			findByTraineeIdAndProgramDurationId_PrevAndNext(
				long traineePdTlErDetailsId, long traineeId,
				long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByTraineeIdAndProgramDurationId_PrevAndNext(
			traineePdTlErDetailsId, traineeId, programDurationId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 */
	public static void removeByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId) {

		getPersistence().removeByTraineeIdAndProgramDurationId(
			traineeId, programDurationId);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	public static int countByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId) {

		return getPersistence().countByTraineeIdAndProgramDurationId(
			traineeId, programDurationId);
	}

	/**
	 * Caches the trainee progduration traineelevel details in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 */
	public static void cacheResult(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		getPersistence().cacheResult(traineeProgdurationTraineelevelDetails);
	}

	/**
	 * Caches the trainee progduration traineelevel detailses in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetailses the trainee progduration traineelevel detailses
	 */
	public static void cacheResult(
		List<TraineeProgdurationTraineelevelDetails>
			traineeProgdurationTraineelevelDetailses) {

		getPersistence().cacheResult(traineeProgdurationTraineelevelDetailses);
	}

	/**
	 * Creates a new trainee progduration traineelevel details with the primary key. Does not add the trainee progduration traineelevel details to the database.
	 *
	 * @param traineePdTlErDetailsId the primary key for the new trainee progduration traineelevel details
	 * @return the new trainee progduration traineelevel details
	 */
	public static TraineeProgdurationTraineelevelDetails create(
		long traineePdTlErDetailsId) {

		return getPersistence().create(traineePdTlErDetailsId);
	}

	/**
	 * Removes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails remove(
			long traineePdTlErDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().remove(traineePdTlErDetailsId);
	}

	public static TraineeProgdurationTraineelevelDetails updateImpl(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		return getPersistence().updateImpl(
			traineeProgdurationTraineelevelDetails);
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails findByPrimaryKey(
			long traineePdTlErDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeProgdurationTraineelevelDetailsException {

		return getPersistence().findByPrimaryKey(traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details, or <code>null</code> if a trainee progduration traineelevel details with the primary key could not be found
	 */
	public static TraineeProgdurationTraineelevelDetails fetchByPrimaryKey(
		long traineePdTlErDetailsId) {

		return getPersistence().fetchByPrimaryKey(traineePdTlErDetailsId);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses.
	 *
	 * @return the trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	public static List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses.
	 *
	 * @return the number of trainee progduration traineelevel detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeProgdurationTraineelevelDetailsPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile TraineeProgdurationTraineelevelDetailsPersistence
		_persistence;

}