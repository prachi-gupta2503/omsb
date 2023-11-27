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
 * Provides a wrapper for {@link ProgramDutyAssignmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignmentLocalService
 * @generated
 */
public class ProgramDutyAssignmentLocalServiceWrapper
	implements ProgramDutyAssignmentLocalService,
			   ServiceWrapper<ProgramDutyAssignmentLocalService> {

	public ProgramDutyAssignmentLocalServiceWrapper() {
		this(null);
	}

	public ProgramDutyAssignmentLocalServiceWrapper(
		ProgramDutyAssignmentLocalService programDutyAssignmentLocalService) {

		_programDutyAssignmentLocalService = programDutyAssignmentLocalService;
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment addProgramDutyAssignment(
			long programId, long dutyAssignmentId, long cohortId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.addProgramDutyAssignment(
			programId, dutyAssignmentId, cohortId, serviceContext);
	}

	/**
	 * Adds the program duty assignment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyAssignment the program duty assignment
	 * @return the program duty assignment that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment addProgramDutyAssignment(
		gov.omsb.tms.model.ProgramDutyAssignment programDutyAssignment) {

		return _programDutyAssignmentLocalService.addProgramDutyAssignment(
			programDutyAssignment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new program duty assignment with the primary key. Does not add the program duty assignment to the database.
	 *
	 * @param programDutyAssignmentId the primary key for the new program duty assignment
	 * @return the new program duty assignment
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment createProgramDutyAssignment(
		long programDutyAssignmentId) {

		return _programDutyAssignmentLocalService.createProgramDutyAssignment(
			programDutyAssignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment that was removed
	 * @throws PortalException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment deleteProgramDutyAssignment(
			long programDutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.deleteProgramDutyAssignment(
			programDutyAssignmentId);
	}

	/**
	 * Deletes the program duty assignment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyAssignment the program duty assignment
	 * @return the program duty assignment that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment deleteProgramDutyAssignment(
		gov.omsb.tms.model.ProgramDutyAssignment programDutyAssignment) {

		return _programDutyAssignmentLocalService.deleteProgramDutyAssignment(
			programDutyAssignment);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programDutyAssignmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programDutyAssignmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programDutyAssignmentLocalService.dynamicQuery();
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

		return _programDutyAssignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyAssignmentModelImpl</code>.
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

		return _programDutyAssignmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyAssignmentModelImpl</code>.
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

		return _programDutyAssignmentLocalService.dynamicQuery(
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

		return _programDutyAssignmentLocalService.dynamicQueryCount(
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

		return _programDutyAssignmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment editProgramDutyAssignment(
			long programDutyAssignmentId, String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.editProgramDutyAssignment(
			programDutyAssignmentId, status);
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment fetchProgramDutyAssignment(
		long programDutyAssignmentId) {

		return _programDutyAssignmentLocalService.fetchProgramDutyAssignment(
			programDutyAssignmentId);
	}

	/**
	 * Returns the program duty assignment matching the UUID and group.
	 *
	 * @param uuid the program duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment
		fetchProgramDutyAssignmentByUuidAndGroupId(String uuid, long groupId) {

		return _programDutyAssignmentLocalService.
			fetchProgramDutyAssignmentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public String findDutyTypeAssignmentStatus(long dutyAssignmentId) {
		return _programDutyAssignmentLocalService.findDutyTypeAssignmentStatus(
			dutyAssignmentId);
	}

	@Override
	public String findProgramDutyAssignment(
		long programId, long cohortId, long dutyAssignmentId) {

		return _programDutyAssignmentLocalService.findProgramDutyAssignment(
			programId, cohortId, dutyAssignmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programDutyAssignmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getByProgramId(long programId) {

		return _programDutyAssignmentLocalService.getByProgramId(programId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.UserDTO>
		getByProgramIdAndCohortId(long programId, long cohortId) {

		return _programDutyAssignmentLocalService.getByProgramIdAndCohortId(
			programId, cohortId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programDutyAssignmentLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programDutyAssignmentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programDutyAssignmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the program duty assignment with the primary key.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment
	 * @throws PortalException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment getProgramDutyAssignment(
			long programDutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.getProgramDutyAssignment(
			programDutyAssignmentId);
	}

	/**
	 * Returns the program duty assignment matching the UUID and group.
	 *
	 * @param uuid the program duty assignment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duty assignment
	 * @throws PortalException if a matching program duty assignment could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment
			getProgramDutyAssignmentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentLocalService.
			getProgramDutyAssignmentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyAssignment>
		getProgramDutyAssignmentList() {

		return _programDutyAssignmentLocalService.
			getProgramDutyAssignmentList();
	}

	/**
	 * Returns a range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of program duty assignments
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyAssignment>
		getProgramDutyAssignments(int start, int end) {

		return _programDutyAssignmentLocalService.getProgramDutyAssignments(
			start, end);
	}

	/**
	 * Returns all the program duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duty assignments
	 * @param companyId the primary key of the company
	 * @return the matching program duty assignments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyAssignment>
		getProgramDutyAssignmentsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _programDutyAssignmentLocalService.
			getProgramDutyAssignmentsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program duty assignments matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duty assignments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program duty assignments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDutyAssignment>
		getProgramDutyAssignmentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramDutyAssignment> orderByComparator) {

		return _programDutyAssignmentLocalService.
			getProgramDutyAssignmentsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program duty assignments.
	 *
	 * @return the number of program duty assignments
	 */
	@Override
	public int getProgramDutyAssignmentsCount() {
		return _programDutyAssignmentLocalService.
			getProgramDutyAssignmentsCount();
	}

	@Override
	public boolean isUserAvailable(
		com.liferay.portal.kernel.model.User user,
		java.util.List<gov.omsb.tms.custom.dto.UserDTO> userList) {

		return _programDutyAssignmentLocalService.isUserAvailable(
			user, userList);
	}

	/**
	 * Updates the program duty assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDutyAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDutyAssignment the program duty assignment
	 * @return the program duty assignment that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment updateProgramDutyAssignment(
		gov.omsb.tms.model.ProgramDutyAssignment programDutyAssignment) {

		return _programDutyAssignmentLocalService.updateProgramDutyAssignment(
			programDutyAssignment);
	}

	@Override
	public ProgramDutyAssignmentLocalService getWrappedService() {
		return _programDutyAssignmentLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramDutyAssignmentLocalService programDutyAssignmentLocalService) {

		_programDutyAssignmentLocalService = programDutyAssignmentLocalService;
	}

	private ProgramDutyAssignmentLocalService
		_programDutyAssignmentLocalService;

}