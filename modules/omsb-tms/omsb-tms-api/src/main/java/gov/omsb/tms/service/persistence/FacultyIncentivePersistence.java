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

import gov.omsb.tms.exception.NoSuchFacultyIncentiveException;
import gov.omsb.tms.model.FacultyIncentive;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faculty incentive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FacultyIncentiveUtil
 * @generated
 */
@ProviderType
public interface FacultyIncentivePersistence
	extends BasePersistence<FacultyIncentive> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyIncentiveUtil} to access the faculty incentive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faculty incentives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid(String uuid);

	/**
	 * Returns a range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns the faculty incentives before and after the current faculty incentive in the ordered set where uuid = &#63;.
	 *
	 * @param FacultyIncentiveId the primary key of the current faculty incentive
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	public FacultyIncentive[] findByUuid_PrevAndNext(
			long FacultyIncentiveId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Removes all the faculty incentives where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faculty incentives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty incentives
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the faculty incentive where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the faculty incentive where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty incentive that was removed
	 */
	public FacultyIncentive removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the number of faculty incentives where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty incentives
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty incentives
	 */
	public java.util.List<FacultyIncentive> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the first faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the last faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns the faculty incentives before and after the current faculty incentive in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param FacultyIncentiveId the primary key of the current faculty incentive
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	public FacultyIncentive[] findByUuid_C_PrevAndNext(
			long FacultyIncentiveId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
				orderByComparator)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Removes all the faculty incentives where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faculty incentives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty incentives
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the faculty incentive where roleId = &#63; or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param roleId the role ID
	 * @return the matching faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a matching faculty incentive could not be found
	 */
	public FacultyIncentive findByRoleId(long roleId)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the faculty incentive where roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roleId the role ID
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByRoleId(long roleId);

	/**
	 * Returns the faculty incentive where roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty incentive, or <code>null</code> if a matching faculty incentive could not be found
	 */
	public FacultyIncentive fetchByRoleId(long roleId, boolean useFinderCache);

	/**
	 * Removes the faculty incentive where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @return the faculty incentive that was removed
	 */
	public FacultyIncentive removeByRoleId(long roleId)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the number of faculty incentives where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching faculty incentives
	 */
	public int countByRoleId(long roleId);

	/**
	 * Caches the faculty incentive in the entity cache if it is enabled.
	 *
	 * @param facultyIncentive the faculty incentive
	 */
	public void cacheResult(FacultyIncentive facultyIncentive);

	/**
	 * Caches the faculty incentives in the entity cache if it is enabled.
	 *
	 * @param facultyIncentives the faculty incentives
	 */
	public void cacheResult(java.util.List<FacultyIncentive> facultyIncentives);

	/**
	 * Creates a new faculty incentive with the primary key. Does not add the faculty incentive to the database.
	 *
	 * @param FacultyIncentiveId the primary key for the new faculty incentive
	 * @return the new faculty incentive
	 */
	public FacultyIncentive create(long FacultyIncentiveId);

	/**
	 * Removes the faculty incentive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive that was removed
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	public FacultyIncentive remove(long FacultyIncentiveId)
		throws NoSuchFacultyIncentiveException;

	public FacultyIncentive updateImpl(FacultyIncentive facultyIncentive);

	/**
	 * Returns the faculty incentive with the primary key or throws a <code>NoSuchFacultyIncentiveException</code> if it could not be found.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive
	 * @throws NoSuchFacultyIncentiveException if a faculty incentive with the primary key could not be found
	 */
	public FacultyIncentive findByPrimaryKey(long FacultyIncentiveId)
		throws NoSuchFacultyIncentiveException;

	/**
	 * Returns the faculty incentive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FacultyIncentiveId the primary key of the faculty incentive
	 * @return the faculty incentive, or <code>null</code> if a faculty incentive with the primary key could not be found
	 */
	public FacultyIncentive fetchByPrimaryKey(long FacultyIncentiveId);

	/**
	 * Returns all the faculty incentives.
	 *
	 * @return the faculty incentives
	 */
	public java.util.List<FacultyIncentive> findAll();

	/**
	 * Returns a range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @return the range of faculty incentives
	 */
	public java.util.List<FacultyIncentive> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty incentives
	 */
	public java.util.List<FacultyIncentive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faculty incentives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyIncentiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty incentives
	 * @param end the upper bound of the range of faculty incentives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty incentives
	 */
	public java.util.List<FacultyIncentive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FacultyIncentive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faculty incentives from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faculty incentives.
	 *
	 * @return the number of faculty incentives
	 */
	public int countAll();

}