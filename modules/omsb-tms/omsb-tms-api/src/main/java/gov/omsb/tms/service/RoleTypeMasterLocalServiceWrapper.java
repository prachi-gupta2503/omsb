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
 * Provides a wrapper for {@link RoleTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMasterLocalService
 * @generated
 */
public class RoleTypeMasterLocalServiceWrapper
	implements RoleTypeMasterLocalService,
			   ServiceWrapper<RoleTypeMasterLocalService> {

	public RoleTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public RoleTypeMasterLocalServiceWrapper(
		RoleTypeMasterLocalService roleTypeMasterLocalService) {

		_roleTypeMasterLocalService = roleTypeMasterLocalService;
	}

	/**
	 * Adds the role type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was added
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster addRoleTypeMaster(
		gov.omsb.tms.model.RoleTypeMaster roleTypeMaster) {

		return _roleTypeMasterLocalService.addRoleTypeMaster(roleTypeMaster);
	}

	@Override
	public gov.omsb.tms.model.RoleTypeMaster addUpdateRoleTypeMaster(
		gov.omsb.tms.model.RoleTypeMaster roleTypeMaster,
		java.util.List<String> roleTypeNames, boolean isCreate) {

		return _roleTypeMasterLocalService.addUpdateRoleTypeMaster(
			roleTypeMaster, roleTypeNames, isCreate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role type master with the primary key. Does not add the role type master to the database.
	 *
	 * @param roleTypeMasterId the primary key for the new role type master
	 * @return the new role type master
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster createRoleTypeMaster(
		long roleTypeMasterId) {

		return _roleTypeMasterLocalService.createRoleTypeMaster(
			roleTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the role type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master that was removed
	 * @throws PortalException if a role type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster deleteRoleTypeMaster(
			long roleTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.deleteRoleTypeMaster(
			roleTypeMasterId);
	}

	/**
	 * Deletes the role type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was removed
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster deleteRoleTypeMaster(
		gov.omsb.tms.model.RoleTypeMaster roleTypeMaster) {

		return _roleTypeMasterLocalService.deleteRoleTypeMaster(roleTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _roleTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _roleTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roleTypeMasterLocalService.dynamicQuery();
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

		return _roleTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
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

		return _roleTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
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

		return _roleTypeMasterLocalService.dynamicQuery(
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

		return _roleTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _roleTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RoleTypeMaster fetchRoleTypeMaster(
		long roleTypeMasterId) {

		return _roleTypeMasterLocalService.fetchRoleTypeMaster(
			roleTypeMasterId);
	}

	/**
	 * Returns the role type master matching the UUID and group.
	 *
	 * @param uuid the role type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type master, or <code>null</code> if a matching role type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster
		fetchRoleTypeMasterByUuidAndGroupId(String uuid, long groupId) {

		return _roleTypeMasterLocalService.fetchRoleTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeMaster>
		findByRoleTypeNameByLike(String roleTypeName) {

		return _roleTypeMasterLocalService.findByRoleTypeNameByLike(
			roleTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roleTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _roleTypeMasterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roleTypeMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role type master with the primary key.
	 *
	 * @param roleTypeMasterId the primary key of the role type master
	 * @return the role type master
	 * @throws PortalException if a role type master with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster getRoleTypeMaster(
			long roleTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.getRoleTypeMaster(roleTypeMasterId);
	}

	/**
	 * Returns the role type master matching the UUID and group.
	 *
	 * @param uuid the role type master's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type master
	 * @throws PortalException if a matching role type master could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster getRoleTypeMasterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeMasterLocalService.getRoleTypeMasterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the role type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @return the range of role type masters
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeMaster> getRoleTypeMasters(
		int start, int end) {

		return _roleTypeMasterLocalService.getRoleTypeMasters(start, end);
	}

	/**
	 * Returns all the role type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type masters
	 * @param companyId the primary key of the company
	 * @return the matching role type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeMaster>
		getRoleTypeMastersByUuidAndCompanyId(String uuid, long companyId) {

		return _roleTypeMasterLocalService.getRoleTypeMastersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of role type masters matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type masters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role type masters
	 * @param end the upper bound of the range of role type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role type masters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeMaster>
		getRoleTypeMastersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.RoleTypeMaster> orderByComparator) {

		return _roleTypeMasterLocalService.getRoleTypeMastersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role type masters.
	 *
	 * @return the number of role type masters
	 */
	@Override
	public int getRoleTypeMastersCount() {
		return _roleTypeMasterLocalService.getRoleTypeMastersCount();
	}

	/**
	 * Updates the role type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeMaster the role type master
	 * @return the role type master that was updated
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeMaster updateRoleTypeMaster(
		gov.omsb.tms.model.RoleTypeMaster roleTypeMaster) {

		return _roleTypeMasterLocalService.updateRoleTypeMaster(roleTypeMaster);
	}

	@Override
	public Boolean validateRoleTypeNames(
		java.util.List<String> roleTypeNames,
		gov.omsb.tms.model.RoleTypeMaster roleTypeMaster) {

		return _roleTypeMasterLocalService.validateRoleTypeNames(
			roleTypeNames, roleTypeMaster);
	}

	@Override
	public RoleTypeMasterLocalService getWrappedService() {
		return _roleTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		RoleTypeMasterLocalService roleTypeMasterLocalService) {

		_roleTypeMasterLocalService = roleTypeMasterLocalService;
	}

	private RoleTypeMasterLocalService _roleTypeMasterLocalService;

}