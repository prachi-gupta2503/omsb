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

import gov.omsb.tms.exception.NoSuchProcedureGroupMasterException;
import gov.omsb.tms.model.ProcedureGroupMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the procedure group master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMasterUtil
 * @generated
 */
@ProviderType
public interface ProcedureGroupMasterPersistence
	extends BasePersistence<ProcedureGroupMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcedureGroupMasterUtil} to access the procedure group master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster[] findByUuid_PrevAndNext(
			long procedureGroupMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Removes all the procedure group masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of procedure group masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure group masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the procedure group master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the procedure group master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure group master that was removed
	 */
	public ProcedureGroupMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure group masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the first procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the last procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster[] findByUuid_C_PrevAndNext(
			long procedureGroupMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Removes all the procedure group masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of procedure group masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure group masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName);

	/**
	 * Returns a range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end);

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupName the procedure group name
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findByprocedureGroupNameByLike(
		String procedureGroupName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByprocedureGroupNameByLike_First(
			String procedureGroupName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the first procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByprocedureGroupNameByLike_First(
		String procedureGroupName,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster findByprocedureGroupNameByLike_Last(
			String procedureGroupName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the last procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	public ProcedureGroupMaster fetchByprocedureGroupNameByLike_Last(
		String procedureGroupName,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns the procedure group masters before and after the current procedure group master in the ordered set where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupMasterId the primary key of the current procedure group master
	 * @param procedureGroupName the procedure group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster[] findByprocedureGroupNameByLike_PrevAndNext(
			long procedureGroupMasterId, String procedureGroupName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProcedureGroupMaster> orderByComparator)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Removes all the procedure group masters where procedureGroupName LIKE &#63; from the database.
	 *
	 * @param procedureGroupName the procedure group name
	 */
	public void removeByprocedureGroupNameByLike(String procedureGroupName);

	/**
	 * Returns the number of procedure group masters where procedureGroupName LIKE &#63;.
	 *
	 * @param procedureGroupName the procedure group name
	 * @return the number of matching procedure group masters
	 */
	public int countByprocedureGroupNameByLike(String procedureGroupName);

	/**
	 * Caches the procedure group master in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMaster the procedure group master
	 */
	public void cacheResult(ProcedureGroupMaster procedureGroupMaster);

	/**
	 * Caches the procedure group masters in the entity cache if it is enabled.
	 *
	 * @param procedureGroupMasters the procedure group masters
	 */
	public void cacheResult(
		java.util.List<ProcedureGroupMaster> procedureGroupMasters);

	/**
	 * Creates a new procedure group master with the primary key. Does not add the procedure group master to the database.
	 *
	 * @param procedureGroupMasterId the primary key for the new procedure group master
	 * @return the new procedure group master
	 */
	public ProcedureGroupMaster create(long procedureGroupMasterId);

	/**
	 * Removes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster remove(long procedureGroupMasterId)
		throws NoSuchProcedureGroupMasterException;

	public ProcedureGroupMaster updateImpl(
		ProcedureGroupMaster procedureGroupMaster);

	/**
	 * Returns the procedure group master with the primary key or throws a <code>NoSuchProcedureGroupMasterException</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws NoSuchProcedureGroupMasterException if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster findByPrimaryKey(long procedureGroupMasterId)
		throws NoSuchProcedureGroupMasterException;

	/**
	 * Returns the procedure group master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master, or <code>null</code> if a procedure group master with the primary key could not be found
	 */
	public ProcedureGroupMaster fetchByPrimaryKey(long procedureGroupMasterId);

	/**
	 * Returns all the procedure group masters.
	 *
	 * @return the procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findAll();

	/**
	 * Returns a range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure group masters
	 */
	public java.util.List<ProcedureGroupMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureGroupMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the procedure group masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of procedure group masters.
	 *
	 * @return the number of procedure group masters
	 */
	public int countAll();

}