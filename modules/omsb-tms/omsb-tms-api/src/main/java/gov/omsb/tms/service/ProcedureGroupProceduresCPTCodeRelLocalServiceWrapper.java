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
 * Provides a wrapper for {@link ProcedureGroupProceduresCPTCodeRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelLocalService
 * @generated
 */
public class ProcedureGroupProceduresCPTCodeRelLocalServiceWrapper
	implements ProcedureGroupProceduresCPTCodeRelLocalService,
			   ServiceWrapper<ProcedureGroupProceduresCPTCodeRelLocalService> {

	public ProcedureGroupProceduresCPTCodeRelLocalServiceWrapper() {
		this(null);
	}

	public ProcedureGroupProceduresCPTCodeRelLocalServiceWrapper(
		ProcedureGroupProceduresCPTCodeRelLocalService
			procedureGroupProceduresCPTCodeRelLocalService) {

		_procedureGroupProceduresCPTCodeRelLocalService =
			procedureGroupProceduresCPTCodeRelLocalService;
	}

	/**
	 * Adds the procedure group procedures cpt code rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		addProcedureGroupProceduresCPTCodeRel(
			gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			addProcedureGroupProceduresCPTCodeRel(
				procedureGroupProceduresCPTCodeRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new procedure group procedures cpt code rel with the primary key. Does not add the procedure group procedures cpt code rel to the database.
	 *
	 * @param pgProcedureCptCodeRelId the primary key for the new procedure group procedures cpt code rel
	 * @return the new procedure group procedures cpt code rel
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		createProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			createProcedureGroupProceduresCPTCodeRel(pgProcedureCptCodeRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the procedure group procedures cpt code rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 * @throws PortalException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
			deleteProcedureGroupProceduresCPTCodeRel(
				long pgProcedureCptCodeRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			deleteProcedureGroupProceduresCPTCodeRel(pgProcedureCptCodeRelId);
	}

	/**
	 * Deletes the procedure group procedures cpt code rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		deleteProcedureGroupProceduresCPTCodeRel(
			gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			deleteProcedureGroupProceduresCPTCodeRel(
				procedureGroupProceduresCPTCodeRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _procedureGroupProceduresCPTCodeRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _procedureGroupProceduresCPTCodeRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _procedureGroupProceduresCPTCodeRelLocalService.dynamicQuery();
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

		return _procedureGroupProceduresCPTCodeRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
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

		return _procedureGroupProceduresCPTCodeRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
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

		return _procedureGroupProceduresCPTCodeRelLocalService.dynamicQuery(
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

		return _procedureGroupProceduresCPTCodeRelLocalService.
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

		return _procedureGroupProceduresCPTCodeRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		fetchProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			fetchProcedureGroupProceduresCPTCodeRel(pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel matching the UUID and group.
	 *
	 * @param uuid the procedure group procedures cpt code rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group procedures cpt code rel, or <code>null</code> if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		fetchProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			fetchProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel>
		findByProcedureGroupId(long procedureGroupId) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			findByProcedureGroupId(procedureGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _procedureGroupProceduresCPTCodeRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the procedure group procedures cpt code rel with the primary key.
	 *
	 * @param pgProcedureCptCodeRelId the primary key of the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel
	 * @throws PortalException if a procedure group procedures cpt code rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
			getProcedureGroupProceduresCPTCodeRel(long pgProcedureCptCodeRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRel(pgProcedureCptCodeRelId);
	}

	/**
	 * Returns the procedure group procedures cpt code rel matching the UUID and group.
	 *
	 * @param uuid the procedure group procedures cpt code rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching procedure group procedures cpt code rel
	 * @throws PortalException if a matching procedure group procedures cpt code rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
			getProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the procedure group procedures cpt code rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @return the range of procedure group procedures cpt code rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRels(int start, int end) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRels(start, end);
	}

	/**
	 * Returns all the procedure group procedures cpt code rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group procedures cpt code rels
	 * @param companyId the primary key of the company
	 * @return the matching procedure group procedures cpt code rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of procedure group procedures cpt code rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the procedure group procedures cpt code rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of procedure group procedures cpt code rels
	 * @param end the upper bound of the range of procedure group procedures cpt code rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching procedure group procedures cpt code rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel>
		getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel>
					orderByComparator) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of procedure group procedures cpt code rels.
	 *
	 * @return the number of procedure group procedures cpt code rels
	 */
	@Override
	public int getProcedureGroupProceduresCPTCodeRelsCount() {
		return _procedureGroupProceduresCPTCodeRelLocalService.
			getProcedureGroupProceduresCPTCodeRelsCount();
	}

	/**
	 * Updates the procedure group procedures cpt code rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProcedureGroupProceduresCPTCodeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param procedureGroupProceduresCPTCodeRel the procedure group procedures cpt code rel
	 * @return the procedure group procedures cpt code rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
		updateProcedureGroupProceduresCPTCodeRel(
			gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel
				procedureGroupProceduresCPTCodeRel) {

		return _procedureGroupProceduresCPTCodeRelLocalService.
			updateProcedureGroupProceduresCPTCodeRel(
				procedureGroupProceduresCPTCodeRel);
	}

	@Override
	public ProcedureGroupProceduresCPTCodeRelLocalService getWrappedService() {
		return _procedureGroupProceduresCPTCodeRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProcedureGroupProceduresCPTCodeRelLocalService
			procedureGroupProceduresCPTCodeRelLocalService) {

		_procedureGroupProceduresCPTCodeRelLocalService =
			procedureGroupProceduresCPTCodeRelLocalService;
	}

	private ProcedureGroupProceduresCPTCodeRelLocalService
		_procedureGroupProceduresCPTCodeRelLocalService;

}