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

import gov.omsb.tms.exception.NoSuchProgramDutyRuleException;
import gov.omsb.tms.model.ProgramDutyRule;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program duty rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyRuleUtil
 * @generated
 */
@ProviderType
public interface ProgramDutyRulePersistence
	extends BasePersistence<ProgramDutyRule> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramDutyRuleUtil} to access the program duty rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty rules
	 */
	public java.util.List<ProgramDutyRule> findByUuid(String uuid);

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
	public java.util.List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public java.util.List<ProgramDutyRule> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

	/**
	 * Returns the program duty rules before and after the current program duty rule in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyRuleId the primary key of the current program duty rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public ProgramDutyRule[] findByUuid_PrevAndNext(
			long programDutyRuleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Removes all the program duty rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program duty rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty rules
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program duty rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program duty rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty rule that was removed
	 */
	public ProgramDutyRule removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the number of program duty rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty rules
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty rules
	 */
	public java.util.List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public java.util.List<ProgramDutyRule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the first program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the last program duty rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public ProgramDutyRule[] findByUuid_C_PrevAndNext(
			long programDutyRuleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Removes all the program duty rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program duty rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty rules
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty rules
	 */
	public java.util.List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId);

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
	public java.util.List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end);

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
	public java.util.List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public java.util.List<ProgramDutyRule> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the first program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule
	 * @throws NoSuchProgramDutyRuleException if a matching program duty rule could not be found
	 */
	public ProgramDutyRule findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the last program duty rule in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty rule, or <code>null</code> if a matching program duty rule could not be found
	 */
	public ProgramDutyRule fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public ProgramDutyRule[] findByProgramIdAndCohortId_PrevAndNext(
			long programDutyRuleId, long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
				orderByComparator)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Removes all the program duty rules where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	public void removeByProgramIdAndCohortId(long programId, long cohortId);

	/**
	 * Returns the number of program duty rules where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty rules
	 */
	public int countByProgramIdAndCohortId(long programId, long cohortId);

	/**
	 * Caches the program duty rule in the entity cache if it is enabled.
	 *
	 * @param programDutyRule the program duty rule
	 */
	public void cacheResult(ProgramDutyRule programDutyRule);

	/**
	 * Caches the program duty rules in the entity cache if it is enabled.
	 *
	 * @param programDutyRules the program duty rules
	 */
	public void cacheResult(java.util.List<ProgramDutyRule> programDutyRules);

	/**
	 * Creates a new program duty rule with the primary key. Does not add the program duty rule to the database.
	 *
	 * @param programDutyRuleId the primary key for the new program duty rule
	 * @return the new program duty rule
	 */
	public ProgramDutyRule create(long programDutyRuleId);

	/**
	 * Removes the program duty rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule that was removed
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public ProgramDutyRule remove(long programDutyRuleId)
		throws NoSuchProgramDutyRuleException;

	public ProgramDutyRule updateImpl(ProgramDutyRule programDutyRule);

	/**
	 * Returns the program duty rule with the primary key or throws a <code>NoSuchProgramDutyRuleException</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule
	 * @throws NoSuchProgramDutyRuleException if a program duty rule with the primary key could not be found
	 */
	public ProgramDutyRule findByPrimaryKey(long programDutyRuleId)
		throws NoSuchProgramDutyRuleException;

	/**
	 * Returns the program duty rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyRuleId the primary key of the program duty rule
	 * @return the program duty rule, or <code>null</code> if a program duty rule with the primary key could not be found
	 */
	public ProgramDutyRule fetchByPrimaryKey(long programDutyRuleId);

	/**
	 * Returns all the program duty rules.
	 *
	 * @return the program duty rules
	 */
	public java.util.List<ProgramDutyRule> findAll();

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
	public java.util.List<ProgramDutyRule> findAll(int start, int end);

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
	public java.util.List<ProgramDutyRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator);

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
	public java.util.List<ProgramDutyRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program duty rules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program duty rules.
	 *
	 * @return the number of program duty rules
	 */
	public int countAll();

}