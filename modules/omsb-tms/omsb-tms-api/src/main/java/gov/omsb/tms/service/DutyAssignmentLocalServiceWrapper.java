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
 * Provides a wrapper for {@link DutyAssignmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentLocalService
 * @generated
 */
public class DutyAssignmentLocalServiceWrapper
	implements DutyAssignmentLocalService,
			   ServiceWrapper<DutyAssignmentLocalService> {

	public DutyAssignmentLocalServiceWrapper() {
		this(null);
	}

	public DutyAssignmentLocalServiceWrapper(
		DutyAssignmentLocalService dutyAssignmentLocalService) {

		_dutyAssignmentLocalService = dutyAssignmentLocalService;
	}

	/**
	 * Adds the duty assignment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was added
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment addDutyAssignment(
		gov.omsb.tms.model.DutyAssignment dutyAssignment) {

		return _dutyAssignmentLocalService.addDutyAssignment(dutyAssignment);
	}

	/**
	 * Creates a new duty assignment with the primary key. Does not add the duty assignment to the database.
	 *
	 * @param dutyAssignmentId the primary key for the new duty assignment
	 * @return the new duty assignment
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment createDutyAssignment(
		long dutyAssignmentId) {

		return _dutyAssignmentLocalService.createDutyAssignment(
			dutyAssignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the duty assignment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was removed
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment deleteDutyAssignment(
		gov.omsb.tms.model.DutyAssignment dutyAssignment) {

		return _dutyAssignmentLocalService.deleteDutyAssignment(dutyAssignment);
	}

	/**
	 * Deletes the duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment that was removed
	 * @throws PortalException if a duty assignment with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment deleteDutyAssignment(
			long dutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.deleteDutyAssignment(
			dutyAssignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dutyAssignmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dutyAssignmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dutyAssignmentLocalService.dynamicQuery();
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

		return _dutyAssignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
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

		return _dutyAssignmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
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

		return _dutyAssignmentLocalService.dynamicQuery(
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

		return _dutyAssignmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dutyAssignmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.DutyAssignment fetchDutyAssignment(
		long dutyAssignmentId) {

		return _dutyAssignmentLocalService.fetchDutyAssignment(
			dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment matching the UUID and group.
	 *
	 * @param uuid the duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty assignment, or <code>null</code> if a matching duty assignment could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment
		fetchDutyAssignmentByUuidAndGroupId(String uuid, long groupId) {

		return _dutyAssignmentLocalService.fetchDutyAssignmentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public String fetchDutyTypeAssignmentStatus(
		long dutyTypeId, String assignment, long dutyAssignmentId) {

		return _dutyAssignmentLocalService.fetchDutyTypeAssignmentStatus(
			dutyTypeId, assignment, dutyAssignmentId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyAssignment>
		findAssignmentByDutyTypeId(long dutyTypeId) {

		return _dutyAssignmentLocalService.findAssignmentByDutyTypeId(
			dutyTypeId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyAssignment>
		findByDutyTypeIdAndAssignment(long dutyTypeId, String assignment) {

		return _dutyAssignmentLocalService.findByDutyTypeIdAndAssignment(
			dutyTypeId, assignment);
	}

	@Override
	public String findDutyTypeStatus(long dutyTypeId) {
		return _dutyAssignmentLocalService.findDutyTypeStatus(dutyTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dutyAssignmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getAssignmentListByDutyTypeId(long dutyTypeId) {
		return _dutyAssignmentLocalService.getAssignmentListByDutyTypeId(
			dutyTypeId);
	}

	/**
	 * Returns the duty assignment with the primary key.
	 *
	 * @param dutyAssignmentId the primary key of the duty assignment
	 * @return the duty assignment
	 * @throws PortalException if a duty assignment with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment getDutyAssignment(
			long dutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.getDutyAssignment(dutyAssignmentId);
	}

	/**
	 * Returns the duty assignment matching the UUID and group.
	 *
	 * @param uuid the duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty assignment
	 * @throws PortalException if a matching duty assignment could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment getDutyAssignmentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.getDutyAssignmentByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @return the range of duty assignments
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyAssignment> getDutyAssignments(
		int start, int end) {

		return _dutyAssignmentLocalService.getDutyAssignments(start, end);
	}

	/**
	 * Returns all the duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty assignments
	 * @param companyId the primary key of the company
	 * @return the matching duty assignments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyAssignment>
		getDutyAssignmentsByUuidAndCompanyId(String uuid, long companyId) {

		return _dutyAssignmentLocalService.getDutyAssignmentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty assignments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty assignments
	 * @param end the upper bound of the range of duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty assignments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyAssignment>
		getDutyAssignmentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.DutyAssignment> orderByComparator) {

		return _dutyAssignmentLocalService.getDutyAssignmentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty assignments.
	 *
	 * @return the number of duty assignments
	 */
	@Override
	public int getDutyAssignmentsCount() {
		return _dutyAssignmentLocalService.getDutyAssignmentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dutyAssignmentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dutyAssignmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyAssignmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyAssignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the duty assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyAssignment the duty assignment
	 * @return the duty assignment that was updated
	 */
	@Override
	public gov.omsb.tms.model.DutyAssignment updateDutyAssignment(
		gov.omsb.tms.model.DutyAssignment dutyAssignment) {

		return _dutyAssignmentLocalService.updateDutyAssignment(dutyAssignment);
	}

	@Override
	public DutyAssignmentLocalService getWrappedService() {
		return _dutyAssignmentLocalService;
	}

	@Override
	public void setWrappedService(
		DutyAssignmentLocalService dutyAssignmentLocalService) {

		_dutyAssignmentLocalService = dutyAssignmentLocalService;
	}

	private DutyAssignmentLocalService _dutyAssignmentLocalService;

}