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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the block week metadata details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.BlockWeekMetadataDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRelPersistence
 * @generated
 */
public class BlockWeekMetadataDetailsRelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		getPersistence().clearCache(blockWeekMetadataDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BlockWeekMetadataDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BlockWeekMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BlockWeekMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BlockWeekMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BlockWeekMetadataDetailsRel update(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return getPersistence().update(blockWeekMetadataDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BlockWeekMetadataDetailsRel update(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			blockWeekMetadataDetailsRel, serviceContext);
	}

	/**
	 * Returns all the block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching block week metadata details rels
	 */
	public static List<BlockWeekMetadataDetailsRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			blockWeekMetadataDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching block week metadata details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the block week metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the block week metadata details rel that was removed
	 */
	public static BlockWeekMetadataDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching block week metadata details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching block week metadata details rels
	 */
	public static List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static BlockWeekMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			blockWeekMetadataDetailsRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching block week metadata details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching block week metadata details rels
	 */
	public static List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

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
	public static List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end);
	}

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
	public static List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator);
	}

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
	public static List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(
			long blocksMetadataDetailRelId, int start, int end,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
			findByBlocksMetadataDetailRelId_First(
				long blocksMetadataDetailRelId,
				OrderByComparator<BlockWeekMetadataDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailRelId_First(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
		fetchByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailRelId_First(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
			findByBlocksMetadataDetailRelId_Last(
				long blocksMetadataDetailRelId,
				OrderByComparator<BlockWeekMetadataDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailRelId_Last(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
		fetchByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByBlocksMetadataDetailRelId_Last(
			blocksMetadataDetailRelId, orderByComparator);
	}

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel[]
			findByBlocksMetadataDetailRelId_PrevAndNext(
				long blockWeekMetadataDetailsRelId,
				long blocksMetadataDetailRelId,
				OrderByComparator<BlockWeekMetadataDetailsRel>
					orderByComparator)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByBlocksMetadataDetailRelId_PrevAndNext(
			blockWeekMetadataDetailsRelId, blocksMetadataDetailRelId,
			orderByComparator);
	}

	/**
	 * Removes all the block week metadata details rels where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	public static void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		getPersistence().removeByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Returns the number of block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching block week metadata details rels
	 */
	public static int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getPersistence().countByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	/**
	 * Caches the block week metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 */
	public static void cacheResult(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		getPersistence().cacheResult(blockWeekMetadataDetailsRel);
	}

	/**
	 * Caches the block week metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRels the block week metadata details rels
	 */
	public static void cacheResult(
		List<BlockWeekMetadataDetailsRel> blockWeekMetadataDetailsRels) {

		getPersistence().cacheResult(blockWeekMetadataDetailsRels);
	}

	/**
	 * Creates a new block week metadata details rel with the primary key. Does not add the block week metadata details rel to the database.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key for the new block week metadata details rel
	 * @return the new block week metadata details rel
	 */
	public static BlockWeekMetadataDetailsRel create(
		long blockWeekMetadataDetailsRelId) {

		return getPersistence().create(blockWeekMetadataDetailsRelId);
	}

	/**
	 * Removes the block week metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel remove(
			long blockWeekMetadataDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().remove(blockWeekMetadataDetailsRelId);
	}

	public static BlockWeekMetadataDetailsRel updateImpl(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return getPersistence().updateImpl(blockWeekMetadataDetailsRel);
	}

	/**
	 * Returns the block week metadata details rel with the primary key or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel findByPrimaryKey(
			long blockWeekMetadataDetailsRelId)
		throws gov.omsb.tms.exception.
			NoSuchBlockWeekMetadataDetailsRelException {

		return getPersistence().findByPrimaryKey(blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel, or <code>null</code> if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel fetchByPrimaryKey(
		long blockWeekMetadataDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(
			blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns all the block week metadata details rels.
	 *
	 * @return the block week metadata details rels
	 */
	public static List<BlockWeekMetadataDetailsRel> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the block week metadata details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of block week metadata details rels.
	 *
	 * @return the number of block week metadata details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BlockWeekMetadataDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BlockWeekMetadataDetailsRelPersistence _persistence;

}