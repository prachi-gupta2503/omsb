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
 * Provides a wrapper for {@link FacultyTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyTypeLocalService
 * @generated
 */
public class FacultyTypeLocalServiceWrapper
	implements FacultyTypeLocalService,
			   ServiceWrapper<FacultyTypeLocalService> {

	public FacultyTypeLocalServiceWrapper() {
		this(null);
	}

	public FacultyTypeLocalServiceWrapper(
		FacultyTypeLocalService facultyTypeLocalService) {

		_facultyTypeLocalService = facultyTypeLocalService;
	}

	/**
	 * Adds the faculty type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyType the faculty type
	 * @return the faculty type that was added
	 */
	@Override
	public gov.omsb.tms.model.FacultyType addFacultyType(
		gov.omsb.tms.model.FacultyType facultyType) {

		return _facultyTypeLocalService.addFacultyType(facultyType);
	}

	/**
	 * Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	 *
	 * @param facultyTypeId the primary key for the new faculty type
	 * @return the new faculty type
	 */
	@Override
	public gov.omsb.tms.model.FacultyType createFacultyType(
		long facultyTypeId) {

		return _facultyTypeLocalService.createFacultyType(facultyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the faculty type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyType the faculty type
	 * @return the faculty type that was removed
	 */
	@Override
	public gov.omsb.tms.model.FacultyType deleteFacultyType(
		gov.omsb.tms.model.FacultyType facultyType) {

		return _facultyTypeLocalService.deleteFacultyType(facultyType);
	}

	/**
	 * Deletes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws PortalException if a faculty type with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyType deleteFacultyType(long facultyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyTypeLocalService.deleteFacultyType(facultyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyTypeLocalService.dynamicQuery();
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

		return _facultyTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyTypeModelImpl</code>.
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

		return _facultyTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyTypeModelImpl</code>.
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

		return _facultyTypeLocalService.dynamicQuery(
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

		return _facultyTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facultyTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyType fetchFacultyType(long facultyTypeId) {
		return _facultyTypeLocalService.fetchFacultyType(facultyTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the faculty type with the primary key.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type
	 * @throws PortalException if a faculty type with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyType getFacultyType(long facultyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyTypeLocalService.getFacultyType(facultyTypeId);
	}

	/**
	 * Returns a range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @return the range of faculty types
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyType> getFacultyTypes(
		int start, int end) {

		return _facultyTypeLocalService.getFacultyTypes(start, end);
	}

	/**
	 * Returns the number of faculty types.
	 *
	 * @return the number of faculty types
	 */
	@Override
	public int getFacultyTypesCount() {
		return _facultyTypeLocalService.getFacultyTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faculty type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyType the faculty type
	 * @return the faculty type that was updated
	 */
	@Override
	public gov.omsb.tms.model.FacultyType updateFacultyType(
		gov.omsb.tms.model.FacultyType facultyType) {

		return _facultyTypeLocalService.updateFacultyType(facultyType);
	}

	@Override
	public FacultyTypeLocalService getWrappedService() {
		return _facultyTypeLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyTypeLocalService facultyTypeLocalService) {

		_facultyTypeLocalService = facultyTypeLocalService;
	}

	private FacultyTypeLocalService _facultyTypeLocalService;

}