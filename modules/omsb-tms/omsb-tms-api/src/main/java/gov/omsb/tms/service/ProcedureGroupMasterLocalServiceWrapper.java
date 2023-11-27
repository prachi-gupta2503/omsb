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
 * Provides a wrapper for {@link ProcedureGroupMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupMasterLocalService
 * @generated
 */
public class ProcedureGroupMasterLocalServiceWrapper
	implements ProcedureGroupMasterLocalService,
			   ServiceWrapper<ProcedureGroupMasterLocalService> {

	public ProcedureGroupMasterLocalServiceWrapper() {
		this(null);
	}

	public ProcedureGroupMasterLocalServiceWrapper(
		ProcedureGroupMasterLocalService procedureGroupMasterLocalService) {

		_procedureGroupMasterLocalService = procedureGroupMasterLocalService;
	}

	@Override
	public void addLocalizedValue(
		java.util.Map<java.util.Locale, String> localizationMap,
		java.util.List<String> values, String languageCode) {

		_procedureGroupMasterLocalService.addLocalizedValue(
			localizationMap, values, languageCode);
	}

	/**
	 * Adds the procedure group master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was added
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster addProcedureGroupMaster(
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.addProcedureGroupMaster(
			procedureGroupMaster);
	}

	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster
		addUpdateProcedureGroupMaster(
			gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster,
			java.util.List<String> procedureGroupNames, boolean isCreate) {

		return _procedureGroupMasterLocalService.addUpdateProcedureGroupMaster(
			procedureGroupMaster, procedureGroupNames, isCreate);
	}

	@Override
	public boolean checkProcedureGroupNames(
		java.util.List<String> procedureGroupNames,
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.checkProcedureGroupNames(
			procedureGroupNames, actionRequest, procedureGroupMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean createProcedureGroupMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _procedureGroupMasterLocalService.createProcedureGroupMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new procedure group master with the primary key. Does not add the procedure group master to the database.
	 *
	 * @param procedureGroupMasterId the primary key for the new procedure group master
	 * @return the new procedure group master
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster createProcedureGroupMaster(
		long procedureGroupMasterId) {

		return _procedureGroupMasterLocalService.createProcedureGroupMaster(
			procedureGroupMasterId);
	}

	@Override
	public boolean createProcedureGroupMaster(
		javax.portlet.PortletRequest request) {

		return _procedureGroupMasterLocalService.createProcedureGroupMaster(
			request);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the procedure group master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master that was removed
	 * @throws PortalException if a procedure group master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster deleteProcedureGroupMaster(
			long procedureGroupMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.deleteProcedureGroupMaster(
			procedureGroupMasterId);
	}

	/**
	 * Deletes the procedure group master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster deleteProcedureGroupMaster(
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.deleteProcedureGroupMaster(
			procedureGroupMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _procedureGroupMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _procedureGroupMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _procedureGroupMasterLocalService.dynamicQuery();
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

		return _procedureGroupMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
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

		return _procedureGroupMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
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

		return _procedureGroupMasterLocalService.dynamicQuery(
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

		return _procedureGroupMasterLocalService.dynamicQueryCount(
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

		return _procedureGroupMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster fetchProcedureGroupMaster(
		long procedureGroupMasterId) {

		return _procedureGroupMasterLocalService.fetchProcedureGroupMaster(
			procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master matching the UUID and group.
	 *
	 * @param uuid the procedure group master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group master, or <code>null</code> if a matching procedure group master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster
		fetchProcedureGroupMasterByUuidAndGroupId(String uuid, long groupId) {

		return _procedureGroupMasterLocalService.
			fetchProcedureGroupMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupMaster>
		findByprocedureGroupNameByLike(String procedureGroupName) {

		return _procedureGroupMasterLocalService.findByprocedureGroupNameByLike(
			procedureGroupName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _procedureGroupMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _procedureGroupMasterLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _procedureGroupMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _procedureGroupMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the procedure group master with the primary key.
	 *
	 * @param procedureGroupMasterId the primary key of the procedure group master
	 * @return the procedure group master
	 * @throws PortalException if a procedure group master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster getProcedureGroupMaster(
			long procedureGroupMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.getProcedureGroupMaster(
			procedureGroupMasterId);
	}

	/**
	 * Returns the procedure group master matching the UUID and group.
	 *
	 * @param uuid the procedure group master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group master
	 * @throws PortalException if a matching procedure group master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster
			getProcedureGroupMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.
			getProcedureGroupMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure group masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @return the range of procedure group masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupMaster>
		getProcedureGroupMasters(int start, int end) {

		return _procedureGroupMasterLocalService.getProcedureGroupMasters(
			start, end);
	}

	/**
	 * Returns all the procedure group masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group masters
	 * @param companyId the primary key of the company
	 * @return the matching procedure group masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupMaster>
		getProcedureGroupMastersByUuidAndCompanyId(
			String uuid, long companyId) {

		return _procedureGroupMasterLocalService.
			getProcedureGroupMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of procedure group masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure group masters
	 * @param end the upper bound of the range of procedure group masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure group masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupMaster>
		getProcedureGroupMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProcedureGroupMaster> orderByComparator) {

		return _procedureGroupMasterLocalService.
			getProcedureGroupMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure group masters.
	 *
	 * @return the number of procedure group masters
	 */
	@Override
	public int getProcedureGroupMastersCount() {
		return _procedureGroupMasterLocalService.
			getProcedureGroupMastersCount();
	}

	@Override
	public boolean updateProcedureGroupMaster(
			javax.portlet.ActionRequest actionRequest,
			long procedureGroupMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupMasterLocalService.updateProcedureGroupMaster(
			actionRequest, procedureGroupMasterId, themeDisplay);
	}

	/**
	 * Updates the procedure group master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupMaster the procedure group master
	 * @return the procedure group master that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupMaster updateProcedureGroupMaster(
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.updateProcedureGroupMaster(
			procedureGroupMaster);
	}

	@Override
	public boolean validateProcedureGroup(
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.validateProcedureGroup(
			actionRequest, procedureGroupMaster);
	}

	@Override
	public boolean validateProcedureGroupNames(
		java.util.List<String> procedureGroupNames,
		gov.omsb.tms.model.ProcedureGroupMaster procedureGroupMaster) {

		return _procedureGroupMasterLocalService.validateProcedureGroupNames(
			procedureGroupNames, procedureGroupMaster);
	}

	@Override
	public ProcedureGroupMasterLocalService getWrappedService() {
		return _procedureGroupMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProcedureGroupMasterLocalService procedureGroupMasterLocalService) {

		_procedureGroupMasterLocalService = procedureGroupMasterLocalService;
	}

	private ProcedureGroupMasterLocalService _procedureGroupMasterLocalService;

}