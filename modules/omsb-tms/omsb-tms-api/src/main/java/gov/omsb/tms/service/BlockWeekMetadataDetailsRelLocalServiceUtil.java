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

package gov.omsb.tms.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BlockWeekMetadataDetailsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.BlockWeekMetadataDetailsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRelLocalService
 * @generated
 */
public class BlockWeekMetadataDetailsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.BlockWeekMetadataDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the block week metadata details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlockWeekMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 * @return the block week metadata details rel that was added
	 */
	public static BlockWeekMetadataDetailsRel addBlockWeekMetadataDetailsRel(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return getService().addBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRel);
	}

	/**
	 * Creates a new block week metadata details rel with the primary key. Does not add the block week metadata details rel to the database.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key for the new block week metadata details rel
	 * @return the new block week metadata details rel
	 */
	public static BlockWeekMetadataDetailsRel createBlockWeekMetadataDetailsRel(
		long blockWeekMetadataDetailsRelId) {

		return getService().createBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRelId);
	}

	public static BlockWeekMetadataDetailsRel createBlockWeekMetadataDetailsRel(
		long blocksMetadataDetailRelId, java.util.Date weekStartDate,
		java.util.Date weekEndDate, String weekNo, long userId, long groupId) {

		return getService().createBlockWeekMetadataDetailsRel(
			blocksMetadataDetailRelId, weekStartDate, weekEndDate, weekNo,
			userId, groupId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the block week metadata details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlockWeekMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 */
	public static BlockWeekMetadataDetailsRel deleteBlockWeekMetadataDetailsRel(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return getService().deleteBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRel);
	}

	/**
	 * Deletes the block week metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlockWeekMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 * @throws PortalException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel deleteBlockWeekMetadataDetailsRel(
			long blockWeekMetadataDetailsRelId)
		throws PortalException {

		return getService().deleteBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static BlockWeekMetadataDetailsRel fetchBlockWeekMetadataDetailsRel(
		long blockWeekMetadataDetailsRelId) {

		return getService().fetchBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel matching the UUID and group.
	 *
	 * @param uuid the block week metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
		fetchBlockWeekMetadataDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchBlockWeekMetadataDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {

		return getService().findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the block week metadata details rel with the primary key.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws PortalException if a block week metadata details rel with the primary key could not be found
	 */
	public static BlockWeekMetadataDetailsRel getBlockWeekMetadataDetailsRel(
			long blockWeekMetadataDetailsRelId)
		throws PortalException {

		return getService().getBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel matching the UUID and group.
	 *
	 * @param uuid the block week metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching block week metadata details rel
	 * @throws PortalException if a matching block week metadata details rel could not be found
	 */
	public static BlockWeekMetadataDetailsRel
			getBlockWeekMetadataDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getBlockWeekMetadataDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of block week metadata details rels
	 */
	public static List<BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRels(int start, int end) {

		return getService().getBlockWeekMetadataDetailsRels(start, end);
	}

	/**
	 * Returns all the block week metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the block week metadata details rels
	 * @param companyId the primary key of the company
	 * @return the matching block week metadata details rels, or an empty list if no matches were found
	 */
	public static List<BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of block week metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the block week metadata details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching block week metadata details rels, or an empty list if no matches were found
	 */
	public static List<BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return getService().getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of block week metadata details rels.
	 *
	 * @return the number of block week metadata details rels
	 */
	public static int getBlockWeekMetadataDetailsRelsCount() {
		return getService().getBlockWeekMetadataDetailsRelsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the block week metadata details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlockWeekMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 * @return the block week metadata details rel that was updated
	 */
	public static BlockWeekMetadataDetailsRel updateBlockWeekMetadataDetailsRel(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		return getService().updateBlockWeekMetadataDetailsRel(
			blockWeekMetadataDetailsRel);
	}

	public static BlockWeekMetadataDetailsRelLocalService getService() {
		return _service;
	}

	private static volatile BlockWeekMetadataDetailsRelLocalService _service;

}