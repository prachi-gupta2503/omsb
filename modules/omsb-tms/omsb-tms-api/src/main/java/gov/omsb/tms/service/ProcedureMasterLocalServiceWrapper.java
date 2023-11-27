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
 * Provides a wrapper for {@link ProcedureMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureMasterLocalService
 * @generated
 */
public class ProcedureMasterLocalServiceWrapper
	implements ProcedureMasterLocalService,
			   ServiceWrapper<ProcedureMasterLocalService> {

	public ProcedureMasterLocalServiceWrapper() {
		this(null);
	}

	public ProcedureMasterLocalServiceWrapper(
		ProcedureMasterLocalService procedureMasterLocalService) {

		_procedureMasterLocalService = procedureMasterLocalService;
	}

	@Override
	public void addLocalizedValue(
		java.util.Map<java.util.Locale, String> localizationMap,
		java.util.List<String> values, String languageCode) {

		_procedureMasterLocalService.addLocalizedValue(
			localizationMap, values, languageCode);
	}

	/**
	 * Adds the procedure master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was added
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster addProcedureMaster(
		gov.omsb.tms.model.ProcedureMaster procedureMaster) {

		return _procedureMasterLocalService.addProcedureMaster(procedureMaster);
	}

	@Override
	public gov.omsb.tms.model.ProcedureMaster addUpdateProcedureMaster(
		gov.omsb.tms.model.ProcedureMaster procedureMaster,
		java.util.List<String> procedureNames, boolean isCreate) {

		return _procedureMasterLocalService.addUpdateProcedureMaster(
			procedureMaster, procedureNames, isCreate);
	}

	@Override
	public boolean checkProcedureNames(
		java.util.List<String> procedureNames,
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProcedureMaster procedureMaster) {

		return _procedureMasterLocalService.checkProcedureNames(
			procedureNames, actionRequest, procedureMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean createProcedureMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _procedureMasterLocalService.createProcedureMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new procedure master with the primary key. Does not add the procedure master to the database.
	 *
	 * @param procedureMasterId the primary key for the new procedure master
	 * @return the new procedure master
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster createProcedureMaster(
		long procedureMasterId) {

		return _procedureMasterLocalService.createProcedureMaster(
			procedureMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the procedure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master that was removed
	 * @throws PortalException if a procedure master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster deleteProcedureMaster(
			long procedureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.deleteProcedureMaster(
			procedureMasterId);
	}

	/**
	 * Deletes the procedure master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster deleteProcedureMaster(
		gov.omsb.tms.model.ProcedureMaster procedureMaster) {

		return _procedureMasterLocalService.deleteProcedureMaster(
			procedureMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _procedureMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _procedureMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _procedureMasterLocalService.dynamicQuery();
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

		return _procedureMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
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

		return _procedureMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
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

		return _procedureMasterLocalService.dynamicQuery(
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

		return _procedureMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _procedureMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProcedureMaster fetchProcedureMaster(
		long procedureMasterId) {

		return _procedureMasterLocalService.fetchProcedureMaster(
			procedureMasterId);
	}

	/**
	 * Returns the procedure master matching the UUID and group.
	 *
	 * @param uuid the procedure master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure master, or <code>null</code> if a matching procedure master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster
		fetchProcedureMasterByUuidAndGroupId(String uuid, long groupId) {

		return _procedureMasterLocalService.
			fetchProcedureMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		findByProcedureGroupMasterId(long procedureGroupMasterId) {

		return _procedureMasterLocalService.findByProcedureGroupMasterId(
			procedureGroupMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		findByProcedureNameByLike(String procedureName) {

		return _procedureMasterLocalService.findByProcedureNameByLike(
			procedureName);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		findByProcedureNameByLikeAndProcedureGroupMasterId(
			String procedureName, long procedureGroupMasterId) {

		return _procedureMasterLocalService.
			findByProcedureNameByLikeAndProcedureGroupMasterId(
				procedureName, procedureGroupMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _procedureMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _procedureMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _procedureMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _procedureMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the procedure master with the primary key.
	 *
	 * @param procedureMasterId the primary key of the procedure master
	 * @return the procedure master
	 * @throws PortalException if a procedure master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster getProcedureMaster(
			long procedureMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.getProcedureMaster(
			procedureMasterId);
	}

	/**
	 * Returns the procedure master matching the UUID and group.
	 *
	 * @param uuid the procedure master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure master
	 * @throws PortalException if a matching procedure master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster
			getProcedureMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.getProcedureMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @return the range of procedure masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		getProcedureMasters(int start, int end) {

		return _procedureMasterLocalService.getProcedureMasters(start, end);
	}

	/**
	 * Returns all the procedure masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure masters
	 * @param companyId the primary key of the company
	 * @return the matching procedure masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		getProcedureMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _procedureMasterLocalService.
			getProcedureMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of procedure masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure masters
	 * @param end the upper bound of the range of procedure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureMaster>
		getProcedureMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProcedureMaster> orderByComparator) {

		return _procedureMasterLocalService.
			getProcedureMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure masters.
	 *
	 * @return the number of procedure masters
	 */
	@Override
	public int getProcedureMastersCount() {
		return _procedureMasterLocalService.getProcedureMastersCount();
	}

	@Override
	public boolean updateProcedureMaster(
			javax.portlet.ActionRequest actionRequest, long procedureMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureMasterLocalService.updateProcedureMaster(
			actionRequest, procedureMasterId, themeDisplay);
	}

	/**
	 * Updates the procedure master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureMaster the procedure master
	 * @return the procedure master that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProcedureMaster updateProcedureMaster(
		gov.omsb.tms.model.ProcedureMaster procedureMaster) {

		return _procedureMasterLocalService.updateProcedureMaster(
			procedureMaster);
	}

	@Override
	public boolean validateProcedure(
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProcedureMaster procedureMaster) {

		return _procedureMasterLocalService.validateProcedure(
			actionRequest, procedureMaster);
	}

	@Override
	public boolean validateProcedureNames(
		java.util.List<String> procedureNames,
		gov.omsb.tms.model.ProcedureMaster procedureMaster,
		long procedureGroupMasterId) {

		return _procedureMasterLocalService.validateProcedureNames(
			procedureNames, procedureMaster, procedureGroupMasterId);
	}

	@Override
	public ProcedureMasterLocalService getWrappedService() {
		return _procedureMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProcedureMasterLocalService procedureMasterLocalService) {

		_procedureMasterLocalService = procedureMasterLocalService;
	}

	private ProcedureMasterLocalService _procedureMasterLocalService;

}