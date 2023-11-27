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

import gov.omsb.tms.model.RoleTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the role type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.RoleTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMasterPersistence
 * @generated
 */
public class RoleTypeMasterUtil {

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
	public static void clearCache(RoleTypeMaster roleTypeMaster) {
		getPersistence().clearCache(roleTypeMaster);
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
	public static Map<Serializable, RoleTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RoleTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoleTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoleTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RoleTypeMaster update(RoleTypeMaster roleTypeMaster) {
		return getPersistence().update(roleTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RoleTypeMaster update(
		RoleTypeMaster roleTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(roleTypeMaster, serviceContext);
	}

	/**
	 * Returns all the role type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByUuid_First(
			String uuid, OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where uuid = &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster[] findByUuid_PrevAndNext(
			long roleTypeMasterId, String uuid,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			roleTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the role type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of role type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the role type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role type master that was removed
	 */
	public static RoleTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of role type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster[] findByUuid_C_PrevAndNext(
			long roleTypeMasterId, String uuid, long companyId,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			roleTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the role type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of role type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @return the matching role type masters
	 */
	public static List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName) {

		return getPersistence().findByRoleTypeNameByLike(roleTypeName);
	}

	/**
	 * Returns a range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end) {

		return getPersistence().findByRoleTypeNameByLike(
			roleTypeName, start, end);
	}

	/**
	 * Returns an ordered range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().findByRoleTypeNameByLike(
			roleTypeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type masters where roleTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param roleTypeName the role type name
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role type masters
	 */
	public static List<RoleTypeMaster> findByRoleTypeNameByLike(
		String roleTypeName, int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRoleTypeNameByLike(
			roleTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByRoleTypeNameByLike_First(
			String roleTypeName,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByRoleTypeNameByLike_First(
			roleTypeName, orderByComparator);
	}

	/**
	 * Returns the first role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByRoleTypeNameByLike_First(
		String roleTypeName,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByRoleTypeNameByLike_First(
			roleTypeName, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master
	 * @throws NoSuchRoleTypeMasterException if a matching role type master could not be found
	 */
	public static RoleTypeMaster findByRoleTypeNameByLike_Last(
			String roleTypeName,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByRoleTypeNameByLike_Last(
			roleTypeName, orderByComparator);
	}

	/**
	 * Returns the last role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	public static RoleTypeMaster fetchByRoleTypeNameByLike_Last(
		String roleTypeName,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().fetchByRoleTypeNameByLike_Last(
			roleTypeName, orderByComparator);
	}

	/**
	 * Returns the role type masters before and after the current role type master in the ordered set where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeMasterId the primary key of the current role type master
	 * @param roleTypeName the role type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster[] findByRoleTypeNameByLike_PrevAndNext(
			long roleTypeMasterId, String roleTypeName,
			OrderByComparator<RoleTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByRoleTypeNameByLike_PrevAndNext(
			roleTypeMasterId, roleTypeName, orderByComparator);
	}

	/**
	 * Removes all the role type masters where roleTypeName LIKE &#63; from the database.
	 *
	 * @param roleTypeName the role type name
	 */
	public static void removeByRoleTypeNameByLike(String roleTypeName) {
		getPersistence().removeByRoleTypeNameByLike(roleTypeName);
	}

	/**
	 * Returns the number of role type masters where roleTypeName LIKE &#63;.
	 *
	 * @param roleTypeName the role type name
	 * @return the number of matching role type masters
	 */
	public static int countByRoleTypeNameByLike(String roleTypeName) {
		return getPersistence().countByRoleTypeNameByLike(roleTypeName);
	}

	/**
	 * Caches the role type master in the entity cache if it is enabled.
	 *
	 * @param roleTypeMaster the role type master
	 */
	public static void cacheResult(RoleTypeMaster roleTypeMaster) {
		getPersistence().cacheResult(roleTypeMaster);
	}

	/**
	 * Caches the role type masters in the entity cache if it is enabled.
	 *
	 * @param roleTypeMasters the role type masters
	 */
	public static void cacheResult(List<RoleTypeMaster> roleTypeMasters) {
		getPersistence().cacheResult(roleTypeMasters);
	}

	/**
	 * Creates a new role type master with the primary key. Does not add the role type master to the database.
	 *
	 * @param roleTypeMasterId the primary key for the new role type master
	 * @return the new role type master
	 */
	public static RoleTypeMaster create(long roleTypeMasterId) {
		return getPersistence().create(roleTypeMasterId);
	}

	/**
	 * Removes the role type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master that was removed
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster remove(long roleTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().remove(roleTypeMasterId);
	}

	public static RoleTypeMaster updateImpl(RoleTypeMaster roleTypeMaster) {
		return getPersistence().updateImpl(roleTypeMaster);
	}

	/**
	 * Returns the role type master with the primary key or throws a <code>NoSuchRoleTypeMasterException</code> if it could not be found.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master
	 * @throws NoSuchRoleTypeMasterException if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster findByPrimaryKey(long roleTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchRoleTypeMasterException {

		return getPersistence().findByPrimaryKey(roleTypeMasterId);
	}

	/**
	 * Returns the role type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master, or <code>null</code> if a role type master with the primary key could not be found
	 */
	public static RoleTypeMaster fetchByPrimaryKey(long roleTypeMasterId) {
		return getPersistence().fetchByPrimaryKey(roleTypeMasterId);
	}

	/**
	 * Returns all the role type masters.
	 *
	 * @return the role type masters
	 */
	public static List<RoleTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of role type masters
	 */
	public static List<RoleTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role type masters
	 */
	public static List<RoleTypeMaster> findAll(
		int start, int end,
		OrderByComparator<RoleTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role type masters
	 */
	public static List<RoleTypeMaster> findAll(
		int start, int end, OrderByComparator<RoleTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the role type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of role type masters.
	 *
	 * @return the number of role type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoleTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoleTypeMasterPersistence _persistence;

}