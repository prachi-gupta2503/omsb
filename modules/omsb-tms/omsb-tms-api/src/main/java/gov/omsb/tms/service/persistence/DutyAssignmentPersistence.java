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

import gov.omsb.tms.exception.NoSuchDutyAssignmentException;
import gov.omsb.tms.model.DutyAssignment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the duty assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentUtil
 * @generated
 */
@ProviderType
public interface DutyAssignmentPersistence
	extends BasePersistence<DutyAssignment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DutyAssignmentUtil} to access the duty assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid(String uuid);

	/**
	 * Returns a range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment[] findByUuid_PrevAndNext(
			long dutyAssignmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Removes all the duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty assignments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty assignment that was removed
	 */
	public DutyAssignment removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the number of duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty assignments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the first duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the last duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment[] findByUuid_C_PrevAndNext(
			long dutyAssignmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Removes all the duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty assignments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeId(long dutyTypeId);

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeId(
		long dutyTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeId_First(
			long dutyTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeId_First(
		long dutyTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeId_Last(
			long dutyTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeId_Last(
		long dutyTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment[] findByDutyTypeId_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 */
	public void removeByDutyTypeId(long dutyTypeId);

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @return the number of matching duty assignments
	 */
	public int countByDutyTypeId(long dutyTypeId);

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status);

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndStatus(
		long dutyTypeId, String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeIdAndStatus_First(
			long dutyTypeId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeIdAndStatus_First(
		long dutyTypeId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeIdAndStatus_Last(
			long dutyTypeId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeIdAndStatus_Last(
		long dutyTypeId, String status,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment[] findByDutyTypeIdAndStatus_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 */
	public void removeByDutyTypeIdAndStatus(long dutyTypeId, String status);

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and status = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param status the status
	 * @return the number of matching duty assignments
	 */
	public int countByDutyTypeIdAndStatus(long dutyTypeId, String status);

	/**
	 * Returns all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment);

	/**
	 * Returns a range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty assignments
	 */
	public java.util.List<DutyAssignment> findByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeIdAndAssignment_First(
			long dutyTypeId, String assignment,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the first duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeIdAndAssignment_First(
		long dutyTypeId, String assignment,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment
	 * @throws NoSuchDutyAssignmentException if a matching duty assignment could not be found
	 */
	public DutyAssignment findByDutyTypeIdAndAssignment_Last(
			long dutyTypeId, String assignment,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the last duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	public DutyAssignment fetchByDutyTypeIdAndAssignment_Last(
		long dutyTypeId, String assignment,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns the duty assignments before and after the current duty assignment in the ordered set where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyAssignmentId the primary key of the current duty assignment
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment[] findByDutyTypeIdAndAssignment_PrevAndNext(
			long dutyAssignmentId, long dutyTypeId, String assignment,
			com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
				orderByComparator)
		throws NoSuchDutyAssignmentException;

	/**
	 * Removes all the duty assignments where dutyTypeId = &#63; and assignment = &#63; from the database.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 */
	public void removeByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment);

	/**
	 * Returns the number of duty assignments where dutyTypeId = &#63; and assignment = &#63;.
	 *
	 * @param dutyTypeId the duty type ID
	 * @param assignment the assignment
	 * @return the number of matching duty assignments
	 */
	public int countByDutyTypeIdAndAssignment(
		long dutyTypeId, String assignment);

	/**
	 * Caches the duty assignment in the entity cache if it is enabled.
	 *
	 * @param dutyAssignment the duty assignment
	 */
	public void cacheResult(DutyAssignment dutyAssignment);

	/**
	 * Caches the duty assignments in the entity cache if it is enabled.
	 *
	 * @param dutyAssignments the duty assignments
	 */
	public void cacheResult(java.util.List<DutyAssignment> dutyAssignments);

	/**
	 * Creates a new duty assignment with the primary key. Does not add the duty assignment to the database.
	 *
	 * @param dutyAssignmentId the primary key for the new duty assignment
	 * @return the new duty assignment
	 */
	public DutyAssignment create(long dutyAssignmentId);

	/**
	 * Removes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment remove(long dutyAssignmentId)
		throws NoSuchDutyAssignmentException;

	public DutyAssignment updateImpl(DutyAssignment dutyAssignment);

	/**
	 * Returns the duty assignment with the primary key or throws a <code>NoSuchDutyAssignmentException</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws NoSuchDutyAssignmentException if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment findByPrimaryKey(long dutyAssignmentId)
		throws NoSuchDutyAssignmentException;

	/**
	 * Returns the duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment, or <code>null</code> if a duty assignment with the primary key could not be found
	 */
	public DutyAssignment fetchByPrimaryKey(long dutyAssignmentId);

	/**
	 * Returns all the duty assignments.
	 *
	 * @return the duty assignments
	 */
	public java.util.List<DutyAssignment> findAll();

	/**
	 * Returns a range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of duty assignments
	 */
	public java.util.List<DutyAssignment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty assignments
	 */
	public java.util.List<DutyAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty assignments
	 */
	public java.util.List<DutyAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the duty assignments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of duty assignments.
	 *
	 * @return the number of duty assignments
	 */
	public int countAll();

}