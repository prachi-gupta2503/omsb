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

import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TraineeRotationTsBlockDetailsRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.TraineeRotationTsBlockDetailsRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRelLocalService
 * @generated
 */
public class TraineeRotationTsBlockDetailsRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeRotationTsBlockDetailsRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the trainee rotation ts block details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was added
	 */
	public static TraineeRotationTsBlockDetailsRel
		addTraineeRotationTsBlockDetailsRel(
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		return getService().addTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRel);
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
	 * Creates a new trainee rotation ts block details rel with the primary key. Does not add the trainee rotation ts block details rel to the database.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key for the new trainee rotation ts block details rel
	 * @return the new trainee rotation ts block details rel
	 */
	public static TraineeRotationTsBlockDetailsRel
		createTraineeRotationTsBlockDetailsRel(
			long traineeRotationTsBlockDetailsRelId) {

		return getService().createTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trainee rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 * @throws PortalException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			deleteTraineeRotationTsBlockDetailsRel(
				long traineeRotationTsBlockDetailsRelId)
		throws PortalException {

		return getService().deleteTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Deletes the trainee rotation ts block details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 */
	public static TraineeRotationTsBlockDetailsRel
		deleteTraineeRotationTsBlockDetailsRel(
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		return getService().deleteTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeRotationTsBlockDetailsRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeRotationTsBlockDetailsRelModelImpl</code>.
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

	public static TraineeRotationTsBlockDetailsRel
		fetchTraineeRotationTsBlockDetailsRel(
			long traineeRotationTsBlockDetailsRelId) {

		return getService().fetchTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the trainee rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
		fetchTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {

		return getService().findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);
	}

	public static List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return getService().findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);
	}

	public static List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId) {

		return getService().findByTraineeId(traineeId);
	}

	public static TraineeRotationTsBlockDetailsRel
		findByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId) {

		return getService().findByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId);
	}

	public static List<TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(long traineeId, String status) {

		return getService().findByTraineeIdAndStatus(traineeId, status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	/**
	 * Returns the trainee rotation ts block details rel with the primary key.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws PortalException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			getTraineeRotationTsBlockDetailsRel(
				long traineeRotationTsBlockDetailsRelId)
		throws PortalException {

		return getService().getTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the trainee rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee rotation ts block details rel
	 * @throws PortalException if a matching trainee rotation ts block details rel could not be found
	 */
	public static TraineeRotationTsBlockDetailsRel
			getTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of trainee rotation ts block details rels
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRels(int start, int end) {

		return getService().getTraineeRotationTsBlockDetailsRels(start, end);
	}

	/**
	 * Returns all the trainee rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @return the matching trainee rotation ts block details rels, or an empty list if no matches were found
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee rotation ts block details rels, or an empty list if no matches were found
	 */
	public static List<TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return getService().
			getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels.
	 *
	 * @return the number of trainee rotation ts block details rels
	 */
	public static int getTraineeRotationTsBlockDetailsRelsCount() {
		return getService().getTraineeRotationTsBlockDetailsRelsCount();
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO>
		getTrainingSiteByRotation(
			List<Long> programIds, String languageCode, long progDurationId) {

		return getService().getTrainingSiteByRotation(
			programIds, languageCode, progDurationId);
	}

	/**
	 * Updates the trainee rotation ts block details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was updated
	 */
	public static TraineeRotationTsBlockDetailsRel
		updateTraineeRotationTsBlockDetailsRel(
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		return getService().updateTraineeRotationTsBlockDetailsRel(
			traineeRotationTsBlockDetailsRel);
	}

	public static TraineeRotationTsBlockDetailsRelLocalService getService() {
		return _service;
	}

	private static volatile TraineeRotationTsBlockDetailsRelLocalService
		_service;

}