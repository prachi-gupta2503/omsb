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

import gov.omsb.tms.model.DutyLogViolation;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DutyLogViolation. This utility wraps
 * <code>gov.omsb.tms.service.impl.DutyLogViolationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationLocalService
 * @generated
 */
public class DutyLogViolationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyLogViolationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DutyLogViolation addDutyLogViolation(
		DutyLogViolation dutyLogViolation) {

		return getService().addDutyLogViolation(dutyLogViolation);
	}

	public static DutyLogViolation addDutyLogViolation(
		long groupId, long companyId, long createdBy, long modifiedBy,
		long traineeId, long dutyLogId, long programMasterId,
		long residencyLevel, long rotationId, long trainingSiteId, long blockId,
		long blockWeekId, long programDutyRuleId) {

		return getService().addDutyLogViolation(
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
	public static DutyLogViolation createDutyLogViolation(long ViolationId) {
		return getService().createDutyLogViolation(ViolationId);
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
	 * Deletes the duty log violation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyLogViolationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyLogViolation the duty log violation
	 * @return the duty log violation that was removed
	 */
	public static DutyLogViolation deleteDutyLogViolation(
		DutyLogViolation dutyLogViolation) {

		return getService().deleteDutyLogViolation(dutyLogViolation);
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
	public static DutyLogViolation deleteDutyLogViolation(long ViolationId)
		throws PortalException {

		return getService().deleteDutyLogViolation(ViolationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyLogViolationModelImpl</code>.
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

	public static DutyLogViolation fetchDutyLogViolation(long ViolationId) {
		return getService().fetchDutyLogViolation(ViolationId);
	}

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation, or <code>null</code> if a matching duty log violation could not be found
	 */
	public static DutyLogViolation fetchDutyLogViolationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDutyLogViolationByUuidAndGroupId(
			uuid, groupId);
	}

	public static DutyLogViolation findByDutyLogId(long dutyLogId) {
		return getService().findByDutyLogId(dutyLogId);
	}

	public static DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(
		long traineeId, long blockId, long programMasterId, long dutyLogId) {

		return getService().findByTraineeAndBlockAndProgramAndDutyLogId(
			traineeId, blockId, programMasterId, dutyLogId);
	}

	public static DutyLogViolation findByTraineeId(long traineeId) {
		return getService().findByTraineeId(traineeId);
	}

	public static List<DutyLogViolation> findByTraineeIdAndBlockId(
		long traineeId, long blockId) {

		return getService().findByTraineeIdAndBlockId(traineeId, blockId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the duty log violation with the primary key.
	 *
	 * @param ViolationId the primary key of the duty log violation
	 * @return the duty log violation
	 * @throws PortalException if a duty log violation with the primary key could not be found
	 */
	public static DutyLogViolation getDutyLogViolation(long ViolationId)
		throws PortalException {

		return getService().getDutyLogViolation(ViolationId);
	}

	/**
	 * Returns the duty log violation matching the UUID and group.
	 *
	 * @param uuid the duty log violation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty log violation
	 * @throws PortalException if a matching duty log violation could not be found
	 */
	public static DutyLogViolation getDutyLogViolationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDutyLogViolationByUuidAndGroupId(uuid, groupId);
	}

	public static List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationList(
			long programId, long traineeCohortId, long residencyLevelId,
			long traineeId) {

		return getService().getDutyLogViolationList(
			programId, traineeCohortId, residencyLevelId, traineeId);
	}

	public static List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationListByUserId(long traineeId) {

		return getService().getDutyLogViolationListByUserId(traineeId);
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
	public static List<DutyLogViolation> getDutyLogViolations(
		int start, int end) {

		return getService().getDutyLogViolations(start, end);
	}

	/**
	 * Returns all the duty log violations matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty log violations
	 * @param companyId the primary key of the company
	 * @return the matching duty log violations, or an empty list if no matches were found
	 */
	public static List<DutyLogViolation> getDutyLogViolationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDutyLogViolationsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<DutyLogViolation> getDutyLogViolationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DutyLogViolation> orderByComparator) {

		return getService().getDutyLogViolationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty log violations.
	 *
	 * @return the number of duty log violations
	 */
	public static int getDutyLogViolationsCount() {
		return getService().getDutyLogViolationsCount();
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
	public static DutyLogViolation updateDutyLogViolation(
		DutyLogViolation dutyLogViolation) {

		return getService().updateDutyLogViolation(dutyLogViolation);
	}

	public static DutyLogViolationLocalService getService() {
		return _service;
	}

	private static volatile DutyLogViolationLocalService _service;

}