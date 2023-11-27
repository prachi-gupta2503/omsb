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
 * Provides a wrapper for {@link VisitTypeProgDurationRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeProgDurationRelLocalService
 * @generated
 */
public class VisitTypeProgDurationRelLocalServiceWrapper
	implements ServiceWrapper<VisitTypeProgDurationRelLocalService>,
			   VisitTypeProgDurationRelLocalService {

	public VisitTypeProgDurationRelLocalServiceWrapper() {
		this(null);
	}

	public VisitTypeProgDurationRelLocalServiceWrapper(
		VisitTypeProgDurationRelLocalService
			visitTypeProgDurationRelLocalService) {

		_visitTypeProgDurationRelLocalService =
			visitTypeProgDurationRelLocalService;
	}

	/**
	 * Adds the visit type prog duration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was added
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		addVisitTypeProgDurationRel(
			gov.omsb.tms.model.VisitTypeProgDurationRel
				visitTypeProgDurationRel) {

		return _visitTypeProgDurationRelLocalService.
			addVisitTypeProgDurationRel(visitTypeProgDurationRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new visit type prog duration rel with the primary key. Does not add the visit type prog duration rel to the database.
	 *
	 * @param VisitTypeProgDurationRelId the primary key for the new visit type prog duration rel
	 * @return the new visit type prog duration rel
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		createVisitTypeProgDurationRel(long VisitTypeProgDurationRelId) {

		return _visitTypeProgDurationRelLocalService.
			createVisitTypeProgDurationRel(VisitTypeProgDurationRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the visit type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 * @throws PortalException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
			deleteVisitTypeProgDurationRel(long VisitTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.
			deleteVisitTypeProgDurationRel(VisitTypeProgDurationRelId);
	}

	/**
	 * Deletes the visit type prog duration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		deleteVisitTypeProgDurationRel(
			gov.omsb.tms.model.VisitTypeProgDurationRel
				visitTypeProgDurationRel) {

		return _visitTypeProgDurationRelLocalService.
			deleteVisitTypeProgDurationRel(visitTypeProgDurationRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _visitTypeProgDurationRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _visitTypeProgDurationRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visitTypeProgDurationRelLocalService.dynamicQuery();
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

		return _visitTypeProgDurationRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
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

		return _visitTypeProgDurationRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
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

		return _visitTypeProgDurationRelLocalService.dynamicQuery(
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

		return _visitTypeProgDurationRelLocalService.dynamicQueryCount(
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

		return _visitTypeProgDurationRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		fetchVisitTypeProgDurationRel(long VisitTypeProgDurationRelId) {

		return _visitTypeProgDurationRelLocalService.
			fetchVisitTypeProgDurationRel(VisitTypeProgDurationRelId);
	}

	/**
	 * Returns the visit type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the visit type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type prog duration rel, or <code>null</code> if a matching visit type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		fetchVisitTypeProgDurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _visitTypeProgDurationRelLocalService.
			fetchVisitTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeProgDurationRel>
		findByProgramDurationId(long programDurationId) {

		return _visitTypeProgDurationRelLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		findByProgramDurationIdAndVisitTypeMasterId(
			long programDurationId, long visitTypeMasterId) {

		return _visitTypeProgDurationRelLocalService.
			findByProgramDurationIdAndVisitTypeMasterId(
				programDurationId, visitTypeMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _visitTypeProgDurationRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _visitTypeProgDurationRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _visitTypeProgDurationRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _visitTypeProgDurationRelLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<Long, String> getOtherVisitTypesFromVisitMaster(
		long programDurationId, String type, String languageCode) {

		return _visitTypeProgDurationRelLocalService.
			getOtherVisitTypesFromVisitMaster(
				programDurationId, type, languageCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the visit type prog duration rel with the primary key.
	 *
	 * @param VisitTypeProgDurationRelId the primary key of the visit type prog duration rel
	 * @return the visit type prog duration rel
	 * @throws PortalException if a visit type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
			getVisitTypeProgDurationRel(long VisitTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRel(VisitTypeProgDurationRelId);
	}

	/**
	 * Returns the visit type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the visit type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type prog duration rel
	 * @throws PortalException if a matching visit type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
			getVisitTypeProgDurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the visit type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @return the range of visit type prog duration rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeProgDurationRel>
		getVisitTypeProgDurationRels(int start, int end) {

		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRels(start, end);
	}

	/**
	 * Returns all the visit type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type prog duration rels
	 * @param companyId the primary key of the company
	 * @return the matching visit type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeProgDurationRel>
		getVisitTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of visit type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type prog duration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of visit type prog duration rels
	 * @param end the upper bound of the range of visit type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching visit type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeProgDurationRel>
		getVisitTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.VisitTypeProgDurationRel>
					orderByComparator) {

		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of visit type prog duration rels.
	 *
	 * @return the number of visit type prog duration rels
	 */
	@Override
	public int getVisitTypeProgDurationRelsCount() {
		return _visitTypeProgDurationRelLocalService.
			getVisitTypeProgDurationRelsCount();
	}

	/**
	 * Updates the visit type prog duration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeProgDurationRel the visit type prog duration rel
	 * @return the visit type prog duration rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeProgDurationRel
		updateVisitTypeProgDurationRel(
			gov.omsb.tms.model.VisitTypeProgDurationRel
				visitTypeProgDurationRel) {

		return _visitTypeProgDurationRelLocalService.
			updateVisitTypeProgDurationRel(visitTypeProgDurationRel);
	}

	@Override
	public VisitTypeProgDurationRelLocalService getWrappedService() {
		return _visitTypeProgDurationRelLocalService;
	}

	@Override
	public void setWrappedService(
		VisitTypeProgDurationRelLocalService
			visitTypeProgDurationRelLocalService) {

		_visitTypeProgDurationRelLocalService =
			visitTypeProgDurationRelLocalService;
	}

	private VisitTypeProgDurationRelLocalService
		_visitTypeProgDurationRelLocalService;

}