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

import gov.omsb.tms.exception.NoSuchLeaveTraineeMasterException;
import gov.omsb.tms.model.LeaveTraineeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave trainee master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTraineeMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveTraineeMasterPersistence
	extends BasePersistence<LeaveTraineeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTraineeMasterUtil} to access the leave trainee master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave trainee masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns the leave trainee masters before and after the current leave trainee master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTraineeMasterId the primary key of the current leave trainee master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	public LeaveTraineeMaster[] findByUuid_PrevAndNext(
			long leaveTraineeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Removes all the leave trainee masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave trainee masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave trainee masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTraineeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave trainee master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave trainee master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave trainee master that was removed
	 */
	public LeaveTraineeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the number of leave trainee masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave trainee masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the first leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the last leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave trainee master, or <code>null</code> if a matching leave trainee master could not be found
	 */
	public LeaveTraineeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns the leave trainee masters before and after the current leave trainee master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTraineeMasterId the primary key of the current leave trainee master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	public LeaveTraineeMaster[] findByUuid_C_PrevAndNext(
			long leaveTraineeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
				orderByComparator)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Removes all the leave trainee masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave trainee masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave trainee masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the leave trainee master in the entity cache if it is enabled.
	 *
	 * @param leaveTraineeMaster the leave trainee master
	 */
	public void cacheResult(LeaveTraineeMaster leaveTraineeMaster);

	/**
	 * Caches the leave trainee masters in the entity cache if it is enabled.
	 *
	 * @param leaveTraineeMasters the leave trainee masters
	 */
	public void cacheResult(
		java.util.List<LeaveTraineeMaster> leaveTraineeMasters);

	/**
	 * Creates a new leave trainee master with the primary key. Does not add the leave trainee master to the database.
	 *
	 * @param leaveTraineeMasterId the primary key for the new leave trainee master
	 * @return the new leave trainee master
	 */
	public LeaveTraineeMaster create(long leaveTraineeMasterId);

	/**
	 * Removes the leave trainee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master that was removed
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	public LeaveTraineeMaster remove(long leaveTraineeMasterId)
		throws NoSuchLeaveTraineeMasterException;

	public LeaveTraineeMaster updateImpl(LeaveTraineeMaster leaveTraineeMaster);

	/**
	 * Returns the leave trainee master with the primary key or throws a <code>NoSuchLeaveTraineeMasterException</code> if it could not be found.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master
	 * @throws NoSuchLeaveTraineeMasterException if a leave trainee master with the primary key could not be found
	 */
	public LeaveTraineeMaster findByPrimaryKey(long leaveTraineeMasterId)
		throws NoSuchLeaveTraineeMasterException;

	/**
	 * Returns the leave trainee master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTraineeMasterId the primary key of the leave trainee master
	 * @return the leave trainee master, or <code>null</code> if a leave trainee master with the primary key could not be found
	 */
	public LeaveTraineeMaster fetchByPrimaryKey(long leaveTraineeMasterId);

	/**
	 * Returns all the leave trainee masters.
	 *
	 * @return the leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findAll();

	/**
	 * Returns a range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @return the range of leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave trainee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTraineeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trainee masters
	 * @param end the upper bound of the range of leave trainee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave trainee masters
	 */
	public java.util.List<LeaveTraineeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTraineeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave trainee masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave trainee masters.
	 *
	 * @return the number of leave trainee masters
	 */
	public int countAll();

}