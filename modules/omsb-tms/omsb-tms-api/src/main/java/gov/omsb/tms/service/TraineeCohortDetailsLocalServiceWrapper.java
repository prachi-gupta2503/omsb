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
 * Provides a wrapper for {@link TraineeCohortDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeCohortDetailsLocalService
 * @generated
 */
public class TraineeCohortDetailsLocalServiceWrapper
	implements ServiceWrapper<TraineeCohortDetailsLocalService>,
			   TraineeCohortDetailsLocalService {

	public TraineeCohortDetailsLocalServiceWrapper() {
		this(null);
	}

	public TraineeCohortDetailsLocalServiceWrapper(
		TraineeCohortDetailsLocalService traineeCohortDetailsLocalService) {

		_traineeCohortDetailsLocalService = traineeCohortDetailsLocalService;
	}

	/**
	 * Adds the trainee cohort details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails addTraineeCohortDetails(
		gov.omsb.tms.model.TraineeCohortDetails traineeCohortDetails) {

		return _traineeCohortDetailsLocalService.addTraineeCohortDetails(
			traineeCohortDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new trainee cohort details with the primary key. Does not add the trainee cohort details to the database.
	 *
	 * @param traineeCohortDetailsId the primary key for the new trainee cohort details
	 * @return the new trainee cohort details
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails createTraineeCohortDetails(
		long traineeCohortDetailsId) {

		return _traineeCohortDetailsLocalService.createTraineeCohortDetails(
			traineeCohortDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws PortalException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails deleteTraineeCohortDetails(
			long traineeCohortDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.deleteTraineeCohortDetails(
			traineeCohortDetailsId);
	}

	/**
	 * Deletes the trainee cohort details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails deleteTraineeCohortDetails(
		gov.omsb.tms.model.TraineeCohortDetails traineeCohortDetails) {

		return _traineeCohortDetailsLocalService.deleteTraineeCohortDetails(
			traineeCohortDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeCohortDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeCohortDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeCohortDetailsLocalService.dynamicQuery();
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

		return _traineeCohortDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
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

		return _traineeCohortDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
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

		return _traineeCohortDetailsLocalService.dynamicQuery(
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

		return _traineeCohortDetailsLocalService.dynamicQueryCount(
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

		return _traineeCohortDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeCohortDetails fetchTraineeCohortDetails(
		long traineeCohortDetailsId) {

		return _traineeCohortDetailsLocalService.fetchTraineeCohortDetails(
			traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details matching the UUID and group.
	 *
	 * @param uuid the trainee cohort details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails
		fetchTraineeCohortDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _traineeCohortDetailsLocalService.
			fetchTraineeCohortDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelId(long traineeAdmissionDetailsRelId) {

		return _traineeCohortDetailsLocalService.
			findByTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		return _traineeCohortDetailsLocalService.
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);
	}

	@Override
	public gov.omsb.tms.model.TraineeCohortDetails
		findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId) {

		return _traineeCohortDetailsLocalService.
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeCohortDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeCohortDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeCohortDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeCohortDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the trainee cohort details with the primary key.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws PortalException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails getTraineeCohortDetails(
			long traineeCohortDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.getTraineeCohortDetails(
			traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details matching the UUID and group.
	 *
	 * @param uuid the trainee cohort details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee cohort details
	 * @throws PortalException if a matching trainee cohort details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails
			getTraineeCohortDetailsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeCohortDetailsLocalService.
			getTraineeCohortDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of trainee cohort detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getTraineeCohortDetailses(int start, int end) {

		return _traineeCohortDetailsLocalService.getTraineeCohortDetailses(
			start, end);
	}

	/**
	 * Returns all the trainee cohort detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee cohort detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee cohort detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getTraineeCohortDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _traineeCohortDetailsLocalService.
			getTraineeCohortDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of trainee cohort detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee cohort detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee cohort detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getTraineeCohortDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeCohortDetails> orderByComparator) {

		return _traineeCohortDetailsLocalService.
			getTraineeCohortDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee cohort detailses.
	 *
	 * @return the number of trainee cohort detailses
	 */
	@Override
	public int getTraineeCohortDetailsesCount() {
		return _traineeCohortDetailsLocalService.
			getTraineeCohortDetailsesCount();
	}

	/**
	 * Updates the trainee cohort details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeCohortDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 * @return the trainee cohort details that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeCohortDetails updateTraineeCohortDetails(
		gov.omsb.tms.model.TraineeCohortDetails traineeCohortDetails) {

		return _traineeCohortDetailsLocalService.updateTraineeCohortDetails(
			traineeCohortDetails);
	}

	@Override
	public TraineeCohortDetailsLocalService getWrappedService() {
		return _traineeCohortDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeCohortDetailsLocalService traineeCohortDetailsLocalService) {

		_traineeCohortDetailsLocalService = traineeCohortDetailsLocalService;
	}

	private TraineeCohortDetailsLocalService _traineeCohortDetailsLocalService;

}