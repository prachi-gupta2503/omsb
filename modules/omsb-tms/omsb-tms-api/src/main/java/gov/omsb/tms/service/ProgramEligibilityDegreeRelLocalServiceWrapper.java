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
 * Provides a wrapper for {@link ProgramEligibilityDegreeRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramEligibilityDegreeRelLocalService
 * @generated
 */
public class ProgramEligibilityDegreeRelLocalServiceWrapper
	implements ProgramEligibilityDegreeRelLocalService,
			   ServiceWrapper<ProgramEligibilityDegreeRelLocalService> {

	public ProgramEligibilityDegreeRelLocalServiceWrapper() {
		this(null);
	}

	public ProgramEligibilityDegreeRelLocalServiceWrapper(
		ProgramEligibilityDegreeRelLocalService
			programEligibilityDegreeRelLocalService) {

		_programEligibilityDegreeRelLocalService =
			programEligibilityDegreeRelLocalService;
	}

	/**
	 * Adds the program eligibility degree rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramEligibilityDegreeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 * @return the program eligibility degree rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		addProgramEligibilityDegreeRel(
			gov.omsb.tms.model.ProgramEligibilityDegreeRel
				programEligibilityDegreeRel) {

		return _programEligibilityDegreeRelLocalService.
			addProgramEligibilityDegreeRel(programEligibilityDegreeRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new program eligibility degree rel with the primary key. Does not add the program eligibility degree rel to the database.
	 *
	 * @param programEdId the primary key for the new program eligibility degree rel
	 * @return the new program eligibility degree rel
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		createProgramEligibilityDegreeRel(long programEdId) {

		return _programEligibilityDegreeRelLocalService.
			createProgramEligibilityDegreeRel(programEdId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the program eligibility degree rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramEligibilityDegreeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 * @throws PortalException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
			deleteProgramEligibilityDegreeRel(long programEdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.
			deleteProgramEligibilityDegreeRel(programEdId);
	}

	/**
	 * Deletes the program eligibility degree rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramEligibilityDegreeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		deleteProgramEligibilityDegreeRel(
			gov.omsb.tms.model.ProgramEligibilityDegreeRel
				programEligibilityDegreeRel) {

		return _programEligibilityDegreeRelLocalService.
			deleteProgramEligibilityDegreeRel(programEligibilityDegreeRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _programEligibilityDegreeRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _programEligibilityDegreeRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _programEligibilityDegreeRelLocalService.dynamicQuery();
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

		return _programEligibilityDegreeRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramEligibilityDegreeRelModelImpl</code>.
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

		return _programEligibilityDegreeRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramEligibilityDegreeRelModelImpl</code>.
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

		return _programEligibilityDegreeRelLocalService.dynamicQuery(
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

		return _programEligibilityDegreeRelLocalService.dynamicQueryCount(
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

		return _programEligibilityDegreeRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		fetchProgramEligibilityDegreeRel(long programEdId) {

		return _programEligibilityDegreeRelLocalService.
			fetchProgramEligibilityDegreeRel(programEdId);
	}

	/**
	 * Returns the program eligibility degree rel matching the UUID and group.
	 *
	 * @param uuid the program eligibility degree rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		fetchProgramEligibilityDegreeRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _programEligibilityDegreeRelLocalService.
			fetchProgramEligibilityDegreeRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		findByProgramAndEligibilityDegreeId(
			long programMasterId, long eligibilityDegreeMasterId) {

		return _programEligibilityDegreeRelLocalService.
			findByProgramAndEligibilityDegreeId(
				programMasterId, eligibilityDegreeMasterId);
	}

	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		findEligibilityRelByProgramId(long programMasterId) {

		return _programEligibilityDegreeRelLocalService.
			findEligibilityRelByProgramId(programMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _programEligibilityDegreeRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _programEligibilityDegreeRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _programEligibilityDegreeRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programEligibilityDegreeRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the program eligibility degree rel with the primary key.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel
	 * @throws PortalException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
			getProgramEligibilityDegreeRel(long programEdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRel(programEdId);
	}

	/**
	 * Returns the program eligibility degree rel matching the UUID and group.
	 *
	 * @param uuid the program eligibility degree rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching program eligibility degree rel
	 * @throws PortalException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
			getProgramEligibilityDegreeRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of program eligibility degree rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramEligibilityDegreeRel>
		getProgramEligibilityDegreeRels(int start, int end) {

		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRels(start, end);
	}

	/**
	 * Returns all the program eligibility degree rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program eligibility degree rels
	 * @param companyId the primary key of the company
	 * @return the matching program eligibility degree rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramEligibilityDegreeRel>
		getProgramEligibilityDegreeRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of program eligibility degree rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the program eligibility degree rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching program eligibility degree rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgramEligibilityDegreeRel>
		getProgramEligibilityDegreeRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgramEligibilityDegreeRel>
					orderByComparator) {

		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of program eligibility degree rels.
	 *
	 * @return the number of program eligibility degree rels
	 */
	@Override
	public int getProgramEligibilityDegreeRelsCount() {
		return _programEligibilityDegreeRelLocalService.
			getProgramEligibilityDegreeRelsCount();
	}

	/**
	 * Updates the program eligibility degree rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgramEligibilityDegreeRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 * @return the program eligibility degree rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgramEligibilityDegreeRel
		updateProgramEligibilityDegreeRel(
			gov.omsb.tms.model.ProgramEligibilityDegreeRel
				programEligibilityDegreeRel) {

		return _programEligibilityDegreeRelLocalService.
			updateProgramEligibilityDegreeRel(programEligibilityDegreeRel);
	}

	@Override
	public ProgramEligibilityDegreeRelLocalService getWrappedService() {
		return _programEligibilityDegreeRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgramEligibilityDegreeRelLocalService
			programEligibilityDegreeRelLocalService) {

		_programEligibilityDegreeRelLocalService =
			programEligibilityDegreeRelLocalService;
	}

	private ProgramEligibilityDegreeRelLocalService
		_programEligibilityDegreeRelLocalService;

}