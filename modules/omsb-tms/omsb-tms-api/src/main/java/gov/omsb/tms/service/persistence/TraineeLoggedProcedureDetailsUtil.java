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

import gov.omsb.tms.model.TraineeLoggedProcedureDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee logged procedure details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeLoggedProcedureDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetailsPersistence
 * @generated
 */
public class TraineeLoggedProcedureDetailsUtil {

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
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		getPersistence().clearCache(traineeLoggedProcedureDetails);
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
	public static Map<Serializable, TraineeLoggedProcedureDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeLoggedProcedureDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeLoggedProcedureDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeLoggedProcedureDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeLoggedProcedureDetails update(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		return getPersistence().update(traineeLoggedProcedureDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeLoggedProcedureDetails update(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			traineeLoggedProcedureDetails, serviceContext);
	}

	/**
	 * Returns all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails[] findByUuid_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeLoggedProcedureDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee logged procedure details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee logged procedure details that was removed
	 */
	public static TraineeLoggedProcedureDetails removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails[] findByUuid_C_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeLoggedProcedureDetailsId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId) {

		return getPersistence().findByPatientId(patientId);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end) {

		return getPersistence().findByPatientId(patientId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findByPatientId(
			patientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPatientId(
			patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByPatientId_First(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientId_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByPatientId_First(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByPatientId_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByPatientId_Last(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientId_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByPatientId_Last(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByPatientId_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails[] findByPatientId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientId_PrevAndNext(
			traineeLoggedProcedureDetailsId, patientId, orderByComparator);
	}

	/**
	 * Removes all the trainee logged procedure detailses where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public static void removeByPatientId(String patientId) {
		getPersistence().removeByPatientId(patientId);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByPatientId(String patientId) {
		return getPersistence().countByPatientId(patientId);
	}

	/**
	 * Returns all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId) {

		return getPersistence().findByPatientIdByLike(patientId);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end) {

		return getPersistence().findByPatientIdByLike(patientId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findByPatientIdByLike(
			patientId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPatientIdByLike(
			patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByPatientIdByLike_First(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientIdByLike_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByPatientIdByLike_First(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByPatientIdByLike_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByPatientIdByLike_Last(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientIdByLike_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByPatientIdByLike_Last(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByPatientIdByLike_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails[]
			findByPatientIdByLike_PrevAndNext(
				long traineeLoggedProcedureDetailsId, String patientId,
				OrderByComparator<TraineeLoggedProcedureDetails>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPatientIdByLike_PrevAndNext(
			traineeLoggedProcedureDetailsId, patientId, orderByComparator);
	}

	/**
	 * Removes all the trainee logged procedure detailses where patientId LIKE &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public static void removeByPatientIdByLike(String patientId) {
		getPersistence().removeByPatientIdByLike(patientId);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByPatientIdByLike(String patientId) {
		return getPersistence().countByPatientIdByLike(patientId);
	}

	/**
	 * Returns all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId) {

		return getPersistence().findByTraineeId(traineeId);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end) {

		return getPersistence().findByTraineeId(traineeId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().fetchByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails[] findByTraineeId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByTraineeId_PrevAndNext(
			traineeLoggedProcedureDetailsId, traineeId, orderByComparator);
	}

	/**
	 * Removes all the trainee logged procedure detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public static void removeByTraineeId(long traineeId) {
		getPersistence().removeByTraineeId(traineeId);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	public static int countByTraineeId(long traineeId) {
		return getPersistence().countByTraineeId(traineeId);
	}

	/**
	 * Caches the trainee logged procedure details in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 */
	public static void cacheResult(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		getPersistence().cacheResult(traineeLoggedProcedureDetails);
	}

	/**
	 * Caches the trainee logged procedure detailses in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetailses the trainee logged procedure detailses
	 */
	public static void cacheResult(
		List<TraineeLoggedProcedureDetails> traineeLoggedProcedureDetailses) {

		getPersistence().cacheResult(traineeLoggedProcedureDetailses);
	}

	/**
	 * Creates a new trainee logged procedure details with the primary key. Does not add the trainee logged procedure details to the database.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key for the new trainee logged procedure details
	 * @return the new trainee logged procedure details
	 */
	public static TraineeLoggedProcedureDetails create(
		long traineeLoggedProcedureDetailsId) {

		return getPersistence().create(traineeLoggedProcedureDetailsId);
	}

	/**
	 * Removes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails remove(
			long traineeLoggedProcedureDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().remove(traineeLoggedProcedureDetailsId);
	}

	public static TraineeLoggedProcedureDetails updateImpl(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		return getPersistence().updateImpl(traineeLoggedProcedureDetails);
	}

	/**
	 * Returns the trainee logged procedure details with the primary key or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails findByPrimaryKey(
			long traineeLoggedProcedureDetailsId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeLoggedProcedureDetailsException {

		return getPersistence().findByPrimaryKey(
			traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns the trainee logged procedure details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details, or <code>null</code> if a trainee logged procedure details with the primary key could not be found
	 */
	public static TraineeLoggedProcedureDetails fetchByPrimaryKey(
		long traineeLoggedProcedureDetailsId) {

		return getPersistence().fetchByPrimaryKey(
			traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns all the trainee logged procedure detailses.
	 *
	 * @return the trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee logged procedure detailses
	 */
	public static List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee logged procedure detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee logged procedure detailses.
	 *
	 * @return the number of trainee logged procedure detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeLoggedProcedureDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TraineeLoggedProcedureDetailsPersistence
		_persistence;

}