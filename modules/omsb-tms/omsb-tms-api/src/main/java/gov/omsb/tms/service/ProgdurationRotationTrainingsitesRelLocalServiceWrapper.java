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
 * Provides a wrapper for {@link ProgdurationRotationTrainingsitesRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelLocalService
 * @generated
 */
public class ProgdurationRotationTrainingsitesRelLocalServiceWrapper
	implements ProgdurationRotationTrainingsitesRelLocalService,
			   ServiceWrapper
				   <ProgdurationRotationTrainingsitesRelLocalService> {

	public ProgdurationRotationTrainingsitesRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationRotationTrainingsitesRelLocalServiceWrapper(
		ProgdurationRotationTrainingsitesRelLocalService
			progdurationRotationTrainingsitesRelLocalService) {

		_progdurationRotationTrainingsitesRelLocalService =
			progdurationRotationTrainingsitesRelLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		addProgdurationRotationTrainingsitesRel(
			gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return _progdurationRotationTrainingsitesRelLocalService.
			addProgdurationRotationTrainingsitesRel(
				progdurationRotationTrainingsitesRel);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			addRotationsAndSlotsToTrainingSite(
				com.liferay.portal.kernel.json.JSONArray rotationJsonArray,
				long programDurationId, long trainingSiteId, long groupId,
				long createdBy) {

		return _progdurationRotationTrainingsitesRelLocalService.
			addRotationsAndSlotsToTrainingSite(
				rotationJsonArray, programDurationId, trainingSiteId, groupId,
				createdBy);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			addTrainingSitesByProgramCohort(
				long createdBy, long groupId, long programCohortId,
				java.util.List<Long> addTrainingSites) {

		return _progdurationRotationTrainingsitesRelLocalService.
			addTrainingSitesByProgramCohort(
				createdBy, groupId, programCohortId, addTrainingSites);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		createProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			createProgdurationRotationTrainingsitesRel(
				progdurationRotationTsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
			deletePersistedModel(persistedModel);
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
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
			deleteProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
			deleteProgdurationRotationTrainingsitesRel(
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
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		deleteProgdurationRotationTrainingsitesRel(
			gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return _progdurationRotationTrainingsitesRelLocalService.
			deleteProgdurationRotationTrainingsitesRel(
				progdurationRotationTrainingsitesRel);
	}

	@Override
	public boolean deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(
		long programCohortId, java.util.List<Long> deleteTrainingSiteIds) {

		return _progdurationRotationTrainingsitesRelLocalService.
			deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(
				programCohortId, deleteTrainingSiteIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationRotationTrainingsitesRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationRotationTrainingsitesRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationRotationTrainingsitesRelLocalService.dynamicQuery();
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

		return _progdurationRotationTrainingsitesRelLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _progdurationRotationTrainingsitesRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _progdurationRotationTrainingsitesRelLocalService.dynamicQuery(
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

		return _progdurationRotationTrainingsitesRelLocalService.
			dynamicQueryCount(dynamicQuery);
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

		return _progdurationRotationTrainingsitesRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			fetchProgdurationRotationTrainingsitesRel(
				progdurationRotationTsRelId);
	}

	/**
	 * Returns the progduration rotation trainingsites rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation trainingsites rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			fetchProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long progDurationId)
		throws gov.omsb.tms.exception.
			NoSuchProgdurationRotationTrainingsitesRelException {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgDurationAndTrainingSite(trainingSitesId, progDurationId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		findByProgDurationRotationOwningProgramAndRotationId(
			long durationId, long rotationOwningProgramId, long rotationId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgDurationRotationOwningProgramAndRotationId(
				durationId, rotationOwningProgramId, rotationId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		findByProgDurationTrainingSitesAndRotationId(
			long durationId, long trainingSitesId, long rotationId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgDurationTrainingSitesAndRotationId(
				durationId, trainingSitesId, rotationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByProgramDurationId(long programDurationId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgramDurationId(programDurationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByProgramDurationIdAndRotationIdAndIsSharedRotation(
				long programDurationId, long rotationId,
				boolean isSharedRotation) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgramDurationIdAndRotationIdAndIsSharedRotation(
				programDurationId, rotationId, isSharedRotation);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByProgramDurationIdAndTrainingSitesIds(
				long programDurationId, java.util.List<Long> trainingSiteIds) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByProgramDurationIdAndTrainingSitesIds(
				programDurationId, trainingSiteIds);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByRotationId(long rotationId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByRotationId(rotationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByRotationId(long rotationId, boolean isSharedRotation) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByRotationId(rotationId, isSharedRotation);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			findByTrainingSitesId(long trainingSitesId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findByTrainingSitesId(trainingSitesId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		findSlotsByTrainingSitesAndRotationId(
			long trainingSitesId, long rotationId) {

		return _progdurationRotationTrainingsitesRelLocalService.
			findSlotsByTrainingSitesAndRotationId(trainingSitesId, rotationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationRotationTrainingsitesRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationRotationTrainingsitesRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getNotSharedRotationsByTrainingSitesId(
			long trainingSiteId, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getNotSharedRotationsByTrainingSitesId(
				trainingSiteId, languageCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationRotationTrainingsitesRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws PortalException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
			getProgdurationRotationTrainingsitesRel(
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
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTrainingsitesRelLocalService.
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
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			getProgdurationRotationTrainingsitesRels(int start, int end) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getProgdurationRotationTrainingsitesRels(start, end);
	}

	/**
	 * Returns all the progduration rotation trainingsites rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation trainingsites rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation trainingsites rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _progdurationRotationTrainingsitesRelLocalService.
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
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
			getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel>
						orderByComparator) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
	 */
	@Override
	public int getProgdurationRotationTrainingsitesRelsCount() {
		return _progdurationRotationTrainingsitesRelLocalService.
			getProgdurationRotationTrainingsitesRelsCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO>
		getProgramTrainingSitesCapacityDetails(String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getProgramTrainingSitesCapacityDetails(languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTrainingSitesId(
			long trainingSiteId, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getRotationsByTrainingSitesId(trainingSiteId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.SiteCapacityDTO>
		getSiteCapacityDetails(String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getSiteCapacityDetails(languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgram(long programId, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getTrainingSiteDetailsByProgram(programId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgramMaster(
			long programId, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getTrainingSiteDetailsByProgramMaster(programId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByCohort(long programDuration, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getTrainingSitesByCohort(programDuration, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByProgramDuration(
			long programId, String programDuration, String languageCode) {

		return _progdurationRotationTrainingsitesRelLocalService.
			getTrainingSitesByProgramDuration(
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
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
		updateProgdurationRotationTrainingsitesRel(
			gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel) {

		return _progdurationRotationTrainingsitesRelLocalService.
			updateProgdurationRotationTrainingsitesRel(
				progdurationRotationTrainingsitesRel);
	}

	@Override
	public ProgdurationRotationTrainingsitesRelLocalService
		getWrappedService() {

		return _progdurationRotationTrainingsitesRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationRotationTrainingsitesRelLocalService
			progdurationRotationTrainingsitesRelLocalService) {

		_progdurationRotationTrainingsitesRelLocalService =
			progdurationRotationTrainingsitesRelLocalService;
	}

	private ProgdurationRotationTrainingsitesRelLocalService
		_progdurationRotationTrainingsitesRelLocalService;

}