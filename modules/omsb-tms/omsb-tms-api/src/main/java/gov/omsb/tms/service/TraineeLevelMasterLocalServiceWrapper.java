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
 * Provides a wrapper for {@link TraineeLevelMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMasterLocalService
 * @generated
 */
public class TraineeLevelMasterLocalServiceWrapper
	implements ServiceWrapper<TraineeLevelMasterLocalService>,
			   TraineeLevelMasterLocalService {

	public TraineeLevelMasterLocalServiceWrapper() {
		this(null);
	}

	public TraineeLevelMasterLocalServiceWrapper(
		TraineeLevelMasterLocalService traineeLevelMasterLocalService) {

		_traineeLevelMasterLocalService = traineeLevelMasterLocalService;
	}

	@Override
	public void addLocalizedValue(
		java.util.Map<java.util.Locale, String> localizationMap,
		java.util.List<String> values, String languageCode) {

		_traineeLevelMasterLocalService.addLocalizedValue(
			localizationMap, values, languageCode);
	}

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
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster addTraineeLevelMaster(
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster) {

		return _traineeLevelMasterLocalService.addTraineeLevelMaster(
			traineeLevelMaster);
	}

	@Override
	public boolean checkTraineeLevel(
		java.util.List<String> traineeLevelNames,
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster) {

		return _traineeLevelMasterLocalService.checkTraineeLevel(
			traineeLevelNames, actionRequest, traineeLevelMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean createTraineeLevelMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _traineeLevelMasterLocalService.createTraineeLevelMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new trainee level master with the primary key. Does not add the trainee level master to the database.
	 *
	 * @param traineeLevelMasterId the primary key for the new trainee level master
	 * @return the new trainee level master
	 */
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster createTraineeLevelMaster(
		long traineeLevelMasterId) {

		return _traineeLevelMasterLocalService.createTraineeLevelMaster(
			traineeLevelMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.deletePersistedModel(
			persistedModel);
	}

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
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster deleteTraineeLevelMaster(
			long traineeLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.deleteTraineeLevelMaster(
			traineeLevelMasterId);
	}

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
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster deleteTraineeLevelMaster(
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster) {

		return _traineeLevelMasterLocalService.deleteTraineeLevelMaster(
			traineeLevelMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _traineeLevelMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _traineeLevelMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traineeLevelMasterLocalService.dynamicQuery();
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

		return _traineeLevelMasterLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _traineeLevelMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _traineeLevelMasterLocalService.dynamicQuery(
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

		return _traineeLevelMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _traineeLevelMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.TraineeLevelMaster fetchTraineeLevelMaster(
		long traineeLevelMasterId) {

		return _traineeLevelMasterLocalService.fetchTraineeLevelMaster(
			traineeLevelMasterId);
	}

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master, or <code>null</code> if a matching trainee level master could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster
		fetchTraineeLevelMasterByUuidAndGroupId(String uuid, long groupId) {

		return _traineeLevelMasterLocalService.
			fetchTraineeLevelMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		findByTraineeLevelIds(java.util.List<Long> traineeLevelIds) {

		return _traineeLevelMasterLocalService.findByTraineeLevelIds(
			traineeLevelIds);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		findByTraineeLevelName(String traineeLevelName) {

		return _traineeLevelMasterLocalService.findByTraineeLevelName(
			traineeLevelName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _traineeLevelMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _traineeLevelMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _traineeLevelMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeLevelMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getTraineeLevelListByDurationId(long durationId) {

		return _traineeLevelMasterLocalService.getTraineeLevelListByDurationId(
			durationId);
	}

	/**
	 * Returns the trainee level master with the primary key.
	 *
	 * @param traineeLevelMasterId the primary key of the trainee level master
	 * @return the trainee level master
	 * @throws PortalException if a trainee level master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster getTraineeLevelMaster(
			long traineeLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.getTraineeLevelMaster(
			traineeLevelMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getTraineeLevelMasterByProgramId(long programId) {

		return _traineeLevelMasterLocalService.getTraineeLevelMasterByProgramId(
			programId);
	}

	/**
	 * Returns the trainee level master matching the UUID and group.
	 *
	 * @param uuid the trainee level master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trainee level master
	 * @throws PortalException if a matching trainee level master could not be found
	 */
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster
			getTraineeLevelMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.
			getTraineeLevelMasterByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		getTraineeLevelMasters(int start, int end) {

		return _traineeLevelMasterLocalService.getTraineeLevelMasters(
			start, end);
	}

	/**
	 * Returns all the trainee level masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the trainee level masters
	 * @param companyId the primary key of the company
	 * @return the matching trainee level masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		getTraineeLevelMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _traineeLevelMasterLocalService.
			getTraineeLevelMastersByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<gov.omsb.tms.model.TraineeLevelMaster>
		getTraineeLevelMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.TraineeLevelMaster> orderByComparator) {

		return _traineeLevelMasterLocalService.
			getTraineeLevelMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trainee level masters.
	 *
	 * @return the number of trainee level masters
	 */
	@Override
	public int getTraineeLevelMastersCount() {
		return _traineeLevelMasterLocalService.getTraineeLevelMastersCount();
	}

	@Override
	public boolean updateTraineeLevelMaster(
			javax.portlet.ActionRequest actionRequest,
			long traineeLevelMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _traineeLevelMasterLocalService.updateTraineeLevelMaster(
			actionRequest, traineeLevelMasterId, themeDisplay);
	}

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
	@Override
	public gov.omsb.tms.model.TraineeLevelMaster updateTraineeLevelMaster(
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster) {

		return _traineeLevelMasterLocalService.updateTraineeLevelMaster(
			traineeLevelMaster);
	}

	@Override
	public boolean validateTraineeLevel(
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.TraineeLevelMaster traineeLevelMaster) {

		return _traineeLevelMasterLocalService.validateTraineeLevel(
			actionRequest, traineeLevelMaster);
	}

	@Override
	public TraineeLevelMasterLocalService getWrappedService() {
		return _traineeLevelMasterLocalService;
	}

	@Override
	public void setWrappedService(
		TraineeLevelMasterLocalService traineeLevelMasterLocalService) {

		_traineeLevelMasterLocalService = traineeLevelMasterLocalService;
	}

	private TraineeLevelMasterLocalService _traineeLevelMasterLocalService;

}