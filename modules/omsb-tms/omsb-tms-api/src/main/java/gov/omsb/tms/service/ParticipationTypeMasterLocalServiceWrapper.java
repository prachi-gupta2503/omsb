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
 * Provides a wrapper for {@link ParticipationTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ParticipationTypeMasterLocalService
 * @generated
 */
public class ParticipationTypeMasterLocalServiceWrapper
	implements ParticipationTypeMasterLocalService,
			   ServiceWrapper<ParticipationTypeMasterLocalService> {

	public ParticipationTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public ParticipationTypeMasterLocalServiceWrapper(
		ParticipationTypeMasterLocalService
			participationTypeMasterLocalService) {

		_participationTypeMasterLocalService =
			participationTypeMasterLocalService;
	}

	/**
	 * Adds the participation type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was added
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		addParticipationTypeMaster(
			gov.omsb.tms.model.ParticipationTypeMaster
				participationTypeMaster) {

		return _participationTypeMasterLocalService.addParticipationTypeMaster(
			participationTypeMaster);
	}

	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		addUpdateParticipationTypeMaster(
			gov.omsb.tms.model.ParticipationTypeMaster participationTypeMaster,
			java.util.List<String> participationTypeNames, boolean isCreate) {

		return _participationTypeMasterLocalService.
			addUpdateParticipationTypeMaster(
				participationTypeMaster, participationTypeNames, isCreate);
	}

	/**
	 * Creates a new participation type master with the primary key. Does not add the participation type master to the database.
	 *
	 * @param participationTypeMasterId the primary key for the new participation type master
	 * @return the new participation type master
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		createParticipationTypeMaster(long participationTypeMasterId) {

		return _participationTypeMasterLocalService.
			createParticipationTypeMaster(participationTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the participation type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master that was removed
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
			deleteParticipationTypeMaster(long participationTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.
			deleteParticipationTypeMaster(participationTypeMasterId);
	}

	/**
	 * Deletes the participation type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		deleteParticipationTypeMaster(
			gov.omsb.tms.model.ParticipationTypeMaster
				participationTypeMaster) {

		return _participationTypeMasterLocalService.
			deleteParticipationTypeMaster(participationTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _participationTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _participationTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _participationTypeMasterLocalService.dynamicQuery();
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

		return _participationTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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

		return _participationTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
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

		return _participationTypeMasterLocalService.dynamicQuery(
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

		return _participationTypeMasterLocalService.dynamicQueryCount(
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

		return _participationTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		fetchParticipationTypeMaster(long participationTypeMasterId) {

		return _participationTypeMasterLocalService.
			fetchParticipationTypeMaster(participationTypeMasterId);
	}

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master, or <code>null</code> if a matching participation type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		fetchParticipationTypeMasterByUuidAndGroupId(
			String uuid, long groupId) {

		return _participationTypeMasterLocalService.
			fetchParticipationTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ParticipationTypeMaster>
		findByParticipationTypeNameByLikeAndProgramDurationId(
			String participationTypeName, long programDurationId) {

		return _participationTypeMasterLocalService.
			findByParticipationTypeNameByLikeAndProgramDurationId(
				participationTypeName, programDurationId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.ParticipationTypeMaster>
		findByProgramDurationId(long programDurationId) {

		return _participationTypeMasterLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _participationTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _participationTypeMasterLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _participationTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _participationTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the participation type master with the primary key.
	 *
	 * @param participationTypeMasterId the primary key of the participation type master
	 * @return the participation type master
	 * @throws PortalException if a participation type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
			getParticipationTypeMaster(long participationTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.getParticipationTypeMaster(
			participationTypeMasterId);
	}

	/**
	 * Returns the participation type master matching the UUID and group.
	 *
	 * @param uuid the participation type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation type master
	 * @throws PortalException if a matching participation type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
			getParticipationTypeMasterByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.
			getParticipationTypeMasterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the participation type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.ParticipationTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @return the range of participation type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ParticipationTypeMaster>
		getParticipationTypeMasters(int start, int end) {

		return _participationTypeMasterLocalService.getParticipationTypeMasters(
			start, end);
	}

	/**
	 * Returns all the participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @return the matching participation type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId) {

		return _participationTypeMasterLocalService.
			getParticipationTypeMastersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of participation type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the participation type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of participation type masters
	 * @param end the upper bound of the range of participation type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching participation type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.ParticipationTypeMaster>
		getParticipationTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.ParticipationTypeMaster>
					orderByComparator) {

		return _participationTypeMasterLocalService.
			getParticipationTypeMastersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of participation type masters.
	 *
	 * @return the number of participation type masters
	 */
	@Override
	public int getParticipationTypeMastersCount() {
		return _participationTypeMasterLocalService.
			getParticipationTypeMastersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participationTypeMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the participation type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationTypeMaster the participation type master
	 * @return the participation type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.ParticipationTypeMaster
		updateParticipationTypeMaster(
			gov.omsb.tms.model.ParticipationTypeMaster
				participationTypeMaster) {

		return _participationTypeMasterLocalService.
			updateParticipationTypeMaster(participationTypeMaster);
	}

	@Override
	public Boolean validateParticipationTypeNames(
		java.util.List<String> participationTypeNames, long programDurationId,
		gov.omsb.tms.model.ParticipationTypeMaster participationTypeMaster) {

		return _participationTypeMasterLocalService.
			validateParticipationTypeNames(
				participationTypeNames, programDurationId,
				participationTypeMaster);
	}

	@Override
	public ParticipationTypeMasterLocalService getWrappedService() {
		return _participationTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ParticipationTypeMasterLocalService
			participationTypeMasterLocalService) {

		_participationTypeMasterLocalService =
			participationTypeMasterLocalService;
	}

	private ParticipationTypeMasterLocalService
		_participationTypeMasterLocalService;

}