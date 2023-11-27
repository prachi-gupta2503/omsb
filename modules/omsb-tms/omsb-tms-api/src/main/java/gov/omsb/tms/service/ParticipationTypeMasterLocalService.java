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

import gov.omsb.tms.model.ParticipationTypeMaster;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ParticipationTypeMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ParticipationTypeMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ParticipationTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the participation type master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ParticipationTypeMasterLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the participation type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ParticipationTypeMaster addParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster);

	public ParticipationTypeMaster addUpdateParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster,
		List<String> participationTypeNames, boolean isCreate);

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	@Transactional(enabled = false)
	public ParticipationTypeMaster createParticipationTypeMaster(
		long participationTypeMasterId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ParticipationTypeMaster deleteParticipationTypeMaster(
			long participationTypeMasterId)
		throws PortalException;

	/**
	 * Deletes the participation type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ParticipationTypeMaster deleteParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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
	public ParticipationTypeMaster fetchParticipationTypeMaster(
		long participationTypeMasterId);

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ParticipationTypeMaster fetchParticipationTypeMasterByUuidAndGroupId(
		String uuid, long groupId);

	public List<ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId);

	public List<ParticipationTypeMaster> findByProgramDurationId(
		long programDurationId);

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
	 * Returns the participation type master with the primary key.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ParticipationTypeMaster getParticipationTypeMaster(
			long participationTypeMasterId)
		throws PortalException;

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master
	 * @throws PortalException if a matching participation type master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ParticipationTypeMaster getParticipationTypeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of participation type masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ParticipationTypeMaster> getParticipationTypeMasters(
		int start, int end);

	/**
	 * Returns all the participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @return the matching participation type masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching participation type masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ParticipationTypeMaster> orderByComparator);

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getParticipationTypeMastersCount();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the participation type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ParticipationTypeMaster updateParticipationTypeMaster(
		ParticipationTypeMaster participationTypeMaster);

	public Boolean validateParticipationTypeNames(
		List<String> participationTypeNames, long programDurationId,
		ParticipationTypeMaster participationTypeMaster);

}