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

import gov.omsb.tms.exception.NoSuchFacultyRequestStatusException;
import gov.omsb.tms.model.FacultyRequestStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty request status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStatusUtil
 * @generated
 */
@ProviderType
public interface FacultyRequestStatusPersistence
	extends BasePersistence<FacultyRequestStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyRequestStatusUtil} to access the faculty request status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public FacultyRequestStatus[] findByUuid_PrevAndNext(
			long facultyRequestStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Removes all the faculty request statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty request statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty request status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty request status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request status that was removed
	 */
	public FacultyRequestStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request statuses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the first faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the last faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns the faculty request statuses before and after the current faculty request status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestStatusId the primary key of the current faculty request status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public FacultyRequestStatus[] findByUuid_C_PrevAndNext(
			long facultyRequestStatusId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestStatus> orderByComparator)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Removes all the faculty request statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty request statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request statuses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the faculty request status where code = &#63; or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus findByCode(String code)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByCode(String code);

	/**
	 * Returns the faculty request status where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request status, or <code>null</code> if a matching faculty request status could not be found
	 */
	public FacultyRequestStatus fetchByCode(
		String code, boolean useFinderCache);

	/**
	 * Removes the faculty request status where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the faculty request status that was removed
	 */
	public FacultyRequestStatus removeByCode(String code)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the number of faculty request statuses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching faculty request statuses
	 */
	public int countByCode(String code);

	/**
	 * Caches the faculty request status in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatus the faculty request status
	 */
	public void cacheResult(FacultyRequestStatus facultyRequestStatus);

	/**
	 * Caches the faculty request statuses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestStatuses the faculty request statuses
	 */
	public void cacheResult(
		java.util.List<FacultyRequestStatus> facultyRequestStatuses);

	/**
	 * Creates a new faculty request status with the primary key. Does not add the faculty request status to the database.
	 *
	 * @param facultyRequestStatusId the primary key for the new faculty request status
	 * @return the new faculty request status
	 */
	public FacultyRequestStatus create(long facultyRequestStatusId);

	/**
	 * Removes the faculty request status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status that was removed
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public FacultyRequestStatus remove(long facultyRequestStatusId)
		throws NoSuchFacultyRequestStatusException;

	public FacultyRequestStatus updateImpl(
		FacultyRequestStatus facultyRequestStatus);

	/**
	 * Returns the faculty request status with the primary key or throws a <code>NoSuchFacultyRequestStatusException</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status
	 * @throws NoSuchFacultyRequestStatusException if a faculty request status with the primary key could not be found
	 */
	public FacultyRequestStatus findByPrimaryKey(long facultyRequestStatusId)
		throws NoSuchFacultyRequestStatusException;

	/**
	 * Returns the faculty request status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestStatusId the primary key of the faculty request status
	 * @return the faculty request status, or <code>null</code> if a faculty request status with the primary key could not be found
	 */
	public FacultyRequestStatus fetchByPrimaryKey(long facultyRequestStatusId);

	/**
	 * Returns all the faculty request statuses.
	 *
	 * @return the faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findAll();

	/**
	 * Returns a range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @return the range of faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request statuses
	 * @param end the upper bound of the range of faculty request statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request statuses
	 */
	public java.util.List<FacultyRequestStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequestStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty request statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty request statuses.
	 *
	 * @return the number of faculty request statuses
	 */
	public int countAll();

}