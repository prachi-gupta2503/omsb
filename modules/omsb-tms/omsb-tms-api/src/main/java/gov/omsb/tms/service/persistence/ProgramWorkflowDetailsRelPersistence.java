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

import gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program workflow details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRelUtil
 * @generated
 */
@ProviderType
public interface ProgramWorkflowDetailsRelPersistence
	extends BasePersistence<ProgramWorkflowDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramWorkflowDetailsRelUtil} to access the program workflow details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program workflow details rels
	 */
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid(String uuid);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

	/**
	 * Returns the program workflow details rels before and after the current program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the current program workflow details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public ProgramWorkflowDetailsRel[] findByUuid_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Removes all the program workflow details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program workflow details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program workflow details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program workflow details rel that was removed
	 */
	public ProgramWorkflowDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program workflow details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program workflow details rels
	 */
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

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
	public java.util.List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

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
	public ProgramWorkflowDetailsRel[] findByUuid_C_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Removes all the program workflow details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program workflow details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the program workflow details rel where programId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel findByProgramWorkflowByProgramId(
			long programId)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId);

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId, boolean useFinderCache);

	/**
	 * Removes the program workflow details rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program workflow details rel that was removed
	 */
	public ProgramWorkflowDetailsRel removeByProgramWorkflowByProgramId(
			long programId)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the number of program workflow details rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program workflow details rels
	 */
	public int countByProgramWorkflowByProgramId(long programId);

	/**
	 * Caches the program workflow details rel in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 */
	public void cacheResult(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel);

	/**
	 * Caches the program workflow details rels in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRels the program workflow details rels
	 */
	public void cacheResult(
		java.util.List<ProgramWorkflowDetailsRel> programWorkflowDetailsRels);

	/**
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	public ProgramWorkflowDetailsRel create(long programWorkflowDetailsRelId);

	/**
	 * Removes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public ProgramWorkflowDetailsRel remove(long programWorkflowDetailsRelId)
		throws NoSuchProgramWorkflowDetailsRelException;

	public ProgramWorkflowDetailsRel updateImpl(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel);

	/**
	 * Returns the program workflow details rel with the primary key or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	public ProgramWorkflowDetailsRel findByPrimaryKey(
			long programWorkflowDetailsRelId)
		throws NoSuchProgramWorkflowDetailsRelException;

	/**
	 * Returns the program workflow details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel, or <code>null</code> if a program workflow details rel with the primary key could not be found
	 */
	public ProgramWorkflowDetailsRel fetchByPrimaryKey(
		long programWorkflowDetailsRelId);

	/**
	 * Returns all the program workflow details rels.
	 *
	 * @return the program workflow details rels
	 */
	public java.util.List<ProgramWorkflowDetailsRel> findAll();

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
	public java.util.List<ProgramWorkflowDetailsRel> findAll(
		int start, int end);

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
	public java.util.List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator);

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
	public java.util.List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProgramWorkflowDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program workflow details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
	 */
	public int countAll();

}