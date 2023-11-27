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

import gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException;
import gov.omsb.tms.model.FacultyRequestRotations;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty request rotations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsUtil
 * @generated
 */
@ProviderType
public interface FacultyRequestRotationsPersistence
	extends BasePersistence<FacultyRequestRotations> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyRequestRotationsUtil} to access the faculty request rotations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public FacultyRequestRotations[] findByUuid_PrevAndNext(
			long facultyRequestRotationsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request rotationses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty request rotations where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request rotations that was removed
	 */
	public FacultyRequestRotations removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request rotationses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public FacultyRequestRotations[] findByUuid_C_PrevAndNext(
			long facultyRequestRotationsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request rotationses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations findByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive);

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	public FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive, boolean useFinderCache);

	/**
	 * Removes the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the faculty request rotations that was removed
	 */
	public FacultyRequestRotations removeByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the number of faculty request rotationses where facultyRequestId = &#63; and isActive = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the number of matching faculty request rotationses
	 */
	public int countByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive);

	/**
	 * Caches the faculty request rotations in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 */
	public void cacheResult(FacultyRequestRotations facultyRequestRotations);

	/**
	 * Caches the faculty request rotationses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotationses the faculty request rotationses
	 */
	public void cacheResult(
		java.util.List<FacultyRequestRotations> facultyRequestRotationses);

	/**
	 * Creates a new faculty request rotations with the primary key. Does not add the faculty request rotations to the database.
	 *
	 * @param facultyRequestRotationsId the primary key for the new faculty request rotations
	 * @return the new faculty request rotations
	 */
	public FacultyRequestRotations create(long facultyRequestRotationsId);

	/**
	 * Removes the faculty request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations that was removed
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public FacultyRequestRotations remove(long facultyRequestRotationsId)
		throws NoSuchFacultyRequestRotationsException;

	public FacultyRequestRotations updateImpl(
		FacultyRequestRotations facultyRequestRotations);

	/**
	 * Returns the faculty request rotations with the primary key or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	public FacultyRequestRotations findByPrimaryKey(
			long facultyRequestRotationsId)
		throws NoSuchFacultyRequestRotationsException;

	/**
	 * Returns the faculty request rotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations, or <code>null</code> if a faculty request rotations with the primary key could not be found
	 */
	public FacultyRequestRotations fetchByPrimaryKey(
		long facultyRequestRotationsId);

	/**
	 * Returns all the faculty request rotationses.
	 *
	 * @return the faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findAll();

	/**
	 * Returns a range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator);

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request rotationses
	 */
	public java.util.List<FacultyRequestRotations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FacultyRequestRotations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty request rotationses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty request rotationses.
	 *
	 * @return the number of faculty request rotationses
	 */
	public int countAll();

}