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

import gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException;
import gov.omsb.tms.model.ProgramDutyAssignment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program duty assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignmentUtil
 * @generated
 */
@ProviderType
public interface ProgramDutyAssignmentPersistence
	extends BasePersistence<ProgramDutyAssignment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramDutyAssignmentUtil} to access the program duty assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid(String uuid);

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByUuid_PrevAndNext(
			long programDutyAssignmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty assignments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty assignment that was removed
	 */
	public ProgramDutyAssignment removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty assignments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByUuid_C_PrevAndNext(
			long programDutyAssignmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty assignments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId);

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByDutyAssignmentId_First(
			long dutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByDutyAssignmentId_First(
		long dutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByDutyAssignmentId_Last(
			long dutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByDutyAssignmentId_Last(
		long dutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByDutyAssignmentId_PrevAndNext(
			long programDutyAssignmentId, long dutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 */
	public void removeByDutyAssignmentId(long dutyAssignmentId);

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the number of matching program duty assignments
	 */
	public int countByDutyAssignmentId(long dutyAssignmentId);

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment>
		findByDutyAssignmentIdAndStatus(long dutyAssignmentId, String status);

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment>
		findByDutyAssignmentIdAndStatus(
			long dutyAssignmentId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment>
		findByDutyAssignmentIdAndStatus(
			long dutyAssignmentId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment>
		findByDutyAssignmentIdAndStatus(
			long dutyAssignmentId, String status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByDutyAssignmentIdAndStatus_First(
			long dutyAssignmentId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_First(
		long dutyAssignmentId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByDutyAssignmentIdAndStatus_Last(
			long dutyAssignmentId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_Last(
		long dutyAssignmentId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByDutyAssignmentIdAndStatus_PrevAndNext(
			long programDutyAssignmentId, long dutyAssignmentId, String status,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 */
	public void removeByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status);

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the number of matching program duty assignments
	 */
	public int countByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status);

	/**
	 * Returns all the program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramId(
		long programId);

	/**
	 * Returns a range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByProgramId_First(
			long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramId_First(
		long programId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByProgramId_Last(
			long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramId_Last(
		long programId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByProgramId_PrevAndNext(
			long programDutyAssignmentId, long programId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	public void removeByProgramId(long programId);

	/**
	 * Returns the number of program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duty assignments
	 */
	public int countByProgramId(long programId);

	/**
	 * Returns all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId);

	/**
	 * Returns a range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment[] findByProgramIdAndCohortId_PrevAndNext(
			long programDutyAssignmentId, long programId, long cohortId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Removes all the program duty assignments where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	public void removeByProgramIdAndCohortId(long programId, long cohortId);

	/**
	 * Returns the number of program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	public int countByProgramIdAndCohortId(long programId, long cohortId);

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment findByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId);

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	public ProgramDutyAssignment fetchByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId,
		boolean useFinderCache);

	/**
	 * Removes the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the program duty assignment that was removed
	 */
	public ProgramDutyAssignment removeByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the number of program duty assignments where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	public int countByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId);

	/**
	 * Caches the program duty assignment in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignment the program duty assignment
	 */
	public void cacheResult(ProgramDutyAssignment programDutyAssignment);

	/**
	 * Caches the program duty assignments in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignments the program duty assignments
	 */
	public void cacheResult(
		java.util.List<ProgramDutyAssignment> programDutyAssignments);

	/**
	 * Creates a new program duty assignment with the primary key. Does not add the program duty assignment to the database.
	 *
	 * @param programDutyAssignmentId the primary key for the new program duty assignment
	 * @return the new program duty assignment
	 */
	public ProgramDutyAssignment create(long programDutyAssignmentId);

	/**
	 * Removes the program duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment that was removed
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment remove(long programDutyAssignmentId)
		throws NoSuchProgramDutyAssignmentException;

	public ProgramDutyAssignment updateImpl(
		ProgramDutyAssignment programDutyAssignment);

	/**
	 * Returns the program duty assignment with the primary key or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment findByPrimaryKey(long programDutyAssignmentId)
		throws NoSuchProgramDutyAssignmentException;

	/**
	 * Returns the program duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment, or <code>null</code> if a program duty assignment with the primary key could not be found
	 */
	public ProgramDutyAssignment fetchByPrimaryKey(
		long programDutyAssignmentId);

	/**
	 * Returns all the program duty assignments.
	 *
	 * @return the program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findAll();

	/**
	 * Returns a range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duty assignments
	 */
	public java.util.List<ProgramDutyAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramDutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program duty assignments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program duty assignments.
	 *
	 * @return the number of program duty assignments
	 */
	public int countAll();

}