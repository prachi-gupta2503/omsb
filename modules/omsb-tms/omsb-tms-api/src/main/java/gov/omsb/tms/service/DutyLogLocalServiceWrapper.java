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
 * Provides a wrapper for {@link DutyLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogLocalService
 * @generated
 */
public class DutyLogLocalServiceWrapper
	implements DutyLogLocalService, ServiceWrapper<DutyLogLocalService> {

	public DutyLogLocalServiceWrapper() {
		this(null);
	}

	public DutyLogLocalServiceWrapper(DutyLogLocalService dutyLogLocalService) {
		_dutyLogLocalService = dutyLogLocalService;
	}

	/**
	 * Adds the duty log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was added
	 */
	@Override
	public gov.omsb.tms.model.DutyLog addDutyLog(
		gov.omsb.tms.model.DutyLog dutyLog) {

		return _dutyLogLocalService.addDutyLog(dutyLog);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		addToTraineeLevelListDTO(
			java.util.List<gov.omsb.tms.model.DutyLog> dutyLogs,
			String languageCode) {

		return _dutyLogLocalService.addToTraineeLevelListDTO(
			dutyLogs, languageCode);
	}

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	@Override
	public gov.omsb.tms.model.DutyLog createDutyLog(long dutyLogId) {
		return _dutyLogLocalService.createDutyLog(dutyLogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the duty log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was removed
	 */
	@Override
	public gov.omsb.tms.model.DutyLog deleteDutyLog(
		gov.omsb.tms.model.DutyLog dutyLog) {

		return _dutyLogLocalService.deleteDutyLog(dutyLog);
	}

	/**
	 * Deletes the duty log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log that was removed
	 * @throws PortalException if a duty log with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLog deleteDutyLog(long dutyLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.deleteDutyLog(dutyLogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dutyLogLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dutyLogLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dutyLogLocalService.dynamicQuery();
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

		return _dutyLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
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

		return _dutyLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
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

		return _dutyLogLocalService.dynamicQuery(
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

		return _dutyLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dutyLogLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.DutyLog fetchDutyLog(long dutyLogId) {
		return _dutyLogLocalService.fetchDutyLog(dutyLogId);
	}

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLog fetchDutyLogByUuidAndGroupId(
		String uuid, long groupId) {

		return _dutyLogLocalService.fetchDutyLogByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.custom.dto.DutyLogDTO getAcgmeCallRule48Hour(
		long dutyTypeId, long traineeId, long blockId, long dutyLogId) {

		return _dutyLogLocalService.getAcgmeCallRule48Hour(
			dutyTypeId, traineeId, blockId, dutyLogId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dutyLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog>
		getByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {

		return _dutyLogLocalService.getByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog>
		getByProgramDutyAssignmentId(long programDutyAssignmentId) {

		return _dutyLogLocalService.getByProgramDutyAssignmentId(
			programDutyAssignmentId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getByTranieeIdAndProgramDutyAssignmentId(
			long traineeId, long programId, long cohortId,
			String languageCode) {

		return _dutyLogLocalService.getByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programId, cohortId, languageCode);
	}

	/**
	 * Returns the duty log with the primary key.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws PortalException if a duty log with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLog getDutyLog(long dutyLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.getDutyLog(dutyLogId);
	}

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log
	 * @throws PortalException if a matching duty log could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyLog getDutyLogByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.getDutyLogByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.custom.dto.DutyLogDTO getDutyLogDTO(
		long traineeId, String startDate) {

		return _dutyLogLocalService.getDutyLogDTO(traineeId, startDate);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.DutyLogHoursDTO>
		getDutyLogHours(
			long programId, long traineeCohortId, long residencyLevelId,
			long traineeId, String stratDate, String endDate) {

		return _dutyLogLocalService.getDutyLogHours(
			programId, traineeCohortId, residencyLevelId, traineeId, stratDate,
			endDate);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog>
		getDutyLogListByTraineeIdAndBlockId(
			long traineeId, long blocksMetadataDetailRelId) {

		return _dutyLogLocalService.getDutyLogListByTraineeIdAndBlockId(
			traineeId, blocksMetadataDetailRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.DutyLogDTO> getDutyLogs(
		java.util.Date startDate, java.util.Date endDate, long traineeId) {

		return _dutyLogLocalService.getDutyLogs(startDate, endDate, traineeId);
	}

	/**
	 * Returns a range of all the duty logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @return the range of duty logs
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog> getDutyLogs(
		int start, int end) {

		return _dutyLogLocalService.getDutyLogs(start, end);
	}

	/**
	 * Returns all the duty logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty logs
	 * @param companyId the primary key of the company
	 * @return the matching duty logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog>
		getDutyLogsByUuidAndCompanyId(String uuid, long companyId) {

		return _dutyLogLocalService.getDutyLogsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of duty logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty logs
	 * @param end the upper bound of the range of duty logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyLog>
		getDutyLogsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.DutyLog> orderByComparator) {

		return _dutyLogLocalService.getDutyLogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	@Override
	public int getDutyLogsCount() {
		return _dutyLogLocalService.getDutyLogsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dutyLogLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dutyLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyLogLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public gov.omsb.tms.model.DutyLog getPreviousDutyLog(long dutyLogId) {
		return _dutyLogLocalService.getPreviousDutyLog(dutyLogId);
	}

	@Override
	public gov.omsb.tms.model.DutyLog getPreviousDutyLog(
		long dutyLogId, long traineeId, long blockId,
		java.util.Date startDate) {

		return _dutyLogLocalService.getPreviousDutyLog(
			dutyLogId, traineeId, blockId, startDate);
	}

	@Override
	public boolean isTraineeLevel(
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster,
		java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
			traineeLevelList) {

		return _dutyLogLocalService.isTraineeLevel(
			traineeLevelMaster, traineeLevelList);
	}

	/**
	 * Updates the duty log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLog the duty log
	 * @return the duty log that was updated
	 */
	@Override
	public gov.omsb.tms.model.DutyLog updateDutyLog(
		gov.omsb.tms.model.DutyLog dutyLog) {

		return _dutyLogLocalService.updateDutyLog(dutyLog);
	}

	@Override
	public DutyLogLocalService getWrappedService() {
		return _dutyLogLocalService;
	}

	@Override
	public void setWrappedService(DutyLogLocalService dutyLogLocalService) {
		_dutyLogLocalService = dutyLogLocalService;
	}

	private DutyLogLocalService _dutyLogLocalService;

}