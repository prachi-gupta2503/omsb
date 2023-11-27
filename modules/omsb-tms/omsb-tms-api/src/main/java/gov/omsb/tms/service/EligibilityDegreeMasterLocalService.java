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

import gov.omsb.tms.model.EligibilityDegreeMaster;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EligibilityDegreeMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EligibilityDegreeMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>gov.omsb.tms.service.impl.EligibilityDegreeMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the eligibility degree master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EligibilityDegreeMasterLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the eligibility degree master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EligibilityDegreeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 * @return the eligibility degree master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EligibilityDegreeMaster addEligibilityDegreeMaster(
		EligibilityDegreeMaster eligibilityDegreeMaster);

	/**
	 * Creates a new eligibility degree master with the primary key. Does not add the eligibility degree master to the database.
	 *
	 * @param eligibilityDegreeMasterId the primary key for the new eligibility degree master
	 * @return the new eligibility degree master
	 */
	@Transactional(enabled = false)
	public EligibilityDegreeMaster createEligibilityDegreeMaster(
		long eligibilityDegreeMasterId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the eligibility degree master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EligibilityDegreeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 * @return the eligibility degree master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EligibilityDegreeMaster deleteEligibilityDegreeMaster(
		EligibilityDegreeMaster eligibilityDegreeMaster);

	/**
	 * Deletes the eligibility degree master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EligibilityDegreeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master that was removed
	 * @throws PortalException if a eligibility degree master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EligibilityDegreeMaster deleteEligibilityDegreeMaster(
			long eligibilityDegreeMasterId)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EligibilityDegreeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EligibilityDegreeMasterModelImpl</code>.
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
	public EligibilityDegreeMaster fetchEligibilityDegreeMaster(
		long eligibilityDegreeMasterId);

	/**
	 * Returns the eligibility degree master matching the UUID and group.
	 *
	 * @param uuid the eligibility degree master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EligibilityDegreeMaster fetchEligibilityDegreeMasterByUuidAndGroupId(
		String uuid, long groupId);

	public List<EligibilityDegreeMaster> findByeligibilityDegreeByLike(
		String degreeName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the eligibility degree master with the primary key.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws PortalException if a eligibility degree master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EligibilityDegreeMaster getEligibilityDegreeMaster(
			long eligibilityDegreeMasterId)
		throws PortalException;

	/**
	 * Returns the eligibility degree master matching the UUID and group.
	 *
	 * @param uuid the eligibility degree master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching eligibility degree master
	 * @throws PortalException if a matching eligibility degree master could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EligibilityDegreeMaster getEligibilityDegreeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the eligibility degree masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.EligibilityDegreeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @return the range of eligibility degree masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EligibilityDegreeMaster> getEligibilityDegreeMasters(
		int start, int end);

	/**
	 * Returns all the eligibility degree masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the eligibility degree masters
	 * @param companyId the primary key of the company
	 * @return the matching eligibility degree masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EligibilityDegreeMaster>
		getEligibilityDegreeMastersByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of eligibility degree masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the eligibility degree masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of eligibility degree masters
	 * @param end the upper bound of the range of eligibility degree masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching eligibility degree masters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EligibilityDegreeMaster>
		getEligibilityDegreeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EligibilityDegreeMaster> orderByComparator);

	/**
	 * Returns the number of eligibility degree masters.
	 *
	 * @return the number of eligibility degree masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEligibilityDegreeMastersCount();

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
	 * Updates the eligibility degree master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EligibilityDegreeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eligibilityDegreeMaster the eligibility degree master
	 * @return the eligibility degree master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EligibilityDegreeMaster updateEligibilityDegreeMaster(
		EligibilityDegreeMaster eligibilityDegreeMaster);

}