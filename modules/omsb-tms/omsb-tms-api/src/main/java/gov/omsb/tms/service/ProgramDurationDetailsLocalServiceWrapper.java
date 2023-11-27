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
 * Provides a wrapper for {@link ProgramDurationDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDurationDetailsLocalService
 * @generated
 */
public class ProgramDurationDetailsLocalServiceWrapper
	implements ProgramDurationDetailsLocalService,
			   ServiceWrapper<ProgramDurationDetailsLocalService> {

	public ProgramDurationDetailsLocalServiceWrapper() {
		this(null);
	}

	public ProgramDurationDetailsLocalServiceWrapper(
		ProgramDurationDetailsLocalService programDurationDetailsLocalService) {

		_programDurationDetailsLocalService =
			programDurationDetailsLocalService;
	}

	/**
	 * Adds the program duration details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails addProgramDurationDetails(
		gov.omsb.tms.model.ProgramDurationDetails programDurationDetails) {

		return _programDurationDetailsLocalService.addProgramDurationDetails(
			programDurationDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new program duration details with the primary key. Does not add the program duration details to the database.
	 *
	 * @param progDurationId the primary key for the new program duration details
	 * @return the new program duration details
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		createProgramDurationDetails(long progDurationId) {

		return _programDurationDetailsLocalService.createProgramDurationDetails(
			progDurationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws PortalException if a program duration details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
			deleteProgramDurationDetails(long progDurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.deleteProgramDurationDetails(
			progDurationId);
	}

	/**
	 * Deletes the program duration details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		deleteProgramDurationDetails(
			gov.omsb.tms.model.ProgramDurationDetails programDurationDetails) {

		return _programDurationDetailsLocalService.deleteProgramDurationDetails(
			programDurationDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programDurationDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programDurationDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programDurationDetailsLocalService.dynamicQuery();
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

		return _programDurationDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
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

		return _programDurationDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
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

		return _programDurationDetailsLocalService.dynamicQuery(
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

		return _programDurationDetailsLocalService.dynamicQueryCount(
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

		return _programDurationDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		fetchProgramDurationDetails(long progDurationId) {

		return _programDurationDetailsLocalService.fetchProgramDurationDetails(
			progDurationId);
	}

	/**
	 * Returns the program duration details matching the UUID and group.
	 *
	 * @param uuid the program duration details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		fetchProgramDurationDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _programDurationDetailsLocalService.
			fetchProgramDurationDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		findByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm) {

		return _programDurationDetailsLocalService.
			findByProgramIdAndAYApplicableFrom(programId, ayApplicableForm);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDurationDetails>
		findProgramDurationByProgramId(long programId) {

		return _programDurationDetailsLocalService.
			findProgramDurationByProgramId(programId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programDurationDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programDurationDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programDurationDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programDurationDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramAndCohortsFromProgramDuration(
			java.util.List<Long> programIds, java.util.List<String> yearRange,
			String languageCode) {

		return _programDurationDetailsLocalService.
			getProgramAndCohortsFromProgramDuration(
				programIds, yearRange, languageCode);
	}

	/**
	 * Returns the program duration details with the primary key.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details
	 * @throws PortalException if a program duration details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails getProgramDurationDetails(
			long progDurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.getProgramDurationDetails(
			progDurationId);
	}

	/**
	 * Returns the program duration details matching the UUID and group.
	 *
	 * @param uuid the program duration details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program duration details
	 * @throws PortalException if a matching program duration details could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
			getProgramDurationDetailsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDurationDetailsLocalService.
			getProgramDurationDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of program duration detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDurationDetails>
		getProgramDurationDetailses(int start, int end) {

		return _programDurationDetailsLocalService.getProgramDurationDetailses(
			start, end);
	}

	/**
	 * Returns all the program duration detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duration detailses
	 * @param companyId the primary key of the company
	 * @return the matching program duration detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDurationDetails>
		getProgramDurationDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _programDurationDetailsLocalService.
			getProgramDurationDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program duration detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the program duration detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program duration detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramDurationDetails>
		getProgramDurationDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramDurationDetails> orderByComparator) {

		return _programDurationDetailsLocalService.
			getProgramDurationDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program duration detailses.
	 *
	 * @return the number of program duration detailses
	 */
	@Override
	public int getProgramDurationDetailsesCount() {
		return _programDurationDetailsLocalService.
			getProgramDurationDetailsesCount();
	}

	@Override
	public java.util.List<Long> getProgramDurationIdFromProgramIds(
		java.util.List<Long> programIds) {

		return _programDurationDetailsLocalService.
			getProgramDurationIdFromProgramIds(programIds);
	}

	/**
	 * Updates the program duration details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramDurationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programDurationDetails the program duration details
	 * @return the program duration details that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramDurationDetails
		updateProgramDurationDetails(
			gov.omsb.tms.model.ProgramDurationDetails programDurationDetails) {

		return _programDurationDetailsLocalService.updateProgramDurationDetails(
			programDurationDetails);
	}

	@Override
	public ProgramDurationDetailsLocalService getWrappedService() {
		return _programDurationDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramDurationDetailsLocalService programDurationDetailsLocalService) {

		_programDurationDetailsLocalService =
			programDurationDetailsLocalService;
	}

	private ProgramDurationDetailsLocalService
		_programDurationDetailsLocalService;

}