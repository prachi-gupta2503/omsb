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
 * Provides a wrapper for {@link TraineeAdmissionDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRelLocalService
 * @generated
 */
public class TraineeAdmissionDetailsRelLocalServiceWrapper
	implements ServiceWrapper<TraineeAdmissionDetailsRelLocalService>,
			   TraineeAdmissionDetailsRelLocalService {

	public TraineeAdmissionDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public TraineeAdmissionDetailsRelLocalServiceWrapper(
		TraineeAdmissionDetailsRelLocalService
			traineeAdmissionDetailsRelLocalService) {

		_traineeAdmissionDetailsRelLocalService =
			traineeAdmissionDetailsRelLocalService;
	}

	/**
	 * Adds the trainee admission details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeAdmissionDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 * @return the trainee admission details rel that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		addTraineeAdmissionDetailsRel(
			gov.omsb.tms.model.TraineeAdmissionDetailsRel
				traineeAdmissionDetailsRel) {

		return _traineeAdmissionDetailsRelLocalService.
			addTraineeAdmissionDetailsRel(traineeAdmissionDetailsRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new trainee admission details rel with the primary key. Does not add the trainee admission details rel to the database.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key for the new trainee admission details rel
	 * @return the new trainee admission details rel
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		createTraineeAdmissionDetailsRel(long traineeAdmissionDetailsRelId) {

		return _traineeAdmissionDetailsRelLocalService.
			createTraineeAdmissionDetailsRel(traineeAdmissionDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trainee admission details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeAdmissionDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 * @throws PortalException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
			deleteTraineeAdmissionDetailsRel(long traineeAdmissionDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.
			deleteTraineeAdmissionDetailsRel(traineeAdmissionDetailsRelId);
	}

	/**
	 * Deletes the trainee admission details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeAdmissionDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		deleteTraineeAdmissionDetailsRel(
			gov.omsb.tms.model.TraineeAdmissionDetailsRel
				traineeAdmissionDetailsRel) {

		return _traineeAdmissionDetailsRelLocalService.
			deleteTraineeAdmissionDetailsRel(traineeAdmissionDetailsRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeAdmissionDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeAdmissionDetailsRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeAdmissionDetailsRelLocalService.dynamicQuery();
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

		return _traineeAdmissionDetailsRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeAdmissionDetailsRelModelImpl</code>.
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

		return _traineeAdmissionDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeAdmissionDetailsRelModelImpl</code>.
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

		return _traineeAdmissionDetailsRelLocalService.dynamicQuery(
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

		return _traineeAdmissionDetailsRelLocalService.dynamicQueryCount(
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

		return _traineeAdmissionDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		fetchTraineeAdmissionDetailsRel(long traineeAdmissionDetailsRelId) {

		return _traineeAdmissionDetailsRelLocalService.
			fetchTraineeAdmissionDetailsRel(traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns the trainee admission details rel matching the UUID and group.
	 *
	 * @param uuid the trainee admission details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		fetchTraineeAdmissionDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _traineeAdmissionDetailsRelLocalService.
			fetchTraineeAdmissionDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
		findByProgramDurationId(long programDurationId) {

		return _traineeAdmissionDetailsRelLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
		findByTraineeAdmissionDetailsRelIds(
			java.util.List<Long> traineeAdmissionDetailsRelIds) {

		return _traineeAdmissionDetailsRelLocalService.
			findByTraineeAdmissionDetailsRelIds(traineeAdmissionDetailsRelIds);
	}

	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel findByTraineeId(
		long traineeId) {

		return _traineeAdmissionDetailsRelLocalService.findByTraineeId(
			traineeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeAdmissionDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeAdmissionDetailsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeAdmissionDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeAdmissionDetailsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the trainee admission details rel with the primary key.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel
	 * @throws PortalException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
			getTraineeAdmissionDetailsRel(long traineeAdmissionDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRel(traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns the trainee admission details rel matching the UUID and group.
	 *
	 * @param uuid the trainee admission details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee admission details rel
	 * @throws PortalException if a matching trainee admission details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
			getTraineeAdmissionDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of trainee admission details rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
		getTraineeAdmissionDetailsRels(int start, int end) {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRels(start, end);
	}

	/**
	 * Returns all the trainee admission details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee admission details rels
	 * @param companyId the primary key of the company
	 * @return the matching trainee admission details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
		getTraineeAdmissionDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of trainee admission details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee admission details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee admission details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
		getTraineeAdmissionDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeAdmissionDetailsRel>
					orderByComparator) {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee admission details rels.
	 *
	 * @return the number of trainee admission details rels
	 */
	@Override
	public int getTraineeAdmissionDetailsRelsCount() {
		return _traineeAdmissionDetailsRelLocalService.
			getTraineeAdmissionDetailsRelsCount();
	}

	@Override
	public java.util.List<Long> getTraineeByProgramCohortAndTraineeLevel(
		long programDurationId, long traineeLevelId) {

		return _traineeAdmissionDetailsRelLocalService.
			getTraineeByProgramCohortAndTraineeLevel(
				programDurationId, traineeLevelId);
	}

	/**
	 * Updates the trainee admission details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeAdmissionDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 * @return the trainee admission details rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeAdmissionDetailsRel
		updateTraineeAdmissionDetailsRel(
			gov.omsb.tms.model.TraineeAdmissionDetailsRel
				traineeAdmissionDetailsRel) {

		return _traineeAdmissionDetailsRelLocalService.
			updateTraineeAdmissionDetailsRel(traineeAdmissionDetailsRel);
	}

	@Override
	public TraineeAdmissionDetailsRelLocalService getWrappedService() {
		return _traineeAdmissionDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeAdmissionDetailsRelLocalService
			traineeAdmissionDetailsRelLocalService) {

		_traineeAdmissionDetailsRelLocalService =
			traineeAdmissionDetailsRelLocalService;
	}

	private TraineeAdmissionDetailsRelLocalService
		_traineeAdmissionDetailsRelLocalService;

}