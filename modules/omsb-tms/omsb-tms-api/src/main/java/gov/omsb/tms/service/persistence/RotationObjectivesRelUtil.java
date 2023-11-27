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

import gov.omsb.tms.model.RotationObjectivesRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rotation objectives rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RotationObjectivesRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationObjectivesRelPersistence
 * @generated
 */
public class RotationObjectivesRelUtil {

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
	public static void clearCache(RotationObjectivesRel rotationObjectivesRel) {
		getPersistence().clearCache(rotationObjectivesRel);
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
	public static Map<Serializable, RotationObjectivesRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RotationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RotationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RotationObjectivesRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RotationObjectivesRel update(
		RotationObjectivesRel rotationObjectivesRel) {

		return getPersistence().update(rotationObjectivesRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RotationObjectivesRel update(
		RotationObjectivesRel rotationObjectivesRel,
		ServiceContext serviceContext) {

		return getPersistence().update(rotationObjectivesRel, serviceContext);
	}

	/**
	 * Returns all the rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel findByUuid_First(
			String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel findByUuid_Last(
			String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel[] findByUuid_PrevAndNext(
			long rotationObjectivesRelId, String uuid,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_PrevAndNext(
			rotationObjectivesRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation objectives rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation objectives rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the rotation objectives rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation objectives rel that was removed
	 */
	public static RotationObjectivesRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation objectives rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel[] findByUuid_C_PrevAndNext(
			long rotationObjectivesRelId, String uuid, long companyId,
			OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rotationObjectivesRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the rotation objectives rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of rotation objectives rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation objectives rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId);
	}

	/**
	 * Returns a range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation objectives rels
	 */
	public static List<RotationObjectivesRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationObjectivesRel> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel
			findByRotationIdAndProgramDurationId_First(
				long rotationId, long progDurationId,
				OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByRotationIdAndProgramDurationId_First(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the first rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel
		fetchByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByRotationIdAndProgramDurationId_First(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel
			findByRotationIdAndProgramDurationId_Last(
				long rotationId, long progDurationId,
				OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByRotationIdAndProgramDurationId_Last(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the last rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation objectives rel, or <code>null</code> if a matching rotation objectives rel could not be found
	 */
	public static RotationObjectivesRel
		fetchByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().fetchByRotationIdAndProgramDurationId_Last(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the rotation objectives rels before and after the current rotation objectives rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationObjectivesRelId the primary key of the current rotation objectives rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationObjectivesRelId, long rotationId,
				long progDurationId,
				OrderByComparator<RotationObjectivesRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().
			findByRotationIdAndProgramDurationId_PrevAndNext(
				rotationObjectivesRelId, rotationId, progDurationId,
				orderByComparator);
	}

	/**
	 * Removes all the rotation objectives rels where rotationId = &#63; and progDurationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 */
	public static void removeByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		getPersistence().removeByRotationIdAndProgramDurationId(
			rotationId, progDurationId);
	}

	/**
	 * Returns the number of rotation objectives rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation objectives rels
	 */
	public static int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		return getPersistence().countByRotationIdAndProgramDurationId(
			rotationId, progDurationId);
	}

	/**
	 * Caches the rotation objectives rel in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRel the rotation objectives rel
	 */
	public static void cacheResult(
		RotationObjectivesRel rotationObjectivesRel) {

		getPersistence().cacheResult(rotationObjectivesRel);
	}

	/**
	 * Caches the rotation objectives rels in the entity cache if it is enabled.
	 *
	 * @param rotationObjectivesRels the rotation objectives rels
	 */
	public static void cacheResult(
		List<RotationObjectivesRel> rotationObjectivesRels) {

		getPersistence().cacheResult(rotationObjectivesRels);
	}

	/**
	 * Creates a new rotation objectives rel with the primary key. Does not add the rotation objectives rel to the database.
	 *
	 * @param rotationObjectivesRelId the primary key for the new rotation objectives rel
	 * @return the new rotation objectives rel
	 */
	public static RotationObjectivesRel create(long rotationObjectivesRelId) {
		return getPersistence().create(rotationObjectivesRelId);
	}

	/**
	 * Removes the rotation objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel that was removed
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel remove(long rotationObjectivesRelId)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().remove(rotationObjectivesRelId);
	}

	public static RotationObjectivesRel updateImpl(
		RotationObjectivesRel rotationObjectivesRel) {

		return getPersistence().updateImpl(rotationObjectivesRel);
	}

	/**
	 * Returns the rotation objectives rel with the primary key or throws a <code>NoSuchRotationObjectivesRelException</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel
	 * @throws NoSuchRotationObjectivesRelException if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel findByPrimaryKey(
			long rotationObjectivesRelId)
		throws gov.omsb.tms.exception.NoSuchRotationObjectivesRelException {

		return getPersistence().findByPrimaryKey(rotationObjectivesRelId);
	}

	/**
	 * Returns the rotation objectives rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationObjectivesRelId the primary key of the rotation objectives rel
	 * @return the rotation objectives rel, or <code>null</code> if a rotation objectives rel with the primary key could not be found
	 */
	public static RotationObjectivesRel fetchByPrimaryKey(
		long rotationObjectivesRelId) {

		return getPersistence().fetchByPrimaryKey(rotationObjectivesRelId);
	}

	/**
	 * Returns all the rotation objectives rels.
	 *
	 * @return the rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @return the range of rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation objectives rels
	 * @param end the upper bound of the range of rotation objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation objectives rels
	 */
	public static List<RotationObjectivesRel> findAll(
		int start, int end,
		OrderByComparator<RotationObjectivesRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rotation objectives rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rotation objectives rels.
	 *
	 * @return the number of rotation objectives rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RotationObjectivesRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RotationObjectivesRelPersistence _persistence;

}