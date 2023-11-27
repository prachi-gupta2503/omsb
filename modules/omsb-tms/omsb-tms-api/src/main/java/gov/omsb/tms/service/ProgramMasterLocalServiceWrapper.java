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
 * Provides a wrapper for {@link ProgramMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramMasterLocalService
 * @generated
 */
public class ProgramMasterLocalServiceWrapper
	implements ProgramMasterLocalService,
			   ServiceWrapper<ProgramMasterLocalService> {

	public ProgramMasterLocalServiceWrapper() {
		this(null);
	}

	public ProgramMasterLocalServiceWrapper(
		ProgramMasterLocalService programMasterLocalService) {

		_programMasterLocalService = programMasterLocalService;
	}

	/**
	 * Adds the program master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster addProgramMaster(
		gov.omsb.tms.model.ProgramMaster programMaster) {

		return _programMasterLocalService.addProgramMaster(programMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new program master with the primary key. Does not add the program master to the database.
	 *
	 * @param programMasterId the primary key for the new program master
	 * @return the new program master
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster createProgramMaster(
		long programMasterId) {

		return _programMasterLocalService.createProgramMaster(programMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the program master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master that was removed
	 * @throws PortalException if a program master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster deleteProgramMaster(
			long programMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.deleteProgramMaster(programMasterId);
	}

	/**
	 * Deletes the program master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster deleteProgramMaster(
		gov.omsb.tms.model.ProgramMaster programMaster) {

		return _programMasterLocalService.deleteProgramMaster(programMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programMasterLocalService.dynamicQuery();
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

		return _programMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
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

		return _programMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
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

		return _programMasterLocalService.dynamicQuery(
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

		return _programMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _programMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramMaster fetchProgramMaster(
		long programMasterId) {

		return _programMasterLocalService.fetchProgramMaster(programMasterId);
	}

	/**
	 * Returns the program master matching the UUID and group.
	 *
	 * @param uuid the program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program master, or <code>null</code> if a matching program master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster fetchProgramMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return _programMasterLocalService.fetchProgramMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		findByProgramCodeByLike(String programCode) {

		return _programMasterLocalService.findByProgramCodeByLike(programCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		findByProgramMasterId(java.util.List<Long> programIds) {

		return _programMasterLocalService.findByProgramMasterId(programIds);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		findByProgramNameByLike(String programName) {

		return _programMasterLocalService.findByProgramNameByLike(programName);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster> findByProgramStatus(
		Boolean programStatus) {

		return _programMasterLocalService.findByProgramStatus(programStatus);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		findProgramByPorgramType(long programTypeId) {

		return _programMasterLocalService.findProgramByPorgramType(
			programTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramDTO> getAllProgramList(
		String languageCode) {

		return _programMasterLocalService.getAllProgramList(languageCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public gov.omsb.tms.custom.dto.ProgramDTO getProgramDetails(
		long programId, String languageCode) {

		return _programMasterLocalService.getProgramDetails(
			programId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramDTO>
		getProgramDTOListByIds(java.util.List<Long> ids, String languageCode) {

		return _programMasterLocalService.getProgramDTOListByIds(
			ids, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster> getProgramListByIds(
		java.util.List<Long> ids) {

		return _programMasterLocalService.getProgramListByIds(ids);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		getProgramListByIdsAndStatus(java.util.List<Long> ids, Boolean status) {

		return _programMasterLocalService.getProgramListByIdsAndStatus(
			ids, status);
	}

	/**
	 * Returns the program master with the primary key.
	 *
	 * @param programMasterId the primary key of the program master
	 * @return the program master
	 * @throws PortalException if a program master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster getProgramMaster(
			long programMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.getProgramMaster(programMasterId);
	}

	/**
	 * Returns the program master matching the UUID and group.
	 *
	 * @param uuid the program master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program master
	 * @throws PortalException if a matching program master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster getProgramMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programMasterLocalService.getProgramMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the program masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @return the range of program masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster> getProgramMasters(
		int start, int end) {

		return _programMasterLocalService.getProgramMasters(start, end);
	}

	/**
	 * Returns all the program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program masters
	 * @param companyId the primary key of the company
	 * @return the matching program masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		getProgramMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _programMasterLocalService.getProgramMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of program masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the program masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program masters
	 * @param end the upper bound of the range of program masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramMaster>
		getProgramMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramMaster> orderByComparator) {

		return _programMasterLocalService.getProgramMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program masters.
	 *
	 * @return the number of program masters
	 */
	@Override
	public int getProgramMastersCount() {
		return _programMasterLocalService.getProgramMastersCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getProgramStructure(long programDurationId, String languageCode) {

		return _programMasterLocalService.getProgramStructure(
			programDurationId, languageCode);
	}

	/**
	 * Updates the program master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programMaster the program master
	 * @return the program master that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramMaster updateProgramMaster(
		gov.omsb.tms.model.ProgramMaster programMaster) {

		return _programMasterLocalService.updateProgramMaster(programMaster);
	}

	@Override
	public ProgramMasterLocalService getWrappedService() {
		return _programMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramMasterLocalService programMasterLocalService) {

		_programMasterLocalService = programMasterLocalService;
	}

	private ProgramMasterLocalService _programMasterLocalService;

}