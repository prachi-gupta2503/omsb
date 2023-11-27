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
 * Provides a wrapper for {@link TraineeElectiverotationPriorityDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeElectiverotationPriorityDetailsLocalService
 * @generated
 */
public class TraineeElectiverotationPriorityDetailsLocalServiceWrapper
	implements ServiceWrapper
		<TraineeElectiverotationPriorityDetailsLocalService>,
			   TraineeElectiverotationPriorityDetailsLocalService {

	public TraineeElectiverotationPriorityDetailsLocalServiceWrapper() {
		this(null);
	}

	public TraineeElectiverotationPriorityDetailsLocalServiceWrapper(
		TraineeElectiverotationPriorityDetailsLocalService
			traineeElectiverotationPriorityDetailsLocalService) {

		_traineeElectiverotationPriorityDetailsLocalService =
			traineeElectiverotationPriorityDetailsLocalService;
	}

	/**
	 * Adds the trainee electiverotation priority details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		addTraineeElectiverotationPriorityDetails(
			gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			addTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trainee electiverotation priority details with the primary key. Does not add the trainee electiverotation priority details to the database.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key for the new trainee electiverotation priority details
	 * @return the new trainee electiverotation priority details
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		createTraineeElectiverotationPriorityDetails(
			long traineeElectiverotationPriorityDetailsId) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			createTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws PortalException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
			deleteTraineeElectiverotationPriorityDetails(
				long traineeElectiverotationPriorityDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			deleteTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Deletes the trainee electiverotation priority details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		deleteTraineeElectiverotationPriorityDetails(
			gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			deleteTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeElectiverotationPriorityDetailsLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeElectiverotationPriorityDetailsLocalService.
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

		return _traineeElectiverotationPriorityDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
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

		return _traineeElectiverotationPriorityDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
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

		return _traineeElectiverotationPriorityDetailsLocalService.dynamicQuery(
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

		return _traineeElectiverotationPriorityDetailsLocalService.
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

		return _traineeElectiverotationPriorityDetailsLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		fetchTraineeElectiverotationPriorityDetails(
			long traineeElectiverotationPriorityDetailsId) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			fetchTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details matching the UUID and group.
	 *
	 * @param uuid the trainee electiverotation priority details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		fetchTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			fetchTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeElectiverotationPriorityDetails>
			findByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			findByTraineePdTlErDetailsId(traineePdTlErDetailsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeElectiverotationPriorityDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws PortalException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
			getTraineeElectiverotationPriorityDetails(
				long traineeElectiverotationPriorityDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details matching the UUID and group.
	 *
	 * @param uuid the trainee electiverotation priority details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee electiverotation priority details
	 * @throws PortalException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
			getTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetailsByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of trainee electiverotation priority detailses
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeElectiverotationPriorityDetails>
			getTraineeElectiverotationPriorityDetailses(int start, int end) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetailses(start, end);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee electiverotation priority detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee electiverotation priority detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeElectiverotationPriorityDetails>
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee electiverotation priority detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee electiverotation priority detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee electiverotation priority detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.TraineeElectiverotationPriorityDetails>
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.TraineeElectiverotationPriorityDetails>
						orderByComparator) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses.
	 *
	 * @return the number of trainee electiverotation priority detailses
	 */
	@Override
	public int getTraineeElectiverotationPriorityDetailsesCount() {
		return _traineeElectiverotationPriorityDetailsLocalService.
			getTraineeElectiverotationPriorityDetailsesCount();
	}

	/**
	 * Updates the trainee electiverotation priority details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeElectiverotationPriorityDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
		updateTraineeElectiverotationPriorityDetails(
			gov.omsb.tms.model.TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails) {

		return _traineeElectiverotationPriorityDetailsLocalService.
			updateTraineeElectiverotationPriorityDetails(
				traineeElectiverotationPriorityDetails);
	}

	@Override
	public TraineeElectiverotationPriorityDetailsLocalService
		getWrappedService() {

		return _traineeElectiverotationPriorityDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeElectiverotationPriorityDetailsLocalService
			traineeElectiverotationPriorityDetailsLocalService) {

		_traineeElectiverotationPriorityDetailsLocalService =
			traineeElectiverotationPriorityDetailsLocalService;
	}

	private TraineeElectiverotationPriorityDetailsLocalService
		_traineeElectiverotationPriorityDetailsLocalService;

}