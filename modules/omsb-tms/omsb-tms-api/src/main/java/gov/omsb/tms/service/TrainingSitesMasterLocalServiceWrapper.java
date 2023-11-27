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
 * Provides a wrapper for {@link TrainingSitesMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMasterLocalService
 * @generated
 */
public class TrainingSitesMasterLocalServiceWrapper
	implements ServiceWrapper<TrainingSitesMasterLocalService>,
			   TrainingSitesMasterLocalService {

	public TrainingSitesMasterLocalServiceWrapper() {
		this(null);
	}

	public TrainingSitesMasterLocalServiceWrapper(
		TrainingSitesMasterLocalService trainingSitesMasterLocalService) {

		_trainingSitesMasterLocalService = trainingSitesMasterLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster addTrainingSitesMaster(
		gov.omsb.tms.model.TrainingSitesMaster trainingSitesMaster) {

		return _trainingSitesMasterLocalService.addTrainingSitesMaster(
			trainingSitesMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster createTrainingSitesMaster(
		long trainingSiteMasterId) {

		return _trainingSitesMasterLocalService.createTrainingSitesMaster(
			trainingSiteMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster deleteTrainingSitesMaster(
			long trainingSiteMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.deleteTrainingSitesMaster(
			trainingSiteMasterId);
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
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster deleteTrainingSitesMaster(
		gov.omsb.tms.model.TrainingSitesMaster trainingSitesMaster) {

		return _trainingSitesMasterLocalService.deleteTrainingSitesMaster(
			trainingSitesMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _trainingSitesMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _trainingSitesMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingSitesMasterLocalService.dynamicQuery();
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

		return _trainingSitesMasterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _trainingSitesMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _trainingSitesMasterLocalService.dynamicQuery(
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

		return _trainingSitesMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _trainingSitesMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TrainingSitesMaster fetchTrainingSitesMaster(
		long trainingSiteMasterId) {

		return _trainingSitesMasterLocalService.fetchTrainingSitesMaster(
			trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster
		fetchTrainingSitesMasterByUuidAndGroupId(String uuid, long groupId) {

		return _trainingSitesMasterLocalService.
			fetchTrainingSitesMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		findByProgramStatus(Boolean trainingSiteStatus) {

		return _trainingSitesMasterLocalService.findByProgramStatus(
			trainingSiteStatus);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		findByTrainingSiteCodeByLike(String trainingSiteCode) {

		return _trainingSitesMasterLocalService.findByTrainingSiteCodeByLike(
			trainingSiteCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		findByTrainingSiteMasterIds(java.util.List<Long> trainingSiteIds) {

		return _trainingSitesMasterLocalService.findByTrainingSiteMasterIds(
			trainingSiteIds);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		findByTrainingSiteNameByLike(String trainingSiteName) {

		return _trainingSitesMasterLocalService.findByTrainingSiteNameByLike(
			trainingSiteName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingSitesMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _trainingSitesMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingSitesMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingSitesMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO>
			getProgdurationRotationByRotationAndDuration(
				long rotationId, String duration, String languageCode) {

		return _trainingSitesMasterLocalService.
			getProgdurationRotationByRotationAndDuration(
				rotationId, duration, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		getTrainigSitesListByIdsAndStatus(
			java.util.List<Long> ids, Boolean status) {

		return _trainingSitesMasterLocalService.
			getTrainigSitesListByIdsAndStatus(ids, status);
	}

	@Override
	public gov.omsb.tms.model.TrainingSitesMaster
		getTrainingSiteByDatePerformed(String datePerformed, long traineeId) {

		return _trainingSitesMasterLocalService.getTrainingSiteByDatePerformed(
			datePerformed, traineeId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO>
			getTrainingSiteNameWithRotation(
				String languageCode, long programId) {

		return _trainingSitesMasterLocalService.getTrainingSiteNameWithRotation(
			languageCode, programId);
	}

	/**
	 * Returns the training sites master with the primary key.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws PortalException if a training sites master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster getTrainingSitesMaster(
			long trainingSiteMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.getTrainingSitesMaster(
			trainingSiteMasterId);
	}

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master
	 * @throws PortalException if a matching training sites master could not be found
	 */
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster
			getTrainingSitesMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingSitesMasterLocalService.
			getTrainingSitesMasterByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		getTrainingSitesMasters(int start, int end) {

		return _trainingSitesMasterLocalService.getTrainingSitesMasters(
			start, end);
	}

	/**
	 * Returns all the training sites masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the training sites masters
	 * @param companyId the primary key of the company
	 * @return the matching training sites masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		getTrainingSitesMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _trainingSitesMasterLocalService.
			getTrainingSitesMastersByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.TrainingSitesMaster>
		getTrainingSitesMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TrainingSitesMaster> orderByComparator) {

		return _trainingSitesMasterLocalService.
			getTrainingSitesMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
	 */
	@Override
	public int getTrainingSitesMastersCount() {
		return _trainingSitesMasterLocalService.getTrainingSitesMastersCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteStructureDTO>
		getTrainingSiteStructure(
			java.util.List<Long> programMasterIds, String programDuration,
			long trainingSiteId, String languageCode) {

		return _trainingSitesMasterLocalService.getTrainingSiteStructure(
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
	@Override
	public gov.omsb.tms.model.TrainingSitesMaster updateTrainingSitesMaster(
		gov.omsb.tms.model.TrainingSitesMaster trainingSitesMaster) {

		return _trainingSitesMasterLocalService.updateTrainingSitesMaster(
			trainingSitesMaster);
	}

	@Override
	public TrainingSitesMasterLocalService getWrappedService() {
		return _trainingSitesMasterLocalService;
	}

	@Override
	public void setWrappedService(
		TrainingSitesMasterLocalService trainingSitesMasterLocalService) {

		_trainingSitesMasterLocalService = trainingSitesMasterLocalService;
	}

	private TrainingSitesMasterLocalService _trainingSitesMasterLocalService;

}