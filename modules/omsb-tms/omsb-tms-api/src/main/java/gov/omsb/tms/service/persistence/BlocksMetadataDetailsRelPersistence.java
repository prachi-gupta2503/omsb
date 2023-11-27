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

import gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the blocks metadata details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelUtil
 * @generated
 */
@ProviderType
public interface BlocksMetadataDetailsRelPersistence
	extends BasePersistence<BlocksMetadataDetailsRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BlocksMetadataDetailsRelUtil} to access the blocks metadata details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid(String uuid);

	/**
	 * Returns a range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching blocks metadata details rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the blocks metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the blocks metadata details rel that was removed
	 */
	public BlocksMetadataDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching blocks metadata details rels
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching blocks metadata details rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel>
		findByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId);

	/**
	 * Returns a range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel>
		findByProgDurationTlBlocksLtId(
			long progDurationTlBlocksLtId, int start, int end);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel>
		findByProgDurationTlBlocksLtId(
			long progDurationTlBlocksLtId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel>
		findByProgDurationTlBlocksLtId(
			long progDurationTlBlocksLtId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_First(
			long progDurationTlBlocksLtId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByProgDurationTlBlocksLtId_First(
		long progDurationTlBlocksLtId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_Last(
			long progDurationTlBlocksLtId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel fetchByProgDurationTlBlocksLtId_Last(
		long progDurationTlBlocksLtId,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel[]
			findByProgDurationTlBlocksLtId_PrevAndNext(
				long blocksMetadataDetailsRelId, long progDurationTlBlocksLtId,
				com.liferay.portal.kernel.util.OrderByComparator
					<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Removes all the blocks metadata details rels where progDurationTlBlocksLtId = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 */
	public void removeByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId);

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the number of matching blocks metadata details rels
	 */
	public int countByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId);

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel
			findByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate);

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate,
			boolean useFinderCache);

	/**
	 * Removes the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the blocks metadata details rel that was removed
	 */
	public BlocksMetadataDetailsRel
			removeByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the number of matching blocks metadata details rels
	 */
	public int countByProgDurationTlBlocksLtIdAndBlockStartDate(
		long progDurationTlBlocksLtId, Date blockStartDate);

	/**
	 * Caches the blocks metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 */
	public void cacheResult(BlocksMetadataDetailsRel blocksMetadataDetailsRel);

	/**
	 * Caches the blocks metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRels the blocks metadata details rels
	 */
	public void cacheResult(
		java.util.List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels);

	/**
	 * Creates a new blocks metadata details rel with the primary key. Does not add the blocks metadata details rel to the database.
	 *
	 * @param blocksMetadataDetailsRelId the primary key for the new blocks metadata details rel
	 * @return the new blocks metadata details rel
	 */
	public BlocksMetadataDetailsRel create(long blocksMetadataDetailsRelId);

	/**
	 * Removes the blocks metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel remove(long blocksMetadataDetailsRelId)
		throws NoSuchBlocksMetadataDetailsRelException;

	public BlocksMetadataDetailsRel updateImpl(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel);

	/**
	 * Returns the blocks metadata details rel with the primary key or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel findByPrimaryKey(
			long blocksMetadataDetailsRelId)
		throws NoSuchBlocksMetadataDetailsRelException;

	/**
	 * Returns the blocks metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel, or <code>null</code> if a blocks metadata details rel with the primary key could not be found
	 */
	public BlocksMetadataDetailsRel fetchByPrimaryKey(
		long blocksMetadataDetailsRelId);

	/**
	 * Returns all the blocks metadata details rels.
	 *
	 * @return the blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findAll();

	/**
	 * Returns a range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator);

	/**
	 * Returns an ordered range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blocks metadata details rels
	 */
	public java.util.List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the blocks metadata details rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of blocks metadata details rels.
	 *
	 * @return the number of blocks metadata details rels
	 */
	public int countAll();

}