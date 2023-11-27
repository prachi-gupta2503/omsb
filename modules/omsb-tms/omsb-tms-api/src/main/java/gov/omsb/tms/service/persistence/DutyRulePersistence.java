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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import gov.omsb.tms.exception.NoSuchDutyRuleException;
import gov.omsb.tms.model.DutyRule;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the duty rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyRuleUtil
 * @generated
 */
@ProviderType
public interface DutyRulePersistence extends BasePersistence<DutyRule> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DutyRuleUtil} to access the duty rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty rules
	 */
	public java.util.List<DutyRule> findByUuid(String uuid);

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
	public java.util.List<DutyRule> findByUuid(String uuid, int start, int end);

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
	public java.util.List<DutyRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

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
	public java.util.List<DutyRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public DutyRule findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public DutyRule findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

	/**
	 * Returns the duty rules before and after the current duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param dutyRuleId the primary key of the current duty rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty rule
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public DutyRule[] findByUuid_PrevAndNext(
			long dutyRuleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Removes all the duty rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty rules
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public DutyRule findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the duty rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty rule that was removed
	 */
	public DutyRule removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the number of duty rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty rules
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty rules
	 */
	public java.util.List<DutyRule> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

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
	public java.util.List<DutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public DutyRule findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the first duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule
	 * @throws NoSuchDutyRuleException if a matching duty rule could not be found
	 */
	public DutyRule findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the last duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty rule, or <code>null</code> if a matching duty rule could not be found
	 */
	public DutyRule fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

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
	public DutyRule[] findByUuid_C_PrevAndNext(
			long dutyRuleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
				orderByComparator)
		throws NoSuchDutyRuleException;

	/**
	 * Removes all the duty rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty rules
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the duty rule in the entity cache if it is enabled.
	 *
	 * @param dutyRule the duty rule
	 */
	public void cacheResult(DutyRule dutyRule);

	/**
	 * Caches the duty rules in the entity cache if it is enabled.
	 *
	 * @param dutyRules the duty rules
	 */
	public void cacheResult(java.util.List<DutyRule> dutyRules);

	/**
	 * Creates a new duty rule with the primary key. Does not add the duty rule to the database.
	 *
	 * @param dutyRuleId the primary key for the new duty rule
	 * @return the new duty rule
	 */
	public DutyRule create(long dutyRuleId);

	/**
	 * Removes the duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule that was removed
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public DutyRule remove(long dutyRuleId) throws NoSuchDutyRuleException;

	public DutyRule updateImpl(DutyRule dutyRule);

	/**
	 * Returns the duty rule with the primary key or throws a <code>NoSuchDutyRuleException</code> if it could not be found.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule
	 * @throws NoSuchDutyRuleException if a duty rule with the primary key could not be found
	 */
	public DutyRule findByPrimaryKey(long dutyRuleId)
		throws NoSuchDutyRuleException;

	/**
	 * Returns the duty rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyRuleId the primary key of the duty rule
	 * @return the duty rule, or <code>null</code> if a duty rule with the primary key could not be found
	 */
	public DutyRule fetchByPrimaryKey(long dutyRuleId);

	/**
	 * Returns all the duty rules.
	 *
	 * @return the duty rules
	 */
	public java.util.List<DutyRule> findAll();

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
	public java.util.List<DutyRule> findAll(int start, int end);

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
	public java.util.List<DutyRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator);

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
	public java.util.List<DutyRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the duty rules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of duty rules.
	 *
	 * @return the number of duty rules
	 */
	public int countAll();

}