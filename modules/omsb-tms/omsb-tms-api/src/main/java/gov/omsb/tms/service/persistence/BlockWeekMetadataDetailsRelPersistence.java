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

import gov.omsb.tms.exception.NoSuchBlockWeekMetadataDetailsRelException;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the block week metadata details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRelUtil
 * @generated
 */
@ProviderType
public interface BlockWeekMetadataDetailsRelPersistence
	extends BasePersistence<BlockWeekMetadataDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BlockWeekMetadataDetailsRelUtil} to access the block week metadata details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching block week metadata details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the block week metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the block week metadata details rel that was removed
	 */
	public BlockWeekMetadataDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching block week metadata details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching block week metadata details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId);

	/**
	 * Returns a range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end);

	/**
	 * Returns an ordered range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByBlocksMetadataDetailRelId_First(
		long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel findByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByBlocksMetadataDetailRelId_Last(
		long blocksMetadataDetailRelId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel[]
			findByBlocksMetadataDetailRelId_PrevAndNext(
				long blockWeekMetadataDetailsRelId,
				long blocksMetadataDetailRelId,
				com.liferay.portal.kernel.util.OrderByComparator
					<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Removes all the block week metadata details rels where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId);

	/**
	 * Returns the number of block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching block week metadata details rels
	 */
	public int countByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId);

	/**
	 * Caches the block week metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 */
	public void cacheResult(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel);

	/**
	 * Caches the block week metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRels the block week metadata details rels
	 */
	public void cacheResult(
		java.util.List<BlockWeekMetadataDetailsRel>
			blockWeekMetadataDetailsRels);

	/**
	 * Creates a new block week metadata details rel with the primary key. Does not add the block week metadata details rel to the database.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key for the new block week metadata details rel
	 * @return the new block week metadata details rel
	 */
	public BlockWeekMetadataDetailsRel create(
		long blockWeekMetadataDetailsRelId);

	/**
	 * Removes the block week metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel remove(
			long blockWeekMetadataDetailsRelId)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	public BlockWeekMetadataDetailsRel updateImpl(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel);

	/**
	 * Returns the block week metadata details rel with the primary key or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel findByPrimaryKey(
			long blockWeekMetadataDetailsRelId)
		throws NoSuchBlockWeekMetadataDetailsRelException;

	/**
	 * Returns the block week metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel, or <code>null</code> if a block week metadata details rel with the primary key could not be found
	 */
	public BlockWeekMetadataDetailsRel fetchByPrimaryKey(
		long blockWeekMetadataDetailsRelId);

	/**
	 * Returns all the block week metadata details rels.
	 *
	 * @return the block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findAll();

	/**
	 * Returns a range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of block week metadata details rels
	 */
	public java.util.List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the block week metadata details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of block week metadata details rels.
	 *
	 * @return the number of block week metadata details rels
	 */
	public int countAll();

}