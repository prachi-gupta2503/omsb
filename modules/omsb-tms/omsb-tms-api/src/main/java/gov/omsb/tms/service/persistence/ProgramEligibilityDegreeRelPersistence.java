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

import gov.omsb.tms.exception.NoSuchProgramEligibilityDegreeRelException;
import gov.omsb.tms.model.ProgramEligibilityDegreeRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program eligibility degree rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramEligibilityDegreeRelUtil
 * @generated
 */
@ProviderType
public interface ProgramEligibilityDegreeRelPersistence
	extends BasePersistence<ProgramEligibilityDegreeRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramEligibilityDegreeRelUtil} to access the program eligibility degree rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program eligibility degree rels
	 */
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid(String uuid);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

	/**
	 * Returns the program eligibility degree rels before and after the current program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param programEdId the primary key of the current program eligibility degree rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public ProgramEligibilityDegreeRel[] findByUuid_PrevAndNext(
			long programEdId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program eligibility degree rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program eligibility degree rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program eligibility degree rel that was removed
	 */
	public ProgramEligibilityDegreeRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program eligibility degree rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program eligibility degree rels
	 */
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

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
	public java.util.List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

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
	public ProgramEligibilityDegreeRel[] findByUuid_C_PrevAndNext(
			long programEdId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program eligibility degree rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByProgramEligibilityDegreeId(
			long programId, long eligibilityDegreeMasterId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId);

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId, boolean useFinderCache);

	/**
	 * Removes the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the program eligibility degree rel that was removed
	 */
	public ProgramEligibilityDegreeRel removeByProgramEligibilityDegreeId(
			long programId, long eligibilityDegreeMasterId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63; and eligibilityDegreeMasterId = &#63;.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the number of matching program eligibility degree rels
	 */
	public int countByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId);

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel findByProgramId(long programId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByProgramId(long programId);

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByProgramId(
		long programId, boolean useFinderCache);

	/**
	 * Removes the program eligibility degree rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program eligibility degree rel that was removed
	 */
	public ProgramEligibilityDegreeRel removeByProgramId(long programId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program eligibility degree rels
	 */
	public int countByProgramId(long programId);

	/**
	 * Caches the program eligibility degree rel in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 */
	public void cacheResult(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel);

	/**
	 * Caches the program eligibility degree rels in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRels the program eligibility degree rels
	 */
	public void cacheResult(
		java.util.List<ProgramEligibilityDegreeRel>
			programEligibilityDegreeRels);

	/**
	 * Creates a new program eligibility degree rel with the primary key. Does not add the program eligibility degree rel to the database.
	 *
	 * @param programEdId the primary key for the new program eligibility degree rel
	 * @return the new program eligibility degree rel
	 */
	public ProgramEligibilityDegreeRel create(long programEdId);

	/**
	 * Removes the program eligibility degree rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public ProgramEligibilityDegreeRel remove(long programEdId)
		throws NoSuchProgramEligibilityDegreeRelException;

	public ProgramEligibilityDegreeRel updateImpl(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel);

	/**
	 * Returns the program eligibility degree rel with the primary key or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	public ProgramEligibilityDegreeRel findByPrimaryKey(long programEdId)
		throws NoSuchProgramEligibilityDegreeRelException;

	/**
	 * Returns the program eligibility degree rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel, or <code>null</code> if a program eligibility degree rel with the primary key could not be found
	 */
	public ProgramEligibilityDegreeRel fetchByPrimaryKey(long programEdId);

	/**
	 * Returns all the program eligibility degree rels.
	 *
	 * @return the program eligibility degree rels
	 */
	public java.util.List<ProgramEligibilityDegreeRel> findAll();

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
	public java.util.List<ProgramEligibilityDegreeRel> findAll(
		int start, int end);

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
	public java.util.List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator);

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
	public java.util.List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramEligibilityDegreeRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program eligibility degree rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program eligibility degree rels.
	 *
	 * @return the number of program eligibility degree rels
	 */
	public int countAll();

}