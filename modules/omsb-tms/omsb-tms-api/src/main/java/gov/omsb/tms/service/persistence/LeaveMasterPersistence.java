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

import gov.omsb.tms.exception.NoSuchLeaveMasterException;
import gov.omsb.tms.model.LeaveMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveMasterPersistence extends BasePersistence<LeaveMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveMasterUtil} to access the leave master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	public LeaveMaster[] findByUuid_PrevAndNext(
			long leaveMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Removes all the leave masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave master that was removed
	 */
	public LeaveMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the number of leave masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the first leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the last leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	public LeaveMaster[] findByUuid_C_PrevAndNext(
			long leaveMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Removes all the leave masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leave masters where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching leave masters
	 */
	public java.util.List<LeaveMaster> findByTraineeId(long traineeId);

	/**
	 * Returns a range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end);

	/**
	 * Returns an ordered range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave masters where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave masters
	 */
	public java.util.List<LeaveMaster> findByTraineeId(
		long traineeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByTraineeId_First(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the first leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByTraineeId_First(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the last leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master
	 * @throws NoSuchLeaveMasterException if a matching leave master could not be found
	 */
	public LeaveMaster findByTraineeId_Last(
			long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the last leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave master, or <code>null</code> if a matching leave master could not be found
	 */
	public LeaveMaster fetchByTraineeId_Last(
		long traineeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns the leave masters before and after the current leave master in the ordered set where traineeId = &#63;.
	 *
	 * @param leaveMasterId the primary key of the current leave master
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	public LeaveMaster[] findByTraineeId_PrevAndNext(
			long leaveMasterId, long traineeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
				orderByComparator)
		throws NoSuchLeaveMasterException;

	/**
	 * Removes all the leave masters where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	public void removeByTraineeId(long traineeId);

	/**
	 * Returns the number of leave masters where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching leave masters
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Caches the leave master in the entity cache if it is enabled.
	 *
	 * @param leaveMaster the leave master
	 */
	public void cacheResult(LeaveMaster leaveMaster);

	/**
	 * Caches the leave masters in the entity cache if it is enabled.
	 *
	 * @param leaveMasters the leave masters
	 */
	public void cacheResult(java.util.List<LeaveMaster> leaveMasters);

	/**
	 * Creates a new leave master with the primary key. Does not add the leave master to the database.
	 *
	 * @param leaveMasterId the primary key for the new leave master
	 * @return the new leave master
	 */
	public LeaveMaster create(long leaveMasterId);

	/**
	 * Removes the leave master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master that was removed
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	public LeaveMaster remove(long leaveMasterId)
		throws NoSuchLeaveMasterException;

	public LeaveMaster updateImpl(LeaveMaster leaveMaster);

	/**
	 * Returns the leave master with the primary key or throws a <code>NoSuchLeaveMasterException</code> if it could not be found.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master
	 * @throws NoSuchLeaveMasterException if a leave master with the primary key could not be found
	 */
	public LeaveMaster findByPrimaryKey(long leaveMasterId)
		throws NoSuchLeaveMasterException;

	/**
	 * Returns the leave master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveMasterId the primary key of the leave master
	 * @return the leave master, or <code>null</code> if a leave master with the primary key could not be found
	 */
	public LeaveMaster fetchByPrimaryKey(long leaveMasterId);

	/**
	 * Returns all the leave masters.
	 *
	 * @return the leave masters
	 */
	public java.util.List<LeaveMaster> findAll();

	/**
	 * Returns a range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @return the range of leave masters
	 */
	public java.util.List<LeaveMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave masters
	 */
	public java.util.List<LeaveMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave masters
	 * @param end the upper bound of the range of leave masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave masters
	 */
	public java.util.List<LeaveMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave masters.
	 *
	 * @return the number of leave masters
	 */
	public int countAll();

}