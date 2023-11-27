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
 * Provides a wrapper for {@link CompetenciesMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompetenciesMasterLocalService
 * @generated
 */
public class CompetenciesMasterLocalServiceWrapper
	implements CompetenciesMasterLocalService,
			   ServiceWrapper<CompetenciesMasterLocalService> {

	public CompetenciesMasterLocalServiceWrapper() {
		this(null);
	}

	public CompetenciesMasterLocalServiceWrapper(
		CompetenciesMasterLocalService competenciesMasterLocalService) {

		_competenciesMasterLocalService = competenciesMasterLocalService;
	}

	/**
	 * Adds the competencies master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompetenciesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param competenciesMaster the competencies master
	 * @return the competencies master that was added
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster addCompetenciesMaster(
		gov.omsb.tms.model.CompetenciesMaster competenciesMaster) {

		return _competenciesMasterLocalService.addCompetenciesMaster(
			competenciesMaster);
	}

	/**
	 * Creates a new competencies master with the primary key. Does not add the competencies master to the database.
	 *
	 * @param competenciesMasterId the primary key for the new competencies master
	 * @return the new competencies master
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster createCompetenciesMaster(
		long competenciesMasterId) {

		return _competenciesMasterLocalService.createCompetenciesMaster(
			competenciesMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the competencies master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompetenciesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param competenciesMaster the competencies master
	 * @return the competencies master that was removed
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster deleteCompetenciesMaster(
		gov.omsb.tms.model.CompetenciesMaster competenciesMaster) {

		return _competenciesMasterLocalService.deleteCompetenciesMaster(
			competenciesMaster);
	}

	/**
	 * Deletes the competencies master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompetenciesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master that was removed
	 * @throws PortalException if a competencies master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster deleteCompetenciesMaster(
			long competenciesMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.deleteCompetenciesMaster(
			competenciesMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _competenciesMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _competenciesMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _competenciesMasterLocalService.dynamicQuery();
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

		return _competenciesMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CompetenciesMasterModelImpl</code>.
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

		return _competenciesMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CompetenciesMasterModelImpl</code>.
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

		return _competenciesMasterLocalService.dynamicQuery(
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

		return _competenciesMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _competenciesMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.CompetenciesMaster fetchCompetenciesMaster(
		long competenciesMasterId) {

		return _competenciesMasterLocalService.fetchCompetenciesMaster(
			competenciesMasterId);
	}

	/**
	 * Returns the competencies master matching the UUID and group.
	 *
	 * @param uuid the competencies master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching competencies master, or <code>null</code> if a matching competencies master could not be found
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster
		fetchCompetenciesMasterByUuidAndGroupId(String uuid, long groupId) {

		return _competenciesMasterLocalService.
			fetchCompetenciesMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _competenciesMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the competencies master with the primary key.
	 *
	 * @param competenciesMasterId the primary key of the competencies master
	 * @return the competencies master
	 * @throws PortalException if a competencies master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster getCompetenciesMaster(
			long competenciesMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.getCompetenciesMaster(
			competenciesMasterId);
	}

	/**
	 * Returns the competencies master matching the UUID and group.
	 *
	 * @param uuid the competencies master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching competencies master
	 * @throws PortalException if a matching competencies master could not be found
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster
			getCompetenciesMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.
			getCompetenciesMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the competencies masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CompetenciesMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @return the range of competencies masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CompetenciesMaster>
		getCompetenciesMasters(int start, int end) {

		return _competenciesMasterLocalService.getCompetenciesMasters(
			start, end);
	}

	/**
	 * Returns all the competencies masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the competencies masters
	 * @param companyId the primary key of the company
	 * @return the matching competencies masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CompetenciesMaster>
		getCompetenciesMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _competenciesMasterLocalService.
			getCompetenciesMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of competencies masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the competencies masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of competencies masters
	 * @param end the upper bound of the range of competencies masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching competencies masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CompetenciesMaster>
		getCompetenciesMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.CompetenciesMaster> orderByComparator) {

		return _competenciesMasterLocalService.
			getCompetenciesMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of competencies masters.
	 *
	 * @return the number of competencies masters
	 */
	@Override
	public int getCompetenciesMastersCount() {
		return _competenciesMasterLocalService.getCompetenciesMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _competenciesMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _competenciesMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _competenciesMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _competenciesMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the competencies master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompetenciesMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param competenciesMaster the competencies master
	 * @return the competencies master that was updated
	 */
	@Override
	public gov.omsb.tms.model.CompetenciesMaster updateCompetenciesMaster(
		gov.omsb.tms.model.CompetenciesMaster competenciesMaster) {

		return _competenciesMasterLocalService.updateCompetenciesMaster(
			competenciesMaster);
	}

	@Override
	public CompetenciesMasterLocalService getWrappedService() {
		return _competenciesMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CompetenciesMasterLocalService competenciesMasterLocalService) {

		_competenciesMasterLocalService = competenciesMasterLocalService;
	}

	private CompetenciesMasterLocalService _competenciesMasterLocalService;

}