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
 * Provides a wrapper for {@link GenderMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GenderMasterLocalService
 * @generated
 */
public class GenderMasterLocalServiceWrapper
	implements GenderMasterLocalService,
			   ServiceWrapper<GenderMasterLocalService> {

	public GenderMasterLocalServiceWrapper() {
		this(null);
	}

	public GenderMasterLocalServiceWrapper(
		GenderMasterLocalService genderMasterLocalService) {

		_genderMasterLocalService = genderMasterLocalService;
	}

	/**
	 * Adds the gender master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param genderMaster the gender master
	 * @return the gender master that was added
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster addGenderMaster(
		gov.omsb.tms.model.GenderMaster genderMaster) {

		return _genderMasterLocalService.addGenderMaster(genderMaster);
	}

	/**
	 * Creates a new gender master with the primary key. Does not add the gender master to the database.
	 *
	 * @param genderMasterId the primary key for the new gender master
	 * @return the new gender master
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster createGenderMaster(
		long genderMasterId) {

		return _genderMasterLocalService.createGenderMaster(genderMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the gender master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param genderMaster the gender master
	 * @return the gender master that was removed
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster deleteGenderMaster(
		gov.omsb.tms.model.GenderMaster genderMaster) {

		return _genderMasterLocalService.deleteGenderMaster(genderMaster);
	}

	/**
	 * Deletes the gender master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master that was removed
	 * @throws PortalException if a gender master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster deleteGenderMaster(
			long genderMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.deleteGenderMaster(genderMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _genderMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _genderMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _genderMasterLocalService.dynamicQuery();
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

		return _genderMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.GenderMasterModelImpl</code>.
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

		return _genderMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.GenderMasterModelImpl</code>.
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

		return _genderMasterLocalService.dynamicQuery(
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

		return _genderMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _genderMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.GenderMaster fetchGenderMaster(
		long genderMasterId) {

		return _genderMasterLocalService.fetchGenderMaster(genderMasterId);
	}

	/**
	 * Returns the gender master matching the UUID and group.
	 *
	 * @param uuid the gender master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gender master, or <code>null</code> if a matching gender master could not be found
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster fetchGenderMasterByUuidAndGroupId(
		String uuid, long groupId) {

		return _genderMasterLocalService.fetchGenderMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _genderMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _genderMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the gender master with the primary key.
	 *
	 * @param genderMasterId the primary key of the gender master
	 * @return the gender master
	 * @throws PortalException if a gender master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster getGenderMaster(long genderMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.getGenderMaster(genderMasterId);
	}

	/**
	 * Returns the gender master matching the UUID and group.
	 *
	 * @param uuid the gender master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching gender master
	 * @throws PortalException if a matching gender master could not be found
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster getGenderMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.getGenderMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the gender masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.GenderMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @return the range of gender masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.GenderMaster> getGenderMasters(
		int start, int end) {

		return _genderMasterLocalService.getGenderMasters(start, end);
	}

	/**
	 * Returns all the gender masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the gender masters
	 * @param companyId the primary key of the company
	 * @return the matching gender masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.GenderMaster>
		getGenderMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _genderMasterLocalService.getGenderMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of gender masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the gender masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of gender masters
	 * @param end the upper bound of the range of gender masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching gender masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.GenderMaster>
		getGenderMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.GenderMaster> orderByComparator) {

		return _genderMasterLocalService.getGenderMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of gender masters.
	 *
	 * @return the number of gender masters
	 */
	@Override
	public int getGenderMastersCount() {
		return _genderMasterLocalService.getGenderMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _genderMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _genderMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _genderMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the gender master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GenderMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param genderMaster the gender master
	 * @return the gender master that was updated
	 */
	@Override
	public gov.omsb.tms.model.GenderMaster updateGenderMaster(
		gov.omsb.tms.model.GenderMaster genderMaster) {

		return _genderMasterLocalService.updateGenderMaster(genderMaster);
	}

	@Override
	public GenderMasterLocalService getWrappedService() {
		return _genderMasterLocalService;
	}

	@Override
	public void setWrappedService(
		GenderMasterLocalService genderMasterLocalService) {

		_genderMasterLocalService = genderMasterLocalService;
	}

	private GenderMasterLocalService _genderMasterLocalService;

}