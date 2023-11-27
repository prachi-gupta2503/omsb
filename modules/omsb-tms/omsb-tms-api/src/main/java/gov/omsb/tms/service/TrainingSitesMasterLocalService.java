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

import gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO;
import gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.model.TrainingSitesMaster;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TrainingSitesMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingSitesMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TrainingSitesMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TrainingSitesMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the training sites master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TrainingSitesMasterLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the training sites master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TrainingSitesMaster addTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new training sites master with the primary key. Does not add the training sites master to the database.
	 *
	 * @param trainingSiteMasterId the primary key for the new training sites master
	 * @return the new training sites master
	 */
	@Transactional(enabled = false)
	public TrainingSitesMaster createTrainingSitesMaster(
		long trainingSiteMasterId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the training sites master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master that was removed
	 * @throws PortalException if a training sites master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TrainingSitesMaster deleteTrainingSitesMaster(
			long trainingSiteMasterId)
		throws PortalException;

	/**
	 * Deletes the training sites master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TrainingSitesMaster deleteTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
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
	public TrainingSitesMaster fetchTrainingSitesMaster(
		long trainingSiteMasterId);

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master, or <code>null</code> if a matching training sites master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrainingSitesMaster fetchTrainingSitesMasterByUuidAndGroupId(
		String uuid, long groupId);

	public List<TrainingSitesMaster> findByProgramStatus(
		Boolean trainingSiteStatus);

	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(
		String trainingSiteCode);

	public List<TrainingSitesMaster> findByTrainingSiteMasterIds(
		List<Long> trainingSiteIds);

	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(
		String trainingSiteName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgdurationRotationTrainingSiteDTO>
		getProgdurationRotationByRotationAndDuration(
			long rotationId, String duration, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSitesMaster> getTrainigSitesListByIdsAndStatus(
		List<Long> ids, Boolean status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrainingSitesMaster getTrainingSiteByDatePerformed(
		String datePerformed, long traineeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteNameWithRotationDTO>
		getTrainingSiteNameWithRotation(String languageCode, long programId);

	/**
	 * Returns the training sites master with the primary key.
	 *
	 * @param trainingSiteMasterId the primary key of the training sites master
	 * @return the training sites master
	 * @throws PortalException if a training sites master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrainingSitesMaster getTrainingSitesMaster(long trainingSiteMasterId)
		throws PortalException;

	/**
	 * Returns the training sites master matching the UUID and group.
	 *
	 * @param uuid the training sites master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching training sites master
	 * @throws PortalException if a matching training sites master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrainingSitesMaster getTrainingSitesMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the training sites masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TrainingSitesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @return the range of training sites masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSitesMaster> getTrainingSitesMasters(
		int start, int end);

	/**
	 * Returns all the training sites masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the training sites masters
	 * @param companyId the primary key of the company
	 * @return the matching training sites masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSitesMaster> getTrainingSitesMastersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of training sites masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the training sites masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of training sites masters
	 * @param end the upper bound of the range of training sites masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching training sites masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSitesMaster> getTrainingSitesMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TrainingSitesMaster> orderByComparator);

	/**
	 * Returns the number of training sites masters.
	 *
	 * @return the number of training sites masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTrainingSitesMastersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrainingSiteStructureDTO> getTrainingSiteStructure(
		List<Long> programMasterIds, String programDuration,
		long trainingSiteId, String languageCode);

	/**
	 * Updates the training sites master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingSitesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingSitesMaster the training sites master
	 * @return the training sites master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TrainingSitesMaster updateTrainingSitesMaster(
		TrainingSitesMaster trainingSitesMaster);

}