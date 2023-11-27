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
 * Provides a wrapper for {@link ProgdurationObjectivesRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationObjectivesRelLocalService
 * @generated
 */
public class ProgdurationObjectivesRelLocalServiceWrapper
	implements ProgdurationObjectivesRelLocalService,
			   ServiceWrapper<ProgdurationObjectivesRelLocalService> {

	public ProgdurationObjectivesRelLocalServiceWrapper() {
		this(null);
	}

	public ProgdurationObjectivesRelLocalServiceWrapper(
		ProgdurationObjectivesRelLocalService
			progdurationObjectivesRelLocalService) {

		_progdurationObjectivesRelLocalService =
			progdurationObjectivesRelLocalService;
	}

	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		addProgdurationObjectivesRel(
			long groupId, long companyId, long progDurationId,
			String objectives) {

		return _progdurationObjectivesRelLocalService.
			addProgdurationObjectivesRel(
				groupId, companyId, progDurationId, objectives);
	}

	/**
	 * Adds the progduration objectives rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 * @return the progduration objectives rel that was added
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		addProgdurationObjectivesRel(
			gov.omsb.tms.model.ProgdurationObjectivesRel
				progdurationObjectivesRel) {

		return _progdurationObjectivesRelLocalService.
			addProgdurationObjectivesRel(progdurationObjectivesRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new progduration objectives rel with the primary key. Does not add the progduration objectives rel to the database.
	 *
	 * @param PDObjectivesId the primary key for the new progduration objectives rel
	 * @return the new progduration objectives rel
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		createProgdurationObjectivesRel(long PDObjectivesId) {

		return _progdurationObjectivesRelLocalService.
			createProgdurationObjectivesRel(PDObjectivesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the progduration objectives rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 * @throws PortalException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
			deleteProgdurationObjectivesRel(long PDObjectivesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.
			deleteProgdurationObjectivesRel(PDObjectivesId);
	}

	/**
	 * Deletes the progduration objectives rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 * @return the progduration objectives rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		deleteProgdurationObjectivesRel(
			gov.omsb.tms.model.ProgdurationObjectivesRel
				progdurationObjectivesRel) {

		return _progdurationObjectivesRelLocalService.
			deleteProgdurationObjectivesRel(progdurationObjectivesRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _progdurationObjectivesRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _progdurationObjectivesRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _progdurationObjectivesRelLocalService.dynamicQuery();
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

		return _progdurationObjectivesRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationObjectivesRelModelImpl</code>.
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

		return _progdurationObjectivesRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationObjectivesRelModelImpl</code>.
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

		return _progdurationObjectivesRelLocalService.dynamicQuery(
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

		return _progdurationObjectivesRelLocalService.dynamicQueryCount(
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

		return _progdurationObjectivesRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		fetchProgdurationObjectivesRel(long PDObjectivesId) {

		return _progdurationObjectivesRelLocalService.
			fetchProgdurationObjectivesRel(PDObjectivesId);
	}

	/**
	 * Returns the progduration objectives rel matching the UUID and group.
	 *
	 * @param uuid the progduration objectives rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration objectives rel, or <code>null</code> if a matching progduration objectives rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		fetchProgdurationObjectivesRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _progdurationObjectivesRelLocalService.
			fetchProgdurationObjectivesRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ProgdurationObjectivesRel>
		findByProgDurationId(long progDurationId) {

		return _progdurationObjectivesRelLocalService.findByProgDurationId(
			progDurationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _progdurationObjectivesRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _progdurationObjectivesRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _progdurationObjectivesRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationObjectivesRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the progduration objectives rel with the primary key.
	 *
	 * @param PDObjectivesId the primary key of the progduration objectives rel
	 * @return the progduration objectives rel
	 * @throws PortalException if a progduration objectives rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
			getProgdurationObjectivesRel(long PDObjectivesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRel(PDObjectivesId);
	}

	/**
	 * Returns the progduration objectives rel matching the UUID and group.
	 *
	 * @param uuid the progduration objectives rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching progduration objectives rel
	 * @throws PortalException if a matching progduration objectives rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
			getProgdurationObjectivesRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the progduration objectives rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ProgdurationObjectivesRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @return the range of progduration objectives rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgdurationObjectivesRel>
		getProgdurationObjectivesRels(int start, int end) {

		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRels(start, end);
	}

	/**
	 * Returns all the progduration objectives rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration objectives rels
	 * @param companyId the primary key of the company
	 * @return the matching progduration objectives rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgdurationObjectivesRel>
		getProgdurationObjectivesRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of progduration objectives rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the progduration objectives rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of progduration objectives rels
	 * @param end the upper bound of the range of progduration objectives rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching progduration objectives rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ProgdurationObjectivesRel>
		getProgdurationObjectivesRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ProgdurationObjectivesRel>
					orderByComparator) {

		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of progduration objectives rels.
	 *
	 * @return the number of progduration objectives rels
	 */
	@Override
	public int getProgdurationObjectivesRelsCount() {
		return _progdurationObjectivesRelLocalService.
			getProgdurationObjectivesRelsCount();
	}

	/**
	 * Updates the progduration objectives rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProgdurationObjectivesRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param progdurationObjectivesRel the progduration objectives rel
	 * @return the progduration objectives rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.ProgdurationObjectivesRel
		updateProgdurationObjectivesRel(
			gov.omsb.tms.model.ProgdurationObjectivesRel
				progdurationObjectivesRel) {

		return _progdurationObjectivesRelLocalService.
			updateProgdurationObjectivesRel(progdurationObjectivesRel);
	}

	@Override
	public ProgdurationObjectivesRelLocalService getWrappedService() {
		return _progdurationObjectivesRelLocalService;
	}

	@Override
	public void setWrappedService(
		ProgdurationObjectivesRelLocalService
			progdurationObjectivesRelLocalService) {

		_progdurationObjectivesRelLocalService =
			progdurationObjectivesRelLocalService;
	}

	private ProgdurationObjectivesRelLocalService
		_progdurationObjectivesRelLocalService;

}