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
 * Provides a wrapper for {@link RoleTypeProgDurationRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelLocalService
 * @generated
 */
public class RoleTypeProgDurationRelLocalServiceWrapper
	implements RoleTypeProgDurationRelLocalService,
			   ServiceWrapper<RoleTypeProgDurationRelLocalService> {

	public RoleTypeProgDurationRelLocalServiceWrapper() {
		this(null);
	}

	public RoleTypeProgDurationRelLocalServiceWrapper(
		RoleTypeProgDurationRelLocalService
			roleTypeProgDurationRelLocalService) {

		_roleTypeProgDurationRelLocalService =
			roleTypeProgDurationRelLocalService;
	}

	/**
	 * Adds the role type prog duration rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was added
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		addRoleTypeProgDurationRel(
			gov.omsb.tms.model.RoleTypeProgDurationRel
				roleTypeProgDurationRel) {

		return _roleTypeProgDurationRelLocalService.addRoleTypeProgDurationRel(
			roleTypeProgDurationRel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new role type prog duration rel with the primary key. Does not add the role type prog duration rel to the database.
	 *
	 * @param RoleTypeProgDurationRelId the primary key for the new role type prog duration rel
	 * @return the new role type prog duration rel
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		createRoleTypeProgDurationRel(long RoleTypeProgDurationRelId) {

		return _roleTypeProgDurationRelLocalService.
			createRoleTypeProgDurationRel(RoleTypeProgDurationRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the role type prog duration rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 * @throws PortalException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
			deleteRoleTypeProgDurationRel(long RoleTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.
			deleteRoleTypeProgDurationRel(RoleTypeProgDurationRelId);
	}

	/**
	 * Deletes the role type prog duration rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was removed
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		deleteRoleTypeProgDurationRel(
			gov.omsb.tms.model.RoleTypeProgDurationRel
				roleTypeProgDurationRel) {

		return _roleTypeProgDurationRelLocalService.
			deleteRoleTypeProgDurationRel(roleTypeProgDurationRel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _roleTypeProgDurationRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _roleTypeProgDurationRelLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roleTypeProgDurationRelLocalService.dynamicQuery();
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

		return _roleTypeProgDurationRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
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

		return _roleTypeProgDurationRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
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

		return _roleTypeProgDurationRelLocalService.dynamicQuery(
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

		return _roleTypeProgDurationRelLocalService.dynamicQueryCount(
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

		return _roleTypeProgDurationRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		fetchRoleTypeProgDurationRel(long RoleTypeProgDurationRelId) {

		return _roleTypeProgDurationRelLocalService.
			fetchRoleTypeProgDurationRel(RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the role type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type prog duration rel, or <code>null</code> if a matching role type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		fetchRoleTypeProgDurationRelByUuidAndGroupId(
			String uuid, long groupId) {

		return _roleTypeProgDurationRelLocalService.
			fetchRoleTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeProgDurationRel>
		findByProgramDurationId(long programDurationId) {

		return _roleTypeProgDurationRelLocalService.findByProgramDurationId(
			programDurationId);
	}

	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		findByProgramDurationIdAndRoleTypeMasterId(
			long programDurationId, long roleTypeMasterId) {

		return _roleTypeProgDurationRelLocalService.
			findByProgramDurationIdAndRoleTypeMasterId(
				programDurationId, roleTypeMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roleTypeProgDurationRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _roleTypeProgDurationRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roleTypeProgDurationRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTypeProgDurationRelLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<Long, String> getOtherRoleTypesFromRoleMaster(
		long programDurationId, String type, String languageCode) {

		return _roleTypeProgDurationRelLocalService.
			getOtherRoleTypesFromRoleMaster(
				programDurationId, type, languageCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the role type prog duration rel with the primary key.
	 *
	 * @param RoleTypeProgDurationRelId the primary key of the role type prog duration rel
	 * @return the role type prog duration rel
	 * @throws PortalException if a role type prog duration rel with the primary key could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
			getRoleTypeProgDurationRel(long RoleTypeProgDurationRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.getRoleTypeProgDurationRel(
			RoleTypeProgDurationRelId);
	}

	/**
	 * Returns the role type prog duration rel matching the UUID and group.
	 *
	 * @param uuid the role type prog duration rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role type prog duration rel
	 * @throws PortalException if a matching role type prog duration rel could not be found
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
			getRoleTypeProgDurationRelByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTypeProgDurationRelLocalService.
			getRoleTypeProgDurationRelByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the role type prog duration rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>gov.omsb.tms.model.impl.RoleTypeProgDurationRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @return the range of role type prog duration rels
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeProgDurationRel>
		getRoleTypeProgDurationRels(int start, int end) {

		return _roleTypeProgDurationRelLocalService.getRoleTypeProgDurationRels(
			start, end);
	}

	/**
	 * Returns all the role type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type prog duration rels
	 * @param companyId the primary key of the company
	 * @return the matching role type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeProgDurationRel>
		getRoleTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _roleTypeProgDurationRelLocalService.
			getRoleTypeProgDurationRelsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of role type prog duration rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the role type prog duration rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role type prog duration rels
	 * @param end the upper bound of the range of role type prog duration rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role type prog duration rels, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<gov.omsb.tms.model.RoleTypeProgDurationRel>
		getRoleTypeProgDurationRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<gov.omsb.tms.model.RoleTypeProgDurationRel>
					orderByComparator) {

		return _roleTypeProgDurationRelLocalService.
			getRoleTypeProgDurationRelsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role type prog duration rels.
	 *
	 * @return the number of role type prog duration rels
	 */
	@Override
	public int getRoleTypeProgDurationRelsCount() {
		return _roleTypeProgDurationRelLocalService.
			getRoleTypeProgDurationRelsCount();
	}

	/**
	 * Updates the role type prog duration rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTypeProgDurationRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTypeProgDurationRel the role type prog duration rel
	 * @return the role type prog duration rel that was updated
	 */
	@Override
	public gov.omsb.tms.model.RoleTypeProgDurationRel
		updateRoleTypeProgDurationRel(
			gov.omsb.tms.model.RoleTypeProgDurationRel
				roleTypeProgDurationRel) {

		return _roleTypeProgDurationRelLocalService.
			updateRoleTypeProgDurationRel(roleTypeProgDurationRel);
	}

	@Override
	public RoleTypeProgDurationRelLocalService getWrappedService() {
		return _roleTypeProgDurationRelLocalService;
	}

	@Override
	public void setWrappedService(
		RoleTypeProgDurationRelLocalService
			roleTypeProgDurationRelLocalService) {

		_roleTypeProgDurationRelLocalService =
			roleTypeProgDurationRelLocalService;
	}

	private RoleTypeProgDurationRelLocalService
		_roleTypeProgDurationRelLocalService;

}