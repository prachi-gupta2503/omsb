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
 * Provides a wrapper for {@link TraineeProgdurationTraineelevelDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeProgdurationTraineelevelDetailsLocalService
 * @generated
 */
public class TraineeProgdurationTraineelevelDetailsLocalServiceWrapper
	implements ServiceWrapper
		<TraineeProgdurationTraineelevelDetailsLocalService>,
			   TraineeProgdurationTraineelevelDetailsLocalService {

	public TraineeProgdurationTraineelevelDetailsLocalServiceWrapper() {
		this(null);
	}

	public TraineeProgdurationTraineelevelDetailsLocalServiceWrapper(
		TraineeProgdurationTraineelevelDetailsLocalService
			traineeProgdurationTraineelevelDetailsLocalService) {

		_traineeProgdurationTraineelevelDetailsLocalService =
			traineeProgdurationTraineelevelDetailsLocalService;
	}

	/**
	 * Adds the trainee progduration traineelevel details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		addTraineeProgdurationTraineelevelDetails(
			gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			addTraineeProgdurationTraineelevelDetails(
				traineeProgdurationTraineelevelDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trainee progduration traineelevel details with the primary key. Does not add the trainee progduration traineelevel details to the database.
	 *
	 * @param traineePdTlErDetailsId the primary key for the new trainee progduration traineelevel details
	 * @return the new trainee progduration traineelevel details
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		createTraineeProgdurationTraineelevelDetails(
			long traineePdTlErDetailsId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			createTraineeProgdurationTraineelevelDetails(
				traineePdTlErDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws PortalException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
			deleteTraineeProgdurationTraineelevelDetails(
				long traineePdTlErDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			deleteTraineeProgdurationTraineelevelDetails(
				traineePdTlErDetailsId);
	}

	/**
	 * Deletes the trainee progduration traineelevel details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		deleteTraineeProgdurationTraineelevelDetails(
			gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			deleteTraineeProgdurationTraineelevelDetails(
				traineeProgdurationTraineelevelDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeProgdurationTraineelevelDetailsLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeProgdurationTraineelevelDetailsLocalService.
			dynamicQuery();
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

		return _traineeProgdurationTraineelevelDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
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

		return _traineeProgdurationTraineelevelDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
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

		return _traineeProgdurationTraineelevelDetailsLocalService.dynamicQuery(
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

		return _traineeProgdurationTraineelevelDetailsLocalService.
			dynamicQueryCount(dynamicQuery);
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

		return _traineeProgdurationTraineelevelDetailsLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		fetchTraineeProgdurationTraineelevelDetails(
			long traineePdTlErDetailsId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			fetchTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details matching the UUID and group.
	 *
	 * @param uuid the trainee progduration traineelevel details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		fetchTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			fetchTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
			findByTraineeId(long traineeId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			findByTraineeId(traineeId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
			findByTraineeIdAndProgramDurationId(
				long traineeId, long programDurationId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			findByTraineeIdAndProgramDurationId(traineeId, programDurationId);
	}

	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		findByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			findByTraineeIdAndTraineeLevelId(traineeId, traineeLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeProgdurationTraineelevelDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws PortalException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
			getTraineeProgdurationTraineelevelDetails(
				long traineePdTlErDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetails(traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details matching the UUID and group.
	 *
	 * @param uuid the trainee progduration traineelevel details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee progduration traineelevel details
	 * @throws PortalException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
			getTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of trainee progduration traineelevel detailses
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
			getTraineeProgdurationTraineelevelDetailses(int start, int end) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetailses(start, end);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee progduration traineelevel detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee progduration traineelevel detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee progduration traineelevel detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee progduration traineelevel detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee progduration traineelevel detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails>
						orderByComparator) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses.
	 *
	 * @return the number of trainee progduration traineelevel detailses
	 */
	@Override
	public int getTraineeProgdurationTraineelevelDetailsesCount() {
		return _traineeProgdurationTraineelevelDetailsLocalService.
			getTraineeProgdurationTraineelevelDetailsesCount();
	}

	/**
	 * Updates the trainee progduration traineelevel details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeProgdurationTraineelevelDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
		updateTraineeProgdurationTraineelevelDetails(
			gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails) {

		return _traineeProgdurationTraineelevelDetailsLocalService.
			updateTraineeProgdurationTraineelevelDetails(
				traineeProgdurationTraineelevelDetails);
	}

	@Override
	public TraineeProgdurationTraineelevelDetailsLocalService
		getWrappedService() {

		return _traineeProgdurationTraineelevelDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeProgdurationTraineelevelDetailsLocalService
			traineeProgdurationTraineelevelDetailsLocalService) {

		_traineeProgdurationTraineelevelDetailsLocalService =
			traineeProgdurationTraineelevelDetailsLocalService;
	}

	private TraineeProgdurationTraineelevelDetailsLocalService
		_traineeProgdurationTraineelevelDetailsLocalService;

}