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
 * Provides a wrapper for {@link TraineeRotationTsBlockDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeRotationTsBlockDetailsRelLocalService
 * @generated
 */
public class TraineeRotationTsBlockDetailsRelLocalServiceWrapper
	implements ServiceWrapper<TraineeRotationTsBlockDetailsRelLocalService>,
			   TraineeRotationTsBlockDetailsRelLocalService {

	public TraineeRotationTsBlockDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public TraineeRotationTsBlockDetailsRelLocalServiceWrapper(
		TraineeRotationTsBlockDetailsRelLocalService
			traineeRotationTsBlockDetailsRelLocalService) {

		_traineeRotationTsBlockDetailsRelLocalService =
			traineeRotationTsBlockDetailsRelLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		addTraineeRotationTsBlockDetailsRel(
			gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
				traineeRotationTsBlockDetailsRel) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			addTraineeRotationTsBlockDetailsRel(
				traineeRotationTsBlockDetailsRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trainee rotation ts block details rel with the primary key. Does not add the trainee rotation ts block details rel to the database.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key for the new trainee rotation ts block details rel
	 * @return the new trainee rotation ts block details rel
	 */
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		createTraineeRotationTsBlockDetailsRel(
			long traineeRotationTsBlockDetailsRelId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			createTraineeRotationTsBlockDetailsRel(
				traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.
			deletePersistedModel(persistedModel);
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
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
			deleteTraineeRotationTsBlockDetailsRel(
				long traineeRotationTsBlockDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.
			deleteTraineeRotationTsBlockDetailsRel(
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
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		deleteTraineeRotationTsBlockDetailsRel(
			gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
				traineeRotationTsBlockDetailsRel) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			deleteTraineeRotationTsBlockDetailsRel(
				traineeRotationTsBlockDetailsRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeRotationTsBlockDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeRotationTsBlockDetailsRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQuery();
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

		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQuery(
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

		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQueryCount(
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

		return _traineeRotationTsBlockDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		fetchTraineeRotationTsBlockDetailsRel(
			long traineeRotationTsBlockDetailsRelId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			fetchTraineeRotationTsBlockDetailsRel(
				traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the trainee rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		fetchTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			fetchTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			findByBlocksMetadataDetailsRelId(blocksMetadataDetailsRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			findByProgDurationRotationTsRelId(progDurationRotationTsRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		findByTraineeId(long traineeId) {

		return _traineeRotationTsBlockDetailsRelLocalService.findByTraineeId(
			traineeId);
	}

	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		findByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			findByTraineeIdAndBlocksMetadataDetailsRelId(
				traineeId, blocksMetadataDetailsRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		findByTraineeIdAndStatus(long traineeId, String status) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			findByTraineeIdAndStatus(traineeId, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeRotationTsBlockDetailsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws PortalException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
			getTraineeRotationTsBlockDetailsRel(
				long traineeRotationTsBlockDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getTraineeRotationTsBlockDetailsRel(
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
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
			getTraineeRotationTsBlockDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getTraineeRotationTsBlockDetailsRelByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRels(int start, int end) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getTraineeRotationTsBlockDetailsRels(start, end);
	}

	/**
	 * Returns all the trainee rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @return the matching trainee rotation ts block details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
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
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
		getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel>
					orderByComparator) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getTraineeRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels.
	 *
	 * @return the number of trainee rotation ts block details rels
	 */
	@Override
	public int getTraineeRotationTsBlockDetailsRelsCount() {
		return _traineeRotationTsBlockDetailsRelLocalService.
			getTraineeRotationTsBlockDetailsRelsCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO>
		getTrainingSiteByRotation(
			java.util.List<Long> programIds, String languageCode,
			long progDurationId) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			getTrainingSiteByRotation(programIds, languageCode, progDurationId);
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
	@Override
	public gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
		updateTraineeRotationTsBlockDetailsRel(
			gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel
				traineeRotationTsBlockDetailsRel) {

		return _traineeRotationTsBlockDetailsRelLocalService.
			updateTraineeRotationTsBlockDetailsRel(
				traineeRotationTsBlockDetailsRel);
	}

	@Override
	public TraineeRotationTsBlockDetailsRelLocalService getWrappedService() {
		return _traineeRotationTsBlockDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeRotationTsBlockDetailsRelLocalService
			traineeRotationTsBlockDetailsRelLocalService) {

		_traineeRotationTsBlockDetailsRelLocalService =
			traineeRotationTsBlockDetailsRelLocalService;
	}

	private TraineeRotationTsBlockDetailsRelLocalService
		_traineeRotationTsBlockDetailsRelLocalService;

}