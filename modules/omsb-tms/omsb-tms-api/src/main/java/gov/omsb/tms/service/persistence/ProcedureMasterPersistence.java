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

import gov.omsb.tms.exception.NoSuchProcedureMasterException;
import gov.omsb.tms.model.ProcedureMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the procedure master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMasterUtil
 * @generated
 */
@ProviderType
public interface ProcedureMasterPersistence
	extends BasePersistence<ProcedureMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcedureMasterUtil} to access the procedure master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster[] findByUuid_PrevAndNext(
			long procedureMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Removes all the procedure masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of procedure masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procedure masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the procedure master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the procedure master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procedure master that was removed
	 */
	public ProcedureMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the number of procedure masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procedure masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the first procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the last procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster[] findByUuid_C_PrevAndNext(
			long procedureMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Removes all the procedure masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of procedure masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procedure masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName);

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end);

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureNameByLike(
		String procedureName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByProcedureNameByLike_First(
			String procedureName,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByProcedureNameByLike_First(
		String procedureName,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByProcedureNameByLike_Last(
			String procedureName,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByProcedureNameByLike_Last(
		String procedureName,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster[] findByProcedureNameByLike_PrevAndNext(
			long procedureMasterId, String procedureName,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 */
	public void removeByProcedureNameByLike(String procedureName);

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63;.
	 *
	 * @param procedureName the procedure name
	 * @return the number of matching procedure masters
	 */
	public int countByProcedureNameByLike(String procedureName);

	/**
	 * Returns all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	public java.util.List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId);

	/**
	 * Returns a range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end);

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_First(
				String procedureName, long procedureGroupMasterId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the first procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_First(
			String procedureName, long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator);

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster
			findByProcedureNameByLikeAndProcedureGroupMasterId_Last(
				String procedureName, long procedureGroupMasterId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the last procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster
		fetchByProcedureNameByLikeAndProcedureGroupMasterId_Last(
			String procedureName, long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator);

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster[]
			findByProcedureNameByLikeAndProcedureGroupMasterId_PrevAndNext(
				long procedureMasterId, String procedureName,
				long procedureGroupMasterId,
				com.liferay.portal.kernel.util.OrderByComparator
					<ProcedureMaster> orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Removes all the procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public void removeByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId);

	/**
	 * Returns the number of procedure masters where procedureName LIKE &#63; and procedureGroupMasterId = &#63;.
	 *
	 * @param procedureName the procedure name
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	public int countByProcedureNameByLikeAndProcedureGroupMasterId(
		String procedureName, long procedureGroupMasterId);

	/**
	 * Returns all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId);

	/**
	 * Returns a range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procedure masters
	 */
	public java.util.List<ProcedureMaster> findByProcedureGroupMasterId(
		long procedureGroupMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByProcedureGroupMasterId_First(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the first procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByProcedureGroupMasterId_First(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master
	 * @throws NoSuchProcedureMasterException if a matching procedure master could not be found
	 */
	public ProcedureMaster findByProcedureGroupMasterId_Last(
			long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the last procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	public ProcedureMaster fetchByProcedureGroupMasterId_Last(
		long procedureGroupMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns the procedure masters before and after the current procedure master in the ordered set where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureMasterId the primary key of the current procedure master
	 * @param procedureGroupMasterId the procedure group master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster[] findByProcedureGroupMasterId_PrevAndNext(
			long procedureMasterId, long procedureGroupMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
				orderByComparator)
		throws NoSuchProcedureMasterException;

	/**
	 * Removes all the procedure masters where procedureGroupMasterId = &#63; from the database.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 */
	public void removeByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Returns the number of procedure masters where procedureGroupMasterId = &#63;.
	 *
	 * @param procedureGroupMasterId the procedure group master ID
	 * @return the number of matching procedure masters
	 */
	public int countByProcedureGroupMasterId(long procedureGroupMasterId);

	/**
	 * Caches the procedure master in the entity cache if it is enabled.
	 *
	 * @param procedureMaster the procedure master
	 */
	public void cacheResult(ProcedureMaster procedureMaster);

	/**
	 * Caches the procedure masters in the entity cache if it is enabled.
	 *
	 * @param procedureMasters the procedure masters
	 */
	public void cacheResult(java.util.List<ProcedureMaster> procedureMasters);

	/**
	 * Creates a new procedure master with the primary key. Does not add the procedure master to the database.
	 *
	 * @param procedureMasterId the primary key for the new procedure master
	 * @return the new procedure master
	 */
	public ProcedureMaster create(long procedureMasterId);

	/**
	 * Removes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster remove(long procedureMasterId)
		throws NoSuchProcedureMasterException;

	public ProcedureMaster updateImpl(ProcedureMaster procedureMaster);

	/**
	 * Returns the procedure master with the primary key or throws a <code>NoSuchProcedureMasterException</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master
	 * @throws NoSuchProcedureMasterException if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster findByPrimaryKey(long procedureMasterId)
		throws NoSuchProcedureMasterException;

	/**
	 * Returns the procedure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master, or <code>null</code> if a procedure master with the primary key could not be found
	 */
	public ProcedureMaster fetchByPrimaryKey(long procedureMasterId);

	/**
	 * Returns all the procedure masters.
	 *
	 * @return the procedure masters
	 */
	public java.util.List<ProcedureMaster> findAll();

	/**
	 * Returns a range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of procedure masters
	 */
	public java.util.List<ProcedureMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procedure masters
	 */
	public java.util.List<ProcedureMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procedure masters
	 */
	public java.util.List<ProcedureMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcedureMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the procedure masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of procedure masters.
	 *
	 * @return the number of procedure masters
	 */
	public int countAll();

}