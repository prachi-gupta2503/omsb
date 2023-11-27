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

import gov.omsb.tms.model.ProgramTypeMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program type master service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterPersistence
 * @generated
 */
public class ProgramTypeMasterUtil {

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
	public static void clearCache(ProgramTypeMaster programTypeMaster) {
		getPersistence().clearCache(programTypeMaster);
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
	public static Map<Serializable, ProgramTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramTypeMaster update(
		ProgramTypeMaster programTypeMaster) {

		return getPersistence().update(programTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramTypeMaster update(
		ProgramTypeMaster programTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(programTypeMaster, serviceContext);
	}

	/**
	 * Returns all the program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByUuid_First(
			String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUuid_First(
		String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByUuid_Last(
			String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster[] findByUuid_PrevAndNext(
			long programTypeMasterId, String uuid,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_PrevAndNext(
			programTypeMasterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program type masters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program type master that was removed
	 */
	public static ProgramTypeMaster removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program type masters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster[] findByUuid_C_PrevAndNext(
			long programTypeMasterId, String uuid, long companyId,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programTypeMasterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program type masters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the matching program type masters
	 */
	public static List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName) {

		return getPersistence().findByProgramTypeNameByLike(programTypeName);
	}

	/**
	 * Returns a range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end) {

		return getPersistence().findByProgramTypeNameByLike(
			programTypeName, start, end);
	}

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().findByProgramTypeNameByLike(
			programTypeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public static List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramTypeNameByLike(
			programTypeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByProgramTypeNameByLike_First(
			String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByProgramTypeNameByLike_First(
			programTypeName, orderByComparator);
	}

	/**
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByProgramTypeNameByLike_First(
		String programTypeName,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByProgramTypeNameByLike_First(
			programTypeName, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public static ProgramTypeMaster findByProgramTypeNameByLike_Last(
			String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByProgramTypeNameByLike_Last(
			programTypeName, orderByComparator);
	}

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public static ProgramTypeMaster fetchByProgramTypeNameByLike_Last(
		String programTypeName,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().fetchByProgramTypeNameByLike_Last(
			programTypeName, orderByComparator);
	}

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster[] findByProgramTypeNameByLike_PrevAndNext(
			long programTypeMasterId, String programTypeName,
			OrderByComparator<ProgramTypeMaster> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByProgramTypeNameByLike_PrevAndNext(
			programTypeMasterId, programTypeName, orderByComparator);
	}

	/**
	 * Removes all the program type masters where programTypeName LIKE &#63; from the database.
	 *
	 * @param programTypeName the program type name
	 */
	public static void removeByProgramTypeNameByLike(String programTypeName) {
		getPersistence().removeByProgramTypeNameByLike(programTypeName);
	}

	/**
	 * Returns the number of program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the number of matching program type masters
	 */
	public static int countByProgramTypeNameByLike(String programTypeName) {
		return getPersistence().countByProgramTypeNameByLike(programTypeName);
	}

	/**
	 * Caches the program type master in the entity cache if it is enabled.
	 *
	 * @param programTypeMaster the program type master
	 */
	public static void cacheResult(ProgramTypeMaster programTypeMaster) {
		getPersistence().cacheResult(programTypeMaster);
	}

	/**
	 * Caches the program type masters in the entity cache if it is enabled.
	 *
	 * @param programTypeMasters the program type masters
	 */
	public static void cacheResult(List<ProgramTypeMaster> programTypeMasters) {
		getPersistence().cacheResult(programTypeMasters);
	}

	/**
	 * Creates a new program type master with the primary key. Does not add the program type master to the database.
	 *
	 * @param programTypeMasterId the primary key for the new program type master
	 * @return the new program type master
	 */
	public static ProgramTypeMaster create(long programTypeMasterId) {
		return getPersistence().create(programTypeMasterId);
	}

	/**
	 * Removes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster remove(long programTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().remove(programTypeMasterId);
	}

	public static ProgramTypeMaster updateImpl(
		ProgramTypeMaster programTypeMaster) {

		return getPersistence().updateImpl(programTypeMaster);
	}

	/**
	 * Returns the program type master with the primary key or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster findByPrimaryKey(long programTypeMasterId)
		throws gov.omsb.tms.exception.NoSuchProgramTypeMasterException {

		return getPersistence().findByPrimaryKey(programTypeMasterId);
	}

	/**
	 * Returns the program type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master, or <code>null</code> if a program type master with the primary key could not be found
	 */
	public static ProgramTypeMaster fetchByPrimaryKey(
		long programTypeMasterId) {

		return getPersistence().fetchByPrimaryKey(programTypeMasterId);
	}

	/**
	 * Returns all the program type masters.
	 *
	 * @return the program type masters
	 */
	public static List<ProgramTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of program type masters
	 */
	public static List<ProgramTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program type masters
	 */
	public static List<ProgramTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program type masters
	 */
	public static List<ProgramTypeMaster> findAll(
		int start, int end,
		OrderByComparator<ProgramTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program type masters.
	 *
	 * @return the number of program type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramTypeMasterPersistence _persistence;

}