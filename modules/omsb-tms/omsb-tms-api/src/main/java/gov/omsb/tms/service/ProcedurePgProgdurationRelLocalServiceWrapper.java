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
 * Provides a wrapper for {@link ProcedurePgProgdurationRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRelLocalService
 * @generated
 */
public class ProcedurePgProgdurationRelLocalServiceWrapper
	implements ProcedurePgProgdurationRelLocalService,
			   ServiceWrapper<ProcedurePgProgdurationRelLocalService> {

	public ProcedurePgProgdurationRelLocalServiceWrapper() {
		this(null);
	}

	public ProcedurePgProgdurationRelLocalServiceWrapper(
		ProcedurePgProgdurationRelLocalService
			procedurePgProgdurationRelLocalService) {

		_procedurePgProgdurationRelLocalService =
			procedurePgProgdurationRelLocalService;
	}

	/**
	 * Adds the procedure pg progduration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedurePgProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		addProcedurePgProgdurationRel(
			gov.omsb.tms.model.ProcedurePgProgdurationRel
				procedurePgProgdurationRel) {

		return _procedurePgProgdurationRelLocalService.
			addProcedurePgProgdurationRel(procedurePgProgdurationRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new procedure pg progduration rel with the primary key. Does not add the procedure pg progduration rel to the database.
	 *
	 * @param procedurePgPdRelId the primary key for the new procedure pg progduration rel
	 * @return the new procedure pg progduration rel
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		createProcedurePgProgdurationRel(long procedurePgPdRelId) {

		return _procedurePgProgdurationRelLocalService.
			createProcedurePgProgdurationRel(procedurePgPdRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the procedure pg progduration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedurePgProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 * @throws PortalException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
			deleteProcedurePgProgdurationRel(long procedurePgPdRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.
			deleteProcedurePgProgdurationRel(procedurePgPdRelId);
	}

	/**
	 * Deletes the procedure pg progduration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedurePgProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		deleteProcedurePgProgdurationRel(
			gov.omsb.tms.model.ProcedurePgProgdurationRel
				procedurePgProgdurationRel) {

		return _procedurePgProgdurationRelLocalService.
			deleteProcedurePgProgdurationRel(procedurePgProgdurationRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _procedurePgProgdurationRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _procedurePgProgdurationRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _procedurePgProgdurationRelLocalService.dynamicQuery();
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

		return _procedurePgProgdurationRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedurePgProgdurationRelModelImpl</code>.
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

		return _procedurePgProgdurationRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedurePgProgdurationRelModelImpl</code>.
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

		return _procedurePgProgdurationRelLocalService.dynamicQuery(
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

		return _procedurePgProgdurationRelLocalService.dynamicQueryCount(
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

		return _procedurePgProgdurationRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		fetchProcedurePgProgdurationRel(long procedurePgPdRelId) {

		return _procedurePgProgdurationRelLocalService.
			fetchProcedurePgProgdurationRel(procedurePgPdRelId);
	}

	/**
	 * Returns the procedure pg progduration rel matching the UUID and group.
	 *
	 * @param uuid the procedure pg progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure pg progduration rel, or <code>null</code> if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		fetchProcedurePgProgdurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _procedurePgProgdurationRelLocalService.
			fetchProcedurePgProgdurationRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		findByProcedureGroupMasterId(long procedureGroupMasterId) {

		return _procedurePgProgdurationRelLocalService.
			findByProcedureGroupMasterId(procedureGroupMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		findByProcedureMasterId(long procedureMasterId) {

		return _procedurePgProgdurationRelLocalService.findByProcedureMasterId(
			procedureMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		findByProgramDurationId(long programDurationId) {

		return _procedurePgProgdurationRelLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
			long programDurationId, long procedureGroupMasterId,
			long procedureMasterId) {

		return _procedurePgProgdurationRelLocalService.
			findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(
				programDurationId, procedureGroupMasterId, procedureMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _procedurePgProgdurationRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _procedurePgProgdurationRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _procedurePgProgdurationRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _procedurePgProgdurationRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the procedure pg progduration rel with the primary key.
	 *
	 * @param procedurePgPdRelId the primary key of the procedure pg progduration rel
	 * @return the procedure pg progduration rel
	 * @throws PortalException if a procedure pg progduration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
			getProcedurePgProgdurationRel(long procedurePgPdRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRel(procedurePgPdRelId);
	}

	/**
	 * Returns the procedure pg progduration rel matching the UUID and group.
	 *
	 * @param uuid the procedure pg progduration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure pg progduration rel
	 * @throws PortalException if a matching procedure pg progduration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
			getProcedurePgProgdurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure pg progduration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedurePgProgdurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @return the range of procedure pg progduration rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		getProcedurePgProgdurationRels(int start, int end) {

		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRels(start, end);
	}

	/**
	 * Returns all the procedure pg progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure pg progduration rels
	 * @param companyId the primary key of the company
	 * @return the matching procedure pg progduration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		getProcedurePgProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of procedure pg progduration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure pg progduration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure pg progduration rels
	 * @param end the upper bound of the range of procedure pg progduration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure pg progduration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedurePgProgdurationRel>
		getProcedurePgProgdurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProcedurePgProgdurationRel>
					orderByComparator) {

		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure pg progduration rels.
	 *
	 * @return the number of procedure pg progduration rels
	 */
	@Override
	public int getProcedurePgProgdurationRelsCount() {
		return _procedurePgProgdurationRelLocalService.
			getProcedurePgProgdurationRelsCount();
	}

	/**
	 * Updates the procedure pg progduration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedurePgProgdurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedurePgProgdurationRel the procedure pg progduration rel
	 * @return the procedure pg progduration rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProcedurePgProgdurationRel
		updateProcedurePgProgdurationRel(
			gov.omsb.tms.model.ProcedurePgProgdurationRel
				procedurePgProgdurationRel) {

		return _procedurePgProgdurationRelLocalService.
			updateProcedurePgProgdurationRel(procedurePgProgdurationRel);
	}

	@Override
	public ProcedurePgProgdurationRelLocalService getWrappedService() {
		return _procedurePgProgdurationRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProcedurePgProgdurationRelLocalService
			procedurePgProgdurationRelLocalService) {

		_procedurePgProgdurationRelLocalService =
			procedurePgProgdurationRelLocalService;
	}

	private ProcedurePgProgdurationRelLocalService
		_procedurePgProgdurationRelLocalService;

}