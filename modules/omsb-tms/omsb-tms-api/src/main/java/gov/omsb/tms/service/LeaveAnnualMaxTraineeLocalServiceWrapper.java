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
 * Provides a wrapper for {@link LeaveAnnualMaxTraineeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTraineeLocalService
 * @generated
 */
public class LeaveAnnualMaxTraineeLocalServiceWrapper
	implements LeaveAnnualMaxTraineeLocalService,
			   ServiceWrapper<LeaveAnnualMaxTraineeLocalService> {

	public LeaveAnnualMaxTraineeLocalServiceWrapper() {
		this(null);
	}

	public LeaveAnnualMaxTraineeLocalServiceWrapper(
		LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService) {

		_leaveAnnualMaxTraineeLocalService = leaveAnnualMaxTraineeLocalService;
	}

	/**
	 * Adds the leave annual max trainee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMaxTraineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 * @return the leave annual max trainee that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee addLeaveAnnualMaxTrainee(
		gov.omsb.tms.model.LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return _leaveAnnualMaxTraineeLocalService.addLeaveAnnualMaxTrainee(
			leaveAnnualMaxTrainee);
	}

	/**
	 * Creates a new leave annual max trainee with the primary key. Does not add the leave annual max trainee to the database.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key for the new leave annual max trainee
	 * @return the new leave annual max trainee
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee createLeaveAnnualMaxTrainee(
		long leaveAnnualMaxTraineeId) {

		return _leaveAnnualMaxTraineeLocalService.createLeaveAnnualMaxTrainee(
			leaveAnnualMaxTraineeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave annual max trainee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMaxTraineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee deleteLeaveAnnualMaxTrainee(
		gov.omsb.tms.model.LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return _leaveAnnualMaxTraineeLocalService.deleteLeaveAnnualMaxTrainee(
			leaveAnnualMaxTrainee);
	}

	/**
	 * Deletes the leave annual max trainee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMaxTraineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee that was removed
	 * @throws PortalException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee deleteLeaveAnnualMaxTrainee(
			long leaveAnnualMaxTraineeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.deleteLeaveAnnualMaxTrainee(
			leaveAnnualMaxTraineeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveAnnualMaxTraineeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveAnnualMaxTraineeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveAnnualMaxTraineeLocalService.dynamicQuery();
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

		return _leaveAnnualMaxTraineeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMaxTraineeModelImpl</code>.
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

		return _leaveAnnualMaxTraineeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMaxTraineeModelImpl</code>.
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

		return _leaveAnnualMaxTraineeLocalService.dynamicQuery(
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

		return _leaveAnnualMaxTraineeLocalService.dynamicQueryCount(
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

		return _leaveAnnualMaxTraineeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee fetchLeaveAnnualMaxTrainee(
		long leaveAnnualMaxTraineeId) {

		return _leaveAnnualMaxTraineeLocalService.fetchLeaveAnnualMaxTrainee(
			leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns the leave annual max trainee matching the UUID and group.
	 *
	 * @param uuid the leave annual max trainee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual max trainee, or <code>null</code> if a matching leave annual max trainee could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee
		fetchLeaveAnnualMaxTraineeByUuidAndGroupId(String uuid, long groupId) {

		return _leaveAnnualMaxTraineeLocalService.
			fetchLeaveAnnualMaxTraineeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveAnnualMaxTraineeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveAnnualMaxTraineeLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveAnnualMaxTraineeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave annual max trainee with the primary key.
	 *
	 * @param leaveAnnualMaxTraineeId the primary key of the leave annual max trainee
	 * @return the leave annual max trainee
	 * @throws PortalException if a leave annual max trainee with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee getLeaveAnnualMaxTrainee(
			long leaveAnnualMaxTraineeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.getLeaveAnnualMaxTrainee(
			leaveAnnualMaxTraineeId);
	}

	/**
	 * Returns the leave annual max trainee matching the UUID and group.
	 *
	 * @param uuid the leave annual max trainee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual max trainee
	 * @throws PortalException if a matching leave annual max trainee could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee
			getLeaveAnnualMaxTraineeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.
			getLeaveAnnualMaxTraineeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave annual max trainees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMaxTraineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @return the range of leave annual max trainees
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaxTrainee>
		getLeaveAnnualMaxTrainees(int start, int end) {

		return _leaveAnnualMaxTraineeLocalService.getLeaveAnnualMaxTrainees(
			start, end);
	}

	/**
	 * Returns all the leave annual max trainees matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual max trainees
	 * @param companyId the primary key of the company
	 * @return the matching leave annual max trainees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaxTrainee>
		getLeaveAnnualMaxTraineesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _leaveAnnualMaxTraineeLocalService.
			getLeaveAnnualMaxTraineesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave annual max trainees matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual max trainees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave annual max trainees
	 * @param end the upper bound of the range of leave annual max trainees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave annual max trainees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaxTrainee>
		getLeaveAnnualMaxTraineesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveAnnualMaxTrainee> orderByComparator) {

		return _leaveAnnualMaxTraineeLocalService.
			getLeaveAnnualMaxTraineesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave annual max trainees.
	 *
	 * @return the number of leave annual max trainees
	 */
	@Override
	public int getLeaveAnnualMaxTraineesCount() {
		return _leaveAnnualMaxTraineeLocalService.
			getLeaveAnnualMaxTraineesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveAnnualMaxTraineeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMaxTraineeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the leave annual max trainee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMaxTraineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaxTrainee the leave annual max trainee
	 * @return the leave annual max trainee that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaxTrainee updateLeaveAnnualMaxTrainee(
		gov.omsb.tms.model.LeaveAnnualMaxTrainee leaveAnnualMaxTrainee) {

		return _leaveAnnualMaxTraineeLocalService.updateLeaveAnnualMaxTrainee(
			leaveAnnualMaxTrainee);
	}

	@Override
	public LeaveAnnualMaxTraineeLocalService getWrappedService() {
		return _leaveAnnualMaxTraineeLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService) {

		_leaveAnnualMaxTraineeLocalService = leaveAnnualMaxTraineeLocalService;
	}

	private LeaveAnnualMaxTraineeLocalService
		_leaveAnnualMaxTraineeLocalService;

}