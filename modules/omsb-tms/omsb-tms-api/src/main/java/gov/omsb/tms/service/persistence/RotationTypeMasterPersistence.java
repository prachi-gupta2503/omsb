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

import gov.omsb.tms.exception.NoSuchRotationTypeMasterException;
import gov.omsb.tms.model.RotationTypeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rotation type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RotationTypeMasterUtil
 * @generated
 */
@ProviderType
public interface RotationTypeMasterPersistence
	extends BasePersistence<RotationTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RotationTypeMasterUtil} to access the rotation type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid(String uuid);

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster[] findByUuid_PrevAndNext(
			long rotationTypeMasterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Removes all the rotation type masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of rotation type masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation type masters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the rotation type master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the rotation type master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation type master that was removed
	 */
	public RotationTypeMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation type masters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the first rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the last rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster[] findByUuid_C_PrevAndNext(
			long rotationTypeMasterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Removes all the rotation type masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of rotation type masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation type masters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName);

	/**
	 * Returns a range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end);

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param rotationTypeName the rotation type name
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findByRotationTypeNameByLike(
		String rotationTypeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByRotationTypeNameByLike_First(
			String rotationTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the first rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByRotationTypeNameByLike_First(
		String rotationTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master
	 * @throws NoSuchRotationTypeMasterException if a matching rotation type master could not be found
	 */
	public RotationTypeMaster findByRotationTypeNameByLike_Last(
			String rotationTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the last rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation type master, or <code>null</code> if a matching rotation type master could not be found
	 */
	public RotationTypeMaster fetchByRotationTypeNameByLike_Last(
		String rotationTypeName,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns the rotation type masters before and after the current rotation type master in the ordered set where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeMasterId the primary key of the current rotation type master
	 * @param rotationTypeName the rotation type name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster[] findByRotationTypeNameByLike_PrevAndNext(
			long rotationTypeMasterId, String rotationTypeName,
			com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
				orderByComparator)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Removes all the rotation type masters where rotationTypeName LIKE &#63; from the database.
	 *
	 * @param rotationTypeName the rotation type name
	 */
	public void removeByRotationTypeNameByLike(String rotationTypeName);

	/**
	 * Returns the number of rotation type masters where rotationTypeName LIKE &#63;.
	 *
	 * @param rotationTypeName the rotation type name
	 * @return the number of matching rotation type masters
	 */
	public int countByRotationTypeNameByLike(String rotationTypeName);

	/**
	 * Caches the rotation type master in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMaster the rotation type master
	 */
	public void cacheResult(RotationTypeMaster rotationTypeMaster);

	/**
	 * Caches the rotation type masters in the entity cache if it is enabled.
	 *
	 * @param rotationTypeMasters the rotation type masters
	 */
	public void cacheResult(
		java.util.List<RotationTypeMaster> rotationTypeMasters);

	/**
	 * Creates a new rotation type master with the primary key. Does not add the rotation type master to the database.
	 *
	 * @param rotationTypeMasterId the primary key for the new rotation type master
	 * @return the new rotation type master
	 */
	public RotationTypeMaster create(long rotationTypeMasterId);

	/**
	 * Removes the rotation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master that was removed
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster remove(long rotationTypeMasterId)
		throws NoSuchRotationTypeMasterException;

	public RotationTypeMaster updateImpl(RotationTypeMaster rotationTypeMaster);

	/**
	 * Returns the rotation type master with the primary key or throws a <code>NoSuchRotationTypeMasterException</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master
	 * @throws NoSuchRotationTypeMasterException if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster findByPrimaryKey(long rotationTypeMasterId)
		throws NoSuchRotationTypeMasterException;

	/**
	 * Returns the rotation type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationTypeMasterId the primary key of the rotation type master
	 * @return the rotation type master, or <code>null</code> if a rotation type master with the primary key could not be found
	 */
	public RotationTypeMaster fetchByPrimaryKey(long rotationTypeMasterId);

	/**
	 * Returns all the rotation type masters.
	 *
	 * @return the rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findAll();

	/**
	 * Returns a range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @return the range of rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the rotation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation type masters
	 * @param end the upper bound of the range of rotation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation type masters
	 */
	public java.util.List<RotationTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RotationTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rotation type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rotation type masters.
	 *
	 * @return the number of rotation type masters
	 */
	public int countAll();

}