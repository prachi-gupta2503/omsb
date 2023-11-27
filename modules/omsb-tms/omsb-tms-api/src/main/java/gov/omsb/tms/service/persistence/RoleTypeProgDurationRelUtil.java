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

import gov.omsb.tms.model.RoleTypeProgDurationRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the role type prog duration rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RoleTypeProgDurationRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelPersistence
 * @generated
 */
public class RoleTypeProgDurationRelUtil {

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
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		getPersistence().clearCache(roleTypeProgDurationRel);
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
	public static Map<Serializable, RoleTypeProgDurationRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RoleTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoleTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoleTypeProgDurationRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RoleTypeProgDurationRel update(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		return getPersistence().update(roleTypeProgDurationRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RoleTypeProgDurationRel update(
		RoleTypeProgDurationRel roleTypeProgDurationRel,
		ServiceContext serviceContext) {

		return getPersistence().update(roleTypeProgDurationRel, serviceContext);
	}

	/**
	 * Returns all the role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByUuid_First(
			String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByUuid_Last(
			String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel[] findByUuid_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_PrevAndNext(
			RoleTypeProgDurationRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role type prog duration rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role type prog duration rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the role type prog duration rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role type prog duration rel that was removed
	 */
	public static RoleTypeProgDurationRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role type prog duration rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel[] findByUuid_C_PrevAndNext(
			long RoleTypeProgDurationRelId, String uuid, long companyId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			RoleTypeProgDurationRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the role type prog duration rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of role type prog duration rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role type prog duration rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId) {

		return getPersistence().findByProgramDurationId(programDurationId);
	}

	/**
	 * Returns a range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramDurationId(
			programDurationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the first role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_First(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the last role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().fetchByProgramDurationId_Last(
			programDurationId, orderByComparator);
	}

	/**
	 * Returns the role type prog duration rels before and after the current role type prog duration rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the current role type prog duration rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel[] findByProgramDurationId_PrevAndNext(
			long RoleTypeProgDurationRelId, long programDurationId,
			OrderByComparator<RoleTypeProgDurationRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByProgramDurationId_PrevAndNext(
			RoleTypeProgDurationRelId, programDurationId, orderByComparator);
	}

	/**
	 * Removes all the role type prog duration rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	public static void removeByProgramDurationId(long programDurationId) {
		getPersistence().removeByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching role type prog duration rels
	 */
	public static int countByProgramDurationId(long programDurationId) {
		return getPersistence().countByProgramDurationId(programDurationId);
	}

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel
			findByProgramDurationIdAndRoleTypeMasterId(
				long programDurationId, long roleTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId);
	}

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel
		fetchByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId) {

		return getPersistence().fetchByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId);
	}

	/**
	 * Returns the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	public static RoleTypeProgDurationRel
		fetchByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId,
			boolean useFinderCache) {

		return getPersistence().fetchByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId, useFinderCache);
	}

	/**
	 * Removes the role type prog duration rel where programDurationId = &#63; and roleTypeMasterId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the role type prog duration rel that was removed
	 */
	public static RoleTypeProgDurationRel
			removeByProgramDurationIdAndRoleTypeMasterId(
				long programDurationId, long roleTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().removeByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId);
	}

	/**
	 * Returns the number of role type prog duration rels where programDurationId = &#63; and roleTypeMasterId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param roleTypeMasterId the role type master ID
	 * @return the number of matching role type prog duration rels
	 */
	public static int countByProgramDurationIdAndRoleTypeMasterId(
		long programDurationId, long roleTypeMasterId) {

		return getPersistence().countByProgramDurationIdAndRoleTypeMasterId(
			programDurationId, roleTypeMasterId);
	}

	/**
	 * Caches the role type prog duration rel in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 */
	public static void cacheResult(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		getPersistence().cacheResult(roleTypeProgDurationRel);
	}

	/**
	 * Caches the role type prog duration rels in the entity cache if it is enabled.
	 *
	 * @param roleTypeProgDurationRels the role type prog duration rels
	 */
	public static void cacheResult(
		List<RoleTypeProgDurationRel> roleTypeProgDurationRels) {

		getPersistence().cacheResult(roleTypeProgDurationRels);
	}

	/**
	 * Creates a new role type prog duration rel with the primary key. Does not add the role type prog duration rel to the database.
	 *
	 * @param RoleTypeProgDurationRelId the primary key for the new role type prog duration rel
	 * @return the new role type prog duration rel
	 */
	public static RoleTypeProgDurationRel create(
		long RoleTypeProgDurationRelId) {

		return getPersistence().create(RoleTypeProgDurationRelId);
	}

	/**
	 * Removes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel remove(long RoleTypeProgDurationRelId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().remove(RoleTypeProgDurationRelId);
	}

	public static RoleTypeProgDurationRel updateImpl(
		RoleTypeProgDurationRel roleTypeProgDurationRel) {

		return getPersistence().updateImpl(roleTypeProgDurationRel);
	}

	/**
	 * Returns the role type prog duration rel with the primary key or throws a <code>NoSuchRoleTypeProgDurationRelException</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws NoSuchRoleTypeProgDurationRelException if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel findByPrimaryKey(
			long RoleTypeProgDurationRelId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeProgDurationRelException {

		return getPersistence().findByPrimaryKey(RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel, or <code>null</code> if a role type prog duration rel with the primary key could not be found
	 */
	public static RoleTypeProgDurationRel fetchByPrimaryKey(
		long RoleTypeProgDurationRelId) {

		return getPersistence().fetchByPrimaryKey(RoleTypeProgDurationRelId);
	}

	/**
	 * Returns all the role type prog duration rels.
	 *
	 * @return the role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role type prog duration rels
	 */
	public static List<RoleTypeProgDurationRel> findAll(
		int start, int end,
		OrderByComparator<RoleTypeProgDurationRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the role type prog duration rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of role type prog duration rels.
	 *
	 * @return the number of role type prog duration rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoleTypeProgDurationRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoleTypeProgDurationRelPersistence _persistence;

}