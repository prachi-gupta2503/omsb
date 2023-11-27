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
 * Provides a wrapper for {@link RotationMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RotationMasterLocalService
 * @generated
 */
public class RotationMasterLocalServiceWrapper
	implements RotationMasterLocalService,
			   ServiceWrapper<RotationMasterLocalService> {

	public RotationMasterLocalServiceWrapper() {
		this(null);
	}

	public RotationMasterLocalServiceWrapper(
		RotationMasterLocalService rotationMasterLocalService) {

		_rotationMasterLocalService = rotationMasterLocalService;
	}

	/**
	 * Adds the rotation master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was added
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster addRotationMaster(
		gov.omsb.tms.model.RotationMaster rotationMaster) {

		return _rotationMasterLocalService.addRotationMaster(rotationMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new rotation master with the primary key. Does not add the rotation master to the database.
	 *
	 * @param rotationMasterId the primary key for the new rotation master
	 * @return the new rotation master
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster createRotationMaster(
		long rotationMasterId) {

		return _rotationMasterLocalService.createRotationMaster(
			rotationMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rotation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master that was removed
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster deleteRotationMaster(
			long rotationMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.deleteRotationMaster(
			rotationMasterId);
	}

	/**
	 * Deletes the rotation master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was removed
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster deleteRotationMaster(
		gov.omsb.tms.model.RotationMaster rotationMaster) {

		return _rotationMasterLocalService.deleteRotationMaster(rotationMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rotationMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rotationMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rotationMasterLocalService.dynamicQuery();
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

		return _rotationMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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

		return _rotationMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
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

		return _rotationMasterLocalService.dynamicQuery(
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

		return _rotationMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rotationMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RotationMaster fetchRotationMaster(
		long rotationMasterId) {

		return _rotationMasterLocalService.fetchRotationMaster(
			rotationMasterId);
	}

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master, or <code>null</code> if a matching rotation master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster
		fetchRotationMasterByUuidAndGroupId(String uuid, long groupId) {

		return _rotationMasterLocalService.fetchRotationMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		findByRotationCodeByLike(String rotationCode) {

		return _rotationMasterLocalService.findByRotationCodeByLike(
			rotationCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		findByRotationNameByLike(String rotationName) {

		return _rotationMasterLocalService.findByRotationNameByLike(
			rotationName);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		findByRotationStatus(Boolean rotationStatus) {

		return _rotationMasterLocalService.findByRotationStatus(rotationStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rotationMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _rotationMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rotationMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rotationMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		getRotationListByIdsAndStatus(
			java.util.List<Long> ids, Boolean status) {

		return _rotationMasterLocalService.getRotationListByIdsAndStatus(
			ids, status);
	}

	/**
	 * Returns the rotation master with the primary key.
	 *
	 * @param rotationMasterId the primary key of the rotation master
	 * @return the rotation master
	 * @throws PortalException if a rotation master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster getRotationMaster(
			long rotationMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.getRotationMaster(rotationMasterId);
	}

	/**
	 * Returns the rotation master matching the UUID and group.
	 *
	 * @param uuid the rotation master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching rotation master
	 * @throws PortalException if a matching rotation master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster getRotationMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rotationMasterLocalService.getRotationMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the rotation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RotationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @return the range of rotation masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster> getRotationMasters(
		int start, int end) {

		return _rotationMasterLocalService.getRotationMasters(start, end);
	}

	/**
	 * Returns all the rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @return the matching rotation masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		getRotationMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _rotationMasterLocalService.getRotationMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of rotation masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the rotation masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of rotation masters
	 * @param end the upper bound of the range of rotation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching rotation masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RotationMaster>
		getRotationMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.RotationMaster> orderByComparator) {

		return _rotationMasterLocalService.getRotationMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rotation masters.
	 *
	 * @return the number of rotation masters
	 */
	@Override
	public int getRotationMastersCount() {
		return _rotationMasterLocalService.getRotationMastersCount();
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelId(long traineeLevelId, String languageCode) {

		return _rotationMasterLocalService.getRotationsByTraineeLevelId(
			traineeLevelId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelIdAndProgramDurationId(
			long traineeLevelId, long programDurationId, String languageCode) {

		return _rotationMasterLocalService.
			getRotationsByTraineeLevelIdAndProgramDurationId(
				traineeLevelId, programDurationId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationDTO>
		getRotationsByTrainingSiteAndCohort(
			long trainingSiteId, long programDurationId, String languageCode) {

		return _rotationMasterLocalService.getRotationsByTrainingSiteAndCohort(
			trainingSiteId, programDurationId, languageCode);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.RotationStructureDTO>
		getRotationStructure(long rotationId, String languageCode) {

		return _rotationMasterLocalService.getRotationStructure(
			rotationId, languageCode);
	}

	/**
	 * Updates the rotation master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RotationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rotationMaster the rotation master
	 * @return the rotation master that was updated
	 */
	@Override
	public gov.omsb.tms.model.RotationMaster updateRotationMaster(
		gov.omsb.tms.model.RotationMaster rotationMaster) {

		return _rotationMasterLocalService.updateRotationMaster(rotationMaster);
	}

	@Override
	public RotationMasterLocalService getWrappedService() {
		return _rotationMasterLocalService;
	}

	@Override
	public void setWrappedService(
		RotationMasterLocalService rotationMasterLocalService) {

		_rotationMasterLocalService = rotationMasterLocalService;
	}

	private RotationMasterLocalService _rotationMasterLocalService;

}