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

import gov.omsb.tms.exception.NoSuchProgramDurationDetailsException;
import gov.omsb.tms.model.ProgramDurationDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program duration details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetailsUtil
 * @generated
 */
@ProviderType
public interface ProgramDurationDetailsPersistence
	extends BasePersistence<ProgramDurationDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramDurationDetailsUtil} to access the program duration details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails[] findByUuid_PrevAndNext(
			long progDurationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Removes all the program duration detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duration detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program duration details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duration details that was removed
	 */
	public ProgramDurationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duration detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails[] findByUuid_C_PrevAndNext(
			long progDurationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Removes all the program duration detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duration detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByProgramId(
		long programId);

	/**
	 * Returns a range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end);

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByProgramId_First(
			long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByProgramId_First(
		long programId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByProgramId_Last(
			long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByProgramId_Last(
		long programId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where programId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails[] findByProgramId_PrevAndNext(
			long progDurationId, long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Removes all the program duration detailses where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	public void removeByProgramId(long programId);

	/**
	 * Returns the number of program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duration detailses
	 */
	public int countByProgramId(long programId);

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	public ProgramDurationDetails findByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm);

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	public ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm, boolean useFinderCache);

	/**
	 * Removes the program duration details where programId = &#63; and ayApplicableForm = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the program duration details that was removed
	 */
	public ProgramDurationDetails removeByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the number of program duration detailses where programId = &#63; and ayApplicableForm = &#63;.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the number of matching program duration detailses
	 */
	public int countByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm);

	/**
	 * Caches the program duration details in the entity cache if it is enabled.
	 *
	 * @param programDurationDetails the program duration details
	 */
	public void cacheResult(ProgramDurationDetails programDurationDetails);

	/**
	 * Caches the program duration detailses in the entity cache if it is enabled.
	 *
	 * @param programDurationDetailses the program duration detailses
	 */
	public void cacheResult(
		java.util.List<ProgramDurationDetails> programDurationDetailses);

	/**
	 * Creates a new program duration details with the primary key. Does not add the program duration details to the database.
	 *
	 * @param progDurationId the primary key for the new program duration details
	 * @return the new program duration details
	 */
	public ProgramDurationDetails create(long progDurationId);

	/**
	 * Removes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails remove(long progDurationId)
		throws NoSuchProgramDurationDetailsException;

	public ProgramDurationDetails updateImpl(
		ProgramDurationDetails programDurationDetails);

	/**
	 * Returns the program duration details with the primary key or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails findByPrimaryKey(long progDurationId)
		throws NoSuchProgramDurationDetailsException;

	/**
	 * Returns the program duration details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details, or <code>null</code> if a program duration details with the primary key could not be found
	 */
	public ProgramDurationDetails fetchByPrimaryKey(long progDurationId);

	/**
	 * Returns all the program duration detailses.
	 *
	 * @return the program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findAll();

	/**
	 * Returns a range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duration detailses
	 */
	public java.util.List<ProgramDurationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDurationDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program duration detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program duration detailses.
	 *
	 * @return the number of program duration detailses
	 */
	public int countAll();

}