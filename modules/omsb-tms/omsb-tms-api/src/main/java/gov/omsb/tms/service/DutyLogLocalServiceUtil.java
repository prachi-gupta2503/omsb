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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.model.DutyLog;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DutyLog. This utility wraps
 * <code>gov.omsb.tms.service.impl.DutyLogLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogLocalService
 * @generated
 */
public class DutyLogLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyLogLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DutyLog addDutyLog(DutyLog dutyLog) {
		return getService().addDutyLog(dutyLog);
	}

	public static List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		addToTraineeLevelListDTO(List<DutyLog> dutyLogs, String languageCode) {

		return getService().addToTraineeLevelListDTO(dutyLogs, languageCode);
	}

	/**
	 * Creates a new duty log with the primary key. Does not add the duty log to the database.
	 *
	 * @param dutyLogId the primary key for the new duty log
	 * @return the new duty log
	 */
	public static DutyLog createDutyLog(long dutyLogId) {
		return getService().createDutyLog(dutyLogId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DutyLog deleteDutyLog(DutyLog dutyLog) {
		return getService().deleteDutyLog(dutyLog);
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
	public static DutyLog deleteDutyLog(long dutyLogId) throws PortalException {
		return getService().deleteDutyLog(dutyLogId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DutyLog fetchDutyLog(long dutyLogId) {
		return getService().fetchDutyLog(dutyLogId);
	}

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log, or <code>null</code> if a matching duty log could not be found
	 */
	public static DutyLog fetchDutyLogByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDutyLogByUuidAndGroupId(uuid, groupId);
	}

	public static gov.omsb.tms.custom.dto.DutyLogDTO getAcgmeCallRule48Hour(
		long dutyTypeId, long traineeId, long blockId, long dutyLogId) {

		return getService().getAcgmeCallRule48Hour(
			dutyTypeId, traineeId, blockId, dutyLogId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DutyLog> getByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return getService().getByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId);
	}

	public static List<DutyLog> getByProgramDutyAssignmentId(
		long programDutyAssignmentId) {

		return getService().getByProgramDutyAssignmentId(
			programDutyAssignmentId);
	}

	public static List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getByTranieeIdAndProgramDutyAssignmentId(
			long traineeId, long programId, long cohortId,
			String languageCode) {

		return getService().getByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programId, cohortId, languageCode);
	}

	/**
	 * Returns the duty log with the primary key.
	 *
	 * @param dutyLogId the primary key of the duty log
	 * @return the duty log
	 * @throws PortalException if a duty log with the primary key could not be found
	 */
	public static DutyLog getDutyLog(long dutyLogId) throws PortalException {
		return getService().getDutyLog(dutyLogId);
	}

	/**
	 * Returns the duty log matching the UUID and group.
	 *
	 * @param uuid the duty log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log
	 * @throws PortalException if a matching duty log could not be found
	 */
	public static DutyLog getDutyLogByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDutyLogByUuidAndGroupId(uuid, groupId);
	}

	public static gov.omsb.tms.custom.dto.DutyLogDTO getDutyLogDTO(
		long traineeId, String startDate) {

		return getService().getDutyLogDTO(traineeId, startDate);
	}

	public static List<gov.omsb.tms.custom.dto.DutyLogHoursDTO> getDutyLogHours(
		long programId, long traineeCohortId, long residencyLevelId,
		long traineeId, String stratDate, String endDate) {

		return getService().getDutyLogHours(
			programId, traineeCohortId, residencyLevelId, traineeId, stratDate,
			endDate);
	}

	public static List<DutyLog> getDutyLogListByTraineeIdAndBlockId(
		long traineeId, long blocksMetadataDetailRelId) {

		return getService().getDutyLogListByTraineeIdAndBlockId(
			traineeId, blocksMetadataDetailRelId);
	}

	public static List<gov.omsb.tms.custom.dto.DutyLogDTO> getDutyLogs(
		java.util.Date startDate, java.util.Date endDate, long traineeId) {

		return getService().getDutyLogs(startDate, endDate, traineeId);
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
	public static List<DutyLog> getDutyLogs(int start, int end) {
		return getService().getDutyLogs(start, end);
	}

	/**
	 * Returns all the duty logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty logs
	 * @param companyId the primary key of the company
	 * @return the matching duty logs, or an empty list if no matches were found
	 */
	public static List<DutyLog> getDutyLogsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDutyLogsByUuidAndCompanyId(uuid, companyId);
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
	public static List<DutyLog> getDutyLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLog> orderByComparator) {

		return getService().getDutyLogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty logs.
	 *
	 * @return the number of duty logs
	 */
	public static int getDutyLogsCount() {
		return getService().getDutyLogsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static DutyLog getPreviousDutyLog(long dutyLogId) {
		return getService().getPreviousDutyLog(dutyLogId);
	}

	public static DutyLog getPreviousDutyLog(
		long dutyLogId, long traineeId, long blockId,
		java.util.Date startDate) {

		return getService().getPreviousDutyLog(
			dutyLogId, traineeId, blockId, startDate);
	}

	public static boolean isTraineeLevel(
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster,
		List<gov.omsb.tms.custom.dto.TraineeLevelListDTO> traineeLevelList) {

		return getService().isTraineeLevel(
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
	public static DutyLog updateDutyLog(DutyLog dutyLog) {
		return getService().updateDutyLog(dutyLog);
	}

	public static DutyLogLocalService getService() {
		return _service;
	}

	private static volatile DutyLogLocalService _service;

}