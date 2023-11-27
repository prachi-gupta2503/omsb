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

import gov.omsb.tms.exception.NoSuchDutyLogViolationException;
import gov.omsb.tms.model.DutyLogViolation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the duty log violation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationUtil
 * @generated
 */
@ProviderType
public interface DutyLogViolationPersistence
	extends BasePersistence<DutyLogViolation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DutyLogViolationUtil} to access the duty log violation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid(String uuid);

	/**
	 * Returns a range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation[] findByUuid_PrevAndNext(
			long ViolationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Removes all the duty log violations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of duty log violations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching duty log violations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the duty log violation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the duty log violation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the duty log violation that was removed
	 */
	public DutyLogViolation removeByUUID_G(String uuid, long groupId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the number of duty log violations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching duty log violations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the first duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the last duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation[] findByUuid_C_PrevAndNext(
			long ViolationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Removes all the duty log violations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of duty log violations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching duty log violations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the duty log violation where traineeId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByTraineeId(long traineeId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeId(long traineeId);

	/**
	 * Returns the duty log violation where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeId(
		long traineeId, boolean useFinderCache);

	/**
	 * Removes the duty log violation where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the duty log violation that was removed
	 */
	public DutyLogViolation removeByTraineeId(long traineeId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the number of duty log violations where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching duty log violations
	 */
	public int countByTraineeId(long traineeId);

	/**
	 * Returns all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId);

	/**
	 * Returns a range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end);

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching duty log violations
	 */
	public java.util.List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByTraineeIdAndBlockId_First(
			long traineeId, long blockId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the first duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeIdAndBlockId_First(
		long traineeId, long blockId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByTraineeIdAndBlockId_Last(
			long traineeId, long blockId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the last duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeIdAndBlockId_Last(
		long traineeId, long blockId,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns the duty log violations before and after the current duty log violation in the ordered set where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param ViolationId the primary key of the current duty log violation
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation[] findByTraineeIdAndBlockId_PrevAndNext(
			long ViolationId, long traineeId, long blockId,
			com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
				orderByComparator)
		throws NoSuchDutyLogViolationException;

	/**
	 * Removes all the duty log violations where traineeId = &#63; and blockId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 */
	public void removeByTraineeIdAndBlockId(long traineeId, long blockId);

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @return the number of matching duty log violations
	 */
	public int countByTraineeIdAndBlockId(long traineeId, long blockId);

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId, long dutyLogId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId);

	/**
	 * Returns the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId,
		boolean useFinderCache);

	/**
	 * Removes the duty log violation where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	public DutyLogViolation removeByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId, long dutyLogId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the number of duty log violations where traineeId = &#63; and blockId = &#63; and programMasterId = &#63; and dutyLogId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blockId the block ID
	 * @param programMasterId the program master ID
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	public int countByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId);

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation
	 * @throws NoSuchDutyLogViolationException if a matching duty log violation could not be found
	 */
	public DutyLogViolation findByDutyLogId(long dutyLogId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByDutyLogId(long dutyLogId);

	/**
	 * Returns the duty log violation where dutyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dutyLogId the duty log ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public DutyLogViolation fetchByDutyLogId(
		long dutyLogId, boolean useFinderCache);

	/**
	 * Removes the duty log violation where dutyLogId = &#63; from the database.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the duty log violation that was removed
	 */
	public DutyLogViolation removeByDutyLogId(long dutyLogId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the number of duty log violations where dutyLogId = &#63;.
	 *
	 * @param dutyLogId the duty log ID
	 * @return the number of matching duty log violations
	 */
	public int countByDutyLogId(long dutyLogId);

	/**
	 * Caches the duty log violation in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolation the duty log violation
	 */
	public void cacheResult(DutyLogViolation dutyLogViolation);

	/**
	 * Caches the duty log violations in the entity cache if it is enabled.
	 *
	 * @param dutyLogViolations the duty log violations
	 */
	public void cacheResult(java.util.List<DutyLogViolation> dutyLogViolations);

	/**
	 * Creates a new duty log violation with the primary key. Does not add the duty log violation to the database.
	 *
	 * @param ViolationId the primary key for the new duty log violation
	 * @return the new duty log violation
	 */
	public DutyLogViolation create(long ViolationId);

	/**
	 * Removes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation remove(long ViolationId)
		throws NoSuchDutyLogViolationException;

	public DutyLogViolation updateImpl(DutyLogViolation dutyLogViolation);

	/**
	 * Returns the duty log violation with the primary key or throws a <code>NoSuchDutyLogViolationException</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws NoSuchDutyLogViolationException if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation findByPrimaryKey(long ViolationId)
		throws NoSuchDutyLogViolationException;

	/**
	 * Returns the duty log violation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation, or <code>null</code> if a duty log violation with the primary key could not be found
	 */
	public DutyLogViolation fetchByPrimaryKey(long ViolationId);

	/**
	 * Returns all the duty log violations.
	 *
	 * @return the duty log violations
	 */
	public java.util.List<DutyLogViolation> findAll();

	/**
	 * Returns a range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of duty log violations
	 */
	public java.util.List<DutyLogViolation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of duty log violations
	 */
	public java.util.List<DutyLogViolation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of duty log violations
	 */
	public java.util.List<DutyLogViolation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DutyLogViolation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the duty log violations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	public int countAll();

}