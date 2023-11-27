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

import gov.omsb.tms.custom.dto.RotationDTO;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.RotationStructureDTO;
import gov.omsb.tms.model.RotationMaster;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for RotationMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RotationMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RotationMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.RotationMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the rotation master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RotationMasterLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the rotation master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RotationMaster addRotationMaster(RotationMaster rotationMaster);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	@Transactional(enabled = false)
	public RotationMaster createRotationMaster(long rotationMasterId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public RotationMaster deleteRotationMaster(long rotationMasterId)
		throws PortalException;

	/**
	 * Deletes the rotation master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public RotationMaster deleteRotationMaster(RotationMaster rotationMaster);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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
	public RotationMaster fetchRotationMaster(long rotationMasterId);

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RotationMaster fetchRotationMasterByUuidAndGroupId(
		String uuid, long groupId);

	public List<RotationMaster> findByRotationCodeByLike(String rotationCode);

	public List<RotationMaster> findByRotationNameByLike(String rotationName);

	public List<RotationMaster> findByRotationStatus(Boolean rotationStatus);

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
	public List<RotationMaster> getRotationListByIdsAndStatus(
		List<Long> ids, Boolean status);

	/**
	 * Returns the rotation master with the primary key.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RotationMaster getRotationMaster(long rotationMasterId)
		throws PortalException;

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master
	 * @throws PortalException if a matching rotation master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RotationMaster getRotationMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationMaster> getRotationMasters(int start, int end);

	/**
	 * Returns all the rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @return the matching rotation masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationMaster> getRotationMastersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationMaster> getRotationMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationMaster> orderByComparator);

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRotationMastersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationListDTO> getRotationsByTraineeLevelId(
		long traineeLevelId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationListDTO>
		getRotationsByTraineeLevelIdAndProgramDurationId(
			long traineeLevelId, long programDurationId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationDTO> getRotationsByTrainingSiteAndCohort(
		long trainingSiteId, long programDurationId, String languageCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RotationStructureDTO> getRotationStructure(
		long rotationId, String languageCode);

	/**
	 * Updates the rotation master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RotationMaster updateRotationMaster(RotationMaster rotationMaster);

}