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
 * Provides a wrapper for {@link LeaveAnnualMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMasterLocalService
 * @generated
 */
public class LeaveAnnualMasterLocalServiceWrapper
	implements LeaveAnnualMasterLocalService,
			   ServiceWrapper<LeaveAnnualMasterLocalService> {

	public LeaveAnnualMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveAnnualMasterLocalServiceWrapper(
		LeaveAnnualMasterLocalService leaveAnnualMasterLocalService) {

		_leaveAnnualMasterLocalService = leaveAnnualMasterLocalService;
	}

	/**
	 * Adds the leave annual master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaster the leave annual master
	 * @return the leave annual master that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster addLeaveAnnualMaster(
		gov.omsb.tms.model.LeaveAnnualMaster leaveAnnualMaster) {

		return _leaveAnnualMasterLocalService.addLeaveAnnualMaster(
			leaveAnnualMaster);
	}

	/**
	 * Creates a new leave annual master with the primary key. Does not add the leave annual master to the database.
	 *
	 * @param leaveAnnualMasterId the primary key for the new leave annual master
	 * @return the new leave annual master
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster createLeaveAnnualMaster(
		long leaveAnnualMasterId) {

		return _leaveAnnualMasterLocalService.createLeaveAnnualMaster(
			leaveAnnualMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave annual master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaster the leave annual master
	 * @return the leave annual master that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster deleteLeaveAnnualMaster(
		gov.omsb.tms.model.LeaveAnnualMaster leaveAnnualMaster) {

		return _leaveAnnualMasterLocalService.deleteLeaveAnnualMaster(
			leaveAnnualMaster);
	}

	/**
	 * Deletes the leave annual master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMasterId the primary key of the leave annual master
	 * @return the leave annual master that was removed
	 * @throws PortalException if a leave annual master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster deleteLeaveAnnualMaster(
			long leaveAnnualMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.deleteLeaveAnnualMaster(
			leaveAnnualMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveAnnualMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveAnnualMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveAnnualMasterLocalService.dynamicQuery();
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

		return _leaveAnnualMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMasterModelImpl</code>.
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

		return _leaveAnnualMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMasterModelImpl</code>.
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

		return _leaveAnnualMasterLocalService.dynamicQuery(
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

		return _leaveAnnualMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveAnnualMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster fetchLeaveAnnualMaster(
		long leaveAnnualMasterId) {

		return _leaveAnnualMasterLocalService.fetchLeaveAnnualMaster(
			leaveAnnualMasterId);
	}

	/**
	 * Returns the leave annual master matching the UUID and group.
	 *
	 * @param uuid the leave annual master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual master, or <code>null</code> if a matching leave annual master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster
		fetchLeaveAnnualMasterByUuidAndGroupId(String uuid, long groupId) {

		return _leaveAnnualMasterLocalService.
			fetchLeaveAnnualMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveAnnualMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveAnnualMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveAnnualMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave annual master with the primary key.
	 *
	 * @param leaveAnnualMasterId the primary key of the leave annual master
	 * @return the leave annual master
	 * @throws PortalException if a leave annual master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster getLeaveAnnualMaster(
			long leaveAnnualMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.getLeaveAnnualMaster(
			leaveAnnualMasterId);
	}

	/**
	 * Returns the leave annual master matching the UUID and group.
	 *
	 * @param uuid the leave annual master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave annual master
	 * @throws PortalException if a matching leave annual master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster
			getLeaveAnnualMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.
			getLeaveAnnualMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave annual masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveAnnualMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @return the range of leave annual masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaster>
		getLeaveAnnualMasters(int start, int end) {

		return _leaveAnnualMasterLocalService.getLeaveAnnualMasters(start, end);
	}

	/**
	 * Returns all the leave annual masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual masters
	 * @param companyId the primary key of the company
	 * @return the matching leave annual masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaster>
		getLeaveAnnualMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveAnnualMasterLocalService.
			getLeaveAnnualMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave annual masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave annual masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave annual masters
	 * @param end the upper bound of the range of leave annual masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave annual masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveAnnualMaster>
		getLeaveAnnualMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveAnnualMaster> orderByComparator) {

		return _leaveAnnualMasterLocalService.
			getLeaveAnnualMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave annual masters.
	 *
	 * @return the number of leave annual masters
	 */
	@Override
	public int getLeaveAnnualMastersCount() {
		return _leaveAnnualMasterLocalService.getLeaveAnnualMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveAnnualMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveAnnualMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave annual master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveAnnualMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveAnnualMaster the leave annual master
	 * @return the leave annual master that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveAnnualMaster updateLeaveAnnualMaster(
		gov.omsb.tms.model.LeaveAnnualMaster leaveAnnualMaster) {

		return _leaveAnnualMasterLocalService.updateLeaveAnnualMaster(
			leaveAnnualMaster);
	}

	@Override
	public LeaveAnnualMasterLocalService getWrappedService() {
		return _leaveAnnualMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveAnnualMasterLocalService leaveAnnualMasterLocalService) {

		_leaveAnnualMasterLocalService = leaveAnnualMasterLocalService;
	}

	private LeaveAnnualMasterLocalService _leaveAnnualMasterLocalService;

}