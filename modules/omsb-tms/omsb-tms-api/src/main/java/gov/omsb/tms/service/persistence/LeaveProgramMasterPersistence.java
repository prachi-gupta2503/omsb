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

import gov.omsb.tms.exception.NoSuchLeaveProgramMasterException;
import gov.omsb.tms.model.LeaveProgramMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave program master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveProgramMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveProgramMasterPersistence
	extends BasePersistence<LeaveProgramMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveProgramMasterUtil} to access the leave program master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where uuid = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster[] findByUuid_PrevAndNext(
			long leaveProgramMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Removes all the leave program masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave program masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave program master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave program master that was removed
	 */
	public LeaveProgramMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the number of leave program masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave program masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the first leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the last leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster[] findByUuid_C_PrevAndNext(
			long leaveProgramMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Removes all the leave program masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave program masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leave program masters where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @return the matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId);

	/**
	 * Returns a range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave program masters where programMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programMasterId the program master ID
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findByProgramMasterId(
		long programMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByProgramMasterId_First(
			long programMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the first leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByProgramMasterId_First(
		long programMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the last leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByProgramMasterId_Last(
			long programMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the last leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByProgramMasterId_Last(
		long programMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns the leave program masters before and after the current leave program master in the ordered set where programMasterId = &#63;.
	 *
	 * @param leaveProgramMasterId the primary key of the current leave program master
	 * @param programMasterId the program master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster[] findByProgramMasterId_PrevAndNext(
			long leaveProgramMasterId, long programMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
				orderByComparator)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Removes all the leave program masters where programMasterId = &#63; from the database.
	 *
	 * @param programMasterId the program master ID
	 */
	public void removeByProgramMasterId(long programMasterId);

	/**
	 * Returns the number of leave program masters where programMasterId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @return the number of matching leave program masters
	 */
	public int countByProgramMasterId(long programMasterId);

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the matching leave program master
	 * @throws NoSuchLeaveProgramMasterException if a matching leave program master could not be found
	 */
	public LeaveProgramMaster findByProgramMasterLeaveTypeId(
			long programMasterId, long leaveTypesId)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId);

	/**
	 * Returns the leave program master where programMasterId = &#63; and leaveTypesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	public LeaveProgramMaster fetchByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId, boolean useFinderCache);

	/**
	 * Removes the leave program master where programMasterId = &#63; and leaveTypesId = &#63; from the database.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the leave program master that was removed
	 */
	public LeaveProgramMaster removeByProgramMasterLeaveTypeId(
			long programMasterId, long leaveTypesId)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the number of leave program masters where programMasterId = &#63; and leaveTypesId = &#63;.
	 *
	 * @param programMasterId the program master ID
	 * @param leaveTypesId the leave types ID
	 * @return the number of matching leave program masters
	 */
	public int countByProgramMasterLeaveTypeId(
		long programMasterId, long leaveTypesId);

	/**
	 * Caches the leave program master in the entity cache if it is enabled.
	 *
	 * @param leaveProgramMaster the leave program master
	 */
	public void cacheResult(LeaveProgramMaster leaveProgramMaster);

	/**
	 * Caches the leave program masters in the entity cache if it is enabled.
	 *
	 * @param leaveProgramMasters the leave program masters
	 */
	public void cacheResult(
		java.util.List<LeaveProgramMaster> leaveProgramMasters);

	/**
	 * Creates a new leave program master with the primary key. Does not add the leave program master to the database.
	 *
	 * @param leaveProgramMasterId the primary key for the new leave program master
	 * @return the new leave program master
	 */
	public LeaveProgramMaster create(long leaveProgramMasterId);

	/**
	 * Removes the leave program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master that was removed
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster remove(long leaveProgramMasterId)
		throws NoSuchLeaveProgramMasterException;

	public LeaveProgramMaster updateImpl(LeaveProgramMaster leaveProgramMaster);

	/**
	 * Returns the leave program master with the primary key or throws a <code>NoSuchLeaveProgramMasterException</code> if it could not be found.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master
	 * @throws NoSuchLeaveProgramMasterException if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster findByPrimaryKey(long leaveProgramMasterId)
		throws NoSuchLeaveProgramMasterException;

	/**
	 * Returns the leave program master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master, or <code>null</code> if a leave program master with the primary key could not be found
	 */
	public LeaveProgramMaster fetchByPrimaryKey(long leaveProgramMasterId);

	/**
	 * Returns all the leave program masters.
	 *
	 * @return the leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findAll();

	/**
	 * Returns a range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave program masters
	 */
	public java.util.List<LeaveProgramMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave program masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave program masters.
	 *
	 * @return the number of leave program masters
	 */
	public int countAll();

}