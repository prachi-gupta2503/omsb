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

import gov.omsb.tms.model.BlocksMetadataDetailsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BlocksMetadataDetailsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.BlocksMetadataDetailsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelLocalService
 * @generated
 */
public class BlocksMetadataDetailsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.BlocksMetadataDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static BlocksMetadataDetailsRel addBlocksMetadataDetailsRel(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return getService().addBlocksMetadataDetailsRel(
			blocksMetadataDetailsRel);
	}

	public static BlocksMetadataDetailsRel createBlockMetadataDetailsRel(
		String blockNo, java.util.Date blockStartDate,
		java.util.Date blockEndDate, long progDurationTlBlocksLtId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return getService().createBlockMetadataDetailsRel(
			blockNo, blockStartDate, blockEndDate, progDurationTlBlocksLtId,
			themeDisplay);
	}

	/**
	 * Creates a new blocks metadata details rel with the primary key. Does not add the blocks metadata details rel to the database.
	 *
	 * @param blocksMetadataDetailsRelId the primary key for the new blocks metadata details rel
	 * @return the new blocks metadata details rel
	 */
	public static BlocksMetadataDetailsRel createBlocksMetadataDetailsRel(
		long blocksMetadataDetailsRelId) {

		return getService().createBlocksMetadataDetailsRel(
			blocksMetadataDetailsRelId);
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
	 * Deletes the blocks metadata details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BlocksMetadataDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 */
	public static BlocksMetadataDetailsRel deleteBlocksMetadataDetailsRel(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return getService().deleteBlocksMetadataDetailsRel(
			blocksMetadataDetailsRel);
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
	public static BlocksMetadataDetailsRel deleteBlocksMetadataDetailsRel(
			long blocksMetadataDetailsRelId)
		throws PortalException {

		return getService().deleteBlocksMetadataDetailsRel(
			blocksMetadataDetailsRelId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl</code>.
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

	public static BlocksMetadataDetailsRel fetchBlocksMetadataDetailsRel(
		long blocksMetadataDetailsRelId) {

		return getService().fetchBlocksMetadataDetailsRel(
			blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel matching the UUID and group.
	 *
	 * @param uuid the blocks metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
		fetchBlocksMetadataDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchBlocksMetadataDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		return getService().findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId);
	}

	public static BlocksMetadataDetailsRel
		findByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, java.util.Date blockStartDate) {

		return getService().findByProgDurationTlBlocksLtIdAndBlockStartDate(
			progDurationTlBlocksLtId, blockStartDate);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the blocks metadata details rel with the primary key.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws PortalException if a blocks metadata details rel with the primary key could not be found
	 */
	public static BlocksMetadataDetailsRel getBlocksMetadataDetailsRel(
			long blocksMetadataDetailsRelId)
		throws PortalException {

		return getService().getBlocksMetadataDetailsRel(
			blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel matching the UUID and group.
	 *
	 * @param uuid the blocks metadata details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching blocks metadata details rel
	 * @throws PortalException if a matching blocks metadata details rel could not be found
	 */
	public static BlocksMetadataDetailsRel
			getBlocksMetadataDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getBlocksMetadataDetailsRelByUuidAndGroupId(
			uuid, groupId);
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
	public static List<BlocksMetadataDetailsRel> getBlocksMetadataDetailsRels(
		int start, int end) {

		return getService().getBlocksMetadataDetailsRels(start, end);
	}

	/**
	 * Returns all the blocks metadata details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the blocks metadata details rels
	 * @param companyId the primary key of the company
	 * @return the matching blocks metadata details rels, or an empty list if no matches were found
	 */
	public static List<BlocksMetadataDetailsRel>
		getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<BlocksMetadataDetailsRel>
		getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return getService().getBlocksMetadataDetailsRelsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of blocks metadata details rels.
	 *
	 * @return the number of blocks metadata details rels
	 */
	public static int getBlocksMetadataDetailsRelsCount() {
		return getService().getBlocksMetadataDetailsRelsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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

	public static BlocksMetadataDetailsRel updateBlockMetadataDetailsRel(
			long blocksMetadataDetailsRelId, String blockNo,
			java.util.Date blockStartDate, java.util.Date blockEndDate,
			long progDurationTlBlocksLtId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws PortalException {

		return getService().updateBlockMetadataDetailsRel(
			blocksMetadataDetailsRelId, blockNo, blockStartDate, blockEndDate,
			progDurationTlBlocksLtId, themeDisplay);
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
	public static BlocksMetadataDetailsRel updateBlocksMetadataDetailsRel(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		return getService().updateBlocksMetadataDetailsRel(
			blocksMetadataDetailsRel);
	}

	public static BlocksMetadataDetailsRelLocalService getService() {
		return _service;
	}

	private static volatile BlocksMetadataDetailsRelLocalService _service;

}