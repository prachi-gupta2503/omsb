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
 * Provides a wrapper for {@link VisitTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeMasterLocalService
 * @generated
 */
public class VisitTypeMasterLocalServiceWrapper
	implements ServiceWrapper<VisitTypeMasterLocalService>,
			   VisitTypeMasterLocalService {

	public VisitTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public VisitTypeMasterLocalServiceWrapper(
		VisitTypeMasterLocalService visitTypeMasterLocalService) {

		_visitTypeMasterLocalService = visitTypeMasterLocalService;
	}

	@Override
	public gov.omsb.tms.model.VisitTypeMaster addUpdateVisitTypeMaster(
		gov.omsb.tms.model.VisitTypeMaster visitTypeMaster,
		java.util.List<String> visitTypeNames, boolean isCreate) {

		return _visitTypeMasterLocalService.addUpdateVisitTypeMaster(
			visitTypeMaster, visitTypeNames, isCreate);
	}

	/**
	 * Adds the visit type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeMaster the visit type master
	 * @return the visit type master that was added
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster addVisitTypeMaster(
		gov.omsb.tms.model.VisitTypeMaster visitTypeMaster) {

		return _visitTypeMasterLocalService.addVisitTypeMaster(visitTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new visit type master with the primary key. Does not add the visit type master to the database.
	 *
	 * @param visitTypeMasterId the primary key for the new visit type master
	 * @return the new visit type master
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster createVisitTypeMaster(
		long visitTypeMasterId) {

		return _visitTypeMasterLocalService.createVisitTypeMaster(
			visitTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the visit type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master that was removed
	 * @throws PortalException if a visit type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster deleteVisitTypeMaster(
			long visitTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.deleteVisitTypeMaster(
			visitTypeMasterId);
	}

	/**
	 * Deletes the visit type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeMaster the visit type master
	 * @return the visit type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster deleteVisitTypeMaster(
		gov.omsb.tms.model.VisitTypeMaster visitTypeMaster) {

		return _visitTypeMasterLocalService.deleteVisitTypeMaster(
			visitTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _visitTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _visitTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _visitTypeMasterLocalService.dynamicQuery();
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

		return _visitTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeMasterModelImpl</code>.
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

		return _visitTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeMasterModelImpl</code>.
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

		return _visitTypeMasterLocalService.dynamicQuery(
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

		return _visitTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _visitTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.VisitTypeMaster fetchVisitTypeMaster(
		long visitTypeMasterId) {

		return _visitTypeMasterLocalService.fetchVisitTypeMaster(
			visitTypeMasterId);
	}

	/**
	 * Returns the visit type master matching the UUID and group.
	 *
	 * @param uuid the visit type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type master, or <code>null</code> if a matching visit type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster
		fetchVisitTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _visitTypeMasterLocalService.
			fetchVisitTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeMaster>
		findByVisitTypeNameByLike(String visitTypeName) {

		return _visitTypeMasterLocalService.findByVisitTypeNameByLike(
			visitTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _visitTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _visitTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _visitTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _visitTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the visit type master with the primary key.
	 *
	 * @param visitTypeMasterId the primary key of the visit type master
	 * @return the visit type master
	 * @throws PortalException if a visit type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster getVisitTypeMaster(
			long visitTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.getVisitTypeMaster(
			visitTypeMasterId);
	}

	/**
	 * Returns the visit type master matching the UUID and group.
	 *
	 * @param uuid the visit type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching visit type master
	 * @throws PortalException if a matching visit type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster
			getVisitTypeMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _visitTypeMasterLocalService.getVisitTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the visit type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.VisitTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @return the range of visit type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeMaster>
		getVisitTypeMasters(int start, int end) {

		return _visitTypeMasterLocalService.getVisitTypeMasters(start, end);
	}

	/**
	 * Returns all the visit type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type masters
	 * @param companyId the primary key of the company
	 * @return the matching visit type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeMaster>
		getVisitTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _visitTypeMasterLocalService.
			getVisitTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of visit type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the visit type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of visit type masters
	 * @param end the upper bound of the range of visit type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching visit type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.VisitTypeMaster>
		getVisitTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.VisitTypeMaster> orderByComparator) {

		return _visitTypeMasterLocalService.
			getVisitTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of visit type masters.
	 *
	 * @return the number of visit type masters
	 */
	@Override
	public int getVisitTypeMastersCount() {
		return _visitTypeMasterLocalService.getVisitTypeMastersCount();
	}

	/**
	 * Updates the visit type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VisitTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param visitTypeMaster the visit type master
	 * @return the visit type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.VisitTypeMaster updateVisitTypeMaster(
		gov.omsb.tms.model.VisitTypeMaster visitTypeMaster) {

		return _visitTypeMasterLocalService.updateVisitTypeMaster(
			visitTypeMaster);
	}

	@Override
	public Boolean validateRoleTypeNames(
		java.util.List<String> visitTypeNames,
		gov.omsb.tms.model.VisitTypeMaster visitTypeMaster) {

		return _visitTypeMasterLocalService.validateRoleTypeNames(
			visitTypeNames, visitTypeMaster);
	}

	@Override
	public VisitTypeMasterLocalService getWrappedService() {
		return _visitTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		VisitTypeMasterLocalService visitTypeMasterLocalService) {

		_visitTypeMasterLocalService = visitTypeMasterLocalService;
	}

	private VisitTypeMasterLocalService _visitTypeMasterLocalService;

}