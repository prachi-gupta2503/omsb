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

import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProgdurationRotationTrainingsitesRel. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgdurationRotationTrainingsitesRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelLocalService
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationRotationTrainingsitesRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the progduration rotation trainingsites rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTrainingsitesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was added
	 */
	public static ProgdurationRotationTrainingsitesRel
		addProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return getService().addProgdurationRotationTrainingsitesRel(
			progdurationRotationTrainingsitesRel);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		addRotationsAndSlotsToTrainingSite(
			com.liferay.portal.kernel.json.JSONArray rotationJsonArray,
			long programDurationId, long trainingSiteId, long groupId,
			long createdBy) {

		return getService().addRotationsAndSlotsToTrainingSite(
			rotationJsonArray, programDurationId, trainingSiteId, groupId,
			createdBy);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		addTrainingSitesByProgramCohort(
			long createdBy, long groupId, long programCohortId,
			List<Long> addTrainingSites) {

		return getService().addTrainingSitesByProgramCohort(
			createdBy, groupId, programCohortId, addTrainingSites);
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
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	public static ProgdurationRotationTrainingsitesRel
		createProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId) {

		return getService().createProgdurationRotationTrainingsitesRel(
			progdurationRotationTsRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the progduration rotation trainingsites rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTrainingsitesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 * @throws PortalException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			deleteProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws PortalException {

		return getService().deleteProgdurationRotationTrainingsitesRel(
			progdurationRotationTsRelId);
	}

	/**
	 * Deletes the progduration rotation trainingsites rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTrainingsitesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was removed
	 */
	public static ProgdurationRotationTrainingsitesRel
		deleteProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return getService().deleteProgdurationRotationTrainingsitesRel(
			progdurationRotationTrainingsitesRel);
	}

	public static boolean
		deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(
			long programCohortId, List<Long> deleteTrainingSiteIds) {

		return getService().
			deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(
				programCohortId, deleteTrainingSiteIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTrainingsitesRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTrainingsitesRelModelImpl</code>.
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

	public static ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId) {

		return getService().fetchProgdurationRotationTrainingsitesRel(
			progdurationRotationTsRelId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation trainingsites rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRelByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().
			fetchProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				uuid, groupId);
	}

	public static ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long progDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return getService().findByProgDurationAndTrainingSite(
			trainingSitesId, progDurationId);
	}

	public static ProgdurationRotationTrainingsitesRel
		findByProgDurationRotationOwningProgramAndRotationId(
			long durationId, long rotationOwningProgramId, long rotationId) {

		return getService().
			findByProgDurationRotationOwningProgramAndRotationId(
				durationId, rotationOwningProgramId, rotationId);
	}

	public static ProgdurationRotationTrainingsitesRel
		findByProgDurationTrainingSitesAndRotationId(
			long durationId, long trainingSitesId, long rotationId) {

		return getService().findByProgDurationTrainingSitesAndRotationId(
			durationId, trainingSitesId, rotationId);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationId(long programDurationId) {

		return getService().findByProgramDurationId(programDurationId);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationIdAndRotationIdAndIsSharedRotation(
			long programDurationId, long rotationId, boolean isSharedRotation) {

		return getService().
			findByProgramDurationIdAndRotationIdAndIsSharedRotation(
				programDurationId, rotationId, isSharedRotation);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationIdAndTrainingSitesIds(
			long programDurationId, List<Long> trainingSiteIds) {

		return getService().findByProgramDurationIdAndTrainingSitesIds(
			programDurationId, trainingSiteIds);
	}

	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId) {

		return getService().findByRotationId(rotationId);
	}

	public static List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, boolean isSharedRotation) {

		return getService().findByRotationId(rotationId, isSharedRotation);
	}

	public static List<ProgdurationRotationTrainingsitesRel>
		findByTrainingSitesId(long trainingSitesId) {

		return getService().findByTrainingSitesId(trainingSitesId);
	}

	public static ProgdurationRotationTrainingsitesRel
		findSlotsByTrainingSitesAndRotationId(
			long trainingSitesId, long rotationId) {

		return getService().findSlotsByTrainingSitesAndRotationId(
			trainingSitesId, rotationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static List<gov.omsb.tms.custom.dto.RotationListDTO>
		getNotSharedRotationsByTrainingSitesId(
			long trainingSiteId, String languageCode) {

		return getService().getNotSharedRotationsByTrainingSitesId(
			trainingSiteId, languageCode);
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
	 * Returns the progduration rotation trainingsites rel with the primary key.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws PortalException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws PortalException {

		return getService().getProgdurationRotationTrainingsitesRel(
			progdurationRotationTsRelId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation trainingsites rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation trainingsites rel
	 * @throws PortalException if a matching progduration rotation trainingsites rel could not be found
	 */
	public static ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().
			getProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration rotation trainingsites rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTrainingsitesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @return the range of progduration rotation trainingsites rels
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRels(int start, int end) {

		return getService().getProgdurationRotationTrainingsitesRels(
			start, end);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation trainingsites rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation trainingsites rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration rotation trainingsites rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation trainingsites rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation trainingsites rels
	 * @param end the upper bound of the range of progduration rotation trainingsites rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation trainingsites rels, or an empty list if no matches were found
	 */
	public static List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator) {

		return getService().
			getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
	 */
	public static int getProgdurationRotationTrainingsitesRelsCount() {
		return getService().getProgdurationRotationTrainingsitesRelsCount();
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO>
		getProgramTrainingSitesCapacityDetails(String languageCode) {

		return getService().getProgramTrainingSitesCapacityDetails(
			languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTrainingSitesId(
			long trainingSiteId, String languageCode) {

		return getService().getRotationsByTrainingSitesId(
			trainingSiteId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.SiteCapacityDTO>
		getSiteCapacityDetails(String languageCode) {

		return getService().getSiteCapacityDetails(languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgram(long programId, String languageCode) {

		return getService().getTrainingSiteDetailsByProgram(
			programId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgramMaster(
			long programId, String languageCode) {

		return getService().getTrainingSiteDetailsByProgramMaster(
			programId, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByCohort(long programDuration, String languageCode) {

		return getService().getTrainingSitesByCohort(
			programDuration, languageCode);
	}

	public static List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByProgramDuration(
			long programId, String programDuration, String languageCode) {

		return getService().getTrainingSitesByProgramDuration(
			programId, programDuration, languageCode);
	}

	/**
	 * Updates the progduration rotation trainingsites rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTrainingsitesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTrainingsitesRel the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel that was updated
	 */
	public static ProgdurationRotationTrainingsitesRel
		updateProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return getService().updateProgdurationRotationTrainingsitesRel(
			progdurationRotationTrainingsitesRel);
	}

	public static ProgdurationRotationTrainingsitesRelLocalService
		getService() {

		return _service;
	}

	private static volatile ProgdurationRotationTrainingsitesRelLocalService
		_service;

}