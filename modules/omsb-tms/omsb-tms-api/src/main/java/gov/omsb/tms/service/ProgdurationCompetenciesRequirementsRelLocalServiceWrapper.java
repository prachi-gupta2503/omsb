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
 * Provides a wrapper for {@link ProgdurationCompetenciesRequirementsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRelLocalService
 * @generated
 */
public class ProgdurationCompetenciesRequirementsRelLocalServiceWrapper
	implements ProgdurationCompetenciesRequirementsRelLocalService,
			   ServiceWrapper
				   <ProgdurationCompetenciesRequirementsRelLocalService> {

	public ProgdurationCompetenciesRequirementsRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationCompetenciesRequirementsRelLocalServiceWrapper(
		ProgdurationCompetenciesRequirementsRelLocalService
			progdurationCompetenciesRequirementsRelLocalService) {

		_progdurationCompetenciesRequirementsRelLocalService =
			progdurationCompetenciesRequirementsRelLocalService;
	}

	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		addProgdurationCompetenciesRequirementsRel(
			long groupId, long companyId, long progDurationId,
			long competenciesMasterId, String requirements) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			addProgdurationCompetenciesRequirementsRel(
				groupId, companyId, progDurationId, competenciesMasterId,
				requirements);
	}

	/**
	 * Adds the progduration competencies requirements rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		addProgdurationCompetenciesRequirementsRel(
			gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			addProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRequirementsRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new progduration competencies requirements rel with the primary key. Does not add the progduration competencies requirements rel to the database.
	 *
	 * @param progdurationCompetenciesRelId the primary key for the new progduration competencies requirements rel
	 * @return the new progduration competencies requirements rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		createProgdurationCompetenciesRequirementsRel(
			long progdurationCompetenciesRelId) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			createProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the progduration competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 * @throws PortalException if a progduration competencies requirements rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
			deleteProgdurationCompetenciesRequirementsRel(
				long progdurationCompetenciesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			deleteProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRelId);
	}

	/**
	 * Deletes the progduration competencies requirements rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		deleteProgdurationCompetenciesRequirementsRel(
			gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			deleteProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRequirementsRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationCompetenciesRequirementsRelLocalService.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationCompetenciesRequirementsRelLocalService.
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

		return _progdurationCompetenciesRequirementsRelLocalService.
			dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
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

		return _progdurationCompetenciesRequirementsRelLocalService.
			dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
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

		return _progdurationCompetenciesRequirementsRelLocalService.
			dynamicQuery(dynamicQuery, start, end, orderByComparator);
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

		return _progdurationCompetenciesRequirementsRelLocalService.
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

		return _progdurationCompetenciesRequirementsRelLocalService.
			dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		fetchProgdurationCompetenciesRequirementsRel(
			long progdurationCompetenciesRelId) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			fetchProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRelId);
	}

	/**
	 * Returns the progduration competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the progduration competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration competencies requirements rel, or <code>null</code> if a matching progduration competencies requirements rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		fetchProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			fetchProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel>
			getByProgDurationId(long progDurationId) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getByProgDurationId(progDurationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationCompetenciesRequirementsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the progduration competencies requirements rel with the primary key.
	 *
	 * @param progdurationCompetenciesRelId the primary key of the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel
	 * @throws PortalException if a progduration competencies requirements rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
			getProgdurationCompetenciesRequirementsRel(
				long progdurationCompetenciesRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRelId);
	}

	/**
	 * Returns the progduration competencies requirements rel matching the UUID and group.
	 *
	 * @param uuid the progduration competencies requirements rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration competencies requirements rel
	 * @throws PortalException if a matching progduration competencies requirements rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
			getProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRelByUuidAndGroupId(
				uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @return the range of progduration competencies requirements rels
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel>
			getProgdurationCompetenciesRequirementsRels(int start, int end) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRels(start, end);
	}

	/**
	 * Returns all the progduration competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration competencies requirements rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration competencies requirements rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel>
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of progduration competencies requirements rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration competencies requirements rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration competencies requirements rels
	 * @param end the upper bound of the range of progduration competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration competencies requirements rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel>
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel>
						orderByComparator) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration competencies requirements rels.
	 *
	 * @return the number of progduration competencies requirements rels
	 */
	@Override
	public int getProgdurationCompetenciesRequirementsRelsCount() {
		return _progdurationCompetenciesRequirementsRelLocalService.
			getProgdurationCompetenciesRequirementsRelsCount();
	}

	/**
	 * Updates the progduration competencies requirements rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationCompetenciesRequirementsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationCompetenciesRequirementsRel the progduration competencies requirements rel
	 * @return the progduration competencies requirements rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
		updateProgdurationCompetenciesRequirementsRel(
			gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel
				progdurationCompetenciesRequirementsRel) {

		return _progdurationCompetenciesRequirementsRelLocalService.
			updateProgdurationCompetenciesRequirementsRel(
				progdurationCompetenciesRequirementsRel);
	}

	@Override
	public ProgdurationCompetenciesRequirementsRelLocalService
		getWrappedService() {

		return _progdurationCompetenciesRequirementsRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationCompetenciesRequirementsRelLocalService
			progdurationCompetenciesRequirementsRelLocalService) {

		_progdurationCompetenciesRequirementsRelLocalService =
			progdurationCompetenciesRequirementsRelLocalService;
	}

	private ProgdurationCompetenciesRequirementsRelLocalService
		_progdurationCompetenciesRequirementsRelLocalService;

}