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

import gov.omsb.tms.exception.NoSuchViolationUpdateStatusException;
import gov.omsb.tms.model.ViolationUpdateStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the violation update status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ViolationUpdateStatusUtil
 * @generated
 */
@ProviderType
public interface ViolationUpdateStatusPersistence
	extends BasePersistence<ViolationUpdateStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViolationUpdateStatusUtil} to access the violation update status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid(String uuid);

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public ViolationUpdateStatus[] findByUuid_PrevAndNext(
			long violationUpdateStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Removes all the violation update statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of violation update statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching violation update statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the violation update status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the violation update status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the violation update status that was removed
	 */
	public ViolationUpdateStatus removeByUUID_G(String uuid, long groupId)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching violation update statuses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the first violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the last violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns the violation update statuses before and after the current violation update status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param violationUpdateStatusId the primary key of the current violation update status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public ViolationUpdateStatus[] findByUuid_C_PrevAndNext(
			long violationUpdateStatusId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ViolationUpdateStatus> orderByComparator)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Removes all the violation update statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of violation update statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching violation update statuses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status
	 * @throws NoSuchViolationUpdateStatusException if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId);

	/**
	 * Returns the violation update status where blocksMetadataDetailRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching violation update status, or <code>null</code> if a matching violation update status could not be found
	 */
	public ViolationUpdateStatus fetchByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, boolean useFinderCache);

	/**
	 * Removes the violation update status where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the violation update status that was removed
	 */
	public ViolationUpdateStatus removeByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the number of violation update statuses where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching violation update statuses
	 */
	public int countByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId);

	/**
	 * Caches the violation update status in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatus the violation update status
	 */
	public void cacheResult(ViolationUpdateStatus violationUpdateStatus);

	/**
	 * Caches the violation update statuses in the entity cache if it is enabled.
	 *
	 * @param violationUpdateStatuses the violation update statuses
	 */
	public void cacheResult(
		java.util.List<ViolationUpdateStatus> violationUpdateStatuses);

	/**
	 * Creates a new violation update status with the primary key. Does not add the violation update status to the database.
	 *
	 * @param violationUpdateStatusId the primary key for the new violation update status
	 * @return the new violation update status
	 */
	public ViolationUpdateStatus create(long violationUpdateStatusId);

	/**
	 * Removes the violation update status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status that was removed
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public ViolationUpdateStatus remove(long violationUpdateStatusId)
		throws NoSuchViolationUpdateStatusException;

	public ViolationUpdateStatus updateImpl(
		ViolationUpdateStatus violationUpdateStatus);

	/**
	 * Returns the violation update status with the primary key or throws a <code>NoSuchViolationUpdateStatusException</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status
	 * @throws NoSuchViolationUpdateStatusException if a violation update status with the primary key could not be found
	 */
	public ViolationUpdateStatus findByPrimaryKey(long violationUpdateStatusId)
		throws NoSuchViolationUpdateStatusException;

	/**
	 * Returns the violation update status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param violationUpdateStatusId the primary key of the violation update status
	 * @return the violation update status, or <code>null</code> if a violation update status with the primary key could not be found
	 */
	public ViolationUpdateStatus fetchByPrimaryKey(
		long violationUpdateStatusId);

	/**
	 * Returns all the violation update statuses.
	 *
	 * @return the violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findAll();

	/**
	 * Returns a range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @return the range of violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the violation update statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViolationUpdateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation update statuses
	 * @param end the upper bound of the range of violation update statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of violation update statuses
	 */
	public java.util.List<ViolationUpdateStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViolationUpdateStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the violation update statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of violation update statuses.
	 *
	 * @return the number of violation update statuses
	 */
	public int countAll();

}