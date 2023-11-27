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
 * Provides a wrapper for {@link ProgramProgramTypeRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramProgramTypeRelLocalService
 * @generated
 */
public class ProgramProgramTypeRelLocalServiceWrapper
	implements ProgramProgramTypeRelLocalService,
			   ServiceWrapper<ProgramProgramTypeRelLocalService> {

	public ProgramProgramTypeRelLocalServiceWrapper() {
		this(null);
	}

	public ProgramProgramTypeRelLocalServiceWrapper(
		ProgramProgramTypeRelLocalService programProgramTypeRelLocalService) {

		_programProgramTypeRelLocalService = programProgramTypeRelLocalService;
	}

	/**
	 * Adds the program program type rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel addProgramProgramTypeRel(
		gov.omsb.tms.model.ProgramProgramTypeRel programProgramTypeRel) {

		return _programProgramTypeRelLocalService.addProgramProgramTypeRel(
			programProgramTypeRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new program program type rel with the primary key. Does not add the program program type rel to the database.
	 *
	 * @param programPtId the primary key for the new program program type rel
	 * @return the new program program type rel
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel createProgramProgramTypeRel(
		long programPtId) {

		return _programProgramTypeRelLocalService.createProgramProgramTypeRel(
			programPtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program program type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel that was removed
	 * @throws PortalException if a program program type rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel deleteProgramProgramTypeRel(
			long programPtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.deleteProgramProgramTypeRel(
			programPtId);
	}

	/**
	 * Deletes the program program type rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel deleteProgramProgramTypeRel(
		gov.omsb.tms.model.ProgramProgramTypeRel programProgramTypeRel) {

		return _programProgramTypeRelLocalService.deleteProgramProgramTypeRel(
			programProgramTypeRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programProgramTypeRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programProgramTypeRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programProgramTypeRelLocalService.dynamicQuery();
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

		return _programProgramTypeRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
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

		return _programProgramTypeRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
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

		return _programProgramTypeRelLocalService.dynamicQuery(
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

		return _programProgramTypeRelLocalService.dynamicQueryCount(
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

		return _programProgramTypeRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel fetchProgramProgramTypeRel(
		long programPtId) {

		return _programProgramTypeRelLocalService.fetchProgramProgramTypeRel(
			programPtId);
	}

	/**
	 * Returns the program program type rel matching the UUID and group.
	 *
	 * @param uuid the program program type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program program type rel, or <code>null</code> if a matching program program type rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel
		fetchProgramProgramTypeRelByUuidAndGroupId(String uuid, long groupId) {

		return _programProgramTypeRelLocalService.
			fetchProgramProgramTypeRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel
		findByProgramAndProgramTypeId(
			long programMasterId, long programTypeMasterId) {

		return _programProgramTypeRelLocalService.findByProgramAndProgramTypeId(
			programMasterId, programTypeMasterId);
	}

	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel findByProgramId(
		long programMasterId) {

		return _programProgramTypeRelLocalService.findByProgramId(
			programMasterId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgramProgramTypeRel>
		findProgramMasterByPerogramTypeId(long programTypeId) {

		return _programProgramTypeRelLocalService.
			findProgramMasterByPerogramTypeId(programTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programProgramTypeRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programProgramTypeRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programProgramTypeRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programProgramTypeRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the program program type rel with the primary key.
	 *
	 * @param programPtId the primary key of the program program type rel
	 * @return the program program type rel
	 * @throws PortalException if a program program type rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel getProgramProgramTypeRel(
			long programPtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.getProgramProgramTypeRel(
			programPtId);
	}

	/**
	 * Returns the program program type rel matching the UUID and group.
	 *
	 * @param uuid the program program type rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program program type rel
	 * @throws PortalException if a matching program program type rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel
			getProgramProgramTypeRelByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programProgramTypeRelLocalService.
			getProgramProgramTypeRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program program type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramProgramTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @return the range of program program type rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramProgramTypeRel>
		getProgramProgramTypeRels(int start, int end) {

		return _programProgramTypeRelLocalService.getProgramProgramTypeRels(
			start, end);
	}

	/**
	 * Returns all the program program type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program program type rels
	 * @param companyId the primary key of the company
	 * @return the matching program program type rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramProgramTypeRel>
		getProgramProgramTypeRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _programProgramTypeRelLocalService.
			getProgramProgramTypeRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program program type rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program program type rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program program type rels
	 * @param end the upper bound of the range of program program type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program program type rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramProgramTypeRel>
		getProgramProgramTypeRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramProgramTypeRel> orderByComparator) {

		return _programProgramTypeRelLocalService.
			getProgramProgramTypeRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program program type rels.
	 *
	 * @return the number of program program type rels
	 */
	@Override
	public int getProgramProgramTypeRelsCount() {
		return _programProgramTypeRelLocalService.
			getProgramProgramTypeRelsCount();
	}

	/**
	 * Updates the program program type rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramProgramTypeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programProgramTypeRel the program program type rel
	 * @return the program program type rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramProgramTypeRel updateProgramProgramTypeRel(
		gov.omsb.tms.model.ProgramProgramTypeRel programProgramTypeRel) {

		return _programProgramTypeRelLocalService.updateProgramProgramTypeRel(
			programProgramTypeRel);
	}

	@Override
	public ProgramProgramTypeRelLocalService getWrappedService() {
		return _programProgramTypeRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramProgramTypeRelLocalService programProgramTypeRelLocalService) {

		_programProgramTypeRelLocalService = programProgramTypeRelLocalService;
	}

	private ProgramProgramTypeRelLocalService
		_programProgramTypeRelLocalService;

}