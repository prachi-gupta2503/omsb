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

import gov.omsb.tms.model.ProgramWorkflowDetailsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program workflow details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramWorkflowDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRelPersistence
 * @generated
 */
public class ProgramWorkflowDetailsRelUtil {

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
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		getPersistence().clearCache(programWorkflowDetailsRel);
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
	public static Map<Serializable, ProgramWorkflowDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramWorkflowDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramWorkflowDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramWorkflowDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramWorkflowDetailsRel update(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return getPersistence().update(programWorkflowDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramWorkflowDetailsRel update(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			programWorkflowDetailsRel, serviceContext);
	}

	/**
	 * Returns all the program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program workflow details rels before and after the current program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the current program workflow details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel[] findByUuid_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			programWorkflowDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program workflow details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program workflow details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program workflow details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program workflow details rel that was removed
	 */
	public static ProgramWorkflowDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program workflow details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program workflow details rels before and after the current program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the current program workflow details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel[] findByUuid_C_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programWorkflowDetailsRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program workflow details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program workflow details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the program workflow details rel where programId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel findByProgramWorkflowByProgramId(
			long programId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByProgramWorkflowByProgramId(programId);
	}

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId) {

		return getPersistence().fetchByProgramWorkflowByProgramId(programId);
	}

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId, boolean useFinderCache) {

		return getPersistence().fetchByProgramWorkflowByProgramId(
			programId, useFinderCache);
	}

	/**
	 * Removes the program workflow details rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program workflow details rel that was removed
	 */
	public static ProgramWorkflowDetailsRel removeByProgramWorkflowByProgramId(
			long programId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().removeByProgramWorkflowByProgramId(programId);
	}

	/**
	 * Returns the number of program workflow details rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program workflow details rels
	 */
	public static int countByProgramWorkflowByProgramId(long programId) {
		return getPersistence().countByProgramWorkflowByProgramId(programId);
	}

	/**
	 * Caches the program workflow details rel in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 */
	public static void cacheResult(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		getPersistence().cacheResult(programWorkflowDetailsRel);
	}

	/**
	 * Caches the program workflow details rels in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRels the program workflow details rels
	 */
	public static void cacheResult(
		List<ProgramWorkflowDetailsRel> programWorkflowDetailsRels) {

		getPersistence().cacheResult(programWorkflowDetailsRels);
	}

	/**
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	public static ProgramWorkflowDetailsRel create(
		long programWorkflowDetailsRelId) {

		return getPersistence().create(programWorkflowDetailsRelId);
	}

	/**
	 * Removes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel remove(
			long programWorkflowDetailsRelId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().remove(programWorkflowDetailsRelId);
	}

	public static ProgramWorkflowDetailsRel updateImpl(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		return getPersistence().updateImpl(programWorkflowDetailsRel);
	}

	/**
	 * Returns the program workflow details rel with the primary key or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel findByPrimaryKey(
			long programWorkflowDetailsRelId)
		throws gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException {

		return getPersistence().findByPrimaryKey(programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel, or <code>null</code> if a program workflow details rel with the primary key could not be found
	 */
	public static ProgramWorkflowDetailsRel fetchByPrimaryKey(
		long programWorkflowDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(programWorkflowDetailsRelId);
	}

	/**
	 * Returns all the program workflow details rels.
	 *
	 * @return the program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program workflow details rels
	 */
	public static List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program workflow details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramWorkflowDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramWorkflowDetailsRelPersistence _persistence;

}