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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.SiteCapacityDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTrainingsitesRelException;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProgdurationRotationTrainingsitesRel. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTrainingsitesRelLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProgdurationRotationTrainingsitesRelLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationRotationTrainingsitesRelLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the progduration rotation trainingsites rel local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProgdurationRotationTrainingsitesRelLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public ProgdurationRotationTrainingsitesRel
		addProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel);

	public List<ProgdurationRotationTrainingsitesRel>
		addRotationsAndSlotsToTrainingSite(
			JSONArray rotationJsonArray, long programDurationId,
			long trainingSiteId, long groupId, long createdBy);

	public List<ProgdurationRotationTrainingsitesRel>
		addTrainingSitesByProgramCohort(
			long createdBy, long groupId, long programCohortId,
			List<Long> addTrainingSites);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new progduration rotation trainingsites rel with the primary key. Does not add the progduration rotation trainingsites rel to the database.
	 *
	 * @param progdurationRotationTsRelId the primary key for the new progduration rotation trainingsites rel
	 * @return the new progduration rotation trainingsites rel
	 */
	@Transactional(enabled = false)
	public ProgdurationRotationTrainingsitesRel
		createProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public ProgdurationRotationTrainingsitesRel
			deleteProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public ProgdurationRotationTrainingsitesRel
		deleteProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel);

	public boolean deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(
		long programCohortId, List<Long> deleteTrainingSiteIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRel(
			long progdurationRotationTsRelId);

	/**
	 * Returns the progduration rotation trainingsites rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation trainingsites rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation trainingsites rel, or <code>null</code> if a matching progduration rotation trainingsites rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTrainingsitesRel
		fetchProgdurationRotationTrainingsitesRelByUuidAndGroupId(
			String uuid, long groupId);

	public ProgdurationRotationTrainingsitesRel
			findByProgDurationAndTrainingSite(
				long trainingSitesId, long progDurationId)
		throws NoSuchProgdurationRotationTrainingsitesRelException;

	public ProgdurationRotationTrainingsitesRel
		findByProgDurationRotationOwningProgramAndRotationId(
			long durationId, long rotationOwningProgramId, long rotationId);

	public ProgdurationRotationTrainingsitesRel
		findByProgDurationTrainingSitesAndRotationId(
			long durationId, long trainingSitesId, long rotationId);

	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(
		long programDurationId);

	public List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationIdAndRotationIdAndIsSharedRotation(
			long programDurationId, long rotationId, boolean isSharedRotation);

	public List<ProgdurationRotationTrainingsitesRel>
		findByProgramDurationIdAndTrainingSitesIds(
			long programDurationId, List<Long> trainingSiteIds);

	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId);

	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(
		long rotationId, boolean isSharedRotation);

	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(
		long trainingSitesId);

	public ProgdurationRotationTrainingsitesRel
		findSlotsByTrainingSitesAndRotationId(
			long trainingSitesId, long rotationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationListDTO> getNotSharedRotationsByTrainingSitesId(
		long trainingSiteId, String languageCode);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the progduration rotation trainingsites rel with the primary key.
	 *
	 * @param progdurationRotationTsRelId the primary key of the progduration rotation trainingsites rel
	 * @return the progduration rotation trainingsites rel
	 * @throws PortalException if a progduration rotation trainingsites rel with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRel(
				long progdurationRotationTsRelId)
		throws PortalException;

	/**
	 * Returns the progduration rotation trainingsites rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation trainingsites rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation trainingsites rel
	 * @throws PortalException if a matching progduration rotation trainingsites rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTrainingsitesRel
			getProgdurationRotationTrainingsitesRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRels(int start, int end);

	/**
	 * Returns all the progduration rotation trainingsites rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation trainingsites rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation trainingsites rels, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
			String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTrainingsitesRel>
		getProgdurationRotationTrainingsitesRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTrainingsitesRel>
				orderByComparator);

	/**
	 * Returns the number of progduration rotation trainingsites rels.
	 *
	 * @return the number of progduration rotation trainingsites rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProgdurationRotationTrainingsitesRelsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSitesCapacityDTO>
		getProgramTrainingSitesCapacityDetails(String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationListDTO> getRotationsByTrainingSitesId(
		long trainingSiteId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SiteCapacityDTO> getSiteCapacityDetails(String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgram(
		long programId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgramMaster(
		long programId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteByPdDTO> getTrainingSitesByCohort(
		long programDuration, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteByPdDTO> getTrainingSitesByProgramDuration(
		long programId, String programDuration, String languageCode);

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
	@Indexable(type = IndexableType.REINDEX)
	public ProgdurationRotationTrainingsitesRel
		updateProgdurationRotationTrainingsitesRel(
			ProgdurationRotationTrainingsitesRel
				progdurationRotationTrainingsitesRel);

}