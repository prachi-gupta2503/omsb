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

import gov.omsb.tms.model.TraineeAdmissionDetailsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the trainee admission details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.TraineeAdmissionDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRelPersistence
 * @generated
 */
public class TraineeAdmissionDetailsRelUtil {

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
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		getPersistence().clearCache(traineeAdmissionDetailsRel);
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
	public static Map<Serializable, TraineeAdmissionDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraineeAdmissionDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraineeAdmissionDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraineeAdmissionDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraineeAdmissionDetailsRel update(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		return getPersistence().update(traineeAdmissionDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraineeAdmissionDetailsRel update(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			traineeAdmissionDetailsRel, serviceContext);
	}

	/**
	 * Returns all the trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel[] findByUuid_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			traineeAdmissionDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee admission details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the trainee admission details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee admission details rel that was removed
	 */
	public static TraineeAdmissionDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee admission details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			traineeAdmissionDetailsRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee admission details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel[]
			findByProgramDurationId_PrevAndNext(
				long traineeAdmissionDetailsRelId, long programDurationId,
				OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			traineeAdmissionDetailsRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the trainee admission details rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee admission details rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel findByTraineeId(long traineeId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByTraineeId(traineeId);
	}

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByTraineeId(long traineeId) {
		return getPersistence().fetchByTraineeId(traineeId);
	}

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByTraineeId(
		long traineeId, boolean useFinderCache) {

		return getPersistence().fetchByTraineeId(traineeId, useFinderCache);
	}

	/**
	 * Removes the trainee admission details rel where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee admission details rel that was removed
	 */
	public static TraineeAdmissionDetailsRel removeByTraineeId(long traineeId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().removeByTraineeId(traineeId);
	}

	/**
	 * Returns the number of trainee admission details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee admission details rels
	 */
	public static int countByTraineeId(long traineeId) {
		return getPersistence().countByTraineeId(traineeId);
	}

	/**
	 * Caches the trainee admission details rel in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 */
	public static void cacheResult(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		getPersistence().cacheResult(traineeAdmissionDetailsRel);
	}

	/**
	 * Caches the trainee admission details rels in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRels the trainee admission details rels
	 */
	public static void cacheResult(
		List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels) {

		getPersistence().cacheResult(traineeAdmissionDetailsRels);
	}

	/**
	 * Creates a new trainee admission details rel with the primary key. Does not add the trainee admission details rel to the database.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key for the new trainee admission details rel
	 * @return the new trainee admission details rel
	 */
	public static TraineeAdmissionDetailsRel create(
		long traineeAdmissionDetailsRelId) {

		return getPersistence().create(traineeAdmissionDetailsRelId);
	}

	/**
	 * Removes the trainee admission details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel remove(
			long traineeAdmissionDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().remove(traineeAdmissionDetailsRelId);
	}

	public static TraineeAdmissionDetailsRel updateImpl(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		return getPersistence().updateImpl(traineeAdmissionDetailsRel);
	}

	/**
	 * Returns the trainee admission details rel with the primary key or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel findByPrimaryKey(
			long traineeAdmissionDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchTraineeAdmissionDetailsRelException {

		return getPersistence().findByPrimaryKey(traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns the trainee admission details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel, or <code>null</code> if a trainee admission details rel with the primary key could not be found
	 */
	public static TraineeAdmissionDetailsRel fetchByPrimaryKey(
		long traineeAdmissionDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns all the trainee admission details rels.
	 *
	 * @return the trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee admission details rels
	 */
	public static List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the trainee admission details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trainee admission details rels.
	 *
	 * @return the number of trainee admission details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TraineeAdmissionDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TraineeAdmissionDetailsRelPersistence _persistence;

}