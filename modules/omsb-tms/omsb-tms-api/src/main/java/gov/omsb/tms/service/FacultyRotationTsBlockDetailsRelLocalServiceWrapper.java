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
 * Provides a wrapper for {@link FacultyRotationTsBlockDetailsRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRotationTsBlockDetailsRelLocalService
 * @generated
 */
public class FacultyRotationTsBlockDetailsRelLocalServiceWrapper
	implements FacultyRotationTsBlockDetailsRelLocalService,
			   ServiceWrapper<FacultyRotationTsBlockDetailsRelLocalService> {

	public FacultyRotationTsBlockDetailsRelLocalServiceWrapper() {
		this(null);
	}

	public FacultyRotationTsBlockDetailsRelLocalServiceWrapper(
		FacultyRotationTsBlockDetailsRelLocalService
			facultyRotationTsBlockDetailsRelLocalService) {

		_facultyRotationTsBlockDetailsRelLocalService =
			facultyRotationTsBlockDetailsRelLocalService;
	}

	/**
	 * Adds the faculty rotation ts block details rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was added
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		addFacultyRotationTsBlockDetailsRel(
			gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
				facultyRotationTsBlockDetailsRel) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			addFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRel);
	}

	/**
	 * Creates a new faculty rotation ts block details rel with the primary key. Does not add the faculty rotation ts block details rel to the database.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key for the new faculty rotation ts block details rel
	 * @return the new faculty rotation ts block details rel
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		createFacultyRotationTsBlockDetailsRel(
			long facultyRotationTsBlockDetailsRelId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			createFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.
			createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the faculty rotation ts block details rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		deleteFacultyRotationTsBlockDetailsRel(
			gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
				facultyRotationTsBlockDetailsRel) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			deleteFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRel);
	}

	@Override
	public void deleteFacultyRotationTsBlockDetailsRel(
		java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels) {

		_facultyRotationTsBlockDetailsRelLocalService.
			deleteFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRels);
	}

	/**
	 * Deletes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws PortalException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
			deleteFacultyRotationTsBlockDetailsRel(
				long facultyRotationTsBlockDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.
			deleteFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.
			deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyRotationTsBlockDetailsRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyRotationTsBlockDetailsRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQuery();
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

		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
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

		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
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

		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQuery(
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

		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQueryCount(
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

		return _facultyRotationTsBlockDetailsRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		fetchFacultyRotationTsBlockDetailsRel(
			long facultyRotationTsBlockDetailsRelId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			fetchFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the faculty rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		fetchFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			fetchFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
				uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		findByFacultyId(long facultyId) {

		return _facultyRotationTsBlockDetailsRelLocalService.findByFacultyId(
			facultyId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		findByFacultyIdAndStatus(long facultyId, String status) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			findByFacultyIdAndStatus(facultyId, status);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			findByProgDurationRotationTsRelId(progDurationRotationTsRelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws PortalException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
			getFacultyRotationTsBlockDetailsRel(
				long facultyRotationTsBlockDetailsRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel matching the UUID and group.
	 *
	 * @param uuid the faculty rotation ts block details rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty rotation ts block details rel
	 * @throws PortalException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
			getFacultyRotationTsBlockDetailsRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of faculty rotation ts block details rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRels(int start, int end) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRels(start, end);
	}

	/**
	 * Returns all the faculty rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @return the matching faculty rotation ts block details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of faculty rotation ts block details rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty rotation ts block details rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty rotation ts block details rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
		getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel>
					orderByComparator) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels.
	 *
	 * @return the number of faculty rotation ts block details rels
	 */
	@Override
	public int getFacultyRotationTsBlockDetailsRelsCount() {
		return _facultyRotationTsBlockDetailsRelLocalService.
			getFacultyRotationTsBlockDetailsRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyRotationTsBlockDetailsRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRotationTsBlockDetailsRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyRotationTsBlockDetailsRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the faculty rotation ts block details rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyRotationTsBlockDetailsRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
		updateFacultyRotationTsBlockDetailsRel(
			gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel
				facultyRotationTsBlockDetailsRel) {

		return _facultyRotationTsBlockDetailsRelLocalService.
			updateFacultyRotationTsBlockDetailsRel(
				facultyRotationTsBlockDetailsRel);
	}

	@Override
	public FacultyRotationTsBlockDetailsRelLocalService getWrappedService() {
		return _facultyRotationTsBlockDetailsRelLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyRotationTsBlockDetailsRelLocalService
			facultyRotationTsBlockDetailsRelLocalService) {

		_facultyRotationTsBlockDetailsRelLocalService =
			facultyRotationTsBlockDetailsRelLocalService;
	}

	private FacultyRotationTsBlockDetailsRelLocalService
		_facultyRotationTsBlockDetailsRelLocalService;

}