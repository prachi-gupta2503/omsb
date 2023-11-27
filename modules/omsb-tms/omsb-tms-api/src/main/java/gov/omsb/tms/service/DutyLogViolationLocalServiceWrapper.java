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
 * Provides a wrapper for {@link DutyLogViolationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationLocalService
 * @generated
 */
public class DutyLogViolationLocalServiceWrapper
	implements DutyLogViolationLocalService,
			   ServiceWrapper<DutyLogViolationLocalService> {

	public DutyLogViolationLocalServiceWrapper() {
		this(null);
	}

	public DutyLogViolationLocalServiceWrapper(
		DutyLogViolationLocalService dutyLogViolationLocalService) {

		_dutyLogViolationLocalService = dutyLogViolationLocalService;
	}

	/**
	 * Adds the duty log violation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was added
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation addDutyLogViolation(
		gov.omsb.tms.model.DutyLogViolation dutyLogViolation) {

		return _dutyLogViolationLocalService.addDutyLogViolation(
			dutyLogViolation);
	}

	@Override
	public gov.omsb.tms.model.DutyLogViolation addDutyLogViolation(
		long groupId, long companyId, long createdBy, long modifiedBy,
		long traineeId, long dutyLogId, long programMasterId,
		long residencyLevel, long rotationId, long trainingSiteId, long blockId,
		long blockWeekId, long programDutyRuleId) {

		return _dutyLogViolationLocalService.addDutyLogViolation(
			groupId, companyId, createdBy, modifiedBy, traineeId, dutyLogId,
			programMasterId, residencyLevel, rotationId, trainingSiteId,
			blockId, blockWeekId, programDutyRuleId);
	}

	/**
	 * Creates a new duty log violation with the primary key. Does not add the duty log violation to the database.
	 *
	 * @param ViolationId the primary key for the new duty log violation
	 * @return the new duty log violation
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation createDutyLogViolation(
		long ViolationId) {

		return _dutyLogViolationLocalService.createDutyLogViolation(
			ViolationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the duty log violation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was removed
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation deleteDutyLogViolation(
		gov.omsb.tms.model.DutyLogViolation dutyLogViolation) {

		return _dutyLogViolationLocalService.deleteDutyLogViolation(
			dutyLogViolation);
	}

	/**
	 * Deletes the duty log violation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation that was removed
	 * @throws PortalException if a duty log violation with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation deleteDutyLogViolation(
			long ViolationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.deleteDutyLogViolation(
			ViolationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dutyLogViolationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dutyLogViolationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dutyLogViolationLocalService.dynamicQuery();
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

		return _dutyLogViolationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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

		return _dutyLogViolationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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

		return _dutyLogViolationLocalService.dynamicQuery(
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

		return _dutyLogViolationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dutyLogViolationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.DutyLogViolation fetchDutyLogViolation(
		long ViolationId) {

		return _dutyLogViolationLocalService.fetchDutyLogViolation(ViolationId);
	}

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation
		fetchDutyLogViolationByUuidAndGroupId(String uuid, long groupId) {

		return _dutyLogViolationLocalService.
			fetchDutyLogViolationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.DutyLogViolation findByDutyLogId(long dutyLogId) {
		return _dutyLogViolationLocalService.findByDutyLogId(dutyLogId);
	}

	@Override
	public gov.omsb.tms.model.DutyLogViolation
		findByTraineeAndBlockAndProgramAndDutyLogId(
			long traineeId, long blockId, long programMasterId,
			long dutyLogId) {

		return _dutyLogViolationLocalService.
			findByTraineeAndBlockAndProgramAndDutyLogId(
				traineeId, blockId, programMasterId, dutyLogId);
	}

	@Override
	public gov.omsb.tms.model.DutyLogViolation findByTraineeId(long traineeId) {
		return _dutyLogViolationLocalService.findByTraineeId(traineeId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyLogViolation>
		findByTraineeIdAndBlockId(long traineeId, long blockId) {

		return _dutyLogViolationLocalService.findByTraineeIdAndBlockId(
			traineeId, blockId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dutyLogViolationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the duty log violation with the primary key.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws PortalException if a duty log violation with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation getDutyLogViolation(
			long ViolationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.getDutyLogViolation(ViolationId);
	}

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation
	 * @throws PortalException if a matching duty log violation could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation
			getDutyLogViolationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.
			getDutyLogViolationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationList(
			long programId, long traineeCohortId, long residencyLevelId,
			long traineeId) {

		return _dutyLogViolationLocalService.getDutyLogViolationList(
			programId, traineeCohortId, residencyLevelId, traineeId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationListByUserId(long traineeId) {

		return _dutyLogViolationLocalService.getDutyLogViolationListByUserId(
			traineeId);
	}

	/**
	 * Returns a range of all the duty log violations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @return the range of duty log violations
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLogViolation>
		getDutyLogViolations(int start, int end) {

		return _dutyLogViolationLocalService.getDutyLogViolations(start, end);
	}

	/**
	 * Returns all the duty log violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty log violations
	 * @param companyId the primary key of the company
	 * @return the matching duty log violations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLogViolation>
		getDutyLogViolationsByUuidAndCompanyId(String uuid, long companyId) {

		return _dutyLogViolationLocalService.
			getDutyLogViolationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of duty log violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty log violations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty log violations
	 * @param end the upper bound of the range of duty log violations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty log violations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLogViolation>
		getDutyLogViolationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.DutyLogViolation> orderByComparator) {

		return _dutyLogViolationLocalService.
			getDutyLogViolationsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	@Override
	public int getDutyLogViolationsCount() {
		return _dutyLogViolationLocalService.getDutyLogViolationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dutyLogViolationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dutyLogViolationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyLogViolationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogViolationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the duty log violation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was updated
	 */
	@Override
	public gov.omsb.tms.model.DutyLogViolation updateDutyLogViolation(
		gov.omsb.tms.model.DutyLogViolation dutyLogViolation) {

		return _dutyLogViolationLocalService.updateDutyLogViolation(
			dutyLogViolation);
	}

	@Override
	public DutyLogViolationLocalService getWrappedService() {
		return _dutyLogViolationLocalService;
	}

	@Override
	public void setWrappedService(
		DutyLogViolationLocalService dutyLogViolationLocalService) {

		_dutyLogViolationLocalService = dutyLogViolationLocalService;
	}

	private DutyLogViolationLocalService _dutyLogViolationLocalService;

}