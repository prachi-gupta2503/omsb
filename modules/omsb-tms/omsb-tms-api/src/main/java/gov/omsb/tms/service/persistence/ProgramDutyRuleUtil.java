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

import gov.omsb.tms.model.ProgramDutyRule;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the program duty rule service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.ProgramDutyRulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyRulePersistence
 * @generated
 */
public class ProgramDutyRuleUtil {

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
	public static void clearCache(ProgramDutyRule programDutyRule) {
		getPersistence().clearCache(programDutyRule);
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
	public static Map<Serializable, ProgramDutyRule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProgramDutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProgramDutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProgramDutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProgramDutyRule update(ProgramDutyRule programDutyRule) {
		return getPersistence().update(programDutyRule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProgramDutyRule update(
		ProgramDutyRule programDutyRule, ServiceContext serviceContext) {

		return getPersistence().update(programDutyRule, serviceContext);
	}

	/**
	 * Returns all the program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByUuid_First(
			String uuid, OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUuid_First(
		String uuid, OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByUuid_Last(
			String uuid, OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUuid_Last(
		String uuid, OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule[] findByUuid_PrevAndNext(
			long programDutyRuleId, String uuid,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_PrevAndNext(
			programDutyRuleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the program duty rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty rules
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the program duty rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty rule that was removed
	 */
	public static ProgramDutyRule removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty rules
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule[] findByUuid_C_PrevAndNext(
			long programDutyRuleId, String uuid, long companyId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			programDutyRuleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the program duty rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty rules
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty rules
	 */
	public static List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId) {

		return getPersistence().findByProgramIdAndCohortId(programId, cohortId);
	}

	/**
	 * Returns a range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end);
	}

	/**
	 * Returns an ordered range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty rules
	 */
	public static List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByProgramIdAndCohortId_First(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByProgramIdAndCohortId_First(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByProgramIdAndCohortId_Last(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public static ProgramDutyRule fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().fetchByProgramIdAndCohortId_Last(
			programId, cohortId, orderByComparator);
	}

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule[] findByProgramIdAndCohortId_PrevAndNext(
			long programDutyRuleId, long programId, long cohortId,
			OrderByComparator<ProgramDutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByProgramIdAndCohortId_PrevAndNext(
			programDutyRuleId, programId, cohortId, orderByComparator);
	}

	/**
	 * Removes all the program duty rules where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	public static void removeByProgramIdAndCohortId(
		long programId, long cohortId) {

		getPersistence().removeByProgramIdAndCohortId(programId, cohortId);
	}

	/**
	 * Returns the number of program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty rules
	 */
	public static int countByProgramIdAndCohortId(
		long programId, long cohortId) {

		return getPersistence().countByProgramIdAndCohortId(
			programId, cohortId);
	}

	/**
	 * Caches the program duty rule in the entity cache if it is enabled.
	 *
	 * @param programDutyRule the program duty rule
	 */
	public static void cacheResult(ProgramDutyRule programDutyRule) {
		getPersistence().cacheResult(programDutyRule);
	}

	/**
	 * Caches the program duty rules in the entity cache if it is enabled.
	 *
	 * @param programDutyRules the program duty rules
	 */
	public static void cacheResult(List<ProgramDutyRule> programDutyRules) {
		getPersistence().cacheResult(programDutyRules);
	}

	/**
	 * Creates a new program duty rule with the primary key. Does not add the program duty rule to the database.
	 *
	 * @param programDutyRuleId the primary key for the new program duty rule
	 * @return the new program duty rule
	 */
	public static ProgramDutyRule create(long programDutyRuleId) {
		return getPersistence().create(programDutyRuleId);
	}

	/**
	 * Removes the program duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule that was removed
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule remove(long programDutyRuleId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().remove(programDutyRuleId);
	}

	public static ProgramDutyRule updateImpl(ProgramDutyRule programDutyRule) {
		return getPersistence().updateImpl(programDutyRule);
	}

	/**
	 * Returns the program duty rule with the primary key or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule findByPrimaryKey(long programDutyRuleId)
		throws gov.omsb.tms.exception.NoSuchProgramDutyRuleException {

		return getPersistence().findByPrimaryKey(programDutyRuleId);
	}

	/**
	 * Returns the program duty rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule, or <code>null</code> if a program duty rule with the primary key could not be found
	 */
	public static ProgramDutyRule fetchByPrimaryKey(long programDutyRuleId) {
		return getPersistence().fetchByPrimaryKey(programDutyRuleId);
	}

	/**
	 * Returns all the program duty rules.
	 *
	 * @return the program duty rules
	 */
	public static List<ProgramDutyRule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @return the range of program duty rules
	 */
	public static List<ProgramDutyRule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duty rules
	 */
	public static List<ProgramDutyRule> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the program duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty rules
	 * @param end the upper bound of the range of program duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duty rules
	 */
	public static List<ProgramDutyRule> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyRule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the program duty rules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of program duty rules.
	 *
	 * @return the number of program duty rules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProgramDutyRulePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProgramDutyRulePersistence _persistence;

}