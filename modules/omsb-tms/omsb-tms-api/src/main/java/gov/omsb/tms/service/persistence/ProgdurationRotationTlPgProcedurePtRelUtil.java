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

import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the progduration rotation tl pg procedure pt rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgdurationRotationTlPgProcedurePtRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRelPersistence
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelUtil {

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
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		getPersistence().clearCache(progdurationRotationTlPgProcedurePtRel);
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
	public static Map<Serializable, ProgdurationRotationTlPgProcedurePtRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgdurationRotationTlPgProcedurePtRel update(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		return getPersistence().update(progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgdurationRotationTlPgProcedurePtRel update(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			progdurationRotationTlPgProcedurePtRel, serviceContext);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid) {

		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel[]
			findByUuid_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId, String uuid,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_PrevAndNext(
			progdurationRotationTlPgProcedurePtRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public static ProgdurationRotationTlPgProcedurePtRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel[]
			findByUuid_C_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId, String uuid,
				long companyId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			progdurationRotationTlPgProcedurePtRelId, uuid, companyId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(long procedureGroupId) {

		return getPersistence().findByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(long procedureGroupId, int start, int end) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProcedureGroupId(
			long procedureGroupId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProcedureGroupId(
			procedureGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProcedureGroupId_First(
				long procedureGroupId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProcedureGroupId_First(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProcedureGroupId_First(
			long procedureGroupId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupId_First(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProcedureGroupId_Last(
				long procedureGroupId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProcedureGroupId_Last(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProcedureGroupId_Last(
			long procedureGroupId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().fetchByProcedureGroupId_Last(
			procedureGroupId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where procedureGroupId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param procedureGroupId the procedure group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel[]
			findByProcedureGroupId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long procedureGroupId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProcedureGroupId_PrevAndNext(
			progdurationRotationTlPgProcedurePtRelId, procedureGroupId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where procedureGroupId = &#63; from the database.
	 *
	 * @param procedureGroupId the procedure group ID
	 */
	public static void removeByProcedureGroupId(long procedureGroupId) {
		getPersistence().removeByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureGroupId = &#63;.
	 *
	 * @param procedureGroupId the procedure group ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByProcedureGroupId(long procedureGroupId) {
		return getPersistence().countByProcedureGroupId(procedureGroupId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByProcedureId(
			long procedureId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProcedureId(procedureId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId) {

		return getPersistence().fetchByProcedureId(procedureId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where procedureId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param procedureId the procedure ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByProcedureId(
		long procedureId, boolean useFinderCache) {

		return getPersistence().fetchByProcedureId(procedureId, useFinderCache);
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where procedureId = &#63; from the database.
	 *
	 * @param procedureId the procedure ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public static ProgdurationRotationTlPgProcedurePtRel removeByProcedureId(
			long procedureId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().removeByProcedureId(procedureId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where procedureId = &#63;.
	 *
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByProcedureId(long procedureId) {
		return getPersistence().countByProcedureId(procedureId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationId(
			long programDurationId, int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationId_First(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationId_Last(
				long programDurationId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			progdurationRotationTlPgProcedurePtRelId, programDurationId,
			orderByComparator);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId) {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end) {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId, start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId, start, end,
				orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel>
		findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId,
			int start, int end,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId, start, end,
				orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
				programDurationId, procedureGroupId, procedureId,
				orderByComparator);
	}

	/**
	 * Returns the first progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
			long programDurationId, long procedureGroupId, long procedureId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_First(
				programDurationId, procedureGroupId, procedureId,
				orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
				programDurationId, procedureGroupId, procedureId,
				orderByComparator);
	}

	/**
	 * Returns the last progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
			long programDurationId, long procedureGroupId, long procedureId,
			OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
				orderByComparator) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupIdAndProcedureId_Last(
				programDurationId, procedureGroupId, procedureId,
				orderByComparator);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rels before and after the current progduration rotation tl pg procedure pt rel in the ordered set where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the current progduration rotation tl pg procedure pt rel
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel[]
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
				long progdurationRotationTlPgProcedurePtRelId,
				long programDurationId, long procedureGroupId, long procedureId,
				OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId_PrevAndNext(
				progdurationRotationTlPgProcedurePtRelId, programDurationId,
				procedureGroupId, procedureId, orderByComparator);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 */
	public static void
		removeByProgramDurationIdAndProcedureGroupIdAndProcedureId(
			long programDurationId, long procedureGroupId, long procedureId) {

		getPersistence().
			removeByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int countByProgramDurationIdAndProcedureGroupIdAndProcedureId(
		long programDurationId, long procedureGroupId, long procedureId) {

		return getPersistence().
			countByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
		fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId, boolean useFinderCache) {

		return getPersistence().
			fetchByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId,
				useFinderCache);
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	public static ProgdurationRotationTlPgProcedurePtRel
			removeByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				long programDurationId, long procedureGroupId, long procedureId,
				long rotationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().
			removeByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels where programDurationId = &#63; and procedureGroupId = &#63; and procedureId = &#63; and rotationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param procedureGroupId the procedure group ID
	 * @param procedureId the procedure ID
	 * @param rotationId the rotation ID
	 * @return the number of matching progduration rotation tl pg procedure pt rels
	 */
	public static int
		countByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		return getPersistence().
			countByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	/**
	 * Caches the progduration rotation tl pg procedure pt rel in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 */
	public static void cacheResult(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		getPersistence().cacheResult(progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Caches the progduration rotation tl pg procedure pt rels in the entity cache if it is enabled.
	 *
	 * @param progdurationRotationTlPgProcedurePtRels the progduration rotation tl pg procedure pt rels
	 */
	public static void cacheResult(
		List<ProgdurationRotationTlPgProcedurePtRel>
			progdurationRotationTlPgProcedurePtRels) {

		getPersistence().cacheResult(progdurationRotationTlPgProcedurePtRels);
	}

	/**
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	public static ProgdurationRotationTlPgProcedurePtRel create(
		long progdurationRotationTlPgProcedurePtRelId) {

		return getPersistence().create(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Removes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel remove(
			long progdurationRotationTlPgProcedurePtRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().remove(
			progdurationRotationTlPgProcedurePtRelId);
	}

	public static ProgdurationRotationTlPgProcedurePtRel updateImpl(
		ProgdurationRotationTlPgProcedurePtRel
			progdurationRotationTlPgProcedurePtRel) {

		return getPersistence().updateImpl(
			progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or throws a <code>NoSuchProgdurationRotationTlPgProcedurePtRelException</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws NoSuchProgdurationRotationTlPgProcedurePtRelException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel findByPrimaryKey(
			long progdurationRotationTlPgProcedurePtRelId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTlPgProcedurePtRelException {

		return getPersistence().findByPrimaryKey(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel, or <code>null</code> if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	public static ProgdurationRotationTlPgProcedurePtRel fetchByPrimaryKey(
		long progdurationRotationTlPgProcedurePtRelId) {

		return getPersistence().fetchByPrimaryKey(
			progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels.
	 *
	 * @return the progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of progduration rotation tl pg procedure pt rels
	 */
	public static List<ProgdurationRotationTlPgProcedurePtRel> findAll(
		int start, int end,
		OrderByComparator<ProgdurationRotationTlPgProcedurePtRel>
			orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the progduration rotation tl pg procedure pt rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgdurationRotationTlPgProcedurePtRelPersistence
		getPersistence() {

		return _persistence;
	}

	private static volatile ProgdurationRotationTlPgProcedurePtRelPersistence
		_persistence;

}