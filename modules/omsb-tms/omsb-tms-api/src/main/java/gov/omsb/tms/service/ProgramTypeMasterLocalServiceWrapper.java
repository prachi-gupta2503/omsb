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
 * Provides a wrapper for {@link ProgramTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterLocalService
 * @generated
 */
public class ProgramTypeMasterLocalServiceWrapper
	implements ProgramTypeMasterLocalService,
			   ServiceWrapper<ProgramTypeMasterLocalService> {

	public ProgramTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public ProgramTypeMasterLocalServiceWrapper(
		ProgramTypeMasterLocalService programTypeMasterLocalService) {

		_programTypeMasterLocalService = programTypeMasterLocalService;
	}

	@Override
	public void addLocalizedValue(
		java.util.Map<java.util.Locale, String> localizationMap,
		java.util.List<String> values, String languageCode) {

		_programTypeMasterLocalService.addLocalizedValue(
			localizationMap, values, languageCode);
	}

	/**
	 * Adds the program type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster addProgramTypeMaster(
		gov.omsb.tms.model.ProgramTypeMaster programTypeMaster) {

		return _programTypeMasterLocalService.addProgramTypeMaster(
			programTypeMaster);
	}

	@Override
	public boolean checkprogramTypeNames(
		java.util.List<String> programTypeNames,
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProgramTypeMaster programTypeMaster) {

		return _programTypeMasterLocalService.checkprogramTypeNames(
			programTypeNames, actionRequest, programTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean createProgramTypeMaster(
		javax.portlet.ActionRequest actionRequest,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		return _programTypeMasterLocalService.createProgramTypeMaster(
			actionRequest, themeDisplay);
	}

	/**
	 * Creates a new program type master with the primary key. Does not add the program type master to the database.
	 *
	 * @param programTypeMasterId the primary key for the new program type master
	 * @return the new program type master
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster createProgramTypeMaster(
		long programTypeMasterId) {

		return _programTypeMasterLocalService.createProgramTypeMaster(
			programTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master that was removed
	 * @throws PortalException if a program type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster deleteProgramTypeMaster(
			long programTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.deleteProgramTypeMaster(
			programTypeMasterId);
	}

	/**
	 * Deletes the program type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster deleteProgramTypeMaster(
		gov.omsb.tms.model.ProgramTypeMaster programTypeMaster) {

		return _programTypeMasterLocalService.deleteProgramTypeMaster(
			programTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programTypeMasterLocalService.dynamicQuery();
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

		return _programTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
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

		return _programTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
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

		return _programTypeMasterLocalService.dynamicQuery(
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

		return _programTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _programTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramTypeMaster fetchProgramTypeMaster(
		long programTypeMasterId) {

		return _programTypeMasterLocalService.fetchProgramTypeMaster(
			programTypeMasterId);
	}

	/**
	 * Returns the program type master matching the UUID and group.
	 *
	 * @param uuid the program type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program type master, or <code>null</code> if a matching program type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster
		fetchProgramTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _programTypeMasterLocalService.
			fetchProgramTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramTypeMaster>
		findByProgramTypeNameByLike(String programTypeName) {

		return _programTypeMasterLocalService.findByProgramTypeNameByLike(
			programTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the program type master with the primary key.
	 *
	 * @param programTypeMasterId the primary key of the program type master
	 * @return the program type master
	 * @throws PortalException if a program type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster getProgramTypeMaster(
			long programTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.getProgramTypeMaster(
			programTypeMasterId);
	}

	/**
	 * Returns the program type master matching the UUID and group.
	 *
	 * @param uuid the program type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program type master
	 * @throws PortalException if a matching program type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster
			getProgramTypeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.
			getProgramTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @return the range of program type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramTypeMaster>
		getProgramTypeMasters(int start, int end) {

		return _programTypeMasterLocalService.getProgramTypeMasters(start, end);
	}

	/**
	 * Returns all the program type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program type masters
	 * @param companyId the primary key of the company
	 * @return the matching program type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramTypeMaster>
		getProgramTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _programTypeMasterLocalService.
			getProgramTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program type masters
	 * @param end the upper bound of the range of program type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramTypeMaster>
		getProgramTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramTypeMaster> orderByComparator) {

		return _programTypeMasterLocalService.
			getProgramTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program type masters.
	 *
	 * @return the number of program type masters
	 */
	@Override
	public int getProgramTypeMastersCount() {
		return _programTypeMasterLocalService.getProgramTypeMastersCount();
	}

	@Override
	public boolean updateProgramTypeMaster(
			javax.portlet.ActionRequest actionRequest, long programTypeMasterId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programTypeMasterLocalService.updateProgramTypeMaster(
			actionRequest, programTypeMasterId, themeDisplay);
	}

	/**
	 * Updates the program type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programTypeMaster the program type master
	 * @return the program type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramTypeMaster updateProgramTypeMaster(
		gov.omsb.tms.model.ProgramTypeMaster programTypeMaster) {

		return _programTypeMasterLocalService.updateProgramTypeMaster(
			programTypeMaster);
	}

	@Override
	public boolean validateProgramType(
		javax.portlet.ActionRequest actionRequest,
		gov.omsb.tms.model.ProgramTypeMaster programTypeMaster) {

		return _programTypeMasterLocalService.validateProgramType(
			actionRequest, programTypeMaster);
	}

	@Override
	public ProgramTypeMasterLocalService getWrappedService() {
		return _programTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramTypeMasterLocalService programTypeMasterLocalService) {

		_programTypeMasterLocalService = programTypeMasterLocalService;
	}

	private ProgramTypeMasterLocalService _programTypeMasterLocalService;

}