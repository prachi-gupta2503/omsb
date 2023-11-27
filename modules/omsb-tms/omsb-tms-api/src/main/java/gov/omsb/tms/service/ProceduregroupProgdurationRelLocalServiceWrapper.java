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
 * Provides a wrapper for {@link ProceduregroupProgdurationRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProceduregroupProgdurationRelLocalService
 * @generated
 */
public class ProceduregroupProgdurationRelLocalServiceWrapper
	implements ProceduregroupProgdurationRelLocalService,
			   ServiceWrapper<ProceduregroupProgdurationRelLocalService> {

	public ProceduregroupProgdurationRelLocalServiceWrapper() {
		this(null);
	}

	public ProceduregroupProgdurationRelLocalServiceWrapper(
		ProceduregroupProgdurationRelLocalService
			proceduregroupProgdurationRelLocalService) {

		_proceduregroupProgdurationRelLocalService =
			proceduregroupProgdurationRelLocalService;
	}

	/**
	 * Adds the proceduregroup progduration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		addProceduregroupProgdurationRel(
			gov.omsb.tms.model.ProceduregroupProgdurationRel
				proceduregroupProgdurationRel) {

		return _proceduregroupProgdurationRelLocalService.
			addProceduregroupProgdurationRel(proceduregroupProgdurationRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new proceduregroup progduration rel with the primary key. Does not add the proceduregroup progduration rel to the database.
	 *
	 * @param pgPdRelId the primary key for the new proceduregroup progduration rel
	 * @return the new proceduregroup progduration rel
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		createProceduregroupProgdurationRel(long pgPdRelId) {

		return _proceduregroupProgdurationRelLocalService.
			createProceduregroupProgdurationRel(pgPdRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the proceduregroup progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 * @throws PortalException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
			deleteProceduregroupProgdurationRel(long pgPdRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.
			deleteProceduregroupProgdurationRel(pgPdRelId);
	}

	/**
	 * Deletes the proceduregroup progduration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		deleteProceduregroupProgdurationRel(
			gov.omsb.tms.model.ProceduregroupProgdurationRel
				proceduregroupProgdurationRel) {

		return _proceduregroupProgdurationRelLocalService.
			deleteProceduregroupProgdurationRel(proceduregroupProgdurationRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _proceduregroupProgdurationRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _proceduregroupProgdurationRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proceduregroupProgdurationRelLocalService.dynamicQuery();
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

		return _proceduregroupProgdurationRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
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

		return _proceduregroupProgdurationRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
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

		return _proceduregroupProgdurationRelLocalService.dynamicQuery(
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

		return _proceduregroupProgdurationRelLocalService.dynamicQueryCount(
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

		return _proceduregroupProgdurationRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		fetchProceduregroupProgdurationRel(long pgPdRelId) {

		return _proceduregroupProgdurationRelLocalService.
			fetchProceduregroupProgdurationRel(pgPdRelId);
	}

	/**
	 * Returns the proceduregroup progduration rel matching the UUID and group.
	 *
	 * @param uuid the proceduregroup progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching proceduregroup progduration rel, or <code>null</code> if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		fetchProceduregroupProgdurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _proceduregroupProgdurationRelLocalService.
			fetchProceduregroupProgdurationRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProceduregroupProgdurationRel>
		findByProcedureGroupMasterId(long procedureGroupMasterId) {

		return _proceduregroupProgdurationRelLocalService.
			findByProcedureGroupMasterId(procedureGroupMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProceduregroupProgdurationRel>
		findByProgramDurationId(long programDurationId) {

		return _proceduregroupProgdurationRelLocalService.
			findByProgramDurationId(programDurationId);
	}

	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		findByProgramDurationIdAndProcedureGroupMasterId(
			long programDurationId, long procedureGroupMasterId) {

		return _proceduregroupProgdurationRelLocalService.
			findByProgramDurationIdAndProcedureGroupMasterId(
				programDurationId, procedureGroupMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _proceduregroupProgdurationRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _proceduregroupProgdurationRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _proceduregroupProgdurationRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _proceduregroupProgdurationRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the proceduregroup progduration rel with the primary key.
	 *
	 * @param pgPdRelId the primary key of the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel
	 * @throws PortalException if a proceduregroup progduration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
			getProceduregroupProgdurationRel(long pgPdRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRel(pgPdRelId);
	}

	/**
	 * Returns the proceduregroup progduration rel matching the UUID and group.
	 *
	 * @param uuid the proceduregroup progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching proceduregroup progduration rel
	 * @throws PortalException if a matching proceduregroup progduration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
			getProceduregroupProgdurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the proceduregroup progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProceduregroupProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @return the range of proceduregroup progduration rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRels(int start, int end) {

		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRels(start, end);
	}

	/**
	 * Returns all the proceduregroup progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduregroup progduration rels
	 * @param companyId the primary key of the company
	 * @return the matching proceduregroup progduration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of proceduregroup progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the proceduregroup progduration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of proceduregroup progduration rels
	 * @param end the upper bound of the range of proceduregroup progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching proceduregroup progduration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProceduregroupProgdurationRel>
		getProceduregroupProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProceduregroupProgdurationRel>
					orderByComparator) {

		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of proceduregroup progduration rels.
	 *
	 * @return the number of proceduregroup progduration rels
	 */
	@Override
	public int getProceduregroupProgdurationRelsCount() {
		return _proceduregroupProgdurationRelLocalService.
			getProceduregroupProgdurationRelsCount();
	}

	/**
	 * Updates the proceduregroup progduration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProceduregroupProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param proceduregroupProgdurationRel the proceduregroup progduration rel
	 * @return the proceduregroup progduration rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProceduregroupProgdurationRel
		updateProceduregroupProgdurationRel(
			gov.omsb.tms.model.ProceduregroupProgdurationRel
				proceduregroupProgdurationRel) {

		return _proceduregroupProgdurationRelLocalService.
			updateProceduregroupProgdurationRel(proceduregroupProgdurationRel);
	}

	@Override
	public ProceduregroupProgdurationRelLocalService getWrappedService() {
		return _proceduregroupProgdurationRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProceduregroupProgdurationRelLocalService
			proceduregroupProgdurationRelLocalService) {

		_proceduregroupProgdurationRelLocalService =
			proceduregroupProgdurationRelLocalService;
	}

	private ProceduregroupProgdurationRelLocalService
		_proceduregroupProgdurationRelLocalService;

}