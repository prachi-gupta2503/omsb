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

import gov.omsb.tms.exception.NoSuchLeaveTypesException;
import gov.omsb.tms.model.LeaveTypes;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave types service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypesUtil
 * @generated
 */
@ProviderType
public interface LeaveTypesPersistence extends BasePersistence<LeaveTypes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTypesUtil} to access the leave types persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public LeaveTypes findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public LeaveTypes findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns the leave typeses before and after the current leave types in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTypesId the primary key of the current leave types
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public LeaveTypes[] findByUuid_PrevAndNext(
			long leaveTypesId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Removes all the leave typeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave typeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave typeses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTypesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public LeaveTypes findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave types where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave types where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave types that was removed
	 */
	public LeaveTypes removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the number of leave typeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave typeses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave typeses
	 */
	public java.util.List<LeaveTypes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public LeaveTypes findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the first leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types
	 * @throws NoSuchLeaveTypesException if a matching leave types could not be found
	 */
	public LeaveTypes findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the last leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave types, or <code>null</code> if a matching leave types could not be found
	 */
	public LeaveTypes fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns the leave typeses before and after the current leave types in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTypesId the primary key of the current leave types
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public LeaveTypes[] findByUuid_C_PrevAndNext(
			long leaveTypesId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
				orderByComparator)
		throws NoSuchLeaveTypesException;

	/**
	 * Removes all the leave typeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave typeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave typeses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the leave types in the entity cache if it is enabled.
	 *
	 * @param leaveTypes the leave types
	 */
	public void cacheResult(LeaveTypes leaveTypes);

	/**
	 * Caches the leave typeses in the entity cache if it is enabled.
	 *
	 * @param leaveTypeses the leave typeses
	 */
	public void cacheResult(java.util.List<LeaveTypes> leaveTypeses);

	/**
	 * Creates a new leave types with the primary key. Does not add the leave types to the database.
	 *
	 * @param leaveTypesId the primary key for the new leave types
	 * @return the new leave types
	 */
	public LeaveTypes create(long leaveTypesId);

	/**
	 * Removes the leave types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types that was removed
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public LeaveTypes remove(long leaveTypesId)
		throws NoSuchLeaveTypesException;

	public LeaveTypes updateImpl(LeaveTypes leaveTypes);

	/**
	 * Returns the leave types with the primary key or throws a <code>NoSuchLeaveTypesException</code> if it could not be found.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types
	 * @throws NoSuchLeaveTypesException if a leave types with the primary key could not be found
	 */
	public LeaveTypes findByPrimaryKey(long leaveTypesId)
		throws NoSuchLeaveTypesException;

	/**
	 * Returns the leave types with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypesId the primary key of the leave types
	 * @return the leave types, or <code>null</code> if a leave types with the primary key could not be found
	 */
	public LeaveTypes fetchByPrimaryKey(long leaveTypesId);

	/**
	 * Returns all the leave typeses.
	 *
	 * @return the leave typeses
	 */
	public java.util.List<LeaveTypes> findAll();

	/**
	 * Returns a range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @return the range of leave typeses
	 */
	public java.util.List<LeaveTypes> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave typeses
	 */
	public java.util.List<LeaveTypes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave typeses
	 * @param end the upper bound of the range of leave typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave typeses
	 */
	public java.util.List<LeaveTypes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave typeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave typeses.
	 *
	 * @return the number of leave typeses
	 */
	public int countAll();

}