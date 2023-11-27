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

import gov.omsb.tms.exception.NoSuchLeaveAnnualRuleException;
import gov.omsb.tms.model.LeaveAnnualRule;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave annual rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualRuleUtil
 * @generated
 */
@ProviderType
public interface LeaveAnnualRulePersistence
	extends BasePersistence<LeaveAnnualRule> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveAnnualRuleUtil} to access the leave annual rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave annual rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns the leave annual rules before and after the current leave annual rule in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualRuleId the primary key of the current leave annual rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	public LeaveAnnualRule[] findByUuid_PrevAndNext(
			long leaveAnnualRuleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Removes all the leave annual rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave annual rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual rules
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave annual rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave annual rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual rule that was removed
	 */
	public LeaveAnnualRule removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the number of leave annual rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual rules
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the first leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the last leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual rule, or <code>null</code> if a matching leave annual rule could not be found
	 */
	public LeaveAnnualRule fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns the leave annual rules before and after the current leave annual rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualRuleId the primary key of the current leave annual rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	public LeaveAnnualRule[] findByUuid_C_PrevAndNext(
			long leaveAnnualRuleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
				orderByComparator)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Removes all the leave annual rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave annual rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual rules
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the leave annual rule in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualRule the leave annual rule
	 */
	public void cacheResult(LeaveAnnualRule leaveAnnualRule);

	/**
	 * Caches the leave annual rules in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualRules the leave annual rules
	 */
	public void cacheResult(java.util.List<LeaveAnnualRule> leaveAnnualRules);

	/**
	 * Creates a new leave annual rule with the primary key. Does not add the leave annual rule to the database.
	 *
	 * @param leaveAnnualRuleId the primary key for the new leave annual rule
	 * @return the new leave annual rule
	 */
	public LeaveAnnualRule create(long leaveAnnualRuleId);

	/**
	 * Removes the leave annual rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule that was removed
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	public LeaveAnnualRule remove(long leaveAnnualRuleId)
		throws NoSuchLeaveAnnualRuleException;

	public LeaveAnnualRule updateImpl(LeaveAnnualRule leaveAnnualRule);

	/**
	 * Returns the leave annual rule with the primary key or throws a <code>NoSuchLeaveAnnualRuleException</code> if it could not be found.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule
	 * @throws NoSuchLeaveAnnualRuleException if a leave annual rule with the primary key could not be found
	 */
	public LeaveAnnualRule findByPrimaryKey(long leaveAnnualRuleId)
		throws NoSuchLeaveAnnualRuleException;

	/**
	 * Returns the leave annual rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualRuleId the primary key of the leave annual rule
	 * @return the leave annual rule, or <code>null</code> if a leave annual rule with the primary key could not be found
	 */
	public LeaveAnnualRule fetchByPrimaryKey(long leaveAnnualRuleId);

	/**
	 * Returns all the leave annual rules.
	 *
	 * @return the leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findAll();

	/**
	 * Returns a range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @return the range of leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual rules
	 * @param end the upper bound of the range of leave annual rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual rules
	 */
	public java.util.List<LeaveAnnualRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave annual rules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave annual rules.
	 *
	 * @return the number of leave annual rules
	 */
	public int countAll();

}