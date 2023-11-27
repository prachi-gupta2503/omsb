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

import gov.omsb.tms.exception.NoSuchDutyLogException;
import gov.omsb.tms.model.DutyLog;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the duty log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogUtil
 * @generated
 */
@ProviderType
public interface DutyLogPersistence extends BasePersistence<DutyLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DutyLogUtil} to access the duty log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid(String uuid);

	/**
	 * Returns a range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByUuid_PrevAndNext(
			long dutyLogId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of duty logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty logs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogException;

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the duty log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the duty log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log that was removed
	 */
	public DutyLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogException;

	/**
	 * Returns the number of duty logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty logs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByUuid_C_PrevAndNext(
			long dutyLogId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of duty logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty logs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByTraineeIdAndStartDate(long traineeId, Date startDate)
		throws NoSuchDutyLogException;

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTraineeIdAndStartDate(long traineeId, Date startDate);

	/**
	 * Returns the duty log where traineeId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTraineeIdAndStartDate(
		long traineeId, Date startDate, boolean useFinderCache);

	/**
	 * Removes the duty log where traineeId = &#63; and startDate = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the duty log that was removed
	 */
	public DutyLog removeByTraineeIdAndStartDate(long traineeId, Date startDate)
		throws NoSuchDutyLogException;

	/**
	 * Returns the number of duty logs where traineeId = &#63; and startDate = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param startDate the start date
	 * @return the number of matching duty logs
	 */
	public int countByTraineeIdAndStartDate(long traineeId, Date startDate);

	/**
	 * Returns all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId);

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_First(
			long traineeId, long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_First(
		long traineeId, long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByTranieeIdAndBlocksMetadataDetailRelId_Last(
			long traineeId, long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTranieeIdAndBlocksMetadataDetailRelId_Last(
		long traineeId, long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByTranieeIdAndBlocksMetadataDetailRelId_PrevAndNext(
			long dutyLogId, long traineeId, long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public void removeByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId);

	/**
	 * Returns the number of duty logs where traineeId = &#63; and blocksMetadataDetailRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	public int countByTranieeIdAndBlocksMetadataDetailRelId(
		long traineeId, long blocksMetadataDetailRelId);

	/**
	 * Returns all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId);

	/**
	 * Returns a range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByTranieeIdAndProgramDutyAssignmentId_First(
			long traineeId, long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_First(
		long traineeId, long programDutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByTranieeIdAndProgramDutyAssignmentId_Last(
			long traineeId, long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByTranieeIdAndProgramDutyAssignmentId_Last(
		long traineeId, long programDutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByTranieeIdAndProgramDutyAssignmentId_PrevAndNext(
			long dutyLogId, long traineeId, long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where traineeId = &#63; and programDutyAssignmentId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	public void removeByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId);

	/**
	 * Returns the number of duty logs where traineeId = &#63; and programDutyAssignmentId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	public int countByTranieeIdAndProgramDutyAssignmentId(
		long traineeId, long programDutyAssignmentId);

	/**
	 * Returns all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId);

	/**
	 * Returns a range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByBlocksMetadataDetailRelId_First(
		long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByBlocksMetadataDetailRelId_Last(
		long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByBlocksMetadataDetailRelId_PrevAndNext(
			long dutyLogId, long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId);

	/**
	 * Returns the number of duty logs where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching duty logs
	 */
	public int countByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId);

	/**
	 * Returns all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the matching duty logs
	 */
	public java.util.List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId);

	/**
	 * Returns a range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of matching duty logs
	 */
	public java.util.List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end);

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs where programDutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty logs
	 */
	public java.util.List<DutyLog> findByProgramDutyAssignmentId(
		long programDutyAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByProgramDutyAssignmentId_First(
			long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the first duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByProgramDutyAssignmentId_First(
		long programDutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log
	 * @throws NoSuchDutyLogException if a matching duty log could not be found
	 */
	public DutyLog findByProgramDutyAssignmentId_Last(
			long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Returns the last duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public DutyLog fetchByProgramDutyAssignmentId_Last(
		long programDutyAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns the duty logs before and after the current duty log in the ordered set where programDutyAssignmentId = &#63;.
	 *
	 * @param dutyLogId the primary key of the current duty log
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog[] findByProgramDutyAssignmentId_PrevAndNext(
			long dutyLogId, long programDutyAssignmentId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
				orderByComparator)
		throws NoSuchDutyLogException;

	/**
	 * Removes all the duty logs where programDutyAssignmentId = &#63; from the database.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 */
	public void removeByProgramDutyAssignmentId(long programDutyAssignmentId);

	/**
	 * Returns the number of duty logs where programDutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the program duty assignment ID
	 * @return the number of matching duty logs
	 */
	public int countByProgramDutyAssignmentId(long programDutyAssignmentId);

	/**
	 * Caches the duty log in the entity cache if it is enabled.
	 *
	 * @param dutyLog the duty log
	 */
	public void cacheResult(DutyLog dutyLog);

	/**
	 * Caches the duty logs in the entity cache if it is enabled.
	 *
	 * @param dutyLogs the duty logs
	 */
	public void cacheResult(java.util.List<DutyLog> dutyLogs);

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	public DutyLog create(long dutyLogId);

	/**
	 * Removes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog remove(long dutyLogId) throws NoSuchDutyLogException;

	public DutyLog updateImpl(DutyLog dutyLog);

	/**
	 * Returns the duty log with the primary key or throws a <code>NoSuchDutyLogException</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws NoSuchDutyLogException if a duty log with the primary key could not be found
	 */
	public DutyLog findByPrimaryKey(long dutyLogId)
		throws NoSuchDutyLogException;

	/**
	 * Returns the duty log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log, or <code>null</code> if a duty log with the primary key could not be found
	 */
	public DutyLog fetchByPrimaryKey(long dutyLogId);

	/**
	 * Returns all the duty logs.
	 *
	 * @return the duty logs
	 */
	public java.util.List<DutyLog> findAll();

	/**
	 * Returns a range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of duty logs
	 */
	public java.util.List<DutyLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty logs
	 */
	public java.util.List<DutyLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty logs
	 */
	public java.util.List<DutyLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the duty logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	public int countAll();

}