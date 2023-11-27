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

import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration competencies requirements rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationCompetenciesRequirementsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRelPersistence
 * @generated
 */
public class ProgdurationCompetenciesRequirementsRelUtil {

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
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel) {

		getPersistence().clearCache(progdurationCompetenciesRequirementsRel);
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
	public static Map<Serializable, ProgdurationCompetenciesRequirementsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationCompetenciesRequirementsRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationCompetenciesRequirementsRel update(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel) {

		return getPersistence().update(progdurationCompetenciesRequirementsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationCompetenciesRequirementsRel update(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationCompetenciesRequirementsRel, serviceContext);
	}

	/**
	 * Returns all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration competencies requirements rels before and after the current progduration competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the current progduration competencies requirements rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel[]
			findByUuid_PrevAndNext(
				long progdurationCompetenciesRelId, String uuid,
				OrderByComparator<ProgdurationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			progdurationCompetenciesRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration competencies requirements rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration competencies requirements rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration competencies requirements rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration competencies requirements rel that was removed
	 */
	public static ProgdurationCompetenciesRequirementsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration competencies requirements rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationCompetenciesRequirementsRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration competencies requirements rels before and after the current progduration competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the current progduration competencies requirements rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel[]
			findByUuid_C_PrevAndNext(
				long progdurationCompetenciesRelId, String uuid, long companyId,
				OrderByComparator<ProgdurationCompetenciesRequirementsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progdurationCompetenciesRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the progduration competencies requirements rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration competencies requirements rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the progduration competencies requirements rel in the entity cache if it is enabled.
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 */
	public static void cacheResult(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel) {

		getPersistence().cacheResult(progdurationCompetenciesRequirementsRel);
	}

	/**
	 * Caches the progduration competencies requirements rels in the entity cache if it is enabled.
	 *
	 * @param progdurationCompetenciesRequirementsRels the progduration competencies requirements rels
	 */
	public static void cacheResult(
		List<ProgdurationCompetenciesRequirementsRel>
			progdurationCompetenciesRequirementsRels) {

		getPersistence().cacheResult(progdurationCompetenciesRequirementsRels);
	}

	/**
	 * Creates a new progduration competencies requirements rel with the primary key. Does not add the progduration competencies requirements rel to the database.
	 *
	 * @param progdurationCompetenciesRelId the primary key for the new progduration competencies requirements rel
	 * @return the new progduration competencies requirements rel
	 */
	public static ProgdurationCompetenciesRequirementsRel create(
		long progdurationCompetenciesRelId) {

		return getPersistence().create(progdurationCompetenciesRelId);
	}

	/**
	 * Removes the progduration competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel remove(
			long progdurationCompetenciesRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().remove(progdurationCompetenciesRelId);
	}

	public static ProgdurationCompetenciesRequirementsRel updateImpl(
		ProgdurationCompetenciesRequirementsRel
			progdurationCompetenciesRequirementsRel) {

		return getPersistence().updateImpl(
			progdurationCompetenciesRequirementsRel);
	}

	/**
	 * Returns the progduration competencies requirements rel with the primary key or throws a <code>NoSuchProgdurationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel
	 * @throws NoSuchProgdurationCompetenciesRequirementsRelException if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel findByPrimaryKey(
			long progdurationCompetenciesRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationCompetenciesRequirementsRelException {

		return getPersistence().findByPrimaryKey(progdurationCompetenciesRelId);
	}

	/**
	 * Returns the progduration competencies requirements rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel, or <code>null</code> if a progduration competencies requirements rel with the primary key could not be found
	 */
	public static ProgdurationCompetenciesRequirementsRel fetchByPrimaryKey(
		long progdurationCompetenciesRelId) {

		return getPersistence().fetchByPrimaryKey(
			progdurationCompetenciesRelId);
	}

	/**
	 * Returns all the progduration competencies requirements rels.
	 *
	 * @return the progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration competencies requirements rels
	 */
	public static List<ProgdurationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationCompetenciesRequirementsRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration competencies requirements rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration competencies requirements rels.
	 *
	 * @return the number of progduration competencies requirements rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationCompetenciesRequirementsRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile ProgdurationCompetenciesRequirementsRelPersistence
		_persistence;

}