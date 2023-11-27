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

import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee rotation ts block details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeRotationTsBlockDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRelPersistence
 * @generated
 */
public class TraineeRotationTsBlockDetailsRelUtil {

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
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		getPersistence().clearCache(traineeRotationTsBlockDetailsRel);
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
	public static Map<Serializable, TraineeRotationTsBlockDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeRotationTsBlockDetailsRel update(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		return getPersistence().update(traineeRotationTsBlockDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeRotationTsBlockDetailsRel update(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			traineeRotationTsBlockDetailsRel, serviceContext);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	public static TraineeRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {

		return getPersistence().findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end) {

		return getPersistence().findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_First(
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailsRelId_First(
			blocksMetadataDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_First(
			long blocksMetadataDetailsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailsRelId_First(
			blocksMetadataDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_Last(
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailsRelId_Last(
			blocksMetadataDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_Last(
			long blocksMetadataDetailsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailsRelId_Last(
			blocksMetadataDetailsRelId, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailsRelId_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, blocksMetadataDetailsRelId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 */
	public static void removeByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId) {

		getPersistence().removeByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId) {

		return getPersistence().countByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId) {

		return getPersistence().findByTraineeId(traineeId);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end) {

		return getPersistence().findByTraineeId(traineeId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTraineeId(
			traineeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByTraineeId_First(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().fetchByTraineeId_Last(
			traineeId, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[]
			findByTraineeId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId, long traineeId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeId_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, traineeId, orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public static void removeByTraineeId(long traineeId) {
		getPersistence().removeByTraineeId(traineeId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByTraineeId(long traineeId) {
		return getPersistence().countByTraineeId(traineeId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_First(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByProgDurationRotationTsRelId_First(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_Last(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByProgDurationRotationTsRelId_Last(
			progDurationRotationTsRelId, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByProgDurationRotationTsRelId_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, progDurationRotationTsRelId,
			orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	public static void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		getPersistence().removeByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		return getPersistence().countByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(long traineeId, String status) {

		return getPersistence().findByTraineeIdAndStatus(traineeId, status);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end) {

		return getPersistence().findByTraineeIdAndStatus(
			traineeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().findByTraineeIdAndStatus(
			traineeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(
			long traineeId, String status, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTraineeIdAndStatus(
			traineeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByTraineeIdAndStatus_First(
				long traineeId, String status,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeIdAndStatus_First(
			traineeId, status, orderByComparator);
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndStatus_First(
			long traineeId, String status,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeIdAndStatus_First(
			traineeId, status, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByTraineeIdAndStatus_Last(
				long traineeId, String status,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeIdAndStatus_Last(
			traineeId, status, orderByComparator);
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndStatus_Last(
			long traineeId, String status,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getPersistence().fetchByTraineeIdAndStatus_Last(
			traineeId, status, orderByComparator);
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel[]
			findByTraineeIdAndStatus_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId, long traineeId,
				String status,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeIdAndStatus_PrevAndNext(
			traineeRotationTsBlockDetailsRelId, traineeId, status,
			orderByComparator);
	}

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 */
	public static void removeByTraineeIdAndStatus(
		long traineeId, String status) {

		getPersistence().removeByTraineeIdAndStatus(traineeId, status);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByTraineeIdAndStatus(long traineeId, String status) {
		return getPersistence().countByTraineeIdAndStatus(traineeId, status);
	}

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			findByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId) {

		return getPersistence().fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId,
			boolean useFinderCache) {

		return getPersistence().fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId, useFinderCache);
	}

	/**
	 * Removes the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	public static TraineeRotationTsBlockDetailsRel
			removeByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().removeByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	public static int countByTraineeIdAndBlocksMetadataDetailsRelId(
		long traineeId, long blocksMetadataDetailsRelId) {

		return getPersistence().countByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId);
	}

	/**
	 * Caches the trainee rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 */
	public static void cacheResult(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		getPersistence().cacheResult(traineeRotationTsBlockDetailsRel);
	}

	/**
	 * Caches the trainee rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRels the trainee rotation ts block details rels
	 */
	public static void cacheResult(
		List<TraineeRotationTsBlockDetailsRel>
			traineeRotationTsBlockDetailsRels) {

		getPersistence().cacheResult(traineeRotationTsBlockDetailsRels);
	}

	/**
	 * Creates a new trainee rotation ts block details rel with the primary key. Does not add the trainee rotation ts block details rel to the database.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key for the new trainee rotation ts block details rel
	 * @return the new trainee rotation ts block details rel
	 */
	public static TraineeRotationTsBlockDetailsRel create(
		long traineeRotationTsBlockDetailsRelId) {

		return getPersistence().create(traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Removes the trainee rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel remove(
			long traineeRotationTsBlockDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().remove(traineeRotationTsBlockDetailsRelId);
	}

	public static TraineeRotationTsBlockDetailsRel updateImpl(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		return getPersistence().updateImpl(traineeRotationTsBlockDetailsRel);
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel findByPrimaryKey(
			long traineeRotationTsBlockDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeRotationTsBlockDetailsRelException {

		return getPersistence().findByPrimaryKey(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel, or <code>null</code> if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel fetchByPrimaryKey(
		long traineeRotationTsBlockDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels.
	 *
	 * @return the trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee rotation ts block details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee rotation ts block details rels.
	 *
	 * @return the number of trainee rotation ts block details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeRotationTsBlockDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TraineeRotationTsBlockDetailsRelPersistence
		_persistence;

}