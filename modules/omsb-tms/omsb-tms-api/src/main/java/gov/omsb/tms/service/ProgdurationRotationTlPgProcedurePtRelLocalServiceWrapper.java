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
 * Provides a wrapper for {@link ProgdurationRotationTlPgProcedurePtRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationRotationTlPgProcedurePtRelLocalService
 * @generated
 */
public class ProgdurationRotationTlPgProcedurePtRelLocalServiceWrapper
	implements ProgdurationRotationTlPgProcedurePtRelLocalService,
			   ServiceWrapper
				   <ProgdurationRotationTlPgProcedurePtRelLocalService> {

	public ProgdurationRotationTlPgProcedurePtRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationRotationTlPgProcedurePtRelLocalServiceWrapper(
		ProgdurationRotationTlPgProcedurePtRelLocalService
			progdurationRotationTlPgProcedurePtRelLocalService) {

		_progdurationRotationTlPgProcedurePtRelLocalService =
			progdurationRotationTlPgProcedurePtRelLocalService;
	}

	/**
	 * Adds the progduration rotation tl pg procedure pt rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		addProgdurationRotationTlPgProcedurePtRel(
			gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			addProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration rotation tl pg procedure pt rel with the primary key. Does not add the progduration rotation tl pg procedure pt rel to the database.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key for the new progduration rotation tl pg procedure pt rel
	 * @return the new progduration rotation tl pg procedure pt rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		createProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			createProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the progduration rotation tl pg procedure pt rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
			deleteProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			deleteProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Deletes the progduration rotation tl pg procedure pt rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		deleteProgdurationRotationTlPgProcedurePtRel(
			gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			deleteProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationRotationTlPgProcedurePtRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationRotationTlPgProcedurePtRelLocalService.
			dynamicQuery();
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

		return _progdurationRotationTlPgProcedurePtRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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

		return _progdurationRotationTlPgProcedurePtRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
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

		return _progdurationRotationTlPgProcedurePtRelLocalService.dynamicQuery(
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

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			dynamicQueryCount(dynamicQuery);
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

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRel(
			long progdurationRotationTlPgProcedurePtRelId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			fetchProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel, or <code>null</code> if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		fetchProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			fetchProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			findByProgramDurationId(long programDurationId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			findByProgramDurationId(programDurationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				long programDurationId, long procedureGroupId,
				long procedureId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			findByProgramDurationIdAndProcedureGroupIdAndProcedureId(
				programDurationId, procedureGroupId, procedureId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
			long programDurationId, long procedureGroupId, long procedureId,
			long rotationId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
				programDurationId, procedureGroupId, procedureId, rotationId);
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			findProgdurationRotationTlPgProcedurePtRelByProcedureGroupId(
				long procedureGroupId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			findProgdurationRotationTlPgProcedurePtRelByProcedureGroupId(
				procedureGroupId);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		findProgdurationRotationTlPgProcedurePtRelByProcedureId(
			long procedureId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			findProgdurationRotationTlPgProcedurePtRelByProcedureId(
				procedureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel with the primary key.
	 *
	 * @param progdurationRotationTlPgProcedurePtRelId the primary key of the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a progduration rotation tl pg procedure pt rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRel(
				long progdurationRotationTlPgProcedurePtRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRelId);
	}

	/**
	 * Returns the progduration rotation tl pg procedure pt rel matching the UUID and group.
	 *
	 * @param uuid the progduration rotation tl pg procedure pt rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration rotation tl pg procedure pt rel
	 * @throws PortalException if a matching progduration rotation tl pg procedure pt rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
			getProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration rotation tl pg procedure pt rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationRotationTlPgProcedurePtRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @return the range of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			getProgdurationRotationTlPgProcedurePtRels(int start, int end) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRels(start, end);
	}

	/**
	 * Returns all the progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration rotation tl pg procedure pt rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration rotation tl pg procedure pt rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration rotation tl pg procedure pt rels
	 * @param end the upper bound of the range of progduration rotation tl pg procedure pt rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration rotation tl pg procedure pt rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel>
						orderByComparator) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration rotation tl pg procedure pt rels.
	 *
	 * @return the number of progduration rotation tl pg procedure pt rels
	 */
	@Override
	public int getProgdurationRotationTlPgProcedurePtRelsCount() {
		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getProgdurationRotationTlPgProcedurePtRelsCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.SetupProcedureDTO>
		getSetUpProcedureDetails(String languageCode) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			getSetUpProcedureDetails(languageCode);
	}

	/**
	 * Updates the progduration rotation tl pg procedure pt rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationRotationTlPgProcedurePtRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationRotationTlPgProcedurePtRel the progduration rotation tl pg procedure pt rel
	 * @return the progduration rotation tl pg procedure pt rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
		updateProgdurationRotationTlPgProcedurePtRel(
			gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel
				progdurationRotationTlPgProcedurePtRel) {

		return _progdurationRotationTlPgProcedurePtRelLocalService.
			updateProgdurationRotationTlPgProcedurePtRel(
				progdurationRotationTlPgProcedurePtRel);
	}

	@Override
	public ProgdurationRotationTlPgProcedurePtRelLocalService
		getWrappedService() {

		return _progdurationRotationTlPgProcedurePtRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationRotationTlPgProcedurePtRelLocalService
			progdurationRotationTlPgProcedurePtRelLocalService) {

		_progdurationRotationTlPgProcedurePtRelLocalService =
			progdurationRotationTlPgProcedurePtRelLocalService;
	}

	private ProgdurationRotationTlPgProcedurePtRelLocalService
		_progdurationRotationTlPgProcedurePtRelLocalService;

}