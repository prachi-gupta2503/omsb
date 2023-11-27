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

import gov.omsb.tms.exception.NoSuchFacultyRequestStateException;
import gov.omsb.tms.model.FacultyRequestState;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty request state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStateUtil
 * @generated
 */
@ProviderType
public interface FacultyRequestStatePersistence
	extends BasePersistence<FacultyRequestState> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyRequestStateUtil} to access the faculty request state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState[] findByUuid_PrevAndNext(
			long facultyRequestStateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Removes all the faculty request states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty request states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request states
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty request state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty request state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request state that was removed
	 */
	public FacultyRequestState removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the number of faculty request states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request states
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the first faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the last faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState[] findByUuid_C_PrevAndNext(
			long facultyRequestStateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Removes all the faculty request states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty request states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request states
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId);

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState> findByfacultyRequestId(
		long facultyRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByfacultyRequestId_First(
			long facultyRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByfacultyRequestId_First(
		long facultyRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByfacultyRequestId_Last(
			long facultyRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByfacultyRequestId_Last(
		long facultyRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState[] findByfacultyRequestId_PrevAndNext(
			long facultyRequestStateId, long facultyRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 */
	public void removeByfacultyRequestId(long facultyRequestId);

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @return the number of matching faculty request states
	 */
	public int countByfacultyRequestId(long facultyRequestId);

	/**
	 * Returns all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the matching faculty request states
	 */
	public java.util.List<FacultyRequestState>
		findByfacultyRequestIdAndCreatedBy(
			long facultyRequestId, long createdBy);

	/**
	 * Returns a range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState>
		findByfacultyRequestIdAndCreatedBy(
			long facultyRequestId, long createdBy, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState>
		findByfacultyRequestIdAndCreatedBy(
			long facultyRequestId, long createdBy, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request states
	 */
	public java.util.List<FacultyRequestState>
		findByfacultyRequestIdAndCreatedBy(
			long facultyRequestId, long createdBy, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByfacultyRequestIdAndCreatedBy_First(
			long facultyRequestId, long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the first faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_First(
		long facultyRequestId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state
	 * @throws NoSuchFacultyRequestStateException if a matching faculty request state could not be found
	 */
	public FacultyRequestState findByfacultyRequestIdAndCreatedBy_Last(
			long facultyRequestId, long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the last faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request state, or <code>null</code> if a matching faculty request state could not be found
	 */
	public FacultyRequestState fetchByfacultyRequestIdAndCreatedBy_Last(
		long facultyRequestId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns the faculty request states before and after the current faculty request state in the ordered set where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestStateId the primary key of the current faculty request state
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState[] findByfacultyRequestIdAndCreatedBy_PrevAndNext(
			long facultyRequestStateId, long facultyRequestId, long createdBy,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestState> orderByComparator)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Removes all the faculty request states where facultyRequestId = &#63; and createdBy = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 */
	public void removeByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy);

	/**
	 * Returns the number of faculty request states where facultyRequestId = &#63; and createdBy = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param createdBy the created by
	 * @return the number of matching faculty request states
	 */
	public int countByfacultyRequestIdAndCreatedBy(
		long facultyRequestId, long createdBy);

	/**
	 * Caches the faculty request state in the entity cache if it is enabled.
	 *
	 * @param facultyRequestState the faculty request state
	 */
	public void cacheResult(FacultyRequestState facultyRequestState);

	/**
	 * Caches the faculty request states in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStates the faculty request states
	 */
	public void cacheResult(
		java.util.List<FacultyRequestState> facultyRequestStates);

	/**
	 * Creates a new faculty request state with the primary key. Does not add the faculty request state to the database.
	 *
	 * @param facultyRequestStateId the primary key for the new faculty request state
	 * @return the new faculty request state
	 */
	public FacultyRequestState create(long facultyRequestStateId);

	/**
	 * Removes the faculty request state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state that was removed
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState remove(long facultyRequestStateId)
		throws NoSuchFacultyRequestStateException;

	public FacultyRequestState updateImpl(
		FacultyRequestState facultyRequestState);

	/**
	 * Returns the faculty request state with the primary key or throws a <code>NoSuchFacultyRequestStateException</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state
	 * @throws NoSuchFacultyRequestStateException if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState findByPrimaryKey(long facultyRequestStateId)
		throws NoSuchFacultyRequestStateException;

	/**
	 * Returns the faculty request state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStateId the primary key of the faculty request state
	 * @return the faculty request state, or <code>null</code> if a faculty request state with the primary key could not be found
	 */
	public FacultyRequestState fetchByPrimaryKey(long facultyRequestStateId);

	/**
	 * Returns all the faculty request states.
	 *
	 * @return the faculty request states
	 */
	public java.util.List<FacultyRequestState> findAll();

	/**
	 * Returns a range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @return the range of faculty request states
	 */
	public java.util.List<FacultyRequestState> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request states
	 */
	public java.util.List<FacultyRequestState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request states
	 * @param end the upper bound of the range of faculty request states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request states
	 */
	public java.util.List<FacultyRequestState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestState>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty request states from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty request states.
	 *
	 * @return the number of faculty request states
	 */
	public int countAll();

}