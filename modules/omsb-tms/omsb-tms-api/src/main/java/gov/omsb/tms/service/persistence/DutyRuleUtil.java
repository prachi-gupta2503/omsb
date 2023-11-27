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

import gov.omsb.tms.model.DutyRule;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the duty rule service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.DutyRulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyRulePersistence
 * @generated
 */
public class DutyRuleUtil {

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
	public static void clearCache(DutyRule dutyRule) {
		getPersistence().clearCache(dutyRule);
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
	public static Map<Serializable, DutyRule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DutyRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DutyRule update(DutyRule dutyRule) {
		return getPersistence().update(dutyRule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DutyRule update(
		DutyRule dutyRule, ServiceContext serviceContext) {

		return getPersistence().update(dutyRule, serviceContext);
	}

	/**
	 * Returns all the duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty rules
	 */
	public static List<DutyRule> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @return the range of matching duty rules
	 */
	public static List<DutyRule> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty rules
	 */
	public static List<DutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty rules
	 */
	public static List<DutyRule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DutyRule> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public static DutyRule findByUuid_First(
			String uuid, OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUuid_First(
		String uuid, OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public static DutyRule findByUuid_Last(
			String uuid, OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUuid_Last(
		String uuid, OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the duty rules before and after the current duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param dutyRuleId the primary key of the current duty rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty rule
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public static DutyRule[] findByUuid_PrevAndNext(
			long dutyRuleId, String uuid,
			OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_PrevAndNext(
			dutyRuleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the duty rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty rules
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public static DutyRule findByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the duty rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty rule that was removed
	 */
	public static DutyRule removeByUUID_G(String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of duty rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty rules
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty rules
	 */
	public static List<DutyRule> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @return the range of matching duty rules
	 */
	public static List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty rules
	 */
	public static List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty rules
	 */
	public static List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyRule> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public static DutyRule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public static DutyRule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public static DutyRule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the duty rules before and after the current duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyRuleId the primary key of the current duty rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty rule
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public static DutyRule[] findByUuid_C_PrevAndNext(
			long dutyRuleId, String uuid, long companyId,
			OrderByComparator<DutyRule> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dutyRuleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the duty rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty rules
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the duty rule in the entity cache if it is enabled.
	 *
	 * @param dutyRule the duty rule
	 */
	public static void cacheResult(DutyRule dutyRule) {
		getPersistence().cacheResult(dutyRule);
	}

	/**
	 * Caches the duty rules in the entity cache if it is enabled.
	 *
	 * @param dutyRules the duty rules
	 */
	public static void cacheResult(List<DutyRule> dutyRules) {
		getPersistence().cacheResult(dutyRules);
	}

	/**
	 * Creates a new duty rule with the primary key. Does not add the duty rule to the database.
	 *
	 * @param dutyRuleId the primary key for the new duty rule
	 * @return the new duty rule
	 */
	public static DutyRule create(long dutyRuleId) {
		return getPersistence().create(dutyRuleId);
	}

	/**
	 * Removes the duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule that was removed
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public static DutyRule remove(long dutyRuleId)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().remove(dutyRuleId);
	}

	public static DutyRule updateImpl(DutyRule dutyRule) {
		return getPersistence().updateImpl(dutyRule);
	}

	/**
	 * Returns the duty rule with the primary key or throws a <code>NoSuchDutyRuleException</code> if it could not be found.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public static DutyRule findByPrimaryKey(long dutyRuleId)
		throws gov.omsb.tms.exception.NoSuchDutyRuleException {

		return getPersistence().findByPrimaryKey(dutyRuleId);
	}

	/**
	 * Returns the duty rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule, or <code>null</code> if a duty rule with the primary key could not be found
	 */
	public static DutyRule fetchByPrimaryKey(long dutyRuleId) {
		return getPersistence().fetchByPrimaryKey(dutyRuleId);
	}

	/**
	 * Returns all the duty rules.
	 *
	 * @return the duty rules
	 */
	public static List<DutyRule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @return the range of duty rules
	 */
	public static List<DutyRule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty rules
	 */
	public static List<DutyRule> findAll(
		int start, int end, OrderByComparator<DutyRule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the duty rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty rules
	 * @param end the upper bound of the range of duty rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty rules
	 */
	public static List<DutyRule> findAll(
		int start, int end, OrderByComparator<DutyRule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the duty rules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of duty rules.
	 *
	 * @return the number of duty rules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DutyRulePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DutyRulePersistence _persistence;

}