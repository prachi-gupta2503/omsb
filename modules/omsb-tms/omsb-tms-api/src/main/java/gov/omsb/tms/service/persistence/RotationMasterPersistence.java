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

import gov.omsb.tms.exception.NoSuchRotationMasterException;
import gov.omsb.tms.model.RotationMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rotation master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationMasterUtil
 * @generated
 */
@ProviderType
public interface RotationMasterPersistence
	extends BasePersistence<RotationMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RotationMasterUtil} to access the rotation master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster[] findByUuid_PrevAndNext(
			long rotationMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Removes all the rotation masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of rotation masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the rotation master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the rotation master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation master that was removed
	 */
	public RotationMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the number of rotation masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the first rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the last rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster[] findByUuid_C_PrevAndNext(
			long rotationMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Removes all the rotation masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of rotation masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus);

	/**
	 * Returns a range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters where rotationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationStatus the rotation status
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationStatus(
		Boolean rotationStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationStatus_First(
			Boolean rotationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the first rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationStatus_First(
		Boolean rotationStatus,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationStatus_Last(
			Boolean rotationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the last rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationStatus_Last(
		Boolean rotationStatus,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationStatus = &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationStatus the rotation status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster[] findByRotationStatus_PrevAndNext(
			long rotationMasterId, Boolean rotationStatus,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Removes all the rotation masters where rotationStatus = &#63; from the database.
	 *
	 * @param rotationStatus the rotation status
	 */
	public void removeByRotationStatus(Boolean rotationStatus);

	/**
	 * Returns the number of rotation masters where rotationStatus = &#63;.
	 *
	 * @param rotationStatus the rotation status
	 * @return the number of matching rotation masters
	 */
	public int countByRotationStatus(Boolean rotationStatus);

	/**
	 * Returns all the rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationNameByLike(
		String rotationName);

	/**
	 * Returns a range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters where rotationName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationName the rotation name
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationNameByLike(
		String rotationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationNameByLike_First(
			String rotationName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the first rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationNameByLike_First(
		String rotationName,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationNameByLike_Last(
			String rotationName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the last rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationNameByLike_Last(
		String rotationName,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationName LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationName the rotation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster[] findByRotationNameByLike_PrevAndNext(
			long rotationMasterId, String rotationName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Removes all the rotation masters where rotationName LIKE &#63; from the database.
	 *
	 * @param rotationName the rotation name
	 */
	public void removeByRotationNameByLike(String rotationName);

	/**
	 * Returns the number of rotation masters where rotationName LIKE &#63;.
	 *
	 * @param rotationName the rotation name
	 * @return the number of matching rotation masters
	 */
	public int countByRotationNameByLike(String rotationName);

	/**
	 * Returns all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationCodeByLike(
		String rotationCode);

	/**
	 * Returns a range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters where rotationCode LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationCode the rotation code
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation masters
	 */
	public java.util.List<RotationMaster> findByRotationCodeByLike(
		String rotationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationCodeByLike_First(
			String rotationCode,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the first rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationCodeByLike_First(
		String rotationCode,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master
	 * @throws NoSuchRotationMasterException if a matching rotation master could not be found
	 */
	public RotationMaster findByRotationCodeByLike_Last(
			String rotationCode,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the last rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	public RotationMaster fetchByRotationCodeByLike_Last(
		String rotationCode,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns the rotation masters before and after the current rotation master in the ordered set where rotationCode LIKE &#63;.
	 *
	 * @param rotationMasterId the primary key of the current rotation master
	 * @param rotationCode the rotation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster[] findByRotationCodeByLike_PrevAndNext(
			long rotationMasterId, String rotationCode,
			com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
				orderByComparator)
		throws NoSuchRotationMasterException;

	/**
	 * Removes all the rotation masters where rotationCode LIKE &#63; from the database.
	 *
	 * @param rotationCode the rotation code
	 */
	public void removeByRotationCodeByLike(String rotationCode);

	/**
	 * Returns the number of rotation masters where rotationCode LIKE &#63;.
	 *
	 * @param rotationCode the rotation code
	 * @return the number of matching rotation masters
	 */
	public int countByRotationCodeByLike(String rotationCode);

	/**
	 * Caches the rotation master in the entity cache if it is enabled.
	 *
	 * @param rotationMaster the rotation master
	 */
	public void cacheResult(RotationMaster rotationMaster);

	/**
	 * Caches the rotation masters in the entity cache if it is enabled.
	 *
	 * @param rotationMasters the rotation masters
	 */
	public void cacheResult(java.util.List<RotationMaster> rotationMasters);

	/**
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	public RotationMaster create(long rotationMasterId);

	/**
	 * Removes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster remove(long rotationMasterId)
		throws NoSuchRotationMasterException;

	public RotationMaster updateImpl(RotationMaster rotationMaster);

	/**
	 * Returns the rotation master with the primary key or throws a <code>NoSuchRotationMasterException</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws NoSuchRotationMasterException if a rotation master with the primary key could not be found
	 */
	public RotationMaster findByPrimaryKey(long rotationMasterId)
		throws NoSuchRotationMasterException;

	/**
	 * Returns the rotation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master, or <code>null</code> if a rotation master with the primary key could not be found
	 */
	public RotationMaster fetchByPrimaryKey(long rotationMasterId);

	/**
	 * Returns all the rotation masters.
	 *
	 * @return the rotation masters
	 */
	public java.util.List<RotationMaster> findAll();

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	public java.util.List<RotationMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation masters
	 */
	public java.util.List<RotationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation masters
	 */
	public java.util.List<RotationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rotation masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	public int countAll();

}