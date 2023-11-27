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

import gov.omsb.tms.exception.NoSuchLeaveAnnualMasterException;
import gov.omsb.tms.model.LeaveAnnualMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave annual master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveAnnualMasterPersistence
	extends BasePersistence<LeaveAnnualMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveAnnualMasterUtil} to access the leave annual master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave annual masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave annual masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @return the range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the first leave annual master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns the last leave annual master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the last leave annual master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns the leave annual masters before and after the current leave annual master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualMasterId the primary key of the current leave annual master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a leave annual master with the primary key could not be found
	 */
	public LeaveAnnualMaster[] findByUuid_PrevAndNext(
			long leaveAnnualMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Removes all the leave annual masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave annual masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave annual master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the leave annual master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave annual master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave annual master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual master that was removed
	 */
	public LeaveAnnualMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the number of leave annual masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave annual masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave annual masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @return the range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the first leave annual master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns the last leave annual master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the last leave annual master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	public LeaveAnnualMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns the leave annual masters before and after the current leave annual master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualMasterId the primary key of the current leave annual master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a leave annual master with the primary key could not be found
	 */
	public LeaveAnnualMaster[] findByUuid_C_PrevAndNext(
			long leaveAnnualMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
				orderByComparator)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Removes all the leave annual masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave annual masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the leave annual master in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaster the leave annual master
	 */
	public void cacheResult(LeaveAnnualMaster leaveAnnualMaster);

	/**
	 * Caches the leave annual masters in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMasters the leave annual masters
	 */
	public void cacheResult(
		java.util.List<LeaveAnnualMaster> leaveAnnualMasters);

	/**
	 * Creates a new leave annual master with the primary key. Does not add the leave annual master to the database.
	 *
	 * @param leaveAnnualMasterId the primary key for the new leave annual master
	 * @return the new leave annual master
	 */
	public LeaveAnnualMaster create(long leaveAnnualMasterId);

	/**
	 * Removes the leave annual master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualMasterId the primary key of the leave annual master
	 * @return the leave annual master that was removed
	 * @throws NoSuchLeaveAnnualMasterException if a leave annual master with the primary key could not be found
	 */
	public LeaveAnnualMaster remove(long leaveAnnualMasterId)
		throws NoSuchLeaveAnnualMasterException;

	public LeaveAnnualMaster updateImpl(LeaveAnnualMaster leaveAnnualMaster);

	/**
	 * Returns the leave annual master with the primary key or throws a <code>NoSuchLeaveAnnualMasterException</code> if it could not be found.
	 *
	 * @param leaveAnnualMasterId the primary key of the leave annual master
	 * @return the leave annual master
	 * @throws NoSuchLeaveAnnualMasterException if a leave annual master with the primary key could not be found
	 */
	public LeaveAnnualMaster findByPrimaryKey(long leaveAnnualMasterId)
		throws NoSuchLeaveAnnualMasterException;

	/**
	 * Returns the leave annual master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualMasterId the primary key of the leave annual master
	 * @return the leave annual master, or <code>null</code> if a leave annual master with the primary key could not be found
	 */
	public LeaveAnnualMaster fetchByPrimaryKey(long leaveAnnualMasterId);

	/**
	 * Returns all the leave annual masters.
	 *
	 * @return the leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findAll();

	/**
	 * Returns a range of all the leave annual masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @return the range of leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave annual masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual masters
	 */
	public java.util.List<LeaveAnnualMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave annual masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave annual masters.
	 *
	 * @return the number of leave annual masters
	 */
	public int countAll();

}