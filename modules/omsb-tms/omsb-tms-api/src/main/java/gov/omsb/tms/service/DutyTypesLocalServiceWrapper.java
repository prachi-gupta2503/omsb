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
 * Provides a wrapper for {@link DutyTypesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyTypesLocalService
 * @generated
 */
public class DutyTypesLocalServiceWrapper
	implements DutyTypesLocalService, ServiceWrapper<DutyTypesLocalService> {

	public DutyTypesLocalServiceWrapper() {
		this(null);
	}

	public DutyTypesLocalServiceWrapper(
		DutyTypesLocalService dutyTypesLocalService) {

		_dutyTypesLocalService = dutyTypesLocalService;
	}

	/**
	 * Adds the duty types to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyTypes the duty types
	 * @return the duty types that was added
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes addDutyTypes(
		gov.omsb.tms.model.DutyTypes dutyTypes) {

		return _dutyTypesLocalService.addDutyTypes(dutyTypes);
	}

	@Override
	public gov.omsb.tms.model.DutyTypes addDutyTypes(
			String dutyType, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.addDutyTypes(dutyType, groupId, userId);
	}

	/**
	 * Creates a new duty types with the primary key. Does not add the duty types to the database.
	 *
	 * @param dutyTypeId the primary key for the new duty types
	 * @return the new duty types
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes createDutyTypes(long dutyTypeId) {
		return _dutyTypesLocalService.createDutyTypes(dutyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public gov.omsb.tms.model.DutyTypes deleteDutyType(long dutyTypeId) {
		return _dutyTypesLocalService.deleteDutyType(dutyTypeId);
	}

	/**
	 * Deletes the duty types from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyTypes the duty types
	 * @return the duty types that was removed
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes deleteDutyTypes(
		gov.omsb.tms.model.DutyTypes dutyTypes) {

		return _dutyTypesLocalService.deleteDutyTypes(dutyTypes);
	}

	/**
	 * Deletes the duty types with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types that was removed
	 * @throws PortalException if a duty types with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes deleteDutyTypes(long dutyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.deleteDutyTypes(dutyTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dutyTypesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dutyTypesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dutyTypesLocalService.dynamicQuery();
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

		return _dutyTypesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyTypesModelImpl</code>.
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

		return _dutyTypesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyTypesModelImpl</code>.
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

		return _dutyTypesLocalService.dynamicQuery(
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

		return _dutyTypesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dutyTypesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.DutyTypes editDutyTypes(
			long dutyTypeId, long userId, String dutyType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.editDutyTypes(
			dutyTypeId, userId, dutyType);
	}

	@Override
	public gov.omsb.tms.model.DutyTypes fetchDutyTypes(long dutyTypeId) {
		return _dutyTypesLocalService.fetchDutyTypes(dutyTypeId);
	}

	/**
	 * Returns the duty types matching the UUID and group.
	 *
	 * @param uuid the duty types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty types, or <code>null</code> if a matching duty types could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes fetchDutyTypesByUuidAndGroupId(
		String uuid, long groupId) {

		return _dutyTypesLocalService.fetchDutyTypesByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public gov.omsb.tms.model.DutyTypes findByDutyTypeAndStatus(
		String dutyType, String status) {

		return _dutyTypesLocalService.findByDutyTypeAndStatus(dutyType, status);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.DutyTypeDTO>
		getAcgmeCallRule8Hour(long dutyTypeId, long traineeId, long blockId) {

		return _dutyTypesLocalService.getAcgmeCallRule8Hour(
			dutyTypeId, traineeId, blockId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dutyTypesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the duty types with the primary key.
	 *
	 * @param dutyTypeId the primary key of the duty types
	 * @return the duty types
	 * @throws PortalException if a duty types with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes getDutyTypes(long dutyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.getDutyTypes(dutyTypeId);
	}

	/**
	 * Returns the duty types matching the UUID and group.
	 *
	 * @param uuid the duty types's UUID
	 * @param groupId the primary key of the group
	 * @return the matching duty types
	 * @throws PortalException if a matching duty types could not be found
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes getDutyTypesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.getDutyTypesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the duty typeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.DutyTypesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @return the range of duty typeses
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyTypes> getDutyTypeses(
		int start, int end) {

		return _dutyTypesLocalService.getDutyTypeses(start, end);
	}

	/**
	 * Returns all the duty typeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty typeses
	 * @param companyId the primary key of the company
	 * @return the matching duty typeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyTypes>
		getDutyTypesesByUuidAndCompanyId(String uuid, long companyId) {

		return _dutyTypesLocalService.getDutyTypesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of duty typeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the duty typeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of duty typeses
	 * @param end the upper bound of the range of duty typeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching duty typeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.DutyTypes>
		getDutyTypesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.DutyTypes> orderByComparator) {

		return _dutyTypesLocalService.getDutyTypesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of duty typeses.
	 *
	 * @return the number of duty typeses
	 */
	@Override
	public int getDutyTypesesCount() {
		return _dutyTypesLocalService.getDutyTypesesCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.model.DutyTypes> getDutyTypesList() {
		return _dutyTypesLocalService.getDutyTypesList();
	}

	@Override
	public String getDutyTypesListByDutyType(String dutyType) {
		return _dutyTypesLocalService.getDutyTypesListByDutyType(dutyType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dutyTypesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dutyTypesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyTypesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dutyTypesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the duty types in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DutyTypesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dutyTypes the duty types
	 * @return the duty types that was updated
	 */
	@Override
	public gov.omsb.tms.model.DutyTypes updateDutyTypes(
		gov.omsb.tms.model.DutyTypes dutyTypes) {

		return _dutyTypesLocalService.updateDutyTypes(dutyTypes);
	}

	@Override
	public DutyTypesLocalService getWrappedService() {
		return _dutyTypesLocalService;
	}

	@Override
	public void setWrappedService(DutyTypesLocalService dutyTypesLocalService) {
		_dutyTypesLocalService = dutyTypesLocalService;
	}

	private DutyTypesLocalService _dutyTypesLocalService;

}