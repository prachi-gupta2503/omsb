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
 * Provides a wrapper for {@link ProgramWorkflowDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramWorkflowDetailsRelLocalService
 * @generated
 */
public class ProgramWorkflowDetailsRelLocalServiceWrapper
	implements ProgramWorkflowDetailsRelLocalService,
			   ServiceWrapper<ProgramWorkflowDetailsRelLocalService> {

	public ProgramWorkflowDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public ProgramWorkflowDetailsRelLocalServiceWrapper(
		ProgramWorkflowDetailsRelLocalService
			programWorkflowDetailsRelLocalService) {

		_programWorkflowDetailsRelLocalService =
			programWorkflowDetailsRelLocalService;
	}

	/**
	 * Adds the program workflow details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		addProgramWorkflowDetailsRel(
			gov.omsb.tms.model.ProgramWorkflowDetailsRel
				programWorkflowDetailsRel) {

		return _programWorkflowDetailsRelLocalService.
			addProgramWorkflowDetailsRel(programWorkflowDetailsRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		createProgramWorkflowDetailsRel(long programWorkflowDetailsRelId) {

		return _programWorkflowDetailsRelLocalService.
			createProgramWorkflowDetailsRel(programWorkflowDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
			deleteProgramWorkflowDetailsRel(long programWorkflowDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.
			deleteProgramWorkflowDetailsRel(programWorkflowDetailsRelId);
	}

	/**
	 * Deletes the program workflow details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		deleteProgramWorkflowDetailsRel(
			gov.omsb.tms.model.ProgramWorkflowDetailsRel
				programWorkflowDetailsRel) {

		return _programWorkflowDetailsRelLocalService.
			deleteProgramWorkflowDetailsRel(programWorkflowDetailsRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programWorkflowDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programWorkflowDetailsRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programWorkflowDetailsRelLocalService.dynamicQuery();
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

		return _programWorkflowDetailsRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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

		return _programWorkflowDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
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

		return _programWorkflowDetailsRelLocalService.dynamicQuery(
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

		return _programWorkflowDetailsRelLocalService.dynamicQueryCount(
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

		return _programWorkflowDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		fetchProgramWorkflowDetailsRel(long programWorkflowDetailsRelId) {

		return _programWorkflowDetailsRelLocalService.
			fetchProgramWorkflowDetailsRel(programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		fetchProgramWorkflowDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _programWorkflowDetailsRelLocalService.
			fetchProgramWorkflowDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel findByProgramId(
		long programId) {

		return _programWorkflowDetailsRelLocalService.findByProgramId(
			programId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programWorkflowDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programWorkflowDetailsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programWorkflowDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programWorkflowDetailsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the program workflow details rel with the primary key.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws PortalException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
			getProgramWorkflowDetailsRel(long programWorkflowDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRel(programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel matching the UUID and group.
	 *
	 * @param uuid the program workflow details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program workflow details rel
	 * @throws PortalException if a matching program workflow details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
			getProgramWorkflowDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of program workflow details rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRels(int start, int end) {

		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRels(start, end);
	}

	/**
	 * Returns all the program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @return the matching program workflow details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program workflow details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program workflow details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program workflow details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramWorkflowDetailsRel>
		getProgramWorkflowDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramWorkflowDetailsRel>
					orderByComparator) {

		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
	 */
	@Override
	public int getProgramWorkflowDetailsRelsCount() {
		return _programWorkflowDetailsRelLocalService.
			getProgramWorkflowDetailsRelsCount();
	}

	/**
	 * Updates the program workflow details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramWorkflowDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 * @return the program workflow details rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramWorkflowDetailsRel
		updateProgramWorkflowDetailsRel(
			gov.omsb.tms.model.ProgramWorkflowDetailsRel
				programWorkflowDetailsRel) {

		return _programWorkflowDetailsRelLocalService.
			updateProgramWorkflowDetailsRel(programWorkflowDetailsRel);
	}

	@Override
	public ProgramWorkflowDetailsRelLocalService getWrappedService() {
		return _programWorkflowDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramWorkflowDetailsRelLocalService
			programWorkflowDetailsRelLocalService) {

		_programWorkflowDetailsRelLocalService =
			programWorkflowDetailsRelLocalService;
	}

	private ProgramWorkflowDetailsRelLocalService
		_programWorkflowDetailsRelLocalService;

}