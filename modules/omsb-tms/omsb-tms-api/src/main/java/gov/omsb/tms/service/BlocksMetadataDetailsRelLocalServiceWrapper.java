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
 * Provides a wrapper for {@link BlocksMetadataDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelLocalService
 * @generated
 */
public class BlocksMetadataDetailsRelLocalServiceWrapper
	implements BlocksMetadataDetailsRelLocalService,
			   ServiceWrapper<BlocksMetadataDetailsRelLocalService> {

	public BlocksMetadataDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public BlocksMetadataDetailsRelLocalServiceWrapper(
		BlocksMetadataDetailsRelLocalService
			blocksMetadataDetailsRelLocalService) {

		_blocksMetadataDetailsRelLocalService =
			blocksMetadataDetailsRelLocalService;
	}

	/**
	 * Adds the blocks metadata details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 * @return the blocks metadata details rel that was added
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		addBlocksMetadataDetailsRel(
			gov.omsb.tms.model.BlocksMetadataDetailsRel
				blocksMetadataDetailsRel) {

		return _blocksMetadataDetailsRelLocalService.
			addBlocksMetadataDetailsRel(blocksMetadataDetailsRel);
	}

	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		createBlockMetadataDetailsRel(
			String blockNo, java.util.Date blockStartDate,
			java.util.Date blockEndDate, long progDurationTlBlocksLtId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _blocksMetadataDetailsRelLocalService.
			createBlockMetadataDetailsRel(
				blockNo, blockStartDate, blockEndDate, progDurationTlBlocksLtId,
				themeDisplay);
	}

	/**
	 * Creates a new blocks metadata details rel with the primary key. Does not add the blocks metadata details rel to the database.
	 *
	 * @param blocksMetadataDetailsRelId the primary key for the new blocks metadata details rel
	 * @return the new blocks metadata details rel
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		createBlocksMetadataDetailsRel(long blocksMetadataDetailsRelId) {

		return _blocksMetadataDetailsRelLocalService.
			createBlocksMetadataDetailsRel(blocksMetadataDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the blocks metadata details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		deleteBlocksMetadataDetailsRel(
			gov.omsb.tms.model.BlocksMetadataDetailsRel
				blocksMetadataDetailsRel) {

		return _blocksMetadataDetailsRelLocalService.
			deleteBlocksMetadataDetailsRel(blocksMetadataDetailsRel);
	}

	/**
	 * Deletes the blocks metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 * @throws PortalException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
			deleteBlocksMetadataDetailsRel(long blocksMetadataDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.
			deleteBlocksMetadataDetailsRel(blocksMetadataDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _blocksMetadataDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _blocksMetadataDetailsRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _blocksMetadataDetailsRelLocalService.dynamicQuery();
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

		return _blocksMetadataDetailsRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl</code>.
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

		return _blocksMetadataDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl</code>.
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

		return _blocksMetadataDetailsRelLocalService.dynamicQuery(
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

		return _blocksMetadataDetailsRelLocalService.dynamicQueryCount(
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

		return _blocksMetadataDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		fetchBlocksMetadataDetailsRel(long blocksMetadataDetailsRelId) {

		return _blocksMetadataDetailsRelLocalService.
			fetchBlocksMetadataDetailsRel(blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel matching the UUID and group.
	 *
	 * @param uuid the blocks metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		fetchBlocksMetadataDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _blocksMetadataDetailsRelLocalService.
			fetchBlocksMetadataDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.BlocksMetadataDetailsRel>
		findByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId) {

		return _blocksMetadataDetailsRelLocalService.
			findByProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
	}

	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		findByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, java.util.Date blockStartDate) {

		return _blocksMetadataDetailsRelLocalService.
			findByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _blocksMetadataDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the blocks metadata details rel with the primary key.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws PortalException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
			getBlocksMetadataDetailsRel(long blocksMetadataDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRel(blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel matching the UUID and group.
	 *
	 * @param uuid the blocks metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching blocks metadata details rel
	 * @throws PortalException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
			getBlocksMetadataDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of blocks metadata details rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BlocksMetadataDetailsRel>
		getBlocksMetadataDetailsRels(int start, int end) {

		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRels(start, end);
	}

	/**
	 * Returns all the blocks metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the blocks metadata details rels
	 * @param companyId the primary key of the company
	 * @return the matching blocks metadata details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BlocksMetadataDetailsRel>
		getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of blocks metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the blocks metadata details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching blocks metadata details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.BlocksMetadataDetailsRel>
		getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.BlocksMetadataDetailsRel>
					orderByComparator) {

		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of blocks metadata details rels.
	 *
	 * @return the number of blocks metadata details rels
	 */
	@Override
	public int getBlocksMetadataDetailsRelsCount() {
		return _blocksMetadataDetailsRelLocalService.
			getBlocksMetadataDetailsRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _blocksMetadataDetailsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _blocksMetadataDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _blocksMetadataDetailsRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
			updateBlockMetadataDetailsRel(
				long blocksMetadataDetailsRelId, String blockNo,
				java.util.Date blockStartDate, java.util.Date blockEndDate,
				long progDurationTlBlocksLtId,
				com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _blocksMetadataDetailsRelLocalService.
			updateBlockMetadataDetailsRel(
				blocksMetadataDetailsRelId, blockNo, blockStartDate,
				blockEndDate, progDurationTlBlocksLtId, themeDisplay);
	}

	/**
	 * Updates the blocks metadata details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 * @return the blocks metadata details rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.BlocksMetadataDetailsRel
		updateBlocksMetadataDetailsRel(
			gov.omsb.tms.model.BlocksMetadataDetailsRel
				blocksMetadataDetailsRel) {

		return _blocksMetadataDetailsRelLocalService.
			updateBlocksMetadataDetailsRel(blocksMetadataDetailsRel);
	}

	@Override
	public BlocksMetadataDetailsRelLocalService getWrappedService() {
		return _blocksMetadataDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		BlocksMetadataDetailsRelLocalService
			blocksMetadataDetailsRelLocalService) {

		_blocksMetadataDetailsRelLocalService =
			blocksMetadataDetailsRelLocalService;
	}

	private BlocksMetadataDetailsRelLocalService
		_blocksMetadataDetailsRelLocalService;

}