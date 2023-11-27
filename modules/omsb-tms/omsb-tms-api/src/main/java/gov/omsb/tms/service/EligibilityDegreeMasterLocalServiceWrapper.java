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
 * Provides a wrapper for {@link EligibilityDegreeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterLocalService
 * @generated
 */
public class EligibilityDegreeMasterLocalServiceWrapper
	implements EligibilityDegreeMasterLocalService,
			   ServiceWrapper<EligibilityDegreeMasterLocalService> {

	public EligibilityDegreeMasterLocalServiceWrapper() {
		this(null);
	}

	public EligibilityDegreeMasterLocalServiceWrapper(
		EligibilityDegreeMasterLocalService
			eligibilityDegreeMasterLocalService) {

		_eligibilityDegreeMasterLocalService =
			eligibilityDegreeMasterLocalService;
	}

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
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		addEligibilityDegreeMaster(
			gov.omsb.tms.model.EligibilityDegreeMaster
				eligibilityDegreeMaster) {

		return _eligibilityDegreeMasterLocalService.addEligibilityDegreeMaster(
			eligibilityDegreeMaster);
	}

	/**
	 * Creates a new eligibility degree master with the primary key. Does not add the eligibility degree master to the database.
	 *
	 * @param eligibilityDegreeMasterId the primary key for the new eligibility degree master
	 * @return the new eligibility degree master
	 */
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		createEligibilityDegreeMaster(long eligibilityDegreeMasterId) {

		return _eligibilityDegreeMasterLocalService.
			createEligibilityDegreeMaster(eligibilityDegreeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

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
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		deleteEligibilityDegreeMaster(
			gov.omsb.tms.model.EligibilityDegreeMaster
				eligibilityDegreeMaster) {

		return _eligibilityDegreeMasterLocalService.
			deleteEligibilityDegreeMaster(eligibilityDegreeMaster);
	}

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
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
			deleteEligibilityDegreeMaster(long eligibilityDegreeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.
			deleteEligibilityDegreeMaster(eligibilityDegreeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _eligibilityDegreeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _eligibilityDegreeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eligibilityDegreeMasterLocalService.dynamicQuery();
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

		return _eligibilityDegreeMasterLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _eligibilityDegreeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _eligibilityDegreeMasterLocalService.dynamicQuery(
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

		return _eligibilityDegreeMasterLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _eligibilityDegreeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		fetchEligibilityDegreeMaster(long eligibilityDegreeMasterId) {

		return _eligibilityDegreeMasterLocalService.
			fetchEligibilityDegreeMaster(eligibilityDegreeMasterId);
	}

	/**
	 * Returns the eligibility degree master matching the UUID and group.
	 *
	 * @param uuid the eligibility degree master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching eligibility degree master, or <code>null</code> if a matching eligibility degree master could not be found
	 */
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		fetchEligibilityDegreeMasterByUuidAndGroupId(
			String uuid, long groupId) {

		return _eligibilityDegreeMasterLocalService.
			fetchEligibilityDegreeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.EligibilityDegreeMaster>
		findByeligibilityDegreeByLike(String degreeName) {

		return _eligibilityDegreeMasterLocalService.
			findByeligibilityDegreeByLike(degreeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eligibilityDegreeMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the eligibility degree master with the primary key.
	 *
	 * @param eligibilityDegreeMasterId the primary key of the eligibility degree master
	 * @return the eligibility degree master
	 * @throws PortalException if a eligibility degree master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
			getEligibilityDegreeMaster(long eligibilityDegreeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.getEligibilityDegreeMaster(
			eligibilityDegreeMasterId);
	}

	/**
	 * Returns the eligibility degree master matching the UUID and group.
	 *
	 * @param uuid the eligibility degree master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching eligibility degree master
	 * @throws PortalException if a matching eligibility degree master could not be found
	 */
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
			getEligibilityDegreeMasterByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.
			getEligibilityDegreeMasterByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<gov.omsb.tms.model.EligibilityDegreeMaster>
		getEligibilityDegreeMasters(int start, int end) {

		return _eligibilityDegreeMasterLocalService.getEligibilityDegreeMasters(
			start, end);
	}

	/**
	 * Returns all the eligibility degree masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the eligibility degree masters
	 * @param companyId the primary key of the company
	 * @return the matching eligibility degree masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.EligibilityDegreeMaster>
		getEligibilityDegreeMastersByUuidAndCompanyId(
			String uuid, long companyId) {

		return _eligibilityDegreeMasterLocalService.
			getEligibilityDegreeMastersByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<gov.omsb.tms.model.EligibilityDegreeMaster>
		getEligibilityDegreeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.EligibilityDegreeMaster>
					orderByComparator) {

		return _eligibilityDegreeMasterLocalService.
			getEligibilityDegreeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of eligibility degree masters.
	 *
	 * @return the number of eligibility degree masters
	 */
	@Override
	public int getEligibilityDegreeMastersCount() {
		return _eligibilityDegreeMasterLocalService.
			getEligibilityDegreeMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _eligibilityDegreeMasterLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eligibilityDegreeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eligibilityDegreeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eligibilityDegreeMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

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
	@Override
	public gov.omsb.tms.model.EligibilityDegreeMaster
		updateEligibilityDegreeMaster(
			gov.omsb.tms.model.EligibilityDegreeMaster
				eligibilityDegreeMaster) {

		return _eligibilityDegreeMasterLocalService.
			updateEligibilityDegreeMaster(eligibilityDegreeMaster);
	}

	@Override
	public EligibilityDegreeMasterLocalService getWrappedService() {
		return _eligibilityDegreeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		EligibilityDegreeMasterLocalService
			eligibilityDegreeMasterLocalService) {

		_eligibilityDegreeMasterLocalService =
			eligibilityDegreeMasterLocalService;
	}

	private EligibilityDegreeMasterLocalService
		_eligibilityDegreeMasterLocalService;

}