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

import gov.omsb.tms.exception.NoSuchFacultyRequestException;
import gov.omsb.tms.model.FacultyRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestUtil
 * @generated
 */
@ProviderType
public interface FacultyRequestPersistence
	extends BasePersistence<FacultyRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyRequestUtil} to access the faculty request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	public FacultyRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	public FacultyRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns the faculty requests before and after the current faculty request in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestId the primary key of the current faculty request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	public FacultyRequest[] findByUuid_PrevAndNext(
			long facultyRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Removes all the faculty requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	public FacultyRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request that was removed
	 */
	public FacultyRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the number of faculty requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty requests
	 */
	public java.util.List<FacultyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	public FacultyRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the first faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request
	 * @throws NoSuchFacultyRequestException if a matching faculty request could not be found
	 */
	public FacultyRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the last faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request, or <code>null</code> if a matching faculty request could not be found
	 */
	public FacultyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns the faculty requests before and after the current faculty request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestId the primary key of the current faculty request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	public FacultyRequest[] findByUuid_C_PrevAndNext(
			long facultyRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
				orderByComparator)
		throws NoSuchFacultyRequestException;

	/**
	 * Removes all the faculty requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the faculty request in the entity cache if it is enabled.
	 *
	 * @param facultyRequest the faculty request
	 */
	public void cacheResult(FacultyRequest facultyRequest);

	/**
	 * Caches the faculty requests in the entity cache if it is enabled.
	 *
	 * @param facultyRequests the faculty requests
	 */
	public void cacheResult(java.util.List<FacultyRequest> facultyRequests);

	/**
	 * Creates a new faculty request with the primary key. Does not add the faculty request to the database.
	 *
	 * @param facultyRequestId the primary key for the new faculty request
	 * @return the new faculty request
	 */
	public FacultyRequest create(long facultyRequestId);

	/**
	 * Removes the faculty request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request that was removed
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	public FacultyRequest remove(long facultyRequestId)
		throws NoSuchFacultyRequestException;

	public FacultyRequest updateImpl(FacultyRequest facultyRequest);

	/**
	 * Returns the faculty request with the primary key or throws a <code>NoSuchFacultyRequestException</code> if it could not be found.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request
	 * @throws NoSuchFacultyRequestException if a faculty request with the primary key could not be found
	 */
	public FacultyRequest findByPrimaryKey(long facultyRequestId)
		throws NoSuchFacultyRequestException;

	/**
	 * Returns the faculty request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestId the primary key of the faculty request
	 * @return the faculty request, or <code>null</code> if a faculty request with the primary key could not be found
	 */
	public FacultyRequest fetchByPrimaryKey(long facultyRequestId);

	/**
	 * Returns all the faculty requests.
	 *
	 * @return the faculty requests
	 */
	public java.util.List<FacultyRequest> findAll();

	/**
	 * Returns a range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @return the range of faculty requests
	 */
	public java.util.List<FacultyRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty requests
	 */
	public java.util.List<FacultyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty requests
	 * @param end the upper bound of the range of faculty requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty requests
	 */
	public java.util.List<FacultyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty requests.
	 *
	 * @return the number of faculty requests
	 */
	public int countAll();

}