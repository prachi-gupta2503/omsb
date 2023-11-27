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

import gov.omsb.tms.exception.NoSuchProgramTypeMasterException;
import gov.omsb.tms.model.ProgramTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the program type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterUtil
 * @generated
 */
@ProviderType
public interface ProgramTypeMasterPersistence
	extends BasePersistence<ProgramTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProgramTypeMasterUtil} to access the program type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster[] findByUuid_PrevAndNext(
			long programTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Removes all the program type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of program type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the program type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the program type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program type master that was removed
	 */
	public ProgramTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the number of program type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the first program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the last program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster[] findByUuid_C_PrevAndNext(
			long programTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Removes all the program type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of program type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName);

	/**
	 * Returns a range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end);

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program type masters where programTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param programTypeName the program type name
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program type masters
	 */
	public java.util.List<ProgramTypeMaster> findByProgramTypeNameByLike(
		String programTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByProgramTypeNameByLike_First(
			String programTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the first program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByProgramTypeNameByLike_First(
		String programTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master
	 * @throws NoSuchProgramTypeMasterException if a matching program type master could not be found
	 */
	public ProgramTypeMaster findByProgramTypeNameByLike_Last(
			String programTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the last program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	public ProgramTypeMaster fetchByProgramTypeNameByLike_Last(
		String programTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns the program type masters before and after the current program type master in the ordered set where programTypeName LIKE &#63;.
	 *
	 * @param programTypeMasterId the primary key of the current program type master
	 * @param programTypeName the program type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster[] findByProgramTypeNameByLike_PrevAndNext(
			long programTypeMasterId, String programTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
				orderByComparator)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Removes all the program type masters where programTypeName LIKE &#63; from the database.
	 *
	 * @param programTypeName the program type name
	 */
	public void removeByProgramTypeNameByLike(String programTypeName);

	/**
	 * Returns the number of program type masters where programTypeName LIKE &#63;.
	 *
	 * @param programTypeName the program type name
	 * @return the number of matching program type masters
	 */
	public int countByProgramTypeNameByLike(String programTypeName);

	/**
	 * Caches the program type master in the entity cache if it is enabled.
	 *
	 * @param programTypeMaster the program type master
	 */
	public void cacheResult(ProgramTypeMaster programTypeMaster);

	/**
	 * Caches the program type masters in the entity cache if it is enabled.
	 *
	 * @param programTypeMasters the program type masters
	 */
	public void cacheResult(
		java.util.List<ProgramTypeMaster> programTypeMasters);

	/**
	 * Creates a new program type master with the primary key. Does not add the program type master to the database.
	 *
	 * @param programTypeMasterId the primary key for the new program type master
	 * @return the new program type master
	 */
	public ProgramTypeMaster create(long programTypeMasterId);

	/**
	 * Removes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster remove(long programTypeMasterId)
		throws NoSuchProgramTypeMasterException;

	public ProgramTypeMaster updateImpl(ProgramTypeMaster programTypeMaster);

	/**
	 * Returns the program type master with the primary key or throws a <code>NoSuchProgramTypeMasterException</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master
	 * @throws NoSuchProgramTypeMasterException if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster findByPrimaryKey(long programTypeMasterId)
		throws NoSuchProgramTypeMasterException;

	/**
	 * Returns the program type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master, or <code>null</code> if a program type master with the primary key could not be found
	 */
	public ProgramTypeMaster fetchByPrimaryKey(long programTypeMasterId);

	/**
	 * Returns all the program type masters.
	 *
	 * @return the program type masters
	 */
	public java.util.List<ProgramTypeMaster> findAll();

	/**
	 * Returns a range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of program type masters
	 */
	public java.util.List<ProgramTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program type masters
	 */
	public java.util.List<ProgramTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program type masters
	 */
	public java.util.List<ProgramTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProgramTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the program type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of program type masters.
	 *
	 * @return the number of program type masters
	 */
	public int countAll();

}