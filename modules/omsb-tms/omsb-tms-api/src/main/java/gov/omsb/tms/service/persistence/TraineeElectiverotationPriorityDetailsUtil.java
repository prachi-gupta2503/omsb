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

import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee electiverotation priority details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeElectiverotationPriorityDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetailsPersistence
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsUtil {

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
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		getPersistence().clearCache(traineeElectiverotationPriorityDetails);
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
	public static Map<Serializable, TraineeElectiverotationPriorityDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeElectiverotationPriorityDetails update(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		return getPersistence().update(traineeElectiverotationPriorityDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeElectiverotationPriorityDetails update(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			traineeElectiverotationPriorityDetails, serviceContext);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails[]
			findByUuid_PrevAndNext(
				long traineeElectiverotationPriorityDetailsId, String uuid,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeElectiverotationPriorityDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee electiverotation priority details that was removed
	 */
	public static TraineeElectiverotationPriorityDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails[]
			findByUuid_C_PrevAndNext(
				long traineeElectiverotationPriorityDetailsId, String uuid,
				long companyId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeElectiverotationPriorityDetailsId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {

		return getPersistence().findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end) {

		return getPersistence().findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return getPersistence().findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_First(
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByTraineePdTlErDetailsId_First(
			traineePdTlErDetailsId, orderByComparator);
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_First(
			long traineePdTlErDetailsId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return getPersistence().fetchByTraineePdTlErDetailsId_First(
			traineePdTlErDetailsId, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_Last(
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByTraineePdTlErDetailsId_Last(
			traineePdTlErDetailsId, orderByComparator);
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	public static TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_Last(
			long traineePdTlErDetailsId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return getPersistence().fetchByTraineePdTlErDetailsId_Last(
			traineePdTlErDetailsId, orderByComparator);
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails[]
			findByTraineePdTlErDetailsId_PrevAndNext(
				long traineeElectiverotationPriorityDetailsId,
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByTraineePdTlErDetailsId_PrevAndNext(
			traineeElectiverotationPriorityDetailsId, traineePdTlErDetailsId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63; from the database.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 */
	public static void removeByTraineePdTlErDetailsId(
		long traineePdTlErDetailsId) {

		getPersistence().removeByTraineePdTlErDetailsId(traineePdTlErDetailsId);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	public static int countByTraineePdTlErDetailsId(
		long traineePdTlErDetailsId) {

		return getPersistence().countByTraineePdTlErDetailsId(
			traineePdTlErDetailsId);
	}

	/**
	 * Caches the trainee electiverotation priority details in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 */
	public static void cacheResult(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		getPersistence().cacheResult(traineeElectiverotationPriorityDetails);
	}

	/**
	 * Caches the trainee electiverotation priority detailses in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetailses the trainee electiverotation priority detailses
	 */
	public static void cacheResult(
		List<TraineeElectiverotationPriorityDetails>
			traineeElectiverotationPriorityDetailses) {

		getPersistence().cacheResult(traineeElectiverotationPriorityDetailses);
	}

	/**
	 * Creates a new trainee electiverotation priority details with the primary key. Does not add the trainee electiverotation priority details to the database.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key for the new trainee electiverotation priority details
	 * @return the new trainee electiverotation priority details
	 */
	public static TraineeElectiverotationPriorityDetails create(
		long traineeElectiverotationPriorityDetailsId) {

		return getPersistence().create(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Removes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails remove(
			long traineeElectiverotationPriorityDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().remove(
			traineeElectiverotationPriorityDetailsId);
	}

	public static TraineeElectiverotationPriorityDetails updateImpl(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		return getPersistence().updateImpl(
			traineeElectiverotationPriorityDetails);
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails findByPrimaryKey(
			long traineeElectiverotationPriorityDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeElectiverotationPriorityDetailsException {

		return getPersistence().findByPrimaryKey(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details, or <code>null</code> if a trainee electiverotation priority details with the primary key could not be found
	 */
	public static TraineeElectiverotationPriorityDetails fetchByPrimaryKey(
		long traineeElectiverotationPriorityDetailsId) {

		return getPersistence().fetchByPrimaryKey(
			traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses.
	 *
	 * @return the trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	public static List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee electiverotation priority detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses.
	 *
	 * @return the number of trainee electiverotation priority detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeElectiverotationPriorityDetailsPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile TraineeElectiverotationPriorityDetailsPersistence
		_persistence;

}