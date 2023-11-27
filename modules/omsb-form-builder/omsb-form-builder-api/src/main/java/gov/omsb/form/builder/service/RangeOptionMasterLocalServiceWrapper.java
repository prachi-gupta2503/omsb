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

package gov.omsb.form.builder.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RangeOptionMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RangeOptionMasterLocalService
 * @generated
 */
public class RangeOptionMasterLocalServiceWrapper
	implements RangeOptionMasterLocalService,
			   ServiceWrapper<RangeOptionMasterLocalService> {

	public RangeOptionMasterLocalServiceWrapper() {
		this(null);
	}

	public RangeOptionMasterLocalServiceWrapper(
		RangeOptionMasterLocalService rangeOptionMasterLocalService) {

		_rangeOptionMasterLocalService = rangeOptionMasterLocalService;
	}

	/**
	 * Adds the range option master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RangeOptionMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rangeOptionMaster the range option master
	 * @return the range option master that was added
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster addRangeOptionMaster(
		gov.omsb.form.builder.model.RangeOptionMaster rangeOptionMaster) {

		return _rangeOptionMasterLocalService.addRangeOptionMaster(
			rangeOptionMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new range option master with the primary key. Does not add the range option master to the database.
	 *
	 * @param rangeOptionId the primary key for the new range option master
	 * @return the new range option master
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
		createRangeOptionMaster(long rangeOptionId) {

		return _rangeOptionMasterLocalService.createRangeOptionMaster(
			rangeOptionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the range option master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RangeOptionMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master that was removed
	 * @throws PortalException if a range option master with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
			deleteRangeOptionMaster(long rangeOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.deleteRangeOptionMaster(
			rangeOptionId);
	}

	/**
	 * Deletes the range option master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RangeOptionMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rangeOptionMaster the range option master
	 * @return the range option master that was removed
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
		deleteRangeOptionMaster(
			gov.omsb.form.builder.model.RangeOptionMaster rangeOptionMaster) {

		return _rangeOptionMasterLocalService.deleteRangeOptionMaster(
			rangeOptionMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rangeOptionMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rangeOptionMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rangeOptionMasterLocalService.dynamicQuery();
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

		return _rangeOptionMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.RangeOptionMasterModelImpl</code>.
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

		return _rangeOptionMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.RangeOptionMasterModelImpl</code>.
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

		return _rangeOptionMasterLocalService.dynamicQuery(
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

		return _rangeOptionMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rangeOptionMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster fetchRangeOptionMaster(
		long rangeOptionId) {

		return _rangeOptionMasterLocalService.fetchRangeOptionMaster(
			rangeOptionId);
	}

	/**
	 * Returns the range option master matching the UUID and group.
	 *
	 * @param uuid the range option master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching range option master, or <code>null</code> if a matching range option master could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
		fetchRangeOptionMasterByUuidAndGroupId(String uuid, long groupId) {

		return _rangeOptionMasterLocalService.
			fetchRangeOptionMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rangeOptionMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rangeOptionMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rangeOptionMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the range option master with the primary key.
	 *
	 * @param rangeOptionId the primary key of the range option master
	 * @return the range option master
	 * @throws PortalException if a range option master with the primary key could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster getRangeOptionMaster(
			long rangeOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.getRangeOptionMaster(
			rangeOptionId);
	}

	/**
	 * Returns the range option master matching the UUID and group.
	 *
	 * @param uuid the range option master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching range option master
	 * @throws PortalException if a matching range option master could not be found
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
			getRangeOptionMasterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rangeOptionMasterLocalService.
			getRangeOptionMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the range option masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.form.builder.model.impl.RangeOptionMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @return the range of range option masters
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.RangeOptionMaster>
		getRangeOptionMasters(int start, int end) {

		return _rangeOptionMasterLocalService.getRangeOptionMasters(start, end);
	}

	/**
	 * Returns all the range option masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the range option masters
	 * @param companyId the primary key of the company
	 * @return the matching range option masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.RangeOptionMaster>
		getRangeOptionMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _rangeOptionMasterLocalService.
			getRangeOptionMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of range option masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the range option masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of range option masters
	 * @param end the upper bound of the range of range option masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching range option masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.form.builder.model.RangeOptionMaster>
		getRangeOptionMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.form.builder.model.RangeOptionMaster>
					orderByComparator) {

		return _rangeOptionMasterLocalService.
			getRangeOptionMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of range option masters.
	 *
	 * @return the number of range option masters
	 */
	@Override
	public int getRangeOptionMastersCount() {
		return _rangeOptionMasterLocalService.getRangeOptionMastersCount();
	}

	/**
	 * Updates the range option master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RangeOptionMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rangeOptionMaster the range option master
	 * @return the range option master that was updated
	 */
	@Override
	public gov.omsb.form.builder.model.RangeOptionMaster
		updateRangeOptionMaster(
			gov.omsb.form.builder.model.RangeOptionMaster rangeOptionMaster) {

		return _rangeOptionMasterLocalService.updateRangeOptionMaster(
			rangeOptionMaster);
	}

	@Override
	public RangeOptionMasterLocalService getWrappedService() {
		return _rangeOptionMasterLocalService;
	}

	@Override
	public void setWrappedService(
		RangeOptionMasterLocalService rangeOptionMasterLocalService) {

		_rangeOptionMasterLocalService = rangeOptionMasterLocalService;
	}

	private RangeOptionMasterLocalService _rangeOptionMasterLocalService;

}