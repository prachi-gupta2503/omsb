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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTraineelevelBlocksRelException;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ProgdurationRotationTraineelevelBlocksRel. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTraineelevelBlocksRelLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProgdurationRotationTraineelevelBlocksRelLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the progduration rotation traineelevel blocks rel local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProgdurationRotationTraineelevelBlocksRelLocalServiceUtil} if injection and service tracking are not available.
	 */
	public List<ProgdurationRotationTraineelevelBlocksRel>
		addProgdurationRotationTraineelevelBlocksRel(
			List<ProgdurationTraineelevelBlocksLevelTypeRel>
				progdurationTraineelevelBlocksLevelTypeRels,
			long rotationId, long groupId, long createdBy);

	/**
	 * Adds the progduration rotation traineelevel blocks rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProgdurationRotationTraineelevelBlocksRel
		addProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new progduration rotation traineelevel blocks rel with the primary key. Does not add the progduration rotation traineelevel blocks rel to the database.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key for the new progduration rotation traineelevel blocks rel
	 * @return the new progduration rotation traineelevel blocks rel
	 */
	@Transactional(enabled = false)
	public ProgdurationRotationTraineelevelBlocksRel
		createProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the progduration rotation traineelevel blocks rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 * @throws PortalException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProgdurationRotationTraineelevelBlocksRel
			deleteProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws PortalException;

	/**
	 * Deletes the progduration rotation traineelevel blocks rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ProgdurationRotationTraineelevelBlocksRel
		deleteProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
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
	public ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRel(
			long progdurationRotationTlBlocksRelId);

	/**
	 * Returns the progduration rotation traineelevel blocks rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation traineelevel blocks rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation traineelevel blocks rel, or <code>null</code> if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTraineelevelBlocksRel
		fetchProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
			String uuid, long groupId);

	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndRotationId(
			long programDurationId, long rotationId);

	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId);

	public ProgdurationRotationTraineelevelBlocksRel
			findByProgramDurationIdAndTraineeLevelIdAndRotationId(
				long traineeLevelId, long programDurationId, long rotationId)
		throws NoSuchProgdurationRotationTraineelevelBlocksRelException;

	public List<ProgdurationRotationTraineelevelBlocksRel>
		findByTraineeLevelIdAndRotationType(
			long traineeLevelId, long rotationType);

	public List<ProgdurationRotationTraineelevelBlocksRel>
		findRotationByTraineeLevelId(long traineeLevelId);

	public List<ProgdurationRotationTraineelevelBlocksRel>
		findTraineeLevelByDurationId(long durationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConfigureRotationDetailsDTO> getConfigureRotationDetails(
		String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConfigureRotationEditDetailsDTO>
		getConfigureRotationDetailsByProgramAndDuration(
			long programId, long traineeLevelId, long programDurationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConfigureRotationBlockDetailsDTO
		getConfigureRotationDetailsByRotationAndDuration(
			long rotationId, String duration);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	 * Returns the progduration rotation traineelevel blocks rel with the primary key.
	 *
	 * @param progdurationRotationTlBlocksRelId the primary key of the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel
	 * @throws PortalException if a progduration rotation traineelevel blocks rel with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRel(
				long progdurationRotationTlBlocksRelId)
		throws PortalException;

	/**
	 * Returns the progduration rotation traineelevel blocks rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation traineelevel blocks rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation traineelevel blocks rel
	 * @throws PortalException if a matching progduration rotation traineelevel blocks rel could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProgdurationRotationTraineelevelBlocksRel
			getProgdurationRotationTraineelevelBlocksRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the progduration rotation traineelevel blocks rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTraineelevelBlocksRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @return the range of progduration rotation traineelevel blocks rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRels(int start, int end);

	/**
	 * Returns all the progduration rotation traineelevel blocks rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation traineelevel blocks rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation traineelevel blocks rels, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of progduration rotation traineelevel blocks rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation traineelevel blocks rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation traineelevel blocks rels
	 * @param end the upper bound of the range of progduration rotation traineelevel blocks rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation traineelevel blocks rels, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTraineelevelBlocksRel>
		getProgdurationRotationTraineelevelBlocksRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProgdurationRotationTraineelevelBlocksRel>
				orderByComparator);

	/**
	 * Returns the number of progduration rotation traineelevel blocks rels.
	 *
	 * @return the number of progduration rotation traineelevel blocks rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProgdurationRotationTraineelevelBlocksRelsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationTraineeBlockRelationDTO> getTraineeNoofBlocks(
		long programDurationId, long traineeLevelId, String languageCode);

	/**
	 * Updates the progduration rotation traineelevel blocks rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTraineelevelBlocksRel the progduration rotation traineelevel blocks rel
	 * @return the progduration rotation traineelevel blocks rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ProgdurationRotationTraineelevelBlocksRel
		updateProgdurationRotationTraineelevelBlocksRel(
			ProgdurationRotationTraineelevelBlocksRel
				progdurationRotationTraineelevelBlocksRel);

}