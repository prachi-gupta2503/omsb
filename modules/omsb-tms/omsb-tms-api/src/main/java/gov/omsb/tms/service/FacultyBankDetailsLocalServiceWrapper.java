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
 * Provides a wrapper for {@link FacultyBankDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyBankDetailsLocalService
 * @generated
 */
public class FacultyBankDetailsLocalServiceWrapper
	implements FacultyBankDetailsLocalService,
			   ServiceWrapper<FacultyBankDetailsLocalService> {

	public FacultyBankDetailsLocalServiceWrapper() {
		this(null);
	}

	public FacultyBankDetailsLocalServiceWrapper(
		FacultyBankDetailsLocalService facultyBankDetailsLocalService) {

		_facultyBankDetailsLocalService = facultyBankDetailsLocalService;
	}

	/**
	 * Adds the faculty bank details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyBankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyBankDetails the faculty bank details
	 * @return the faculty bank details that was added
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails addFacultyBankDetails(
		gov.omsb.tms.model.FacultyBankDetails facultyBankDetails) {

		return _facultyBankDetailsLocalService.addFacultyBankDetails(
			facultyBankDetails);
	}

	/**
	 * Creates a new faculty bank details with the primary key. Does not add the faculty bank details to the database.
	 *
	 * @param facultyBankDetailsId the primary key for the new faculty bank details
	 * @return the new faculty bank details
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails createFacultyBankDetails(
		long facultyBankDetailsId) {

		return _facultyBankDetailsLocalService.createFacultyBankDetails(
			facultyBankDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the faculty bank details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyBankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyBankDetails the faculty bank details
	 * @return the faculty bank details that was removed
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails deleteFacultyBankDetails(
		gov.omsb.tms.model.FacultyBankDetails facultyBankDetails) {

		return _facultyBankDetailsLocalService.deleteFacultyBankDetails(
			facultyBankDetails);
	}

	/**
	 * Deletes the faculty bank details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyBankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details that was removed
	 * @throws PortalException if a faculty bank details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails deleteFacultyBankDetails(
			long facultyBankDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.deleteFacultyBankDetails(
			facultyBankDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _facultyBankDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _facultyBankDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyBankDetailsLocalService.dynamicQuery();
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

		return _facultyBankDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyBankDetailsModelImpl</code>.
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

		return _facultyBankDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyBankDetailsModelImpl</code>.
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

		return _facultyBankDetailsLocalService.dynamicQuery(
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

		return _facultyBankDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _facultyBankDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.FacultyBankDetails fetchFacultyBankDetails(
		long facultyBankDetailsId) {

		return _facultyBankDetailsLocalService.fetchFacultyBankDetails(
			facultyBankDetailsId);
	}

	/**
	 * Returns the faculty bank details matching the UUID and group.
	 *
	 * @param uuid the faculty bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty bank details, or <code>null</code> if a matching faculty bank details could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails
		fetchFacultyBankDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _facultyBankDetailsLocalService.
			fetchFacultyBankDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.FacultyBankDetails findByFacultyRequestId(
		long facultyRequestId) {

		return _facultyBankDetailsLocalService.findByFacultyRequestId(
			facultyRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _facultyBankDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _facultyBankDetailsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the faculty bank details with the primary key.
	 *
	 * @param facultyBankDetailsId the primary key of the faculty bank details
	 * @return the faculty bank details
	 * @throws PortalException if a faculty bank details with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails getFacultyBankDetails(
			long facultyBankDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.getFacultyBankDetails(
			facultyBankDetailsId);
	}

	/**
	 * Returns the faculty bank details matching the UUID and group.
	 *
	 * @param uuid the faculty bank details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faculty bank details
	 * @throws PortalException if a matching faculty bank details could not be found
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails
			getFacultyBankDetailsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.
			getFacultyBankDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the faculty bank detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.FacultyBankDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @return the range of faculty bank detailses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyBankDetails>
		getFacultyBankDetailses(int start, int end) {

		return _facultyBankDetailsLocalService.getFacultyBankDetailses(
			start, end);
	}

	/**
	 * Returns all the faculty bank detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty bank detailses
	 * @param companyId the primary key of the company
	 * @return the matching faculty bank detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyBankDetails>
		getFacultyBankDetailsesByUuidAndCompanyId(String uuid, long companyId) {

		return _facultyBankDetailsLocalService.
			getFacultyBankDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of faculty bank detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the faculty bank detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faculty bank detailses
	 * @param end the upper bound of the range of faculty bank detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faculty bank detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.FacultyBankDetails>
		getFacultyBankDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.FacultyBankDetails> orderByComparator) {

		return _facultyBankDetailsLocalService.
			getFacultyBankDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faculty bank detailses.
	 *
	 * @return the number of faculty bank detailses
	 */
	@Override
	public int getFacultyBankDetailsesCount() {
		return _facultyBankDetailsLocalService.getFacultyBankDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _facultyBankDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyBankDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _facultyBankDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faculty bank details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FacultyBankDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param facultyBankDetails the faculty bank details
	 * @return the faculty bank details that was updated
	 */
	@Override
	public gov.omsb.tms.model.FacultyBankDetails updateFacultyBankDetails(
		gov.omsb.tms.model.FacultyBankDetails facultyBankDetails) {

		return _facultyBankDetailsLocalService.updateFacultyBankDetails(
			facultyBankDetails);
	}

	@Override
	public FacultyBankDetailsLocalService getWrappedService() {
		return _facultyBankDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyBankDetailsLocalService facultyBankDetailsLocalService) {

		_facultyBankDetailsLocalService = facultyBankDetailsLocalService;
	}

	private FacultyBankDetailsLocalService _facultyBankDetailsLocalService;

}