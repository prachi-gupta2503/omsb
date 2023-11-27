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

import gov.omsb.tms.exception.NoSuchLeaveAnnualMaxTraineeException;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave annual max trainee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTraineeUtil
 * @generated
 */
@ProviderType
public interface LeaveAnnualMaxTraineePersistence
	extends BasePersistence<LeaveAnnualMaxTrainee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveAnnualMaxTraineeUtil} to access the leave annual max trainee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public LeaveAnnualMaxTrainee[] findByUuid_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave annual max trainees
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave annual max trainee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave annual max trainee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave annual max trainee that was removed
	 */
	public LeaveAnnualMaxTrainee removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave annual max trainees
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the first leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the last leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns the leave annual max trainees before and after the current leave annual max trainee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the current leave annual max trainee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public LeaveAnnualMaxTrainee[] findByUuid_C_PrevAndNext(
			long leaveAnnualMaxTraineeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveAnnualMaxTrainee> orderByComparator)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Removes all the leave annual max trainees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave annual max trainees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave annual max trainees
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the leave annual max trainee in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 */
	public void cacheResult(LeaveAnnualMaxTrainee leaveAnnualMaxTrainee);

	/**
	 * Caches the leave annual max trainees in the entity cache if it is enabled.
	 *
	 * @param leaveAnnualMaxTrainees the leave annual max trainees
	 */
	public void cacheResult(
		java.util.List<LeaveAnnualMaxTrainee> leaveAnnualMaxTrainees);

	/**
	 * Creates a new leave annual max trainee with the primary key. Does not add the leave annual max trainee to the database.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key for the new leave annual max trainee
	 * @return the new leave annual max trainee
	 */
	public LeaveAnnualMaxTrainee create(long leaveAnnualMaxTraineeId);

	/**
	 * Removes the leave annual max trainee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public LeaveAnnualMaxTrainee remove(long leaveAnnualMaxTraineeId)
		throws NoSuchLeaveAnnualMaxTraineeException;

	public LeaveAnnualMaxTrainee updateImpl(
		LeaveAnnualMaxTrainee leaveAnnualMaxTrainee);

	/**
	 * Returns the leave annual max trainee with the primary key or throws a <code>NoSuchLeaveAnnualMaxTraineeException</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee
	 * @throws NoSuchLeaveAnnualMaxTraineeException if a leave annual max trainee with the primary key could not be found
	 */
	public LeaveAnnualMaxTrainee findByPrimaryKey(long leaveAnnualMaxTraineeId)
		throws NoSuchLeaveAnnualMaxTraineeException;

	/**
	 * Returns the leave annual max trainee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee, or <code>null</code> if a leave annual max trainee with the primary key could not be found
	 */
	public LeaveAnnualMaxTrainee fetchByPrimaryKey(
		long leaveAnnualMaxTraineeId);

	/**
	 * Returns all the leave annual max trainees.
	 *
	 * @return the leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findAll();

	/**
	 * Returns a range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave annual max trainees
	 */
	public java.util.List<LeaveAnnualMaxTrainee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveAnnualMaxTrainee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave annual max trainees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave annual max trainees.
	 *
	 * @return the number of leave annual max trainees
	 */
	public int countAll();

}