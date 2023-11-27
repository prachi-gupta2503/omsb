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
 * Provides a wrapper for {@link LeaveProgramMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveProgramMasterLocalService
 * @generated
 */
public class LeaveProgramMasterLocalServiceWrapper
	implements LeaveProgramMasterLocalService,
			   ServiceWrapper<LeaveProgramMasterLocalService> {

	public LeaveProgramMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveProgramMasterLocalServiceWrapper(
		LeaveProgramMasterLocalService leaveProgramMasterLocalService) {

		_leaveProgramMasterLocalService = leaveProgramMasterLocalService;
	}

	/**
	 * Adds the leave program master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveProgramMaster the leave program master
	 * @return the leave program master that was added
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster addLeaveProgramMaster(
		gov.omsb.tms.model.LeaveProgramMaster leaveProgramMaster) {

		return _leaveProgramMasterLocalService.addLeaveProgramMaster(
			leaveProgramMaster);
	}

	/**
	 * Creates a new leave program master with the primary key. Does not add the leave program master to the database.
	 *
	 * @param leaveProgramMasterId the primary key for the new leave program master
	 * @return the new leave program master
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster createLeaveProgramMaster(
		long leaveProgramMasterId) {

		return _leaveProgramMasterLocalService.createLeaveProgramMaster(
			leaveProgramMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave program master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveProgramMaster the leave program master
	 * @return the leave program master that was removed
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster deleteLeaveProgramMaster(
		gov.omsb.tms.model.LeaveProgramMaster leaveProgramMaster) {

		return _leaveProgramMasterLocalService.deleteLeaveProgramMaster(
			leaveProgramMaster);
	}

	/**
	 * Deletes the leave program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master that was removed
	 * @throws PortalException if a leave program master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster deleteLeaveProgramMaster(
			long leaveProgramMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.deleteLeaveProgramMaster(
			leaveProgramMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveProgramMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveProgramMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveProgramMasterLocalService.dynamicQuery();
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

		return _leaveProgramMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveProgramMasterModelImpl</code>.
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

		return _leaveProgramMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveProgramMasterModelImpl</code>.
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

		return _leaveProgramMasterLocalService.dynamicQuery(
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

		return _leaveProgramMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveProgramMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.LeaveProgramMaster fetchLeaveProgramMaster(
		long leaveProgramMasterId) {

		return _leaveProgramMasterLocalService.fetchLeaveProgramMaster(
			leaveProgramMasterId);
	}

	/**
	 * Returns the leave program master matching the UUID and group.
	 *
	 * @param uuid the leave program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave program master, or <code>null</code> if a matching leave program master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster
		fetchLeaveProgramMasterByUuidAndGroupId(String uuid, long groupId) {

		return _leaveProgramMasterLocalService.
			fetchLeaveProgramMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveProgramMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveProgramMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveProgramMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave program master with the primary key.
	 *
	 * @param leaveProgramMasterId the primary key of the leave program master
	 * @return the leave program master
	 * @throws PortalException if a leave program master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster getLeaveProgramMaster(
			long leaveProgramMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.getLeaveProgramMaster(
			leaveProgramMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.LeaveProgramMaster>
			getLeaveProgramMasterByProgramMasterId(long programMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _leaveProgramMasterLocalService.
			getLeaveProgramMasterByProgramMasterId(programMasterId);
	}

	@Override
	public gov.omsb.tms.model.LeaveProgramMaster
			getLeaveProgramMasterByProgramMasterIdLeaveTypesId(
				long programMasterId, long leaveTypesId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _leaveProgramMasterLocalService.
			getLeaveProgramMasterByProgramMasterIdLeaveTypesId(
				programMasterId, leaveTypesId);
	}

	/**
	 * Returns the leave program master matching the UUID and group.
	 *
	 * @param uuid the leave program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave program master
	 * @throws PortalException if a matching leave program master could not be found
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster
			getLeaveProgramMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.
			getLeaveProgramMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.LeaveProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @return the range of leave program masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveProgramMaster>
		getLeaveProgramMasters(int start, int end) {

		return _leaveProgramMasterLocalService.getLeaveProgramMasters(
			start, end);
	}

	/**
	 * Returns all the leave program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave program masters
	 * @param companyId the primary key of the company
	 * @return the matching leave program masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveProgramMaster>
		getLeaveProgramMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveProgramMasterLocalService.
			getLeaveProgramMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave program masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave program masters
	 * @param end the upper bound of the range of leave program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave program masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.LeaveProgramMaster>
		getLeaveProgramMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.LeaveProgramMaster> orderByComparator) {

		return _leaveProgramMasterLocalService.
			getLeaveProgramMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave program masters.
	 *
	 * @return the number of leave program masters
	 */
	@Override
	public int getLeaveProgramMastersCount() {
		return _leaveProgramMasterLocalService.getLeaveProgramMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveProgramMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveProgramMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave program master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveProgramMaster the leave program master
	 * @return the leave program master that was updated
	 */
	@Override
	public gov.omsb.tms.model.LeaveProgramMaster updateLeaveProgramMaster(
		gov.omsb.tms.model.LeaveProgramMaster leaveProgramMaster) {

		return _leaveProgramMasterLocalService.updateLeaveProgramMaster(
			leaveProgramMaster);
	}

	@Override
	public LeaveProgramMasterLocalService getWrappedService() {
		return _leaveProgramMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveProgramMasterLocalService leaveProgramMasterLocalService) {

		_leaveProgramMasterLocalService = leaveProgramMasterLocalService;
	}

	private LeaveProgramMasterLocalService _leaveProgramMasterLocalService;

}