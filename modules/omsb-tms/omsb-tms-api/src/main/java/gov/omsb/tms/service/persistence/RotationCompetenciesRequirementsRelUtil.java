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

import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rotation competencies requirements rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RotationCompetenciesRequirementsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationCompetenciesRequirementsRelPersistence
 * @generated
 */
public class RotationCompetenciesRequirementsRelUtil {

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
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		getPersistence().clearCache(rotationCompetenciesRequirementsRel);
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
	public static Map<Serializable, RotationCompetenciesRequirementsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RotationCompetenciesRequirementsRel update(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		return getPersistence().update(rotationCompetenciesRequirementsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RotationCompetenciesRequirementsRel update(
		RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			rotationCompetenciesRequirementsRel, serviceContext);
	}

	/**
	 * Returns all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByUuid_First(
			String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByUuid_Last(
			String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel[] findByUuid_PrevAndNext(
			long rotationCompetenciesRelId, String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			rotationCompetenciesRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation competencies requirements rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation competencies requirements rel that was removed
	 */
	public static RotationCompetenciesRequirementsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel[]
			findByUuid_C_PrevAndNext(
				long rotationCompetenciesRelId, String uuid, long companyId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rotationCompetenciesRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_First(
				long rotationId, long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByRotationIdAndProgramDurationId_First(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		return getPersistence().fetchByRotationIdAndProgramDurationId_First(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_Last(
				long rotationId, long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByRotationIdAndProgramDurationId_Last(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	public static RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		return getPersistence().fetchByRotationIdAndProgramDurationId_Last(
			rotationId, progDurationId, orderByComparator);
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationCompetenciesRelId, long rotationId,
				long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().
			findByRotationIdAndProgramDurationId_PrevAndNext(
				rotationCompetenciesRelId, rotationId, progDurationId,
				orderByComparator);
	}

	/**
	 * Removes all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63; from the database.
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
	 * Returns the number of rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	public static int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		return getPersistence().countByRotationIdAndProgramDurationId(
			rotationId, progDurationId);
	}

	/**
	 * Caches the rotation competencies requirements rel in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 */
	public static void cacheResult(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		getPersistence().cacheResult(rotationCompetenciesRequirementsRel);
	}

	/**
	 * Caches the rotation competencies requirements rels in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRels the rotation competencies requirements rels
	 */
	public static void cacheResult(
		List<RotationCompetenciesRequirementsRel>
			rotationCompetenciesRequirementsRels) {

		getPersistence().cacheResult(rotationCompetenciesRequirementsRels);
	}

	/**
	 * Creates a new rotation competencies requirements rel with the primary key. Does not add the rotation competencies requirements rel to the database.
	 *
	 * @param rotationCompetenciesRelId the primary key for the new rotation competencies requirements rel
	 * @return the new rotation competencies requirements rel
	 */
	public static RotationCompetenciesRequirementsRel create(
		long rotationCompetenciesRelId) {

		return getPersistence().create(rotationCompetenciesRelId);
	}

	/**
	 * Removes the rotation competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel remove(
			long rotationCompetenciesRelId)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().remove(rotationCompetenciesRelId);
	}

	public static RotationCompetenciesRequirementsRel updateImpl(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		return getPersistence().updateImpl(rotationCompetenciesRequirementsRel);
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel findByPrimaryKey(
			long rotationCompetenciesRelId)
		throws gov.omsb.tms.exception.
			NoSuchRotationCompetenciesRequirementsRelException {

		return getPersistence().findByPrimaryKey(rotationCompetenciesRelId);
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel, or <code>null</code> if a rotation competencies requirements rel with the primary key could not be found
	 */
	public static RotationCompetenciesRequirementsRel fetchByPrimaryKey(
		long rotationCompetenciesRelId) {

		return getPersistence().fetchByPrimaryKey(rotationCompetenciesRelId);
	}

	/**
	 * Returns all the rotation competencies requirements rels.
	 *
	 * @return the rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation competencies requirements rels
	 */
	public static List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rotation competencies requirements rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rotation competencies requirements rels.
	 *
	 * @return the number of rotation competencies requirements rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RotationCompetenciesRequirementsRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile RotationCompetenciesRequirementsRelPersistence
		_persistence;

}