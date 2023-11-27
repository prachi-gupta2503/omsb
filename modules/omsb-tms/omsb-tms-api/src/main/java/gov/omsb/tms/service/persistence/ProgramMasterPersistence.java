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

import gov.omsb.tms.exception.NoSuchProgramMasterException;
import gov.omsb.tms.model.ProgramMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMasterUtil
 * @generated
 */
@ProviderType
public interface ProgramMasterPersistence
	extends BasePersistence<ProgramMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramMasterUtil} to access the program master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByUuid_PrevAndNext(
			long programMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program master that was removed
	 */
	public ProgramMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the number of program masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByUuid_C_PrevAndNext(
			long programMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramStatus(
		Boolean programStatus);

	/**
	 * Returns a range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where programStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programStatus the program status
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramStatus(
		Boolean programStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramStatus_First(
			Boolean programStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramStatus_First(
		Boolean programStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramStatus_Last(
			Boolean programStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramStatus_Last(
		Boolean programStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programStatus = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programStatus the program status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByProgramStatus_PrevAndNext(
			long programMasterId, Boolean programStatus,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where programStatus = &#63; from the database.
	 *
	 * @param programStatus the program status
	 */
	public void removeByProgramStatus(Boolean programStatus);

	/**
	 * Returns the number of program masters where programStatus = &#63;.
	 *
	 * @param programStatus the program status
	 * @return the number of matching program masters
	 */
	public int countByProgramStatus(Boolean programStatus);

	/**
	 * Returns all the program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramNameByLike(
		String programName);

	/**
	 * Returns a range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where programName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programName the program name
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramNameByLike(
		String programName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramNameByLike_First(
			String programName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramNameByLike_First(
		String programName,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramNameByLike_Last(
			String programName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramNameByLike_Last(
		String programName,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programName LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programName the program name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByProgramNameByLike_PrevAndNext(
			long programMasterId, String programName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where programName LIKE &#63; from the database.
	 *
	 * @param programName the program name
	 */
	public void removeByProgramNameByLike(String programName);

	/**
	 * Returns the number of program masters where programName LIKE &#63;.
	 *
	 * @param programName the program name
	 * @return the number of matching program masters
	 */
	public int countByProgramNameByLike(String programName);

	/**
	 * Returns all the program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramCodeByLike(
		String programCode);

	/**
	 * Returns a range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where programCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programCode the program code
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByProgramCodeByLike(
		String programCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramCodeByLike_First(
			String programCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramCodeByLike_First(
		String programCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByProgramCodeByLike_Last(
			String programCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByProgramCodeByLike_Last(
		String programCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programCode LIKE &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programCode the program code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByProgramCodeByLike_PrevAndNext(
			long programMasterId, String programCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where programCode LIKE &#63; from the database.
	 *
	 * @param programCode the program code
	 */
	public void removeByProgramCodeByLike(String programCode);

	/**
	 * Returns the number of program masters where programCode LIKE &#63;.
	 *
	 * @param programCode the program code
	 * @return the number of matching program masters
	 */
	public int countByProgramCodeByLike(String programCode);

	/**
	 * Returns all the program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the matching program masters
	 */
	public java.util.List<ProgramMaster> findByprogramTypeId(
		long programTypeId);

	/**
	 * Returns a range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters where programTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeId the program type ID
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program masters
	 */
	public java.util.List<ProgramMaster> findByprogramTypeId(
		long programTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByprogramTypeId_First(
			long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the first program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByprogramTypeId_First(
		long programTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master
	 * @throws NoSuchProgramMasterException if a matching program master could not be found
	 */
	public ProgramMaster findByprogramTypeId_Last(
			long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the last program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program master, or <code>null</code> if a matching program master could not be found
	 */
	public ProgramMaster fetchByprogramTypeId_Last(
		long programTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns the program masters before and after the current program master in the ordered set where programTypeId = &#63;.
	 *
	 * @param programMasterId the primary key of the current program master
	 * @param programTypeId the program type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster[] findByprogramTypeId_PrevAndNext(
			long programMasterId, long programTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
				orderByComparator)
		throws NoSuchProgramMasterException;

	/**
	 * Removes all the program masters where programTypeId = &#63; from the database.
	 *
	 * @param programTypeId the program type ID
	 */
	public void removeByprogramTypeId(long programTypeId);

	/**
	 * Returns the number of program masters where programTypeId = &#63;.
	 *
	 * @param programTypeId the program type ID
	 * @return the number of matching program masters
	 */
	public int countByprogramTypeId(long programTypeId);

	/**
	 * Caches the program master in the entity cache if it is enabled.
	 *
	 * @param programMaster the program master
	 */
	public void cacheResult(ProgramMaster programMaster);

	/**
	 * Caches the program masters in the entity cache if it is enabled.
	 *
	 * @param programMasters the program masters
	 */
	public void cacheResult(java.util.List<ProgramMaster> programMasters);

	/**
	 * Creates a new program master with the primary key. Does not add the program master to the database.
	 *
	 * @param programMasterId the primary key for the new program master
	 * @return the new program master
	 */
	public ProgramMaster create(long programMasterId);

	/**
	 * Removes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master that was removed
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster remove(long programMasterId)
		throws NoSuchProgramMasterException;

	public ProgramMaster updateImpl(ProgramMaster programMaster);

	/**
	 * Returns the program master with the primary key or throws a <code>NoSuchProgramMasterException</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master
	 * @throws NoSuchProgramMasterException if a program master with the primary key could not be found
	 */
	public ProgramMaster findByPrimaryKey(long programMasterId)
		throws NoSuchProgramMasterException;

	/**
	 * Returns the program master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master, or <code>null</code> if a program master with the primary key could not be found
	 */
	public ProgramMaster fetchByPrimaryKey(long programMasterId);

	/**
	 * Returns all the program masters.
	 *
	 * @return the program masters
	 */
	public java.util.List<ProgramMaster> findAll();

	/**
	 * Returns a range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of program masters
	 */
	public java.util.List<ProgramMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program masters
	 */
	public java.util.List<ProgramMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program masters
	 */
	public java.util.List<ProgramMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program masters.
	 *
	 * @return the number of program masters
	 */
	public int countAll();

}