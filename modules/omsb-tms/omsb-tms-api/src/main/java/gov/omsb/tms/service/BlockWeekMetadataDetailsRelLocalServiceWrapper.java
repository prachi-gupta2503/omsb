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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BlockWeekMetadataDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BlockWeekMetadataDetailsRelLocalService
 * @generated
 */
public class BlockWeekMetadataDetailsRelLocalServiceWrapper
	implements BlockWeekMetadataDetailsRelLocalService,
			   ServiceWrapper<BlockWeekMetadataDetailsRelLocalService> {

	public BlockWeekMetadataDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public BlockWeekMetadataDetailsRelLocalServiceWrapper(
		BlockWeekMetadataDetailsRelLocalService
			blockWeekMetadataDetailsRelLocalService) {

		_blockWeekMetadataDetailsRelLocalService =
			blockWeekMetadataDetailsRelLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		addBlockWeekMetadataDetailsRel(
			gov.omsb.tms.model.BlockWeekMetadataDetailsRel
				blockWeekMetadataDetailsRel) {

		return _blockWeekMetadataDetailsRelLocalService.
			addBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRel);
	}

	/**
	 * Creates a new block week metadata details rel with the primary key. Does not add the block week metadata details rel to the database.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key for the new block week metadata details rel
	 * @return the new block week metadata details rel
	 */
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		createBlockWeekMetadataDetailsRel(long blockWeekMetadataDetailsRelId) {

		return _blockWeekMetadataDetailsRelLocalService.
			createBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRelId);
	}

	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		createBlockWeekMetadataDetailsRel(
			long blocksMetadataDetailRelId, java.util.Date weekStartDate,
			java.util.Date weekEndDate, String weekNo, long userId,
			long groupId) {

		return _blockWeekMetadataDetailsRelLocalService.
			createBlockWeekMetadataDetailsRel(
				blocksMetadataDetailRelId, weekStartDate, weekEndDate, weekNo,
				userId, groupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		deleteBlockWeekMetadataDetailsRel(
			gov.omsb.tms.model.BlockWeekMetadataDetailsRel
				blockWeekMetadataDetailsRel) {

		return _blockWeekMetadataDetailsRelLocalService.
			deleteBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRel);
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
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
			deleteBlockWeekMetadataDetailsRel(
				long blockWeekMetadataDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.
			deleteBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _blockWeekMetadataDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _blockWeekMetadataDetailsRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _blockWeekMetadataDetailsRelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _blockWeekMetadataDetailsRelLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _blockWeekMetadataDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _blockWeekMetadataDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _blockWeekMetadataDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _blockWeekMetadataDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		fetchBlockWeekMetadataDetailsRel(long blockWeekMetadataDetailsRelId) {

		return _blockWeekMetadataDetailsRelLocalService.
			fetchBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel matching the UUID and group.
	 *
	 * @param uuid the block week metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		fetchBlockWeekMetadataDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _blockWeekMetadataDetailsRelLocalService.
			fetchBlockWeekMetadataDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.BlockWeekMetadataDetailsRel>
		findByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {

		return _blockWeekMetadataDetailsRelLocalService.
			findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _blockWeekMetadataDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the block week metadata details rel with the primary key.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws PortalException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
			getBlockWeekMetadataDetailsRel(long blockWeekMetadataDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel matching the UUID and group.
	 *
	 * @param uuid the block week metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching block week metadata details rel
	 * @throws PortalException if a matching block week metadata details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
			getBlockWeekMetadataDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRelByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRels(int start, int end) {

		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRels(start, end);
	}

	/**
	 * Returns all the block week metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the block week metadata details rels
	 * @param companyId the primary key of the company
	 * @return the matching block week metadata details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.BlockWeekMetadataDetailsRel>
		getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.BlockWeekMetadataDetailsRel>
					orderByComparator) {

		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of block week metadata details rels.
	 *
	 * @return the number of block week metadata details rels
	 */
	@Override
	public int getBlockWeekMetadataDetailsRelsCount() {
		return _blockWeekMetadataDetailsRelLocalService.
			getBlockWeekMetadataDetailsRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _blockWeekMetadataDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _blockWeekMetadataDetailsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blockWeekMetadataDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public gov.omsb.tms.model.BlockWeekMetadataDetailsRel
		updateBlockWeekMetadataDetailsRel(
			gov.omsb.tms.model.BlockWeekMetadataDetailsRel
				blockWeekMetadataDetailsRel) {

		return _blockWeekMetadataDetailsRelLocalService.
			updateBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRel);
	}

	@Override
	public BlockWeekMetadataDetailsRelLocalService getWrappedService() {
		return _blockWeekMetadataDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		BlockWeekMetadataDetailsRelLocalService
			blockWeekMetadataDetailsRelLocalService) {

		_blockWeekMetadataDetailsRelLocalService =
			blockWeekMetadataDetailsRelLocalService;
	}

	private BlockWeekMetadataDetailsRelLocalService
		_blockWeekMetadataDetailsRelLocalService;

}