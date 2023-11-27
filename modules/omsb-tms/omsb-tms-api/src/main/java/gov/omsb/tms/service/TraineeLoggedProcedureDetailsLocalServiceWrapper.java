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
 * Provides a wrapper for {@link TraineeLoggedProcedureDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLoggedProcedureDetailsLocalService
 * @generated
 */
public class TraineeLoggedProcedureDetailsLocalServiceWrapper
	implements ServiceWrapper<TraineeLoggedProcedureDetailsLocalService>,
			   TraineeLoggedProcedureDetailsLocalService {

	public TraineeLoggedProcedureDetailsLocalServiceWrapper() {
		this(null);
	}

	public TraineeLoggedProcedureDetailsLocalServiceWrapper(
		TraineeLoggedProcedureDetailsLocalService
			traineeLoggedProcedureDetailsLocalService) {

		_traineeLoggedProcedureDetailsLocalService =
			traineeLoggedProcedureDetailsLocalService;
	}

	/**
	 * Adds the trainee logged procedure details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		addTraineeLoggedProcedureDetails(
			gov.omsb.tms.model.TraineeLoggedProcedureDetails
				traineeLoggedProcedureDetails) {

		return _traineeLoggedProcedureDetailsLocalService.
			addTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new trainee logged procedure details with the primary key. Does not add the trainee logged procedure details to the database.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key for the new trainee logged procedure details
	 * @return the new trainee logged procedure details
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		createTraineeLoggedProcedureDetails(
			long traineeLoggedProcedureDetailsId) {

		return _traineeLoggedProcedureDetailsLocalService.
			createTraineeLoggedProcedureDetails(
				traineeLoggedProcedureDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws PortalException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
			deleteTraineeLoggedProcedureDetails(
				long traineeLoggedProcedureDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.
			deleteTraineeLoggedProcedureDetails(
				traineeLoggedProcedureDetailsId);
	}

	/**
	 * Deletes the trainee logged procedure details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		deleteTraineeLoggedProcedureDetails(
			gov.omsb.tms.model.TraineeLoggedProcedureDetails
				traineeLoggedProcedureDetails) {

		return _traineeLoggedProcedureDetailsLocalService.
			deleteTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeLoggedProcedureDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeLoggedProcedureDetailsLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeLoggedProcedureDetailsLocalService.dynamicQuery();
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

		return _traineeLoggedProcedureDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
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

		return _traineeLoggedProcedureDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
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

		return _traineeLoggedProcedureDetailsLocalService.dynamicQuery(
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

		return _traineeLoggedProcedureDetailsLocalService.dynamicQueryCount(
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

		return _traineeLoggedProcedureDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		fetchTraineeLoggedProcedureDetails(
			long traineeLoggedProcedureDetailsId) {

		return _traineeLoggedProcedureDetailsLocalService.
			fetchTraineeLoggedProcedureDetails(traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns the trainee logged procedure details matching the UUID and group.
	 *
	 * @param uuid the trainee logged procedure details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		fetchTraineeLoggedProcedureDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _traineeLoggedProcedureDetailsLocalService.
			fetchTraineeLoggedProcedureDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		findByPatientIdByLike(String patientId) {

		return _traineeLoggedProcedureDetailsLocalService.findByPatientIdByLike(
			patientId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		findByTraineeId(long traineeId) {

		return _traineeLoggedProcedureDetailsLocalService.findByTraineeId(
			traineeId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		findTraineeLoggedProcedureDetailsByPatientId(String patientId) {

		return _traineeLoggedProcedureDetailsLocalService.
			findTraineeLoggedProcedureDetailsByPatientId(patientId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeLoggedProcedureDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeLoggedProcedureDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeLoggedProcedureDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeLoggedProcedureDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public long getRotationIdByDatePerformed(
		String datePerformed, long traineeId) {

		return _traineeLoggedProcedureDetailsLocalService.
			getRotationIdByDatePerformed(datePerformed, traineeId);
	}

	@Override
	public gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO
		getTraineeLoggedProcedureDetail(
			long supervisorId, long traineeLoggedProcedureDetailsId,
			String languageCode) {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetail(
				supervisorId, traineeLoggedProcedureDetailsId, languageCode);
	}

	/**
	 * Returns the trainee logged procedure details with the primary key.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws PortalException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
			getTraineeLoggedProcedureDetails(
				long traineeLoggedProcedureDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetails(traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns the trainee logged procedure details matching the UUID and group.
	 *
	 * @param uuid the trainee logged procedure details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee logged procedure details
	 * @throws PortalException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
			getTraineeLoggedProcedureDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of trainee logged procedure detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailses(int start, int end) {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailses(start, end);
	}

	/**
	 * Returns all the trainee logged procedure detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee logged procedure detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee logged procedure detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of trainee logged procedure detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee logged procedure detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee logged procedure detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
		getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeLoggedProcedureDetails>
					orderByComparator) {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee logged procedure detailses.
	 *
	 * @return the number of trainee logged procedure detailses
	 */
	@Override
	public int getTraineeLoggedProcedureDetailsesCount() {
		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailsesCount();
	}

	@Override
	public java.util.List
		<gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO>
			getTraineeLoggedProcedureDetailsList(
				boolean isSuperVisor, boolean getByDedicatedProgram,
				long supervisorId, String programIds, String languageCode) {

		return _traineeLoggedProcedureDetailsLocalService.
			getTraineeLoggedProcedureDetailsList(
				isSuperVisor, getByDedicatedProgram, supervisorId, programIds,
				languageCode);
	}

	/**
	 * Updates the trainee logged procedure details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLoggedProcedureDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 * @return the trainee logged procedure details that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeLoggedProcedureDetails
		updateTraineeLoggedProcedureDetails(
			gov.omsb.tms.model.TraineeLoggedProcedureDetails
				traineeLoggedProcedureDetails) {

		return _traineeLoggedProcedureDetailsLocalService.
			updateTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);
	}

	@Override
	public TraineeLoggedProcedureDetailsLocalService getWrappedService() {
		return _traineeLoggedProcedureDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeLoggedProcedureDetailsLocalService
			traineeLoggedProcedureDetailsLocalService) {

		_traineeLoggedProcedureDetailsLocalService =
			traineeLoggedProcedureDetailsLocalService;
	}

	private TraineeLoggedProcedureDetailsLocalService
		_traineeLoggedProcedureDetailsLocalService;

}