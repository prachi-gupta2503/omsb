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

import gov.omsb.tms.model.ProgramProgramTypeRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program program type rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramProgramTypeRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRelPersistence
 * @generated
 */
public class ProgramProgramTypeRelUtil {

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
	public static void clearCache(ProgramProgramTypeRel programProgramTypeRel) {
		getPersistence().clearCache(programProgramTypeRel);
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
	public static Map<Serializable, ProgramProgramTypeRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramProgramTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramProgramTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramProgramTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramProgramTypeRel update(
		ProgramProgramTypeRel programProgramTypeRel) {

		return getPersistence().update(programProgramTypeRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramProgramTypeRel update(
		ProgramProgramTypeRel programProgramTypeRel,
		ServiceContext serviceContext) {

		return getPersistence().update(programProgramTypeRel, serviceContext);
	}

	/**
	 * Returns all the program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel[] findByUuid_PrevAndNext(
			long programPtId, String uuid,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_PrevAndNext(
			programPtId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program program type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program program type rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program program type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program program type rel that was removed
	 */
	public static ProgramProgramTypeRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program program type rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel[] findByUuid_C_PrevAndNext(
			long programPtId, String uuid, long companyId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programPtId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program program type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program program type rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByProgramProgramType(
			long programId, long programTypeId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByProgramProgramType(
			programId, programTypeId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId) {

		return getPersistence().fetchByProgramProgramType(
			programId, programTypeId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId, boolean useFinderCache) {

		return getPersistence().fetchByProgramProgramType(
			programId, programTypeId, useFinderCache);
	}

	/**
	 * Removes the program program type rel where programId = &#63; and programTypeId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the program program type rel that was removed
	 */
	public static ProgramProgramTypeRel removeByProgramProgramType(
			long programId, long programTypeId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().removeByProgramProgramType(
			programId, programTypeId);
	}

	/**
	 * Returns the number of program program type rels where programId = &#63; and programTypeId = &#63;.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	public static int countByProgramProgramType(
		long programId, long programTypeId) {

		return getPersistence().countByProgramProgramType(
			programId, programTypeId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByProgramId(long programId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByProgramId(programId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByProgramId(long programId) {
		return getPersistence().fetchByProgramId(programId);
	}

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByProgramId(
		long programId, boolean useFinderCache) {

		return getPersistence().fetchByProgramId(programId, useFinderCache);
	}

	/**
	 * Removes the program program type rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program program type rel that was removed
	 */
	public static ProgramProgramTypeRel removeByProgramId(long programId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().removeByProgramId(programId);
	}

	/**
	 * Returns the number of program program type rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program program type rels
	 */
	public static int countByProgramId(long programId) {
		return getPersistence().countByProgramId(programId);
	}

	/**
	 * Returns all the program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId) {

		return getPersistence().findByprogramTypeId(programTypeId);
	}

	/**
	 * Returns a range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end) {

		return getPersistence().findByprogramTypeId(programTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().findByprogramTypeId(
			programTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program program type rels where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program program type rels
	 */
	public static List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByprogramTypeId(
			programTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByprogramTypeId_First(
			long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByprogramTypeId_First(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByprogramTypeId_First(
		long programTypeId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByprogramTypeId_First(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel findByprogramTypeId_Last(
			long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByprogramTypeId_Last(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public static ProgramProgramTypeRel fetchByprogramTypeId_Last(
		long programTypeId,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().fetchByprogramTypeId_Last(
			programTypeId, orderByComparator);
	}

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel[] findByprogramTypeId_PrevAndNext(
			long programPtId, long programTypeId,
			OrderByComparator<ProgramProgramTypeRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByprogramTypeId_PrevAndNext(
			programPtId, programTypeId, orderByComparator);
	}

	/**
	 * Removes all the program program type rels where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	public static void removeByprogramTypeId(long programTypeId) {
		getPersistence().removeByprogramTypeId(programTypeId);
	}

	/**
	 * Returns the number of program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	public static int countByprogramTypeId(long programTypeId) {
		return getPersistence().countByprogramTypeId(programTypeId);
	}

	/**
	 * Caches the program program type rel in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRel the program program type rel
	 */
	public static void cacheResult(
		ProgramProgramTypeRel programProgramTypeRel) {

		getPersistence().cacheResult(programProgramTypeRel);
	}

	/**
	 * Caches the program program type rels in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRels the program program type rels
	 */
	public static void cacheResult(
		List<ProgramProgramTypeRel> programProgramTypeRels) {

		getPersistence().cacheResult(programProgramTypeRels);
	}

	/**
	 * Creates a new program program type rel with the primary key. Does not add the program program type rel to the database.
	 *
	 * @param programPtId the primary key for the new program program type rel
	 * @return the new program program type rel
	 */
	public static ProgramProgramTypeRel create(long programPtId) {
		return getPersistence().create(programPtId);
	}

	/**
	 * Removes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel remove(long programPtId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().remove(programPtId);
	}

	public static ProgramProgramTypeRel updateImpl(
		ProgramProgramTypeRel programProgramTypeRel) {

		return getPersistence().updateImpl(programProgramTypeRel);
	}

	/**
	 * Returns the program program type rel with the primary key or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel findByPrimaryKey(long programPtId)
		throws gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException {

		return getPersistence().findByPrimaryKey(programPtId);
	}

	/**
	 * Returns the program program type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel, or <code>null</code> if a program program type rel with the primary key could not be found
	 */
	public static ProgramProgramTypeRel fetchByPrimaryKey(long programPtId) {
		return getPersistence().fetchByPrimaryKey(programPtId);
	}

	/**
	 * Returns all the program program type rels.
	 *
	 * @return the program program type rels
	 */
	public static List<ProgramProgramTypeRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of program program type rels
	 */
	public static List<ProgramProgramTypeRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program program type rels
	 */
	public static List<ProgramProgramTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program program type rels
	 */
	public static List<ProgramProgramTypeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramProgramTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program program type rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program program type rels.
	 *
	 * @return the number of program program type rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramProgramTypeRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramProgramTypeRelPersistence _persistence;

}