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
 * Provides a wrapper for {@link CptCodeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMasterLocalService
 * @generated
 */
public class CptCodeMasterLocalServiceWrapper
	implements CptCodeMasterLocalService,
			   ServiceWrapper<CptCodeMasterLocalService> {

	public CptCodeMasterLocalServiceWrapper() {
		this(null);
	}

	public CptCodeMasterLocalServiceWrapper(
		CptCodeMasterLocalService cptCodeMasterLocalService) {

		_cptCodeMasterLocalService = cptCodeMasterLocalService;
	}

	/**
	 * Adds the cpt code master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was added
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster addCptCodeMaster(
		gov.omsb.tms.model.CptCodeMaster cptCodeMaster) {

		return _cptCodeMasterLocalService.addCptCodeMaster(cptCodeMaster);
	}

	/**
	 * Creates a new cpt code master with the primary key. Does not add the cpt code master to the database.
	 *
	 * @param cptCodeMasterId the primary key for the new cpt code master
	 * @return the new cpt code master
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster createCptCodeMaster(
		long cptCodeMasterId) {

		return _cptCodeMasterLocalService.createCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cpt code master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was removed
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster deleteCptCodeMaster(
		gov.omsb.tms.model.CptCodeMaster cptCodeMaster) {

		return _cptCodeMasterLocalService.deleteCptCodeMaster(cptCodeMaster);
	}

	/**
	 * Deletes the cpt code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master that was removed
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster deleteCptCodeMaster(
			long cptCodeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.deleteCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cptCodeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cptCodeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cptCodeMasterLocalService.dynamicQuery();
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

		return _cptCodeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
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

		return _cptCodeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
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

		return _cptCodeMasterLocalService.dynamicQuery(
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

		return _cptCodeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cptCodeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.CptCodeMaster fetchCptCodeMaster(
		long cptCodeMasterId) {

		return _cptCodeMasterLocalService.fetchCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master, or <code>null</code> if a matching cpt code master could not be found
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster fetchCptCodeMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return _cptCodeMasterLocalService.fetchCptCodeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.CptCodeMaster>
		findByCptCodeNameByLike(String cptCodeName) {

		return _cptCodeMasterLocalService.findByCptCodeNameByLike(cptCodeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cptCodeMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cpt code master with the primary key.
	 *
	 * @param cptCodeMasterId the primary key of the cpt code master
	 * @return the cpt code master
	 * @throws PortalException if a cpt code master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster getCptCodeMaster(
			long cptCodeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.getCptCodeMaster(cptCodeMasterId);
	}

	/**
	 * Returns the cpt code master matching the UUID and group.
	 *
	 * @param uuid the cpt code master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cpt code master
	 * @throws PortalException if a matching cpt code master could not be found
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster getCptCodeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.getCptCodeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the cpt code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.CptCodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @return the range of cpt code masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CptCodeMaster> getCptCodeMasters(
		int start, int end) {

		return _cptCodeMasterLocalService.getCptCodeMasters(start, end);
	}

	/**
	 * Returns all the cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @return the matching cpt code masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CptCodeMaster>
		getCptCodeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _cptCodeMasterLocalService.getCptCodeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cpt code masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the cpt code masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cpt code masters
	 * @param end the upper bound of the range of cpt code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cpt code masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.CptCodeMaster>
		getCptCodeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.CptCodeMaster> orderByComparator) {

		return _cptCodeMasterLocalService.getCptCodeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cpt code masters.
	 *
	 * @return the number of cpt code masters
	 */
	@Override
	public int getCptCodeMastersCount() {
		return _cptCodeMasterLocalService.getCptCodeMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cptCodeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cptCodeMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cptCodeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cptCodeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cpt code master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CptCodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cptCodeMaster the cpt code master
	 * @return the cpt code master that was updated
	 */
	@Override
	public gov.omsb.tms.model.CptCodeMaster updateCptCodeMaster(
		gov.omsb.tms.model.CptCodeMaster cptCodeMaster) {

		return _cptCodeMasterLocalService.updateCptCodeMaster(cptCodeMaster);
	}

	@Override
	public CptCodeMasterLocalService getWrappedService() {
		return _cptCodeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CptCodeMasterLocalService cptCodeMasterLocalService) {

		_cptCodeMasterLocalService = cptCodeMasterLocalService;
	}

	private CptCodeMasterLocalService _cptCodeMasterLocalService;

}