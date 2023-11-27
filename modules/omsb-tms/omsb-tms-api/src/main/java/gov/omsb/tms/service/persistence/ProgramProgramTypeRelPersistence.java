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

import gov.omsb.tms.exception.NoSuchProgramProgramTypeRelException;
import gov.omsb.tms.model.ProgramProgramTypeRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program program type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRelUtil
 * @generated
 */
@ProviderType
public interface ProgramProgramTypeRelPersistence
	extends BasePersistence<ProgramProgramTypeRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramProgramTypeRelUtil} to access the program program type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program program type rels
	 */
	public java.util.List<ProgramProgramTypeRel> findByUuid(String uuid);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where uuid = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public ProgramProgramTypeRel[] findByUuid_PrevAndNext(
			long programPtId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Removes all the program program type rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program program type rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program program type rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program program type rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program program type rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program program type rel that was removed
	 */
	public ProgramProgramTypeRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the number of program program type rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program program type rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program program type rels
	 */
	public java.util.List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

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
	public java.util.List<ProgramProgramTypeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the first program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the last program program type rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

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
	public ProgramProgramTypeRel[] findByUuid_C_PrevAndNext(
			long programPtId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Removes all the program program type rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program program type rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program program type rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByProgramProgramType(
			long programId, long programTypeId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId);

	/**
	 * Returns the program program type rel where programId = &#63; and programTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByProgramProgramType(
		long programId, long programTypeId, boolean useFinderCache);

	/**
	 * Removes the program program type rel where programId = &#63; and programTypeId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the program program type rel that was removed
	 */
	public ProgramProgramTypeRel removeByProgramProgramType(
			long programId, long programTypeId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the number of program program type rels where programId = &#63; and programTypeId = &#63;.
	 *
	 * @param programId the program ID
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	public int countByProgramProgramType(long programId, long programTypeId);

	/**
	 * Returns the program program type rel where programId = &#63; or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByProgramId(long programId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByProgramId(long programId);

	/**
	 * Returns the program program type rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByProgramId(
		long programId, boolean useFinderCache);

	/**
	 * Removes the program program type rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program program type rel that was removed
	 */
	public ProgramProgramTypeRel removeByProgramId(long programId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the number of program program type rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program program type rels
	 */
	public int countByProgramId(long programId);

	/**
	 * Returns all the program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program program type rels
	 */
	public java.util.List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId);

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
	public java.util.List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end);

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
	public java.util.List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

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
	public java.util.List<ProgramProgramTypeRel> findByprogramTypeId(
		long programTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByprogramTypeId_First(
			long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the first program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByprogramTypeId_First(
		long programTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel findByprogramTypeId_Last(
			long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the last program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	public ProgramProgramTypeRel fetchByprogramTypeId_Last(
		long programTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

	/**
	 * Returns the program program type rels before and after the current program program type rel in the ordered set where programTypeId = &#63;.
	 *
	 * @param programPtId the primary key of the current program program type rel
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public ProgramProgramTypeRel[] findByprogramTypeId_PrevAndNext(
			long programPtId, long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramProgramTypeRel> orderByComparator)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Removes all the program program type rels where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	public void removeByprogramTypeId(long programTypeId);

	/**
	 * Returns the number of program program type rels where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program program type rels
	 */
	public int countByprogramTypeId(long programTypeId);

	/**
	 * Caches the program program type rel in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRel the program program type rel
	 */
	public void cacheResult(ProgramProgramTypeRel programProgramTypeRel);

	/**
	 * Caches the program program type rels in the entity cache if it is enabled.
	 *
	 * @param programProgramTypeRels the program program type rels
	 */
	public void cacheResult(
		java.util.List<ProgramProgramTypeRel> programProgramTypeRels);

	/**
	 * Creates a new program program type rel with the primary key. Does not add the program program type rel to the database.
	 *
	 * @param programPtId the primary key for the new program program type rel
	 * @return the new program program type rel
	 */
	public ProgramProgramTypeRel create(long programPtId);

	/**
	 * Removes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public ProgramProgramTypeRel remove(long programPtId)
		throws NoSuchProgramProgramTypeRelException;

	public ProgramProgramTypeRel updateImpl(
		ProgramProgramTypeRel programProgramTypeRel);

	/**
	 * Returns the program program type rel with the primary key or throws a <code>NoSuchProgramProgramTypeRelException</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws NoSuchProgramProgramTypeRelException if a program program type rel with the primary key could not be found
	 */
	public ProgramProgramTypeRel findByPrimaryKey(long programPtId)
		throws NoSuchProgramProgramTypeRelException;

	/**
	 * Returns the program program type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel, or <code>null</code> if a program program type rel with the primary key could not be found
	 */
	public ProgramProgramTypeRel fetchByPrimaryKey(long programPtId);

	/**
	 * Returns all the program program type rels.
	 *
	 * @return the program program type rels
	 */
	public java.util.List<ProgramProgramTypeRel> findAll();

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
	public java.util.List<ProgramProgramTypeRel> findAll(int start, int end);

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
	public java.util.List<ProgramProgramTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator);

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
	public java.util.List<ProgramProgramTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramProgramTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program program type rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program program type rels.
	 *
	 * @return the number of program program type rels
	 */
	public int countAll();

}