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

import gov.omsb.tms.model.BlocksMetadataDetailsRel;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the blocks metadata details rel service. This utility wraps <code>gov.omsb.tms.service.persistence.impl.BlocksMetadataDetailsRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelPersistence
 * @generated
 */
public class BlocksMetadataDetailsRelUtil {

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
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		getPersistence().clearCache(blocksMetadataDetailsRel);
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
	public static Map<Serializable, BlocksMetadataDetailsRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BlocksMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BlocksMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BlocksMetadataDetailsRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BlocksMetadataDetailsRel update(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return getPersistence().update(blocksMetadataDetailsRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BlocksMetadataDetailsRel update(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			blocksMetadataDetailsRel, serviceContext);
	}

	/**
	 * Returns all the blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching blocks metadata details rels
	 */
	public static List<BlocksMetadataDetailsRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_PrevAndNext(
			blocksMetadataDetailsRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching blocks metadata details rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the blocks metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the blocks metadata details rel that was removed
	 */
	public static BlocksMetadataDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching blocks metadata details rels
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching blocks metadata details rels
	 */
	public static List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static BlocksMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			blocksMetadataDetailsRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching blocks metadata details rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the matching blocks metadata details rels
	 */
	public static List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		return getPersistence().findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId);
	}

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
	public static List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end) {

		return getPersistence().findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, start, end);
	}

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
	public static List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, start, end, orderByComparator);
	}

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
	public static List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_First(
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByProgDurationTlBlocksLtId_First(
			progDurationTlBlocksLtId, orderByComparator);
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtId_First(
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByProgDurationTlBlocksLtId_First(
			progDurationTlBlocksLtId, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_Last(
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByProgDurationTlBlocksLtId_Last(
			progDurationTlBlocksLtId, orderByComparator);
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByProgDurationTlBlocksLtId_Last(
		long progDurationTlBlocksLtId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().fetchByProgDurationTlBlocksLtId_Last(
			progDurationTlBlocksLtId, orderByComparator);
	}

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel[]
			findByProgDurationTlBlocksLtId_PrevAndNext(
				long blocksMetadataDetailsRelId, long progDurationTlBlocksLtId,
				OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByProgDurationTlBlocksLtId_PrevAndNext(
			blocksMetadataDetailsRelId, progDurationTlBlocksLtId,
			orderByComparator);
	}

	/**
	 * Removes all the blocks metadata details rels where progDurationTlBlocksLtId = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 */
	public static void removeByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		getPersistence().removeByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId);
	}

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the number of matching blocks metadata details rels
	 */
	public static int countByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		return getPersistence().countByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId);
	}

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
			findByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByProgDurationTlBlocksLtIdAndBlockStartDate(
			progDurationTlBlocksLtId, blockStartDate);
	}

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate) {

		return getPersistence().
			fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);
	}

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate,
			boolean useFinderCache) {

		return getPersistence().
			fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate, useFinderCache);
	}

	/**
	 * Removes the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the blocks metadata details rel that was removed
	 */
	public static BlocksMetadataDetailsRel
			removeByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().
			removeByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);
	}

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the number of matching blocks metadata details rels
	 */
	public static int countByProgDurationTlBlocksLtIdAndBlockStartDate(
		long progDurationTlBlocksLtId, Date blockStartDate) {

		return getPersistence().
			countByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);
	}

	/**
	 * Caches the blocks metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 */
	public static void cacheResult(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		getPersistence().cacheResult(blocksMetadataDetailsRel);
	}

	/**
	 * Caches the blocks metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRels the blocks metadata details rels
	 */
	public static void cacheResult(
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) {

		getPersistence().cacheResult(blocksMetadataDetailsRels);
	}

	/**
	 * Creates a new blocks metadata details rel with the primary key. Does not add the blocks metadata details rel to the database.
	 *
	 * @param blocksMetadataDetailsRelId the primary key for the new blocks metadata details rel
	 * @return the new blocks metadata details rel
	 */
	public static BlocksMetadataDetailsRel create(
		long blocksMetadataDetailsRelId) {

		return getPersistence().create(blocksMetadataDetailsRelId);
	}

	/**
	 * Removes the blocks metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel remove(
			long blocksMetadataDetailsRelId)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().remove(blocksMetadataDetailsRelId);
	}

	public static BlocksMetadataDetailsRel updateImpl(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return getPersistence().updateImpl(blocksMetadataDetailsRel);
	}

	/**
	 * Returns the blocks metadata details rel with the primary key or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel findByPrimaryKey(
			long blocksMetadataDetailsRelId)
		throws gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException {

		return getPersistence().findByPrimaryKey(blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel, or <code>null</code> if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel fetchByPrimaryKey(
		long blocksMetadataDetailsRelId) {

		return getPersistence().fetchByPrimaryKey(blocksMetadataDetailsRelId);
	}

	/**
	 * Returns all the blocks metadata details rels.
	 *
	 * @return the blocks metadata details rels
	 */
	public static List<BlocksMetadataDetailsRel> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BlocksMetadataDetailsRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the blocks metadata details rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of blocks metadata details rels.
	 *
	 * @return the number of blocks metadata details rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BlocksMetadataDetailsRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BlocksMetadataDetailsRelPersistence _persistence;

}