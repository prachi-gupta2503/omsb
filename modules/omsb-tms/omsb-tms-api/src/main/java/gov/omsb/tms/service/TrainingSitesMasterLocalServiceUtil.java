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

import gov.omsb.tms.model.TrainingSitesMaster;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TrainingSitesMaster. This utility wraps
 * <code>gov.omsb.tms.service.impl.TrainingSitesMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMasterLocalService
 * @generated
 */
public class TrainingSitesMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TrainingSitesMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the training sites master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was added
	 */
	public static TrainingSitesMaster addTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster) {

		return getService().addTrainingSitesMaster(trainingSitesMaster);
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
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	public static TrainingSitesMaster createTrainingSitesMaster(
		long trainingSiteMasterId) {

		return getService().createTrainingSitesMaster(trainingSiteMasterId);
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
	 * Deletes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws PortalException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster deleteTrainingSitesMaster(
			long trainingSiteMasterId)
		throws PortalException {

		return getService().deleteTrainingSitesMaster(trainingSiteMasterId);
	}

	/**
	 * Deletes the training sites master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was removed
	 */
	public static TrainingSitesMaster deleteTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster) {

		return getService().deleteTrainingSitesMaster(trainingSitesMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
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

	public static TrainingSitesMaster fetchTrainingSitesMaster(
		long trainingSiteMasterId) {

		return getService().fetchTrainingSitesMaster(trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster fetchTrainingSitesMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTrainingSitesMasterByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<TrainingSitesMaster> findByProgramStatus(
		Boolean trainingSiteStatus) {

		return getService().findByProgramStatus(trainingSiteStatus);
	}

	public static List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode) {

		return getService().findByTrainingSiteCodeByLike(trainingSiteCode);
	}

	public static List<TrainingSitesMaster> findByTrainingSiteMasterIds(
		List<Long> trainingSiteIds) {

		return getService().findByTrainingSiteMasterIds(trainingSiteIds);
	}

	public static List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName) {

		return getService().findByTrainingSiteNameByLike(trainingSiteName);
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

	public static List
		<gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO>
			getProgdurationRotationByRotationAndDuration(
				long rotationId, String duration, String languageCode) {

		return getService().getProgdurationRotationByRotationAndDuration(
			rotationId, duration, languageCode);
	}

	public static List<TrainingSitesMaster> getTrainigSitesListByIdsAndStatus(
		List<Long> ids, Boolean status) {

		return getService().getTrainigSitesListByIdsAndStatus(ids, status);
	}

	public static TrainingSitesMaster getTrainingSiteByDatePerformed(
		String datePerformed, long traineeId) {

		return getService().getTrainingSiteByDatePerformed(
			datePerformed, traineeId);
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO>
		getTrainingSiteNameWithRotation(String languageCode, long programId) {

		return getService().getTrainingSiteNameWithRotation(
			languageCode, programId);
	}

	/**
	 * Returns the training sites master with the primary key.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws PortalException if a training sites master with the primary key could not be found
	 */
	public static TrainingSitesMaster getTrainingSitesMaster(
			long trainingSiteMasterId)
		throws PortalException {

		return getService().getTrainingSitesMaster(trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master
	 * @throws PortalException if a matching training sites master could not be found
	 */
	public static TrainingSitesMaster getTrainingSitesMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTrainingSitesMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of training sites masters
	 */
	public static List<TrainingSitesMaster> getTrainingSitesMasters(
		int start, int end) {

		return getService().getTrainingSitesMasters(start, end);
	}

	/**
	 * Returns all the training sites masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the training sites masters
	 * @param companyId the primary key of the company
	 * @return the matching training sites masters, or an empty list if no matches were found
	 */
	public static List<TrainingSitesMaster>
		getTrainingSitesMastersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getTrainingSitesMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of training sites masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the training sites masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching training sites masters, or an empty list if no matches were found
	 */
	public static List<TrainingSitesMaster>
		getTrainingSitesMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<TrainingSitesMaster> orderByComparator) {

		return getService().getTrainingSitesMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
	 */
	public static int getTrainingSitesMastersCount() {
		return getService().getTrainingSitesMastersCount();
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteStructureDTO>
		getTrainingSiteStructure(
			List<Long> programMasterIds, String programDuration,
			long trainingSiteId, String languageCode) {

		return getService().getTrainingSiteStructure(
			programMasterIds, programDuration, trainingSiteId, languageCode);
	}

	/**
	 * Updates the training sites master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was updated
	 */
	public static TrainingSitesMaster updateTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster) {

		return getService().updateTrainingSitesMaster(trainingSitesMaster);
	}

	public static TrainingSitesMasterLocalService getService() {
		return _service;
	}

	private static volatile TrainingSitesMasterLocalService _service;

}