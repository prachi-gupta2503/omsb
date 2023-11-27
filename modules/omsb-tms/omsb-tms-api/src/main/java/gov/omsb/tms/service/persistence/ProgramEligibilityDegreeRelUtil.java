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

import gov.omsb.tms.model.ProgramEligibilityDegreeRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program eligibility degree rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramEligibilityDegreeRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramEligibilityDegreeRelPersistence
 * @generated
 */
public class ProgramEligibilityDegreeRelUtil {

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
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		getPersistence().clearCache(programEligibilityDegreeRel);
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
	public static Map<Serializable, ProgramEligibilityDegreeRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramEligibilityDegreeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramEligibilityDegreeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramEligibilityDegreeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramEligibilityDegreeRel update(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		return getPersistence().update(programEligibilityDegreeRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramEligibilityDegreeRel update(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			programEligibilityDegreeRel, serviceContext);
	}

	/**
	 * Returns all the program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program eligibility degree rels before and after the current program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param programEdId the primary key of the current program eligibility degree rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public static ProgramEligibilityDegreeRel[] findByUuid_PrevAndNext(
			long programEdId, String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_PrevAndNext(
			programEdId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program eligibility degree rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program eligibility degree rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program eligibility degree rel that was removed
	 */
	public static ProgramEligibilityDegreeRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program eligibility degree rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program eligibility degree rels before and after the current program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programEdId the primary key of the current program eligibility degree rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public static ProgramEligibilityDegreeRel[] findByUuid_C_PrevAndNext(
			long programEdId, String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programEdId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program eligibility degree rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByProgramEligibilityDegreeId(
			long programId, long eligibilityDegreeMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId) {

		return getPersistence().fetchByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId,
		boolean useFinderCache) {

		return getPersistence().fetchByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId, useFinderCache);
	}

	/**
	 * Removes the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the program eligibility degree rel that was removed
	 */
	public static ProgramEligibilityDegreeRel
			removeByProgramEligibilityDegreeId(
				long programId, long eligibilityDegreeMasterId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().removeByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId);
	}

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63; and eligibilityDegreeMasterId = &#63;.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the number of matching program eligibility degree rels
	 */
	public static int countByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId) {

		return getPersistence().countByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel findByProgramId(long programId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByProgramId(programId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByProgramId(long programId) {
		return getPersistence().fetchByProgramId(programId);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByProgramId(
		long programId, boolean useFinderCache) {

		return getPersistence().fetchByProgramId(programId, useFinderCache);
	}

	/**
	 * Removes the program eligibility degree rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program eligibility degree rel that was removed
	 */
	public static ProgramEligibilityDegreeRel removeByProgramId(long programId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().removeByProgramId(programId);
	}

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program eligibility degree rels
	 */
	public static int countByProgramId(long programId) {
		return getPersistence().countByProgramId(programId);
	}

	/**
	 * Caches the program eligibility degree rel in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 */
	public static void cacheResult(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		getPersistence().cacheResult(programEligibilityDegreeRel);
	}

	/**
	 * Caches the program eligibility degree rels in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRels the program eligibility degree rels
	 */
	public static void cacheResult(
		List<ProgramEligibilityDegreeRel> programEligibilityDegreeRels) {

		getPersistence().cacheResult(programEligibilityDegreeRels);
	}

	/**
	 * Creates a new program eligibility degree rel with the primary key. Does not add the program eligibility degree rel to the database.
	 *
	 * @param programEdId the primary key for the new program eligibility degree rel
	 * @return the new program eligibility degree rel
	 */
	public static ProgramEligibilityDegreeRel create(long programEdId) {
		return getPersistence().create(programEdId);
	}

	/**
	 * Removes the program eligibility degree rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public static ProgramEligibilityDegreeRel remove(long programEdId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().remove(programEdId);
	}

	public static ProgramEligibilityDegreeRel updateImpl(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		return getPersistence().updateImpl(programEligibilityDegreeRel);
	}

	/**
	 * Returns the program eligibility degree rel with the primary key or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public static ProgramEligibilityDegreeRel findByPrimaryKey(long programEdId)
		throws gov.omsb.tms.exception.
			NoSuchProgramEligibilityDegreeRelException {

		return getPersistence().findByPrimaryKey(programEdId);
	}

	/**
	 * Returns the program eligibility degree rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel, or <code>null</code> if a program eligibility degree rel with the primary key could not be found
	 */
	public static ProgramEligibilityDegreeRel fetchByPrimaryKey(
		long programEdId) {

		return getPersistence().fetchByPrimaryKey(programEdId);
	}

	/**
	 * Returns all the program eligibility degree rels.
	 *
	 * @return the program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program eligibility degree rels
	 */
	public static List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program eligibility degree rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program eligibility degree rels.
	 *
	 * @return the number of program eligibility degree rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramEligibilityDegreeRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramEligibilityDegreeRelPersistence _persistence;

}