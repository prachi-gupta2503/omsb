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
 * Provides a wrapper for {@link TraineeSponsorDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeSponsorDetailsLocalService
 * @generated
 */
public class TraineeSponsorDetailsLocalServiceWrapper
	implements ServiceWrapper<TraineeSponsorDetailsLocalService>,
			   TraineeSponsorDetailsLocalService {

	public TraineeSponsorDetailsLocalServiceWrapper() {
		this(null);
	}

	public TraineeSponsorDetailsLocalServiceWrapper(
		TraineeSponsorDetailsLocalService traineeSponsorDetailsLocalService) {

		_traineeSponsorDetailsLocalService = traineeSponsorDetailsLocalService;
	}

	/**
	 * Adds the trainee sponsor details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was added
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails addTraineeSponsorDetails(
		gov.omsb.tms.model.TraineeSponsorDetails traineeSponsorDetails) {

		return _traineeSponsorDetailsLocalService.addTraineeSponsorDetails(
			traineeSponsorDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new trainee sponsor details with the primary key. Does not add the trainee sponsor details to the database.
	 *
	 * @param traineeSponsorDetailsId the primary key for the new trainee sponsor details
	 * @return the new trainee sponsor details
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails createTraineeSponsorDetails(
		long traineeSponsorDetailsId) {

		return _traineeSponsorDetailsLocalService.createTraineeSponsorDetails(
			traineeSponsorDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws PortalException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails deleteTraineeSponsorDetails(
			long traineeSponsorDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.deleteTraineeSponsorDetails(
			traineeSponsorDetailsId);
	}

	/**
	 * Deletes the trainee sponsor details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails deleteTraineeSponsorDetails(
		gov.omsb.tms.model.TraineeSponsorDetails traineeSponsorDetails) {

		return _traineeSponsorDetailsLocalService.deleteTraineeSponsorDetails(
			traineeSponsorDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeSponsorDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeSponsorDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeSponsorDetailsLocalService.dynamicQuery();
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

		return _traineeSponsorDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
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

		return _traineeSponsorDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
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

		return _traineeSponsorDetailsLocalService.dynamicQuery(
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

		return _traineeSponsorDetailsLocalService.dynamicQueryCount(
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

		return _traineeSponsorDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails fetchTraineeSponsorDetails(
		long traineeSponsorDetailsId) {

		return _traineeSponsorDetailsLocalService.fetchTraineeSponsorDetails(
			traineeSponsorDetailsId);
	}

	/**
	 * Returns the trainee sponsor details matching the UUID and group.
	 *
	 * @param uuid the trainee sponsor details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails
		fetchTraineeSponsorDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _traineeSponsorDetailsLocalService.
			fetchTraineeSponsorDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeSponsorDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeSponsorDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeSponsorDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the trainee sponsor details with the primary key.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws PortalException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails getTraineeSponsorDetails(
			long traineeSponsorDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.getTraineeSponsorDetails(
			traineeSponsorDetailsId);
	}

	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails
		getTraineeSponsorDetailsByTraineeId(long traineeId) {

		return _traineeSponsorDetailsLocalService.
			getTraineeSponsorDetailsByTraineeId(traineeId);
	}

	/**
	 * Returns the trainee sponsor details matching the UUID and group.
	 *
	 * @param uuid the trainee sponsor details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee sponsor details
	 * @throws PortalException if a matching trainee sponsor details could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails
			getTraineeSponsorDetailsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeSponsorDetailsLocalService.
			getTraineeSponsorDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of trainee sponsor detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeSponsorDetails>
		getTraineeSponsorDetailses(int start, int end) {

		return _traineeSponsorDetailsLocalService.getTraineeSponsorDetailses(
			start, end);
	}

	/**
	 * Returns all the trainee sponsor detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee sponsor detailses
	 * @param companyId the primary key of the company
	 * @return the matching trainee sponsor detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeSponsorDetails>
		getTraineeSponsorDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _traineeSponsorDetailsLocalService.
			getTraineeSponsorDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of trainee sponsor detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee sponsor detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee sponsor detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeSponsorDetails>
		getTraineeSponsorDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeSponsorDetails> orderByComparator) {

		return _traineeSponsorDetailsLocalService.
			getTraineeSponsorDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee sponsor detailses.
	 *
	 * @return the number of trainee sponsor detailses
	 */
	@Override
	public int getTraineeSponsorDetailsesCount() {
		return _traineeSponsorDetailsLocalService.
			getTraineeSponsorDetailsesCount();
	}

	/**
	 * Updates the trainee sponsor details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeSponsorDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 * @return the trainee sponsor details that was updated
	 */
	@Override
	public gov.omsb.tms.model.TraineeSponsorDetails updateTraineeSponsorDetails(
		gov.omsb.tms.model.TraineeSponsorDetails traineeSponsorDetails) {

		return _traineeSponsorDetailsLocalService.updateTraineeSponsorDetails(
			traineeSponsorDetails);
	}

	@Override
	public TraineeSponsorDetailsLocalService getWrappedService() {
		return _traineeSponsorDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeSponsorDetailsLocalService traineeSponsorDetailsLocalService) {

		_traineeSponsorDetailsLocalService = traineeSponsorDetailsLocalService;
	}

	private TraineeSponsorDetailsLocalService
		_traineeSponsorDetailsLocalService;

}