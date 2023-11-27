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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.model.TraineeLevelMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TraineeLevelMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TraineeLevelMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.TraineeLevelMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the trainee level master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TraineeLevelMasterLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addLocalizedValue(
		Map<Locale, String> localizationMap, List<String> values,
		String languageCode);

	/**
	 * Adds the trainee level master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TraineeLevelMaster addTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster);

	public boolean checkTraineeLevel(
		List<String> traineeLevelNames, ActionRequest actionRequest,
		TraineeLevelMaster traineeLevelMaster);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public boolean createTraineeLevelMaster(
		ActionRequest actionRequest, ThemeDisplay themeDisplay);

	/**
	 * Creates a new trainee level master with the primary key. Does not add the trainee level master to the database.
	 *
	 * @param traineeLevelMasterId the primary key for the new trainee level master
	 * @return the new trainee level master
	 */
	@Transactional(enabled = false)
	public TraineeLevelMaster createTraineeLevelMaster(
		long traineeLevelMasterId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the trainee level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master that was removed
	 * @throws PortalException if a trainee level master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TraineeLevelMaster deleteTraineeLevelMaster(
			long traineeLevelMasterId)
		throws PortalException;

	/**
	 * Deletes the trainee level master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TraineeLevelMaster deleteTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
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
	public TraineeLevelMaster fetchTraineeLevelMaster(
		long traineeLevelMasterId);

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLevelMaster fetchTraineeLevelMasterByUuidAndGroupId(
		String uuid, long groupId);

	public List<TraineeLevelMaster> findByTraineeLevelIds(
		List<Long> traineeLevelIds);

	public List<TraineeLevelMaster> findByTraineeLevelName(
		String traineeLevelName);

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
	public List<TraineeLevelListDTO> getTraineeLevelListByDurationId(
		long durationId);

	/**
	 * Returns the trainee level master with the primary key.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws PortalException if a trainee level master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLevelMaster getTraineeLevelMaster(long traineeLevelMasterId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProgramStructureDTO> getTraineeLevelMasterByProgramId(
		long programId);

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master
	 * @throws PortalException if a matching trainee level master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraineeLevelMaster getTraineeLevelMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the trainee level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.TraineeLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @return the range of trainee level masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLevelMaster> getTraineeLevelMasters(int start, int end);

	/**
	 * Returns all the trainee level masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee level masters
	 * @param companyId the primary key of the company
	 * @return the matching trainee level masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLevelMaster> getTraineeLevelMastersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of trainee level masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee level masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trainee level masters
	 * @param end the upper bound of the range of trainee level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trainee level masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraineeLevelMaster> getTraineeLevelMastersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLevelMaster> orderByComparator);

	/**
	 * Returns the number of trainee level masters.
	 *
	 * @return the number of trainee level masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTraineeLevelMastersCount();

	public boolean updateTraineeLevelMaster(
			ActionRequest actionRequest, long traineeLevelMasterId,
			ThemeDisplay themeDisplay)
		throws PortalException;

	/**
	 * Updates the trainee level master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TraineeLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param traineeLevelMaster the trainee level master
	 * @return the trainee level master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TraineeLevelMaster updateTraineeLevelMaster(
		TraineeLevelMaster traineeLevelMaster);

	public boolean validateTraineeLevel(
		ActionRequest actionRequest, TraineeLevelMaster traineeLevelMaster);

}