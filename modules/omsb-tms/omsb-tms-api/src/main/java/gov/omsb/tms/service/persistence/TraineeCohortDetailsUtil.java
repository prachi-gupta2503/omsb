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

import gov.omsb.tms.model.TraineeCohortDetails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee cohort details service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeCohortDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetailsPersistence
 * @generated
 */
public class TraineeCohortDetailsUtil {

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
	public static void clearCache(TraineeCohortDetails traineeCohortDetails) {
		getPersistence().clearCache(traineeCohortDetails);
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
	public static Map<Serializable, TraineeCohortDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeCohortDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeCohortDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeCohortDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeCohortDetails update(
		TraineeCohortDetails traineeCohortDetails) {

		return getPersistence().update(traineeCohortDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeCohortDetails update(
		TraineeCohortDetails traineeCohortDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(traineeCohortDetails, serviceContext);
	}

	/**
	 * Returns all the trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails[] findByUuid_PrevAndNext(
			long traineeCohortDetailsId, String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeCohortDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee cohort detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee cohort details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee cohort details that was removed
	 */
	public static TraineeCohortDetails removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee cohort detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails[] findByUuid_C_PrevAndNext(
			long traineeCohortDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeCohortDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee cohort detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end) {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
				end);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
				end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			OrderByComparator<TraineeCohortDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
				end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().
			fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().
			fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				String cohortYear, long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
				traineeCohortDetailsId, traineeAdmissionDetailsRelId,
				cohortYear, traineeLevelId, orderByComparator);
	}

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 */
	public static void
		removeByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		getPersistence().
			removeByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee cohort detailses
	 */
	public static int
		countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		return getPersistence().
			countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);
	}

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);
	}

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel) {

		return getPersistence().
			fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);
	}

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel,
			boolean useFinderCache) {

		return getPersistence().
			fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel,
				useFinderCache);
	}

	/**
	 * Removes the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the trainee cohort details that was removed
	 */
	public static TraineeCohortDetails
			removeByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().
			removeByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the number of matching trainee cohort detailses
	 */
	public static int
		countByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel) {

		return getPersistence().
			countByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);
	}

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		return getPersistence().findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end) {

		return getPersistence().findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByTraineeAdmissionDetailsRelId_First(
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByTraineeAdmissionDetailsRelId_First(
			traineeAdmissionDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelId_First(
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByTraineeAdmissionDetailsRelId_First(
			traineeAdmissionDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails findByTraineeAdmissionDetailsRelId_Last(
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByTraineeAdmissionDetailsRelId_Last(
			traineeAdmissionDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	public static TraineeCohortDetails fetchByTraineeAdmissionDetailsRelId_Last(
		long traineeAdmissionDetailsRelId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().fetchByTraineeAdmissionDetailsRelId_Last(
			traineeAdmissionDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByTraineeAdmissionDetailsRelId_PrevAndNext(
			traineeCohortDetailsId, traineeAdmissionDetailsRelId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 */
	public static void removeByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		getPersistence().removeByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the number of matching trainee cohort detailses
	 */
	public static int countByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		return getPersistence().countByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);
	}

	/**
	 * Caches the trainee cohort details in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 */
	public static void cacheResult(TraineeCohortDetails traineeCohortDetails) {
		getPersistence().cacheResult(traineeCohortDetails);
	}

	/**
	 * Caches the trainee cohort detailses in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetailses the trainee cohort detailses
	 */
	public static void cacheResult(
		List<TraineeCohortDetails> traineeCohortDetailses) {

		getPersistence().cacheResult(traineeCohortDetailses);
	}

	/**
	 * Creates a new trainee cohort details with the primary key. Does not add the trainee cohort details to the database.
	 *
	 * @param traineeCohortDetailsId the primary key for the new trainee cohort details
	 * @return the new trainee cohort details
	 */
	public static TraineeCohortDetails create(long traineeCohortDetailsId) {
		return getPersistence().create(traineeCohortDetailsId);
	}

	/**
	 * Removes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails remove(long traineeCohortDetailsId)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().remove(traineeCohortDetailsId);
	}

	public static TraineeCohortDetails updateImpl(
		TraineeCohortDetails traineeCohortDetails) {

		return getPersistence().updateImpl(traineeCohortDetails);
	}

	/**
	 * Returns the trainee cohort details with the primary key or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails findByPrimaryKey(
			long traineeCohortDetailsId)
		throws gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException {

		return getPersistence().findByPrimaryKey(traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details, or <code>null</code> if a trainee cohort details with the primary key could not be found
	 */
	public static TraineeCohortDetails fetchByPrimaryKey(
		long traineeCohortDetailsId) {

		return getPersistence().fetchByPrimaryKey(traineeCohortDetailsId);
	}

	/**
	 * Returns all the trainee cohort detailses.
	 *
	 * @return the trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee cohort detailses
	 */
	public static List<TraineeCohortDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee cohort detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee cohort detailses.
	 *
	 * @return the number of trainee cohort detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeCohortDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TraineeCohortDetailsPersistence _persistence;

}