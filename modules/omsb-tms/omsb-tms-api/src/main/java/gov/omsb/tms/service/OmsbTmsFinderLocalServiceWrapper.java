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
 * Provides a wrapper for {@link OmsbTmsFinderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OmsbTmsFinderLocalService
 * @generated
 */
public class OmsbTmsFinderLocalServiceWrapper
	implements OmsbTmsFinderLocalService,
			   ServiceWrapper<OmsbTmsFinderLocalService> {

	public OmsbTmsFinderLocalServiceWrapper() {
		this(null);
	}

	public OmsbTmsFinderLocalServiceWrapper(
		OmsbTmsFinderLocalService omsbTmsFinderLocalService) {

		_omsbTmsFinderLocalService = omsbTmsFinderLocalService;
	}

	/**
	 * Adds the omsb tms finder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was added
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder addOmsbTmsFinder(
		gov.omsb.tms.model.OmsbTmsFinder omsbTmsFinder) {

		return _omsbTmsFinderLocalService.addOmsbTmsFinder(omsbTmsFinder);
	}

	/**
	 * Creates a new omsb tms finder with the primary key. Does not add the omsb tms finder to the database.
	 *
	 * @param omsbTmsFinderId the primary key for the new omsb tms finder
	 * @return the new omsb tms finder
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder createOmsbTmsFinder(
		long omsbTmsFinderId) {

		return _omsbTmsFinderLocalService.createOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the omsb tms finder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder that was removed
	 * @throws PortalException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder deleteOmsbTmsFinder(
			long omsbTmsFinderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.deleteOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Deletes the omsb tms finder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was removed
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder deleteOmsbTmsFinder(
		gov.omsb.tms.model.OmsbTmsFinder omsbTmsFinder) {

		return _omsbTmsFinderLocalService.deleteOmsbTmsFinder(omsbTmsFinder);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _omsbTmsFinderLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _omsbTmsFinderLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _omsbTmsFinderLocalService.dynamicQuery();
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

		return _omsbTmsFinderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
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

		return _omsbTmsFinderLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
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

		return _omsbTmsFinderLocalService.dynamicQuery(
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

		return _omsbTmsFinderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _omsbTmsFinderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.OmsbTmsFinder fetchOmsbTmsFinder(
		long omsbTmsFinderId) {

		return _omsbTmsFinderLocalService.fetchOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder matching the UUID and group.
	 *
	 * @param uuid the omsb tms finder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching omsb tms finder, or <code>null</code> if a matching omsb tms finder could not be found
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder fetchOmsbTmsFinderByUuidAndGroupId(
		String uuid, long groupId) {

		return _omsbTmsFinderLocalService.fetchOmsbTmsFinderByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _omsbTmsFinderLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _omsbTmsFinderLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _omsbTmsFinderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the omsb tms finder with the primary key.
	 *
	 * @param omsbTmsFinderId the primary key of the omsb tms finder
	 * @return the omsb tms finder
	 * @throws PortalException if a omsb tms finder with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder getOmsbTmsFinder(
			long omsbTmsFinderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.getOmsbTmsFinder(omsbTmsFinderId);
	}

	/**
	 * Returns the omsb tms finder matching the UUID and group.
	 *
	 * @param uuid the omsb tms finder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching omsb tms finder
	 * @throws PortalException if a matching omsb tms finder could not be found
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder getOmsbTmsFinderByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.getOmsbTmsFinderByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the omsb tms finders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.OmsbTmsFinderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @return the range of omsb tms finders
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.OmsbTmsFinder> getOmsbTmsFinders(
		int start, int end) {

		return _omsbTmsFinderLocalService.getOmsbTmsFinders(start, end);
	}

	/**
	 * Returns all the omsb tms finders matching the UUID and company.
	 *
	 * @param uuid the UUID of the omsb tms finders
	 * @param companyId the primary key of the company
	 * @return the matching omsb tms finders, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.OmsbTmsFinder>
		getOmsbTmsFindersByUuidAndCompanyId(String uuid, long companyId) {

		return _omsbTmsFinderLocalService.getOmsbTmsFindersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of omsb tms finders matching the UUID and company.
	 *
	 * @param uuid the UUID of the omsb tms finders
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of omsb tms finders
	 * @param end the upper bound of the range of omsb tms finders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching omsb tms finders, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.OmsbTmsFinder>
		getOmsbTmsFindersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.OmsbTmsFinder> orderByComparator) {

		return _omsbTmsFinderLocalService.getOmsbTmsFindersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of omsb tms finders.
	 *
	 * @return the number of omsb tms finders
	 */
	@Override
	public int getOmsbTmsFindersCount() {
		return _omsbTmsFinderLocalService.getOmsbTmsFindersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _omsbTmsFinderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _omsbTmsFinderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the omsb tms finder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OmsbTmsFinderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param omsbTmsFinder the omsb tms finder
	 * @return the omsb tms finder that was updated
	 */
	@Override
	public gov.omsb.tms.model.OmsbTmsFinder updateOmsbTmsFinder(
		gov.omsb.tms.model.OmsbTmsFinder omsbTmsFinder) {

		return _omsbTmsFinderLocalService.updateOmsbTmsFinder(omsbTmsFinder);
	}

	@Override
	public OmsbTmsFinderLocalService getWrappedService() {
		return _omsbTmsFinderLocalService;
	}

	@Override
	public void setWrappedService(
		OmsbTmsFinderLocalService omsbTmsFinderLocalService) {

		_omsbTmsFinderLocalService = omsbTmsFinderLocalService;
	}

	private OmsbTmsFinderLocalService _omsbTmsFinderLocalService;

}